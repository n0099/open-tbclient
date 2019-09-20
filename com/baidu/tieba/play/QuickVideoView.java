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
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.play.b.b;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a, com.baidu.tieba.play.c.c {
    private static h dii;
    private static com.baidu.tieba.j.l dij;
    private static int iyZ = 0;
    private static int iza = 1;
    private static int izb = 2;
    private static int izc = 1;
    private static int izd = 0;
    private Map<String, String> FV;
    private WeakReference<Context> bCb;
    private String bXN;
    private g.b cKP;
    private b cKT;
    private final CustomMessageListener cUD;
    private g.a cUp;
    private g.f cUq;
    private g.c cUr;
    private g.e cUs;
    private g.InterfaceC0404g cUt;
    private g.i cUu;
    private g.d cUv;
    private g.h cUw;
    private int cZs;
    private boolean dib;
    private g.f dik;
    private g.a dil;
    private g.InterfaceC0404g dio;
    private int iie;
    private g.e iyA;
    private c iyB;
    private com.baidu.tieba.j.i iyC;
    private com.baidu.tieba.j.e iyD;
    private String iyE;
    private boolean iyF;
    private d iyG;
    private com.baidu.tieba.j.k iyH;
    private boolean iyI;
    private int iyJ;
    private int iyK;
    private boolean iyL;
    private SurfaceTexture iyM;
    private boolean iyN;
    private com.baidu.tieba.play.c.a iyO;
    private r iyP;
    private com.baidu.tieba.play.c.f iyQ;
    private String iyR;
    private String iyS;
    private String iyT;
    private long iyU;
    private boolean iyV;
    private boolean iyW;
    private long iyX;
    private long iyY;
    private a iye;
    private RenderView iyx;
    private String iyy;
    private g iyz;
    private int ize;
    private int izf;
    private int izg;
    private int izh;
    private int izi;
    private int izj;
    private boolean izk;
    private Runnable izl;
    private Runnable izm;
    private TextureView.SurfaceTextureListener izn;
    private Runnable izo;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void ceX();
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
            dii = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            dij = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.iyN = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.iyF = false;
        this.iyI = false;
        this.iyJ = 0;
        this.dib = false;
        this.iyK = -1;
        this.iyL = false;
        this.iyM = null;
        this.iyN = true;
        this.iyX = 0L;
        this.iyY = 0L;
        this.iie = izd;
        this.ize = 0;
        this.izf = 0;
        this.izg = -1;
        this.izh = 0;
        this.izi = 0;
        this.izj = 0;
        this.cZs = 0;
        this.izk = false;
        this.bCb = null;
        this.izl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iyz != null && QuickVideoView.this.iyF) {
                    QuickVideoView.this.b(QuickVideoView.this.iyz, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.izm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.nB(false);
                }
            }
        };
        this.izn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.izk) {
                    QuickVideoView.this.izk = false;
                    if (QuickVideoView.this.iyz != null) {
                        QuickVideoView.this.iyz.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.iyI || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iyz != null && QuickVideoView.this.iyL) {
                        QuickVideoView.this.iyz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.iyK);
                        if (QuickVideoView.this.iye != null) {
                            QuickVideoView.this.iye.ceX();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iyC.bPH();
                        }
                    }
                } else if (cfs()) {
                    if (QuickVideoView.this.iyz != null) {
                        QuickVideoView.this.cfl();
                        QuickVideoView.this.iyI = true;
                        QuickVideoView.this.iyz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iyC.bPG();
                    }
                }
                QuickVideoView.this.iyM = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.izk) {
                    QuickVideoView.this.cfn();
                    QuickVideoView.this.qi(false);
                    if (QuickVideoView.this.iyz != null) {
                        if (QuickVideoView.this.iyz.isPlaying() && QuickVideoView.this.cfq()) {
                            y.cfS().bi(QuickVideoView.this.iyT, QuickVideoView.this.iyz.getCurrentPosition());
                        }
                        QuickVideoView.this.iyz.release();
                    }
                    if (QuickVideoView.this.iyI) {
                        if (QuickVideoView.this.iyG != null) {
                            QuickVideoView.this.iyG.onStop();
                        }
                        if (QuickVideoView.this.cKT != null) {
                            QuickVideoView.this.cKT.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iyM = null;
                    if (QuickVideoView.this.iyC != null && QuickVideoView.this.iyC.BD(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.iyI = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cfs() {
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
        this.dik = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Dz;
                QuickVideoView.this.cfn();
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.onPrepared();
                }
                if (QuickVideoView.this.iyC != null && QuickVideoView.this.iyz != null) {
                    QuickVideoView.this.iyC.xq(QuickVideoView.this.iyz.getPlayerType());
                }
                if (QuickVideoView.this.cUq != null) {
                    QuickVideoView.this.iyH.bPW();
                    QuickVideoView.this.cUq.onPrepared(gVar);
                }
                if (QuickVideoView.this.iyG != null) {
                    long j = 0;
                    if (QuickVideoView.this.iyz != null) {
                        j = QuickVideoView.this.iyz.getDuration();
                    }
                    QuickVideoView.this.iyG.et(j);
                    QuickVideoView.this.cfm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iyG.cfe();
                        QuickVideoView.this.cfp();
                    }
                }
                if (QuickVideoView.this.iyW && (Dz = y.cfS().Dz(QuickVideoView.this.iyT)) > 0 && QuickVideoView.this.iyz != null) {
                    if (QuickVideoView.this.iyz.isPlayerReuse()) {
                        if (QuickVideoView.this.iyz.getCurrentPosition() == 0) {
                            QuickVideoView.this.zc(Dz);
                        }
                    } else {
                        QuickVideoView.this.zc(Dz);
                    }
                }
                if (QuickVideoView.this.iyF) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iyx != null && gVar != null) {
                    QuickVideoView.this.iyx.ae(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iyJ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iyy) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iyy);
                }
                if (QuickVideoView.this.iyO != null && QuickVideoView.this.iyO.cgo()) {
                    com.baidu.tieba.play.c.e.zj(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dil = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qi(true);
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.BC(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iyC = null;
                }
                if (!QuickVideoView.this.dib || QuickVideoView.this.iyG == null) {
                    if (QuickVideoView.this.iyG != null) {
                        QuickVideoView.this.iyG.onCompletion();
                    }
                    QuickVideoView.this.iyF = false;
                    y.cfS().remove(QuickVideoView.this.iyT);
                    if (QuickVideoView.this.cUp != null) {
                        QuickVideoView.this.cUp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iyE = null;
                QuickVideoView.this.iyU = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iyG.ceY());
                QuickVideoView.this.start();
            }
        };
        this.cUr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.af(i, i2, i3);
                QuickVideoView.this.cfn();
                if (QuickVideoView.this.iyG != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cfq()) {
                    QuickVideoView.this.iyV = true;
                    y.cfS().bi(QuickVideoView.this.iyT, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.iyC != null) {
                        QuickVideoView.this.iyE = QuickVideoView.this.iyC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iyU, QuickVideoView.this.ab(QuickVideoView.this.iyC.bPL(), i3 + "", QuickVideoView.this.iyC.bPM()));
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.iyU = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.zh(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.zi(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cKP == null || QuickVideoView.this.cKP.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dio = new g.InterfaceC0404g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                if (QuickVideoView.this.iyV) {
                    QuickVideoView.this.iyV = false;
                    return;
                }
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.cfC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iyG != null && z) {
                    QuickVideoView.this.iyG.onSeekComplete();
                }
                if (QuickVideoView.this.cUt != null) {
                    QuickVideoView.this.cUt.b(gVar);
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.iyA != null) {
                    QuickVideoView.this.iyA.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.iyJ = i2;
                    if (QuickVideoView.this.iyx != null && gVar != null) {
                        QuickVideoView.this.iyx.ae(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iyJ);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.iyH.a(QuickVideoView.this.bXN, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.a(i, i2, QuickVideoView.this.iyC);
                    return true;
                }
                return true;
            }
        };
        this.cUu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.i(i, i2, str);
                }
            }
        };
        this.cUv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.BE(str);
                }
            }
        };
        this.cUw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iyU = j;
                }
            }
        };
        this.izo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iyG != null && QuickVideoView.this.iyG.cfa() && QuickVideoView.this.iyG.cfb() && QuickVideoView.this.iyG.cfc() && QuickVideoView.this.iyz != null) {
                    int aBU = QuickVideoView.this.iyz.aBU();
                    int currentPosition = QuickVideoView.this.iyz.getCurrentPosition();
                    int duration = QuickVideoView.this.iyz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iyX;
                    boolean z = currentPosition + aBU < duration;
                    if (aBU < QuickVideoView.this.iyG.cfd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iyX = currentTimeMillis;
                        QuickVideoView.this.iyG.za(0);
                    }
                    if (QuickVideoView.this.cfo() && currentPosition == QuickVideoView.this.iyY && j > 500) {
                        QuickVideoView.this.iyX = currentTimeMillis;
                        QuickVideoView.this.iyG.za(0);
                    }
                    QuickVideoView.this.iyY = currentPosition;
                    if (QuickVideoView.this.iie == QuickVideoView.izc) {
                        QuickVideoView.this.cfp();
                    }
                }
            }
        };
        this.cUD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iyG != null) {
                        QuickVideoView.this.iyG.cfg();
                    }
                    if (QuickVideoView.this.iyC != null) {
                        QuickVideoView.this.iyC.BB(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.cfn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iyF = false;
        this.iyI = false;
        this.iyJ = 0;
        this.dib = false;
        this.iyK = -1;
        this.iyL = false;
        this.iyM = null;
        this.iyN = true;
        this.iyX = 0L;
        this.iyY = 0L;
        this.iie = izd;
        this.ize = 0;
        this.izf = 0;
        this.izg = -1;
        this.izh = 0;
        this.izi = 0;
        this.izj = 0;
        this.cZs = 0;
        this.izk = false;
        this.bCb = null;
        this.izl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iyz != null && QuickVideoView.this.iyF) {
                    QuickVideoView.this.b(QuickVideoView.this.iyz, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.izm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.nB(false);
                }
            }
        };
        this.izn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.izk) {
                    QuickVideoView.this.izk = false;
                    if (QuickVideoView.this.iyz != null) {
                        QuickVideoView.this.iyz.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.iyI || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iyz != null && QuickVideoView.this.iyL) {
                        QuickVideoView.this.iyz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.iyK);
                        if (QuickVideoView.this.iye != null) {
                            QuickVideoView.this.iye.ceX();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iyC.bPH();
                        }
                    }
                } else if (cfs()) {
                    if (QuickVideoView.this.iyz != null) {
                        QuickVideoView.this.cfl();
                        QuickVideoView.this.iyI = true;
                        QuickVideoView.this.iyz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iyC.bPG();
                    }
                }
                QuickVideoView.this.iyM = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.izk) {
                    QuickVideoView.this.cfn();
                    QuickVideoView.this.qi(false);
                    if (QuickVideoView.this.iyz != null) {
                        if (QuickVideoView.this.iyz.isPlaying() && QuickVideoView.this.cfq()) {
                            y.cfS().bi(QuickVideoView.this.iyT, QuickVideoView.this.iyz.getCurrentPosition());
                        }
                        QuickVideoView.this.iyz.release();
                    }
                    if (QuickVideoView.this.iyI) {
                        if (QuickVideoView.this.iyG != null) {
                            QuickVideoView.this.iyG.onStop();
                        }
                        if (QuickVideoView.this.cKT != null) {
                            QuickVideoView.this.cKT.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iyM = null;
                    if (QuickVideoView.this.iyC != null && QuickVideoView.this.iyC.BD(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.iyI = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cfs() {
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
        this.dik = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Dz;
                QuickVideoView.this.cfn();
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.onPrepared();
                }
                if (QuickVideoView.this.iyC != null && QuickVideoView.this.iyz != null) {
                    QuickVideoView.this.iyC.xq(QuickVideoView.this.iyz.getPlayerType());
                }
                if (QuickVideoView.this.cUq != null) {
                    QuickVideoView.this.iyH.bPW();
                    QuickVideoView.this.cUq.onPrepared(gVar);
                }
                if (QuickVideoView.this.iyG != null) {
                    long j = 0;
                    if (QuickVideoView.this.iyz != null) {
                        j = QuickVideoView.this.iyz.getDuration();
                    }
                    QuickVideoView.this.iyG.et(j);
                    QuickVideoView.this.cfm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iyG.cfe();
                        QuickVideoView.this.cfp();
                    }
                }
                if (QuickVideoView.this.iyW && (Dz = y.cfS().Dz(QuickVideoView.this.iyT)) > 0 && QuickVideoView.this.iyz != null) {
                    if (QuickVideoView.this.iyz.isPlayerReuse()) {
                        if (QuickVideoView.this.iyz.getCurrentPosition() == 0) {
                            QuickVideoView.this.zc(Dz);
                        }
                    } else {
                        QuickVideoView.this.zc(Dz);
                    }
                }
                if (QuickVideoView.this.iyF) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iyx != null && gVar != null) {
                    QuickVideoView.this.iyx.ae(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iyJ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iyy) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iyy);
                }
                if (QuickVideoView.this.iyO != null && QuickVideoView.this.iyO.cgo()) {
                    com.baidu.tieba.play.c.e.zj(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dil = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qi(true);
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.BC(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iyC = null;
                }
                if (!QuickVideoView.this.dib || QuickVideoView.this.iyG == null) {
                    if (QuickVideoView.this.iyG != null) {
                        QuickVideoView.this.iyG.onCompletion();
                    }
                    QuickVideoView.this.iyF = false;
                    y.cfS().remove(QuickVideoView.this.iyT);
                    if (QuickVideoView.this.cUp != null) {
                        QuickVideoView.this.cUp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iyE = null;
                QuickVideoView.this.iyU = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iyG.ceY());
                QuickVideoView.this.start();
            }
        };
        this.cUr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.af(i, i2, i3);
                QuickVideoView.this.cfn();
                if (QuickVideoView.this.iyG != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cfq()) {
                    QuickVideoView.this.iyV = true;
                    y.cfS().bi(QuickVideoView.this.iyT, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.iyC != null) {
                        QuickVideoView.this.iyE = QuickVideoView.this.iyC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iyU, QuickVideoView.this.ab(QuickVideoView.this.iyC.bPL(), i3 + "", QuickVideoView.this.iyC.bPM()));
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.iyU = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.zh(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.zi(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cKP == null || QuickVideoView.this.cKP.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dio = new g.InterfaceC0404g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                if (QuickVideoView.this.iyV) {
                    QuickVideoView.this.iyV = false;
                    return;
                }
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.cfC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iyG != null && z) {
                    QuickVideoView.this.iyG.onSeekComplete();
                }
                if (QuickVideoView.this.cUt != null) {
                    QuickVideoView.this.cUt.b(gVar);
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.iyA != null) {
                    QuickVideoView.this.iyA.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.iyJ = i2;
                    if (QuickVideoView.this.iyx != null && gVar != null) {
                        QuickVideoView.this.iyx.ae(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iyJ);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.iyH.a(QuickVideoView.this.bXN, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.a(i, i2, QuickVideoView.this.iyC);
                    return true;
                }
                return true;
            }
        };
        this.cUu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.i(i, i2, str);
                }
            }
        };
        this.cUv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.BE(str);
                }
            }
        };
        this.cUw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iyU = j;
                }
            }
        };
        this.izo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iyG != null && QuickVideoView.this.iyG.cfa() && QuickVideoView.this.iyG.cfb() && QuickVideoView.this.iyG.cfc() && QuickVideoView.this.iyz != null) {
                    int aBU = QuickVideoView.this.iyz.aBU();
                    int currentPosition = QuickVideoView.this.iyz.getCurrentPosition();
                    int duration = QuickVideoView.this.iyz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iyX;
                    boolean z = currentPosition + aBU < duration;
                    if (aBU < QuickVideoView.this.iyG.cfd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iyX = currentTimeMillis;
                        QuickVideoView.this.iyG.za(0);
                    }
                    if (QuickVideoView.this.cfo() && currentPosition == QuickVideoView.this.iyY && j > 500) {
                        QuickVideoView.this.iyX = currentTimeMillis;
                        QuickVideoView.this.iyG.za(0);
                    }
                    QuickVideoView.this.iyY = currentPosition;
                    if (QuickVideoView.this.iie == QuickVideoView.izc) {
                        QuickVideoView.this.cfp();
                    }
                }
            }
        };
        this.cUD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iyG != null) {
                        QuickVideoView.this.iyG.cfg();
                    }
                    if (QuickVideoView.this.iyC != null) {
                        QuickVideoView.this.iyC.BB(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.cfn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iyF = false;
        this.iyI = false;
        this.iyJ = 0;
        this.dib = false;
        this.iyK = -1;
        this.iyL = false;
        this.iyM = null;
        this.iyN = true;
        this.iyX = 0L;
        this.iyY = 0L;
        this.iie = izd;
        this.ize = 0;
        this.izf = 0;
        this.izg = -1;
        this.izh = 0;
        this.izi = 0;
        this.izj = 0;
        this.cZs = 0;
        this.izk = false;
        this.bCb = null;
        this.izl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iyz != null && QuickVideoView.this.iyF) {
                    QuickVideoView.this.b(QuickVideoView.this.iyz, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.izm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.nB(false);
                }
            }
        };
        this.izn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.izk) {
                    QuickVideoView.this.izk = false;
                    if (QuickVideoView.this.iyz != null) {
                        QuickVideoView.this.iyz.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.iyI || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iyz != null && QuickVideoView.this.iyL) {
                        QuickVideoView.this.iyz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.iyK);
                        if (QuickVideoView.this.iye != null) {
                            QuickVideoView.this.iye.ceX();
                        }
                        if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iyC.bPH();
                        }
                    }
                } else if (cfs()) {
                    if (QuickVideoView.this.iyz != null) {
                        QuickVideoView.this.cfl();
                        QuickVideoView.this.iyI = true;
                        QuickVideoView.this.iyz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.FV, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iyC.bPG();
                    }
                }
                QuickVideoView.this.iyM = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.izk) {
                    QuickVideoView.this.cfn();
                    QuickVideoView.this.qi(false);
                    if (QuickVideoView.this.iyz != null) {
                        if (QuickVideoView.this.iyz.isPlaying() && QuickVideoView.this.cfq()) {
                            y.cfS().bi(QuickVideoView.this.iyT, QuickVideoView.this.iyz.getCurrentPosition());
                        }
                        QuickVideoView.this.iyz.release();
                    }
                    if (QuickVideoView.this.iyI) {
                        if (QuickVideoView.this.iyG != null) {
                            QuickVideoView.this.iyG.onStop();
                        }
                        if (QuickVideoView.this.cKT != null) {
                            QuickVideoView.this.cKT.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iyM = null;
                    if (QuickVideoView.this.iyC != null && QuickVideoView.this.iyC.BD(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.iyI = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cfs() {
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
        this.dik = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Dz;
                QuickVideoView.this.cfn();
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.onPrepared();
                }
                if (QuickVideoView.this.iyC != null && QuickVideoView.this.iyz != null) {
                    QuickVideoView.this.iyC.xq(QuickVideoView.this.iyz.getPlayerType());
                }
                if (QuickVideoView.this.cUq != null) {
                    QuickVideoView.this.iyH.bPW();
                    QuickVideoView.this.cUq.onPrepared(gVar);
                }
                if (QuickVideoView.this.iyG != null) {
                    long j = 0;
                    if (QuickVideoView.this.iyz != null) {
                        j = QuickVideoView.this.iyz.getDuration();
                    }
                    QuickVideoView.this.iyG.et(j);
                    QuickVideoView.this.cfm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iyG.cfe();
                        QuickVideoView.this.cfp();
                    }
                }
                if (QuickVideoView.this.iyW && (Dz = y.cfS().Dz(QuickVideoView.this.iyT)) > 0 && QuickVideoView.this.iyz != null) {
                    if (QuickVideoView.this.iyz.isPlayerReuse()) {
                        if (QuickVideoView.this.iyz.getCurrentPosition() == 0) {
                            QuickVideoView.this.zc(Dz);
                        }
                    } else {
                        QuickVideoView.this.zc(Dz);
                    }
                }
                if (QuickVideoView.this.iyF) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iyx != null && gVar != null) {
                    QuickVideoView.this.iyx.ae(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iyJ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iyy) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iyy);
                }
                if (QuickVideoView.this.iyO != null && QuickVideoView.this.iyO.cgo()) {
                    com.baidu.tieba.play.c.e.zj(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dil = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.qi(true);
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.BC(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iyC = null;
                }
                if (!QuickVideoView.this.dib || QuickVideoView.this.iyG == null) {
                    if (QuickVideoView.this.iyG != null) {
                        QuickVideoView.this.iyG.onCompletion();
                    }
                    QuickVideoView.this.iyF = false;
                    y.cfS().remove(QuickVideoView.this.iyT);
                    if (QuickVideoView.this.cUp != null) {
                        QuickVideoView.this.cUp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iyE = null;
                QuickVideoView.this.iyU = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iyG.ceY());
                QuickVideoView.this.start();
            }
        };
        this.cUr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.c.e.af(i2, i22, i3);
                QuickVideoView.this.cfn();
                if (QuickVideoView.this.iyG != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cfq()) {
                    QuickVideoView.this.iyV = true;
                    y.cfS().bi(QuickVideoView.this.iyT, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kc()) {
                    if (QuickVideoView.this.iyC != null) {
                        QuickVideoView.this.iyE = QuickVideoView.this.iyC.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iyU, QuickVideoView.this.ab(QuickVideoView.this.iyC.bPL(), i3 + "", QuickVideoView.this.iyC.bPM()));
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.iyU = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.c.e.zh(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.zi(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cKP == null || QuickVideoView.this.cKP.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.dio = new g.InterfaceC0404g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0404g
            public void b(g gVar) {
                if (QuickVideoView.this.iyV) {
                    QuickVideoView.this.iyV = false;
                    return;
                }
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.cfC();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iyG != null && z) {
                    QuickVideoView.this.iyG.onSeekComplete();
                }
                if (QuickVideoView.this.cUt != null) {
                    QuickVideoView.this.cUt.b(gVar);
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.iyA != null) {
                    QuickVideoView.this.iyA.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.iyJ = i22;
                    if (QuickVideoView.this.iyx != null && gVar != null) {
                        QuickVideoView.this.iyx.ae(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iyJ);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.iyH.a(QuickVideoView.this.bXN, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.iyP != null) {
                    QuickVideoView.this.iyP.a(i2, i22, QuickVideoView.this.iyC);
                    return true;
                }
                return true;
            }
        };
        this.cUu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.i(i2, i22, str);
                }
            }
        };
        this.cUv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iyC != null) {
                    QuickVideoView.this.iyC.BE(str);
                }
            }
        };
        this.cUw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iyU = j;
                }
            }
        };
        this.izo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iyG != null && QuickVideoView.this.iyG.cfa() && QuickVideoView.this.iyG.cfb() && QuickVideoView.this.iyG.cfc() && QuickVideoView.this.iyz != null) {
                    int aBU = QuickVideoView.this.iyz.aBU();
                    int currentPosition = QuickVideoView.this.iyz.getCurrentPosition();
                    int duration = QuickVideoView.this.iyz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iyX;
                    boolean z = currentPosition + aBU < duration;
                    if (aBU < QuickVideoView.this.iyG.cfd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iyX = currentTimeMillis;
                        QuickVideoView.this.iyG.za(0);
                    }
                    if (QuickVideoView.this.cfo() && currentPosition == QuickVideoView.this.iyY && j > 500) {
                        QuickVideoView.this.iyX = currentTimeMillis;
                        QuickVideoView.this.iyG.za(0);
                    }
                    QuickVideoView.this.iyY = currentPosition;
                    if (QuickVideoView.this.iie == QuickVideoView.izc) {
                        QuickVideoView.this.cfp();
                    }
                }
            }
        };
        this.cUD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iyG != null) {
                        QuickVideoView.this.iyG.cfg();
                    }
                    if (QuickVideoView.this.iyC != null) {
                        QuickVideoView.this.iyC.BB(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iyC = null;
                    }
                    QuickVideoView.this.cfn();
                }
            }
        };
        init(context);
    }

    @Override // com.baidu.tieba.play.a.a
    public View getView() {
        return this;
    }

    private void init(Context context) {
        this.mContext = context;
        this.iyx = new RenderView(context);
        this.bCb = new WeakReference<>(TbadkCoreApplication.getInst());
        this.iyx.setSurfaceTextureListener(this.izn);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.iyN) {
            addView(this.iyx, layoutParams);
        } else {
            addView(this.iyx, 0, layoutParams);
        }
        if (dii != null) {
            this.iyz = dii.aBW();
        }
        if (this.iyz != null) {
            this.iyz.setOnPreparedListener(this.dik);
            this.iyz.setOnCompletionListener(this.dil);
            this.iyz.a(this.cUr);
            this.iyz.setOnSeekCompleteListener(this.dio);
            this.iyz.a(this.cUs);
            this.iyz.a(this.cUu);
            this.iyz.a(this.cUv);
            this.iyz.a(this.cUw);
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
        this.iyO = new com.baidu.tieba.play.c.a(this);
        this.iyP = new r();
        this.iyQ = new com.baidu.tieba.play.c.f();
        am.k(this, R.color.black_alpha100);
        this.iyH = new com.baidu.tieba.j.k();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.hS().az("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.iyW = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.iyH.bPV();
        this.bXN = str2;
        if (this.iyO != null) {
            this.iyO.clear();
            this.iyO.cgo();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.c.e.DE(str2);
            if (dij != null) {
                this.iyC = dij.Z(this.bXN, str, "");
                if (this.iyC != null) {
                    this.iyC.a(-300, -44399, -44399, getLocateSource(), false, this.iyU, "");
                    this.iyC = null;
                }
            }
        }
        if (this.iyD != null) {
            this.iyD.a(null);
            this.iyD.bPz();
            this.iyD = null;
        }
        this.iyE = null;
        this.iyU = 0L;
        setVideoPath(str);
    }

    private String Dv(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cuO().cuP()) {
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
            String Dv = Dv(str);
            this.iyR = Dv;
            if (this.iyG != null) {
                Dv = this.iyG.sn(Dv);
                if (this.iyG.cff() != null) {
                    this.iyG.cff().setPlayer(this);
                }
                if (dij != null && pO(Dv)) {
                    this.iyD = dij.BH(Dv);
                }
                if (this.iyD != null) {
                    this.iyD.a(new com.baidu.tieba.play.monitor.a(this.bXN, this.iyR, this.iyC));
                    this.iyD.bPy();
                }
                Dw(Dv);
            }
            if (!com.baidu.adp.lib.util.j.kc() && !pO(Dv)) {
                if (this.cKP != null) {
                    this.cKP.onError(this.iyz, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(Dv));
            if (this.iyC != null) {
                if (u(Uri.parse(Dv)) != null) {
                    this.iyC.bPF();
                }
                this.iyC.Gf();
                this.iyC = null;
            }
            this.iyS = str;
            int lastIndexOf = this.iyS.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.iyS.length() > 4) {
                this.iyT = this.iyS.substring(0, lastIndexOf + 4);
            } else {
                this.iyT = this.iyS;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfl() {
        if (com.baidu.tbadk.coreExtra.model.f.apY()) {
            if (this.iyG != null && (this.iyG.ceZ() || this.iyG.cfa())) {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izl);
                com.baidu.adp.lib.g.e.iK().postDelayed(this.izl, com.baidu.tbadk.coreExtra.model.f.apX());
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izm);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.izm, com.baidu.tbadk.coreExtra.model.f.apW());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void ceA() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.iyC.BA(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aBQ();
        }
        this.mUri = uri;
        this.FV = map;
        if (this.iyM != null) {
            cfl();
            if (this.iyz != null) {
                if (!this.iyI) {
                    this.iyI = true;
                    this.iyz.a(this.mContext, this.mUri, this.FV, this.iyM, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.dik.onPrepared(this.iyz);
                }
            }
        } else if (this.iyx != null && this.iyx.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.iyN) {
                addView(this.iyx, layoutParams);
            } else {
                addView(this.iyx, 0, layoutParams);
            }
        }
        am.k(this, R.color.black_alpha100);
    }

    private void aBQ() {
        this.iyI = false;
        this.iyF = false;
        if (this.iyz != null) {
            if (this.iyz.isPlaying() && cfq()) {
                y.cfS().bi(this.iyT, this.iyz.getCurrentPosition());
            }
            this.iyz.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izo);
    }

    private void Dw(String str) {
        this.izf = 0;
        this.izg = 0;
        this.izh = 0;
        this.izi = 0;
        this.izj = 0;
        this.cZs = 0;
        if (this.iyG.cfa()) {
            this.ize = iza;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.izg = (int) u.Dy(QuickVideoView.this.iyR);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.iyR != null && this.iyR.equals(str)) {
            this.ize = iyZ;
        } else {
            this.ize = izb;
        }
        this.iie = izc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfm() {
        this.iie = izc;
        if (this.iyz != null) {
            this.izf = this.iyz.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z) {
        if (this.iie == izc && this.iyz != null) {
            this.iie = izd;
            this.izi = this.iyz.getDuration();
            if (z) {
                this.izj = 0;
                this.izh = this.izi;
            } else {
                this.izh = this.iyz.getCurrentPosition();
                this.izj = this.iyz.getCachedSize();
            }
            if (this.izh > 0) {
                if (this.ize == iyZ) {
                    this.izg = (int) u.Dy(this.iyR);
                    if (this.izf > 0) {
                        long j = (this.izf * (this.izh / 1000)) / 8;
                        if (this.izj < 0) {
                            this.izj = 0;
                        }
                        long j2 = this.izj + j;
                        if (this.izg > 0) {
                            j2 += this.izg;
                        }
                        setFlowCount(j2, this.izh, this.izi, this.cZs);
                    } else if (this.izf == -1) {
                        this.izf = 603327;
                        setFlowCount((this.izf * (this.izh / 1000)) / 8, this.izh, this.izi, this.cZs);
                    }
                } else if (this.ize == iza) {
                    if (this.izf > 0) {
                        long j3 = (this.izf * (this.izh / 1000)) / 8;
                        if (this.izj < 0) {
                            this.izj = 0;
                        }
                        long j4 = this.izj + j3;
                        if (this.izg > 0) {
                            j4 -= this.izg;
                        }
                        setFlowCount(j4, this.izh, this.izi, this.cZs);
                    } else if (this.izf == -1) {
                        this.izf = 603327;
                        setFlowCount((this.izf * (this.izh / 1000)) / 8, this.izh, this.izi, this.cZs);
                    }
                } else {
                    setFlowCount(0L, this.izh, this.izi, this.cZs);
                }
            }
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izo);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ac.a(this.bCb, false);
        }
        cfn();
        qi(false);
        if (this.iyO != null) {
            this.iyO.clear();
        }
        this.iyy = null;
        aBQ();
        this.dib = false;
        if (this.iyG != null) {
            this.iyG.onStop();
        }
        com.baidu.tieba.play.b.b.cfV().a((b.InterfaceC0401b) null);
        if (this.iyC != null && this.iyC.BD(getLocateSource())) {
            this.iyC = null;
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izo);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.izk = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfn() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izl);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izm);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.cUq = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.cUp = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.cKP = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0404g interfaceC0404g) {
        this.cUt = interfaceC0404g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ab(String str, String str2, String str3) {
        if (this.iyQ == null) {
            return "";
        }
        String cgq = this.iyQ.cgq();
        this.iyQ.ac(str, str2, str3);
        return cgq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.iyG != null && !StringUtils.isNull(this.iyG.ceY())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.c.a.DD(uri);
                }
            }
            this.mUri = Uri.parse(this.iyG.ceY());
        }
        boolean z = false;
        if (this.iyO != null) {
            z = this.iyO.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.iyC != null) {
            this.iyE = this.iyC.a(i, i2, i3, getLocateSource(), z, this.iyU, ab(this.iyC.bPL(), i3 + "", this.iyC.bPM()));
            this.iyC = null;
        }
        this.iyU = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.iyz != null) {
            try {
                if (this.iyz.isPlaying() && cfq()) {
                    y.cfS().bi(this.iyT, this.iyz.getCurrentPosition());
                }
                this.iyz.release();
                this.iyy = str;
                URI uri = new URI(this.mUri.toString());
                this.iyz.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.FV, this.iyM, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.iyC.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.iyz != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.iyz.isPlaying() && cfq()) {
                y.cfS().bi(this.iyT, this.iyz.getCurrentPosition());
            }
            this.iyz.release();
            this.iyz.a(this.mContext, this.mUri, this.FV, this.iyM, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.iyC.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.iyz != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.iyz.forceUseSystemMediaPlayer(true);
            }
            if (this.iyz.isPlaying() && cfq()) {
                y.cfS().bi(this.iyT, this.iyz.getCurrentPosition());
            }
            this.iyz.release();
            this.iyz.a(this.mContext, this.mUri, this.FV, this.iyM, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.iyC.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.iyF = true;
        if (this.iyz != null) {
            if (this.iyM != null && this.iyL && !this.iyz.isExistInRemote()) {
                this.iyz.a(this.mContext, this.mUri, this.FV, this.iyM, this.iyK);
                if (this.iye != null) {
                    this.iye.ceX();
                }
                if (u(this.mUri) != null) {
                    this.iyC.bPH();
                }
                cfl();
                return;
            }
            if (!this.iyz.aBV()) {
                ac.a(this.bCb, true);
                this.iyz.setVolume(1.0f, 1.0f);
            }
            this.iyH.bPX();
            this.iyz.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.iyG != null) {
            this.iyG.onStart();
        }
        if (this.iyB != null) {
            this.iyB.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.iyz != null) {
            this.iyC.xr(this.iyz.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void bMd() {
        start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cfn();
        ac.a(this.bCb, false);
        if (this.iyz != null) {
            if (this.iyz.isPlaying() && cfq()) {
                y.cfS().bi(this.iyT, this.iyz.getCurrentPosition());
            }
            this.iyz.pause();
        }
        if (this.iyG != null) {
            this.iyG.onPause();
        }
        this.iyF = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iyC != null) {
            this.iyC.bPK();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.iyz != null) {
            return this.iyz.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.iyz != null) {
            return this.iyz.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.cZs = i;
        zc(i);
    }

    public void zc(int i) {
        if (this.iyP != null) {
            this.iyP.cfB();
        }
        if (this.iyz != null) {
            this.iyz.seekTo(i);
        }
        if (this.iyG != null) {
            this.iyG.za(0);
            cfp();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.iyz != null) {
            return this.iyz.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.iyz != null) {
            this.iyz.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.iyK = i;
    }

    public int getRecoveryState() {
        return this.iyK;
    }

    public void setNeedRecovery(boolean z) {
        this.iyL = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setLooping(boolean z) {
        this.dib = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cfo() {
        return this.iyF;
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

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(b bVar) {
        this.cKT = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.iyG = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cUD);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setMute(boolean z) {
        if (z) {
            this.iyz.setVolume(0.0f, 0.0f);
            ac.a(this.bCb, false);
            return;
        }
        ac.a(this.bCb, true);
        this.iyz.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dib = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iyz != null) {
            this.iyz.awJ();
        }
        if (this.iyP != null) {
            this.iyP.cfD();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izo);
        MessageManager.getInstance().unRegisterListener(this.cUD);
        if (this.iyO != null) {
            this.iyO.clear();
        }
        if (this.iyD != null) {
            this.iyD.a(null);
            this.iyD.bPz();
        }
    }

    public g getPlayer() {
        return this.iyz;
    }

    public int getPlayerType() {
        if (this.iyz == null) {
            return -300;
        }
        return this.iyz.getPlayerType();
    }

    public void cfp() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izo);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.izo, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.iye = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.iyG instanceof n) || ((n) this.iyG).cfz() == null) ? "" : ((n) this.iyG).cfz().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i u(Uri uri) {
        String uri2;
        if (this.iyC != null) {
            return this.iyC;
        }
        if (!StringUtils.isNull(this.iyR)) {
            uri2 = this.iyR;
        } else if (dij != null && this.iyG != null && !StringUtils.isNull(this.iyG.ceY())) {
            uri2 = this.iyG.ceY();
        } else {
            uri2 = (dij == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && dij != null) {
            this.iyC = dij.Z(this.bXN, uri2, this.iyE);
        }
        this.iyE = null;
        this.iyU = 0L;
        return this.iyC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfq() {
        return this.iyz != null && this.iyz.getDuration() >= this.iyz.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.iyC, j, j2, j3, j4);
    }

    public static boolean pO(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.iyA = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.iyz != null) {
            return this.iyz.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.iyz != null ? this.iyz.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void setPageTypeForPerfStat(String str) {
        this.iyH.setPageTypeForPerfStat(str);
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.iyC != null) {
            this.iyC.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.iyB = cVar;
    }
}
