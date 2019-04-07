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
    private static int hWQ = 0;
    private static int hWR = 1;
    private static int hWS = 2;
    private static int hWT = 1;
    private static int hWU = 0;
    private static h hWr;
    private static com.baidu.tieba.j.l hWs;
    private Map<String, String> Ie;
    private WeakReference<Context> btD;
    private g.b cAo;
    private b cAs;
    private g.a cJH;
    private g.f cJI;
    private g.c cJJ;
    private g.e cJK;
    private g.InterfaceC0369g cJL;
    private g.i cJM;
    private g.d cJN;
    private g.h cJO;
    private final CustomMessageListener cJV;
    private int cNV;
    private String ctw;
    private int hGI;
    private a hVT;
    private boolean hWA;
    private int hWB;
    private boolean hWC;
    private SurfaceTexture hWD;
    private boolean hWE;
    private com.baidu.tieba.play.b.a hWF;
    private r hWG;
    private com.baidu.tieba.play.b.f hWH;
    private String hWI;
    private String hWJ;
    private String hWK;
    private long hWL;
    private boolean hWM;
    private boolean hWN;
    private long hWO;
    private long hWP;
    private int hWV;
    private int hWW;
    private int hWX;
    private int hWY;
    private int hWZ;
    private RenderView hWm;
    private String hWn;
    private g hWo;
    private g.e hWp;
    private c hWq;
    private com.baidu.tieba.j.i hWt;
    private com.baidu.tieba.j.e hWu;
    private String hWv;
    private boolean hWw;
    private d hWx;
    private boolean hWy;
    private int hWz;
    private int hXa;
    private boolean hXb;
    private Runnable hXc;
    private Runnable hXd;
    private TextureView.SurfaceTextureListener hXe;
    private g.f hXf;
    private g.a hXg;
    private g.InterfaceC0369g hXh;
    private Runnable hXi;
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
            hWr = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            hWs = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.hWE = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.hWw = false;
        this.hWy = false;
        this.hWz = 0;
        this.hWA = false;
        this.hWB = -1;
        this.hWC = false;
        this.hWD = null;
        this.hWE = true;
        this.hWO = 0L;
        this.hWP = 0L;
        this.hGI = hWU;
        this.hWV = 0;
        this.hWW = 0;
        this.hWX = -1;
        this.hWY = 0;
        this.hWZ = 0;
        this.hXa = 0;
        this.cNV = 0;
        this.hXb = false;
        this.btD = null;
        this.hXc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWo != null && QuickVideoView.this.hWw) {
                    QuickVideoView.this.b(QuickVideoView.this.hWo, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.mt(false);
                }
            }
        };
        this.hXe = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXb) {
                    QuickVideoView.this.hXb = false;
                    QuickVideoView.this.hWo.c(surfaceTexture);
                } else if (QuickVideoView.this.hWy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWo != null && QuickVideoView.this.hWC) {
                        QuickVideoView.this.hWo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWB);
                        if (QuickVideoView.this.hVT != null) {
                            QuickVideoView.this.hVT.bSW();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWt.bEj();
                        }
                    }
                } else if (bTr()) {
                    if (QuickVideoView.this.hWo != null) {
                        QuickVideoView.this.bTk();
                        QuickVideoView.this.hWy = true;
                        QuickVideoView.this.hWo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWt.bEi();
                    }
                }
                QuickVideoView.this.hWD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXb) {
                    QuickVideoView.this.bTm();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWo != null) {
                        if (QuickVideoView.this.hWo.isPlaying() && QuickVideoView.this.bTp()) {
                            y.bTR().bj(QuickVideoView.this.hWK, QuickVideoView.this.hWo.getCurrentPosition());
                        }
                        QuickVideoView.this.hWo.release();
                    }
                    if (QuickVideoView.this.hWy) {
                        if (QuickVideoView.this.hWx != null) {
                            QuickVideoView.this.hWx.onStop();
                        }
                        if (QuickVideoView.this.cAs != null) {
                            QuickVideoView.this.cAs.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWD = null;
                    if (QuickVideoView.this.hWt != null && QuickVideoView.this.hWt.za(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.hWy = false;
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
        this.hXf = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AS;
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.onPrepared();
                }
                if (QuickVideoView.this.hWt != null && QuickVideoView.this.hWo != null) {
                    QuickVideoView.this.hWt.vB(QuickVideoView.this.hWo.getPlayerType());
                }
                if (QuickVideoView.this.cJI != null) {
                    QuickVideoView.this.cJI.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWx != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWo != null) {
                        j = QuickVideoView.this.hWo.getDuration();
                    }
                    QuickVideoView.this.hWx.dI(j);
                    QuickVideoView.this.bTl();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWx.bTd();
                        QuickVideoView.this.bTo();
                    }
                }
                if (QuickVideoView.this.hWN && (AS = y.bTR().AS(QuickVideoView.this.hWK)) > 0) {
                    if (QuickVideoView.this.hWo.isPlayerReuse()) {
                        if (QuickVideoView.this.hWo.getCurrentPosition() == 0) {
                            QuickVideoView.this.xl(AS);
                        }
                    } else {
                        QuickVideoView.this.xl(AS);
                    }
                }
                if (QuickVideoView.this.hWw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWm != null && gVar != null) {
                    QuickVideoView.this.hWm.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWn) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWn);
                }
                if (QuickVideoView.this.hWF != null && QuickVideoView.this.hWF.bUn()) {
                    com.baidu.tieba.play.b.e.xs(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXg = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.yZ(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWt = null;
                }
                if (!QuickVideoView.this.hWA || QuickVideoView.this.hWx == null) {
                    if (QuickVideoView.this.hWx != null) {
                        QuickVideoView.this.hWx.onCompletion();
                    }
                    QuickVideoView.this.hWw = false;
                    y.bTR().remove(QuickVideoView.this.hWK);
                    if (QuickVideoView.this.cJH != null) {
                        QuickVideoView.this.cJH.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWv = null;
                QuickVideoView.this.hWL = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWx.bSX());
                QuickVideoView.this.start();
            }
        };
        this.cJJ = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWx != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTp()) {
                    QuickVideoView.this.hWM = true;
                    y.bTR().bj(QuickVideoView.this.hWK, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWt != null) {
                        QuickVideoView.this.hWv = QuickVideoView.this.hWt.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWL, QuickVideoView.this.Z(QuickVideoView.this.hWt.bEn(), i3 + "", QuickVideoView.this.hWt.bEo()));
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.hWL = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAo == null || QuickVideoView.this.cAo.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXh = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hWM) {
                    QuickVideoView.this.hWM = false;
                    return;
                }
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.bTB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWx != null && z) {
                    QuickVideoView.this.hWx.onSeekComplete();
                }
                if (QuickVideoView.this.cJL != null) {
                    QuickVideoView.this.cJL.b(gVar);
                }
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWp != null) {
                    QuickVideoView.this.hWp.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWz = i2;
                    if (QuickVideoView.this.hWm != null && gVar != null) {
                        QuickVideoView.this.hWm.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWz);
                    }
                }
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.a(i, i2, QuickVideoView.this.hWt);
                    return true;
                }
                return true;
            }
        };
        this.cJM = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.h(i, i2, str);
                }
            }
        };
        this.cJN = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.zb(str);
                }
            }
        };
        this.cJO = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWL = j;
                }
            }
        };
        this.hXi = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWx != null && QuickVideoView.this.hWx.bSZ() && QuickVideoView.this.hWx.bTa() && QuickVideoView.this.hWx.bTb() && QuickVideoView.this.hWo != null) {
                    int avh = QuickVideoView.this.hWo.avh();
                    int currentPosition = QuickVideoView.this.hWo.getCurrentPosition();
                    int duration = QuickVideoView.this.hWo.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hWO;
                    boolean z = currentPosition + avh < duration;
                    if (avh < QuickVideoView.this.hWx.bTc() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hWO = currentTimeMillis;
                        QuickVideoView.this.hWx.xj(0);
                    }
                    if (QuickVideoView.this.bTn() && currentPosition == QuickVideoView.this.hWP && j > 500) {
                        QuickVideoView.this.hWO = currentTimeMillis;
                        QuickVideoView.this.hWx.xj(0);
                    }
                    QuickVideoView.this.hWP = currentPosition;
                    if (QuickVideoView.this.hGI == QuickVideoView.hWT) {
                        QuickVideoView.this.bTo();
                    }
                }
            }
        };
        this.cJV = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWx != null) {
                        QuickVideoView.this.hWx.bTf();
                    }
                    if (QuickVideoView.this.hWt != null) {
                        QuickVideoView.this.hWt.yY(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.bTm();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWw = false;
        this.hWy = false;
        this.hWz = 0;
        this.hWA = false;
        this.hWB = -1;
        this.hWC = false;
        this.hWD = null;
        this.hWE = true;
        this.hWO = 0L;
        this.hWP = 0L;
        this.hGI = hWU;
        this.hWV = 0;
        this.hWW = 0;
        this.hWX = -1;
        this.hWY = 0;
        this.hWZ = 0;
        this.hXa = 0;
        this.cNV = 0;
        this.hXb = false;
        this.btD = null;
        this.hXc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWo != null && QuickVideoView.this.hWw) {
                    QuickVideoView.this.b(QuickVideoView.this.hWo, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.mt(false);
                }
            }
        };
        this.hXe = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXb) {
                    QuickVideoView.this.hXb = false;
                    QuickVideoView.this.hWo.c(surfaceTexture);
                } else if (QuickVideoView.this.hWy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWo != null && QuickVideoView.this.hWC) {
                        QuickVideoView.this.hWo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWB);
                        if (QuickVideoView.this.hVT != null) {
                            QuickVideoView.this.hVT.bSW();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWt.bEj();
                        }
                    }
                } else if (bTr()) {
                    if (QuickVideoView.this.hWo != null) {
                        QuickVideoView.this.bTk();
                        QuickVideoView.this.hWy = true;
                        QuickVideoView.this.hWo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWt.bEi();
                    }
                }
                QuickVideoView.this.hWD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXb) {
                    QuickVideoView.this.bTm();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWo != null) {
                        if (QuickVideoView.this.hWo.isPlaying() && QuickVideoView.this.bTp()) {
                            y.bTR().bj(QuickVideoView.this.hWK, QuickVideoView.this.hWo.getCurrentPosition());
                        }
                        QuickVideoView.this.hWo.release();
                    }
                    if (QuickVideoView.this.hWy) {
                        if (QuickVideoView.this.hWx != null) {
                            QuickVideoView.this.hWx.onStop();
                        }
                        if (QuickVideoView.this.cAs != null) {
                            QuickVideoView.this.cAs.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWD = null;
                    if (QuickVideoView.this.hWt != null && QuickVideoView.this.hWt.za(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.hWy = false;
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
        this.hXf = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AS;
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.onPrepared();
                }
                if (QuickVideoView.this.hWt != null && QuickVideoView.this.hWo != null) {
                    QuickVideoView.this.hWt.vB(QuickVideoView.this.hWo.getPlayerType());
                }
                if (QuickVideoView.this.cJI != null) {
                    QuickVideoView.this.cJI.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWx != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWo != null) {
                        j = QuickVideoView.this.hWo.getDuration();
                    }
                    QuickVideoView.this.hWx.dI(j);
                    QuickVideoView.this.bTl();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWx.bTd();
                        QuickVideoView.this.bTo();
                    }
                }
                if (QuickVideoView.this.hWN && (AS = y.bTR().AS(QuickVideoView.this.hWK)) > 0) {
                    if (QuickVideoView.this.hWo.isPlayerReuse()) {
                        if (QuickVideoView.this.hWo.getCurrentPosition() == 0) {
                            QuickVideoView.this.xl(AS);
                        }
                    } else {
                        QuickVideoView.this.xl(AS);
                    }
                }
                if (QuickVideoView.this.hWw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWm != null && gVar != null) {
                    QuickVideoView.this.hWm.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWn) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWn);
                }
                if (QuickVideoView.this.hWF != null && QuickVideoView.this.hWF.bUn()) {
                    com.baidu.tieba.play.b.e.xs(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXg = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.yZ(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWt = null;
                }
                if (!QuickVideoView.this.hWA || QuickVideoView.this.hWx == null) {
                    if (QuickVideoView.this.hWx != null) {
                        QuickVideoView.this.hWx.onCompletion();
                    }
                    QuickVideoView.this.hWw = false;
                    y.bTR().remove(QuickVideoView.this.hWK);
                    if (QuickVideoView.this.cJH != null) {
                        QuickVideoView.this.cJH.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWv = null;
                QuickVideoView.this.hWL = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWx.bSX());
                QuickVideoView.this.start();
            }
        };
        this.cJJ = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWx != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTp()) {
                    QuickVideoView.this.hWM = true;
                    y.bTR().bj(QuickVideoView.this.hWK, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWt != null) {
                        QuickVideoView.this.hWv = QuickVideoView.this.hWt.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWL, QuickVideoView.this.Z(QuickVideoView.this.hWt.bEn(), i3 + "", QuickVideoView.this.hWt.bEo()));
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.hWL = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAo == null || QuickVideoView.this.cAo.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXh = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hWM) {
                    QuickVideoView.this.hWM = false;
                    return;
                }
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.bTB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWx != null && z) {
                    QuickVideoView.this.hWx.onSeekComplete();
                }
                if (QuickVideoView.this.cJL != null) {
                    QuickVideoView.this.cJL.b(gVar);
                }
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWp != null) {
                    QuickVideoView.this.hWp.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWz = i2;
                    if (QuickVideoView.this.hWm != null && gVar != null) {
                        QuickVideoView.this.hWm.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWz);
                    }
                }
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.a(i, i2, QuickVideoView.this.hWt);
                    return true;
                }
                return true;
            }
        };
        this.cJM = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.h(i, i2, str);
                }
            }
        };
        this.cJN = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.zb(str);
                }
            }
        };
        this.cJO = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWL = j;
                }
            }
        };
        this.hXi = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWx != null && QuickVideoView.this.hWx.bSZ() && QuickVideoView.this.hWx.bTa() && QuickVideoView.this.hWx.bTb() && QuickVideoView.this.hWo != null) {
                    int avh = QuickVideoView.this.hWo.avh();
                    int currentPosition = QuickVideoView.this.hWo.getCurrentPosition();
                    int duration = QuickVideoView.this.hWo.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hWO;
                    boolean z = currentPosition + avh < duration;
                    if (avh < QuickVideoView.this.hWx.bTc() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hWO = currentTimeMillis;
                        QuickVideoView.this.hWx.xj(0);
                    }
                    if (QuickVideoView.this.bTn() && currentPosition == QuickVideoView.this.hWP && j > 500) {
                        QuickVideoView.this.hWO = currentTimeMillis;
                        QuickVideoView.this.hWx.xj(0);
                    }
                    QuickVideoView.this.hWP = currentPosition;
                    if (QuickVideoView.this.hGI == QuickVideoView.hWT) {
                        QuickVideoView.this.bTo();
                    }
                }
            }
        };
        this.cJV = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWx != null) {
                        QuickVideoView.this.hWx.bTf();
                    }
                    if (QuickVideoView.this.hWt != null) {
                        QuickVideoView.this.hWt.yY(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.bTm();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWw = false;
        this.hWy = false;
        this.hWz = 0;
        this.hWA = false;
        this.hWB = -1;
        this.hWC = false;
        this.hWD = null;
        this.hWE = true;
        this.hWO = 0L;
        this.hWP = 0L;
        this.hGI = hWU;
        this.hWV = 0;
        this.hWW = 0;
        this.hWX = -1;
        this.hWY = 0;
        this.hWZ = 0;
        this.hXa = 0;
        this.cNV = 0;
        this.hXb = false;
        this.btD = null;
        this.hXc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWo != null && QuickVideoView.this.hWw) {
                    QuickVideoView.this.b(QuickVideoView.this.hWo, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.mt(false);
                }
            }
        };
        this.hXe = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.hXb) {
                    QuickVideoView.this.hXb = false;
                    QuickVideoView.this.hWo.c(surfaceTexture);
                } else if (QuickVideoView.this.hWy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWo != null && QuickVideoView.this.hWC) {
                        QuickVideoView.this.hWo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWB);
                        if (QuickVideoView.this.hVT != null) {
                            QuickVideoView.this.hVT.bSW();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWt.bEj();
                        }
                    }
                } else if (bTr()) {
                    if (QuickVideoView.this.hWo != null) {
                        QuickVideoView.this.bTk();
                        QuickVideoView.this.hWy = true;
                        QuickVideoView.this.hWo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWt.bEi();
                    }
                }
                QuickVideoView.this.hWD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXb) {
                    QuickVideoView.this.bTm();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWo != null) {
                        if (QuickVideoView.this.hWo.isPlaying() && QuickVideoView.this.bTp()) {
                            y.bTR().bj(QuickVideoView.this.hWK, QuickVideoView.this.hWo.getCurrentPosition());
                        }
                        QuickVideoView.this.hWo.release();
                    }
                    if (QuickVideoView.this.hWy) {
                        if (QuickVideoView.this.hWx != null) {
                            QuickVideoView.this.hWx.onStop();
                        }
                        if (QuickVideoView.this.cAs != null) {
                            QuickVideoView.this.cAs.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWD = null;
                    if (QuickVideoView.this.hWt != null && QuickVideoView.this.hWt.za(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.hWy = false;
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
        this.hXf = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AS;
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.onPrepared();
                }
                if (QuickVideoView.this.hWt != null && QuickVideoView.this.hWo != null) {
                    QuickVideoView.this.hWt.vB(QuickVideoView.this.hWo.getPlayerType());
                }
                if (QuickVideoView.this.cJI != null) {
                    QuickVideoView.this.cJI.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWx != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWo != null) {
                        j = QuickVideoView.this.hWo.getDuration();
                    }
                    QuickVideoView.this.hWx.dI(j);
                    QuickVideoView.this.bTl();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWx.bTd();
                        QuickVideoView.this.bTo();
                    }
                }
                if (QuickVideoView.this.hWN && (AS = y.bTR().AS(QuickVideoView.this.hWK)) > 0) {
                    if (QuickVideoView.this.hWo.isPlayerReuse()) {
                        if (QuickVideoView.this.hWo.getCurrentPosition() == 0) {
                            QuickVideoView.this.xl(AS);
                        }
                    } else {
                        QuickVideoView.this.xl(AS);
                    }
                }
                if (QuickVideoView.this.hWw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWm != null && gVar != null) {
                    QuickVideoView.this.hWm.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWn) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWn);
                }
                if (QuickVideoView.this.hWF != null && QuickVideoView.this.hWF.bUn()) {
                    com.baidu.tieba.play.b.e.xs(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXg = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.yZ(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWt = null;
                }
                if (!QuickVideoView.this.hWA || QuickVideoView.this.hWx == null) {
                    if (QuickVideoView.this.hWx != null) {
                        QuickVideoView.this.hWx.onCompletion();
                    }
                    QuickVideoView.this.hWw = false;
                    y.bTR().remove(QuickVideoView.this.hWK);
                    if (QuickVideoView.this.cJH != null) {
                        QuickVideoView.this.cJH.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWv = null;
                QuickVideoView.this.hWL = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWx.bSX());
                QuickVideoView.this.start();
            }
        };
        this.cJJ = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ac(i2, i22, i3);
                QuickVideoView.this.bTm();
                if (QuickVideoView.this.hWx != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTp()) {
                    QuickVideoView.this.hWM = true;
                    y.bTR().bj(QuickVideoView.this.hWK, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWt != null) {
                        QuickVideoView.this.hWv = QuickVideoView.this.hWt.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWL, QuickVideoView.this.Z(QuickVideoView.this.hWt.bEn(), i3 + "", QuickVideoView.this.hWt.bEo()));
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.hWL = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.xq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAo == null || QuickVideoView.this.cAo.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.hXh = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hWM) {
                    QuickVideoView.this.hWM = false;
                    return;
                }
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.bTB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWx != null && z) {
                    QuickVideoView.this.hWx.onSeekComplete();
                }
                if (QuickVideoView.this.cJL != null) {
                    QuickVideoView.this.cJL.b(gVar);
                }
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.hWp != null) {
                    QuickVideoView.this.hWp.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.hWz = i22;
                    if (QuickVideoView.this.hWm != null && gVar != null) {
                        QuickVideoView.this.hWm.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWz);
                    }
                }
                if (QuickVideoView.this.hWG != null) {
                    QuickVideoView.this.hWG.a(i2, i22, QuickVideoView.this.hWt);
                    return true;
                }
                return true;
            }
        };
        this.cJM = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.h(i2, i22, str);
                }
            }
        };
        this.cJN = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWt != null) {
                    QuickVideoView.this.hWt.zb(str);
                }
            }
        };
        this.cJO = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWL = j;
                }
            }
        };
        this.hXi = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWx != null && QuickVideoView.this.hWx.bSZ() && QuickVideoView.this.hWx.bTa() && QuickVideoView.this.hWx.bTb() && QuickVideoView.this.hWo != null) {
                    int avh = QuickVideoView.this.hWo.avh();
                    int currentPosition = QuickVideoView.this.hWo.getCurrentPosition();
                    int duration = QuickVideoView.this.hWo.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hWO;
                    boolean z = currentPosition + avh < duration;
                    if (avh < QuickVideoView.this.hWx.bTc() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hWO = currentTimeMillis;
                        QuickVideoView.this.hWx.xj(0);
                    }
                    if (QuickVideoView.this.bTn() && currentPosition == QuickVideoView.this.hWP && j > 500) {
                        QuickVideoView.this.hWO = currentTimeMillis;
                        QuickVideoView.this.hWx.xj(0);
                    }
                    QuickVideoView.this.hWP = currentPosition;
                    if (QuickVideoView.this.hGI == QuickVideoView.hWT) {
                        QuickVideoView.this.bTo();
                    }
                }
            }
        };
        this.cJV = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWx != null) {
                        QuickVideoView.this.hWx.bTf();
                    }
                    if (QuickVideoView.this.hWt != null) {
                        QuickVideoView.this.hWt.yY(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWt = null;
                    }
                    QuickVideoView.this.bTm();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.hWm = new RenderView(context);
        this.btD = new WeakReference<>(TbadkCoreApplication.getInst());
        this.hWm.setSurfaceTextureListener(this.hXe);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.hWE) {
            addView(this.hWm, layoutParams);
        } else {
            addView(this.hWm, 0, layoutParams);
        }
        if (hWr != null) {
            this.hWo = hWr.avj();
        }
        if (this.hWo != null) {
            this.hWo.setOnPreparedListener(this.hXf);
            this.hWo.setOnCompletionListener(this.hXg);
            this.hWo.a(this.cJJ);
            this.hWo.setOnSeekCompleteListener(this.hXh);
            this.hWo.a(this.cJK);
            this.hWo.a(this.cJM);
            this.hWo.a(this.cJN);
            this.hWo.a(this.cJO);
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
        this.hWF = new com.baidu.tieba.play.b.a(this);
        this.hWG = new r();
        this.hWH = new com.baidu.tieba.play.b.f();
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
        this.hWN = z;
    }

    public void setVideoPath(String str, String str2) {
        this.ctw = str2;
        if (this.hWF != null) {
            this.hWF.clear();
            this.hWF.bUn();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.AX(str2);
            if (hWs != null) {
                this.hWt = hWs.X(this.ctw, str, "");
                if (this.hWt != null) {
                    this.hWt.a(-300, -44399, -44399, getLocateSource(), false, this.hWL, "");
                    this.hWt = null;
                }
            }
        }
        if (this.hWu != null) {
            this.hWu.a(null);
            this.hWu.bEb();
            this.hWu = null;
        }
        this.hWv = null;
        this.hWL = 0L;
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
            this.hWI = AO;
            if (this.hWx != null) {
                AO = this.hWx.qC(AO);
                if (this.hWx.bTe() != null) {
                    this.hWx.bTe().setPlayer(this);
                }
                if (hWs != null && od(AO)) {
                    this.hWu = hWs.ze(AO);
                }
                if (this.hWu != null) {
                    this.hWu.a(new com.baidu.tieba.play.monitor.a(this.ctw, this.hWI, this.hWt));
                    this.hWu.bEa();
                }
                AP(AO);
            }
            if (!com.baidu.adp.lib.util.j.kY() && !od(AO)) {
                if (this.cAo != null) {
                    this.cAo.onError(this.hWo, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(AO));
            if (this.hWt != null) {
                if (o(Uri.parse(AO)) != null) {
                    this.hWt.bEh();
                }
                this.hWt.Ko();
                this.hWt = null;
            }
            this.hWJ = str;
            int lastIndexOf = this.hWJ.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.hWJ.length() > 4) {
                this.hWK = this.hWJ.substring(0, lastIndexOf + 4);
            } else {
                this.hWK = this.hWJ;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTk() {
        if (com.baidu.tbadk.coreExtra.model.f.ajD()) {
            if (this.hWx != null && (this.hWx.bSY() || this.hWx.bSZ())) {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXc);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hXc, com.baidu.tbadk.coreExtra.model.f.ajC());
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXd);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXd, com.baidu.tbadk.coreExtra.model.f.ajB());
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
            this.hWt.yX(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            avd();
        }
        this.mUri = uri;
        this.Ie = map;
        this.hWz = 0;
        if (this.hWD != null) {
            bTk();
            if (this.hWo != null) {
                if (!this.hWy) {
                    this.hWy = true;
                    this.hWo.a(this.mContext, this.mUri, this.Ie, this.hWD, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.hXf.onPrepared(this.hWo);
                }
            }
        } else if (this.hWm != null && this.hWm.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.hWE) {
                addView(this.hWm, layoutParams);
            } else {
                addView(this.hWm, 0, layoutParams);
            }
        }
        al.k(this, d.C0277d.cp_bg_line_k);
    }

    private void avd() {
        this.hWy = false;
        this.hWw = false;
        if (this.hWo != null) {
            if (this.hWo.isPlaying() && bTp()) {
                y.bTR().bj(this.hWK, this.hWo.getCurrentPosition());
            }
            this.hWo.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXi);
    }

    private void AP(String str) {
        this.hWW = 0;
        this.hWX = 0;
        this.hWY = 0;
        this.hWZ = 0;
        this.hXa = 0;
        this.cNV = 0;
        if (this.hWx.bSZ()) {
            this.hWV = hWR;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.hWX = (int) u.AR(QuickVideoView.this.hWI);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.hWI != null && this.hWI.equals(str)) {
            this.hWV = hWQ;
        } else {
            this.hWV = hWS;
        }
        this.hGI = hWT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTl() {
        this.hGI = hWT;
        if (this.hWo != null) {
            this.hWW = this.hWo.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
        if (this.hGI == hWT && this.hWo != null) {
            this.hGI = hWU;
            this.hWZ = this.hWo.getDuration();
            if (z) {
                this.hXa = 0;
                this.hWY = this.hWZ;
            } else {
                this.hWY = this.hWo.getCurrentPosition();
                this.hXa = this.hWo.getCachedSize();
            }
            if (this.hWY > 0) {
                if (this.hWV == hWQ) {
                    this.hWX = (int) u.AR(this.hWI);
                    if (this.hWW > 0) {
                        long j = (this.hWW * (this.hWY / 1000)) / 8;
                        if (this.hXa < 0) {
                            this.hXa = 0;
                        }
                        long j2 = this.hXa + j;
                        if (this.hWX > 0) {
                            j2 += this.hWX;
                        }
                        setFlowCount(j2, this.hWY, this.hWZ, this.cNV);
                    } else if (this.hWW == -1) {
                        this.hWW = 603327;
                        setFlowCount((this.hWW * (this.hWY / 1000)) / 8, this.hWY, this.hWZ, this.cNV);
                    }
                } else if (this.hWV == hWR) {
                    if (this.hWW > 0) {
                        long j3 = (this.hWW * (this.hWY / 1000)) / 8;
                        if (this.hXa < 0) {
                            this.hXa = 0;
                        }
                        long j4 = this.hXa + j3;
                        if (this.hWX > 0) {
                            j4 -= this.hWX;
                        }
                        setFlowCount(j4, this.hWY, this.hWZ, this.cNV);
                    } else if (this.hWW == -1) {
                        this.hWW = 603327;
                        setFlowCount((this.hWW * (this.hWY / 1000)) / 8, this.hWY, this.hWZ, this.cNV);
                    }
                } else {
                    setFlowCount(0L, this.hWY, this.hWZ, this.cNV);
                }
            }
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXi);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.btD, false);
        }
        bTm();
        pb(false);
        if (this.hWF != null) {
            this.hWF.clear();
        }
        this.hWn = null;
        avd();
        this.hWA = false;
        if (this.hWx != null) {
            this.hWx.onStop();
        }
        com.baidu.tieba.play.a.b.bTU().a((b.InterfaceC0366b) null);
        if (this.hWt != null && this.hWt.za(getLocateSource())) {
            this.hWt = null;
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXi);
    }

    public void setFullScreenToDestroySurface() {
        this.hXb = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTm() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXc);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXd);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cJI = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cJH = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cAo = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0369g interfaceC0369g) {
        this.cJL = interfaceC0369g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.hWH == null) {
            return "";
        }
        String bUp = this.hWH.bUp();
        this.hWH.aa(str, str2, str3);
        return bUp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.hWx != null && !StringUtils.isNull(this.hWx.bSX())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.AW(uri);
                }
            }
            this.mUri = Uri.parse(this.hWx.bSX());
        }
        boolean z = false;
        if (this.hWF != null) {
            z = this.hWF.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.hWt != null) {
            this.hWv = this.hWt.a(i, i2, i3, getLocateSource(), z, this.hWL, Z(this.hWt.bEn(), i3 + "", this.hWt.bEo()));
            this.hWt = null;
        }
        this.hWL = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.hWo != null) {
            try {
                if (this.hWo.isPlaying() && bTp()) {
                    y.bTR().bj(this.hWK, this.hWo.getCurrentPosition());
                }
                this.hWo.release();
                this.hWn = str;
                URI uri = new URI(this.mUri.toString());
                this.hWo.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Ie, this.hWD, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (o(this.mUri) != null) {
                    this.hWt.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWo != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.hWo.isPlaying() && bTp()) {
                y.bTR().bj(this.hWK, this.hWo.getCurrentPosition());
            }
            this.hWo.release();
            this.hWo.a(this.mContext, this.mUri, this.Ie, this.hWD, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWt.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWo != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.hWo.forceUseSystemMediaPlayer(true);
            }
            if (this.hWo.isPlaying() && bTp()) {
                y.bTR().bj(this.hWK, this.hWo.getCurrentPosition());
            }
            this.hWo.release();
            this.hWo.a(this.mContext, this.mUri, this.Ie, this.hWD, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWt.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.hWw = true;
        if (this.hWo != null) {
            if (this.hWD != null && this.hWC && !this.hWo.isExistInRemote()) {
                this.hWo.a(this.mContext, this.mUri, this.Ie, this.hWD, this.hWB);
                if (this.hVT != null) {
                    this.hVT.bSW();
                }
                if (o(this.mUri) != null) {
                    this.hWt.bEj();
                }
                bTk();
                return;
            }
            if (!this.hWo.avi()) {
                ad.a(this.btD, true);
                this.hWo.setVolume(1.0f, 1.0f);
            }
            this.hWo.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.hWx != null) {
            this.hWx.onStart();
        }
        if (this.hWq != null) {
            this.hWq.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (o(this.mUri) != null && this.hWo != null) {
            this.hWt.vC(this.hWo.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bTm();
        ad.a(this.btD, false);
        if (this.hWo != null) {
            if (this.hWo.isPlaying() && bTp()) {
                y.bTR().bj(this.hWK, this.hWo.getCurrentPosition());
            }
            this.hWo.pause();
        }
        if (this.hWx != null) {
            this.hWx.onPause();
        }
        this.hWw = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWt != null) {
            this.hWt.bEm();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.hWo != null) {
            return this.hWo.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.hWo != null) {
            return this.hWo.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cNV = i;
        xl(i);
    }

    public void xl(int i) {
        if (this.hWG != null) {
            this.hWG.bTA();
        }
        if (this.hWo != null) {
            this.hWo.seekTo(i);
        }
        if (this.hWx != null) {
            this.hWx.xj(0);
            bTo();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.hWo != null) {
            return this.hWo.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.hWo != null) {
            this.hWo.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.hWB = i;
    }

    public int getRecoveryState() {
        return this.hWB;
    }

    public void setNeedRecovery(boolean z) {
        this.hWC = z;
    }

    public void setLooping(boolean z) {
        this.hWA = z;
    }

    public boolean bTn() {
        return this.hWw;
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
        this.cAs = bVar;
    }

    public void setBusiness(d dVar) {
        this.hWx = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cJV);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hWA = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWo != null) {
            this.hWo.aqh();
        }
        if (this.hWG != null) {
            this.hWG.bTC();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXi);
        MessageManager.getInstance().unRegisterListener(this.cJV);
        if (this.hWF != null) {
            this.hWF.clear();
        }
        if (this.hWu != null) {
            this.hWu.a(null);
            this.hWu.bEb();
        }
    }

    public g getPlayer() {
        return this.hWo;
    }

    public int getPlayerType() {
        if (this.hWo == null) {
            return -300;
        }
        return this.hWo.getPlayerType();
    }

    public void bTo() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXi);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXi, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.hVT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.hWx instanceof n) || ((n) this.hWx).bTy() == null) ? "" : ((n) this.hWx).bTy().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i o(Uri uri) {
        String uri2;
        if (this.hWt != null) {
            return this.hWt;
        }
        if (!StringUtils.isNull(this.hWI)) {
            uri2 = this.hWI;
        } else if (hWs != null && this.hWx != null && !StringUtils.isNull(this.hWx.bSX())) {
            uri2 = this.hWx.bSX();
        } else {
            uri2 = (hWs == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && hWs != null) {
            this.hWt = hWs.X(this.ctw, uri2, this.hWv);
        }
        this.hWv = null;
        this.hWL = 0L;
        return this.hWt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTp() {
        return this.hWo != null && this.hWo.getDuration() >= this.hWo.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.hWt, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.hWt, j);
    }

    public static boolean od(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.hWp = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.hWo != null) {
            return this.hWo.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.hWo != null ? this.hWo.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.hWt != null) {
            this.hWt.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.hWq = cVar;
    }
}
