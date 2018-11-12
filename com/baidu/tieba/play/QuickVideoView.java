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
    private static h gvR;
    private static com.baidu.tieba.j.l gvS;
    private static int gwq = 0;
    private static int gwr = 1;
    private static int gws = 2;
    private static int gwt = 1;
    private static int gwu = 0;
    private String beV;
    private b blC;
    private g.b bly;
    private g.a bul;
    private g.f bum;
    private g.c bun;
    private g.e buo;
    private g.InterfaceC0287g bup;
    private g.i buq;
    private g.d bur;
    private g.h bus;
    private final CustomMessageListener buy;
    private int byB;
    private int gfY;
    private RenderView gvM;
    private String gvN;
    private g gvO;
    private g.e gvP;
    private c gvQ;
    private com.baidu.tieba.j.i gvT;
    private com.baidu.tieba.j.e gvU;
    private String gvV;
    private boolean gvW;
    private d gvX;
    private boolean gvY;
    private int gvZ;
    private a gvu;
    private int gwA;
    private boolean gwB;
    private Runnable gwC;
    private Runnable gwD;
    private TextureView.SurfaceTextureListener gwE;
    private g.f gwF;
    private g.a gwG;
    private g.InterfaceC0287g gwH;
    private Runnable gwI;
    private boolean gwa;
    private int gwb;
    private boolean gwc;
    private SurfaceTexture gwd;
    private boolean gwe;
    private com.baidu.tieba.play.b.a gwf;
    private r gwg;
    private com.baidu.tieba.play.b.f gwh;
    private String gwi;
    private String gwj;
    private String gwk;
    private long gwl;
    private boolean gwm;
    private boolean gwn;
    private long gwo;
    private long gwp;
    private int gwv;
    private int gww;
    private int gwx;
    private int gwy;
    private int gwz;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bpq();
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
            gvR = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gvS = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gwe = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gvW = false;
        this.gvY = false;
        this.gvZ = 0;
        this.gwa = false;
        this.gwb = -1;
        this.gwc = false;
        this.gwd = null;
        this.gwe = true;
        this.gwo = 0L;
        this.gwp = 0L;
        this.gfY = gwu;
        this.gwv = 0;
        this.gww = 0;
        this.gwx = -1;
        this.gwy = 0;
        this.gwz = 0;
        this.gwA = 0;
        this.byB = 0;
        this.gwB = false;
        this.gwC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gvO != null && QuickVideoView.this.gvW) {
                    QuickVideoView.this.b(QuickVideoView.this.gvO, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gwD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.jM(false);
                }
            }
        };
        this.gwE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gwB) {
                    QuickVideoView.this.gwB = false;
                    QuickVideoView.this.gvO.c(surfaceTexture);
                } else if (QuickVideoView.this.gvY || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gvO != null && QuickVideoView.this.gwc) {
                        QuickVideoView.this.gvO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gwb);
                        if (QuickVideoView.this.gvu != null) {
                            QuickVideoView.this.gvu.bpq();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gvT.baF();
                        }
                    }
                } else if (bpK()) {
                    if (QuickVideoView.this.gvO != null) {
                        QuickVideoView.this.bpD();
                        QuickVideoView.this.gvY = true;
                        QuickVideoView.this.gvO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gvT.baE();
                    }
                }
                QuickVideoView.this.gwd = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gwB) {
                    QuickVideoView.this.bpF();
                    QuickVideoView.this.mx(false);
                    if (QuickVideoView.this.gvO != null) {
                        if (QuickVideoView.this.gvO.isPlaying() && QuickVideoView.this.bpI()) {
                            y.bqk().aM(QuickVideoView.this.gwk, QuickVideoView.this.gvO.getCurrentPosition());
                        }
                        QuickVideoView.this.gvO.release();
                    }
                    if (QuickVideoView.this.gvY) {
                        if (QuickVideoView.this.gvX != null) {
                            QuickVideoView.this.gvX.onStop();
                        }
                        if (QuickVideoView.this.blC != null) {
                            QuickVideoView.this.blC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gwd = null;
                    if (QuickVideoView.this.gvT != null && QuickVideoView.this.gvT.rD(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.gvY = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bpK() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gwF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tu;
                QuickVideoView.this.bpF();
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.onPrepared();
                }
                if (QuickVideoView.this.gvT != null && QuickVideoView.this.gvO != null) {
                    QuickVideoView.this.gvT.rn(QuickVideoView.this.gvO.getPlayerType());
                }
                if (QuickVideoView.this.bum != null) {
                    QuickVideoView.this.bum.onPrepared(gVar);
                }
                if (QuickVideoView.this.gvX != null) {
                    long j = 0;
                    if (QuickVideoView.this.gvO != null) {
                        j = QuickVideoView.this.gvO.getDuration();
                    }
                    QuickVideoView.this.gvX.cR(j);
                    QuickVideoView.this.bpE();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gvX.bpx();
                        QuickVideoView.this.bpH();
                    }
                }
                if (QuickVideoView.this.gwn && (tu = y.bqk().tu(QuickVideoView.this.gwk)) > 0) {
                    if (QuickVideoView.this.gvO.isPlayerReuse()) {
                        if (QuickVideoView.this.gvO.getCurrentPosition() == 0) {
                            QuickVideoView.this.sU(tu);
                        }
                    } else {
                        QuickVideoView.this.sU(tu);
                    }
                }
                if (QuickVideoView.this.gvW) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gvM != null && gVar != null) {
                    QuickVideoView.this.gvM.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gvZ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gvN) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gvN);
                }
                if (QuickVideoView.this.gwf != null && QuickVideoView.this.gwf.bqq()) {
                    com.baidu.tieba.play.b.e.sY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gwG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mx(true);
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.rC(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gvT = null;
                }
                if (!QuickVideoView.this.gwa || QuickVideoView.this.gvX == null) {
                    if (QuickVideoView.this.gvX != null) {
                        QuickVideoView.this.gvX.onCompletion();
                    }
                    QuickVideoView.this.gvW = false;
                    if (QuickVideoView.this.bul != null) {
                        QuickVideoView.this.bul.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gvV = null;
                QuickVideoView.this.gwl = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gvX.bpr());
                QuickVideoView.this.start();
            }
        };
        this.bun = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bpF();
                if (QuickVideoView.this.gvX != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bpI()) {
                    QuickVideoView.this.gwm = true;
                    y.bqk().aM(QuickVideoView.this.gwk, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gvT != null) {
                        QuickVideoView.this.gvV = QuickVideoView.this.gvT.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gwl, QuickVideoView.this.M(QuickVideoView.this.gvT.baJ(), i3 + "", QuickVideoView.this.gvT.baK()));
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.gwl = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.sW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bly == null || QuickVideoView.this.bly.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gwH = new g.InterfaceC0287g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0287g
            public void b(g gVar) {
                if (QuickVideoView.this.gwm) {
                    QuickVideoView.this.gwm = false;
                    return;
                }
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.bpU();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gvX != null && z) {
                    QuickVideoView.this.gvX.onSeekComplete();
                }
                if (QuickVideoView.this.bup != null) {
                    QuickVideoView.this.bup.b(gVar);
                }
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gvP != null) {
                    QuickVideoView.this.gvP.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gvZ = i2;
                    if (QuickVideoView.this.gvM != null && gVar != null) {
                        QuickVideoView.this.gvM.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gvZ);
                    }
                }
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.a(i, i2, QuickVideoView.this.gvT);
                    return true;
                }
                return true;
            }
        };
        this.buq = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.f(i, i2, str);
                }
            }
        };
        this.bur = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.rE(str);
                }
            }
        };
        this.bus = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gwl = j;
                }
            }
        };
        this.gwI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gvX != null && QuickVideoView.this.gvX.bpt() && QuickVideoView.this.gvX.bpu() && QuickVideoView.this.gvX.bpv() && QuickVideoView.this.gvO != null) {
                    int TH = QuickVideoView.this.gvO.TH();
                    int currentPosition = QuickVideoView.this.gvO.getCurrentPosition();
                    int duration = QuickVideoView.this.gvO.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gwo;
                    boolean z = currentPosition + TH < duration;
                    if (TH < QuickVideoView.this.gvX.bpw() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gwo = currentTimeMillis;
                        QuickVideoView.this.gvX.sT(0);
                    }
                    if (QuickVideoView.this.bpG() && currentPosition == QuickVideoView.this.gwp && j > 500) {
                        QuickVideoView.this.gwo = currentTimeMillis;
                        QuickVideoView.this.gvX.sT(0);
                    }
                    QuickVideoView.this.gwp = currentPosition;
                    if (QuickVideoView.this.gfY == QuickVideoView.gwt) {
                        QuickVideoView.this.bpH();
                    }
                }
            }
        };
        this.buy = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gvX != null) {
                        QuickVideoView.this.gvX.bpz();
                    }
                    if (QuickVideoView.this.gvT != null) {
                        QuickVideoView.this.gvT.rB(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.bpF();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvW = false;
        this.gvY = false;
        this.gvZ = 0;
        this.gwa = false;
        this.gwb = -1;
        this.gwc = false;
        this.gwd = null;
        this.gwe = true;
        this.gwo = 0L;
        this.gwp = 0L;
        this.gfY = gwu;
        this.gwv = 0;
        this.gww = 0;
        this.gwx = -1;
        this.gwy = 0;
        this.gwz = 0;
        this.gwA = 0;
        this.byB = 0;
        this.gwB = false;
        this.gwC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gvO != null && QuickVideoView.this.gvW) {
                    QuickVideoView.this.b(QuickVideoView.this.gvO, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gwD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.jM(false);
                }
            }
        };
        this.gwE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gwB) {
                    QuickVideoView.this.gwB = false;
                    QuickVideoView.this.gvO.c(surfaceTexture);
                } else if (QuickVideoView.this.gvY || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gvO != null && QuickVideoView.this.gwc) {
                        QuickVideoView.this.gvO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gwb);
                        if (QuickVideoView.this.gvu != null) {
                            QuickVideoView.this.gvu.bpq();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gvT.baF();
                        }
                    }
                } else if (bpK()) {
                    if (QuickVideoView.this.gvO != null) {
                        QuickVideoView.this.bpD();
                        QuickVideoView.this.gvY = true;
                        QuickVideoView.this.gvO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gvT.baE();
                    }
                }
                QuickVideoView.this.gwd = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gwB) {
                    QuickVideoView.this.bpF();
                    QuickVideoView.this.mx(false);
                    if (QuickVideoView.this.gvO != null) {
                        if (QuickVideoView.this.gvO.isPlaying() && QuickVideoView.this.bpI()) {
                            y.bqk().aM(QuickVideoView.this.gwk, QuickVideoView.this.gvO.getCurrentPosition());
                        }
                        QuickVideoView.this.gvO.release();
                    }
                    if (QuickVideoView.this.gvY) {
                        if (QuickVideoView.this.gvX != null) {
                            QuickVideoView.this.gvX.onStop();
                        }
                        if (QuickVideoView.this.blC != null) {
                            QuickVideoView.this.blC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gwd = null;
                    if (QuickVideoView.this.gvT != null && QuickVideoView.this.gvT.rD(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.gvY = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bpK() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gwF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tu;
                QuickVideoView.this.bpF();
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.onPrepared();
                }
                if (QuickVideoView.this.gvT != null && QuickVideoView.this.gvO != null) {
                    QuickVideoView.this.gvT.rn(QuickVideoView.this.gvO.getPlayerType());
                }
                if (QuickVideoView.this.bum != null) {
                    QuickVideoView.this.bum.onPrepared(gVar);
                }
                if (QuickVideoView.this.gvX != null) {
                    long j = 0;
                    if (QuickVideoView.this.gvO != null) {
                        j = QuickVideoView.this.gvO.getDuration();
                    }
                    QuickVideoView.this.gvX.cR(j);
                    QuickVideoView.this.bpE();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gvX.bpx();
                        QuickVideoView.this.bpH();
                    }
                }
                if (QuickVideoView.this.gwn && (tu = y.bqk().tu(QuickVideoView.this.gwk)) > 0) {
                    if (QuickVideoView.this.gvO.isPlayerReuse()) {
                        if (QuickVideoView.this.gvO.getCurrentPosition() == 0) {
                            QuickVideoView.this.sU(tu);
                        }
                    } else {
                        QuickVideoView.this.sU(tu);
                    }
                }
                if (QuickVideoView.this.gvW) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gvM != null && gVar != null) {
                    QuickVideoView.this.gvM.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gvZ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gvN) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gvN);
                }
                if (QuickVideoView.this.gwf != null && QuickVideoView.this.gwf.bqq()) {
                    com.baidu.tieba.play.b.e.sY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gwG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mx(true);
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.rC(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gvT = null;
                }
                if (!QuickVideoView.this.gwa || QuickVideoView.this.gvX == null) {
                    if (QuickVideoView.this.gvX != null) {
                        QuickVideoView.this.gvX.onCompletion();
                    }
                    QuickVideoView.this.gvW = false;
                    if (QuickVideoView.this.bul != null) {
                        QuickVideoView.this.bul.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gvV = null;
                QuickVideoView.this.gwl = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gvX.bpr());
                QuickVideoView.this.start();
            }
        };
        this.bun = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bpF();
                if (QuickVideoView.this.gvX != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bpI()) {
                    QuickVideoView.this.gwm = true;
                    y.bqk().aM(QuickVideoView.this.gwk, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gvT != null) {
                        QuickVideoView.this.gvV = QuickVideoView.this.gvT.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gwl, QuickVideoView.this.M(QuickVideoView.this.gvT.baJ(), i3 + "", QuickVideoView.this.gvT.baK()));
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.gwl = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.sW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bly == null || QuickVideoView.this.bly.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gwH = new g.InterfaceC0287g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0287g
            public void b(g gVar) {
                if (QuickVideoView.this.gwm) {
                    QuickVideoView.this.gwm = false;
                    return;
                }
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.bpU();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gvX != null && z) {
                    QuickVideoView.this.gvX.onSeekComplete();
                }
                if (QuickVideoView.this.bup != null) {
                    QuickVideoView.this.bup.b(gVar);
                }
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gvP != null) {
                    QuickVideoView.this.gvP.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gvZ = i2;
                    if (QuickVideoView.this.gvM != null && gVar != null) {
                        QuickVideoView.this.gvM.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gvZ);
                    }
                }
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.a(i, i2, QuickVideoView.this.gvT);
                    return true;
                }
                return true;
            }
        };
        this.buq = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.f(i, i2, str);
                }
            }
        };
        this.bur = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.rE(str);
                }
            }
        };
        this.bus = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gwl = j;
                }
            }
        };
        this.gwI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gvX != null && QuickVideoView.this.gvX.bpt() && QuickVideoView.this.gvX.bpu() && QuickVideoView.this.gvX.bpv() && QuickVideoView.this.gvO != null) {
                    int TH = QuickVideoView.this.gvO.TH();
                    int currentPosition = QuickVideoView.this.gvO.getCurrentPosition();
                    int duration = QuickVideoView.this.gvO.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gwo;
                    boolean z = currentPosition + TH < duration;
                    if (TH < QuickVideoView.this.gvX.bpw() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gwo = currentTimeMillis;
                        QuickVideoView.this.gvX.sT(0);
                    }
                    if (QuickVideoView.this.bpG() && currentPosition == QuickVideoView.this.gwp && j > 500) {
                        QuickVideoView.this.gwo = currentTimeMillis;
                        QuickVideoView.this.gvX.sT(0);
                    }
                    QuickVideoView.this.gwp = currentPosition;
                    if (QuickVideoView.this.gfY == QuickVideoView.gwt) {
                        QuickVideoView.this.bpH();
                    }
                }
            }
        };
        this.buy = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gvX != null) {
                        QuickVideoView.this.gvX.bpz();
                    }
                    if (QuickVideoView.this.gvT != null) {
                        QuickVideoView.this.gvT.rB(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.bpF();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvW = false;
        this.gvY = false;
        this.gvZ = 0;
        this.gwa = false;
        this.gwb = -1;
        this.gwc = false;
        this.gwd = null;
        this.gwe = true;
        this.gwo = 0L;
        this.gwp = 0L;
        this.gfY = gwu;
        this.gwv = 0;
        this.gww = 0;
        this.gwx = -1;
        this.gwy = 0;
        this.gwz = 0;
        this.gwA = 0;
        this.byB = 0;
        this.gwB = false;
        this.gwC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gvO != null && QuickVideoView.this.gvW) {
                    QuickVideoView.this.b(QuickVideoView.this.gvO, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gwD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.jM(false);
                }
            }
        };
        this.gwE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gwB) {
                    QuickVideoView.this.gwB = false;
                    QuickVideoView.this.gvO.c(surfaceTexture);
                } else if (QuickVideoView.this.gvY || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gvO != null && QuickVideoView.this.gwc) {
                        QuickVideoView.this.gvO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gwb);
                        if (QuickVideoView.this.gvu != null) {
                            QuickVideoView.this.gvu.bpq();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gvT.baF();
                        }
                    }
                } else if (bpK()) {
                    if (QuickVideoView.this.gvO != null) {
                        QuickVideoView.this.bpD();
                        QuickVideoView.this.gvY = true;
                        QuickVideoView.this.gvO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gvT.baE();
                    }
                }
                QuickVideoView.this.gwd = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gwB) {
                    QuickVideoView.this.bpF();
                    QuickVideoView.this.mx(false);
                    if (QuickVideoView.this.gvO != null) {
                        if (QuickVideoView.this.gvO.isPlaying() && QuickVideoView.this.bpI()) {
                            y.bqk().aM(QuickVideoView.this.gwk, QuickVideoView.this.gvO.getCurrentPosition());
                        }
                        QuickVideoView.this.gvO.release();
                    }
                    if (QuickVideoView.this.gvY) {
                        if (QuickVideoView.this.gvX != null) {
                            QuickVideoView.this.gvX.onStop();
                        }
                        if (QuickVideoView.this.blC != null) {
                            QuickVideoView.this.blC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gwd = null;
                    if (QuickVideoView.this.gvT != null && QuickVideoView.this.gvT.rD(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.gvY = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bpK() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gwF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tu;
                QuickVideoView.this.bpF();
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.onPrepared();
                }
                if (QuickVideoView.this.gvT != null && QuickVideoView.this.gvO != null) {
                    QuickVideoView.this.gvT.rn(QuickVideoView.this.gvO.getPlayerType());
                }
                if (QuickVideoView.this.bum != null) {
                    QuickVideoView.this.bum.onPrepared(gVar);
                }
                if (QuickVideoView.this.gvX != null) {
                    long j = 0;
                    if (QuickVideoView.this.gvO != null) {
                        j = QuickVideoView.this.gvO.getDuration();
                    }
                    QuickVideoView.this.gvX.cR(j);
                    QuickVideoView.this.bpE();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gvX.bpx();
                        QuickVideoView.this.bpH();
                    }
                }
                if (QuickVideoView.this.gwn && (tu = y.bqk().tu(QuickVideoView.this.gwk)) > 0) {
                    if (QuickVideoView.this.gvO.isPlayerReuse()) {
                        if (QuickVideoView.this.gvO.getCurrentPosition() == 0) {
                            QuickVideoView.this.sU(tu);
                        }
                    } else {
                        QuickVideoView.this.sU(tu);
                    }
                }
                if (QuickVideoView.this.gvW) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gvM != null && gVar != null) {
                    QuickVideoView.this.gvM.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gvZ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gvN) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gvN);
                }
                if (QuickVideoView.this.gwf != null && QuickVideoView.this.gwf.bqq()) {
                    com.baidu.tieba.play.b.e.sY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gwG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mx(true);
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.rC(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gvT = null;
                }
                if (!QuickVideoView.this.gwa || QuickVideoView.this.gvX == null) {
                    if (QuickVideoView.this.gvX != null) {
                        QuickVideoView.this.gvX.onCompletion();
                    }
                    QuickVideoView.this.gvW = false;
                    if (QuickVideoView.this.bul != null) {
                        QuickVideoView.this.bul.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gvV = null;
                QuickVideoView.this.gwl = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gvX.bpr());
                QuickVideoView.this.start();
            }
        };
        this.bun = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.bpF();
                if (QuickVideoView.this.gvX != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bpI()) {
                    QuickVideoView.this.gwm = true;
                    y.bqk().aM(QuickVideoView.this.gwk, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gvT != null) {
                        QuickVideoView.this.gvV = QuickVideoView.this.gvT.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gwl, QuickVideoView.this.M(QuickVideoView.this.gvT.baJ(), i3 + "", QuickVideoView.this.gvT.baK()));
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.gwl = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.sW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bly == null || QuickVideoView.this.bly.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gwH = new g.InterfaceC0287g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0287g
            public void b(g gVar) {
                if (QuickVideoView.this.gwm) {
                    QuickVideoView.this.gwm = false;
                    return;
                }
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.bpU();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gvX != null && z) {
                    QuickVideoView.this.gvX.onSeekComplete();
                }
                if (QuickVideoView.this.bup != null) {
                    QuickVideoView.this.bup.b(gVar);
                }
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gvP != null) {
                    QuickVideoView.this.gvP.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gvZ = i22;
                    if (QuickVideoView.this.gvM != null && gVar != null) {
                        QuickVideoView.this.gvM.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gvZ);
                    }
                }
                if (QuickVideoView.this.gwg != null) {
                    QuickVideoView.this.gwg.a(i2, i22, QuickVideoView.this.gvT);
                    return true;
                }
                return true;
            }
        };
        this.buq = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.f(i2, i22, str);
                }
            }
        };
        this.bur = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gvT != null) {
                    QuickVideoView.this.gvT.rE(str);
                }
            }
        };
        this.bus = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gwl = j;
                }
            }
        };
        this.gwI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gvX != null && QuickVideoView.this.gvX.bpt() && QuickVideoView.this.gvX.bpu() && QuickVideoView.this.gvX.bpv() && QuickVideoView.this.gvO != null) {
                    int TH = QuickVideoView.this.gvO.TH();
                    int currentPosition = QuickVideoView.this.gvO.getCurrentPosition();
                    int duration = QuickVideoView.this.gvO.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gwo;
                    boolean z = currentPosition + TH < duration;
                    if (TH < QuickVideoView.this.gvX.bpw() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gwo = currentTimeMillis;
                        QuickVideoView.this.gvX.sT(0);
                    }
                    if (QuickVideoView.this.bpG() && currentPosition == QuickVideoView.this.gwp && j > 500) {
                        QuickVideoView.this.gwo = currentTimeMillis;
                        QuickVideoView.this.gvX.sT(0);
                    }
                    QuickVideoView.this.gwp = currentPosition;
                    if (QuickVideoView.this.gfY == QuickVideoView.gwt) {
                        QuickVideoView.this.bpH();
                    }
                }
            }
        };
        this.buy = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gvX != null) {
                        QuickVideoView.this.gvX.bpz();
                    }
                    if (QuickVideoView.this.gvT != null) {
                        QuickVideoView.this.gvT.rB(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gvT = null;
                    }
                    QuickVideoView.this.bpF();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gvM = new RenderView(context);
        this.gvM.setSurfaceTextureListener(this.gwE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gwe) {
            addView(this.gvM, layoutParams);
        } else {
            addView(this.gvM, 0, layoutParams);
        }
        if (gvR != null) {
            this.gvO = gvR.TI();
        }
        if (this.gvO != null) {
            this.gvO.setOnPreparedListener(this.gwF);
            this.gvO.setOnCompletionListener(this.gwG);
            this.gvO.a(this.bun);
            this.gvO.setOnSeekCompleteListener(this.gwH);
            this.gvO.a(this.buo);
            this.gvO.a(this.buq);
            this.gvO.a(this.bur);
            this.gvO.a(this.bus);
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
        this.gwf = new com.baidu.tieba.play.b.a(this);
        this.gwg = new r();
        this.gwh = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iQ().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.gwn = z;
    }

    public void setVideoPath(String str, String str2) {
        this.beV = str2;
        if (this.gwf != null) {
            this.gwf.clear();
            this.gwf.bqq();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.tz(str2);
            if (gvS != null) {
                this.gvT = gvS.L(this.beV, str, "");
                if (this.gvT != null) {
                    this.gvT.a(ReportLevel.USER, -44399, -44399, getLocateSource(), false, this.gwl, "");
                    this.gvT = null;
                }
            }
        }
        if (this.gvU != null) {
            this.gvU.a(null);
            this.gvU.bax();
            this.gvU = null;
        }
        this.gvV = null;
        this.gwl = 0L;
        setVideoPath(str);
    }

    public void co(String str, String str2) {
    }

    private String tq(String str) {
        if (!ao.isEmpty(str) && com.baidu.tieba.video.g.bFM().bFN()) {
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
            String tq = tq(str);
            this.gwi = tq;
            if (this.gvX != null) {
                tq = this.gvX.ji(tq);
                if (this.gvX.bpy() != null) {
                    this.gvX.bpy().setPlayer(this);
                }
                if (gvS != null && gK(tq)) {
                    this.gvU = gvS.rH(tq);
                }
                if (this.gvU != null) {
                    this.gvU.a(new com.baidu.tieba.play.monitor.a(this.beV, this.gwi, this.gvT));
                    this.gvU.baw();
                }
                tr(tq);
            }
            if (!com.baidu.adp.lib.util.j.kV() && !gK(tq)) {
                if (this.bly != null) {
                    this.bly.onError(this.gvO, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(tq));
            if (this.gvT != null) {
                if (f(Uri.parse(tq)) != null) {
                    this.gvT.baD();
                }
                this.gvT.report();
                this.gvT = null;
            }
            this.gwj = str;
            int lastIndexOf = this.gwj.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.gwj.length() > 4) {
                this.gwk = this.gwj.substring(0, lastIndexOf + 4);
            } else {
                this.gwk = this.gwj;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpD() {
        if (com.baidu.tbadk.coreExtra.model.f.IP()) {
            if (this.gvX != null && (this.gvX.bps() || this.gvX.bpt())) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwC);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.gwC, com.baidu.tbadk.coreExtra.model.f.IO());
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwD);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gwD, com.baidu.tbadk.coreExtra.model.f.IN());
        }
    }

    public void boT() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.gvT.rA(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            TD();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.gvZ = 0;
        if (this.gwd != null) {
            bpD();
            if (this.gvO != null) {
                if (!this.gvY) {
                    this.gvY = true;
                    this.gvO.a(this.mContext, this.mUri, this.mHeaders, this.gwd, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gwF.onPrepared(this.gvO);
                }
            }
        } else if (this.gvM != null && this.gvM.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.gwe) {
                addView(this.gvM, layoutParams);
            } else {
                addView(this.gvM, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void TD() {
        this.gvY = false;
        this.gvW = false;
        if (this.gvO != null) {
            if (this.gvO.isPlaying() && bpI()) {
                y.bqk().aM(this.gwk, this.gvO.getCurrentPosition());
            }
            this.gvO.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwI);
    }

    private void tr(String str) {
        this.gww = 0;
        this.gwx = 0;
        this.gwy = 0;
        this.gwz = 0;
        this.gwA = 0;
        this.byB = 0;
        if (this.gvX.bpt()) {
            this.gwv = gwr;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gwx = (int) u.tt(QuickVideoView.this.gwi);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gwi != null && this.gwi.equals(str)) {
            this.gwv = gwq;
        } else {
            this.gwv = gws;
        }
        this.gfY = gwt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpE() {
        this.gfY = gwt;
        if (this.gvO != null) {
            this.gww = this.gvO.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(boolean z) {
        if (this.gfY == gwt && this.gvO != null) {
            this.gfY = gwu;
            this.gwz = this.gvO.getDuration();
            if (z) {
                this.gwA = 0;
                this.gwy = this.gwz;
            } else {
                this.gwy = this.gvO.getCurrentPosition();
                this.gwA = this.gvO.getCachedSize();
            }
            if (this.gwy > 0) {
                if (this.gwv == gwq) {
                    this.gwx = (int) u.tt(this.gwi);
                    if (this.gww > 0) {
                        long j = (this.gww * (this.gwy / 1000)) / 8;
                        if (this.gwA < 0) {
                            this.gwA = 0;
                        }
                        long j2 = this.gwA + j;
                        if (this.gwx > 0) {
                            j2 += this.gwx;
                        }
                        setFlowCount(j2, this.gwy, this.gwz, this.byB);
                    } else if (this.gww == -1) {
                        this.gww = 603327;
                        setFlowCount((this.gww * (this.gwy / 1000)) / 8, this.gwy, this.gwz, this.byB);
                    }
                } else if (this.gwv == gwr) {
                    if (this.gww > 0) {
                        long j3 = (this.gww * (this.gwy / 1000)) / 8;
                        if (this.gwA < 0) {
                            this.gwA = 0;
                        }
                        long j4 = this.gwA + j3;
                        if (this.gwx > 0) {
                            j4 -= this.gwx;
                        }
                        setFlowCount(j4, this.gwy, this.gwz, this.byB);
                    } else if (this.gww == -1) {
                        this.gww = 603327;
                        setFlowCount((this.gww * (this.gwy / 1000)) / 8, this.gwy, this.gwz, this.byB);
                    }
                } else {
                    setFlowCount(0L, this.gwy, this.gwz, this.byB);
                }
            }
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwI);
    }

    public void stopPlayback() {
        bpF();
        mx(false);
        if (this.gwf != null) {
            this.gwf.clear();
        }
        this.gvN = null;
        TD();
        this.gwa = false;
        if (this.gvX != null) {
            this.gvX.onStop();
        }
        com.baidu.tieba.play.a.b.bqn().a((b.InterfaceC0284b) null);
        if (this.gvT != null && this.gvT.rD(getLocateSource())) {
            this.gvT = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwI);
    }

    public void setFullScreenToDestroySurface() {
        this.gwB = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpF() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwC);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwD);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bum = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bul = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bly = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0287g interfaceC0287g) {
        this.bup = interfaceC0287g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String M(String str, String str2, String str3) {
        if (this.gwh == null) {
            return "";
        }
        String bqs = this.gwh.bqs();
        this.gwh.N(str, str2, str3);
        return bqs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gvX != null && !StringUtils.isNull(this.gvX.bpr())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.ty(uri);
                }
            }
            this.mUri = Uri.parse(this.gvX.bpr());
        }
        boolean z = false;
        if (this.gwf != null) {
            z = this.gwf.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gvT != null) {
            this.gvV = this.gvT.a(i, i2, i3, getLocateSource(), z, this.gwl, M(this.gvT.baJ(), i3 + "", this.gvT.baK()));
            this.gvT = null;
        }
        this.gwl = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gvO != null) {
            try {
                if (this.gvO.isPlaying() && bpI()) {
                    y.bqk().aM(this.gwk, this.gvO.getCurrentPosition());
                }
                this.gvO.release();
                this.gvN = str;
                URI uri = new URI(this.mUri.toString());
                this.gvO.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.gwd, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (f(this.mUri) != null) {
                    this.gvT.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gvO != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.gvO.isPlaying() && bpI()) {
                y.bqk().aM(this.gwk, this.gvO.getCurrentPosition());
            }
            this.gvO.release();
            this.gvO.a(this.mContext, this.mUri, this.mHeaders, this.gwd, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gvT.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gvO != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gvO.forceUseSystemMediaPlayer(true);
            }
            if (this.gvO.isPlaying() && bpI()) {
                y.bqk().aM(this.gwk, this.gvO.getCurrentPosition());
            }
            this.gvO.release();
            this.gvO.a(this.mContext, this.mUri, this.mHeaders, this.gwd, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gvT.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gvW = true;
        if (this.gvO != null) {
            if (this.gwd != null && this.gwc && !this.gvO.isExistInRemote()) {
                this.gvO.a(this.mContext, this.mUri, this.mHeaders, this.gwd, this.gwb);
                if (this.gvu != null) {
                    this.gvu.bpq();
                }
                if (f(this.mUri) != null) {
                    this.gvT.baF();
                }
                bpD();
                return;
            }
            this.gvO.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gvX != null) {
            this.gvX.onStart();
        }
        if (this.gvQ != null) {
            this.gvQ.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null && this.gvO != null) {
            this.gvT.ro(this.gvO.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bpF();
        if (this.gvO != null) {
            if (this.gvO.isPlaying() && bpI()) {
                y.bqk().aM(this.gwk, this.gvO.getCurrentPosition());
            }
            this.gvO.pause();
        }
        if (this.gvX != null) {
            this.gvX.onPause();
        }
        this.gvW = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gvT != null) {
            this.gvT.baI();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gvO != null) {
            return this.gvO.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gvO != null) {
            return this.gvO.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.byB = i;
        sU(i);
    }

    public void sU(int i) {
        if (this.gwg != null) {
            this.gwg.bpT();
        }
        if (this.gvO != null) {
            this.gvO.seekTo(i);
        }
        if (this.gvX != null) {
            this.gvX.sT(0);
            bpH();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gvO != null) {
            return this.gvO.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gvO != null) {
            this.gvO.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gwb = i;
    }

    public int getRecoveryState() {
        return this.gwb;
    }

    public void setNeedRecovery(boolean z) {
        this.gwc = z;
    }

    public void setLooping(boolean z) {
        this.gwa = z;
    }

    public boolean bpG() {
        return this.gvW;
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
        this.blC = bVar;
    }

    public void setBusiness(d dVar) {
        this.gvX = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.buy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gwa = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gvO != null) {
            this.gvO.OW();
        }
        if (this.gwg != null) {
            this.gwg.bpV();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwI);
        MessageManager.getInstance().unRegisterListener(this.buy);
        if (this.gwf != null) {
            this.gwf.clear();
        }
        if (this.gvU != null) {
            this.gvU.a(null);
            this.gvU.bax();
        }
    }

    public g getPlayer() {
        return this.gvO;
    }

    public int getPlayerType() {
        return this.gvO == null ? ReportLevel.USER : this.gvO.getPlayerType();
    }

    public void bpH() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwI);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gwI, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gvu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gvX instanceof n) || ((n) this.gvX).bpR() == null) ? "" : ((n) this.gvX).bpR().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.gvT != null) {
            return this.gvT;
        }
        if (!StringUtils.isNull(this.gwi)) {
            uri2 = this.gwi;
        } else if (gvS != null && this.gvX != null && !StringUtils.isNull(this.gvX.bpr())) {
            uri2 = this.gvX.bpr();
        } else {
            uri2 = (gvS == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gvS != null) {
            this.gvT = gvS.L(this.beV, uri2, this.gvV);
        }
        this.gvV = null;
        this.gwl = 0L;
        return this.gvT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpI() {
        return this.gvO != null && this.gvO.getDuration() >= this.gvO.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gvT, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gvT, j);
    }

    public static boolean gK(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gvP = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gvO != null) {
            return this.gvO.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gvO != null ? this.gvO.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.gvT != null) {
            this.gvT.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.gvQ = cVar;
    }
}
