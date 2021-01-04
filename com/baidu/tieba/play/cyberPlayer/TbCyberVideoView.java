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
    private static k mEe;
    private f abL;
    private String anD;
    private String ePk;
    private final CustomMessageListener iQh;
    private CyberPlayerManager.OnErrorListener kZU;
    private boolean lru;
    private boolean lrv;
    private boolean mEb;
    private boolean mEc;
    private b mEd;
    private h mEf;
    private String mEg;
    private boolean mEh;
    private boolean mEi;
    private int mEj;
    private int mEk;
    private boolean mEl;
    private CyberPlayerManager.OnPreparedListener mEm;
    private CyberPlayerManager.OnCompletionListener mEn;
    private CyberPlayerManager.OnSeekCompleteListener mEo;
    private CyberPlayerManager.OnErrorListener mEp;
    private CyberPlayerManager.OnInfoListener mEq;
    private a mEr;
    private CyberPlayerManager.OnPreparedListener mEs;
    private CyberPlayerManager.OnCompletionListener mEt;
    private CyberPlayerManager.OnSeekCompleteListener mEu;
    private CyberPlayerManager.OnInfoListener mEv;
    private PowerManager.WakeLock mWakeLock;
    private WeakReference<Context> mWeakContext;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        if (runTask != null) {
            mEe = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.mEh = false;
        this.mEi = false;
        this.mEl = false;
        this.mEs = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QU;
                if (TbCyberVideoView.this.mEd != null) {
                    TbCyberVideoView.this.mEd.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().FX(-400);
                }
                if (!TbCyberVideoView.this.mEl) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCd().a(TbCyberVideoView.this, TbCyberVideoView.this.ePk);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mEm != null) {
                    TbCyberVideoView.this.mEm.onPrepared();
                }
                if (TbCyberVideoView.this.mEb && (QU = n.dBP().QU(TbCyberVideoView.this.ePk)) > 0) {
                    TbCyberVideoView.this.seekTo(QU);
                }
                if (TbCyberVideoView.this.mEc) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mEt = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mEf != null) {
                    TbCyberVideoView.this.mEf.OZ(TbCyberVideoView.this.mEg);
                    TbCyberVideoView.this.mEf = null;
                }
                n.dBP().remove(TbCyberVideoView.this.ePk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mEd != null) {
                        TbCyberVideoView.this.mEd.onComplete();
                    }
                    TbCyberVideoView.this.mEc = false;
                    if (TbCyberVideoView.this.mEn != null) {
                        TbCyberVideoView.this.mEn.onCompletion();
                    }
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dBX()) {
                    n.dBP().bK(TbCyberVideoView.this.ePk, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCd().QX(TbCyberVideoView.this.ePk);
                if (TbCyberVideoView.this.mEp != null) {
                    TbCyberVideoView.this.mEp.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mEu = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mEo != null) {
                    TbCyberVideoView.this.mEo.onSeekComplete();
                }
            }
        };
        this.mEv = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mEq != null) {
                    TbCyberVideoView.this.mEq.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mEd != null) {
                    TbCyberVideoView.this.mEd.b(TbCyberVideoView.this);
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
                    if (TbCyberVideoView.this.mEf != null) {
                        TbCyberVideoView.this.mEf.OY(TbCyberVideoView.this.mEg);
                        TbCyberVideoView.this.mEf = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.mEh = false;
        this.mEi = false;
        this.mEl = false;
        this.mEs = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QU;
                if (TbCyberVideoView.this.mEd != null) {
                    TbCyberVideoView.this.mEd.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().FX(-400);
                }
                if (!TbCyberVideoView.this.mEl) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCd().a(TbCyberVideoView.this, TbCyberVideoView.this.ePk);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mEm != null) {
                    TbCyberVideoView.this.mEm.onPrepared();
                }
                if (TbCyberVideoView.this.mEb && (QU = n.dBP().QU(TbCyberVideoView.this.ePk)) > 0) {
                    TbCyberVideoView.this.seekTo(QU);
                }
                if (TbCyberVideoView.this.mEc) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mEt = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mEf != null) {
                    TbCyberVideoView.this.mEf.OZ(TbCyberVideoView.this.mEg);
                    TbCyberVideoView.this.mEf = null;
                }
                n.dBP().remove(TbCyberVideoView.this.ePk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mEd != null) {
                        TbCyberVideoView.this.mEd.onComplete();
                    }
                    TbCyberVideoView.this.mEc = false;
                    if (TbCyberVideoView.this.mEn != null) {
                        TbCyberVideoView.this.mEn.onCompletion();
                    }
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dBX()) {
                    n.dBP().bK(TbCyberVideoView.this.ePk, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCd().QX(TbCyberVideoView.this.ePk);
                if (TbCyberVideoView.this.mEp != null) {
                    TbCyberVideoView.this.mEp.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mEu = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mEo != null) {
                    TbCyberVideoView.this.mEo.onSeekComplete();
                }
            }
        };
        this.mEv = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mEq != null) {
                    TbCyberVideoView.this.mEq.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mEd != null) {
                    TbCyberVideoView.this.mEd.b(TbCyberVideoView.this);
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
                    if (TbCyberVideoView.this.mEf != null) {
                        TbCyberVideoView.this.mEf.OY(TbCyberVideoView.this.mEg);
                        TbCyberVideoView.this.mEf = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.mEh = false;
        this.mEi = false;
        this.mEl = false;
        this.mEs = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QU;
                if (TbCyberVideoView.this.mEd != null) {
                    TbCyberVideoView.this.mEd.hv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().FX(-400);
                }
                if (!TbCyberVideoView.this.mEl) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dCd().a(TbCyberVideoView.this, TbCyberVideoView.this.ePk);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mEm != null) {
                    TbCyberVideoView.this.mEm.onPrepared();
                }
                if (TbCyberVideoView.this.mEb && (QU = n.dBP().QU(TbCyberVideoView.this.ePk)) > 0) {
                    TbCyberVideoView.this.seekTo(QU);
                }
                if (TbCyberVideoView.this.mEc) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mEt = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mEf != null) {
                    TbCyberVideoView.this.mEf.OZ(TbCyberVideoView.this.mEg);
                    TbCyberVideoView.this.mEf = null;
                }
                n.dBP().remove(TbCyberVideoView.this.ePk);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mEd != null) {
                        TbCyberVideoView.this.mEd.onComplete();
                    }
                    TbCyberVideoView.this.mEc = false;
                    if (TbCyberVideoView.this.mEn != null) {
                        TbCyberVideoView.this.mEn.onCompletion();
                    }
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dBX()) {
                    n.dBP().bK(TbCyberVideoView.this.ePk, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dCd().QX(TbCyberVideoView.this.ePk);
                if (TbCyberVideoView.this.mEp != null) {
                    TbCyberVideoView.this.mEp.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mEu = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mEo != null) {
                    TbCyberVideoView.this.mEo.onSeekComplete();
                }
            }
        };
        this.mEv = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mEq != null) {
                    TbCyberVideoView.this.mEq.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().H(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mEd != null) {
                    TbCyberVideoView.this.mEd.b(TbCyberVideoView.this);
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
                    if (TbCyberVideoView.this.mEf != null) {
                        TbCyberVideoView.this.mEf.OY(TbCyberVideoView.this.mEg);
                        TbCyberVideoView.this.mEf = null;
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
        super.setOnPreparedListener(this.mEs);
        super.setOnCompletionListener(this.mEt);
        super.setOnErrorListener(this.kZU);
        super.setOnSeekCompleteListener(this.mEu);
        super.setOnInfoListener(this.mEv);
        this.mEd = new b();
        this.abL = new f();
        ao.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void C(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dBR()) {
            if (!pcdnConfigData.B(uri)) {
                this.mEk = 2;
                return;
            } else if (c.dCi() <= 0) {
                this.mEk = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dBS() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dCi()));
                this.lru = true;
                this.lrv = pcdnConfigData.dBS();
                this.mEk = 1;
                return;
            }
        }
        this.mEk = 0;
    }

    public int getPcdnState() {
        return this.mEk;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mEh = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ah.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mEh = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mEd == null) {
            this.mEd = new b();
        }
        this.mEd.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mEg = oVar.mLocate;
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
        if (this.mEd == null) {
            this.mEd = new b();
        }
        this.mEd.setThreadData(bzVar);
    }

    public void setPlayMode(String str) {
        if (this.mEd != null) {
            this.mEd.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mEd = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mEm = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mEn = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mEp = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mEo = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mEq = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mEr = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mEb = z;
    }

    public String getOriginUrl() {
        return this.ePk;
    }

    public void setVideoDuration(int i) {
        this.mEj = i;
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
            dBV();
            this.ePk = str;
            String QV = QV(str);
            if (mEe != null) {
                this.mEf = mEe.aL(this.anD, this.ePk, null);
                if (this.mEf != null) {
                    this.mEf.tR(CyberPlayerManager.hasCacheFile(QV));
                }
            }
            this.abL.setPlayer(this);
            if (this.mEd != null) {
                this.mEd.dBT();
            }
            C(Uri.parse(QV));
            if (this.mEf != null) {
                this.mEf.diC();
            }
            String host = Uri.parse(this.ePk).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mEj < 900)) ? "1" : "0");
            super.setVideoPath(QV);
        }
    }

    private void dBV() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mEi = true;
            if (!dBZ()) {
                aVar.dCe();
            }
            if (!dBY()) {
                aVar.dCf();
                this.mEc = true;
                setVideoPath(this.ePk, this.anD);
                return;
            }
        } else {
            this.mEi = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mEh) {
            ah.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.mEc = true;
        super.start();
        if (this.mEd != null) {
            this.mEd.onStart();
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
        if (isPlaying() || this.mEc) {
            a(aVar);
            return;
        }
        this.mEc = true;
        if (aVar != null) {
            this.mEi = true;
            if (!dBZ()) {
                aVar.dCe();
            }
        } else {
            this.mEi = false;
        }
        setVideoPath(this.ePk, this.anD);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ah.a(this.mWeakContext, false);
        if (isPlaying() && dBX()) {
            n.dBP().bK(this.ePk, getCurrentPositionSync());
        }
        super.pause();
        if (this.mEd != null) {
            this.mEd.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mEf != null) {
            this.mEf.diD();
        }
    }

    public void stop() {
        if (!this.mEi) {
            stopPlayback();
            return;
        }
        if (this.ePk != null && isPlaying()) {
            ah.a(this.mWeakContext, false);
        }
        this.mEc = false;
        if (isPlaying() && dBX()) {
            n.dBP().bK(this.ePk, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mEd != null) {
            this.mEd.onStop();
        }
        this.abL.stop();
        if (this.mEf != null && this.mEf.Pa(this.mEg)) {
            this.mEf = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.ePk != null && isPlaying()) {
            ah.a(this.mWeakContext, false);
        }
        this.mEc = false;
        if (isPlaying() && dBX()) {
            n.dBP().bK(this.ePk, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dCd().QX(this.ePk);
        if (this.mEd != null) {
            this.mEd.onStop();
        }
        this.abL.stop();
        if (this.mEf != null && this.mEf.Pa(this.mEg)) {
            this.mEf = null;
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
        if (this.mEr != null) {
            this.mEr.onSurfaceDestroyed();
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

    private String QV(String str) {
        if (!at.isEmpty(str) && com.baidu.tieba.video.f.dTD().dTE()) {
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

    public boolean dBW() {
        return this.mEc;
    }

    public void h(long j, long j2, long j3) {
        if (this.mEf != null) {
            this.mEf.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dBX() {
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
        this.mEg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        if (this.mEf != null) {
            return this.mEf;
        }
        if (!StringUtils.isNull(this.ePk) && mEe != null) {
            this.mEf = mEe.aL(this.anD, this.ePk, null);
        }
        return this.mEf;
    }

    private boolean dBY() {
        return this == TbVideoViewSet.dCd().QW(this.ePk);
    }

    private boolean dBZ() {
        return getParent() != null;
    }

    public void dCa() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mEr = null;
        this.mEn = null;
        this.mEp = null;
        this.mEq = null;
        this.mEm = null;
        this.mEo = null;
        this.abL.a((f.b) null);
        this.abL.a((f.a) null);
        this.abL.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.abL;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mEi = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.mEl = z;
    }

    @Deprecated
    public void dCb() {
        if (this.mEd != null) {
            this.mEd.dBT();
            this.mEd.hv(getDuration());
            this.mEd.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().tR(CyberPlayerManager.hasCacheFile(this.ePk));
            getVideoMonitor().FY(-400);
        }
    }

    @Deprecated
    public void dCc() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().tR(CyberPlayerManager.hasCacheFile(this.ePk));
            getVideoMonitor().diC();
            getVideoMonitor().FX(-400);
        }
    }
}
