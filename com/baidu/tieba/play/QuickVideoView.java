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
    private static h deM;
    private static com.baidu.tieba.j.l deN;
    private static int ipD = 0;
    private static int ipE = 1;
    private static int ipF = 2;
    private static int ipG = 1;
    private static int ipH = 0;
    private Map<String, String> FO;
    private WeakReference<Context> bAG;
    private String bVL;
    private b cIB;
    private g.b cIx;
    private g.a cRS;
    private g.f cRT;
    private g.c cRU;
    private g.e cRV;
    private g.InterfaceC0388g cRW;
    private g.i cRX;
    private g.d cRY;
    private g.h cRZ;
    private final CustomMessageListener cSg;
    private int cWi;
    private boolean deF;
    private g.f deO;
    private g.a deP;
    private g.InterfaceC0388g deS;
    private int hYM;
    private a ioJ;
    private boolean ipA;
    private long ipB;
    private long ipC;
    private int ipI;
    private int ipJ;
    private int ipK;
    private int ipL;
    private int ipM;
    private int ipN;
    private boolean ipO;
    private Runnable ipP;
    private Runnable ipQ;
    private TextureView.SurfaceTextureListener ipR;
    private Runnable ipS;
    private RenderView ipc;
    private String ipd;
    private g ipe;
    private g.e ipf;
    private c ipg;
    private com.baidu.tieba.j.i iph;
    private com.baidu.tieba.j.e ipi;
    private String ipj;
    private boolean ipk;
    private d ipl;
    private boolean ipm;
    private int ipn;
    private int ipo;
    private boolean ipp;
    private SurfaceTexture ipq;
    private boolean ipr;
    private com.baidu.tieba.play.b.a ips;
    private r ipt;
    private com.baidu.tieba.play.b.f ipu;
    private String ipv;
    private String ipw;
    private String ipx;
    private long ipy;
    private boolean ipz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cba();
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
            deM = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            deN = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.ipr = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.ipk = false;
        this.ipm = false;
        this.ipn = 0;
        this.deF = false;
        this.ipo = -1;
        this.ipp = false;
        this.ipq = null;
        this.ipr = true;
        this.ipB = 0L;
        this.ipC = 0L;
        this.hYM = ipH;
        this.ipI = 0;
        this.ipJ = 0;
        this.ipK = -1;
        this.ipL = 0;
        this.ipM = 0;
        this.ipN = 0;
        this.cWi = 0;
        this.ipO = false;
        this.bAG = null;
        this.ipP = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipk) {
                    QuickVideoView.this.b(QuickVideoView.this.ipe, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.ni(false);
                }
            }
        };
        this.ipR = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ipO) {
                    QuickVideoView.this.ipO = false;
                    QuickVideoView.this.ipe.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipm || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipe != null && QuickVideoView.this.ipp) {
                        QuickVideoView.this.ipe.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.ipo);
                        if (QuickVideoView.this.ioJ != null) {
                            QuickVideoView.this.ioJ.cba();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iph.bLX();
                        }
                    }
                } else if (cbv()) {
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.cbo();
                        QuickVideoView.this.ipm = true;
                        QuickVideoView.this.ipe.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iph.bLW();
                    }
                }
                QuickVideoView.this.ipq = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipO) {
                    QuickVideoView.this.cbq();
                    QuickVideoView.this.pP(false);
                    if (QuickVideoView.this.ipe != null) {
                        if (QuickVideoView.this.ipe.isPlaying() && QuickVideoView.this.cbt()) {
                            y.cbV().bf(QuickVideoView.this.ipx, QuickVideoView.this.ipe.getCurrentPosition());
                        }
                        QuickVideoView.this.ipe.release();
                    }
                    if (QuickVideoView.this.ipm) {
                        if (QuickVideoView.this.ipl != null) {
                            QuickVideoView.this.ipl.onStop();
                        }
                        if (QuickVideoView.this.cIB != null) {
                            QuickVideoView.this.cIB.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipq = null;
                    if (QuickVideoView.this.iph != null && QuickVideoView.this.iph.Aq(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.ipm = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbv() {
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
        this.deO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Ck;
                QuickVideoView.this.cbq();
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.onPrepared();
                }
                if (QuickVideoView.this.iph != null && QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.iph.wI(QuickVideoView.this.ipe.getPlayerType());
                }
                if (QuickVideoView.this.cRT != null) {
                    QuickVideoView.this.cRT.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipl != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipe != null) {
                        j = QuickVideoView.this.ipe.getDuration();
                    }
                    QuickVideoView.this.ipl.eg(j);
                    QuickVideoView.this.cbp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipl.cbh();
                        QuickVideoView.this.cbs();
                    }
                }
                if (QuickVideoView.this.ipA && (Ck = y.cbV().Ck(QuickVideoView.this.ipx)) > 0) {
                    if (QuickVideoView.this.ipe.isPlayerReuse()) {
                        if (QuickVideoView.this.ipe.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Ck);
                        }
                    } else {
                        QuickVideoView.this.ys(Ck);
                    }
                }
                if (QuickVideoView.this.ipk) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ipc != null && gVar != null) {
                    QuickVideoView.this.ipc.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipn);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipd) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipd);
                }
                if (QuickVideoView.this.ips != null && QuickVideoView.this.ips.ccr()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pP(true);
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.Ap(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iph = null;
                }
                if (!QuickVideoView.this.deF || QuickVideoView.this.ipl == null) {
                    if (QuickVideoView.this.ipl != null) {
                        QuickVideoView.this.ipl.onCompletion();
                    }
                    QuickVideoView.this.ipk = false;
                    y.cbV().remove(QuickVideoView.this.ipx);
                    if (QuickVideoView.this.cRS != null) {
                        QuickVideoView.this.cRS.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipj = null;
                QuickVideoView.this.ipy = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipl.cbb());
                QuickVideoView.this.start();
            }
        };
        this.cRU = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ad(i, i2, i3);
                QuickVideoView.this.cbq();
                if (QuickVideoView.this.ipl != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbt()) {
                    QuickVideoView.this.ipz = true;
                    y.cbV().bf(QuickVideoView.this.ipx, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.iph != null) {
                        QuickVideoView.this.ipj = QuickVideoView.this.iph.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipy, QuickVideoView.this.Z(QuickVideoView.this.iph.bMb(), i3 + "", QuickVideoView.this.iph.bMc()));
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.ipy = 0L;
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
        this.deS = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipz) {
                    QuickVideoView.this.ipz = false;
                    return;
                }
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.cbF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipl != null && z) {
                    QuickVideoView.this.ipl.onSeekComplete();
                }
                if (QuickVideoView.this.cRW != null) {
                    QuickVideoView.this.cRW.b(gVar);
                }
            }
        };
        this.cRV = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ipf != null) {
                    QuickVideoView.this.ipf.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ipn = i2;
                    if (QuickVideoView.this.ipc != null && gVar != null) {
                        QuickVideoView.this.ipc.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipn);
                    }
                }
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.a(i, i2, QuickVideoView.this.iph);
                    return true;
                }
                return true;
            }
        };
        this.cRX = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.i(i, i2, str);
                }
            }
        };
        this.cRY = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.Ar(str);
                }
            }
        };
        this.cRZ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipy = j;
                }
            }
        };
        this.ipS = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipl != null && QuickVideoView.this.ipl.cbd() && QuickVideoView.this.ipl.cbe() && QuickVideoView.this.ipl.cbf() && QuickVideoView.this.ipe != null) {
                    int aAp = QuickVideoView.this.ipe.aAp();
                    int currentPosition = QuickVideoView.this.ipe.getCurrentPosition();
                    int duration = QuickVideoView.this.ipe.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipB;
                    boolean z = currentPosition + aAp < duration;
                    if (aAp < QuickVideoView.this.ipl.cbg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipB = currentTimeMillis;
                        QuickVideoView.this.ipl.yq(0);
                    }
                    if (QuickVideoView.this.cbr() && currentPosition == QuickVideoView.this.ipC && j > 500) {
                        QuickVideoView.this.ipB = currentTimeMillis;
                        QuickVideoView.this.ipl.yq(0);
                    }
                    QuickVideoView.this.ipC = currentPosition;
                    if (QuickVideoView.this.hYM == QuickVideoView.ipG) {
                        QuickVideoView.this.cbs();
                    }
                }
            }
        };
        this.cSg = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipl != null) {
                        QuickVideoView.this.ipl.cbj();
                    }
                    if (QuickVideoView.this.iph != null) {
                        QuickVideoView.this.iph.Ao(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.cbq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ipk = false;
        this.ipm = false;
        this.ipn = 0;
        this.deF = false;
        this.ipo = -1;
        this.ipp = false;
        this.ipq = null;
        this.ipr = true;
        this.ipB = 0L;
        this.ipC = 0L;
        this.hYM = ipH;
        this.ipI = 0;
        this.ipJ = 0;
        this.ipK = -1;
        this.ipL = 0;
        this.ipM = 0;
        this.ipN = 0;
        this.cWi = 0;
        this.ipO = false;
        this.bAG = null;
        this.ipP = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipk) {
                    QuickVideoView.this.b(QuickVideoView.this.ipe, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.ni(false);
                }
            }
        };
        this.ipR = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ipO) {
                    QuickVideoView.this.ipO = false;
                    QuickVideoView.this.ipe.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipm || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipe != null && QuickVideoView.this.ipp) {
                        QuickVideoView.this.ipe.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.ipo);
                        if (QuickVideoView.this.ioJ != null) {
                            QuickVideoView.this.ioJ.cba();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iph.bLX();
                        }
                    }
                } else if (cbv()) {
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.cbo();
                        QuickVideoView.this.ipm = true;
                        QuickVideoView.this.ipe.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iph.bLW();
                    }
                }
                QuickVideoView.this.ipq = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipO) {
                    QuickVideoView.this.cbq();
                    QuickVideoView.this.pP(false);
                    if (QuickVideoView.this.ipe != null) {
                        if (QuickVideoView.this.ipe.isPlaying() && QuickVideoView.this.cbt()) {
                            y.cbV().bf(QuickVideoView.this.ipx, QuickVideoView.this.ipe.getCurrentPosition());
                        }
                        QuickVideoView.this.ipe.release();
                    }
                    if (QuickVideoView.this.ipm) {
                        if (QuickVideoView.this.ipl != null) {
                            QuickVideoView.this.ipl.onStop();
                        }
                        if (QuickVideoView.this.cIB != null) {
                            QuickVideoView.this.cIB.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipq = null;
                    if (QuickVideoView.this.iph != null && QuickVideoView.this.iph.Aq(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.ipm = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbv() {
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
        this.deO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Ck;
                QuickVideoView.this.cbq();
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.onPrepared();
                }
                if (QuickVideoView.this.iph != null && QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.iph.wI(QuickVideoView.this.ipe.getPlayerType());
                }
                if (QuickVideoView.this.cRT != null) {
                    QuickVideoView.this.cRT.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipl != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipe != null) {
                        j = QuickVideoView.this.ipe.getDuration();
                    }
                    QuickVideoView.this.ipl.eg(j);
                    QuickVideoView.this.cbp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipl.cbh();
                        QuickVideoView.this.cbs();
                    }
                }
                if (QuickVideoView.this.ipA && (Ck = y.cbV().Ck(QuickVideoView.this.ipx)) > 0) {
                    if (QuickVideoView.this.ipe.isPlayerReuse()) {
                        if (QuickVideoView.this.ipe.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Ck);
                        }
                    } else {
                        QuickVideoView.this.ys(Ck);
                    }
                }
                if (QuickVideoView.this.ipk) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ipc != null && gVar != null) {
                    QuickVideoView.this.ipc.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipn);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipd) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipd);
                }
                if (QuickVideoView.this.ips != null && QuickVideoView.this.ips.ccr()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pP(true);
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.Ap(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iph = null;
                }
                if (!QuickVideoView.this.deF || QuickVideoView.this.ipl == null) {
                    if (QuickVideoView.this.ipl != null) {
                        QuickVideoView.this.ipl.onCompletion();
                    }
                    QuickVideoView.this.ipk = false;
                    y.cbV().remove(QuickVideoView.this.ipx);
                    if (QuickVideoView.this.cRS != null) {
                        QuickVideoView.this.cRS.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipj = null;
                QuickVideoView.this.ipy = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipl.cbb());
                QuickVideoView.this.start();
            }
        };
        this.cRU = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ad(i, i2, i3);
                QuickVideoView.this.cbq();
                if (QuickVideoView.this.ipl != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbt()) {
                    QuickVideoView.this.ipz = true;
                    y.cbV().bf(QuickVideoView.this.ipx, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.iph != null) {
                        QuickVideoView.this.ipj = QuickVideoView.this.iph.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipy, QuickVideoView.this.Z(QuickVideoView.this.iph.bMb(), i3 + "", QuickVideoView.this.iph.bMc()));
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.ipy = 0L;
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
        this.deS = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipz) {
                    QuickVideoView.this.ipz = false;
                    return;
                }
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.cbF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipl != null && z) {
                    QuickVideoView.this.ipl.onSeekComplete();
                }
                if (QuickVideoView.this.cRW != null) {
                    QuickVideoView.this.cRW.b(gVar);
                }
            }
        };
        this.cRV = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ipf != null) {
                    QuickVideoView.this.ipf.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ipn = i2;
                    if (QuickVideoView.this.ipc != null && gVar != null) {
                        QuickVideoView.this.ipc.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipn);
                    }
                }
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.a(i, i2, QuickVideoView.this.iph);
                    return true;
                }
                return true;
            }
        };
        this.cRX = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.i(i, i2, str);
                }
            }
        };
        this.cRY = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.Ar(str);
                }
            }
        };
        this.cRZ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipy = j;
                }
            }
        };
        this.ipS = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipl != null && QuickVideoView.this.ipl.cbd() && QuickVideoView.this.ipl.cbe() && QuickVideoView.this.ipl.cbf() && QuickVideoView.this.ipe != null) {
                    int aAp = QuickVideoView.this.ipe.aAp();
                    int currentPosition = QuickVideoView.this.ipe.getCurrentPosition();
                    int duration = QuickVideoView.this.ipe.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipB;
                    boolean z = currentPosition + aAp < duration;
                    if (aAp < QuickVideoView.this.ipl.cbg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipB = currentTimeMillis;
                        QuickVideoView.this.ipl.yq(0);
                    }
                    if (QuickVideoView.this.cbr() && currentPosition == QuickVideoView.this.ipC && j > 500) {
                        QuickVideoView.this.ipB = currentTimeMillis;
                        QuickVideoView.this.ipl.yq(0);
                    }
                    QuickVideoView.this.ipC = currentPosition;
                    if (QuickVideoView.this.hYM == QuickVideoView.ipG) {
                        QuickVideoView.this.cbs();
                    }
                }
            }
        };
        this.cSg = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipl != null) {
                        QuickVideoView.this.ipl.cbj();
                    }
                    if (QuickVideoView.this.iph != null) {
                        QuickVideoView.this.iph.Ao(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.cbq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ipk = false;
        this.ipm = false;
        this.ipn = 0;
        this.deF = false;
        this.ipo = -1;
        this.ipp = false;
        this.ipq = null;
        this.ipr = true;
        this.ipB = 0L;
        this.ipC = 0L;
        this.hYM = ipH;
        this.ipI = 0;
        this.ipJ = 0;
        this.ipK = -1;
        this.ipL = 0;
        this.ipM = 0;
        this.ipN = 0;
        this.cWi = 0;
        this.ipO = false;
        this.bAG = null;
        this.ipP = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ipe != null && QuickVideoView.this.ipk) {
                    QuickVideoView.this.b(QuickVideoView.this.ipe, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ipQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.ni(false);
                }
            }
        };
        this.ipR = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.ipO) {
                    QuickVideoView.this.ipO = false;
                    QuickVideoView.this.ipe.setSurface(surfaceTexture);
                } else if (QuickVideoView.this.ipm || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ipe != null && QuickVideoView.this.ipp) {
                        QuickVideoView.this.ipe.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.ipo);
                        if (QuickVideoView.this.ioJ != null) {
                            QuickVideoView.this.ioJ.cba();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iph.bLX();
                        }
                    }
                } else if (cbv()) {
                    if (QuickVideoView.this.ipe != null) {
                        QuickVideoView.this.cbo();
                        QuickVideoView.this.ipm = true;
                        QuickVideoView.this.ipe.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FO, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iph.bLW();
                    }
                }
                QuickVideoView.this.ipq = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ipO) {
                    QuickVideoView.this.cbq();
                    QuickVideoView.this.pP(false);
                    if (QuickVideoView.this.ipe != null) {
                        if (QuickVideoView.this.ipe.isPlaying() && QuickVideoView.this.cbt()) {
                            y.cbV().bf(QuickVideoView.this.ipx, QuickVideoView.this.ipe.getCurrentPosition());
                        }
                        QuickVideoView.this.ipe.release();
                    }
                    if (QuickVideoView.this.ipm) {
                        if (QuickVideoView.this.ipl != null) {
                            QuickVideoView.this.ipl.onStop();
                        }
                        if (QuickVideoView.this.cIB != null) {
                            QuickVideoView.this.cIB.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ipq = null;
                    if (QuickVideoView.this.iph != null && QuickVideoView.this.iph.Aq(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.ipm = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cbv() {
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
        this.deO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Ck;
                QuickVideoView.this.cbq();
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.onPrepared();
                }
                if (QuickVideoView.this.iph != null && QuickVideoView.this.ipe != null) {
                    QuickVideoView.this.iph.wI(QuickVideoView.this.ipe.getPlayerType());
                }
                if (QuickVideoView.this.cRT != null) {
                    QuickVideoView.this.cRT.onPrepared(gVar);
                }
                if (QuickVideoView.this.ipl != null) {
                    long j = 0;
                    if (QuickVideoView.this.ipe != null) {
                        j = QuickVideoView.this.ipe.getDuration();
                    }
                    QuickVideoView.this.ipl.eg(j);
                    QuickVideoView.this.cbp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ipl.cbh();
                        QuickVideoView.this.cbs();
                    }
                }
                if (QuickVideoView.this.ipA && (Ck = y.cbV().Ck(QuickVideoView.this.ipx)) > 0) {
                    if (QuickVideoView.this.ipe.isPlayerReuse()) {
                        if (QuickVideoView.this.ipe.getCurrentPosition() == 0) {
                            QuickVideoView.this.ys(Ck);
                        }
                    } else {
                        QuickVideoView.this.ys(Ck);
                    }
                }
                if (QuickVideoView.this.ipk) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.ipc != null && gVar != null) {
                    QuickVideoView.this.ipc.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipn);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ipd) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ipd);
                }
                if (QuickVideoView.this.ips != null && QuickVideoView.this.ips.ccr()) {
                    com.baidu.tieba.play.b.e.yz(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.deP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pP(true);
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.Ap(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iph = null;
                }
                if (!QuickVideoView.this.deF || QuickVideoView.this.ipl == null) {
                    if (QuickVideoView.this.ipl != null) {
                        QuickVideoView.this.ipl.onCompletion();
                    }
                    QuickVideoView.this.ipk = false;
                    y.cbV().remove(QuickVideoView.this.ipx);
                    if (QuickVideoView.this.cRS != null) {
                        QuickVideoView.this.cRS.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ipj = null;
                QuickVideoView.this.ipy = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ipl.cbb());
                QuickVideoView.this.start();
            }
        };
        this.cRU = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ad(i2, i22, i3);
                QuickVideoView.this.cbq();
                if (QuickVideoView.this.ipl != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cbt()) {
                    QuickVideoView.this.ipz = true;
                    y.cbV().bf(QuickVideoView.this.ipx, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jS()) {
                    if (QuickVideoView.this.iph != null) {
                        QuickVideoView.this.ipj = QuickVideoView.this.iph.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ipy, QuickVideoView.this.Z(QuickVideoView.this.iph.bMb(), i3 + "", QuickVideoView.this.iph.bMc()));
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.ipy = 0L;
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
        this.deS = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0388g
            public void b(g gVar) {
                if (QuickVideoView.this.ipz) {
                    QuickVideoView.this.ipz = false;
                    return;
                }
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.cbF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ipl != null && z) {
                    QuickVideoView.this.ipl.onSeekComplete();
                }
                if (QuickVideoView.this.cRW != null) {
                    QuickVideoView.this.cRW.b(gVar);
                }
            }
        };
        this.cRV = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.ipf != null) {
                    QuickVideoView.this.ipf.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.ipn = i22;
                    if (QuickVideoView.this.ipc != null && gVar != null) {
                        QuickVideoView.this.ipc.ac(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ipn);
                    }
                }
                if (QuickVideoView.this.ipt != null) {
                    QuickVideoView.this.ipt.a(i2, i22, QuickVideoView.this.iph);
                    return true;
                }
                return true;
            }
        };
        this.cRX = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.i(i2, i22, str);
                }
            }
        };
        this.cRY = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iph != null) {
                    QuickVideoView.this.iph.Ar(str);
                }
            }
        };
        this.cRZ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ipy = j;
                }
            }
        };
        this.ipS = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ipl != null && QuickVideoView.this.ipl.cbd() && QuickVideoView.this.ipl.cbe() && QuickVideoView.this.ipl.cbf() && QuickVideoView.this.ipe != null) {
                    int aAp = QuickVideoView.this.ipe.aAp();
                    int currentPosition = QuickVideoView.this.ipe.getCurrentPosition();
                    int duration = QuickVideoView.this.ipe.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ipB;
                    boolean z = currentPosition + aAp < duration;
                    if (aAp < QuickVideoView.this.ipl.cbg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ipB = currentTimeMillis;
                        QuickVideoView.this.ipl.yq(0);
                    }
                    if (QuickVideoView.this.cbr() && currentPosition == QuickVideoView.this.ipC && j > 500) {
                        QuickVideoView.this.ipB = currentTimeMillis;
                        QuickVideoView.this.ipl.yq(0);
                    }
                    QuickVideoView.this.ipC = currentPosition;
                    if (QuickVideoView.this.hYM == QuickVideoView.ipG) {
                        QuickVideoView.this.cbs();
                    }
                }
            }
        };
        this.cSg = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ipl != null) {
                        QuickVideoView.this.ipl.cbj();
                    }
                    if (QuickVideoView.this.iph != null) {
                        QuickVideoView.this.iph.Ao(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iph = null;
                    }
                    QuickVideoView.this.cbq();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ipc = new RenderView(context);
        this.bAG = new WeakReference<>(TbadkCoreApplication.getInst());
        this.ipc.setSurfaceTextureListener(this.ipR);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.ipr) {
            addView(this.ipc, layoutParams);
        } else {
            addView(this.ipc, 0, layoutParams);
        }
        if (deM != null) {
            this.ipe = deM.aAr();
        }
        if (this.ipe != null) {
            this.ipe.setOnPreparedListener(this.deO);
            this.ipe.setOnCompletionListener(this.deP);
            this.ipe.a(this.cRU);
            this.ipe.setOnSeekCompleteListener(this.deS);
            this.ipe.a(this.cRV);
            this.ipe.a(this.cRX);
            this.ipe.a(this.cRY);
            this.ipe.a(this.cRZ);
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
        this.ips = new com.baidu.tieba.play.b.a(this);
        this.ipt = new r();
        this.ipu = new com.baidu.tieba.play.b.f();
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
        this.ipA = z;
    }

    public void setVideoPath(String str, String str2) {
        this.bVL = str2;
        if (this.ips != null) {
            this.ips.clear();
            this.ips.ccr();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Cp(str2);
            if (deN != null) {
                this.iph = deN.X(this.bVL, str, "");
                if (this.iph != null) {
                    this.iph.a(-300, -44399, -44399, getLocateSource(), false, this.ipy, "");
                    this.iph = null;
                }
            }
        }
        if (this.ipi != null) {
            this.ipi.a(null);
            this.ipi.bLP();
            this.ipi = null;
        }
        this.ipj = null;
        this.ipy = 0L;
        setVideoPath(str);
    }

    public void dR(String str, String str2) {
    }

    private String Cg(String str) {
        if (!ap.isEmpty(str) && com.baidu.tieba.video.g.cqS().cqT()) {
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
            this.ipv = Cg;
            if (this.ipl != null) {
                Cg = this.ipl.rL(Cg);
                if (this.ipl.cbi() != null) {
                    this.ipl.cbi().setPlayer(this);
                }
                if (deN != null && pn(Cg)) {
                    this.ipi = deN.Au(Cg);
                }
                if (this.ipi != null) {
                    this.ipi.a(new com.baidu.tieba.play.monitor.a(this.bVL, this.ipv, this.iph));
                    this.ipi.bLO();
                }
                Ch(Cg);
            }
            if (!com.baidu.adp.lib.util.j.jS() && !pn(Cg)) {
                if (this.cIx != null) {
                    this.cIx.onError(this.ipe, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(Cg));
            if (this.iph != null) {
                if (u(Uri.parse(Cg)) != null) {
                    this.iph.bLV();
                }
                this.iph.Fr();
                this.iph = null;
            }
            this.ipw = str;
            int lastIndexOf = this.ipw.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.ipw.length() > 4) {
                this.ipx = this.ipw.substring(0, lastIndexOf + 4);
            } else {
                this.ipx = this.ipw;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbo() {
        if (com.baidu.tbadk.coreExtra.model.f.aoE()) {
            if (this.ipl != null && (this.ipl.cbc() || this.ipl.cbd())) {
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipP);
                com.baidu.adp.lib.g.e.iB().postDelayed(this.ipP, com.baidu.tbadk.coreExtra.model.f.aoD());
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipQ);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.ipQ, com.baidu.tbadk.coreExtra.model.f.aoC());
        }
    }

    public void caD() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.iph.An(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aAl();
        }
        this.mUri = uri;
        this.FO = map;
        if (this.ipq != null) {
            cbo();
            if (this.ipe != null) {
                if (!this.ipm) {
                    this.ipm = true;
                    this.ipe.a(this.mContext, this.mUri, this.FO, this.ipq, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.deO.onPrepared(this.ipe);
                }
            }
        } else if (this.ipc != null && this.ipc.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.ipr) {
                addView(this.ipc, layoutParams);
            } else {
                addView(this.ipc, 0, layoutParams);
            }
        }
        al.k(this, R.color.cp_bg_line_k);
    }

    private void aAl() {
        this.ipm = false;
        this.ipk = false;
        if (this.ipe != null) {
            if (this.ipe.isPlaying() && cbt()) {
                y.cbV().bf(this.ipx, this.ipe.getCurrentPosition());
            }
            this.ipe.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipS);
    }

    private void Ch(String str) {
        this.ipJ = 0;
        this.ipK = 0;
        this.ipL = 0;
        this.ipM = 0;
        this.ipN = 0;
        this.cWi = 0;
        if (this.ipl.cbd()) {
            this.ipI = ipE;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.ipK = (int) u.Cj(QuickVideoView.this.ipv);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.ipv != null && this.ipv.equals(str)) {
            this.ipI = ipD;
        } else {
            this.ipI = ipF;
        }
        this.hYM = ipG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbp() {
        this.hYM = ipG;
        if (this.ipe != null) {
            this.ipJ = this.ipe.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(boolean z) {
        if (this.hYM == ipG && this.ipe != null) {
            this.hYM = ipH;
            this.ipM = this.ipe.getDuration();
            if (z) {
                this.ipN = 0;
                this.ipL = this.ipM;
            } else {
                this.ipL = this.ipe.getCurrentPosition();
                this.ipN = this.ipe.getCachedSize();
            }
            if (this.ipL > 0) {
                if (this.ipI == ipD) {
                    this.ipK = (int) u.Cj(this.ipv);
                    if (this.ipJ > 0) {
                        long j = (this.ipJ * (this.ipL / 1000)) / 8;
                        if (this.ipN < 0) {
                            this.ipN = 0;
                        }
                        long j2 = this.ipN + j;
                        if (this.ipK > 0) {
                            j2 += this.ipK;
                        }
                        setFlowCount(j2, this.ipL, this.ipM, this.cWi);
                    } else if (this.ipJ == -1) {
                        this.ipJ = 603327;
                        setFlowCount((this.ipJ * (this.ipL / 1000)) / 8, this.ipL, this.ipM, this.cWi);
                    }
                } else if (this.ipI == ipE) {
                    if (this.ipJ > 0) {
                        long j3 = (this.ipJ * (this.ipL / 1000)) / 8;
                        if (this.ipN < 0) {
                            this.ipN = 0;
                        }
                        long j4 = this.ipN + j3;
                        if (this.ipK > 0) {
                            j4 -= this.ipK;
                        }
                        setFlowCount(j4, this.ipL, this.ipM, this.cWi);
                    } else if (this.ipJ == -1) {
                        this.ipJ = 603327;
                        setFlowCount((this.ipJ * (this.ipL / 1000)) / 8, this.ipL, this.ipM, this.cWi);
                    }
                } else {
                    setFlowCount(0L, this.ipL, this.ipM, this.cWi);
                }
            }
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipS);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.bAG, false);
        }
        cbq();
        pP(false);
        if (this.ips != null) {
            this.ips.clear();
        }
        this.ipd = null;
        aAl();
        this.deF = false;
        if (this.ipl != null) {
            this.ipl.onStop();
        }
        com.baidu.tieba.play.a.b.cbY().a((b.InterfaceC0385b) null);
        if (this.iph != null && this.iph.Aq(getLocateSource())) {
            this.iph = null;
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipS);
    }

    public void setFullScreenToDestroySurface() {
        this.ipO = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbq() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipP);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipQ);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cRT = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cRS = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cIx = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0388g interfaceC0388g) {
        this.cRW = interfaceC0388g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.ipu == null) {
            return "";
        }
        String cct = this.ipu.cct();
        this.ipu.aa(str, str2, str3);
        return cct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.ipl != null && !StringUtils.isNull(this.ipl.cbb())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Co(uri);
                }
            }
            this.mUri = Uri.parse(this.ipl.cbb());
        }
        boolean z = false;
        if (this.ips != null) {
            z = this.ips.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.iph != null) {
            this.ipj = this.iph.a(i, i2, i3, getLocateSource(), z, this.ipy, Z(this.iph.bMb(), i3 + "", this.iph.bMc()));
            this.iph = null;
        }
        this.ipy = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.ipe != null) {
            try {
                if (this.ipe.isPlaying() && cbt()) {
                    y.cbV().bf(this.ipx, this.ipe.getCurrentPosition());
                }
                this.ipe.release();
                this.ipd = str;
                URI uri = new URI(this.mUri.toString());
                this.ipe.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.FO, this.ipq, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.iph.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ipe != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.ipe.isPlaying() && cbt()) {
                y.cbV().bf(this.ipx, this.ipe.getCurrentPosition());
            }
            this.ipe.release();
            this.ipe.a(this.mContext, this.mUri, this.FO, this.ipq, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.iph.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ipe != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.ipe.forceUseSystemMediaPlayer(true);
            }
            if (this.ipe.isPlaying() && cbt()) {
                y.cbV().bf(this.ipx, this.ipe.getCurrentPosition());
            }
            this.ipe.release();
            this.ipe.a(this.mContext, this.mUri, this.FO, this.ipq, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.iph.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.ipk = true;
        if (this.ipe != null) {
            if (this.ipq != null && this.ipp && !this.ipe.isExistInRemote()) {
                this.ipe.a(this.mContext, this.mUri, this.FO, this.ipq, this.ipo);
                if (this.ioJ != null) {
                    this.ioJ.cba();
                }
                if (u(this.mUri) != null) {
                    this.iph.bLX();
                }
                cbo();
                return;
            }
            if (!this.ipe.aAq()) {
                ad.a(this.bAG, true);
                this.ipe.setVolume(1.0f, 1.0f);
            }
            this.ipe.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.ipl != null) {
            this.ipl.onStart();
        }
        if (this.ipg != null) {
            this.ipg.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.ipe != null) {
            this.iph.wJ(this.ipe.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cbq();
        ad.a(this.bAG, false);
        if (this.ipe != null) {
            if (this.ipe.isPlaying() && cbt()) {
                y.cbV().bf(this.ipx, this.ipe.getCurrentPosition());
            }
            this.ipe.pause();
        }
        if (this.ipl != null) {
            this.ipl.onPause();
        }
        this.ipk = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iph != null) {
            this.iph.bMa();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.ipe != null) {
            return this.ipe.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.ipe != null) {
            return this.ipe.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cWi = i;
        ys(i);
    }

    public void ys(int i) {
        if (this.ipt != null) {
            this.ipt.cbE();
        }
        if (this.ipe != null) {
            this.ipe.seekTo(i);
        }
        if (this.ipl != null) {
            this.ipl.yq(0);
            cbs();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.ipe != null) {
            return this.ipe.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.ipe != null) {
            this.ipe.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.ipo = i;
    }

    public int getRecoveryState() {
        return this.ipo;
    }

    public void setNeedRecovery(boolean z) {
        this.ipp = z;
    }

    public void setLooping(boolean z) {
        this.deF = z;
    }

    public boolean cbr() {
        return this.ipk;
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
        this.ipl = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cSg);
    }

    public void setMute(boolean z) {
        if (z) {
            this.ipe.setVolume(0.0f, 0.0f);
            ad.a(this.bAG, false);
            return;
        }
        ad.a(this.bAG, true);
        this.ipe.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.deF = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ipe != null) {
            this.ipe.avm();
        }
        if (this.ipt != null) {
            this.ipt.cbG();
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipS);
        MessageManager.getInstance().unRegisterListener(this.cSg);
        if (this.ips != null) {
            this.ips.clear();
        }
        if (this.ipi != null) {
            this.ipi.a(null);
            this.ipi.bLP();
        }
    }

    public g getPlayer() {
        return this.ipe;
    }

    public int getPlayerType() {
        if (this.ipe == null) {
            return -300;
        }
        return this.ipe.getPlayerType();
    }

    public void cbs() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipS);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.ipS, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.ioJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.ipl instanceof n) || ((n) this.ipl).cbC() == null) ? "" : ((n) this.ipl).cbC().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i u(Uri uri) {
        String uri2;
        if (this.iph != null) {
            return this.iph;
        }
        if (!StringUtils.isNull(this.ipv)) {
            uri2 = this.ipv;
        } else if (deN != null && this.ipl != null && !StringUtils.isNull(this.ipl.cbb())) {
            uri2 = this.ipl.cbb();
        } else {
            uri2 = (deN == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && deN != null) {
            this.iph = deN.X(this.bVL, uri2, this.ipj);
        }
        this.ipj = null;
        this.ipy = 0L;
        return this.iph;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbt() {
        return this.ipe != null && this.ipe.getDuration() >= this.ipe.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.iph, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.iph, j);
    }

    public static boolean pn(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.ipf = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.ipe != null) {
            return this.ipe.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.ipe != null ? this.ipe.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.iph != null) {
            this.iph.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.ipg = cVar;
    }
}
