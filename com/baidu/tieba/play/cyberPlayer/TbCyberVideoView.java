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
    private i jtT;
    private d jtX;
    private boolean juo;
    private boolean jvX;
    private boolean jvY;
    private a jvZ;
    private boolean jwa;
    private boolean jwb;
    private boolean jwc;
    private g.f jwd;
    private g.a jwe;
    private g.InterfaceC0582g jwf;
    private g.b jwg;
    private g.e jwh;
    private QuickVideoView.b jwi;
    private CyberPlayerManager.OnPreparedListener jwj;
    private CyberPlayerManager.OnCompletionListener jwk;
    private CyberPlayerManager.OnErrorListener jwl;
    private CyberPlayerManager.OnSeekCompleteListener jwm;
    private CyberPlayerManager.OnInfoListener jwn;
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
        this.jwa = false;
        this.jwb = false;
        this.jwc = false;
        this.juo = false;
        this.jwj = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int GP;
                TbCyberVideoView.this.cxr();
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cxZ().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jwd != null) {
                        TbCyberVideoView.this.jwd.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jvX && (GP = x.cxW().GP(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(GP);
                    }
                    if (TbCyberVideoView.this.jvY) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jwk = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jtT != null) {
                    TbCyberVideoView.this.jtT.EO(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtT = null;
                }
                x.cxW().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jvZ != null) {
                        TbCyberVideoView.this.jvZ.onComplete();
                    }
                    TbCyberVideoView.this.jvY = false;
                    if (TbCyberVideoView.this.jwe != null) {
                        TbCyberVideoView.this.jwe.onCompletion(null);
                    }
                }
            }
        };
        this.jwl = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jtX != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cxu()) {
                    x.cxW().bn(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxZ().GR(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwg == null || !TbCyberVideoView.this.jwg.onError(null, i, i2)) {
                    TbCyberVideoView.this.jwc = false;
                    TbCyberVideoView.this.jwb = false;
                }
                return true;
            }
        };
        this.jwm = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jwc = false;
                if (TbCyberVideoView.this.jwf != null) {
                    TbCyberVideoView.this.jwf.b(null);
                }
            }
        };
        this.jwn = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwh != null) {
                    TbCyberVideoView.this.jwh.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jwc && !TbCyberVideoView.this.jwb && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cfb();
                    TbCyberVideoView.this.getVideoMonitor().cfc();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jvZ.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.jtT != null) {
                    TbCyberVideoView.this.jtT.EN(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtT = null;
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.OC = null;
        this.jwa = false;
        this.jwb = false;
        this.jwc = false;
        this.juo = false;
        this.jwj = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int GP;
                TbCyberVideoView.this.cxr();
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cxZ().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jwd != null) {
                        TbCyberVideoView.this.jwd.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jvX && (GP = x.cxW().GP(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(GP);
                    }
                    if (TbCyberVideoView.this.jvY) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jwk = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jtT != null) {
                    TbCyberVideoView.this.jtT.EO(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtT = null;
                }
                x.cxW().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jvZ != null) {
                        TbCyberVideoView.this.jvZ.onComplete();
                    }
                    TbCyberVideoView.this.jvY = false;
                    if (TbCyberVideoView.this.jwe != null) {
                        TbCyberVideoView.this.jwe.onCompletion(null);
                    }
                }
            }
        };
        this.jwl = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jtX != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cxu()) {
                    x.cxW().bn(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxZ().GR(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jwg == null || !TbCyberVideoView.this.jwg.onError(null, i, i2)) {
                    TbCyberVideoView.this.jwc = false;
                    TbCyberVideoView.this.jwb = false;
                }
                return true;
            }
        };
        this.jwm = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jwc = false;
                if (TbCyberVideoView.this.jwf != null) {
                    TbCyberVideoView.this.jwf.b(null);
                }
            }
        };
        this.jwn = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwh != null) {
                    TbCyberVideoView.this.jwh.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jwc && !TbCyberVideoView.this.jwb && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cfb();
                    TbCyberVideoView.this.getVideoMonitor().cfc();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jvZ.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.jtT != null) {
                    TbCyberVideoView.this.jtT.EN(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jtT = null;
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
        setOnPreparedListener(this.jwj);
        setOnCompletionListener(this.jwk);
        setOnErrorListener(this.jwl);
        setOnSeekCompleteListener(this.jwm);
        setOnInfoListener(this.jwn);
        this.jvZ = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.jwa = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.OC, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.jwa = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.jtX = dVar;
        if ((this.jtX instanceof n) && ((n) this.jtX).cxG() != null) {
            this.jvZ.h((n) this.jtX);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.jwd = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.jwe = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.jwg = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0582g interfaceC0582g) {
        this.jwf = interfaceC0582g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jwh = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.jwi = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jvX = z;
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
                this.jtT = eaW.ap(this.OG, this.mOriginUrl, null);
                if (this.jtT != null) {
                    this.jtT.oN(CyberPlayerManager.hasCacheFile(GL));
                }
            }
            if (this.jtX != null && this.jtX.cxj() != null) {
                this.jtX.cxj().setPlayer(this);
            }
            this.jvZ.cxY();
            setVideoPath(GL);
            if (this.jtT != null) {
                this.jtT.ceY();
            }
            this.jwb = true;
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            if (!cxx()) {
                aVar.cya();
            }
            if (!cxw()) {
                aVar.cyb();
                this.jvY = true;
                setVideoPath(this.mOriginUrl, this.OG);
                return;
            }
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.jwa) {
            af.a(this.OC, true);
            setVolume(1.0f, 1.0f);
        }
        this.jvY = true;
        super.start();
        if (this.jvZ != null) {
            this.jvZ.onStart();
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
        if (isPlaying() || this.jvY) {
            b(aVar);
            return;
        }
        this.jvY = true;
        if (aVar != null) {
            this.juo = true;
            if (!cxx()) {
                aVar.cya();
            }
        } else {
            this.juo = false;
        }
        setVideoPath(this.mOriginUrl, this.OG);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.OC, false);
        if (isPlaying() && cxu()) {
            x.cxW().bn(this.mOriginUrl, getCurrentPositionSync());
        }
        super.pause();
        if (this.jvZ != null) {
            this.jvZ.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jtT != null) {
            this.jtT.cfd();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.juo) {
            stopPlayback();
            return;
        }
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.OC, false);
        }
        this.jvY = false;
        if (isPlaying() && cxu()) {
            x.cxW().bn(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.jvZ != null) {
            this.jvZ.onStop();
        }
        if (this.jtT != null && this.jtT.EP(getLocateSource())) {
            this.jtT = null;
        }
        this.jwb = false;
        this.jwc = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.OC, false);
        }
        this.jvY = false;
        if (isPlaying() && cxu()) {
            x.cxW().bn(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cxZ().GR(this.mOriginUrl);
        if (this.jvZ != null) {
            this.jvZ.onStop();
        }
        if (this.jtT != null && this.jtT.EP(getLocateSource())) {
            this.jtT = null;
        }
        this.jwb = false;
        this.jwc = false;
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
        if (this.jwi != null) {
            this.jwi.onSurfaceDestroyed();
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
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cNK().cNL()) {
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
    public boolean cxs() {
        return this.jvY;
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.jtT != null) {
            this.jtT.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxu() {
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
        this.jvZ.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.jvZ.setVideoSize(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.jtX instanceof n) || ((n) this.jtX).cxG() == null) ? "" : ((n) this.jtX).cxG().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.jtT != null) {
            return this.jtT;
        }
        if (!StringUtils.isNull(this.mOriginUrl) && eaW != null) {
            this.jtT = eaW.ap(this.OG, this.mOriginUrl, null);
        }
        return this.jtT;
    }

    private boolean cxw() {
        return this == TbVideoViewSet.cxZ().GQ(this.mOriginUrl);
    }

    private boolean cxx() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cxv() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.jwe = null;
        this.jwg = null;
        this.jwh = null;
        this.jwd = null;
        this.jwf = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.juo = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.jwc = true;
        super.seekTo(i);
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cxr() {
        this.jwb = false;
        if (this.jvZ != null) {
            this.jvZ.eB(getDuration());
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().yb(-400);
        }
    }
}
