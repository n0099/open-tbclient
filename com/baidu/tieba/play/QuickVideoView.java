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
    private static int guO = 0;
    private static int guP = 1;
    private static int guQ = 2;
    private static int guR = 1;
    private static int guS = 0;
    private static h guq;
    private static com.baidu.tieba.j.l gur;
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
    private int geB;
    private a gtT;
    private int guA;
    private boolean guB;
    private SurfaceTexture guC;
    private boolean guD;
    private com.baidu.tieba.play.b.a guE;
    private r guF;
    private com.baidu.tieba.play.b.f guG;
    private String guH;
    private String guI;
    private long guJ;
    private boolean guK;
    private boolean guL;
    private long guM;
    private long guN;
    private int guT;
    private int guU;
    private int guV;
    private int guW;
    private int guX;
    private int guY;
    private boolean guZ;
    private RenderView gul;
    private String gum;
    private g gun;
    private g.e guo;
    private c gup;
    private com.baidu.tieba.j.i gus;
    private com.baidu.tieba.j.e gut;
    private String guu;
    private boolean guv;
    private d guw;
    private boolean gux;
    private int guy;
    private boolean guz;
    private Runnable gva;
    private Runnable gvb;
    private TextureView.SurfaceTextureListener gvc;
    private g.f gvd;
    private g.a gve;
    private g.InterfaceC0259g gvf;
    private Runnable gvg;
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
            guq = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gur = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.guD = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.guv = false;
        this.gux = false;
        this.guy = 0;
        this.guz = false;
        this.guA = -1;
        this.guB = false;
        this.guC = null;
        this.guD = true;
        this.guM = 0L;
        this.guN = 0L;
        this.geB = guS;
        this.guT = 0;
        this.guU = 0;
        this.guV = -1;
        this.guW = 0;
        this.guX = 0;
        this.guY = 0;
        this.bxQ = 0;
        this.guZ = false;
        this.gva = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gun != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gun, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gvb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.jC(false);
                }
            }
        };
        this.gvc = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.guZ) {
                    QuickVideoView.this.guZ = false;
                    QuickVideoView.this.gun.c(surfaceTexture);
                } else if (QuickVideoView.this.gux || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gun != null && QuickVideoView.this.guB) {
                        QuickVideoView.this.gun.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.guA);
                        if (QuickVideoView.this.gtT != null) {
                            QuickVideoView.this.gtT.bpU();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gus.bbi();
                        }
                    }
                } else if (bqo()) {
                    if (QuickVideoView.this.gun != null) {
                        QuickVideoView.this.bqh();
                        QuickVideoView.this.gux = true;
                        QuickVideoView.this.gun.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gus.bbh();
                    }
                }
                QuickVideoView.this.guC = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.guZ) {
                    QuickVideoView.this.bqj();
                    QuickVideoView.this.mm(false);
                    if (QuickVideoView.this.gun != null) {
                        if (QuickVideoView.this.gun.isPlaying() && QuickVideoView.this.bqm()) {
                            y.bqO().aM(QuickVideoView.this.guI, QuickVideoView.this.gun.getCurrentPosition());
                        }
                        QuickVideoView.this.gun.release();
                    }
                    if (QuickVideoView.this.gux) {
                        if (QuickVideoView.this.guw != null) {
                            QuickVideoView.this.guw.onStop();
                        }
                        if (QuickVideoView.this.bkR != null) {
                            QuickVideoView.this.bkR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.guC = null;
                    if (QuickVideoView.this.gus != null && QuickVideoView.this.gus.rC(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.gux = false;
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
        this.gvd = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tp;
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.onPrepared();
                }
                if (QuickVideoView.this.gus != null && QuickVideoView.this.gun != null) {
                    QuickVideoView.this.gus.qU(QuickVideoView.this.gun.getPlayerType());
                }
                if (QuickVideoView.this.btz != null) {
                    QuickVideoView.this.btz.onPrepared(gVar);
                }
                if (QuickVideoView.this.guw != null) {
                    long j = 0;
                    if (QuickVideoView.this.gun != null) {
                        j = QuickVideoView.this.gun.getDuration();
                    }
                    QuickVideoView.this.guw.cW(j);
                    QuickVideoView.this.bqi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.guw.bqb();
                        QuickVideoView.this.bql();
                    }
                }
                if (QuickVideoView.this.guL && (tp = y.bqO().tp(QuickVideoView.this.guI)) > 0) {
                    if (QuickVideoView.this.gun.isPlayerReuse()) {
                        if (QuickVideoView.this.gun.getCurrentPosition() == 0) {
                            QuickVideoView.this.sB(tp);
                        }
                    } else {
                        QuickVideoView.this.sB(tp);
                    }
                }
                if (QuickVideoView.this.guv) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gul != null && gVar != null) {
                    QuickVideoView.this.gul.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guy);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gum) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gum);
                }
                if (QuickVideoView.this.guE != null && QuickVideoView.this.guE.bqU()) {
                    com.baidu.tieba.play.b.e.sF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gve = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mm(true);
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.rB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gus = null;
                }
                if (!QuickVideoView.this.guz || QuickVideoView.this.guw == null) {
                    if (QuickVideoView.this.guw != null) {
                        QuickVideoView.this.guw.onCompletion();
                    }
                    QuickVideoView.this.guv = false;
                    if (QuickVideoView.this.bty != null) {
                        QuickVideoView.this.bty.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.guu = null;
                QuickVideoView.this.guJ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.guw.bpV());
                QuickVideoView.this.start();
            }
        };
        this.btA = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guw != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bqm()) {
                    QuickVideoView.this.guK = true;
                    y.bqO().aM(QuickVideoView.this.guI, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kX()) {
                    if (QuickVideoView.this.gus != null) {
                        QuickVideoView.this.guu = QuickVideoView.this.gus.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.guJ, QuickVideoView.this.M(QuickVideoView.this.gus.bbm(), i3 + "", QuickVideoView.this.gus.bbn()));
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.guJ = 0L;
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
        this.gvf = new g.InterfaceC0259g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (QuickVideoView.this.guK) {
                    QuickVideoView.this.guK = false;
                    return;
                }
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.bqy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.guw != null && z) {
                    QuickVideoView.this.guw.onSeekComplete();
                }
                if (QuickVideoView.this.btC != null) {
                    QuickVideoView.this.btC.b(gVar);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.guo != null) {
                    QuickVideoView.this.guo.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.guy = i2;
                    if (QuickVideoView.this.gul != null && gVar != null) {
                        QuickVideoView.this.gul.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guy);
                    }
                }
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.a(i, i2, QuickVideoView.this.gus);
                    return true;
                }
                return true;
            }
        };
        this.btD = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.f(i, i2, str);
                }
            }
        };
        this.btE = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.rD(str);
                }
            }
        };
        this.btF = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.guJ = j;
                }
            }
        };
        this.gvg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.guw != null && QuickVideoView.this.guw.bpX() && QuickVideoView.this.guw.bpY() && QuickVideoView.this.guw.bpZ() && QuickVideoView.this.gun != null) {
                    int Ty = QuickVideoView.this.gun.Ty();
                    int currentPosition = QuickVideoView.this.gun.getCurrentPosition();
                    int duration = QuickVideoView.this.gun.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guM;
                    boolean z = currentPosition + Ty < duration;
                    if (Ty < QuickVideoView.this.guw.bqa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.guM = currentTimeMillis;
                        QuickVideoView.this.guw.sA(0);
                    }
                    if (QuickVideoView.this.bqk() && currentPosition == QuickVideoView.this.guN && j > 500) {
                        QuickVideoView.this.guM = currentTimeMillis;
                        QuickVideoView.this.guw.sA(0);
                    }
                    QuickVideoView.this.guN = currentPosition;
                    if (QuickVideoView.this.geB == QuickVideoView.guR) {
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
                    if (QuickVideoView.this.guw != null) {
                        QuickVideoView.this.guw.bqd();
                    }
                    if (QuickVideoView.this.gus != null) {
                        QuickVideoView.this.gus.rA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.bqj();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guv = false;
        this.gux = false;
        this.guy = 0;
        this.guz = false;
        this.guA = -1;
        this.guB = false;
        this.guC = null;
        this.guD = true;
        this.guM = 0L;
        this.guN = 0L;
        this.geB = guS;
        this.guT = 0;
        this.guU = 0;
        this.guV = -1;
        this.guW = 0;
        this.guX = 0;
        this.guY = 0;
        this.bxQ = 0;
        this.guZ = false;
        this.gva = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gun != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gun, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gvb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.jC(false);
                }
            }
        };
        this.gvc = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.guZ) {
                    QuickVideoView.this.guZ = false;
                    QuickVideoView.this.gun.c(surfaceTexture);
                } else if (QuickVideoView.this.gux || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gun != null && QuickVideoView.this.guB) {
                        QuickVideoView.this.gun.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.guA);
                        if (QuickVideoView.this.gtT != null) {
                            QuickVideoView.this.gtT.bpU();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gus.bbi();
                        }
                    }
                } else if (bqo()) {
                    if (QuickVideoView.this.gun != null) {
                        QuickVideoView.this.bqh();
                        QuickVideoView.this.gux = true;
                        QuickVideoView.this.gun.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gus.bbh();
                    }
                }
                QuickVideoView.this.guC = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.guZ) {
                    QuickVideoView.this.bqj();
                    QuickVideoView.this.mm(false);
                    if (QuickVideoView.this.gun != null) {
                        if (QuickVideoView.this.gun.isPlaying() && QuickVideoView.this.bqm()) {
                            y.bqO().aM(QuickVideoView.this.guI, QuickVideoView.this.gun.getCurrentPosition());
                        }
                        QuickVideoView.this.gun.release();
                    }
                    if (QuickVideoView.this.gux) {
                        if (QuickVideoView.this.guw != null) {
                            QuickVideoView.this.guw.onStop();
                        }
                        if (QuickVideoView.this.bkR != null) {
                            QuickVideoView.this.bkR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.guC = null;
                    if (QuickVideoView.this.gus != null && QuickVideoView.this.gus.rC(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.gux = false;
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
        this.gvd = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tp;
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.onPrepared();
                }
                if (QuickVideoView.this.gus != null && QuickVideoView.this.gun != null) {
                    QuickVideoView.this.gus.qU(QuickVideoView.this.gun.getPlayerType());
                }
                if (QuickVideoView.this.btz != null) {
                    QuickVideoView.this.btz.onPrepared(gVar);
                }
                if (QuickVideoView.this.guw != null) {
                    long j = 0;
                    if (QuickVideoView.this.gun != null) {
                        j = QuickVideoView.this.gun.getDuration();
                    }
                    QuickVideoView.this.guw.cW(j);
                    QuickVideoView.this.bqi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.guw.bqb();
                        QuickVideoView.this.bql();
                    }
                }
                if (QuickVideoView.this.guL && (tp = y.bqO().tp(QuickVideoView.this.guI)) > 0) {
                    if (QuickVideoView.this.gun.isPlayerReuse()) {
                        if (QuickVideoView.this.gun.getCurrentPosition() == 0) {
                            QuickVideoView.this.sB(tp);
                        }
                    } else {
                        QuickVideoView.this.sB(tp);
                    }
                }
                if (QuickVideoView.this.guv) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gul != null && gVar != null) {
                    QuickVideoView.this.gul.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guy);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gum) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gum);
                }
                if (QuickVideoView.this.guE != null && QuickVideoView.this.guE.bqU()) {
                    com.baidu.tieba.play.b.e.sF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gve = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mm(true);
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.rB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gus = null;
                }
                if (!QuickVideoView.this.guz || QuickVideoView.this.guw == null) {
                    if (QuickVideoView.this.guw != null) {
                        QuickVideoView.this.guw.onCompletion();
                    }
                    QuickVideoView.this.guv = false;
                    if (QuickVideoView.this.bty != null) {
                        QuickVideoView.this.bty.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.guu = null;
                QuickVideoView.this.guJ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.guw.bpV());
                QuickVideoView.this.start();
            }
        };
        this.btA = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guw != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bqm()) {
                    QuickVideoView.this.guK = true;
                    y.bqO().aM(QuickVideoView.this.guI, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kX()) {
                    if (QuickVideoView.this.gus != null) {
                        QuickVideoView.this.guu = QuickVideoView.this.gus.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.guJ, QuickVideoView.this.M(QuickVideoView.this.gus.bbm(), i3 + "", QuickVideoView.this.gus.bbn()));
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.guJ = 0L;
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
        this.gvf = new g.InterfaceC0259g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (QuickVideoView.this.guK) {
                    QuickVideoView.this.guK = false;
                    return;
                }
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.bqy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.guw != null && z) {
                    QuickVideoView.this.guw.onSeekComplete();
                }
                if (QuickVideoView.this.btC != null) {
                    QuickVideoView.this.btC.b(gVar);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.guo != null) {
                    QuickVideoView.this.guo.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.guy = i2;
                    if (QuickVideoView.this.gul != null && gVar != null) {
                        QuickVideoView.this.gul.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guy);
                    }
                }
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.a(i, i2, QuickVideoView.this.gus);
                    return true;
                }
                return true;
            }
        };
        this.btD = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.f(i, i2, str);
                }
            }
        };
        this.btE = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.rD(str);
                }
            }
        };
        this.btF = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.guJ = j;
                }
            }
        };
        this.gvg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.guw != null && QuickVideoView.this.guw.bpX() && QuickVideoView.this.guw.bpY() && QuickVideoView.this.guw.bpZ() && QuickVideoView.this.gun != null) {
                    int Ty = QuickVideoView.this.gun.Ty();
                    int currentPosition = QuickVideoView.this.gun.getCurrentPosition();
                    int duration = QuickVideoView.this.gun.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guM;
                    boolean z = currentPosition + Ty < duration;
                    if (Ty < QuickVideoView.this.guw.bqa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.guM = currentTimeMillis;
                        QuickVideoView.this.guw.sA(0);
                    }
                    if (QuickVideoView.this.bqk() && currentPosition == QuickVideoView.this.guN && j > 500) {
                        QuickVideoView.this.guM = currentTimeMillis;
                        QuickVideoView.this.guw.sA(0);
                    }
                    QuickVideoView.this.guN = currentPosition;
                    if (QuickVideoView.this.geB == QuickVideoView.guR) {
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
                    if (QuickVideoView.this.guw != null) {
                        QuickVideoView.this.guw.bqd();
                    }
                    if (QuickVideoView.this.gus != null) {
                        QuickVideoView.this.gus.rA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.bqj();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.guv = false;
        this.gux = false;
        this.guy = 0;
        this.guz = false;
        this.guA = -1;
        this.guB = false;
        this.guC = null;
        this.guD = true;
        this.guM = 0L;
        this.guN = 0L;
        this.geB = guS;
        this.guT = 0;
        this.guU = 0;
        this.guV = -1;
        this.guW = 0;
        this.guX = 0;
        this.guY = 0;
        this.bxQ = 0;
        this.guZ = false;
        this.gva = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gun != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gun, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gvb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.jC(false);
                }
            }
        };
        this.gvc = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.guZ) {
                    QuickVideoView.this.guZ = false;
                    QuickVideoView.this.gun.c(surfaceTexture);
                } else if (QuickVideoView.this.gux || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gun != null && QuickVideoView.this.guB) {
                        QuickVideoView.this.gun.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.guA);
                        if (QuickVideoView.this.gtT != null) {
                            QuickVideoView.this.gtT.bpU();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gus.bbi();
                        }
                    }
                } else if (bqo()) {
                    if (QuickVideoView.this.gun != null) {
                        QuickVideoView.this.bqh();
                        QuickVideoView.this.gux = true;
                        QuickVideoView.this.gun.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gus.bbh();
                    }
                }
                QuickVideoView.this.guC = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.guZ) {
                    QuickVideoView.this.bqj();
                    QuickVideoView.this.mm(false);
                    if (QuickVideoView.this.gun != null) {
                        if (QuickVideoView.this.gun.isPlaying() && QuickVideoView.this.bqm()) {
                            y.bqO().aM(QuickVideoView.this.guI, QuickVideoView.this.gun.getCurrentPosition());
                        }
                        QuickVideoView.this.gun.release();
                    }
                    if (QuickVideoView.this.gux) {
                        if (QuickVideoView.this.guw != null) {
                            QuickVideoView.this.guw.onStop();
                        }
                        if (QuickVideoView.this.bkR != null) {
                            QuickVideoView.this.bkR.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.guC = null;
                    if (QuickVideoView.this.gus != null && QuickVideoView.this.gus.rC(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.gux = false;
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
        this.gvd = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tp;
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.onPrepared();
                }
                if (QuickVideoView.this.gus != null && QuickVideoView.this.gun != null) {
                    QuickVideoView.this.gus.qU(QuickVideoView.this.gun.getPlayerType());
                }
                if (QuickVideoView.this.btz != null) {
                    QuickVideoView.this.btz.onPrepared(gVar);
                }
                if (QuickVideoView.this.guw != null) {
                    long j = 0;
                    if (QuickVideoView.this.gun != null) {
                        j = QuickVideoView.this.gun.getDuration();
                    }
                    QuickVideoView.this.guw.cW(j);
                    QuickVideoView.this.bqi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.guw.bqb();
                        QuickVideoView.this.bql();
                    }
                }
                if (QuickVideoView.this.guL && (tp = y.bqO().tp(QuickVideoView.this.guI)) > 0) {
                    if (QuickVideoView.this.gun.isPlayerReuse()) {
                        if (QuickVideoView.this.gun.getCurrentPosition() == 0) {
                            QuickVideoView.this.sB(tp);
                        }
                    } else {
                        QuickVideoView.this.sB(tp);
                    }
                }
                if (QuickVideoView.this.guv) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gul != null && gVar != null) {
                    QuickVideoView.this.gul.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guy);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gum) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gum);
                }
                if (QuickVideoView.this.guE != null && QuickVideoView.this.guE.bqU()) {
                    com.baidu.tieba.play.b.e.sF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gve = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mm(true);
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.rB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gus = null;
                }
                if (!QuickVideoView.this.guz || QuickVideoView.this.guw == null) {
                    if (QuickVideoView.this.guw != null) {
                        QuickVideoView.this.guw.onCompletion();
                    }
                    QuickVideoView.this.guv = false;
                    if (QuickVideoView.this.bty != null) {
                        QuickVideoView.this.bty.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.guu = null;
                QuickVideoView.this.guJ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.guw.bpV());
                QuickVideoView.this.start();
            }
        };
        this.btA = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.bqj();
                if (QuickVideoView.this.guw != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bqm()) {
                    QuickVideoView.this.guK = true;
                    y.bqO().aM(QuickVideoView.this.guI, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kX()) {
                    if (QuickVideoView.this.gus != null) {
                        QuickVideoView.this.guu = QuickVideoView.this.gus.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.guJ, QuickVideoView.this.M(QuickVideoView.this.gus.bbm(), i3 + "", QuickVideoView.this.gus.bbn()));
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.guJ = 0L;
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
        this.gvf = new g.InterfaceC0259g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0259g
            public void b(g gVar) {
                if (QuickVideoView.this.guK) {
                    QuickVideoView.this.guK = false;
                    return;
                }
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.bqy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.guw != null && z) {
                    QuickVideoView.this.guw.onSeekComplete();
                }
                if (QuickVideoView.this.btC != null) {
                    QuickVideoView.this.btC.b(gVar);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.guo != null) {
                    QuickVideoView.this.guo.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.guy = i22;
                    if (QuickVideoView.this.gul != null && gVar != null) {
                        QuickVideoView.this.gul.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.guy);
                    }
                }
                if (QuickVideoView.this.guF != null) {
                    QuickVideoView.this.guF.a(i2, i22, QuickVideoView.this.gus);
                    return true;
                }
                return true;
            }
        };
        this.btD = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.f(i2, i22, str);
                }
            }
        };
        this.btE = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gus != null) {
                    QuickVideoView.this.gus.rD(str);
                }
            }
        };
        this.btF = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.guJ = j;
                }
            }
        };
        this.gvg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.guw != null && QuickVideoView.this.guw.bpX() && QuickVideoView.this.guw.bpY() && QuickVideoView.this.guw.bpZ() && QuickVideoView.this.gun != null) {
                    int Ty = QuickVideoView.this.gun.Ty();
                    int currentPosition = QuickVideoView.this.gun.getCurrentPosition();
                    int duration = QuickVideoView.this.gun.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guM;
                    boolean z = currentPosition + Ty < duration;
                    if (Ty < QuickVideoView.this.guw.bqa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.guM = currentTimeMillis;
                        QuickVideoView.this.guw.sA(0);
                    }
                    if (QuickVideoView.this.bqk() && currentPosition == QuickVideoView.this.guN && j > 500) {
                        QuickVideoView.this.guM = currentTimeMillis;
                        QuickVideoView.this.guw.sA(0);
                    }
                    QuickVideoView.this.guN = currentPosition;
                    if (QuickVideoView.this.geB == QuickVideoView.guR) {
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
                    if (QuickVideoView.this.guw != null) {
                        QuickVideoView.this.guw.bqd();
                    }
                    if (QuickVideoView.this.gus != null) {
                        QuickVideoView.this.gus.rA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gus = null;
                    }
                    QuickVideoView.this.bqj();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gul = new RenderView(context);
        this.gul.setSurfaceTextureListener(this.gvc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.guD) {
            addView(this.gul, layoutParams);
        } else {
            addView(this.gul, 0, layoutParams);
        }
        if (guq != null) {
            this.gun = guq.Tz();
        }
        if (this.gun != null) {
            this.gun.setOnPreparedListener(this.gvd);
            this.gun.setOnCompletionListener(this.gve);
            this.gun.a(this.btA);
            this.gun.setOnSeekCompleteListener(this.gvf);
            this.gun.a(this.btB);
            this.gun.a(this.btD);
            this.gun.a(this.btE);
            this.gun.a(this.btF);
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
        this.guE = new com.baidu.tieba.play.b.a(this);
        this.guF = new r();
        this.guG = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iR().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.guL = z;
    }

    public void setVideoPath(String str, String str2) {
        this.beh = str2;
        if (this.guE != null) {
            this.guE.clear();
            this.guE.bqU();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.tu(str2);
            if (gur != null) {
                this.gus = gur.L(this.beh, str, "");
                if (this.gus != null) {
                    this.gus.a(ReportLevel.USER, -44399, -44399, getLocateSource(), false, this.guJ, "");
                    this.gus = null;
                }
            }
        }
        if (this.gut != null) {
            this.gut.a(null);
            this.gut.bba();
            this.gut = null;
        }
        this.guu = null;
        this.guJ = 0L;
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
            this.guH = tl;
            if (this.guw != null) {
                str = this.guw.jg(tl);
                if (this.guw.bqc() != null) {
                    this.guw.bqc().setPlayer(this);
                }
                if (gur != null && gJ(tl)) {
                    this.gut = gur.rG(tl);
                }
                if (this.gut != null) {
                    this.gut.a(new com.baidu.tieba.play.monitor.a(this.beh, this.guH, this.gus));
                    this.gut.baZ();
                }
                tm(tl);
            }
            if (!com.baidu.adp.lib.util.j.kX() && !gJ(tl)) {
                if (this.bkN != null) {
                    this.bkN.onError(this.gun, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(tl));
            if (this.gus != null) {
                if (f(Uri.parse(tl)) != null) {
                    this.gus.bbg();
                }
                this.gus.report();
                this.gus = null;
            }
            this.guI = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqh() {
        if (com.baidu.tbadk.coreExtra.model.f.ID()) {
            if (this.guw != null && (this.guw.bpW() || this.guw.bpX())) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gva);
                com.baidu.adp.lib.g.e.jI().postDelayed(this.gva, com.baidu.tbadk.coreExtra.model.f.IC());
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvb);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.gvb, com.baidu.tbadk.coreExtra.model.f.IB());
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
            this.gus.rz(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            Tu();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.guy = 0;
        if (this.guC != null) {
            bqh();
            if (this.gun != null) {
                if (!this.gux) {
                    this.gux = true;
                    this.gun.a(this.mContext, this.mUri, this.mHeaders, this.guC, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gvd.onPrepared(this.gun);
                }
            }
        } else if (this.gul != null && this.gul.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.guD) {
                addView(this.gul, layoutParams);
            } else {
                addView(this.gul, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void Tu() {
        this.gux = false;
        this.guv = false;
        if (this.gun != null) {
            if (this.gun.isPlaying() && bqm()) {
                y.bqO().aM(this.guI, this.gun.getCurrentPosition());
            }
            this.gun.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvg);
    }

    private void tm(String str) {
        this.guU = 0;
        this.guV = 0;
        this.guW = 0;
        this.guX = 0;
        this.guY = 0;
        this.bxQ = 0;
        if (this.guw.bpX()) {
            this.guT = guP;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.guV = (int) u.to(QuickVideoView.this.guH);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.guH != null && this.guH.equals(str)) {
            this.guT = guO;
        } else {
            this.guT = guQ;
        }
        this.geB = guR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqi() {
        this.geB = guR;
        if (this.gun != null) {
            this.guU = this.gun.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(boolean z) {
        if (this.geB == guR && this.gun != null) {
            this.geB = guS;
            this.guX = this.gun.getDuration();
            if (z) {
                this.guY = 0;
                this.guW = this.guX;
            } else {
                this.guW = this.gun.getCurrentPosition();
                this.guY = this.gun.getCachedSize();
            }
            if (this.guW > 0) {
                if (this.guT == guO) {
                    this.guV = (int) u.to(this.guH);
                    if (this.guU > 0) {
                        long j = (this.guU * (this.guW / 1000)) / 8;
                        if (this.guY < 0) {
                            this.guY = 0;
                        }
                        long j2 = this.guY + j;
                        if (this.guV > 0) {
                            j2 += this.guV;
                        }
                        setFlowCount(j2, this.guW, this.guX, this.bxQ);
                    } else if (this.guU == -1) {
                        this.guU = 603327;
                        setFlowCount((this.guU * (this.guW / 1000)) / 8, this.guW, this.guX, this.bxQ);
                    }
                } else if (this.guT == guP) {
                    if (this.guU > 0) {
                        long j3 = (this.guU * (this.guW / 1000)) / 8;
                        if (this.guY < 0) {
                            this.guY = 0;
                        }
                        long j4 = this.guY + j3;
                        if (this.guV > 0) {
                            j4 -= this.guV;
                        }
                        setFlowCount(j4, this.guW, this.guX, this.bxQ);
                    } else if (this.guU == -1) {
                        this.guU = 603327;
                        setFlowCount((this.guU * (this.guW / 1000)) / 8, this.guW, this.guX, this.bxQ);
                    }
                } else {
                    setFlowCount(0L, this.guW, this.guX, this.bxQ);
                }
            }
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvg);
    }

    public void stopPlayback() {
        bqj();
        mm(false);
        if (this.guE != null) {
            this.guE.clear();
        }
        this.gum = null;
        Tu();
        this.guz = false;
        if (this.guw != null) {
            this.guw.onStop();
        }
        com.baidu.tieba.play.a.b.bqR().a((b.InterfaceC0256b) null);
        if (this.gus != null && this.gus.rC(getLocateSource())) {
            this.gus = null;
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvg);
    }

    public void setFullScreenToDestroySurface() {
        this.guZ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqj() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gva);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvb);
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
        if (this.guG == null) {
            return "";
        }
        String bqW = this.guG.bqW();
        this.guG.N(str, str2, str3);
        return bqW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.guw != null && !StringUtils.isNull(this.guw.bpV())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.tt(uri);
                }
            }
            this.mUri = Uri.parse(this.guw.bpV());
        }
        boolean z = false;
        if (this.guE != null) {
            z = this.guE.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gus != null) {
            this.guu = this.gus.a(i, i2, i3, getLocateSource(), z, this.guJ, M(this.gus.bbm(), i3 + "", this.gus.bbn()));
            this.gus = null;
        }
        this.guJ = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gun != null) {
            try {
                if (this.gun.isPlaying() && bqm()) {
                    y.bqO().aM(this.guI, this.gun.getCurrentPosition());
                }
                this.gun.release();
                this.gum = str;
                URI uri = new URI(this.mUri.toString());
                this.gun.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.guC, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (f(this.mUri) != null) {
                    this.gus.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gun != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.gun.isPlaying() && bqm()) {
                y.bqO().aM(this.guI, this.gun.getCurrentPosition());
            }
            this.gun.release();
            this.gun.a(this.mContext, this.mUri, this.mHeaders, this.guC, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gus.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gun != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gun.forceUseSystemMediaPlayer(true);
            }
            if (this.gun.isPlaying() && bqm()) {
                y.bqO().aM(this.guI, this.gun.getCurrentPosition());
            }
            this.gun.release();
            this.gun.a(this.mContext, this.mUri, this.mHeaders, this.guC, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gus.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.guv = true;
        if (this.gun != null) {
            if (this.guC != null && this.guB && !this.gun.isExistInRemote()) {
                this.gun.a(this.mContext, this.mUri, this.mHeaders, this.guC, this.guA);
                if (this.gtT != null) {
                    this.gtT.bpU();
                }
                if (f(this.mUri) != null) {
                    this.gus.bbi();
                }
                bqh();
                return;
            }
            this.gun.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.guw != null) {
            this.guw.onStart();
        }
        if (this.gup != null) {
            this.gup.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null && this.gun != null) {
            this.gus.qV(this.gun.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bqj();
        if (this.gun != null) {
            if (this.gun.isPlaying() && bqm()) {
                y.bqO().aM(this.guI, this.gun.getCurrentPosition());
            }
            this.gun.pause();
        }
        if (this.guw != null) {
            this.guw.onPause();
        }
        this.guv = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gus != null) {
            this.gus.bbl();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gun != null) {
            return this.gun.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gun != null) {
            return this.gun.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bxQ = i;
        sB(i);
    }

    public void sB(int i) {
        if (this.guF != null) {
            this.guF.bqx();
        }
        if (this.gun != null) {
            this.gun.seekTo(i);
        }
        if (this.guw != null) {
            this.guw.sA(0);
            bql();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gun != null) {
            return this.gun.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gun != null) {
            this.gun.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.guA = i;
    }

    public int getRecoveryState() {
        return this.guA;
    }

    public void setNeedRecovery(boolean z) {
        this.guB = z;
    }

    public void setLooping(boolean z) {
        this.guz = z;
    }

    public boolean bqk() {
        return this.guv;
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
        this.guw = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.btL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.guz = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gun != null) {
            this.gun.ON();
        }
        if (this.guF != null) {
            this.guF.bqz();
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvg);
        MessageManager.getInstance().unRegisterListener(this.btL);
        if (this.guE != null) {
            this.guE.clear();
        }
        if (this.gut != null) {
            this.gut.a(null);
            this.gut.bba();
        }
    }

    public g getPlayer() {
        return this.gun;
    }

    public int getPlayerType() {
        return this.gun == null ? ReportLevel.USER : this.gun.getPlayerType();
    }

    public void bql() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvg);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvg, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gtT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.guw instanceof n) || ((n) this.guw).bqv() == null) ? "" : ((n) this.guw).bqv().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.gus != null) {
            return this.gus;
        }
        if (!StringUtils.isNull(this.guH)) {
            uri2 = this.guH;
        } else if (gur != null && this.guw != null && !StringUtils.isNull(this.guw.bpV())) {
            uri2 = this.guw.bpV();
        } else {
            uri2 = (gur == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gur != null) {
            this.gus = gur.L(this.beh, uri2, this.guu);
        }
        this.guu = null;
        this.guJ = 0L;
        return this.gus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqm() {
        return this.gun != null && this.gun.getDuration() >= this.gun.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gus, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gus, j);
    }

    public static boolean gJ(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.guo = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gun != null) {
            return this.gun.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gun != null ? this.gun.getId() : "";
    }

    public void setVideoStatusListener(c cVar) {
        this.gup = cVar;
    }
}
