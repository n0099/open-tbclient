package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
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
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.j.i;
import com.baidu.tieba.j.l;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.d;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements com.baidu.tieba.play.a.a {
    private static l eaW;
    private WeakReference<Context> OC;
    private String OG;
    private final CustomMessageListener dRk;
    private i jtO;
    private d jtS;
    private boolean juj;
    private boolean jvS;
    private boolean jvT;
    private a jvU;
    private boolean jvV;
    private boolean jvW;
    private boolean jvX;
    private g.f jvY;
    private g.a jvZ;
    private g.InterfaceC0582g jwa;
    private g.b jwb;
    private g.e jwc;
    private QuickVideoView.b jwd;
    private CyberPlayerManager.OnPreparedListener jwe;
    private CyberPlayerManager.OnCompletionListener jwf;
    private CyberPlayerManager.OnErrorListener jwg;
    private CyberPlayerManager.OnSeekCompleteListener jwh;
    private CyberPlayerManager.OnInfoListener jwi;
    private String mOriginUrl;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            eaW = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.OC = null;
        this.jvV = false;
        this.jvW = false;
        this.jvX = false;
        this.juj = false;
        this.jwe = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int GP;
                TbCyberVideoView.this.cxp();
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cxX().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jvY != null) {
                        TbCyberVideoView.this.jvY.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jvS && (GP = x.cxU().GP(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(GP);
                    }
                    if (TbCyberVideoView.this.jvT) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jwf = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jtO != null) {
                    TbCyberVideoView.this.jtO.EO(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtO = null;
                }
                x.cxU().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jvU != null) {
                        TbCyberVideoView.this.jvU.onComplete();
                    }
                    TbCyberVideoView.this.jvT = false;
                    if (TbCyberVideoView.this.jvZ != null) {
                        TbCyberVideoView.this.jvZ.onCompletion(null);
                    }
                }
            }
        };
        this.jwg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jtS != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cxs()) {
                    x.cxU().bn(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxX().GR(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwb == null || !TbCyberVideoView.this.jwb.onError(null, i, i2)) {
                    TbCyberVideoView.this.jvX = false;
                    TbCyberVideoView.this.jvW = false;
                }
                return true;
            }
        };
        this.jwh = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jvX = false;
                if (TbCyberVideoView.this.jwa != null) {
                    TbCyberVideoView.this.jwa.b(null);
                }
            }
        };
        this.jwi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwc != null) {
                    TbCyberVideoView.this.jwc.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jvX && !TbCyberVideoView.this.jvW && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cfb();
                    TbCyberVideoView.this.getVideoMonitor().cfc();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jvU.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.jtO != null) {
                    TbCyberVideoView.this.jtO.EN(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtO = null;
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.OC = null;
        this.jvV = false;
        this.jvW = false;
        this.jvX = false;
        this.juj = false;
        this.jwe = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int GP;
                TbCyberVideoView.this.cxp();
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cxX().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jvY != null) {
                        TbCyberVideoView.this.jvY.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jvS && (GP = x.cxU().GP(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(GP);
                    }
                    if (TbCyberVideoView.this.jvT) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jwf = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jtO != null) {
                    TbCyberVideoView.this.jtO.EO(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtO = null;
                }
                x.cxU().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jvU != null) {
                        TbCyberVideoView.this.jvU.onComplete();
                    }
                    TbCyberVideoView.this.jvT = false;
                    if (TbCyberVideoView.this.jvZ != null) {
                        TbCyberVideoView.this.jvZ.onCompletion(null);
                    }
                }
            }
        };
        this.jwg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jtS != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cxs()) {
                    x.cxU().bn(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxX().GR(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwb == null || !TbCyberVideoView.this.jwb.onError(null, i, i2)) {
                    TbCyberVideoView.this.jvX = false;
                    TbCyberVideoView.this.jvW = false;
                }
                return true;
            }
        };
        this.jwh = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jvX = false;
                if (TbCyberVideoView.this.jwa != null) {
                    TbCyberVideoView.this.jwa.b(null);
                }
            }
        };
        this.jwi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwc != null) {
                    TbCyberVideoView.this.jwc.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jvX && !TbCyberVideoView.this.jvW && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cfb();
                    TbCyberVideoView.this.getVideoMonitor().cfc();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jvU.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.jtO != null) {
                    TbCyberVideoView.this.jtO.EN(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtO = null;
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
        setOnPreparedListener(this.jwe);
        setOnCompletionListener(this.jwf);
        setOnErrorListener(this.jwg);
        setOnSeekCompleteListener(this.jwh);
        setOnInfoListener(this.jwi);
        this.jvU = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.jvV = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.OC, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.jvV = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.jtS = dVar;
        if ((this.jtS instanceof n) && ((n) this.jtS).cxE() != null) {
            this.jvU.h((n) this.jtS);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.jvY = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.jvZ = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.jwb = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0582g interfaceC0582g) {
        this.jwa = interfaceC0582g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jwc = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.jwd = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jvS = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.OG = str2;
            this.mOriginUrl = str;
            String GL = GL(str);
            if (eaW != null) {
                this.jtO = eaW.ap(this.OG, this.mOriginUrl, null);
                if (this.jtO != null) {
                    this.jtO.oN(CyberPlayerManager.hasCacheFile(GL));
                }
            }
            if (this.jtS != null && this.jtS.cxh() != null) {
                this.jtS.cxh().setPlayer(this);
            }
            this.jvU.cxW();
            setVideoPath(GL);
            if (this.jtO != null) {
                this.jtO.ceY();
            }
            this.jvW = true;
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            if (!cxv()) {
                aVar.cxY();
            }
            if (!cxu()) {
                aVar.cxZ();
                this.jvT = true;
                setVideoPath(this.mOriginUrl, this.OG);
                return;
            }
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.jvV) {
            af.a(this.OC, true);
            setVolume(1.0f, 1.0f);
        }
        this.jvT = true;
        super.start();
        if (this.jvU != null) {
            this.jvU.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().yc(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jvT) {
            b(aVar);
            return;
        }
        this.jvT = true;
        if (aVar != null) {
            this.juj = true;
            if (!cxv()) {
                aVar.cxY();
            }
        } else {
            this.juj = false;
        }
        setVideoPath(this.mOriginUrl, this.OG);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.OC, false);
        if (isPlaying() && cxs()) {
            x.cxU().bn(this.mOriginUrl, getCurrentPositionSync());
        }
        super.pause();
        if (this.jvU != null) {
            this.jvU.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jtO != null) {
            this.jtO.cfd();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.juj) {
            stopPlayback();
            return;
        }
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.OC, false);
        }
        this.jvT = false;
        if (isPlaying() && cxs()) {
            x.cxU().bn(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.jvU != null) {
            this.jvU.onStop();
        }
        if (this.jtO != null && this.jtO.EP(getLocateSource())) {
            this.jtO = null;
        }
        this.jvW = false;
        this.jvX = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.OC, false);
        }
        this.jvT = false;
        if (isPlaying() && cxs()) {
            x.cxU().bn(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cxX().GR(this.mOriginUrl);
        if (this.jvU != null) {
            this.jvU.onStop();
        }
        if (this.jtO != null && this.jtO.EP(getLocateSource())) {
            this.jtO = null;
        }
        this.jvW = false;
        this.jvX = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dRk);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jwd != null) {
            this.jwd.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.dRk);
    }

    private String GL(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cNI().cNJ()) {
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
    public boolean cxq() {
        return this.jvT;
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.jtO != null) {
            this.jtO.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxs() {
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
        this.jvU.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.jvU.setVideoSize(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.jtS instanceof n) || ((n) this.jtS).cxE() == null) ? "" : ((n) this.jtS).cxE().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.jtO != null) {
            return this.jtO;
        }
        if (!StringUtils.isNull(this.mOriginUrl) && eaW != null) {
            this.jtO = eaW.ap(this.OG, this.mOriginUrl, null);
        }
        return this.jtO;
    }

    private boolean cxu() {
        return this == TbVideoViewSet.cxX().GQ(this.mOriginUrl);
    }

    private boolean cxv() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cxt() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.jvZ = null;
        this.jwb = null;
        this.jwc = null;
        this.jvY = null;
        this.jwa = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.juj = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.jvX = true;
        super.seekTo(i);
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cxp() {
        this.jvW = false;
        if (this.jvU != null) {
            this.jvU.eB(getDuration());
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().yb(-400);
        }
    }
}
