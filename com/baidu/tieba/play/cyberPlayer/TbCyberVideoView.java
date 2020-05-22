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
import com.baidu.tbadk.util.ag;
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
    private static l kyj;
    private WeakReference<Context> aio;
    private String ais;
    private final CustomMessageListener eKz;
    private boolean jrp;
    private boolean jrq;
    private String kAA;
    private boolean kAB;
    private b kAC;
    private boolean kAD;
    private int kAE;
    private g.f kAF;
    private g.a kAG;
    private g.InterfaceC0704g kAH;
    private g.b kAI;
    private g.e kAJ;
    private QuickVideoView.b kAK;
    private CyberPlayerManager.OnPreparedListener kAL;
    private CyberPlayerManager.OnCompletionListener kAM;
    private CyberPlayerManager.OnErrorListener kAN;
    private CyberPlayerManager.OnSeekCompleteListener kAO;
    private CyberPlayerManager.OnInfoListener kAP;
    private boolean kAz;
    private boolean kyF;
    private i kyk;
    private d kyo;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            kyj = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.aio = null;
        this.kAD = false;
        this.kyF = false;
        this.kAL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int KA;
                if (TbCyberVideoView.this.kAC != null) {
                    TbCyberVideoView.this.kAC.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().zy(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cRt().a(TbCyberVideoView.this, TbCyberVideoView.this.kAA);
                    if (TbCyberVideoView.this.kAF != null) {
                        TbCyberVideoView.this.kAF.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kAz && (KA = x.cRo().KA(TbCyberVideoView.this.kAA)) > 0) {
                        TbCyberVideoView.this.seekTo(KA);
                    }
                    if (TbCyberVideoView.this.kAB) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kAM = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kyk != null) {
                    TbCyberVideoView.this.kyk.Iy(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kyk = null;
                }
                x.cRo().remove(TbCyberVideoView.this.kAA);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kAC != null) {
                        TbCyberVideoView.this.kAC.onComplete();
                    }
                    TbCyberVideoView.this.kAB = false;
                    if (TbCyberVideoView.this.kAG != null) {
                        TbCyberVideoView.this.kAG.onCompletion(null);
                    }
                }
            }
        };
        this.kAN = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kyo != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cQM()) {
                    x.cRo().bw(TbCyberVideoView.this.kAA, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRt().KC(TbCyberVideoView.this.kAA);
                if (TbCyberVideoView.this.kAI == null || TbCyberVideoView.this.kAI.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kAO = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kAH != null) {
                    TbCyberVideoView.this.kAH.b(null);
                }
            }
        };
        this.kAP = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kAJ != null) {
                    TbCyberVideoView.this.kAJ.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kAC.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.eKz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kyk != null) {
                        TbCyberVideoView.this.kyk.Ix(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kyk = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.aio = null;
        this.kAD = false;
        this.kyF = false;
        this.kAL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int KA;
                if (TbCyberVideoView.this.kAC != null) {
                    TbCyberVideoView.this.kAC.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().zy(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cRt().a(TbCyberVideoView.this, TbCyberVideoView.this.kAA);
                    if (TbCyberVideoView.this.kAF != null) {
                        TbCyberVideoView.this.kAF.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kAz && (KA = x.cRo().KA(TbCyberVideoView.this.kAA)) > 0) {
                        TbCyberVideoView.this.seekTo(KA);
                    }
                    if (TbCyberVideoView.this.kAB) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kAM = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kyk != null) {
                    TbCyberVideoView.this.kyk.Iy(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kyk = null;
                }
                x.cRo().remove(TbCyberVideoView.this.kAA);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kAC != null) {
                        TbCyberVideoView.this.kAC.onComplete();
                    }
                    TbCyberVideoView.this.kAB = false;
                    if (TbCyberVideoView.this.kAG != null) {
                        TbCyberVideoView.this.kAG.onCompletion(null);
                    }
                }
            }
        };
        this.kAN = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kyo != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cQM()) {
                    x.cRo().bw(TbCyberVideoView.this.kAA, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRt().KC(TbCyberVideoView.this.kAA);
                if (TbCyberVideoView.this.kAI == null || TbCyberVideoView.this.kAI.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kAO = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kAH != null) {
                    TbCyberVideoView.this.kAH.b(null);
                }
            }
        };
        this.kAP = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kAJ != null) {
                    TbCyberVideoView.this.kAJ.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kAC.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.eKz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kyk != null) {
                        TbCyberVideoView.this.kyk.Ix(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kyk = null;
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
        this.aio = new WeakReference<>(TbadkCoreApplication.getInst());
        setOnPreparedListener(this.kAL);
        setOnCompletionListener(this.kAM);
        setOnErrorListener(this.kAN);
        setOnSeekCompleteListener(this.kAO);
        setOnInfoListener(this.kAP);
        this.kAC = new b();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void z(Uri uri) {
        a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.cRq() && pcdnConfigData.y(uri) && c.cRy() > 0) {
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
            setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.cRr() ? "1" : "0");
            setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.cRy()));
            this.jrp = true;
            this.jrq = pcdnConfigData.cRr();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.kAD = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ag.a(this.aio, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.kAD = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kyo = dVar;
        if ((this.kyo instanceof n) && ((n) this.kyo).cQY() != null) {
            this.kAC.h((n) this.kyo);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.kAF = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.kAG = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.kAI = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0704g interfaceC0704g) {
        this.kAH = interfaceC0704g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kAJ = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.kAK = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kAz = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kAA;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.kAE = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.ais = str2;
            this.kAA = str;
            String Kw = Kw(str);
            if (kyj != null) {
                this.kyk = kyj.at(this.ais, this.kAA, null);
                if (this.kyk != null) {
                    this.kyk.qx(CyberPlayerManager.hasCacheFile(Kw));
                }
            }
            if (this.kyo != null && this.kyo.cQA() != null) {
                this.kyo.cQA().setPlayer(this);
            }
            this.kAC.cRs();
            z(Uri.parse(Kw));
            if (this.kyk != null) {
                this.kyk.cyh();
            }
            String host = Uri.parse(this.kAA).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.kAE < 900)) ? "1" : "0");
            setVideoPath(Kw);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.kyF = true;
            if (!cQP()) {
                aVar.cRu();
            }
            if (!cQO()) {
                aVar.cRv();
                this.kAB = true;
                setVideoPath(this.kAA, this.ais);
                return;
            }
        } else {
            this.kyF = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.kAD) {
            ag.a(this.aio, true);
            setVolume(1.0f, 1.0f);
        }
        this.kAB = true;
        super.start();
        if (this.kAC != null) {
            this.kAC.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().zA(-400);
            getVideoMonitor().ac(this.jrp, this.jrq);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kAB) {
            b(aVar);
            return;
        }
        this.kAB = true;
        if (aVar != null) {
            this.kyF = true;
            if (!cQP()) {
                aVar.cRu();
            }
        } else {
            this.kyF = false;
        }
        setVideoPath(this.kAA, this.ais);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ag.a(this.aio, false);
        if (isPlaying() && cQM()) {
            x.cRo().bw(this.kAA, getCurrentPositionSync());
        }
        super.pause();
        if (this.kAC != null) {
            this.kAC.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kyk != null) {
            this.kyk.cym();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kyF) {
            stopPlayback();
            return;
        }
        if (this.kAA != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        this.kAB = false;
        if (isPlaying() && cQM()) {
            x.cRo().bw(this.kAA, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.kAC != null) {
            this.kAC.onStop();
        }
        if (this.kyk != null && this.kyk.Iz(getLocateSource())) {
            this.kyk = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.kAA != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        this.kAB = false;
        if (isPlaying() && cQM()) {
            x.cRo().bw(this.kAA, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cRt().KC(this.kAA);
        if (this.kAC != null) {
            this.kAC.onStop();
        }
        if (this.kyk != null && this.kyk.Iz(getLocateSource())) {
            this.kyk = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eKz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kAK != null) {
            this.kAK.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.eKz);
    }

    private String Kw(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.dhK().dhL()) {
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
    public boolean cQK() {
        return this.kAB;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kyk != null) {
            this.kyk.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQM() {
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
        if (!(this.kyo instanceof n) || ((n) this.kyo).cQY() == null) {
            return "";
        }
        return ((n) this.kyo).kzn ? "v_mid_page" : ((n) this.kyo).cQY().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.kyk != null) {
            return this.kyk;
        }
        if (!StringUtils.isNull(this.kAA) && kyj != null) {
            this.kyk = kyj.at(this.ais, this.kAA, null);
        }
        return this.kyk;
    }

    private boolean cQO() {
        return this == TbVideoViewSet.cRt().KB(this.kAA);
    }

    private boolean cQP() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cQN() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.kAK = null;
        this.kAG = null;
        this.kAI = null;
        this.kAJ = null;
        this.kAF = null;
        this.kAH = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kyF = z;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQI() {
        if (this.kAC != null) {
            this.kAC.cRs();
            this.kAC.fl(getDuration());
            this.kAC.a(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().qx(CyberPlayerManager.hasCacheFile(this.kAA));
            getVideoMonitor().zz(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQJ() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().qx(CyberPlayerManager.hasCacheFile(this.kAA));
            getVideoMonitor().cyh();
            getVideoMonitor().zy(-400);
        }
    }
}
