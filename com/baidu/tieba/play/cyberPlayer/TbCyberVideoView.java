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
    private static l mko;
    private f ZZ;
    private WeakReference<Context> alP;
    private String alT;
    private String eAe;
    private final CustomMessageListener isn;
    private CyberPlayerManager.OnErrorListener kGI;
    private boolean kXX;
    private boolean kXY;
    private CyberPlayerManager.OnInfoListener mkA;
    private a mkB;
    private CyberPlayerManager.OnPreparedListener mkC;
    private CyberPlayerManager.OnCompletionListener mkD;
    private CyberPlayerManager.OnSeekCompleteListener mkE;
    private CyberPlayerManager.OnInfoListener mkF;
    private boolean mkl;
    private boolean mkm;
    private b mkn;
    private i mkp;
    private String mkq;
    private PowerManager.WakeLock mkr;
    private boolean mks;
    private boolean mkt;
    private int mku;
    private int mkv;
    private CyberPlayerManager.OnPreparedListener mkw;
    private CyberPlayerManager.OnCompletionListener mkx;
    private CyberPlayerManager.OnSeekCompleteListener mky;
    private CyberPlayerManager.OnErrorListener mkz;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            mko = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alP = null;
        this.mks = false;
        this.mkt = false;
        this.mkC = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QK;
                if (TbCyberVideoView.this.mkn != null) {
                    TbCyberVideoView.this.mkn.gS(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().ER(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dxv().a(TbCyberVideoView.this, TbCyberVideoView.this.eAe);
                    if (TbCyberVideoView.this.mkw != null) {
                        TbCyberVideoView.this.mkw.onPrepared();
                    }
                    if (TbCyberVideoView.this.mkl && (QK = n.dxh().QK(TbCyberVideoView.this.eAe)) > 0) {
                        TbCyberVideoView.this.seekTo(QK);
                    }
                    if (TbCyberVideoView.this.mkm) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.mkD = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mkp != null) {
                    TbCyberVideoView.this.mkp.OO(TbCyberVideoView.this.mkq);
                    TbCyberVideoView.this.mkp = null;
                }
                n.dxh().remove(TbCyberVideoView.this.eAe);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mkn != null) {
                        TbCyberVideoView.this.mkn.onComplete();
                    }
                    TbCyberVideoView.this.mkm = false;
                    if (TbCyberVideoView.this.mkx != null) {
                        TbCyberVideoView.this.mkx.onCompletion();
                    }
                }
            }
        };
        this.kGI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dxp()) {
                    n.dxh().bC(TbCyberVideoView.this.eAe, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dxv().QN(TbCyberVideoView.this.eAe);
                if (TbCyberVideoView.this.mkz != null) {
                    TbCyberVideoView.this.mkz.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mkE = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mky != null) {
                    TbCyberVideoView.this.mky.onSeekComplete();
                }
            }
        };
        this.mkF = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mkA != null) {
                    TbCyberVideoView.this.mkA.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().E(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mkn != null) {
                    TbCyberVideoView.this.mkn.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.isn = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mkp != null) {
                        TbCyberVideoView.this.mkp.ON(TbCyberVideoView.this.mkq);
                        TbCyberVideoView.this.mkp = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.alP = null;
        this.mks = false;
        this.mkt = false;
        this.mkC = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QK;
                if (TbCyberVideoView.this.mkn != null) {
                    TbCyberVideoView.this.mkn.gS(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().ER(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dxv().a(TbCyberVideoView.this, TbCyberVideoView.this.eAe);
                    if (TbCyberVideoView.this.mkw != null) {
                        TbCyberVideoView.this.mkw.onPrepared();
                    }
                    if (TbCyberVideoView.this.mkl && (QK = n.dxh().QK(TbCyberVideoView.this.eAe)) > 0) {
                        TbCyberVideoView.this.seekTo(QK);
                    }
                    if (TbCyberVideoView.this.mkm) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.mkD = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mkp != null) {
                    TbCyberVideoView.this.mkp.OO(TbCyberVideoView.this.mkq);
                    TbCyberVideoView.this.mkp = null;
                }
                n.dxh().remove(TbCyberVideoView.this.eAe);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mkn != null) {
                        TbCyberVideoView.this.mkn.onComplete();
                    }
                    TbCyberVideoView.this.mkm = false;
                    if (TbCyberVideoView.this.mkx != null) {
                        TbCyberVideoView.this.mkx.onCompletion();
                    }
                }
            }
        };
        this.kGI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dxp()) {
                    n.dxh().bC(TbCyberVideoView.this.eAe, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dxv().QN(TbCyberVideoView.this.eAe);
                if (TbCyberVideoView.this.mkz != null) {
                    TbCyberVideoView.this.mkz.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mkE = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mky != null) {
                    TbCyberVideoView.this.mky.onSeekComplete();
                }
            }
        };
        this.mkF = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mkA != null) {
                    TbCyberVideoView.this.mkA.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().E(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mkn != null) {
                    TbCyberVideoView.this.mkn.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.isn = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mkp != null) {
                        TbCyberVideoView.this.mkp.ON(TbCyberVideoView.this.mkq);
                        TbCyberVideoView.this.mkp = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.alP = null;
        this.mks = false;
        this.mkt = false;
        this.mkC = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QK;
                if (TbCyberVideoView.this.mkn != null) {
                    TbCyberVideoView.this.mkn.gS(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().ER(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dxv().a(TbCyberVideoView.this, TbCyberVideoView.this.eAe);
                    if (TbCyberVideoView.this.mkw != null) {
                        TbCyberVideoView.this.mkw.onPrepared();
                    }
                    if (TbCyberVideoView.this.mkl && (QK = n.dxh().QK(TbCyberVideoView.this.eAe)) > 0) {
                        TbCyberVideoView.this.seekTo(QK);
                    }
                    if (TbCyberVideoView.this.mkm) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.mkD = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mkp != null) {
                    TbCyberVideoView.this.mkp.OO(TbCyberVideoView.this.mkq);
                    TbCyberVideoView.this.mkp = null;
                }
                n.dxh().remove(TbCyberVideoView.this.eAe);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mkn != null) {
                        TbCyberVideoView.this.mkn.onComplete();
                    }
                    TbCyberVideoView.this.mkm = false;
                    if (TbCyberVideoView.this.mkx != null) {
                        TbCyberVideoView.this.mkx.onCompletion();
                    }
                }
            }
        };
        this.kGI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dxp()) {
                    n.dxh().bC(TbCyberVideoView.this.eAe, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dxv().QN(TbCyberVideoView.this.eAe);
                if (TbCyberVideoView.this.mkz != null) {
                    TbCyberVideoView.this.mkz.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mkE = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mky != null) {
                    TbCyberVideoView.this.mky.onSeekComplete();
                }
            }
        };
        this.mkF = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mkA != null) {
                    TbCyberVideoView.this.mkA.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().E(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mkn != null) {
                    TbCyberVideoView.this.mkn.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.isn = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mkp != null) {
                        TbCyberVideoView.this.mkp.ON(TbCyberVideoView.this.mkq);
                        TbCyberVideoView.this.mkp = null;
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
                this.mkr = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.mkr.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.alP = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.mkC);
        super.setOnCompletionListener(this.mkD);
        super.setOnErrorListener(this.kGI);
        super.setOnSeekCompleteListener(this.mkE);
        super.setOnInfoListener(this.mkF);
        this.mkn = new b();
        this.ZZ = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void z(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dxj()) {
            if (!pcdnConfigData.y(uri)) {
                this.mkv = 2;
                return;
            } else if (c.dxA() <= 0) {
                this.mkv = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dxk() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dxA()));
                this.kXX = true;
                this.kXY = pcdnConfigData.dxk();
                this.mkv = 1;
                return;
            }
        }
        this.mkv = 0;
    }

    public int getPcdnState() {
        return this.mkv;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mks = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ai.a(this.alP, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mks = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mkn == null) {
            this.mkn = new b();
        }
        this.mkn.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mkq = oVar.mLocate;
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
        if (this.mkn == null) {
            this.mkn = new b();
        }
        this.mkn.setThreadData(bwVar);
    }

    public void setPlayMode(String str) {
        if (this.mkn != null) {
            this.mkn.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mkn = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mkw = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mkx = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mkz = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mky = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mkA = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mkB = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mkl = z;
    }

    public String getOriginUrl() {
        return this.eAe;
    }

    public void setVideoDuration(int i) {
        this.mku = i;
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
            dxn();
            this.eAe = str;
            String QL = QL(str);
            if (mko != null) {
                this.mkp = mko.aF(this.alT, this.eAe, null);
                if (this.mkp != null) {
                    this.mkp.tl(CyberPlayerManager.hasCacheFile(QL));
                }
            }
            this.ZZ.setPlayer(this);
            if (this.mkn != null) {
                this.mkn.dxl();
            }
            z(Uri.parse(QL));
            if (this.mkp != null) {
                this.mkp.deg();
            }
            String host = Uri.parse(this.eAe).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mku < 900)) ? "1" : "0");
            super.setVideoPath(QL);
        }
    }

    private void dxn() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mkt = true;
            if (!dxr()) {
                aVar.dxw();
            }
            if (!dxq()) {
                aVar.dxx();
                this.mkm = true;
                setVideoPath(this.eAe, this.alT);
                return;
            }
        } else {
            this.mkt = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mks) {
            ai.a(this.alP, true);
            setVolume(1.0f, 1.0f);
        }
        this.mkm = true;
        super.start();
        if (this.mkn != null) {
            this.mkn.onStart();
        }
        this.ZZ.start();
        try {
            if (this.mkr != null && !this.mkr.isHeld()) {
                this.mkr.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().ET(-400);
            getVideoMonitor().am(this.kXX, this.kXY);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.mkm) {
            a(aVar);
            return;
        }
        this.mkm = true;
        if (aVar != null) {
            this.mkt = true;
            if (!dxr()) {
                aVar.dxw();
            }
        } else {
            this.mkt = false;
        }
        setVideoPath(this.eAe, this.alT);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ai.a(this.alP, false);
        if (isPlaying() && dxp()) {
            n.dxh().bC(this.eAe, getCurrentPositionSync());
        }
        super.pause();
        if (this.mkn != null) {
            this.mkn.onPause();
        }
        try {
            if (this.mkr != null && this.mkr.isHeld()) {
                this.mkr.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mkp != null) {
            this.mkp.deh();
        }
    }

    public void stop() {
        if (!this.mkt) {
            stopPlayback();
            return;
        }
        if (this.eAe != null && isPlaying()) {
            ai.a(this.alP, false);
        }
        this.mkm = false;
        if (isPlaying() && dxp()) {
            n.dxh().bC(this.eAe, getCurrentPositionSync());
        }
        try {
            if (this.mkr != null && this.mkr.isHeld()) {
                this.mkr.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mkn != null) {
            this.mkn.onStop();
        }
        this.ZZ.stop();
        if (this.mkp != null && this.mkp.OP(this.mkq)) {
            this.mkp = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eAe != null && isPlaying()) {
            ai.a(this.alP, false);
        }
        this.mkm = false;
        if (isPlaying() && dxp()) {
            n.dxh().bC(this.eAe, getCurrentPositionSync());
        }
        try {
            if (this.mkr != null && this.mkr.isHeld()) {
                this.mkr.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dxv().QN(this.eAe);
        if (this.mkn != null) {
            this.mkn.onStop();
        }
        this.ZZ.stop();
        if (this.mkp != null && this.mkp.OP(this.mkq)) {
            this.mkp = null;
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
        MessageManager.getInstance().registerListener(this.isn);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mkB != null) {
            this.mkB.onSurfaceDestroyed();
        }
        try {
            if (this.mkr != null && this.mkr.isHeld()) {
                this.mkr.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.isn);
    }

    private String QL(String str) {
        if (!at.isEmpty(str) && g.dOu().dOv()) {
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

    public boolean dxo() {
        return this.mkm;
    }

    public void h(long j, long j2, long j3) {
        if (this.mkp != null) {
            this.mkp.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxp() {
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
        this.mkq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.mkp != null) {
            return this.mkp;
        }
        if (!StringUtils.isNull(this.eAe) && mko != null) {
            this.mkp = mko.aF(this.alT, this.eAe, null);
        }
        return this.mkp;
    }

    private boolean dxq() {
        return this == TbVideoViewSet.dxv().QM(this.eAe);
    }

    private boolean dxr() {
        return getParent() != null;
    }

    public void dxs() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mkB = null;
        this.mkx = null;
        this.mkz = null;
        this.mkA = null;
        this.mkw = null;
        this.mky = null;
        this.ZZ.a((f.b) null);
        this.ZZ.a((f.a) null);
        this.ZZ.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.ZZ;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mkt = z;
    }

    @Deprecated
    public void dxt() {
        if (this.mkn != null) {
            this.mkn.dxl();
            this.mkn.gS(getDuration());
            this.mkn.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().tl(CyberPlayerManager.hasCacheFile(this.eAe));
            getVideoMonitor().ES(-400);
        }
    }

    @Deprecated
    public void dxu() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().tl(CyberPlayerManager.hasCacheFile(this.eAe));
            getVideoMonitor().deg();
            getVideoMonitor().ER(-400);
        }
    }
}
