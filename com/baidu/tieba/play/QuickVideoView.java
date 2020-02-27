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
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.network.http.a.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.switchs.VideoPlayerReuseSwitch;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a, com.baidu.tieba.play.b.c {
    private static h eeY;
    private static com.baidu.tieba.k.l eeZ;
    private static int jvf = 0;
    private static int jvg = 1;
    private static int jvh = 2;
    private static int jvi = 1;
    private static int jvj = 0;
    private WeakReference<Context> Pf;
    private String Pj;
    private TextureView.SurfaceTextureListener aXO;
    private g.b dMf;
    private b dMj;
    private g.a dVb;
    private g.f dVc;
    private g.c dVd;
    private g.e dVe;
    private g.InterfaceC0590g dVf;
    private g.i dVg;
    private g.d dVh;
    private g.h dVi;
    private final CustomMessageListener dVp;
    private int dZZ;
    private boolean eeQ;
    private g.f efa;
    private g.a efb;
    private g.InterfaceC0590g efe;
    private RenderView juC;
    private String juD;
    private g juE;
    private g.e juF;
    private c juG;
    private com.baidu.tieba.k.i juH;
    private com.baidu.tieba.k.e juI;
    private String juJ;
    private boolean juK;
    private d juL;
    private com.baidu.tieba.k.k juM;
    private boolean juN;
    private int juO;
    private int juP;
    private boolean juQ;
    private SurfaceTexture juR;
    private boolean juS;
    private com.baidu.tieba.play.b.a juT;
    private q juU;
    private com.baidu.tieba.play.b.f juV;
    private String juW;
    private String juX;
    private String juY;
    private long juZ;
    private a jui;
    private boolean jva;
    private boolean jvb;
    private boolean jvc;
    private long jvd;
    private long jve;
    private int jvk;
    private int jvl;
    private int jvm;
    private int jvn;
    private int jvo;
    private int jvp;
    private boolean jvq;
    private Runnable jvr;
    private Runnable jvs;
    public boolean jvt;
    private Runnable jvu;
    private int mBitRate;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cyr();
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            eeY = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            eeZ = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.juS = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.juK = false;
        this.juN = false;
        this.juO = 0;
        this.eeQ = false;
        this.juP = -1;
        this.juQ = false;
        this.juR = null;
        this.juS = true;
        this.jvc = false;
        this.jvd = 0L;
        this.jve = 0L;
        this.jvk = jvj;
        this.jvl = 0;
        this.mBitRate = 0;
        this.jvm = -1;
        this.jvn = 0;
        this.jvo = 0;
        this.jvp = 0;
        this.dZZ = 0;
        this.jvq = false;
        this.Pf = null;
        this.jvr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juE != null && QuickVideoView.this.juK) {
                    QuickVideoView.this.b(QuickVideoView.this.juE, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.oR(false);
                }
            }
        };
        this.jvt = false;
        this.aXO = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jvq) {
                    QuickVideoView.this.jvq = false;
                    if (QuickVideoView.this.juE != null) {
                        QuickVideoView.this.juE.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.juN || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juE != null) {
                        if (QuickVideoView.this.cyQ()) {
                            QuickVideoView.this.juE.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juQ) {
                            QuickVideoView.this.juE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.juP);
                            if (QuickVideoView.this.jui != null) {
                                QuickVideoView.this.jui.cyr();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juH.cgE();
                            }
                        }
                    }
                } else if (cyT()) {
                    if (QuickVideoView.this.juE != null) {
                        QuickVideoView.this.cyH();
                        QuickVideoView.this.juN = true;
                        QuickVideoView.this.juE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juH.cgD();
                    }
                }
                QuickVideoView.this.juR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvq) {
                    QuickVideoView.this.cyJ();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juE != null) {
                        if (QuickVideoView.this.juE.isPlaying() && QuickVideoView.this.cyO()) {
                            x.czq().bl(QuickVideoView.this.juY, QuickVideoView.this.juE.getCurrentPosition());
                            if (QuickVideoView.this.jvc) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jvc) {
                            QuickVideoView.this.juE.release();
                        }
                    }
                    if (QuickVideoView.this.juN) {
                        if (QuickVideoView.this.juL != null && !QuickVideoView.this.jvc) {
                            QuickVideoView.this.juL.GY(QuickVideoView.this.juX);
                        }
                        if (QuickVideoView.this.dMj != null) {
                            QuickVideoView.this.dMj.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.juR = null;
                    if (QuickVideoView.this.juH != null && QuickVideoView.this.juH.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juH = null;
                    }
                    if (!QuickVideoView.this.jvc) {
                        QuickVideoView.this.juN = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyT() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
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
        this.efa = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.cyJ();
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.onPrepared();
                }
                if (QuickVideoView.this.juH != null && QuickVideoView.this.juE != null) {
                    QuickVideoView.this.juH.yh(QuickVideoView.this.juE.getPlayerType());
                }
                if (QuickVideoView.this.jvc) {
                    TbVideoViewSet.czt().a(QuickVideoView.this, QuickVideoView.this.juX);
                }
                if (QuickVideoView.this.dVc != null) {
                    QuickVideoView.this.juM.cgU();
                    QuickVideoView.this.dVc.onPrepared(gVar);
                }
                if (QuickVideoView.this.juL != null) {
                    long j = 0;
                    if (QuickVideoView.this.juE != null) {
                        j = QuickVideoView.this.juE.getDuration();
                    }
                    QuickVideoView.this.juL.ew(j);
                    QuickVideoView.this.cyI();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juL.cyB();
                        QuickVideoView.this.cyN();
                    }
                }
                if (QuickVideoView.this.jvb && (Hd = x.czq().Hd(QuickVideoView.this.juY)) > 0 && QuickVideoView.this.juE != null) {
                    if (QuickVideoView.this.juE.isPlayerReuse()) {
                        if (QuickVideoView.this.juE.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(Hd);
                        }
                    } else {
                        QuickVideoView.this.As(Hd);
                    }
                }
                if (QuickVideoView.this.juK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juC != null && gVar != null) {
                    QuickVideoView.this.juC.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juO);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juD) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juD);
                }
                if (QuickVideoView.this.juT != null && QuickVideoView.this.juT.czL()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efb = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juH = null;
                }
                if (!QuickVideoView.this.eeQ || QuickVideoView.this.juL == null) {
                    if (QuickVideoView.this.juL != null) {
                        QuickVideoView.this.juL.onCompletion();
                    }
                    QuickVideoView.this.juK = false;
                    x.czq().remove(QuickVideoView.this.juY);
                    if (QuickVideoView.this.dVb != null) {
                        QuickVideoView.this.dVb.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juJ = null;
                QuickVideoView.this.juZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juL.cyu());
                QuickVideoView.this.start();
            }
        };
        this.dVd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.cyJ();
                if (QuickVideoView.this.juL != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyO()) {
                    QuickVideoView.this.jva = true;
                    x.czq().bl(QuickVideoView.this.juY, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czt().Hf(QuickVideoView.this.juX);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juH != null) {
                        QuickVideoView.this.juJ = QuickVideoView.this.juH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.juZ, QuickVideoView.this.aq(QuickVideoView.this.juH.cgI(), i3 + "", QuickVideoView.this.juH.cgJ()));
                        QuickVideoView.this.juH = null;
                    }
                    QuickVideoView.this.juZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMf == null || QuickVideoView.this.dMf.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.efe = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jva) {
                    QuickVideoView.this.jva = false;
                    return;
                }
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.czc();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juL != null && z) {
                    QuickVideoView.this.juL.onSeekComplete();
                }
                if (QuickVideoView.this.dVf != null) {
                    QuickVideoView.this.dVf.b(gVar);
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.juF != null) {
                    QuickVideoView.this.juF.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.juO = i2;
                    if (QuickVideoView.this.juC != null && gVar != null) {
                        QuickVideoView.this.juC.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juO);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.juM.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.a(i, i2, QuickVideoView.this.juH);
                    return true;
                }
                return true;
            }
        };
        this.dVg = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.m(i, i2, str);
                }
            }
        };
        this.dVh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.Fg(str);
                }
            }
        };
        this.dVi = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.juZ = j;
                }
            }
        };
        this.jvu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juL != null && QuickVideoView.this.juL.cyx() && QuickVideoView.this.juL.cyy() && QuickVideoView.this.juL.cyz() && QuickVideoView.this.juE != null) {
                    int aWE = QuickVideoView.this.juE.aWE();
                    int currentPosition = QuickVideoView.this.juE.getCurrentPosition();
                    int duration = QuickVideoView.this.juE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvd;
                    boolean z = currentPosition + aWE < duration;
                    if (aWE < QuickVideoView.this.juL.cyA() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvd = currentTimeMillis;
                        QuickVideoView.this.juL.Ap(0);
                    }
                    if (QuickVideoView.this.cyM() && currentPosition == QuickVideoView.this.jve && j > 500) {
                        QuickVideoView.this.jvd = currentTimeMillis;
                        QuickVideoView.this.juL.Ap(0);
                    }
                    QuickVideoView.this.jve = currentPosition;
                    if (QuickVideoView.this.jvk == QuickVideoView.jvi) {
                        QuickVideoView.this.cyN();
                    }
                }
            }
        };
        this.dVp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juL != null) {
                        QuickVideoView.this.juL.wJ(QuickVideoView.this.juX);
                    }
                    if (QuickVideoView.this.juH != null) {
                        QuickVideoView.this.juH.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juH = null;
                    }
                    QuickVideoView.this.cyJ();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.juK = false;
        this.juN = false;
        this.juO = 0;
        this.eeQ = false;
        this.juP = -1;
        this.juQ = false;
        this.juR = null;
        this.juS = true;
        this.jvc = false;
        this.jvd = 0L;
        this.jve = 0L;
        this.jvk = jvj;
        this.jvl = 0;
        this.mBitRate = 0;
        this.jvm = -1;
        this.jvn = 0;
        this.jvo = 0;
        this.jvp = 0;
        this.dZZ = 0;
        this.jvq = false;
        this.Pf = null;
        this.jvr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juE != null && QuickVideoView.this.juK) {
                    QuickVideoView.this.b(QuickVideoView.this.juE, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.oR(false);
                }
            }
        };
        this.jvt = false;
        this.aXO = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jvq) {
                    QuickVideoView.this.jvq = false;
                    if (QuickVideoView.this.juE != null) {
                        QuickVideoView.this.juE.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.juN || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juE != null) {
                        if (QuickVideoView.this.cyQ()) {
                            QuickVideoView.this.juE.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juQ) {
                            QuickVideoView.this.juE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.juP);
                            if (QuickVideoView.this.jui != null) {
                                QuickVideoView.this.jui.cyr();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juH.cgE();
                            }
                        }
                    }
                } else if (cyT()) {
                    if (QuickVideoView.this.juE != null) {
                        QuickVideoView.this.cyH();
                        QuickVideoView.this.juN = true;
                        QuickVideoView.this.juE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juH.cgD();
                    }
                }
                QuickVideoView.this.juR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvq) {
                    QuickVideoView.this.cyJ();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juE != null) {
                        if (QuickVideoView.this.juE.isPlaying() && QuickVideoView.this.cyO()) {
                            x.czq().bl(QuickVideoView.this.juY, QuickVideoView.this.juE.getCurrentPosition());
                            if (QuickVideoView.this.jvc) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jvc) {
                            QuickVideoView.this.juE.release();
                        }
                    }
                    if (QuickVideoView.this.juN) {
                        if (QuickVideoView.this.juL != null && !QuickVideoView.this.jvc) {
                            QuickVideoView.this.juL.GY(QuickVideoView.this.juX);
                        }
                        if (QuickVideoView.this.dMj != null) {
                            QuickVideoView.this.dMj.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.juR = null;
                    if (QuickVideoView.this.juH != null && QuickVideoView.this.juH.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juH = null;
                    }
                    if (!QuickVideoView.this.jvc) {
                        QuickVideoView.this.juN = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyT() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
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
        this.efa = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.cyJ();
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.onPrepared();
                }
                if (QuickVideoView.this.juH != null && QuickVideoView.this.juE != null) {
                    QuickVideoView.this.juH.yh(QuickVideoView.this.juE.getPlayerType());
                }
                if (QuickVideoView.this.jvc) {
                    TbVideoViewSet.czt().a(QuickVideoView.this, QuickVideoView.this.juX);
                }
                if (QuickVideoView.this.dVc != null) {
                    QuickVideoView.this.juM.cgU();
                    QuickVideoView.this.dVc.onPrepared(gVar);
                }
                if (QuickVideoView.this.juL != null) {
                    long j = 0;
                    if (QuickVideoView.this.juE != null) {
                        j = QuickVideoView.this.juE.getDuration();
                    }
                    QuickVideoView.this.juL.ew(j);
                    QuickVideoView.this.cyI();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juL.cyB();
                        QuickVideoView.this.cyN();
                    }
                }
                if (QuickVideoView.this.jvb && (Hd = x.czq().Hd(QuickVideoView.this.juY)) > 0 && QuickVideoView.this.juE != null) {
                    if (QuickVideoView.this.juE.isPlayerReuse()) {
                        if (QuickVideoView.this.juE.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(Hd);
                        }
                    } else {
                        QuickVideoView.this.As(Hd);
                    }
                }
                if (QuickVideoView.this.juK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juC != null && gVar != null) {
                    QuickVideoView.this.juC.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juO);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juD) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juD);
                }
                if (QuickVideoView.this.juT != null && QuickVideoView.this.juT.czL()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efb = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juH = null;
                }
                if (!QuickVideoView.this.eeQ || QuickVideoView.this.juL == null) {
                    if (QuickVideoView.this.juL != null) {
                        QuickVideoView.this.juL.onCompletion();
                    }
                    QuickVideoView.this.juK = false;
                    x.czq().remove(QuickVideoView.this.juY);
                    if (QuickVideoView.this.dVb != null) {
                        QuickVideoView.this.dVb.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juJ = null;
                QuickVideoView.this.juZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juL.cyu());
                QuickVideoView.this.start();
            }
        };
        this.dVd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.cyJ();
                if (QuickVideoView.this.juL != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyO()) {
                    QuickVideoView.this.jva = true;
                    x.czq().bl(QuickVideoView.this.juY, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czt().Hf(QuickVideoView.this.juX);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juH != null) {
                        QuickVideoView.this.juJ = QuickVideoView.this.juH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.juZ, QuickVideoView.this.aq(QuickVideoView.this.juH.cgI(), i3 + "", QuickVideoView.this.juH.cgJ()));
                        QuickVideoView.this.juH = null;
                    }
                    QuickVideoView.this.juZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMf == null || QuickVideoView.this.dMf.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.efe = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jva) {
                    QuickVideoView.this.jva = false;
                    return;
                }
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.czc();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juL != null && z) {
                    QuickVideoView.this.juL.onSeekComplete();
                }
                if (QuickVideoView.this.dVf != null) {
                    QuickVideoView.this.dVf.b(gVar);
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.juF != null) {
                    QuickVideoView.this.juF.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.juO = i2;
                    if (QuickVideoView.this.juC != null && gVar != null) {
                        QuickVideoView.this.juC.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juO);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.juM.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.a(i, i2, QuickVideoView.this.juH);
                    return true;
                }
                return true;
            }
        };
        this.dVg = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.m(i, i2, str);
                }
            }
        };
        this.dVh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.Fg(str);
                }
            }
        };
        this.dVi = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.juZ = j;
                }
            }
        };
        this.jvu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juL != null && QuickVideoView.this.juL.cyx() && QuickVideoView.this.juL.cyy() && QuickVideoView.this.juL.cyz() && QuickVideoView.this.juE != null) {
                    int aWE = QuickVideoView.this.juE.aWE();
                    int currentPosition = QuickVideoView.this.juE.getCurrentPosition();
                    int duration = QuickVideoView.this.juE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvd;
                    boolean z = currentPosition + aWE < duration;
                    if (aWE < QuickVideoView.this.juL.cyA() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvd = currentTimeMillis;
                        QuickVideoView.this.juL.Ap(0);
                    }
                    if (QuickVideoView.this.cyM() && currentPosition == QuickVideoView.this.jve && j > 500) {
                        QuickVideoView.this.jvd = currentTimeMillis;
                        QuickVideoView.this.juL.Ap(0);
                    }
                    QuickVideoView.this.jve = currentPosition;
                    if (QuickVideoView.this.jvk == QuickVideoView.jvi) {
                        QuickVideoView.this.cyN();
                    }
                }
            }
        };
        this.dVp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juL != null) {
                        QuickVideoView.this.juL.wJ(QuickVideoView.this.juX);
                    }
                    if (QuickVideoView.this.juH != null) {
                        QuickVideoView.this.juH.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juH = null;
                    }
                    QuickVideoView.this.cyJ();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.juK = false;
        this.juN = false;
        this.juO = 0;
        this.eeQ = false;
        this.juP = -1;
        this.juQ = false;
        this.juR = null;
        this.juS = true;
        this.jvc = false;
        this.jvd = 0L;
        this.jve = 0L;
        this.jvk = jvj;
        this.jvl = 0;
        this.mBitRate = 0;
        this.jvm = -1;
        this.jvn = 0;
        this.jvo = 0;
        this.jvp = 0;
        this.dZZ = 0;
        this.jvq = false;
        this.Pf = null;
        this.jvr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juE != null && QuickVideoView.this.juK) {
                    QuickVideoView.this.b(QuickVideoView.this.juE, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.oR(false);
                }
            }
        };
        this.jvt = false;
        this.aXO = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.jvq) {
                    QuickVideoView.this.jvq = false;
                    if (QuickVideoView.this.juE != null) {
                        QuickVideoView.this.juE.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.juN || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juE != null) {
                        if (QuickVideoView.this.cyQ()) {
                            QuickVideoView.this.juE.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juQ) {
                            QuickVideoView.this.juE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.juP);
                            if (QuickVideoView.this.jui != null) {
                                QuickVideoView.this.jui.cyr();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juH.cgE();
                            }
                        }
                    }
                } else if (cyT()) {
                    if (QuickVideoView.this.juE != null) {
                        QuickVideoView.this.cyH();
                        QuickVideoView.this.juN = true;
                        QuickVideoView.this.juE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juH.cgD();
                    }
                }
                QuickVideoView.this.juR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvq) {
                    QuickVideoView.this.cyJ();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juE != null) {
                        if (QuickVideoView.this.juE.isPlaying() && QuickVideoView.this.cyO()) {
                            x.czq().bl(QuickVideoView.this.juY, QuickVideoView.this.juE.getCurrentPosition());
                            if (QuickVideoView.this.jvc) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jvc) {
                            QuickVideoView.this.juE.release();
                        }
                    }
                    if (QuickVideoView.this.juN) {
                        if (QuickVideoView.this.juL != null && !QuickVideoView.this.jvc) {
                            QuickVideoView.this.juL.GY(QuickVideoView.this.juX);
                        }
                        if (QuickVideoView.this.dMj != null) {
                            QuickVideoView.this.dMj.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.juR = null;
                    if (QuickVideoView.this.juH != null && QuickVideoView.this.juH.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juH = null;
                    }
                    if (!QuickVideoView.this.jvc) {
                        QuickVideoView.this.juN = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyT() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
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
        this.efa = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.cyJ();
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.onPrepared();
                }
                if (QuickVideoView.this.juH != null && QuickVideoView.this.juE != null) {
                    QuickVideoView.this.juH.yh(QuickVideoView.this.juE.getPlayerType());
                }
                if (QuickVideoView.this.jvc) {
                    TbVideoViewSet.czt().a(QuickVideoView.this, QuickVideoView.this.juX);
                }
                if (QuickVideoView.this.dVc != null) {
                    QuickVideoView.this.juM.cgU();
                    QuickVideoView.this.dVc.onPrepared(gVar);
                }
                if (QuickVideoView.this.juL != null) {
                    long j = 0;
                    if (QuickVideoView.this.juE != null) {
                        j = QuickVideoView.this.juE.getDuration();
                    }
                    QuickVideoView.this.juL.ew(j);
                    QuickVideoView.this.cyI();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juL.cyB();
                        QuickVideoView.this.cyN();
                    }
                }
                if (QuickVideoView.this.jvb && (Hd = x.czq().Hd(QuickVideoView.this.juY)) > 0 && QuickVideoView.this.juE != null) {
                    if (QuickVideoView.this.juE.isPlayerReuse()) {
                        if (QuickVideoView.this.juE.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(Hd);
                        }
                    } else {
                        QuickVideoView.this.As(Hd);
                    }
                }
                if (QuickVideoView.this.juK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juC != null && gVar != null) {
                    QuickVideoView.this.juC.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juO);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juD) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juD);
                }
                if (QuickVideoView.this.juT != null && QuickVideoView.this.juT.czL()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efb = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juH = null;
                }
                if (!QuickVideoView.this.eeQ || QuickVideoView.this.juL == null) {
                    if (QuickVideoView.this.juL != null) {
                        QuickVideoView.this.juL.onCompletion();
                    }
                    QuickVideoView.this.juK = false;
                    x.czq().remove(QuickVideoView.this.juY);
                    if (QuickVideoView.this.dVb != null) {
                        QuickVideoView.this.dVb.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juJ = null;
                QuickVideoView.this.juZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juL.cyu());
                QuickVideoView.this.start();
            }
        };
        this.dVd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.X(i2, i22, i3);
                QuickVideoView.this.cyJ();
                if (QuickVideoView.this.juL != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyO()) {
                    QuickVideoView.this.jva = true;
                    x.czq().bl(QuickVideoView.this.juY, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czt().Hf(QuickVideoView.this.juX);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juH != null) {
                        QuickVideoView.this.juJ = QuickVideoView.this.juH.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.juZ, QuickVideoView.this.aq(QuickVideoView.this.juH.cgI(), i3 + "", QuickVideoView.this.juH.cgJ()));
                        QuickVideoView.this.juH = null;
                    }
                    QuickVideoView.this.juZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMf == null || QuickVideoView.this.dMf.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.efe = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jva) {
                    QuickVideoView.this.jva = false;
                    return;
                }
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.czc();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juL != null && z) {
                    QuickVideoView.this.juL.onSeekComplete();
                }
                if (QuickVideoView.this.dVf != null) {
                    QuickVideoView.this.dVf.b(gVar);
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.juF != null) {
                    QuickVideoView.this.juF.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.juO = i22;
                    if (QuickVideoView.this.juC != null && gVar != null) {
                        QuickVideoView.this.juC.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juO);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.juM.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.juU != null) {
                    QuickVideoView.this.juU.a(i2, i22, QuickVideoView.this.juH);
                    return true;
                }
                return true;
            }
        };
        this.dVg = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.m(i2, i22, str);
                }
            }
        };
        this.dVh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.Fg(str);
                }
            }
        };
        this.dVi = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.juZ = j;
                }
            }
        };
        this.jvu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juL != null && QuickVideoView.this.juL.cyx() && QuickVideoView.this.juL.cyy() && QuickVideoView.this.juL.cyz() && QuickVideoView.this.juE != null) {
                    int aWE = QuickVideoView.this.juE.aWE();
                    int currentPosition = QuickVideoView.this.juE.getCurrentPosition();
                    int duration = QuickVideoView.this.juE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvd;
                    boolean z = currentPosition + aWE < duration;
                    if (aWE < QuickVideoView.this.juL.cyA() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvd = currentTimeMillis;
                        QuickVideoView.this.juL.Ap(0);
                    }
                    if (QuickVideoView.this.cyM() && currentPosition == QuickVideoView.this.jve && j > 500) {
                        QuickVideoView.this.jvd = currentTimeMillis;
                        QuickVideoView.this.juL.Ap(0);
                    }
                    QuickVideoView.this.jve = currentPosition;
                    if (QuickVideoView.this.jvk == QuickVideoView.jvi) {
                        QuickVideoView.this.cyN();
                    }
                }
            }
        };
        this.dVp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juL != null) {
                        QuickVideoView.this.juL.wJ(QuickVideoView.this.juX);
                    }
                    if (QuickVideoView.this.juH != null) {
                        QuickVideoView.this.juH.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juH = null;
                    }
                    QuickVideoView.this.cyJ();
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
        this.juC = new RenderView(context);
        this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
        this.juC.setSurfaceTextureListener(this.aXO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.juS) {
            addView(this.juC, layoutParams);
        } else {
            addView(this.juC, 0, layoutParams);
        }
        if (eeY != null) {
            this.juE = eeY.aWH();
        }
        if (this.juE != null) {
            this.juE.setOnPreparedListener(this.efa);
            this.juE.setOnCompletionListener(this.efb);
            this.juE.a(this.dVd);
            this.juE.setOnSeekCompleteListener(this.efe);
            this.juE.a(this.dVe);
            this.juE.a(this.dVg);
            this.juE.a(this.dVh);
            this.juE.a(this.dVi);
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
        this.juT = new com.baidu.tieba.play.b.a(this);
        this.juU = new q();
        this.juV = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.juM = new com.baidu.tieba.k.k();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(SwitchManager.getInstance().findType(VideoPlayerReuseSwitch.VIDEO_PLAY_REUSE_KEY) == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jvb = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.juX;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.juM.cgT();
        this.Pj = str2;
        if (this.juT != null) {
            this.juT.clear();
            this.juT.czL();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Hh(str2);
            if (eeZ != null) {
                this.juH = eeZ.ap(this.Pj, str, "");
                if (this.juH != null) {
                    this.juH.a(-300, -44399, -44399, getLocateSource(), false, this.juZ, "");
                    this.juH = null;
                }
            }
        }
        if (this.juI != null) {
            this.juI.a(null);
            this.juI.cgw();
            this.juI = null;
        }
        this.juJ = null;
        this.juZ = 0L;
        setVideoPath(str);
    }

    private String GZ(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPf().cPg()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
                return str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
            }
            return str;
        }
        return str;
    }

    public void setVideoPath(String str) {
        if (!aq.isEmpty(str)) {
            String GZ = GZ(str);
            this.juW = GZ;
            if (this.juL != null) {
                GZ = this.juL.wE(GZ);
                if (this.juL.cyC() != null) {
                    this.juL.cyC().setPlayer(this);
                }
                if (eeZ != null && uy(GZ)) {
                    this.juI = eeZ.Fi(GZ);
                }
                if (this.juI != null) {
                    this.juI.a(new com.baidu.tieba.play.monitor.a(this.Pj, this.juW, this.juH));
                    this.juI.cgv();
                }
                Ha(GZ);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !uy(GZ)) {
                if (this.dMf != null) {
                    this.dMf.onError(this.juE, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.czt().Hf(this.juX);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(GZ));
            if (this.juH != null && u(Uri.parse(GZ)) != null) {
                this.juH.cgC();
            }
            this.juX = str;
            int lastIndexOf = this.juX.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.juX.length() > 4) {
                this.juY = this.juX.substring(0, lastIndexOf + 4);
            } else {
                this.juY = this.juX;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
        if (com.baidu.tbadk.coreExtra.model.f.aMd()) {
            if (this.juL != null && (this.juL.cyw() || this.juL.cyx())) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvr);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.jvr, com.baidu.tbadk.coreExtra.model.f.aMc());
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvs);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jvs, com.baidu.tbadk.coreExtra.model.f.aMb());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.juH.Fc(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aWA();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.jvt = false;
        if (this.juR != null) {
            cyH();
            if (this.juE != null) {
                if (!this.juN) {
                    this.juN = true;
                    this.juE.a(this.mContext, this.mUri, this.mHeaders, this.juR, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying() && this.efa != null) {
                    this.jvt = true;
                    this.efa.onPrepared(this.juE);
                }
            }
        } else if (this.juC != null && this.juC.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.juS) {
                addView(this.juC, layoutParams);
            } else {
                addView(this.juC, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aWA() {
        this.juN = false;
        this.juK = false;
        if (this.juE != null) {
            if (this.juE.isPlaying() && cyO()) {
                x.czq().bl(this.juY, this.juE.getCurrentPosition());
            }
            this.juE.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
    }

    private void Ha(String str) {
        this.mBitRate = 0;
        this.jvm = 0;
        this.jvn = 0;
        this.jvo = 0;
        this.jvp = 0;
        this.dZZ = 0;
        if (this.juL.cyx()) {
            this.jvl = jvg;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.jvm = (int) t.Hc(QuickVideoView.this.juW);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.juW != null && this.juW.equals(str)) {
            this.jvl = jvf;
        } else {
            this.jvl = jvh;
        }
        this.jvk = jvi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyI() {
        this.jvk = jvi;
        if (this.juE != null) {
            this.mBitRate = this.juE.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(boolean z) {
        if (this.jvk == jvi && this.juE != null) {
            this.jvk = jvj;
            this.jvo = this.juE.getDuration();
            if (z) {
                this.jvp = 0;
                this.jvn = this.jvo;
            } else {
                this.jvn = this.juE.getCurrentPosition();
                this.jvp = this.juE.getCachedSize();
            }
            if (this.jvn > 0) {
                if (this.jvl == jvf) {
                    this.jvm = (int) t.Hc(this.juW);
                    if (this.mBitRate > 0) {
                        long j = (this.mBitRate * (this.jvn / 1000)) / 8;
                        if (this.jvp < 0) {
                            this.jvp = 0;
                        }
                        long j2 = this.jvp + j;
                        if (this.jvm > 0) {
                            j2 += this.jvm;
                        }
                        setFlowCount(j2, this.jvn, this.jvo, this.dZZ);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jvn / 1000)) / 8, this.jvn, this.jvo, this.dZZ);
                    }
                } else if (this.jvl == jvg) {
                    if (this.mBitRate > 0) {
                        long j3 = (this.mBitRate * (this.jvn / 1000)) / 8;
                        if (this.jvp < 0) {
                            this.jvp = 0;
                        }
                        long j4 = this.jvp + j3;
                        if (this.jvm > 0) {
                            j4 -= this.jvm;
                        }
                        setFlowCount(j4, this.jvn, this.jvo, this.dZZ);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jvn / 1000)) / 8, this.jvn, this.jvo, this.dZZ);
                    }
                } else {
                    setFlowCount(0L, this.jvn, this.jvo, this.dZZ);
                }
            }
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jvc) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        cyJ();
        rO(false);
        if (this.juT != null) {
            this.juT.clear();
        }
        this.juD = null;
        this.juK = false;
        if (this.juE != null) {
            if (this.juE.isPlaying() && cyO()) {
                x.czq().bl(this.juY, this.juE.getCurrentPosition());
            }
            this.juE.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
        this.eeQ = false;
        if (this.juL != null) {
            this.juL.cyv();
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.juH != null && this.juH.Ff(getLocateSource())) {
            this.juH = null;
        }
        if (this.juM != null) {
            this.juM.cgS();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        cyJ();
        rO(false);
        if (this.juT != null) {
            this.juT.clear();
        }
        this.juD = null;
        aWA();
        TbVideoViewSet.czt().Hf(this.juX);
        this.eeQ = false;
        if (this.juL != null) {
            this.juL.GY(this.juX);
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.juH != null && this.juH.Ff(getLocateSource())) {
            this.juH = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.jvq = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyJ() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvr);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvs);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.dVc = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.dVb = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.dMf = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0590g interfaceC0590g) {
        this.dVf = interfaceC0590g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyK() {
        cyJ();
        if (this.juU != null) {
            this.juU.onPrepared();
        }
        if (u(this.mUri) != null && this.juE != null) {
            this.juH.Fc(this.mUri.getPath());
            this.juH.yi(this.juE.getPlayerType());
        }
        this.juM.cgT();
        this.juM.cgU();
        if (this.juL != null) {
            long j = 0;
            if (this.juE != null) {
                j = this.juE.getDuration();
            }
            this.juL.ew(j);
            cyI();
            if (getPlayerType() == -200) {
                this.juL.cyB();
                cyN();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyL() {
        if (u(this.mUri) != null && this.juE != null) {
            this.juH.Fc(this.mUri.getPath());
            this.juH.cgC();
            this.juH.yh(this.juE.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.juV == null) {
            return "";
        }
        String czN = this.juV.czN();
        this.juV.ar(str, str2, str3);
        return czN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.juL != null && !StringUtils.isNull(this.juL.cyu())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Hg(uri);
                }
            }
            this.mUri = Uri.parse(this.juL.cyu());
        }
        boolean z = false;
        if (this.juT != null) {
            z = this.juT.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.juH != null) {
            this.juJ = this.juH.a(i, i2, i3, getLocateSource(), z, this.juZ, aq(this.juH.cgI(), i3 + "", this.juH.cgJ()));
            this.juH = null;
        }
        this.juZ = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.juE != null) {
            try {
                if (this.juE.isPlaying() && cyO()) {
                    x.czq().bl(this.juY, this.juE.getCurrentPosition());
                }
                this.juE.release();
                this.juD = str;
                URI uri = new URI(this.mUri.toString());
                this.juE.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.juR, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.juH.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.juE != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.juE.isPlaying() && cyO()) {
                x.czq().bl(this.juY, this.juE.getCurrentPosition());
            }
            this.juE.release();
            this.juE.a(this.mContext, this.mUri, this.mHeaders, this.juR, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.juH.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.juE != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.juE.forceUseSystemMediaPlayer(true);
            }
            if (this.juE.isPlaying() && cyO()) {
                x.czq().bl(this.juY, this.juE.getCurrentPosition());
            }
            this.juE.release();
            this.juE.a(this.mContext, this.mUri, this.mHeaders, this.juR, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.juH.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.juK = true;
        if (this.juE != null) {
            if (this.juR != null && this.juQ && !this.juE.isExistInRemote()) {
                this.juE.a(this.mContext, this.mUri, this.mHeaders, this.juR, this.juP);
                if (this.jui != null) {
                    this.jui.cyr();
                }
                if (u(this.mUri) != null) {
                    this.juH.cgE();
                }
                cyH();
                return;
            }
            if (!this.juE.aWF()) {
                af.a(this.Pf, true);
                this.juE.setVolume(1.0f, 1.0f);
            }
            this.juM.cgV();
            this.juE.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.juL != null) {
            this.juL.onStart();
        }
        if (this.juG != null) {
            this.juG.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.juE != null) {
            this.juH.yj(this.juE.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.juK) {
            b(aVar);
            return;
        }
        this.juK = true;
        if (aVar != null) {
            this.jvc = true;
            if (!cyR()) {
                aVar.czu();
            }
        } else {
            this.jvc = false;
        }
        setVideoPath(this.juX, this.Pj);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cyJ();
        af.a(this.Pf, false);
        if (this.juE != null) {
            if (this.juE.isPlaying() && cyO()) {
                x.czq().bl(this.juY, this.juE.getCurrentPosition());
            }
            this.juE.pause();
        }
        if (this.juL != null) {
            this.juL.onPause();
        }
        this.juK = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juH != null) {
            this.juH.cgH();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.juE != null) {
            return this.juE.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.juE != null) {
            return this.juE.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.dZZ = i;
        As(i);
    }

    public void As(int i) {
        if (this.juU != null) {
            this.juU.czb();
        }
        if (this.juE != null) {
            this.juE.seekTo(i);
        }
        if (this.juL != null) {
            this.juL.Ap(0);
            cyN();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.juE != null) {
            return this.juE.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.juE != null) {
            this.juE.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.juP = i;
    }

    public int getRecoveryState() {
        return this.juP;
    }

    public void setNeedRecovery(boolean z) {
        this.juQ = z;
    }

    public void setLooping(boolean z) {
        this.eeQ = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cyM() {
        return this.juK;
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
        this.dMj = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.juL = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVp);
    }

    public void setMute(boolean z) {
        if (z) {
            this.juE.setVolume(0.0f, 0.0f);
            af.a(this.Pf, false);
            return;
        }
        af.a(this.Pf, true);
        this.juE.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eeQ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juE != null) {
            this.juE.aWG();
        }
        if (this.juU != null) {
            this.juU.Gk();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
        MessageManager.getInstance().unRegisterListener(this.dVp);
        if (this.juT != null) {
            this.juT.clear();
        }
        if (this.juI != null) {
            this.juI.a(null);
            this.juI.cgw();
        }
    }

    public g getPlayer() {
        return this.juE;
    }

    public int getPlayerType() {
        if (this.juE == null) {
            return -300;
        }
        return this.juE.getPlayerType();
    }

    public void cyN() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvu, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.jui = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.juL instanceof n) || ((n) this.juL).cza() == null) {
            return "";
        }
        return ((n) this.juL).jvG ? "v_mid_page" : ((n) this.juL).cza().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i u(Uri uri) {
        String uri2;
        if (this.juH != null) {
            return this.juH;
        }
        if (!StringUtils.isNull(this.juW)) {
            uri2 = this.juW;
        } else if (eeZ != null && this.juL != null && !StringUtils.isNull(this.juL.cyu())) {
            uri2 = this.juL.cyu();
        } else {
            uri2 = (eeZ == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && eeZ != null) {
            this.juH = eeZ.ap(this.Pj, uri2, this.juJ);
        }
        this.juJ = null;
        this.juZ = 0L;
        return this.juH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyO() {
        return this.juE != null && this.juE.getDuration() >= this.juE.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.juH, j, j2, j3, j4);
    }

    public static boolean uy(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cyP() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            try {
                ((ViewGroup) getParent()).removeView(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.jvc = true;
            if (!cyR()) {
                aVar.czu();
            }
            if (!cyQ()) {
                aVar.czv();
                this.juK = true;
                setVideoPath(this.juX, this.Pj);
                return;
            }
        } else {
            this.jvc = false;
        }
        start();
        if (this.juE != null && this.jvc) {
            this.juM.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyQ() {
        return this == TbVideoViewSet.czt().He(this.juX);
    }

    private boolean cyR() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.dVb = null;
        this.dMf = null;
        this.dVe = null;
        this.efa = null;
        this.efe = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jvc = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.juF = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.juE != null) {
            return this.juE.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.juE != null ? this.juE.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.juH != null) {
            this.juH.e(j, j2, j3);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.juG = cVar;
    }
}
