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
import com.baidu.tbadk.TbSingleton;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements com.baidu.tieba.play.a.a {
    private static l eFt;
    private WeakReference<Context> ahH;
    private String ahL;
    private final CustomMessageListener evS;
    private boolean jci;
    private boolean jcj;
    private boolean kgJ;
    private i kgo;
    private d kgs;
    private boolean kiA;
    private String kiB;
    private boolean kiC;
    private b kiD;
    private boolean kiE;
    private int kiF;
    private g.f kiG;
    private g.a kiH;
    private g.InterfaceC0630g kiI;
    private g.b kiJ;
    private g.e kiK;
    private QuickVideoView.b kiL;
    private CyberPlayerManager.OnPreparedListener kiM;
    private CyberPlayerManager.OnCompletionListener kiN;
    private CyberPlayerManager.OnErrorListener kiO;
    private CyberPlayerManager.OnSeekCompleteListener kiP;
    private CyberPlayerManager.OnInfoListener kiQ;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            eFt = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.ahH = null;
        this.kiE = false;
        this.kgJ = false;
        this.kiM = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int IL;
                if (TbCyberVideoView.this.kiD != null) {
                    TbCyberVideoView.this.kiD.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yQ(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cKw().a(TbCyberVideoView.this, TbCyberVideoView.this.kiB);
                    if (TbCyberVideoView.this.kiG != null) {
                        TbCyberVideoView.this.kiG.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kiA && (IL = x.cKr().IL(TbCyberVideoView.this.kiB)) > 0) {
                        TbCyberVideoView.this.seekTo(IL);
                    }
                    if (TbCyberVideoView.this.kiC) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kiN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kgo != null) {
                    TbCyberVideoView.this.kgo.GM(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kgo = null;
                }
                x.cKr().remove(TbCyberVideoView.this.kiB);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kiD != null) {
                        TbCyberVideoView.this.kiD.onComplete();
                    }
                    TbCyberVideoView.this.kiC = false;
                    if (TbCyberVideoView.this.kiH != null) {
                        TbCyberVideoView.this.kiH.onCompletion(null);
                    }
                }
            }
        };
        this.kiO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kgs != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cJP()) {
                    x.cKr().bv(TbCyberVideoView.this.kiB, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKw().IN(TbCyberVideoView.this.kiB);
                if (TbCyberVideoView.this.kiJ == null || TbCyberVideoView.this.kiJ.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kiP = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kiI != null) {
                    TbCyberVideoView.this.kiI.b(null);
                }
            }
        };
        this.kiQ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kiK != null) {
                    TbCyberVideoView.this.kiK.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kiD.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.evS = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kgo != null) {
                        TbCyberVideoView.this.kgo.GL(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kgo = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.ahH = null;
        this.kiE = false;
        this.kgJ = false;
        this.kiM = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int IL;
                if (TbCyberVideoView.this.kiD != null) {
                    TbCyberVideoView.this.kiD.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yQ(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cKw().a(TbCyberVideoView.this, TbCyberVideoView.this.kiB);
                    if (TbCyberVideoView.this.kiG != null) {
                        TbCyberVideoView.this.kiG.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kiA && (IL = x.cKr().IL(TbCyberVideoView.this.kiB)) > 0) {
                        TbCyberVideoView.this.seekTo(IL);
                    }
                    if (TbCyberVideoView.this.kiC) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kiN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kgo != null) {
                    TbCyberVideoView.this.kgo.GM(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kgo = null;
                }
                x.cKr().remove(TbCyberVideoView.this.kiB);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kiD != null) {
                        TbCyberVideoView.this.kiD.onComplete();
                    }
                    TbCyberVideoView.this.kiC = false;
                    if (TbCyberVideoView.this.kiH != null) {
                        TbCyberVideoView.this.kiH.onCompletion(null);
                    }
                }
            }
        };
        this.kiO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kgs != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cJP()) {
                    x.cKr().bv(TbCyberVideoView.this.kiB, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKw().IN(TbCyberVideoView.this.kiB);
                if (TbCyberVideoView.this.kiJ == null || TbCyberVideoView.this.kiJ.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kiP = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kiI != null) {
                    TbCyberVideoView.this.kiI.b(null);
                }
            }
        };
        this.kiQ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kiK != null) {
                    TbCyberVideoView.this.kiK.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kiD.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.evS = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kgo != null) {
                        TbCyberVideoView.this.kgo.GL(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kgo = null;
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
        this.ahH = new WeakReference<>(TbadkCoreApplication.getInst());
        setOnPreparedListener(this.kiM);
        setOnCompletionListener(this.kiN);
        setOnErrorListener(this.kiO);
        setOnSeekCompleteListener(this.kiP);
        setOnInfoListener(this.kiQ);
        this.kiD = new b();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void w(Uri uri) {
        a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.cKt() && pcdnConfigData.v(uri) && c.cKB() > 0) {
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
            setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.cKu() ? "1" : "0");
            setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.cKB()));
            this.jci = true;
            this.jcj = pcdnConfigData.cKu();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.kiE = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.ahH, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.kiE = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kgs = dVar;
        if ((this.kgs instanceof n) && ((n) this.kgs).cKb() != null) {
            this.kiD.h((n) this.kgs);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.kiG = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.kiH = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.kiJ = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0630g interfaceC0630g) {
        this.kiI = interfaceC0630g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kiK = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.kiL = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kiA = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kiB;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.kiF = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.ahL = str2;
            this.kiB = str;
            String IH = IH(str);
            if (eFt != null) {
                this.kgo = eFt.ap(this.ahL, this.kiB, null);
                if (this.kgo != null) {
                    this.kgo.qa(CyberPlayerManager.hasCacheFile(IH));
                }
            }
            if (this.kgs != null && this.kgs.cJD() != null) {
                this.kgs.cJD().setPlayer(this);
            }
            this.kiD.cKv();
            w(Uri.parse(IH));
            if (this.kgo != null) {
                this.kgo.crG();
            }
            String host = Uri.parse(this.kiB).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.kiF < 900)) ? "1" : "0");
            setVideoPath(IH);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.kgJ = true;
            if (!cJS()) {
                aVar.cKx();
            }
            if (!cJR()) {
                aVar.cKy();
                this.kiC = true;
                setVideoPath(this.kiB, this.ahL);
                return;
            }
        } else {
            this.kgJ = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.kiE) {
            af.a(this.ahH, true);
            setVolume(1.0f, 1.0f);
        }
        this.kiC = true;
        super.start();
        if (this.kiD != null) {
            this.kiD.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().yS(-400);
            getVideoMonitor().Z(this.jci, this.jcj);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kiC) {
            b(aVar);
            return;
        }
        this.kiC = true;
        if (aVar != null) {
            this.kgJ = true;
            if (!cJS()) {
                aVar.cKx();
            }
        } else {
            this.kgJ = false;
        }
        setVideoPath(this.kiB, this.ahL);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.ahH, false);
        if (isPlaying() && cJP()) {
            x.cKr().bv(this.kiB, getCurrentPositionSync());
        }
        super.pause();
        if (this.kiD != null) {
            this.kiD.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kgo != null) {
            this.kgo.crL();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kgJ) {
            stopPlayback();
            return;
        }
        if (this.kiB != null && isPlaying()) {
            af.a(this.ahH, false);
        }
        this.kiC = false;
        if (isPlaying() && cJP()) {
            x.cKr().bv(this.kiB, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.kiD != null) {
            this.kiD.onStop();
        }
        if (this.kgo != null && this.kgo.GN(getLocateSource())) {
            this.kgo = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.kiB != null && isPlaying()) {
            af.a(this.ahH, false);
        }
        this.kiC = false;
        if (isPlaying() && cJP()) {
            x.cKr().bv(this.kiB, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cKw().IN(this.kiB);
        if (this.kiD != null) {
            this.kiD.onStop();
        }
        if (this.kgo != null && this.kgo.GN(getLocateSource())) {
            this.kgo = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.evS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kiL != null) {
            this.kiL.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.evS);
    }

    private String IH(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.day().daz()) {
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
    public boolean cJN() {
        return this.kiC;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kgo != null) {
            this.kgo.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJP() {
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
        if (!(this.kgs instanceof n) || ((n) this.kgs).cKb() == null) {
            return "";
        }
        return ((n) this.kgs).kho ? "v_mid_page" : ((n) this.kgs).cKb().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.kgo != null) {
            return this.kgo;
        }
        if (!StringUtils.isNull(this.kiB) && eFt != null) {
            this.kgo = eFt.ap(this.ahL, this.kiB, null);
        }
        return this.kgo;
    }

    private boolean cJR() {
        return this == TbVideoViewSet.cKw().IM(this.kiB);
    }

    private boolean cJS() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cJQ() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.kiL = null;
        this.kiH = null;
        this.kiJ = null;
        this.kiK = null;
        this.kiG = null;
        this.kiI = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kgJ = z;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJL() {
        if (this.kiD != null) {
            this.kiD.cKv();
            this.kiD.fl(getDuration());
            this.kiD.a(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().qa(CyberPlayerManager.hasCacheFile(this.kiB));
            getVideoMonitor().yR(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJM() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().qa(CyberPlayerManager.hasCacheFile(this.kiB));
            getVideoMonitor().crG();
            getVideoMonitor().yQ(-400);
        }
    }
}
