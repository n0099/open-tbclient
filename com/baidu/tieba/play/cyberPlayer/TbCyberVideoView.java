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
    private static l kzp;
    private WeakReference<Context> aio;
    private String ais;
    private final CustomMessageListener eKK;
    private boolean jsv;
    private boolean jsw;
    private boolean kBG;
    private String kBH;
    private boolean kBI;
    private b kBJ;
    private boolean kBK;
    private int kBL;
    private int kBM;
    private g.f kBN;
    private g.a kBO;
    private g.InterfaceC0705g kBP;
    private g.b kBQ;
    private g.e kBR;
    private QuickVideoView.b kBS;
    private CyberPlayerManager.OnPreparedListener kBT;
    private CyberPlayerManager.OnCompletionListener kBU;
    private CyberPlayerManager.OnErrorListener kBV;
    private CyberPlayerManager.OnSeekCompleteListener kBW;
    private CyberPlayerManager.OnInfoListener kBX;
    private boolean kzL;
    private i kzq;
    private d kzu;
    private PowerManager.WakeLock mWakeLock;

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            kzp = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.aio = null;
        this.kBK = false;
        this.kzL = false;
        this.kBT = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int KB;
                if (TbCyberVideoView.this.kBJ != null) {
                    TbCyberVideoView.this.kBJ.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().zA(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cRJ().a(TbCyberVideoView.this, TbCyberVideoView.this.kBH);
                    if (TbCyberVideoView.this.kBN != null) {
                        TbCyberVideoView.this.kBN.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kBG && (KB = x.cRE().KB(TbCyberVideoView.this.kBH)) > 0) {
                        TbCyberVideoView.this.seekTo(KB);
                    }
                    if (TbCyberVideoView.this.kBI) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kBU = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kzq != null) {
                    TbCyberVideoView.this.kzq.Iz(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kzq = null;
                }
                x.cRE().remove(TbCyberVideoView.this.kBH);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kBJ != null) {
                        TbCyberVideoView.this.kBJ.onComplete();
                    }
                    TbCyberVideoView.this.kBI = false;
                    if (TbCyberVideoView.this.kBO != null) {
                        TbCyberVideoView.this.kBO.onCompletion(null);
                    }
                }
            }
        };
        this.kBV = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kzu != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cRc()) {
                    x.cRE().bw(TbCyberVideoView.this.kBH, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRJ().KD(TbCyberVideoView.this.kBH);
                if (TbCyberVideoView.this.kBQ == null || TbCyberVideoView.this.kBQ.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kBW = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kBP != null) {
                    TbCyberVideoView.this.kBP.b(null);
                }
            }
        };
        this.kBX = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kBR != null) {
                    TbCyberVideoView.this.kBR.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kBJ.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.eKK = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kzq != null) {
                        TbCyberVideoView.this.kzq.Iy(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kzq = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.aio = null;
        this.kBK = false;
        this.kzL = false;
        this.kBT = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int KB;
                if (TbCyberVideoView.this.kBJ != null) {
                    TbCyberVideoView.this.kBJ.fl(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().zA(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cRJ().a(TbCyberVideoView.this, TbCyberVideoView.this.kBH);
                    if (TbCyberVideoView.this.kBN != null) {
                        TbCyberVideoView.this.kBN.onPrepared(null);
                    }
                    if (TbCyberVideoView.this.kBG && (KB = x.cRE().KB(TbCyberVideoView.this.kBH)) > 0) {
                        TbCyberVideoView.this.seekTo(KB);
                    }
                    if (TbCyberVideoView.this.kBI) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.kBU = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.kzq != null) {
                    TbCyberVideoView.this.kzq.Iz(TbCyberVideoView.this.getLocateSource());
                    TbCyberVideoView.this.kzq = null;
                }
                x.cRE().remove(TbCyberVideoView.this.kBH);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.kBJ != null) {
                        TbCyberVideoView.this.kBJ.onComplete();
                    }
                    TbCyberVideoView.this.kBI = false;
                    if (TbCyberVideoView.this.kBO != null) {
                        TbCyberVideoView.this.kBO.onCompletion(null);
                    }
                }
            }
        };
        this.kBV = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kzu != null && TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cRc()) {
                    x.cRE().bw(TbCyberVideoView.this.kBH, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRJ().KD(TbCyberVideoView.this.kBH);
                if (TbCyberVideoView.this.kBQ == null || TbCyberVideoView.this.kBQ.onError(null, i, i2)) {
                }
                return true;
            }
        };
        this.kBW = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.kBP != null) {
                    TbCyberVideoView.this.kBP.b(null);
                }
            }
        };
        this.kBX = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (TbCyberVideoView.this.kBR != null) {
                    TbCyberVideoView.this.kBR.onInfo(null, i, i2);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().s(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i == 904) {
                    TbCyberVideoView.this.kBJ.a(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.eKK = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.kzq != null) {
                        TbCyberVideoView.this.kzq.Iy(TbCyberVideoView.this.getLocateSource());
                        TbCyberVideoView.this.kzq = null;
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
        setOnPreparedListener(this.kBT);
        setOnCompletionListener(this.kBU);
        setOnErrorListener(this.kBV);
        setOnSeekCompleteListener(this.kBW);
        setOnInfoListener(this.kBX);
        this.kBJ = new b();
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void z(Uri uri) {
        a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.cRG()) {
            if (!pcdnConfigData.y(uri)) {
                this.kBM = 2;
                return;
            } else if (c.cRO() <= 0) {
                this.kBM = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.cRH() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.cRO()));
                this.jsv = true;
                this.jsw = pcdnConfigData.cRH();
                this.kBM = 1;
                return;
            }
        }
        this.kBM = 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getPcdnState() {
        return this.kBM;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.kBK = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ag.a(this.aio, !z);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.kBK = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kzu = dVar;
        if ((this.kzu instanceof n) && ((n) this.kzu).cRo() != null) {
            this.kBJ.h((n) this.kzu);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.kBN = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.kBO = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.kBQ = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0705g interfaceC0705g) {
        this.kBP = interfaceC0705g;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kBR = eVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(QuickVideoView.b bVar) {
        this.kBS = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kBG = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kBH;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
        this.kBL = i;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        if (!aq.isEmpty(str)) {
            this.ais = str2;
            this.kBH = str;
            String Kx = Kx(str);
            if (kzp != null) {
                this.kzq = kzp.at(this.ais, this.kBH, null);
                if (this.kzq != null) {
                    this.kzq.qx(CyberPlayerManager.hasCacheFile(Kx));
                }
            }
            if (this.kzu != null && this.kzu.cQQ() != null) {
                this.kzu.cQQ().setPlayer(this);
            }
            this.kBJ.cRI();
            z(Uri.parse(Kx));
            if (this.kzq != null) {
                this.kzq.cyy();
            }
            String host = Uri.parse(this.kBH).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.kBL < 900)) ? "1" : "0");
            setVideoPath(Kx);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.kzL = true;
            if (!cRf()) {
                aVar.cRK();
            }
            if (!cRe()) {
                aVar.cRL();
                this.kBI = true;
                setVideoPath(this.kBH, this.ais);
                return;
            }
        } else {
            this.kzL = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.kBK) {
            ag.a(this.aio, true);
            setVolume(1.0f, 1.0f);
        }
        this.kBI = true;
        super.start();
        if (this.kBJ != null) {
            this.kBJ.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().zC(-400);
            getVideoMonitor().ac(this.jsv, this.jsw);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kBI) {
            b(aVar);
            return;
        }
        this.kBI = true;
        if (aVar != null) {
            this.kzL = true;
            if (!cRf()) {
                aVar.cRK();
            }
        } else {
            this.kzL = false;
        }
        setVideoPath(this.kBH, this.ais);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ag.a(this.aio, false);
        if (isPlaying() && cRc()) {
            x.cRE().bw(this.kBH, getCurrentPositionSync());
        }
        super.pause();
        if (this.kBJ != null) {
            this.kBJ.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kzq != null) {
            this.kzq.cyD();
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kzL) {
            stopPlayback();
            return;
        }
        if (this.kBH != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        this.kBI = false;
        if (isPlaying() && cRc()) {
            x.cRE().bw(this.kBH, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.kBJ != null) {
            this.kBJ.onStop();
        }
        if (this.kzq != null && this.kzq.IA(getLocateSource())) {
            this.kzq = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.kBH != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        this.kBI = false;
        if (isPlaying() && cRc()) {
            x.cRE().bw(this.kBH, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cRJ().KD(this.kBH);
        if (this.kBJ != null) {
            this.kBJ.onStop();
        }
        if (this.kzq != null && this.kzq.IA(getLocateSource())) {
            this.kzq = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eKK);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kBS != null) {
            this.kBS.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.eKK);
    }

    private String Kx(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.dhZ().dia()) {
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
    public boolean cRa() {
        return this.kBI;
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kzq != null) {
            this.kzq.e(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRc() {
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
        if (!(this.kzu instanceof n) || ((n) this.kzu).cRo() == null) {
            return "";
        }
        return ((n) this.kzu).kAt ? "v_mid_page" : ((n) this.kzu).cRo().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.kzq != null) {
            return this.kzq;
        }
        if (!StringUtils.isNull(this.kBH) && kzp != null) {
            this.kzq = kzp.at(this.ais, this.kBH, null);
        }
        return this.kzq;
    }

    private boolean cRe() {
        return this == TbVideoViewSet.cRJ().KC(this.kBH);
    }

    private boolean cRf() {
        return getParent() != null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cRd() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.kBS = null;
        this.kBO = null;
        this.kBQ = null;
        this.kBR = null;
        this.kBN = null;
        this.kBP = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kzL = z;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQY() {
        if (this.kBJ != null) {
            this.kBJ.cRI();
            this.kBJ.fl(getDuration());
            this.kBJ.a(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().qx(CyberPlayerManager.hasCacheFile(this.kBH));
            getVideoMonitor().zB(-400);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQZ() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().qx(CyberPlayerManager.hasCacheFile(this.kBH));
            getVideoMonitor().cyy();
            getVideoMonitor().zA(-400);
        }
    }
}
