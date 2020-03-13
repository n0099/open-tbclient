package com.baidu.tieba.play;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.network.http.a.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.switchs.VideoPlayerReuseSwitch;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a, com.baidu.tieba.play.b.c {
    private static h efm;
    private static com.baidu.tieba.k.l efn;
    private static int jvt = 0;
    private static int jvu = 1;
    private static int jvv = 2;
    private static int jvw = 1;
    private static int jvx = 0;
    private WeakReference<Context> Pf;
    private String Pj;
    private TextureView.SurfaceTextureListener aXQ;
    private g.b dMt;
    private b dMx;
    private final CustomMessageListener dVD;
    private g.a dVp;
    private g.f dVq;
    private g.c dVr;
    private g.e dVs;
    private g.InterfaceC0590g dVt;
    private g.i dVu;
    private g.d dVv;
    private g.h dVw;
    private int ean;
    private boolean efe;
    private g.f efo;
    private g.a efp;
    private g.InterfaceC0590g efs;
    private RenderView juQ;
    private String juR;
    private g juS;
    private g.e juT;
    private c juU;
    private com.baidu.tieba.k.i juV;
    private com.baidu.tieba.k.e juW;
    private String juX;
    private boolean juY;
    private d juZ;
    private a juw;
    private int jvA;
    private int jvB;
    private int jvC;
    private int jvD;
    private boolean jvE;
    private Runnable jvF;
    private Runnable jvG;
    public boolean jvH;
    private Runnable jvI;
    private com.baidu.tieba.k.k jva;
    private boolean jvb;
    private int jvc;
    private int jvd;
    private boolean jve;
    private SurfaceTexture jvf;
    private boolean jvg;
    private com.baidu.tieba.play.b.a jvh;
    private q jvi;
    private com.baidu.tieba.play.b.f jvj;
    private String jvk;
    private String jvl;
    private String jvm;
    private long jvn;
    private boolean jvo;
    private boolean jvp;
    private boolean jvq;
    private long jvr;
    private long jvs;
    private int jvy;
    private int jvz;
    private int mBitRate;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cyu();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onStart();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            efm = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            efn = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.jvg = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.juY = false;
        this.jvb = false;
        this.jvc = 0;
        this.efe = false;
        this.jvd = -1;
        this.jve = false;
        this.jvf = null;
        this.jvg = true;
        this.jvq = false;
        this.jvr = 0L;
        this.jvs = 0L;
        this.jvy = jvx;
        this.jvz = 0;
        this.mBitRate = 0;
        this.jvA = -1;
        this.jvB = 0;
        this.jvC = 0;
        this.jvD = 0;
        this.ean = 0;
        this.jvE = false;
        this.Pf = null;
        this.jvF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juS != null && QuickVideoView.this.juY) {
                    QuickVideoView.this.b(QuickVideoView.this.juS, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvG = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.oR(false);
                }
            }
        };
        this.jvH = false;
        this.aXQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jvE) {
                    QuickVideoView.this.jvE = false;
                    if (QuickVideoView.this.juS != null) {
                        QuickVideoView.this.juS.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jvb || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juS != null) {
                        if (QuickVideoView.this.cyT()) {
                            QuickVideoView.this.juS.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jve) {
                            QuickVideoView.this.juS.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jvd);
                            if (QuickVideoView.this.juw != null) {
                                QuickVideoView.this.juw.cyu();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juV.cgH();
                            }
                        }
                    }
                } else if (cyW()) {
                    if (QuickVideoView.this.juS != null) {
                        QuickVideoView.this.cyK();
                        QuickVideoView.this.jvb = true;
                        QuickVideoView.this.juS.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juV.cgG();
                    }
                }
                QuickVideoView.this.jvf = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvE) {
                    QuickVideoView.this.cyM();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juS != null) {
                        if (QuickVideoView.this.juS.isPlaying() && QuickVideoView.this.cyR()) {
                            x.czt().bl(QuickVideoView.this.jvm, QuickVideoView.this.juS.getCurrentPosition());
                            if (QuickVideoView.this.jvq) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jvq) {
                            QuickVideoView.this.juS.release();
                        }
                    }
                    if (QuickVideoView.this.jvb) {
                        if (QuickVideoView.this.juZ != null && !QuickVideoView.this.jvq) {
                            QuickVideoView.this.juZ.GZ(QuickVideoView.this.jvl);
                        }
                        if (QuickVideoView.this.dMx != null) {
                            QuickVideoView.this.dMx.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jvf = null;
                    if (QuickVideoView.this.juV != null && QuickVideoView.this.juV.Fg(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juV = null;
                    }
                    if (!QuickVideoView.this.jvq) {
                        QuickVideoView.this.jvb = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyW() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                            if (runningTaskInfo.topActivity.getClassName().equals(((Activity) QuickVideoView.this.mContext).getClass().getName())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.efo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int He;
                QuickVideoView.this.cyM();
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.onPrepared();
                }
                if (QuickVideoView.this.juV != null && QuickVideoView.this.juS != null) {
                    QuickVideoView.this.juV.yh(QuickVideoView.this.juS.getPlayerType());
                }
                if (QuickVideoView.this.jvq) {
                    TbVideoViewSet.czw().a(QuickVideoView.this, QuickVideoView.this.jvl);
                }
                if (QuickVideoView.this.dVq != null) {
                    QuickVideoView.this.jva.cgX();
                    QuickVideoView.this.dVq.onPrepared(gVar);
                }
                if (QuickVideoView.this.juZ != null) {
                    long j = 0;
                    if (QuickVideoView.this.juS != null) {
                        j = QuickVideoView.this.juS.getDuration();
                    }
                    QuickVideoView.this.juZ.ew(j);
                    QuickVideoView.this.cyL();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juZ.cyE();
                        QuickVideoView.this.cyQ();
                    }
                }
                if (QuickVideoView.this.jvp && (He = x.czt().He(QuickVideoView.this.jvm)) > 0 && QuickVideoView.this.juS != null) {
                    if (QuickVideoView.this.juS.isPlayerReuse()) {
                        if (QuickVideoView.this.juS.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(He);
                        }
                    } else {
                        QuickVideoView.this.As(He);
                    }
                }
                if (QuickVideoView.this.juY) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juQ != null && gVar != null) {
                    QuickVideoView.this.juQ.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jvc);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juR) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juR);
                }
                if (QuickVideoView.this.jvh != null && QuickVideoView.this.jvh.czO()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efp = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.Ff(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juV = null;
                }
                if (!QuickVideoView.this.efe || QuickVideoView.this.juZ == null) {
                    if (QuickVideoView.this.juZ != null) {
                        QuickVideoView.this.juZ.onCompletion();
                    }
                    QuickVideoView.this.juY = false;
                    x.czt().remove(QuickVideoView.this.jvm);
                    if (QuickVideoView.this.dVp != null) {
                        QuickVideoView.this.dVp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juX = null;
                QuickVideoView.this.jvn = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juZ.cyx());
                QuickVideoView.this.start();
            }
        };
        this.dVr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.cyM();
                if (QuickVideoView.this.juZ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyR()) {
                    QuickVideoView.this.jvo = true;
                    x.czt().bl(QuickVideoView.this.jvm, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czw().Hg(QuickVideoView.this.jvl);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juV != null) {
                        QuickVideoView.this.juX = QuickVideoView.this.juV.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jvn, QuickVideoView.this.aq(QuickVideoView.this.juV.cgL(), i3 + "", QuickVideoView.this.juV.cgM()));
                        QuickVideoView.this.juV = null;
                    }
                    QuickVideoView.this.jvn = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMt == null || QuickVideoView.this.dMt.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.efs = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jvo) {
                    QuickVideoView.this.jvo = false;
                    return;
                }
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.czf();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juZ != null && z) {
                    QuickVideoView.this.juZ.onSeekComplete();
                }
                if (QuickVideoView.this.dVt != null) {
                    QuickVideoView.this.dVt.b(gVar);
                }
            }
        };
        this.dVs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.juT != null) {
                    QuickVideoView.this.juT.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jvc = i2;
                    if (QuickVideoView.this.juQ != null && gVar != null) {
                        QuickVideoView.this.juQ.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jvc);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jva.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.a(i, i2, QuickVideoView.this.juV);
                    return true;
                }
                return true;
            }
        };
        this.dVu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.m(i, i2, str);
                }
            }
        };
        this.dVv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.Fh(str);
                }
            }
        };
        this.dVw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jvn = j;
                }
            }
        };
        this.jvI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juZ != null && QuickVideoView.this.juZ.cyA() && QuickVideoView.this.juZ.cyB() && QuickVideoView.this.juZ.cyC() && QuickVideoView.this.juS != null) {
                    int aWH = QuickVideoView.this.juS.aWH();
                    int currentPosition = QuickVideoView.this.juS.getCurrentPosition();
                    int duration = QuickVideoView.this.juS.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvr;
                    boolean z = currentPosition + aWH < duration;
                    if (aWH < QuickVideoView.this.juZ.cyD() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvr = currentTimeMillis;
                        QuickVideoView.this.juZ.Ap(0);
                    }
                    if (QuickVideoView.this.cyP() && currentPosition == QuickVideoView.this.jvs && j > 500) {
                        QuickVideoView.this.jvr = currentTimeMillis;
                        QuickVideoView.this.juZ.Ap(0);
                    }
                    QuickVideoView.this.jvs = currentPosition;
                    if (QuickVideoView.this.jvy == QuickVideoView.jvw) {
                        QuickVideoView.this.cyQ();
                    }
                }
            }
        };
        this.dVD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juZ != null) {
                        QuickVideoView.this.juZ.wK(QuickVideoView.this.jvl);
                    }
                    if (QuickVideoView.this.juV != null) {
                        QuickVideoView.this.juV.Fe(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juV = null;
                    }
                    QuickVideoView.this.cyM();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.juY = false;
        this.jvb = false;
        this.jvc = 0;
        this.efe = false;
        this.jvd = -1;
        this.jve = false;
        this.jvf = null;
        this.jvg = true;
        this.jvq = false;
        this.jvr = 0L;
        this.jvs = 0L;
        this.jvy = jvx;
        this.jvz = 0;
        this.mBitRate = 0;
        this.jvA = -1;
        this.jvB = 0;
        this.jvC = 0;
        this.jvD = 0;
        this.ean = 0;
        this.jvE = false;
        this.Pf = null;
        this.jvF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juS != null && QuickVideoView.this.juY) {
                    QuickVideoView.this.b(QuickVideoView.this.juS, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvG = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.oR(false);
                }
            }
        };
        this.jvH = false;
        this.aXQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jvE) {
                    QuickVideoView.this.jvE = false;
                    if (QuickVideoView.this.juS != null) {
                        QuickVideoView.this.juS.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jvb || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juS != null) {
                        if (QuickVideoView.this.cyT()) {
                            QuickVideoView.this.juS.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jve) {
                            QuickVideoView.this.juS.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jvd);
                            if (QuickVideoView.this.juw != null) {
                                QuickVideoView.this.juw.cyu();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juV.cgH();
                            }
                        }
                    }
                } else if (cyW()) {
                    if (QuickVideoView.this.juS != null) {
                        QuickVideoView.this.cyK();
                        QuickVideoView.this.jvb = true;
                        QuickVideoView.this.juS.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juV.cgG();
                    }
                }
                QuickVideoView.this.jvf = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvE) {
                    QuickVideoView.this.cyM();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juS != null) {
                        if (QuickVideoView.this.juS.isPlaying() && QuickVideoView.this.cyR()) {
                            x.czt().bl(QuickVideoView.this.jvm, QuickVideoView.this.juS.getCurrentPosition());
                            if (QuickVideoView.this.jvq) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jvq) {
                            QuickVideoView.this.juS.release();
                        }
                    }
                    if (QuickVideoView.this.jvb) {
                        if (QuickVideoView.this.juZ != null && !QuickVideoView.this.jvq) {
                            QuickVideoView.this.juZ.GZ(QuickVideoView.this.jvl);
                        }
                        if (QuickVideoView.this.dMx != null) {
                            QuickVideoView.this.dMx.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jvf = null;
                    if (QuickVideoView.this.juV != null && QuickVideoView.this.juV.Fg(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juV = null;
                    }
                    if (!QuickVideoView.this.jvq) {
                        QuickVideoView.this.jvb = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyW() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                            if (runningTaskInfo.topActivity.getClassName().equals(((Activity) QuickVideoView.this.mContext).getClass().getName())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.efo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int He;
                QuickVideoView.this.cyM();
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.onPrepared();
                }
                if (QuickVideoView.this.juV != null && QuickVideoView.this.juS != null) {
                    QuickVideoView.this.juV.yh(QuickVideoView.this.juS.getPlayerType());
                }
                if (QuickVideoView.this.jvq) {
                    TbVideoViewSet.czw().a(QuickVideoView.this, QuickVideoView.this.jvl);
                }
                if (QuickVideoView.this.dVq != null) {
                    QuickVideoView.this.jva.cgX();
                    QuickVideoView.this.dVq.onPrepared(gVar);
                }
                if (QuickVideoView.this.juZ != null) {
                    long j = 0;
                    if (QuickVideoView.this.juS != null) {
                        j = QuickVideoView.this.juS.getDuration();
                    }
                    QuickVideoView.this.juZ.ew(j);
                    QuickVideoView.this.cyL();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juZ.cyE();
                        QuickVideoView.this.cyQ();
                    }
                }
                if (QuickVideoView.this.jvp && (He = x.czt().He(QuickVideoView.this.jvm)) > 0 && QuickVideoView.this.juS != null) {
                    if (QuickVideoView.this.juS.isPlayerReuse()) {
                        if (QuickVideoView.this.juS.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(He);
                        }
                    } else {
                        QuickVideoView.this.As(He);
                    }
                }
                if (QuickVideoView.this.juY) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juQ != null && gVar != null) {
                    QuickVideoView.this.juQ.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jvc);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juR) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juR);
                }
                if (QuickVideoView.this.jvh != null && QuickVideoView.this.jvh.czO()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efp = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.Ff(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juV = null;
                }
                if (!QuickVideoView.this.efe || QuickVideoView.this.juZ == null) {
                    if (QuickVideoView.this.juZ != null) {
                        QuickVideoView.this.juZ.onCompletion();
                    }
                    QuickVideoView.this.juY = false;
                    x.czt().remove(QuickVideoView.this.jvm);
                    if (QuickVideoView.this.dVp != null) {
                        QuickVideoView.this.dVp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juX = null;
                QuickVideoView.this.jvn = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juZ.cyx());
                QuickVideoView.this.start();
            }
        };
        this.dVr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.cyM();
                if (QuickVideoView.this.juZ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyR()) {
                    QuickVideoView.this.jvo = true;
                    x.czt().bl(QuickVideoView.this.jvm, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czw().Hg(QuickVideoView.this.jvl);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juV != null) {
                        QuickVideoView.this.juX = QuickVideoView.this.juV.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jvn, QuickVideoView.this.aq(QuickVideoView.this.juV.cgL(), i3 + "", QuickVideoView.this.juV.cgM()));
                        QuickVideoView.this.juV = null;
                    }
                    QuickVideoView.this.jvn = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMt == null || QuickVideoView.this.dMt.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.efs = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jvo) {
                    QuickVideoView.this.jvo = false;
                    return;
                }
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.czf();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juZ != null && z) {
                    QuickVideoView.this.juZ.onSeekComplete();
                }
                if (QuickVideoView.this.dVt != null) {
                    QuickVideoView.this.dVt.b(gVar);
                }
            }
        };
        this.dVs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.juT != null) {
                    QuickVideoView.this.juT.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jvc = i2;
                    if (QuickVideoView.this.juQ != null && gVar != null) {
                        QuickVideoView.this.juQ.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jvc);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jva.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.a(i, i2, QuickVideoView.this.juV);
                    return true;
                }
                return true;
            }
        };
        this.dVu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.m(i, i2, str);
                }
            }
        };
        this.dVv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.Fh(str);
                }
            }
        };
        this.dVw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jvn = j;
                }
            }
        };
        this.jvI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juZ != null && QuickVideoView.this.juZ.cyA() && QuickVideoView.this.juZ.cyB() && QuickVideoView.this.juZ.cyC() && QuickVideoView.this.juS != null) {
                    int aWH = QuickVideoView.this.juS.aWH();
                    int currentPosition = QuickVideoView.this.juS.getCurrentPosition();
                    int duration = QuickVideoView.this.juS.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvr;
                    boolean z = currentPosition + aWH < duration;
                    if (aWH < QuickVideoView.this.juZ.cyD() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvr = currentTimeMillis;
                        QuickVideoView.this.juZ.Ap(0);
                    }
                    if (QuickVideoView.this.cyP() && currentPosition == QuickVideoView.this.jvs && j > 500) {
                        QuickVideoView.this.jvr = currentTimeMillis;
                        QuickVideoView.this.juZ.Ap(0);
                    }
                    QuickVideoView.this.jvs = currentPosition;
                    if (QuickVideoView.this.jvy == QuickVideoView.jvw) {
                        QuickVideoView.this.cyQ();
                    }
                }
            }
        };
        this.dVD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juZ != null) {
                        QuickVideoView.this.juZ.wK(QuickVideoView.this.jvl);
                    }
                    if (QuickVideoView.this.juV != null) {
                        QuickVideoView.this.juV.Fe(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juV = null;
                    }
                    QuickVideoView.this.cyM();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.juY = false;
        this.jvb = false;
        this.jvc = 0;
        this.efe = false;
        this.jvd = -1;
        this.jve = false;
        this.jvf = null;
        this.jvg = true;
        this.jvq = false;
        this.jvr = 0L;
        this.jvs = 0L;
        this.jvy = jvx;
        this.jvz = 0;
        this.mBitRate = 0;
        this.jvA = -1;
        this.jvB = 0;
        this.jvC = 0;
        this.jvD = 0;
        this.ean = 0;
        this.jvE = false;
        this.Pf = null;
        this.jvF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juS != null && QuickVideoView.this.juY) {
                    QuickVideoView.this.b(QuickVideoView.this.juS, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvG = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.oR(false);
                }
            }
        };
        this.jvH = false;
        this.aXQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.jvE) {
                    QuickVideoView.this.jvE = false;
                    if (QuickVideoView.this.juS != null) {
                        QuickVideoView.this.juS.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jvb || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juS != null) {
                        if (QuickVideoView.this.cyT()) {
                            QuickVideoView.this.juS.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jve) {
                            QuickVideoView.this.juS.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jvd);
                            if (QuickVideoView.this.juw != null) {
                                QuickVideoView.this.juw.cyu();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juV.cgH();
                            }
                        }
                    }
                } else if (cyW()) {
                    if (QuickVideoView.this.juS != null) {
                        QuickVideoView.this.cyK();
                        QuickVideoView.this.jvb = true;
                        QuickVideoView.this.juS.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juV.cgG();
                    }
                }
                QuickVideoView.this.jvf = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvE) {
                    QuickVideoView.this.cyM();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juS != null) {
                        if (QuickVideoView.this.juS.isPlaying() && QuickVideoView.this.cyR()) {
                            x.czt().bl(QuickVideoView.this.jvm, QuickVideoView.this.juS.getCurrentPosition());
                            if (QuickVideoView.this.jvq) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jvq) {
                            QuickVideoView.this.juS.release();
                        }
                    }
                    if (QuickVideoView.this.jvb) {
                        if (QuickVideoView.this.juZ != null && !QuickVideoView.this.jvq) {
                            QuickVideoView.this.juZ.GZ(QuickVideoView.this.jvl);
                        }
                        if (QuickVideoView.this.dMx != null) {
                            QuickVideoView.this.dMx.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jvf = null;
                    if (QuickVideoView.this.juV != null && QuickVideoView.this.juV.Fg(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juV = null;
                    }
                    if (!QuickVideoView.this.jvq) {
                        QuickVideoView.this.jvb = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyW() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                            if (runningTaskInfo.topActivity.getClassName().equals(((Activity) QuickVideoView.this.mContext).getClass().getName())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.efo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int He;
                QuickVideoView.this.cyM();
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.onPrepared();
                }
                if (QuickVideoView.this.juV != null && QuickVideoView.this.juS != null) {
                    QuickVideoView.this.juV.yh(QuickVideoView.this.juS.getPlayerType());
                }
                if (QuickVideoView.this.jvq) {
                    TbVideoViewSet.czw().a(QuickVideoView.this, QuickVideoView.this.jvl);
                }
                if (QuickVideoView.this.dVq != null) {
                    QuickVideoView.this.jva.cgX();
                    QuickVideoView.this.dVq.onPrepared(gVar);
                }
                if (QuickVideoView.this.juZ != null) {
                    long j = 0;
                    if (QuickVideoView.this.juS != null) {
                        j = QuickVideoView.this.juS.getDuration();
                    }
                    QuickVideoView.this.juZ.ew(j);
                    QuickVideoView.this.cyL();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juZ.cyE();
                        QuickVideoView.this.cyQ();
                    }
                }
                if (QuickVideoView.this.jvp && (He = x.czt().He(QuickVideoView.this.jvm)) > 0 && QuickVideoView.this.juS != null) {
                    if (QuickVideoView.this.juS.isPlayerReuse()) {
                        if (QuickVideoView.this.juS.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(He);
                        }
                    } else {
                        QuickVideoView.this.As(He);
                    }
                }
                if (QuickVideoView.this.juY) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juQ != null && gVar != null) {
                    QuickVideoView.this.juQ.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jvc);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juR) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juR);
                }
                if (QuickVideoView.this.jvh != null && QuickVideoView.this.jvh.czO()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efp = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.Ff(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juV = null;
                }
                if (!QuickVideoView.this.efe || QuickVideoView.this.juZ == null) {
                    if (QuickVideoView.this.juZ != null) {
                        QuickVideoView.this.juZ.onCompletion();
                    }
                    QuickVideoView.this.juY = false;
                    x.czt().remove(QuickVideoView.this.jvm);
                    if (QuickVideoView.this.dVp != null) {
                        QuickVideoView.this.dVp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juX = null;
                QuickVideoView.this.jvn = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juZ.cyx());
                QuickVideoView.this.start();
            }
        };
        this.dVr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.X(i2, i22, i3);
                QuickVideoView.this.cyM();
                if (QuickVideoView.this.juZ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyR()) {
                    QuickVideoView.this.jvo = true;
                    x.czt().bl(QuickVideoView.this.jvm, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czw().Hg(QuickVideoView.this.jvl);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juV != null) {
                        QuickVideoView.this.juX = QuickVideoView.this.juV.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jvn, QuickVideoView.this.aq(QuickVideoView.this.juV.cgL(), i3 + "", QuickVideoView.this.juV.cgM()));
                        QuickVideoView.this.juV = null;
                    }
                    QuickVideoView.this.jvn = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMt == null || QuickVideoView.this.dMt.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.efs = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jvo) {
                    QuickVideoView.this.jvo = false;
                    return;
                }
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.czf();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juZ != null && z) {
                    QuickVideoView.this.juZ.onSeekComplete();
                }
                if (QuickVideoView.this.dVt != null) {
                    QuickVideoView.this.dVt.b(gVar);
                }
            }
        };
        this.dVs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.juT != null) {
                    QuickVideoView.this.juT.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.jvc = i22;
                    if (QuickVideoView.this.juQ != null && gVar != null) {
                        QuickVideoView.this.juQ.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jvc);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.jva.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.jvi != null) {
                    QuickVideoView.this.jvi.a(i2, i22, QuickVideoView.this.juV);
                    return true;
                }
                return true;
            }
        };
        this.dVu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.m(i2, i22, str);
                }
            }
        };
        this.dVv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juV != null) {
                    QuickVideoView.this.juV.Fh(str);
                }
            }
        };
        this.dVw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jvn = j;
                }
            }
        };
        this.jvI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juZ != null && QuickVideoView.this.juZ.cyA() && QuickVideoView.this.juZ.cyB() && QuickVideoView.this.juZ.cyC() && QuickVideoView.this.juS != null) {
                    int aWH = QuickVideoView.this.juS.aWH();
                    int currentPosition = QuickVideoView.this.juS.getCurrentPosition();
                    int duration = QuickVideoView.this.juS.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvr;
                    boolean z = currentPosition + aWH < duration;
                    if (aWH < QuickVideoView.this.juZ.cyD() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvr = currentTimeMillis;
                        QuickVideoView.this.juZ.Ap(0);
                    }
                    if (QuickVideoView.this.cyP() && currentPosition == QuickVideoView.this.jvs && j > 500) {
                        QuickVideoView.this.jvr = currentTimeMillis;
                        QuickVideoView.this.juZ.Ap(0);
                    }
                    QuickVideoView.this.jvs = currentPosition;
                    if (QuickVideoView.this.jvy == QuickVideoView.jvw) {
                        QuickVideoView.this.cyQ();
                    }
                }
            }
        };
        this.dVD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juZ != null) {
                        QuickVideoView.this.juZ.wK(QuickVideoView.this.jvl);
                    }
                    if (QuickVideoView.this.juV != null) {
                        QuickVideoView.this.juV.Fe(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juV = null;
                    }
                    QuickVideoView.this.cyM();
                }
            }
        };
        init(context);
    }

    @Override // com.baidu.tieba.play.a.a
    public View getView() {
        return this;
    }

    private void init(Context context) {
        this.mContext = context;
        this.juQ = new RenderView(context);
        this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
        this.juQ.setSurfaceTextureListener(this.aXQ);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.jvg) {
            addView(this.juQ, layoutParams);
        } else {
            addView(this.juQ, 0, layoutParams);
        }
        if (efm != null) {
            this.juS = efm.aWK();
        }
        if (this.juS != null) {
            this.juS.setOnPreparedListener(this.efo);
            this.juS.setOnCompletionListener(this.efp);
            this.juS.a(this.dVr);
            this.juS.setOnSeekCompleteListener(this.efs);
            this.juS.a(this.dVs);
            this.juS.a(this.dVu);
            this.juS.a(this.dVv);
            this.juS.a(this.dVw);
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.jvh = new com.baidu.tieba.play.b.a(this);
        this.jvi = new q();
        this.jvj = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.jva = new com.baidu.tieba.k.k();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(SwitchManager.getInstance().findType(VideoPlayerReuseSwitch.VIDEO_PLAY_REUSE_KEY) == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jvp = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.jvl;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.jva.cgW();
        this.Pj = str2;
        if (this.jvh != null) {
            this.jvh.clear();
            this.jvh.czO();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Hi(str2);
            if (efn != null) {
                this.juV = efn.ap(this.Pj, str, "");
                if (this.juV != null) {
                    this.juV.a(-300, -44399, -44399, getLocateSource(), false, this.jvn, "");
                    this.juV = null;
                }
            }
        }
        if (this.juW != null) {
            this.juW.a(null);
            this.juW.cgz();
            this.juW = null;
        }
        this.juX = null;
        this.jvn = 0L;
        setVideoPath(str);
    }

    private String Ha(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPi().cPj()) {
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

    public void setVideoPath(String str) {
        if (!aq.isEmpty(str)) {
            String Ha = Ha(str);
            this.jvk = Ha;
            if (this.juZ != null) {
                Ha = this.juZ.wF(Ha);
                if (this.juZ.cyF() != null) {
                    this.juZ.cyF().setPlayer(this);
                }
                if (efn != null && uz(Ha)) {
                    this.juW = efn.Fj(Ha);
                }
                if (this.juW != null) {
                    this.juW.a(new com.baidu.tieba.play.monitor.a(this.Pj, this.jvk, this.juV));
                    this.juW.cgy();
                }
                Hb(Ha);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !uz(Ha)) {
                if (this.dMt != null) {
                    this.dMt.onError(this.juS, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.czw().Hg(this.jvl);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(Ha));
            if (this.juV != null && u(Uri.parse(Ha)) != null) {
                this.juV.cgF();
            }
            this.jvl = str;
            int lastIndexOf = this.jvl.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.jvl.length() > 4) {
                this.jvm = this.jvl.substring(0, lastIndexOf + 4);
            } else {
                this.jvm = this.jvl;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        if (com.baidu.tbadk.coreExtra.model.f.aMg()) {
            if (this.juZ != null && (this.juZ.cyz() || this.juZ.cyA())) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvF);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.jvF, com.baidu.tbadk.coreExtra.model.f.aMf());
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvG);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jvG, com.baidu.tbadk.coreExtra.model.f.aMe());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.juV.Fd(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aWD();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.jvH = false;
        if (this.jvf != null) {
            cyK();
            if (this.juS != null) {
                if (!this.jvb) {
                    this.jvb = true;
                    this.juS.a(this.mContext, this.mUri, this.mHeaders, this.jvf, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying() && this.efo != null) {
                    this.jvH = true;
                    this.efo.onPrepared(this.juS);
                }
            }
        } else if (this.juQ != null && this.juQ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.jvg) {
                addView(this.juQ, layoutParams);
            } else {
                addView(this.juQ, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aWD() {
        this.jvb = false;
        this.juY = false;
        if (this.juS != null) {
            if (this.juS.isPlaying() && cyR()) {
                x.czt().bl(this.jvm, this.juS.getCurrentPosition());
            }
            this.juS.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvI);
    }

    private void Hb(String str) {
        this.mBitRate = 0;
        this.jvA = 0;
        this.jvB = 0;
        this.jvC = 0;
        this.jvD = 0;
        this.ean = 0;
        if (this.juZ.cyA()) {
            this.jvz = jvu;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.jvA = (int) t.Hd(QuickVideoView.this.jvk);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.jvk != null && this.jvk.equals(str)) {
            this.jvz = jvt;
        } else {
            this.jvz = jvv;
        }
        this.jvy = jvw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyL() {
        this.jvy = jvw;
        if (this.juS != null) {
            this.mBitRate = this.juS.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(boolean z) {
        if (this.jvy == jvw && this.juS != null) {
            this.jvy = jvx;
            this.jvC = this.juS.getDuration();
            if (z) {
                this.jvD = 0;
                this.jvB = this.jvC;
            } else {
                this.jvB = this.juS.getCurrentPosition();
                this.jvD = this.juS.getCachedSize();
            }
            if (this.jvB > 0) {
                if (this.jvz == jvt) {
                    this.jvA = (int) t.Hd(this.jvk);
                    if (this.mBitRate > 0) {
                        long j = (this.mBitRate * (this.jvB / 1000)) / 8;
                        if (this.jvD < 0) {
                            this.jvD = 0;
                        }
                        long j2 = this.jvD + j;
                        if (this.jvA > 0) {
                            j2 += this.jvA;
                        }
                        setFlowCount(j2, this.jvB, this.jvC, this.ean);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jvB / 1000)) / 8, this.jvB, this.jvC, this.ean);
                    }
                } else if (this.jvz == jvu) {
                    if (this.mBitRate > 0) {
                        long j3 = (this.mBitRate * (this.jvB / 1000)) / 8;
                        if (this.jvD < 0) {
                            this.jvD = 0;
                        }
                        long j4 = this.jvD + j3;
                        if (this.jvA > 0) {
                            j4 -= this.jvA;
                        }
                        setFlowCount(j4, this.jvB, this.jvC, this.ean);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jvB / 1000)) / 8, this.jvB, this.jvC, this.ean);
                    }
                } else {
                    setFlowCount(0L, this.jvB, this.jvC, this.ean);
                }
            }
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvI);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jvq) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        cyM();
        rO(false);
        if (this.jvh != null) {
            this.jvh.clear();
        }
        this.juR = null;
        this.juY = false;
        if (this.juS != null) {
            if (this.juS.isPlaying() && cyR()) {
                x.czt().bl(this.jvm, this.juS.getCurrentPosition());
            }
            this.juS.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvI);
        this.efe = false;
        if (this.juZ != null) {
            this.juZ.cyy();
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.juV != null && this.juV.Fg(getLocateSource())) {
            this.juV = null;
        }
        if (this.jva != null) {
            this.jva.cgV();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvI);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        cyM();
        rO(false);
        if (this.jvh != null) {
            this.jvh.clear();
        }
        this.juR = null;
        aWD();
        TbVideoViewSet.czw().Hg(this.jvl);
        this.efe = false;
        if (this.juZ != null) {
            this.juZ.GZ(this.jvl);
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.juV != null && this.juV.Fg(getLocateSource())) {
            this.juV = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvI);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.jvE = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyM() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvF);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvG);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.dVq = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.dVp = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.dMt = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0590g interfaceC0590g) {
        this.dVt = interfaceC0590g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyN() {
        cyM();
        if (this.jvi != null) {
            this.jvi.onPrepared();
        }
        if (u(this.mUri) != null && this.juS != null) {
            this.juV.Fd(this.mUri.getPath());
            this.juV.yi(this.juS.getPlayerType());
        }
        this.jva.cgW();
        this.jva.cgX();
        if (this.juZ != null) {
            long j = 0;
            if (this.juS != null) {
                j = this.juS.getDuration();
            }
            this.juZ.ew(j);
            cyL();
            if (getPlayerType() == -200) {
                this.juZ.cyE();
                cyQ();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyO() {
        if (u(this.mUri) != null && this.juS != null) {
            this.juV.Fd(this.mUri.getPath());
            this.juV.cgF();
            this.juV.yh(this.juS.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.jvj == null) {
            return "";
        }
        String czQ = this.jvj.czQ();
        this.jvj.ar(str, str2, str3);
        return czQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.juZ != null && !StringUtils.isNull(this.juZ.cyx())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Hh(uri);
                }
            }
            this.mUri = Uri.parse(this.juZ.cyx());
        }
        boolean z = false;
        if (this.jvh != null) {
            z = this.jvh.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.juV != null) {
            this.juX = this.juV.a(i, i2, i3, getLocateSource(), z, this.jvn, aq(this.juV.cgL(), i3 + "", this.juV.cgM()));
            this.juV = null;
        }
        this.jvn = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.juS != null) {
            try {
                if (this.juS.isPlaying() && cyR()) {
                    x.czt().bl(this.jvm, this.juS.getCurrentPosition());
                }
                this.juS.release();
                this.juR = str;
                URI uri = new URI(this.mUri.toString());
                this.juS.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.jvf, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.juV.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.juS != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.juS.isPlaying() && cyR()) {
                x.czt().bl(this.jvm, this.juS.getCurrentPosition());
            }
            this.juS.release();
            this.juS.a(this.mContext, this.mUri, this.mHeaders, this.jvf, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.juV.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.juS != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.juS.forceUseSystemMediaPlayer(true);
            }
            if (this.juS.isPlaying() && cyR()) {
                x.czt().bl(this.jvm, this.juS.getCurrentPosition());
            }
            this.juS.release();
            this.juS.a(this.mContext, this.mUri, this.mHeaders, this.jvf, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.juV.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.juY = true;
        if (this.juS != null) {
            if (this.jvf != null && this.jve && !this.juS.isExistInRemote()) {
                this.juS.a(this.mContext, this.mUri, this.mHeaders, this.jvf, this.jvd);
                if (this.juw != null) {
                    this.juw.cyu();
                }
                if (u(this.mUri) != null) {
                    this.juV.cgH();
                }
                cyK();
                return;
            }
            if (!this.juS.aWI()) {
                af.a(this.Pf, true);
                this.juS.setVolume(1.0f, 1.0f);
            }
            this.jva.cgY();
            this.juS.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.juZ != null) {
            this.juZ.onStart();
        }
        if (this.juU != null) {
            this.juU.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.juS != null) {
            this.juV.yj(this.juS.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.juY) {
            b(aVar);
            return;
        }
        this.juY = true;
        if (aVar != null) {
            this.jvq = true;
            if (!cyU()) {
                aVar.czx();
            }
        } else {
            this.jvq = false;
        }
        setVideoPath(this.jvl, this.Pj);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cyM();
        af.a(this.Pf, false);
        if (this.juS != null) {
            if (this.juS.isPlaying() && cyR()) {
                x.czt().bl(this.jvm, this.juS.getCurrentPosition());
            }
            this.juS.pause();
        }
        if (this.juZ != null) {
            this.juZ.onPause();
        }
        this.juY = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juV != null) {
            this.juV.cgK();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.juS != null) {
            return this.juS.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.juS != null) {
            return this.juS.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.ean = i;
        As(i);
    }

    public void As(int i) {
        if (this.jvi != null) {
            this.jvi.cze();
        }
        if (this.juS != null) {
            this.juS.seekTo(i);
        }
        if (this.juZ != null) {
            this.juZ.Ap(0);
            cyQ();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.juS != null) {
            return this.juS.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.juS != null) {
            this.juS.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.jvd = i;
    }

    public int getRecoveryState() {
        return this.jvd;
    }

    public void setNeedRecovery(boolean z) {
        this.jve = z;
    }

    public void setLooping(boolean z) {
        this.efe = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cyP() {
        return this.juY;
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

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(b bVar) {
        this.dMx = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.juZ = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVD);
    }

    public void setMute(boolean z) {
        if (z) {
            this.juS.setVolume(0.0f, 0.0f);
            af.a(this.Pf, false);
            return;
        }
        af.a(this.Pf, true);
        this.juS.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.efe = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juS != null) {
            this.juS.aWJ();
        }
        if (this.jvi != null) {
            this.jvi.Gm();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvI);
        MessageManager.getInstance().unRegisterListener(this.dVD);
        if (this.jvh != null) {
            this.jvh.clear();
        }
        if (this.juW != null) {
            this.juW.a(null);
            this.juW.cgz();
        }
    }

    public g getPlayer() {
        return this.juS;
    }

    public int getPlayerType() {
        if (this.juS == null) {
            return -300;
        }
        return this.juS.getPlayerType();
    }

    public void cyQ() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvI);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvI, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.juw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.juZ instanceof n) || ((n) this.juZ).czd() == null) {
            return "";
        }
        return ((n) this.juZ).jvU ? "v_mid_page" : ((n) this.juZ).czd().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i u(Uri uri) {
        String uri2;
        if (this.juV != null) {
            return this.juV;
        }
        if (!StringUtils.isNull(this.jvk)) {
            uri2 = this.jvk;
        } else if (efn != null && this.juZ != null && !StringUtils.isNull(this.juZ.cyx())) {
            uri2 = this.juZ.cyx();
        } else {
            uri2 = (efn == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && efn != null) {
            this.juV = efn.ap(this.Pj, uri2, this.juX);
        }
        this.juX = null;
        this.jvn = 0L;
        return this.juV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyR() {
        return this.juS != null && this.juS.getDuration() >= this.juS.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.juV, j, j2, j3, j4);
    }

    public static boolean uz(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cyS() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            try {
                ((ViewGroup) getParent()).removeView(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.jvq = true;
            if (!cyU()) {
                aVar.czx();
            }
            if (!cyT()) {
                aVar.czy();
                this.juY = true;
                setVideoPath(this.jvl, this.Pj);
                return;
            }
        } else {
            this.jvq = false;
        }
        start();
        if (this.juS != null && this.jvq) {
            this.jva.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyT() {
        return this == TbVideoViewSet.czw().Hf(this.jvl);
    }

    private boolean cyU() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.dVp = null;
        this.dMt = null;
        this.dVs = null;
        this.efo = null;
        this.efs = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jvq = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.juT = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.juS != null) {
            return this.juS.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.juS != null ? this.juS.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.juV != null) {
            this.juV.e(j, j2, j3);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.juU = cVar;
    }
}
