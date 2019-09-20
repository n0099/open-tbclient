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
    private static l dij;
    private WeakReference<Context> bCb;
    private String bXN;
    private final CustomMessageListener cUD;
    private boolean iAM;
    private String iAN;
    private boolean iAO;
    private a iAP;
    private boolean iAQ;
    private boolean iAR;
    private boolean iAS;
    private g.f iAT;
    private g.a iAU;
    private g.InterfaceC0404g iAV;
    private g.b iAW;
    private g.e iAX;
    private QuickVideoView.b iAY;
    private CyberPlayerManager.OnPreparedListener iAZ;
    private CyberPlayerManager.OnCompletionListener iBa;
    private CyberPlayerManager.OnErrorListener iBb;
    private CyberPlayerManager.OnSeekCompleteListener iBc;
    private CyberPlayerManager.OnInfoListener iBd;
    private i iyC;
    private d iyG;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        if (runTask != null) {
            dij = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.bCb = null;
        this.iAQ = false;
        this.iAR = false;
        this.iAS = false;
        this.iAZ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Dz;
                TbCyberVideoView.this.iAR = false;
                if (TbCyberVideoView.this.iAP != null) {
                    TbCyberVideoView.this.iAP.ev(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().xq(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    if (TbCyberVideoView.this.iAT != null) {
                        TbCyberVideoView.this.iAT.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.iAM && (Dz = y.cfS().Dz(TbCyberVideoView.this.iAN)) > 0) {
                        TbCyberVideoView.this.seekTo(Dz);
                    }
                    if (TbCyberVideoView.this.iAO) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.iBa = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.iyC != null) {
                    TbCyberVideoView.this.iyC.BC(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iyC = null;
                }
                y.cfS().remove(TbCyberVideoView.this.iAN);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.iAP != null) {
                        TbCyberVideoView.this.iAP.onComplete();
                    }
                    TbCyberVideoView.this.iAO = false;
                    if (TbCyberVideoView.this.iAU != null) {
                        TbCyberVideoView.this.iAU.onCompletion(null);
                    }
                }
            }
        };
        this.iBb = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iyG != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cfq()) {
                    y.cfS().bi(TbCyberVideoView.this.iAN, TbCyberVideoView.this.getCurrentPosition());
                }
                if (TbCyberVideoView.this.iAW == null || !TbCyberVideoView.this.iAW.onError(null, i, i2)) {
                    TbCyberVideoView.this.iAS = false;
                    TbCyberVideoView.this.iAR = false;
                }
                return true;
            }
        };
        this.iBc = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.iAS = false;
                if (TbCyberVideoView.this.iAV != null) {
                    TbCyberVideoView.this.iAV.b(null);
                }
            }
        };
        this.iBd = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iAX != null) {
                    TbCyberVideoView.this.iAX.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.iAS && !TbCyberVideoView.this.iAR && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().bPI();
                    TbCyberVideoView.this.getVideoMonitor().bPJ();
                }
                if (i == 904) {
                    TbCyberVideoView.this.iAP.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.cUD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.iyC != null) {
                    TbCyberVideoView.this.iyC.BB(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iyC = null;
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.bCb = null;
        this.iAQ = false;
        this.iAR = false;
        this.iAS = false;
        this.iAZ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Dz;
                TbCyberVideoView.this.iAR = false;
                if (TbCyberVideoView.this.iAP != null) {
                    TbCyberVideoView.this.iAP.ev(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().xq(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    if (TbCyberVideoView.this.iAT != null) {
                        TbCyberVideoView.this.iAT.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.iAM && (Dz = y.cfS().Dz(TbCyberVideoView.this.iAN)) > 0) {
                        TbCyberVideoView.this.seekTo(Dz);
                    }
                    if (TbCyberVideoView.this.iAO) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.iBa = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.iyC != null) {
                    TbCyberVideoView.this.iyC.BC(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iyC = null;
                }
                y.cfS().remove(TbCyberVideoView.this.iAN);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.iAP != null) {
                        TbCyberVideoView.this.iAP.onComplete();
                    }
                    TbCyberVideoView.this.iAO = false;
                    if (TbCyberVideoView.this.iAU != null) {
                        TbCyberVideoView.this.iAU.onCompletion(null);
                    }
                }
            }
        };
        this.iBb = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iyG != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cfq()) {
                    y.cfS().bi(TbCyberVideoView.this.iAN, TbCyberVideoView.this.getCurrentPosition());
                }
                if (TbCyberVideoView.this.iAW == null || !TbCyberVideoView.this.iAW.onError(null, i, i2)) {
                    TbCyberVideoView.this.iAS = false;
                    TbCyberVideoView.this.iAR = false;
                }
                return true;
            }
        };
        this.iBc = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.iAS = false;
                if (TbCyberVideoView.this.iAV != null) {
                    TbCyberVideoView.this.iAV.b(null);
                }
            }
        };
        this.iBd = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iAX != null) {
                    TbCyberVideoView.this.iAX.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.iAS && !TbCyberVideoView.this.iAR && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().bPI();
                    TbCyberVideoView.this.getVideoMonitor().bPJ();
                }
                if (i == 904) {
                    TbCyberVideoView.this.iAP.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.cUD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.iyC != null) {
                    TbCyberVideoView.this.iyC.BB(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iyC = null;
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
        setOnPreparedListener(this.iAZ);
        setOnCompletionListener(this.iBa);
        setOnErrorListener(this.iBb);
        setOnSeekCompleteListener(this.iBc);
        setOnInfoListener(this.iBd);
        this.iAP = new a();
        am.k(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setMute(boolean z) {
        this.iAQ = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ac.a(this.bCb, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.iAQ = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void ceA() {
        stopPlayback();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.iyG = dVar;
        if ((this.iyG instanceof n) && ((n) this.iyG).cfz() != null) {
            this.iAP.setVideoStatsData(((n) this.iyG).cfz());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.iAT = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.iAU = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.iAW = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0404g interfaceC0404g) {
        this.iAV = interfaceC0404g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.iAX = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.iAY = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.iAM = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.bXN = str2;
            this.iAN = str;
            String Dv = Dv(str);
            if (dij != null) {
                this.iyC = dij.Z(this.bXN, this.iAN, null);
                if (this.iyC != null) {
                    this.iyC.nA(CyberPlayerManager.hasCacheFile(Dv));
                }
            }
            if (this.iyG != null && this.iyG.cff() != null) {
                this.iyG.cff().setPlayer(this);
            }
            this.iAP.cfU();
            setVideoPath(Dv);
            if (this.iyC != null) {
                this.iyC.bPF();
            }
            this.iAR = true;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.iAQ) {
            ac.a(this.bCb, true);
            setVolume(1.0f, 1.0f);
        }
        this.iAO = true;
        super.start();
        if (this.iAP != null) {
            this.iAP.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().xr(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void bMd() {
        if (isPlaying() || this.iAO) {
            start();
            return;
        }
        this.iAO = true;
        setVideoPath(this.iAN, this.bXN);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ac.a(this.bCb, false);
        if (isPlaying() && cfq()) {
            y.cfS().bi(this.iAN, getCurrentPositionSync());
        }
        super.pause();
        if (this.iAP != null) {
            this.iAP.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iyC != null) {
            this.iyC.bPK();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.iAN != null && isPlaying()) {
            ac.a(this.bCb, false);
        }
        this.iAO = false;
        if (isPlaying() && cfq()) {
            y.cfS().bi(this.iAN, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        if (this.iAP != null) {
            this.iAP.onStop();
        }
        if (this.iyC != null && this.iyC.BD(getLocateSource())) {
            this.iyC = null;
        }
        this.iAR = false;
        this.iAS = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cUD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iAY != null) {
            this.iAY.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.cUD);
    }

    private String Dv(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cuO().cuP()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            if (str.contains("http:")) {
                return str.replace("http:", "https:");
            }
            return str;
        }
        return str;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cfo() {
        return this.iAO;
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.iyC != null) {
            this.iyC.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfq() {
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
        this.iAP.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.iAP.setVideoSize(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.iyG instanceof n) || ((n) this.iyG).cfz() == null) ? "" : ((n) this.iyG).cfz().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.iyC != null) {
            return this.iyC;
        }
        if (!StringUtils.isNull(this.iAN) && dij != null) {
            this.iyC = dij.Z(this.bXN, this.iAN, null);
        }
        return this.iyC;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.iAS = true;
        super.seekTo(i);
    }
}
