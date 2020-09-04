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
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    private static l ltL;
    private f Zq;
    private WeakReference<Context> akW;
    private String ala;
    private String dXz;
    private final CustomMessageListener hDR;
    private CyberPlayerManager.OnErrorListener jQz;
    private boolean khS;
    private boolean khT;
    private boolean ltI;
    private boolean ltJ;
    private b ltK;
    private i ltM;
    private String ltN;
    private PowerManager.WakeLock ltO;
    private boolean ltP;
    private boolean ltQ;
    private int ltR;
    private int ltS;
    private CyberPlayerManager.OnPreparedListener ltT;
    private CyberPlayerManager.OnCompletionListener ltU;
    private CyberPlayerManager.OnSeekCompleteListener ltV;
    private CyberPlayerManager.OnErrorListener ltW;
    private CyberPlayerManager.OnInfoListener ltX;
    private a ltY;
    private CyberPlayerManager.OnPreparedListener ltZ;
    private CyberPlayerManager.OnCompletionListener lua;
    private CyberPlayerManager.OnSeekCompleteListener lub;
    private CyberPlayerManager.OnInfoListener luc;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            ltL = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akW = null;
        this.ltP = false;
        this.ltQ = false;
        this.ltZ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int OF;
                if (TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.fP(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().De(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dku().a(TbCyberVideoView.this, TbCyberVideoView.this.dXz);
                    if (TbCyberVideoView.this.ltT != null) {
                        TbCyberVideoView.this.ltT.onPrepared();
                    }
                    if (TbCyberVideoView.this.ltI && (OF = n.dkg().OF(TbCyberVideoView.this.dXz)) > 0) {
                        TbCyberVideoView.this.seekTo(OF);
                    }
                    if (TbCyberVideoView.this.ltJ) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lua = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ltM != null) {
                    TbCyberVideoView.this.ltM.MI(TbCyberVideoView.this.ltN);
                    TbCyberVideoView.this.ltM = null;
                }
                n.dkg().remove(TbCyberVideoView.this.dXz);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ltK != null) {
                        TbCyberVideoView.this.ltK.onComplete();
                    }
                    TbCyberVideoView.this.ltJ = false;
                    if (TbCyberVideoView.this.ltU != null) {
                        TbCyberVideoView.this.ltU.onCompletion();
                    }
                }
            }
        };
        this.jQz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dko()) {
                    n.dkg().by(TbCyberVideoView.this.dXz, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dku().OI(TbCyberVideoView.this.dXz);
                if (TbCyberVideoView.this.ltW != null) {
                    TbCyberVideoView.this.ltW.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lub = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ltV != null) {
                    TbCyberVideoView.this.ltV.onSeekComplete();
                }
            }
        };
        this.luc = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ltX != null) {
                    TbCyberVideoView.this.ltX.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hDR = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ltM != null) {
                        TbCyberVideoView.this.ltM.MH(TbCyberVideoView.this.ltN);
                        TbCyberVideoView.this.ltM = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.akW = null;
        this.ltP = false;
        this.ltQ = false;
        this.ltZ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int OF;
                if (TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.fP(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().De(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dku().a(TbCyberVideoView.this, TbCyberVideoView.this.dXz);
                    if (TbCyberVideoView.this.ltT != null) {
                        TbCyberVideoView.this.ltT.onPrepared();
                    }
                    if (TbCyberVideoView.this.ltI && (OF = n.dkg().OF(TbCyberVideoView.this.dXz)) > 0) {
                        TbCyberVideoView.this.seekTo(OF);
                    }
                    if (TbCyberVideoView.this.ltJ) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lua = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ltM != null) {
                    TbCyberVideoView.this.ltM.MI(TbCyberVideoView.this.ltN);
                    TbCyberVideoView.this.ltM = null;
                }
                n.dkg().remove(TbCyberVideoView.this.dXz);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ltK != null) {
                        TbCyberVideoView.this.ltK.onComplete();
                    }
                    TbCyberVideoView.this.ltJ = false;
                    if (TbCyberVideoView.this.ltU != null) {
                        TbCyberVideoView.this.ltU.onCompletion();
                    }
                }
            }
        };
        this.jQz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dko()) {
                    n.dkg().by(TbCyberVideoView.this.dXz, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dku().OI(TbCyberVideoView.this.dXz);
                if (TbCyberVideoView.this.ltW != null) {
                    TbCyberVideoView.this.ltW.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lub = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ltV != null) {
                    TbCyberVideoView.this.ltV.onSeekComplete();
                }
            }
        };
        this.luc = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ltX != null) {
                    TbCyberVideoView.this.ltX.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hDR = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ltM != null) {
                        TbCyberVideoView.this.ltM.MH(TbCyberVideoView.this.ltN);
                        TbCyberVideoView.this.ltM = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.akW = null;
        this.ltP = false;
        this.ltQ = false;
        this.ltZ = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int OF;
                if (TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.fP(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().De(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.dku().a(TbCyberVideoView.this, TbCyberVideoView.this.dXz);
                    if (TbCyberVideoView.this.ltT != null) {
                        TbCyberVideoView.this.ltT.onPrepared();
                    }
                    if (TbCyberVideoView.this.ltI && (OF = n.dkg().OF(TbCyberVideoView.this.dXz)) > 0) {
                        TbCyberVideoView.this.seekTo(OF);
                    }
                    if (TbCyberVideoView.this.ltJ) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.lua = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ltM != null) {
                    TbCyberVideoView.this.ltM.MI(TbCyberVideoView.this.ltN);
                    TbCyberVideoView.this.ltM = null;
                }
                n.dkg().remove(TbCyberVideoView.this.dXz);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ltK != null) {
                        TbCyberVideoView.this.ltK.onComplete();
                    }
                    TbCyberVideoView.this.ltJ = false;
                    if (TbCyberVideoView.this.ltU != null) {
                        TbCyberVideoView.this.ltU.onCompletion();
                    }
                }
            }
        };
        this.jQz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.dko()) {
                    n.dkg().by(TbCyberVideoView.this.dXz, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.dku().OI(TbCyberVideoView.this.dXz);
                if (TbCyberVideoView.this.ltW != null) {
                    TbCyberVideoView.this.ltW.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.lub = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ltV != null) {
                    TbCyberVideoView.this.ltV.onSeekComplete();
                }
            }
        };
        this.luc = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ltX != null) {
                    TbCyberVideoView.this.ltX.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ltK != null) {
                    TbCyberVideoView.this.ltK.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hDR = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ltM != null) {
                        TbCyberVideoView.this.ltM.MH(TbCyberVideoView.this.ltN);
                        TbCyberVideoView.this.ltM = null;
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
                this.ltO = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.ltO.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.akW = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.ltZ);
        super.setOnCompletionListener(this.lua);
        super.setOnErrorListener(this.jQz);
        super.setOnSeekCompleteListener(this.lub);
        super.setOnInfoListener(this.luc);
        this.ltK = new b();
        this.Zq = new f();
        ap.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void y(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.dki()) {
            if (!pcdnConfigData.x(uri)) {
                this.ltS = 2;
                return;
            } else if (c.dkz() <= 0) {
                this.ltS = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.dkj() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.dkz()));
                this.khS = true;
                this.khT = pcdnConfigData.dkj();
                this.ltS = 1;
                return;
            }
        }
        this.ltS = 0;
    }

    public int getPcdnState() {
        return this.ltS;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.ltP = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ah.a(this.akW, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.ltP = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.ltK == null) {
            this.ltK = new b();
        }
        this.ltK.setVideoStatsData(oVar);
        if (oVar != null) {
            this.ltN = oVar.mLocate;
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
        if (this.ltK == null) {
            this.ltK = new b();
        }
        this.ltK.setThreadData(bwVar);
    }

    public void setPlayMode(String str) {
        if (this.ltK != null) {
            this.ltK.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.ltK = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.ltT = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.ltU = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.ltW = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.ltV = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.ltX = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.ltY = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.ltI = z;
    }

    public String getOriginUrl() {
        return this.dXz;
    }

    public void setVideoDuration(int i) {
        this.ltR = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!at.isEmpty(str)) {
            this.ala = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!at.isEmpty(str)) {
            dkm();
            this.dXz = str;
            String OG = OG(str);
            if (ltL != null) {
                this.ltM = ltL.av(this.ala, this.dXz, null);
                if (this.ltM != null) {
                    this.ltM.rW(CyberPlayerManager.hasCacheFile(OG));
                }
            }
            this.Zq.setPlayer(this);
            if (this.ltK != null) {
                this.ltK.dkk();
            }
            y(Uri.parse(OG));
            if (this.ltM != null) {
                this.ltM.cRh();
            }
            String host = Uri.parse(this.dXz).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.ltR < 900)) ? "1" : "0");
            super.setVideoPath(OG);
        }
    }

    private void dkm() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.ltQ = true;
            if (!dkq()) {
                aVar.dkv();
            }
            if (!dkp()) {
                aVar.dkw();
                this.ltJ = true;
                setVideoPath(this.dXz, this.ala);
                return;
            }
        } else {
            this.ltQ = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.ltP) {
            ah.a(this.akW, true);
            setVolume(1.0f, 1.0f);
        }
        this.ltJ = true;
        super.start();
        if (this.ltK != null) {
            this.ltK.onStart();
        }
        this.Zq.start();
        try {
            if (this.ltO != null && !this.ltO.isHeld()) {
                this.ltO.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().Dg(-400);
            getVideoMonitor().ai(this.khS, this.khT);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.ltJ) {
            a(aVar);
            return;
        }
        this.ltJ = true;
        if (aVar != null) {
            this.ltQ = true;
            if (!dkq()) {
                aVar.dkv();
            }
        } else {
            this.ltQ = false;
        }
        setVideoPath(this.dXz, this.ala);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ah.a(this.akW, false);
        if (isPlaying() && dko()) {
            n.dkg().by(this.dXz, getCurrentPositionSync());
        }
        super.pause();
        if (this.ltK != null) {
            this.ltK.onPause();
        }
        try {
            if (this.ltO != null && this.ltO.isHeld()) {
                this.ltO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ltM != null) {
            this.ltM.cRi();
        }
    }

    public void stop() {
        if (!this.ltQ) {
            stopPlayback();
            return;
        }
        if (this.dXz != null && isPlaying()) {
            ah.a(this.akW, false);
        }
        this.ltJ = false;
        if (isPlaying() && dko()) {
            n.dkg().by(this.dXz, getCurrentPositionSync());
        }
        try {
            if (this.ltO != null && this.ltO.isHeld()) {
                this.ltO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.ltK != null) {
            this.ltK.onStop();
        }
        this.Zq.stop();
        if (this.ltM != null && this.ltM.MJ(this.ltN)) {
            this.ltM = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.dXz != null && isPlaying()) {
            ah.a(this.akW, false);
        }
        this.ltJ = false;
        if (isPlaying() && dko()) {
            n.dkg().by(this.dXz, getCurrentPositionSync());
        }
        try {
            if (this.ltO != null && this.ltO.isHeld()) {
                this.ltO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.dku().OI(this.dXz);
        if (this.ltK != null) {
            this.ltK.onStop();
        }
        this.Zq.stop();
        if (this.ltM != null && this.ltM.MJ(this.ltN)) {
            this.ltM = null;
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
        MessageManager.getInstance().registerListener(this.hDR);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ltY != null) {
            this.ltY.onSurfaceDestroyed();
        }
        try {
            if (this.ltO != null && this.ltO.isHeld()) {
                this.ltO.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.hDR);
    }

    private String OG(String str) {
        if (!at.isEmpty(str) && g.dBe().dBf()) {
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

    public boolean dkn() {
        return this.ltJ;
    }

    public void h(long j, long j2, long j3) {
        if (this.ltM != null) {
            this.ltM.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dko() {
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
        this.ltN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.ltM != null) {
            return this.ltM;
        }
        if (!StringUtils.isNull(this.dXz) && ltL != null) {
            this.ltM = ltL.av(this.ala, this.dXz, null);
        }
        return this.ltM;
    }

    private boolean dkp() {
        return this == TbVideoViewSet.dku().OH(this.dXz);
    }

    private boolean dkq() {
        return getParent() != null;
    }

    public void dkr() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.ltY = null;
        this.ltU = null;
        this.ltW = null;
        this.ltX = null;
        this.ltT = null;
        this.ltV = null;
        this.Zq.a((f.b) null);
        this.Zq.a((f.a) null);
        this.Zq.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.Zq;
    }

    public void setTryUseViewInSet(boolean z) {
        this.ltQ = z;
    }

    @Deprecated
    public void dks() {
        if (this.ltK != null) {
            this.ltK.dkk();
            this.ltK.fP(getDuration());
            this.ltK.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().rW(CyberPlayerManager.hasCacheFile(this.dXz));
            getVideoMonitor().Df(-400);
        }
    }

    @Deprecated
    public void dkt() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().rW(CyberPlayerManager.hasCacheFile(this.dXz));
            getVideoMonitor().cRh();
            getVideoMonitor().De(-400);
        }
    }
}
