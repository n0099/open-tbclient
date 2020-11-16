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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ah;
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
    private static l mkH;
    private f aaf;
    private WeakReference<Context> alV;
    private String alZ;
    private String eyv;
    private final CustomMessageListener itb;
    private CyberPlayerManager.OnErrorListener kGX;
    private boolean kYp;
    private boolean kYq;
    private boolean mkE;
    private boolean mkF;
    private b mkG;
    private i mkI;
    private String mkJ;
    private PowerManager.WakeLock mkK;
    private boolean mkL;
    private boolean mkM;
    private int mkN;
    private int mkO;
    private boolean mkP;
    private CyberPlayerManager.OnPreparedListener mkQ;
    private CyberPlayerManager.OnCompletionListener mkR;
    private CyberPlayerManager.OnSeekCompleteListener mkS;
    private CyberPlayerManager.OnErrorListener mkT;
    private CyberPlayerManager.OnInfoListener mkU;
    private a mkV;
    private CyberPlayerManager.OnPreparedListener mkW;
    private CyberPlayerManager.OnCompletionListener mkX;
    private CyberPlayerManager.OnSeekCompleteListener mkY;
    private CyberPlayerManager.OnInfoListener mkZ;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            mkH = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alV = null;
        this.mkL = false;
        this.mkM = false;
        this.mkP = false;
        this.mkW = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Qf;
                if (TbCyberVideoView.this.mkG != null) {
                    TbCyberVideoView.this.mkG.gV(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Fp(-400);
                }
                if (!TbCyberVideoView.this.mkP) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dwV().a(TbCyberVideoView.this, TbCyberVideoView.this.eyv);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mkQ != null) {
                    TbCyberVideoView.this.mkQ.onPrepared();
                }
                if (TbCyberVideoView.this.mkE && (Qf = n.dwH().Qf(TbCyberVideoView.this.eyv)) > 0) {
                    TbCyberVideoView.this.seekTo(Qf);
                }
                if (TbCyberVideoView.this.mkF) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mkX = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mkI != null) {
                    TbCyberVideoView.this.mkI.Ok(TbCyberVideoView.this.mkJ);
                    TbCyberVideoView.this.mkI = null;
                }
                n.dwH().remove(TbCyberVideoView.this.eyv);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mkG != null) {
                        TbCyberVideoView.this.mkG.onComplete();
                    }
                    TbCyberVideoView.this.mkF = false;
                    if (TbCyberVideoView.this.mkR != null) {
                        TbCyberVideoView.this.mkR.onCompletion();
                    }
                }
            }
        };
        this.kGX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dwP()) {
                    n.dwH().bB(TbCyberVideoView.this.eyv, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dwV().Qi(TbCyberVideoView.this.eyv);
                if (TbCyberVideoView.this.mkT != null) {
                    TbCyberVideoView.this.mkT.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mkY = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mkS != null) {
                    TbCyberVideoView.this.mkS.onSeekComplete();
                }
            }
        };
        this.mkZ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mkU != null) {
                    TbCyberVideoView.this.mkU.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().E(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mkG != null) {
                    TbCyberVideoView.this.mkG.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.itb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mkI != null) {
                        TbCyberVideoView.this.mkI.Oj(TbCyberVideoView.this.mkJ);
                        TbCyberVideoView.this.mkI = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.alV = null;
        this.mkL = false;
        this.mkM = false;
        this.mkP = false;
        this.mkW = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Qf;
                if (TbCyberVideoView.this.mkG != null) {
                    TbCyberVideoView.this.mkG.gV(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Fp(-400);
                }
                if (!TbCyberVideoView.this.mkP) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dwV().a(TbCyberVideoView.this, TbCyberVideoView.this.eyv);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mkQ != null) {
                    TbCyberVideoView.this.mkQ.onPrepared();
                }
                if (TbCyberVideoView.this.mkE && (Qf = n.dwH().Qf(TbCyberVideoView.this.eyv)) > 0) {
                    TbCyberVideoView.this.seekTo(Qf);
                }
                if (TbCyberVideoView.this.mkF) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mkX = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mkI != null) {
                    TbCyberVideoView.this.mkI.Ok(TbCyberVideoView.this.mkJ);
                    TbCyberVideoView.this.mkI = null;
                }
                n.dwH().remove(TbCyberVideoView.this.eyv);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mkG != null) {
                        TbCyberVideoView.this.mkG.onComplete();
                    }
                    TbCyberVideoView.this.mkF = false;
                    if (TbCyberVideoView.this.mkR != null) {
                        TbCyberVideoView.this.mkR.onCompletion();
                    }
                }
            }
        };
        this.kGX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dwP()) {
                    n.dwH().bB(TbCyberVideoView.this.eyv, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dwV().Qi(TbCyberVideoView.this.eyv);
                if (TbCyberVideoView.this.mkT != null) {
                    TbCyberVideoView.this.mkT.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mkY = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mkS != null) {
                    TbCyberVideoView.this.mkS.onSeekComplete();
                }
            }
        };
        this.mkZ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mkU != null) {
                    TbCyberVideoView.this.mkU.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().E(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mkG != null) {
                    TbCyberVideoView.this.mkG.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.itb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mkI != null) {
                        TbCyberVideoView.this.mkI.Oj(TbCyberVideoView.this.mkJ);
                        TbCyberVideoView.this.mkI = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.alV = null;
        this.mkL = false;
        this.mkM = false;
        this.mkP = false;
        this.mkW = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int Qf;
                if (TbCyberVideoView.this.mkG != null) {
                    TbCyberVideoView.this.mkG.gV(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Fp(-400);
                }
                if (!TbCyberVideoView.this.mkP) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dwV().a(TbCyberVideoView.this, TbCyberVideoView.this.eyv);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mkQ != null) {
                    TbCyberVideoView.this.mkQ.onPrepared();
                }
                if (TbCyberVideoView.this.mkE && (Qf = n.dwH().Qf(TbCyberVideoView.this.eyv)) > 0) {
                    TbCyberVideoView.this.seekTo(Qf);
                }
                if (TbCyberVideoView.this.mkF) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mkX = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mkI != null) {
                    TbCyberVideoView.this.mkI.Ok(TbCyberVideoView.this.mkJ);
                    TbCyberVideoView.this.mkI = null;
                }
                n.dwH().remove(TbCyberVideoView.this.eyv);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mkG != null) {
                        TbCyberVideoView.this.mkG.onComplete();
                    }
                    TbCyberVideoView.this.mkF = false;
                    if (TbCyberVideoView.this.mkR != null) {
                        TbCyberVideoView.this.mkR.onCompletion();
                    }
                }
            }
        };
        this.kGX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dwP()) {
                    n.dwH().bB(TbCyberVideoView.this.eyv, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dwV().Qi(TbCyberVideoView.this.eyv);
                if (TbCyberVideoView.this.mkT != null) {
                    TbCyberVideoView.this.mkT.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mkY = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mkS != null) {
                    TbCyberVideoView.this.mkS.onSeekComplete();
                }
            }
        };
        this.mkZ = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mkU != null) {
                    TbCyberVideoView.this.mkU.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().E(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mkG != null) {
                    TbCyberVideoView.this.mkG.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.itb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mkI != null) {
                        TbCyberVideoView.this.mkI.Oj(TbCyberVideoView.this.mkJ);
                        TbCyberVideoView.this.mkI = null;
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
                this.mkK = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.mkK.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.alV = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.mkW);
        super.setOnCompletionListener(this.mkX);
        super.setOnErrorListener(this.kGX);
        super.setOnSeekCompleteListener(this.mkY);
        super.setOnInfoListener(this.mkZ);
        this.mkG = new b();
        this.aaf = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void A(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dwJ()) {
            if (!pcdnConfigData.z(uri)) {
                this.mkO = 2;
                return;
            } else if (c.dxa() <= 0) {
                this.mkO = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dwK() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dxa()));
                this.kYp = true;
                this.kYq = pcdnConfigData.dwK();
                this.mkO = 1;
                return;
            }
        }
        this.mkO = 0;
    }

    public int getPcdnState() {
        return this.mkO;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mkL = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ah.a(this.alV, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mkL = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mkG == null) {
            this.mkG = new b();
        }
        this.mkG.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mkJ = oVar.mLocate;
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

    public void setThreadDataForStatistic(bx bxVar) {
        if (this.mkG == null) {
            this.mkG = new b();
        }
        this.mkG.setThreadData(bxVar);
    }

    public void setPlayMode(String str) {
        if (this.mkG != null) {
            this.mkG.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mkG = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mkQ = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mkR = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mkT = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mkS = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mkU = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mkV = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mkE = z;
    }

    public String getOriginUrl() {
        return this.eyv;
    }

    public void setVideoDuration(int i) {
        this.mkN = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!au.isEmpty(str)) {
            this.alZ = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!au.isEmpty(str)) {
            dwN();
            this.eyv = str;
            String Qg = Qg(str);
            if (mkH != null) {
                this.mkI = mkH.aF(this.alZ, this.eyv, null);
                if (this.mkI != null) {
                    this.mkI.to(CyberPlayerManager.hasCacheFile(Qg));
                }
            }
            this.aaf.setPlayer(this);
            if (this.mkG != null) {
                this.mkG.dwL();
            }
            A(Uri.parse(Qg));
            if (this.mkI != null) {
                this.mkI.ddD();
            }
            String host = Uri.parse(this.eyv).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mkN < 900)) ? "1" : "0");
            super.setVideoPath(Qg);
        }
    }

    private void dwN() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mkM = true;
            if (!dwR()) {
                aVar.dwW();
            }
            if (!dwQ()) {
                aVar.dwX();
                this.mkF = true;
                setVideoPath(this.eyv, this.alZ);
                return;
            }
        } else {
            this.mkM = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mkL) {
            ah.a(this.alV, true);
            setVolume(1.0f, 1.0f);
        }
        this.mkF = true;
        super.start();
        if (this.mkG != null) {
            this.mkG.onStart();
        }
        this.aaf.start();
        try {
            if (this.mkK != null && !this.mkK.isHeld()) {
                this.mkK.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().Fr(-400);
            getVideoMonitor().am(this.kYp, this.kYq);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.mkF) {
            a(aVar);
            return;
        }
        this.mkF = true;
        if (aVar != null) {
            this.mkM = true;
            if (!dwR()) {
                aVar.dwW();
            }
        } else {
            this.mkM = false;
        }
        setVideoPath(this.eyv, this.alZ);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ah.a(this.alV, false);
        if (isPlaying() && dwP()) {
            n.dwH().bB(this.eyv, getCurrentPositionSync());
        }
        super.pause();
        if (this.mkG != null) {
            this.mkG.onPause();
        }
        try {
            if (this.mkK != null && this.mkK.isHeld()) {
                this.mkK.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mkI != null) {
            this.mkI.ddE();
        }
    }

    public void stop() {
        if (!this.mkM) {
            stopPlayback();
            return;
        }
        if (this.eyv != null && isPlaying()) {
            ah.a(this.alV, false);
        }
        this.mkF = false;
        if (isPlaying() && dwP()) {
            n.dwH().bB(this.eyv, getCurrentPositionSync());
        }
        try {
            if (this.mkK != null && this.mkK.isHeld()) {
                this.mkK.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mkG != null) {
            this.mkG.onStop();
        }
        this.aaf.stop();
        if (this.mkI != null && this.mkI.Ol(this.mkJ)) {
            this.mkI = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eyv != null && isPlaying()) {
            ah.a(this.alV, false);
        }
        this.mkF = false;
        if (isPlaying() && dwP()) {
            n.dwH().bB(this.eyv, getCurrentPositionSync());
        }
        try {
            if (this.mkK != null && this.mkK.isHeld()) {
                this.mkK.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dwV().Qi(this.eyv);
        if (this.mkG != null) {
            this.mkG.onStop();
        }
        this.aaf.stop();
        if (this.mkI != null && this.mkI.Ol(this.mkJ)) {
            this.mkI = null;
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
        MessageManager.getInstance().registerListener(this.itb);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mkV != null) {
            this.mkV.onSurfaceDestroyed();
        }
        try {
            if (this.mkK != null && this.mkK.isHeld()) {
                this.mkK.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.itb);
    }

    private String Qg(String str) {
        if (!au.isEmpty(str) && g.dOt().dOu()) {
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

    public boolean dwO() {
        return this.mkF;
    }

    public void h(long j, long j2, long j3) {
        if (this.mkI != null) {
            this.mkI.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwP() {
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
        this.mkJ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.mkI != null) {
            return this.mkI;
        }
        if (!StringUtils.isNull(this.eyv) && mkH != null) {
            this.mkI = mkH.aF(this.alZ, this.eyv, null);
        }
        return this.mkI;
    }

    private boolean dwQ() {
        return this == TbVideoViewSet.dwV().Qh(this.eyv);
    }

    private boolean dwR() {
        return getParent() != null;
    }

    public void dwS() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mkV = null;
        this.mkR = null;
        this.mkT = null;
        this.mkU = null;
        this.mkQ = null;
        this.mkS = null;
        this.aaf.a((f.b) null);
        this.aaf.a((f.a) null);
        this.aaf.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.aaf;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mkM = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.mkP = z;
    }

    @Deprecated
    public void dwT() {
        if (this.mkG != null) {
            this.mkG.dwL();
            this.mkG.gV(getDuration());
            this.mkG.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().to(CyberPlayerManager.hasCacheFile(this.eyv));
            getVideoMonitor().Fq(-400);
        }
    }

    @Deprecated
    public void dwU() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().to(CyberPlayerManager.hasCacheFile(this.eyv));
            getVideoMonitor().ddD();
            getVideoMonitor().Fp(-400);
        }
    }
}
