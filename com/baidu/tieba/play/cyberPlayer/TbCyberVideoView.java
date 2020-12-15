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
    private static l myN;
    private f aba;
    private String amY;
    private String eFu;
    private final CustomMessageListener iDV;
    private CyberPlayerManager.OnErrorListener kUr;
    private boolean llK;
    private boolean llL;
    private WeakReference<Context> mWeakContext;
    private boolean myK;
    private boolean myL;
    private b myM;
    private i myO;
    private String myP;
    private PowerManager.WakeLock myQ;
    private boolean myR;
    private boolean myS;
    private int myT;
    private int myU;
    private boolean myV;
    private CyberPlayerManager.OnPreparedListener myW;
    private CyberPlayerManager.OnCompletionListener myX;
    private CyberPlayerManager.OnSeekCompleteListener myY;
    private CyberPlayerManager.OnErrorListener myZ;
    private CyberPlayerManager.OnInfoListener mza;
    private a mzb;
    private CyberPlayerManager.OnPreparedListener mzc;
    private CyberPlayerManager.OnCompletionListener mzd;
    private CyberPlayerManager.OnSeekCompleteListener mze;
    private CyberPlayerManager.OnInfoListener mzf;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            myN = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.myR = false;
        this.myS = false;
        this.myV = false;
        this.mzc = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Ro;
                if (TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Ge(-400);
                }
                if (!TbCyberVideoView.this.myV) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCo().a(TbCyberVideoView.this, TbCyberVideoView.this.eFu);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.myW != null) {
                    TbCyberVideoView.this.myW.onPrepared();
                }
                if (TbCyberVideoView.this.myK && (Ro = n.dCa().Ro(TbCyberVideoView.this.eFu)) > 0) {
                    TbCyberVideoView.this.seekTo(Ro);
                }
                if (TbCyberVideoView.this.myL) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.myO != null) {
                    TbCyberVideoView.this.myO.Pr(TbCyberVideoView.this.myP);
                    TbCyberVideoView.this.myO = null;
                }
                n.dCa().remove(TbCyberVideoView.this.eFu);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.myM != null) {
                        TbCyberVideoView.this.myM.onComplete();
                    }
                    TbCyberVideoView.this.myL = false;
                    if (TbCyberVideoView.this.myX != null) {
                        TbCyberVideoView.this.myX.onCompletion();
                    }
                }
            }
        };
        this.kUr = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dCi()) {
                    n.dCa().bD(TbCyberVideoView.this.eFu, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCo().Rr(TbCyberVideoView.this.eFu);
                if (TbCyberVideoView.this.myZ != null) {
                    TbCyberVideoView.this.myZ.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mze = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.myY != null) {
                    TbCyberVideoView.this.myY.onSeekComplete();
                }
            }
        };
        this.mzf = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mza != null) {
                    TbCyberVideoView.this.mza.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().G(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iDV = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.myO != null) {
                        TbCyberVideoView.this.myO.Pq(TbCyberVideoView.this.myP);
                        TbCyberVideoView.this.myO = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.myR = false;
        this.myS = false;
        this.myV = false;
        this.mzc = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Ro;
                if (TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Ge(-400);
                }
                if (!TbCyberVideoView.this.myV) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCo().a(TbCyberVideoView.this, TbCyberVideoView.this.eFu);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.myW != null) {
                    TbCyberVideoView.this.myW.onPrepared();
                }
                if (TbCyberVideoView.this.myK && (Ro = n.dCa().Ro(TbCyberVideoView.this.eFu)) > 0) {
                    TbCyberVideoView.this.seekTo(Ro);
                }
                if (TbCyberVideoView.this.myL) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.myO != null) {
                    TbCyberVideoView.this.myO.Pr(TbCyberVideoView.this.myP);
                    TbCyberVideoView.this.myO = null;
                }
                n.dCa().remove(TbCyberVideoView.this.eFu);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.myM != null) {
                        TbCyberVideoView.this.myM.onComplete();
                    }
                    TbCyberVideoView.this.myL = false;
                    if (TbCyberVideoView.this.myX != null) {
                        TbCyberVideoView.this.myX.onCompletion();
                    }
                }
            }
        };
        this.kUr = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dCi()) {
                    n.dCa().bD(TbCyberVideoView.this.eFu, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCo().Rr(TbCyberVideoView.this.eFu);
                if (TbCyberVideoView.this.myZ != null) {
                    TbCyberVideoView.this.myZ.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mze = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.myY != null) {
                    TbCyberVideoView.this.myY.onSeekComplete();
                }
            }
        };
        this.mzf = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mza != null) {
                    TbCyberVideoView.this.mza.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().G(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iDV = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.myO != null) {
                        TbCyberVideoView.this.myO.Pq(TbCyberVideoView.this.myP);
                        TbCyberVideoView.this.myO = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.myR = false;
        this.myS = false;
        this.myV = false;
        this.mzc = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Ro;
                if (TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Ge(-400);
                }
                if (!TbCyberVideoView.this.myV) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCo().a(TbCyberVideoView.this, TbCyberVideoView.this.eFu);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.myW != null) {
                    TbCyberVideoView.this.myW.onPrepared();
                }
                if (TbCyberVideoView.this.myK && (Ro = n.dCa().Ro(TbCyberVideoView.this.eFu)) > 0) {
                    TbCyberVideoView.this.seekTo(Ro);
                }
                if (TbCyberVideoView.this.myL) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.myO != null) {
                    TbCyberVideoView.this.myO.Pr(TbCyberVideoView.this.myP);
                    TbCyberVideoView.this.myO = null;
                }
                n.dCa().remove(TbCyberVideoView.this.eFu);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.myM != null) {
                        TbCyberVideoView.this.myM.onComplete();
                    }
                    TbCyberVideoView.this.myL = false;
                    if (TbCyberVideoView.this.myX != null) {
                        TbCyberVideoView.this.myX.onCompletion();
                    }
                }
            }
        };
        this.kUr = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dCi()) {
                    n.dCa().bD(TbCyberVideoView.this.eFu, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCo().Rr(TbCyberVideoView.this.eFu);
                if (TbCyberVideoView.this.myZ != null) {
                    TbCyberVideoView.this.myZ.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mze = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.myY != null) {
                    TbCyberVideoView.this.myY.onSeekComplete();
                }
            }
        };
        this.mzf = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mza != null) {
                    TbCyberVideoView.this.mza.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().G(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.myM != null) {
                    TbCyberVideoView.this.myM.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iDV = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.myO != null) {
                        TbCyberVideoView.this.myO.Pq(TbCyberVideoView.this.myP);
                        TbCyberVideoView.this.myO = null;
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
                this.myQ = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.myQ.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.mzc);
        super.setOnCompletionListener(this.mzd);
        super.setOnErrorListener(this.kUr);
        super.setOnSeekCompleteListener(this.mze);
        super.setOnInfoListener(this.mzf);
        this.myM = new b();
        this.aba = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void A(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dCc()) {
            if (!pcdnConfigData.z(uri)) {
                this.myU = 2;
                return;
            } else if (c.dCt() <= 0) {
                this.myU = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dCd() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dCt()));
                this.llK = true;
                this.llL = pcdnConfigData.dCd();
                this.myU = 1;
                return;
            }
        }
        this.myU = 0;
    }

    public int getPcdnState() {
        return this.myU;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.myR = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ai.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.myR = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.myM == null) {
            this.myM = new b();
        }
        this.myM.setVideoStatsData(oVar);
        if (oVar != null) {
            this.myP = oVar.mLocate;
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
        if (this.myM == null) {
            this.myM = new b();
        }
        this.myM.setThreadData(byVar);
    }

    public void setPlayMode(String str) {
        if (this.myM != null) {
            this.myM.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.myM = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.myW = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.myX = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.myZ = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.myY = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mza = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mzb = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.myK = z;
    }

    public String getOriginUrl() {
        return this.eFu;
    }

    public void setVideoDuration(int i) {
        this.myT = i;
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
            dCg();
            this.eFu = str;
            String Rp = Rp(str);
            if (myN != null) {
                this.myO = myN.aI(this.amY, this.eFu, null);
                if (this.myO != null) {
                    this.myO.tQ(CyberPlayerManager.hasCacheFile(Rp));
                }
            }
            this.aba.setPlayer(this);
            if (this.myM != null) {
                this.myM.dCe();
            }
            A(Uri.parse(Rp));
            if (this.myO != null) {
                this.myO.diP();
            }
            String host = Uri.parse(this.eFu).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.myT < 900)) ? "1" : "0");
            super.setVideoPath(Rp);
        }
    }

    private void dCg() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.myS = true;
            if (!dCk()) {
                aVar.dCp();
            }
            if (!dCj()) {
                aVar.dCq();
                this.myL = true;
                setVideoPath(this.eFu, this.amY);
                return;
            }
        } else {
            this.myS = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.myR) {
            ai.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.myL = true;
        super.start();
        if (this.myM != null) {
            this.myM.onStart();
        }
        this.aba.start();
        try {
            if (this.myQ != null && !this.myQ.isHeld()) {
                this.myQ.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().Gg(-400);
            getVideoMonitor().am(this.llK, this.llL);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.myL) {
            a(aVar);
            return;
        }
        this.myL = true;
        if (aVar != null) {
            this.myS = true;
            if (!dCk()) {
                aVar.dCp();
            }
        } else {
            this.myS = false;
        }
        setVideoPath(this.eFu, this.amY);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ai.a(this.mWeakContext, false);
        if (isPlaying() && dCi()) {
            n.dCa().bD(this.eFu, getCurrentPositionSync());
        }
        super.pause();
        if (this.myM != null) {
            this.myM.onPause();
        }
        try {
            if (this.myQ != null && this.myQ.isHeld()) {
                this.myQ.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.myO != null) {
            this.myO.diQ();
        }
    }

    public void stop() {
        if (!this.myS) {
            stopPlayback();
            return;
        }
        if (this.eFu != null && isPlaying()) {
            ai.a(this.mWeakContext, false);
        }
        this.myL = false;
        if (isPlaying() && dCi()) {
            n.dCa().bD(this.eFu, getCurrentPositionSync());
        }
        try {
            if (this.myQ != null && this.myQ.isHeld()) {
                this.myQ.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.myM != null) {
            this.myM.onStop();
        }
        this.aba.stop();
        if (this.myO != null && this.myO.Ps(this.myP)) {
            this.myO = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eFu != null && isPlaying()) {
            ai.a(this.mWeakContext, false);
        }
        this.myL = false;
        if (isPlaying() && dCi()) {
            n.dCa().bD(this.eFu, getCurrentPositionSync());
        }
        try {
            if (this.myQ != null && this.myQ.isHeld()) {
                this.myQ.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dCo().Rr(this.eFu);
        if (this.myM != null) {
            this.myM.onStop();
        }
        this.aba.stop();
        if (this.myO != null && this.myO.Ps(this.myP)) {
            this.myO = null;
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
        MessageManager.getInstance().registerListener(this.iDV);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mzb != null) {
            this.mzb.onSurfaceDestroyed();
        }
        try {
            if (this.myQ != null && this.myQ.isHeld()) {
                this.myQ.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.iDV);
    }

    private String Rp(String str) {
        if (!au.isEmpty(str) && g.dTM().dTN()) {
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

    public boolean dCh() {
        return this.myL;
    }

    public void h(long j, long j2, long j3) {
        if (this.myO != null) {
            this.myO.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dCi() {
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
        this.myP = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.myO != null) {
            return this.myO;
        }
        if (!StringUtils.isNull(this.eFu) && myN != null) {
            this.myO = myN.aI(this.amY, this.eFu, null);
        }
        return this.myO;
    }

    private boolean dCj() {
        return this == TbVideoViewSet.dCo().Rq(this.eFu);
    }

    private boolean dCk() {
        return getParent() != null;
    }

    public void dCl() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mzb = null;
        this.myX = null;
        this.myZ = null;
        this.mza = null;
        this.myW = null;
        this.myY = null;
        this.aba.a((f.b) null);
        this.aba.a((f.a) null);
        this.aba.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.aba;
    }

    public void setTryUseViewInSet(boolean z) {
        this.myS = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.myV = z;
    }

    @Deprecated
    public void dCm() {
        if (this.myM != null) {
            this.myM.dCe();
            this.myM.hA(getDuration());
            this.myM.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().tQ(CyberPlayerManager.hasCacheFile(this.eFu));
            getVideoMonitor().Gf(-400);
        }
    }

    @Deprecated
    public void dCn() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().tQ(CyberPlayerManager.hasCacheFile(this.eFu));
            getVideoMonitor().diP();
            getVideoMonitor().Ge(-400);
        }
    }
}
