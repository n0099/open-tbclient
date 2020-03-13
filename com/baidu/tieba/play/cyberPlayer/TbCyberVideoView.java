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
    private static l efn;
    private WeakReference<Context> Pf;
    private String Pj;
    private final CustomMessageListener dVD;
    private i juV;
    private d juZ;
    private boolean jvq;
    private boolean jxb;
    private boolean jxc;
    private a jxd;
    private boolean jxe;
    private boolean jxf;
    private boolean jxg;
    private int jxh;
    private g.f jxi;
    private g.a jxj;
    private g.InterfaceC0590g jxk;
    private g.b jxl;
    private g.e jxm;
    private QuickVideoView.b jxn;
    private CyberPlayerManager.OnPreparedListener jxo;
    private CyberPlayerManager.OnCompletionListener jxp;
    private CyberPlayerManager.OnErrorListener jxq;
    private CyberPlayerManager.OnSeekCompleteListener jxr;
    private CyberPlayerManager.OnInfoListener jxs;
    private String mOriginUrl;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            efn = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.Pf = null;
        this.jxe = false;
        this.jxf = false;
        this.jxg = false;
        this.jvq = false;
        this.jxo = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int He;
                TbCyberVideoView.this.jxf = false;
                if (TbCyberVideoView.this.jxd != null) {
                    TbCyberVideoView.this.jxd.ey(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yh(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czw().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jxi != null) {
                        TbCyberVideoView.this.jxi.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jxb && (He = x.czt().He(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(He);
                    }
                    if (TbCyberVideoView.this.jxc) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jxp = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.juV != null) {
                    TbCyberVideoView.this.juV.Ff(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.juV = null;
                }
                x.czt().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jxd != null) {
                        TbCyberVideoView.this.jxd.onComplete();
                    }
                    TbCyberVideoView.this.jxc = false;
                    if (TbCyberVideoView.this.jxj != null) {
                        TbCyberVideoView.this.jxj.onCompletion(null);
                    }
                }
            }
        };
        this.jxq = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.juZ != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cyR()) {
                    x.czt().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czw().Hg(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jxl == null || !TbCyberVideoView.this.jxl.onError(null, i, i2)) {
                    TbCyberVideoView.this.jxg = false;
                    TbCyberVideoView.this.jxf = false;
                }
                return true;
            }
        };
        this.jxr = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jxg = false;
                if (TbCyberVideoView.this.jxk != null) {
                    TbCyberVideoView.this.jxk.b(null);
                }
            }
        };
        this.jxs = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jxm != null) {
                    TbCyberVideoView.this.jxm.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jxg && !TbCyberVideoView.this.jxf && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cgI();
                    TbCyberVideoView.this.getVideoMonitor().cgJ();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jxd.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.juV != null) {
                        TbCyberVideoView.this.juV.Fe(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.juV = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.Pf = null;
        this.jxe = false;
        this.jxf = false;
        this.jxg = false;
        this.jvq = false;
        this.jxo = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int He;
                TbCyberVideoView.this.jxf = false;
                if (TbCyberVideoView.this.jxd != null) {
                    TbCyberVideoView.this.jxd.ey(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yh(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czw().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jxi != null) {
                        TbCyberVideoView.this.jxi.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jxb && (He = x.czt().He(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(He);
                    }
                    if (TbCyberVideoView.this.jxc) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jxp = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.juV != null) {
                    TbCyberVideoView.this.juV.Ff(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.juV = null;
                }
                x.czt().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jxd != null) {
                        TbCyberVideoView.this.jxd.onComplete();
                    }
                    TbCyberVideoView.this.jxc = false;
                    if (TbCyberVideoView.this.jxj != null) {
                        TbCyberVideoView.this.jxj.onCompletion(null);
                    }
                }
            }
        };
        this.jxq = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.juZ != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cyR()) {
                    x.czt().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czw().Hg(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jxl == null || !TbCyberVideoView.this.jxl.onError(null, i, i2)) {
                    TbCyberVideoView.this.jxg = false;
                    TbCyberVideoView.this.jxf = false;
                }
                return true;
            }
        };
        this.jxr = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jxg = false;
                if (TbCyberVideoView.this.jxk != null) {
                    TbCyberVideoView.this.jxk.b(null);
                }
            }
        };
        this.jxs = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jxm != null) {
                    TbCyberVideoView.this.jxm.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jxg && !TbCyberVideoView.this.jxf && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cgI();
                    TbCyberVideoView.this.getVideoMonitor().cgJ();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jxd.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.juV != null) {
                        TbCyberVideoView.this.juV.Fe(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.juV = null;
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
        setOnPreparedListener(this.jxo);
        setOnCompletionListener(this.jxp);
        setOnErrorListener(this.jxq);
        setOnSeekCompleteListener(this.jxr);
        setOnInfoListener(this.jxs);
        this.jxd = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.jxe = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.Pf, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.jxe = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.juZ = dVar;
        if ((this.juZ instanceof n) && ((n) this.juZ).czd() != null) {
            this.jxd.h((n) this.juZ);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.jxi = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.jxj = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.jxl = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0590g interfaceC0590g) {
        this.jxk = interfaceC0590g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jxm = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.jxn = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jxb = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.jxh = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.Pj = str2;
            this.mOriginUrl = str;
            String Ha = Ha(str);
            if (efn != null) {
                this.juV = efn.ap(this.Pj, this.mOriginUrl, null);
                if (this.juV != null) {
                    this.juV.oQ(CyberPlayerManager.hasCacheFile(Ha));
                }
            }
            if (this.juZ != null && this.juZ.cyF() != null) {
                this.juZ.cyF().setPlayer(this);
            }
            this.jxd.czv();
            String host = Uri.parse(this.mOriginUrl).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.jxh < 900)) ? "1" : "0");
            setVideoPath(Ha);
            if (this.juV != null) {
                this.juV.cgF();
            }
            this.jxf = true;
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.jvq = true;
            if (!cyU()) {
                aVar.czx();
            }
            if (!cyT()) {
                aVar.czy();
                this.jxc = true;
                setVideoPath(this.mOriginUrl, this.Pj);
                return;
            }
        } else {
            this.jvq = false;
        }
        start();
        if (this.jvq) {
            this.jxd.a(this);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.jxe) {
            af.a(this.Pf, true);
            setVolume(1.0f, 1.0f);
        }
        this.jxc = true;
        super.start();
        if (this.jxd != null) {
            this.jxd.onStart();
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
        if (isPlaying() || this.jxc) {
            b(aVar);
            return;
        }
        this.jxc = true;
        if (aVar != null) {
            this.jvq = true;
            if (!cyU()) {
                aVar.czx();
            }
        } else {
            this.jvq = false;
        }
        setVideoPath(this.mOriginUrl, this.Pj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.Pf, false);
        if (isPlaying() && cyR()) {
            x.czt().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        super.pause();
        if (this.jxd != null) {
            this.jxd.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juV != null) {
            this.juV.cgK();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jvq) {
            stopPlayback();
            return;
        }
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        this.jxc = false;
        if (isPlaying() && cyR()) {
            x.czt().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.jxd != null) {
            this.jxd.onStop();
        }
        if (this.juV != null && this.juV.Fg(getLocateSource())) {
            this.juV = null;
        }
        this.jxf = false;
        this.jxg = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        this.jxc = false;
        if (isPlaying() && cyR()) {
            x.czt().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.czw().Hg(this.mOriginUrl);
        if (this.jxd != null) {
            this.jxd.onStop();
        }
        if (this.juV != null && this.juV.Fg(getLocateSource())) {
            this.juV = null;
        }
        this.jxf = false;
        this.jxg = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jxn != null) {
            this.jxn.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.dVD);
    }

    private String Ha(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPi().cPj()) {
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
    public boolean cyP() {
        return this.jxc;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.juV != null) {
            this.juV.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyR() {
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
        if (!(this.juZ instanceof n) || ((n) this.juZ).czd() == null) {
            return "";
        }
        return ((n) this.juZ).jvU ? "v_mid_page" : ((n) this.juZ).czd().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.juV != null) {
            return this.juV;
        }
        if (!StringUtils.isNull(this.mOriginUrl) && efn != null) {
            this.juV = efn.ap(this.Pj, this.mOriginUrl, null);
        }
        return this.juV;
    }

    private boolean cyT() {
        return this == TbVideoViewSet.czw().Hf(this.mOriginUrl);
    }

    private boolean cyU() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cyS() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.jxn = null;
        this.jxj = null;
        this.jxl = null;
        this.jxm = null;
        this.jxi = null;
        this.jxk = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jvq = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.jxg = true;
        super.seekTo(i);
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyN() {
        this.jxf = false;
        if (this.jxd != null) {
            this.jxd.czv();
            this.jxd.ey(getDuration());
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().oQ(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().yi(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyO() {
        this.jxf = false;
        if (getVideoMonitor() != null) {
            getVideoMonitor().oQ(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().cgF();
            getVideoMonitor().yh(-400);
        }
    }
}
