package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.os.PowerManager;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.j.i;
import com.baidu.tieba.j.l;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.d;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements com.baidu.tieba.play.a.a {
    private static l drE;
    private WeakReference<Context> bUw;
    private String cmS;
    private final CustomMessageListener ddY;
    private i ixe;
    private d ixi;
    private CyberPlayerManager.OnInfoListener izA;
    private boolean izj;
    private String izk;
    private boolean izl;
    private a izm;
    private boolean izn;
    private boolean izo;
    private boolean izp;
    private g.f izq;
    private g.a izr;
    private g.InterfaceC0498g izs;
    private g.b izt;
    private g.e izu;
    private QuickVideoView.b izv;
    private CyberPlayerManager.OnPreparedListener izw;
    private CyberPlayerManager.OnCompletionListener izx;
    private CyberPlayerManager.OnErrorListener izy;
    private CyberPlayerManager.OnSeekCompleteListener izz;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            drE = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.bUw = null;
        this.izn = false;
        this.izo = false;
        this.izp = false;
        this.izw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int BS;
                TbCyberVideoView.this.izo = false;
                if (TbCyberVideoView.this.izm != null) {
                    TbCyberVideoView.this.izm.dQ(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().vW(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    if (TbCyberVideoView.this.izq != null) {
                        TbCyberVideoView.this.izq.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.izj && (BS = y.ccT().BS(TbCyberVideoView.this.izk)) > 0) {
                        TbCyberVideoView.this.seekTo(BS);
                    }
                    if (TbCyberVideoView.this.izl) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.izx = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ixe != null) {
                    TbCyberVideoView.this.ixe.zW(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.ixe = null;
                }
                y.ccT().remove(TbCyberVideoView.this.izk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.izm != null) {
                        TbCyberVideoView.this.izm.onComplete();
                    }
                    TbCyberVideoView.this.izl = false;
                    if (TbCyberVideoView.this.izr != null) {
                        TbCyberVideoView.this.izr.onCompletion(null);
                    }
                }
            }
        };
        this.izy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.ixi != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.ccs()) {
                    y.ccT().bd(TbCyberVideoView.this.izk, TbCyberVideoView.this.getCurrentPosition());
                }
                if (TbCyberVideoView.this.izt == null || !TbCyberVideoView.this.izt.onError(null, i, i2)) {
                    TbCyberVideoView.this.izp = false;
                    TbCyberVideoView.this.izo = false;
                }
                return true;
            }
        };
        this.izz = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.izp = false;
                if (TbCyberVideoView.this.izs != null) {
                    TbCyberVideoView.this.izs.b(null);
                }
            }
        };
        this.izA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.izu != null) {
                    TbCyberVideoView.this.izu.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.izp && !TbCyberVideoView.this.izo && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().bMI();
                    TbCyberVideoView.this.getVideoMonitor().bMJ();
                }
                if (i == 904) {
                    TbCyberVideoView.this.izm.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.ddY = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.ixe != null) {
                    TbCyberVideoView.this.ixe.zV(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.ixe = null;
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.bUw = null;
        this.izn = false;
        this.izo = false;
        this.izp = false;
        this.izw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int BS;
                TbCyberVideoView.this.izo = false;
                if (TbCyberVideoView.this.izm != null) {
                    TbCyberVideoView.this.izm.dQ(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().vW(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    if (TbCyberVideoView.this.izq != null) {
                        TbCyberVideoView.this.izq.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.izj && (BS = y.ccT().BS(TbCyberVideoView.this.izk)) > 0) {
                        TbCyberVideoView.this.seekTo(BS);
                    }
                    if (TbCyberVideoView.this.izl) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.izx = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ixe != null) {
                    TbCyberVideoView.this.ixe.zW(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.ixe = null;
                }
                y.ccT().remove(TbCyberVideoView.this.izk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.izm != null) {
                        TbCyberVideoView.this.izm.onComplete();
                    }
                    TbCyberVideoView.this.izl = false;
                    if (TbCyberVideoView.this.izr != null) {
                        TbCyberVideoView.this.izr.onCompletion(null);
                    }
                }
            }
        };
        this.izy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.ixi != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.ccs()) {
                    y.ccT().bd(TbCyberVideoView.this.izk, TbCyberVideoView.this.getCurrentPosition());
                }
                if (TbCyberVideoView.this.izt == null || !TbCyberVideoView.this.izt.onError(null, i, i2)) {
                    TbCyberVideoView.this.izp = false;
                    TbCyberVideoView.this.izo = false;
                }
                return true;
            }
        };
        this.izz = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.izp = false;
                if (TbCyberVideoView.this.izs != null) {
                    TbCyberVideoView.this.izs.b(null);
                }
            }
        };
        this.izA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.izu != null) {
                    TbCyberVideoView.this.izu.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.izp && !TbCyberVideoView.this.izo && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().bMI();
                    TbCyberVideoView.this.getVideoMonitor().bMJ();
                }
                if (i == 904) {
                    TbCyberVideoView.this.izm.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.ddY = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.ixe != null) {
                    TbCyberVideoView.this.ixe.zV(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.ixe = null;
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
        setOnPreparedListener(this.izw);
        setOnCompletionListener(this.izx);
        setOnErrorListener(this.izy);
        setOnSeekCompleteListener(this.izz);
        setOnInfoListener(this.izA);
        this.izm = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setMute(boolean z) {
        this.izn = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ac.a(this.bUw, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.izn = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void cbC() {
        stopPlayback();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.ixi = dVar;
        if ((this.ixi instanceof n) && ((n) this.ixi).ccB() != null) {
            this.izm.setVideoStatsData(((n) this.ixi).ccB());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.izq = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.izr = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.izt = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0498g interfaceC0498g) {
        this.izs = interfaceC0498g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.izu = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.izv = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.izj = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.cmS = str2;
            this.izk = str;
            String BO = BO(str);
            if (drE != null) {
                this.ixe = drE.aa(this.cmS, this.izk, null);
                if (this.ixe != null) {
                    this.ixe.nm(CyberPlayerManager.hasCacheFile(BO));
                }
            }
            if (this.ixi != null && this.ixi.cch() != null) {
                this.ixi.cch().setPlayer(this);
            }
            this.izm.ccV();
            setVideoPath(BO);
            if (this.ixe != null) {
                this.ixe.bMF();
            }
            this.izo = true;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.izn) {
            ac.a(this.bUw, true);
            setVolume(1.0f, 1.0f);
        }
        this.izl = true;
        super.start();
        if (this.izm != null) {
            this.izm.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().vX(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void bIM() {
        if (isPlaying() || this.izl) {
            start();
            return;
        }
        this.izl = true;
        setVideoPath(this.izk, this.cmS);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ac.a(this.bUw, false);
        if (isPlaying() && ccs()) {
            y.ccT().bd(this.izk, getCurrentPositionSync());
        }
        super.pause();
        if (this.izm != null) {
            this.izm.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ixe != null) {
            this.ixe.bMK();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.izk != null && isPlaying()) {
            ac.a(this.bUw, false);
        }
        this.izl = false;
        if (isPlaying() && ccs()) {
            y.ccT().bd(this.izk, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        if (this.izm != null) {
            this.izm.onStop();
        }
        if (this.ixe != null && this.ixe.zX(getLocateSource())) {
            this.ixe = null;
        }
        this.izo = false;
        this.izp = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddY);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.izv != null) {
            this.izv.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.ddY);
    }

    private String BO(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.csD().csE()) {
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
    public boolean ccq() {
        return this.izl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.ixe != null) {
            this.ixe.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccs() {
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

    @Override // com.baidu.tieba.play.a.a
    public void setPageTypeForPerfStat(String str) {
        this.izm.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.izm.setVideoSize(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.ixi instanceof n) || ((n) this.ixi).ccB() == null) ? "" : ((n) this.ixi).ccB().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.ixe != null) {
            return this.ixe;
        }
        if (!StringUtils.isNull(this.izk) && drE != null) {
            this.ixe = drE.aa(this.cmS, this.izk, null);
        }
        return this.ixe;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.izp = true;
        super.seekTo(i);
    }
}
