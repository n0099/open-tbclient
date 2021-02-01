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
    private static k mIE;
    private f abE;
    private String amC;
    private String eML;
    private final CustomMessageListener iRi;
    private CyberPlayerManager.OnErrorListener lds;
    private boolean luR;
    private boolean luS;
    private boolean mIA;
    private boolean mIB;
    private b mIC;
    private h mIF;
    private String mIG;
    private boolean mIH;
    private boolean mII;
    private int mIJ;
    private int mIK;
    private boolean mIL;
    private CyberPlayerManager.OnPreparedListener mIM;
    private CyberPlayerManager.OnCompletionListener mIN;
    private CyberPlayerManager.OnSeekCompleteListener mIO;
    private CyberPlayerManager.OnErrorListener mIQ;
    private CyberPlayerManager.OnInfoListener mIR;
    private a mIS;
    private CyberPlayerManager.OnPreparedListener mIT;
    private CyberPlayerManager.OnCompletionListener mIU;
    private CyberPlayerManager.OnSeekCompleteListener mIV;
    private CyberPlayerManager.OnInfoListener mIW;
    private PowerManager.WakeLock mWakeLock;
    private WeakReference<Context> mWeakContext;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        if (runTask != null) {
            mIE = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWeakContext = null;
        this.mIH = false;
        this.mII = false;
        this.mIL = false;
        this.mIT = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QD;
                if (TbCyberVideoView.this.mIC != null) {
                    TbCyberVideoView.this.mIC.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EJ(-400);
                }
                if (!TbCyberVideoView.this.mIL) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAu().a(TbCyberVideoView.this, TbCyberVideoView.this.eML);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mIM != null) {
                    TbCyberVideoView.this.mIM.onPrepared();
                }
                if (TbCyberVideoView.this.mIA && (QD = n.dAg().QD(TbCyberVideoView.this.eML)) > 0) {
                    TbCyberVideoView.this.seekTo(QD);
                }
                if (TbCyberVideoView.this.mIB) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mIU = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mIF != null) {
                    TbCyberVideoView.this.mIF.OF(TbCyberVideoView.this.mIG);
                    TbCyberVideoView.this.mIF = null;
                }
                n.dAg().remove(TbCyberVideoView.this.eML);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mIC != null) {
                        TbCyberVideoView.this.mIC.onComplete();
                    }
                    TbCyberVideoView.this.mIB = false;
                    if (TbCyberVideoView.this.mIN != null) {
                        TbCyberVideoView.this.mIN.onCompletion();
                    }
                }
            }
        };
        this.lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAo()) {
                    n.dAg().bL(TbCyberVideoView.this.eML, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAu().QG(TbCyberVideoView.this.eML);
                if (TbCyberVideoView.this.mIQ != null) {
                    TbCyberVideoView.this.mIQ.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mIV = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mIO != null) {
                    TbCyberVideoView.this.mIO.onSeekComplete();
                }
            }
        };
        this.mIW = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mIR != null) {
                    TbCyberVideoView.this.mIR.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mIC != null) {
                    TbCyberVideoView.this.mIC.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iRi = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mIF != null) {
                        TbCyberVideoView.this.mIF.OE(TbCyberVideoView.this.mIG);
                        TbCyberVideoView.this.mIF = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.mWeakContext = null;
        this.mIH = false;
        this.mII = false;
        this.mIL = false;
        this.mIT = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QD;
                if (TbCyberVideoView.this.mIC != null) {
                    TbCyberVideoView.this.mIC.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EJ(-400);
                }
                if (!TbCyberVideoView.this.mIL) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAu().a(TbCyberVideoView.this, TbCyberVideoView.this.eML);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mIM != null) {
                    TbCyberVideoView.this.mIM.onPrepared();
                }
                if (TbCyberVideoView.this.mIA && (QD = n.dAg().QD(TbCyberVideoView.this.eML)) > 0) {
                    TbCyberVideoView.this.seekTo(QD);
                }
                if (TbCyberVideoView.this.mIB) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mIU = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mIF != null) {
                    TbCyberVideoView.this.mIF.OF(TbCyberVideoView.this.mIG);
                    TbCyberVideoView.this.mIF = null;
                }
                n.dAg().remove(TbCyberVideoView.this.eML);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mIC != null) {
                        TbCyberVideoView.this.mIC.onComplete();
                    }
                    TbCyberVideoView.this.mIB = false;
                    if (TbCyberVideoView.this.mIN != null) {
                        TbCyberVideoView.this.mIN.onCompletion();
                    }
                }
            }
        };
        this.lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAo()) {
                    n.dAg().bL(TbCyberVideoView.this.eML, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAu().QG(TbCyberVideoView.this.eML);
                if (TbCyberVideoView.this.mIQ != null) {
                    TbCyberVideoView.this.mIQ.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mIV = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mIO != null) {
                    TbCyberVideoView.this.mIO.onSeekComplete();
                }
            }
        };
        this.mIW = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mIR != null) {
                    TbCyberVideoView.this.mIR.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mIC != null) {
                    TbCyberVideoView.this.mIC.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iRi = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mIF != null) {
                        TbCyberVideoView.this.mIF.OE(TbCyberVideoView.this.mIG);
                        TbCyberVideoView.this.mIF = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.mWeakContext = null;
        this.mIH = false;
        this.mII = false;
        this.mIL = false;
        this.mIT = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int QD;
                if (TbCyberVideoView.this.mIC != null) {
                    TbCyberVideoView.this.mIC.hA(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().EJ(-400);
                }
                if (!TbCyberVideoView.this.mIL) {
                    if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                        TbVideoViewSet.dAu().a(TbCyberVideoView.this, TbCyberVideoView.this.eML);
                    } else {
                        return;
                    }
                }
                if (TbCyberVideoView.this.mIM != null) {
                    TbCyberVideoView.this.mIM.onPrepared();
                }
                if (TbCyberVideoView.this.mIA && (QD = n.dAg().QD(TbCyberVideoView.this.eML)) > 0) {
                    TbCyberVideoView.this.seekTo(QD);
                }
                if (TbCyberVideoView.this.mIB) {
                    TbCyberVideoView.this.start();
                }
            }
        };
        this.mIU = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.mIF != null) {
                    TbCyberVideoView.this.mIF.OF(TbCyberVideoView.this.mIG);
                    TbCyberVideoView.this.mIF = null;
                }
                n.dAg().remove(TbCyberVideoView.this.eML);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.mIC != null) {
                        TbCyberVideoView.this.mIC.onComplete();
                    }
                    TbCyberVideoView.this.mIB = false;
                    if (TbCyberVideoView.this.mIN != null) {
                        TbCyberVideoView.this.mIN.onCompletion();
                    }
                }
            }
        };
        this.lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dAo()) {
                    n.dAg().bL(TbCyberVideoView.this.eML, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dAu().QG(TbCyberVideoView.this.eML);
                if (TbCyberVideoView.this.mIQ != null) {
                    TbCyberVideoView.this.mIQ.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.mIV = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.mIO != null) {
                    TbCyberVideoView.this.mIO.onSeekComplete();
                }
            }
        };
        this.mIW = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.mIR != null) {
                    TbCyberVideoView.this.mIR.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().F(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.mIC != null) {
                    TbCyberVideoView.this.mIC.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.iRi = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.mIF != null) {
                        TbCyberVideoView.this.mIF.OE(TbCyberVideoView.this.mIG);
                        TbCyberVideoView.this.mIF = null;
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
        super.setOnPreparedListener(this.mIT);
        super.setOnCompletionListener(this.mIU);
        super.setOnErrorListener(this.lds);
        super.setOnSeekCompleteListener(this.mIV);
        super.setOnInfoListener(this.mIW);
        this.mIC = new b();
        this.abE = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void F(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dAi()) {
            if (!pcdnConfigData.E(uri)) {
                this.mIK = 2;
                return;
            } else if (c.dAz() <= 0) {
                this.mIK = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dAj() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dAz()));
                this.luR = true;
                this.luS = pcdnConfigData.dAj();
                this.mIK = 1;
                return;
            }
        }
        this.mIK = 0;
    }

    public int getPcdnState() {
        return this.mIK;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.mIH = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ak.a(this.mWeakContext, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.mIH = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.mIC == null) {
            this.mIC = new b();
        }
        this.mIC.setVideoStatsData(oVar);
        if (oVar != null) {
            this.mIG = oVar.mLocate;
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
        if (this.mIC == null) {
            this.mIC = new b();
        }
        this.mIC.setThreadData(cbVar);
    }

    public void setPlayMode(String str) {
        if (this.mIC != null) {
            this.mIC.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.mIC = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mIM = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mIN = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mIQ = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mIO = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mIR = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.mIS = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.mIA = z;
    }

    public String getOriginUrl() {
        return this.eML;
    }

    public void setVideoDuration(int i) {
        this.mIJ = i;
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
            dAm();
            this.eML = str;
            String QE = QE(str);
            if (mIE != null) {
                this.mIF = mIE.aM(this.amC, this.eML, null);
                if (this.mIF != null) {
                    this.mIF.ua(CyberPlayerManager.hasCacheFile(QE));
                }
            }
            this.abE.setPlayer(this);
            if (this.mIC != null) {
                this.mIC.dAk();
            }
            F(Uri.parse(QE));
            if (this.mIF != null) {
                this.mIF.dgL();
            }
            String host = Uri.parse(this.eML).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.mIJ < 900)) ? "1" : "0");
            super.setVideoPath(QE);
        }
    }

    private void dAm() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.mII = true;
            if (!dAq()) {
                aVar.dAv();
            }
            if (!dAp()) {
                aVar.dAw();
                this.mIB = true;
                setVideoPath(this.eML, this.amC);
                return;
            }
        } else {
            this.mII = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.mIH) {
            ak.a(this.mWeakContext, true);
            setVolume(1.0f, 1.0f);
        }
        this.mIB = true;
        super.start();
        if (this.mIC != null) {
            this.mIC.onStart();
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
            getVideoMonitor().ao(this.luR, this.luS);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.mIB) {
            a(aVar);
            return;
        }
        this.mIB = true;
        if (aVar != null) {
            this.mII = true;
            if (!dAq()) {
                aVar.dAv();
            }
        } else {
            this.mII = false;
        }
        setVideoPath(this.eML, this.amC);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ak.a(this.mWeakContext, false);
        if (isPlaying() && dAo()) {
            n.dAg().bL(this.eML, getCurrentPositionSync());
        }
        super.pause();
        if (this.mIC != null) {
            this.mIC.onPause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mIF != null) {
            this.mIF.dgM();
        }
    }

    public void stop() {
        if (!this.mII) {
            stopPlayback();
            return;
        }
        if (this.eML != null && isPlaying()) {
            ak.a(this.mWeakContext, false);
        }
        this.mIB = false;
        if (isPlaying() && dAo()) {
            n.dAg().bL(this.eML, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.mIC != null) {
            this.mIC.onStop();
        }
        this.abE.stop();
        if (this.mIF != null && this.mIF.OG(this.mIG)) {
            this.mIF = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.eML != null && isPlaying()) {
            ak.a(this.mWeakContext, false);
        }
        this.mIB = false;
        if (isPlaying() && dAo()) {
            n.dAg().bL(this.eML, getCurrentPositionSync());
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dAu().QG(this.eML);
        if (this.mIC != null) {
            this.mIC.onStop();
        }
        this.abE.stop();
        if (this.mIF != null && this.mIF.OG(this.mIG)) {
            this.mIF = null;
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
        MessageManager.getInstance().registerListener(this.iRi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIS != null) {
            this.mIS.onSurfaceDestroyed();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.iRi);
    }

    private String QE(String str) {
        if (!au.isEmpty(str) && com.baidu.tieba.video.f.dRX().dRY()) {
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

    public boolean dAn() {
        return this.mIB;
    }

    public void h(long j, long j2, long j3) {
        if (this.mIF != null) {
            this.mIF.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dAo() {
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
        this.mIG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        if (this.mIF != null) {
            return this.mIF;
        }
        if (!StringUtils.isNull(this.eML) && mIE != null) {
            this.mIF = mIE.aM(this.amC, this.eML, null);
        }
        return this.mIF;
    }

    private boolean dAp() {
        return this == TbVideoViewSet.dAu().QF(this.eML);
    }

    private boolean dAq() {
        return getParent() != null;
    }

    public void dAr() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.mIS = null;
        this.mIN = null;
        this.mIQ = null;
        this.mIR = null;
        this.mIM = null;
        this.mIO = null;
        this.abE.a((f.b) null);
        this.abE.a((f.a) null);
        this.abE.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.abE;
    }

    public void setTryUseViewInSet(boolean z) {
        this.mII = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.mIL = z;
    }

    @Deprecated
    public void dAs() {
        if (this.mIC != null) {
            this.mIC.dAk();
            this.mIC.hA(getDuration());
            this.mIC.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().ua(CyberPlayerManager.hasCacheFile(this.eML));
            getVideoMonitor().EK(-400);
        }
    }

    @Deprecated
    public void dAt() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().ua(CyberPlayerManager.hasCacheFile(this.eML));
            getVideoMonitor().dgL();
            getVideoMonitor().EJ(-400);
        }
    }
}
