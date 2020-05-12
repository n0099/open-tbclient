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
    private static l eFy;
    private WeakReference<Context> ahK;
    private String ahO;
    private final CustomMessageListener evX;
    private boolean jcm;
    private boolean jcn;
    private boolean kgN;
    private i kgs;
    private d kgw;
    private boolean kiE;
    private String kiF;
    private boolean kiG;
    private b kiH;
    private boolean kiI;
    private int kiJ;
    private g.f kiK;
    private g.a kiL;
    private g.InterfaceC0651g kiM;
    private g.b kiN;
    private g.e kiO;
    private QuickVideoView.b kiP;
    private CyberPlayerManager.OnPreparedListener kiQ;
    private CyberPlayerManager.OnCompletionListener kiR;
    private CyberPlayerManager.OnErrorListener kiS;
    private CyberPlayerManager.OnSeekCompleteListener kiT;
    private CyberPlayerManager.OnInfoListener kiU;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            eFy = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.ahK = null;
        this.kiI = false;
        this.kgN = false;
        this.kiQ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int IO;
                if (TbCyberVideoView.this.kiH != null) {
                    TbCyberVideoView.this.kiH.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yQ(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cKu().a(TbCyberVideoView.this, TbCyberVideoView.this.kiF);
                    if (TbCyberVideoView.this.kiK != null) {
                        TbCyberVideoView.this.kiK.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kiE && (IO = x.cKp().IO(TbCyberVideoView.this.kiF)) > 0) {
                        TbCyberVideoView.this.seekTo(IO);
                    }
                    if (TbCyberVideoView.this.kiG) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kiR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kgs != null) {
                    TbCyberVideoView.this.kgs.GP(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kgs = null;
                }
                x.cKp().remove(TbCyberVideoView.this.kiF);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kiH != null) {
                        TbCyberVideoView.this.kiH.onComplete();
                    }
                    TbCyberVideoView.this.kiG = false;
                    if (TbCyberVideoView.this.kiL != null) {
                        TbCyberVideoView.this.kiL.onCompletion(null);
                    }
                }
            }
        };
        this.kiS = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kgw != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cJN()) {
                    x.cKp().bv(TbCyberVideoView.this.kiF, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKu().IQ(TbCyberVideoView.this.kiF);
                if (TbCyberVideoView.this.kiN == null || TbCyberVideoView.this.kiN.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kiT = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kiM != null) {
                    TbCyberVideoView.this.kiM.b(null);
                }
            }
        };
        this.kiU = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kiO != null) {
                    TbCyberVideoView.this.kiO.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kiH.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.evX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kgs != null) {
                        TbCyberVideoView.this.kgs.GO(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kgs = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.ahK = null;
        this.kiI = false;
        this.kgN = false;
        this.kiQ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int IO;
                if (TbCyberVideoView.this.kiH != null) {
                    TbCyberVideoView.this.kiH.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().yQ(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cKu().a(TbCyberVideoView.this, TbCyberVideoView.this.kiF);
                    if (TbCyberVideoView.this.kiK != null) {
                        TbCyberVideoView.this.kiK.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kiE && (IO = x.cKp().IO(TbCyberVideoView.this.kiF)) > 0) {
                        TbCyberVideoView.this.seekTo(IO);
                    }
                    if (TbCyberVideoView.this.kiG) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kiR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kgs != null) {
                    TbCyberVideoView.this.kgs.GP(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kgs = null;
                }
                x.cKp().remove(TbCyberVideoView.this.kiF);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kiH != null) {
                        TbCyberVideoView.this.kiH.onComplete();
                    }
                    TbCyberVideoView.this.kiG = false;
                    if (TbCyberVideoView.this.kiL != null) {
                        TbCyberVideoView.this.kiL.onCompletion(null);
                    }
                }
            }
        };
        this.kiS = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kgw != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cJN()) {
                    x.cKp().bv(TbCyberVideoView.this.kiF, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKu().IQ(TbCyberVideoView.this.kiF);
                if (TbCyberVideoView.this.kiN == null || TbCyberVideoView.this.kiN.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kiT = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kiM != null) {
                    TbCyberVideoView.this.kiM.b(null);
                }
            }
        };
        this.kiU = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kiO != null) {
                    TbCyberVideoView.this.kiO.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kiH.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.evX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kgs != null) {
                        TbCyberVideoView.this.kgs.GO(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kgs = null;
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
        this.ahK = new WeakReference<>(TbadkCoreApplication.getInst());
        setOnPreparedListener(this.kiQ);
        setOnCompletionListener(this.kiR);
        setOnErrorListener(this.kiS);
        setOnSeekCompleteListener(this.kiT);
        setOnInfoListener(this.kiU);
        this.kiH = new b();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void w(Uri uri) {
        a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.cKr() && pcdnConfigData.v(uri) && c.cKz() > 0) {
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
            setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.cKs() ? "1" : "0");
            setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.cKz()));
            this.jcm = true;
            this.jcn = pcdnConfigData.cKs();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.kiI = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        af.a(this.ahK, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.kiI = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kgw = dVar;
        if ((this.kgw instanceof n) && ((n) this.kgw).cJZ() != null) {
            this.kiH.h((n) this.kgw);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.kiK = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.kiL = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.kiN = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0651g interfaceC0651g) {
        this.kiM = interfaceC0651g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kiO = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.kiP = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kiE = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kiF;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.kiJ = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.ahO = str2;
            this.kiF = str;
            String IK = IK(str);
            if (eFy != null) {
                this.kgs = eFy.ap(this.ahO, this.kiF, null);
                if (this.kgs != null) {
                    this.kgs.qa(CyberPlayerManager.hasCacheFile(IK));
                }
            }
            if (this.kgw != null && this.kgw.cJB() != null) {
                this.kgw.cJB().setPlayer(this);
            }
            this.kiH.cKt();
            w(Uri.parse(IK));
            if (this.kgs != null) {
                this.kgs.crE();
            }
            String host = Uri.parse(this.kiF).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.kiJ < 900)) ? "1" : "0");
            setVideoPath(IK);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.kgN = true;
            if (!cJQ()) {
                aVar.cKv();
            }
            if (!cJP()) {
                aVar.cKw();
                this.kiG = true;
                setVideoPath(this.kiF, this.ahO);
                return;
            }
        } else {
            this.kgN = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.kiI) {
            af.a(this.ahK, true);
            setVolume(1.0f, 1.0f);
        }
        this.kiG = true;
        super.start();
        if (this.kiH != null) {
            this.kiH.onStart();
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
            getVideoMonitor().Z(this.jcm, this.jcn);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kiG) {
            b(aVar);
            return;
        }
        this.kiG = true;
        if (aVar != null) {
            this.kgN = true;
            if (!cJQ()) {
                aVar.cKv();
            }
        } else {
            this.kgN = false;
        }
        setVideoPath(this.kiF, this.ahO);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        af.a(this.ahK, false);
        if (isPlaying() && cJN()) {
            x.cKp().bv(this.kiF, getCurrentPositionSync());
        }
        super.pause();
        if (this.kiH != null) {
            this.kiH.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kgs != null) {
            this.kgs.crJ();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kgN) {
            stopPlayback();
            return;
        }
        if (this.kiF != null && isPlaying()) {
            af.a(this.ahK, false);
        }
        this.kiG = false;
        if (isPlaying() && cJN()) {
            x.cKp().bv(this.kiF, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.kiH != null) {
            this.kiH.onStop();
        }
        if (this.kgs != null && this.kgs.GQ(getLocateSource())) {
            this.kgs = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.kiF != null && isPlaying()) {
            af.a(this.ahK, false);
        }
        this.kiG = false;
        if (isPlaying() && cJN()) {
            x.cKp().bv(this.kiF, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cKu().IQ(this.kiF);
        if (this.kiH != null) {
            this.kiH.onStop();
        }
        if (this.kgs != null && this.kgs.GQ(getLocateSource())) {
            this.kgs = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.evX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kiP != null) {
            this.kiP.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.evX);
    }

    private String IK(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.daw().dax()) {
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
    public boolean cJL() {
        return this.kiG;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kgs != null) {
            this.kgs.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJN() {
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
        if (!(this.kgw instanceof n) || ((n) this.kgw).cJZ() == null) {
            return "";
        }
        return ((n) this.kgw).khs ? "v_mid_page" : ((n) this.kgw).cJZ().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.kgs != null) {
            return this.kgs;
        }
        if (!StringUtils.isNull(this.kiF) && eFy != null) {
            this.kgs = eFy.ap(this.ahO, this.kiF, null);
        }
        return this.kgs;
    }

    private boolean cJP() {
        return this == TbVideoViewSet.cKu().IP(this.kiF);
    }

    private boolean cJQ() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cJO() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.kiP = null;
        this.kiL = null;
        this.kiN = null;
        this.kiO = null;
        this.kiK = null;
        this.kiM = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kgN = z;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJJ() {
        if (this.kiH != null) {
            this.kiH.cKt();
            this.kiH.fl(getDuration());
            this.kiH.a(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().qa(CyberPlayerManager.hasCacheFile(this.kiF));
            getVideoMonitor().yR(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJK() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().qa(CyberPlayerManager.hasCacheFile(this.kiF));
            getVideoMonitor().crE();
            getVideoMonitor().yQ(-400);
        }
    }
}
