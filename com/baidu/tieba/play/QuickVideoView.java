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
    private static h deL;
    private static com.baidu.tieba.j.l deM;
    private static int ipA = 0;
    private static int ipB = 1;
    private static int ipC = 2;
    private static int ipD = 1;
    private static int ipE = 0;
    private Map<String, String> FO;
    private WeakReference<Context> bAG;
    private String bVL;
    private b cIB;
    private g.b cIx;
    private g.a cRR;
    private g.f cRS;
    private g.c cRT;
    private g.e cRU;
    private g.InterfaceC0388g cRV;
    private g.i cRW;
    private g.d cRX;
    private g.h cRY;
    private final CustomMessageListener cSf;
    private int cWh;
    private boolean deE;
    private g.f deN;
    private g.a deO;
    private g.InterfaceC0388g deR;
    private int hYJ;
    private a ioG;
    private RenderView ioZ;
    private int ipF;
    private int ipG;
    private int ipH;
    private int ipI;
    private int ipJ;
    private int ipK;
    private boolean ipL;
    private Runnable ipM;
    private Runnable ipN;
    private TextureView.SurfaceTextureListener ipO;
    private Runnable ipP;
    private String ipa;
    private g ipb;
    private g.e ipc;
    private c ipd;
    private com.baidu.tieba.j.i ipe;
    private com.baidu.tieba.j.e ipf;
    private String ipg;
    private boolean iph;
    private d ipi;
    private boolean ipj;
    private int ipk;
    private int ipl;
    private boolean ipm;
    private SurfaceTexture ipn;
    private boolean ipo;
    private com.baidu.tieba.play.b.a ipp;
    private r ipq;
    private com.baidu.tieba.play.b.f ipr;
    private String ips;
    private String ipt;
    private String ipu;
    private long ipv;
    private boolean ipw;
    private boolean ipx;
    private long ipy;
    private long ipz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void caX();
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
            deL = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            deM = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.ipo = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.iph = false;
        this.ipj = false;
        this.ipk = 0;
        this.deE = false;
        this.ipl = -1;
        this.ipm = false;
        this.ipn = null;
        this.ipo = true;
        this.ipy = 0L;
        this.ipz = 0L;
        this.hYJ = ipE;
        this.ipF = 0;
        this.ipG = 0;
        this.ipH = -1;
        this.ipI = 0;
        this.ipJ = 0;
        this.ipK = 0;
        this.cWh = 0;
        this.ipL = false;
        this.bAG = null;
        this.ipM = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipb != null && QuickVideoView.this.iph) {
                    QuickVideoView.this.b(QuickVideoView.this.ipb, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipN = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.ni(false);
                }
            }
        };
        this.ipO = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ipL) {
                    QuickVideoView.this.ipL = false;
                    QuickVideoView.this.ipb.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipj || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipb != null && QuickVideoView.this.ipm) {
                        QuickVideoView.this.ipb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.ipl);
                        if (QuickVideoView.this.ioG != null) {
                            QuickVideoView.this.ioG.caX();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ipe.bLU();
                        }
                    }
                } else if (cbs()) {
                    if (QuickVideoView.this.ipb != null) {
                        QuickVideoView.this.cbl();
                        QuickVideoView.this.ipj = true;
                        QuickVideoView.this.ipb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ipe.bLT();
                    }
                }
                QuickVideoView.this.ipn = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipL) {
                    QuickVideoView.this.cbn();
                    QuickVideoView.this.pP(false);
                    if (QuickVideoView.this.ipb != null) {
                        if (QuickVideoView.this.ipb.isPlaying() && QuickVideoView.this.cbq()) {
                            y.cbS().bf(QuickVideoView.this.ipu, QuickVideoView.this.ipb.getCurrentPosition());
                        }
                        QuickVideoView.this.ipb.release();
                    }
                    if (QuickVideoView.this.ipj) {
                        if (QuickVideoView.this.ipi != null) {
                            QuickVideoView.this.ipi.onStop();
                        }
                        if (QuickVideoView.this.cIB != null) {
                            QuickVideoView.this.cIB.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipn = null;
                    if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipe.Aq(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.ipj = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbs() {
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
        this.deN = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Ck;
                QuickVideoView.this.cbn();
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.onPrepared();
                }
                if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipb != null) {
                    QuickVideoView.this.ipe.wI(QuickVideoView.this.ipb.getPlayerType());
                }
                if (QuickVideoView.this.cRS != null) {
                    QuickVideoView.this.cRS.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipi != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipb != null) {
                        j = QuickVideoView.this.ipb.getDuration();
                    }
                    QuickVideoView.this.ipi.eg(j);
                    QuickVideoView.this.cbm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipi.cbe();
                        QuickVideoView.this.cbp();
                    }
                }
                if (QuickVideoView.this.ipx && (Ck = y.cbS().Ck(QuickVideoView.this.ipu)) > 0) {
                    if (QuickVideoView.this.ipb.isPlayerReuse()) {
                        if (QuickVideoView.this.ipb.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Ck);
                        }
                    } else {
                        QuickVideoView.this.ys(Ck);
                    }
                }
                if (QuickVideoView.this.iph) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ioZ != null && gVar != null) {
                    QuickVideoView.this.ioZ.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipk);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipa) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipa);
                }
                if (QuickVideoView.this.ipp != null && QuickVideoView.this.ipp.cco()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deO = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pP(true);
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.Ap(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ipe = null;
                }
                if (!QuickVideoView.this.deE || QuickVideoView.this.ipi == null) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.onCompletion();
                    }
                    QuickVideoView.this.iph = false;
                    y.cbS().remove(QuickVideoView.this.ipu);
                    if (QuickVideoView.this.cRR != null) {
                        QuickVideoView.this.cRR.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipg = null;
                QuickVideoView.this.ipv = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipi.caY());
                QuickVideoView.this.start();
            }
        };
        this.cRT = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ad(i, i2, i3);
                QuickVideoView.this.cbn();
                if (QuickVideoView.this.ipi != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbq()) {
                    QuickVideoView.this.ipw = true;
                    y.cbS().bf(QuickVideoView.this.ipu, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.ipg = QuickVideoView.this.ipe.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipv, QuickVideoView.this.Z(QuickVideoView.this.ipe.bLY(), i3 + "", QuickVideoView.this.ipe.bLZ()));
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.ipv = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.yx(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.yy(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cIx == null || QuickVideoView.this.cIx.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.deR = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipw) {
                    QuickVideoView.this.ipw = false;
                    return;
                }
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.cbC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipi != null && z) {
                    QuickVideoView.this.ipi.onSeekComplete();
                }
                if (QuickVideoView.this.cRV != null) {
                    QuickVideoView.this.cRV.b(gVar);
                }
            }
        };
        this.cRU = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ipc != null) {
                    QuickVideoView.this.ipc.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ipk = i2;
                    if (QuickVideoView.this.ioZ != null && gVar != null) {
                        QuickVideoView.this.ioZ.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipk);
                    }
                }
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.a(i, i2, QuickVideoView.this.ipe);
                    return true;
                }
                return true;
            }
        };
        this.cRW = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.i(i, i2, str);
                }
            }
        };
        this.cRX = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.Ar(str);
                }
            }
        };
        this.cRY = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipv = j;
                }
            }
        };
        this.ipP = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipi != null && QuickVideoView.this.ipi.cba() && QuickVideoView.this.ipi.cbb() && QuickVideoView.this.ipi.cbc() && QuickVideoView.this.ipb != null) {
                    int aAm = QuickVideoView.this.ipb.aAm();
                    int currentPosition = QuickVideoView.this.ipb.getCurrentPosition();
                    int duration = QuickVideoView.this.ipb.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipy;
                    boolean z = currentPosition + aAm < duration;
                    if (aAm < QuickVideoView.this.ipi.cbd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipy = currentTimeMillis;
                        QuickVideoView.this.ipi.yq(0);
                    }
                    if (QuickVideoView.this.cbo() && currentPosition == QuickVideoView.this.ipz && j > 500) {
                        QuickVideoView.this.ipy = currentTimeMillis;
                        QuickVideoView.this.ipi.yq(0);
                    }
                    QuickVideoView.this.ipz = currentPosition;
                    if (QuickVideoView.this.hYJ == QuickVideoView.ipD) {
                        QuickVideoView.this.cbp();
                    }
                }
            }
        };
        this.cSf = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.cbg();
                    }
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.ipe.Ao(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.cbn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iph = false;
        this.ipj = false;
        this.ipk = 0;
        this.deE = false;
        this.ipl = -1;
        this.ipm = false;
        this.ipn = null;
        this.ipo = true;
        this.ipy = 0L;
        this.ipz = 0L;
        this.hYJ = ipE;
        this.ipF = 0;
        this.ipG = 0;
        this.ipH = -1;
        this.ipI = 0;
        this.ipJ = 0;
        this.ipK = 0;
        this.cWh = 0;
        this.ipL = false;
        this.bAG = null;
        this.ipM = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipb != null && QuickVideoView.this.iph) {
                    QuickVideoView.this.b(QuickVideoView.this.ipb, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipN = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.ni(false);
                }
            }
        };
        this.ipO = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ipL) {
                    QuickVideoView.this.ipL = false;
                    QuickVideoView.this.ipb.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipj || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipb != null && QuickVideoView.this.ipm) {
                        QuickVideoView.this.ipb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.ipl);
                        if (QuickVideoView.this.ioG != null) {
                            QuickVideoView.this.ioG.caX();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ipe.bLU();
                        }
                    }
                } else if (cbs()) {
                    if (QuickVideoView.this.ipb != null) {
                        QuickVideoView.this.cbl();
                        QuickVideoView.this.ipj = true;
                        QuickVideoView.this.ipb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ipe.bLT();
                    }
                }
                QuickVideoView.this.ipn = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipL) {
                    QuickVideoView.this.cbn();
                    QuickVideoView.this.pP(false);
                    if (QuickVideoView.this.ipb != null) {
                        if (QuickVideoView.this.ipb.isPlaying() && QuickVideoView.this.cbq()) {
                            y.cbS().bf(QuickVideoView.this.ipu, QuickVideoView.this.ipb.getCurrentPosition());
                        }
                        QuickVideoView.this.ipb.release();
                    }
                    if (QuickVideoView.this.ipj) {
                        if (QuickVideoView.this.ipi != null) {
                            QuickVideoView.this.ipi.onStop();
                        }
                        if (QuickVideoView.this.cIB != null) {
                            QuickVideoView.this.cIB.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipn = null;
                    if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipe.Aq(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.ipj = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbs() {
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
        this.deN = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Ck;
                QuickVideoView.this.cbn();
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.onPrepared();
                }
                if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipb != null) {
                    QuickVideoView.this.ipe.wI(QuickVideoView.this.ipb.getPlayerType());
                }
                if (QuickVideoView.this.cRS != null) {
                    QuickVideoView.this.cRS.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipi != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipb != null) {
                        j = QuickVideoView.this.ipb.getDuration();
                    }
                    QuickVideoView.this.ipi.eg(j);
                    QuickVideoView.this.cbm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipi.cbe();
                        QuickVideoView.this.cbp();
                    }
                }
                if (QuickVideoView.this.ipx && (Ck = y.cbS().Ck(QuickVideoView.this.ipu)) > 0) {
                    if (QuickVideoView.this.ipb.isPlayerReuse()) {
                        if (QuickVideoView.this.ipb.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Ck);
                        }
                    } else {
                        QuickVideoView.this.ys(Ck);
                    }
                }
                if (QuickVideoView.this.iph) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ioZ != null && gVar != null) {
                    QuickVideoView.this.ioZ.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipk);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipa) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipa);
                }
                if (QuickVideoView.this.ipp != null && QuickVideoView.this.ipp.cco()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deO = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pP(true);
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.Ap(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ipe = null;
                }
                if (!QuickVideoView.this.deE || QuickVideoView.this.ipi == null) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.onCompletion();
                    }
                    QuickVideoView.this.iph = false;
                    y.cbS().remove(QuickVideoView.this.ipu);
                    if (QuickVideoView.this.cRR != null) {
                        QuickVideoView.this.cRR.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipg = null;
                QuickVideoView.this.ipv = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipi.caY());
                QuickVideoView.this.start();
            }
        };
        this.cRT = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ad(i, i2, i3);
                QuickVideoView.this.cbn();
                if (QuickVideoView.this.ipi != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbq()) {
                    QuickVideoView.this.ipw = true;
                    y.cbS().bf(QuickVideoView.this.ipu, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.ipg = QuickVideoView.this.ipe.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipv, QuickVideoView.this.Z(QuickVideoView.this.ipe.bLY(), i3 + "", QuickVideoView.this.ipe.bLZ()));
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.ipv = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.yx(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.yy(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cIx == null || QuickVideoView.this.cIx.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.deR = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipw) {
                    QuickVideoView.this.ipw = false;
                    return;
                }
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.cbC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipi != null && z) {
                    QuickVideoView.this.ipi.onSeekComplete();
                }
                if (QuickVideoView.this.cRV != null) {
                    QuickVideoView.this.cRV.b(gVar);
                }
            }
        };
        this.cRU = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ipc != null) {
                    QuickVideoView.this.ipc.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ipk = i2;
                    if (QuickVideoView.this.ioZ != null && gVar != null) {
                        QuickVideoView.this.ioZ.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipk);
                    }
                }
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.a(i, i2, QuickVideoView.this.ipe);
                    return true;
                }
                return true;
            }
        };
        this.cRW = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.i(i, i2, str);
                }
            }
        };
        this.cRX = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.Ar(str);
                }
            }
        };
        this.cRY = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipv = j;
                }
            }
        };
        this.ipP = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipi != null && QuickVideoView.this.ipi.cba() && QuickVideoView.this.ipi.cbb() && QuickVideoView.this.ipi.cbc() && QuickVideoView.this.ipb != null) {
                    int aAm = QuickVideoView.this.ipb.aAm();
                    int currentPosition = QuickVideoView.this.ipb.getCurrentPosition();
                    int duration = QuickVideoView.this.ipb.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipy;
                    boolean z = currentPosition + aAm < duration;
                    if (aAm < QuickVideoView.this.ipi.cbd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipy = currentTimeMillis;
                        QuickVideoView.this.ipi.yq(0);
                    }
                    if (QuickVideoView.this.cbo() && currentPosition == QuickVideoView.this.ipz && j > 500) {
                        QuickVideoView.this.ipy = currentTimeMillis;
                        QuickVideoView.this.ipi.yq(0);
                    }
                    QuickVideoView.this.ipz = currentPosition;
                    if (QuickVideoView.this.hYJ == QuickVideoView.ipD) {
                        QuickVideoView.this.cbp();
                    }
                }
            }
        };
        this.cSf = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.cbg();
                    }
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.ipe.Ao(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.cbn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iph = false;
        this.ipj = false;
        this.ipk = 0;
        this.deE = false;
        this.ipl = -1;
        this.ipm = false;
        this.ipn = null;
        this.ipo = true;
        this.ipy = 0L;
        this.ipz = 0L;
        this.hYJ = ipE;
        this.ipF = 0;
        this.ipG = 0;
        this.ipH = -1;
        this.ipI = 0;
        this.ipJ = 0;
        this.ipK = 0;
        this.cWh = 0;
        this.ipL = false;
        this.bAG = null;
        this.ipM = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipb != null && QuickVideoView.this.iph) {
                    QuickVideoView.this.b(QuickVideoView.this.ipb, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipN = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.ni(false);
                }
            }
        };
        this.ipO = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.ipL) {
                    QuickVideoView.this.ipL = false;
                    QuickVideoView.this.ipb.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipj || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipb != null && QuickVideoView.this.ipm) {
                        QuickVideoView.this.ipb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.ipl);
                        if (QuickVideoView.this.ioG != null) {
                            QuickVideoView.this.ioG.caX();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ipe.bLU();
                        }
                    }
                } else if (cbs()) {
                    if (QuickVideoView.this.ipb != null) {
                        QuickVideoView.this.cbl();
                        QuickVideoView.this.ipj = true;
                        QuickVideoView.this.ipb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ipe.bLT();
                    }
                }
                QuickVideoView.this.ipn = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipL) {
                    QuickVideoView.this.cbn();
                    QuickVideoView.this.pP(false);
                    if (QuickVideoView.this.ipb != null) {
                        if (QuickVideoView.this.ipb.isPlaying() && QuickVideoView.this.cbq()) {
                            y.cbS().bf(QuickVideoView.this.ipu, QuickVideoView.this.ipb.getCurrentPosition());
                        }
                        QuickVideoView.this.ipb.release();
                    }
                    if (QuickVideoView.this.ipj) {
                        if (QuickVideoView.this.ipi != null) {
                            QuickVideoView.this.ipi.onStop();
                        }
                        if (QuickVideoView.this.cIB != null) {
                            QuickVideoView.this.cIB.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipn = null;
                    if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipe.Aq(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.ipj = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbs() {
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
        this.deN = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Ck;
                QuickVideoView.this.cbn();
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.onPrepared();
                }
                if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipb != null) {
                    QuickVideoView.this.ipe.wI(QuickVideoView.this.ipb.getPlayerType());
                }
                if (QuickVideoView.this.cRS != null) {
                    QuickVideoView.this.cRS.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipi != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipb != null) {
                        j = QuickVideoView.this.ipb.getDuration();
                    }
                    QuickVideoView.this.ipi.eg(j);
                    QuickVideoView.this.cbm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipi.cbe();
                        QuickVideoView.this.cbp();
                    }
                }
                if (QuickVideoView.this.ipx && (Ck = y.cbS().Ck(QuickVideoView.this.ipu)) > 0) {
                    if (QuickVideoView.this.ipb.isPlayerReuse()) {
                        if (QuickVideoView.this.ipb.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Ck);
                        }
                    } else {
                        QuickVideoView.this.ys(Ck);
                    }
                }
                if (QuickVideoView.this.iph) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ioZ != null && gVar != null) {
                    QuickVideoView.this.ioZ.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipk);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipa) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipa);
                }
                if (QuickVideoView.this.ipp != null && QuickVideoView.this.ipp.cco()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deO = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pP(true);
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.Ap(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ipe = null;
                }
                if (!QuickVideoView.this.deE || QuickVideoView.this.ipi == null) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.onCompletion();
                    }
                    QuickVideoView.this.iph = false;
                    y.cbS().remove(QuickVideoView.this.ipu);
                    if (QuickVideoView.this.cRR != null) {
                        QuickVideoView.this.cRR.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipg = null;
                QuickVideoView.this.ipv = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipi.caY());
                QuickVideoView.this.start();
            }
        };
        this.cRT = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ad(i2, i22, i3);
                QuickVideoView.this.cbn();
                if (QuickVideoView.this.ipi != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbq()) {
                    QuickVideoView.this.ipw = true;
                    y.cbS().bf(QuickVideoView.this.ipu, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.ipg = QuickVideoView.this.ipe.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipv, QuickVideoView.this.Z(QuickVideoView.this.ipe.bLY(), i3 + "", QuickVideoView.this.ipe.bLZ()));
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.ipv = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.yx(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.yy(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cIx == null || QuickVideoView.this.cIx.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.deR = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipw) {
                    QuickVideoView.this.ipw = false;
                    return;
                }
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.cbC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipi != null && z) {
                    QuickVideoView.this.ipi.onSeekComplete();
                }
                if (QuickVideoView.this.cRV != null) {
                    QuickVideoView.this.cRV.b(gVar);
                }
            }
        };
        this.cRU = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.ipc != null) {
                    QuickVideoView.this.ipc.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.ipk = i22;
                    if (QuickVideoView.this.ioZ != null && gVar != null) {
                        QuickVideoView.this.ioZ.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipk);
                    }
                }
                if (QuickVideoView.this.ipq != null) {
                    QuickVideoView.this.ipq.a(i2, i22, QuickVideoView.this.ipe);
                    return true;
                }
                return true;
            }
        };
        this.cRW = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.i(i2, i22, str);
                }
            }
        };
        this.cRX = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.ipe.Ar(str);
                }
            }
        };
        this.cRY = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipv = j;
                }
            }
        };
        this.ipP = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipi != null && QuickVideoView.this.ipi.cba() && QuickVideoView.this.ipi.cbb() && QuickVideoView.this.ipi.cbc() && QuickVideoView.this.ipb != null) {
                    int aAm = QuickVideoView.this.ipb.aAm();
                    int currentPosition = QuickVideoView.this.ipb.getCurrentPosition();
                    int duration = QuickVideoView.this.ipb.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipy;
                    boolean z = currentPosition + aAm < duration;
                    if (aAm < QuickVideoView.this.ipi.cbd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipy = currentTimeMillis;
                        QuickVideoView.this.ipi.yq(0);
                    }
                    if (QuickVideoView.this.cbo() && currentPosition == QuickVideoView.this.ipz && j > 500) {
                        QuickVideoView.this.ipy = currentTimeMillis;
                        QuickVideoView.this.ipi.yq(0);
                    }
                    QuickVideoView.this.ipz = currentPosition;
                    if (QuickVideoView.this.hYJ == QuickVideoView.ipD) {
                        QuickVideoView.this.cbp();
                    }
                }
            }
        };
        this.cSf = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.cbg();
                    }
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.ipe.Ao(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ipe = null;
                    }
                    QuickVideoView.this.cbn();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ioZ = new RenderView(context);
        this.bAG = new WeakReference<>(TbadkCoreApplication.getInst());
        this.ioZ.setSurfaceTextureListener(this.ipO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.ipo) {
            addView(this.ioZ, layoutParams);
        } else {
            addView(this.ioZ, 0, layoutParams);
        }
        if (deL != null) {
            this.ipb = deL.aAo();
        }
        if (this.ipb != null) {
            this.ipb.setOnPreparedListener(this.deN);
            this.ipb.setOnCompletionListener(this.deO);
            this.ipb.a(this.cRT);
            this.ipb.setOnSeekCompleteListener(this.deR);
            this.ipb.a(this.cRU);
            this.ipb.a(this.cRW);
            this.ipb.a(this.cRX);
            this.ipb.a(this.cRY);
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
        this.ipp = new com.baidu.tieba.play.b.a(this);
        this.ipq = new r();
        this.ipr = new com.baidu.tieba.play.b.f();
        al.k(this, R.color.cp_bg_line_k);
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.hI().ay("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.ipx = z;
    }

    public void setVideoPath(String str, String str2) {
        this.bVL = str2;
        if (this.ipp != null) {
            this.ipp.clear();
            this.ipp.cco();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Cp(str2);
            if (deM != null) {
                this.ipe = deM.X(this.bVL, str, "");
                if (this.ipe != null) {
                    this.ipe.a(-300, -44399, -44399, getLocateSource(), false, this.ipv, "");
                    this.ipe = null;
                }
            }
        }
        if (this.ipf != null) {
            this.ipf.a(null);
            this.ipf.bLM();
            this.ipf = null;
        }
        this.ipg = null;
        this.ipv = 0L;
        setVideoPath(str);
    }

    public void dR(String str, String str2) {
    }

    private String Cg(String str) {
        if (!ap.isEmpty(str) && com.baidu.tieba.video.g.cqQ().cqR()) {
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
            String Cg = Cg(str);
            this.ips = Cg;
            if (this.ipi != null) {
                Cg = this.ipi.rL(Cg);
                if (this.ipi.cbf() != null) {
                    this.ipi.cbf().setPlayer(this);
                }
                if (deM != null && pn(Cg)) {
                    this.ipf = deM.Au(Cg);
                }
                if (this.ipf != null) {
                    this.ipf.a(new com.baidu.tieba.play.monitor.a(this.bVL, this.ips, this.ipe));
                    this.ipf.bLL();
                }
                Ch(Cg);
            }
            if (!com.baidu.adp.lib.util.j.jS() && !pn(Cg)) {
                if (this.cIx != null) {
                    this.cIx.onError(this.ipb, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(Cg));
            if (this.ipe != null) {
                if (u(Uri.parse(Cg)) != null) {
                    this.ipe.bLS();
                }
                this.ipe.Fr();
                this.ipe = null;
            }
            this.ipt = str;
            int lastIndexOf = this.ipt.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.ipt.length() > 4) {
                this.ipu = this.ipt.substring(0, lastIndexOf + 4);
            } else {
                this.ipu = this.ipt;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbl() {
        if (com.baidu.tbadk.coreExtra.model.f.aoE()) {
            if (this.ipi != null && (this.ipi.caZ() || this.ipi.cba())) {
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipM);
                com.baidu.adp.lib.g.e.iB().postDelayed(this.ipM, com.baidu.tbadk.coreExtra.model.f.aoD());
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipN);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.ipN, com.baidu.tbadk.coreExtra.model.f.aoC());
        }
    }

    public void caA() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.ipe.An(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aAi();
        }
        this.mUri = uri;
        this.FO = map;
        if (this.ipn != null) {
            cbl();
            if (this.ipb != null) {
                if (!this.ipj) {
                    this.ipj = true;
                    this.ipb.a(this.mContext, this.mUri, this.FO, this.ipn, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.deN.onPrepared(this.ipb);
                }
            }
        } else if (this.ioZ != null && this.ioZ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.ipo) {
                addView(this.ioZ, layoutParams);
            } else {
                addView(this.ioZ, 0, layoutParams);
            }
        }
        al.k(this, R.color.cp_bg_line_k);
    }

    private void aAi() {
        this.ipj = false;
        this.iph = false;
        if (this.ipb != null) {
            if (this.ipb.isPlaying() && cbq()) {
                y.cbS().bf(this.ipu, this.ipb.getCurrentPosition());
            }
            this.ipb.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipP);
    }

    private void Ch(String str) {
        this.ipG = 0;
        this.ipH = 0;
        this.ipI = 0;
        this.ipJ = 0;
        this.ipK = 0;
        this.cWh = 0;
        if (this.ipi.cba()) {
            this.ipF = ipB;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.ipH = (int) u.Cj(QuickVideoView.this.ips);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.ips != null && this.ips.equals(str)) {
            this.ipF = ipA;
        } else {
            this.ipF = ipC;
        }
        this.hYJ = ipD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbm() {
        this.hYJ = ipD;
        if (this.ipb != null) {
            this.ipG = this.ipb.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(boolean z) {
        if (this.hYJ == ipD && this.ipb != null) {
            this.hYJ = ipE;
            this.ipJ = this.ipb.getDuration();
            if (z) {
                this.ipK = 0;
                this.ipI = this.ipJ;
            } else {
                this.ipI = this.ipb.getCurrentPosition();
                this.ipK = this.ipb.getCachedSize();
            }
            if (this.ipI > 0) {
                if (this.ipF == ipA) {
                    this.ipH = (int) u.Cj(this.ips);
                    if (this.ipG > 0) {
                        long j = (this.ipG * (this.ipI / 1000)) / 8;
                        if (this.ipK < 0) {
                            this.ipK = 0;
                        }
                        long j2 = this.ipK + j;
                        if (this.ipH > 0) {
                            j2 += this.ipH;
                        }
                        setFlowCount(j2, this.ipI, this.ipJ, this.cWh);
                    } else if (this.ipG == -1) {
                        this.ipG = 603327;
                        setFlowCount((this.ipG * (this.ipI / 1000)) / 8, this.ipI, this.ipJ, this.cWh);
                    }
                } else if (this.ipF == ipB) {
                    if (this.ipG > 0) {
                        long j3 = (this.ipG * (this.ipI / 1000)) / 8;
                        if (this.ipK < 0) {
                            this.ipK = 0;
                        }
                        long j4 = this.ipK + j3;
                        if (this.ipH > 0) {
                            j4 -= this.ipH;
                        }
                        setFlowCount(j4, this.ipI, this.ipJ, this.cWh);
                    } else if (this.ipG == -1) {
                        this.ipG = 603327;
                        setFlowCount((this.ipG * (this.ipI / 1000)) / 8, this.ipI, this.ipJ, this.cWh);
                    }
                } else {
                    setFlowCount(0L, this.ipI, this.ipJ, this.cWh);
                }
            }
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipP);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.bAG, false);
        }
        cbn();
        pP(false);
        if (this.ipp != null) {
            this.ipp.clear();
        }
        this.ipa = null;
        aAi();
        this.deE = false;
        if (this.ipi != null) {
            this.ipi.onStop();
        }
        com.baidu.tieba.play.a.b.cbV().a((b.InterfaceC0385b) null);
        if (this.ipe != null && this.ipe.Aq(getLocateSource())) {
            this.ipe = null;
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipP);
    }

    public void setFullScreenToDestroySurface() {
        this.ipL = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbn() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipM);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipN);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cRS = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cRR = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cIx = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0388g interfaceC0388g) {
        this.cRV = interfaceC0388g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.ipr == null) {
            return "";
        }
        String ccq = this.ipr.ccq();
        this.ipr.aa(str, str2, str3);
        return ccq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.ipi != null && !StringUtils.isNull(this.ipi.caY())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Co(uri);
                }
            }
            this.mUri = Uri.parse(this.ipi.caY());
        }
        boolean z = false;
        if (this.ipp != null) {
            z = this.ipp.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.ipe != null) {
            this.ipg = this.ipe.a(i, i2, i3, getLocateSource(), z, this.ipv, Z(this.ipe.bLY(), i3 + "", this.ipe.bLZ()));
            this.ipe = null;
        }
        this.ipv = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.ipb != null) {
            try {
                if (this.ipb.isPlaying() && cbq()) {
                    y.cbS().bf(this.ipu, this.ipb.getCurrentPosition());
                }
                this.ipb.release();
                this.ipa = str;
                URI uri = new URI(this.mUri.toString());
                this.ipb.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.FO, this.ipn, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.ipe.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ipb != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.ipb.isPlaying() && cbq()) {
                y.cbS().bf(this.ipu, this.ipb.getCurrentPosition());
            }
            this.ipb.release();
            this.ipb.a(this.mContext, this.mUri, this.FO, this.ipn, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.ipe.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ipb != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.ipb.forceUseSystemMediaPlayer(true);
            }
            if (this.ipb.isPlaying() && cbq()) {
                y.cbS().bf(this.ipu, this.ipb.getCurrentPosition());
            }
            this.ipb.release();
            this.ipb.a(this.mContext, this.mUri, this.FO, this.ipn, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.ipe.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.iph = true;
        if (this.ipb != null) {
            if (this.ipn != null && this.ipm && !this.ipb.isExistInRemote()) {
                this.ipb.a(this.mContext, this.mUri, this.FO, this.ipn, this.ipl);
                if (this.ioG != null) {
                    this.ioG.caX();
                }
                if (u(this.mUri) != null) {
                    this.ipe.bLU();
                }
                cbl();
                return;
            }
            if (!this.ipb.aAn()) {
                ad.a(this.bAG, true);
                this.ipb.setVolume(1.0f, 1.0f);
            }
            this.ipb.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.ipi != null) {
            this.ipi.onStart();
        }
        if (this.ipd != null) {
            this.ipd.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.ipb != null) {
            this.ipe.wJ(this.ipb.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cbn();
        ad.a(this.bAG, false);
        if (this.ipb != null) {
            if (this.ipb.isPlaying() && cbq()) {
                y.cbS().bf(this.ipu, this.ipb.getCurrentPosition());
            }
            this.ipb.pause();
        }
        if (this.ipi != null) {
            this.ipi.onPause();
        }
        this.iph = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ipe != null) {
            this.ipe.bLX();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.ipb != null) {
            return this.ipb.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.ipb != null) {
            return this.ipb.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cWh = i;
        ys(i);
    }

    public void ys(int i) {
        if (this.ipq != null) {
            this.ipq.cbB();
        }
        if (this.ipb != null) {
            this.ipb.seekTo(i);
        }
        if (this.ipi != null) {
            this.ipi.yq(0);
            cbp();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.ipb != null) {
            return this.ipb.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.ipb != null) {
            this.ipb.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.ipl = i;
    }

    public int getRecoveryState() {
        return this.ipl;
    }

    public void setNeedRecovery(boolean z) {
        this.ipm = z;
    }

    public void setLooping(boolean z) {
        this.deE = z;
    }

    public boolean cbo() {
        return this.iph;
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
        this.cIB = bVar;
    }

    public void setBusiness(d dVar) {
        this.ipi = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cSf);
    }

    public void setMute(boolean z) {
        if (z) {
            this.ipb.setVolume(0.0f, 0.0f);
            ad.a(this.bAG, false);
            return;
        }
        ad.a(this.bAG, true);
        this.ipb.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.deE = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ipb != null) {
            this.ipb.avm();
        }
        if (this.ipq != null) {
            this.ipq.cbD();
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipP);
        MessageManager.getInstance().unRegisterListener(this.cSf);
        if (this.ipp != null) {
            this.ipp.clear();
        }
        if (this.ipf != null) {
            this.ipf.a(null);
            this.ipf.bLM();
        }
    }

    public g getPlayer() {
        return this.ipb;
    }

    public int getPlayerType() {
        if (this.ipb == null) {
            return -300;
        }
        return this.ipb.getPlayerType();
    }

    public void cbp() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipP);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.ipP, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.ioG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.ipi instanceof n) || ((n) this.ipi).cbz() == null) ? "" : ((n) this.ipi).cbz().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i u(Uri uri) {
        String uri2;
        if (this.ipe != null) {
            return this.ipe;
        }
        if (!StringUtils.isNull(this.ips)) {
            uri2 = this.ips;
        } else if (deM != null && this.ipi != null && !StringUtils.isNull(this.ipi.caY())) {
            uri2 = this.ipi.caY();
        } else {
            uri2 = (deM == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && deM != null) {
            this.ipe = deM.X(this.bVL, uri2, this.ipg);
        }
        this.ipg = null;
        this.ipv = 0L;
        return this.ipe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbq() {
        return this.ipb != null && this.ipb.getDuration() >= this.ipb.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.ipe, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.ipe, j);
    }

    public static boolean pn(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.ipc = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.ipb != null) {
            return this.ipb.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.ipb != null ? this.ipb.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.ipe != null) {
            this.ipe.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.ipd = cVar;
    }
}
