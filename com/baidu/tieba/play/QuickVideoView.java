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
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.ng.ai.apps.trace.ReportLevel;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static h gGC;
    private static com.baidu.tieba.j.l gGD;
    private static int gHb = 0;
    private static int gHc = 1;
    private static int gHd = 2;
    private static int gHe = 1;
    private static int gHf = 0;
    private int bCO;
    private String bjm;
    private g.b bpN;
    private b bpR;
    private g.f byA;
    private g.c byB;
    private g.e byC;
    private g.InterfaceC0298g byD;
    private g.i byE;
    private g.d byF;
    private g.h byG;
    private final CustomMessageListener byM;
    private g.a byz;
    private g.e gGA;
    private c gGB;
    private com.baidu.tieba.j.i gGE;
    private com.baidu.tieba.j.e gGF;
    private String gGG;
    private boolean gGH;
    private d gGI;
    private boolean gGJ;
    private int gGK;
    private boolean gGL;
    private int gGM;
    private boolean gGN;
    private SurfaceTexture gGO;
    private boolean gGP;
    private com.baidu.tieba.play.b.a gGQ;
    private r gGR;
    private com.baidu.tieba.play.b.f gGS;
    private String gGT;
    private String gGU;
    private String gGV;
    private long gGW;
    private boolean gGX;
    private boolean gGY;
    private long gGZ;
    private a gGf;
    private RenderView gGx;
    private String gGy;
    private g gGz;
    private long gHa;
    private int gHg;
    private int gHh;
    private int gHi;
    private int gHj;
    private int gHk;
    private int gHl;
    private boolean gHm;
    private Runnable gHn;
    private Runnable gHo;
    private TextureView.SurfaceTextureListener gHp;
    private g.f gHq;
    private g.a gHr;
    private g.InterfaceC0298g gHs;
    private Runnable gHt;
    private int gqK;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bsD();
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
            gGC = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gGD = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gGP = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gGH = false;
        this.gGJ = false;
        this.gGK = 0;
        this.gGL = false;
        this.gGM = -1;
        this.gGN = false;
        this.gGO = null;
        this.gGP = true;
        this.gGZ = 0L;
        this.gHa = 0L;
        this.gqK = gHf;
        this.gHg = 0;
        this.gHh = 0;
        this.gHi = -1;
        this.gHj = 0;
        this.gHk = 0;
        this.gHl = 0;
        this.bCO = 0;
        this.gHm = false;
        this.gHn = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGz != null && QuickVideoView.this.gGH) {
                    QuickVideoView.this.b(QuickVideoView.this.gGz, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gHo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.jS(false);
                }
            }
        };
        this.gHp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gHm) {
                    QuickVideoView.this.gHm = false;
                    QuickVideoView.this.gGz.c(surfaceTexture);
                } else if (QuickVideoView.this.gGJ || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gGz != null && QuickVideoView.this.gGN) {
                        QuickVideoView.this.gGz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gGM);
                        if (QuickVideoView.this.gGf != null) {
                            QuickVideoView.this.gGf.bsD();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gGE.bdJ();
                        }
                    }
                } else if (bsX()) {
                    if (QuickVideoView.this.gGz != null) {
                        QuickVideoView.this.bsQ();
                        QuickVideoView.this.gGJ = true;
                        QuickVideoView.this.gGz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gGE.bdI();
                    }
                }
                QuickVideoView.this.gGO = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gHm) {
                    QuickVideoView.this.bsS();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gGz != null) {
                        if (QuickVideoView.this.gGz.isPlaying() && QuickVideoView.this.bsV()) {
                            y.btx().aO(QuickVideoView.this.gGV, QuickVideoView.this.gGz.getCurrentPosition());
                        }
                        QuickVideoView.this.gGz.release();
                    }
                    if (QuickVideoView.this.gGJ) {
                        if (QuickVideoView.this.gGI != null) {
                            QuickVideoView.this.gGI.onStop();
                        }
                        if (QuickVideoView.this.bpR != null) {
                            QuickVideoView.this.bpR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gGO = null;
                    if (QuickVideoView.this.gGE != null && QuickVideoView.this.gGE.sz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.gGJ = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bsX() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gHq = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int up;
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.onPrepared();
                }
                if (QuickVideoView.this.gGE != null && QuickVideoView.this.gGz != null) {
                    QuickVideoView.this.gGE.rW(QuickVideoView.this.gGz.getPlayerType());
                }
                if (QuickVideoView.this.byA != null) {
                    QuickVideoView.this.byA.onPrepared(gVar);
                }
                if (QuickVideoView.this.gGI != null) {
                    long j = 0;
                    if (QuickVideoView.this.gGz != null) {
                        j = QuickVideoView.this.gGz.getDuration();
                    }
                    QuickVideoView.this.gGI.dd(j);
                    QuickVideoView.this.bsR();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gGI.bsK();
                        QuickVideoView.this.bsU();
                    }
                }
                if (QuickVideoView.this.gGY && (up = y.btx().up(QuickVideoView.this.gGV)) > 0) {
                    if (QuickVideoView.this.gGz.isPlayerReuse()) {
                        if (QuickVideoView.this.gGz.getCurrentPosition() == 0) {
                            QuickVideoView.this.tF(up);
                        }
                    } else {
                        QuickVideoView.this.tF(up);
                    }
                }
                if (QuickVideoView.this.gGH) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gGx != null && gVar != null) {
                    QuickVideoView.this.gGx.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGK);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gGy) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gGy);
                }
                if (QuickVideoView.this.gGQ != null && QuickVideoView.this.gGQ.btD()) {
                    com.baidu.tieba.play.b.e.tJ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gHr = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.sy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gGE = null;
                }
                if (!QuickVideoView.this.gGL || QuickVideoView.this.gGI == null) {
                    if (QuickVideoView.this.gGI != null) {
                        QuickVideoView.this.gGI.onCompletion();
                    }
                    QuickVideoView.this.gGH = false;
                    y.btx().remove(QuickVideoView.this.gGV);
                    if (QuickVideoView.this.byz != null) {
                        QuickVideoView.this.byz.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gGG = null;
                QuickVideoView.this.gGW = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gGI.bsE());
                QuickVideoView.this.start();
            }
        };
        this.byB = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGI != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsV()) {
                    QuickVideoView.this.gGX = true;
                    y.btx().aO(QuickVideoView.this.gGV, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gGE != null) {
                        QuickVideoView.this.gGG = QuickVideoView.this.gGE.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gGW, QuickVideoView.this.N(QuickVideoView.this.gGE.bdN(), i3 + "", QuickVideoView.this.gGE.bdO()));
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.gGW = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tH(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tI(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bpN == null || QuickVideoView.this.bpN.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gHs = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gGX) {
                    QuickVideoView.this.gGX = false;
                    return;
                }
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.bth();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gGI != null && z) {
                    QuickVideoView.this.gGI.onSeekComplete();
                }
                if (QuickVideoView.this.byD != null) {
                    QuickVideoView.this.byD.b(gVar);
                }
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gGA != null) {
                    QuickVideoView.this.gGA.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gGK = i2;
                    if (QuickVideoView.this.gGx != null && gVar != null) {
                        QuickVideoView.this.gGx.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGK);
                    }
                }
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.a(i, i2, QuickVideoView.this.gGE);
                    return true;
                }
                return true;
            }
        };
        this.byE = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.f(i, i2, str);
                }
            }
        };
        this.byF = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.sA(str);
                }
            }
        };
        this.byG = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gGW = j;
                }
            }
        };
        this.gHt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gGI != null && QuickVideoView.this.gGI.bsG() && QuickVideoView.this.gGI.bsH() && QuickVideoView.this.gGI.bsI() && QuickVideoView.this.gGz != null) {
                    int Vl = QuickVideoView.this.gGz.Vl();
                    int currentPosition = QuickVideoView.this.gGz.getCurrentPosition();
                    int duration = QuickVideoView.this.gGz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gGZ;
                    boolean z = currentPosition + Vl < duration;
                    if (Vl < QuickVideoView.this.gGI.bsJ() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gGZ = currentTimeMillis;
                        QuickVideoView.this.gGI.tE(0);
                    }
                    if (QuickVideoView.this.bsT() && currentPosition == QuickVideoView.this.gHa && j > 500) {
                        QuickVideoView.this.gGZ = currentTimeMillis;
                        QuickVideoView.this.gGI.tE(0);
                    }
                    QuickVideoView.this.gHa = currentPosition;
                    if (QuickVideoView.this.gqK == QuickVideoView.gHe) {
                        QuickVideoView.this.bsU();
                    }
                }
            }
        };
        this.byM = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gGI != null) {
                        QuickVideoView.this.gGI.bsM();
                    }
                    if (QuickVideoView.this.gGE != null) {
                        QuickVideoView.this.gGE.sx(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.bsS();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gGH = false;
        this.gGJ = false;
        this.gGK = 0;
        this.gGL = false;
        this.gGM = -1;
        this.gGN = false;
        this.gGO = null;
        this.gGP = true;
        this.gGZ = 0L;
        this.gHa = 0L;
        this.gqK = gHf;
        this.gHg = 0;
        this.gHh = 0;
        this.gHi = -1;
        this.gHj = 0;
        this.gHk = 0;
        this.gHl = 0;
        this.bCO = 0;
        this.gHm = false;
        this.gHn = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGz != null && QuickVideoView.this.gGH) {
                    QuickVideoView.this.b(QuickVideoView.this.gGz, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gHo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.jS(false);
                }
            }
        };
        this.gHp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gHm) {
                    QuickVideoView.this.gHm = false;
                    QuickVideoView.this.gGz.c(surfaceTexture);
                } else if (QuickVideoView.this.gGJ || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gGz != null && QuickVideoView.this.gGN) {
                        QuickVideoView.this.gGz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gGM);
                        if (QuickVideoView.this.gGf != null) {
                            QuickVideoView.this.gGf.bsD();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gGE.bdJ();
                        }
                    }
                } else if (bsX()) {
                    if (QuickVideoView.this.gGz != null) {
                        QuickVideoView.this.bsQ();
                        QuickVideoView.this.gGJ = true;
                        QuickVideoView.this.gGz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gGE.bdI();
                    }
                }
                QuickVideoView.this.gGO = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gHm) {
                    QuickVideoView.this.bsS();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gGz != null) {
                        if (QuickVideoView.this.gGz.isPlaying() && QuickVideoView.this.bsV()) {
                            y.btx().aO(QuickVideoView.this.gGV, QuickVideoView.this.gGz.getCurrentPosition());
                        }
                        QuickVideoView.this.gGz.release();
                    }
                    if (QuickVideoView.this.gGJ) {
                        if (QuickVideoView.this.gGI != null) {
                            QuickVideoView.this.gGI.onStop();
                        }
                        if (QuickVideoView.this.bpR != null) {
                            QuickVideoView.this.bpR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gGO = null;
                    if (QuickVideoView.this.gGE != null && QuickVideoView.this.gGE.sz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.gGJ = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bsX() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gHq = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int up;
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.onPrepared();
                }
                if (QuickVideoView.this.gGE != null && QuickVideoView.this.gGz != null) {
                    QuickVideoView.this.gGE.rW(QuickVideoView.this.gGz.getPlayerType());
                }
                if (QuickVideoView.this.byA != null) {
                    QuickVideoView.this.byA.onPrepared(gVar);
                }
                if (QuickVideoView.this.gGI != null) {
                    long j = 0;
                    if (QuickVideoView.this.gGz != null) {
                        j = QuickVideoView.this.gGz.getDuration();
                    }
                    QuickVideoView.this.gGI.dd(j);
                    QuickVideoView.this.bsR();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gGI.bsK();
                        QuickVideoView.this.bsU();
                    }
                }
                if (QuickVideoView.this.gGY && (up = y.btx().up(QuickVideoView.this.gGV)) > 0) {
                    if (QuickVideoView.this.gGz.isPlayerReuse()) {
                        if (QuickVideoView.this.gGz.getCurrentPosition() == 0) {
                            QuickVideoView.this.tF(up);
                        }
                    } else {
                        QuickVideoView.this.tF(up);
                    }
                }
                if (QuickVideoView.this.gGH) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gGx != null && gVar != null) {
                    QuickVideoView.this.gGx.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGK);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gGy) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gGy);
                }
                if (QuickVideoView.this.gGQ != null && QuickVideoView.this.gGQ.btD()) {
                    com.baidu.tieba.play.b.e.tJ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gHr = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.sy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gGE = null;
                }
                if (!QuickVideoView.this.gGL || QuickVideoView.this.gGI == null) {
                    if (QuickVideoView.this.gGI != null) {
                        QuickVideoView.this.gGI.onCompletion();
                    }
                    QuickVideoView.this.gGH = false;
                    y.btx().remove(QuickVideoView.this.gGV);
                    if (QuickVideoView.this.byz != null) {
                        QuickVideoView.this.byz.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gGG = null;
                QuickVideoView.this.gGW = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gGI.bsE());
                QuickVideoView.this.start();
            }
        };
        this.byB = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGI != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsV()) {
                    QuickVideoView.this.gGX = true;
                    y.btx().aO(QuickVideoView.this.gGV, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gGE != null) {
                        QuickVideoView.this.gGG = QuickVideoView.this.gGE.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gGW, QuickVideoView.this.N(QuickVideoView.this.gGE.bdN(), i3 + "", QuickVideoView.this.gGE.bdO()));
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.gGW = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tH(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tI(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bpN == null || QuickVideoView.this.bpN.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gHs = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gGX) {
                    QuickVideoView.this.gGX = false;
                    return;
                }
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.bth();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gGI != null && z) {
                    QuickVideoView.this.gGI.onSeekComplete();
                }
                if (QuickVideoView.this.byD != null) {
                    QuickVideoView.this.byD.b(gVar);
                }
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gGA != null) {
                    QuickVideoView.this.gGA.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gGK = i2;
                    if (QuickVideoView.this.gGx != null && gVar != null) {
                        QuickVideoView.this.gGx.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGK);
                    }
                }
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.a(i, i2, QuickVideoView.this.gGE);
                    return true;
                }
                return true;
            }
        };
        this.byE = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.f(i, i2, str);
                }
            }
        };
        this.byF = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.sA(str);
                }
            }
        };
        this.byG = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gGW = j;
                }
            }
        };
        this.gHt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gGI != null && QuickVideoView.this.gGI.bsG() && QuickVideoView.this.gGI.bsH() && QuickVideoView.this.gGI.bsI() && QuickVideoView.this.gGz != null) {
                    int Vl = QuickVideoView.this.gGz.Vl();
                    int currentPosition = QuickVideoView.this.gGz.getCurrentPosition();
                    int duration = QuickVideoView.this.gGz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gGZ;
                    boolean z = currentPosition + Vl < duration;
                    if (Vl < QuickVideoView.this.gGI.bsJ() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gGZ = currentTimeMillis;
                        QuickVideoView.this.gGI.tE(0);
                    }
                    if (QuickVideoView.this.bsT() && currentPosition == QuickVideoView.this.gHa && j > 500) {
                        QuickVideoView.this.gGZ = currentTimeMillis;
                        QuickVideoView.this.gGI.tE(0);
                    }
                    QuickVideoView.this.gHa = currentPosition;
                    if (QuickVideoView.this.gqK == QuickVideoView.gHe) {
                        QuickVideoView.this.bsU();
                    }
                }
            }
        };
        this.byM = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gGI != null) {
                        QuickVideoView.this.gGI.bsM();
                    }
                    if (QuickVideoView.this.gGE != null) {
                        QuickVideoView.this.gGE.sx(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.bsS();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gGH = false;
        this.gGJ = false;
        this.gGK = 0;
        this.gGL = false;
        this.gGM = -1;
        this.gGN = false;
        this.gGO = null;
        this.gGP = true;
        this.gGZ = 0L;
        this.gHa = 0L;
        this.gqK = gHf;
        this.gHg = 0;
        this.gHh = 0;
        this.gHi = -1;
        this.gHj = 0;
        this.gHk = 0;
        this.gHl = 0;
        this.bCO = 0;
        this.gHm = false;
        this.gHn = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGz != null && QuickVideoView.this.gGH) {
                    QuickVideoView.this.b(QuickVideoView.this.gGz, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gHo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.jS(false);
                }
            }
        };
        this.gHp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gHm) {
                    QuickVideoView.this.gHm = false;
                    QuickVideoView.this.gGz.c(surfaceTexture);
                } else if (QuickVideoView.this.gGJ || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gGz != null && QuickVideoView.this.gGN) {
                        QuickVideoView.this.gGz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gGM);
                        if (QuickVideoView.this.gGf != null) {
                            QuickVideoView.this.gGf.bsD();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gGE.bdJ();
                        }
                    }
                } else if (bsX()) {
                    if (QuickVideoView.this.gGz != null) {
                        QuickVideoView.this.bsQ();
                        QuickVideoView.this.gGJ = true;
                        QuickVideoView.this.gGz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gGE.bdI();
                    }
                }
                QuickVideoView.this.gGO = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gHm) {
                    QuickVideoView.this.bsS();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gGz != null) {
                        if (QuickVideoView.this.gGz.isPlaying() && QuickVideoView.this.bsV()) {
                            y.btx().aO(QuickVideoView.this.gGV, QuickVideoView.this.gGz.getCurrentPosition());
                        }
                        QuickVideoView.this.gGz.release();
                    }
                    if (QuickVideoView.this.gGJ) {
                        if (QuickVideoView.this.gGI != null) {
                            QuickVideoView.this.gGI.onStop();
                        }
                        if (QuickVideoView.this.bpR != null) {
                            QuickVideoView.this.bpR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gGO = null;
                    if (QuickVideoView.this.gGE != null && QuickVideoView.this.gGE.sz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.gGJ = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bsX() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gHq = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int up;
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.onPrepared();
                }
                if (QuickVideoView.this.gGE != null && QuickVideoView.this.gGz != null) {
                    QuickVideoView.this.gGE.rW(QuickVideoView.this.gGz.getPlayerType());
                }
                if (QuickVideoView.this.byA != null) {
                    QuickVideoView.this.byA.onPrepared(gVar);
                }
                if (QuickVideoView.this.gGI != null) {
                    long j = 0;
                    if (QuickVideoView.this.gGz != null) {
                        j = QuickVideoView.this.gGz.getDuration();
                    }
                    QuickVideoView.this.gGI.dd(j);
                    QuickVideoView.this.bsR();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gGI.bsK();
                        QuickVideoView.this.bsU();
                    }
                }
                if (QuickVideoView.this.gGY && (up = y.btx().up(QuickVideoView.this.gGV)) > 0) {
                    if (QuickVideoView.this.gGz.isPlayerReuse()) {
                        if (QuickVideoView.this.gGz.getCurrentPosition() == 0) {
                            QuickVideoView.this.tF(up);
                        }
                    } else {
                        QuickVideoView.this.tF(up);
                    }
                }
                if (QuickVideoView.this.gGH) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gGx != null && gVar != null) {
                    QuickVideoView.this.gGx.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGK);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gGy) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gGy);
                }
                if (QuickVideoView.this.gGQ != null && QuickVideoView.this.gGQ.btD()) {
                    com.baidu.tieba.play.b.e.tJ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gHr = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.sy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gGE = null;
                }
                if (!QuickVideoView.this.gGL || QuickVideoView.this.gGI == null) {
                    if (QuickVideoView.this.gGI != null) {
                        QuickVideoView.this.gGI.onCompletion();
                    }
                    QuickVideoView.this.gGH = false;
                    y.btx().remove(QuickVideoView.this.gGV);
                    if (QuickVideoView.this.byz != null) {
                        QuickVideoView.this.byz.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gGG = null;
                QuickVideoView.this.gGW = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gGI.bsE());
                QuickVideoView.this.start();
            }
        };
        this.byB = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGI != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsV()) {
                    QuickVideoView.this.gGX = true;
                    y.btx().aO(QuickVideoView.this.gGV, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gGE != null) {
                        QuickVideoView.this.gGG = QuickVideoView.this.gGE.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gGW, QuickVideoView.this.N(QuickVideoView.this.gGE.bdN(), i3 + "", QuickVideoView.this.gGE.bdO()));
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.gGW = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.tH(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tI(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bpN == null || QuickVideoView.this.bpN.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gHs = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gGX) {
                    QuickVideoView.this.gGX = false;
                    return;
                }
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.bth();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gGI != null && z) {
                    QuickVideoView.this.gGI.onSeekComplete();
                }
                if (QuickVideoView.this.byD != null) {
                    QuickVideoView.this.byD.b(gVar);
                }
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gGA != null) {
                    QuickVideoView.this.gGA.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gGK = i22;
                    if (QuickVideoView.this.gGx != null && gVar != null) {
                        QuickVideoView.this.gGx.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGK);
                    }
                }
                if (QuickVideoView.this.gGR != null) {
                    QuickVideoView.this.gGR.a(i2, i22, QuickVideoView.this.gGE);
                    return true;
                }
                return true;
            }
        };
        this.byE = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.f(i2, i22, str);
                }
            }
        };
        this.byF = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gGE != null) {
                    QuickVideoView.this.gGE.sA(str);
                }
            }
        };
        this.byG = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gGW = j;
                }
            }
        };
        this.gHt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gGI != null && QuickVideoView.this.gGI.bsG() && QuickVideoView.this.gGI.bsH() && QuickVideoView.this.gGI.bsI() && QuickVideoView.this.gGz != null) {
                    int Vl = QuickVideoView.this.gGz.Vl();
                    int currentPosition = QuickVideoView.this.gGz.getCurrentPosition();
                    int duration = QuickVideoView.this.gGz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gGZ;
                    boolean z = currentPosition + Vl < duration;
                    if (Vl < QuickVideoView.this.gGI.bsJ() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gGZ = currentTimeMillis;
                        QuickVideoView.this.gGI.tE(0);
                    }
                    if (QuickVideoView.this.bsT() && currentPosition == QuickVideoView.this.gHa && j > 500) {
                        QuickVideoView.this.gGZ = currentTimeMillis;
                        QuickVideoView.this.gGI.tE(0);
                    }
                    QuickVideoView.this.gHa = currentPosition;
                    if (QuickVideoView.this.gqK == QuickVideoView.gHe) {
                        QuickVideoView.this.bsU();
                    }
                }
            }
        };
        this.byM = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gGI != null) {
                        QuickVideoView.this.gGI.bsM();
                    }
                    if (QuickVideoView.this.gGE != null) {
                        QuickVideoView.this.gGE.sx(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gGE = null;
                    }
                    QuickVideoView.this.bsS();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gGx = new RenderView(context);
        this.gGx.setSurfaceTextureListener(this.gHp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gGP) {
            addView(this.gGx, layoutParams);
        } else {
            addView(this.gGx, 0, layoutParams);
        }
        if (gGC != null) {
            this.gGz = gGC.Vm();
        }
        if (this.gGz != null) {
            this.gGz.setOnPreparedListener(this.gHq);
            this.gGz.setOnCompletionListener(this.gHr);
            this.gGz.a(this.byB);
            this.gGz.setOnSeekCompleteListener(this.gHs);
            this.gGz.a(this.byC);
            this.gGz.a(this.byE);
            this.gGz.a(this.byF);
            this.gGz.a(this.byG);
        }
        al.j(this, e.d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(ARResourceKey.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gGQ = new com.baidu.tieba.play.b.a(this);
        this.gGR = new r();
        this.gGS = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iQ().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.gGY = z;
    }

    public void setVideoPath(String str, String str2) {
        this.bjm = str2;
        if (this.gGQ != null) {
            this.gGQ.clear();
            this.gGQ.btD();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.uu(str2);
            if (gGD != null) {
                this.gGE = gGD.M(this.bjm, str, "");
                if (this.gGE != null) {
                    this.gGE.a(ReportLevel.USER, -44399, -44399, getLocateSource(), false, this.gGW, "");
                    this.gGE = null;
                }
            }
        }
        if (this.gGF != null) {
            this.gGF.a(null);
            this.gGF.bdB();
            this.gGF = null;
        }
        this.gGG = null;
        this.gGW = 0L;
        setVideoPath(str);
    }

    public void cu(String str, String str2) {
    }

    private String ul(String str) {
        if (!ao.isEmpty(str) && com.baidu.tieba.video.g.bJp().bJq()) {
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
        if (!ao.isEmpty(str)) {
            String ul = ul(str);
            this.gGT = ul;
            if (this.gGI != null) {
                ul = this.gGI.jR(ul);
                if (this.gGI.bsL() != null) {
                    this.gGI.bsL().setPlayer(this);
                }
                if (gGD != null && hr(ul)) {
                    this.gGF = gGD.sD(ul);
                }
                if (this.gGF != null) {
                    this.gGF.a(new com.baidu.tieba.play.monitor.a(this.bjm, this.gGT, this.gGE));
                    this.gGF.bdA();
                }
                um(ul);
            }
            if (!com.baidu.adp.lib.util.j.kV() && !hr(ul)) {
                if (this.bpN != null) {
                    this.bpN.onError(this.gGz, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(ul));
            if (this.gGE != null) {
                if (g(Uri.parse(ul)) != null) {
                    this.gGE.bdH();
                }
                this.gGE.report();
                this.gGE = null;
            }
            this.gGU = str;
            int lastIndexOf = this.gGU.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.gGU.length() > 4) {
                this.gGV = this.gGU.substring(0, lastIndexOf + 4);
            } else {
                this.gGV = this.gGU;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsQ() {
        if (com.baidu.tbadk.coreExtra.model.f.Kj()) {
            if (this.gGI != null && (this.gGI.bsF() || this.gGI.bsG())) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHn);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.gHn, com.baidu.tbadk.coreExtra.model.f.Ki());
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHo);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gHo, com.baidu.tbadk.coreExtra.model.f.Kh());
        }
    }

    public void bsg() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (g(uri) != null) {
            this.gGE.sw(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            Vh();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.gGK = 0;
        if (this.gGO != null) {
            bsQ();
            if (this.gGz != null) {
                if (!this.gGJ) {
                    this.gGJ = true;
                    this.gGz.a(this.mContext, this.mUri, this.mHeaders, this.gGO, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gHq.onPrepared(this.gGz);
                }
            }
        } else if (this.gGx != null && this.gGx.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.gGP) {
                addView(this.gGx, layoutParams);
            } else {
                addView(this.gGx, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void Vh() {
        this.gGJ = false;
        this.gGH = false;
        if (this.gGz != null) {
            if (this.gGz.isPlaying() && bsV()) {
                y.btx().aO(this.gGV, this.gGz.getCurrentPosition());
            }
            this.gGz.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHt);
    }

    private void um(String str) {
        this.gHh = 0;
        this.gHi = 0;
        this.gHj = 0;
        this.gHk = 0;
        this.gHl = 0;
        this.bCO = 0;
        if (this.gGI.bsG()) {
            this.gHg = gHc;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gHi = (int) u.uo(QuickVideoView.this.gGT);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gGT != null && this.gGT.equals(str)) {
            this.gHg = gHb;
        } else {
            this.gHg = gHd;
        }
        this.gqK = gHe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsR() {
        this.gqK = gHe;
        if (this.gGz != null) {
            this.gHh = this.gGz.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(boolean z) {
        if (this.gqK == gHe && this.gGz != null) {
            this.gqK = gHf;
            this.gHk = this.gGz.getDuration();
            if (z) {
                this.gHl = 0;
                this.gHj = this.gHk;
            } else {
                this.gHj = this.gGz.getCurrentPosition();
                this.gHl = this.gGz.getCachedSize();
            }
            if (this.gHj > 0) {
                if (this.gHg == gHb) {
                    this.gHi = (int) u.uo(this.gGT);
                    if (this.gHh > 0) {
                        long j = (this.gHh * (this.gHj / 1000)) / 8;
                        if (this.gHl < 0) {
                            this.gHl = 0;
                        }
                        long j2 = this.gHl + j;
                        if (this.gHi > 0) {
                            j2 += this.gHi;
                        }
                        setFlowCount(j2, this.gHj, this.gHk, this.bCO);
                    } else if (this.gHh == -1) {
                        this.gHh = 603327;
                        setFlowCount((this.gHh * (this.gHj / 1000)) / 8, this.gHj, this.gHk, this.bCO);
                    }
                } else if (this.gHg == gHc) {
                    if (this.gHh > 0) {
                        long j3 = (this.gHh * (this.gHj / 1000)) / 8;
                        if (this.gHl < 0) {
                            this.gHl = 0;
                        }
                        long j4 = this.gHl + j3;
                        if (this.gHi > 0) {
                            j4 -= this.gHi;
                        }
                        setFlowCount(j4, this.gHj, this.gHk, this.bCO);
                    } else if (this.gHh == -1) {
                        this.gHh = 603327;
                        setFlowCount((this.gHh * (this.gHj / 1000)) / 8, this.gHj, this.gHk, this.bCO);
                    }
                } else {
                    setFlowCount(0L, this.gHj, this.gHk, this.bCO);
                }
            }
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHt);
    }

    public void stopPlayback() {
        bsS();
        mD(false);
        if (this.gGQ != null) {
            this.gGQ.clear();
        }
        this.gGy = null;
        Vh();
        this.gGL = false;
        if (this.gGI != null) {
            this.gGI.onStop();
        }
        com.baidu.tieba.play.a.b.btA().a((b.InterfaceC0295b) null);
        if (this.gGE != null && this.gGE.sz(getLocateSource())) {
            this.gGE = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHt);
    }

    public void setFullScreenToDestroySurface() {
        this.gHm = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsS() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHn);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHo);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.byA = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.byz = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bpN = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0298g interfaceC0298g) {
        this.byD = interfaceC0298g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(String str, String str2, String str3) {
        if (this.gGS == null) {
            return "";
        }
        String btF = this.gGS.btF();
        this.gGS.O(str, str2, str3);
        return btF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gGI != null && !StringUtils.isNull(this.gGI.bsE())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.ut(uri);
                }
            }
            this.mUri = Uri.parse(this.gGI.bsE());
        }
        boolean z = false;
        if (this.gGQ != null) {
            z = this.gGQ.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gGE != null) {
            this.gGG = this.gGE.a(i, i2, i3, getLocateSource(), z, this.gGW, N(this.gGE.bdN(), i3 + "", this.gGE.bdO()));
            this.gGE = null;
        }
        this.gGW = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gGz != null) {
            try {
                if (this.gGz.isPlaying() && bsV()) {
                    y.btx().aO(this.gGV, this.gGz.getCurrentPosition());
                }
                this.gGz.release();
                this.gGy = str;
                URI uri = new URI(this.mUri.toString());
                this.gGz.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.gGO, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (g(this.mUri) != null) {
                    this.gGE.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gGz != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.gGz.isPlaying() && bsV()) {
                y.btx().aO(this.gGV, this.gGz.getCurrentPosition());
            }
            this.gGz.release();
            this.gGz.a(this.mContext, this.mUri, this.mHeaders, this.gGO, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gGE.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gGz != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gGz.forceUseSystemMediaPlayer(true);
            }
            if (this.gGz.isPlaying() && bsV()) {
                y.btx().aO(this.gGV, this.gGz.getCurrentPosition());
            }
            this.gGz.release();
            this.gGz.a(this.mContext, this.mUri, this.mHeaders, this.gGO, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gGE.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gGH = true;
        if (this.gGz != null) {
            if (this.gGO != null && this.gGN && !this.gGz.isExistInRemote()) {
                this.gGz.a(this.mContext, this.mUri, this.mHeaders, this.gGO, this.gGM);
                if (this.gGf != null) {
                    this.gGf.bsD();
                }
                if (g(this.mUri) != null) {
                    this.gGE.bdJ();
                }
                bsQ();
                return;
            }
            this.gGz.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gGI != null) {
            this.gGI.onStart();
        }
        if (this.gGB != null) {
            this.gGB.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (g(this.mUri) != null && this.gGz != null) {
            this.gGE.rX(this.gGz.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bsS();
        if (this.gGz != null) {
            if (this.gGz.isPlaying() && bsV()) {
                y.btx().aO(this.gGV, this.gGz.getCurrentPosition());
            }
            this.gGz.pause();
        }
        if (this.gGI != null) {
            this.gGI.onPause();
        }
        this.gGH = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gGE != null) {
            this.gGE.bdM();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gGz != null) {
            return this.gGz.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gGz != null) {
            return this.gGz.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bCO = i;
        tF(i);
    }

    public void tF(int i) {
        if (this.gGR != null) {
            this.gGR.btg();
        }
        if (this.gGz != null) {
            this.gGz.seekTo(i);
        }
        if (this.gGI != null) {
            this.gGI.tE(0);
            bsU();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gGz != null) {
            return this.gGz.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gGz != null) {
            this.gGz.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gGM = i;
    }

    public int getRecoveryState() {
        return this.gGM;
    }

    public void setNeedRecovery(boolean z) {
        this.gGN = z;
    }

    public void setLooping(boolean z) {
        this.gGL = z;
    }

    public boolean bsT() {
        return this.gGH;
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
        this.bpR = bVar;
    }

    public void setBusiness(d dVar) {
        this.gGI = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.byM);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gGL = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gGz != null) {
            this.gGz.Qz();
        }
        if (this.gGR != null) {
            this.gGR.bti();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHt);
        MessageManager.getInstance().unRegisterListener(this.byM);
        if (this.gGQ != null) {
            this.gGQ.clear();
        }
        if (this.gGF != null) {
            this.gGF.a(null);
            this.gGF.bdB();
        }
    }

    public g getPlayer() {
        return this.gGz;
    }

    public int getPlayerType() {
        return this.gGz == null ? ReportLevel.USER : this.gGz.getPlayerType();
    }

    public void bsU() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHt);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gHt, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gGf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gGI instanceof n) || ((n) this.gGI).bte() == null) ? "" : ((n) this.gGI).bte().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i g(Uri uri) {
        String uri2;
        if (this.gGE != null) {
            return this.gGE;
        }
        if (!StringUtils.isNull(this.gGT)) {
            uri2 = this.gGT;
        } else if (gGD != null && this.gGI != null && !StringUtils.isNull(this.gGI.bsE())) {
            uri2 = this.gGI.bsE();
        } else {
            uri2 = (gGD == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gGD != null) {
            this.gGE = gGD.M(this.bjm, uri2, this.gGG);
        }
        this.gGG = null;
        this.gGW = 0L;
        return this.gGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsV() {
        return this.gGz != null && this.gGz.getDuration() >= this.gGz.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gGE, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gGE, j);
    }

    public static boolean hr(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gGA = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gGz != null) {
            return this.gGz.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gGz != null ? this.gGz.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.gGE != null) {
            this.gGE.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.gGB = cVar;
    }
}
