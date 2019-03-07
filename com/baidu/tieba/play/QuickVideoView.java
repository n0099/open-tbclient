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
    private static h hWK;
    private static com.baidu.tieba.j.l hWL;
    private static int hXj = 0;
    private static int hXk = 1;
    private static int hXl = 2;
    private static int hXm = 1;
    private static int hXn = 0;
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
    private int hHb;
    private RenderView hWF;
    private String hWG;
    private g hWH;
    private g.e hWI;
    private c hWJ;
    private com.baidu.tieba.j.i hWM;
    private com.baidu.tieba.j.e hWN;
    private String hWO;
    private boolean hWP;
    private d hWQ;
    private boolean hWR;
    private int hWS;
    private boolean hWT;
    private int hWU;
    private boolean hWV;
    private SurfaceTexture hWW;
    private boolean hWX;
    private com.baidu.tieba.play.b.a hWY;
    private r hWZ;
    private a hWm;
    private g.InterfaceC0295g hXA;
    private Runnable hXB;
    private com.baidu.tieba.play.b.f hXa;
    private String hXb;
    private String hXc;
    private String hXd;
    private long hXe;
    private boolean hXf;
    private boolean hXg;
    private long hXh;
    private long hXi;
    private int hXo;
    private int hXp;
    private int hXq;
    private int hXr;
    private int hXs;
    private int hXt;
    private boolean hXu;
    private Runnable hXv;
    private Runnable hXw;
    private TextureView.SurfaceTextureListener hXx;
    private g.f hXy;
    private g.a hXz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bSX();
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
            hWK = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            hWL = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.hWX = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.hWP = false;
        this.hWR = false;
        this.hWS = 0;
        this.hWT = false;
        this.hWU = -1;
        this.hWV = false;
        this.hWW = null;
        this.hWX = true;
        this.hXh = 0L;
        this.hXi = 0L;
        this.hHb = hXn;
        this.hXo = 0;
        this.hXp = 0;
        this.hXq = -1;
        this.hXr = 0;
        this.hXs = 0;
        this.hXt = 0;
        this.cNW = 0;
        this.hXu = false;
        this.bty = null;
        this.hXv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWP) {
                    QuickVideoView.this.b(QuickVideoView.this.hWH, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.mt(false);
                }
            }
        };
        this.hXx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXu) {
                    QuickVideoView.this.hXu = false;
                    QuickVideoView.this.hWH.c(surfaceTexture);
                } else if (QuickVideoView.this.hWR || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWH != null && QuickVideoView.this.hWV) {
                        QuickVideoView.this.hWH.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWU);
                        if (QuickVideoView.this.hWm != null) {
                            QuickVideoView.this.hWm.bSX();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWM.bEm();
                        }
                    }
                } else if (bTs()) {
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.bTl();
                        QuickVideoView.this.hWR = true;
                        QuickVideoView.this.hWH.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWM.bEl();
                    }
                }
                QuickVideoView.this.hWW = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXu) {
                    QuickVideoView.this.bTn();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWH != null) {
                        if (QuickVideoView.this.hWH.isPlaying() && QuickVideoView.this.bTq()) {
                            y.bTS().bj(QuickVideoView.this.hXd, QuickVideoView.this.hWH.getCurrentPosition());
                        }
                        QuickVideoView.this.hWH.release();
                    }
                    if (QuickVideoView.this.hWR) {
                        if (QuickVideoView.this.hWQ != null) {
                            QuickVideoView.this.hWQ.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWW = null;
                    if (QuickVideoView.this.hWM != null && QuickVideoView.this.hWM.zc(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.hWR = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTs() {
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
        this.hXy = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AU;
                QuickVideoView.this.bTn();
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.onPrepared();
                }
                if (QuickVideoView.this.hWM != null && QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWM.vF(QuickVideoView.this.hWH.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWQ != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWH != null) {
                        j = QuickVideoView.this.hWH.getDuration();
                    }
                    QuickVideoView.this.hWQ.dI(j);
                    QuickVideoView.this.bTm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWQ.bTe();
                        QuickVideoView.this.bTp();
                    }
                }
                if (QuickVideoView.this.hXg && (AU = y.bTS().AU(QuickVideoView.this.hXd)) > 0) {
                    if (QuickVideoView.this.hWH.isPlayerReuse()) {
                        if (QuickVideoView.this.hWH.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AU);
                        }
                    } else {
                        QuickVideoView.this.xp(AU);
                    }
                }
                if (QuickVideoView.this.hWP) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWF != null && gVar != null) {
                    QuickVideoView.this.hWF.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWS);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWG) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWG);
                }
                if (QuickVideoView.this.hWY != null && QuickVideoView.this.hWY.bUo()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXz = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.zb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWM = null;
                }
                if (!QuickVideoView.this.hWT || QuickVideoView.this.hWQ == null) {
                    if (QuickVideoView.this.hWQ != null) {
                        QuickVideoView.this.hWQ.onCompletion();
                    }
                    QuickVideoView.this.hWP = false;
                    y.bTS().remove(QuickVideoView.this.hXd);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWO = null;
                QuickVideoView.this.hXe = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWQ.bSY());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTn();
                if (QuickVideoView.this.hWQ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTq()) {
                    QuickVideoView.this.hXf = true;
                    y.bTS().bj(QuickVideoView.this.hXd, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWM != null) {
                        QuickVideoView.this.hWO = QuickVideoView.this.hWM.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hXe, QuickVideoView.this.Z(QuickVideoView.this.hWM.bEq(), i3 + "", QuickVideoView.this.hWM.bEr()));
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.hXe = 0L;
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
        this.hXA = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (QuickVideoView.this.hXf) {
                    QuickVideoView.this.hXf = false;
                    return;
                }
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.bTC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWQ != null && z) {
                    QuickVideoView.this.hWQ.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWI != null) {
                    QuickVideoView.this.hWI.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWS = i2;
                    if (QuickVideoView.this.hWF != null && gVar != null) {
                        QuickVideoView.this.hWF.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWS);
                    }
                }
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.a(i, i2, QuickVideoView.this.hWM);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.h(i, i2, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.zd(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hXe = j;
                }
            }
        };
        this.hXB = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWQ != null && QuickVideoView.this.hWQ.bTa() && QuickVideoView.this.hWQ.bTb() && QuickVideoView.this.hWQ.bTc() && QuickVideoView.this.hWH != null) {
                    int avk = QuickVideoView.this.hWH.avk();
                    int currentPosition = QuickVideoView.this.hWH.getCurrentPosition();
                    int duration = QuickVideoView.this.hWH.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXh;
                    boolean z = currentPosition + avk < duration;
                    if (avk < QuickVideoView.this.hWQ.bTd() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.hXh = currentTimeMillis;
                        QuickVideoView.this.hWQ.xn(0);
                    }
                    if (QuickVideoView.this.bTo() && currentPosition == QuickVideoView.this.hXi && j > 500) {
                        QuickVideoView.this.hXh = currentTimeMillis;
                        QuickVideoView.this.hWQ.xn(0);
                    }
                    QuickVideoView.this.hXi = currentPosition;
                    if (QuickVideoView.this.hHb == QuickVideoView.hXm) {
                        QuickVideoView.this.bTp();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWQ != null) {
                        QuickVideoView.this.hWQ.bTg();
                    }
                    if (QuickVideoView.this.hWM != null) {
                        QuickVideoView.this.hWM.za(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.bTn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWP = false;
        this.hWR = false;
        this.hWS = 0;
        this.hWT = false;
        this.hWU = -1;
        this.hWV = false;
        this.hWW = null;
        this.hWX = true;
        this.hXh = 0L;
        this.hXi = 0L;
        this.hHb = hXn;
        this.hXo = 0;
        this.hXp = 0;
        this.hXq = -1;
        this.hXr = 0;
        this.hXs = 0;
        this.hXt = 0;
        this.cNW = 0;
        this.hXu = false;
        this.bty = null;
        this.hXv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWP) {
                    QuickVideoView.this.b(QuickVideoView.this.hWH, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.mt(false);
                }
            }
        };
        this.hXx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.hXu) {
                    QuickVideoView.this.hXu = false;
                    QuickVideoView.this.hWH.c(surfaceTexture);
                } else if (QuickVideoView.this.hWR || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWH != null && QuickVideoView.this.hWV) {
                        QuickVideoView.this.hWH.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWU);
                        if (QuickVideoView.this.hWm != null) {
                            QuickVideoView.this.hWm.bSX();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWM.bEm();
                        }
                    }
                } else if (bTs()) {
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.bTl();
                        QuickVideoView.this.hWR = true;
                        QuickVideoView.this.hWH.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWM.bEl();
                    }
                }
                QuickVideoView.this.hWW = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXu) {
                    QuickVideoView.this.bTn();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWH != null) {
                        if (QuickVideoView.this.hWH.isPlaying() && QuickVideoView.this.bTq()) {
                            y.bTS().bj(QuickVideoView.this.hXd, QuickVideoView.this.hWH.getCurrentPosition());
                        }
                        QuickVideoView.this.hWH.release();
                    }
                    if (QuickVideoView.this.hWR) {
                        if (QuickVideoView.this.hWQ != null) {
                            QuickVideoView.this.hWQ.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWW = null;
                    if (QuickVideoView.this.hWM != null && QuickVideoView.this.hWM.zc(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.hWR = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTs() {
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
        this.hXy = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AU;
                QuickVideoView.this.bTn();
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.onPrepared();
                }
                if (QuickVideoView.this.hWM != null && QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWM.vF(QuickVideoView.this.hWH.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWQ != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWH != null) {
                        j = QuickVideoView.this.hWH.getDuration();
                    }
                    QuickVideoView.this.hWQ.dI(j);
                    QuickVideoView.this.bTm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWQ.bTe();
                        QuickVideoView.this.bTp();
                    }
                }
                if (QuickVideoView.this.hXg && (AU = y.bTS().AU(QuickVideoView.this.hXd)) > 0) {
                    if (QuickVideoView.this.hWH.isPlayerReuse()) {
                        if (QuickVideoView.this.hWH.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AU);
                        }
                    } else {
                        QuickVideoView.this.xp(AU);
                    }
                }
                if (QuickVideoView.this.hWP) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWF != null && gVar != null) {
                    QuickVideoView.this.hWF.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWS);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWG) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWG);
                }
                if (QuickVideoView.this.hWY != null && QuickVideoView.this.hWY.bUo()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXz = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.zb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWM = null;
                }
                if (!QuickVideoView.this.hWT || QuickVideoView.this.hWQ == null) {
                    if (QuickVideoView.this.hWQ != null) {
                        QuickVideoView.this.hWQ.onCompletion();
                    }
                    QuickVideoView.this.hWP = false;
                    y.bTS().remove(QuickVideoView.this.hXd);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWO = null;
                QuickVideoView.this.hXe = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWQ.bSY());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ac(i, i2, i3);
                QuickVideoView.this.bTn();
                if (QuickVideoView.this.hWQ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTq()) {
                    QuickVideoView.this.hXf = true;
                    y.bTS().bj(QuickVideoView.this.hXd, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWM != null) {
                        QuickVideoView.this.hWO = QuickVideoView.this.hWM.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hXe, QuickVideoView.this.Z(QuickVideoView.this.hWM.bEq(), i3 + "", QuickVideoView.this.hWM.bEr()));
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.hXe = 0L;
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
        this.hXA = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (QuickVideoView.this.hXf) {
                    QuickVideoView.this.hXf = false;
                    return;
                }
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.bTC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWQ != null && z) {
                    QuickVideoView.this.hWQ.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.hWI != null) {
                    QuickVideoView.this.hWI.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.hWS = i2;
                    if (QuickVideoView.this.hWF != null && gVar != null) {
                        QuickVideoView.this.hWF.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWS);
                    }
                }
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.a(i, i2, QuickVideoView.this.hWM);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.h(i, i2, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.zd(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hXe = j;
                }
            }
        };
        this.hXB = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWQ != null && QuickVideoView.this.hWQ.bTa() && QuickVideoView.this.hWQ.bTb() && QuickVideoView.this.hWQ.bTc() && QuickVideoView.this.hWH != null) {
                    int avk = QuickVideoView.this.hWH.avk();
                    int currentPosition = QuickVideoView.this.hWH.getCurrentPosition();
                    int duration = QuickVideoView.this.hWH.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXh;
                    boolean z = currentPosition + avk < duration;
                    if (avk < QuickVideoView.this.hWQ.bTd() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.hXh = currentTimeMillis;
                        QuickVideoView.this.hWQ.xn(0);
                    }
                    if (QuickVideoView.this.bTo() && currentPosition == QuickVideoView.this.hXi && j > 500) {
                        QuickVideoView.this.hXh = currentTimeMillis;
                        QuickVideoView.this.hWQ.xn(0);
                    }
                    QuickVideoView.this.hXi = currentPosition;
                    if (QuickVideoView.this.hHb == QuickVideoView.hXm) {
                        QuickVideoView.this.bTp();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWQ != null) {
                        QuickVideoView.this.hWQ.bTg();
                    }
                    if (QuickVideoView.this.hWM != null) {
                        QuickVideoView.this.hWM.za(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.bTn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWP = false;
        this.hWR = false;
        this.hWS = 0;
        this.hWT = false;
        this.hWU = -1;
        this.hWV = false;
        this.hWW = null;
        this.hWX = true;
        this.hXh = 0L;
        this.hXi = 0L;
        this.hHb = hXn;
        this.hXo = 0;
        this.hXp = 0;
        this.hXq = -1;
        this.hXr = 0;
        this.hXs = 0;
        this.hXt = 0;
        this.cNW = 0;
        this.hXu = false;
        this.bty = null;
        this.hXv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWH != null && QuickVideoView.this.hWP) {
                    QuickVideoView.this.b(QuickVideoView.this.hWH, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.hXw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.mt(false);
                }
            }
        };
        this.hXx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.hXu) {
                    QuickVideoView.this.hXu = false;
                    QuickVideoView.this.hWH.c(surfaceTexture);
                } else if (QuickVideoView.this.hWR || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.hWH != null && QuickVideoView.this.hWV) {
                        QuickVideoView.this.hWH.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.hWU);
                        if (QuickVideoView.this.hWm != null) {
                            QuickVideoView.this.hWm.bSX();
                        }
                        if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.hWM.bEm();
                        }
                    }
                } else if (bTs()) {
                    if (QuickVideoView.this.hWH != null) {
                        QuickVideoView.this.bTl();
                        QuickVideoView.this.hWR = true;
                        QuickVideoView.this.hWH.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ie, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.o(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.hWM.bEl();
                    }
                }
                QuickVideoView.this.hWW = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.hXu) {
                    QuickVideoView.this.bTn();
                    QuickVideoView.this.pb(false);
                    if (QuickVideoView.this.hWH != null) {
                        if (QuickVideoView.this.hWH.isPlaying() && QuickVideoView.this.bTq()) {
                            y.bTS().bj(QuickVideoView.this.hXd, QuickVideoView.this.hWH.getCurrentPosition());
                        }
                        QuickVideoView.this.hWH.release();
                    }
                    if (QuickVideoView.this.hWR) {
                        if (QuickVideoView.this.hWQ != null) {
                            QuickVideoView.this.hWQ.onStop();
                        }
                        if (QuickVideoView.this.cAt != null) {
                            QuickVideoView.this.cAt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.hWW = null;
                    if (QuickVideoView.this.hWM != null && QuickVideoView.this.hWM.zc(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.hWR = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bTs() {
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
        this.hXy = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int AU;
                QuickVideoView.this.bTn();
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.onPrepared();
                }
                if (QuickVideoView.this.hWM != null && QuickVideoView.this.hWH != null) {
                    QuickVideoView.this.hWM.vF(QuickVideoView.this.hWH.getPlayerType());
                }
                if (QuickVideoView.this.cJJ != null) {
                    QuickVideoView.this.cJJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.hWQ != null) {
                    long j = 0;
                    if (QuickVideoView.this.hWH != null) {
                        j = QuickVideoView.this.hWH.getDuration();
                    }
                    QuickVideoView.this.hWQ.dI(j);
                    QuickVideoView.this.bTm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.hWQ.bTe();
                        QuickVideoView.this.bTp();
                    }
                }
                if (QuickVideoView.this.hXg && (AU = y.bTS().AU(QuickVideoView.this.hXd)) > 0) {
                    if (QuickVideoView.this.hWH.isPlayerReuse()) {
                        if (QuickVideoView.this.hWH.getCurrentPosition() == 0) {
                            QuickVideoView.this.xp(AU);
                        }
                    } else {
                        QuickVideoView.this.xp(AU);
                    }
                }
                if (QuickVideoView.this.hWP) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.hWF != null && gVar != null) {
                    QuickVideoView.this.hWF.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWS);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.hWG) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.c(QuickVideoView.this.mUri, QuickVideoView.this.hWG);
                }
                if (QuickVideoView.this.hWY != null && QuickVideoView.this.hWY.bUo()) {
                    com.baidu.tieba.play.b.e.xw(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.hXz = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pb(true);
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.zb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.hWM = null;
                }
                if (!QuickVideoView.this.hWT || QuickVideoView.this.hWQ == null) {
                    if (QuickVideoView.this.hWQ != null) {
                        QuickVideoView.this.hWQ.onCompletion();
                    }
                    QuickVideoView.this.hWP = false;
                    y.bTS().remove(QuickVideoView.this.hXd);
                    if (QuickVideoView.this.cJI != null) {
                        QuickVideoView.this.cJI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.hWO = null;
                QuickVideoView.this.hXe = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.hWQ.bSY());
                QuickVideoView.this.start();
            }
        };
        this.cJK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ac(i2, i22, i3);
                QuickVideoView.this.bTn();
                if (QuickVideoView.this.hWQ != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bTq()) {
                    QuickVideoView.this.hXf = true;
                    y.bTS().bj(QuickVideoView.this.hXd, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kY()) {
                    if (QuickVideoView.this.hWM != null) {
                        QuickVideoView.this.hWO = QuickVideoView.this.hWM.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.hXe, QuickVideoView.this.Z(QuickVideoView.this.hWM.bEq(), i3 + "", QuickVideoView.this.hWM.bEr()));
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.hXe = 0L;
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
        this.hXA = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0295g
            public void b(g gVar) {
                if (QuickVideoView.this.hXf) {
                    QuickVideoView.this.hXf = false;
                    return;
                }
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.bTC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.hWQ != null && z) {
                    QuickVideoView.this.hWQ.onSeekComplete();
                }
                if (QuickVideoView.this.cJM != null) {
                    QuickVideoView.this.cJM.b(gVar);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.hWI != null) {
                    QuickVideoView.this.hWI.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.hWS = i22;
                    if (QuickVideoView.this.hWF != null && gVar != null) {
                        QuickVideoView.this.hWF.ab(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.hWS);
                    }
                }
                if (QuickVideoView.this.hWZ != null) {
                    QuickVideoView.this.hWZ.a(i2, i22, QuickVideoView.this.hWM);
                    return true;
                }
                return true;
            }
        };
        this.cJN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.h(i2, i22, str);
                }
            }
        };
        this.cJO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.hWM != null) {
                    QuickVideoView.this.hWM.zd(str);
                }
            }
        };
        this.cJP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.hXe = j;
                }
            }
        };
        this.hXB = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.hWQ != null && QuickVideoView.this.hWQ.bTa() && QuickVideoView.this.hWQ.bTb() && QuickVideoView.this.hWQ.bTc() && QuickVideoView.this.hWH != null) {
                    int avk = QuickVideoView.this.hWH.avk();
                    int currentPosition = QuickVideoView.this.hWH.getCurrentPosition();
                    int duration = QuickVideoView.this.hWH.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.hXh;
                    boolean z = currentPosition + avk < duration;
                    if (avk < QuickVideoView.this.hWQ.bTd() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.hXh = currentTimeMillis;
                        QuickVideoView.this.hWQ.xn(0);
                    }
                    if (QuickVideoView.this.bTo() && currentPosition == QuickVideoView.this.hXi && j > 500) {
                        QuickVideoView.this.hXh = currentTimeMillis;
                        QuickVideoView.this.hWQ.xn(0);
                    }
                    QuickVideoView.this.hXi = currentPosition;
                    if (QuickVideoView.this.hHb == QuickVideoView.hXm) {
                        QuickVideoView.this.bTp();
                    }
                }
            }
        };
        this.cJW = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.hWQ != null) {
                        QuickVideoView.this.hWQ.bTg();
                    }
                    if (QuickVideoView.this.hWM != null) {
                        QuickVideoView.this.hWM.za(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.hWM = null;
                    }
                    QuickVideoView.this.bTn();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.hWF = new RenderView(context);
        this.bty = new WeakReference<>(TbadkCoreApplication.getInst());
        this.hWF.setSurfaceTextureListener(this.hXx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.hWX) {
            addView(this.hWF, layoutParams);
        } else {
            addView(this.hWF, 0, layoutParams);
        }
        if (hWK != null) {
            this.hWH = hWK.avm();
        }
        if (this.hWH != null) {
            this.hWH.setOnPreparedListener(this.hXy);
            this.hWH.setOnCompletionListener(this.hXz);
            this.hWH.a(this.cJK);
            this.hWH.setOnSeekCompleteListener(this.hXA);
            this.hWH.a(this.cJL);
            this.hWH.a(this.cJN);
            this.hWH.a(this.cJO);
            this.hWH.a(this.cJP);
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
        this.hWY = new com.baidu.tieba.play.b.a(this);
        this.hWZ = new r();
        this.hXa = new com.baidu.tieba.play.b.f();
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
        this.hXg = z;
    }

    public void setVideoPath(String str, String str2) {
        this.ctx = str2;
        if (this.hWY != null) {
            this.hWY.clear();
            this.hWY.bUo();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.AZ(str2);
            if (hWL != null) {
                this.hWM = hWL.X(this.ctx, str, "");
                if (this.hWM != null) {
                    this.hWM.a(-300, -44399, -44399, getLocateSource(), false, this.hXe, "");
                    this.hWM = null;
                }
            }
        }
        if (this.hWN != null) {
            this.hWN.a(null);
            this.hWN.bEe();
            this.hWN = null;
        }
        this.hWO = null;
        this.hXe = 0L;
        setVideoPath(str);
    }

    public void dE(String str, String str2) {
    }

    private String AQ(String str) {
        if (!ap.isEmpty(str) && com.baidu.tieba.video.g.ciC().ciD()) {
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
            String AQ = AQ(str);
            this.hXb = AQ;
            if (this.hWQ != null) {
                AQ = this.hWQ.qC(AQ);
                if (this.hWQ.bTf() != null) {
                    this.hWQ.bTf().setPlayer(this);
                }
                if (hWL != null && oc(AQ)) {
                    this.hWN = hWL.zg(AQ);
                }
                if (this.hWN != null) {
                    this.hWN.a(new com.baidu.tieba.play.monitor.a(this.ctx, this.hXb, this.hWM));
                    this.hWN.bEd();
                }
                AR(AQ);
            }
            if (!com.baidu.adp.lib.util.j.kY() && !oc(AQ)) {
                if (this.cAp != null) {
                    this.cAp.onError(this.hWH, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(AQ));
            if (this.hWM != null) {
                if (o(Uri.parse(AQ)) != null) {
                    this.hWM.bEk();
                }
                this.hWM.Kq();
                this.hWM = null;
            }
            this.hXc = str;
            int lastIndexOf = this.hXc.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.hXc.length() > 4) {
                this.hXd = this.hXc.substring(0, lastIndexOf + 4);
            } else {
                this.hXd = this.hXc;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTl() {
        if (com.baidu.tbadk.coreExtra.model.f.ajH()) {
            if (this.hWQ != null && (this.hWQ.bSZ() || this.hWQ.bTa())) {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXv);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hXv, com.baidu.tbadk.coreExtra.model.f.ajG());
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXw, com.baidu.tbadk.coreExtra.model.f.ajF());
        }
    }

    public void bSB() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (o(uri) != null) {
            this.hWM.yZ(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            avg();
        }
        this.mUri = uri;
        this.Ie = map;
        this.hWS = 0;
        if (this.hWW != null) {
            bTl();
            if (this.hWH != null) {
                if (!this.hWR) {
                    this.hWR = true;
                    this.hWH.a(this.mContext, this.mUri, this.Ie, this.hWW, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.hXy.onPrepared(this.hWH);
                }
            }
        } else if (this.hWF != null && this.hWF.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.hWX) {
                addView(this.hWF, layoutParams);
            } else {
                addView(this.hWF, 0, layoutParams);
            }
        }
        al.k(this, d.C0236d.cp_bg_line_k);
    }

    private void avg() {
        this.hWR = false;
        this.hWP = false;
        if (this.hWH != null) {
            if (this.hWH.isPlaying() && bTq()) {
                y.bTS().bj(this.hXd, this.hWH.getCurrentPosition());
            }
            this.hWH.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXB);
    }

    private void AR(String str) {
        this.hXp = 0;
        this.hXq = 0;
        this.hXr = 0;
        this.hXs = 0;
        this.hXt = 0;
        this.cNW = 0;
        if (this.hWQ.bTa()) {
            this.hXo = hXk;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.hXq = (int) u.AT(QuickVideoView.this.hXb);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.hXb != null && this.hXb.equals(str)) {
            this.hXo = hXj;
        } else {
            this.hXo = hXl;
        }
        this.hHb = hXm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTm() {
        this.hHb = hXm;
        if (this.hWH != null) {
            this.hXp = this.hWH.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
        if (this.hHb == hXm && this.hWH != null) {
            this.hHb = hXn;
            this.hXs = this.hWH.getDuration();
            if (z) {
                this.hXt = 0;
                this.hXr = this.hXs;
            } else {
                this.hXr = this.hWH.getCurrentPosition();
                this.hXt = this.hWH.getCachedSize();
            }
            if (this.hXr > 0) {
                if (this.hXo == hXj) {
                    this.hXq = (int) u.AT(this.hXb);
                    if (this.hXp > 0) {
                        long j = (this.hXp * (this.hXr / 1000)) / 8;
                        if (this.hXt < 0) {
                            this.hXt = 0;
                        }
                        long j2 = this.hXt + j;
                        if (this.hXq > 0) {
                            j2 += this.hXq;
                        }
                        setFlowCount(j2, this.hXr, this.hXs, this.cNW);
                    } else if (this.hXp == -1) {
                        this.hXp = 603327;
                        setFlowCount((this.hXp * (this.hXr / 1000)) / 8, this.hXr, this.hXs, this.cNW);
                    }
                } else if (this.hXo == hXk) {
                    if (this.hXp > 0) {
                        long j3 = (this.hXp * (this.hXr / 1000)) / 8;
                        if (this.hXt < 0) {
                            this.hXt = 0;
                        }
                        long j4 = this.hXt + j3;
                        if (this.hXq > 0) {
                            j4 -= this.hXq;
                        }
                        setFlowCount(j4, this.hXr, this.hXs, this.cNW);
                    } else if (this.hXp == -1) {
                        this.hXp = 603327;
                        setFlowCount((this.hXp * (this.hXr / 1000)) / 8, this.hXr, this.hXs, this.cNW);
                    }
                } else {
                    setFlowCount(0L, this.hXr, this.hXs, this.cNW);
                }
            }
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXB);
    }

    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ad.a(this.bty, false);
        }
        bTn();
        pb(false);
        if (this.hWY != null) {
            this.hWY.clear();
        }
        this.hWG = null;
        avg();
        this.hWT = false;
        if (this.hWQ != null) {
            this.hWQ.onStop();
        }
        com.baidu.tieba.play.a.b.bTV().a((b.InterfaceC0292b) null);
        if (this.hWM != null && this.hWM.zc(getLocateSource())) {
            this.hWM = null;
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXB);
    }

    public void setFullScreenToDestroySurface() {
        this.hXu = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTn() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXv);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXw);
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
        if (this.hXa == null) {
            return "";
        }
        String bUq = this.hXa.bUq();
        this.hXa.aa(str, str2, str3);
        return bUq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.hWQ != null && !StringUtils.isNull(this.hWQ.bSY())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.AY(uri);
                }
            }
            this.mUri = Uri.parse(this.hWQ.bSY());
        }
        boolean z = false;
        if (this.hWY != null) {
            z = this.hWY.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.hWM != null) {
            this.hWO = this.hWM.a(i, i2, i3, getLocateSource(), z, this.hXe, Z(this.hWM.bEq(), i3 + "", this.hWM.bEr()));
            this.hWM = null;
        }
        this.hXe = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.hWH != null) {
            try {
                if (this.hWH.isPlaying() && bTq()) {
                    y.bTS().bj(this.hXd, this.hWH.getCurrentPosition());
                }
                this.hWH.release();
                this.hWG = str;
                URI uri = new URI(this.mUri.toString());
                this.hWH.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Ie, this.hWW, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (o(this.mUri) != null) {
                    this.hWM.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWH != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.hWH.isPlaying() && bTq()) {
                y.bTS().bj(this.hXd, this.hWH.getCurrentPosition());
            }
            this.hWH.release();
            this.hWH.a(this.mContext, this.mUri, this.Ie, this.hWW, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWM.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.hWH != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.hWH.forceUseSystemMediaPlayer(true);
            }
            if (this.hWH.isPlaying() && bTq()) {
                y.bTS().bj(this.hXd, this.hWH.getCurrentPosition());
            }
            this.hWH.release();
            this.hWH.a(this.mContext, this.mUri, this.Ie, this.hWW, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (o(this.mUri) != null) {
                this.hWM.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.hWP = true;
        if (this.hWH != null) {
            if (this.hWW != null && this.hWV && !this.hWH.isExistInRemote()) {
                this.hWH.a(this.mContext, this.mUri, this.Ie, this.hWW, this.hWU);
                if (this.hWm != null) {
                    this.hWm.bSX();
                }
                if (o(this.mUri) != null) {
                    this.hWM.bEm();
                }
                bTl();
                return;
            }
            if (!this.hWH.avl()) {
                ad.a(this.bty, true);
                this.hWH.setVolume(1.0f, 1.0f);
            }
            this.hWH.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.hWQ != null) {
            this.hWQ.onStart();
        }
        if (this.hWJ != null) {
            this.hWJ.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (o(this.mUri) != null && this.hWH != null) {
            this.hWM.vG(this.hWH.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bTn();
        ad.a(this.bty, false);
        if (this.hWH != null) {
            if (this.hWH.isPlaying() && bTq()) {
                y.bTS().bj(this.hXd, this.hWH.getCurrentPosition());
            }
            this.hWH.pause();
        }
        if (this.hWQ != null) {
            this.hWQ.onPause();
        }
        this.hWP = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWM != null) {
            this.hWM.bEp();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.hWH != null) {
            return this.hWH.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.hWH != null) {
            return this.hWH.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cNW = i;
        xp(i);
    }

    public void xp(int i) {
        if (this.hWZ != null) {
            this.hWZ.bTB();
        }
        if (this.hWH != null) {
            this.hWH.seekTo(i);
        }
        if (this.hWQ != null) {
            this.hWQ.xn(0);
            bTp();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.hWH != null) {
            return this.hWH.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.hWH != null) {
            this.hWH.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.hWU = i;
    }

    public int getRecoveryState() {
        return this.hWU;
    }

    public void setNeedRecovery(boolean z) {
        this.hWV = z;
    }

    public void setLooping(boolean z) {
        this.hWT = z;
    }

    public boolean bTo() {
        return this.hWP;
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
        this.hWQ = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cJW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hWT = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.hWH != null) {
            this.hWH.aqk();
        }
        if (this.hWZ != null) {
            this.hWZ.bTD();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXB);
        MessageManager.getInstance().unRegisterListener(this.cJW);
        if (this.hWY != null) {
            this.hWY.clear();
        }
        if (this.hWN != null) {
            this.hWN.a(null);
            this.hWN.bEe();
        }
    }

    public g getPlayer() {
        return this.hWH;
    }

    public int getPlayerType() {
        if (this.hWH == null) {
            return -300;
        }
        return this.hWH.getPlayerType();
    }

    public void bTp() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXB);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXB, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.hWm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.hWQ instanceof n) || ((n) this.hWQ).bTz() == null) ? "" : ((n) this.hWQ).bTz().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i o(Uri uri) {
        String uri2;
        if (this.hWM != null) {
            return this.hWM;
        }
        if (!StringUtils.isNull(this.hXb)) {
            uri2 = this.hXb;
        } else if (hWL != null && this.hWQ != null && !StringUtils.isNull(this.hWQ.bSY())) {
            uri2 = this.hWQ.bSY();
        } else {
            uri2 = (hWL == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && hWL != null) {
            this.hWM = hWL.X(this.ctx, uri2, this.hWO);
        }
        this.hWO = null;
        this.hXe = 0L;
        return this.hWM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTq() {
        return this.hWH != null && this.hWH.getDuration() >= this.hWH.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.hWM, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.hWM, j);
    }

    public static boolean oc(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.hWI = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.hWH != null) {
            return this.hWH.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.hWH != null ? this.hWH.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.hWM != null) {
            this.hWM.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.hWJ = cVar;
    }
}
