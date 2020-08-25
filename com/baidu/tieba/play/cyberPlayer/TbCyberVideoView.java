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
import com.baidu.tbadk.util.ah;
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
/* loaded from: classes2.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    private static l ltA;
    private f Zo;
    private WeakReference<Context> akU;
    private String akY;
    private String dXv;
    private final CustomMessageListener hDL;
    private CyberPlayerManager.OnErrorListener jQt;
    private boolean khL;
    private boolean khM;
    private i ltB;
    private String ltC;
    private PowerManager.WakeLock ltD;
    private boolean ltE;
    private boolean ltF;
    private int ltG;
    private int ltH;
    private CyberPlayerManager.OnPreparedListener ltI;
    private CyberPlayerManager.OnCompletionListener ltJ;
    private CyberPlayerManager.OnSeekCompleteListener ltK;
    private CyberPlayerManager.OnErrorListener ltL;
    private CyberPlayerManager.OnInfoListener ltM;
    private a ltN;
    private CyberPlayerManager.OnPreparedListener ltO;
    private CyberPlayerManager.OnCompletionListener ltP;
    private CyberPlayerManager.OnSeekCompleteListener ltQ;
    private CyberPlayerManager.OnInfoListener ltR;
    private boolean ltx;
    private boolean lty;
    private b ltz;

    /* loaded from: classes2.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            ltA = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akU = null;
        this.ltE = false;
        this.ltF = false;
        this.ltO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int OE;
                if (TbCyberVideoView.this.ltz != null) {
                    TbCyberVideoView.this.ltz.fN(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().De(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dkr().a(TbCyberVideoView.this, TbCyberVideoView.this.dXv);
                    if (TbCyberVideoView.this.ltI != null) {
                        TbCyberVideoView.this.ltI.onPrepared();
                    }
                    if (TbCyberVideoView.this.ltx && (OE = n.dkd().OE(TbCyberVideoView.this.dXv)) > 0) {
                        TbCyberVideoView.this.seekTo(OE);
                    }
                    if (TbCyberVideoView.this.lty) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.ltP = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ltB != null) {
                    TbCyberVideoView.this.ltB.MH(TbCyberVideoView.this.ltC);
                    TbCyberVideoView.this.ltB = null;
                }
                n.dkd().remove(TbCyberVideoView.this.dXv);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ltz != null) {
                        TbCyberVideoView.this.ltz.onComplete();
                    }
                    TbCyberVideoView.this.lty = false;
                    if (TbCyberVideoView.this.ltJ != null) {
                        TbCyberVideoView.this.ltJ.onCompletion();
                    }
                }
            }
        };
        this.jQt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dkl()) {
                    n.dkd().by(TbCyberVideoView.this.dXv, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dkr().OH(TbCyberVideoView.this.dXv);
                if (TbCyberVideoView.this.ltL != null) {
                    TbCyberVideoView.this.ltL.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.ltQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.onSeekComplete();
                }
            }
        };
        this.ltR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ltM != null) {
                    TbCyberVideoView.this.ltM.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ltz != null) {
                    TbCyberVideoView.this.ltz.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hDL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ltB != null) {
                        TbCyberVideoView.this.ltB.MG(TbCyberVideoView.this.ltC);
                        TbCyberVideoView.this.ltB = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.akU = null;
        this.ltE = false;
        this.ltF = false;
        this.ltO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int OE;
                if (TbCyberVideoView.this.ltz != null) {
                    TbCyberVideoView.this.ltz.fN(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().De(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dkr().a(TbCyberVideoView.this, TbCyberVideoView.this.dXv);
                    if (TbCyberVideoView.this.ltI != null) {
                        TbCyberVideoView.this.ltI.onPrepared();
                    }
                    if (TbCyberVideoView.this.ltx && (OE = n.dkd().OE(TbCyberVideoView.this.dXv)) > 0) {
                        TbCyberVideoView.this.seekTo(OE);
                    }
                    if (TbCyberVideoView.this.lty) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.ltP = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ltB != null) {
                    TbCyberVideoView.this.ltB.MH(TbCyberVideoView.this.ltC);
                    TbCyberVideoView.this.ltB = null;
                }
                n.dkd().remove(TbCyberVideoView.this.dXv);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ltz != null) {
                        TbCyberVideoView.this.ltz.onComplete();
                    }
                    TbCyberVideoView.this.lty = false;
                    if (TbCyberVideoView.this.ltJ != null) {
                        TbCyberVideoView.this.ltJ.onCompletion();
                    }
                }
            }
        };
        this.jQt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dkl()) {
                    n.dkd().by(TbCyberVideoView.this.dXv, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dkr().OH(TbCyberVideoView.this.dXv);
                if (TbCyberVideoView.this.ltL != null) {
                    TbCyberVideoView.this.ltL.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.ltQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.onSeekComplete();
                }
            }
        };
        this.ltR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ltM != null) {
                    TbCyberVideoView.this.ltM.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ltz != null) {
                    TbCyberVideoView.this.ltz.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hDL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ltB != null) {
                        TbCyberVideoView.this.ltB.MG(TbCyberVideoView.this.ltC);
                        TbCyberVideoView.this.ltB = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.akU = null;
        this.ltE = false;
        this.ltF = false;
        this.ltO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int OE;
                if (TbCyberVideoView.this.ltz != null) {
                    TbCyberVideoView.this.ltz.fN(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().De(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dkr().a(TbCyberVideoView.this, TbCyberVideoView.this.dXv);
                    if (TbCyberVideoView.this.ltI != null) {
                        TbCyberVideoView.this.ltI.onPrepared();
                    }
                    if (TbCyberVideoView.this.ltx && (OE = n.dkd().OE(TbCyberVideoView.this.dXv)) > 0) {
                        TbCyberVideoView.this.seekTo(OE);
                    }
                    if (TbCyberVideoView.this.lty) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.ltP = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ltB != null) {
                    TbCyberVideoView.this.ltB.MH(TbCyberVideoView.this.ltC);
                    TbCyberVideoView.this.ltB = null;
                }
                n.dkd().remove(TbCyberVideoView.this.dXv);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ltz != null) {
                        TbCyberVideoView.this.ltz.onComplete();
                    }
                    TbCyberVideoView.this.lty = false;
                    if (TbCyberVideoView.this.ltJ != null) {
                        TbCyberVideoView.this.ltJ.onCompletion();
                    }
                }
            }
        };
        this.jQt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dkl()) {
                    n.dkd().by(TbCyberVideoView.this.dXv, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dkr().OH(TbCyberVideoView.this.dXv);
                if (TbCyberVideoView.this.ltL != null) {
                    TbCyberVideoView.this.ltL.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.ltQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.onSeekComplete();
                }
            }
        };
        this.ltR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ltM != null) {
                    TbCyberVideoView.this.ltM.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ltz != null) {
                    TbCyberVideoView.this.ltz.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hDL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ltB != null) {
                        TbCyberVideoView.this.ltB.MG(TbCyberVideoView.this.ltC);
                        TbCyberVideoView.this.ltB = null;
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
                this.ltD = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.ltD.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.akU = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.ltO);
        super.setOnCompletionListener(this.ltP);
        super.setOnErrorListener(this.jQt);
        super.setOnSeekCompleteListener(this.ltQ);
        super.setOnInfoListener(this.ltR);
        this.ltz = new b();
        this.Zo = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void y(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dkf()) {
            if (!pcdnConfigData.x(uri)) {
                this.ltH = 2;
                return;
            } else if (c.dkw() <= 0) {
                this.ltH = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dkg() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dkw()));
                this.khL = true;
                this.khM = pcdnConfigData.dkg();
                this.ltH = 1;
                return;
            }
        }
        this.ltH = 0;
    }

    public int getPcdnState() {
        return this.ltH;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.ltE = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ah.a(this.akU, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.ltE = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.ltz == null) {
            this.ltz = new b();
        }
        this.ltz.setVideoStatsData(oVar);
        if (oVar != null) {
            this.ltC = oVar.mLocate;
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
        if (this.ltz == null) {
            this.ltz = new b();
        }
        this.ltz.setThreadData(bwVar);
    }

    public void setPlayMode(String str) {
        if (this.ltz != null) {
            this.ltz.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.ltz = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.ltI = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.ltJ = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.ltL = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.ltK = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.ltM = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.ltN = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.ltx = z;
    }

    public String getOriginUrl() {
        return this.dXv;
    }

    public void setVideoDuration(int i) {
        this.ltG = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!at.isEmpty(str)) {
            this.akY = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!at.isEmpty(str)) {
            dkj();
            this.dXv = str;
            String OF = OF(str);
            if (ltA != null) {
                this.ltB = ltA.av(this.akY, this.dXv, null);
                if (this.ltB != null) {
                    this.ltB.rU(CyberPlayerManager.hasCacheFile(OF));
                }
            }
            this.Zo.setPlayer(this);
            if (this.ltz != null) {
                this.ltz.dkh();
            }
            y(Uri.parse(OF));
            if (this.ltB != null) {
                this.ltB.cRg();
            }
            String host = Uri.parse(this.dXv).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.ltG < 900)) ? "1" : "0");
            super.setVideoPath(OF);
        }
    }

    private void dkj() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.ltF = true;
            if (!dkn()) {
                aVar.dks();
            }
            if (!dkm()) {
                aVar.dkt();
                this.lty = true;
                setVideoPath(this.dXv, this.akY);
                return;
            }
        } else {
            this.ltF = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.ltE) {
            ah.a(this.akU, true);
            setVolume(1.0f, 1.0f);
        }
        this.lty = true;
        super.start();
        if (this.ltz != null) {
            this.ltz.onStart();
        }
        this.Zo.start();
        try {
            if (this.ltD != null && !this.ltD.isHeld()) {
                this.ltD.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().Dg(-400);
            getVideoMonitor().ai(this.khL, this.khM);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.lty) {
            a(aVar);
            return;
        }
        this.lty = true;
        if (aVar != null) {
            this.ltF = true;
            if (!dkn()) {
                aVar.dks();
            }
        } else {
            this.ltF = false;
        }
        setVideoPath(this.dXv, this.akY);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ah.a(this.akU, false);
        if (isPlaying() && dkl()) {
            n.dkd().by(this.dXv, getCurrentPositionSync());
        }
        super.pause();
        if (this.ltz != null) {
            this.ltz.onPause();
        }
        try {
            if (this.ltD != null && this.ltD.isHeld()) {
                this.ltD.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ltB != null) {
            this.ltB.cRh();
        }
    }

    public void stop() {
        if (!this.ltF) {
            stopPlayback();
            return;
        }
        if (this.dXv != null && isPlaying()) {
            ah.a(this.akU, false);
        }
        this.lty = false;
        if (isPlaying() && dkl()) {
            n.dkd().by(this.dXv, getCurrentPositionSync());
        }
        try {
            if (this.ltD != null && this.ltD.isHeld()) {
                this.ltD.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.ltz != null) {
            this.ltz.onStop();
        }
        this.Zo.stop();
        if (this.ltB != null && this.ltB.MI(this.ltC)) {
            this.ltB = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.dXv != null && isPlaying()) {
            ah.a(this.akU, false);
        }
        this.lty = false;
        if (isPlaying() && dkl()) {
            n.dkd().by(this.dXv, getCurrentPositionSync());
        }
        try {
            if (this.ltD != null && this.ltD.isHeld()) {
                this.ltD.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dkr().OH(this.dXv);
        if (this.ltz != null) {
            this.ltz.onStop();
        }
        this.Zo.stop();
        if (this.ltB != null && this.ltB.MI(this.ltC)) {
            this.ltB = null;
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
        MessageManager.getInstance().registerListener(this.hDL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ltN != null) {
            this.ltN.onSurfaceDestroyed();
        }
        try {
            if (this.ltD != null && this.ltD.isHeld()) {
                this.ltD.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.hDL);
    }

    private String OF(String str) {
        if (!at.isEmpty(str) && g.dAV().dAW()) {
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

    public boolean dkk() {
        return this.lty;
    }

    public void h(long j, long j2, long j3) {
        if (this.ltB != null) {
            this.ltB.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dkl() {
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
        this.ltC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.ltB != null) {
            return this.ltB;
        }
        if (!StringUtils.isNull(this.dXv) && ltA != null) {
            this.ltB = ltA.av(this.akY, this.dXv, null);
        }
        return this.ltB;
    }

    private boolean dkm() {
        return this == TbVideoViewSet.dkr().OG(this.dXv);
    }

    private boolean dkn() {
        return getParent() != null;
    }

    public void dko() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.ltN = null;
        this.ltJ = null;
        this.ltL = null;
        this.ltM = null;
        this.ltI = null;
        this.ltK = null;
        this.Zo.a((f.b) null);
        this.Zo.a((f.a) null);
        this.Zo.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.Zo;
    }

    public void setTryUseViewInSet(boolean z) {
        this.ltF = z;
    }

    @Deprecated
    public void dkp() {
        if (this.ltz != null) {
            this.ltz.dkh();
            this.ltz.fN(getDuration());
            this.ltz.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().rU(CyberPlayerManager.hasCacheFile(this.dXv));
            getVideoMonitor().Df(-400);
        }
    }

    @Deprecated
    public void dkq() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().rU(CyberPlayerManager.hasCacheFile(this.dXv));
            getVideoMonitor().cRg();
            getVideoMonitor().De(-400);
        }
    }
}
