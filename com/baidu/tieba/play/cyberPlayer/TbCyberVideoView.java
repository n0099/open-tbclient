package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.k.i;
import com.baidu.tieba.k.l;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.d;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements com.baidu.tieba.play.a.a {
    private static l efa;
    private WeakReference<Context> Pf;
    private String Pj;
    private final CustomMessageListener dVq;
    private i juJ;
    private d juN;
    private boolean jve;
    private boolean jwP;
    private boolean jwQ;
    private a jwR;
    private boolean jwS;
    private boolean jwT;
    private boolean jwU;
    private int jwV;
    private g.f jwW;
    private g.a jwX;
    private g.InterfaceC0590g jwY;
    private g.b jwZ;
    private g.e jxa;
    private QuickVideoView.b jxb;
    private CyberPlayerManager.OnPreparedListener jxc;
    private CyberPlayerManager.OnCompletionListener jxd;
    private CyberPlayerManager.OnErrorListener jxe;
    private CyberPlayerManager.OnSeekCompleteListener jxf;
    private CyberPlayerManager.OnInfoListener jxg;
    private String mOriginUrl;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            efa = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.Pf = null;
        this.jwS = false;
        this.jwT = false;
        this.jwU = false;
        this.jve = false;
        this.jxc = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Hd;
                TbCyberVideoView.this.jwT = false;
                if (TbCyberVideoView.this.jwR != null) {
                    TbCyberVideoView.this.jwR.ey(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yh(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czv().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jwW != null) {
                        TbCyberVideoView.this.jwW.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jwP && (Hd = x.czs().Hd(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(Hd);
                    }
                    if (TbCyberVideoView.this.jwQ) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jxd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.juJ != null) {
                    TbCyberVideoView.this.juJ.Fe(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.juJ = null;
                }
                x.czs().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jwR != null) {
                        TbCyberVideoView.this.jwR.onComplete();
                    }
                    TbCyberVideoView.this.jwQ = false;
                    if (TbCyberVideoView.this.jwX != null) {
                        TbCyberVideoView.this.jwX.onCompletion(null);
                    }
                }
            }
        };
        this.jxe = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.juN != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cyQ()) {
                    x.czs().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czv().Hf(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwZ == null || !TbCyberVideoView.this.jwZ.onError(null, i, i2)) {
                    TbCyberVideoView.this.jwU = false;
                    TbCyberVideoView.this.jwT = false;
                }
                return true;
            }
        };
        this.jxf = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jwU = false;
                if (TbCyberVideoView.this.jwY != null) {
                    TbCyberVideoView.this.jwY.b(null);
                }
            }
        };
        this.jxg = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jxa != null) {
                    TbCyberVideoView.this.jxa.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jwU && !TbCyberVideoView.this.jwT && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cgH();
                    TbCyberVideoView.this.getVideoMonitor().cgI();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jwR.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.juJ != null) {
                        TbCyberVideoView.this.juJ.Fd(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.juJ = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.Pf = null;
        this.jwS = false;
        this.jwT = false;
        this.jwU = false;
        this.jve = false;
        this.jxc = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Hd;
                TbCyberVideoView.this.jwT = false;
                if (TbCyberVideoView.this.jwR != null) {
                    TbCyberVideoView.this.jwR.ey(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yh(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czv().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jwW != null) {
                        TbCyberVideoView.this.jwW.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jwP && (Hd = x.czs().Hd(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(Hd);
                    }
                    if (TbCyberVideoView.this.jwQ) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jxd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.juJ != null) {
                    TbCyberVideoView.this.juJ.Fe(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.juJ = null;
                }
                x.czs().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jwR != null) {
                        TbCyberVideoView.this.jwR.onComplete();
                    }
                    TbCyberVideoView.this.jwQ = false;
                    if (TbCyberVideoView.this.jwX != null) {
                        TbCyberVideoView.this.jwX.onCompletion(null);
                    }
                }
            }
        };
        this.jxe = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.juN != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cyQ()) {
                    x.czs().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czv().Hf(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwZ == null || !TbCyberVideoView.this.jwZ.onError(null, i, i2)) {
                    TbCyberVideoView.this.jwU = false;
                    TbCyberVideoView.this.jwT = false;
                }
                return true;
            }
        };
        this.jxf = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jwU = false;
                if (TbCyberVideoView.this.jwY != null) {
                    TbCyberVideoView.this.jwY.b(null);
                }
            }
        };
        this.jxg = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jxa != null) {
                    TbCyberVideoView.this.jxa.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jwU && !TbCyberVideoView.this.jwT && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cgH();
                    TbCyberVideoView.this.getVideoMonitor().cgI();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jwR.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.juJ != null) {
                        TbCyberVideoView.this.juJ.Fd(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.juJ = null;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
        setOnPreparedListener(this.jxc);
        setOnCompletionListener(this.jxd);
        setOnErrorListener(this.jxe);
        setOnSeekCompleteListener(this.jxf);
        setOnInfoListener(this.jxg);
        this.jwR = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.jwS = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.Pf, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.jwS = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.juN = dVar;
        if ((this.juN instanceof n) && ((n) this.juN).czc() != null) {
            this.jwR.h((n) this.juN);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.jwW = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.jwX = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.jwZ = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0590g interfaceC0590g) {
        this.jwY = interfaceC0590g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jxa = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.jxb = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jwP = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.jwV = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.Pj = str2;
            this.mOriginUrl = str;
            String GZ = GZ(str);
            if (efa != null) {
                this.juJ = efa.ap(this.Pj, this.mOriginUrl, null);
                if (this.juJ != null) {
                    this.juJ.oQ(CyberPlayerManager.hasCacheFile(GZ));
                }
            }
            if (this.juN != null && this.juN.cyE() != null) {
                this.juN.cyE().setPlayer(this);
            }
            this.jwR.czu();
            String host = Uri.parse(this.mOriginUrl).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.jwV < 900)) ? "1" : "0");
            setVideoPath(GZ);
            if (this.juJ != null) {
                this.juJ.cgE();
            }
            this.jwT = true;
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.jve = true;
            if (!cyT()) {
                aVar.czw();
            }
            if (!cyS()) {
                aVar.czx();
                this.jwQ = true;
                setVideoPath(this.mOriginUrl, this.Pj);
                return;
            }
        } else {
            this.jve = false;
        }
        start();
        if (this.jve) {
            this.jwR.a(this);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.jwS) {
            af.a(this.Pf, true);
            setVolume(1.0f, 1.0f);
        }
        this.jwQ = true;
        super.start();
        if (this.jwR != null) {
            this.jwR.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().yj(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jwQ) {
            b(aVar);
            return;
        }
        this.jwQ = true;
        if (aVar != null) {
            this.jve = true;
            if (!cyT()) {
                aVar.czw();
            }
        } else {
            this.jve = false;
        }
        setVideoPath(this.mOriginUrl, this.Pj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.Pf, false);
        if (isPlaying() && cyQ()) {
            x.czs().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        super.pause();
        if (this.jwR != null) {
            this.jwR.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juJ != null) {
            this.juJ.cgJ();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jve) {
            stopPlayback();
            return;
        }
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        this.jwQ = false;
        if (isPlaying() && cyQ()) {
            x.czs().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.jwR != null) {
            this.jwR.onStop();
        }
        if (this.juJ != null && this.juJ.Ff(getLocateSource())) {
            this.juJ = null;
        }
        this.jwT = false;
        this.jwU = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        this.jwQ = false;
        if (isPlaying() && cyQ()) {
            x.czs().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.czv().Hf(this.mOriginUrl);
        if (this.jwR != null) {
            this.jwR.onStop();
        }
        if (this.juJ != null && this.juJ.Ff(getLocateSource())) {
            this.juJ = null;
        }
        this.jwT = false;
        this.jwU = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jxb != null) {
            this.jxb.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.dVq);
    }

    private String GZ(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPh().cPi()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
                return str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
            }
            return str;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cyO() {
        return this.jwQ;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.juJ != null) {
            this.juJ.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyQ() {
        return getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.juN instanceof n) || ((n) this.juN).czc() == null) {
            return "";
        }
        return ((n) this.juN).jvI ? "v_mid_page" : ((n) this.juN).czc().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.juJ != null) {
            return this.juJ;
        }
        if (!StringUtils.isNull(this.mOriginUrl) && efa != null) {
            this.juJ = efa.ap(this.Pj, this.mOriginUrl, null);
        }
        return this.juJ;
    }

    private boolean cyS() {
        return this == TbVideoViewSet.czv().He(this.mOriginUrl);
    }

    private boolean cyT() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cyR() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.jxb = null;
        this.jwX = null;
        this.jwZ = null;
        this.jxa = null;
        this.jwW = null;
        this.jwY = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jve = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.jwU = true;
        super.seekTo(i);
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyM() {
        this.jwT = false;
        if (this.jwR != null) {
            this.jwR.czu();
            this.jwR.ey(getDuration());
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().oQ(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().yi(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyN() {
        this.jwT = false;
        if (getVideoMonitor() != null) {
            getVideoMonitor().oQ(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().cgE();
            getVideoMonitor().yh(-400);
        }
    }
}
