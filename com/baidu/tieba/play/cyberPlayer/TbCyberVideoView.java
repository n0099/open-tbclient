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
    private static l lCC;
    private f ZI;
    private String alA;
    private WeakReference<Context> alw;
    private String dZJ;
    private final CustomMessageListener hKT;
    private CyberPlayerManager.OnErrorListener jZc;
    private boolean kqs;
    private boolean kqt;
    private boolean lCA;
    private b lCB;
    private i lCD;
    private String lCE;
    private PowerManager.WakeLock lCF;
    private boolean lCG;
    private boolean lCH;
    private int lCI;
    private int lCJ;
    private CyberPlayerManager.OnPreparedListener lCK;
    private CyberPlayerManager.OnCompletionListener lCL;
    private CyberPlayerManager.OnSeekCompleteListener lCM;
    private CyberPlayerManager.OnErrorListener lCN;
    private CyberPlayerManager.OnInfoListener lCO;
    private a lCP;
    private CyberPlayerManager.OnPreparedListener lCQ;
    private CyberPlayerManager.OnCompletionListener lCR;
    private CyberPlayerManager.OnSeekCompleteListener lCS;
    private CyberPlayerManager.OnInfoListener lCT;
    private boolean lCz;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            lCC = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alw = null;
        this.lCG = false;
        this.lCH = false;
        this.lCQ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Pg;
                if (TbCyberVideoView.this.lCB != null) {
                    TbCyberVideoView.this.lCB.gd(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().DF(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dob().a(TbCyberVideoView.this, TbCyberVideoView.this.dZJ);
                    if (TbCyberVideoView.this.lCK != null) {
                        TbCyberVideoView.this.lCK.onPrepared();
                    }
                    if (TbCyberVideoView.this.lCz && (Pg = n.dnN().Pg(TbCyberVideoView.this.dZJ)) > 0) {
                        TbCyberVideoView.this.seekTo(Pg);
                    }
                    if (TbCyberVideoView.this.lCA) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lCR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.lCD != null) {
                    TbCyberVideoView.this.lCD.Nk(TbCyberVideoView.this.lCE);
                    TbCyberVideoView.this.lCD = null;
                }
                n.dnN().remove(TbCyberVideoView.this.dZJ);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.lCB != null) {
                        TbCyberVideoView.this.lCB.onComplete();
                    }
                    TbCyberVideoView.this.lCA = false;
                    if (TbCyberVideoView.this.lCL != null) {
                        TbCyberVideoView.this.lCL.onCompletion();
                    }
                }
            }
        };
        this.jZc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dnV()) {
                    n.dnN().by(TbCyberVideoView.this.dZJ, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dob().Pj(TbCyberVideoView.this.dZJ);
                if (TbCyberVideoView.this.lCN != null) {
                    TbCyberVideoView.this.lCN.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lCS = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.lCM != null) {
                    TbCyberVideoView.this.lCM.onSeekComplete();
                }
            }
        };
        this.lCT = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.lCO != null) {
                    TbCyberVideoView.this.lCO.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().w(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.lCB != null) {
                    TbCyberVideoView.this.lCB.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hKT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.lCD != null) {
                        TbCyberVideoView.this.lCD.Nj(TbCyberVideoView.this.lCE);
                        TbCyberVideoView.this.lCD = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.alw = null;
        this.lCG = false;
        this.lCH = false;
        this.lCQ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Pg;
                if (TbCyberVideoView.this.lCB != null) {
                    TbCyberVideoView.this.lCB.gd(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().DF(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dob().a(TbCyberVideoView.this, TbCyberVideoView.this.dZJ);
                    if (TbCyberVideoView.this.lCK != null) {
                        TbCyberVideoView.this.lCK.onPrepared();
                    }
                    if (TbCyberVideoView.this.lCz && (Pg = n.dnN().Pg(TbCyberVideoView.this.dZJ)) > 0) {
                        TbCyberVideoView.this.seekTo(Pg);
                    }
                    if (TbCyberVideoView.this.lCA) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lCR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.lCD != null) {
                    TbCyberVideoView.this.lCD.Nk(TbCyberVideoView.this.lCE);
                    TbCyberVideoView.this.lCD = null;
                }
                n.dnN().remove(TbCyberVideoView.this.dZJ);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.lCB != null) {
                        TbCyberVideoView.this.lCB.onComplete();
                    }
                    TbCyberVideoView.this.lCA = false;
                    if (TbCyberVideoView.this.lCL != null) {
                        TbCyberVideoView.this.lCL.onCompletion();
                    }
                }
            }
        };
        this.jZc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dnV()) {
                    n.dnN().by(TbCyberVideoView.this.dZJ, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dob().Pj(TbCyberVideoView.this.dZJ);
                if (TbCyberVideoView.this.lCN != null) {
                    TbCyberVideoView.this.lCN.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lCS = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.lCM != null) {
                    TbCyberVideoView.this.lCM.onSeekComplete();
                }
            }
        };
        this.lCT = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.lCO != null) {
                    TbCyberVideoView.this.lCO.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().w(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.lCB != null) {
                    TbCyberVideoView.this.lCB.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hKT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.lCD != null) {
                        TbCyberVideoView.this.lCD.Nj(TbCyberVideoView.this.lCE);
                        TbCyberVideoView.this.lCD = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.alw = null;
        this.lCG = false;
        this.lCH = false;
        this.lCQ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Pg;
                if (TbCyberVideoView.this.lCB != null) {
                    TbCyberVideoView.this.lCB.gd(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().DF(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dob().a(TbCyberVideoView.this, TbCyberVideoView.this.dZJ);
                    if (TbCyberVideoView.this.lCK != null) {
                        TbCyberVideoView.this.lCK.onPrepared();
                    }
                    if (TbCyberVideoView.this.lCz && (Pg = n.dnN().Pg(TbCyberVideoView.this.dZJ)) > 0) {
                        TbCyberVideoView.this.seekTo(Pg);
                    }
                    if (TbCyberVideoView.this.lCA) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lCR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.lCD != null) {
                    TbCyberVideoView.this.lCD.Nk(TbCyberVideoView.this.lCE);
                    TbCyberVideoView.this.lCD = null;
                }
                n.dnN().remove(TbCyberVideoView.this.dZJ);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.lCB != null) {
                        TbCyberVideoView.this.lCB.onComplete();
                    }
                    TbCyberVideoView.this.lCA = false;
                    if (TbCyberVideoView.this.lCL != null) {
                        TbCyberVideoView.this.lCL.onCompletion();
                    }
                }
            }
        };
        this.jZc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dnV()) {
                    n.dnN().by(TbCyberVideoView.this.dZJ, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dob().Pj(TbCyberVideoView.this.dZJ);
                if (TbCyberVideoView.this.lCN != null) {
                    TbCyberVideoView.this.lCN.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lCS = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.lCM != null) {
                    TbCyberVideoView.this.lCM.onSeekComplete();
                }
            }
        };
        this.lCT = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.lCO != null) {
                    TbCyberVideoView.this.lCO.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().w(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.lCB != null) {
                    TbCyberVideoView.this.lCB.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hKT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.lCD != null) {
                        TbCyberVideoView.this.lCD.Nj(TbCyberVideoView.this.lCE);
                        TbCyberVideoView.this.lCD = null;
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
                this.lCF = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.lCF.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.alw = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.lCQ);
        super.setOnCompletionListener(this.lCR);
        super.setOnErrorListener(this.jZc);
        super.setOnSeekCompleteListener(this.lCS);
        super.setOnInfoListener(this.lCT);
        this.lCB = new b();
        this.ZI = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void z(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dnP()) {
            if (!pcdnConfigData.y(uri)) {
                this.lCJ = 2;
                return;
            } else if (c.dog() <= 0) {
                this.lCJ = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dnQ() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dog()));
                this.kqs = true;
                this.kqt = pcdnConfigData.dnQ();
                this.lCJ = 1;
                return;
            }
        }
        this.lCJ = 0;
    }

    public int getPcdnState() {
        return this.lCJ;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.lCG = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ai.a(this.alw, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.lCG = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.lCB == null) {
            this.lCB = new b();
        }
        this.lCB.setVideoStatsData(oVar);
        if (oVar != null) {
            this.lCE = oVar.mLocate;
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
        if (this.lCB == null) {
            this.lCB = new b();
        }
        this.lCB.setThreadData(bwVar);
    }

    public void setPlayMode(String str) {
        if (this.lCB != null) {
            this.lCB.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.lCB = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.lCK = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lCL = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lCN = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.lCM = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.lCO = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.lCP = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.lCz = z;
    }

    public String getOriginUrl() {
        return this.dZJ;
    }

    public void setVideoDuration(int i) {
        this.lCI = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!at.isEmpty(str)) {
            this.alA = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!at.isEmpty(str)) {
            dnT();
            this.dZJ = str;
            String Ph = Ph(str);
            if (lCC != null) {
                this.lCD = lCC.av(this.alA, this.dZJ, null);
                if (this.lCD != null) {
                    this.lCD.se(CyberPlayerManager.hasCacheFile(Ph));
                }
            }
            this.ZI.setPlayer(this);
            if (this.lCB != null) {
                this.lCB.dnR();
            }
            z(Uri.parse(Ph));
            if (this.lCD != null) {
                this.lCD.cUN();
            }
            String host = Uri.parse(this.dZJ).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.lCI < 900)) ? "1" : "0");
            super.setVideoPath(Ph);
        }
    }

    private void dnT() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.lCH = true;
            if (!dnX()) {
                aVar.doc();
            }
            if (!dnW()) {
                aVar.dod();
                this.lCA = true;
                setVideoPath(this.dZJ, this.alA);
                return;
            }
        } else {
            this.lCH = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.lCG) {
            ai.a(this.alw, true);
            setVolume(1.0f, 1.0f);
        }
        this.lCA = true;
        super.start();
        if (this.lCB != null) {
            this.lCB.onStart();
        }
        this.ZI.start();
        try {
            if (this.lCF != null && !this.lCF.isHeld()) {
                this.lCF.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().DH(-400);
            getVideoMonitor().ak(this.kqs, this.kqt);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.lCA) {
            a(aVar);
            return;
        }
        this.lCA = true;
        if (aVar != null) {
            this.lCH = true;
            if (!dnX()) {
                aVar.doc();
            }
        } else {
            this.lCH = false;
        }
        setVideoPath(this.dZJ, this.alA);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ai.a(this.alw, false);
        if (isPlaying() && dnV()) {
            n.dnN().by(this.dZJ, getCurrentPositionSync());
        }
        super.pause();
        if (this.lCB != null) {
            this.lCB.onPause();
        }
        try {
            if (this.lCF != null && this.lCF.isHeld()) {
                this.lCF.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.lCD != null) {
            this.lCD.cUO();
        }
    }

    public void stop() {
        if (!this.lCH) {
            stopPlayback();
            return;
        }
        if (this.dZJ != null && isPlaying()) {
            ai.a(this.alw, false);
        }
        this.lCA = false;
        if (isPlaying() && dnV()) {
            n.dnN().by(this.dZJ, getCurrentPositionSync());
        }
        try {
            if (this.lCF != null && this.lCF.isHeld()) {
                this.lCF.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.lCB != null) {
            this.lCB.onStop();
        }
        this.ZI.stop();
        if (this.lCD != null && this.lCD.Nl(this.lCE)) {
            this.lCD = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.dZJ != null && isPlaying()) {
            ai.a(this.alw, false);
        }
        this.lCA = false;
        if (isPlaying() && dnV()) {
            n.dnN().by(this.dZJ, getCurrentPositionSync());
        }
        try {
            if (this.lCF != null && this.lCF.isHeld()) {
                this.lCF.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dob().Pj(this.dZJ);
        if (this.lCB != null) {
            this.lCB.onStop();
        }
        this.ZI.stop();
        if (this.lCD != null && this.lCD.Nl(this.lCE)) {
            this.lCD = null;
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
        MessageManager.getInstance().registerListener(this.hKT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.lCP != null) {
            this.lCP.onSurfaceDestroyed();
        }
        try {
            if (this.lCF != null && this.lCF.isHeld()) {
                this.lCF.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.hKT);
    }

    private String Ph(String str) {
        if (!at.isEmpty(str) && g.dEY().dEZ()) {
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

    public boolean dnU() {
        return this.lCA;
    }

    public void h(long j, long j2, long j3) {
        if (this.lCD != null) {
            this.lCD.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dnV() {
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
        this.lCE = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.lCD != null) {
            return this.lCD;
        }
        if (!StringUtils.isNull(this.dZJ) && lCC != null) {
            this.lCD = lCC.av(this.alA, this.dZJ, null);
        }
        return this.lCD;
    }

    private boolean dnW() {
        return this == TbVideoViewSet.dob().Pi(this.dZJ);
    }

    private boolean dnX() {
        return getParent() != null;
    }

    public void dnY() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.lCP = null;
        this.lCL = null;
        this.lCN = null;
        this.lCO = null;
        this.lCK = null;
        this.lCM = null;
        this.ZI.a((f.b) null);
        this.ZI.a((f.a) null);
        this.ZI.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.ZI;
    }

    public void setTryUseViewInSet(boolean z) {
        this.lCH = z;
    }

    @Deprecated
    public void dnZ() {
        if (this.lCB != null) {
            this.lCB.dnR();
            this.lCB.gd(getDuration());
            this.lCB.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().se(CyberPlayerManager.hasCacheFile(this.dZJ));
            getVideoMonitor().DG(-400);
        }
    }

    @Deprecated
    public void doa() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().se(CyberPlayerManager.hasCacheFile(this.dZJ));
            getVideoMonitor().cUN();
            getVideoMonitor().DF(-400);
        }
    }
}
