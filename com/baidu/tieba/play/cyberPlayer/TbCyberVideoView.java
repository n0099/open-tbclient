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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.l.i;
import com.baidu.tieba.l.l;
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
    private static l myL;
    private f aba;
    private String amY;
    private String eFu;
    private final CustomMessageListener iDT;
    private CyberPlayerManager.OnErrorListener kUp;
    private boolean llI;
    private boolean llJ;
    private WeakReference<Context> mWeakContext;
    private boolean myI;
    private boolean myJ;
    private b myK;
    private i myM;
    private String myN;
    private PowerManager.WakeLock myO;
    private boolean myP;
    private boolean myQ;
    private int myR;
    private int myS;
    private boolean myT;
    private CyberPlayerManager.OnPreparedListener myU;
    private CyberPlayerManager.OnCompletionListener myV;
    private CyberPlayerManager.OnSeekCompleteListener myW;
    private CyberPlayerManager.OnErrorListener myX;
    private CyberPlayerManager.OnInfoListener myY;
    private a myZ;
    private CyberPlayerManager.OnPreparedListener mza;
    private CyberPlayerManager.OnCompletionListener mzb;
    private CyberPlayerManager.OnSeekCompleteListener mzc;
    private CyberPlayerManager.OnInfoListener mzd;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            myL = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.myP = false;
        this.myQ = false;
        this.myT = false;
        this.mza = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Ro;
                if (TbCyberVideoView.this.myK != null) {
                    TbCyberVideoView.this.myK.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Ge(-400);
                }
                if (!TbCyberVideoView.this.myT) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCn().a(TbCyberVideoView.this, TbCyberVideoView.this.eFu);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.myU != null) {
                    TbCyberVideoView.this.myU.onPrepared();
                }
                if (TbCyberVideoView.this.myI && (Ro = n.dBZ().Ro(TbCyberVideoView.this.eFu)) > 0) {
                    TbCyberVideoView.this.seekTo(Ro);
                }
                if (TbCyberVideoView.this.myJ) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzb = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.Pr(TbCyberVideoView.this.myN);
                    TbCyberVideoView.this.myM = null;
                }
                n.dBZ().remove(TbCyberVideoView.this.eFu);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.myK != null) {
                        TbCyberVideoView.this.myK.onComplete();
                    }
                    TbCyberVideoView.this.myJ = false;
                    if (TbCyberVideoView.this.myV != null) {
                        TbCyberVideoView.this.myV.onCompletion();
                    }
                }
            }
        };
        this.kUp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dCh()) {
                    n.dBZ().bD(TbCyberVideoView.this.eFu, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCn().Rr(TbCyberVideoView.this.eFu);
                if (TbCyberVideoView.this.myX != null) {
                    TbCyberVideoView.this.myX.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mzc = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.myW != null) {
                    TbCyberVideoView.this.myW.onSeekComplete();
                }
            }
        };
        this.mzd = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.myY != null) {
                    TbCyberVideoView.this.myY.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().G(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.myK != null) {
                    TbCyberVideoView.this.myK.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iDT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.myM != null) {
                        TbCyberVideoView.this.myM.Pq(TbCyberVideoView.this.myN);
                        TbCyberVideoView.this.myM = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.myP = false;
        this.myQ = false;
        this.myT = false;
        this.mza = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Ro;
                if (TbCyberVideoView.this.myK != null) {
                    TbCyberVideoView.this.myK.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Ge(-400);
                }
                if (!TbCyberVideoView.this.myT) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCn().a(TbCyberVideoView.this, TbCyberVideoView.this.eFu);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.myU != null) {
                    TbCyberVideoView.this.myU.onPrepared();
                }
                if (TbCyberVideoView.this.myI && (Ro = n.dBZ().Ro(TbCyberVideoView.this.eFu)) > 0) {
                    TbCyberVideoView.this.seekTo(Ro);
                }
                if (TbCyberVideoView.this.myJ) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzb = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.Pr(TbCyberVideoView.this.myN);
                    TbCyberVideoView.this.myM = null;
                }
                n.dBZ().remove(TbCyberVideoView.this.eFu);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.myK != null) {
                        TbCyberVideoView.this.myK.onComplete();
                    }
                    TbCyberVideoView.this.myJ = false;
                    if (TbCyberVideoView.this.myV != null) {
                        TbCyberVideoView.this.myV.onCompletion();
                    }
                }
            }
        };
        this.kUp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dCh()) {
                    n.dBZ().bD(TbCyberVideoView.this.eFu, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCn().Rr(TbCyberVideoView.this.eFu);
                if (TbCyberVideoView.this.myX != null) {
                    TbCyberVideoView.this.myX.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mzc = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.myW != null) {
                    TbCyberVideoView.this.myW.onSeekComplete();
                }
            }
        };
        this.mzd = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.myY != null) {
                    TbCyberVideoView.this.myY.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().G(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.myK != null) {
                    TbCyberVideoView.this.myK.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iDT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.myM != null) {
                        TbCyberVideoView.this.myM.Pq(TbCyberVideoView.this.myN);
                        TbCyberVideoView.this.myM = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.myP = false;
        this.myQ = false;
        this.myT = false;
        this.mza = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Ro;
                if (TbCyberVideoView.this.myK != null) {
                    TbCyberVideoView.this.myK.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Ge(-400);
                }
                if (!TbCyberVideoView.this.myT) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCn().a(TbCyberVideoView.this, TbCyberVideoView.this.eFu);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.myU != null) {
                    TbCyberVideoView.this.myU.onPrepared();
                }
                if (TbCyberVideoView.this.myI && (Ro = n.dBZ().Ro(TbCyberVideoView.this.eFu)) > 0) {
                    TbCyberVideoView.this.seekTo(Ro);
                }
                if (TbCyberVideoView.this.myJ) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzb = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.Pr(TbCyberVideoView.this.myN);
                    TbCyberVideoView.this.myM = null;
                }
                n.dBZ().remove(TbCyberVideoView.this.eFu);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.myK != null) {
                        TbCyberVideoView.this.myK.onComplete();
                    }
                    TbCyberVideoView.this.myJ = false;
                    if (TbCyberVideoView.this.myV != null) {
                        TbCyberVideoView.this.myV.onCompletion();
                    }
                }
            }
        };
        this.kUp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dCh()) {
                    n.dBZ().bD(TbCyberVideoView.this.eFu, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCn().Rr(TbCyberVideoView.this.eFu);
                if (TbCyberVideoView.this.myX != null) {
                    TbCyberVideoView.this.myX.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mzc = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.myW != null) {
                    TbCyberVideoView.this.myW.onSeekComplete();
                }
            }
        };
        this.mzd = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.myY != null) {
                    TbCyberVideoView.this.myY.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().G(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.myK != null) {
                    TbCyberVideoView.this.myK.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iDT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.myM != null) {
                        TbCyberVideoView.this.myM.Pq(TbCyberVideoView.this.myN);
                        TbCyberVideoView.this.myM = null;
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
                this.myO = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.myO.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.mza);
        super.setOnCompletionListener(this.mzb);
        super.setOnErrorListener(this.kUp);
        super.setOnSeekCompleteListener(this.mzc);
        super.setOnInfoListener(this.mzd);
        this.myK = new b();
        this.aba = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void A(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dCb()) {
            if (!pcdnConfigData.z(uri)) {
                this.myS = 2;
                return;
            } else if (c.dCs() <= 0) {
                this.myS = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dCc() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dCs()));
                this.llI = true;
                this.llJ = pcdnConfigData.dCc();
                this.myS = 1;
                return;
            }
        }
        this.myS = 0;
    }

    public int getPcdnState() {
        return this.myS;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.myP = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ai.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.myP = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.myK == null) {
            this.myK = new b();
        }
        this.myK.setVideoStatsData(oVar);
        if (oVar != null) {
            this.myN = oVar.mLocate;
        }
    }

    public void setStageType(String str) {
        if (au.isEmpty(str)) {
            str = "-1";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20484");
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void setThreadDataForStatistic(by byVar) {
        if (this.myK == null) {
            this.myK = new b();
        }
        this.myK.setThreadData(byVar);
    }

    public void setPlayMode(String str) {
        if (this.myK != null) {
            this.myK.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.myK = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.myU = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.myV = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.myX = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.myW = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.myY = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.myZ = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.myI = z;
    }

    public String getOriginUrl() {
        return this.eFu;
    }

    public void setVideoDuration(int i) {
        this.myR = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!au.isEmpty(str)) {
            this.amY = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!au.isEmpty(str)) {
            dCf();
            this.eFu = str;
            String Rp = Rp(str);
            if (myL != null) {
                this.myM = myL.aI(this.amY, this.eFu, null);
                if (this.myM != null) {
                    this.myM.tQ(CyberPlayerManager.hasCacheFile(Rp));
                }
            }
            this.aba.setPlayer(this);
            if (this.myK != null) {
                this.myK.dCd();
            }
            A(Uri.parse(Rp));
            if (this.myM != null) {
                this.myM.diO();
            }
            String host = Uri.parse(this.eFu).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.myR < 900)) ? "1" : "0");
            super.setVideoPath(Rp);
        }
    }

    private void dCf() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.myQ = true;
            if (!dCj()) {
                aVar.dCo();
            }
            if (!dCi()) {
                aVar.dCp();
                this.myJ = true;
                setVideoPath(this.eFu, this.amY);
                return;
            }
        } else {
            this.myQ = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.myP) {
            ai.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.myJ = true;
        super.start();
        if (this.myK != null) {
            this.myK.onStart();
        }
        this.aba.start();
        try {
            if (this.myO != null && !this.myO.isHeld()) {
                this.myO.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().Gg(-400);
            getVideoMonitor().am(this.llI, this.llJ);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.myJ) {
            a(aVar);
            return;
        }
        this.myJ = true;
        if (aVar != null) {
            this.myQ = true;
            if (!dCj()) {
                aVar.dCo();
            }
        } else {
            this.myQ = false;
        }
        setVideoPath(this.eFu, this.amY);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ai.a(this.mWeakContext, false);
        if (isPlaying() && dCh()) {
            n.dBZ().bD(this.eFu, getCurrentPositionSync());
        }
        super.pause();
        if (this.myK != null) {
            this.myK.onPause();
        }
        try {
            if (this.myO != null && this.myO.isHeld()) {
                this.myO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.myM != null) {
            this.myM.diP();
        }
    }

    public void stop() {
        if (!this.myQ) {
            stopPlayback();
            return;
        }
        if (this.eFu != null && isPlaying()) {
            ai.a(this.mWeakContext, false);
        }
        this.myJ = false;
        if (isPlaying() && dCh()) {
            n.dBZ().bD(this.eFu, getCurrentPositionSync());
        }
        try {
            if (this.myO != null && this.myO.isHeld()) {
                this.myO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.myK != null) {
            this.myK.onStop();
        }
        this.aba.stop();
        if (this.myM != null && this.myM.Ps(this.myN)) {
            this.myM = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eFu != null && isPlaying()) {
            ai.a(this.mWeakContext, false);
        }
        this.myJ = false;
        if (isPlaying() && dCh()) {
            n.dBZ().bD(this.eFu, getCurrentPositionSync());
        }
        try {
            if (this.myO != null && this.myO.isHeld()) {
                this.myO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dCn().Rr(this.eFu);
        if (this.myK != null) {
            this.myK.onStop();
        }
        this.aba.stop();
        if (this.myM != null && this.myM.Ps(this.myN)) {
            this.myM = null;
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
        MessageManager.getInstance().registerListener(this.iDT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.myZ != null) {
            this.myZ.onSurfaceDestroyed();
        }
        try {
            if (this.myO != null && this.myO.isHeld()) {
                this.myO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.iDT);
    }

    private String Rp(String str) {
        if (!au.isEmpty(str) && g.dTL().dTM()) {
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

    public boolean dCg() {
        return this.myJ;
    }

    public void h(long j, long j2, long j3) {
        if (this.myM != null) {
            this.myM.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dCh() {
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
        this.myN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.myM != null) {
            return this.myM;
        }
        if (!StringUtils.isNull(this.eFu) && myL != null) {
            this.myM = myL.aI(this.amY, this.eFu, null);
        }
        return this.myM;
    }

    private boolean dCi() {
        return this == TbVideoViewSet.dCn().Rq(this.eFu);
    }

    private boolean dCj() {
        return getParent() != null;
    }

    public void dCk() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.myZ = null;
        this.myV = null;
        this.myX = null;
        this.myY = null;
        this.myU = null;
        this.myW = null;
        this.aba.a((f.b) null);
        this.aba.a((f.a) null);
        this.aba.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.aba;
    }

    public void setTryUseViewInSet(boolean z) {
        this.myQ = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.myT = z;
    }

    @Deprecated
    public void dCl() {
        if (this.myK != null) {
            this.myK.dCd();
            this.myK.hA(getDuration());
            this.myK.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().tQ(CyberPlayerManager.hasCacheFile(this.eFu));
            getVideoMonitor().Gf(-400);
        }
    }

    @Deprecated
    public void dCm() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().tQ(CyberPlayerManager.hasCacheFile(this.eFu));
            getVideoMonitor().diO();
            getVideoMonitor().Ge(-400);
        }
    }
}
