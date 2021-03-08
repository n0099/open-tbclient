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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ak;
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
    private static k mKW;
    private f ada;
    private String anU;
    private String eOm;
    private final CustomMessageListener iTf;
    private CyberPlayerManager.OnErrorListener lfJ;
    private boolean lxh;
    private boolean lxi;
    private boolean mKT;
    private boolean mKU;
    private b mKV;
    private h mKX;
    private String mKY;
    private boolean mKZ;
    private boolean mLa;
    private int mLb;
    private int mLc;
    private boolean mLd;
    private CyberPlayerManager.OnPreparedListener mLe;
    private CyberPlayerManager.OnCompletionListener mLf;
    private CyberPlayerManager.OnSeekCompleteListener mLg;
    private CyberPlayerManager.OnErrorListener mLh;
    private CyberPlayerManager.OnInfoListener mLi;
    private a mLj;
    private CyberPlayerManager.OnPreparedListener mLk;
    private CyberPlayerManager.OnCompletionListener mLl;
    private CyberPlayerManager.OnSeekCompleteListener mLm;
    private CyberPlayerManager.OnInfoListener mLn;
    private PowerManager.WakeLock mWakeLock;
    private WeakReference<Context> mWeakContext;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        if (runTask != null) {
            mKW = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.mKZ = false;
        this.mLa = false;
        this.mLd = false;
        this.mLk = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QK;
                if (TbCyberVideoView.this.mKV != null) {
                    TbCyberVideoView.this.mKV.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EM(-400);
                }
                if (!TbCyberVideoView.this.mLd) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAJ().a(TbCyberVideoView.this, TbCyberVideoView.this.eOm);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mLe != null) {
                    TbCyberVideoView.this.mLe.onPrepared();
                }
                if (TbCyberVideoView.this.mKT && (QK = n.dAv().QK(TbCyberVideoView.this.eOm)) > 0) {
                    TbCyberVideoView.this.seekTo(QK);
                }
                if (TbCyberVideoView.this.mKU) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mLl = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mKX != null) {
                    TbCyberVideoView.this.mKX.OM(TbCyberVideoView.this.mKY);
                    TbCyberVideoView.this.mKX = null;
                }
                n.dAv().remove(TbCyberVideoView.this.eOm);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mKV != null) {
                        TbCyberVideoView.this.mKV.onComplete();
                    }
                    TbCyberVideoView.this.mKU = false;
                    if (TbCyberVideoView.this.mLf != null) {
                        TbCyberVideoView.this.mLf.onCompletion();
                    }
                }
            }
        };
        this.lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAD()) {
                    n.dAv().bL(TbCyberVideoView.this.eOm, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAJ().QN(TbCyberVideoView.this.eOm);
                if (TbCyberVideoView.this.mLh != null) {
                    TbCyberVideoView.this.mLh.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mLm = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mLg != null) {
                    TbCyberVideoView.this.mLg.onSeekComplete();
                }
            }
        };
        this.mLn = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mLi != null) {
                    TbCyberVideoView.this.mLi.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mKV != null) {
                    TbCyberVideoView.this.mKV.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iTf = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mKX != null) {
                        TbCyberVideoView.this.mKX.OL(TbCyberVideoView.this.mKY);
                        TbCyberVideoView.this.mKX = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.mKZ = false;
        this.mLa = false;
        this.mLd = false;
        this.mLk = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QK;
                if (TbCyberVideoView.this.mKV != null) {
                    TbCyberVideoView.this.mKV.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EM(-400);
                }
                if (!TbCyberVideoView.this.mLd) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAJ().a(TbCyberVideoView.this, TbCyberVideoView.this.eOm);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mLe != null) {
                    TbCyberVideoView.this.mLe.onPrepared();
                }
                if (TbCyberVideoView.this.mKT && (QK = n.dAv().QK(TbCyberVideoView.this.eOm)) > 0) {
                    TbCyberVideoView.this.seekTo(QK);
                }
                if (TbCyberVideoView.this.mKU) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mLl = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mKX != null) {
                    TbCyberVideoView.this.mKX.OM(TbCyberVideoView.this.mKY);
                    TbCyberVideoView.this.mKX = null;
                }
                n.dAv().remove(TbCyberVideoView.this.eOm);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mKV != null) {
                        TbCyberVideoView.this.mKV.onComplete();
                    }
                    TbCyberVideoView.this.mKU = false;
                    if (TbCyberVideoView.this.mLf != null) {
                        TbCyberVideoView.this.mLf.onCompletion();
                    }
                }
            }
        };
        this.lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAD()) {
                    n.dAv().bL(TbCyberVideoView.this.eOm, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAJ().QN(TbCyberVideoView.this.eOm);
                if (TbCyberVideoView.this.mLh != null) {
                    TbCyberVideoView.this.mLh.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mLm = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mLg != null) {
                    TbCyberVideoView.this.mLg.onSeekComplete();
                }
            }
        };
        this.mLn = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mLi != null) {
                    TbCyberVideoView.this.mLi.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mKV != null) {
                    TbCyberVideoView.this.mKV.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iTf = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mKX != null) {
                        TbCyberVideoView.this.mKX.OL(TbCyberVideoView.this.mKY);
                        TbCyberVideoView.this.mKX = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.mKZ = false;
        this.mLa = false;
        this.mLd = false;
        this.mLk = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QK;
                if (TbCyberVideoView.this.mKV != null) {
                    TbCyberVideoView.this.mKV.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EM(-400);
                }
                if (!TbCyberVideoView.this.mLd) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAJ().a(TbCyberVideoView.this, TbCyberVideoView.this.eOm);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mLe != null) {
                    TbCyberVideoView.this.mLe.onPrepared();
                }
                if (TbCyberVideoView.this.mKT && (QK = n.dAv().QK(TbCyberVideoView.this.eOm)) > 0) {
                    TbCyberVideoView.this.seekTo(QK);
                }
                if (TbCyberVideoView.this.mKU) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mLl = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mKX != null) {
                    TbCyberVideoView.this.mKX.OM(TbCyberVideoView.this.mKY);
                    TbCyberVideoView.this.mKX = null;
                }
                n.dAv().remove(TbCyberVideoView.this.eOm);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mKV != null) {
                        TbCyberVideoView.this.mKV.onComplete();
                    }
                    TbCyberVideoView.this.mKU = false;
                    if (TbCyberVideoView.this.mLf != null) {
                        TbCyberVideoView.this.mLf.onCompletion();
                    }
                }
            }
        };
        this.lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAD()) {
                    n.dAv().bL(TbCyberVideoView.this.eOm, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAJ().QN(TbCyberVideoView.this.eOm);
                if (TbCyberVideoView.this.mLh != null) {
                    TbCyberVideoView.this.mLh.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mLm = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mLg != null) {
                    TbCyberVideoView.this.mLg.onSeekComplete();
                }
            }
        };
        this.mLn = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mLi != null) {
                    TbCyberVideoView.this.mLi.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mKV != null) {
                    TbCyberVideoView.this.mKV.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iTf = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mKX != null) {
                        TbCyberVideoView.this.mKX.OL(TbCyberVideoView.this.mKY);
                        TbCyberVideoView.this.mKX = null;
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
        super.setOnPreparedListener(this.mLk);
        super.setOnCompletionListener(this.mLl);
        super.setOnErrorListener(this.lfJ);
        super.setOnSeekCompleteListener(this.mLm);
        super.setOnInfoListener(this.mLn);
        this.mKV = new b();
        this.ada = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void F(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dAx()) {
            if (!pcdnConfigData.E(uri)) {
                this.mLc = 2;
                return;
            } else if (c.dAO() <= 0) {
                this.mLc = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dAy() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dAO()));
                this.lxh = true;
                this.lxi = pcdnConfigData.dAy();
                this.mLc = 1;
                return;
            }
        }
        this.mLc = 0;
    }

    public int getPcdnState() {
        return this.mLc;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mKZ = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ak.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mKZ = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mKV == null) {
            this.mKV = new b();
        }
        this.mKV.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mKY = oVar.mLocate;
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

    public void setThreadDataForStatistic(cb cbVar) {
        if (this.mKV == null) {
            this.mKV = new b();
        }
        this.mKV.setThreadData(cbVar);
    }

    public void setPlayMode(String str) {
        if (this.mKV != null) {
            this.mKV.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mKV = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mLe = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mLf = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mLh = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mLg = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mLi = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mLj = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mKT = z;
    }

    public String getOriginUrl() {
        return this.eOm;
    }

    public void setVideoDuration(int i) {
        this.mLb = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!au.isEmpty(str)) {
            this.anU = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!au.isEmpty(str)) {
            dAB();
            this.eOm = str;
            String QL = QL(str);
            if (mKW != null) {
                this.mKX = mKW.aM(this.anU, this.eOm, null);
                if (this.mKX != null) {
                    this.mKX.ua(CyberPlayerManager.hasCacheFile(QL));
                }
            }
            this.ada.setPlayer(this);
            if (this.mKV != null) {
                this.mKV.dAz();
            }
            F(Uri.parse(QL));
            if (this.mKX != null) {
                this.mKX.dhb();
            }
            String host = Uri.parse(this.eOm).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mLb < 900)) ? "1" : "0");
            super.setVideoPath(QL);
        }
    }

    private void dAB() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mLa = true;
            if (!dAF()) {
                aVar.dAK();
            }
            if (!dAE()) {
                aVar.dAL();
                this.mKU = true;
                setVideoPath(this.eOm, this.anU);
                return;
            }
        } else {
            this.mLa = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mKZ) {
            ak.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.mKU = true;
        super.start();
        if (this.mKV != null) {
            this.mKV.onStart();
        }
        this.ada.start();
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().EO(-400);
            getVideoMonitor().ao(this.lxh, this.lxi);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.mKU) {
            a(aVar);
            return;
        }
        this.mKU = true;
        if (aVar != null) {
            this.mLa = true;
            if (!dAF()) {
                aVar.dAK();
            }
        } else {
            this.mLa = false;
        }
        setVideoPath(this.eOm, this.anU);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ak.a(this.mWeakContext, false);
        if (isPlaying() && dAD()) {
            n.dAv().bL(this.eOm, getCurrentPositionSync());
        }
        super.pause();
        if (this.mKV != null) {
            this.mKV.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mKX != null) {
            this.mKX.dhc();
        }
    }

    public void stop() {
        if (!this.mLa) {
            stopPlayback();
            return;
        }
        if (this.eOm != null && isPlaying()) {
            ak.a(this.mWeakContext, false);
        }
        this.mKU = false;
        if (isPlaying() && dAD()) {
            n.dAv().bL(this.eOm, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mKV != null) {
            this.mKV.onStop();
        }
        this.ada.stop();
        if (this.mKX != null && this.mKX.ON(this.mKY)) {
            this.mKX = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eOm != null && isPlaying()) {
            ak.a(this.mWeakContext, false);
        }
        this.mKU = false;
        if (isPlaying() && dAD()) {
            n.dAv().bL(this.eOm, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dAJ().QN(this.eOm);
        if (this.mKV != null) {
            this.mKV.onStop();
        }
        this.ada.stop();
        if (this.mKX != null && this.mKX.ON(this.mKY)) {
            this.mKX = null;
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
        MessageManager.getInstance().registerListener(this.iTf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mLj != null) {
            this.mLj.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.iTf);
    }

    private String QL(String str) {
        if (!au.isEmpty(str) && com.baidu.tieba.video.f.dSn().dSo()) {
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

    public boolean dAC() {
        return this.mKU;
    }

    public void i(long j, long j2, long j3) {
        if (this.mKX != null) {
            this.mKX.i(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dAD() {
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
        this.mKY = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        if (this.mKX != null) {
            return this.mKX;
        }
        if (!StringUtils.isNull(this.eOm) && mKW != null) {
            this.mKX = mKW.aM(this.anU, this.eOm, null);
        }
        return this.mKX;
    }

    private boolean dAE() {
        return this == TbVideoViewSet.dAJ().QM(this.eOm);
    }

    private boolean dAF() {
        return getParent() != null;
    }

    public void dAG() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mLj = null;
        this.mLf = null;
        this.mLh = null;
        this.mLi = null;
        this.mLe = null;
        this.mLg = null;
        this.ada.a((f.b) null);
        this.ada.a((f.a) null);
        this.ada.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.ada;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mLa = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.mLd = z;
    }

    @Deprecated
    public void dAH() {
        if (this.mKV != null) {
            this.mKV.dAz();
            this.mKV.hA(getDuration());
            this.mKV.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().ua(CyberPlayerManager.hasCacheFile(this.eOm));
            getVideoMonitor().EN(-400);
        }
    }

    @Deprecated
    public void dAI() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().ua(CyberPlayerManager.hasCacheFile(this.eOm));
            getVideoMonitor().dhb();
            getVideoMonitor().EM(-400);
        }
    }
}
