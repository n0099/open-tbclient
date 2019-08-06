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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
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
    private static h dgx;
    private static com.baidu.tieba.j.l dgy;
    private static int iwX = 0;
    private static int iwY = 1;
    private static int iwZ = 2;
    private static int ixa = 1;
    private static int ixb = 0;
    private Map<String, String> FV;
    private WeakReference<Context> bBD;
    private String bWU;
    private g.b cJZ;
    private b cKd;
    private g.InterfaceC0393g cTA;
    private g.i cTB;
    private g.d cTC;
    private g.h cTD;
    private final CustomMessageListener cTK;
    private g.a cTw;
    private g.f cTx;
    private g.c cTy;
    private g.e cTz;
    private int cXM;
    private g.a dgA;
    private g.InterfaceC0393g dgD;
    private boolean dgq;
    private g.f dgz;
    private int igf;
    private c iwA;
    private com.baidu.tieba.j.i iwB;
    private com.baidu.tieba.j.e iwC;
    private String iwD;
    private boolean iwE;
    private d iwF;
    private boolean iwG;
    private int iwH;
    private int iwI;
    private boolean iwJ;
    private SurfaceTexture iwK;
    private boolean iwL;
    private com.baidu.tieba.play.b.a iwM;
    private r iwN;
    private com.baidu.tieba.play.b.f iwO;
    private String iwP;
    private String iwQ;
    private String iwR;
    private long iwS;
    private boolean iwT;
    private boolean iwU;
    private long iwV;
    private long iwW;
    private a iwd;
    private RenderView iww;
    private String iwx;
    private g iwy;
    private g.e iwz;
    private int ixc;
    private int ixd;
    private int ixe;
    private int ixf;
    private int ixg;
    private int ixh;
    private boolean ixi;
    private Runnable ixj;
    private Runnable ixk;
    private TextureView.SurfaceTextureListener ixl;
    private Runnable ixm;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cei();
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
            dgx = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            dgy = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.iwL = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.iwE = false;
        this.iwG = false;
        this.iwH = 0;
        this.dgq = false;
        this.iwI = -1;
        this.iwJ = false;
        this.iwK = null;
        this.iwL = true;
        this.iwV = 0L;
        this.iwW = 0L;
        this.igf = ixb;
        this.ixc = 0;
        this.ixd = 0;
        this.ixe = -1;
        this.ixf = 0;
        this.ixg = 0;
        this.ixh = 0;
        this.cXM = 0;
        this.ixi = false;
        this.bBD = null;
        this.ixj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwy != null && QuickVideoView.this.iwE) {
                    QuickVideoView.this.b(QuickVideoView.this.iwy, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ixk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.nx(false);
                }
            }
        };
        this.ixl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ixi) {
                    QuickVideoView.this.ixi = false;
                    QuickVideoView.this.iwy.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.iwG || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iwy != null && QuickVideoView.this.iwJ) {
                        QuickVideoView.this.iwy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.iwI);
                        if (QuickVideoView.this.iwd != null) {
                            QuickVideoView.this.iwd.cei();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iwB.bOU();
                        }
                    }
                } else if (ceE()) {
                    if (QuickVideoView.this.iwy != null) {
                        QuickVideoView.this.cew();
                        QuickVideoView.this.iwG = true;
                        QuickVideoView.this.iwy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iwB.bOT();
                    }
                }
                QuickVideoView.this.iwK = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ixi) {
                    QuickVideoView.this.cez();
                    QuickVideoView.this.qf(false);
                    if (QuickVideoView.this.iwy != null) {
                        if (QuickVideoView.this.iwy.isPlaying() && QuickVideoView.this.ceC()) {
                            y.cfe().bg(QuickVideoView.this.iwR, QuickVideoView.this.iwy.getCurrentPosition());
                        }
                        QuickVideoView.this.iwy.release();
                    }
                    if (QuickVideoView.this.iwG) {
                        if (QuickVideoView.this.iwF != null) {
                            QuickVideoView.this.iwF.onStop();
                        }
                        if (QuickVideoView.this.cKd != null) {
                            QuickVideoView.this.cKd.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iwK = null;
                    if (QuickVideoView.this.iwB != null && QuickVideoView.this.iwB.Be(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.iwG = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ceE() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.aa(runningTasks)) {
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
        this.dgz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Da;
                QuickVideoView.this.cez();
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.onPrepared();
                }
                if (QuickVideoView.this.iwB != null && QuickVideoView.this.iwy != null) {
                    QuickVideoView.this.iwB.xn(QuickVideoView.this.iwy.getPlayerType());
                }
                if (QuickVideoView.this.cTx != null) {
                    QuickVideoView.this.cTx.onPrepared(gVar);
                }
                if (QuickVideoView.this.iwF != null) {
                    long j = 0;
                    if (QuickVideoView.this.iwy != null) {
                        j = QuickVideoView.this.iwy.getDuration();
                    }
                    QuickVideoView.this.iwF.eq(j);
                    QuickVideoView.this.cex();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iwF.cep();
                        QuickVideoView.this.ceB();
                    }
                }
                if (QuickVideoView.this.iwU && (Da = y.cfe().Da(QuickVideoView.this.iwR)) > 0) {
                    if (QuickVideoView.this.iwy.isPlayerReuse()) {
                        if (QuickVideoView.this.iwy.getCurrentPosition() == 0) {
                            QuickVideoView.this.yZ(Da);
                        }
                    } else {
                        QuickVideoView.this.yZ(Da);
                    }
                }
                if (QuickVideoView.this.iwE) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iww != null && gVar != null) {
                    QuickVideoView.this.iww.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwH);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iwx) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iwx);
                }
                if (QuickVideoView.this.iwM != null && QuickVideoView.this.iwM.cfA()) {
                    com.baidu.tieba.play.b.e.zg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dgA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qf(true);
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.Bd(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iwB = null;
                }
                if (!QuickVideoView.this.dgq || QuickVideoView.this.iwF == null) {
                    if (QuickVideoView.this.iwF != null) {
                        QuickVideoView.this.iwF.onCompletion();
                    }
                    QuickVideoView.this.iwE = false;
                    y.cfe().remove(QuickVideoView.this.iwR);
                    if (QuickVideoView.this.cTw != null) {
                        QuickVideoView.this.cTw.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iwD = null;
                QuickVideoView.this.iwS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iwF.cej());
                QuickVideoView.this.start();
            }
        };
        this.cTy = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ae(i, i2, i3);
                QuickVideoView.this.cez();
                if (QuickVideoView.this.iwF != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ceC()) {
                    QuickVideoView.this.iwT = true;
                    y.cfe().bg(QuickVideoView.this.iwR, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.iwB != null) {
                        QuickVideoView.this.iwD = QuickVideoView.this.iwB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iwS, QuickVideoView.this.Z(QuickVideoView.this.iwB.bOY(), i3 + "", QuickVideoView.this.iwB.bOZ()));
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.iwS = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.ze(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.zf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cJZ == null || QuickVideoView.this.cJZ.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dgD = new g.InterfaceC0393g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (QuickVideoView.this.iwT) {
                    QuickVideoView.this.iwT = false;
                    return;
                }
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.ceO();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iwF != null && z) {
                    QuickVideoView.this.iwF.onSeekComplete();
                }
                if (QuickVideoView.this.cTA != null) {
                    QuickVideoView.this.cTA.b(gVar);
                }
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.iwz != null) {
                    QuickVideoView.this.iwz.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.iwH = i2;
                    if (QuickVideoView.this.iww != null && gVar != null) {
                        QuickVideoView.this.iww.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwH);
                    }
                }
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.a(i, i2, QuickVideoView.this.iwB);
                    return true;
                }
                return true;
            }
        };
        this.cTB = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.i(i, i2, str);
                }
            }
        };
        this.cTC = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.Bf(str);
                }
            }
        };
        this.cTD = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iwS = j;
                }
            }
        };
        this.ixm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iwF != null && QuickVideoView.this.iwF.cel() && QuickVideoView.this.iwF.cem() && QuickVideoView.this.iwF.cen() && QuickVideoView.this.iwy != null) {
                    int aBG = QuickVideoView.this.iwy.aBG();
                    int currentPosition = QuickVideoView.this.iwy.getCurrentPosition();
                    int duration = QuickVideoView.this.iwy.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iwV;
                    boolean z = currentPosition + aBG < duration;
                    if (aBG < QuickVideoView.this.iwF.ceo() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iwV = currentTimeMillis;
                        QuickVideoView.this.iwF.yX(0);
                    }
                    if (QuickVideoView.this.ceA() && currentPosition == QuickVideoView.this.iwW && j > 500) {
                        QuickVideoView.this.iwV = currentTimeMillis;
                        QuickVideoView.this.iwF.yX(0);
                    }
                    QuickVideoView.this.iwW = currentPosition;
                    if (QuickVideoView.this.igf == QuickVideoView.ixa) {
                        QuickVideoView.this.ceB();
                    }
                }
            }
        };
        this.cTK = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iwF != null) {
                        QuickVideoView.this.iwF.cer();
                    }
                    if (QuickVideoView.this.iwB != null) {
                        QuickVideoView.this.iwB.Bc(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.cez();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwE = false;
        this.iwG = false;
        this.iwH = 0;
        this.dgq = false;
        this.iwI = -1;
        this.iwJ = false;
        this.iwK = null;
        this.iwL = true;
        this.iwV = 0L;
        this.iwW = 0L;
        this.igf = ixb;
        this.ixc = 0;
        this.ixd = 0;
        this.ixe = -1;
        this.ixf = 0;
        this.ixg = 0;
        this.ixh = 0;
        this.cXM = 0;
        this.ixi = false;
        this.bBD = null;
        this.ixj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwy != null && QuickVideoView.this.iwE) {
                    QuickVideoView.this.b(QuickVideoView.this.iwy, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ixk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.nx(false);
                }
            }
        };
        this.ixl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ixi) {
                    QuickVideoView.this.ixi = false;
                    QuickVideoView.this.iwy.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.iwG || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iwy != null && QuickVideoView.this.iwJ) {
                        QuickVideoView.this.iwy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.iwI);
                        if (QuickVideoView.this.iwd != null) {
                            QuickVideoView.this.iwd.cei();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iwB.bOU();
                        }
                    }
                } else if (ceE()) {
                    if (QuickVideoView.this.iwy != null) {
                        QuickVideoView.this.cew();
                        QuickVideoView.this.iwG = true;
                        QuickVideoView.this.iwy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iwB.bOT();
                    }
                }
                QuickVideoView.this.iwK = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ixi) {
                    QuickVideoView.this.cez();
                    QuickVideoView.this.qf(false);
                    if (QuickVideoView.this.iwy != null) {
                        if (QuickVideoView.this.iwy.isPlaying() && QuickVideoView.this.ceC()) {
                            y.cfe().bg(QuickVideoView.this.iwR, QuickVideoView.this.iwy.getCurrentPosition());
                        }
                        QuickVideoView.this.iwy.release();
                    }
                    if (QuickVideoView.this.iwG) {
                        if (QuickVideoView.this.iwF != null) {
                            QuickVideoView.this.iwF.onStop();
                        }
                        if (QuickVideoView.this.cKd != null) {
                            QuickVideoView.this.cKd.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iwK = null;
                    if (QuickVideoView.this.iwB != null && QuickVideoView.this.iwB.Be(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.iwG = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ceE() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.aa(runningTasks)) {
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
        this.dgz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Da;
                QuickVideoView.this.cez();
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.onPrepared();
                }
                if (QuickVideoView.this.iwB != null && QuickVideoView.this.iwy != null) {
                    QuickVideoView.this.iwB.xn(QuickVideoView.this.iwy.getPlayerType());
                }
                if (QuickVideoView.this.cTx != null) {
                    QuickVideoView.this.cTx.onPrepared(gVar);
                }
                if (QuickVideoView.this.iwF != null) {
                    long j = 0;
                    if (QuickVideoView.this.iwy != null) {
                        j = QuickVideoView.this.iwy.getDuration();
                    }
                    QuickVideoView.this.iwF.eq(j);
                    QuickVideoView.this.cex();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iwF.cep();
                        QuickVideoView.this.ceB();
                    }
                }
                if (QuickVideoView.this.iwU && (Da = y.cfe().Da(QuickVideoView.this.iwR)) > 0) {
                    if (QuickVideoView.this.iwy.isPlayerReuse()) {
                        if (QuickVideoView.this.iwy.getCurrentPosition() == 0) {
                            QuickVideoView.this.yZ(Da);
                        }
                    } else {
                        QuickVideoView.this.yZ(Da);
                    }
                }
                if (QuickVideoView.this.iwE) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iww != null && gVar != null) {
                    QuickVideoView.this.iww.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwH);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iwx) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iwx);
                }
                if (QuickVideoView.this.iwM != null && QuickVideoView.this.iwM.cfA()) {
                    com.baidu.tieba.play.b.e.zg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dgA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qf(true);
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.Bd(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iwB = null;
                }
                if (!QuickVideoView.this.dgq || QuickVideoView.this.iwF == null) {
                    if (QuickVideoView.this.iwF != null) {
                        QuickVideoView.this.iwF.onCompletion();
                    }
                    QuickVideoView.this.iwE = false;
                    y.cfe().remove(QuickVideoView.this.iwR);
                    if (QuickVideoView.this.cTw != null) {
                        QuickVideoView.this.cTw.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iwD = null;
                QuickVideoView.this.iwS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iwF.cej());
                QuickVideoView.this.start();
            }
        };
        this.cTy = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ae(i, i2, i3);
                QuickVideoView.this.cez();
                if (QuickVideoView.this.iwF != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ceC()) {
                    QuickVideoView.this.iwT = true;
                    y.cfe().bg(QuickVideoView.this.iwR, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.iwB != null) {
                        QuickVideoView.this.iwD = QuickVideoView.this.iwB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iwS, QuickVideoView.this.Z(QuickVideoView.this.iwB.bOY(), i3 + "", QuickVideoView.this.iwB.bOZ()));
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.iwS = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.ze(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.zf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cJZ == null || QuickVideoView.this.cJZ.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dgD = new g.InterfaceC0393g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (QuickVideoView.this.iwT) {
                    QuickVideoView.this.iwT = false;
                    return;
                }
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.ceO();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iwF != null && z) {
                    QuickVideoView.this.iwF.onSeekComplete();
                }
                if (QuickVideoView.this.cTA != null) {
                    QuickVideoView.this.cTA.b(gVar);
                }
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.iwz != null) {
                    QuickVideoView.this.iwz.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.iwH = i2;
                    if (QuickVideoView.this.iww != null && gVar != null) {
                        QuickVideoView.this.iww.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwH);
                    }
                }
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.a(i, i2, QuickVideoView.this.iwB);
                    return true;
                }
                return true;
            }
        };
        this.cTB = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.i(i, i2, str);
                }
            }
        };
        this.cTC = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.Bf(str);
                }
            }
        };
        this.cTD = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iwS = j;
                }
            }
        };
        this.ixm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iwF != null && QuickVideoView.this.iwF.cel() && QuickVideoView.this.iwF.cem() && QuickVideoView.this.iwF.cen() && QuickVideoView.this.iwy != null) {
                    int aBG = QuickVideoView.this.iwy.aBG();
                    int currentPosition = QuickVideoView.this.iwy.getCurrentPosition();
                    int duration = QuickVideoView.this.iwy.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iwV;
                    boolean z = currentPosition + aBG < duration;
                    if (aBG < QuickVideoView.this.iwF.ceo() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iwV = currentTimeMillis;
                        QuickVideoView.this.iwF.yX(0);
                    }
                    if (QuickVideoView.this.ceA() && currentPosition == QuickVideoView.this.iwW && j > 500) {
                        QuickVideoView.this.iwV = currentTimeMillis;
                        QuickVideoView.this.iwF.yX(0);
                    }
                    QuickVideoView.this.iwW = currentPosition;
                    if (QuickVideoView.this.igf == QuickVideoView.ixa) {
                        QuickVideoView.this.ceB();
                    }
                }
            }
        };
        this.cTK = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iwF != null) {
                        QuickVideoView.this.iwF.cer();
                    }
                    if (QuickVideoView.this.iwB != null) {
                        QuickVideoView.this.iwB.Bc(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.cez();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwE = false;
        this.iwG = false;
        this.iwH = 0;
        this.dgq = false;
        this.iwI = -1;
        this.iwJ = false;
        this.iwK = null;
        this.iwL = true;
        this.iwV = 0L;
        this.iwW = 0L;
        this.igf = ixb;
        this.ixc = 0;
        this.ixd = 0;
        this.ixe = -1;
        this.ixf = 0;
        this.ixg = 0;
        this.ixh = 0;
        this.cXM = 0;
        this.ixi = false;
        this.bBD = null;
        this.ixj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwy != null && QuickVideoView.this.iwE) {
                    QuickVideoView.this.b(QuickVideoView.this.iwy, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ixk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.nx(false);
                }
            }
        };
        this.ixl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.ixi) {
                    QuickVideoView.this.ixi = false;
                    QuickVideoView.this.iwy.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.iwG || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iwy != null && QuickVideoView.this.iwJ) {
                        QuickVideoView.this.iwy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.iwI);
                        if (QuickVideoView.this.iwd != null) {
                            QuickVideoView.this.iwd.cei();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iwB.bOU();
                        }
                    }
                } else if (ceE()) {
                    if (QuickVideoView.this.iwy != null) {
                        QuickVideoView.this.cew();
                        QuickVideoView.this.iwG = true;
                        QuickVideoView.this.iwy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iwB.bOT();
                    }
                }
                QuickVideoView.this.iwK = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ixi) {
                    QuickVideoView.this.cez();
                    QuickVideoView.this.qf(false);
                    if (QuickVideoView.this.iwy != null) {
                        if (QuickVideoView.this.iwy.isPlaying() && QuickVideoView.this.ceC()) {
                            y.cfe().bg(QuickVideoView.this.iwR, QuickVideoView.this.iwy.getCurrentPosition());
                        }
                        QuickVideoView.this.iwy.release();
                    }
                    if (QuickVideoView.this.iwG) {
                        if (QuickVideoView.this.iwF != null) {
                            QuickVideoView.this.iwF.onStop();
                        }
                        if (QuickVideoView.this.cKd != null) {
                            QuickVideoView.this.cKd.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iwK = null;
                    if (QuickVideoView.this.iwB != null && QuickVideoView.this.iwB.Be(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.iwG = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ceE() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.aa(runningTasks)) {
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
        this.dgz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Da;
                QuickVideoView.this.cez();
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.onPrepared();
                }
                if (QuickVideoView.this.iwB != null && QuickVideoView.this.iwy != null) {
                    QuickVideoView.this.iwB.xn(QuickVideoView.this.iwy.getPlayerType());
                }
                if (QuickVideoView.this.cTx != null) {
                    QuickVideoView.this.cTx.onPrepared(gVar);
                }
                if (QuickVideoView.this.iwF != null) {
                    long j = 0;
                    if (QuickVideoView.this.iwy != null) {
                        j = QuickVideoView.this.iwy.getDuration();
                    }
                    QuickVideoView.this.iwF.eq(j);
                    QuickVideoView.this.cex();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iwF.cep();
                        QuickVideoView.this.ceB();
                    }
                }
                if (QuickVideoView.this.iwU && (Da = y.cfe().Da(QuickVideoView.this.iwR)) > 0) {
                    if (QuickVideoView.this.iwy.isPlayerReuse()) {
                        if (QuickVideoView.this.iwy.getCurrentPosition() == 0) {
                            QuickVideoView.this.yZ(Da);
                        }
                    } else {
                        QuickVideoView.this.yZ(Da);
                    }
                }
                if (QuickVideoView.this.iwE) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iww != null && gVar != null) {
                    QuickVideoView.this.iww.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwH);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iwx) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iwx);
                }
                if (QuickVideoView.this.iwM != null && QuickVideoView.this.iwM.cfA()) {
                    com.baidu.tieba.play.b.e.zg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dgA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qf(true);
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.Bd(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iwB = null;
                }
                if (!QuickVideoView.this.dgq || QuickVideoView.this.iwF == null) {
                    if (QuickVideoView.this.iwF != null) {
                        QuickVideoView.this.iwF.onCompletion();
                    }
                    QuickVideoView.this.iwE = false;
                    y.cfe().remove(QuickVideoView.this.iwR);
                    if (QuickVideoView.this.cTw != null) {
                        QuickVideoView.this.cTw.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iwD = null;
                QuickVideoView.this.iwS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iwF.cej());
                QuickVideoView.this.start();
            }
        };
        this.cTy = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ae(i2, i22, i3);
                QuickVideoView.this.cez();
                if (QuickVideoView.this.iwF != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ceC()) {
                    QuickVideoView.this.iwT = true;
                    y.cfe().bg(QuickVideoView.this.iwR, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.iwB != null) {
                        QuickVideoView.this.iwD = QuickVideoView.this.iwB.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iwS, QuickVideoView.this.Z(QuickVideoView.this.iwB.bOY(), i3 + "", QuickVideoView.this.iwB.bOZ()));
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.iwS = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.ze(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.zf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cJZ == null || QuickVideoView.this.cJZ.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.dgD = new g.InterfaceC0393g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0393g
            public void b(g gVar) {
                if (QuickVideoView.this.iwT) {
                    QuickVideoView.this.iwT = false;
                    return;
                }
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.ceO();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iwF != null && z) {
                    QuickVideoView.this.iwF.onSeekComplete();
                }
                if (QuickVideoView.this.cTA != null) {
                    QuickVideoView.this.cTA.b(gVar);
                }
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.iwz != null) {
                    QuickVideoView.this.iwz.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.iwH = i22;
                    if (QuickVideoView.this.iww != null && gVar != null) {
                        QuickVideoView.this.iww.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwH);
                    }
                }
                if (QuickVideoView.this.iwN != null) {
                    QuickVideoView.this.iwN.a(i2, i22, QuickVideoView.this.iwB);
                    return true;
                }
                return true;
            }
        };
        this.cTB = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.i(i2, i22, str);
                }
            }
        };
        this.cTC = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iwB != null) {
                    QuickVideoView.this.iwB.Bf(str);
                }
            }
        };
        this.cTD = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iwS = j;
                }
            }
        };
        this.ixm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iwF != null && QuickVideoView.this.iwF.cel() && QuickVideoView.this.iwF.cem() && QuickVideoView.this.iwF.cen() && QuickVideoView.this.iwy != null) {
                    int aBG = QuickVideoView.this.iwy.aBG();
                    int currentPosition = QuickVideoView.this.iwy.getCurrentPosition();
                    int duration = QuickVideoView.this.iwy.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iwV;
                    boolean z = currentPosition + aBG < duration;
                    if (aBG < QuickVideoView.this.iwF.ceo() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iwV = currentTimeMillis;
                        QuickVideoView.this.iwF.yX(0);
                    }
                    if (QuickVideoView.this.ceA() && currentPosition == QuickVideoView.this.iwW && j > 500) {
                        QuickVideoView.this.iwV = currentTimeMillis;
                        QuickVideoView.this.iwF.yX(0);
                    }
                    QuickVideoView.this.iwW = currentPosition;
                    if (QuickVideoView.this.igf == QuickVideoView.ixa) {
                        QuickVideoView.this.ceB();
                    }
                }
            }
        };
        this.cTK = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iwF != null) {
                        QuickVideoView.this.iwF.cer();
                    }
                    if (QuickVideoView.this.iwB != null) {
                        QuickVideoView.this.iwB.Bc(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iwB = null;
                    }
                    QuickVideoView.this.cez();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.iww = new RenderView(context);
        this.bBD = new WeakReference<>(TbadkCoreApplication.getInst());
        this.iww.setSurfaceTextureListener(this.ixl);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.iwL) {
            addView(this.iww, layoutParams);
        } else {
            addView(this.iww, 0, layoutParams);
        }
        if (dgx != null) {
            this.iwy = dgx.aBI();
        }
        if (this.iwy != null) {
            this.iwy.setOnPreparedListener(this.dgz);
            this.iwy.setOnCompletionListener(this.dgA);
            this.iwy.a(this.cTy);
            this.iwy.setOnSeekCompleteListener(this.dgD);
            this.iwy.a(this.cTz);
            this.iwy.a(this.cTB);
            this.iwy.a(this.cTC);
            this.iwy.a(this.cTD);
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
        this.iwM = new com.baidu.tieba.play.b.a(this);
        this.iwN = new r();
        this.iwO = new com.baidu.tieba.play.b.f();
        am.k(this, R.color.cp_bg_line_k);
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.hS().az("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.iwU = z;
    }

    public void setVideoPath(String str, String str2) {
        this.bWU = str2;
        if (this.iwM != null) {
            this.iwM.clear();
            this.iwM.cfA();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Df(str2);
            if (dgy != null) {
                this.iwB = dgy.X(this.bWU, str, "");
                if (this.iwB != null) {
                    this.iwB.a(-300, -44399, -44399, getLocateSource(), false, this.iwS, "");
                    this.iwB = null;
                }
            }
        }
        if (this.iwC != null) {
            this.iwC.a(null);
            this.iwC.bOM();
            this.iwC = null;
        }
        this.iwD = null;
        this.iwS = 0L;
        setVideoPath(str);
    }

    public void dS(String str, String str2) {
    }

    private String CW(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cua().cub()) {
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
        if (!aq.isEmpty(str)) {
            String CW = CW(str);
            this.iwP = CW;
            if (this.iwF != null) {
                CW = this.iwF.sc(CW);
                if (this.iwF.ceq() != null) {
                    this.iwF.ceq().setPlayer(this);
                }
                if (dgy != null && pD(CW)) {
                    this.iwC = dgy.Bi(CW);
                }
                if (this.iwC != null) {
                    this.iwC.a(new com.baidu.tieba.play.monitor.a(this.bWU, this.iwP, this.iwB));
                    this.iwC.bOL();
                }
                CX(CW);
            }
            if (!com.baidu.adp.lib.util.j.kc() && !pD(CW)) {
                if (this.cJZ != null) {
                    this.cJZ.onError(this.iwy, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(CW));
            if (this.iwB != null) {
                if (u(Uri.parse(CW)) != null) {
                    this.iwB.bOS();
                }
                this.iwB.Gb();
                this.iwB = null;
            }
            this.iwQ = str;
            int lastIndexOf = this.iwQ.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.iwQ.length() > 4) {
                this.iwR = this.iwQ.substring(0, lastIndexOf + 4);
            } else {
                this.iwR = this.iwQ;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cew() {
        if (com.baidu.tbadk.coreExtra.model.f.apM()) {
            if (this.iwF != null && (this.iwF.cek() || this.iwF.cel())) {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixj);
                com.baidu.adp.lib.g.e.iK().postDelayed(this.ixj, com.baidu.tbadk.coreExtra.model.f.apL());
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixk);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.ixk, com.baidu.tbadk.coreExtra.model.f.apK());
        }
    }

    public void cdL() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        b(uri, (Map<String, String>) null);
    }

    private void b(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.iwB.Bb(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aBC();
        }
        this.mUri = uri;
        this.FV = map;
        if (this.iwK != null) {
            cew();
            if (this.iwy != null) {
                if (!this.iwG) {
                    this.iwG = true;
                    this.iwy.a(this.mContext, this.mUri, this.FV, this.iwK, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.dgz.onPrepared(this.iwy);
                }
            }
        } else if (this.iww != null && this.iww.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.iwL) {
                addView(this.iww, layoutParams);
            } else {
                addView(this.iww, 0, layoutParams);
            }
        }
        am.k(this, R.color.cp_bg_line_k);
    }

    private void aBC() {
        this.iwG = false;
        this.iwE = false;
        if (this.iwy != null) {
            if (this.iwy.isPlaying() && ceC()) {
                y.cfe().bg(this.iwR, this.iwy.getCurrentPosition());
            }
            this.iwy.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixm);
    }

    private void CX(String str) {
        this.ixd = 0;
        this.ixe = 0;
        this.ixf = 0;
        this.ixg = 0;
        this.ixh = 0;
        this.cXM = 0;
        if (this.iwF.cel()) {
            this.ixc = iwY;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.ixe = (int) u.CZ(QuickVideoView.this.iwP);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.iwP != null && this.iwP.equals(str)) {
            this.ixc = iwX;
        } else {
            this.ixc = iwZ;
        }
        this.igf = ixa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cex() {
        this.igf = ixa;
        if (this.iwy != null) {
            this.ixd = this.iwy.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(boolean z) {
        if (this.igf == ixa && this.iwy != null) {
            this.igf = ixb;
            this.ixg = this.iwy.getDuration();
            if (z) {
                this.ixh = 0;
                this.ixf = this.ixg;
            } else {
                this.ixf = this.iwy.getCurrentPosition();
                this.ixh = this.iwy.getCachedSize();
            }
            if (this.ixf > 0) {
                if (this.ixc == iwX) {
                    this.ixe = (int) u.CZ(this.iwP);
                    if (this.ixd > 0) {
                        long j = (this.ixd * (this.ixf / 1000)) / 8;
                        if (this.ixh < 0) {
                            this.ixh = 0;
                        }
                        long j2 = this.ixh + j;
                        if (this.ixe > 0) {
                            j2 += this.ixe;
                        }
                        setFlowCount(j2, this.ixf, this.ixg, this.cXM);
                    } else if (this.ixd == -1) {
                        this.ixd = 603327;
                        setFlowCount((this.ixd * (this.ixf / 1000)) / 8, this.ixf, this.ixg, this.cXM);
                    }
                } else if (this.ixc == iwY) {
                    if (this.ixd > 0) {
                        long j3 = (this.ixd * (this.ixf / 1000)) / 8;
                        if (this.ixh < 0) {
                            this.ixh = 0;
                        }
                        long j4 = this.ixh + j3;
                        if (this.ixe > 0) {
                            j4 -= this.ixe;
                        }
                        setFlowCount(j4, this.ixf, this.ixg, this.cXM);
                    } else if (this.ixd == -1) {
                        this.ixd = 603327;
                        setFlowCount((this.ixd * (this.ixf / 1000)) / 8, this.ixf, this.ixg, this.cXM);
                    }
                } else {
                    setFlowCount(0L, this.ixf, this.ixg, this.cXM);
                }
            }
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixm);
    }

    public void cey() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.bBD, false);
        }
        cez();
        qf(false);
        if (this.iwM != null) {
            this.iwM.clear();
        }
        this.iwx = null;
        aBC();
        this.dgq = false;
        if (this.iwF != null) {
            this.iwF.onStop();
        }
        com.baidu.tieba.play.a.b.cfh().a((b.InterfaceC0390b) null);
        if (this.iwB != null && this.iwB.Be(getLocateSource())) {
            this.iwB = null;
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixm);
    }

    public void setFullScreenToDestroySurface() {
        this.ixi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cez() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixj);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixk);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cTx = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cTw = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cJZ = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0393g interfaceC0393g) {
        this.cTA = interfaceC0393g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.iwO == null) {
            return "";
        }
        String cfC = this.iwO.cfC();
        this.iwO.aa(str, str2, str3);
        return cfC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.iwF != null && !StringUtils.isNull(this.iwF.cej())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.De(uri);
                }
            }
            this.mUri = Uri.parse(this.iwF.cej());
        }
        boolean z = false;
        if (this.iwM != null) {
            z = this.iwM.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.iwB != null) {
            this.iwD = this.iwB.a(i, i2, i3, getLocateSource(), z, this.iwS, Z(this.iwB.bOY(), i3 + "", this.iwB.bOZ()));
            this.iwB = null;
        }
        this.iwS = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.iwy != null) {
            try {
                if (this.iwy.isPlaying() && ceC()) {
                    y.cfe().bg(this.iwR, this.iwy.getCurrentPosition());
                }
                this.iwy.release();
                this.iwx = str;
                URI uri = new URI(this.mUri.toString());
                this.iwy.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.FV, this.iwK, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.iwB.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.iwy != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.iwy.isPlaying() && ceC()) {
                y.cfe().bg(this.iwR, this.iwy.getCurrentPosition());
            }
            this.iwy.release();
            this.iwy.a(this.mContext, this.mUri, this.FV, this.iwK, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.iwB.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.iwy != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.iwy.forceUseSystemMediaPlayer(true);
            }
            if (this.iwy.isPlaying() && ceC()) {
                y.cfe().bg(this.iwR, this.iwy.getCurrentPosition());
            }
            this.iwy.release();
            this.iwy.a(this.mContext, this.mUri, this.FV, this.iwK, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.iwB.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.iwE = true;
        if (this.iwy != null) {
            if (this.iwK != null && this.iwJ && !this.iwy.isExistInRemote()) {
                this.iwy.a(this.mContext, this.mUri, this.FV, this.iwK, this.iwI);
                if (this.iwd != null) {
                    this.iwd.cei();
                }
                if (u(this.mUri) != null) {
                    this.iwB.bOU();
                }
                cew();
                return;
            }
            if (!this.iwy.aBH()) {
                ad.a(this.bBD, true);
                this.iwy.setVolume(1.0f, 1.0f);
            }
            this.iwy.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.iwF != null) {
            this.iwF.onStart();
        }
        if (this.iwA != null) {
            this.iwA.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.iwy != null) {
            this.iwB.xo(this.iwy.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cez();
        ad.a(this.bBD, false);
        if (this.iwy != null) {
            if (this.iwy.isPlaying() && ceC()) {
                y.cfe().bg(this.iwR, this.iwy.getCurrentPosition());
            }
            this.iwy.pause();
        }
        if (this.iwF != null) {
            this.iwF.onPause();
        }
        this.iwE = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iwB != null) {
            this.iwB.bOX();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.iwy != null) {
            return this.iwy.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.iwy != null) {
            return this.iwy.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cXM = i;
        yZ(i);
    }

    public void yZ(int i) {
        if (this.iwN != null) {
            this.iwN.ceN();
        }
        if (this.iwy != null) {
            this.iwy.seekTo(i);
        }
        if (this.iwF != null) {
            this.iwF.yX(0);
            ceB();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.iwy != null) {
            return this.iwy.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.iwy != null) {
            this.iwy.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.iwI = i;
    }

    public int getRecoveryState() {
        return this.iwI;
    }

    public void setNeedRecovery(boolean z) {
        this.iwJ = z;
    }

    public void setLooping(boolean z) {
        this.dgq = z;
    }

    public boolean ceA() {
        return this.iwE;
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
        this.cKd = bVar;
    }

    public void setBusiness(d dVar) {
        this.iwF = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cTK);
    }

    public void setMute(boolean z) {
        if (z) {
            this.iwy.setVolume(0.0f, 0.0f);
            ad.a(this.bBD, false);
            return;
        }
        ad.a(this.bBD, true);
        this.iwy.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dgq = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iwy != null) {
            this.iwy.awx();
        }
        if (this.iwN != null) {
            this.iwN.ceP();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixm);
        MessageManager.getInstance().unRegisterListener(this.cTK);
        if (this.iwM != null) {
            this.iwM.clear();
        }
        if (this.iwC != null) {
            this.iwC.a(null);
            this.iwC.bOM();
        }
    }

    public g getPlayer() {
        return this.iwy;
    }

    public int getPlayerType() {
        if (this.iwy == null) {
            return -300;
        }
        return this.iwy.getPlayerType();
    }

    public void ceB() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixm);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.ixm, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.iwd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.iwF instanceof n) || ((n) this.iwF).ceL() == null) ? "" : ((n) this.iwF).ceL().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i u(Uri uri) {
        String uri2;
        if (this.iwB != null) {
            return this.iwB;
        }
        if (!StringUtils.isNull(this.iwP)) {
            uri2 = this.iwP;
        } else if (dgy != null && this.iwF != null && !StringUtils.isNull(this.iwF.cej())) {
            uri2 = this.iwF.cej();
        } else {
            uri2 = (dgy == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && dgy != null) {
            this.iwB = dgy.X(this.bWU, uri2, this.iwD);
        }
        this.iwD = null;
        this.iwS = 0L;
        return this.iwB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceC() {
        return this.iwy != null && this.iwy.getDuration() >= this.iwy.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.iwB, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.iwB, j);
    }

    public static boolean pD(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.iwz = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.iwy != null) {
            return this.iwy.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.iwy != null ? this.iwy.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.iwB != null) {
            this.iwB.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.iwA = cVar;
    }
}
