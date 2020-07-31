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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.k.i;
import com.baidu.tieba.k.l;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video.g;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    private static l lde;
    private f YI;
    private WeakReference<Context> ajF;
    private String ajJ;
    private String fZQ;
    private final CustomMessageListener hqU;
    private CyberPlayerManager.OnErrorListener jAX;
    private boolean jSo;
    private boolean jSp;
    private boolean ldb;
    private boolean ldc;
    private b ldd;
    private i ldf;
    private String ldg;
    private PowerManager.WakeLock ldh;
    private boolean ldi;
    private boolean ldj;
    private int ldk;
    private int ldl;
    private CyberPlayerManager.OnPreparedListener ldm;
    private CyberPlayerManager.OnCompletionListener ldn;
    private CyberPlayerManager.OnSeekCompleteListener ldo;
    private CyberPlayerManager.OnErrorListener ldp;
    private CyberPlayerManager.OnInfoListener ldq;
    private a ldr;
    private CyberPlayerManager.OnPreparedListener lds;
    private CyberPlayerManager.OnCompletionListener ldt;
    private CyberPlayerManager.OnSeekCompleteListener ldu;
    private CyberPlayerManager.OnInfoListener ldv;

    /* loaded from: classes.dex */
    public interface a {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            lde = (l) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajF = null;
        this.ldi = false;
        this.ldj = false;
        this.lds = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int LL;
                if (TbCyberVideoView.this.ldd != null) {
                    TbCyberVideoView.this.ldd.fB(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().AL(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cZn().a(TbCyberVideoView.this, TbCyberVideoView.this.fZQ);
                    if (TbCyberVideoView.this.ldm != null) {
                        TbCyberVideoView.this.ldm.onPrepared();
                    }
                    if (TbCyberVideoView.this.ldb && (LL = n.cZa().LL(TbCyberVideoView.this.fZQ)) > 0) {
                        TbCyberVideoView.this.seekTo(LL);
                    }
                    if (TbCyberVideoView.this.ldc) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.ldt = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ldf != null) {
                    TbCyberVideoView.this.ldf.JP(TbCyberVideoView.this.ldg);
                    TbCyberVideoView.this.ldf = null;
                }
                n.cZa().remove(TbCyberVideoView.this.fZQ);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ldd != null) {
                        TbCyberVideoView.this.ldd.onComplete();
                    }
                    TbCyberVideoView.this.ldc = false;
                    if (TbCyberVideoView.this.ldn != null) {
                        TbCyberVideoView.this.ldn.onCompletion();
                    }
                }
            }
        };
        this.jAX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cZh()) {
                    n.cZa().bt(TbCyberVideoView.this.fZQ, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cZn().LO(TbCyberVideoView.this.fZQ);
                if (TbCyberVideoView.this.ldp != null) {
                    TbCyberVideoView.this.ldp.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.ldu = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ldo != null) {
                    TbCyberVideoView.this.ldo.onSeekComplete();
                }
            }
        };
        this.ldv = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ldq != null) {
                    TbCyberVideoView.this.ldq.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ldd != null) {
                    TbCyberVideoView.this.ldd.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hqU = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ldf != null) {
                        TbCyberVideoView.this.ldf.JO(TbCyberVideoView.this.ldg);
                        TbCyberVideoView.this.ldf = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.ajF = null;
        this.ldi = false;
        this.ldj = false;
        this.lds = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int LL;
                if (TbCyberVideoView.this.ldd != null) {
                    TbCyberVideoView.this.ldd.fB(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().AL(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cZn().a(TbCyberVideoView.this, TbCyberVideoView.this.fZQ);
                    if (TbCyberVideoView.this.ldm != null) {
                        TbCyberVideoView.this.ldm.onPrepared();
                    }
                    if (TbCyberVideoView.this.ldb && (LL = n.cZa().LL(TbCyberVideoView.this.fZQ)) > 0) {
                        TbCyberVideoView.this.seekTo(LL);
                    }
                    if (TbCyberVideoView.this.ldc) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.ldt = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ldf != null) {
                    TbCyberVideoView.this.ldf.JP(TbCyberVideoView.this.ldg);
                    TbCyberVideoView.this.ldf = null;
                }
                n.cZa().remove(TbCyberVideoView.this.fZQ);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ldd != null) {
                        TbCyberVideoView.this.ldd.onComplete();
                    }
                    TbCyberVideoView.this.ldc = false;
                    if (TbCyberVideoView.this.ldn != null) {
                        TbCyberVideoView.this.ldn.onCompletion();
                    }
                }
            }
        };
        this.jAX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cZh()) {
                    n.cZa().bt(TbCyberVideoView.this.fZQ, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cZn().LO(TbCyberVideoView.this.fZQ);
                if (TbCyberVideoView.this.ldp != null) {
                    TbCyberVideoView.this.ldp.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.ldu = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ldo != null) {
                    TbCyberVideoView.this.ldo.onSeekComplete();
                }
            }
        };
        this.ldv = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ldq != null) {
                    TbCyberVideoView.this.ldq.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ldd != null) {
                    TbCyberVideoView.this.ldd.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hqU = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ldf != null) {
                        TbCyberVideoView.this.ldf.JO(TbCyberVideoView.this.ldg);
                        TbCyberVideoView.this.ldf = null;
                    }
                }
            }
        };
        init(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.ajF = null;
        this.ldi = false;
        this.ldj = false;
        this.lds = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                int LL;
                if (TbCyberVideoView.this.ldd != null) {
                    TbCyberVideoView.this.ldd.fB(TbCyberVideoView.this.getDuration());
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null) {
                    TbCyberVideoView.this.getVideoMonitor().AL(-400);
                }
                if (ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    TbVideoViewSet.cZn().a(TbCyberVideoView.this, TbCyberVideoView.this.fZQ);
                    if (TbCyberVideoView.this.ldm != null) {
                        TbCyberVideoView.this.ldm.onPrepared();
                    }
                    if (TbCyberVideoView.this.ldb && (LL = n.cZa().LL(TbCyberVideoView.this.fZQ)) > 0) {
                        TbCyberVideoView.this.seekTo(LL);
                    }
                    if (TbCyberVideoView.this.ldc) {
                        TbCyberVideoView.this.start();
                    }
                }
            }
        };
        this.ldt = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (TbCyberVideoView.this.ldf != null) {
                    TbCyberVideoView.this.ldf.JP(TbCyberVideoView.this.ldg);
                    TbCyberVideoView.this.ldf = null;
                }
                n.cZa().remove(TbCyberVideoView.this.fZQ);
                if (!TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                    if (TbCyberVideoView.this.ldd != null) {
                        TbCyberVideoView.this.ldd.onComplete();
                    }
                    TbCyberVideoView.this.ldc = false;
                    if (TbCyberVideoView.this.ldn != null) {
                        TbCyberVideoView.this.ldn.onCompletion();
                    }
                }
            }
        };
        this.jAX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.cZh()) {
                    n.cZa().bt(TbCyberVideoView.this.fZQ, TbCyberVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cZn().LO(TbCyberVideoView.this.fZQ);
                if (TbCyberVideoView.this.ldp != null) {
                    TbCyberVideoView.this.ldp.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
        };
        this.ldu = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (TbCyberVideoView.this.ldo != null) {
                    TbCyberVideoView.this.ldo.onSeekComplete();
                }
            }
        };
        this.ldv = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (TbCyberVideoView.this.ldq != null) {
                    TbCyberVideoView.this.ldq.onInfo(i2, i3, obj);
                }
                if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        TbCyberVideoView.this.getVideoMonitor().t(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException e) {
                    }
                }
                if (i2 == 904 && TbCyberVideoView.this.ldd != null) {
                    TbCyberVideoView.this.ldd.b(TbCyberVideoView.this);
                    return true;
                }
                return true;
            }
        };
        this.hqU = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbCyberVideoView.this.stop();
                    if (TbCyberVideoView.this.ldf != null) {
                        TbCyberVideoView.this.ldf.JO(TbCyberVideoView.this.ldg);
                        TbCyberVideoView.this.ldf = null;
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
                this.ldh = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.ldh.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.ajF = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.lds);
        super.setOnCompletionListener(this.ldt);
        super.setOnErrorListener(this.jAX);
        super.setOnSeekCompleteListener(this.ldu);
        super.setOnInfoListener(this.ldv);
        this.ldd = new b();
        this.YI = new f();
        ao.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void y(Uri uri) {
        com.baidu.tieba.play.cyberPlayer.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.cZc()) {
            if (!pcdnConfigData.x(uri)) {
                this.ldl = 2;
                return;
            } else if (c.cZs() <= 0) {
                this.ldl = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.cZd() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.cZs()));
                this.jSo = true;
                this.jSp = pcdnConfigData.cZd();
                this.ldl = 1;
                return;
            }
        }
        this.ldl = 0;
    }

    public int getPcdnState() {
        return this.ldl;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.ldi = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        ag.a(this.ajF, !z);
    }

    public void setVolume(float f, float f2) {
        if (getCyberPlayer() != null) {
            this.ldi = f == 0.0f && f2 == 0.0f;
            getCyberPlayer().setVolume(f, f2);
        }
    }

    public void setVideoStatData(o oVar) {
        if (this.ldd == null) {
            this.ldd = new b();
        }
        this.ldd.setVideoStatsData(oVar);
        if (oVar != null) {
            this.ldg = oVar.mLocate;
        }
    }

    public void setThreadDataForStatistic(bv bvVar) {
        if (this.ldd == null) {
            this.ldd = new b();
        }
        this.ldd.setThreadData(bvVar);
    }

    public void setPlayMode(String str) {
        if (this.ldd != null) {
            this.ldd.setPlayMode(str);
        }
    }

    public void setNoBussinessStats() {
        this.ldd = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.ldm = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.ldn = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.ldp = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.ldo = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.ldq = onInfoListener;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.ldr = aVar;
    }

    public void setContinuePlayEnable(boolean z) {
        this.ldb = z;
    }

    public String getOriginUrl() {
        return this.fZQ;
    }

    public void setVideoDuration(int i) {
        this.ldk = i;
    }

    public void setVideoPath(String str, String str2) {
        if (!as.isEmpty(str)) {
            this.ajJ = str2;
            setVideoPath(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (!as.isEmpty(str)) {
            this.fZQ = str;
            String LM = LM(str);
            if (lde != null) {
                this.ldf = lde.av(this.ajJ, this.fZQ, null);
                if (this.ldf != null) {
                    this.ldf.ro(CyberPlayerManager.hasCacheFile(LM));
                }
            }
            this.YI.setPlayer(this);
            if (this.ldd != null) {
                this.ldd.cZe();
            }
            y(Uri.parse(LM));
            if (this.ldf != null) {
                this.ldf.cGr();
            }
            String host = Uri.parse(this.fZQ).getHost();
            setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.ldk < 900)) ? "1" : "0");
            super.setVideoPath(LM);
        }
    }

    public void a(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.ldj = true;
            if (!cZj()) {
                aVar.cZo();
            }
            if (!cZi()) {
                aVar.cZp();
                this.ldc = true;
                setVideoPath(this.fZQ, this.ajJ);
                return;
            }
        } else {
            this.ldj = false;
        }
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.ldi) {
            ag.a(this.ajF, true);
            setVolume(1.0f, 1.0f);
        }
        this.ldc = true;
        super.start();
        if (this.ldd != null) {
            this.ldd.onStart();
        }
        this.YI.start();
        try {
            if (this.ldh != null && !this.ldh.isHeld()) {
                this.ldh.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().AN(-400);
            getVideoMonitor().ae(this.jSo, this.jSp);
        }
    }

    public void b(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.ldc) {
            a(aVar);
            return;
        }
        this.ldc = true;
        if (aVar != null) {
            this.ldj = true;
            if (!cZj()) {
                aVar.cZo();
            }
        } else {
            this.ldj = false;
        }
        setVideoPath(this.fZQ, this.ajJ);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        ag.a(this.ajF, false);
        if (isPlaying() && cZh()) {
            n.cZa().bt(this.fZQ, getCurrentPositionSync());
        }
        super.pause();
        if (this.ldd != null) {
            this.ldd.onPause();
        }
        try {
            if (this.ldh != null && this.ldh.isHeld()) {
                this.ldh.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ldf != null) {
            this.ldf.cGs();
        }
    }

    public void stop() {
        if (!this.ldj) {
            stopPlayback();
            return;
        }
        if (this.fZQ != null && isPlaying()) {
            ag.a(this.ajF, false);
        }
        this.ldc = false;
        if (isPlaying() && cZh()) {
            n.cZa().bt(this.fZQ, getCurrentPositionSync());
        }
        try {
            if (this.ldh != null && this.ldh.isHeld()) {
                this.ldh.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.pause();
        if (this.ldd != null) {
            this.ldd.onStop();
        }
        this.YI.stop();
        if (this.ldf != null && this.ldf.JQ(this.ldg)) {
            this.ldf = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.fZQ != null && isPlaying()) {
            ag.a(this.ajF, false);
        }
        this.ldc = false;
        if (isPlaying() && cZh()) {
            n.cZa().bt(this.fZQ, getCurrentPositionSync());
        }
        try {
            if (this.ldh != null && this.ldh.isHeld()) {
                this.ldh.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        super.stopPlayback();
        TbVideoViewSet.cZn().LO(this.fZQ);
        if (this.ldd != null) {
            this.ldd.onStop();
        }
        this.YI.stop();
        if (this.ldf != null && this.ldf.JQ(this.ldg)) {
            this.ldf = null;
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
        MessageManager.getInstance().registerListener(this.hqU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ldr != null) {
            this.ldr.onSurfaceDestroyed();
        }
        try {
            if (this.ldh != null && this.ldh.isHeld()) {
                this.ldh.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().unRegisterListener(this.hqU);
    }

    private String LM(String str) {
        if (!as.isEmpty(str) && g.dpz().dpA()) {
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

    public boolean cZg() {
        return this.ldc;
    }

    public void h(long j, long j2, long j3) {
        if (this.ldf != null) {
            this.ldf.h(j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cZh() {
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
        this.ldg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getVideoMonitor() {
        if (this.ldf != null) {
            return this.ldf;
        }
        if (!StringUtils.isNull(this.fZQ) && lde != null) {
            this.ldf = lde.av(this.ajJ, this.fZQ, null);
        }
        return this.ldf;
    }

    private boolean cZi() {
        return this == TbVideoViewSet.cZn().LN(this.fZQ);
    }

    private boolean cZj() {
        return getParent() != null;
    }

    public void cZk() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void clearCallbacks() {
        this.ldr = null;
        this.ldn = null;
        this.ldp = null;
        this.ldq = null;
        this.ldm = null;
        this.ldo = null;
        this.YI.a((f.b) null);
        this.YI.a((f.a) null);
        this.YI.a((f.c) null);
    }

    public f getMediaProgressObserver() {
        return this.YI;
    }

    public void setTryUseViewInSet(boolean z) {
        this.ldj = z;
    }

    @Deprecated
    public void cZl() {
        if (this.ldd != null) {
            this.ldd.cZe();
            this.ldd.fB(getDuration());
            this.ldd.b(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().ro(CyberPlayerManager.hasCacheFile(this.fZQ));
            getVideoMonitor().AM(-400);
        }
    }

    @Deprecated
    public void cZm() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().ro(CyberPlayerManager.hasCacheFile(this.fZQ));
            getVideoMonitor().cGr();
            getVideoMonitor().AL(-400);
        }
    }
}
