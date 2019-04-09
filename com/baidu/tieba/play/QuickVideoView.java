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
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static int hWR = 0;
    private static int hWS = 1;
    private static int hWT = 2;
    private static int hWU = 1;
    private static int hWV = 0;
    private static h hWs;
    private static com.baidu.tieba.j.l hWt;
    private Map<String, String> Ie;
    private WeakReference<Context> btE;
    private g.b cAp;
    private b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.c cJK;
    private g.e cJL;
    private g.InterfaceC0369g cJM;
    private g.i cJN;
    private g.d cJO;
    private g.h cJP;
    private final CustomMessageListener cJW;
    private int cNW;
    private String ctx;
    private int hGJ;
    private a hVU;
    private int hWA;
    private boolean hWB;
    private int hWC;
    private boolean hWD;
    private SurfaceTexture hWE;
    private boolean hWF;
    private com.baidu.tieba.play.b.a hWG;
    private r hWH;
    private com.baidu.tieba.play.b.f hWI;
    private String hWJ;
    private String hWK;
    private String hWL;
    private long hWM;
    private boolean hWN;
    private boolean hWO;
    private long hWP;
    private long hWQ;
    private int hWW;
    private int hWX;
    private int hWY;
    private int hWZ;
    private RenderView hWn;
    private String hWo;
    private g hWp;
    private g.e hWq;
    private c hWr;
    private com.baidu.tieba.j.i hWu;
    private com.baidu.tieba.j.e hWv;
    private String hWw;
    private boolean hWx;
    private d hWy;
    private boolean hWz;
    private int hXa;
    private int hXb;
    private boolean hXc;
    private Runnable hXd;
    private Runnable hXe;
    private TextureView.SurfaceTextureListener hXf;
    private g.f hXg;
    private g.a hXh;
    private g.InterfaceC0369g hXi;
    private Runnable hXj;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bSW();
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            hWs = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            hWt = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.hWF = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.hWx = false;
        this.hWz = false;
        this.hWA = 0;
        this.hWB = false;
        this.hWC = -1;
        this.hWD = false;
        this.hWE = null;
        this.hWF = true;
        this.hWP = 0L;
        this.hWQ = 0L;
        this.hGJ = hWV;
        this.hWW = 0;
        this.hWX = 0;
        this.hWY = -1;
        this.hWZ = 0;
        this.hXa = 0;
        this.hXb = 0;
        this.cNW = 0;
        this.hXc = false;
        this.btE = null;
        this.hXd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWp != null && QuickVideoView.this.hWx) {
                    QuickVideoView.this.b(QuickVideoView.this.hWp, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.mt(false);
                }
            }
        };
        this.hXf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXc) {
                    QuickVideoView.this.hXc = false;
                    QuickVideoView.this.hWp.c(surfaceTexture);
                } else if (QuickVideoView.this.hWz || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWp != null && QuickVideoView.this.hWD) {
                        QuickVideoView.this.hWp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWC);
                        if (QuickVideoView.this.hVU != null) {
                            QuickVideoView.this.hVU.bSW();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWu.bEj();
                        }
                    }
                } else if (bTr()) {
                    if (QuickVideoView.this.hWp != null) {
                        QuickVideoView.this.bTk();
                        QuickVideoView.this.hWz = true;
                        QuickVideoView.this.hWp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWu.bEi();
                    }
                }
                QuickVideoView.this.hWE = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXc) {
                    QuickVideoView.this.bTm();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWp != null) {
                        if (QuickVideoView.this.hWp.isPlaying() && QuickVideoView.this.bTp()) {
                            y.bTR().bj(QuickVideoView.this.hWL, QuickVideoView.this.hWp.getCurrentPosition());
                        }
                        QuickVideoView.this.hWp.release();
                    }
                    if (QuickVideoView.this.hWz) {
                        if (QuickVideoView.this.hWy != null) {
                            QuickVideoView.this.hWy.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWE = null;
                    if (QuickVideoView.this.hWu != null && QuickVideoView.this.hWu.za(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.hWz = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTr() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.T(runningTasks)) {
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
        this.hXg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AS;
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.onPrepared();
                }
                if (QuickVideoView.this.hWu != null && QuickVideoView.this.hWp != null) {
                    QuickVideoView.this.hWu.vB(QuickVideoView.this.hWp.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWy != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWp != null) {
                        j = QuickVideoView.this.hWp.getDuration();
                    }
                    QuickVideoView.this.hWy.dI(j);
                    QuickVideoView.this.bTl();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWy.bTd();
                        QuickVideoView.this.bTo();
                    }
                }
                if (QuickVideoView.this.hWO && (AS = y.bTR().AS(QuickVideoView.this.hWL)) > 0) {
                    if (QuickVideoView.this.hWp.isPlayerReuse()) {
                        if (QuickVideoView.this.hWp.getCurrentPosition() == 0) {
                            QuickVideoView.this.xl(AS);
                        }
                    } else {
                        QuickVideoView.this.xl(AS);
                    }
                }
                if (QuickVideoView.this.hWx) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWn != null && gVar != null) {
                    QuickVideoView.this.hWn.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWA);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWo) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWo);
                }
                if (QuickVideoView.this.hWG != null && QuickVideoView.this.hWG.bUn()) {
                    com.baidu.tieba.play.b.e.xs(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXh = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.yZ(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWu = null;
                }
                if (!QuickVideoView.this.hWB || QuickVideoView.this.hWy == null) {
                    if (QuickVideoView.this.hWy != null) {
                        QuickVideoView.this.hWy.onCompletion();
                    }
                    QuickVideoView.this.hWx = false;
                    y.bTR().remove(QuickVideoView.this.hWL);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWw = null;
                QuickVideoView.this.hWM = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWy.bSX());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWy != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTp()) {
                    QuickVideoView.this.hWN = true;
                    y.bTR().bj(QuickVideoView.this.hWL, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWu != null) {
                        QuickVideoView.this.hWw = QuickVideoView.this.hWu.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWM, QuickVideoView.this.Z(QuickVideoView.this.hWu.bEn(), i3 + "", QuickVideoView.this.hWu.bEo()));
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.hWM = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAp == null || QuickVideoView.this.cAp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXi = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hWN) {
                    QuickVideoView.this.hWN = false;
                    return;
                }
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.bTB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWy != null && z) {
                    QuickVideoView.this.hWy.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWq != null) {
                    QuickVideoView.this.hWq.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWA = i2;
                    if (QuickVideoView.this.hWn != null && gVar != null) {
                        QuickVideoView.this.hWn.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWA);
                    }
                }
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.a(i, i2, QuickVideoView.this.hWu);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.h(i, i2, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.zb(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWM = j;
                }
            }
        };
        this.hXj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWy != null && QuickVideoView.this.hWy.bSZ() && QuickVideoView.this.hWy.bTa() && QuickVideoView.this.hWy.bTb() && QuickVideoView.this.hWp != null) {
                    int avh = QuickVideoView.this.hWp.avh();
                    int currentPosition = QuickVideoView.this.hWp.getCurrentPosition();
                    int duration = QuickVideoView.this.hWp.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hWP;
                    boolean z = currentPosition + avh < duration;
                    if (avh < QuickVideoView.this.hWy.bTc() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hWP = currentTimeMillis;
                        QuickVideoView.this.hWy.xj(0);
                    }
                    if (QuickVideoView.this.bTn() && currentPosition == QuickVideoView.this.hWQ && j > 500) {
                        QuickVideoView.this.hWP = currentTimeMillis;
                        QuickVideoView.this.hWy.xj(0);
                    }
                    QuickVideoView.this.hWQ = currentPosition;
                    if (QuickVideoView.this.hGJ == QuickVideoView.hWU) {
                        QuickVideoView.this.bTo();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWy != null) {
                        QuickVideoView.this.hWy.bTf();
                    }
                    if (QuickVideoView.this.hWu != null) {
                        QuickVideoView.this.hWu.yY(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.bTm();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWx = false;
        this.hWz = false;
        this.hWA = 0;
        this.hWB = false;
        this.hWC = -1;
        this.hWD = false;
        this.hWE = null;
        this.hWF = true;
        this.hWP = 0L;
        this.hWQ = 0L;
        this.hGJ = hWV;
        this.hWW = 0;
        this.hWX = 0;
        this.hWY = -1;
        this.hWZ = 0;
        this.hXa = 0;
        this.hXb = 0;
        this.cNW = 0;
        this.hXc = false;
        this.btE = null;
        this.hXd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWp != null && QuickVideoView.this.hWx) {
                    QuickVideoView.this.b(QuickVideoView.this.hWp, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.mt(false);
                }
            }
        };
        this.hXf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXc) {
                    QuickVideoView.this.hXc = false;
                    QuickVideoView.this.hWp.c(surfaceTexture);
                } else if (QuickVideoView.this.hWz || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWp != null && QuickVideoView.this.hWD) {
                        QuickVideoView.this.hWp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWC);
                        if (QuickVideoView.this.hVU != null) {
                            QuickVideoView.this.hVU.bSW();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWu.bEj();
                        }
                    }
                } else if (bTr()) {
                    if (QuickVideoView.this.hWp != null) {
                        QuickVideoView.this.bTk();
                        QuickVideoView.this.hWz = true;
                        QuickVideoView.this.hWp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWu.bEi();
                    }
                }
                QuickVideoView.this.hWE = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXc) {
                    QuickVideoView.this.bTm();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWp != null) {
                        if (QuickVideoView.this.hWp.isPlaying() && QuickVideoView.this.bTp()) {
                            y.bTR().bj(QuickVideoView.this.hWL, QuickVideoView.this.hWp.getCurrentPosition());
                        }
                        QuickVideoView.this.hWp.release();
                    }
                    if (QuickVideoView.this.hWz) {
                        if (QuickVideoView.this.hWy != null) {
                            QuickVideoView.this.hWy.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWE = null;
                    if (QuickVideoView.this.hWu != null && QuickVideoView.this.hWu.za(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.hWz = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTr() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.T(runningTasks)) {
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
        this.hXg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AS;
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.onPrepared();
                }
                if (QuickVideoView.this.hWu != null && QuickVideoView.this.hWp != null) {
                    QuickVideoView.this.hWu.vB(QuickVideoView.this.hWp.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWy != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWp != null) {
                        j = QuickVideoView.this.hWp.getDuration();
                    }
                    QuickVideoView.this.hWy.dI(j);
                    QuickVideoView.this.bTl();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWy.bTd();
                        QuickVideoView.this.bTo();
                    }
                }
                if (QuickVideoView.this.hWO && (AS = y.bTR().AS(QuickVideoView.this.hWL)) > 0) {
                    if (QuickVideoView.this.hWp.isPlayerReuse()) {
                        if (QuickVideoView.this.hWp.getCurrentPosition() == 0) {
                            QuickVideoView.this.xl(AS);
                        }
                    } else {
                        QuickVideoView.this.xl(AS);
                    }
                }
                if (QuickVideoView.this.hWx) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWn != null && gVar != null) {
                    QuickVideoView.this.hWn.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWA);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWo) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWo);
                }
                if (QuickVideoView.this.hWG != null && QuickVideoView.this.hWG.bUn()) {
                    com.baidu.tieba.play.b.e.xs(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXh = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.yZ(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWu = null;
                }
                if (!QuickVideoView.this.hWB || QuickVideoView.this.hWy == null) {
                    if (QuickVideoView.this.hWy != null) {
                        QuickVideoView.this.hWy.onCompletion();
                    }
                    QuickVideoView.this.hWx = false;
                    y.bTR().remove(QuickVideoView.this.hWL);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWw = null;
                QuickVideoView.this.hWM = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWy.bSX());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWy != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTp()) {
                    QuickVideoView.this.hWN = true;
                    y.bTR().bj(QuickVideoView.this.hWL, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWu != null) {
                        QuickVideoView.this.hWw = QuickVideoView.this.hWu.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWM, QuickVideoView.this.Z(QuickVideoView.this.hWu.bEn(), i3 + "", QuickVideoView.this.hWu.bEo()));
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.hWM = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAp == null || QuickVideoView.this.cAp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXi = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hWN) {
                    QuickVideoView.this.hWN = false;
                    return;
                }
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.bTB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWy != null && z) {
                    QuickVideoView.this.hWy.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWq != null) {
                    QuickVideoView.this.hWq.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWA = i2;
                    if (QuickVideoView.this.hWn != null && gVar != null) {
                        QuickVideoView.this.hWn.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWA);
                    }
                }
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.a(i, i2, QuickVideoView.this.hWu);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.h(i, i2, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.zb(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWM = j;
                }
            }
        };
        this.hXj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWy != null && QuickVideoView.this.hWy.bSZ() && QuickVideoView.this.hWy.bTa() && QuickVideoView.this.hWy.bTb() && QuickVideoView.this.hWp != null) {
                    int avh = QuickVideoView.this.hWp.avh();
                    int currentPosition = QuickVideoView.this.hWp.getCurrentPosition();
                    int duration = QuickVideoView.this.hWp.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hWP;
                    boolean z = currentPosition + avh < duration;
                    if (avh < QuickVideoView.this.hWy.bTc() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hWP = currentTimeMillis;
                        QuickVideoView.this.hWy.xj(0);
                    }
                    if (QuickVideoView.this.bTn() && currentPosition == QuickVideoView.this.hWQ && j > 500) {
                        QuickVideoView.this.hWP = currentTimeMillis;
                        QuickVideoView.this.hWy.xj(0);
                    }
                    QuickVideoView.this.hWQ = currentPosition;
                    if (QuickVideoView.this.hGJ == QuickVideoView.hWU) {
                        QuickVideoView.this.bTo();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWy != null) {
                        QuickVideoView.this.hWy.bTf();
                    }
                    if (QuickVideoView.this.hWu != null) {
                        QuickVideoView.this.hWu.yY(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.bTm();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWx = false;
        this.hWz = false;
        this.hWA = 0;
        this.hWB = false;
        this.hWC = -1;
        this.hWD = false;
        this.hWE = null;
        this.hWF = true;
        this.hWP = 0L;
        this.hWQ = 0L;
        this.hGJ = hWV;
        this.hWW = 0;
        this.hWX = 0;
        this.hWY = -1;
        this.hWZ = 0;
        this.hXa = 0;
        this.hXb = 0;
        this.cNW = 0;
        this.hXc = false;
        this.btE = null;
        this.hXd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWp != null && QuickVideoView.this.hWx) {
                    QuickVideoView.this.b(QuickVideoView.this.hWp, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.mt(false);
                }
            }
        };
        this.hXf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.hXc) {
                    QuickVideoView.this.hXc = false;
                    QuickVideoView.this.hWp.c(surfaceTexture);
                } else if (QuickVideoView.this.hWz || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWp != null && QuickVideoView.this.hWD) {
                        QuickVideoView.this.hWp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWC);
                        if (QuickVideoView.this.hVU != null) {
                            QuickVideoView.this.hVU.bSW();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWu.bEj();
                        }
                    }
                } else if (bTr()) {
                    if (QuickVideoView.this.hWp != null) {
                        QuickVideoView.this.bTk();
                        QuickVideoView.this.hWz = true;
                        QuickVideoView.this.hWp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWu.bEi();
                    }
                }
                QuickVideoView.this.hWE = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXc) {
                    QuickVideoView.this.bTm();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWp != null) {
                        if (QuickVideoView.this.hWp.isPlaying() && QuickVideoView.this.bTp()) {
                            y.bTR().bj(QuickVideoView.this.hWL, QuickVideoView.this.hWp.getCurrentPosition());
                        }
                        QuickVideoView.this.hWp.release();
                    }
                    if (QuickVideoView.this.hWz) {
                        if (QuickVideoView.this.hWy != null) {
                            QuickVideoView.this.hWy.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWE = null;
                    if (QuickVideoView.this.hWu != null && QuickVideoView.this.hWu.za(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.hWz = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTr() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.T(runningTasks)) {
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
        this.hXg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AS;
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.onPrepared();
                }
                if (QuickVideoView.this.hWu != null && QuickVideoView.this.hWp != null) {
                    QuickVideoView.this.hWu.vB(QuickVideoView.this.hWp.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWy != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWp != null) {
                        j = QuickVideoView.this.hWp.getDuration();
                    }
                    QuickVideoView.this.hWy.dI(j);
                    QuickVideoView.this.bTl();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWy.bTd();
                        QuickVideoView.this.bTo();
                    }
                }
                if (QuickVideoView.this.hWO && (AS = y.bTR().AS(QuickVideoView.this.hWL)) > 0) {
                    if (QuickVideoView.this.hWp.isPlayerReuse()) {
                        if (QuickVideoView.this.hWp.getCurrentPosition() == 0) {
                            QuickVideoView.this.xl(AS);
                        }
                    } else {
                        QuickVideoView.this.xl(AS);
                    }
                }
                if (QuickVideoView.this.hWx) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWn != null && gVar != null) {
                    QuickVideoView.this.hWn.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWA);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWo) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWo);
                }
                if (QuickVideoView.this.hWG != null && QuickVideoView.this.hWG.bUn()) {
                    com.baidu.tieba.play.b.e.xs(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXh = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.yZ(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWu = null;
                }
                if (!QuickVideoView.this.hWB || QuickVideoView.this.hWy == null) {
                    if (QuickVideoView.this.hWy != null) {
                        QuickVideoView.this.hWy.onCompletion();
                    }
                    QuickVideoView.this.hWx = false;
                    y.bTR().remove(QuickVideoView.this.hWL);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWw = null;
                QuickVideoView.this.hWM = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWy.bSX());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ac(i2, i22, i3);
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWy != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTp()) {
                    QuickVideoView.this.hWN = true;
                    y.bTR().bj(QuickVideoView.this.hWL, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWu != null) {
                        QuickVideoView.this.hWw = QuickVideoView.this.hWu.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWM, QuickVideoView.this.Z(QuickVideoView.this.hWu.bEn(), i3 + "", QuickVideoView.this.hWu.bEo()));
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.hWM = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.xq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAp == null || QuickVideoView.this.cAp.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.hXi = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hWN) {
                    QuickVideoView.this.hWN = false;
                    return;
                }
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.bTB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWy != null && z) {
                    QuickVideoView.this.hWy.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.hWq != null) {
                    QuickVideoView.this.hWq.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.hWA = i22;
                    if (QuickVideoView.this.hWn != null && gVar != null) {
                        QuickVideoView.this.hWn.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWA);
                    }
                }
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.a(i2, i22, QuickVideoView.this.hWu);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.h(i2, i22, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWu != null) {
                    QuickVideoView.this.hWu.zb(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWM = j;
                }
            }
        };
        this.hXj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWy != null && QuickVideoView.this.hWy.bSZ() && QuickVideoView.this.hWy.bTa() && QuickVideoView.this.hWy.bTb() && QuickVideoView.this.hWp != null) {
                    int avh = QuickVideoView.this.hWp.avh();
                    int currentPosition = QuickVideoView.this.hWp.getCurrentPosition();
                    int duration = QuickVideoView.this.hWp.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hWP;
                    boolean z = currentPosition + avh < duration;
                    if (avh < QuickVideoView.this.hWy.bTc() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hWP = currentTimeMillis;
                        QuickVideoView.this.hWy.xj(0);
                    }
                    if (QuickVideoView.this.bTn() && currentPosition == QuickVideoView.this.hWQ && j > 500) {
                        QuickVideoView.this.hWP = currentTimeMillis;
                        QuickVideoView.this.hWy.xj(0);
                    }
                    QuickVideoView.this.hWQ = currentPosition;
                    if (QuickVideoView.this.hGJ == QuickVideoView.hWU) {
                        QuickVideoView.this.bTo();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWy != null) {
                        QuickVideoView.this.hWy.bTf();
                    }
                    if (QuickVideoView.this.hWu != null) {
                        QuickVideoView.this.hWu.yY(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWu = null;
                    }
                    QuickVideoView.this.bTm();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.hWn = new RenderView(context);
        this.btE = new WeakReference<>(TbadkCoreApplication.getInst());
        this.hWn.setSurfaceTextureListener(this.hXf);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.hWF) {
            addView(this.hWn, layoutParams);
        } else {
            addView(this.hWn, 0, layoutParams);
        }
        if (hWs != null) {
            this.hWp = hWs.avj();
        }
        if (this.hWp != null) {
            this.hWp.setOnPreparedListener(this.hXg);
            this.hWp.setOnCompletionListener(this.hXh);
            this.hWp.a(this.cJK);
            this.hWp.setOnSeekCompleteListener(this.hXi);
            this.hWp.a(this.cJL);
            this.hWp.a(this.cJN);
            this.hWp.a(this.cJO);
            this.hWp.a(this.cJP);
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
        this.hWG = new com.baidu.tieba.play.b.a(this);
        this.hWH = new r();
        this.hWI = new com.baidu.tieba.play.b.f();
        al.k(this, d.C0277d.cp_bg_line_k);
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iQ().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.hWO = z;
    }

    public void setVideoPath(String str, String str2) {
        this.ctx = str2;
        if (this.hWG != null) {
            this.hWG.clear();
            this.hWG.bUn();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.AX(str2);
            if (hWt != null) {
                this.hWu = hWt.X(this.ctx, str, "");
                if (this.hWu != null) {
                    this.hWu.a(-300, -44399, -44399, getLocateSource(), false, this.hWM, "");
                    this.hWu = null;
                }
            }
        }
        if (this.hWv != null) {
            this.hWv.a(null);
            this.hWv.bEb();
            this.hWv = null;
        }
        this.hWw = null;
        this.hWM = 0L;
        setVideoPath(str);
    }

    public void dF(String str, String str2) {
    }

    private String AO(String str) {
        if (!ap.isEmpty(str) && com.baidu.tieba.video.g.ciN().ciO()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            if (str.contains("http:")) {
                return str.replace("http:", "https:");
            }
            return str;
        }
        return str;
    }

    public void setVideoPath(String str) {
        if (!ap.isEmpty(str)) {
            String AO = AO(str);
            this.hWJ = AO;
            if (this.hWy != null) {
                AO = this.hWy.qC(AO);
                if (this.hWy.bTe() != null) {
                    this.hWy.bTe().setPlayer(this);
                }
                if (hWt != null && od(AO)) {
                    this.hWv = hWt.ze(AO);
                }
                if (this.hWv != null) {
                    this.hWv.a(new com.baidu.tieba.play.monitor.a(this.ctx, this.hWJ, this.hWu));
                    this.hWv.bEa();
                }
                AP(AO);
            }
            if (!com.baidu.adp.lib.util.j.kY() && !od(AO)) {
                if (this.cAp != null) {
                    this.cAp.onError(this.hWp, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(AO));
            if (this.hWu != null) {
                if (o(Uri.parse(AO)) != null) {
                    this.hWu.bEh();
                }
                this.hWu.Ko();
                this.hWu = null;
            }
            this.hWK = str;
            int lastIndexOf = this.hWK.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.hWK.length() > 4) {
                this.hWL = this.hWK.substring(0, lastIndexOf + 4);
            } else {
                this.hWL = this.hWK;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTk() {
        if (com.baidu.tbadk.coreExtra.model.f.ajD()) {
            if (this.hWy != null && (this.hWy.bSY() || this.hWy.bSZ())) {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXd);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hXd, com.baidu.tbadk.coreExtra.model.f.ajC());
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXe);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXe, com.baidu.tbadk.coreExtra.model.f.ajB());
        }
    }

    public void bSA() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (o(uri) != null) {
            this.hWu.yX(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            avd();
        }
        this.mUri = uri;
        this.Ie = map;
        this.hWA = 0;
        if (this.hWE != null) {
            bTk();
            if (this.hWp != null) {
                if (!this.hWz) {
                    this.hWz = true;
                    this.hWp.a(this.mContext, this.mUri, this.Ie, this.hWE, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.hXg.onPrepared(this.hWp);
                }
            }
        } else if (this.hWn != null && this.hWn.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.hWF) {
                addView(this.hWn, layoutParams);
            } else {
                addView(this.hWn, 0, layoutParams);
            }
        }
        al.k(this, d.C0277d.cp_bg_line_k);
    }

    private void avd() {
        this.hWz = false;
        this.hWx = false;
        if (this.hWp != null) {
            if (this.hWp.isPlaying() && bTp()) {
                y.bTR().bj(this.hWL, this.hWp.getCurrentPosition());
            }
            this.hWp.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXj);
    }

    private void AP(String str) {
        this.hWX = 0;
        this.hWY = 0;
        this.hWZ = 0;
        this.hXa = 0;
        this.hXb = 0;
        this.cNW = 0;
        if (this.hWy.bSZ()) {
            this.hWW = hWS;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.hWY = (int) u.AR(QuickVideoView.this.hWJ);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.hWJ != null && this.hWJ.equals(str)) {
            this.hWW = hWR;
        } else {
            this.hWW = hWT;
        }
        this.hGJ = hWU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTl() {
        this.hGJ = hWU;
        if (this.hWp != null) {
            this.hWX = this.hWp.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
        if (this.hGJ == hWU && this.hWp != null) {
            this.hGJ = hWV;
            this.hXa = this.hWp.getDuration();
            if (z) {
                this.hXb = 0;
                this.hWZ = this.hXa;
            } else {
                this.hWZ = this.hWp.getCurrentPosition();
                this.hXb = this.hWp.getCachedSize();
            }
            if (this.hWZ > 0) {
                if (this.hWW == hWR) {
                    this.hWY = (int) u.AR(this.hWJ);
                    if (this.hWX > 0) {
                        long j = (this.hWX * (this.hWZ / 1000)) / 8;
                        if (this.hXb < 0) {
                            this.hXb = 0;
                        }
                        long j2 = this.hXb + j;
                        if (this.hWY > 0) {
                            j2 += this.hWY;
                        }
                        setFlowCount(j2, this.hWZ, this.hXa, this.cNW);
                    } else if (this.hWX == -1) {
                        this.hWX = 603327;
                        setFlowCount((this.hWX * (this.hWZ / 1000)) / 8, this.hWZ, this.hXa, this.cNW);
                    }
                } else if (this.hWW == hWS) {
                    if (this.hWX > 0) {
                        long j3 = (this.hWX * (this.hWZ / 1000)) / 8;
                        if (this.hXb < 0) {
                            this.hXb = 0;
                        }
                        long j4 = this.hXb + j3;
                        if (this.hWY > 0) {
                            j4 -= this.hWY;
                        }
                        setFlowCount(j4, this.hWZ, this.hXa, this.cNW);
                    } else if (this.hWX == -1) {
                        this.hWX = 603327;
                        setFlowCount((this.hWX * (this.hWZ / 1000)) / 8, this.hWZ, this.hXa, this.cNW);
                    }
                } else {
                    setFlowCount(0L, this.hWZ, this.hXa, this.cNW);
                }
            }
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXj);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.btE, false);
        }
        bTm();
        pb(false);
        if (this.hWG != null) {
            this.hWG.clear();
        }
        this.hWo = null;
        avd();
        this.hWB = false;
        if (this.hWy != null) {
            this.hWy.onStop();
        }
        com.baidu.tieba.play.a.b.bTU().a((b.InterfaceC0366b) null);
        if (this.hWu != null && this.hWu.za(getLocateSource())) {
            this.hWu = null;
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXj);
    }

    public void setFullScreenToDestroySurface() {
        this.hXc = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTm() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXd);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXe);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cJJ = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cJI = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cAp = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0369g interfaceC0369g) {
        this.cJM = interfaceC0369g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.hWI == null) {
            return "";
        }
        String bUp = this.hWI.bUp();
        this.hWI.aa(str, str2, str3);
        return bUp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.hWy != null && !StringUtils.isNull(this.hWy.bSX())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.AW(uri);
                }
            }
            this.mUri = Uri.parse(this.hWy.bSX());
        }
        boolean z = false;
        if (this.hWG != null) {
            z = this.hWG.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.hWu != null) {
            this.hWw = this.hWu.a(i, i2, i3, getLocateSource(), z, this.hWM, Z(this.hWu.bEn(), i3 + "", this.hWu.bEo()));
            this.hWu = null;
        }
        this.hWM = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.hWp != null) {
            try {
                if (this.hWp.isPlaying() && bTp()) {
                    y.bTR().bj(this.hWL, this.hWp.getCurrentPosition());
                }
                this.hWp.release();
                this.hWo = str;
                URI uri = new URI(this.mUri.toString());
                this.hWp.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Ie, this.hWE, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (o(this.mUri) != null) {
                    this.hWu.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWp != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.hWp.isPlaying() && bTp()) {
                y.bTR().bj(this.hWL, this.hWp.getCurrentPosition());
            }
            this.hWp.release();
            this.hWp.a(this.mContext, this.mUri, this.Ie, this.hWE, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWu.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWp != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.hWp.forceUseSystemMediaPlayer(true);
            }
            if (this.hWp.isPlaying() && bTp()) {
                y.bTR().bj(this.hWL, this.hWp.getCurrentPosition());
            }
            this.hWp.release();
            this.hWp.a(this.mContext, this.mUri, this.Ie, this.hWE, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWu.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.hWx = true;
        if (this.hWp != null) {
            if (this.hWE != null && this.hWD && !this.hWp.isExistInRemote()) {
                this.hWp.a(this.mContext, this.mUri, this.Ie, this.hWE, this.hWC);
                if (this.hVU != null) {
                    this.hVU.bSW();
                }
                if (o(this.mUri) != null) {
                    this.hWu.bEj();
                }
                bTk();
                return;
            }
            if (!this.hWp.avi()) {
                ad.a(this.btE, true);
                this.hWp.setVolume(1.0f, 1.0f);
            }
            this.hWp.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.hWy != null) {
            this.hWy.onStart();
        }
        if (this.hWr != null) {
            this.hWr.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (o(this.mUri) != null && this.hWp != null) {
            this.hWu.vC(this.hWp.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bTm();
        ad.a(this.btE, false);
        if (this.hWp != null) {
            if (this.hWp.isPlaying() && bTp()) {
                y.bTR().bj(this.hWL, this.hWp.getCurrentPosition());
            }
            this.hWp.pause();
        }
        if (this.hWy != null) {
            this.hWy.onPause();
        }
        this.hWx = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWu != null) {
            this.hWu.bEm();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.hWp != null) {
            return this.hWp.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.hWp != null) {
            return this.hWp.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cNW = i;
        xl(i);
    }

    public void xl(int i) {
        if (this.hWH != null) {
            this.hWH.bTA();
        }
        if (this.hWp != null) {
            this.hWp.seekTo(i);
        }
        if (this.hWy != null) {
            this.hWy.xj(0);
            bTo();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.hWp != null) {
            return this.hWp.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.hWp != null) {
            this.hWp.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.hWC = i;
    }

    public int getRecoveryState() {
        return this.hWC;
    }

    public void setNeedRecovery(boolean z) {
        this.hWD = z;
    }

    public void setLooping(boolean z) {
        this.hWB = z;
    }

    public boolean bTn() {
        return this.hWx;
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

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.cAt = bVar;
    }

    public void setBusiness(d dVar) {
        this.hWy = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cJW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hWB = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWp != null) {
            this.hWp.aqh();
        }
        if (this.hWH != null) {
            this.hWH.bTC();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXj);
        MessageManager.getInstance().unRegisterListener(this.cJW);
        if (this.hWG != null) {
            this.hWG.clear();
        }
        if (this.hWv != null) {
            this.hWv.a(null);
            this.hWv.bEb();
        }
    }

    public g getPlayer() {
        return this.hWp;
    }

    public int getPlayerType() {
        if (this.hWp == null) {
            return -300;
        }
        return this.hWp.getPlayerType();
    }

    public void bTo() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXj);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXj, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.hVU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.hWy instanceof n) || ((n) this.hWy).bTy() == null) ? "" : ((n) this.hWy).bTy().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i o(Uri uri) {
        String uri2;
        if (this.hWu != null) {
            return this.hWu;
        }
        if (!StringUtils.isNull(this.hWJ)) {
            uri2 = this.hWJ;
        } else if (hWt != null && this.hWy != null && !StringUtils.isNull(this.hWy.bSX())) {
            uri2 = this.hWy.bSX();
        } else {
            uri2 = (hWt == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && hWt != null) {
            this.hWu = hWt.X(this.ctx, uri2, this.hWw);
        }
        this.hWw = null;
        this.hWM = 0L;
        return this.hWu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTp() {
        return this.hWp != null && this.hWp.getDuration() >= this.hWp.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.hWu, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.hWu, j);
    }

    public static boolean od(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.hWq = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.hWp != null) {
            return this.hWp.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.hWp != null ? this.hWp.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.hWu != null) {
            this.hWu.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.hWr = cVar;
    }
}
