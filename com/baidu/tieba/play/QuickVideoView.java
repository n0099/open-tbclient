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
    private static h hWF;
    private static com.baidu.tieba.j.l hWG;
    private static int hXe = 0;
    private static int hXf = 1;
    private static int hXg = 2;
    private static int hXh = 1;
    private static int hXi = 0;
    private Map<String, String> Ie;
    private WeakReference<Context> btA;
    private g.b cAm;
    private b cAq;
    private g.a cJF;
    private g.f cJG;
    private g.c cJH;
    private g.e cJI;
    private g.InterfaceC0369g cJJ;
    private g.i cJK;
    private g.d cJL;
    private g.h cJM;
    private final CustomMessageListener cJT;
    private int cNT;
    private String ctu;
    private int hGW;
    private RenderView hWA;
    private String hWB;
    private g hWC;
    private g.e hWD;
    private c hWE;
    private com.baidu.tieba.j.i hWH;
    private com.baidu.tieba.j.e hWI;
    private String hWJ;
    private boolean hWK;
    private d hWL;
    private boolean hWM;
    private int hWN;
    private boolean hWO;
    private int hWP;
    private boolean hWQ;
    private SurfaceTexture hWR;
    private boolean hWS;
    private com.baidu.tieba.play.b.a hWT;
    private r hWU;
    private com.baidu.tieba.play.b.f hWV;
    private String hWW;
    private String hWX;
    private String hWY;
    private long hWZ;
    private a hWh;
    private boolean hXa;
    private boolean hXb;
    private long hXc;
    private long hXd;
    private int hXj;
    private int hXk;
    private int hXl;
    private int hXm;
    private int hXn;
    private int hXo;
    private boolean hXp;
    private Runnable hXq;
    private Runnable hXr;
    private TextureView.SurfaceTextureListener hXs;
    private g.f hXt;
    private g.a hXu;
    private g.InterfaceC0369g hXv;
    private Runnable hXw;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bTa();
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
            hWF = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            hWG = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.hWS = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.hWK = false;
        this.hWM = false;
        this.hWN = 0;
        this.hWO = false;
        this.hWP = -1;
        this.hWQ = false;
        this.hWR = null;
        this.hWS = true;
        this.hXc = 0L;
        this.hXd = 0L;
        this.hGW = hXi;
        this.hXj = 0;
        this.hXk = 0;
        this.hXl = -1;
        this.hXm = 0;
        this.hXn = 0;
        this.hXo = 0;
        this.cNT = 0;
        this.hXp = false;
        this.btA = null;
        this.hXq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWC != null && QuickVideoView.this.hWK) {
                    QuickVideoView.this.b(QuickVideoView.this.hWC, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.mt(false);
                }
            }
        };
        this.hXs = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXp) {
                    QuickVideoView.this.hXp = false;
                    QuickVideoView.this.hWC.c(surfaceTexture);
                } else if (QuickVideoView.this.hWM || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWC != null && QuickVideoView.this.hWQ) {
                        QuickVideoView.this.hWC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWP);
                        if (QuickVideoView.this.hWh != null) {
                            QuickVideoView.this.hWh.bTa();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWH.bEm();
                        }
                    }
                } else if (bTv()) {
                    if (QuickVideoView.this.hWC != null) {
                        QuickVideoView.this.bTo();
                        QuickVideoView.this.hWM = true;
                        QuickVideoView.this.hWC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWH.bEl();
                    }
                }
                QuickVideoView.this.hWR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXp) {
                    QuickVideoView.this.bTq();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWC != null) {
                        if (QuickVideoView.this.hWC.isPlaying() && QuickVideoView.this.bTt()) {
                            y.bTV().bj(QuickVideoView.this.hWY, QuickVideoView.this.hWC.getCurrentPosition());
                        }
                        QuickVideoView.this.hWC.release();
                    }
                    if (QuickVideoView.this.hWM) {
                        if (QuickVideoView.this.hWL != null) {
                            QuickVideoView.this.hWL.onStop();
                        }
                        if (QuickVideoView.this.cAq != null) {
                            QuickVideoView.this.cAq.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWR = null;
                    if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWH.zb(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.hWM = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTv() {
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
        this.hXt = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AT;
                QuickVideoView.this.bTq();
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.onPrepared();
                }
                if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWC != null) {
                    QuickVideoView.this.hWH.vF(QuickVideoView.this.hWC.getPlayerType());
                }
                if (QuickVideoView.this.cJG != null) {
                    QuickVideoView.this.cJG.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWL != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWC != null) {
                        j = QuickVideoView.this.hWC.getDuration();
                    }
                    QuickVideoView.this.hWL.dI(j);
                    QuickVideoView.this.bTp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWL.bTh();
                        QuickVideoView.this.bTs();
                    }
                }
                if (QuickVideoView.this.hXb && (AT = y.bTV().AT(QuickVideoView.this.hWY)) > 0) {
                    if (QuickVideoView.this.hWC.isPlayerReuse()) {
                        if (QuickVideoView.this.hWC.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AT);
                        }
                    } else {
                        QuickVideoView.this.xp(AT);
                    }
                }
                if (QuickVideoView.this.hWK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWA != null && gVar != null) {
                    QuickVideoView.this.hWA.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWB) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWB);
                }
                if (QuickVideoView.this.hWT != null && QuickVideoView.this.hWT.bUr()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXu = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.za(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWH = null;
                }
                if (!QuickVideoView.this.hWO || QuickVideoView.this.hWL == null) {
                    if (QuickVideoView.this.hWL != null) {
                        QuickVideoView.this.hWL.onCompletion();
                    }
                    QuickVideoView.this.hWK = false;
                    y.bTV().remove(QuickVideoView.this.hWY);
                    if (QuickVideoView.this.cJF != null) {
                        QuickVideoView.this.cJF.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWJ = null;
                QuickVideoView.this.hWZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWL.bTb());
                QuickVideoView.this.start();
            }
        };
        this.cJH = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTq();
                if (QuickVideoView.this.hWL != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTt()) {
                    QuickVideoView.this.hXa = true;
                    y.bTV().bj(QuickVideoView.this.hWY, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.hWJ = QuickVideoView.this.hWH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWZ, QuickVideoView.this.Z(QuickVideoView.this.hWH.bEq(), i3 + "", QuickVideoView.this.hWH.bEr()));
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.hWZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xu(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xv(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAm == null || QuickVideoView.this.cAm.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXv = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hXa) {
                    QuickVideoView.this.hXa = false;
                    return;
                }
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.bTF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWL != null && z) {
                    QuickVideoView.this.hWL.onSeekComplete();
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.b(gVar);
                }
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWD != null) {
                    QuickVideoView.this.hWD.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWN = i2;
                    if (QuickVideoView.this.hWA != null && gVar != null) {
                        QuickVideoView.this.hWA.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWN);
                    }
                }
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.a(i, i2, QuickVideoView.this.hWH);
                    return true;
                }
                return true;
            }
        };
        this.cJK = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.h(i, i2, str);
                }
            }
        };
        this.cJL = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.zc(str);
                }
            }
        };
        this.cJM = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWZ = j;
                }
            }
        };
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWL != null && QuickVideoView.this.hWL.bTd() && QuickVideoView.this.hWL.bTe() && QuickVideoView.this.hWL.bTf() && QuickVideoView.this.hWC != null) {
                    int avk = QuickVideoView.this.hWC.avk();
                    int currentPosition = QuickVideoView.this.hWC.getCurrentPosition();
                    int duration = QuickVideoView.this.hWC.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXc;
                    boolean z = currentPosition + avk < duration;
                    if (avk < QuickVideoView.this.hWL.bTg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hXc = currentTimeMillis;
                        QuickVideoView.this.hWL.xn(0);
                    }
                    if (QuickVideoView.this.bTr() && currentPosition == QuickVideoView.this.hXd && j > 500) {
                        QuickVideoView.this.hXc = currentTimeMillis;
                        QuickVideoView.this.hWL.xn(0);
                    }
                    QuickVideoView.this.hXd = currentPosition;
                    if (QuickVideoView.this.hGW == QuickVideoView.hXh) {
                        QuickVideoView.this.bTs();
                    }
                }
            }
        };
        this.cJT = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWL != null) {
                        QuickVideoView.this.hWL.bTj();
                    }
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.hWH.yZ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.bTq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWK = false;
        this.hWM = false;
        this.hWN = 0;
        this.hWO = false;
        this.hWP = -1;
        this.hWQ = false;
        this.hWR = null;
        this.hWS = true;
        this.hXc = 0L;
        this.hXd = 0L;
        this.hGW = hXi;
        this.hXj = 0;
        this.hXk = 0;
        this.hXl = -1;
        this.hXm = 0;
        this.hXn = 0;
        this.hXo = 0;
        this.cNT = 0;
        this.hXp = false;
        this.btA = null;
        this.hXq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWC != null && QuickVideoView.this.hWK) {
                    QuickVideoView.this.b(QuickVideoView.this.hWC, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.mt(false);
                }
            }
        };
        this.hXs = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXp) {
                    QuickVideoView.this.hXp = false;
                    QuickVideoView.this.hWC.c(surfaceTexture);
                } else if (QuickVideoView.this.hWM || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWC != null && QuickVideoView.this.hWQ) {
                        QuickVideoView.this.hWC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWP);
                        if (QuickVideoView.this.hWh != null) {
                            QuickVideoView.this.hWh.bTa();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWH.bEm();
                        }
                    }
                } else if (bTv()) {
                    if (QuickVideoView.this.hWC != null) {
                        QuickVideoView.this.bTo();
                        QuickVideoView.this.hWM = true;
                        QuickVideoView.this.hWC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWH.bEl();
                    }
                }
                QuickVideoView.this.hWR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXp) {
                    QuickVideoView.this.bTq();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWC != null) {
                        if (QuickVideoView.this.hWC.isPlaying() && QuickVideoView.this.bTt()) {
                            y.bTV().bj(QuickVideoView.this.hWY, QuickVideoView.this.hWC.getCurrentPosition());
                        }
                        QuickVideoView.this.hWC.release();
                    }
                    if (QuickVideoView.this.hWM) {
                        if (QuickVideoView.this.hWL != null) {
                            QuickVideoView.this.hWL.onStop();
                        }
                        if (QuickVideoView.this.cAq != null) {
                            QuickVideoView.this.cAq.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWR = null;
                    if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWH.zb(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.hWM = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTv() {
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
        this.hXt = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AT;
                QuickVideoView.this.bTq();
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.onPrepared();
                }
                if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWC != null) {
                    QuickVideoView.this.hWH.vF(QuickVideoView.this.hWC.getPlayerType());
                }
                if (QuickVideoView.this.cJG != null) {
                    QuickVideoView.this.cJG.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWL != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWC != null) {
                        j = QuickVideoView.this.hWC.getDuration();
                    }
                    QuickVideoView.this.hWL.dI(j);
                    QuickVideoView.this.bTp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWL.bTh();
                        QuickVideoView.this.bTs();
                    }
                }
                if (QuickVideoView.this.hXb && (AT = y.bTV().AT(QuickVideoView.this.hWY)) > 0) {
                    if (QuickVideoView.this.hWC.isPlayerReuse()) {
                        if (QuickVideoView.this.hWC.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AT);
                        }
                    } else {
                        QuickVideoView.this.xp(AT);
                    }
                }
                if (QuickVideoView.this.hWK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWA != null && gVar != null) {
                    QuickVideoView.this.hWA.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWB) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWB);
                }
                if (QuickVideoView.this.hWT != null && QuickVideoView.this.hWT.bUr()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXu = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.za(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWH = null;
                }
                if (!QuickVideoView.this.hWO || QuickVideoView.this.hWL == null) {
                    if (QuickVideoView.this.hWL != null) {
                        QuickVideoView.this.hWL.onCompletion();
                    }
                    QuickVideoView.this.hWK = false;
                    y.bTV().remove(QuickVideoView.this.hWY);
                    if (QuickVideoView.this.cJF != null) {
                        QuickVideoView.this.cJF.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWJ = null;
                QuickVideoView.this.hWZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWL.bTb());
                QuickVideoView.this.start();
            }
        };
        this.cJH = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTq();
                if (QuickVideoView.this.hWL != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTt()) {
                    QuickVideoView.this.hXa = true;
                    y.bTV().bj(QuickVideoView.this.hWY, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.hWJ = QuickVideoView.this.hWH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWZ, QuickVideoView.this.Z(QuickVideoView.this.hWH.bEq(), i3 + "", QuickVideoView.this.hWH.bEr()));
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.hWZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xu(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xv(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAm == null || QuickVideoView.this.cAm.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXv = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hXa) {
                    QuickVideoView.this.hXa = false;
                    return;
                }
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.bTF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWL != null && z) {
                    QuickVideoView.this.hWL.onSeekComplete();
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.b(gVar);
                }
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWD != null) {
                    QuickVideoView.this.hWD.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWN = i2;
                    if (QuickVideoView.this.hWA != null && gVar != null) {
                        QuickVideoView.this.hWA.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWN);
                    }
                }
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.a(i, i2, QuickVideoView.this.hWH);
                    return true;
                }
                return true;
            }
        };
        this.cJK = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.h(i, i2, str);
                }
            }
        };
        this.cJL = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.zc(str);
                }
            }
        };
        this.cJM = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWZ = j;
                }
            }
        };
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWL != null && QuickVideoView.this.hWL.bTd() && QuickVideoView.this.hWL.bTe() && QuickVideoView.this.hWL.bTf() && QuickVideoView.this.hWC != null) {
                    int avk = QuickVideoView.this.hWC.avk();
                    int currentPosition = QuickVideoView.this.hWC.getCurrentPosition();
                    int duration = QuickVideoView.this.hWC.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXc;
                    boolean z = currentPosition + avk < duration;
                    if (avk < QuickVideoView.this.hWL.bTg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hXc = currentTimeMillis;
                        QuickVideoView.this.hWL.xn(0);
                    }
                    if (QuickVideoView.this.bTr() && currentPosition == QuickVideoView.this.hXd && j > 500) {
                        QuickVideoView.this.hXc = currentTimeMillis;
                        QuickVideoView.this.hWL.xn(0);
                    }
                    QuickVideoView.this.hXd = currentPosition;
                    if (QuickVideoView.this.hGW == QuickVideoView.hXh) {
                        QuickVideoView.this.bTs();
                    }
                }
            }
        };
        this.cJT = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWL != null) {
                        QuickVideoView.this.hWL.bTj();
                    }
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.hWH.yZ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.bTq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWK = false;
        this.hWM = false;
        this.hWN = 0;
        this.hWO = false;
        this.hWP = -1;
        this.hWQ = false;
        this.hWR = null;
        this.hWS = true;
        this.hXc = 0L;
        this.hXd = 0L;
        this.hGW = hXi;
        this.hXj = 0;
        this.hXk = 0;
        this.hXl = -1;
        this.hXm = 0;
        this.hXn = 0;
        this.hXo = 0;
        this.cNT = 0;
        this.hXp = false;
        this.btA = null;
        this.hXq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWC != null && QuickVideoView.this.hWK) {
                    QuickVideoView.this.b(QuickVideoView.this.hWC, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.mt(false);
                }
            }
        };
        this.hXs = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.hXp) {
                    QuickVideoView.this.hXp = false;
                    QuickVideoView.this.hWC.c(surfaceTexture);
                } else if (QuickVideoView.this.hWM || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWC != null && QuickVideoView.this.hWQ) {
                        QuickVideoView.this.hWC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWP);
                        if (QuickVideoView.this.hWh != null) {
                            QuickVideoView.this.hWh.bTa();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWH.bEm();
                        }
                    }
                } else if (bTv()) {
                    if (QuickVideoView.this.hWC != null) {
                        QuickVideoView.this.bTo();
                        QuickVideoView.this.hWM = true;
                        QuickVideoView.this.hWC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWH.bEl();
                    }
                }
                QuickVideoView.this.hWR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXp) {
                    QuickVideoView.this.bTq();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWC != null) {
                        if (QuickVideoView.this.hWC.isPlaying() && QuickVideoView.this.bTt()) {
                            y.bTV().bj(QuickVideoView.this.hWY, QuickVideoView.this.hWC.getCurrentPosition());
                        }
                        QuickVideoView.this.hWC.release();
                    }
                    if (QuickVideoView.this.hWM) {
                        if (QuickVideoView.this.hWL != null) {
                            QuickVideoView.this.hWL.onStop();
                        }
                        if (QuickVideoView.this.cAq != null) {
                            QuickVideoView.this.cAq.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWR = null;
                    if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWH.zb(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.hWM = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTv() {
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
        this.hXt = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AT;
                QuickVideoView.this.bTq();
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.onPrepared();
                }
                if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWC != null) {
                    QuickVideoView.this.hWH.vF(QuickVideoView.this.hWC.getPlayerType());
                }
                if (QuickVideoView.this.cJG != null) {
                    QuickVideoView.this.cJG.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWL != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWC != null) {
                        j = QuickVideoView.this.hWC.getDuration();
                    }
                    QuickVideoView.this.hWL.dI(j);
                    QuickVideoView.this.bTp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWL.bTh();
                        QuickVideoView.this.bTs();
                    }
                }
                if (QuickVideoView.this.hXb && (AT = y.bTV().AT(QuickVideoView.this.hWY)) > 0) {
                    if (QuickVideoView.this.hWC.isPlayerReuse()) {
                        if (QuickVideoView.this.hWC.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AT);
                        }
                    } else {
                        QuickVideoView.this.xp(AT);
                    }
                }
                if (QuickVideoView.this.hWK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWA != null && gVar != null) {
                    QuickVideoView.this.hWA.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWB) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWB);
                }
                if (QuickVideoView.this.hWT != null && QuickVideoView.this.hWT.bUr()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXu = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.za(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWH = null;
                }
                if (!QuickVideoView.this.hWO || QuickVideoView.this.hWL == null) {
                    if (QuickVideoView.this.hWL != null) {
                        QuickVideoView.this.hWL.onCompletion();
                    }
                    QuickVideoView.this.hWK = false;
                    y.bTV().remove(QuickVideoView.this.hWY);
                    if (QuickVideoView.this.cJF != null) {
                        QuickVideoView.this.cJF.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWJ = null;
                QuickVideoView.this.hWZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWL.bTb());
                QuickVideoView.this.start();
            }
        };
        this.cJH = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ac(i2, i22, i3);
                QuickVideoView.this.bTq();
                if (QuickVideoView.this.hWL != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTt()) {
                    QuickVideoView.this.hXa = true;
                    y.bTV().bj(QuickVideoView.this.hWY, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.hWJ = QuickVideoView.this.hWH.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hWZ, QuickVideoView.this.Z(QuickVideoView.this.hWH.bEq(), i3 + "", QuickVideoView.this.hWH.bEr()));
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.hWZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.xu(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xv(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAm == null || QuickVideoView.this.cAm.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.hXv = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0369g
            public void b(g gVar) {
                if (QuickVideoView.this.hXa) {
                    QuickVideoView.this.hXa = false;
                    return;
                }
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.bTF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWL != null && z) {
                    QuickVideoView.this.hWL.onSeekComplete();
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.b(gVar);
                }
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.hWD != null) {
                    QuickVideoView.this.hWD.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.hWN = i22;
                    if (QuickVideoView.this.hWA != null && gVar != null) {
                        QuickVideoView.this.hWA.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWN);
                    }
                }
                if (QuickVideoView.this.hWU != null) {
                    QuickVideoView.this.hWU.a(i2, i22, QuickVideoView.this.hWH);
                    return true;
                }
                return true;
            }
        };
        this.cJK = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.h(i2, i22, str);
                }
            }
        };
        this.cJL = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWH.zc(str);
                }
            }
        };
        this.cJM = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hWZ = j;
                }
            }
        };
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWL != null && QuickVideoView.this.hWL.bTd() && QuickVideoView.this.hWL.bTe() && QuickVideoView.this.hWL.bTf() && QuickVideoView.this.hWC != null) {
                    int avk = QuickVideoView.this.hWC.avk();
                    int currentPosition = QuickVideoView.this.hWC.getCurrentPosition();
                    int duration = QuickVideoView.this.hWC.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXc;
                    boolean z = currentPosition + avk < duration;
                    if (avk < QuickVideoView.this.hWL.bTg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.hXc = currentTimeMillis;
                        QuickVideoView.this.hWL.xn(0);
                    }
                    if (QuickVideoView.this.bTr() && currentPosition == QuickVideoView.this.hXd && j > 500) {
                        QuickVideoView.this.hXc = currentTimeMillis;
                        QuickVideoView.this.hWL.xn(0);
                    }
                    QuickVideoView.this.hXd = currentPosition;
                    if (QuickVideoView.this.hGW == QuickVideoView.hXh) {
                        QuickVideoView.this.bTs();
                    }
                }
            }
        };
        this.cJT = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWL != null) {
                        QuickVideoView.this.hWL.bTj();
                    }
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.hWH.yZ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWH = null;
                    }
                    QuickVideoView.this.bTq();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.hWA = new RenderView(context);
        this.btA = new WeakReference<>(TbadkCoreApplication.getInst());
        this.hWA.setSurfaceTextureListener(this.hXs);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.hWS) {
            addView(this.hWA, layoutParams);
        } else {
            addView(this.hWA, 0, layoutParams);
        }
        if (hWF != null) {
            this.hWC = hWF.avm();
        }
        if (this.hWC != null) {
            this.hWC.setOnPreparedListener(this.hXt);
            this.hWC.setOnCompletionListener(this.hXu);
            this.hWC.a(this.cJH);
            this.hWC.setOnSeekCompleteListener(this.hXv);
            this.hWC.a(this.cJI);
            this.hWC.a(this.cJK);
            this.hWC.a(this.cJL);
            this.hWC.a(this.cJM);
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
        this.hWT = new com.baidu.tieba.play.b.a(this);
        this.hWU = new r();
        this.hWV = new com.baidu.tieba.play.b.f();
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
        this.hXb = z;
    }

    public void setVideoPath(String str, String str2) {
        this.ctu = str2;
        if (this.hWT != null) {
            this.hWT.clear();
            this.hWT.bUr();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.AY(str2);
            if (hWG != null) {
                this.hWH = hWG.X(this.ctu, str, "");
                if (this.hWH != null) {
                    this.hWH.a(-300, -44399, -44399, getLocateSource(), false, this.hWZ, "");
                    this.hWH = null;
                }
            }
        }
        if (this.hWI != null) {
            this.hWI.a(null);
            this.hWI.bEe();
            this.hWI = null;
        }
        this.hWJ = null;
        this.hWZ = 0L;
        setVideoPath(str);
    }

    public void dE(String str, String str2) {
    }

    private String AP(String str) {
        if (!ap.isEmpty(str) && com.baidu.tieba.video.g.ciP().ciQ()) {
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
            String AP = AP(str);
            this.hWW = AP;
            if (this.hWL != null) {
                AP = this.hWL.qB(AP);
                if (this.hWL.bTi() != null) {
                    this.hWL.bTi().setPlayer(this);
                }
                if (hWG != null && oc(AP)) {
                    this.hWI = hWG.zf(AP);
                }
                if (this.hWI != null) {
                    this.hWI.a(new com.baidu.tieba.play.monitor.a(this.ctu, this.hWW, this.hWH));
                    this.hWI.bEd();
                }
                AQ(AP);
            }
            if (!com.baidu.adp.lib.util.j.kY() && !oc(AP)) {
                if (this.cAm != null) {
                    this.cAm.onError(this.hWC, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(AP));
            if (this.hWH != null) {
                if (o(Uri.parse(AP)) != null) {
                    this.hWH.bEk();
                }
                this.hWH.Kq();
                this.hWH = null;
            }
            this.hWX = str;
            int lastIndexOf = this.hWX.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.hWX.length() > 4) {
                this.hWY = this.hWX.substring(0, lastIndexOf + 4);
            } else {
                this.hWY = this.hWX;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTo() {
        if (com.baidu.tbadk.coreExtra.model.f.ajG()) {
            if (this.hWL != null && (this.hWL.bTc() || this.hWL.bTd())) {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXq);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hXq, com.baidu.tbadk.coreExtra.model.f.ajF());
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXr);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXr, com.baidu.tbadk.coreExtra.model.f.ajE());
        }
    }

    public void bSE() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (o(uri) != null) {
            this.hWH.yY(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            avg();
        }
        this.mUri = uri;
        this.Ie = map;
        this.hWN = 0;
        if (this.hWR != null) {
            bTo();
            if (this.hWC != null) {
                if (!this.hWM) {
                    this.hWM = true;
                    this.hWC.a(this.mContext, this.mUri, this.Ie, this.hWR, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.hXt.onPrepared(this.hWC);
                }
            }
        } else if (this.hWA != null && this.hWA.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.hWS) {
                addView(this.hWA, layoutParams);
            } else {
                addView(this.hWA, 0, layoutParams);
            }
        }
        al.k(this, d.C0277d.cp_bg_line_k);
    }

    private void avg() {
        this.hWM = false;
        this.hWK = false;
        if (this.hWC != null) {
            if (this.hWC.isPlaying() && bTt()) {
                y.bTV().bj(this.hWY, this.hWC.getCurrentPosition());
            }
            this.hWC.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
    }

    private void AQ(String str) {
        this.hXk = 0;
        this.hXl = 0;
        this.hXm = 0;
        this.hXn = 0;
        this.hXo = 0;
        this.cNT = 0;
        if (this.hWL.bTd()) {
            this.hXj = hXf;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.hXl = (int) u.AS(QuickVideoView.this.hWW);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.hWW != null && this.hWW.equals(str)) {
            this.hXj = hXe;
        } else {
            this.hXj = hXg;
        }
        this.hGW = hXh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTp() {
        this.hGW = hXh;
        if (this.hWC != null) {
            this.hXk = this.hWC.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
        if (this.hGW == hXh && this.hWC != null) {
            this.hGW = hXi;
            this.hXn = this.hWC.getDuration();
            if (z) {
                this.hXo = 0;
                this.hXm = this.hXn;
            } else {
                this.hXm = this.hWC.getCurrentPosition();
                this.hXo = this.hWC.getCachedSize();
            }
            if (this.hXm > 0) {
                if (this.hXj == hXe) {
                    this.hXl = (int) u.AS(this.hWW);
                    if (this.hXk > 0) {
                        long j = (this.hXk * (this.hXm / 1000)) / 8;
                        if (this.hXo < 0) {
                            this.hXo = 0;
                        }
                        long j2 = this.hXo + j;
                        if (this.hXl > 0) {
                            j2 += this.hXl;
                        }
                        setFlowCount(j2, this.hXm, this.hXn, this.cNT);
                    } else if (this.hXk == -1) {
                        this.hXk = 603327;
                        setFlowCount((this.hXk * (this.hXm / 1000)) / 8, this.hXm, this.hXn, this.cNT);
                    }
                } else if (this.hXj == hXf) {
                    if (this.hXk > 0) {
                        long j3 = (this.hXk * (this.hXm / 1000)) / 8;
                        if (this.hXo < 0) {
                            this.hXo = 0;
                        }
                        long j4 = this.hXo + j3;
                        if (this.hXl > 0) {
                            j4 -= this.hXl;
                        }
                        setFlowCount(j4, this.hXm, this.hXn, this.cNT);
                    } else if (this.hXk == -1) {
                        this.hXk = 603327;
                        setFlowCount((this.hXk * (this.hXm / 1000)) / 8, this.hXm, this.hXn, this.cNT);
                    }
                } else {
                    setFlowCount(0L, this.hXm, this.hXn, this.cNT);
                }
            }
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.btA, false);
        }
        bTq();
        pb(false);
        if (this.hWT != null) {
            this.hWT.clear();
        }
        this.hWB = null;
        avg();
        this.hWO = false;
        if (this.hWL != null) {
            this.hWL.onStop();
        }
        com.baidu.tieba.play.a.b.bTY().a((b.InterfaceC0366b) null);
        if (this.hWH != null && this.hWH.zb(getLocateSource())) {
            this.hWH = null;
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
    }

    public void setFullScreenToDestroySurface() {
        this.hXp = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTq() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXq);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXr);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cJG = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cJF = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cAm = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0369g interfaceC0369g) {
        this.cJJ = interfaceC0369g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.hWV == null) {
            return "";
        }
        String bUt = this.hWV.bUt();
        this.hWV.aa(str, str2, str3);
        return bUt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.hWL != null && !StringUtils.isNull(this.hWL.bTb())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.AX(uri);
                }
            }
            this.mUri = Uri.parse(this.hWL.bTb());
        }
        boolean z = false;
        if (this.hWT != null) {
            z = this.hWT.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.hWH != null) {
            this.hWJ = this.hWH.a(i, i2, i3, getLocateSource(), z, this.hWZ, Z(this.hWH.bEq(), i3 + "", this.hWH.bEr()));
            this.hWH = null;
        }
        this.hWZ = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.hWC != null) {
            try {
                if (this.hWC.isPlaying() && bTt()) {
                    y.bTV().bj(this.hWY, this.hWC.getCurrentPosition());
                }
                this.hWC.release();
                this.hWB = str;
                URI uri = new URI(this.mUri.toString());
                this.hWC.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Ie, this.hWR, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (o(this.mUri) != null) {
                    this.hWH.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWC != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.hWC.isPlaying() && bTt()) {
                y.bTV().bj(this.hWY, this.hWC.getCurrentPosition());
            }
            this.hWC.release();
            this.hWC.a(this.mContext, this.mUri, this.Ie, this.hWR, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWH.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWC != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.hWC.forceUseSystemMediaPlayer(true);
            }
            if (this.hWC.isPlaying() && bTt()) {
                y.bTV().bj(this.hWY, this.hWC.getCurrentPosition());
            }
            this.hWC.release();
            this.hWC.a(this.mContext, this.mUri, this.Ie, this.hWR, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWH.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.hWK = true;
        if (this.hWC != null) {
            if (this.hWR != null && this.hWQ && !this.hWC.isExistInRemote()) {
                this.hWC.a(this.mContext, this.mUri, this.Ie, this.hWR, this.hWP);
                if (this.hWh != null) {
                    this.hWh.bTa();
                }
                if (o(this.mUri) != null) {
                    this.hWH.bEm();
                }
                bTo();
                return;
            }
            if (!this.hWC.avl()) {
                ad.a(this.btA, true);
                this.hWC.setVolume(1.0f, 1.0f);
            }
            this.hWC.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.hWL != null) {
            this.hWL.onStart();
        }
        if (this.hWE != null) {
            this.hWE.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (o(this.mUri) != null && this.hWC != null) {
            this.hWH.vG(this.hWC.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bTq();
        ad.a(this.btA, false);
        if (this.hWC != null) {
            if (this.hWC.isPlaying() && bTt()) {
                y.bTV().bj(this.hWY, this.hWC.getCurrentPosition());
            }
            this.hWC.pause();
        }
        if (this.hWL != null) {
            this.hWL.onPause();
        }
        this.hWK = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWH != null) {
            this.hWH.bEp();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.hWC != null) {
            return this.hWC.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.hWC != null) {
            return this.hWC.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cNT = i;
        xp(i);
    }

    public void xp(int i) {
        if (this.hWU != null) {
            this.hWU.bTE();
        }
        if (this.hWC != null) {
            this.hWC.seekTo(i);
        }
        if (this.hWL != null) {
            this.hWL.xn(0);
            bTs();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.hWC != null) {
            return this.hWC.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.hWC != null) {
            this.hWC.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.hWP = i;
    }

    public int getRecoveryState() {
        return this.hWP;
    }

    public void setNeedRecovery(boolean z) {
        this.hWQ = z;
    }

    public void setLooping(boolean z) {
        this.hWO = z;
    }

    public boolean bTr() {
        return this.hWK;
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
        this.cAq = bVar;
    }

    public void setBusiness(d dVar) {
        this.hWL = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cJT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hWO = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWC != null) {
            this.hWC.aqk();
        }
        if (this.hWU != null) {
            this.hWU.bTG();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
        MessageManager.getInstance().unRegisterListener(this.cJT);
        if (this.hWT != null) {
            this.hWT.clear();
        }
        if (this.hWI != null) {
            this.hWI.a(null);
            this.hWI.bEe();
        }
    }

    public g getPlayer() {
        return this.hWC;
    }

    public int getPlayerType() {
        if (this.hWC == null) {
            return -300;
        }
        return this.hWC.getPlayerType();
    }

    public void bTs() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXw, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.hWh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.hWL instanceof n) || ((n) this.hWL).bTC() == null) ? "" : ((n) this.hWL).bTC().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i o(Uri uri) {
        String uri2;
        if (this.hWH != null) {
            return this.hWH;
        }
        if (!StringUtils.isNull(this.hWW)) {
            uri2 = this.hWW;
        } else if (hWG != null && this.hWL != null && !StringUtils.isNull(this.hWL.bTb())) {
            uri2 = this.hWL.bTb();
        } else {
            uri2 = (hWG == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && hWG != null) {
            this.hWH = hWG.X(this.ctu, uri2, this.hWJ);
        }
        this.hWJ = null;
        this.hWZ = 0L;
        return this.hWH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTt() {
        return this.hWC != null && this.hWC.getDuration() >= this.hWC.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.hWH, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.hWH, j);
    }

    public static boolean oc(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.hWD = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.hWC != null) {
            return this.hWC.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.hWC != null ? this.hWC.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.hWH != null) {
            this.hWH.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.hWE = cVar;
    }
}
