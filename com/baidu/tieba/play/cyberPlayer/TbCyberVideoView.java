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
    private static k mIU;
    private f abE;
    private String amC;
    private String eML;
    private final CustomMessageListener iRw;
    private CyberPlayerManager.OnErrorListener ldG;
    private boolean lvf;
    private boolean lvg;
    private boolean mIR;
    private boolean mIS;
    private b mIT;
    private h mIV;
    private String mIW;
    private boolean mIX;
    private boolean mIY;
    private int mIZ;
    private int mJa;
    private boolean mJb;
    private CyberPlayerManager.OnPreparedListener mJc;
    private CyberPlayerManager.OnCompletionListener mJd;
    private CyberPlayerManager.OnSeekCompleteListener mJe;
    private CyberPlayerManager.OnErrorListener mJf;
    private CyberPlayerManager.OnInfoListener mJg;
    private a mJh;
    private CyberPlayerManager.OnPreparedListener mJi;
    private CyberPlayerManager.OnCompletionListener mJj;
    private CyberPlayerManager.OnSeekCompleteListener mJk;
    private CyberPlayerManager.OnInfoListener mJl;
    private PowerManager.WakeLock mWakeLock;
    private WeakReference<Context> mWeakContext;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        if (runTask != null) {
            mIU = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.mIX = false;
        this.mIY = false;
        this.mJb = false;
        this.mJi = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QE;
                if (TbCyberVideoView.this.mIT != null) {
                    TbCyberVideoView.this.mIT.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EJ(-400);
                }
                if (!TbCyberVideoView.this.mJb) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAB().a(TbCyberVideoView.this, TbCyberVideoView.this.eML);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mJc != null) {
                    TbCyberVideoView.this.mJc.onPrepared();
                }
                if (TbCyberVideoView.this.mIR && (QE = n.dAn().QE(TbCyberVideoView.this.eML)) > 0) {
                    TbCyberVideoView.this.seekTo(QE);
                }
                if (TbCyberVideoView.this.mIS) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mJj = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mIV != null) {
                    TbCyberVideoView.this.mIV.OG(TbCyberVideoView.this.mIW);
                    TbCyberVideoView.this.mIV = null;
                }
                n.dAn().remove(TbCyberVideoView.this.eML);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mIT != null) {
                        TbCyberVideoView.this.mIT.onComplete();
                    }
                    TbCyberVideoView.this.mIS = false;
                    if (TbCyberVideoView.this.mJd != null) {
                        TbCyberVideoView.this.mJd.onCompletion();
                    }
                }
            }
        };
        this.ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAv()) {
                    n.dAn().bL(TbCyberVideoView.this.eML, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAB().QH(TbCyberVideoView.this.eML);
                if (TbCyberVideoView.this.mJf != null) {
                    TbCyberVideoView.this.mJf.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mJk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mJe != null) {
                    TbCyberVideoView.this.mJe.onSeekComplete();
                }
            }
        };
        this.mJl = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mJg != null) {
                    TbCyberVideoView.this.mJg.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mIT != null) {
                    TbCyberVideoView.this.mIT.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iRw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mIV != null) {
                        TbCyberVideoView.this.mIV.OF(TbCyberVideoView.this.mIW);
                        TbCyberVideoView.this.mIV = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.mIX = false;
        this.mIY = false;
        this.mJb = false;
        this.mJi = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QE;
                if (TbCyberVideoView.this.mIT != null) {
                    TbCyberVideoView.this.mIT.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EJ(-400);
                }
                if (!TbCyberVideoView.this.mJb) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAB().a(TbCyberVideoView.this, TbCyberVideoView.this.eML);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mJc != null) {
                    TbCyberVideoView.this.mJc.onPrepared();
                }
                if (TbCyberVideoView.this.mIR && (QE = n.dAn().QE(TbCyberVideoView.this.eML)) > 0) {
                    TbCyberVideoView.this.seekTo(QE);
                }
                if (TbCyberVideoView.this.mIS) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mJj = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mIV != null) {
                    TbCyberVideoView.this.mIV.OG(TbCyberVideoView.this.mIW);
                    TbCyberVideoView.this.mIV = null;
                }
                n.dAn().remove(TbCyberVideoView.this.eML);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mIT != null) {
                        TbCyberVideoView.this.mIT.onComplete();
                    }
                    TbCyberVideoView.this.mIS = false;
                    if (TbCyberVideoView.this.mJd != null) {
                        TbCyberVideoView.this.mJd.onCompletion();
                    }
                }
            }
        };
        this.ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAv()) {
                    n.dAn().bL(TbCyberVideoView.this.eML, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAB().QH(TbCyberVideoView.this.eML);
                if (TbCyberVideoView.this.mJf != null) {
                    TbCyberVideoView.this.mJf.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mJk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mJe != null) {
                    TbCyberVideoView.this.mJe.onSeekComplete();
                }
            }
        };
        this.mJl = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mJg != null) {
                    TbCyberVideoView.this.mJg.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mIT != null) {
                    TbCyberVideoView.this.mIT.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iRw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mIV != null) {
                        TbCyberVideoView.this.mIV.OF(TbCyberVideoView.this.mIW);
                        TbCyberVideoView.this.mIV = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.mIX = false;
        this.mIY = false;
        this.mJb = false;
        this.mJi = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QE;
                if (TbCyberVideoView.this.mIT != null) {
                    TbCyberVideoView.this.mIT.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EJ(-400);
                }
                if (!TbCyberVideoView.this.mJb) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAB().a(TbCyberVideoView.this, TbCyberVideoView.this.eML);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mJc != null) {
                    TbCyberVideoView.this.mJc.onPrepared();
                }
                if (TbCyberVideoView.this.mIR && (QE = n.dAn().QE(TbCyberVideoView.this.eML)) > 0) {
                    TbCyberVideoView.this.seekTo(QE);
                }
                if (TbCyberVideoView.this.mIS) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mJj = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mIV != null) {
                    TbCyberVideoView.this.mIV.OG(TbCyberVideoView.this.mIW);
                    TbCyberVideoView.this.mIV = null;
                }
                n.dAn().remove(TbCyberVideoView.this.eML);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mIT != null) {
                        TbCyberVideoView.this.mIT.onComplete();
                    }
                    TbCyberVideoView.this.mIS = false;
                    if (TbCyberVideoView.this.mJd != null) {
                        TbCyberVideoView.this.mJd.onCompletion();
                    }
                }
            }
        };
        this.ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAv()) {
                    n.dAn().bL(TbCyberVideoView.this.eML, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAB().QH(TbCyberVideoView.this.eML);
                if (TbCyberVideoView.this.mJf != null) {
                    TbCyberVideoView.this.mJf.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mJk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mJe != null) {
                    TbCyberVideoView.this.mJe.onSeekComplete();
                }
            }
        };
        this.mJl = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mJg != null) {
                    TbCyberVideoView.this.mJg.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mIT != null) {
                    TbCyberVideoView.this.mIT.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iRw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mIV != null) {
                        TbCyberVideoView.this.mIV.OF(TbCyberVideoView.this.mIW);
                        TbCyberVideoView.this.mIV = null;
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
        super.setOnPreparedListener(this.mJi);
        super.setOnCompletionListener(this.mJj);
        super.setOnErrorListener(this.ldG);
        super.setOnSeekCompleteListener(this.mJk);
        super.setOnInfoListener(this.mJl);
        this.mIT = new b();
        this.abE = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void F(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dAp()) {
            if (!pcdnConfigData.E(uri)) {
                this.mJa = 2;
                return;
            } else if (c.dAG() <= 0) {
                this.mJa = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dAq() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dAG()));
                this.lvf = true;
                this.lvg = pcdnConfigData.dAq();
                this.mJa = 1;
                return;
            }
        }
        this.mJa = 0;
    }

    public int getPcdnState() {
        return this.mJa;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mIX = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ak.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mIX = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mIT == null) {
            this.mIT = new b();
        }
        this.mIT.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mIW = oVar.mLocate;
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
        if (this.mIT == null) {
            this.mIT = new b();
        }
        this.mIT.setThreadData(cbVar);
    }

    public void setPlayMode(String str) {
        if (this.mIT != null) {
            this.mIT.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mIT = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mJc = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mJd = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mJf = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mJe = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mJg = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mJh = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mIR = z;
    }

    public String getOriginUrl() {
        return this.eML;
    }

    public void setVideoDuration(int i) {
        this.mIZ = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!au.isEmpty(str)) {
            this.amC = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!au.isEmpty(str)) {
            dAt();
            this.eML = str;
            String QF = QF(str);
            if (mIU != null) {
                this.mIV = mIU.aM(this.amC, this.eML, null);
                if (this.mIV != null) {
                    this.mIV.ua(CyberPlayerManager.hasCacheFile(QF));
                }
            }
            this.abE.setPlayer(this);
            if (this.mIT != null) {
                this.mIT.dAr();
            }
            F(Uri.parse(QF));
            if (this.mIV != null) {
                this.mIV.dgS();
            }
            String host = Uri.parse(this.eML).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mIZ < 900)) ? "1" : "0");
            super.setVideoPath(QF);
        }
    }

    private void dAt() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mIY = true;
            if (!dAx()) {
                aVar.dAC();
            }
            if (!dAw()) {
                aVar.dAD();
                this.mIS = true;
                setVideoPath(this.eML, this.amC);
                return;
            }
        } else {
            this.mIY = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mIX) {
            ak.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.mIS = true;
        super.start();
        if (this.mIT != null) {
            this.mIT.onStart();
        }
        this.abE.start();
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().EL(-400);
            getVideoMonitor().ao(this.lvf, this.lvg);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.mIS) {
            a(aVar);
            return;
        }
        this.mIS = true;
        if (aVar != null) {
            this.mIY = true;
            if (!dAx()) {
                aVar.dAC();
            }
        } else {
            this.mIY = false;
        }
        setVideoPath(this.eML, this.amC);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ak.a(this.mWeakContext, false);
        if (isPlaying() && dAv()) {
            n.dAn().bL(this.eML, getCurrentPositionSync());
        }
        super.pause();
        if (this.mIT != null) {
            this.mIT.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mIV != null) {
            this.mIV.dgT();
        }
    }

    public void stop() {
        if (!this.mIY) {
            stopPlayback();
            return;
        }
        if (this.eML != null && isPlaying()) {
            ak.a(this.mWeakContext, false);
        }
        this.mIS = false;
        if (isPlaying() && dAv()) {
            n.dAn().bL(this.eML, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mIT != null) {
            this.mIT.onStop();
        }
        this.abE.stop();
        if (this.mIV != null && this.mIV.OH(this.mIW)) {
            this.mIV = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eML != null && isPlaying()) {
            ak.a(this.mWeakContext, false);
        }
        this.mIS = false;
        if (isPlaying() && dAv()) {
            n.dAn().bL(this.eML, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dAB().QH(this.eML);
        if (this.mIT != null) {
            this.mIT.onStop();
        }
        this.abE.stop();
        if (this.mIV != null && this.mIV.OH(this.mIW)) {
            this.mIV = null;
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
        MessageManager.getInstance().registerListener(this.iRw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mJh != null) {
            this.mJh.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.iRw);
    }

    private String QF(String str) {
        if (!au.isEmpty(str) && com.baidu.tieba.video.f.dSf().dSg()) {
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

    public boolean dAu() {
        return this.mIS;
    }

    public void h(long j, long j2, long j3) {
        if (this.mIV != null) {
            this.mIV.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dAv() {
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
        this.mIW = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        if (this.mIV != null) {
            return this.mIV;
        }
        if (!StringUtils.isNull(this.eML) && mIU != null) {
            this.mIV = mIU.aM(this.amC, this.eML, null);
        }
        return this.mIV;
    }

    private boolean dAw() {
        return this == TbVideoViewSet.dAB().QG(this.eML);
    }

    private boolean dAx() {
        return getParent() != null;
    }

    public void dAy() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mJh = null;
        this.mJd = null;
        this.mJf = null;
        this.mJg = null;
        this.mJc = null;
        this.mJe = null;
        this.abE.a((f.b) null);
        this.abE.a((f.a) null);
        this.abE.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.abE;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mIY = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.mJb = z;
    }

    @Deprecated
    public void dAz() {
        if (this.mIT != null) {
            this.mIT.dAr();
            this.mIT.hA(getDuration());
            this.mIT.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().ua(CyberPlayerManager.hasCacheFile(this.eML));
            getVideoMonitor().EK(-400);
        }
    }

    @Deprecated
    public void dAA() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().ua(CyberPlayerManager.hasCacheFile(this.eML));
            getVideoMonitor().dgS();
            getVideoMonitor().EJ(-400);
        }
    }
}
