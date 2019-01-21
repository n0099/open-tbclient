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
    private static h gGD;
    private static com.baidu.tieba.j.l gGE;
    private static int gHc = 0;
    private static int gHd = 1;
    private static int gHe = 2;
    private static int gHf = 1;
    private static int gHg = 0;
    private int bCP;
    private String bjn;
    private g.b bpO;
    private b bpS;
    private g.a byA;
    private g.f byB;
    private g.c byC;
    private g.e byD;
    private g.InterfaceC0298g byE;
    private g.i byF;
    private g.d byG;
    private g.h byH;
    private final CustomMessageListener byN;
    private g gGA;
    private g.e gGB;
    private c gGC;
    private com.baidu.tieba.j.i gGF;
    private com.baidu.tieba.j.e gGG;
    private String gGH;
    private boolean gGI;
    private d gGJ;
    private boolean gGK;
    private int gGL;
    private boolean gGM;
    private int gGN;
    private boolean gGO;
    private SurfaceTexture gGP;
    private boolean gGQ;
    private com.baidu.tieba.play.b.a gGR;
    private r gGS;
    private com.baidu.tieba.play.b.f gGT;
    private String gGU;
    private String gGV;
    private String gGW;
    private long gGX;
    private boolean gGY;
    private boolean gGZ;
    private a gGg;
    private RenderView gGy;
    private String gGz;
    private long gHa;
    private long gHb;
    private int gHh;
    private int gHi;
    private int gHj;
    private int gHk;
    private int gHl;
    private int gHm;
    private boolean gHn;
    private Runnable gHo;
    private Runnable gHp;
    private TextureView.SurfaceTextureListener gHq;
    private g.f gHr;
    private g.a gHs;
    private g.InterfaceC0298g gHt;
    private Runnable gHu;
    private int gqL;
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
            gGD = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gGE = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gGQ = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gGI = false;
        this.gGK = false;
        this.gGL = 0;
        this.gGM = false;
        this.gGN = -1;
        this.gGO = false;
        this.gGP = null;
        this.gGQ = true;
        this.gHa = 0L;
        this.gHb = 0L;
        this.gqL = gHg;
        this.gHh = 0;
        this.gHi = 0;
        this.gHj = -1;
        this.gHk = 0;
        this.gHl = 0;
        this.gHm = 0;
        this.bCP = 0;
        this.gHn = false;
        this.gHo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGA != null && QuickVideoView.this.gGI) {
                    QuickVideoView.this.b(QuickVideoView.this.gGA, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gHp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.jS(false);
                }
            }
        };
        this.gHq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gHn) {
                    QuickVideoView.this.gHn = false;
                    QuickVideoView.this.gGA.c(surfaceTexture);
                } else if (QuickVideoView.this.gGK || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gGA != null && QuickVideoView.this.gGO) {
                        QuickVideoView.this.gGA.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gGN);
                        if (QuickVideoView.this.gGg != null) {
                            QuickVideoView.this.gGg.bsD();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gGF.bdJ();
                        }
                    }
                } else if (bsX()) {
                    if (QuickVideoView.this.gGA != null) {
                        QuickVideoView.this.bsQ();
                        QuickVideoView.this.gGK = true;
                        QuickVideoView.this.gGA.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gGF.bdI();
                    }
                }
                QuickVideoView.this.gGP = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gHn) {
                    QuickVideoView.this.bsS();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gGA != null) {
                        if (QuickVideoView.this.gGA.isPlaying() && QuickVideoView.this.bsV()) {
                            y.btx().aO(QuickVideoView.this.gGW, QuickVideoView.this.gGA.getCurrentPosition());
                        }
                        QuickVideoView.this.gGA.release();
                    }
                    if (QuickVideoView.this.gGK) {
                        if (QuickVideoView.this.gGJ != null) {
                            QuickVideoView.this.gGJ.onStop();
                        }
                        if (QuickVideoView.this.bpS != null) {
                            QuickVideoView.this.bpS.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gGP = null;
                    if (QuickVideoView.this.gGF != null && QuickVideoView.this.gGF.sz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.gGK = false;
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
        this.gHr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int up;
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.onPrepared();
                }
                if (QuickVideoView.this.gGF != null && QuickVideoView.this.gGA != null) {
                    QuickVideoView.this.gGF.rW(QuickVideoView.this.gGA.getPlayerType());
                }
                if (QuickVideoView.this.byB != null) {
                    QuickVideoView.this.byB.onPrepared(gVar);
                }
                if (QuickVideoView.this.gGJ != null) {
                    long j = 0;
                    if (QuickVideoView.this.gGA != null) {
                        j = QuickVideoView.this.gGA.getDuration();
                    }
                    QuickVideoView.this.gGJ.dd(j);
                    QuickVideoView.this.bsR();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gGJ.bsK();
                        QuickVideoView.this.bsU();
                    }
                }
                if (QuickVideoView.this.gGZ && (up = y.btx().up(QuickVideoView.this.gGW)) > 0) {
                    if (QuickVideoView.this.gGA.isPlayerReuse()) {
                        if (QuickVideoView.this.gGA.getCurrentPosition() == 0) {
                            QuickVideoView.this.tF(up);
                        }
                    } else {
                        QuickVideoView.this.tF(up);
                    }
                }
                if (QuickVideoView.this.gGI) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gGy != null && gVar != null) {
                    QuickVideoView.this.gGy.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGL);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gGz) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gGz);
                }
                if (QuickVideoView.this.gGR != null && QuickVideoView.this.gGR.btD()) {
                    com.baidu.tieba.play.b.e.tJ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gHs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.sy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gGF = null;
                }
                if (!QuickVideoView.this.gGM || QuickVideoView.this.gGJ == null) {
                    if (QuickVideoView.this.gGJ != null) {
                        QuickVideoView.this.gGJ.onCompletion();
                    }
                    QuickVideoView.this.gGI = false;
                    y.btx().remove(QuickVideoView.this.gGW);
                    if (QuickVideoView.this.byA != null) {
                        QuickVideoView.this.byA.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gGH = null;
                QuickVideoView.this.gGX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gGJ.bsE());
                QuickVideoView.this.start();
            }
        };
        this.byC = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGJ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsV()) {
                    QuickVideoView.this.gGY = true;
                    y.btx().aO(QuickVideoView.this.gGW, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gGF != null) {
                        QuickVideoView.this.gGH = QuickVideoView.this.gGF.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gGX, QuickVideoView.this.N(QuickVideoView.this.gGF.bdN(), i3 + "", QuickVideoView.this.gGF.bdO()));
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.gGX = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tH(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tI(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bpO == null || QuickVideoView.this.bpO.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gHt = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gGY) {
                    QuickVideoView.this.gGY = false;
                    return;
                }
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.bth();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gGJ != null && z) {
                    QuickVideoView.this.gGJ.onSeekComplete();
                }
                if (QuickVideoView.this.byE != null) {
                    QuickVideoView.this.byE.b(gVar);
                }
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gGB != null) {
                    QuickVideoView.this.gGB.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gGL = i2;
                    if (QuickVideoView.this.gGy != null && gVar != null) {
                        QuickVideoView.this.gGy.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGL);
                    }
                }
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.a(i, i2, QuickVideoView.this.gGF);
                    return true;
                }
                return true;
            }
        };
        this.byF = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.f(i, i2, str);
                }
            }
        };
        this.byG = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.sA(str);
                }
            }
        };
        this.byH = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gGX = j;
                }
            }
        };
        this.gHu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gGJ != null && QuickVideoView.this.gGJ.bsG() && QuickVideoView.this.gGJ.bsH() && QuickVideoView.this.gGJ.bsI() && QuickVideoView.this.gGA != null) {
                    int Vl = QuickVideoView.this.gGA.Vl();
                    int currentPosition = QuickVideoView.this.gGA.getCurrentPosition();
                    int duration = QuickVideoView.this.gGA.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gHa;
                    boolean z = currentPosition + Vl < duration;
                    if (Vl < QuickVideoView.this.gGJ.bsJ() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gHa = currentTimeMillis;
                        QuickVideoView.this.gGJ.tE(0);
                    }
                    if (QuickVideoView.this.bsT() && currentPosition == QuickVideoView.this.gHb && j > 500) {
                        QuickVideoView.this.gHa = currentTimeMillis;
                        QuickVideoView.this.gGJ.tE(0);
                    }
                    QuickVideoView.this.gHb = currentPosition;
                    if (QuickVideoView.this.gqL == QuickVideoView.gHf) {
                        QuickVideoView.this.bsU();
                    }
                }
            }
        };
        this.byN = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gGJ != null) {
                        QuickVideoView.this.gGJ.bsM();
                    }
                    if (QuickVideoView.this.gGF != null) {
                        QuickVideoView.this.gGF.sx(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.bsS();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gGI = false;
        this.gGK = false;
        this.gGL = 0;
        this.gGM = false;
        this.gGN = -1;
        this.gGO = false;
        this.gGP = null;
        this.gGQ = true;
        this.gHa = 0L;
        this.gHb = 0L;
        this.gqL = gHg;
        this.gHh = 0;
        this.gHi = 0;
        this.gHj = -1;
        this.gHk = 0;
        this.gHl = 0;
        this.gHm = 0;
        this.bCP = 0;
        this.gHn = false;
        this.gHo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGA != null && QuickVideoView.this.gGI) {
                    QuickVideoView.this.b(QuickVideoView.this.gGA, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gHp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.jS(false);
                }
            }
        };
        this.gHq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gHn) {
                    QuickVideoView.this.gHn = false;
                    QuickVideoView.this.gGA.c(surfaceTexture);
                } else if (QuickVideoView.this.gGK || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gGA != null && QuickVideoView.this.gGO) {
                        QuickVideoView.this.gGA.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gGN);
                        if (QuickVideoView.this.gGg != null) {
                            QuickVideoView.this.gGg.bsD();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gGF.bdJ();
                        }
                    }
                } else if (bsX()) {
                    if (QuickVideoView.this.gGA != null) {
                        QuickVideoView.this.bsQ();
                        QuickVideoView.this.gGK = true;
                        QuickVideoView.this.gGA.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gGF.bdI();
                    }
                }
                QuickVideoView.this.gGP = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gHn) {
                    QuickVideoView.this.bsS();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gGA != null) {
                        if (QuickVideoView.this.gGA.isPlaying() && QuickVideoView.this.bsV()) {
                            y.btx().aO(QuickVideoView.this.gGW, QuickVideoView.this.gGA.getCurrentPosition());
                        }
                        QuickVideoView.this.gGA.release();
                    }
                    if (QuickVideoView.this.gGK) {
                        if (QuickVideoView.this.gGJ != null) {
                            QuickVideoView.this.gGJ.onStop();
                        }
                        if (QuickVideoView.this.bpS != null) {
                            QuickVideoView.this.bpS.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gGP = null;
                    if (QuickVideoView.this.gGF != null && QuickVideoView.this.gGF.sz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.gGK = false;
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
        this.gHr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int up;
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.onPrepared();
                }
                if (QuickVideoView.this.gGF != null && QuickVideoView.this.gGA != null) {
                    QuickVideoView.this.gGF.rW(QuickVideoView.this.gGA.getPlayerType());
                }
                if (QuickVideoView.this.byB != null) {
                    QuickVideoView.this.byB.onPrepared(gVar);
                }
                if (QuickVideoView.this.gGJ != null) {
                    long j = 0;
                    if (QuickVideoView.this.gGA != null) {
                        j = QuickVideoView.this.gGA.getDuration();
                    }
                    QuickVideoView.this.gGJ.dd(j);
                    QuickVideoView.this.bsR();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gGJ.bsK();
                        QuickVideoView.this.bsU();
                    }
                }
                if (QuickVideoView.this.gGZ && (up = y.btx().up(QuickVideoView.this.gGW)) > 0) {
                    if (QuickVideoView.this.gGA.isPlayerReuse()) {
                        if (QuickVideoView.this.gGA.getCurrentPosition() == 0) {
                            QuickVideoView.this.tF(up);
                        }
                    } else {
                        QuickVideoView.this.tF(up);
                    }
                }
                if (QuickVideoView.this.gGI) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gGy != null && gVar != null) {
                    QuickVideoView.this.gGy.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGL);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gGz) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gGz);
                }
                if (QuickVideoView.this.gGR != null && QuickVideoView.this.gGR.btD()) {
                    com.baidu.tieba.play.b.e.tJ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gHs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.sy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gGF = null;
                }
                if (!QuickVideoView.this.gGM || QuickVideoView.this.gGJ == null) {
                    if (QuickVideoView.this.gGJ != null) {
                        QuickVideoView.this.gGJ.onCompletion();
                    }
                    QuickVideoView.this.gGI = false;
                    y.btx().remove(QuickVideoView.this.gGW);
                    if (QuickVideoView.this.byA != null) {
                        QuickVideoView.this.byA.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gGH = null;
                QuickVideoView.this.gGX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gGJ.bsE());
                QuickVideoView.this.start();
            }
        };
        this.byC = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGJ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsV()) {
                    QuickVideoView.this.gGY = true;
                    y.btx().aO(QuickVideoView.this.gGW, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gGF != null) {
                        QuickVideoView.this.gGH = QuickVideoView.this.gGF.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gGX, QuickVideoView.this.N(QuickVideoView.this.gGF.bdN(), i3 + "", QuickVideoView.this.gGF.bdO()));
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.gGX = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tH(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tI(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bpO == null || QuickVideoView.this.bpO.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gHt = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gGY) {
                    QuickVideoView.this.gGY = false;
                    return;
                }
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.bth();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gGJ != null && z) {
                    QuickVideoView.this.gGJ.onSeekComplete();
                }
                if (QuickVideoView.this.byE != null) {
                    QuickVideoView.this.byE.b(gVar);
                }
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gGB != null) {
                    QuickVideoView.this.gGB.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gGL = i2;
                    if (QuickVideoView.this.gGy != null && gVar != null) {
                        QuickVideoView.this.gGy.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGL);
                    }
                }
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.a(i, i2, QuickVideoView.this.gGF);
                    return true;
                }
                return true;
            }
        };
        this.byF = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.f(i, i2, str);
                }
            }
        };
        this.byG = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.sA(str);
                }
            }
        };
        this.byH = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gGX = j;
                }
            }
        };
        this.gHu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gGJ != null && QuickVideoView.this.gGJ.bsG() && QuickVideoView.this.gGJ.bsH() && QuickVideoView.this.gGJ.bsI() && QuickVideoView.this.gGA != null) {
                    int Vl = QuickVideoView.this.gGA.Vl();
                    int currentPosition = QuickVideoView.this.gGA.getCurrentPosition();
                    int duration = QuickVideoView.this.gGA.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gHa;
                    boolean z = currentPosition + Vl < duration;
                    if (Vl < QuickVideoView.this.gGJ.bsJ() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gHa = currentTimeMillis;
                        QuickVideoView.this.gGJ.tE(0);
                    }
                    if (QuickVideoView.this.bsT() && currentPosition == QuickVideoView.this.gHb && j > 500) {
                        QuickVideoView.this.gHa = currentTimeMillis;
                        QuickVideoView.this.gGJ.tE(0);
                    }
                    QuickVideoView.this.gHb = currentPosition;
                    if (QuickVideoView.this.gqL == QuickVideoView.gHf) {
                        QuickVideoView.this.bsU();
                    }
                }
            }
        };
        this.byN = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gGJ != null) {
                        QuickVideoView.this.gGJ.bsM();
                    }
                    if (QuickVideoView.this.gGF != null) {
                        QuickVideoView.this.gGF.sx(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.bsS();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gGI = false;
        this.gGK = false;
        this.gGL = 0;
        this.gGM = false;
        this.gGN = -1;
        this.gGO = false;
        this.gGP = null;
        this.gGQ = true;
        this.gHa = 0L;
        this.gHb = 0L;
        this.gqL = gHg;
        this.gHh = 0;
        this.gHi = 0;
        this.gHj = -1;
        this.gHk = 0;
        this.gHl = 0;
        this.gHm = 0;
        this.bCP = 0;
        this.gHn = false;
        this.gHo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGA != null && QuickVideoView.this.gGI) {
                    QuickVideoView.this.b(QuickVideoView.this.gGA, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gHp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.jS(false);
                }
            }
        };
        this.gHq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gHn) {
                    QuickVideoView.this.gHn = false;
                    QuickVideoView.this.gGA.c(surfaceTexture);
                } else if (QuickVideoView.this.gGK || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gGA != null && QuickVideoView.this.gGO) {
                        QuickVideoView.this.gGA.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gGN);
                        if (QuickVideoView.this.gGg != null) {
                            QuickVideoView.this.gGg.bsD();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gGF.bdJ();
                        }
                    }
                } else if (bsX()) {
                    if (QuickVideoView.this.gGA != null) {
                        QuickVideoView.this.bsQ();
                        QuickVideoView.this.gGK = true;
                        QuickVideoView.this.gGA.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gGF.bdI();
                    }
                }
                QuickVideoView.this.gGP = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gHn) {
                    QuickVideoView.this.bsS();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gGA != null) {
                        if (QuickVideoView.this.gGA.isPlaying() && QuickVideoView.this.bsV()) {
                            y.btx().aO(QuickVideoView.this.gGW, QuickVideoView.this.gGA.getCurrentPosition());
                        }
                        QuickVideoView.this.gGA.release();
                    }
                    if (QuickVideoView.this.gGK) {
                        if (QuickVideoView.this.gGJ != null) {
                            QuickVideoView.this.gGJ.onStop();
                        }
                        if (QuickVideoView.this.bpS != null) {
                            QuickVideoView.this.bpS.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gGP = null;
                    if (QuickVideoView.this.gGF != null && QuickVideoView.this.gGF.sz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.gGK = false;
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
        this.gHr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int up;
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.onPrepared();
                }
                if (QuickVideoView.this.gGF != null && QuickVideoView.this.gGA != null) {
                    QuickVideoView.this.gGF.rW(QuickVideoView.this.gGA.getPlayerType());
                }
                if (QuickVideoView.this.byB != null) {
                    QuickVideoView.this.byB.onPrepared(gVar);
                }
                if (QuickVideoView.this.gGJ != null) {
                    long j = 0;
                    if (QuickVideoView.this.gGA != null) {
                        j = QuickVideoView.this.gGA.getDuration();
                    }
                    QuickVideoView.this.gGJ.dd(j);
                    QuickVideoView.this.bsR();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gGJ.bsK();
                        QuickVideoView.this.bsU();
                    }
                }
                if (QuickVideoView.this.gGZ && (up = y.btx().up(QuickVideoView.this.gGW)) > 0) {
                    if (QuickVideoView.this.gGA.isPlayerReuse()) {
                        if (QuickVideoView.this.gGA.getCurrentPosition() == 0) {
                            QuickVideoView.this.tF(up);
                        }
                    } else {
                        QuickVideoView.this.tF(up);
                    }
                }
                if (QuickVideoView.this.gGI) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gGy != null && gVar != null) {
                    QuickVideoView.this.gGy.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGL);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gGz) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gGz);
                }
                if (QuickVideoView.this.gGR != null && QuickVideoView.this.gGR.btD()) {
                    com.baidu.tieba.play.b.e.tJ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gHs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.sy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gGF = null;
                }
                if (!QuickVideoView.this.gGM || QuickVideoView.this.gGJ == null) {
                    if (QuickVideoView.this.gGJ != null) {
                        QuickVideoView.this.gGJ.onCompletion();
                    }
                    QuickVideoView.this.gGI = false;
                    y.btx().remove(QuickVideoView.this.gGW);
                    if (QuickVideoView.this.byA != null) {
                        QuickVideoView.this.byA.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gGH = null;
                QuickVideoView.this.gGX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gGJ.bsE());
                QuickVideoView.this.start();
            }
        };
        this.byC = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.bsS();
                if (QuickVideoView.this.gGJ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsV()) {
                    QuickVideoView.this.gGY = true;
                    y.btx().aO(QuickVideoView.this.gGW, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gGF != null) {
                        QuickVideoView.this.gGH = QuickVideoView.this.gGF.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gGX, QuickVideoView.this.N(QuickVideoView.this.gGF.bdN(), i3 + "", QuickVideoView.this.gGF.bdO()));
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.gGX = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.tH(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tI(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bpO == null || QuickVideoView.this.bpO.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gHt = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gGY) {
                    QuickVideoView.this.gGY = false;
                    return;
                }
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.bth();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gGJ != null && z) {
                    QuickVideoView.this.gGJ.onSeekComplete();
                }
                if (QuickVideoView.this.byE != null) {
                    QuickVideoView.this.byE.b(gVar);
                }
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gGB != null) {
                    QuickVideoView.this.gGB.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gGL = i22;
                    if (QuickVideoView.this.gGy != null && gVar != null) {
                        QuickVideoView.this.gGy.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gGL);
                    }
                }
                if (QuickVideoView.this.gGS != null) {
                    QuickVideoView.this.gGS.a(i2, i22, QuickVideoView.this.gGF);
                    return true;
                }
                return true;
            }
        };
        this.byF = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.f(i2, i22, str);
                }
            }
        };
        this.byG = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gGF != null) {
                    QuickVideoView.this.gGF.sA(str);
                }
            }
        };
        this.byH = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gGX = j;
                }
            }
        };
        this.gHu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gGJ != null && QuickVideoView.this.gGJ.bsG() && QuickVideoView.this.gGJ.bsH() && QuickVideoView.this.gGJ.bsI() && QuickVideoView.this.gGA != null) {
                    int Vl = QuickVideoView.this.gGA.Vl();
                    int currentPosition = QuickVideoView.this.gGA.getCurrentPosition();
                    int duration = QuickVideoView.this.gGA.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gHa;
                    boolean z = currentPosition + Vl < duration;
                    if (Vl < QuickVideoView.this.gGJ.bsJ() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gHa = currentTimeMillis;
                        QuickVideoView.this.gGJ.tE(0);
                    }
                    if (QuickVideoView.this.bsT() && currentPosition == QuickVideoView.this.gHb && j > 500) {
                        QuickVideoView.this.gHa = currentTimeMillis;
                        QuickVideoView.this.gGJ.tE(0);
                    }
                    QuickVideoView.this.gHb = currentPosition;
                    if (QuickVideoView.this.gqL == QuickVideoView.gHf) {
                        QuickVideoView.this.bsU();
                    }
                }
            }
        };
        this.byN = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gGJ != null) {
                        QuickVideoView.this.gGJ.bsM();
                    }
                    if (QuickVideoView.this.gGF != null) {
                        QuickVideoView.this.gGF.sx(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gGF = null;
                    }
                    QuickVideoView.this.bsS();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gGy = new RenderView(context);
        this.gGy.setSurfaceTextureListener(this.gHq);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gGQ) {
            addView(this.gGy, layoutParams);
        } else {
            addView(this.gGy, 0, layoutParams);
        }
        if (gGD != null) {
            this.gGA = gGD.Vm();
        }
        if (this.gGA != null) {
            this.gGA.setOnPreparedListener(this.gHr);
            this.gGA.setOnCompletionListener(this.gHs);
            this.gGA.a(this.byC);
            this.gGA.setOnSeekCompleteListener(this.gHt);
            this.gGA.a(this.byD);
            this.gGA.a(this.byF);
            this.gGA.a(this.byG);
            this.gGA.a(this.byH);
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
        this.gGR = new com.baidu.tieba.play.b.a(this);
        this.gGS = new r();
        this.gGT = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iQ().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.gGZ = z;
    }

    public void setVideoPath(String str, String str2) {
        this.bjn = str2;
        if (this.gGR != null) {
            this.gGR.clear();
            this.gGR.btD();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.uu(str2);
            if (gGE != null) {
                this.gGF = gGE.M(this.bjn, str, "");
                if (this.gGF != null) {
                    this.gGF.a(ReportLevel.USER, -44399, -44399, getLocateSource(), false, this.gGX, "");
                    this.gGF = null;
                }
            }
        }
        if (this.gGG != null) {
            this.gGG.a(null);
            this.gGG.bdB();
            this.gGG = null;
        }
        this.gGH = null;
        this.gGX = 0L;
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
            this.gGU = ul;
            if (this.gGJ != null) {
                ul = this.gGJ.jR(ul);
                if (this.gGJ.bsL() != null) {
                    this.gGJ.bsL().setPlayer(this);
                }
                if (gGE != null && hr(ul)) {
                    this.gGG = gGE.sD(ul);
                }
                if (this.gGG != null) {
                    this.gGG.a(new com.baidu.tieba.play.monitor.a(this.bjn, this.gGU, this.gGF));
                    this.gGG.bdA();
                }
                um(ul);
            }
            if (!com.baidu.adp.lib.util.j.kV() && !hr(ul)) {
                if (this.bpO != null) {
                    this.bpO.onError(this.gGA, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(ul));
            if (this.gGF != null) {
                if (g(Uri.parse(ul)) != null) {
                    this.gGF.bdH();
                }
                this.gGF.report();
                this.gGF = null;
            }
            this.gGV = str;
            int lastIndexOf = this.gGV.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.gGV.length() > 4) {
                this.gGW = this.gGV.substring(0, lastIndexOf + 4);
            } else {
                this.gGW = this.gGV;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsQ() {
        if (com.baidu.tbadk.coreExtra.model.f.Kj()) {
            if (this.gGJ != null && (this.gGJ.bsF() || this.gGJ.bsG())) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHo);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.gHo, com.baidu.tbadk.coreExtra.model.f.Ki());
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHp);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gHp, com.baidu.tbadk.coreExtra.model.f.Kh());
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
            this.gGF.sw(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            Vh();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.gGL = 0;
        if (this.gGP != null) {
            bsQ();
            if (this.gGA != null) {
                if (!this.gGK) {
                    this.gGK = true;
                    this.gGA.a(this.mContext, this.mUri, this.mHeaders, this.gGP, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gHr.onPrepared(this.gGA);
                }
            }
        } else if (this.gGy != null && this.gGy.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.gGQ) {
                addView(this.gGy, layoutParams);
            } else {
                addView(this.gGy, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void Vh() {
        this.gGK = false;
        this.gGI = false;
        if (this.gGA != null) {
            if (this.gGA.isPlaying() && bsV()) {
                y.btx().aO(this.gGW, this.gGA.getCurrentPosition());
            }
            this.gGA.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHu);
    }

    private void um(String str) {
        this.gHi = 0;
        this.gHj = 0;
        this.gHk = 0;
        this.gHl = 0;
        this.gHm = 0;
        this.bCP = 0;
        if (this.gGJ.bsG()) {
            this.gHh = gHd;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gHj = (int) u.uo(QuickVideoView.this.gGU);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gGU != null && this.gGU.equals(str)) {
            this.gHh = gHc;
        } else {
            this.gHh = gHe;
        }
        this.gqL = gHf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsR() {
        this.gqL = gHf;
        if (this.gGA != null) {
            this.gHi = this.gGA.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(boolean z) {
        if (this.gqL == gHf && this.gGA != null) {
            this.gqL = gHg;
            this.gHl = this.gGA.getDuration();
            if (z) {
                this.gHm = 0;
                this.gHk = this.gHl;
            } else {
                this.gHk = this.gGA.getCurrentPosition();
                this.gHm = this.gGA.getCachedSize();
            }
            if (this.gHk > 0) {
                if (this.gHh == gHc) {
                    this.gHj = (int) u.uo(this.gGU);
                    if (this.gHi > 0) {
                        long j = (this.gHi * (this.gHk / 1000)) / 8;
                        if (this.gHm < 0) {
                            this.gHm = 0;
                        }
                        long j2 = this.gHm + j;
                        if (this.gHj > 0) {
                            j2 += this.gHj;
                        }
                        setFlowCount(j2, this.gHk, this.gHl, this.bCP);
                    } else if (this.gHi == -1) {
                        this.gHi = 603327;
                        setFlowCount((this.gHi * (this.gHk / 1000)) / 8, this.gHk, this.gHl, this.bCP);
                    }
                } else if (this.gHh == gHd) {
                    if (this.gHi > 0) {
                        long j3 = (this.gHi * (this.gHk / 1000)) / 8;
                        if (this.gHm < 0) {
                            this.gHm = 0;
                        }
                        long j4 = this.gHm + j3;
                        if (this.gHj > 0) {
                            j4 -= this.gHj;
                        }
                        setFlowCount(j4, this.gHk, this.gHl, this.bCP);
                    } else if (this.gHi == -1) {
                        this.gHi = 603327;
                        setFlowCount((this.gHi * (this.gHk / 1000)) / 8, this.gHk, this.gHl, this.bCP);
                    }
                } else {
                    setFlowCount(0L, this.gHk, this.gHl, this.bCP);
                }
            }
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHu);
    }

    public void stopPlayback() {
        bsS();
        mD(false);
        if (this.gGR != null) {
            this.gGR.clear();
        }
        this.gGz = null;
        Vh();
        this.gGM = false;
        if (this.gGJ != null) {
            this.gGJ.onStop();
        }
        com.baidu.tieba.play.a.b.btA().a((b.InterfaceC0295b) null);
        if (this.gGF != null && this.gGF.sz(getLocateSource())) {
            this.gGF = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHu);
    }

    public void setFullScreenToDestroySurface() {
        this.gHn = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsS() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHo);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHp);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.byB = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.byA = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bpO = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0298g interfaceC0298g) {
        this.byE = interfaceC0298g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(String str, String str2, String str3) {
        if (this.gGT == null) {
            return "";
        }
        String btF = this.gGT.btF();
        this.gGT.O(str, str2, str3);
        return btF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gGJ != null && !StringUtils.isNull(this.gGJ.bsE())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.ut(uri);
                }
            }
            this.mUri = Uri.parse(this.gGJ.bsE());
        }
        boolean z = false;
        if (this.gGR != null) {
            z = this.gGR.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gGF != null) {
            this.gGH = this.gGF.a(i, i2, i3, getLocateSource(), z, this.gGX, N(this.gGF.bdN(), i3 + "", this.gGF.bdO()));
            this.gGF = null;
        }
        this.gGX = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gGA != null) {
            try {
                if (this.gGA.isPlaying() && bsV()) {
                    y.btx().aO(this.gGW, this.gGA.getCurrentPosition());
                }
                this.gGA.release();
                this.gGz = str;
                URI uri = new URI(this.mUri.toString());
                this.gGA.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.gGP, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (g(this.mUri) != null) {
                    this.gGF.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gGA != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.gGA.isPlaying() && bsV()) {
                y.btx().aO(this.gGW, this.gGA.getCurrentPosition());
            }
            this.gGA.release();
            this.gGA.a(this.mContext, this.mUri, this.mHeaders, this.gGP, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gGF.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gGA != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gGA.forceUseSystemMediaPlayer(true);
            }
            if (this.gGA.isPlaying() && bsV()) {
                y.btx().aO(this.gGW, this.gGA.getCurrentPosition());
            }
            this.gGA.release();
            this.gGA.a(this.mContext, this.mUri, this.mHeaders, this.gGP, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gGF.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gGI = true;
        if (this.gGA != null) {
            if (this.gGP != null && this.gGO && !this.gGA.isExistInRemote()) {
                this.gGA.a(this.mContext, this.mUri, this.mHeaders, this.gGP, this.gGN);
                if (this.gGg != null) {
                    this.gGg.bsD();
                }
                if (g(this.mUri) != null) {
                    this.gGF.bdJ();
                }
                bsQ();
                return;
            }
            this.gGA.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gGJ != null) {
            this.gGJ.onStart();
        }
        if (this.gGC != null) {
            this.gGC.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (g(this.mUri) != null && this.gGA != null) {
            this.gGF.rX(this.gGA.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bsS();
        if (this.gGA != null) {
            if (this.gGA.isPlaying() && bsV()) {
                y.btx().aO(this.gGW, this.gGA.getCurrentPosition());
            }
            this.gGA.pause();
        }
        if (this.gGJ != null) {
            this.gGJ.onPause();
        }
        this.gGI = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gGF != null) {
            this.gGF.bdM();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gGA != null) {
            return this.gGA.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gGA != null) {
            return this.gGA.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bCP = i;
        tF(i);
    }

    public void tF(int i) {
        if (this.gGS != null) {
            this.gGS.btg();
        }
        if (this.gGA != null) {
            this.gGA.seekTo(i);
        }
        if (this.gGJ != null) {
            this.gGJ.tE(0);
            bsU();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gGA != null) {
            return this.gGA.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gGA != null) {
            this.gGA.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gGN = i;
    }

    public int getRecoveryState() {
        return this.gGN;
    }

    public void setNeedRecovery(boolean z) {
        this.gGO = z;
    }

    public void setLooping(boolean z) {
        this.gGM = z;
    }

    public boolean bsT() {
        return this.gGI;
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
        this.bpS = bVar;
    }

    public void setBusiness(d dVar) {
        this.gGJ = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.byN);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gGM = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gGA != null) {
            this.gGA.Qz();
        }
        if (this.gGS != null) {
            this.gGS.bti();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHu);
        MessageManager.getInstance().unRegisterListener(this.byN);
        if (this.gGR != null) {
            this.gGR.clear();
        }
        if (this.gGG != null) {
            this.gGG.a(null);
            this.gGG.bdB();
        }
    }

    public g getPlayer() {
        return this.gGA;
    }

    public int getPlayerType() {
        return this.gGA == null ? ReportLevel.USER : this.gGA.getPlayerType();
    }

    public void bsU() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHu);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gHu, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gGg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gGJ instanceof n) || ((n) this.gGJ).bte() == null) ? "" : ((n) this.gGJ).bte().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i g(Uri uri) {
        String uri2;
        if (this.gGF != null) {
            return this.gGF;
        }
        if (!StringUtils.isNull(this.gGU)) {
            uri2 = this.gGU;
        } else if (gGE != null && this.gGJ != null && !StringUtils.isNull(this.gGJ.bsE())) {
            uri2 = this.gGJ.bsE();
        } else {
            uri2 = (gGE == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gGE != null) {
            this.gGF = gGE.M(this.bjn, uri2, this.gGH);
        }
        this.gGH = null;
        this.gGX = 0L;
        return this.gGF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsV() {
        return this.gGA != null && this.gGA.getDuration() >= this.gGA.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gGF, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gGF, j);
    }

    public static boolean hr(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gGB = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gGA != null) {
            return this.gGA.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gGA != null ? this.gGA.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.gGF != null) {
            this.gGF.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.gGC = cVar;
    }
}
