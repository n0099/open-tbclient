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
    private static k mEd;
    private f abL;
    private String anD;
    private String ePk;
    private final CustomMessageListener iQh;
    private CyberPlayerManager.OnErrorListener kZU;
    private boolean lru;
    private boolean lrv;
    private boolean mEa;
    private boolean mEb;
    private b mEc;
    private h mEe;
    private String mEf;
    private boolean mEg;
    private boolean mEh;
    private int mEi;
    private int mEj;
    private boolean mEk;
    private CyberPlayerManager.OnPreparedListener mEl;
    private CyberPlayerManager.OnCompletionListener mEm;
    private CyberPlayerManager.OnSeekCompleteListener mEn;
    private CyberPlayerManager.OnErrorListener mEo;
    private CyberPlayerManager.OnInfoListener mEp;
    private a mEq;
    private CyberPlayerManager.OnPreparedListener mEr;
    private CyberPlayerManager.OnCompletionListener mEs;
    private CyberPlayerManager.OnSeekCompleteListener mEt;
    private CyberPlayerManager.OnInfoListener mEu;
    private PowerManager.WakeLock mWakeLock;
    private WeakReference<Context> mWeakContext;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        if (runTask != null) {
            mEd = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.mEg = false;
        this.mEh = false;
        this.mEk = false;
        this.mEr = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QT;
                if (TbCyberVideoView.this.mEc != null) {
                    TbCyberVideoView.this.mEc.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().FX(-400);
                }
                if (!TbCyberVideoView.this.mEk) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCe().a(TbCyberVideoView.this, TbCyberVideoView.this.ePk);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mEl != null) {
                    TbCyberVideoView.this.mEl.onPrepared();
                }
                if (TbCyberVideoView.this.mEa && (QT = n.dBQ().QT(TbCyberVideoView.this.ePk)) > 0) {
                    TbCyberVideoView.this.seekTo(QT);
                }
                if (TbCyberVideoView.this.mEb) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mEs = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mEe != null) {
                    TbCyberVideoView.this.mEe.OY(TbCyberVideoView.this.mEf);
                    TbCyberVideoView.this.mEe = null;
                }
                n.dBQ().remove(TbCyberVideoView.this.ePk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mEc != null) {
                        TbCyberVideoView.this.mEc.onComplete();
                    }
                    TbCyberVideoView.this.mEb = false;
                    if (TbCyberVideoView.this.mEm != null) {
                        TbCyberVideoView.this.mEm.onCompletion();
                    }
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dBY()) {
                    n.dBQ().bK(TbCyberVideoView.this.ePk, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCe().QW(TbCyberVideoView.this.ePk);
                if (TbCyberVideoView.this.mEo != null) {
                    TbCyberVideoView.this.mEo.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mEt = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mEn != null) {
                    TbCyberVideoView.this.mEn.onSeekComplete();
                }
            }
        };
        this.mEu = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mEp != null) {
                    TbCyberVideoView.this.mEp.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mEc != null) {
                    TbCyberVideoView.this.mEc.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iQh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mEe != null) {
                        TbCyberVideoView.this.mEe.OX(TbCyberVideoView.this.mEf);
                        TbCyberVideoView.this.mEe = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.mEg = false;
        this.mEh = false;
        this.mEk = false;
        this.mEr = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QT;
                if (TbCyberVideoView.this.mEc != null) {
                    TbCyberVideoView.this.mEc.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().FX(-400);
                }
                if (!TbCyberVideoView.this.mEk) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCe().a(TbCyberVideoView.this, TbCyberVideoView.this.ePk);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mEl != null) {
                    TbCyberVideoView.this.mEl.onPrepared();
                }
                if (TbCyberVideoView.this.mEa && (QT = n.dBQ().QT(TbCyberVideoView.this.ePk)) > 0) {
                    TbCyberVideoView.this.seekTo(QT);
                }
                if (TbCyberVideoView.this.mEb) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mEs = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mEe != null) {
                    TbCyberVideoView.this.mEe.OY(TbCyberVideoView.this.mEf);
                    TbCyberVideoView.this.mEe = null;
                }
                n.dBQ().remove(TbCyberVideoView.this.ePk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mEc != null) {
                        TbCyberVideoView.this.mEc.onComplete();
                    }
                    TbCyberVideoView.this.mEb = false;
                    if (TbCyberVideoView.this.mEm != null) {
                        TbCyberVideoView.this.mEm.onCompletion();
                    }
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dBY()) {
                    n.dBQ().bK(TbCyberVideoView.this.ePk, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCe().QW(TbCyberVideoView.this.ePk);
                if (TbCyberVideoView.this.mEo != null) {
                    TbCyberVideoView.this.mEo.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mEt = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mEn != null) {
                    TbCyberVideoView.this.mEn.onSeekComplete();
                }
            }
        };
        this.mEu = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mEp != null) {
                    TbCyberVideoView.this.mEp.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mEc != null) {
                    TbCyberVideoView.this.mEc.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iQh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mEe != null) {
                        TbCyberVideoView.this.mEe.OX(TbCyberVideoView.this.mEf);
                        TbCyberVideoView.this.mEe = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.mEg = false;
        this.mEh = false;
        this.mEk = false;
        this.mEr = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QT;
                if (TbCyberVideoView.this.mEc != null) {
                    TbCyberVideoView.this.mEc.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().FX(-400);
                }
                if (!TbCyberVideoView.this.mEk) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCe().a(TbCyberVideoView.this, TbCyberVideoView.this.ePk);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mEl != null) {
                    TbCyberVideoView.this.mEl.onPrepared();
                }
                if (TbCyberVideoView.this.mEa && (QT = n.dBQ().QT(TbCyberVideoView.this.ePk)) > 0) {
                    TbCyberVideoView.this.seekTo(QT);
                }
                if (TbCyberVideoView.this.mEb) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mEs = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mEe != null) {
                    TbCyberVideoView.this.mEe.OY(TbCyberVideoView.this.mEf);
                    TbCyberVideoView.this.mEe = null;
                }
                n.dBQ().remove(TbCyberVideoView.this.ePk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mEc != null) {
                        TbCyberVideoView.this.mEc.onComplete();
                    }
                    TbCyberVideoView.this.mEb = false;
                    if (TbCyberVideoView.this.mEm != null) {
                        TbCyberVideoView.this.mEm.onCompletion();
                    }
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dBY()) {
                    n.dBQ().bK(TbCyberVideoView.this.ePk, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCe().QW(TbCyberVideoView.this.ePk);
                if (TbCyberVideoView.this.mEo != null) {
                    TbCyberVideoView.this.mEo.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mEt = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mEn != null) {
                    TbCyberVideoView.this.mEn.onSeekComplete();
                }
            }
        };
        this.mEu = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mEp != null) {
                    TbCyberVideoView.this.mEp.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mEc != null) {
                    TbCyberVideoView.this.mEc.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iQh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mEe != null) {
                        TbCyberVideoView.this.mEe.OX(TbCyberVideoView.this.mEf);
                        TbCyberVideoView.this.mEe = null;
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
        super.setOnPreparedListener(this.mEr);
        super.setOnCompletionListener(this.mEs);
        super.setOnErrorListener(this.kZU);
        super.setOnSeekCompleteListener(this.mEt);
        super.setOnInfoListener(this.mEu);
        this.mEc = new b();
        this.abL = new f();
        ao.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void C(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dBS()) {
            if (!pcdnConfigData.B(uri)) {
                this.mEj = 2;
                return;
            } else if (c.dCj() <= 0) {
                this.mEj = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dBT() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dCj()));
                this.lru = true;
                this.lrv = pcdnConfigData.dBT();
                this.mEj = 1;
                return;
            }
        }
        this.mEj = 0;
    }

    public int getPcdnState() {
        return this.mEj;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mEg = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ah.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mEg = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mEc == null) {
            this.mEc = new b();
        }
        this.mEc.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mEf = oVar.mLocate;
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
        if (this.mEc == null) {
            this.mEc = new b();
        }
        this.mEc.setThreadData(bzVar);
    }

    public void setPlayMode(String str) {
        if (this.mEc != null) {
            this.mEc.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mEc = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mEl = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mEm = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mEo = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mEn = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mEp = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mEq = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mEa = z;
    }

    public String getOriginUrl() {
        return this.ePk;
    }

    public void setVideoDuration(int i) {
        this.mEi = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!at.isEmpty(str)) {
            this.anD = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!at.isEmpty(str)) {
            dBW();
            this.ePk = str;
            String QU = QU(str);
            if (mEd != null) {
                this.mEe = mEd.aL(this.anD, this.ePk, null);
                if (this.mEe != null) {
                    this.mEe.tR(CyberPlayerManager.hasCacheFile(QU));
                }
            }
            this.abL.setPlayer(this);
            if (this.mEc != null) {
                this.mEc.dBU();
            }
            C(Uri.parse(QU));
            if (this.mEe != null) {
                this.mEe.diD();
            }
            String host = Uri.parse(this.ePk).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mEi < 900)) ? "1" : "0");
            super.setVideoPath(QU);
        }
    }

    private void dBW() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mEh = true;
            if (!dCa()) {
                aVar.dCf();
            }
            if (!dBZ()) {
                aVar.dCg();
                this.mEb = true;
                setVideoPath(this.ePk, this.anD);
                return;
            }
        } else {
            this.mEh = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mEg) {
            ah.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.mEb = true;
        super.start();
        if (this.mEc != null) {
            this.mEc.onStart();
        }
        this.abL.start();
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().FZ(-400);
            getVideoMonitor().ao(this.lru, this.lrv);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.mEb) {
            a(aVar);
            return;
        }
        this.mEb = true;
        if (aVar != null) {
            this.mEh = true;
            if (!dCa()) {
                aVar.dCf();
            }
        } else {
            this.mEh = false;
        }
        setVideoPath(this.ePk, this.anD);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ah.a(this.mWeakContext, false);
        if (isPlaying() && dBY()) {
            n.dBQ().bK(this.ePk, getCurrentPositionSync());
        }
        super.pause();
        if (this.mEc != null) {
            this.mEc.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mEe != null) {
            this.mEe.diE();
        }
    }

    public void stop() {
        if (!this.mEh) {
            stopPlayback();
            return;
        }
        if (this.ePk != null && isPlaying()) {
            ah.a(this.mWeakContext, false);
        }
        this.mEb = false;
        if (isPlaying() && dBY()) {
            n.dBQ().bK(this.ePk, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mEc != null) {
            this.mEc.onStop();
        }
        this.abL.stop();
        if (this.mEe != null && this.mEe.OZ(this.mEf)) {
            this.mEe = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.ePk != null && isPlaying()) {
            ah.a(this.mWeakContext, false);
        }
        this.mEb = false;
        if (isPlaying() && dBY()) {
            n.dBQ().bK(this.ePk, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dCe().QW(this.ePk);
        if (this.mEc != null) {
            this.mEc.onStop();
        }
        this.abL.stop();
        if (this.mEe != null && this.mEe.OZ(this.mEf)) {
            this.mEe = null;
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
        MessageManager.getInstance().registerListener(this.iQh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mEq != null) {
            this.mEq.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.iQh);
    }

    private String QU(String str) {
        if (!at.isEmpty(str) && com.baidu.tieba.video.f.dTE().dTF()) {
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

    public boolean dBX() {
        return this.mEb;
    }

    public void h(long j, long j2, long j3) {
        if (this.mEe != null) {
            this.mEe.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dBY() {
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
        this.mEf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        if (this.mEe != null) {
            return this.mEe;
        }
        if (!StringUtils.isNull(this.ePk) && mEd != null) {
            this.mEe = mEd.aL(this.anD, this.ePk, null);
        }
        return this.mEe;
    }

    private boolean dBZ() {
        return this == TbVideoViewSet.dCe().QV(this.ePk);
    }

    private boolean dCa() {
        return getParent() != null;
    }

    public void dCb() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mEq = null;
        this.mEm = null;
        this.mEo = null;
        this.mEp = null;
        this.mEl = null;
        this.mEn = null;
        this.abL.a((f.b) null);
        this.abL.a((f.a) null);
        this.abL.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.abL;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mEh = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.mEk = z;
    }

    @Deprecated
    public void dCc() {
        if (this.mEc != null) {
            this.mEc.dBU();
            this.mEc.hv(getDuration());
            this.mEc.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().tR(CyberPlayerManager.hasCacheFile(this.ePk));
            getVideoMonitor().FY(-400);
        }
    }

    @Deprecated
    public void dCd() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().tR(CyberPlayerManager.hasCacheFile(this.ePk));
            getVideoMonitor().diD();
            getVideoMonitor().FX(-400);
        }
    }
}
