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
    private static h dgq;
    private static com.baidu.tieba.j.l dgr;
    private static int ivU = 0;
    private static int ivV = 1;
    private static int ivW = 2;
    private static int ivX = 1;
    private static int ivY = 0;
    private Map<String, String> FV;
    private WeakReference<Context> bBD;
    private String bWO;
    private g.b cJS;
    private b cJW;
    private final CustomMessageListener cTD;
    private g.a cTp;
    private g.f cTq;
    private g.c cTr;
    private g.e cTs;
    private g.InterfaceC0387g cTt;
    private g.i cTu;
    private g.d cTv;
    private g.h cTw;
    private int cXF;
    private boolean dgj;
    private g.f dgs;
    private g.a dgt;
    private g.InterfaceC0387g dgw;
    private int ifd;
    private String ivA;
    private boolean ivB;
    private d ivC;
    private boolean ivD;
    private int ivE;
    private int ivF;
    private boolean ivG;
    private SurfaceTexture ivH;
    private boolean ivI;
    private com.baidu.tieba.play.b.a ivJ;
    private r ivK;
    private com.baidu.tieba.play.b.f ivL;
    private String ivM;
    private String ivN;
    private String ivO;
    private long ivP;
    private boolean ivQ;
    private boolean ivR;
    private long ivS;
    private long ivT;
    private int ivZ;
    private a iva;
    private RenderView ivt;
    private String ivu;
    private g ivv;
    private g.e ivw;
    private c ivx;
    private com.baidu.tieba.j.i ivy;
    private com.baidu.tieba.j.e ivz;
    private int iwa;
    private int iwb;
    private int iwc;
    private int iwd;
    private int iwe;
    private boolean iwf;
    private Runnable iwg;
    private Runnable iwh;
    private TextureView.SurfaceTextureListener iwi;
    private Runnable iwj;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cdQ();
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
            dgq = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            dgr = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.ivI = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.ivB = false;
        this.ivD = false;
        this.ivE = 0;
        this.dgj = false;
        this.ivF = -1;
        this.ivG = false;
        this.ivH = null;
        this.ivI = true;
        this.ivS = 0L;
        this.ivT = 0L;
        this.ifd = ivY;
        this.ivZ = 0;
        this.iwa = 0;
        this.iwb = -1;
        this.iwc = 0;
        this.iwd = 0;
        this.iwe = 0;
        this.cXF = 0;
        this.iwf = false;
        this.bBD = null;
        this.iwg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ivv != null && QuickVideoView.this.ivB) {
                    QuickVideoView.this.b(QuickVideoView.this.ivv, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.iwh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.nx(false);
                }
            }
        };
        this.iwi = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.iwf) {
                    QuickVideoView.this.iwf = false;
                    QuickVideoView.this.ivv.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ivD || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ivv != null && QuickVideoView.this.ivG) {
                        QuickVideoView.this.ivv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.ivF);
                        if (QuickVideoView.this.iva != null) {
                            QuickVideoView.this.iva.cdQ();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ivy.bOG();
                        }
                    }
                } else if (cem()) {
                    if (QuickVideoView.this.ivv != null) {
                        QuickVideoView.this.cee();
                        QuickVideoView.this.ivD = true;
                        QuickVideoView.this.ivv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ivy.bOF();
                    }
                }
                QuickVideoView.this.ivH = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.iwf) {
                    QuickVideoView.this.ceh();
                    QuickVideoView.this.qe(false);
                    if (QuickVideoView.this.ivv != null) {
                        if (QuickVideoView.this.ivv.isPlaying() && QuickVideoView.this.cek()) {
                            y.ceM().bg(QuickVideoView.this.ivO, QuickVideoView.this.ivv.getCurrentPosition());
                        }
                        QuickVideoView.this.ivv.release();
                    }
                    if (QuickVideoView.this.ivD) {
                        if (QuickVideoView.this.ivC != null) {
                            QuickVideoView.this.ivC.onStop();
                        }
                        if (QuickVideoView.this.cJW != null) {
                            QuickVideoView.this.cJW.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ivH = null;
                    if (QuickVideoView.this.ivy != null && QuickVideoView.this.ivy.Bd(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ivD = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cem() {
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
        this.dgs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int CZ;
                QuickVideoView.this.ceh();
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.onPrepared();
                }
                if (QuickVideoView.this.ivy != null && QuickVideoView.this.ivv != null) {
                    QuickVideoView.this.ivy.xl(QuickVideoView.this.ivv.getPlayerType());
                }
                if (QuickVideoView.this.cTq != null) {
                    QuickVideoView.this.cTq.onPrepared(gVar);
                }
                if (QuickVideoView.this.ivC != null) {
                    long j = 0;
                    if (QuickVideoView.this.ivv != null) {
                        j = QuickVideoView.this.ivv.getDuration();
                    }
                    QuickVideoView.this.ivC.eq(j);
                    QuickVideoView.this.cef();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ivC.cdX();
                        QuickVideoView.this.cej();
                    }
                }
                if (QuickVideoView.this.ivR && (CZ = y.ceM().CZ(QuickVideoView.this.ivO)) > 0) {
                    if (QuickVideoView.this.ivv.isPlayerReuse()) {
                        if (QuickVideoView.this.ivv.getCurrentPosition() == 0) {
                            QuickVideoView.this.yX(CZ);
                        }
                    } else {
                        QuickVideoView.this.yX(CZ);
                    }
                }
                if (QuickVideoView.this.ivB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ivt != null && gVar != null) {
                    QuickVideoView.this.ivt.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ivE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ivu) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ivu);
                }
                if (QuickVideoView.this.ivJ != null && QuickVideoView.this.ivJ.cfi()) {
                    com.baidu.tieba.play.b.e.ze(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dgt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qe(true);
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.Bc(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ivy = null;
                }
                if (!QuickVideoView.this.dgj || QuickVideoView.this.ivC == null) {
                    if (QuickVideoView.this.ivC != null) {
                        QuickVideoView.this.ivC.onCompletion();
                    }
                    QuickVideoView.this.ivB = false;
                    y.ceM().remove(QuickVideoView.this.ivO);
                    if (QuickVideoView.this.cTp != null) {
                        QuickVideoView.this.cTp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ivA = null;
                QuickVideoView.this.ivP = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ivC.cdR());
                QuickVideoView.this.start();
            }
        };
        this.cTr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ae(i, i2, i3);
                QuickVideoView.this.ceh();
                if (QuickVideoView.this.ivC != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cek()) {
                    QuickVideoView.this.ivQ = true;
                    y.ceM().bg(QuickVideoView.this.ivO, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.ivy != null) {
                        QuickVideoView.this.ivA = QuickVideoView.this.ivy.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ivP, QuickVideoView.this.Z(QuickVideoView.this.ivy.bOK(), i3 + "", QuickVideoView.this.ivy.bOL()));
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ivP = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.zc(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.zd(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cJS == null || QuickVideoView.this.cJS.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dgw = new g.InterfaceC0387g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0387g
            public void b(g gVar) {
                if (QuickVideoView.this.ivQ) {
                    QuickVideoView.this.ivQ = false;
                    return;
                }
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.cew();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ivC != null && z) {
                    QuickVideoView.this.ivC.onSeekComplete();
                }
                if (QuickVideoView.this.cTt != null) {
                    QuickVideoView.this.cTt.b(gVar);
                }
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ivw != null) {
                    QuickVideoView.this.ivw.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ivE = i2;
                    if (QuickVideoView.this.ivt != null && gVar != null) {
                        QuickVideoView.this.ivt.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ivE);
                    }
                }
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.a(i, i2, QuickVideoView.this.ivy);
                    return true;
                }
                return true;
            }
        };
        this.cTu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.i(i, i2, str);
                }
            }
        };
        this.cTv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.Be(str);
                }
            }
        };
        this.cTw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ivP = j;
                }
            }
        };
        this.iwj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ivC != null && QuickVideoView.this.ivC.cdT() && QuickVideoView.this.ivC.cdU() && QuickVideoView.this.ivC.cdV() && QuickVideoView.this.ivv != null) {
                    int aBE = QuickVideoView.this.ivv.aBE();
                    int currentPosition = QuickVideoView.this.ivv.getCurrentPosition();
                    int duration = QuickVideoView.this.ivv.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ivS;
                    boolean z = currentPosition + aBE < duration;
                    if (aBE < QuickVideoView.this.ivC.cdW() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ivS = currentTimeMillis;
                        QuickVideoView.this.ivC.yV(0);
                    }
                    if (QuickVideoView.this.cei() && currentPosition == QuickVideoView.this.ivT && j > 500) {
                        QuickVideoView.this.ivS = currentTimeMillis;
                        QuickVideoView.this.ivC.yV(0);
                    }
                    QuickVideoView.this.ivT = currentPosition;
                    if (QuickVideoView.this.ifd == QuickVideoView.ivX) {
                        QuickVideoView.this.cej();
                    }
                }
            }
        };
        this.cTD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ivC != null) {
                        QuickVideoView.this.ivC.cdZ();
                    }
                    if (QuickVideoView.this.ivy != null) {
                        QuickVideoView.this.ivy.Bb(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ceh();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ivB = false;
        this.ivD = false;
        this.ivE = 0;
        this.dgj = false;
        this.ivF = -1;
        this.ivG = false;
        this.ivH = null;
        this.ivI = true;
        this.ivS = 0L;
        this.ivT = 0L;
        this.ifd = ivY;
        this.ivZ = 0;
        this.iwa = 0;
        this.iwb = -1;
        this.iwc = 0;
        this.iwd = 0;
        this.iwe = 0;
        this.cXF = 0;
        this.iwf = false;
        this.bBD = null;
        this.iwg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ivv != null && QuickVideoView.this.ivB) {
                    QuickVideoView.this.b(QuickVideoView.this.ivv, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.iwh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.nx(false);
                }
            }
        };
        this.iwi = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.iwf) {
                    QuickVideoView.this.iwf = false;
                    QuickVideoView.this.ivv.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ivD || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ivv != null && QuickVideoView.this.ivG) {
                        QuickVideoView.this.ivv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.ivF);
                        if (QuickVideoView.this.iva != null) {
                            QuickVideoView.this.iva.cdQ();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ivy.bOG();
                        }
                    }
                } else if (cem()) {
                    if (QuickVideoView.this.ivv != null) {
                        QuickVideoView.this.cee();
                        QuickVideoView.this.ivD = true;
                        QuickVideoView.this.ivv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ivy.bOF();
                    }
                }
                QuickVideoView.this.ivH = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.iwf) {
                    QuickVideoView.this.ceh();
                    QuickVideoView.this.qe(false);
                    if (QuickVideoView.this.ivv != null) {
                        if (QuickVideoView.this.ivv.isPlaying() && QuickVideoView.this.cek()) {
                            y.ceM().bg(QuickVideoView.this.ivO, QuickVideoView.this.ivv.getCurrentPosition());
                        }
                        QuickVideoView.this.ivv.release();
                    }
                    if (QuickVideoView.this.ivD) {
                        if (QuickVideoView.this.ivC != null) {
                            QuickVideoView.this.ivC.onStop();
                        }
                        if (QuickVideoView.this.cJW != null) {
                            QuickVideoView.this.cJW.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ivH = null;
                    if (QuickVideoView.this.ivy != null && QuickVideoView.this.ivy.Bd(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ivD = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cem() {
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
        this.dgs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int CZ;
                QuickVideoView.this.ceh();
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.onPrepared();
                }
                if (QuickVideoView.this.ivy != null && QuickVideoView.this.ivv != null) {
                    QuickVideoView.this.ivy.xl(QuickVideoView.this.ivv.getPlayerType());
                }
                if (QuickVideoView.this.cTq != null) {
                    QuickVideoView.this.cTq.onPrepared(gVar);
                }
                if (QuickVideoView.this.ivC != null) {
                    long j = 0;
                    if (QuickVideoView.this.ivv != null) {
                        j = QuickVideoView.this.ivv.getDuration();
                    }
                    QuickVideoView.this.ivC.eq(j);
                    QuickVideoView.this.cef();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ivC.cdX();
                        QuickVideoView.this.cej();
                    }
                }
                if (QuickVideoView.this.ivR && (CZ = y.ceM().CZ(QuickVideoView.this.ivO)) > 0) {
                    if (QuickVideoView.this.ivv.isPlayerReuse()) {
                        if (QuickVideoView.this.ivv.getCurrentPosition() == 0) {
                            QuickVideoView.this.yX(CZ);
                        }
                    } else {
                        QuickVideoView.this.yX(CZ);
                    }
                }
                if (QuickVideoView.this.ivB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ivt != null && gVar != null) {
                    QuickVideoView.this.ivt.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ivE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ivu) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ivu);
                }
                if (QuickVideoView.this.ivJ != null && QuickVideoView.this.ivJ.cfi()) {
                    com.baidu.tieba.play.b.e.ze(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dgt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qe(true);
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.Bc(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ivy = null;
                }
                if (!QuickVideoView.this.dgj || QuickVideoView.this.ivC == null) {
                    if (QuickVideoView.this.ivC != null) {
                        QuickVideoView.this.ivC.onCompletion();
                    }
                    QuickVideoView.this.ivB = false;
                    y.ceM().remove(QuickVideoView.this.ivO);
                    if (QuickVideoView.this.cTp != null) {
                        QuickVideoView.this.cTp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ivA = null;
                QuickVideoView.this.ivP = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ivC.cdR());
                QuickVideoView.this.start();
            }
        };
        this.cTr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ae(i, i2, i3);
                QuickVideoView.this.ceh();
                if (QuickVideoView.this.ivC != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cek()) {
                    QuickVideoView.this.ivQ = true;
                    y.ceM().bg(QuickVideoView.this.ivO, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.ivy != null) {
                        QuickVideoView.this.ivA = QuickVideoView.this.ivy.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ivP, QuickVideoView.this.Z(QuickVideoView.this.ivy.bOK(), i3 + "", QuickVideoView.this.ivy.bOL()));
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ivP = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.zc(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.zd(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cJS == null || QuickVideoView.this.cJS.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dgw = new g.InterfaceC0387g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0387g
            public void b(g gVar) {
                if (QuickVideoView.this.ivQ) {
                    QuickVideoView.this.ivQ = false;
                    return;
                }
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.cew();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ivC != null && z) {
                    QuickVideoView.this.ivC.onSeekComplete();
                }
                if (QuickVideoView.this.cTt != null) {
                    QuickVideoView.this.cTt.b(gVar);
                }
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ivw != null) {
                    QuickVideoView.this.ivw.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ivE = i2;
                    if (QuickVideoView.this.ivt != null && gVar != null) {
                        QuickVideoView.this.ivt.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ivE);
                    }
                }
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.a(i, i2, QuickVideoView.this.ivy);
                    return true;
                }
                return true;
            }
        };
        this.cTu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.i(i, i2, str);
                }
            }
        };
        this.cTv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.Be(str);
                }
            }
        };
        this.cTw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ivP = j;
                }
            }
        };
        this.iwj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ivC != null && QuickVideoView.this.ivC.cdT() && QuickVideoView.this.ivC.cdU() && QuickVideoView.this.ivC.cdV() && QuickVideoView.this.ivv != null) {
                    int aBE = QuickVideoView.this.ivv.aBE();
                    int currentPosition = QuickVideoView.this.ivv.getCurrentPosition();
                    int duration = QuickVideoView.this.ivv.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ivS;
                    boolean z = currentPosition + aBE < duration;
                    if (aBE < QuickVideoView.this.ivC.cdW() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ivS = currentTimeMillis;
                        QuickVideoView.this.ivC.yV(0);
                    }
                    if (QuickVideoView.this.cei() && currentPosition == QuickVideoView.this.ivT && j > 500) {
                        QuickVideoView.this.ivS = currentTimeMillis;
                        QuickVideoView.this.ivC.yV(0);
                    }
                    QuickVideoView.this.ivT = currentPosition;
                    if (QuickVideoView.this.ifd == QuickVideoView.ivX) {
                        QuickVideoView.this.cej();
                    }
                }
            }
        };
        this.cTD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ivC != null) {
                        QuickVideoView.this.ivC.cdZ();
                    }
                    if (QuickVideoView.this.ivy != null) {
                        QuickVideoView.this.ivy.Bb(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ceh();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ivB = false;
        this.ivD = false;
        this.ivE = 0;
        this.dgj = false;
        this.ivF = -1;
        this.ivG = false;
        this.ivH = null;
        this.ivI = true;
        this.ivS = 0L;
        this.ivT = 0L;
        this.ifd = ivY;
        this.ivZ = 0;
        this.iwa = 0;
        this.iwb = -1;
        this.iwc = 0;
        this.iwd = 0;
        this.iwe = 0;
        this.cXF = 0;
        this.iwf = false;
        this.bBD = null;
        this.iwg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ivv != null && QuickVideoView.this.ivB) {
                    QuickVideoView.this.b(QuickVideoView.this.ivv, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.iwh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.nx(false);
                }
            }
        };
        this.iwi = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.iwf) {
                    QuickVideoView.this.iwf = false;
                    QuickVideoView.this.ivv.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ivD || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ivv != null && QuickVideoView.this.ivG) {
                        QuickVideoView.this.ivv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.ivF);
                        if (QuickVideoView.this.iva != null) {
                            QuickVideoView.this.iva.cdQ();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ivy.bOG();
                        }
                    }
                } else if (cem()) {
                    if (QuickVideoView.this.ivv != null) {
                        QuickVideoView.this.cee();
                        QuickVideoView.this.ivD = true;
                        QuickVideoView.this.ivv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ivy.bOF();
                    }
                }
                QuickVideoView.this.ivH = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.iwf) {
                    QuickVideoView.this.ceh();
                    QuickVideoView.this.qe(false);
                    if (QuickVideoView.this.ivv != null) {
                        if (QuickVideoView.this.ivv.isPlaying() && QuickVideoView.this.cek()) {
                            y.ceM().bg(QuickVideoView.this.ivO, QuickVideoView.this.ivv.getCurrentPosition());
                        }
                        QuickVideoView.this.ivv.release();
                    }
                    if (QuickVideoView.this.ivD) {
                        if (QuickVideoView.this.ivC != null) {
                            QuickVideoView.this.ivC.onStop();
                        }
                        if (QuickVideoView.this.cJW != null) {
                            QuickVideoView.this.cJW.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ivH = null;
                    if (QuickVideoView.this.ivy != null && QuickVideoView.this.ivy.Bd(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ivD = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cem() {
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
        this.dgs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int CZ;
                QuickVideoView.this.ceh();
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.onPrepared();
                }
                if (QuickVideoView.this.ivy != null && QuickVideoView.this.ivv != null) {
                    QuickVideoView.this.ivy.xl(QuickVideoView.this.ivv.getPlayerType());
                }
                if (QuickVideoView.this.cTq != null) {
                    QuickVideoView.this.cTq.onPrepared(gVar);
                }
                if (QuickVideoView.this.ivC != null) {
                    long j = 0;
                    if (QuickVideoView.this.ivv != null) {
                        j = QuickVideoView.this.ivv.getDuration();
                    }
                    QuickVideoView.this.ivC.eq(j);
                    QuickVideoView.this.cef();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ivC.cdX();
                        QuickVideoView.this.cej();
                    }
                }
                if (QuickVideoView.this.ivR && (CZ = y.ceM().CZ(QuickVideoView.this.ivO)) > 0) {
                    if (QuickVideoView.this.ivv.isPlayerReuse()) {
                        if (QuickVideoView.this.ivv.getCurrentPosition() == 0) {
                            QuickVideoView.this.yX(CZ);
                        }
                    } else {
                        QuickVideoView.this.yX(CZ);
                    }
                }
                if (QuickVideoView.this.ivB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ivt != null && gVar != null) {
                    QuickVideoView.this.ivt.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ivE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ivu) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ivu);
                }
                if (QuickVideoView.this.ivJ != null && QuickVideoView.this.ivJ.cfi()) {
                    com.baidu.tieba.play.b.e.ze(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dgt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qe(true);
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.Bc(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ivy = null;
                }
                if (!QuickVideoView.this.dgj || QuickVideoView.this.ivC == null) {
                    if (QuickVideoView.this.ivC != null) {
                        QuickVideoView.this.ivC.onCompletion();
                    }
                    QuickVideoView.this.ivB = false;
                    y.ceM().remove(QuickVideoView.this.ivO);
                    if (QuickVideoView.this.cTp != null) {
                        QuickVideoView.this.cTp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ivA = null;
                QuickVideoView.this.ivP = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ivC.cdR());
                QuickVideoView.this.start();
            }
        };
        this.cTr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ae(i2, i22, i3);
                QuickVideoView.this.ceh();
                if (QuickVideoView.this.ivC != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cek()) {
                    QuickVideoView.this.ivQ = true;
                    y.ceM().bg(QuickVideoView.this.ivO, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.ivy != null) {
                        QuickVideoView.this.ivA = QuickVideoView.this.ivy.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ivP, QuickVideoView.this.Z(QuickVideoView.this.ivy.bOK(), i3 + "", QuickVideoView.this.ivy.bOL()));
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ivP = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.zc(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.zd(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cJS == null || QuickVideoView.this.cJS.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.dgw = new g.InterfaceC0387g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0387g
            public void b(g gVar) {
                if (QuickVideoView.this.ivQ) {
                    QuickVideoView.this.ivQ = false;
                    return;
                }
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.cew();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ivC != null && z) {
                    QuickVideoView.this.ivC.onSeekComplete();
                }
                if (QuickVideoView.this.cTt != null) {
                    QuickVideoView.this.cTt.b(gVar);
                }
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.ivw != null) {
                    QuickVideoView.this.ivw.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.ivE = i22;
                    if (QuickVideoView.this.ivt != null && gVar != null) {
                        QuickVideoView.this.ivt.ad(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ivE);
                    }
                }
                if (QuickVideoView.this.ivK != null) {
                    QuickVideoView.this.ivK.a(i2, i22, QuickVideoView.this.ivy);
                    return true;
                }
                return true;
            }
        };
        this.cTu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.i(i2, i22, str);
                }
            }
        };
        this.cTv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ivy != null) {
                    QuickVideoView.this.ivy.Be(str);
                }
            }
        };
        this.cTw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ivP = j;
                }
            }
        };
        this.iwj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ivC != null && QuickVideoView.this.ivC.cdT() && QuickVideoView.this.ivC.cdU() && QuickVideoView.this.ivC.cdV() && QuickVideoView.this.ivv != null) {
                    int aBE = QuickVideoView.this.ivv.aBE();
                    int currentPosition = QuickVideoView.this.ivv.getCurrentPosition();
                    int duration = QuickVideoView.this.ivv.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ivS;
                    boolean z = currentPosition + aBE < duration;
                    if (aBE < QuickVideoView.this.ivC.cdW() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ivS = currentTimeMillis;
                        QuickVideoView.this.ivC.yV(0);
                    }
                    if (QuickVideoView.this.cei() && currentPosition == QuickVideoView.this.ivT && j > 500) {
                        QuickVideoView.this.ivS = currentTimeMillis;
                        QuickVideoView.this.ivC.yV(0);
                    }
                    QuickVideoView.this.ivT = currentPosition;
                    if (QuickVideoView.this.ifd == QuickVideoView.ivX) {
                        QuickVideoView.this.cej();
                    }
                }
            }
        };
        this.cTD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ivC != null) {
                        QuickVideoView.this.ivC.cdZ();
                    }
                    if (QuickVideoView.this.ivy != null) {
                        QuickVideoView.this.ivy.Bb(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ivy = null;
                    }
                    QuickVideoView.this.ceh();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ivt = new RenderView(context);
        this.bBD = new WeakReference<>(TbadkCoreApplication.getInst());
        this.ivt.setSurfaceTextureListener(this.iwi);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.ivI) {
            addView(this.ivt, layoutParams);
        } else {
            addView(this.ivt, 0, layoutParams);
        }
        if (dgq != null) {
            this.ivv = dgq.aBG();
        }
        if (this.ivv != null) {
            this.ivv.setOnPreparedListener(this.dgs);
            this.ivv.setOnCompletionListener(this.dgt);
            this.ivv.a(this.cTr);
            this.ivv.setOnSeekCompleteListener(this.dgw);
            this.ivv.a(this.cTs);
            this.ivv.a(this.cTu);
            this.ivv.a(this.cTv);
            this.ivv.a(this.cTw);
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
        this.ivJ = new com.baidu.tieba.play.b.a(this);
        this.ivK = new r();
        this.ivL = new com.baidu.tieba.play.b.f();
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
        this.ivR = z;
    }

    public void setVideoPath(String str, String str2) {
        this.bWO = str2;
        if (this.ivJ != null) {
            this.ivJ.clear();
            this.ivJ.cfi();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.De(str2);
            if (dgr != null) {
                this.ivy = dgr.X(this.bWO, str, "");
                if (this.ivy != null) {
                    this.ivy.a(-300, -44399, -44399, getLocateSource(), false, this.ivP, "");
                    this.ivy = null;
                }
            }
        }
        if (this.ivz != null) {
            this.ivz.a(null);
            this.ivz.bOy();
            this.ivz = null;
        }
        this.ivA = null;
        this.ivP = 0L;
        setVideoPath(str);
    }

    public void dS(String str, String str2) {
    }

    private String CV(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.ctE().ctF()) {
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
            String CV = CV(str);
            this.ivM = CV;
            if (this.ivC != null) {
                CV = this.ivC.sc(CV);
                if (this.ivC.cdY() != null) {
                    this.ivC.cdY().setPlayer(this);
                }
                if (dgr != null && pD(CV)) {
                    this.ivz = dgr.Bh(CV);
                }
                if (this.ivz != null) {
                    this.ivz.a(new com.baidu.tieba.play.monitor.a(this.bWO, this.ivM, this.ivy));
                    this.ivz.bOx();
                }
                CW(CV);
            }
            if (!com.baidu.adp.lib.util.j.kc() && !pD(CV)) {
                if (this.cJS != null) {
                    this.cJS.onError(this.ivv, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(CV));
            if (this.ivy != null) {
                if (u(Uri.parse(CV)) != null) {
                    this.ivy.bOE();
                }
                this.ivy.Gb();
                this.ivy = null;
            }
            this.ivN = str;
            int lastIndexOf = this.ivN.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.ivN.length() > 4) {
                this.ivO = this.ivN.substring(0, lastIndexOf + 4);
            } else {
                this.ivO = this.ivN;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cee() {
        if (com.baidu.tbadk.coreExtra.model.f.apK()) {
            if (this.ivC != null && (this.ivC.cdS() || this.ivC.cdT())) {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwg);
                com.baidu.adp.lib.g.e.iK().postDelayed(this.iwg, com.baidu.tbadk.coreExtra.model.f.apJ());
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwh);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.iwh, com.baidu.tbadk.coreExtra.model.f.apI());
        }
    }

    public void cdt() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        b(uri, (Map<String, String>) null);
    }

    private void b(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.ivy.Ba(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aBA();
        }
        this.mUri = uri;
        this.FV = map;
        if (this.ivH != null) {
            cee();
            if (this.ivv != null) {
                if (!this.ivD) {
                    this.ivD = true;
                    this.ivv.a(this.mContext, this.mUri, this.FV, this.ivH, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.dgs.onPrepared(this.ivv);
                }
            }
        } else if (this.ivt != null && this.ivt.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.ivI) {
                addView(this.ivt, layoutParams);
            } else {
                addView(this.ivt, 0, layoutParams);
            }
        }
        am.k(this, R.color.cp_bg_line_k);
    }

    private void aBA() {
        this.ivD = false;
        this.ivB = false;
        if (this.ivv != null) {
            if (this.ivv.isPlaying() && cek()) {
                y.ceM().bg(this.ivO, this.ivv.getCurrentPosition());
            }
            this.ivv.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwj);
    }

    private void CW(String str) {
        this.iwa = 0;
        this.iwb = 0;
        this.iwc = 0;
        this.iwd = 0;
        this.iwe = 0;
        this.cXF = 0;
        if (this.ivC.cdT()) {
            this.ivZ = ivV;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.iwb = (int) u.CY(QuickVideoView.this.ivM);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.ivM != null && this.ivM.equals(str)) {
            this.ivZ = ivU;
        } else {
            this.ivZ = ivW;
        }
        this.ifd = ivX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cef() {
        this.ifd = ivX;
        if (this.ivv != null) {
            this.iwa = this.ivv.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(boolean z) {
        if (this.ifd == ivX && this.ivv != null) {
            this.ifd = ivY;
            this.iwd = this.ivv.getDuration();
            if (z) {
                this.iwe = 0;
                this.iwc = this.iwd;
            } else {
                this.iwc = this.ivv.getCurrentPosition();
                this.iwe = this.ivv.getCachedSize();
            }
            if (this.iwc > 0) {
                if (this.ivZ == ivU) {
                    this.iwb = (int) u.CY(this.ivM);
                    if (this.iwa > 0) {
                        long j = (this.iwa * (this.iwc / 1000)) / 8;
                        if (this.iwe < 0) {
                            this.iwe = 0;
                        }
                        long j2 = this.iwe + j;
                        if (this.iwb > 0) {
                            j2 += this.iwb;
                        }
                        setFlowCount(j2, this.iwc, this.iwd, this.cXF);
                    } else if (this.iwa == -1) {
                        this.iwa = 603327;
                        setFlowCount((this.iwa * (this.iwc / 1000)) / 8, this.iwc, this.iwd, this.cXF);
                    }
                } else if (this.ivZ == ivV) {
                    if (this.iwa > 0) {
                        long j3 = (this.iwa * (this.iwc / 1000)) / 8;
                        if (this.iwe < 0) {
                            this.iwe = 0;
                        }
                        long j4 = this.iwe + j3;
                        if (this.iwb > 0) {
                            j4 -= this.iwb;
                        }
                        setFlowCount(j4, this.iwc, this.iwd, this.cXF);
                    } else if (this.iwa == -1) {
                        this.iwa = 603327;
                        setFlowCount((this.iwa * (this.iwc / 1000)) / 8, this.iwc, this.iwd, this.cXF);
                    }
                } else {
                    setFlowCount(0L, this.iwc, this.iwd, this.cXF);
                }
            }
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwj);
    }

    public void ceg() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.bBD, false);
        }
        ceh();
        qe(false);
        if (this.ivJ != null) {
            this.ivJ.clear();
        }
        this.ivu = null;
        aBA();
        this.dgj = false;
        if (this.ivC != null) {
            this.ivC.onStop();
        }
        com.baidu.tieba.play.a.b.ceP().a((b.InterfaceC0384b) null);
        if (this.ivy != null && this.ivy.Bd(getLocateSource())) {
            this.ivy = null;
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwj);
    }

    public void setFullScreenToDestroySurface() {
        this.iwf = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceh() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwg);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwh);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cTq = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cTp = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cJS = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0387g interfaceC0387g) {
        this.cTt = interfaceC0387g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.ivL == null) {
            return "";
        }
        String cfk = this.ivL.cfk();
        this.ivL.aa(str, str2, str3);
        return cfk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.ivC != null && !StringUtils.isNull(this.ivC.cdR())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Dd(uri);
                }
            }
            this.mUri = Uri.parse(this.ivC.cdR());
        }
        boolean z = false;
        if (this.ivJ != null) {
            z = this.ivJ.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.ivy != null) {
            this.ivA = this.ivy.a(i, i2, i3, getLocateSource(), z, this.ivP, Z(this.ivy.bOK(), i3 + "", this.ivy.bOL()));
            this.ivy = null;
        }
        this.ivP = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.ivv != null) {
            try {
                if (this.ivv.isPlaying() && cek()) {
                    y.ceM().bg(this.ivO, this.ivv.getCurrentPosition());
                }
                this.ivv.release();
                this.ivu = str;
                URI uri = new URI(this.mUri.toString());
                this.ivv.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.FV, this.ivH, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.ivy.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ivv != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.ivv.isPlaying() && cek()) {
                y.ceM().bg(this.ivO, this.ivv.getCurrentPosition());
            }
            this.ivv.release();
            this.ivv.a(this.mContext, this.mUri, this.FV, this.ivH, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.ivy.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ivv != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.ivv.forceUseSystemMediaPlayer(true);
            }
            if (this.ivv.isPlaying() && cek()) {
                y.ceM().bg(this.ivO, this.ivv.getCurrentPosition());
            }
            this.ivv.release();
            this.ivv.a(this.mContext, this.mUri, this.FV, this.ivH, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.ivy.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.ivB = true;
        if (this.ivv != null) {
            if (this.ivH != null && this.ivG && !this.ivv.isExistInRemote()) {
                this.ivv.a(this.mContext, this.mUri, this.FV, this.ivH, this.ivF);
                if (this.iva != null) {
                    this.iva.cdQ();
                }
                if (u(this.mUri) != null) {
                    this.ivy.bOG();
                }
                cee();
                return;
            }
            if (!this.ivv.aBF()) {
                ad.a(this.bBD, true);
                this.ivv.setVolume(1.0f, 1.0f);
            }
            this.ivv.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.ivC != null) {
            this.ivC.onStart();
        }
        if (this.ivx != null) {
            this.ivx.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.ivv != null) {
            this.ivy.xm(this.ivv.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        ceh();
        ad.a(this.bBD, false);
        if (this.ivv != null) {
            if (this.ivv.isPlaying() && cek()) {
                y.ceM().bg(this.ivO, this.ivv.getCurrentPosition());
            }
            this.ivv.pause();
        }
        if (this.ivC != null) {
            this.ivC.onPause();
        }
        this.ivB = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ivy != null) {
            this.ivy.bOJ();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.ivv != null) {
            return this.ivv.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.ivv != null) {
            return this.ivv.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cXF = i;
        yX(i);
    }

    public void yX(int i) {
        if (this.ivK != null) {
            this.ivK.cev();
        }
        if (this.ivv != null) {
            this.ivv.seekTo(i);
        }
        if (this.ivC != null) {
            this.ivC.yV(0);
            cej();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.ivv != null) {
            return this.ivv.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.ivv != null) {
            this.ivv.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.ivF = i;
    }

    public int getRecoveryState() {
        return this.ivF;
    }

    public void setNeedRecovery(boolean z) {
        this.ivG = z;
    }

    public void setLooping(boolean z) {
        this.dgj = z;
    }

    public boolean cei() {
        return this.ivB;
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
        this.cJW = bVar;
    }

    public void setBusiness(d dVar) {
        this.ivC = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cTD);
    }

    public void setMute(boolean z) {
        if (z) {
            this.ivv.setVolume(0.0f, 0.0f);
            ad.a(this.bBD, false);
            return;
        }
        ad.a(this.bBD, true);
        this.ivv.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dgj = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ivv != null) {
            this.ivv.awv();
        }
        if (this.ivK != null) {
            this.ivK.cex();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwj);
        MessageManager.getInstance().unRegisterListener(this.cTD);
        if (this.ivJ != null) {
            this.ivJ.clear();
        }
        if (this.ivz != null) {
            this.ivz.a(null);
            this.ivz.bOy();
        }
    }

    public g getPlayer() {
        return this.ivv;
    }

    public int getPlayerType() {
        if (this.ivv == null) {
            return -300;
        }
        return this.ivv.getPlayerType();
    }

    public void cej() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwj);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iwj, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.iva = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.ivC instanceof n) || ((n) this.ivC).cet() == null) ? "" : ((n) this.ivC).cet().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i u(Uri uri) {
        String uri2;
        if (this.ivy != null) {
            return this.ivy;
        }
        if (!StringUtils.isNull(this.ivM)) {
            uri2 = this.ivM;
        } else if (dgr != null && this.ivC != null && !StringUtils.isNull(this.ivC.cdR())) {
            uri2 = this.ivC.cdR();
        } else {
            uri2 = (dgr == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && dgr != null) {
            this.ivy = dgr.X(this.bWO, uri2, this.ivA);
        }
        this.ivA = null;
        this.ivP = 0L;
        return this.ivy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cek() {
        return this.ivv != null && this.ivv.getDuration() >= this.ivv.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.ivy, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.ivy, j);
    }

    public static boolean pD(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.ivw = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.ivv != null) {
            return this.ivv.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.ivv != null ? this.ivv.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.ivy != null) {
            this.ivy.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.ivx = cVar;
    }
}
