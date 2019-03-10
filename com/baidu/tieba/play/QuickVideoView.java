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
import com.baidu.tbadk.TbConfig;
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
    private static h hWL;
    private static com.baidu.tieba.j.l hWM;
    private static int hXk = 0;
    private static int hXl = 1;
    private static int hXm = 2;
    private static int hXn = 1;
    private static int hXo = 0;
    private Map<String, String> Ie;
    private WeakReference<Context> bty;
    private g.b cAp;
    private b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.c cJK;
    private g.e cJL;
    private g.InterfaceC0295g cJM;
    private g.i cJN;
    private g.d cJO;
    private g.h cJP;
    private final CustomMessageListener cJW;
    private int cNW;
    private String ctx;
    private int hHc;
    private RenderView hWG;
    private String hWH;
    private g hWI;
    private g.e hWJ;
    private c hWK;
    private com.baidu.tieba.j.i hWN;
    private com.baidu.tieba.j.e hWO;
    private String hWP;
    private boolean hWQ;
    private d hWR;
    private boolean hWS;
    private int hWT;
    private boolean hWU;
    private int hWV;
    private boolean hWW;
    private SurfaceTexture hWX;
    private boolean hWY;
    private com.baidu.tieba.play.b.a hWZ;
    private a hWn;
    private g.a hXA;
    private g.InterfaceC0295g hXB;
    private Runnable hXC;
    private r hXa;
    private com.baidu.tieba.play.b.f hXb;
    private String hXc;
    private String hXd;
    private String hXe;
    private long hXf;
    private boolean hXg;
    private boolean hXh;
    private long hXi;
    private long hXj;
    private int hXp;
    private int hXq;
    private int hXr;
    private int hXs;
    private int hXt;
    private int hXu;
    private boolean hXv;
    private Runnable hXw;
    private Runnable hXx;
    private TextureView.SurfaceTextureListener hXy;
    private g.f hXz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bSY();
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
            hWL = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            hWM = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.hWY = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.hWQ = false;
        this.hWS = false;
        this.hWT = 0;
        this.hWU = false;
        this.hWV = -1;
        this.hWW = false;
        this.hWX = null;
        this.hWY = true;
        this.hXi = 0L;
        this.hXj = 0L;
        this.hHc = hXo;
        this.hXp = 0;
        this.hXq = 0;
        this.hXr = -1;
        this.hXs = 0;
        this.hXt = 0;
        this.hXu = 0;
        this.cNW = 0;
        this.hXv = false;
        this.bty = null;
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWI != null && QuickVideoView.this.hWQ) {
                    QuickVideoView.this.b(QuickVideoView.this.hWI, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.mt(false);
                }
            }
        };
        this.hXy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXv) {
                    QuickVideoView.this.hXv = false;
                    QuickVideoView.this.hWI.c(surfaceTexture);
                } else if (QuickVideoView.this.hWS || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWI != null && QuickVideoView.this.hWW) {
                        QuickVideoView.this.hWI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWV);
                        if (QuickVideoView.this.hWn != null) {
                            QuickVideoView.this.hWn.bSY();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWN.bEn();
                        }
                    }
                } else if (bTt()) {
                    if (QuickVideoView.this.hWI != null) {
                        QuickVideoView.this.bTm();
                        QuickVideoView.this.hWS = true;
                        QuickVideoView.this.hWI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWN.bEm();
                    }
                }
                QuickVideoView.this.hWX = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXv) {
                    QuickVideoView.this.bTo();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWI != null) {
                        if (QuickVideoView.this.hWI.isPlaying() && QuickVideoView.this.bTr()) {
                            y.bTT().bj(QuickVideoView.this.hXe, QuickVideoView.this.hWI.getCurrentPosition());
                        }
                        QuickVideoView.this.hWI.release();
                    }
                    if (QuickVideoView.this.hWS) {
                        if (QuickVideoView.this.hWR != null) {
                            QuickVideoView.this.hWR.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWX = null;
                    if (QuickVideoView.this.hWN != null && QuickVideoView.this.hWN.zd(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.hWS = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTt() {
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
        this.hXz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AV;
                QuickVideoView.this.bTo();
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.onPrepared();
                }
                if (QuickVideoView.this.hWN != null && QuickVideoView.this.hWI != null) {
                    QuickVideoView.this.hWN.vF(QuickVideoView.this.hWI.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWR != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWI != null) {
                        j = QuickVideoView.this.hWI.getDuration();
                    }
                    QuickVideoView.this.hWR.dI(j);
                    QuickVideoView.this.bTn();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWR.bTf();
                        QuickVideoView.this.bTq();
                    }
                }
                if (QuickVideoView.this.hXh && (AV = y.bTT().AV(QuickVideoView.this.hXe)) > 0) {
                    if (QuickVideoView.this.hWI.isPlayerReuse()) {
                        if (QuickVideoView.this.hWI.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AV);
                        }
                    } else {
                        QuickVideoView.this.xp(AV);
                    }
                }
                if (QuickVideoView.this.hWQ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWG != null && gVar != null) {
                    QuickVideoView.this.hWG.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWT);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWH) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWH);
                }
                if (QuickVideoView.this.hWZ != null && QuickVideoView.this.hWZ.bUp()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.zc(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWN = null;
                }
                if (!QuickVideoView.this.hWU || QuickVideoView.this.hWR == null) {
                    if (QuickVideoView.this.hWR != null) {
                        QuickVideoView.this.hWR.onCompletion();
                    }
                    QuickVideoView.this.hWQ = false;
                    y.bTT().remove(QuickVideoView.this.hXe);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWP = null;
                QuickVideoView.this.hXf = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWR.bSZ());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTo();
                if (QuickVideoView.this.hWR != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTr()) {
                    QuickVideoView.this.hXg = true;
                    y.bTT().bj(QuickVideoView.this.hXe, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWN != null) {
                        QuickVideoView.this.hWP = QuickVideoView.this.hWN.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hXf, QuickVideoView.this.Z(QuickVideoView.this.hWN.bEr(), i3 + "", QuickVideoView.this.hWN.bEs()));
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.hXf = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xu(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xv(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAp == null || QuickVideoView.this.cAp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXB = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (QuickVideoView.this.hXg) {
                    QuickVideoView.this.hXg = false;
                    return;
                }
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.bTD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWR != null && z) {
                    QuickVideoView.this.hWR.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWJ != null) {
                    QuickVideoView.this.hWJ.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWT = i2;
                    if (QuickVideoView.this.hWG != null && gVar != null) {
                        QuickVideoView.this.hWG.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWT);
                    }
                }
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.a(i, i2, QuickVideoView.this.hWN);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.h(i, i2, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.ze(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hXf = j;
                }
            }
        };
        this.hXC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWR != null && QuickVideoView.this.hWR.bTb() && QuickVideoView.this.hWR.bTc() && QuickVideoView.this.hWR.bTd() && QuickVideoView.this.hWI != null) {
                    int avl = QuickVideoView.this.hWI.avl();
                    int currentPosition = QuickVideoView.this.hWI.getCurrentPosition();
                    int duration = QuickVideoView.this.hWI.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXi;
                    boolean z = currentPosition + avl < duration;
                    if (avl < QuickVideoView.this.hWR.bTe() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.hXi = currentTimeMillis;
                        QuickVideoView.this.hWR.xn(0);
                    }
                    if (QuickVideoView.this.bTp() && currentPosition == QuickVideoView.this.hXj && j > 500) {
                        QuickVideoView.this.hXi = currentTimeMillis;
                        QuickVideoView.this.hWR.xn(0);
                    }
                    QuickVideoView.this.hXj = currentPosition;
                    if (QuickVideoView.this.hHc == QuickVideoView.hXn) {
                        QuickVideoView.this.bTq();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWR != null) {
                        QuickVideoView.this.hWR.bTh();
                    }
                    if (QuickVideoView.this.hWN != null) {
                        QuickVideoView.this.hWN.zb(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.bTo();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWQ = false;
        this.hWS = false;
        this.hWT = 0;
        this.hWU = false;
        this.hWV = -1;
        this.hWW = false;
        this.hWX = null;
        this.hWY = true;
        this.hXi = 0L;
        this.hXj = 0L;
        this.hHc = hXo;
        this.hXp = 0;
        this.hXq = 0;
        this.hXr = -1;
        this.hXs = 0;
        this.hXt = 0;
        this.hXu = 0;
        this.cNW = 0;
        this.hXv = false;
        this.bty = null;
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWI != null && QuickVideoView.this.hWQ) {
                    QuickVideoView.this.b(QuickVideoView.this.hWI, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.mt(false);
                }
            }
        };
        this.hXy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXv) {
                    QuickVideoView.this.hXv = false;
                    QuickVideoView.this.hWI.c(surfaceTexture);
                } else if (QuickVideoView.this.hWS || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWI != null && QuickVideoView.this.hWW) {
                        QuickVideoView.this.hWI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWV);
                        if (QuickVideoView.this.hWn != null) {
                            QuickVideoView.this.hWn.bSY();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWN.bEn();
                        }
                    }
                } else if (bTt()) {
                    if (QuickVideoView.this.hWI != null) {
                        QuickVideoView.this.bTm();
                        QuickVideoView.this.hWS = true;
                        QuickVideoView.this.hWI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWN.bEm();
                    }
                }
                QuickVideoView.this.hWX = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXv) {
                    QuickVideoView.this.bTo();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWI != null) {
                        if (QuickVideoView.this.hWI.isPlaying() && QuickVideoView.this.bTr()) {
                            y.bTT().bj(QuickVideoView.this.hXe, QuickVideoView.this.hWI.getCurrentPosition());
                        }
                        QuickVideoView.this.hWI.release();
                    }
                    if (QuickVideoView.this.hWS) {
                        if (QuickVideoView.this.hWR != null) {
                            QuickVideoView.this.hWR.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWX = null;
                    if (QuickVideoView.this.hWN != null && QuickVideoView.this.hWN.zd(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.hWS = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTt() {
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
        this.hXz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AV;
                QuickVideoView.this.bTo();
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.onPrepared();
                }
                if (QuickVideoView.this.hWN != null && QuickVideoView.this.hWI != null) {
                    QuickVideoView.this.hWN.vF(QuickVideoView.this.hWI.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWR != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWI != null) {
                        j = QuickVideoView.this.hWI.getDuration();
                    }
                    QuickVideoView.this.hWR.dI(j);
                    QuickVideoView.this.bTn();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWR.bTf();
                        QuickVideoView.this.bTq();
                    }
                }
                if (QuickVideoView.this.hXh && (AV = y.bTT().AV(QuickVideoView.this.hXe)) > 0) {
                    if (QuickVideoView.this.hWI.isPlayerReuse()) {
                        if (QuickVideoView.this.hWI.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AV);
                        }
                    } else {
                        QuickVideoView.this.xp(AV);
                    }
                }
                if (QuickVideoView.this.hWQ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWG != null && gVar != null) {
                    QuickVideoView.this.hWG.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWT);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWH) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWH);
                }
                if (QuickVideoView.this.hWZ != null && QuickVideoView.this.hWZ.bUp()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.zc(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWN = null;
                }
                if (!QuickVideoView.this.hWU || QuickVideoView.this.hWR == null) {
                    if (QuickVideoView.this.hWR != null) {
                        QuickVideoView.this.hWR.onCompletion();
                    }
                    QuickVideoView.this.hWQ = false;
                    y.bTT().remove(QuickVideoView.this.hXe);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWP = null;
                QuickVideoView.this.hXf = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWR.bSZ());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTo();
                if (QuickVideoView.this.hWR != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTr()) {
                    QuickVideoView.this.hXg = true;
                    y.bTT().bj(QuickVideoView.this.hXe, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWN != null) {
                        QuickVideoView.this.hWP = QuickVideoView.this.hWN.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hXf, QuickVideoView.this.Z(QuickVideoView.this.hWN.bEr(), i3 + "", QuickVideoView.this.hWN.bEs()));
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.hXf = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.xu(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xv(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAp == null || QuickVideoView.this.cAp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.hXB = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (QuickVideoView.this.hXg) {
                    QuickVideoView.this.hXg = false;
                    return;
                }
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.bTD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWR != null && z) {
                    QuickVideoView.this.hWR.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWJ != null) {
                    QuickVideoView.this.hWJ.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWT = i2;
                    if (QuickVideoView.this.hWG != null && gVar != null) {
                        QuickVideoView.this.hWG.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWT);
                    }
                }
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.a(i, i2, QuickVideoView.this.hWN);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.h(i, i2, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.ze(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hXf = j;
                }
            }
        };
        this.hXC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWR != null && QuickVideoView.this.hWR.bTb() && QuickVideoView.this.hWR.bTc() && QuickVideoView.this.hWR.bTd() && QuickVideoView.this.hWI != null) {
                    int avl = QuickVideoView.this.hWI.avl();
                    int currentPosition = QuickVideoView.this.hWI.getCurrentPosition();
                    int duration = QuickVideoView.this.hWI.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXi;
                    boolean z = currentPosition + avl < duration;
                    if (avl < QuickVideoView.this.hWR.bTe() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.hXi = currentTimeMillis;
                        QuickVideoView.this.hWR.xn(0);
                    }
                    if (QuickVideoView.this.bTp() && currentPosition == QuickVideoView.this.hXj && j > 500) {
                        QuickVideoView.this.hXi = currentTimeMillis;
                        QuickVideoView.this.hWR.xn(0);
                    }
                    QuickVideoView.this.hXj = currentPosition;
                    if (QuickVideoView.this.hHc == QuickVideoView.hXn) {
                        QuickVideoView.this.bTq();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWR != null) {
                        QuickVideoView.this.hWR.bTh();
                    }
                    if (QuickVideoView.this.hWN != null) {
                        QuickVideoView.this.hWN.zb(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.bTo();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWQ = false;
        this.hWS = false;
        this.hWT = 0;
        this.hWU = false;
        this.hWV = -1;
        this.hWW = false;
        this.hWX = null;
        this.hWY = true;
        this.hXi = 0L;
        this.hXj = 0L;
        this.hHc = hXo;
        this.hXp = 0;
        this.hXq = 0;
        this.hXr = -1;
        this.hXs = 0;
        this.hXt = 0;
        this.hXu = 0;
        this.cNW = 0;
        this.hXv = false;
        this.bty = null;
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWI != null && QuickVideoView.this.hWQ) {
                    QuickVideoView.this.b(QuickVideoView.this.hWI, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.mt(false);
                }
            }
        };
        this.hXy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.hXv) {
                    QuickVideoView.this.hXv = false;
                    QuickVideoView.this.hWI.c(surfaceTexture);
                } else if (QuickVideoView.this.hWS || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWI != null && QuickVideoView.this.hWW) {
                        QuickVideoView.this.hWI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWV);
                        if (QuickVideoView.this.hWn != null) {
                            QuickVideoView.this.hWn.bSY();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWN.bEn();
                        }
                    }
                } else if (bTt()) {
                    if (QuickVideoView.this.hWI != null) {
                        QuickVideoView.this.bTm();
                        QuickVideoView.this.hWS = true;
                        QuickVideoView.this.hWI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWN.bEm();
                    }
                }
                QuickVideoView.this.hWX = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXv) {
                    QuickVideoView.this.bTo();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWI != null) {
                        if (QuickVideoView.this.hWI.isPlaying() && QuickVideoView.this.bTr()) {
                            y.bTT().bj(QuickVideoView.this.hXe, QuickVideoView.this.hWI.getCurrentPosition());
                        }
                        QuickVideoView.this.hWI.release();
                    }
                    if (QuickVideoView.this.hWS) {
                        if (QuickVideoView.this.hWR != null) {
                            QuickVideoView.this.hWR.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWX = null;
                    if (QuickVideoView.this.hWN != null && QuickVideoView.this.hWN.zd(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.hWS = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTt() {
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
        this.hXz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AV;
                QuickVideoView.this.bTo();
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.onPrepared();
                }
                if (QuickVideoView.this.hWN != null && QuickVideoView.this.hWI != null) {
                    QuickVideoView.this.hWN.vF(QuickVideoView.this.hWI.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWR != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWI != null) {
                        j = QuickVideoView.this.hWI.getDuration();
                    }
                    QuickVideoView.this.hWR.dI(j);
                    QuickVideoView.this.bTn();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWR.bTf();
                        QuickVideoView.this.bTq();
                    }
                }
                if (QuickVideoView.this.hXh && (AV = y.bTT().AV(QuickVideoView.this.hXe)) > 0) {
                    if (QuickVideoView.this.hWI.isPlayerReuse()) {
                        if (QuickVideoView.this.hWI.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AV);
                        }
                    } else {
                        QuickVideoView.this.xp(AV);
                    }
                }
                if (QuickVideoView.this.hWQ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWG != null && gVar != null) {
                    QuickVideoView.this.hWG.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWT);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWH) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWH);
                }
                if (QuickVideoView.this.hWZ != null && QuickVideoView.this.hWZ.bUp()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.zc(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWN = null;
                }
                if (!QuickVideoView.this.hWU || QuickVideoView.this.hWR == null) {
                    if (QuickVideoView.this.hWR != null) {
                        QuickVideoView.this.hWR.onCompletion();
                    }
                    QuickVideoView.this.hWQ = false;
                    y.bTT().remove(QuickVideoView.this.hXe);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWP = null;
                QuickVideoView.this.hXf = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWR.bSZ());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ac(i2, i22, i3);
                QuickVideoView.this.bTo();
                if (QuickVideoView.this.hWR != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTr()) {
                    QuickVideoView.this.hXg = true;
                    y.bTT().bj(QuickVideoView.this.hXe, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWN != null) {
                        QuickVideoView.this.hWP = QuickVideoView.this.hWN.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hXf, QuickVideoView.this.Z(QuickVideoView.this.hWN.bEr(), i3 + "", QuickVideoView.this.hWN.bEs()));
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.hXf = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.xu(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.xv(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cAp == null || QuickVideoView.this.cAp.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.hXB = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (QuickVideoView.this.hXg) {
                    QuickVideoView.this.hXg = false;
                    return;
                }
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.bTD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWR != null && z) {
                    QuickVideoView.this.hWR.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.hWJ != null) {
                    QuickVideoView.this.hWJ.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.hWT = i22;
                    if (QuickVideoView.this.hWG != null && gVar != null) {
                        QuickVideoView.this.hWG.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWT);
                    }
                }
                if (QuickVideoView.this.hXa != null) {
                    QuickVideoView.this.hXa.a(i2, i22, QuickVideoView.this.hWN);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.h(i2, i22, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWN != null) {
                    QuickVideoView.this.hWN.ze(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hXf = j;
                }
            }
        };
        this.hXC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWR != null && QuickVideoView.this.hWR.bTb() && QuickVideoView.this.hWR.bTc() && QuickVideoView.this.hWR.bTd() && QuickVideoView.this.hWI != null) {
                    int avl = QuickVideoView.this.hWI.avl();
                    int currentPosition = QuickVideoView.this.hWI.getCurrentPosition();
                    int duration = QuickVideoView.this.hWI.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXi;
                    boolean z = currentPosition + avl < duration;
                    if (avl < QuickVideoView.this.hWR.bTe() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.hXi = currentTimeMillis;
                        QuickVideoView.this.hWR.xn(0);
                    }
                    if (QuickVideoView.this.bTp() && currentPosition == QuickVideoView.this.hXj && j > 500) {
                        QuickVideoView.this.hXi = currentTimeMillis;
                        QuickVideoView.this.hWR.xn(0);
                    }
                    QuickVideoView.this.hXj = currentPosition;
                    if (QuickVideoView.this.hHc == QuickVideoView.hXn) {
                        QuickVideoView.this.bTq();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWR != null) {
                        QuickVideoView.this.hWR.bTh();
                    }
                    if (QuickVideoView.this.hWN != null) {
                        QuickVideoView.this.hWN.zb(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWN = null;
                    }
                    QuickVideoView.this.bTo();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.hWG = new RenderView(context);
        this.bty = new WeakReference<>(TbadkCoreApplication.getInst());
        this.hWG.setSurfaceTextureListener(this.hXy);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.hWY) {
            addView(this.hWG, layoutParams);
        } else {
            addView(this.hWG, 0, layoutParams);
        }
        if (hWL != null) {
            this.hWI = hWL.avn();
        }
        if (this.hWI != null) {
            this.hWI.setOnPreparedListener(this.hXz);
            this.hWI.setOnCompletionListener(this.hXA);
            this.hWI.a(this.cJK);
            this.hWI.setOnSeekCompleteListener(this.hXB);
            this.hWI.a(this.cJL);
            this.hWI.a(this.cJN);
            this.hWI.a(this.cJO);
            this.hWI.a(this.cJP);
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
        this.hWZ = new com.baidu.tieba.play.b.a(this);
        this.hXa = new r();
        this.hXb = new com.baidu.tieba.play.b.f();
        al.k(this, d.C0236d.cp_bg_line_k);
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iQ().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.hXh = z;
    }

    public void setVideoPath(String str, String str2) {
        this.ctx = str2;
        if (this.hWZ != null) {
            this.hWZ.clear();
            this.hWZ.bUp();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Ba(str2);
            if (hWM != null) {
                this.hWN = hWM.X(this.ctx, str, "");
                if (this.hWN != null) {
                    this.hWN.a(-300, -44399, -44399, getLocateSource(), false, this.hXf, "");
                    this.hWN = null;
                }
            }
        }
        if (this.hWO != null) {
            this.hWO.a(null);
            this.hWO.bEf();
            this.hWO = null;
        }
        this.hWP = null;
        this.hXf = 0L;
        setVideoPath(str);
    }

    public void dE(String str, String str2) {
    }

    private String AR(String str) {
        if (!ap.isEmpty(str) && com.baidu.tieba.video.g.ciM().ciN()) {
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
            String AR = AR(str);
            this.hXc = AR;
            if (this.hWR != null) {
                AR = this.hWR.qD(AR);
                if (this.hWR.bTg() != null) {
                    this.hWR.bTg().setPlayer(this);
                }
                if (hWM != null && oc(AR)) {
                    this.hWO = hWM.zh(AR);
                }
                if (this.hWO != null) {
                    this.hWO.a(new com.baidu.tieba.play.monitor.a(this.ctx, this.hXc, this.hWN));
                    this.hWO.bEe();
                }
                AS(AR);
            }
            if (!com.baidu.adp.lib.util.j.kY() && !oc(AR)) {
                if (this.cAp != null) {
                    this.cAp.onError(this.hWI, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(AR));
            if (this.hWN != null) {
                if (o(Uri.parse(AR)) != null) {
                    this.hWN.bEl();
                }
                this.hWN.Kq();
                this.hWN = null;
            }
            this.hXd = str;
            int lastIndexOf = this.hXd.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.hXd.length() > 4) {
                this.hXe = this.hXd.substring(0, lastIndexOf + 4);
            } else {
                this.hXe = this.hXd;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTm() {
        if (com.baidu.tbadk.coreExtra.model.f.ajH()) {
            if (this.hWR != null && (this.hWR.bTa() || this.hWR.bTb())) {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hXw, com.baidu.tbadk.coreExtra.model.f.ajG());
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXx);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXx, com.baidu.tbadk.coreExtra.model.f.ajF());
        }
    }

    public void bSC() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (o(uri) != null) {
            this.hWN.za(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            avh();
        }
        this.mUri = uri;
        this.Ie = map;
        this.hWT = 0;
        if (this.hWX != null) {
            bTm();
            if (this.hWI != null) {
                if (!this.hWS) {
                    this.hWS = true;
                    this.hWI.a(this.mContext, this.mUri, this.Ie, this.hWX, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.hXz.onPrepared(this.hWI);
                }
            }
        } else if (this.hWG != null && this.hWG.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.hWY) {
                addView(this.hWG, layoutParams);
            } else {
                addView(this.hWG, 0, layoutParams);
            }
        }
        al.k(this, d.C0236d.cp_bg_line_k);
    }

    private void avh() {
        this.hWS = false;
        this.hWQ = false;
        if (this.hWI != null) {
            if (this.hWI.isPlaying() && bTr()) {
                y.bTT().bj(this.hXe, this.hWI.getCurrentPosition());
            }
            this.hWI.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXC);
    }

    private void AS(String str) {
        this.hXq = 0;
        this.hXr = 0;
        this.hXs = 0;
        this.hXt = 0;
        this.hXu = 0;
        this.cNW = 0;
        if (this.hWR.bTb()) {
            this.hXp = hXl;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.hXr = (int) u.AU(QuickVideoView.this.hXc);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.hXc != null && this.hXc.equals(str)) {
            this.hXp = hXk;
        } else {
            this.hXp = hXm;
        }
        this.hHc = hXn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTn() {
        this.hHc = hXn;
        if (this.hWI != null) {
            this.hXq = this.hWI.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
        if (this.hHc == hXn && this.hWI != null) {
            this.hHc = hXo;
            this.hXt = this.hWI.getDuration();
            if (z) {
                this.hXu = 0;
                this.hXs = this.hXt;
            } else {
                this.hXs = this.hWI.getCurrentPosition();
                this.hXu = this.hWI.getCachedSize();
            }
            if (this.hXs > 0) {
                if (this.hXp == hXk) {
                    this.hXr = (int) u.AU(this.hXc);
                    if (this.hXq > 0) {
                        long j = (this.hXq * (this.hXs / 1000)) / 8;
                        if (this.hXu < 0) {
                            this.hXu = 0;
                        }
                        long j2 = this.hXu + j;
                        if (this.hXr > 0) {
                            j2 += this.hXr;
                        }
                        setFlowCount(j2, this.hXs, this.hXt, this.cNW);
                    } else if (this.hXq == -1) {
                        this.hXq = 603327;
                        setFlowCount((this.hXq * (this.hXs / 1000)) / 8, this.hXs, this.hXt, this.cNW);
                    }
                } else if (this.hXp == hXl) {
                    if (this.hXq > 0) {
                        long j3 = (this.hXq * (this.hXs / 1000)) / 8;
                        if (this.hXu < 0) {
                            this.hXu = 0;
                        }
                        long j4 = this.hXu + j3;
                        if (this.hXr > 0) {
                            j4 -= this.hXr;
                        }
                        setFlowCount(j4, this.hXs, this.hXt, this.cNW);
                    } else if (this.hXq == -1) {
                        this.hXq = 603327;
                        setFlowCount((this.hXq * (this.hXs / 1000)) / 8, this.hXs, this.hXt, this.cNW);
                    }
                } else {
                    setFlowCount(0L, this.hXs, this.hXt, this.cNW);
                }
            }
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXC);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.bty, false);
        }
        bTo();
        pb(false);
        if (this.hWZ != null) {
            this.hWZ.clear();
        }
        this.hWH = null;
        avh();
        this.hWU = false;
        if (this.hWR != null) {
            this.hWR.onStop();
        }
        com.baidu.tieba.play.a.b.bTW().a((b.InterfaceC0292b) null);
        if (this.hWN != null && this.hWN.zd(getLocateSource())) {
            this.hWN = null;
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXC);
    }

    public void setFullScreenToDestroySurface() {
        this.hXv = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTo() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXx);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.cJJ = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.cJI = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.cAp = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0295g interfaceC0295g) {
        this.cJM = interfaceC0295g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Z(String str, String str2, String str3) {
        if (this.hXb == null) {
            return "";
        }
        String bUr = this.hXb.bUr();
        this.hXb.aa(str, str2, str3);
        return bUr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.hWR != null && !StringUtils.isNull(this.hWR.bSZ())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.AZ(uri);
                }
            }
            this.mUri = Uri.parse(this.hWR.bSZ());
        }
        boolean z = false;
        if (this.hWZ != null) {
            z = this.hWZ.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.hWN != null) {
            this.hWP = this.hWN.a(i, i2, i3, getLocateSource(), z, this.hXf, Z(this.hWN.bEr(), i3 + "", this.hWN.bEs()));
            this.hWN = null;
        }
        this.hXf = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.hWI != null) {
            try {
                if (this.hWI.isPlaying() && bTr()) {
                    y.bTT().bj(this.hXe, this.hWI.getCurrentPosition());
                }
                this.hWI.release();
                this.hWH = str;
                URI uri = new URI(this.mUri.toString());
                this.hWI.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Ie, this.hWX, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (o(this.mUri) != null) {
                    this.hWN.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWI != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.hWI.isPlaying() && bTr()) {
                y.bTT().bj(this.hXe, this.hWI.getCurrentPosition());
            }
            this.hWI.release();
            this.hWI.a(this.mContext, this.mUri, this.Ie, this.hWX, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWN.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWI != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.hWI.forceUseSystemMediaPlayer(true);
            }
            if (this.hWI.isPlaying() && bTr()) {
                y.bTT().bj(this.hXe, this.hWI.getCurrentPosition());
            }
            this.hWI.release();
            this.hWI.a(this.mContext, this.mUri, this.Ie, this.hWX, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWN.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.hWQ = true;
        if (this.hWI != null) {
            if (this.hWX != null && this.hWW && !this.hWI.isExistInRemote()) {
                this.hWI.a(this.mContext, this.mUri, this.Ie, this.hWX, this.hWV);
                if (this.hWn != null) {
                    this.hWn.bSY();
                }
                if (o(this.mUri) != null) {
                    this.hWN.bEn();
                }
                bTm();
                return;
            }
            if (!this.hWI.avm()) {
                ad.a(this.bty, true);
                this.hWI.setVolume(1.0f, 1.0f);
            }
            this.hWI.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.hWR != null) {
            this.hWR.onStart();
        }
        if (this.hWK != null) {
            this.hWK.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (o(this.mUri) != null && this.hWI != null) {
            this.hWN.vG(this.hWI.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bTo();
        ad.a(this.bty, false);
        if (this.hWI != null) {
            if (this.hWI.isPlaying() && bTr()) {
                y.bTT().bj(this.hXe, this.hWI.getCurrentPosition());
            }
            this.hWI.pause();
        }
        if (this.hWR != null) {
            this.hWR.onPause();
        }
        this.hWQ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWN != null) {
            this.hWN.bEq();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.hWI != null) {
            return this.hWI.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.hWI != null) {
            return this.hWI.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cNW = i;
        xp(i);
    }

    public void xp(int i) {
        if (this.hXa != null) {
            this.hXa.bTC();
        }
        if (this.hWI != null) {
            this.hWI.seekTo(i);
        }
        if (this.hWR != null) {
            this.hWR.xn(0);
            bTq();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.hWI != null) {
            return this.hWI.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.hWI != null) {
            this.hWI.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.hWV = i;
    }

    public int getRecoveryState() {
        return this.hWV;
    }

    public void setNeedRecovery(boolean z) {
        this.hWW = z;
    }

    public void setLooping(boolean z) {
        this.hWU = z;
    }

    public boolean bTp() {
        return this.hWQ;
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
        this.cAt = bVar;
    }

    public void setBusiness(d dVar) {
        this.hWR = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cJW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hWU = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWI != null) {
            this.hWI.aql();
        }
        if (this.hXa != null) {
            this.hXa.bTE();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXC);
        MessageManager.getInstance().unRegisterListener(this.cJW);
        if (this.hWZ != null) {
            this.hWZ.clear();
        }
        if (this.hWO != null) {
            this.hWO.a(null);
            this.hWO.bEf();
        }
    }

    public g getPlayer() {
        return this.hWI;
    }

    public int getPlayerType() {
        if (this.hWI == null) {
            return -300;
        }
        return this.hWI.getPlayerType();
    }

    public void bTq() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXC);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXC, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.hWn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.hWR instanceof n) || ((n) this.hWR).bTA() == null) ? "" : ((n) this.hWR).bTA().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i o(Uri uri) {
        String uri2;
        if (this.hWN != null) {
            return this.hWN;
        }
        if (!StringUtils.isNull(this.hXc)) {
            uri2 = this.hXc;
        } else if (hWM != null && this.hWR != null && !StringUtils.isNull(this.hWR.bSZ())) {
            uri2 = this.hWR.bSZ();
        } else {
            uri2 = (hWM == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && hWM != null) {
            this.hWN = hWM.X(this.ctx, uri2, this.hWP);
        }
        this.hWP = null;
        this.hXf = 0L;
        return this.hWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTr() {
        return this.hWI != null && this.hWI.getDuration() >= this.hWI.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.hWN, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.hWN, j);
    }

    public static boolean oc(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.hWJ = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.hWI != null) {
            return this.hWI.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.hWI != null ? this.hWI.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.hWN != null) {
            this.hWN.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.hWK = cVar;
    }
}
