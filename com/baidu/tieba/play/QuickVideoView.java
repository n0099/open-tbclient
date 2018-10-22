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
    private static int guP = 0;
    private static int guQ = 1;
    private static int guR = 2;
    private static int guS = 1;
    private static int guT = 0;
    private static h gur;
    private static com.baidu.tieba.j.l gus;
    private String beh;
    private g.b bkN;
    private b bkR;
    private g.c btA;
    private g.e btB;
    private g.InterfaceC0259g btC;
    private g.i btD;
    private g.d btE;
    private g.h btF;
    private final CustomMessageListener btL;
    private g.a bty;
    private g.f btz;
    private int bxQ;
    private int geC;
    private a gtU;
    private boolean guA;
    private int guB;
    private boolean guC;
    private SurfaceTexture guD;
    private boolean guE;
    private com.baidu.tieba.play.b.a guF;
    private r guG;
    private com.baidu.tieba.play.b.f guH;
    private String guI;
    private String guJ;
    private long guK;
    private boolean guL;
    private boolean guM;
    private long guN;
    private long guO;
    private int guU;
    private int guV;
    private int guW;
    private int guX;
    private int guY;
    private int guZ;
    private RenderView gum;
    private String gun;
    private g guo;
    private g.e gup;
    private c guq;
    private com.baidu.tieba.j.i gut;
    private com.baidu.tieba.j.e guu;
    private String guv;
    private boolean guw;
    private d gux;
    private boolean guy;
    private int guz;
    private boolean gva;
    private Runnable gvb;
    private Runnable gvc;
    private TextureView.SurfaceTextureListener gvd;
    private g.f gve;
    private g.a gvf;
    private g.InterfaceC0259g gvg;
    private Runnable gvh;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bpU();
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
            gur = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gus = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.guE = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.guw = false;
        this.guy = false;
        this.guz = 0;
        this.guA = false;
        this.guB = -1;
        this.guC = false;
        this.guD = null;
        this.guE = true;
        this.guN = 0L;
        this.guO = 0L;
        this.geC = guT;
        this.guU = 0;
        this.guV = 0;
        this.guW = -1;
        this.guX = 0;
        this.guY = 0;
        this.guZ = 0;
        this.bxQ = 0;
        this.gva = false;
        this.gvb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.guo != null && QuickVideoView.this.guw) {
                    QuickVideoView.this.b(QuickVideoView.this.guo, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gvc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.jC(false);
                }
            }
        };
        this.gvd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gva) {
                    QuickVideoView.this.gva = false;
                    QuickVideoView.this.guo.c(surfaceTexture);
                } else if (QuickVideoView.this.guy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.guo != null && QuickVideoView.this.guC) {
                        QuickVideoView.this.guo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.guB);
                        if (QuickVideoView.this.gtU != null) {
                            QuickVideoView.this.gtU.bpU();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gut.bbi();
                        }
                    }
                } else if (bqo()) {
                    if (QuickVideoView.this.guo != null) {
                        QuickVideoView.this.bqh();
                        QuickVideoView.this.guy = true;
                        QuickVideoView.this.guo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gut.bbh();
                    }
                }
                QuickVideoView.this.guD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gva) {
                    QuickVideoView.this.bqj();
                    QuickVideoView.this.mm(false);
                    if (QuickVideoView.this.guo != null) {
                        if (QuickVideoView.this.guo.isPlaying() && QuickVideoView.this.bqm()) {
                            y.bqO().aM(QuickVideoView.this.guJ, QuickVideoView.this.guo.getCurrentPosition());
                        }
                        QuickVideoView.this.guo.release();
                    }
                    if (QuickVideoView.this.guy) {
                        if (QuickVideoView.this.gux != null) {
                            QuickVideoView.this.gux.onStop();
                        }
                        if (QuickVideoView.this.bkR != null) {
                            QuickVideoView.this.bkR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.guD = null;
                    if (QuickVideoView.this.gut != null && QuickVideoView.this.gut.rC(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.guy = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bqo() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.J(runningTasks)) {
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
        this.gve = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tp;
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.onPrepared();
                }
                if (QuickVideoView.this.gut != null && QuickVideoView.this.guo != null) {
                    QuickVideoView.this.gut.qU(QuickVideoView.this.guo.getPlayerType());
                }
                if (QuickVideoView.this.btz != null) {
                    QuickVideoView.this.btz.onPrepared(gVar);
                }
                if (QuickVideoView.this.gux != null) {
                    long j = 0;
                    if (QuickVideoView.this.guo != null) {
                        j = QuickVideoView.this.guo.getDuration();
                    }
                    QuickVideoView.this.gux.cW(j);
                    QuickVideoView.this.bqi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gux.bqb();
                        QuickVideoView.this.bql();
                    }
                }
                if (QuickVideoView.this.guM && (tp = y.bqO().tp(QuickVideoView.this.guJ)) > 0) {
                    if (QuickVideoView.this.guo.isPlayerReuse()) {
                        if (QuickVideoView.this.guo.getCurrentPosition() == 0) {
                            QuickVideoView.this.sB(tp);
                        }
                    } else {
                        QuickVideoView.this.sB(tp);
                    }
                }
                if (QuickVideoView.this.guw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gum != null && gVar != null) {
                    QuickVideoView.this.gum.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gun) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gun);
                }
                if (QuickVideoView.this.guF != null && QuickVideoView.this.guF.bqU()) {
                    com.baidu.tieba.play.b.e.sF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gvf = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mm(true);
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.rB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gut = null;
                }
                if (!QuickVideoView.this.guA || QuickVideoView.this.gux == null) {
                    if (QuickVideoView.this.gux != null) {
                        QuickVideoView.this.gux.onCompletion();
                    }
                    QuickVideoView.this.guw = false;
                    if (QuickVideoView.this.bty != null) {
                        QuickVideoView.this.bty.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.guv = null;
                QuickVideoView.this.guK = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gux.bpV());
                QuickVideoView.this.start();
            }
        };
        this.btA = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.gux != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bqm()) {
                    QuickVideoView.this.guL = true;
                    y.bqO().aM(QuickVideoView.this.guJ, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kX()) {
                    if (QuickVideoView.this.gut != null) {
                        QuickVideoView.this.guv = QuickVideoView.this.gut.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.guK, QuickVideoView.this.M(QuickVideoView.this.gut.bbm(), i3 + "", QuickVideoView.this.gut.bbn()));
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.guK = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.sD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bkN == null || QuickVideoView.this.bkN.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gvg = new g.InterfaceC0259g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (QuickVideoView.this.guL) {
                    QuickVideoView.this.guL = false;
                    return;
                }
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.bqy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gux != null && z) {
                    QuickVideoView.this.gux.onSeekComplete();
                }
                if (QuickVideoView.this.btC != null) {
                    QuickVideoView.this.btC.b(gVar);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gup != null) {
                    QuickVideoView.this.gup.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.guz = i2;
                    if (QuickVideoView.this.gum != null && gVar != null) {
                        QuickVideoView.this.gum.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guz);
                    }
                }
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.a(i, i2, QuickVideoView.this.gut);
                    return true;
                }
                return true;
            }
        };
        this.btD = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.f(i, i2, str);
                }
            }
        };
        this.btE = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.rD(str);
                }
            }
        };
        this.btF = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.guK = j;
                }
            }
        };
        this.gvh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gux != null && QuickVideoView.this.gux.bpX() && QuickVideoView.this.gux.bpY() && QuickVideoView.this.gux.bpZ() && QuickVideoView.this.guo != null) {
                    int Ty = QuickVideoView.this.guo.Ty();
                    int currentPosition = QuickVideoView.this.guo.getCurrentPosition();
                    int duration = QuickVideoView.this.guo.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guN;
                    boolean z = currentPosition + Ty < duration;
                    if (Ty < QuickVideoView.this.gux.bqa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.guN = currentTimeMillis;
                        QuickVideoView.this.gux.sA(0);
                    }
                    if (QuickVideoView.this.bqk() && currentPosition == QuickVideoView.this.guO && j > 500) {
                        QuickVideoView.this.guN = currentTimeMillis;
                        QuickVideoView.this.gux.sA(0);
                    }
                    QuickVideoView.this.guO = currentPosition;
                    if (QuickVideoView.this.geC == QuickVideoView.guS) {
                        QuickVideoView.this.bql();
                    }
                }
            }
        };
        this.btL = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gux != null) {
                        QuickVideoView.this.gux.bqd();
                    }
                    if (QuickVideoView.this.gut != null) {
                        QuickVideoView.this.gut.rA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.bqj();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guw = false;
        this.guy = false;
        this.guz = 0;
        this.guA = false;
        this.guB = -1;
        this.guC = false;
        this.guD = null;
        this.guE = true;
        this.guN = 0L;
        this.guO = 0L;
        this.geC = guT;
        this.guU = 0;
        this.guV = 0;
        this.guW = -1;
        this.guX = 0;
        this.guY = 0;
        this.guZ = 0;
        this.bxQ = 0;
        this.gva = false;
        this.gvb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.guo != null && QuickVideoView.this.guw) {
                    QuickVideoView.this.b(QuickVideoView.this.guo, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gvc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.jC(false);
                }
            }
        };
        this.gvd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gva) {
                    QuickVideoView.this.gva = false;
                    QuickVideoView.this.guo.c(surfaceTexture);
                } else if (QuickVideoView.this.guy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.guo != null && QuickVideoView.this.guC) {
                        QuickVideoView.this.guo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.guB);
                        if (QuickVideoView.this.gtU != null) {
                            QuickVideoView.this.gtU.bpU();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gut.bbi();
                        }
                    }
                } else if (bqo()) {
                    if (QuickVideoView.this.guo != null) {
                        QuickVideoView.this.bqh();
                        QuickVideoView.this.guy = true;
                        QuickVideoView.this.guo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gut.bbh();
                    }
                }
                QuickVideoView.this.guD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gva) {
                    QuickVideoView.this.bqj();
                    QuickVideoView.this.mm(false);
                    if (QuickVideoView.this.guo != null) {
                        if (QuickVideoView.this.guo.isPlaying() && QuickVideoView.this.bqm()) {
                            y.bqO().aM(QuickVideoView.this.guJ, QuickVideoView.this.guo.getCurrentPosition());
                        }
                        QuickVideoView.this.guo.release();
                    }
                    if (QuickVideoView.this.guy) {
                        if (QuickVideoView.this.gux != null) {
                            QuickVideoView.this.gux.onStop();
                        }
                        if (QuickVideoView.this.bkR != null) {
                            QuickVideoView.this.bkR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.guD = null;
                    if (QuickVideoView.this.gut != null && QuickVideoView.this.gut.rC(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.guy = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bqo() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.J(runningTasks)) {
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
        this.gve = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tp;
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.onPrepared();
                }
                if (QuickVideoView.this.gut != null && QuickVideoView.this.guo != null) {
                    QuickVideoView.this.gut.qU(QuickVideoView.this.guo.getPlayerType());
                }
                if (QuickVideoView.this.btz != null) {
                    QuickVideoView.this.btz.onPrepared(gVar);
                }
                if (QuickVideoView.this.gux != null) {
                    long j = 0;
                    if (QuickVideoView.this.guo != null) {
                        j = QuickVideoView.this.guo.getDuration();
                    }
                    QuickVideoView.this.gux.cW(j);
                    QuickVideoView.this.bqi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gux.bqb();
                        QuickVideoView.this.bql();
                    }
                }
                if (QuickVideoView.this.guM && (tp = y.bqO().tp(QuickVideoView.this.guJ)) > 0) {
                    if (QuickVideoView.this.guo.isPlayerReuse()) {
                        if (QuickVideoView.this.guo.getCurrentPosition() == 0) {
                            QuickVideoView.this.sB(tp);
                        }
                    } else {
                        QuickVideoView.this.sB(tp);
                    }
                }
                if (QuickVideoView.this.guw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gum != null && gVar != null) {
                    QuickVideoView.this.gum.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gun) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gun);
                }
                if (QuickVideoView.this.guF != null && QuickVideoView.this.guF.bqU()) {
                    com.baidu.tieba.play.b.e.sF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gvf = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mm(true);
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.rB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gut = null;
                }
                if (!QuickVideoView.this.guA || QuickVideoView.this.gux == null) {
                    if (QuickVideoView.this.gux != null) {
                        QuickVideoView.this.gux.onCompletion();
                    }
                    QuickVideoView.this.guw = false;
                    if (QuickVideoView.this.bty != null) {
                        QuickVideoView.this.bty.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.guv = null;
                QuickVideoView.this.guK = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gux.bpV());
                QuickVideoView.this.start();
            }
        };
        this.btA = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.gux != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bqm()) {
                    QuickVideoView.this.guL = true;
                    y.bqO().aM(QuickVideoView.this.guJ, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kX()) {
                    if (QuickVideoView.this.gut != null) {
                        QuickVideoView.this.guv = QuickVideoView.this.gut.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.guK, QuickVideoView.this.M(QuickVideoView.this.gut.bbm(), i3 + "", QuickVideoView.this.gut.bbn()));
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.guK = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.sD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bkN == null || QuickVideoView.this.bkN.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gvg = new g.InterfaceC0259g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (QuickVideoView.this.guL) {
                    QuickVideoView.this.guL = false;
                    return;
                }
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.bqy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gux != null && z) {
                    QuickVideoView.this.gux.onSeekComplete();
                }
                if (QuickVideoView.this.btC != null) {
                    QuickVideoView.this.btC.b(gVar);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gup != null) {
                    QuickVideoView.this.gup.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.guz = i2;
                    if (QuickVideoView.this.gum != null && gVar != null) {
                        QuickVideoView.this.gum.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guz);
                    }
                }
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.a(i, i2, QuickVideoView.this.gut);
                    return true;
                }
                return true;
            }
        };
        this.btD = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.f(i, i2, str);
                }
            }
        };
        this.btE = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.rD(str);
                }
            }
        };
        this.btF = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.guK = j;
                }
            }
        };
        this.gvh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gux != null && QuickVideoView.this.gux.bpX() && QuickVideoView.this.gux.bpY() && QuickVideoView.this.gux.bpZ() && QuickVideoView.this.guo != null) {
                    int Ty = QuickVideoView.this.guo.Ty();
                    int currentPosition = QuickVideoView.this.guo.getCurrentPosition();
                    int duration = QuickVideoView.this.guo.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guN;
                    boolean z = currentPosition + Ty < duration;
                    if (Ty < QuickVideoView.this.gux.bqa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.guN = currentTimeMillis;
                        QuickVideoView.this.gux.sA(0);
                    }
                    if (QuickVideoView.this.bqk() && currentPosition == QuickVideoView.this.guO && j > 500) {
                        QuickVideoView.this.guN = currentTimeMillis;
                        QuickVideoView.this.gux.sA(0);
                    }
                    QuickVideoView.this.guO = currentPosition;
                    if (QuickVideoView.this.geC == QuickVideoView.guS) {
                        QuickVideoView.this.bql();
                    }
                }
            }
        };
        this.btL = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gux != null) {
                        QuickVideoView.this.gux.bqd();
                    }
                    if (QuickVideoView.this.gut != null) {
                        QuickVideoView.this.gut.rA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.bqj();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.guw = false;
        this.guy = false;
        this.guz = 0;
        this.guA = false;
        this.guB = -1;
        this.guC = false;
        this.guD = null;
        this.guE = true;
        this.guN = 0L;
        this.guO = 0L;
        this.geC = guT;
        this.guU = 0;
        this.guV = 0;
        this.guW = -1;
        this.guX = 0;
        this.guY = 0;
        this.guZ = 0;
        this.bxQ = 0;
        this.gva = false;
        this.gvb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.guo != null && QuickVideoView.this.guw) {
                    QuickVideoView.this.b(QuickVideoView.this.guo, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gvc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.jC(false);
                }
            }
        };
        this.gvd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gva) {
                    QuickVideoView.this.gva = false;
                    QuickVideoView.this.guo.c(surfaceTexture);
                } else if (QuickVideoView.this.guy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.guo != null && QuickVideoView.this.guC) {
                        QuickVideoView.this.guo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.guB);
                        if (QuickVideoView.this.gtU != null) {
                            QuickVideoView.this.gtU.bpU();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gut.bbi();
                        }
                    }
                } else if (bqo()) {
                    if (QuickVideoView.this.guo != null) {
                        QuickVideoView.this.bqh();
                        QuickVideoView.this.guy = true;
                        QuickVideoView.this.guo.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gut.bbh();
                    }
                }
                QuickVideoView.this.guD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gva) {
                    QuickVideoView.this.bqj();
                    QuickVideoView.this.mm(false);
                    if (QuickVideoView.this.guo != null) {
                        if (QuickVideoView.this.guo.isPlaying() && QuickVideoView.this.bqm()) {
                            y.bqO().aM(QuickVideoView.this.guJ, QuickVideoView.this.guo.getCurrentPosition());
                        }
                        QuickVideoView.this.guo.release();
                    }
                    if (QuickVideoView.this.guy) {
                        if (QuickVideoView.this.gux != null) {
                            QuickVideoView.this.gux.onStop();
                        }
                        if (QuickVideoView.this.bkR != null) {
                            QuickVideoView.this.bkR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.guD = null;
                    if (QuickVideoView.this.gut != null && QuickVideoView.this.gut.rC(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.guy = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bqo() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.J(runningTasks)) {
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
        this.gve = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tp;
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.onPrepared();
                }
                if (QuickVideoView.this.gut != null && QuickVideoView.this.guo != null) {
                    QuickVideoView.this.gut.qU(QuickVideoView.this.guo.getPlayerType());
                }
                if (QuickVideoView.this.btz != null) {
                    QuickVideoView.this.btz.onPrepared(gVar);
                }
                if (QuickVideoView.this.gux != null) {
                    long j = 0;
                    if (QuickVideoView.this.guo != null) {
                        j = QuickVideoView.this.guo.getDuration();
                    }
                    QuickVideoView.this.gux.cW(j);
                    QuickVideoView.this.bqi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gux.bqb();
                        QuickVideoView.this.bql();
                    }
                }
                if (QuickVideoView.this.guM && (tp = y.bqO().tp(QuickVideoView.this.guJ)) > 0) {
                    if (QuickVideoView.this.guo.isPlayerReuse()) {
                        if (QuickVideoView.this.guo.getCurrentPosition() == 0) {
                            QuickVideoView.this.sB(tp);
                        }
                    } else {
                        QuickVideoView.this.sB(tp);
                    }
                }
                if (QuickVideoView.this.guw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gum != null && gVar != null) {
                    QuickVideoView.this.gum.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gun) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gun);
                }
                if (QuickVideoView.this.guF != null && QuickVideoView.this.guF.bqU()) {
                    com.baidu.tieba.play.b.e.sF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gvf = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mm(true);
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.rB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gut = null;
                }
                if (!QuickVideoView.this.guA || QuickVideoView.this.gux == null) {
                    if (QuickVideoView.this.gux != null) {
                        QuickVideoView.this.gux.onCompletion();
                    }
                    QuickVideoView.this.guw = false;
                    if (QuickVideoView.this.bty != null) {
                        QuickVideoView.this.bty.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.guv = null;
                QuickVideoView.this.guK = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gux.bpV());
                QuickVideoView.this.start();
            }
        };
        this.btA = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.gux != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bqm()) {
                    QuickVideoView.this.guL = true;
                    y.bqO().aM(QuickVideoView.this.guJ, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kX()) {
                    if (QuickVideoView.this.gut != null) {
                        QuickVideoView.this.guv = QuickVideoView.this.gut.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.guK, QuickVideoView.this.M(QuickVideoView.this.gut.bbm(), i3 + "", QuickVideoView.this.gut.bbn()));
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.guK = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.sD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bkN == null || QuickVideoView.this.bkN.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gvg = new g.InterfaceC0259g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (QuickVideoView.this.guL) {
                    QuickVideoView.this.guL = false;
                    return;
                }
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.bqy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gux != null && z) {
                    QuickVideoView.this.gux.onSeekComplete();
                }
                if (QuickVideoView.this.btC != null) {
                    QuickVideoView.this.btC.b(gVar);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gup != null) {
                    QuickVideoView.this.gup.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.guz = i22;
                    if (QuickVideoView.this.gum != null && gVar != null) {
                        QuickVideoView.this.gum.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guz);
                    }
                }
                if (QuickVideoView.this.guG != null) {
                    QuickVideoView.this.guG.a(i2, i22, QuickVideoView.this.gut);
                    return true;
                }
                return true;
            }
        };
        this.btD = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.f(i2, i22, str);
                }
            }
        };
        this.btE = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gut != null) {
                    QuickVideoView.this.gut.rD(str);
                }
            }
        };
        this.btF = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.guK = j;
                }
            }
        };
        this.gvh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gux != null && QuickVideoView.this.gux.bpX() && QuickVideoView.this.gux.bpY() && QuickVideoView.this.gux.bpZ() && QuickVideoView.this.guo != null) {
                    int Ty = QuickVideoView.this.guo.Ty();
                    int currentPosition = QuickVideoView.this.guo.getCurrentPosition();
                    int duration = QuickVideoView.this.guo.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guN;
                    boolean z = currentPosition + Ty < duration;
                    if (Ty < QuickVideoView.this.gux.bqa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.guN = currentTimeMillis;
                        QuickVideoView.this.gux.sA(0);
                    }
                    if (QuickVideoView.this.bqk() && currentPosition == QuickVideoView.this.guO && j > 500) {
                        QuickVideoView.this.guN = currentTimeMillis;
                        QuickVideoView.this.gux.sA(0);
                    }
                    QuickVideoView.this.guO = currentPosition;
                    if (QuickVideoView.this.geC == QuickVideoView.guS) {
                        QuickVideoView.this.bql();
                    }
                }
            }
        };
        this.btL = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gux != null) {
                        QuickVideoView.this.gux.bqd();
                    }
                    if (QuickVideoView.this.gut != null) {
                        QuickVideoView.this.gut.rA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gut = null;
                    }
                    QuickVideoView.this.bqj();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gum = new RenderView(context);
        this.gum.setSurfaceTextureListener(this.gvd);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.guE) {
            addView(this.gum, layoutParams);
        } else {
            addView(this.gum, 0, layoutParams);
        }
        if (gur != null) {
            this.guo = gur.Tz();
        }
        if (this.guo != null) {
            this.guo.setOnPreparedListener(this.gve);
            this.guo.setOnCompletionListener(this.gvf);
            this.guo.a(this.btA);
            this.guo.setOnSeekCompleteListener(this.gvg);
            this.guo.a(this.btB);
            this.guo.a(this.btD);
            this.guo.a(this.btE);
            this.guo.a(this.btF);
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
        this.guF = new com.baidu.tieba.play.b.a(this);
        this.guG = new r();
        this.guH = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iR().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.guM = z;
    }

    public void setVideoPath(String str, String str2) {
        this.beh = str2;
        if (this.guF != null) {
            this.guF.clear();
            this.guF.bqU();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.tu(str2);
            if (gus != null) {
                this.gut = gus.L(this.beh, str, "");
                if (this.gut != null) {
                    this.gut.a(ReportLevel.USER, -44399, -44399, getLocateSource(), false, this.guK, "");
                    this.gut = null;
                }
            }
        }
        if (this.guu != null) {
            this.guu.a(null);
            this.guu.bba();
            this.guu = null;
        }
        this.guv = null;
        this.guK = 0L;
        setVideoPath(str);
    }

    public void co(String str, String str2) {
    }

    private String tl(String str) {
        if (!ao.isEmpty(str) && com.baidu.tieba.video.g.bGn().bGo()) {
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
            String tl = tl(str);
            this.guI = tl;
            if (this.gux != null) {
                tl = this.gux.jg(tl);
                if (this.gux.bqc() != null) {
                    this.gux.bqc().setPlayer(this);
                }
                if (gus != null && gJ(tl)) {
                    this.guu = gus.rG(tl);
                }
                if (this.guu != null) {
                    this.guu.a(new com.baidu.tieba.play.monitor.a(this.beh, this.guI, this.gut));
                    this.guu.baZ();
                }
                tm(tl);
            }
            if (!com.baidu.adp.lib.util.j.kX() && !gJ(tl)) {
                if (this.bkN != null) {
                    this.bkN.onError(this.guo, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(tl));
            if (this.gut != null) {
                if (f(Uri.parse(tl)) != null) {
                    this.gut.bbg();
                }
                this.gut.report();
                this.gut = null;
            }
            this.guJ = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqh() {
        if (com.baidu.tbadk.coreExtra.model.f.ID()) {
            if (this.gux != null && (this.gux.bpW() || this.gux.bpX())) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvb);
                com.baidu.adp.lib.g.e.jI().postDelayed(this.gvb, com.baidu.tbadk.coreExtra.model.f.IC());
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvc);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.gvc, com.baidu.tbadk.coreExtra.model.f.IB());
        }
    }

    public void bpy() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.gut.rz(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            Tu();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.guz = 0;
        if (this.guD != null) {
            bqh();
            if (this.guo != null) {
                if (!this.guy) {
                    this.guy = true;
                    this.guo.a(this.mContext, this.mUri, this.mHeaders, this.guD, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gve.onPrepared(this.guo);
                }
            }
        } else if (this.gum != null && this.gum.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.guE) {
                addView(this.gum, layoutParams);
            } else {
                addView(this.gum, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void Tu() {
        this.guy = false;
        this.guw = false;
        if (this.guo != null) {
            if (this.guo.isPlaying() && bqm()) {
                y.bqO().aM(this.guJ, this.guo.getCurrentPosition());
            }
            this.guo.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvh);
    }

    private void tm(String str) {
        this.guV = 0;
        this.guW = 0;
        this.guX = 0;
        this.guY = 0;
        this.guZ = 0;
        this.bxQ = 0;
        if (this.gux.bpX()) {
            this.guU = guQ;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.guW = (int) u.to(QuickVideoView.this.guI);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.guI != null && this.guI.equals(str)) {
            this.guU = guP;
        } else {
            this.guU = guR;
        }
        this.geC = guS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqi() {
        this.geC = guS;
        if (this.guo != null) {
            this.guV = this.guo.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(boolean z) {
        if (this.geC == guS && this.guo != null) {
            this.geC = guT;
            this.guY = this.guo.getDuration();
            if (z) {
                this.guZ = 0;
                this.guX = this.guY;
            } else {
                this.guX = this.guo.getCurrentPosition();
                this.guZ = this.guo.getCachedSize();
            }
            if (this.guX > 0) {
                if (this.guU == guP) {
                    this.guW = (int) u.to(this.guI);
                    if (this.guV > 0) {
                        long j = (this.guV * (this.guX / 1000)) / 8;
                        if (this.guZ < 0) {
                            this.guZ = 0;
                        }
                        long j2 = this.guZ + j;
                        if (this.guW > 0) {
                            j2 += this.guW;
                        }
                        setFlowCount(j2, this.guX, this.guY, this.bxQ);
                    } else if (this.guV == -1) {
                        this.guV = 603327;
                        setFlowCount((this.guV * (this.guX / 1000)) / 8, this.guX, this.guY, this.bxQ);
                    }
                } else if (this.guU == guQ) {
                    if (this.guV > 0) {
                        long j3 = (this.guV * (this.guX / 1000)) / 8;
                        if (this.guZ < 0) {
                            this.guZ = 0;
                        }
                        long j4 = this.guZ + j3;
                        if (this.guW > 0) {
                            j4 -= this.guW;
                        }
                        setFlowCount(j4, this.guX, this.guY, this.bxQ);
                    } else if (this.guV == -1) {
                        this.guV = 603327;
                        setFlowCount((this.guV * (this.guX / 1000)) / 8, this.guX, this.guY, this.bxQ);
                    }
                } else {
                    setFlowCount(0L, this.guX, this.guY, this.bxQ);
                }
            }
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvh);
    }

    public void stopPlayback() {
        bqj();
        mm(false);
        if (this.guF != null) {
            this.guF.clear();
        }
        this.gun = null;
        Tu();
        this.guA = false;
        if (this.gux != null) {
            this.gux.onStop();
        }
        com.baidu.tieba.play.a.b.bqR().a((b.InterfaceC0256b) null);
        if (this.gut != null && this.gut.rC(getLocateSource())) {
            this.gut = null;
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvh);
    }

    public void setFullScreenToDestroySurface() {
        this.gva = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqj() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvb);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvc);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.btz = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bty = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bkN = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0259g interfaceC0259g) {
        this.btC = interfaceC0259g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String M(String str, String str2, String str3) {
        if (this.guH == null) {
            return "";
        }
        String bqW = this.guH.bqW();
        this.guH.N(str, str2, str3);
        return bqW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gux != null && !StringUtils.isNull(this.gux.bpV())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.tt(uri);
                }
            }
            this.mUri = Uri.parse(this.gux.bpV());
        }
        boolean z = false;
        if (this.guF != null) {
            z = this.guF.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gut != null) {
            this.guv = this.gut.a(i, i2, i3, getLocateSource(), z, this.guK, M(this.gut.bbm(), i3 + "", this.gut.bbn()));
            this.gut = null;
        }
        this.guK = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.guo != null) {
            try {
                if (this.guo.isPlaying() && bqm()) {
                    y.bqO().aM(this.guJ, this.guo.getCurrentPosition());
                }
                this.guo.release();
                this.gun = str;
                URI uri = new URI(this.mUri.toString());
                this.guo.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.guD, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (f(this.mUri) != null) {
                    this.gut.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.guo != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.guo.isPlaying() && bqm()) {
                y.bqO().aM(this.guJ, this.guo.getCurrentPosition());
            }
            this.guo.release();
            this.guo.a(this.mContext, this.mUri, this.mHeaders, this.guD, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gut.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.guo != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.guo.forceUseSystemMediaPlayer(true);
            }
            if (this.guo.isPlaying() && bqm()) {
                y.bqO().aM(this.guJ, this.guo.getCurrentPosition());
            }
            this.guo.release();
            this.guo.a(this.mContext, this.mUri, this.mHeaders, this.guD, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gut.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.guw = true;
        if (this.guo != null) {
            if (this.guD != null && this.guC && !this.guo.isExistInRemote()) {
                this.guo.a(this.mContext, this.mUri, this.mHeaders, this.guD, this.guB);
                if (this.gtU != null) {
                    this.gtU.bpU();
                }
                if (f(this.mUri) != null) {
                    this.gut.bbi();
                }
                bqh();
                return;
            }
            this.guo.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gux != null) {
            this.gux.onStart();
        }
        if (this.guq != null) {
            this.guq.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null && this.guo != null) {
            this.gut.qV(this.guo.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bqj();
        if (this.guo != null) {
            if (this.guo.isPlaying() && bqm()) {
                y.bqO().aM(this.guJ, this.guo.getCurrentPosition());
            }
            this.guo.pause();
        }
        if (this.gux != null) {
            this.gux.onPause();
        }
        this.guw = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gut != null) {
            this.gut.bbl();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.guo != null) {
            return this.guo.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.guo != null) {
            return this.guo.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bxQ = i;
        sB(i);
    }

    public void sB(int i) {
        if (this.guG != null) {
            this.guG.bqx();
        }
        if (this.guo != null) {
            this.guo.seekTo(i);
        }
        if (this.gux != null) {
            this.gux.sA(0);
            bql();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.guo != null) {
            return this.guo.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.guo != null) {
            this.guo.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.guB = i;
    }

    public int getRecoveryState() {
        return this.guB;
    }

    public void setNeedRecovery(boolean z) {
        this.guC = z;
    }

    public void setLooping(boolean z) {
        this.guA = z;
    }

    public boolean bqk() {
        return this.guw;
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
        this.bkR = bVar;
    }

    public void setBusiness(d dVar) {
        this.gux = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.btL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.guA = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.guo != null) {
            this.guo.ON();
        }
        if (this.guG != null) {
            this.guG.bqz();
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvh);
        MessageManager.getInstance().unRegisterListener(this.btL);
        if (this.guF != null) {
            this.guF.clear();
        }
        if (this.guu != null) {
            this.guu.a(null);
            this.guu.bba();
        }
    }

    public g getPlayer() {
        return this.guo;
    }

    public int getPlayerType() {
        return this.guo == null ? ReportLevel.USER : this.guo.getPlayerType();
    }

    public void bql() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvh);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvh, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gtU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gux instanceof n) || ((n) this.gux).bqv() == null) ? "" : ((n) this.gux).bqv().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.gut != null) {
            return this.gut;
        }
        if (!StringUtils.isNull(this.guI)) {
            uri2 = this.guI;
        } else if (gus != null && this.gux != null && !StringUtils.isNull(this.gux.bpV())) {
            uri2 = this.gux.bpV();
        } else {
            uri2 = (gus == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gus != null) {
            this.gut = gus.L(this.beh, uri2, this.guv);
        }
        this.guv = null;
        this.guK = 0L;
        return this.gut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqm() {
        return this.guo != null && this.guo.getDuration() >= this.guo.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gut, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gut, j);
    }

    public static boolean gJ(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gup = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.guo != null) {
            return this.guo.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.guo != null ? this.guo.getId() : "";
    }

    public void setVideoStatusListener(c cVar) {
        this.guq = cVar;
    }
}
