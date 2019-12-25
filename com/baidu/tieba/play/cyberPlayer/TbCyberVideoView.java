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
    private static l eaN;
    private String OC;
    private WeakReference<Context> Oy;
    private final CustomMessageListener dRb;
    private boolean jqI;
    private i jqn;
    private d jqr;
    private g.e jsA;
    private QuickVideoView.b jsB;
    private CyberPlayerManager.OnPreparedListener jsC;
    private CyberPlayerManager.OnCompletionListener jsD;
    private CyberPlayerManager.OnErrorListener jsE;
    private CyberPlayerManager.OnSeekCompleteListener jsF;
    private CyberPlayerManager.OnInfoListener jsG;
    private boolean jsq;
    private boolean jsr;
    private a jss;
    private boolean jst;
    private boolean jsu;
    private boolean jsv;
    private g.f jsw;
    private g.a jsx;
    private g.InterfaceC0577g jsy;
    private g.b jsz;
    private String mOriginUrl;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            eaN = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.Oy = null;
        this.jst = false;
        this.jsu = false;
        this.jsv = false;
        this.jqI = false;
        this.jsC = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int GF;
                TbCyberVideoView.this.cwi();
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cwQ().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jsw != null) {
                        TbCyberVideoView.this.jsw.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jsq && (GF = x.cwN().GF(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(GF);
                    }
                    if (TbCyberVideoView.this.jsr) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jsD = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jqn != null) {
                    TbCyberVideoView.this.jqn.EE(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jqn = null;
                }
                x.cwN().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jss != null) {
                        TbCyberVideoView.this.jss.onComplete();
                    }
                    TbCyberVideoView.this.jsr = false;
                    if (TbCyberVideoView.this.jsx != null) {
                        TbCyberVideoView.this.jsx.onCompletion(null);
                    }
                }
            }
        };
        this.jsE = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jqr != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cwl()) {
                    x.cwN().bm(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cwQ().GH(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jsz == null || !TbCyberVideoView.this.jsz.onError(null, i, i2)) {
                    TbCyberVideoView.this.jsv = false;
                    TbCyberVideoView.this.jsu = false;
                }
                return true;
            }
        };
        this.jsF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jsv = false;
                if (TbCyberVideoView.this.jsy != null) {
                    TbCyberVideoView.this.jsy.b(null);
                }
            }
        };
        this.jsG = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jsA != null) {
                    TbCyberVideoView.this.jsA.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jsv && !TbCyberVideoView.this.jsu && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cdS();
                    TbCyberVideoView.this.getVideoMonitor().cdT();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jss.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.jqn != null) {
                    TbCyberVideoView.this.jqn.ED(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jqn = null;
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.Oy = null;
        this.jst = false;
        this.jsu = false;
        this.jsv = false;
        this.jqI = false;
        this.jsC = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int GF;
                TbCyberVideoView.this.cwi();
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cwQ().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jsw != null) {
                        TbCyberVideoView.this.jsw.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jsq && (GF = x.cwN().GF(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(GF);
                    }
                    if (TbCyberVideoView.this.jsr) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jsD = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jqn != null) {
                    TbCyberVideoView.this.jqn.EE(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jqn = null;
                }
                x.cwN().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jss != null) {
                        TbCyberVideoView.this.jss.onComplete();
                    }
                    TbCyberVideoView.this.jsr = false;
                    if (TbCyberVideoView.this.jsx != null) {
                        TbCyberVideoView.this.jsx.onCompletion(null);
                    }
                }
            }
        };
        this.jsE = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jqr != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cwl()) {
                    x.cwN().bm(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cwQ().GH(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jsz == null || !TbCyberVideoView.this.jsz.onError(null, i, i2)) {
                    TbCyberVideoView.this.jsv = false;
                    TbCyberVideoView.this.jsu = false;
                }
                return true;
            }
        };
        this.jsF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jsv = false;
                if (TbCyberVideoView.this.jsy != null) {
                    TbCyberVideoView.this.jsy.b(null);
                }
            }
        };
        this.jsG = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jsA != null) {
                    TbCyberVideoView.this.jsA.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jsv && !TbCyberVideoView.this.jsu && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().cdS();
                    TbCyberVideoView.this.getVideoMonitor().cdT();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jss.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && TbCyberVideoView.this.jqn != null) {
                    TbCyberVideoView.this.jqn.ED(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jqn = null;
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
        setOnPreparedListener(this.jsC);
        setOnCompletionListener(this.jsD);
        setOnErrorListener(this.jsE);
        setOnSeekCompleteListener(this.jsF);
        setOnInfoListener(this.jsG);
        this.jss = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.jst = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.Oy, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.jst = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.jqr = dVar;
        if ((this.jqr instanceof n) && ((n) this.jqr).cwx() != null) {
            this.jss.h((n) this.jqr);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.jsw = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.jsx = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.jsz = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0577g interfaceC0577g) {
        this.jsy = interfaceC0577g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jsA = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.jsB = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jsq = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.OC = str2;
            this.mOriginUrl = str;
            String GB = GB(str);
            if (eaN != null) {
                this.jqn = eaN.ao(this.OC, this.mOriginUrl, null);
                if (this.jqn != null) {
                    this.jqn.oB(CyberPlayerManager.hasCacheFile(GB));
                }
            }
            if (this.jqr != null && this.jqr.cwa() != null) {
                this.jqr.cwa().setPlayer(this);
            }
            this.jss.cwP();
            setVideoPath(GB);
            if (this.jqn != null) {
                this.jqn.cdP();
            }
            this.jsu = true;
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            if (!cwo()) {
                aVar.cwR();
            }
            if (!cwn()) {
                aVar.cwS();
                this.jsr = true;
                setVideoPath(this.mOriginUrl, this.OC);
                return;
            }
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.jst) {
            af.a(this.Oy, true);
            setVolume(1.0f, 1.0f);
        }
        this.jsr = true;
        super.start();
        if (this.jss != null) {
            this.jss.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().xX(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jsr) {
            b(aVar);
            return;
        }
        this.jsr = true;
        if (aVar != null) {
            this.jqI = true;
            if (!cwo()) {
                aVar.cwR();
            }
        } else {
            this.jqI = false;
        }
        setVideoPath(this.mOriginUrl, this.OC);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.Oy, false);
        if (isPlaying() && cwl()) {
            x.cwN().bm(this.mOriginUrl, getCurrentPositionSync());
        }
        super.pause();
        if (this.jss != null) {
            this.jss.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jqn != null) {
            this.jqn.cdU();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jqI) {
            stopPlayback();
            return;
        }
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Oy, false);
        }
        this.jsr = false;
        if (isPlaying() && cwl()) {
            x.cwN().bm(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.jss != null) {
            this.jss.onStop();
        }
        if (this.jqn != null && this.jqn.EF(getLocateSource())) {
            this.jqn = null;
        }
        this.jsu = false;
        this.jsv = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Oy, false);
        }
        this.jsr = false;
        if (isPlaying() && cwl()) {
            x.cwN().bm(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cwQ().GH(this.mOriginUrl);
        if (this.jss != null) {
            this.jss.onStop();
        }
        if (this.jqn != null && this.jqn.EF(getLocateSource())) {
            this.jqn = null;
        }
        this.jsu = false;
        this.jsv = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dRb);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jsB != null) {
            this.jsB.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.dRb);
    }

    private String GB(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cMD().cME()) {
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
    public boolean cwj() {
        return this.jsr;
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.jqn != null) {
            this.jqn.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwl() {
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
        this.jss.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.jss.setVideoSize(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.jqr instanceof n) || ((n) this.jqr).cwx() == null) ? "" : ((n) this.jqr).cwx().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.jqn != null) {
            return this.jqn;
        }
        if (!StringUtils.isNull(this.mOriginUrl) && eaN != null) {
            this.jqn = eaN.ao(this.OC, this.mOriginUrl, null);
        }
        return this.jqn;
    }

    private boolean cwn() {
        return this == TbVideoViewSet.cwQ().GG(this.mOriginUrl);
    }

    private boolean cwo() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cwm() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.jsx = null;
        this.jsz = null;
        this.jsA = null;
        this.jsw = null;
        this.jsy = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jqI = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.jsv = true;
        super.seekTo(i);
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cwi() {
        this.jsu = false;
        if (this.jss != null) {
            this.jss.ew(getDuration());
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().xW(-400);
        }
    }
}
