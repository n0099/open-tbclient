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
    private static h deN;
    private static com.baidu.tieba.j.l deO;
    private static int ipE = 0;
    private static int ipF = 1;
    private static int ipG = 2;
    private static int ipH = 1;
    private static int ipI = 0;
    private Map<String, String> FN;
    private WeakReference<Context> bAG;
    private String bVM;
    private b cIC;
    private g.b cIy;
    private g.a cRT;
    private g.f cRU;
    private g.c cRV;
    private g.e cRW;
    private g.InterfaceC0388g cRX;
    private g.i cRY;
    private g.d cRZ;
    private g.h cSa;
    private final CustomMessageListener cSh;
    private int cWj;
    private boolean deG;
    private g.f deP;
    private g.a deQ;
    private g.InterfaceC0388g deT;
    private int hYN;
    private a ioK;
    private boolean ipA;
    private boolean ipB;
    private long ipC;
    private long ipD;
    private int ipJ;
    private int ipK;
    private int ipL;
    private int ipM;
    private int ipN;
    private int ipO;
    private boolean ipP;
    private Runnable ipQ;
    private Runnable ipR;
    private TextureView.SurfaceTextureListener ipS;
    private Runnable ipT;
    private RenderView ipd;
    private String ipe;
    private g ipf;
    private g.e ipg;
    private c iph;
    private com.baidu.tieba.j.i ipi;
    private com.baidu.tieba.j.e ipj;
    private String ipk;
    private boolean ipl;
    private d ipm;
    private boolean ipn;
    private int ipo;
    private int ipp;
    private boolean ipq;
    private SurfaceTexture ipr;
    private boolean ips;
    private com.baidu.tieba.play.b.a ipt;
    private r ipu;
    private com.baidu.tieba.play.b.f ipv;
    private String ipw;
    private String ipx;
    private String ipy;
    private long ipz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cbb();
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
            deN = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            deO = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.ips = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.ipl = false;
        this.ipn = false;
        this.ipo = 0;
        this.deG = false;
        this.ipp = -1;
        this.ipq = false;
        this.ipr = null;
        this.ips = true;
        this.ipC = 0L;
        this.ipD = 0L;
        this.hYN = ipI;
        this.ipJ = 0;
        this.ipK = 0;
        this.ipL = -1;
        this.ipM = 0;
        this.ipN = 0;
        this.ipO = 0;
        this.cWj = 0;
        this.ipP = false;
        this.bAG = null;
        this.ipQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipf != null && QuickVideoView.this.ipl) {
                    QuickVideoView.this.b(QuickVideoView.this.ipf, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipR = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.nj(false);
                }
            }
        };
        this.ipS = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ipP) {
                    QuickVideoView.this.ipP = false;
                    QuickVideoView.this.ipf.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipn || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipf != null && QuickVideoView.this.ipq) {
                        QuickVideoView.this.ipf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FN, surfaceTexture, QuickVideoView.this.ipp);
                        if (QuickVideoView.this.ioK != null) {
                            QuickVideoView.this.ioK.cbb();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ipi.bLY();
                        }
                    }
                } else if (cbw()) {
                    if (QuickVideoView.this.ipf != null) {
                        QuickVideoView.this.cbp();
                        QuickVideoView.this.ipn = true;
                        QuickVideoView.this.ipf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FN, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ipi.bLX();
                    }
                }
                QuickVideoView.this.ipr = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipP) {
                    QuickVideoView.this.cbr();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.ipf != null) {
                        if (QuickVideoView.this.ipf.isPlaying() && QuickVideoView.this.cbu()) {
                            y.cbW().bf(QuickVideoView.this.ipy, QuickVideoView.this.ipf.getCurrentPosition());
                        }
                        QuickVideoView.this.ipf.release();
                    }
                    if (QuickVideoView.this.ipn) {
                        if (QuickVideoView.this.ipm != null) {
                            QuickVideoView.this.ipm.onStop();
                        }
                        if (QuickVideoView.this.cIC != null) {
                            QuickVideoView.this.cIC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipr = null;
                    if (QuickVideoView.this.ipi != null && QuickVideoView.this.ipi.As(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.ipn = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbw() {
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
        this.deP = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Cm;
                QuickVideoView.this.cbr();
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.onPrepared();
                }
                if (QuickVideoView.this.ipi != null && QuickVideoView.this.ipf != null) {
                    QuickVideoView.this.ipi.wI(QuickVideoView.this.ipf.getPlayerType());
                }
                if (QuickVideoView.this.cRU != null) {
                    QuickVideoView.this.cRU.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipm != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipf != null) {
                        j = QuickVideoView.this.ipf.getDuration();
                    }
                    QuickVideoView.this.ipm.eg(j);
                    QuickVideoView.this.cbq();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipm.cbi();
                        QuickVideoView.this.cbt();
                    }
                }
                if (QuickVideoView.this.ipB && (Cm = y.cbW().Cm(QuickVideoView.this.ipy)) > 0) {
                    if (QuickVideoView.this.ipf.isPlayerReuse()) {
                        if (QuickVideoView.this.ipf.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Cm);
                        }
                    } else {
                        QuickVideoView.this.ys(Cm);
                    }
                }
                if (QuickVideoView.this.ipl) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ipd != null && gVar != null) {
                    QuickVideoView.this.ipd.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipo);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipe) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipe);
                }
                if (QuickVideoView.this.ipt != null && QuickVideoView.this.ipt.ccs()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deQ = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.Ar(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ipi = null;
                }
                if (!QuickVideoView.this.deG || QuickVideoView.this.ipm == null) {
                    if (QuickVideoView.this.ipm != null) {
                        QuickVideoView.this.ipm.onCompletion();
                    }
                    QuickVideoView.this.ipl = false;
                    y.cbW().remove(QuickVideoView.this.ipy);
                    if (QuickVideoView.this.cRT != null) {
                        QuickVideoView.this.cRT.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipk = null;
                QuickVideoView.this.ipz = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipm.cbc());
                QuickVideoView.this.start();
            }
        };
        this.cRV = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ad(i, i2, i3);
                QuickVideoView.this.cbr();
                if (QuickVideoView.this.ipm != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbu()) {
                    QuickVideoView.this.ipA = true;
                    y.cbW().bf(QuickVideoView.this.ipy, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipk = QuickVideoView.this.ipi.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipz, QuickVideoView.this.Z(QuickVideoView.this.ipi.bMc(), i3 + "", QuickVideoView.this.ipi.bMd()));
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.ipz = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.yx(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.yy(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cIy == null || QuickVideoView.this.cIy.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.deT = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipA) {
                    QuickVideoView.this.ipA = false;
                    return;
                }
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.cbG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipm != null && z) {
                    QuickVideoView.this.ipm.onSeekComplete();
                }
                if (QuickVideoView.this.cRX != null) {
                    QuickVideoView.this.cRX.b(gVar);
                }
            }
        };
        this.cRW = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ipg != null) {
                    QuickVideoView.this.ipg.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ipo = i2;
                    if (QuickVideoView.this.ipd != null && gVar != null) {
                        QuickVideoView.this.ipd.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipo);
                    }
                }
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.a(i, i2, QuickVideoView.this.ipi);
                    return true;
                }
                return true;
            }
        };
        this.cRY = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.i(i, i2, str);
                }
            }
        };
        this.cRZ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.At(str);
                }
            }
        };
        this.cSa = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipz = j;
                }
            }
        };
        this.ipT = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipm != null && QuickVideoView.this.ipm.cbe() && QuickVideoView.this.ipm.cbf() && QuickVideoView.this.ipm.cbg() && QuickVideoView.this.ipf != null) {
                    int aAp = QuickVideoView.this.ipf.aAp();
                    int currentPosition = QuickVideoView.this.ipf.getCurrentPosition();
                    int duration = QuickVideoView.this.ipf.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipC;
                    boolean z = currentPosition + aAp < duration;
                    if (aAp < QuickVideoView.this.ipm.cbh() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipC = currentTimeMillis;
                        QuickVideoView.this.ipm.yq(0);
                    }
                    if (QuickVideoView.this.cbs() && currentPosition == QuickVideoView.this.ipD && j > 500) {
                        QuickVideoView.this.ipC = currentTimeMillis;
                        QuickVideoView.this.ipm.yq(0);
                    }
                    QuickVideoView.this.ipD = currentPosition;
                    if (QuickVideoView.this.hYN == QuickVideoView.ipH) {
                        QuickVideoView.this.cbt();
                    }
                }
            }
        };
        this.cSh = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipm != null) {
                        QuickVideoView.this.ipm.cbk();
                    }
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.Aq(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.cbr();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ipl = false;
        this.ipn = false;
        this.ipo = 0;
        this.deG = false;
        this.ipp = -1;
        this.ipq = false;
        this.ipr = null;
        this.ips = true;
        this.ipC = 0L;
        this.ipD = 0L;
        this.hYN = ipI;
        this.ipJ = 0;
        this.ipK = 0;
        this.ipL = -1;
        this.ipM = 0;
        this.ipN = 0;
        this.ipO = 0;
        this.cWj = 0;
        this.ipP = false;
        this.bAG = null;
        this.ipQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipf != null && QuickVideoView.this.ipl) {
                    QuickVideoView.this.b(QuickVideoView.this.ipf, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipR = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.nj(false);
                }
            }
        };
        this.ipS = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ipP) {
                    QuickVideoView.this.ipP = false;
                    QuickVideoView.this.ipf.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipn || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipf != null && QuickVideoView.this.ipq) {
                        QuickVideoView.this.ipf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FN, surfaceTexture, QuickVideoView.this.ipp);
                        if (QuickVideoView.this.ioK != null) {
                            QuickVideoView.this.ioK.cbb();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ipi.bLY();
                        }
                    }
                } else if (cbw()) {
                    if (QuickVideoView.this.ipf != null) {
                        QuickVideoView.this.cbp();
                        QuickVideoView.this.ipn = true;
                        QuickVideoView.this.ipf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FN, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ipi.bLX();
                    }
                }
                QuickVideoView.this.ipr = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipP) {
                    QuickVideoView.this.cbr();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.ipf != null) {
                        if (QuickVideoView.this.ipf.isPlaying() && QuickVideoView.this.cbu()) {
                            y.cbW().bf(QuickVideoView.this.ipy, QuickVideoView.this.ipf.getCurrentPosition());
                        }
                        QuickVideoView.this.ipf.release();
                    }
                    if (QuickVideoView.this.ipn) {
                        if (QuickVideoView.this.ipm != null) {
                            QuickVideoView.this.ipm.onStop();
                        }
                        if (QuickVideoView.this.cIC != null) {
                            QuickVideoView.this.cIC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipr = null;
                    if (QuickVideoView.this.ipi != null && QuickVideoView.this.ipi.As(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.ipn = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbw() {
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
        this.deP = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Cm;
                QuickVideoView.this.cbr();
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.onPrepared();
                }
                if (QuickVideoView.this.ipi != null && QuickVideoView.this.ipf != null) {
                    QuickVideoView.this.ipi.wI(QuickVideoView.this.ipf.getPlayerType());
                }
                if (QuickVideoView.this.cRU != null) {
                    QuickVideoView.this.cRU.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipm != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipf != null) {
                        j = QuickVideoView.this.ipf.getDuration();
                    }
                    QuickVideoView.this.ipm.eg(j);
                    QuickVideoView.this.cbq();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipm.cbi();
                        QuickVideoView.this.cbt();
                    }
                }
                if (QuickVideoView.this.ipB && (Cm = y.cbW().Cm(QuickVideoView.this.ipy)) > 0) {
                    if (QuickVideoView.this.ipf.isPlayerReuse()) {
                        if (QuickVideoView.this.ipf.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Cm);
                        }
                    } else {
                        QuickVideoView.this.ys(Cm);
                    }
                }
                if (QuickVideoView.this.ipl) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ipd != null && gVar != null) {
                    QuickVideoView.this.ipd.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipo);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipe) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipe);
                }
                if (QuickVideoView.this.ipt != null && QuickVideoView.this.ipt.ccs()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deQ = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.Ar(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ipi = null;
                }
                if (!QuickVideoView.this.deG || QuickVideoView.this.ipm == null) {
                    if (QuickVideoView.this.ipm != null) {
                        QuickVideoView.this.ipm.onCompletion();
                    }
                    QuickVideoView.this.ipl = false;
                    y.cbW().remove(QuickVideoView.this.ipy);
                    if (QuickVideoView.this.cRT != null) {
                        QuickVideoView.this.cRT.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipk = null;
                QuickVideoView.this.ipz = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipm.cbc());
                QuickVideoView.this.start();
            }
        };
        this.cRV = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ad(i, i2, i3);
                QuickVideoView.this.cbr();
                if (QuickVideoView.this.ipm != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbu()) {
                    QuickVideoView.this.ipA = true;
                    y.cbW().bf(QuickVideoView.this.ipy, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipk = QuickVideoView.this.ipi.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipz, QuickVideoView.this.Z(QuickVideoView.this.ipi.bMc(), i3 + "", QuickVideoView.this.ipi.bMd()));
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.ipz = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.yx(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.yy(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cIy == null || QuickVideoView.this.cIy.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.deT = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipA) {
                    QuickVideoView.this.ipA = false;
                    return;
                }
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.cbG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipm != null && z) {
                    QuickVideoView.this.ipm.onSeekComplete();
                }
                if (QuickVideoView.this.cRX != null) {
                    QuickVideoView.this.cRX.b(gVar);
                }
            }
        };
        this.cRW = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ipg != null) {
                    QuickVideoView.this.ipg.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ipo = i2;
                    if (QuickVideoView.this.ipd != null && gVar != null) {
                        QuickVideoView.this.ipd.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipo);
                    }
                }
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.a(i, i2, QuickVideoView.this.ipi);
                    return true;
                }
                return true;
            }
        };
        this.cRY = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.i(i, i2, str);
                }
            }
        };
        this.cRZ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.At(str);
                }
            }
        };
        this.cSa = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipz = j;
                }
            }
        };
        this.ipT = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipm != null && QuickVideoView.this.ipm.cbe() && QuickVideoView.this.ipm.cbf() && QuickVideoView.this.ipm.cbg() && QuickVideoView.this.ipf != null) {
                    int aAp = QuickVideoView.this.ipf.aAp();
                    int currentPosition = QuickVideoView.this.ipf.getCurrentPosition();
                    int duration = QuickVideoView.this.ipf.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipC;
                    boolean z = currentPosition + aAp < duration;
                    if (aAp < QuickVideoView.this.ipm.cbh() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipC = currentTimeMillis;
                        QuickVideoView.this.ipm.yq(0);
                    }
                    if (QuickVideoView.this.cbs() && currentPosition == QuickVideoView.this.ipD && j > 500) {
                        QuickVideoView.this.ipC = currentTimeMillis;
                        QuickVideoView.this.ipm.yq(0);
                    }
                    QuickVideoView.this.ipD = currentPosition;
                    if (QuickVideoView.this.hYN == QuickVideoView.ipH) {
                        QuickVideoView.this.cbt();
                    }
                }
            }
        };
        this.cSh = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipm != null) {
                        QuickVideoView.this.ipm.cbk();
                    }
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.Aq(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.cbr();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ipl = false;
        this.ipn = false;
        this.ipo = 0;
        this.deG = false;
        this.ipp = -1;
        this.ipq = false;
        this.ipr = null;
        this.ips = true;
        this.ipC = 0L;
        this.ipD = 0L;
        this.hYN = ipI;
        this.ipJ = 0;
        this.ipK = 0;
        this.ipL = -1;
        this.ipM = 0;
        this.ipN = 0;
        this.ipO = 0;
        this.cWj = 0;
        this.ipP = false;
        this.bAG = null;
        this.ipQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipf != null && QuickVideoView.this.ipl) {
                    QuickVideoView.this.b(QuickVideoView.this.ipf, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipR = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.nj(false);
                }
            }
        };
        this.ipS = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.ipP) {
                    QuickVideoView.this.ipP = false;
                    QuickVideoView.this.ipf.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipn || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipf != null && QuickVideoView.this.ipq) {
                        QuickVideoView.this.ipf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FN, surfaceTexture, QuickVideoView.this.ipp);
                        if (QuickVideoView.this.ioK != null) {
                            QuickVideoView.this.ioK.cbb();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ipi.bLY();
                        }
                    }
                } else if (cbw()) {
                    if (QuickVideoView.this.ipf != null) {
                        QuickVideoView.this.cbp();
                        QuickVideoView.this.ipn = true;
                        QuickVideoView.this.ipf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FN, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ipi.bLX();
                    }
                }
                QuickVideoView.this.ipr = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipP) {
                    QuickVideoView.this.cbr();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.ipf != null) {
                        if (QuickVideoView.this.ipf.isPlaying() && QuickVideoView.this.cbu()) {
                            y.cbW().bf(QuickVideoView.this.ipy, QuickVideoView.this.ipf.getCurrentPosition());
                        }
                        QuickVideoView.this.ipf.release();
                    }
                    if (QuickVideoView.this.ipn) {
                        if (QuickVideoView.this.ipm != null) {
                            QuickVideoView.this.ipm.onStop();
                        }
                        if (QuickVideoView.this.cIC != null) {
                            QuickVideoView.this.cIC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipr = null;
                    if (QuickVideoView.this.ipi != null && QuickVideoView.this.ipi.As(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.ipn = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbw() {
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
        this.deP = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Cm;
                QuickVideoView.this.cbr();
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.onPrepared();
                }
                if (QuickVideoView.this.ipi != null && QuickVideoView.this.ipf != null) {
                    QuickVideoView.this.ipi.wI(QuickVideoView.this.ipf.getPlayerType());
                }
                if (QuickVideoView.this.cRU != null) {
                    QuickVideoView.this.cRU.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipm != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipf != null) {
                        j = QuickVideoView.this.ipf.getDuration();
                    }
                    QuickVideoView.this.ipm.eg(j);
                    QuickVideoView.this.cbq();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipm.cbi();
                        QuickVideoView.this.cbt();
                    }
                }
                if (QuickVideoView.this.ipB && (Cm = y.cbW().Cm(QuickVideoView.this.ipy)) > 0) {
                    if (QuickVideoView.this.ipf.isPlayerReuse()) {
                        if (QuickVideoView.this.ipf.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Cm);
                        }
                    } else {
                        QuickVideoView.this.ys(Cm);
                    }
                }
                if (QuickVideoView.this.ipl) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ipd != null && gVar != null) {
                    QuickVideoView.this.ipd.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipo);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipe) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipe);
                }
                if (QuickVideoView.this.ipt != null && QuickVideoView.this.ipt.ccs()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deQ = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.Ar(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ipi = null;
                }
                if (!QuickVideoView.this.deG || QuickVideoView.this.ipm == null) {
                    if (QuickVideoView.this.ipm != null) {
                        QuickVideoView.this.ipm.onCompletion();
                    }
                    QuickVideoView.this.ipl = false;
                    y.cbW().remove(QuickVideoView.this.ipy);
                    if (QuickVideoView.this.cRT != null) {
                        QuickVideoView.this.cRT.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipk = null;
                QuickVideoView.this.ipz = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipm.cbc());
                QuickVideoView.this.start();
            }
        };
        this.cRV = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ad(i2, i22, i3);
                QuickVideoView.this.cbr();
                if (QuickVideoView.this.ipm != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbu()) {
                    QuickVideoView.this.ipA = true;
                    y.cbW().bf(QuickVideoView.this.ipy, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipk = QuickVideoView.this.ipi.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipz, QuickVideoView.this.Z(QuickVideoView.this.ipi.bMc(), i3 + "", QuickVideoView.this.ipi.bMd()));
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.ipz = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.yx(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.yy(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cIy == null || QuickVideoView.this.cIy.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.deT = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipA) {
                    QuickVideoView.this.ipA = false;
                    return;
                }
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.cbG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipm != null && z) {
                    QuickVideoView.this.ipm.onSeekComplete();
                }
                if (QuickVideoView.this.cRX != null) {
                    QuickVideoView.this.cRX.b(gVar);
                }
            }
        };
        this.cRW = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.ipg != null) {
                    QuickVideoView.this.ipg.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.ipo = i22;
                    if (QuickVideoView.this.ipd != null && gVar != null) {
                        QuickVideoView.this.ipd.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipo);
                    }
                }
                if (QuickVideoView.this.ipu != null) {
                    QuickVideoView.this.ipu.a(i2, i22, QuickVideoView.this.ipi);
                    return true;
                }
                return true;
            }
        };
        this.cRY = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.i(i2, i22, str);
                }
            }
        };
        this.cRZ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ipi != null) {
                    QuickVideoView.this.ipi.At(str);
                }
            }
        };
        this.cSa = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipz = j;
                }
            }
        };
        this.ipT = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipm != null && QuickVideoView.this.ipm.cbe() && QuickVideoView.this.ipm.cbf() && QuickVideoView.this.ipm.cbg() && QuickVideoView.this.ipf != null) {
                    int aAp = QuickVideoView.this.ipf.aAp();
                    int currentPosition = QuickVideoView.this.ipf.getCurrentPosition();
                    int duration = QuickVideoView.this.ipf.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipC;
                    boolean z = currentPosition + aAp < duration;
                    if (aAp < QuickVideoView.this.ipm.cbh() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipC = currentTimeMillis;
                        QuickVideoView.this.ipm.yq(0);
                    }
                    if (QuickVideoView.this.cbs() && currentPosition == QuickVideoView.this.ipD && j > 500) {
                        QuickVideoView.this.ipC = currentTimeMillis;
                        QuickVideoView.this.ipm.yq(0);
                    }
                    QuickVideoView.this.ipD = currentPosition;
                    if (QuickVideoView.this.hYN == QuickVideoView.ipH) {
                        QuickVideoView.this.cbt();
                    }
                }
            }
        };
        this.cSh = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipm != null) {
                        QuickVideoView.this.ipm.cbk();
                    }
                    if (QuickVideoView.this.ipi != null) {
                        QuickVideoView.this.ipi.Aq(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ipi = null;
                    }
                    QuickVideoView.this.cbr();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ipd = new RenderView(context);
        this.bAG = new WeakReference<>(TbadkCoreApplication.getInst());
        this.ipd.setSurfaceTextureListener(this.ipS);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.ips) {
            addView(this.ipd, layoutParams);
        } else {
            addView(this.ipd, 0, layoutParams);
        }
        if (deN != null) {
            this.ipf = deN.aAr();
        }
        if (this.ipf != null) {
            this.ipf.setOnPreparedListener(this.deP);
            this.ipf.setOnCompletionListener(this.deQ);
            this.ipf.a(this.cRV);
            this.ipf.setOnSeekCompleteListener(this.deT);
            this.ipf.a(this.cRW);
            this.ipf.a(this.cRY);
            this.ipf.a(this.cRZ);
            this.ipf.a(this.cSa);
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
        this.ipt = new com.baidu.tieba.play.b.a(this);
        this.ipu = new r();
        this.ipv = new com.baidu.tieba.play.b.f();
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
        this.ipB = z;
    }

    public void setVideoPath(String str, String str2) {
        this.bVM = str2;
        if (this.ipt != null) {
            this.ipt.clear();
            this.ipt.ccs();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Cr(str2);
            if (deO != null) {
                this.ipi = deO.X(this.bVM, str, "");
                if (this.ipi != null) {
                    this.ipi.a(-300, -44399, -44399, getLocateSource(), false, this.ipz, "");
                    this.ipi = null;
                }
            }
        }
        if (this.ipj != null) {
            this.ipj.a(null);
            this.ipj.bLQ();
            this.ipj = null;
        }
        this.ipk = null;
        this.ipz = 0L;
        setVideoPath(str);
    }

    public void dR(String str, String str2) {
    }

    private String Ci(String str) {
        if (!ap.isEmpty(str) && com.baidu.tieba.video.g.cqT().cqU()) {
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
            String Ci = Ci(str);
            this.ipw = Ci;
            if (this.ipm != null) {
                Ci = this.ipm.rK(Ci);
                if (this.ipm.cbj() != null) {
                    this.ipm.cbj().setPlayer(this);
                }
                if (deO != null && pm(Ci)) {
                    this.ipj = deO.Aw(Ci);
                }
                if (this.ipj != null) {
                    this.ipj.a(new com.baidu.tieba.play.monitor.a(this.bVM, this.ipw, this.ipi));
                    this.ipj.bLP();
                }
                Cj(Ci);
            }
            if (!com.baidu.adp.lib.util.j.jS() && !pm(Ci)) {
                if (this.cIy != null) {
                    this.cIy.onError(this.ipf, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(Ci));
            if (this.ipi != null) {
                if (u(Uri.parse(Ci)) != null) {
                    this.ipi.bLW();
                }
                this.ipi.Fr();
                this.ipi = null;
            }
            this.ipx = str;
            int lastIndexOf = this.ipx.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.ipx.length() > 4) {
                this.ipy = this.ipx.substring(0, lastIndexOf + 4);
            } else {
                this.ipy = this.ipx;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbp() {
        if (com.baidu.tbadk.coreExtra.model.f.aoE()) {
            if (this.ipm != null && (this.ipm.cbd() || this.ipm.cbe())) {
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipQ);
                com.baidu.adp.lib.g.e.iB().postDelayed(this.ipQ, com.baidu.tbadk.coreExtra.model.f.aoD());
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipR);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.ipR, com.baidu.tbadk.coreExtra.model.f.aoC());
        }
    }

    public void caE() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.ipi.Ap(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aAl();
        }
        this.mUri = uri;
        this.FN = map;
        if (this.ipr != null) {
            cbp();
            if (this.ipf != null) {
                if (!this.ipn) {
                    this.ipn = true;
                    this.ipf.a(this.mContext, this.mUri, this.FN, this.ipr, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.deP.onPrepared(this.ipf);
                }
            }
        } else if (this.ipd != null && this.ipd.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.ips) {
                addView(this.ipd, layoutParams);
            } else {
                addView(this.ipd, 0, layoutParams);
            }
        }
        al.k(this, R.color.cp_bg_line_k);
    }

    private void aAl() {
        this.ipn = false;
        this.ipl = false;
        if (this.ipf != null) {
            if (this.ipf.isPlaying() && cbu()) {
                y.cbW().bf(this.ipy, this.ipf.getCurrentPosition());
            }
            this.ipf.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipT);
    }

    private void Cj(String str) {
        this.ipK = 0;
        this.ipL = 0;
        this.ipM = 0;
        this.ipN = 0;
        this.ipO = 0;
        this.cWj = 0;
        if (this.ipm.cbe()) {
            this.ipJ = ipF;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.ipL = (int) u.Cl(QuickVideoView.this.ipw);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.ipw != null && this.ipw.equals(str)) {
            this.ipJ = ipE;
        } else {
            this.ipJ = ipG;
        }
        this.hYN = ipH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbq() {
        this.hYN = ipH;
        if (this.ipf != null) {
            this.ipK = this.ipf.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        if (this.hYN == ipH && this.ipf != null) {
            this.hYN = ipI;
            this.ipN = this.ipf.getDuration();
            if (z) {
                this.ipO = 0;
                this.ipM = this.ipN;
            } else {
                this.ipM = this.ipf.getCurrentPosition();
                this.ipO = this.ipf.getCachedSize();
            }
            if (this.ipM > 0) {
                if (this.ipJ == ipE) {
                    this.ipL = (int) u.Cl(this.ipw);
                    if (this.ipK > 0) {
                        long j = (this.ipK * (this.ipM / 1000)) / 8;
                        if (this.ipO < 0) {
                            this.ipO = 0;
                        }
                        long j2 = this.ipO + j;
                        if (this.ipL > 0) {
                            j2 += this.ipL;
                        }
                        setFlowCount(j2, this.ipM, this.ipN, this.cWj);
                    } else if (this.ipK == -1) {
                        this.ipK = 603327;
                        setFlowCount((this.ipK * (this.ipM / 1000)) / 8, this.ipM, this.ipN, this.cWj);
                    }
                } else if (this.ipJ == ipF) {
                    if (this.ipK > 0) {
                        long j3 = (this.ipK * (this.ipM / 1000)) / 8;
                        if (this.ipO < 0) {
                            this.ipO = 0;
                        }
                        long j4 = this.ipO + j3;
                        if (this.ipL > 0) {
                            j4 -= this.ipL;
                        }
                        setFlowCount(j4, this.ipM, this.ipN, this.cWj);
                    } else if (this.ipK == -1) {
                        this.ipK = 603327;
                        setFlowCount((this.ipK * (this.ipM / 1000)) / 8, this.ipM, this.ipN, this.cWj);
                    }
                } else {
                    setFlowCount(0L, this.ipM, this.ipN, this.cWj);
                }
            }
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipT);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.bAG, false);
        }
        cbr();
        pQ(false);
        if (this.ipt != null) {
            this.ipt.clear();
        }
        this.ipe = null;
        aAl();
        this.deG = false;
        if (this.ipm != null) {
            this.ipm.onStop();
        }
        com.baidu.tieba.play.a.b.cbZ().a((b.InterfaceC0385b) null);
        if (this.ipi != null && this.ipi.As(getLocateSource())) {
            this.ipi = null;
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipT);
    }

    public void setFullScreenToDestroySurface() {
        this.ipP = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbr() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipQ);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipR);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cRU = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cRT = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cIy = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0388g interfaceC0388g) {
        this.cRX = interfaceC0388g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.ipv == null) {
            return "";
        }
        String ccu = this.ipv.ccu();
        this.ipv.aa(str, str2, str3);
        return ccu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.ipm != null && !StringUtils.isNull(this.ipm.cbc())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Cq(uri);
                }
            }
            this.mUri = Uri.parse(this.ipm.cbc());
        }
        boolean z = false;
        if (this.ipt != null) {
            z = this.ipt.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.ipi != null) {
            this.ipk = this.ipi.a(i, i2, i3, getLocateSource(), z, this.ipz, Z(this.ipi.bMc(), i3 + "", this.ipi.bMd()));
            this.ipi = null;
        }
        this.ipz = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.ipf != null) {
            try {
                if (this.ipf.isPlaying() && cbu()) {
                    y.cbW().bf(this.ipy, this.ipf.getCurrentPosition());
                }
                this.ipf.release();
                this.ipe = str;
                URI uri = new URI(this.mUri.toString());
                this.ipf.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.FN, this.ipr, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.ipi.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ipf != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.ipf.isPlaying() && cbu()) {
                y.cbW().bf(this.ipy, this.ipf.getCurrentPosition());
            }
            this.ipf.release();
            this.ipf.a(this.mContext, this.mUri, this.FN, this.ipr, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.ipi.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ipf != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.ipf.forceUseSystemMediaPlayer(true);
            }
            if (this.ipf.isPlaying() && cbu()) {
                y.cbW().bf(this.ipy, this.ipf.getCurrentPosition());
            }
            this.ipf.release();
            this.ipf.a(this.mContext, this.mUri, this.FN, this.ipr, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.ipi.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.ipl = true;
        if (this.ipf != null) {
            if (this.ipr != null && this.ipq && !this.ipf.isExistInRemote()) {
                this.ipf.a(this.mContext, this.mUri, this.FN, this.ipr, this.ipp);
                if (this.ioK != null) {
                    this.ioK.cbb();
                }
                if (u(this.mUri) != null) {
                    this.ipi.bLY();
                }
                cbp();
                return;
            }
            if (!this.ipf.aAq()) {
                ad.a(this.bAG, true);
                this.ipf.setVolume(1.0f, 1.0f);
            }
            this.ipf.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.ipm != null) {
            this.ipm.onStart();
        }
        if (this.iph != null) {
            this.iph.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.ipf != null) {
            this.ipi.wJ(this.ipf.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cbr();
        ad.a(this.bAG, false);
        if (this.ipf != null) {
            if (this.ipf.isPlaying() && cbu()) {
                y.cbW().bf(this.ipy, this.ipf.getCurrentPosition());
            }
            this.ipf.pause();
        }
        if (this.ipm != null) {
            this.ipm.onPause();
        }
        this.ipl = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ipi != null) {
            this.ipi.bMb();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.ipf != null) {
            return this.ipf.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.ipf != null) {
            return this.ipf.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cWj = i;
        ys(i);
    }

    public void ys(int i) {
        if (this.ipu != null) {
            this.ipu.cbF();
        }
        if (this.ipf != null) {
            this.ipf.seekTo(i);
        }
        if (this.ipm != null) {
            this.ipm.yq(0);
            cbt();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.ipf != null) {
            return this.ipf.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.ipf != null) {
            this.ipf.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.ipp = i;
    }

    public int getRecoveryState() {
        return this.ipp;
    }

    public void setNeedRecovery(boolean z) {
        this.ipq = z;
    }

    public void setLooping(boolean z) {
        this.deG = z;
    }

    public boolean cbs() {
        return this.ipl;
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
        this.cIC = bVar;
    }

    public void setBusiness(d dVar) {
        this.ipm = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cSh);
    }

    public void setMute(boolean z) {
        if (z) {
            this.ipf.setVolume(0.0f, 0.0f);
            ad.a(this.bAG, false);
            return;
        }
        ad.a(this.bAG, true);
        this.ipf.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.deG = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ipf != null) {
            this.ipf.avm();
        }
        if (this.ipu != null) {
            this.ipu.cbH();
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipT);
        MessageManager.getInstance().unRegisterListener(this.cSh);
        if (this.ipt != null) {
            this.ipt.clear();
        }
        if (this.ipj != null) {
            this.ipj.a(null);
            this.ipj.bLQ();
        }
    }

    public g getPlayer() {
        return this.ipf;
    }

    public int getPlayerType() {
        if (this.ipf == null) {
            return -300;
        }
        return this.ipf.getPlayerType();
    }

    public void cbt() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipT);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.ipT, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.ioK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.ipm instanceof n) || ((n) this.ipm).cbD() == null) ? "" : ((n) this.ipm).cbD().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i u(Uri uri) {
        String uri2;
        if (this.ipi != null) {
            return this.ipi;
        }
        if (!StringUtils.isNull(this.ipw)) {
            uri2 = this.ipw;
        } else if (deO != null && this.ipm != null && !StringUtils.isNull(this.ipm.cbc())) {
            uri2 = this.ipm.cbc();
        } else {
            uri2 = (deO == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && deO != null) {
            this.ipi = deO.X(this.bVM, uri2, this.ipk);
        }
        this.ipk = null;
        this.ipz = 0L;
        return this.ipi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbu() {
        return this.ipf != null && this.ipf.getDuration() >= this.ipf.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.ipi, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.ipi, j);
    }

    public static boolean pm(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.ipg = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.ipf != null) {
            return this.ipf.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.ipf != null ? this.ipf.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.ipi != null) {
            this.ipi.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.iph = cVar;
    }
}
