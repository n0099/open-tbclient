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
    private static l efD;
    private WeakReference<Context> Pg;
    private String Pk;
    private final CustomMessageListener dVT;
    private boolean jwP;
    private i jwu;
    private d jwy;
    private boolean jyA;
    private boolean jyB;
    private a jyC;
    private boolean jyD;
    private boolean jyE;
    private boolean jyF;
    private int jyG;
    private g.f jyH;
    private g.a jyI;
    private g.InterfaceC0591g jyJ;
    private g.b jyK;
    private g.e jyL;
    private QuickVideoView.b jyM;
    private CyberPlayerManager.OnPreparedListener jyN;
    private CyberPlayerManager.OnCompletionListener jyO;
    private CyberPlayerManager.OnErrorListener jyP;
    private CyberPlayerManager.OnSeekCompleteListener jyQ;
    private CyberPlayerManager.OnInfoListener jyR;
    private String mOriginUrl;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            efD = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.Pg = null;
        this.jyD = false;
        this.jyE = false;
        this.jyF = false;
        this.jwP = false;
        this.jyN = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int He;
                TbCyberVideoView.this.jyE = false;
                if (TbCyberVideoView.this.jyC != null) {
                    TbCyberVideoView.this.jyC.ez(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yp(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czP().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jyH != null) {
                        TbCyberVideoView.this.jyH.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jyA && (He = x.czM().He(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(He);
                    }
                    if (TbCyberVideoView.this.jyB) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jyO = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jwu != null) {
                    TbCyberVideoView.this.jwu.Ff(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jwu = null;
                }
                x.czM().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jyC != null) {
                        TbCyberVideoView.this.jyC.onComplete();
                    }
                    TbCyberVideoView.this.jyB = false;
                    if (TbCyberVideoView.this.jyI != null) {
                        TbCyberVideoView.this.jyI.onCompletion(null);
                    }
                }
            }
        };
        this.jyP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwy != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.czk()) {
                    x.czM().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czP().Hg(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jyK == null || !TbCyberVideoView.this.jyK.onError(null, i, i2)) {
                    TbCyberVideoView.this.jyF = false;
                    TbCyberVideoView.this.jyE = false;
                }
                return true;
            }
        };
        this.jyQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jyF = false;
                if (TbCyberVideoView.this.jyJ != null) {
                    TbCyberVideoView.this.jyJ.b(null);
                }
            }
        };
        this.jyR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jyL != null) {
                    TbCyberVideoView.this.jyL.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jyF && !TbCyberVideoView.this.jyE && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().chc();
                    TbCyberVideoView.this.getVideoMonitor().chd();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jyC.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.jwu != null) {
                        TbCyberVideoView.this.jwu.Fe(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.jwu = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.Pg = null;
        this.jyD = false;
        this.jyE = false;
        this.jyF = false;
        this.jwP = false;
        this.jyN = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int He;
                TbCyberVideoView.this.jyE = false;
                if (TbCyberVideoView.this.jyC != null) {
                    TbCyberVideoView.this.jyC.ez(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yp(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.czP().a(TbCyberVideoView.this, TbCyberVideoView.this.mOriginUrl);
                    if (TbCyberVideoView.this.jyH != null) {
                        TbCyberVideoView.this.jyH.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.jyA && (He = x.czM().He(TbCyberVideoView.this.mOriginUrl)) > 0) {
                        TbCyberVideoView.this.seekTo(He);
                    }
                    if (TbCyberVideoView.this.jyB) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.jyO = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.jwu != null) {
                    TbCyberVideoView.this.jwu.Ff(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.jwu = null;
                }
                x.czM().remove(TbCyberVideoView.this.mOriginUrl);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.jyC != null) {
                        TbCyberVideoView.this.jyC.onComplete();
                    }
                    TbCyberVideoView.this.jyB = false;
                    if (TbCyberVideoView.this.jyI != null) {
                        TbCyberVideoView.this.jyI.onCompletion(null);
                    }
                }
            }
        };
        this.jyP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jwy != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.czk()) {
                    x.czM().bl(TbCyberVideoView.this.mOriginUrl, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czP().Hg(TbCyberVideoView.this.mOriginUrl);
                if (TbCyberVideoView.this.jyK == null || !TbCyberVideoView.this.jyK.onError(null, i, i2)) {
                    TbCyberVideoView.this.jyF = false;
                    TbCyberVideoView.this.jyE = false;
                }
                return true;
            }
        };
        this.jyQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                TbCyberVideoView.this.jyF = false;
                if (TbCyberVideoView.this.jyJ != null) {
                    TbCyberVideoView.this.jyJ.b(null);
                }
            }
        };
        this.jyR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.jyL != null) {
                    TbCyberVideoView.this.jyL.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && !TbCyberVideoView.this.jyF && !TbCyberVideoView.this.jyE && i == 925) {
                    TbCyberVideoView.this.getVideoMonitor().chc();
                    TbCyberVideoView.this.getVideoMonitor().chd();
                }
                if (i == 904) {
                    TbCyberVideoView.this.jyC.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.dVT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.jwu != null) {
                        TbCyberVideoView.this.jwu.Fe(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.jwu = null;
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
        this.Pg = new WeakReference<>(TbadkCoreApplication.getInst());
        setOnPreparedListener(this.jyN);
        setOnCompletionListener(this.jyO);
        setOnErrorListener(this.jyP);
        setOnSeekCompleteListener(this.jyQ);
        setOnInfoListener(this.jyR);
        this.jyC = new a();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.jyD = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.Pg, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.jyD = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.jwy = dVar;
        if ((this.jwy instanceof n) && ((n) this.jwy).czw() != null) {
            this.jyC.h((n) this.jwy);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.jyH = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.jyI = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.jyK = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0591g interfaceC0591g) {
        this.jyJ = interfaceC0591g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jyL = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.jyM = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jyA = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.jyG = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.Pk = str2;
            this.mOriginUrl = str;
            String Ha = Ha(str);
            if (efD != null) {
                this.jwu = efD.ap(this.Pk, this.mOriginUrl, null);
                if (this.jwu != null) {
                    this.jwu.oW(CyberPlayerManager.hasCacheFile(Ha));
                }
            }
            if (this.jwy != null && this.jwy.cyY() != null) {
                this.jwy.cyY().setPlayer(this);
            }
            this.jyC.czO();
            String host = Uri.parse(this.mOriginUrl).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.jyG < 900)) ? "1" : "0");
            setVideoPath(Ha);
            if (this.jwu != null) {
                this.jwu.cgZ();
            }
            this.jyE = true;
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.jwP = true;
            if (!czn()) {
                aVar.czQ();
            }
            if (!czm()) {
                aVar.czR();
                this.jyB = true;
                setVideoPath(this.mOriginUrl, this.Pk);
                return;
            }
        } else {
            this.jwP = false;
        }
        start();
        if (this.jwP) {
            this.jyC.a(this);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.jyD) {
            af.a(this.Pg, true);
            setVolume(1.0f, 1.0f);
        }
        this.jyB = true;
        super.start();
        if (this.jyC != null) {
            this.jyC.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().yr(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jyB) {
            b(aVar);
            return;
        }
        this.jyB = true;
        if (aVar != null) {
            this.jwP = true;
            if (!czn()) {
                aVar.czQ();
            }
        } else {
            this.jwP = false;
        }
        setVideoPath(this.mOriginUrl, this.Pk);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.Pg, false);
        if (isPlaying() && czk()) {
            x.czM().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        super.pause();
        if (this.jyC != null) {
            this.jyC.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jwu != null) {
            this.jwu.che();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jwP) {
            stopPlayback();
            return;
        }
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pg, false);
        }
        this.jyB = false;
        if (isPlaying() && czk()) {
            x.czM().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.jyC != null) {
            this.jyC.onStop();
        }
        if (this.jwu != null && this.jwu.Fg(getLocateSource())) {
            this.jwu = null;
        }
        this.jyE = false;
        this.jyF = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.mOriginUrl != null && isPlaying()) {
            af.a(this.Pg, false);
        }
        this.jyB = false;
        if (isPlaying() && czk()) {
            x.czM().bl(this.mOriginUrl, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.czP().Hg(this.mOriginUrl);
        if (this.jyC != null) {
            this.jyC.onStop();
        }
        if (this.jwu != null && this.jwu.Fg(getLocateSource())) {
            this.jwu = null;
        }
        this.jyE = false;
        this.jyF = false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jyM != null) {
            this.jyM.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.dVT);
    }

    private String Ha(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPC().cPD()) {
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
    public boolean czi() {
        return this.jyB;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.jwu != null) {
            this.jwu.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czk() {
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
        if (!(this.jwy instanceof n) || ((n) this.jwy).czw() == null) {
            return "";
        }
        return ((n) this.jwy).jxt ? "v_mid_page" : ((n) this.jwy).czw().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.jwu != null) {
            return this.jwu;
        }
        if (!StringUtils.isNull(this.mOriginUrl) && efD != null) {
            this.jwu = efD.ap(this.Pk, this.mOriginUrl, null);
        }
        return this.jwu;
    }

    private boolean czm() {
        return this == TbVideoViewSet.czP().Hf(this.mOriginUrl);
    }

    private boolean czn() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void czl() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.jyM = null;
        this.jyI = null;
        this.jyK = null;
        this.jyL = null;
        this.jyH = null;
        this.jyJ = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jwP = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        this.jyF = true;
        super.seekTo(i);
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void czg() {
        this.jyE = false;
        if (this.jyC != null) {
            this.jyC.czO();
            this.jyC.ez(getDuration());
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().oW(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().yq(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void czh() {
        this.jyE = false;
        if (getVideoMonitor() != null) {
            getVideoMonitor().oW(CyberPlayerManager.hasCacheFile(this.mOriginUrl));
            getVideoMonitor().cgZ();
            getVideoMonitor().yp(-400);
        }
    }
}
