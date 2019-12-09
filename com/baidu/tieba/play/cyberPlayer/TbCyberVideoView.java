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
    private static l dqN;
    private WeakReference<Context> bTF;
    private String cma;
    private final CustomMessageListener ddg;
    private i iwn;
    private d iwr;
    private g.a iyA;
    private g.InterfaceC0493g iyB;
    private g.b iyC;
    private g.e iyD;
    private QuickVideoView.b iyE;
    private CyberPlayerManager.OnPreparedListener iyF;
    private CyberPlayerManager.OnCompletionListener iyG;
    private CyberPlayerManager.OnErrorListener iyH;
    private CyberPlayerManager.OnSeekCompleteListener iyI;
    private CyberPlayerManager.OnInfoListener iyJ;
    private boolean iys;
    private String iyt;
    private boolean iyu;
    private a iyv;
    private boolean iyw;
    private boolean iyx;
    private boolean iyy;
    private g.f iyz;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            dqN = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.bTF = null;
        this.iyw = false;
        this.iyx = false;
        this.iyy = false;
        this.iyF = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int BS;
                TbCyberVideoView.this.iyx = false;
                if (TbCyberVideoView.this.iyv != null) {
                    TbCyberVideoView.this.iyv.dP(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().vV(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    if (TbCyberVideoView.this.iyz != null) {
                        TbCyberVideoView.this.iyz.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.iys && (BS = y.ccR().BS(TbCyberVideoView.this.iyt)) > 0) {
                        TbCyberVideoView.this.seekTo(BS);
                    }
                    if (TbCyberVideoView.this.iyu) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.iyG = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.iwn != null) {
                    TbCyberVideoView.this.iwn.zW(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iwn = null;
                }
                y.ccR().remove(TbCyberVideoView.this.iyt);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.iyv != null) {
                        TbCyberVideoView.this.iyv.onComplete();
                    }
                    TbCyberVideoView.this.iyu = false;
                    if (TbCyberVideoView.this.iyA != null) {
                        TbCyberVideoView.this.iyA.onCompletion(null);
                    }
                }
            }
        };
        this.iyH = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iwr != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.ccq()) {
                    y.ccR().bd(TbCyberVideoView.this.iyt, TbCyberVideoView.this.getCurrentPosition());
                }
                if (TbCyberVideoView.this.iyC == null || !TbCyberVideoView.this.iyC.onError(null, i, i2)) {
                    TbCyberVideoView.this.iyy = false;
                    TbCyberVideoView.this.iyx = false;
                }
                return true;
            }
        };
        this.iyI = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.iyy = false;
                if (TbCyberVideoView.this.iyB != null) {
                    TbCyberVideoView.this.iyB.b(null);
                }
            }
        };
        this.iyJ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iyD != null) {
                    TbCyberVideoView.this.iyD.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.iyy && !TbCyberVideoView.this.iyx && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().bMG();
                    TbCyberVideoView.this.getVideoMonitor().bMH();
                }
                if (i == 904) {
                    TbCyberVideoView.this.iyv.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.ddg = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.iwn != null) {
                    TbCyberVideoView.this.iwn.zV(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iwn = null;
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.bTF = null;
        this.iyw = false;
        this.iyx = false;
        this.iyy = false;
        this.iyF = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int BS;
                TbCyberVideoView.this.iyx = false;
                if (TbCyberVideoView.this.iyv != null) {
                    TbCyberVideoView.this.iyv.dP(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().vV(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    if (TbCyberVideoView.this.iyz != null) {
                        TbCyberVideoView.this.iyz.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.iys && (BS = y.ccR().BS(TbCyberVideoView.this.iyt)) > 0) {
                        TbCyberVideoView.this.seekTo(BS);
                    }
                    if (TbCyberVideoView.this.iyu) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.iyG = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.iwn != null) {
                    TbCyberVideoView.this.iwn.zW(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iwn = null;
                }
                y.ccR().remove(TbCyberVideoView.this.iyt);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.iyv != null) {
                        TbCyberVideoView.this.iyv.onComplete();
                    }
                    TbCyberVideoView.this.iyu = false;
                    if (TbCyberVideoView.this.iyA != null) {
                        TbCyberVideoView.this.iyA.onCompletion(null);
                    }
                }
            }
        };
        this.iyH = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iwr != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.ccq()) {
                    y.ccR().bd(TbCyberVideoView.this.iyt, TbCyberVideoView.this.getCurrentPosition());
                }
                if (TbCyberVideoView.this.iyC == null || !TbCyberVideoView.this.iyC.onError(null, i, i2)) {
                    TbCyberVideoView.this.iyy = false;
                    TbCyberVideoView.this.iyx = false;
                }
                return true;
            }
        };
        this.iyI = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.iyy = false;
                if (TbCyberVideoView.this.iyB != null) {
                    TbCyberVideoView.this.iyB.b(null);
                }
            }
        };
        this.iyJ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.iyD != null) {
                    TbCyberVideoView.this.iyD.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.iyy && !TbCyberVideoView.this.iyx && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().bMG();
                    TbCyberVideoView.this.getVideoMonitor().bMH();
                }
                if (i == 904) {
                    TbCyberVideoView.this.iyv.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.ddg = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.iwn != null) {
                    TbCyberVideoView.this.iwn.zV(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.iwn = null;
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
        setOnPreparedListener(this.iyF);
        setOnCompletionListener(this.iyG);
        setOnErrorListener(this.iyH);
        setOnSeekCompleteListener(this.iyI);
        setOnInfoListener(this.iyJ);
        this.iyv = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setMute(boolean z) {
        this.iyw = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ac.a(this.bTF, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.iyw = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void cbA() {
        stopPlayback();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.iwr = dVar;
        if ((this.iwr instanceof n) && ((n) this.iwr).ccz() != null) {
            this.iyv.setVideoStatsData(((n) this.iwr).ccz());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.iyz = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.iyA = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.iyC = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0493g interfaceC0493g) {
        this.iyB = interfaceC0493g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.iyD = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.iyE = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.iys = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.cma = str2;
            this.iyt = str;
            String BO = BO(str);
            if (dqN != null) {
                this.iwn = dqN.aa(this.cma, this.iyt, null);
                if (this.iwn != null) {
                    this.iwn.nm(CyberPlayerManager.hasCacheFile(BO));
                }
            }
            if (this.iwr != null && this.iwr.ccf() != null) {
                this.iwr.ccf().setPlayer(this);
            }
            this.iyv.ccT();
            setVideoPath(BO);
            if (this.iwn != null) {
                this.iwn.bMD();
            }
            this.iyx = true;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.iyw) {
            ac.a(this.bTF, true);
            setVolume(1.0f, 1.0f);
        }
        this.iyu = true;
        super.start();
        if (this.iyv != null) {
            this.iyv.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().vW(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void bIK() {
        if (isPlaying() || this.iyu) {
            start();
            return;
        }
        this.iyu = true;
        setVideoPath(this.iyt, this.cma);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ac.a(this.bTF, false);
        if (isPlaying() && ccq()) {
            y.ccR().bd(this.iyt, getCurrentPositionSync());
        }
        super.pause();
        if (this.iyv != null) {
            this.iyv.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iwn != null) {
            this.iwn.bMI();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.iyt != null && isPlaying()) {
            ac.a(this.bTF, false);
        }
        this.iyu = false;
        if (isPlaying() && ccq()) {
            y.ccR().bd(this.iyt, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        if (this.iyv != null) {
            this.iyv.onStop();
        }
        if (this.iwn != null && this.iwn.zX(getLocateSource())) {
            this.iwn = null;
        }
        this.iyx = false;
        this.iyy = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddg);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iyE != null) {
            this.iyE.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.ddg);
    }

    private String BO(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.csB().csC()) {
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
    public boolean cco() {
        return this.iyu;
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.iwn != null) {
            this.iwn.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccq() {
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
        this.iyv.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.iyv.setVideoSize(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.iwr instanceof n) || ((n) this.iwr).ccz() == null) ? "" : ((n) this.iwr).ccz().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.iwn != null) {
            return this.iwn;
        }
        if (!StringUtils.isNull(this.iyt) && dqN != null) {
            this.iwn = dqN.aa(this.cma, this.iyt, null);
        }
        return this.iwn;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.iyy = true;
        super.seekTo(i);
    }
}
