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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.video.h;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements com.baidu.tieba.play.a.a {
    private static l kTm;
    private WeakReference<Context> ajK;
    private String ajO;
    private final CustomMessageListener eUW;
    private String fUy;
    private boolean jJM;
    private boolean jJN;
    private boolean kTI;
    private i kTn;
    private d kTr;
    private boolean kVD;
    private boolean kVE;
    private b kVF;
    private boolean kVG;
    private int kVH;
    private int kVI;
    private g.f kVJ;
    private g.a kVK;
    private g.InterfaceC0721g kVL;
    private g.b kVM;
    private g.e kVN;
    private QuickVideoView.b kVO;
    private CyberPlayerManager.OnPreparedListener kVP;
    private CyberPlayerManager.OnCompletionListener kVQ;
    private CyberPlayerManager.OnErrorListener kVR;
    private CyberPlayerManager.OnSeekCompleteListener kVS;
    private CyberPlayerManager.OnInfoListener kVT;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            kTm = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.ajK = null;
        this.kVG = false;
        this.kTI = false;
        this.kVP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Lc;
                if (TbCyberVideoView.this.kVF != null) {
                    TbCyberVideoView.this.kVF.fo(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Am(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cWb().a(TbCyberVideoView.this, TbCyberVideoView.this.fUy);
                    if (TbCyberVideoView.this.kVJ != null) {
                        TbCyberVideoView.this.kVJ.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kVD && (Lc = x.cVW().Lc(TbCyberVideoView.this.fUy)) > 0) {
                        TbCyberVideoView.this.seekTo(Lc);
                    }
                    if (TbCyberVideoView.this.kVE) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kVQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kTn != null) {
                    TbCyberVideoView.this.kTn.Jb(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kTn = null;
                }
                x.cVW().remove(TbCyberVideoView.this.fUy);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kVF != null) {
                        TbCyberVideoView.this.kVF.onComplete();
                    }
                    TbCyberVideoView.this.kVE = false;
                    if (TbCyberVideoView.this.kVK != null) {
                        TbCyberVideoView.this.kVK.onCompletion(null);
                    }
                }
            }
        };
        this.kVR = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kTr != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cVu()) {
                    x.cVW().bv(TbCyberVideoView.this.fUy, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cWb().Le(TbCyberVideoView.this.fUy);
                if (TbCyberVideoView.this.kVM == null || TbCyberVideoView.this.kVM.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kVS = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kVL != null) {
                    TbCyberVideoView.this.kVL.b(null);
                }
            }
        };
        this.kVT = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kVN != null) {
                    TbCyberVideoView.this.kVN.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kVF.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.eUW = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kTn != null) {
                        TbCyberVideoView.this.kTn.Ja(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kTn = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.ajK = null;
        this.kVG = false;
        this.kTI = false;
        this.kVP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Lc;
                if (TbCyberVideoView.this.kVF != null) {
                    TbCyberVideoView.this.kVF.fo(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Am(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cWb().a(TbCyberVideoView.this, TbCyberVideoView.this.fUy);
                    if (TbCyberVideoView.this.kVJ != null) {
                        TbCyberVideoView.this.kVJ.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kVD && (Lc = x.cVW().Lc(TbCyberVideoView.this.fUy)) > 0) {
                        TbCyberVideoView.this.seekTo(Lc);
                    }
                    if (TbCyberVideoView.this.kVE) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kVQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kTn != null) {
                    TbCyberVideoView.this.kTn.Jb(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kTn = null;
                }
                x.cVW().remove(TbCyberVideoView.this.fUy);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kVF != null) {
                        TbCyberVideoView.this.kVF.onComplete();
                    }
                    TbCyberVideoView.this.kVE = false;
                    if (TbCyberVideoView.this.kVK != null) {
                        TbCyberVideoView.this.kVK.onCompletion(null);
                    }
                }
            }
        };
        this.kVR = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kTr != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cVu()) {
                    x.cVW().bv(TbCyberVideoView.this.fUy, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cWb().Le(TbCyberVideoView.this.fUy);
                if (TbCyberVideoView.this.kVM == null || TbCyberVideoView.this.kVM.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kVS = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kVL != null) {
                    TbCyberVideoView.this.kVL.b(null);
                }
            }
        };
        this.kVT = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kVN != null) {
                    TbCyberVideoView.this.kVN.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kVF.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.eUW = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kTn != null) {
                        TbCyberVideoView.this.kTn.Ja(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kTn = null;
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
        this.ajK = new WeakReference<>(TbadkCoreApplication.getInst());
        setOnPreparedListener(this.kVP);
        setOnCompletionListener(this.kVQ);
        setOnErrorListener(this.kVR);
        setOnSeekCompleteListener(this.kVS);
        setOnInfoListener(this.kVT);
        this.kVF = new b();
        an.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void z(Uri uri) {
        a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.cVY()) {
            if (!pcdnConfigData.y(uri)) {
                this.kVI = 2;
                return;
            } else if (c.cWg() <= 0) {
                this.kVI = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.cVZ() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.cWg()));
                this.jJM = true;
                this.jJN = pcdnConfigData.cVZ();
                this.kVI = 1;
                return;
            }
        }
        this.kVI = 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getPcdnState() {
        return this.kVI;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.kVG = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ag.a(this.ajK, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.kVG = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kTr = dVar;
        if ((this.kTr instanceof n) && ((n) this.kTr).cVG() != null) {
            this.kVF.h((n) this.kTr);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.kVJ = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.kVK = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.kVM = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0721g interfaceC0721g) {
        this.kVL = interfaceC0721g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kVN = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.kVO = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kVD = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.fUy;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.kVH = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!ar.isEmpty(str)) {
            this.ajO = str2;
            this.fUy = str;
            String KY = KY(str);
            if (kTm != null) {
                this.kTn = kTm.au(this.ajO, this.fUy, null);
                if (this.kTn != null) {
                    this.kTn.qH(CyberPlayerManager.hasCacheFile(KY));
                }
            }
            if (this.kTr != null && this.kTr.cVi() != null) {
                this.kTr.cVi().setPlayer(this);
            }
            this.kVF.cWa();
            z(Uri.parse(KY));
            if (this.kTn != null) {
                this.kTn.cCw();
            }
            String host = Uri.parse(this.fUy).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.kVH < 900)) ? "1" : "0");
            setVideoPath(KY);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.kTI = true;
            if (!cVx()) {
                aVar.cWc();
            }
            if (!cVw()) {
                aVar.cWd();
                this.kVE = true;
                setVideoPath(this.fUy, this.ajO);
                return;
            }
        } else {
            this.kTI = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.kVG) {
            ag.a(this.ajK, true);
            setVolume(1.0f, 1.0f);
        }
        this.kVE = true;
        super.start();
        if (this.kVF != null) {
            this.kVF.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().Ao(-400);
            getVideoMonitor().ad(this.jJM, this.jJN);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kVE) {
            b(aVar);
            return;
        }
        this.kVE = true;
        if (aVar != null) {
            this.kTI = true;
            if (!cVx()) {
                aVar.cWc();
            }
        } else {
            this.kTI = false;
        }
        setVideoPath(this.fUy, this.ajO);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ag.a(this.ajK, false);
        if (isPlaying() && cVu()) {
            x.cVW().bv(this.fUy, getCurrentPositionSync());
        }
        super.pause();
        if (this.kVF != null) {
            this.kVF.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kTn != null) {
            this.kTn.cCB();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kTI) {
            stopPlayback();
            return;
        }
        if (this.fUy != null && isPlaying()) {
            ag.a(this.ajK, false);
        }
        this.kVE = false;
        if (isPlaying() && cVu()) {
            x.cVW().bv(this.fUy, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.kVF != null) {
            this.kVF.onStop();
        }
        if (this.kTn != null && this.kTn.Jc(getLocateSource())) {
            this.kTn = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.fUy != null && isPlaying()) {
            ag.a(this.ajK, false);
        }
        this.kVE = false;
        if (isPlaying() && cVu()) {
            x.cVW().bv(this.fUy, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cWb().Le(this.fUy);
        if (this.kVF != null) {
            this.kVF.onStop();
        }
        if (this.kTn != null && this.kTn.Jc(getLocateSource())) {
            this.kTn = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eUW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kVO != null) {
            this.kVO.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.eUW);
    }

    private String KY(String str) {
        if (!ar.isEmpty(str) && h.dmo().dmp()) {
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
    public boolean cVs() {
        return this.kVE;
    }

    @Override // com.baidu.tieba.play.a.a
    public void h(long j, long j2, long j3) {
        if (this.kTn != null) {
            this.kTn.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVu() {
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
        if (!(this.kTr instanceof n) || ((n) this.kTr).cVG() == null) {
            return "";
        }
        return ((n) this.kTr).kUq ? "v_mid_page" : ((n) this.kTr).cVG().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.kTn != null) {
            return this.kTn;
        }
        if (!StringUtils.isNull(this.fUy) && kTm != null) {
            this.kTn = kTm.au(this.ajO, this.fUy, null);
        }
        return this.kTn;
    }

    private boolean cVw() {
        return this == TbVideoViewSet.cWb().Ld(this.fUy);
    }

    private boolean cVx() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cVv() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.kVO = null;
        this.kVK = null;
        this.kVM = null;
        this.kVN = null;
        this.kVJ = null;
        this.kVL = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kTI = z;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cVq() {
        if (this.kVF != null) {
            this.kVF.cWa();
            this.kVF.fo(getDuration());
            this.kVF.a(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().qH(CyberPlayerManager.hasCacheFile(this.fUy));
            getVideoMonitor().An(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cVr() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().qH(CyberPlayerManager.hasCacheFile(this.fUy));
            getVideoMonitor().cCw();
            getVideoMonitor().Am(-400);
        }
    }
}
