package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.MediaController;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.l.h;
import com.baidu.tieba.l.k;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    private static k mzu;
    private f abJ;
    private String amM;
    private String eKz;
    private final CustomMessageListener iLA;
    private CyberPlayerManager.OnErrorListener kVp;
    private boolean lmK;
    private boolean lmL;
    private PowerManager.WakeLock mWakeLock;
    private WeakReference<Context> mWeakContext;
    private int mzA;
    private boolean mzB;
    private CyberPlayerManager.OnPreparedListener mzC;
    private CyberPlayerManager.OnCompletionListener mzD;
    private CyberPlayerManager.OnSeekCompleteListener mzE;
    private CyberPlayerManager.OnErrorListener mzF;
    private CyberPlayerManager.OnInfoListener mzG;
    private a mzH;
    private CyberPlayerManager.OnPreparedListener mzI;
    private CyberPlayerManager.OnCompletionListener mzJ;
    private CyberPlayerManager.OnSeekCompleteListener mzK;
    private CyberPlayerManager.OnInfoListener mzL;
    private boolean mzr;
    private boolean mzs;
    private b mzt;
    private h mzv;
    private String mzw;
    private boolean mzx;
    private boolean mzy;
    private int mzz;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        if (runTask != null) {
            mzu = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.mzx = false;
        this.mzy = false;
        this.mzB = false;
        this.mzI = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int PL;
                if (TbCyberVideoView.this.mzt != null) {
                    TbCyberVideoView.this.mzt.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Er(-400);
                }
                if (!TbCyberVideoView.this.mzB) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dym().a(TbCyberVideoView.this, TbCyberVideoView.this.eKz);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mzC != null) {
                    TbCyberVideoView.this.mzC.onPrepared();
                }
                if (TbCyberVideoView.this.mzr && (PL = n.dxY().PL(TbCyberVideoView.this.eKz)) > 0) {
                    TbCyberVideoView.this.seekTo(PL);
                }
                if (TbCyberVideoView.this.mzs) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mzv != null) {
                    TbCyberVideoView.this.mzv.NQ(TbCyberVideoView.this.mzw);
                    TbCyberVideoView.this.mzv = null;
                }
                n.dxY().remove(TbCyberVideoView.this.eKz);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mzt != null) {
                        TbCyberVideoView.this.mzt.onComplete();
                    }
                    TbCyberVideoView.this.mzs = false;
                    if (TbCyberVideoView.this.mzD != null) {
                        TbCyberVideoView.this.mzD.onCompletion();
                    }
                }
            }
        };
        this.kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dyg()) {
                    n.dxY().bK(TbCyberVideoView.this.eKz, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dym().PO(TbCyberVideoView.this.eKz);
                if (TbCyberVideoView.this.mzF != null) {
                    TbCyberVideoView.this.mzF.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mzK = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mzE != null) {
                    TbCyberVideoView.this.mzE.onSeekComplete();
                }
            }
        };
        this.mzL = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mzG != null) {
                    TbCyberVideoView.this.mzG.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mzt != null) {
                    TbCyberVideoView.this.mzt.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iLA = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mzv != null) {
                        TbCyberVideoView.this.mzv.NP(TbCyberVideoView.this.mzw);
                        TbCyberVideoView.this.mzv = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.mzx = false;
        this.mzy = false;
        this.mzB = false;
        this.mzI = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int PL;
                if (TbCyberVideoView.this.mzt != null) {
                    TbCyberVideoView.this.mzt.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Er(-400);
                }
                if (!TbCyberVideoView.this.mzB) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dym().a(TbCyberVideoView.this, TbCyberVideoView.this.eKz);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mzC != null) {
                    TbCyberVideoView.this.mzC.onPrepared();
                }
                if (TbCyberVideoView.this.mzr && (PL = n.dxY().PL(TbCyberVideoView.this.eKz)) > 0) {
                    TbCyberVideoView.this.seekTo(PL);
                }
                if (TbCyberVideoView.this.mzs) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mzv != null) {
                    TbCyberVideoView.this.mzv.NQ(TbCyberVideoView.this.mzw);
                    TbCyberVideoView.this.mzv = null;
                }
                n.dxY().remove(TbCyberVideoView.this.eKz);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mzt != null) {
                        TbCyberVideoView.this.mzt.onComplete();
                    }
                    TbCyberVideoView.this.mzs = false;
                    if (TbCyberVideoView.this.mzD != null) {
                        TbCyberVideoView.this.mzD.onCompletion();
                    }
                }
            }
        };
        this.kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dyg()) {
                    n.dxY().bK(TbCyberVideoView.this.eKz, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dym().PO(TbCyberVideoView.this.eKz);
                if (TbCyberVideoView.this.mzF != null) {
                    TbCyberVideoView.this.mzF.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mzK = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mzE != null) {
                    TbCyberVideoView.this.mzE.onSeekComplete();
                }
            }
        };
        this.mzL = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mzG != null) {
                    TbCyberVideoView.this.mzG.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mzt != null) {
                    TbCyberVideoView.this.mzt.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iLA = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mzv != null) {
                        TbCyberVideoView.this.mzv.NP(TbCyberVideoView.this.mzw);
                        TbCyberVideoView.this.mzv = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.mzx = false;
        this.mzy = false;
        this.mzB = false;
        this.mzI = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int PL;
                if (TbCyberVideoView.this.mzt != null) {
                    TbCyberVideoView.this.mzt.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().Er(-400);
                }
                if (!TbCyberVideoView.this.mzB) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dym().a(TbCyberVideoView.this, TbCyberVideoView.this.eKz);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mzC != null) {
                    TbCyberVideoView.this.mzC.onPrepared();
                }
                if (TbCyberVideoView.this.mzr && (PL = n.dxY().PL(TbCyberVideoView.this.eKz)) > 0) {
                    TbCyberVideoView.this.seekTo(PL);
                }
                if (TbCyberVideoView.this.mzs) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mzJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mzv != null) {
                    TbCyberVideoView.this.mzv.NQ(TbCyberVideoView.this.mzw);
                    TbCyberVideoView.this.mzv = null;
                }
                n.dxY().remove(TbCyberVideoView.this.eKz);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mzt != null) {
                        TbCyberVideoView.this.mzt.onComplete();
                    }
                    TbCyberVideoView.this.mzs = false;
                    if (TbCyberVideoView.this.mzD != null) {
                        TbCyberVideoView.this.mzD.onCompletion();
                    }
                }
            }
        };
        this.kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dyg()) {
                    n.dxY().bK(TbCyberVideoView.this.eKz, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dym().PO(TbCyberVideoView.this.eKz);
                if (TbCyberVideoView.this.mzF != null) {
                    TbCyberVideoView.this.mzF.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mzK = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mzE != null) {
                    TbCyberVideoView.this.mzE.onSeekComplete();
                }
            }
        };
        this.mzL = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mzG != null) {
                    TbCyberVideoView.this.mzG.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mzt != null) {
                    TbCyberVideoView.this.mzt.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iLA = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mzv != null) {
                        TbCyberVideoView.this.mzv.NP(TbCyberVideoView.this.mzw);
                        TbCyberVideoView.this.mzv = null;
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
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.mzI);
        super.setOnCompletionListener(this.mzJ);
        super.setOnErrorListener(this.kVp);
        super.setOnSeekCompleteListener(this.mzK);
        super.setOnInfoListener(this.mzL);
        this.mzt = new b();
        this.abJ = new f();
        ao.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void F(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dya()) {
            if (!pcdnConfigData.E(uri)) {
                this.mzA = 2;
                return;
            } else if (c.dyr() <= 0) {
                this.mzA = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dyb() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dyr()));
                this.lmK = true;
                this.lmL = pcdnConfigData.dyb();
                this.mzA = 1;
                return;
            }
        }
        this.mzA = 0;
    }

    public int getPcdnState() {
        return this.mzA;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mzx = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ah.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mzx = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mzt == null) {
            this.mzt = new b();
        }
        this.mzt.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mzw = oVar.mLocate;
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

    public void setThreadDataForStatistic(bz bzVar) {
        if (this.mzt == null) {
            this.mzt = new b();
        }
        this.mzt.setThreadData(bzVar);
    }

    public void setPlayMode(String str) {
        if (this.mzt != null) {
            this.mzt.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mzt = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mzC = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mzD = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mzF = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mzE = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mzG = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mzH = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mzr = z;
    }

    public String getOriginUrl() {
        return this.eKz;
    }

    public void setVideoDuration(int i) {
        this.mzz = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!at.isEmpty(str)) {
            this.amM = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!at.isEmpty(str)) {
            dye();
            this.eKz = str;
            String PM = PM(str);
            if (mzu != null) {
                this.mzv = mzu.aK(this.amM, this.eKz, null);
                if (this.mzv != null) {
                    this.mzv.tN(CyberPlayerManager.hasCacheFile(PM));
                }
            }
            this.abJ.setPlayer(this);
            if (this.mzt != null) {
                this.mzt.dyc();
            }
            F(Uri.parse(PM));
            if (this.mzv != null) {
                this.mzv.deL();
            }
            String host = Uri.parse(this.eKz).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mzz < 900)) ? "1" : "0");
            super.setVideoPath(PM);
        }
    }

    private void dye() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mzy = true;
            if (!dyi()) {
                aVar.dyn();
            }
            if (!dyh()) {
                aVar.dyo();
                this.mzs = true;
                setVideoPath(this.eKz, this.amM);
                return;
            }
        } else {
            this.mzy = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mzx) {
            ah.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.mzs = true;
        super.start();
        if (this.mzt != null) {
            this.mzt.onStart();
        }
        this.abJ.start();
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().Et(-400);
            getVideoMonitor().ao(this.lmK, this.lmL);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.mzs) {
            a(aVar);
            return;
        }
        this.mzs = true;
        if (aVar != null) {
            this.mzy = true;
            if (!dyi()) {
                aVar.dyn();
            }
        } else {
            this.mzy = false;
        }
        setVideoPath(this.eKz, this.amM);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ah.a(this.mWeakContext, false);
        if (isPlaying() && dyg()) {
            n.dxY().bK(this.eKz, getCurrentPositionSync());
        }
        super.pause();
        if (this.mzt != null) {
            this.mzt.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mzv != null) {
            this.mzv.deM();
        }
    }

    public void stop() {
        if (!this.mzy) {
            stopPlayback();
            return;
        }
        if (this.eKz != null && isPlaying()) {
            ah.a(this.mWeakContext, false);
        }
        this.mzs = false;
        if (isPlaying() && dyg()) {
            n.dxY().bK(this.eKz, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mzt != null) {
            this.mzt.onStop();
        }
        this.abJ.stop();
        if (this.mzv != null && this.mzv.NR(this.mzw)) {
            this.mzv = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eKz != null && isPlaying()) {
            ah.a(this.mWeakContext, false);
        }
        this.mzs = false;
        if (isPlaying() && dyg()) {
            n.dxY().bK(this.eKz, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dym().PO(this.eKz);
        if (this.mzt != null) {
            this.mzt.onStop();
        }
        this.abJ.stop();
        if (this.mzv != null && this.mzv.NR(this.mzw)) {
            this.mzv = null;
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
        MessageManager.getInstance().registerListener(this.iLA);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mzH != null) {
            this.mzH.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.iLA);
    }

    private String PM(String str) {
        if (!at.isEmpty(str) && com.baidu.tieba.video.f.dPM().dPN()) {
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

    public boolean dyf() {
        return this.mzs;
    }

    public void h(long j, long j2, long j3) {
        if (this.mzv != null) {
            this.mzv.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dyg() {
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
        this.mzw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        if (this.mzv != null) {
            return this.mzv;
        }
        if (!StringUtils.isNull(this.eKz) && mzu != null) {
            this.mzv = mzu.aK(this.amM, this.eKz, null);
        }
        return this.mzv;
    }

    private boolean dyh() {
        return this == TbVideoViewSet.dym().PN(this.eKz);
    }

    private boolean dyi() {
        return getParent() != null;
    }

    public void dyj() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mzH = null;
        this.mzD = null;
        this.mzF = null;
        this.mzG = null;
        this.mzC = null;
        this.mzE = null;
        this.abJ.a((f.b) null);
        this.abJ.a((f.a) null);
        this.abJ.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.abJ;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mzy = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.mzB = z;
    }

    @Deprecated
    public void dyk() {
        if (this.mzt != null) {
            this.mzt.dyc();
            this.mzt.hv(getDuration());
            this.mzt.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().tN(CyberPlayerManager.hasCacheFile(this.eKz));
            getVideoMonitor().Es(-400);
        }
    }

    @Deprecated
    public void dyl() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().tN(CyberPlayerManager.hasCacheFile(this.eKz));
            getVideoMonitor().deL();
            getVideoMonitor().Er(-400);
        }
    }
}
