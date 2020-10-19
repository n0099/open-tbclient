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
    private static l lRR;
    private f ZY;
    private WeakReference<Context> alO;
    private String alS;
    private String elL;
    private final CustomMessageListener hZO;
    private boolean kFE;
    private boolean kFF;
    private CyberPlayerManager.OnErrorListener kor;
    private boolean lRO;
    private boolean lRP;
    private b lRQ;
    private i lRS;
    private String lRT;
    private PowerManager.WakeLock lRU;
    private boolean lRV;
    private boolean lRW;
    private int lRX;
    private int lRY;
    private CyberPlayerManager.OnPreparedListener lRZ;
    private CyberPlayerManager.OnCompletionListener lSa;
    private CyberPlayerManager.OnSeekCompleteListener lSb;
    private CyberPlayerManager.OnErrorListener lSc;
    private CyberPlayerManager.OnInfoListener lSd;
    private a lSe;
    private CyberPlayerManager.OnPreparedListener lSf;
    private CyberPlayerManager.OnCompletionListener lSg;
    private CyberPlayerManager.OnSeekCompleteListener lSh;
    private CyberPlayerManager.OnInfoListener lSi;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            lRR = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alO = null;
        this.lRV = false;
        this.lRW = false;
        this.lSf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int PV;
                if (TbCyberVideoView.this.lRQ != null) {
                    TbCyberVideoView.this.lRQ.gv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().El(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.drM().a(TbCyberVideoView.this, TbCyberVideoView.this.elL);
                    if (TbCyberVideoView.this.lRZ != null) {
                        TbCyberVideoView.this.lRZ.onPrepared();
                    }
                    if (TbCyberVideoView.this.lRO && (PV = n.dry().PV(TbCyberVideoView.this.elL)) > 0) {
                        TbCyberVideoView.this.seekTo(PV);
                    }
                    if (TbCyberVideoView.this.lRP) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lSg = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.lRS != null) {
                    TbCyberVideoView.this.lRS.NZ(TbCyberVideoView.this.lRT);
                    TbCyberVideoView.this.lRS = null;
                }
                n.dry().remove(TbCyberVideoView.this.elL);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.lRQ != null) {
                        TbCyberVideoView.this.lRQ.onComplete();
                    }
                    TbCyberVideoView.this.lRP = false;
                    if (TbCyberVideoView.this.lSa != null) {
                        TbCyberVideoView.this.lSa.onCompletion();
                    }
                }
            }
        };
        this.kor = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.drG()) {
                    n.dry().bz(TbCyberVideoView.this.elL, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.drM().PY(TbCyberVideoView.this.elL);
                if (TbCyberVideoView.this.lSc != null) {
                    TbCyberVideoView.this.lSc.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lSh = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.lSb != null) {
                    TbCyberVideoView.this.lSb.onSeekComplete();
                }
            }
        };
        this.lSi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.lSd != null) {
                    TbCyberVideoView.this.lSd.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().A(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.lRQ != null) {
                    TbCyberVideoView.this.lRQ.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hZO = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.lRS != null) {
                        TbCyberVideoView.this.lRS.NY(TbCyberVideoView.this.lRT);
                        TbCyberVideoView.this.lRS = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.alO = null;
        this.lRV = false;
        this.lRW = false;
        this.lSf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int PV;
                if (TbCyberVideoView.this.lRQ != null) {
                    TbCyberVideoView.this.lRQ.gv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().El(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.drM().a(TbCyberVideoView.this, TbCyberVideoView.this.elL);
                    if (TbCyberVideoView.this.lRZ != null) {
                        TbCyberVideoView.this.lRZ.onPrepared();
                    }
                    if (TbCyberVideoView.this.lRO && (PV = n.dry().PV(TbCyberVideoView.this.elL)) > 0) {
                        TbCyberVideoView.this.seekTo(PV);
                    }
                    if (TbCyberVideoView.this.lRP) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lSg = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.lRS != null) {
                    TbCyberVideoView.this.lRS.NZ(TbCyberVideoView.this.lRT);
                    TbCyberVideoView.this.lRS = null;
                }
                n.dry().remove(TbCyberVideoView.this.elL);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.lRQ != null) {
                        TbCyberVideoView.this.lRQ.onComplete();
                    }
                    TbCyberVideoView.this.lRP = false;
                    if (TbCyberVideoView.this.lSa != null) {
                        TbCyberVideoView.this.lSa.onCompletion();
                    }
                }
            }
        };
        this.kor = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.drG()) {
                    n.dry().bz(TbCyberVideoView.this.elL, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.drM().PY(TbCyberVideoView.this.elL);
                if (TbCyberVideoView.this.lSc != null) {
                    TbCyberVideoView.this.lSc.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lSh = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.lSb != null) {
                    TbCyberVideoView.this.lSb.onSeekComplete();
                }
            }
        };
        this.lSi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.lSd != null) {
                    TbCyberVideoView.this.lSd.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().A(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.lRQ != null) {
                    TbCyberVideoView.this.lRQ.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hZO = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.lRS != null) {
                        TbCyberVideoView.this.lRS.NY(TbCyberVideoView.this.lRT);
                        TbCyberVideoView.this.lRS = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.alO = null;
        this.lRV = false;
        this.lRW = false;
        this.lSf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int PV;
                if (TbCyberVideoView.this.lRQ != null) {
                    TbCyberVideoView.this.lRQ.gv(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().El(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.drM().a(TbCyberVideoView.this, TbCyberVideoView.this.elL);
                    if (TbCyberVideoView.this.lRZ != null) {
                        TbCyberVideoView.this.lRZ.onPrepared();
                    }
                    if (TbCyberVideoView.this.lRO && (PV = n.dry().PV(TbCyberVideoView.this.elL)) > 0) {
                        TbCyberVideoView.this.seekTo(PV);
                    }
                    if (TbCyberVideoView.this.lRP) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lSg = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.lRS != null) {
                    TbCyberVideoView.this.lRS.NZ(TbCyberVideoView.this.lRT);
                    TbCyberVideoView.this.lRS = null;
                }
                n.dry().remove(TbCyberVideoView.this.elL);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.lRQ != null) {
                        TbCyberVideoView.this.lRQ.onComplete();
                    }
                    TbCyberVideoView.this.lRP = false;
                    if (TbCyberVideoView.this.lSa != null) {
                        TbCyberVideoView.this.lSa.onCompletion();
                    }
                }
            }
        };
        this.kor = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.drG()) {
                    n.dry().bz(TbCyberVideoView.this.elL, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.drM().PY(TbCyberVideoView.this.elL);
                if (TbCyberVideoView.this.lSc != null) {
                    TbCyberVideoView.this.lSc.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lSh = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.lSb != null) {
                    TbCyberVideoView.this.lSb.onSeekComplete();
                }
            }
        };
        this.lSi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.lSd != null) {
                    TbCyberVideoView.this.lSd.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().A(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.lRQ != null) {
                    TbCyberVideoView.this.lRQ.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hZO = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.lRS != null) {
                        TbCyberVideoView.this.lRS.NY(TbCyberVideoView.this.lRT);
                        TbCyberVideoView.this.lRS = null;
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
                this.lRU = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.lRU.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.alO = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.lSf);
        super.setOnCompletionListener(this.lSg);
        super.setOnErrorListener(this.kor);
        super.setOnSeekCompleteListener(this.lSh);
        super.setOnInfoListener(this.lSi);
        this.lRQ = new b();
        this.ZY = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void z(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.drA()) {
            if (!pcdnConfigData.y(uri)) {
                this.lRY = 2;
                return;
            } else if (c.drR() <= 0) {
                this.lRY = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.drB() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.drR()));
                this.kFE = true;
                this.kFF = pcdnConfigData.drB();
                this.lRY = 1;
                return;
            }
        }
        this.lRY = 0;
    }

    public int getPcdnState() {
        return this.lRY;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.lRV = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ai.a(this.alO, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.lRV = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.lRQ == null) {
            this.lRQ = new b();
        }
        this.lRQ.setVideoStatsData(oVar);
        if (oVar != null) {
            this.lRT = oVar.mLocate;
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
        if (this.lRQ == null) {
            this.lRQ = new b();
        }
        this.lRQ.setThreadData(bwVar);
    }

    public void setPlayMode(String str) {
        if (this.lRQ != null) {
            this.lRQ.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.lRQ = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.lRZ = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lSa = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lSc = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.lSb = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.lSd = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.lSe = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.lRO = z;
    }

    public String getOriginUrl() {
        return this.elL;
    }

    public void setVideoDuration(int i) {
        this.lRX = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!at.isEmpty(str)) {
            this.alS = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!at.isEmpty(str)) {
            drE();
            this.elL = str;
            String PW = PW(str);
            if (lRR != null) {
                this.lRS = lRR.ax(this.alS, this.elL, null);
                if (this.lRS != null) {
                    this.lRS.sL(CyberPlayerManager.hasCacheFile(PW));
                }
            }
            this.ZY.setPlayer(this);
            if (this.lRQ != null) {
                this.lRQ.drC();
            }
            z(Uri.parse(PW));
            if (this.lRS != null) {
                this.lRS.cYw();
            }
            String host = Uri.parse(this.elL).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.lRX < 900)) ? "1" : "0");
            super.setVideoPath(PW);
        }
    }

    private void drE() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.lRW = true;
            if (!drI()) {
                aVar.drN();
            }
            if (!drH()) {
                aVar.drO();
                this.lRP = true;
                setVideoPath(this.elL, this.alS);
                return;
            }
        } else {
            this.lRW = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.lRV) {
            ai.a(this.alO, true);
            setVolume(1.0f, 1.0f);
        }
        this.lRP = true;
        super.start();
        if (this.lRQ != null) {
            this.lRQ.onStart();
        }
        this.ZY.start();
        try {
            if (this.lRU != null && !this.lRU.isHeld()) {
                this.lRU.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().En(-400);
            getVideoMonitor().aj(this.kFE, this.kFF);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.lRP) {
            a(aVar);
            return;
        }
        this.lRP = true;
        if (aVar != null) {
            this.lRW = true;
            if (!drI()) {
                aVar.drN();
            }
        } else {
            this.lRW = false;
        }
        setVideoPath(this.elL, this.alS);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ai.a(this.alO, false);
        if (isPlaying() && drG()) {
            n.dry().bz(this.elL, getCurrentPositionSync());
        }
        super.pause();
        if (this.lRQ != null) {
            this.lRQ.onPause();
        }
        try {
            if (this.lRU != null && this.lRU.isHeld()) {
                this.lRU.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.lRS != null) {
            this.lRS.cYx();
        }
    }

    public void stop() {
        if (!this.lRW) {
            stopPlayback();
            return;
        }
        if (this.elL != null && isPlaying()) {
            ai.a(this.alO, false);
        }
        this.lRP = false;
        if (isPlaying() && drG()) {
            n.dry().bz(this.elL, getCurrentPositionSync());
        }
        try {
            if (this.lRU != null && this.lRU.isHeld()) {
                this.lRU.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.lRQ != null) {
            this.lRQ.onStop();
        }
        this.ZY.stop();
        if (this.lRS != null && this.lRS.Oa(this.lRT)) {
            this.lRS = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.elL != null && isPlaying()) {
            ai.a(this.alO, false);
        }
        this.lRP = false;
        if (isPlaying() && drG()) {
            n.dry().bz(this.elL, getCurrentPositionSync());
        }
        try {
            if (this.lRU != null && this.lRU.isHeld()) {
                this.lRU.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.drM().PY(this.elL);
        if (this.lRQ != null) {
            this.lRQ.onStop();
        }
        this.ZY.stop();
        if (this.lRS != null && this.lRS.Oa(this.lRT)) {
            this.lRS = null;
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
        MessageManager.getInstance().registerListener(this.hZO);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.lSe != null) {
            this.lSe.onSurfaceDestroyed();
        }
        try {
            if (this.lRU != null && this.lRU.isHeld()) {
                this.lRU.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.hZO);
    }

    private String PW(String str) {
        if (!at.isEmpty(str) && g.dIK().dIL()) {
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

    public boolean drF() {
        return this.lRP;
    }

    public void h(long j, long j2, long j3) {
        if (this.lRS != null) {
            this.lRS.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean drG() {
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
        this.lRT = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.lRS != null) {
            return this.lRS;
        }
        if (!StringUtils.isNull(this.elL) && lRR != null) {
            this.lRS = lRR.ax(this.alS, this.elL, null);
        }
        return this.lRS;
    }

    private boolean drH() {
        return this == TbVideoViewSet.drM().PX(this.elL);
    }

    private boolean drI() {
        return getParent() != null;
    }

    public void drJ() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.lSe = null;
        this.lSa = null;
        this.lSc = null;
        this.lSd = null;
        this.lRZ = null;
        this.lSb = null;
        this.ZY.a((f.b) null);
        this.ZY.a((f.a) null);
        this.ZY.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.ZY;
    }

    public void setTryUseViewInSet(boolean z) {
        this.lRW = z;
    }

    @Deprecated
    public void drK() {
        if (this.lRQ != null) {
            this.lRQ.drC();
            this.lRQ.gv(getDuration());
            this.lRQ.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().sL(CyberPlayerManager.hasCacheFile(this.elL));
            getVideoMonitor().Em(-400);
        }
    }

    @Deprecated
    public void drL() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().sL(CyberPlayerManager.hasCacheFile(this.elL));
            getVideoMonitor().cYw();
            getVideoMonitor().El(-400);
        }
    }
}
