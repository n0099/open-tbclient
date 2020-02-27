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
    private static l eeZ;
    private WeakReference<Context> Pf;
    private String Pj;
    private final CustomMessageListener dVp;
    private i juH;
    private d juL;
    private boolean jvc;
    private boolean jwN;
    private boolean jwO;
    private a jwP;
    private boolean jwQ;
    private boolean jwR;
    private boolean jwS;
    private int jwT;
    private g.f jwU;
    private g.a jwV;
    private g.InterfaceC0590g jwW;
    private g.b jwX;
    private g.e jwY;
    private QuickVideoView.b jwZ;
    private CyberPlayerManager.OnPreparedListener jxa;
    private CyberPlayerManager.OnCompletionListener jxb;
    private CyberPlayerManager.OnErrorListener jxc;
    private CyberPlayerManager.OnSeekCompleteListener jxd;
    private CyberPlayerManager.OnInfoListener jxe;
    private String mOriginUrl;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            eeZ = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.Pf = null;
        this.jwQ = false;
        this.jwR = false;
        this.jwS = false;
        this.jvc = false;
        this.jxa = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Hd;
                TbCyberVideoView.this.jwR = false;
                if (TbCyberVideoView.this.jwP != null) {
                    TbCyberVideoView.this.jwP.ey(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yh(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czt().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jwU != null) {
                        TbCyberVideoView.this.jwU.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jwN && (Hd = x.czq().Hd(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(Hd);
                    }
                    if (TbCyberVideoView.this.jwO) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jxb = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.juH != null) {
                    TbCyberVideoView.this.juH.Fe(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.juH = null;
                }
                x.czq().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jwP != null) {
                        TbCyberVideoView.this.jwP.onComplete();
                    }
                    TbCyberVideoView.this.jwO = false;
                    if (TbCyberVideoView.this.jwV != null) {
                        TbCyberVideoView.this.jwV.onCompletion(null);
                    }
                }
            }
        };
        this.jxc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.juL != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cyO()) {
                    x.czq().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czt().Hf(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwX == null || !TbCyberVideoView.this.jwX.onError(null, i, i2)) {
                    TbCyberVideoView.this.jwS = false;
                    TbCyberVideoView.this.jwR = false;
                }
                return true;
            }
        };
        this.jxd = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jwS = false;
                if (TbCyberVideoView.this.jwW != null) {
                    TbCyberVideoView.this.jwW.b(null);
                }
            }
        };
        this.jxe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwY != null) {
                    TbCyberVideoView.this.jwY.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jwS && !TbCyberVideoView.this.jwR && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cgF();
                    TbCyberVideoView.this.getVideoMonitor().cgG();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jwP.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.juH != null) {
                        TbCyberVideoView.this.juH.Fd(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.juH = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.Pf = null;
        this.jwQ = false;
        this.jwR = false;
        this.jwS = false;
        this.jvc = false;
        this.jxa = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Hd;
                TbCyberVideoView.this.jwR = false;
                if (TbCyberVideoView.this.jwP != null) {
                    TbCyberVideoView.this.jwP.ey(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yh(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czt().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jwU != null) {
                        TbCyberVideoView.this.jwU.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jwN && (Hd = x.czq().Hd(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(Hd);
                    }
                    if (TbCyberVideoView.this.jwO) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jxb = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.juH != null) {
                    TbCyberVideoView.this.juH.Fe(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.juH = null;
                }
                x.czq().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jwP != null) {
                        TbCyberVideoView.this.jwP.onComplete();
                    }
                    TbCyberVideoView.this.jwO = false;
                    if (TbCyberVideoView.this.jwV != null) {
                        TbCyberVideoView.this.jwV.onCompletion(null);
                    }
                }
            }
        };
        this.jxc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.juL != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cyO()) {
                    x.czq().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czt().Hf(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwX == null || !TbCyberVideoView.this.jwX.onError(null, i, i2)) {
                    TbCyberVideoView.this.jwS = false;
                    TbCyberVideoView.this.jwR = false;
                }
                return true;
            }
        };
        this.jxd = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jwS = false;
                if (TbCyberVideoView.this.jwW != null) {
                    TbCyberVideoView.this.jwW.b(null);
                }
            }
        };
        this.jxe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwY != null) {
                    TbCyberVideoView.this.jwY.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jwS && !TbCyberVideoView.this.jwR && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cgF();
                    TbCyberVideoView.this.getVideoMonitor().cgG();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jwP.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.juH != null) {
                        TbCyberVideoView.this.juH.Fd(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.juH = null;
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
        setOnPreparedListener(this.jxa);
        setOnCompletionListener(this.jxb);
        setOnErrorListener(this.jxc);
        setOnSeekCompleteListener(this.jxd);
        setOnInfoListener(this.jxe);
        this.jwP = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.jwQ = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.Pf, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.jwQ = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.juL = dVar;
        if ((this.juL instanceof n) && ((n) this.juL).cza() != null) {
            this.jwP.h((n) this.juL);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.jwU = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.jwV = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.jwX = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0590g interfaceC0590g) {
        this.jwW = interfaceC0590g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jwY = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.jwZ = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jwN = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.jwT = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.Pj = str2;
            this.mOriginUrl = str;
            String GZ = GZ(str);
            if (eeZ != null) {
                this.juH = eeZ.ap(this.Pj, this.mOriginUrl, null);
                if (this.juH != null) {
                    this.juH.oQ(CyberPlayerManager.hasCacheFile(GZ));
                }
            }
            if (this.juL != null && this.juL.cyC() != null) {
                this.juL.cyC().setPlayer(this);
            }
            this.jwP.czs();
            String host = Uri.parse(this.mOriginUrl).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.jwT < 900)) ? "1" : "0");
            setVideoPath(GZ);
            if (this.juH != null) {
                this.juH.cgC();
            }
            this.jwR = true;
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.jvc = true;
            if (!cyR()) {
                aVar.czu();
            }
            if (!cyQ()) {
                aVar.czv();
                this.jwO = true;
                setVideoPath(this.mOriginUrl, this.Pj);
                return;
            }
        } else {
            this.jvc = false;
        }
        start();
        if (this.jvc) {
            this.jwP.a(this);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.jwQ) {
            af.a(this.Pf, true);
            setVolume(1.0f, 1.0f);
        }
        this.jwO = true;
        super.start();
        if (this.jwP != null) {
            this.jwP.onStart();
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
        if (isPlaying() || this.jwO) {
            b(aVar);
            return;
        }
        this.jwO = true;
        if (aVar != null) {
            this.jvc = true;
            if (!cyR()) {
                aVar.czu();
            }
        } else {
            this.jvc = false;
        }
        setVideoPath(this.mOriginUrl, this.Pj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.Pf, false);
        if (isPlaying() && cyO()) {
            x.czq().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        super.pause();
        if (this.jwP != null) {
            this.jwP.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juH != null) {
            this.juH.cgH();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jvc) {
            stopPlayback();
            return;
        }
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        this.jwO = false;
        if (isPlaying() && cyO()) {
            x.czq().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.jwP != null) {
            this.jwP.onStop();
        }
        if (this.juH != null && this.juH.Ff(getLocateSource())) {
            this.juH = null;
        }
        this.jwR = false;
        this.jwS = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        this.jwO = false;
        if (isPlaying() && cyO()) {
            x.czq().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.czt().Hf(this.mOriginUrl);
        if (this.jwP != null) {
            this.jwP.onStop();
        }
        if (this.juH != null && this.juH.Ff(getLocateSource())) {
            this.juH = null;
        }
        this.jwR = false;
        this.jwS = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVp);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jwZ != null) {
            this.jwZ.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.dVp);
    }

    private String GZ(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPf().cPg()) {
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
    public boolean cyM() {
        return this.jwO;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.juH != null) {
            this.juH.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyO() {
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
        if (!(this.juL instanceof n) || ((n) this.juL).cza() == null) {
            return "";
        }
        return ((n) this.juL).jvG ? "v_mid_page" : ((n) this.juL).cza().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.juH != null) {
            return this.juH;
        }
        if (!StringUtils.isNull(this.mOriginUrl) && eeZ != null) {
            this.juH = eeZ.ap(this.Pj, this.mOriginUrl, null);
        }
        return this.juH;
    }

    private boolean cyQ() {
        return this == TbVideoViewSet.czt().He(this.mOriginUrl);
    }

    private boolean cyR() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cyP() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.jwZ = null;
        this.jwV = null;
        this.jwX = null;
        this.jwY = null;
        this.jwU = null;
        this.jwW = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jvc = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.jwS = true;
        super.seekTo(i);
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyK() {
        this.jwR = false;
        if (this.jwP != null) {
            this.jwP.czs();
            this.jwP.ey(getDuration());
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().oQ(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().yi(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyL() {
        this.jwR = false;
        if (getVideoMonitor() != null) {
            getVideoMonitor().oQ(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().cgC();
            getVideoMonitor().yh(-400);
        }
    }
}
