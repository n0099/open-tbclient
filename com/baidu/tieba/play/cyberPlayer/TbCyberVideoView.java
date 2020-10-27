package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.MediaController;
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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.k.i;
import com.baidu.tieba.k.l;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    private static l meq;
    private f ZZ;
    private WeakReference<Context> alP;
    private String alT;
    private String eul;
    private final CustomMessageListener imp;
    private CyberPlayerManager.OnErrorListener kAO;
    private boolean kSb;
    private boolean kSc;
    private CyberPlayerManager.OnSeekCompleteListener meA;
    private CyberPlayerManager.OnErrorListener meB;
    private CyberPlayerManager.OnInfoListener meC;
    private a meD;
    private CyberPlayerManager.OnPreparedListener meE;
    private CyberPlayerManager.OnCompletionListener meF;
    private CyberPlayerManager.OnSeekCompleteListener meG;
    private CyberPlayerManager.OnInfoListener meH;
    private boolean men;
    private boolean meo;
    private b mep;
    private i mer;
    private String mes;
    private PowerManager.WakeLock met;
    private boolean meu;
    private boolean mev;
    private int mew;
    private int mex;
    private CyberPlayerManager.OnPreparedListener mey;
    private CyberPlayerManager.OnCompletionListener mez;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            meq = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alP = null;
        this.meu = false;
        this.mev = false;
        this.meE = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Qt;
                if (TbCyberVideoView.this.mep != null) {
                    TbCyberVideoView.this.mep.gw(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EE(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.duT().a(TbCyberVideoView.this, TbCyberVideoView.this.eul);
                    if (TbCyberVideoView.this.mey != null) {
                        TbCyberVideoView.this.mey.onPrepared();
                    }
                    if (TbCyberVideoView.this.men && (Qt = n.duF().Qt(TbCyberVideoView.this.eul)) > 0) {
                        TbCyberVideoView.this.seekTo(Qt);
                    }
                    if (TbCyberVideoView.this.meo) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.meF = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mer != null) {
                    TbCyberVideoView.this.mer.Ox(TbCyberVideoView.this.mes);
                    TbCyberVideoView.this.mer = null;
                }
                n.duF().remove(TbCyberVideoView.this.eul);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mep != null) {
                        TbCyberVideoView.this.mep.onComplete();
                    }
                    TbCyberVideoView.this.meo = false;
                    if (TbCyberVideoView.this.mez != null) {
                        TbCyberVideoView.this.mez.onCompletion();
                    }
                }
            }
        };
        this.kAO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.duN()) {
                    n.duF().bA(TbCyberVideoView.this.eul, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.duT().Qw(TbCyberVideoView.this.eul);
                if (TbCyberVideoView.this.meB != null) {
                    TbCyberVideoView.this.meB.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.meG = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.meA != null) {
                    TbCyberVideoView.this.meA.onSeekComplete();
                }
            }
        };
        this.meH = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.meC != null) {
                    TbCyberVideoView.this.meC.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().A(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mep != null) {
                    TbCyberVideoView.this.mep.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.imp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mer != null) {
                        TbCyberVideoView.this.mer.Ow(TbCyberVideoView.this.mes);
                        TbCyberVideoView.this.mer = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.alP = null;
        this.meu = false;
        this.mev = false;
        this.meE = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Qt;
                if (TbCyberVideoView.this.mep != null) {
                    TbCyberVideoView.this.mep.gw(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EE(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.duT().a(TbCyberVideoView.this, TbCyberVideoView.this.eul);
                    if (TbCyberVideoView.this.mey != null) {
                        TbCyberVideoView.this.mey.onPrepared();
                    }
                    if (TbCyberVideoView.this.men && (Qt = n.duF().Qt(TbCyberVideoView.this.eul)) > 0) {
                        TbCyberVideoView.this.seekTo(Qt);
                    }
                    if (TbCyberVideoView.this.meo) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.meF = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mer != null) {
                    TbCyberVideoView.this.mer.Ox(TbCyberVideoView.this.mes);
                    TbCyberVideoView.this.mer = null;
                }
                n.duF().remove(TbCyberVideoView.this.eul);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mep != null) {
                        TbCyberVideoView.this.mep.onComplete();
                    }
                    TbCyberVideoView.this.meo = false;
                    if (TbCyberVideoView.this.mez != null) {
                        TbCyberVideoView.this.mez.onCompletion();
                    }
                }
            }
        };
        this.kAO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.duN()) {
                    n.duF().bA(TbCyberVideoView.this.eul, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.duT().Qw(TbCyberVideoView.this.eul);
                if (TbCyberVideoView.this.meB != null) {
                    TbCyberVideoView.this.meB.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.meG = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.meA != null) {
                    TbCyberVideoView.this.meA.onSeekComplete();
                }
            }
        };
        this.meH = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.meC != null) {
                    TbCyberVideoView.this.meC.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().A(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mep != null) {
                    TbCyberVideoView.this.mep.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.imp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mer != null) {
                        TbCyberVideoView.this.mer.Ow(TbCyberVideoView.this.mes);
                        TbCyberVideoView.this.mer = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.alP = null;
        this.meu = false;
        this.mev = false;
        this.meE = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Qt;
                if (TbCyberVideoView.this.mep != null) {
                    TbCyberVideoView.this.mep.gw(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EE(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.duT().a(TbCyberVideoView.this, TbCyberVideoView.this.eul);
                    if (TbCyberVideoView.this.mey != null) {
                        TbCyberVideoView.this.mey.onPrepared();
                    }
                    if (TbCyberVideoView.this.men && (Qt = n.duF().Qt(TbCyberVideoView.this.eul)) > 0) {
                        TbCyberVideoView.this.seekTo(Qt);
                    }
                    if (TbCyberVideoView.this.meo) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.meF = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mer != null) {
                    TbCyberVideoView.this.mer.Ox(TbCyberVideoView.this.mes);
                    TbCyberVideoView.this.mer = null;
                }
                n.duF().remove(TbCyberVideoView.this.eul);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mep != null) {
                        TbCyberVideoView.this.mep.onComplete();
                    }
                    TbCyberVideoView.this.meo = false;
                    if (TbCyberVideoView.this.mez != null) {
                        TbCyberVideoView.this.mez.onCompletion();
                    }
                }
            }
        };
        this.kAO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.duN()) {
                    n.duF().bA(TbCyberVideoView.this.eul, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.duT().Qw(TbCyberVideoView.this.eul);
                if (TbCyberVideoView.this.meB != null) {
                    TbCyberVideoView.this.meB.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.meG = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.meA != null) {
                    TbCyberVideoView.this.meA.onSeekComplete();
                }
            }
        };
        this.meH = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.meC != null) {
                    TbCyberVideoView.this.meC.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().A(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mep != null) {
                    TbCyberVideoView.this.mep.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.imp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mer != null) {
                        TbCyberVideoView.this.mer.Ow(TbCyberVideoView.this.mes);
                        TbCyberVideoView.this.mer = null;
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
                this.met = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.met.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.alP = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.meE);
        super.setOnCompletionListener(this.meF);
        super.setOnErrorListener(this.kAO);
        super.setOnSeekCompleteListener(this.meG);
        super.setOnInfoListener(this.meH);
        this.mep = new b();
        this.ZZ = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void z(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.duH()) {
            if (!pcdnConfigData.y(uri)) {
                this.mex = 2;
                return;
            } else if (c.duY() <= 0) {
                this.mex = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.duI() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.duY()));
                this.kSb = true;
                this.kSc = pcdnConfigData.duI();
                this.mex = 1;
                return;
            }
        }
        this.mex = 0;
    }

    public int getPcdnState() {
        return this.mex;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.meu = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ai.a(this.alP, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.meu = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mep == null) {
            this.mep = new b();
        }
        this.mep.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mes = oVar.mLocate;
        }
    }

    public void setStageType(String str) {
        if (at.isEmpty(str)) {
            str = "-1";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20484");
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void setThreadDataForStatistic(bw bwVar) {
        if (this.mep == null) {
            this.mep = new b();
        }
        this.mep.setThreadData(bwVar);
    }

    public void setPlayMode(String str) {
        if (this.mep != null) {
            this.mep.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mep = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mey = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mez = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.meB = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.meA = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.meC = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.meD = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.men = z;
    }

    public String getOriginUrl() {
        return this.eul;
    }

    public void setVideoDuration(int i) {
        this.mew = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!at.isEmpty(str)) {
            this.alT = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!at.isEmpty(str)) {
            duL();
            this.eul = str;
            String Qu = Qu(str);
            if (meq != null) {
                this.mer = meq.aE(this.alT, this.eul, null);
                if (this.mer != null) {
                    this.mer.tc(CyberPlayerManager.hasCacheFile(Qu));
                }
            }
            this.ZZ.setPlayer(this);
            if (this.mep != null) {
                this.mep.duJ();
            }
            z(Uri.parse(Qu));
            if (this.mer != null) {
                this.mer.dbE();
            }
            String host = Uri.parse(this.eul).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mew < 900)) ? "1" : "0");
            super.setVideoPath(Qu);
        }
    }

    private void duL() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mev = true;
            if (!duP()) {
                aVar.duU();
            }
            if (!duO()) {
                aVar.duV();
                this.meo = true;
                setVideoPath(this.eul, this.alT);
                return;
            }
        } else {
            this.mev = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.meu) {
            ai.a(this.alP, true);
            setVolume(1.0f, 1.0f);
        }
        this.meo = true;
        super.start();
        if (this.mep != null) {
            this.mep.onStart();
        }
        this.ZZ.start();
        try {
            if (this.met != null && !this.met.isHeld()) {
                this.met.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().EG(-400);
            getVideoMonitor().am(this.kSb, this.kSc);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.meo) {
            a(aVar);
            return;
        }
        this.meo = true;
        if (aVar != null) {
            this.mev = true;
            if (!duP()) {
                aVar.duU();
            }
        } else {
            this.mev = false;
        }
        setVideoPath(this.eul, this.alT);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ai.a(this.alP, false);
        if (isPlaying() && duN()) {
            n.duF().bA(this.eul, getCurrentPositionSync());
        }
        super.pause();
        if (this.mep != null) {
            this.mep.onPause();
        }
        try {
            if (this.met != null && this.met.isHeld()) {
                this.met.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mer != null) {
            this.mer.dbF();
        }
    }

    public void stop() {
        if (!this.mev) {
            stopPlayback();
            return;
        }
        if (this.eul != null && isPlaying()) {
            ai.a(this.alP, false);
        }
        this.meo = false;
        if (isPlaying() && duN()) {
            n.duF().bA(this.eul, getCurrentPositionSync());
        }
        try {
            if (this.met != null && this.met.isHeld()) {
                this.met.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mep != null) {
            this.mep.onStop();
        }
        this.ZZ.stop();
        if (this.mer != null && this.mer.Oy(this.mes)) {
            this.mer = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eul != null && isPlaying()) {
            ai.a(this.alP, false);
        }
        this.meo = false;
        if (isPlaying() && duN()) {
            n.duF().bA(this.eul, getCurrentPositionSync());
        }
        try {
            if (this.met != null && this.met.isHeld()) {
                this.met.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.duT().Qw(this.eul);
        if (this.mep != null) {
            this.mep.onStop();
        }
        this.ZZ.stop();
        if (this.mer != null && this.mer.Oy(this.mes)) {
            this.mer = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public int getCurrentPositionSync() {
        if (getCyberPlayer() == null) {
            return 0;
        }
        return getCyberPlayer().getCurrentPositionSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.imp);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.meD != null) {
            this.meD.onSurfaceDestroyed();
        }
        try {
            if (this.met != null && this.met.isHeld()) {
                this.met.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.imp);
    }

    private String Qu(String str) {
        if (!at.isEmpty(str) && g.dLS().dLT()) {
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

    public boolean duM() {
        return this.meo;
    }

    public void h(long j, long j2, long j3) {
        if (this.mer != null) {
            this.mer.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean duN() {
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

    public void setLocateSource(String str) {
        this.mes = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.mer != null) {
            return this.mer;
        }
        if (!StringUtils.isNull(this.eul) && meq != null) {
            this.mer = meq.aE(this.alT, this.eul, null);
        }
        return this.mer;
    }

    private boolean duO() {
        return this == TbVideoViewSet.duT().Qv(this.eul);
    }

    private boolean duP() {
        return getParent() != null;
    }

    public void duQ() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.meD = null;
        this.mez = null;
        this.meB = null;
        this.meC = null;
        this.mey = null;
        this.meA = null;
        this.ZZ.a((f.b) null);
        this.ZZ.a((f.a) null);
        this.ZZ.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.ZZ;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mev = z;
    }

    @Deprecated
    public void duR() {
        if (this.mep != null) {
            this.mep.duJ();
            this.mep.gw(getDuration());
            this.mep.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().tc(CyberPlayerManager.hasCacheFile(this.eul));
            getVideoMonitor().EF(-400);
        }
    }

    @Deprecated
    public void duS() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().tc(CyberPlayerManager.hasCacheFile(this.eul));
            getVideoMonitor().dbE();
            getVideoMonitor().EE(-400);
        }
    }
}
