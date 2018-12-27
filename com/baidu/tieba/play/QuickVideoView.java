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
    private static h gFy;
    private static com.baidu.tieba.j.l gFz;
    private int bCb;
    private String biz;
    private g.b boZ;
    private b bpd;
    private g.a bxL;
    private g.f bxM;
    private g.c bxN;
    private g.e bxO;
    private g.InterfaceC0298g bxP;
    private g.i bxQ;
    private g.d bxR;
    private g.h bxS;
    private final CustomMessageListener bxY;
    private com.baidu.tieba.j.i gFA;
    private com.baidu.tieba.j.e gFB;
    private String gFC;
    private boolean gFD;
    private d gFE;
    private boolean gFF;
    private int gFG;
    private boolean gFH;
    private int gFI;
    private boolean gFJ;
    private SurfaceTexture gFK;
    private boolean gFL;
    private com.baidu.tieba.play.b.a gFM;
    private r gFN;
    private com.baidu.tieba.play.b.f gFO;
    private String gFP;
    private String gFQ;
    private String gFR;
    private long gFS;
    private boolean gFT;
    private boolean gFU;
    private long gFV;
    private long gFW;
    private a gFb;
    private RenderView gFt;
    private String gFu;
    private g gFv;
    private g.e gFw;
    private c gFx;
    private int gGc;
    private int gGd;
    private int gGe;
    private int gGf;
    private int gGg;
    private int gGh;
    private boolean gGi;
    private Runnable gGj;
    private Runnable gGk;
    private TextureView.SurfaceTextureListener gGl;
    private g.f gGm;
    private g.a gGn;
    private g.InterfaceC0298g gGo;
    private Runnable gGp;
    private int gpG;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;
    private static int gFX = 0;
    private static int gFY = 1;
    private static int gFZ = 2;
    private static int gGa = 1;
    private static int gGb = 0;

    /* loaded from: classes.dex */
    public interface a {
        void brU();
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
            gFy = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gFz = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gFL = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gFD = false;
        this.gFF = false;
        this.gFG = 0;
        this.gFH = false;
        this.gFI = -1;
        this.gFJ = false;
        this.gFK = null;
        this.gFL = true;
        this.gFV = 0L;
        this.gFW = 0L;
        this.gpG = gGb;
        this.gGc = 0;
        this.gGd = 0;
        this.gGe = -1;
        this.gGf = 0;
        this.gGg = 0;
        this.gGh = 0;
        this.bCb = 0;
        this.gGi = false;
        this.gGj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gFv != null && QuickVideoView.this.gFD) {
                    QuickVideoView.this.b(QuickVideoView.this.gFv, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gGk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.jS(false);
                }
            }
        };
        this.gGl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gGi) {
                    QuickVideoView.this.gGi = false;
                    QuickVideoView.this.gFv.c(surfaceTexture);
                } else if (QuickVideoView.this.gFF || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gFv != null && QuickVideoView.this.gFJ) {
                        QuickVideoView.this.gFv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gFI);
                        if (QuickVideoView.this.gFb != null) {
                            QuickVideoView.this.gFb.brU();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gFA.bdj();
                        }
                    }
                } else if (bso()) {
                    if (QuickVideoView.this.gFv != null) {
                        QuickVideoView.this.bsh();
                        QuickVideoView.this.gFF = true;
                        QuickVideoView.this.gFv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gFA.bdi();
                    }
                }
                QuickVideoView.this.gFK = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gGi) {
                    QuickVideoView.this.bsj();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gFv != null) {
                        if (QuickVideoView.this.gFv.isPlaying() && QuickVideoView.this.bsm()) {
                            y.bsO().aO(QuickVideoView.this.gFR, QuickVideoView.this.gFv.getCurrentPosition());
                        }
                        QuickVideoView.this.gFv.release();
                    }
                    if (QuickVideoView.this.gFF) {
                        if (QuickVideoView.this.gFE != null) {
                            QuickVideoView.this.gFE.onStop();
                        }
                        if (QuickVideoView.this.bpd != null) {
                            QuickVideoView.this.bpd.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gFK = null;
                    if (QuickVideoView.this.gFA != null && QuickVideoView.this.gFA.si(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.gFF = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bso() {
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
        this.gGm = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tZ;
                QuickVideoView.this.bsj();
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.onPrepared();
                }
                if (QuickVideoView.this.gFA != null && QuickVideoView.this.gFv != null) {
                    QuickVideoView.this.gFA.rU(QuickVideoView.this.gFv.getPlayerType());
                }
                if (QuickVideoView.this.bxM != null) {
                    QuickVideoView.this.bxM.onPrepared(gVar);
                }
                if (QuickVideoView.this.gFE != null) {
                    long j = 0;
                    if (QuickVideoView.this.gFv != null) {
                        j = QuickVideoView.this.gFv.getDuration();
                    }
                    QuickVideoView.this.gFE.dd(j);
                    QuickVideoView.this.bsi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gFE.bsb();
                        QuickVideoView.this.bsl();
                    }
                }
                if (QuickVideoView.this.gFU && (tZ = y.bsO().tZ(QuickVideoView.this.gFR)) > 0) {
                    if (QuickVideoView.this.gFv.isPlayerReuse()) {
                        if (QuickVideoView.this.gFv.getCurrentPosition() == 0) {
                            QuickVideoView.this.tB(tZ);
                        }
                    } else {
                        QuickVideoView.this.tB(tZ);
                    }
                }
                if (QuickVideoView.this.gFD) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gFt != null && gVar != null) {
                    QuickVideoView.this.gFt.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gFG);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gFu) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gFu);
                }
                if (QuickVideoView.this.gFM != null && QuickVideoView.this.gFM.bsU()) {
                    com.baidu.tieba.play.b.e.tF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gGn = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.sh(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gFA = null;
                }
                if (!QuickVideoView.this.gFH || QuickVideoView.this.gFE == null) {
                    if (QuickVideoView.this.gFE != null) {
                        QuickVideoView.this.gFE.onCompletion();
                    }
                    QuickVideoView.this.gFD = false;
                    y.bsO().remove(QuickVideoView.this.gFR);
                    if (QuickVideoView.this.bxL != null) {
                        QuickVideoView.this.bxL.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gFC = null;
                QuickVideoView.this.gFS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gFE.brV());
                QuickVideoView.this.start();
            }
        };
        this.bxN = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bsj();
                if (QuickVideoView.this.gFE != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsm()) {
                    QuickVideoView.this.gFT = true;
                    y.bsO().aO(QuickVideoView.this.gFR, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gFA != null) {
                        QuickVideoView.this.gFC = QuickVideoView.this.gFA.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gFS, QuickVideoView.this.N(QuickVideoView.this.gFA.bdn(), i3 + "", QuickVideoView.this.gFA.bdo()));
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.gFS = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.boZ == null || QuickVideoView.this.boZ.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gGo = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gFT) {
                    QuickVideoView.this.gFT = false;
                    return;
                }
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.bsy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gFE != null && z) {
                    QuickVideoView.this.gFE.onSeekComplete();
                }
                if (QuickVideoView.this.bxP != null) {
                    QuickVideoView.this.bxP.b(gVar);
                }
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gFw != null) {
                    QuickVideoView.this.gFw.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gFG = i2;
                    if (QuickVideoView.this.gFt != null && gVar != null) {
                        QuickVideoView.this.gFt.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gFG);
                    }
                }
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.a(i, i2, QuickVideoView.this.gFA);
                    return true;
                }
                return true;
            }
        };
        this.bxQ = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.f(i, i2, str);
                }
            }
        };
        this.bxR = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.sj(str);
                }
            }
        };
        this.bxS = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gFS = j;
                }
            }
        };
        this.gGp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gFE != null && QuickVideoView.this.gFE.brX() && QuickVideoView.this.gFE.brY() && QuickVideoView.this.gFE.brZ() && QuickVideoView.this.gFv != null) {
                    int UP = QuickVideoView.this.gFv.UP();
                    int currentPosition = QuickVideoView.this.gFv.getCurrentPosition();
                    int duration = QuickVideoView.this.gFv.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gFV;
                    boolean z = currentPosition + UP < duration;
                    if (UP < QuickVideoView.this.gFE.bsa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gFV = currentTimeMillis;
                        QuickVideoView.this.gFE.tA(0);
                    }
                    if (QuickVideoView.this.bsk() && currentPosition == QuickVideoView.this.gFW && j > 500) {
                        QuickVideoView.this.gFV = currentTimeMillis;
                        QuickVideoView.this.gFE.tA(0);
                    }
                    QuickVideoView.this.gFW = currentPosition;
                    if (QuickVideoView.this.gpG == QuickVideoView.gGa) {
                        QuickVideoView.this.bsl();
                    }
                }
            }
        };
        this.bxY = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gFE != null) {
                        QuickVideoView.this.gFE.bsd();
                    }
                    if (QuickVideoView.this.gFA != null) {
                        QuickVideoView.this.gFA.sg(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.bsj();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gFD = false;
        this.gFF = false;
        this.gFG = 0;
        this.gFH = false;
        this.gFI = -1;
        this.gFJ = false;
        this.gFK = null;
        this.gFL = true;
        this.gFV = 0L;
        this.gFW = 0L;
        this.gpG = gGb;
        this.gGc = 0;
        this.gGd = 0;
        this.gGe = -1;
        this.gGf = 0;
        this.gGg = 0;
        this.gGh = 0;
        this.bCb = 0;
        this.gGi = false;
        this.gGj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gFv != null && QuickVideoView.this.gFD) {
                    QuickVideoView.this.b(QuickVideoView.this.gFv, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gGk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.jS(false);
                }
            }
        };
        this.gGl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gGi) {
                    QuickVideoView.this.gGi = false;
                    QuickVideoView.this.gFv.c(surfaceTexture);
                } else if (QuickVideoView.this.gFF || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gFv != null && QuickVideoView.this.gFJ) {
                        QuickVideoView.this.gFv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gFI);
                        if (QuickVideoView.this.gFb != null) {
                            QuickVideoView.this.gFb.brU();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gFA.bdj();
                        }
                    }
                } else if (bso()) {
                    if (QuickVideoView.this.gFv != null) {
                        QuickVideoView.this.bsh();
                        QuickVideoView.this.gFF = true;
                        QuickVideoView.this.gFv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gFA.bdi();
                    }
                }
                QuickVideoView.this.gFK = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gGi) {
                    QuickVideoView.this.bsj();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gFv != null) {
                        if (QuickVideoView.this.gFv.isPlaying() && QuickVideoView.this.bsm()) {
                            y.bsO().aO(QuickVideoView.this.gFR, QuickVideoView.this.gFv.getCurrentPosition());
                        }
                        QuickVideoView.this.gFv.release();
                    }
                    if (QuickVideoView.this.gFF) {
                        if (QuickVideoView.this.gFE != null) {
                            QuickVideoView.this.gFE.onStop();
                        }
                        if (QuickVideoView.this.bpd != null) {
                            QuickVideoView.this.bpd.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gFK = null;
                    if (QuickVideoView.this.gFA != null && QuickVideoView.this.gFA.si(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.gFF = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bso() {
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
        this.gGm = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tZ;
                QuickVideoView.this.bsj();
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.onPrepared();
                }
                if (QuickVideoView.this.gFA != null && QuickVideoView.this.gFv != null) {
                    QuickVideoView.this.gFA.rU(QuickVideoView.this.gFv.getPlayerType());
                }
                if (QuickVideoView.this.bxM != null) {
                    QuickVideoView.this.bxM.onPrepared(gVar);
                }
                if (QuickVideoView.this.gFE != null) {
                    long j = 0;
                    if (QuickVideoView.this.gFv != null) {
                        j = QuickVideoView.this.gFv.getDuration();
                    }
                    QuickVideoView.this.gFE.dd(j);
                    QuickVideoView.this.bsi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gFE.bsb();
                        QuickVideoView.this.bsl();
                    }
                }
                if (QuickVideoView.this.gFU && (tZ = y.bsO().tZ(QuickVideoView.this.gFR)) > 0) {
                    if (QuickVideoView.this.gFv.isPlayerReuse()) {
                        if (QuickVideoView.this.gFv.getCurrentPosition() == 0) {
                            QuickVideoView.this.tB(tZ);
                        }
                    } else {
                        QuickVideoView.this.tB(tZ);
                    }
                }
                if (QuickVideoView.this.gFD) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gFt != null && gVar != null) {
                    QuickVideoView.this.gFt.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gFG);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gFu) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gFu);
                }
                if (QuickVideoView.this.gFM != null && QuickVideoView.this.gFM.bsU()) {
                    com.baidu.tieba.play.b.e.tF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gGn = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.sh(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gFA = null;
                }
                if (!QuickVideoView.this.gFH || QuickVideoView.this.gFE == null) {
                    if (QuickVideoView.this.gFE != null) {
                        QuickVideoView.this.gFE.onCompletion();
                    }
                    QuickVideoView.this.gFD = false;
                    y.bsO().remove(QuickVideoView.this.gFR);
                    if (QuickVideoView.this.bxL != null) {
                        QuickVideoView.this.bxL.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gFC = null;
                QuickVideoView.this.gFS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gFE.brV());
                QuickVideoView.this.start();
            }
        };
        this.bxN = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bsj();
                if (QuickVideoView.this.gFE != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsm()) {
                    QuickVideoView.this.gFT = true;
                    y.bsO().aO(QuickVideoView.this.gFR, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gFA != null) {
                        QuickVideoView.this.gFC = QuickVideoView.this.gFA.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gFS, QuickVideoView.this.N(QuickVideoView.this.gFA.bdn(), i3 + "", QuickVideoView.this.gFA.bdo()));
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.gFS = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.boZ == null || QuickVideoView.this.boZ.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gGo = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gFT) {
                    QuickVideoView.this.gFT = false;
                    return;
                }
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.bsy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gFE != null && z) {
                    QuickVideoView.this.gFE.onSeekComplete();
                }
                if (QuickVideoView.this.bxP != null) {
                    QuickVideoView.this.bxP.b(gVar);
                }
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gFw != null) {
                    QuickVideoView.this.gFw.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gFG = i2;
                    if (QuickVideoView.this.gFt != null && gVar != null) {
                        QuickVideoView.this.gFt.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gFG);
                    }
                }
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.a(i, i2, QuickVideoView.this.gFA);
                    return true;
                }
                return true;
            }
        };
        this.bxQ = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.f(i, i2, str);
                }
            }
        };
        this.bxR = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.sj(str);
                }
            }
        };
        this.bxS = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gFS = j;
                }
            }
        };
        this.gGp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gFE != null && QuickVideoView.this.gFE.brX() && QuickVideoView.this.gFE.brY() && QuickVideoView.this.gFE.brZ() && QuickVideoView.this.gFv != null) {
                    int UP = QuickVideoView.this.gFv.UP();
                    int currentPosition = QuickVideoView.this.gFv.getCurrentPosition();
                    int duration = QuickVideoView.this.gFv.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gFV;
                    boolean z = currentPosition + UP < duration;
                    if (UP < QuickVideoView.this.gFE.bsa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gFV = currentTimeMillis;
                        QuickVideoView.this.gFE.tA(0);
                    }
                    if (QuickVideoView.this.bsk() && currentPosition == QuickVideoView.this.gFW && j > 500) {
                        QuickVideoView.this.gFV = currentTimeMillis;
                        QuickVideoView.this.gFE.tA(0);
                    }
                    QuickVideoView.this.gFW = currentPosition;
                    if (QuickVideoView.this.gpG == QuickVideoView.gGa) {
                        QuickVideoView.this.bsl();
                    }
                }
            }
        };
        this.bxY = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gFE != null) {
                        QuickVideoView.this.gFE.bsd();
                    }
                    if (QuickVideoView.this.gFA != null) {
                        QuickVideoView.this.gFA.sg(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.bsj();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gFD = false;
        this.gFF = false;
        this.gFG = 0;
        this.gFH = false;
        this.gFI = -1;
        this.gFJ = false;
        this.gFK = null;
        this.gFL = true;
        this.gFV = 0L;
        this.gFW = 0L;
        this.gpG = gGb;
        this.gGc = 0;
        this.gGd = 0;
        this.gGe = -1;
        this.gGf = 0;
        this.gGg = 0;
        this.gGh = 0;
        this.bCb = 0;
        this.gGi = false;
        this.gGj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gFv != null && QuickVideoView.this.gFD) {
                    QuickVideoView.this.b(QuickVideoView.this.gFv, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gGk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.jS(false);
                }
            }
        };
        this.gGl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gGi) {
                    QuickVideoView.this.gGi = false;
                    QuickVideoView.this.gFv.c(surfaceTexture);
                } else if (QuickVideoView.this.gFF || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gFv != null && QuickVideoView.this.gFJ) {
                        QuickVideoView.this.gFv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gFI);
                        if (QuickVideoView.this.gFb != null) {
                            QuickVideoView.this.gFb.brU();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gFA.bdj();
                        }
                    }
                } else if (bso()) {
                    if (QuickVideoView.this.gFv != null) {
                        QuickVideoView.this.bsh();
                        QuickVideoView.this.gFF = true;
                        QuickVideoView.this.gFv.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gFA.bdi();
                    }
                }
                QuickVideoView.this.gFK = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gGi) {
                    QuickVideoView.this.bsj();
                    QuickVideoView.this.mD(false);
                    if (QuickVideoView.this.gFv != null) {
                        if (QuickVideoView.this.gFv.isPlaying() && QuickVideoView.this.bsm()) {
                            y.bsO().aO(QuickVideoView.this.gFR, QuickVideoView.this.gFv.getCurrentPosition());
                        }
                        QuickVideoView.this.gFv.release();
                    }
                    if (QuickVideoView.this.gFF) {
                        if (QuickVideoView.this.gFE != null) {
                            QuickVideoView.this.gFE.onStop();
                        }
                        if (QuickVideoView.this.bpd != null) {
                            QuickVideoView.this.bpd.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gFK = null;
                    if (QuickVideoView.this.gFA != null && QuickVideoView.this.gFA.si(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.gFF = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bso() {
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
        this.gGm = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tZ;
                QuickVideoView.this.bsj();
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.onPrepared();
                }
                if (QuickVideoView.this.gFA != null && QuickVideoView.this.gFv != null) {
                    QuickVideoView.this.gFA.rU(QuickVideoView.this.gFv.getPlayerType());
                }
                if (QuickVideoView.this.bxM != null) {
                    QuickVideoView.this.bxM.onPrepared(gVar);
                }
                if (QuickVideoView.this.gFE != null) {
                    long j = 0;
                    if (QuickVideoView.this.gFv != null) {
                        j = QuickVideoView.this.gFv.getDuration();
                    }
                    QuickVideoView.this.gFE.dd(j);
                    QuickVideoView.this.bsi();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gFE.bsb();
                        QuickVideoView.this.bsl();
                    }
                }
                if (QuickVideoView.this.gFU && (tZ = y.bsO().tZ(QuickVideoView.this.gFR)) > 0) {
                    if (QuickVideoView.this.gFv.isPlayerReuse()) {
                        if (QuickVideoView.this.gFv.getCurrentPosition() == 0) {
                            QuickVideoView.this.tB(tZ);
                        }
                    } else {
                        QuickVideoView.this.tB(tZ);
                    }
                }
                if (QuickVideoView.this.gFD) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gFt != null && gVar != null) {
                    QuickVideoView.this.gFt.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gFG);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gFu) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gFu);
                }
                if (QuickVideoView.this.gFM != null && QuickVideoView.this.gFM.bsU()) {
                    com.baidu.tieba.play.b.e.tF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gGn = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mD(true);
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.sh(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gFA = null;
                }
                if (!QuickVideoView.this.gFH || QuickVideoView.this.gFE == null) {
                    if (QuickVideoView.this.gFE != null) {
                        QuickVideoView.this.gFE.onCompletion();
                    }
                    QuickVideoView.this.gFD = false;
                    y.bsO().remove(QuickVideoView.this.gFR);
                    if (QuickVideoView.this.bxL != null) {
                        QuickVideoView.this.bxL.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gFC = null;
                QuickVideoView.this.gFS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gFE.brV());
                QuickVideoView.this.start();
            }
        };
        this.bxN = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.bsj();
                if (QuickVideoView.this.gFE != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.bsm()) {
                    QuickVideoView.this.gFT = true;
                    y.bsO().aO(QuickVideoView.this.gFR, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gFA != null) {
                        QuickVideoView.this.gFC = QuickVideoView.this.gFA.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gFS, QuickVideoView.this.N(QuickVideoView.this.gFA.bdn(), i3 + "", QuickVideoView.this.gFA.bdo()));
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.gFS = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.tD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.boZ == null || QuickVideoView.this.boZ.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gGo = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gFT) {
                    QuickVideoView.this.gFT = false;
                    return;
                }
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.bsy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gFE != null && z) {
                    QuickVideoView.this.gFE.onSeekComplete();
                }
                if (QuickVideoView.this.bxP != null) {
                    QuickVideoView.this.bxP.b(gVar);
                }
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gFw != null) {
                    QuickVideoView.this.gFw.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gFG = i22;
                    if (QuickVideoView.this.gFt != null && gVar != null) {
                        QuickVideoView.this.gFt.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gFG);
                    }
                }
                if (QuickVideoView.this.gFN != null) {
                    QuickVideoView.this.gFN.a(i2, i22, QuickVideoView.this.gFA);
                    return true;
                }
                return true;
            }
        };
        this.bxQ = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.f(i2, i22, str);
                }
            }
        };
        this.bxR = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gFA != null) {
                    QuickVideoView.this.gFA.sj(str);
                }
            }
        };
        this.bxS = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gFS = j;
                }
            }
        };
        this.gGp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gFE != null && QuickVideoView.this.gFE.brX() && QuickVideoView.this.gFE.brY() && QuickVideoView.this.gFE.brZ() && QuickVideoView.this.gFv != null) {
                    int UP = QuickVideoView.this.gFv.UP();
                    int currentPosition = QuickVideoView.this.gFv.getCurrentPosition();
                    int duration = QuickVideoView.this.gFv.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gFV;
                    boolean z = currentPosition + UP < duration;
                    if (UP < QuickVideoView.this.gFE.bsa() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gFV = currentTimeMillis;
                        QuickVideoView.this.gFE.tA(0);
                    }
                    if (QuickVideoView.this.bsk() && currentPosition == QuickVideoView.this.gFW && j > 500) {
                        QuickVideoView.this.gFV = currentTimeMillis;
                        QuickVideoView.this.gFE.tA(0);
                    }
                    QuickVideoView.this.gFW = currentPosition;
                    if (QuickVideoView.this.gpG == QuickVideoView.gGa) {
                        QuickVideoView.this.bsl();
                    }
                }
            }
        };
        this.bxY = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gFE != null) {
                        QuickVideoView.this.gFE.bsd();
                    }
                    if (QuickVideoView.this.gFA != null) {
                        QuickVideoView.this.gFA.sg(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gFA = null;
                    }
                    QuickVideoView.this.bsj();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gFt = new RenderView(context);
        this.gFt.setSurfaceTextureListener(this.gGl);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gFL) {
            addView(this.gFt, layoutParams);
        } else {
            addView(this.gFt, 0, layoutParams);
        }
        if (gFy != null) {
            this.gFv = gFy.UQ();
        }
        if (this.gFv != null) {
            this.gFv.setOnPreparedListener(this.gGm);
            this.gFv.setOnCompletionListener(this.gGn);
            this.gFv.a(this.bxN);
            this.gFv.setOnSeekCompleteListener(this.gGo);
            this.gFv.a(this.bxO);
            this.gFv.a(this.bxQ);
            this.gFv.a(this.bxR);
            this.gFv.a(this.bxS);
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
        this.gFM = new com.baidu.tieba.play.b.a(this);
        this.gFN = new r();
        this.gFO = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iQ().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.gFU = z;
    }

    public void setVideoPath(String str, String str2) {
        this.biz = str2;
        if (this.gFM != null) {
            this.gFM.clear();
            this.gFM.bsU();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.ue(str2);
            if (gFz != null) {
                this.gFA = gFz.M(this.biz, str, "");
                if (this.gFA != null) {
                    this.gFA.a(ReportLevel.USER, -44399, -44399, getLocateSource(), false, this.gFS, "");
                    this.gFA = null;
                }
            }
        }
        if (this.gFB != null) {
            this.gFB.a(null);
            this.gFB.bdb();
            this.gFB = null;
        }
        this.gFC = null;
        this.gFS = 0L;
        setVideoPath(str);
    }

    public void ct(String str, String str2) {
    }

    private String tV(String str) {
        if (!ao.isEmpty(str) && com.baidu.tieba.video.g.bIG().bIH()) {
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
            String tV = tV(str);
            this.gFP = tV;
            if (this.gFE != null) {
                tV = this.gFE.jB(tV);
                if (this.gFE.bsc() != null) {
                    this.gFE.bsc().setPlayer(this);
                }
                if (gFz != null && hd(tV)) {
                    this.gFB = gFz.sm(tV);
                }
                if (this.gFB != null) {
                    this.gFB.a(new com.baidu.tieba.play.monitor.a(this.biz, this.gFP, this.gFA));
                    this.gFB.bda();
                }
                tW(tV);
            }
            if (!com.baidu.adp.lib.util.j.kV() && !hd(tV)) {
                if (this.boZ != null) {
                    this.boZ.onError(this.gFv, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(tV));
            if (this.gFA != null) {
                if (g(Uri.parse(tV)) != null) {
                    this.gFA.bdh();
                }
                this.gFA.report();
                this.gFA = null;
            }
            this.gFQ = str;
            int lastIndexOf = this.gFQ.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.gFQ.length() > 4) {
                this.gFR = this.gFQ.substring(0, lastIndexOf + 4);
            } else {
                this.gFR = this.gFQ;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsh() {
        if (com.baidu.tbadk.coreExtra.model.f.JU()) {
            if (this.gFE != null && (this.gFE.brW() || this.gFE.brX())) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGj);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.gGj, com.baidu.tbadk.coreExtra.model.f.JT());
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGk);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gGk, com.baidu.tbadk.coreExtra.model.f.JS());
        }
    }

    public void brx() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (g(uri) != null) {
            this.gFA.sf(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            UL();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.gFG = 0;
        if (this.gFK != null) {
            bsh();
            if (this.gFv != null) {
                if (!this.gFF) {
                    this.gFF = true;
                    this.gFv.a(this.mContext, this.mUri, this.mHeaders, this.gFK, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gGm.onPrepared(this.gFv);
                }
            }
        } else if (this.gFt != null && this.gFt.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.gFL) {
                addView(this.gFt, layoutParams);
            } else {
                addView(this.gFt, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void UL() {
        this.gFF = false;
        this.gFD = false;
        if (this.gFv != null) {
            if (this.gFv.isPlaying() && bsm()) {
                y.bsO().aO(this.gFR, this.gFv.getCurrentPosition());
            }
            this.gFv.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGp);
    }

    private void tW(String str) {
        this.gGd = 0;
        this.gGe = 0;
        this.gGf = 0;
        this.gGg = 0;
        this.gGh = 0;
        this.bCb = 0;
        if (this.gFE.brX()) {
            this.gGc = gFY;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gGe = (int) u.tY(QuickVideoView.this.gFP);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gFP != null && this.gFP.equals(str)) {
            this.gGc = gFX;
        } else {
            this.gGc = gFZ;
        }
        this.gpG = gGa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsi() {
        this.gpG = gGa;
        if (this.gFv != null) {
            this.gGd = this.gFv.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(boolean z) {
        if (this.gpG == gGa && this.gFv != null) {
            this.gpG = gGb;
            this.gGg = this.gFv.getDuration();
            if (z) {
                this.gGh = 0;
                this.gGf = this.gGg;
            } else {
                this.gGf = this.gFv.getCurrentPosition();
                this.gGh = this.gFv.getCachedSize();
            }
            if (this.gGf > 0) {
                if (this.gGc == gFX) {
                    this.gGe = (int) u.tY(this.gFP);
                    if (this.gGd > 0) {
                        long j = (this.gGd * (this.gGf / 1000)) / 8;
                        if (this.gGh < 0) {
                            this.gGh = 0;
                        }
                        long j2 = this.gGh + j;
                        if (this.gGe > 0) {
                            j2 += this.gGe;
                        }
                        setFlowCount(j2, this.gGf, this.gGg, this.bCb);
                    } else if (this.gGd == -1) {
                        this.gGd = 603327;
                        setFlowCount((this.gGd * (this.gGf / 1000)) / 8, this.gGf, this.gGg, this.bCb);
                    }
                } else if (this.gGc == gFY) {
                    if (this.gGd > 0) {
                        long j3 = (this.gGd * (this.gGf / 1000)) / 8;
                        if (this.gGh < 0) {
                            this.gGh = 0;
                        }
                        long j4 = this.gGh + j3;
                        if (this.gGe > 0) {
                            j4 -= this.gGe;
                        }
                        setFlowCount(j4, this.gGf, this.gGg, this.bCb);
                    } else if (this.gGd == -1) {
                        this.gGd = 603327;
                        setFlowCount((this.gGd * (this.gGf / 1000)) / 8, this.gGf, this.gGg, this.bCb);
                    }
                } else {
                    setFlowCount(0L, this.gGf, this.gGg, this.bCb);
                }
            }
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGp);
    }

    public void stopPlayback() {
        bsj();
        mD(false);
        if (this.gFM != null) {
            this.gFM.clear();
        }
        this.gFu = null;
        UL();
        this.gFH = false;
        if (this.gFE != null) {
            this.gFE.onStop();
        }
        com.baidu.tieba.play.a.b.bsR().a((b.InterfaceC0295b) null);
        if (this.gFA != null && this.gFA.si(getLocateSource())) {
            this.gFA = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGp);
    }

    public void setFullScreenToDestroySurface() {
        this.gGi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGj);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGk);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bxM = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bxL = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.boZ = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0298g interfaceC0298g) {
        this.bxP = interfaceC0298g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(String str, String str2, String str3) {
        if (this.gFO == null) {
            return "";
        }
        String bsW = this.gFO.bsW();
        this.gFO.O(str, str2, str3);
        return bsW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gFE != null && !StringUtils.isNull(this.gFE.brV())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.ud(uri);
                }
            }
            this.mUri = Uri.parse(this.gFE.brV());
        }
        boolean z = false;
        if (this.gFM != null) {
            z = this.gFM.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gFA != null) {
            this.gFC = this.gFA.a(i, i2, i3, getLocateSource(), z, this.gFS, N(this.gFA.bdn(), i3 + "", this.gFA.bdo()));
            this.gFA = null;
        }
        this.gFS = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gFv != null) {
            try {
                if (this.gFv.isPlaying() && bsm()) {
                    y.bsO().aO(this.gFR, this.gFv.getCurrentPosition());
                }
                this.gFv.release();
                this.gFu = str;
                URI uri = new URI(this.mUri.toString());
                this.gFv.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.gFK, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (g(this.mUri) != null) {
                    this.gFA.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gFv != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.gFv.isPlaying() && bsm()) {
                y.bsO().aO(this.gFR, this.gFv.getCurrentPosition());
            }
            this.gFv.release();
            this.gFv.a(this.mContext, this.mUri, this.mHeaders, this.gFK, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gFA.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gFv != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gFv.forceUseSystemMediaPlayer(true);
            }
            if (this.gFv.isPlaying() && bsm()) {
                y.bsO().aO(this.gFR, this.gFv.getCurrentPosition());
            }
            this.gFv.release();
            this.gFv.a(this.mContext, this.mUri, this.mHeaders, this.gFK, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gFA.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gFD = true;
        if (this.gFv != null) {
            if (this.gFK != null && this.gFJ && !this.gFv.isExistInRemote()) {
                this.gFv.a(this.mContext, this.mUri, this.mHeaders, this.gFK, this.gFI);
                if (this.gFb != null) {
                    this.gFb.brU();
                }
                if (g(this.mUri) != null) {
                    this.gFA.bdj();
                }
                bsh();
                return;
            }
            this.gFv.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gFE != null) {
            this.gFE.onStart();
        }
        if (this.gFx != null) {
            this.gFx.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (g(this.mUri) != null && this.gFv != null) {
            this.gFA.rV(this.gFv.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bsj();
        if (this.gFv != null) {
            if (this.gFv.isPlaying() && bsm()) {
                y.bsO().aO(this.gFR, this.gFv.getCurrentPosition());
            }
            this.gFv.pause();
        }
        if (this.gFE != null) {
            this.gFE.onPause();
        }
        this.gFD = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gFA != null) {
            this.gFA.bdm();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gFv != null) {
            return this.gFv.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gFv != null) {
            return this.gFv.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bCb = i;
        tB(i);
    }

    public void tB(int i) {
        if (this.gFN != null) {
            this.gFN.bsx();
        }
        if (this.gFv != null) {
            this.gFv.seekTo(i);
        }
        if (this.gFE != null) {
            this.gFE.tA(0);
            bsl();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gFv != null) {
            return this.gFv.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gFv != null) {
            this.gFv.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gFI = i;
    }

    public int getRecoveryState() {
        return this.gFI;
    }

    public void setNeedRecovery(boolean z) {
        this.gFJ = z;
    }

    public void setLooping(boolean z) {
        this.gFH = z;
    }

    public boolean bsk() {
        return this.gFD;
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
        this.bpd = bVar;
    }

    public void setBusiness(d dVar) {
        this.gFE = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bxY);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gFH = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gFv != null) {
            this.gFv.Qe();
        }
        if (this.gFN != null) {
            this.gFN.bsz();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGp);
        MessageManager.getInstance().unRegisterListener(this.bxY);
        if (this.gFM != null) {
            this.gFM.clear();
        }
        if (this.gFB != null) {
            this.gFB.a(null);
            this.gFB.bdb();
        }
    }

    public g getPlayer() {
        return this.gFv;
    }

    public int getPlayerType() {
        return this.gFv == null ? ReportLevel.USER : this.gFv.getPlayerType();
    }

    public void bsl() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGp);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gGp, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gFb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gFE instanceof n) || ((n) this.gFE).bsv() == null) ? "" : ((n) this.gFE).bsv().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i g(Uri uri) {
        String uri2;
        if (this.gFA != null) {
            return this.gFA;
        }
        if (!StringUtils.isNull(this.gFP)) {
            uri2 = this.gFP;
        } else if (gFz != null && this.gFE != null && !StringUtils.isNull(this.gFE.brV())) {
            uri2 = this.gFE.brV();
        } else {
            uri2 = (gFz == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gFz != null) {
            this.gFA = gFz.M(this.biz, uri2, this.gFC);
        }
        this.gFC = null;
        this.gFS = 0L;
        return this.gFA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsm() {
        return this.gFv != null && this.gFv.getDuration() >= this.gFv.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gFA, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gFA, j);
    }

    public static boolean hd(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gFw = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gFv != null) {
            return this.gFv.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gFv != null ? this.gFv.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.gFA != null) {
            this.gFA.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.gFx = cVar;
    }
}
