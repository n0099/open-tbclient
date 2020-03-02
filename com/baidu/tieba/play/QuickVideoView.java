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
    private static h eeZ;
    private static com.baidu.tieba.k.l efa;
    private static int jvh = 0;
    private static int jvi = 1;
    private static int jvj = 2;
    private static int jvk = 1;
    private static int jvl = 0;
    private WeakReference<Context> Pf;
    private String Pj;
    private TextureView.SurfaceTextureListener aXP;
    private g.b dMg;
    private b dMk;
    private g.a dVc;
    private g.f dVd;
    private g.c dVe;
    private g.e dVf;
    private g.InterfaceC0590g dVg;
    private g.i dVh;
    private g.d dVi;
    private g.h dVj;
    private final CustomMessageListener dVq;
    private int eaa;
    private boolean eeR;
    private g.f efb;
    private g.a efc;
    private g.InterfaceC0590g eff;
    private RenderView juE;
    private String juF;
    private g juG;
    private g.e juH;
    private c juI;
    private com.baidu.tieba.k.i juJ;
    private com.baidu.tieba.k.e juK;
    private String juL;
    private boolean juM;
    private d juN;
    private com.baidu.tieba.k.k juO;
    private boolean juP;
    private int juQ;
    private int juR;
    private boolean juS;
    private SurfaceTexture juT;
    private boolean juU;
    private com.baidu.tieba.play.b.a juV;
    private q juW;
    private com.baidu.tieba.play.b.f juX;
    private String juY;
    private String juZ;
    private a juk;
    private String jva;
    private long jvb;
    private boolean jvc;
    private boolean jvd;
    private boolean jve;
    private long jvf;
    private long jvg;
    private int jvm;
    private int jvn;
    private int jvo;
    private int jvp;
    private int jvq;
    private int jvr;
    private boolean jvs;
    private Runnable jvt;
    private Runnable jvu;
    public boolean jvv;
    private Runnable jvw;
    private int mBitRate;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cyt();
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
            eeZ = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            efa = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.juU = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.juM = false;
        this.juP = false;
        this.juQ = 0;
        this.eeR = false;
        this.juR = -1;
        this.juS = false;
        this.juT = null;
        this.juU = true;
        this.jve = false;
        this.jvf = 0L;
        this.jvg = 0L;
        this.jvm = jvl;
        this.jvn = 0;
        this.mBitRate = 0;
        this.jvo = -1;
        this.jvp = 0;
        this.jvq = 0;
        this.jvr = 0;
        this.eaa = 0;
        this.jvs = false;
        this.Pf = null;
        this.jvt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juG != null && QuickVideoView.this.juM) {
                    QuickVideoView.this.b(QuickVideoView.this.juG, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.oR(false);
                }
            }
        };
        this.jvv = false;
        this.aXP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jvs) {
                    QuickVideoView.this.jvs = false;
                    if (QuickVideoView.this.juG != null) {
                        QuickVideoView.this.juG.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.juP || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juG != null) {
                        if (QuickVideoView.this.cyS()) {
                            QuickVideoView.this.juG.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juS) {
                            QuickVideoView.this.juG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.juR);
                            if (QuickVideoView.this.juk != null) {
                                QuickVideoView.this.juk.cyt();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juJ.cgG();
                            }
                        }
                    }
                } else if (cyV()) {
                    if (QuickVideoView.this.juG != null) {
                        QuickVideoView.this.cyJ();
                        QuickVideoView.this.juP = true;
                        QuickVideoView.this.juG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juJ.cgF();
                    }
                }
                QuickVideoView.this.juT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvs) {
                    QuickVideoView.this.cyL();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juG != null) {
                        if (QuickVideoView.this.juG.isPlaying() && QuickVideoView.this.cyQ()) {
                            x.czs().bl(QuickVideoView.this.jva, QuickVideoView.this.juG.getCurrentPosition());
                            if (QuickVideoView.this.jve) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jve) {
                            QuickVideoView.this.juG.release();
                        }
                    }
                    if (QuickVideoView.this.juP) {
                        if (QuickVideoView.this.juN != null && !QuickVideoView.this.jve) {
                            QuickVideoView.this.juN.GY(QuickVideoView.this.juZ);
                        }
                        if (QuickVideoView.this.dMk != null) {
                            QuickVideoView.this.dMk.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.juT = null;
                    if (QuickVideoView.this.juJ != null && QuickVideoView.this.juJ.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juJ = null;
                    }
                    if (!QuickVideoView.this.jve) {
                        QuickVideoView.this.juP = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyV() {
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
        this.efb = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.cyL();
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.onPrepared();
                }
                if (QuickVideoView.this.juJ != null && QuickVideoView.this.juG != null) {
                    QuickVideoView.this.juJ.yh(QuickVideoView.this.juG.getPlayerType());
                }
                if (QuickVideoView.this.jve) {
                    TbVideoViewSet.czv().a(QuickVideoView.this, QuickVideoView.this.juZ);
                }
                if (QuickVideoView.this.dVd != null) {
                    QuickVideoView.this.juO.cgW();
                    QuickVideoView.this.dVd.onPrepared(gVar);
                }
                if (QuickVideoView.this.juN != null) {
                    long j = 0;
                    if (QuickVideoView.this.juG != null) {
                        j = QuickVideoView.this.juG.getDuration();
                    }
                    QuickVideoView.this.juN.ew(j);
                    QuickVideoView.this.cyK();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juN.cyD();
                        QuickVideoView.this.cyP();
                    }
                }
                if (QuickVideoView.this.jvd && (Hd = x.czs().Hd(QuickVideoView.this.jva)) > 0 && QuickVideoView.this.juG != null) {
                    if (QuickVideoView.this.juG.isPlayerReuse()) {
                        if (QuickVideoView.this.juG.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(Hd);
                        }
                    } else {
                        QuickVideoView.this.As(Hd);
                    }
                }
                if (QuickVideoView.this.juM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juE != null && gVar != null) {
                    QuickVideoView.this.juE.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juQ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juF) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juF);
                }
                if (QuickVideoView.this.juV != null && QuickVideoView.this.juV.czN()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efc = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juJ = null;
                }
                if (!QuickVideoView.this.eeR || QuickVideoView.this.juN == null) {
                    if (QuickVideoView.this.juN != null) {
                        QuickVideoView.this.juN.onCompletion();
                    }
                    QuickVideoView.this.juM = false;
                    x.czs().remove(QuickVideoView.this.jva);
                    if (QuickVideoView.this.dVc != null) {
                        QuickVideoView.this.dVc.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juL = null;
                QuickVideoView.this.jvb = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juN.cyw());
                QuickVideoView.this.start();
            }
        };
        this.dVe = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.cyL();
                if (QuickVideoView.this.juN != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyQ()) {
                    QuickVideoView.this.jvc = true;
                    x.czs().bl(QuickVideoView.this.jva, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czv().Hf(QuickVideoView.this.juZ);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juJ != null) {
                        QuickVideoView.this.juL = QuickVideoView.this.juJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jvb, QuickVideoView.this.aq(QuickVideoView.this.juJ.cgK(), i3 + "", QuickVideoView.this.juJ.cgL()));
                        QuickVideoView.this.juJ = null;
                    }
                    QuickVideoView.this.jvb = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMg == null || QuickVideoView.this.dMg.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eff = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jvc) {
                    QuickVideoView.this.jvc = false;
                    return;
                }
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.cze();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juN != null && z) {
                    QuickVideoView.this.juN.onSeekComplete();
                }
                if (QuickVideoView.this.dVg != null) {
                    QuickVideoView.this.dVg.b(gVar);
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.juQ = i2;
                    if (QuickVideoView.this.juE != null && gVar != null) {
                        QuickVideoView.this.juE.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juQ);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.juO.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.a(i, i2, QuickVideoView.this.juJ);
                    return true;
                }
                return true;
            }
        };
        this.dVh = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.m(i, i2, str);
                }
            }
        };
        this.dVi = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.Fg(str);
                }
            }
        };
        this.dVj = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jvb = j;
                }
            }
        };
        this.jvw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juN != null && QuickVideoView.this.juN.cyz() && QuickVideoView.this.juN.cyA() && QuickVideoView.this.juN.cyB() && QuickVideoView.this.juG != null) {
                    int aWG = QuickVideoView.this.juG.aWG();
                    int currentPosition = QuickVideoView.this.juG.getCurrentPosition();
                    int duration = QuickVideoView.this.juG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvf;
                    boolean z = currentPosition + aWG < duration;
                    if (aWG < QuickVideoView.this.juN.cyC() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvf = currentTimeMillis;
                        QuickVideoView.this.juN.Ap(0);
                    }
                    if (QuickVideoView.this.cyO() && currentPosition == QuickVideoView.this.jvg && j > 500) {
                        QuickVideoView.this.jvf = currentTimeMillis;
                        QuickVideoView.this.juN.Ap(0);
                    }
                    QuickVideoView.this.jvg = currentPosition;
                    if (QuickVideoView.this.jvm == QuickVideoView.jvk) {
                        QuickVideoView.this.cyP();
                    }
                }
            }
        };
        this.dVq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juN != null) {
                        QuickVideoView.this.juN.wJ(QuickVideoView.this.juZ);
                    }
                    if (QuickVideoView.this.juJ != null) {
                        QuickVideoView.this.juJ.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juJ = null;
                    }
                    QuickVideoView.this.cyL();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.juM = false;
        this.juP = false;
        this.juQ = 0;
        this.eeR = false;
        this.juR = -1;
        this.juS = false;
        this.juT = null;
        this.juU = true;
        this.jve = false;
        this.jvf = 0L;
        this.jvg = 0L;
        this.jvm = jvl;
        this.jvn = 0;
        this.mBitRate = 0;
        this.jvo = -1;
        this.jvp = 0;
        this.jvq = 0;
        this.jvr = 0;
        this.eaa = 0;
        this.jvs = false;
        this.Pf = null;
        this.jvt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juG != null && QuickVideoView.this.juM) {
                    QuickVideoView.this.b(QuickVideoView.this.juG, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.oR(false);
                }
            }
        };
        this.jvv = false;
        this.aXP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jvs) {
                    QuickVideoView.this.jvs = false;
                    if (QuickVideoView.this.juG != null) {
                        QuickVideoView.this.juG.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.juP || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juG != null) {
                        if (QuickVideoView.this.cyS()) {
                            QuickVideoView.this.juG.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juS) {
                            QuickVideoView.this.juG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.juR);
                            if (QuickVideoView.this.juk != null) {
                                QuickVideoView.this.juk.cyt();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juJ.cgG();
                            }
                        }
                    }
                } else if (cyV()) {
                    if (QuickVideoView.this.juG != null) {
                        QuickVideoView.this.cyJ();
                        QuickVideoView.this.juP = true;
                        QuickVideoView.this.juG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juJ.cgF();
                    }
                }
                QuickVideoView.this.juT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvs) {
                    QuickVideoView.this.cyL();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juG != null) {
                        if (QuickVideoView.this.juG.isPlaying() && QuickVideoView.this.cyQ()) {
                            x.czs().bl(QuickVideoView.this.jva, QuickVideoView.this.juG.getCurrentPosition());
                            if (QuickVideoView.this.jve) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jve) {
                            QuickVideoView.this.juG.release();
                        }
                    }
                    if (QuickVideoView.this.juP) {
                        if (QuickVideoView.this.juN != null && !QuickVideoView.this.jve) {
                            QuickVideoView.this.juN.GY(QuickVideoView.this.juZ);
                        }
                        if (QuickVideoView.this.dMk != null) {
                            QuickVideoView.this.dMk.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.juT = null;
                    if (QuickVideoView.this.juJ != null && QuickVideoView.this.juJ.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juJ = null;
                    }
                    if (!QuickVideoView.this.jve) {
                        QuickVideoView.this.juP = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyV() {
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
        this.efb = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.cyL();
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.onPrepared();
                }
                if (QuickVideoView.this.juJ != null && QuickVideoView.this.juG != null) {
                    QuickVideoView.this.juJ.yh(QuickVideoView.this.juG.getPlayerType());
                }
                if (QuickVideoView.this.jve) {
                    TbVideoViewSet.czv().a(QuickVideoView.this, QuickVideoView.this.juZ);
                }
                if (QuickVideoView.this.dVd != null) {
                    QuickVideoView.this.juO.cgW();
                    QuickVideoView.this.dVd.onPrepared(gVar);
                }
                if (QuickVideoView.this.juN != null) {
                    long j = 0;
                    if (QuickVideoView.this.juG != null) {
                        j = QuickVideoView.this.juG.getDuration();
                    }
                    QuickVideoView.this.juN.ew(j);
                    QuickVideoView.this.cyK();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juN.cyD();
                        QuickVideoView.this.cyP();
                    }
                }
                if (QuickVideoView.this.jvd && (Hd = x.czs().Hd(QuickVideoView.this.jva)) > 0 && QuickVideoView.this.juG != null) {
                    if (QuickVideoView.this.juG.isPlayerReuse()) {
                        if (QuickVideoView.this.juG.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(Hd);
                        }
                    } else {
                        QuickVideoView.this.As(Hd);
                    }
                }
                if (QuickVideoView.this.juM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juE != null && gVar != null) {
                    QuickVideoView.this.juE.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juQ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juF) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juF);
                }
                if (QuickVideoView.this.juV != null && QuickVideoView.this.juV.czN()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efc = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juJ = null;
                }
                if (!QuickVideoView.this.eeR || QuickVideoView.this.juN == null) {
                    if (QuickVideoView.this.juN != null) {
                        QuickVideoView.this.juN.onCompletion();
                    }
                    QuickVideoView.this.juM = false;
                    x.czs().remove(QuickVideoView.this.jva);
                    if (QuickVideoView.this.dVc != null) {
                        QuickVideoView.this.dVc.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juL = null;
                QuickVideoView.this.jvb = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juN.cyw());
                QuickVideoView.this.start();
            }
        };
        this.dVe = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.cyL();
                if (QuickVideoView.this.juN != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyQ()) {
                    QuickVideoView.this.jvc = true;
                    x.czs().bl(QuickVideoView.this.jva, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czv().Hf(QuickVideoView.this.juZ);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juJ != null) {
                        QuickVideoView.this.juL = QuickVideoView.this.juJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jvb, QuickVideoView.this.aq(QuickVideoView.this.juJ.cgK(), i3 + "", QuickVideoView.this.juJ.cgL()));
                        QuickVideoView.this.juJ = null;
                    }
                    QuickVideoView.this.jvb = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMg == null || QuickVideoView.this.dMg.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eff = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jvc) {
                    QuickVideoView.this.jvc = false;
                    return;
                }
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.cze();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juN != null && z) {
                    QuickVideoView.this.juN.onSeekComplete();
                }
                if (QuickVideoView.this.dVg != null) {
                    QuickVideoView.this.dVg.b(gVar);
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.juQ = i2;
                    if (QuickVideoView.this.juE != null && gVar != null) {
                        QuickVideoView.this.juE.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juQ);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.juO.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.a(i, i2, QuickVideoView.this.juJ);
                    return true;
                }
                return true;
            }
        };
        this.dVh = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.m(i, i2, str);
                }
            }
        };
        this.dVi = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.Fg(str);
                }
            }
        };
        this.dVj = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jvb = j;
                }
            }
        };
        this.jvw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juN != null && QuickVideoView.this.juN.cyz() && QuickVideoView.this.juN.cyA() && QuickVideoView.this.juN.cyB() && QuickVideoView.this.juG != null) {
                    int aWG = QuickVideoView.this.juG.aWG();
                    int currentPosition = QuickVideoView.this.juG.getCurrentPosition();
                    int duration = QuickVideoView.this.juG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvf;
                    boolean z = currentPosition + aWG < duration;
                    if (aWG < QuickVideoView.this.juN.cyC() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvf = currentTimeMillis;
                        QuickVideoView.this.juN.Ap(0);
                    }
                    if (QuickVideoView.this.cyO() && currentPosition == QuickVideoView.this.jvg && j > 500) {
                        QuickVideoView.this.jvf = currentTimeMillis;
                        QuickVideoView.this.juN.Ap(0);
                    }
                    QuickVideoView.this.jvg = currentPosition;
                    if (QuickVideoView.this.jvm == QuickVideoView.jvk) {
                        QuickVideoView.this.cyP();
                    }
                }
            }
        };
        this.dVq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juN != null) {
                        QuickVideoView.this.juN.wJ(QuickVideoView.this.juZ);
                    }
                    if (QuickVideoView.this.juJ != null) {
                        QuickVideoView.this.juJ.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juJ = null;
                    }
                    QuickVideoView.this.cyL();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.juM = false;
        this.juP = false;
        this.juQ = 0;
        this.eeR = false;
        this.juR = -1;
        this.juS = false;
        this.juT = null;
        this.juU = true;
        this.jve = false;
        this.jvf = 0L;
        this.jvg = 0L;
        this.jvm = jvl;
        this.jvn = 0;
        this.mBitRate = 0;
        this.jvo = -1;
        this.jvp = 0;
        this.jvq = 0;
        this.jvr = 0;
        this.eaa = 0;
        this.jvs = false;
        this.Pf = null;
        this.jvt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juG != null && QuickVideoView.this.juM) {
                    QuickVideoView.this.b(QuickVideoView.this.juG, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jvu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.oR(false);
                }
            }
        };
        this.jvv = false;
        this.aXP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.jvs) {
                    QuickVideoView.this.jvs = false;
                    if (QuickVideoView.this.juG != null) {
                        QuickVideoView.this.juG.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.juP || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.juG != null) {
                        if (QuickVideoView.this.cyS()) {
                            QuickVideoView.this.juG.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juS) {
                            QuickVideoView.this.juG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.juR);
                            if (QuickVideoView.this.juk != null) {
                                QuickVideoView.this.juk.cyt();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.juJ.cgG();
                            }
                        }
                    }
                } else if (cyV()) {
                    if (QuickVideoView.this.juG != null) {
                        QuickVideoView.this.cyJ();
                        QuickVideoView.this.juP = true;
                        QuickVideoView.this.juG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.juJ.cgF();
                    }
                }
                QuickVideoView.this.juT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jvs) {
                    QuickVideoView.this.cyL();
                    QuickVideoView.this.rO(false);
                    if (QuickVideoView.this.juG != null) {
                        if (QuickVideoView.this.juG.isPlaying() && QuickVideoView.this.cyQ()) {
                            x.czs().bl(QuickVideoView.this.jva, QuickVideoView.this.juG.getCurrentPosition());
                            if (QuickVideoView.this.jve) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jve) {
                            QuickVideoView.this.juG.release();
                        }
                    }
                    if (QuickVideoView.this.juP) {
                        if (QuickVideoView.this.juN != null && !QuickVideoView.this.jve) {
                            QuickVideoView.this.juN.GY(QuickVideoView.this.juZ);
                        }
                        if (QuickVideoView.this.dMk != null) {
                            QuickVideoView.this.dMk.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.juT = null;
                    if (QuickVideoView.this.juJ != null && QuickVideoView.this.juJ.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.juJ = null;
                    }
                    if (!QuickVideoView.this.jve) {
                        QuickVideoView.this.juP = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cyV() {
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
        this.efb = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.cyL();
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.onPrepared();
                }
                if (QuickVideoView.this.juJ != null && QuickVideoView.this.juG != null) {
                    QuickVideoView.this.juJ.yh(QuickVideoView.this.juG.getPlayerType());
                }
                if (QuickVideoView.this.jve) {
                    TbVideoViewSet.czv().a(QuickVideoView.this, QuickVideoView.this.juZ);
                }
                if (QuickVideoView.this.dVd != null) {
                    QuickVideoView.this.juO.cgW();
                    QuickVideoView.this.dVd.onPrepared(gVar);
                }
                if (QuickVideoView.this.juN != null) {
                    long j = 0;
                    if (QuickVideoView.this.juG != null) {
                        j = QuickVideoView.this.juG.getDuration();
                    }
                    QuickVideoView.this.juN.ew(j);
                    QuickVideoView.this.cyK();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.juN.cyD();
                        QuickVideoView.this.cyP();
                    }
                }
                if (QuickVideoView.this.jvd && (Hd = x.czs().Hd(QuickVideoView.this.jva)) > 0 && QuickVideoView.this.juG != null) {
                    if (QuickVideoView.this.juG.isPlayerReuse()) {
                        if (QuickVideoView.this.juG.getCurrentPosition() == 0) {
                            QuickVideoView.this.As(Hd);
                        }
                    } else {
                        QuickVideoView.this.As(Hd);
                    }
                }
                if (QuickVideoView.this.juM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.juE != null && gVar != null) {
                    QuickVideoView.this.juE.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juQ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.juF) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.juF);
                }
                if (QuickVideoView.this.juV != null && QuickVideoView.this.juV.czN()) {
                    com.baidu.tieba.play.b.e.Ay(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efc = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rO(true);
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.juJ = null;
                }
                if (!QuickVideoView.this.eeR || QuickVideoView.this.juN == null) {
                    if (QuickVideoView.this.juN != null) {
                        QuickVideoView.this.juN.onCompletion();
                    }
                    QuickVideoView.this.juM = false;
                    x.czs().remove(QuickVideoView.this.jva);
                    if (QuickVideoView.this.dVc != null) {
                        QuickVideoView.this.dVc.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.juL = null;
                QuickVideoView.this.jvb = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.juN.cyw());
                QuickVideoView.this.start();
            }
        };
        this.dVe = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.X(i2, i22, i3);
                QuickVideoView.this.cyL();
                if (QuickVideoView.this.juN != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cyQ()) {
                    QuickVideoView.this.jvc = true;
                    x.czs().bl(QuickVideoView.this.jva, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czv().Hf(QuickVideoView.this.juZ);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.juJ != null) {
                        QuickVideoView.this.juL = QuickVideoView.this.juJ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jvb, QuickVideoView.this.aq(QuickVideoView.this.juJ.cgK(), i3 + "", QuickVideoView.this.juJ.cgL()));
                        QuickVideoView.this.juJ = null;
                    }
                    QuickVideoView.this.jvb = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.Aw(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ax(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMg == null || QuickVideoView.this.dMg.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.eff = new g.InterfaceC0590g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (QuickVideoView.this.jvc) {
                    QuickVideoView.this.jvc = false;
                    return;
                }
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.cze();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.juN != null && z) {
                    QuickVideoView.this.juN.onSeekComplete();
                }
                if (QuickVideoView.this.dVg != null) {
                    QuickVideoView.this.dVg.b(gVar);
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.juH != null) {
                    QuickVideoView.this.juH.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.juQ = i22;
                    if (QuickVideoView.this.juE != null && gVar != null) {
                        QuickVideoView.this.juE.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.juQ);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.juO.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.juW != null) {
                    QuickVideoView.this.juW.a(i2, i22, QuickVideoView.this.juJ);
                    return true;
                }
                return true;
            }
        };
        this.dVh = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.m(i2, i22, str);
                }
            }
        };
        this.dVi = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.juJ != null) {
                    QuickVideoView.this.juJ.Fg(str);
                }
            }
        };
        this.dVj = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jvb = j;
                }
            }
        };
        this.jvw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.juN != null && QuickVideoView.this.juN.cyz() && QuickVideoView.this.juN.cyA() && QuickVideoView.this.juN.cyB() && QuickVideoView.this.juG != null) {
                    int aWG = QuickVideoView.this.juG.aWG();
                    int currentPosition = QuickVideoView.this.juG.getCurrentPosition();
                    int duration = QuickVideoView.this.juG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jvf;
                    boolean z = currentPosition + aWG < duration;
                    if (aWG < QuickVideoView.this.juN.cyC() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jvf = currentTimeMillis;
                        QuickVideoView.this.juN.Ap(0);
                    }
                    if (QuickVideoView.this.cyO() && currentPosition == QuickVideoView.this.jvg && j > 500) {
                        QuickVideoView.this.jvf = currentTimeMillis;
                        QuickVideoView.this.juN.Ap(0);
                    }
                    QuickVideoView.this.jvg = currentPosition;
                    if (QuickVideoView.this.jvm == QuickVideoView.jvk) {
                        QuickVideoView.this.cyP();
                    }
                }
            }
        };
        this.dVq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.juN != null) {
                        QuickVideoView.this.juN.wJ(QuickVideoView.this.juZ);
                    }
                    if (QuickVideoView.this.juJ != null) {
                        QuickVideoView.this.juJ.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.juJ = null;
                    }
                    QuickVideoView.this.cyL();
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
        this.juE = new RenderView(context);
        this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
        this.juE.setSurfaceTextureListener(this.aXP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.juU) {
            addView(this.juE, layoutParams);
        } else {
            addView(this.juE, 0, layoutParams);
        }
        if (eeZ != null) {
            this.juG = eeZ.aWJ();
        }
        if (this.juG != null) {
            this.juG.setOnPreparedListener(this.efb);
            this.juG.setOnCompletionListener(this.efc);
            this.juG.a(this.dVe);
            this.juG.setOnSeekCompleteListener(this.eff);
            this.juG.a(this.dVf);
            this.juG.a(this.dVh);
            this.juG.a(this.dVi);
            this.juG.a(this.dVj);
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
        this.juV = new com.baidu.tieba.play.b.a(this);
        this.juW = new q();
        this.juX = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.juO = new com.baidu.tieba.k.k();
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
        this.jvd = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.juZ;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.juO.cgV();
        this.Pj = str2;
        if (this.juV != null) {
            this.juV.clear();
            this.juV.czN();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Hh(str2);
            if (efa != null) {
                this.juJ = efa.ap(this.Pj, str, "");
                if (this.juJ != null) {
                    this.juJ.a(-300, -44399, -44399, getLocateSource(), false, this.jvb, "");
                    this.juJ = null;
                }
            }
        }
        if (this.juK != null) {
            this.juK.a(null);
            this.juK.cgy();
            this.juK = null;
        }
        this.juL = null;
        this.jvb = 0L;
        setVideoPath(str);
    }

    private String GZ(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPh().cPi()) {
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
            this.juY = GZ;
            if (this.juN != null) {
                GZ = this.juN.wE(GZ);
                if (this.juN.cyE() != null) {
                    this.juN.cyE().setPlayer(this);
                }
                if (efa != null && uy(GZ)) {
                    this.juK = efa.Fi(GZ);
                }
                if (this.juK != null) {
                    this.juK.a(new com.baidu.tieba.play.monitor.a(this.Pj, this.juY, this.juJ));
                    this.juK.cgx();
                }
                Ha(GZ);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !uy(GZ)) {
                if (this.dMg != null) {
                    this.dMg.onError(this.juG, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.czv().Hf(this.juZ);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(GZ));
            if (this.juJ != null && u(Uri.parse(GZ)) != null) {
                this.juJ.cgE();
            }
            this.juZ = str;
            int lastIndexOf = this.juZ.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.juZ.length() > 4) {
                this.jva = this.juZ.substring(0, lastIndexOf + 4);
            } else {
                this.jva = this.juZ;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyJ() {
        if (com.baidu.tbadk.coreExtra.model.f.aMf()) {
            if (this.juN != null && (this.juN.cyy() || this.juN.cyz())) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvt);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.jvt, com.baidu.tbadk.coreExtra.model.f.aMe());
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jvu, com.baidu.tbadk.coreExtra.model.f.aMd());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.juJ.Fc(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aWC();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.jvv = false;
        if (this.juT != null) {
            cyJ();
            if (this.juG != null) {
                if (!this.juP) {
                    this.juP = true;
                    this.juG.a(this.mContext, this.mUri, this.mHeaders, this.juT, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying() && this.efb != null) {
                    this.jvv = true;
                    this.efb.onPrepared(this.juG);
                }
            }
        } else if (this.juE != null && this.juE.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.juU) {
                addView(this.juE, layoutParams);
            } else {
                addView(this.juE, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aWC() {
        this.juP = false;
        this.juM = false;
        if (this.juG != null) {
            if (this.juG.isPlaying() && cyQ()) {
                x.czs().bl(this.jva, this.juG.getCurrentPosition());
            }
            this.juG.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvw);
    }

    private void Ha(String str) {
        this.mBitRate = 0;
        this.jvo = 0;
        this.jvp = 0;
        this.jvq = 0;
        this.jvr = 0;
        this.eaa = 0;
        if (this.juN.cyz()) {
            this.jvn = jvi;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.jvo = (int) t.Hc(QuickVideoView.this.juY);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.juY != null && this.juY.equals(str)) {
            this.jvn = jvh;
        } else {
            this.jvn = jvj;
        }
        this.jvm = jvk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        this.jvm = jvk;
        if (this.juG != null) {
            this.mBitRate = this.juG.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(boolean z) {
        if (this.jvm == jvk && this.juG != null) {
            this.jvm = jvl;
            this.jvq = this.juG.getDuration();
            if (z) {
                this.jvr = 0;
                this.jvp = this.jvq;
            } else {
                this.jvp = this.juG.getCurrentPosition();
                this.jvr = this.juG.getCachedSize();
            }
            if (this.jvp > 0) {
                if (this.jvn == jvh) {
                    this.jvo = (int) t.Hc(this.juY);
                    if (this.mBitRate > 0) {
                        long j = (this.mBitRate * (this.jvp / 1000)) / 8;
                        if (this.jvr < 0) {
                            this.jvr = 0;
                        }
                        long j2 = this.jvr + j;
                        if (this.jvo > 0) {
                            j2 += this.jvo;
                        }
                        setFlowCount(j2, this.jvp, this.jvq, this.eaa);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jvp / 1000)) / 8, this.jvp, this.jvq, this.eaa);
                    }
                } else if (this.jvn == jvi) {
                    if (this.mBitRate > 0) {
                        long j3 = (this.mBitRate * (this.jvp / 1000)) / 8;
                        if (this.jvr < 0) {
                            this.jvr = 0;
                        }
                        long j4 = this.jvr + j3;
                        if (this.jvo > 0) {
                            j4 -= this.jvo;
                        }
                        setFlowCount(j4, this.jvp, this.jvq, this.eaa);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jvp / 1000)) / 8, this.jvp, this.jvq, this.eaa);
                    }
                } else {
                    setFlowCount(0L, this.jvp, this.jvq, this.eaa);
                }
            }
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvw);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jve) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        cyL();
        rO(false);
        if (this.juV != null) {
            this.juV.clear();
        }
        this.juF = null;
        this.juM = false;
        if (this.juG != null) {
            if (this.juG.isPlaying() && cyQ()) {
                x.czs().bl(this.jva, this.juG.getCurrentPosition());
            }
            this.juG.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvw);
        this.eeR = false;
        if (this.juN != null) {
            this.juN.cyx();
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.juJ != null && this.juJ.Ff(getLocateSource())) {
            this.juJ = null;
        }
        if (this.juO != null) {
            this.juO.cgU();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvw);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pf, false);
        }
        cyL();
        rO(false);
        if (this.juV != null) {
            this.juV.clear();
        }
        this.juF = null;
        aWC();
        TbVideoViewSet.czv().Hf(this.juZ);
        this.eeR = false;
        if (this.juN != null) {
            this.juN.GY(this.juZ);
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.juJ != null && this.juJ.Ff(getLocateSource())) {
            this.juJ = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvw);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.jvs = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyL() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvt);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvu);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.dVd = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.dVc = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.dMg = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0590g interfaceC0590g) {
        this.dVg = interfaceC0590g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyM() {
        cyL();
        if (this.juW != null) {
            this.juW.onPrepared();
        }
        if (u(this.mUri) != null && this.juG != null) {
            this.juJ.Fc(this.mUri.getPath());
            this.juJ.yi(this.juG.getPlayerType());
        }
        this.juO.cgV();
        this.juO.cgW();
        if (this.juN != null) {
            long j = 0;
            if (this.juG != null) {
                j = this.juG.getDuration();
            }
            this.juN.ew(j);
            cyK();
            if (getPlayerType() == -200) {
                this.juN.cyD();
                cyP();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cyN() {
        if (u(this.mUri) != null && this.juG != null) {
            this.juJ.Fc(this.mUri.getPath());
            this.juJ.cgE();
            this.juJ.yh(this.juG.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.juX == null) {
            return "";
        }
        String czP = this.juX.czP();
        this.juX.ar(str, str2, str3);
        return czP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.juN != null && !StringUtils.isNull(this.juN.cyw())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Hg(uri);
                }
            }
            this.mUri = Uri.parse(this.juN.cyw());
        }
        boolean z = false;
        if (this.juV != null) {
            z = this.juV.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.juJ != null) {
            this.juL = this.juJ.a(i, i2, i3, getLocateSource(), z, this.jvb, aq(this.juJ.cgK(), i3 + "", this.juJ.cgL()));
            this.juJ = null;
        }
        this.jvb = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.juG != null) {
            try {
                if (this.juG.isPlaying() && cyQ()) {
                    x.czs().bl(this.jva, this.juG.getCurrentPosition());
                }
                this.juG.release();
                this.juF = str;
                URI uri = new URI(this.mUri.toString());
                this.juG.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.juT, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.juJ.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.juG != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.juG.isPlaying() && cyQ()) {
                x.czs().bl(this.jva, this.juG.getCurrentPosition());
            }
            this.juG.release();
            this.juG.a(this.mContext, this.mUri, this.mHeaders, this.juT, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.juJ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.juG != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.juG.forceUseSystemMediaPlayer(true);
            }
            if (this.juG.isPlaying() && cyQ()) {
                x.czs().bl(this.jva, this.juG.getCurrentPosition());
            }
            this.juG.release();
            this.juG.a(this.mContext, this.mUri, this.mHeaders, this.juT, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.juJ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.juM = true;
        if (this.juG != null) {
            if (this.juT != null && this.juS && !this.juG.isExistInRemote()) {
                this.juG.a(this.mContext, this.mUri, this.mHeaders, this.juT, this.juR);
                if (this.juk != null) {
                    this.juk.cyt();
                }
                if (u(this.mUri) != null) {
                    this.juJ.cgG();
                }
                cyJ();
                return;
            }
            if (!this.juG.aWH()) {
                af.a(this.Pf, true);
                this.juG.setVolume(1.0f, 1.0f);
            }
            this.juO.cgX();
            this.juG.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.juN != null) {
            this.juN.onStart();
        }
        if (this.juI != null) {
            this.juI.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.juG != null) {
            this.juJ.yj(this.juG.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.juM) {
            b(aVar);
            return;
        }
        this.juM = true;
        if (aVar != null) {
            this.jve = true;
            if (!cyT()) {
                aVar.czw();
            }
        } else {
            this.jve = false;
        }
        setVideoPath(this.juZ, this.Pj);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cyL();
        af.a(this.Pf, false);
        if (this.juG != null) {
            if (this.juG.isPlaying() && cyQ()) {
                x.czs().bl(this.jva, this.juG.getCurrentPosition());
            }
            this.juG.pause();
        }
        if (this.juN != null) {
            this.juN.onPause();
        }
        this.juM = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juJ != null) {
            this.juJ.cgJ();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.juG != null) {
            return this.juG.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.juG != null) {
            return this.juG.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.eaa = i;
        As(i);
    }

    public void As(int i) {
        if (this.juW != null) {
            this.juW.czd();
        }
        if (this.juG != null) {
            this.juG.seekTo(i);
        }
        if (this.juN != null) {
            this.juN.Ap(0);
            cyP();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.juG != null) {
            return this.juG.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.juG != null) {
            this.juG.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.juR = i;
    }

    public int getRecoveryState() {
        return this.juR;
    }

    public void setNeedRecovery(boolean z) {
        this.juS = z;
    }

    public void setLooping(boolean z) {
        this.eeR = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cyO() {
        return this.juM;
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
        this.dMk = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.juN = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVq);
    }

    public void setMute(boolean z) {
        if (z) {
            this.juG.setVolume(0.0f, 0.0f);
            af.a(this.Pf, false);
            return;
        }
        af.a(this.Pf, true);
        this.juG.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eeR = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.juG != null) {
            this.juG.aWI();
        }
        if (this.juW != null) {
            this.juW.Gm();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvw);
        MessageManager.getInstance().unRegisterListener(this.dVq);
        if (this.juV != null) {
            this.juV.clear();
        }
        if (this.juK != null) {
            this.juK.a(null);
            this.juK.cgy();
        }
    }

    public g getPlayer() {
        return this.juG;
    }

    public int getPlayerType() {
        if (this.juG == null) {
            return -300;
        }
        return this.juG.getPlayerType();
    }

    public void cyP() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvw);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvw, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.juk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.juN instanceof n) || ((n) this.juN).czc() == null) {
            return "";
        }
        return ((n) this.juN).jvI ? "v_mid_page" : ((n) this.juN).czc().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i u(Uri uri) {
        String uri2;
        if (this.juJ != null) {
            return this.juJ;
        }
        if (!StringUtils.isNull(this.juY)) {
            uri2 = this.juY;
        } else if (efa != null && this.juN != null && !StringUtils.isNull(this.juN.cyw())) {
            uri2 = this.juN.cyw();
        } else {
            uri2 = (efa == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && efa != null) {
            this.juJ = efa.ap(this.Pj, uri2, this.juL);
        }
        this.juL = null;
        this.jvb = 0L;
        return this.juJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyQ() {
        return this.juG != null && this.juG.getDuration() >= this.juG.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.juJ, j, j2, j3, j4);
    }

    public static boolean uy(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cyR() {
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
            this.jve = true;
            if (!cyT()) {
                aVar.czw();
            }
            if (!cyS()) {
                aVar.czx();
                this.juM = true;
                setVideoPath(this.juZ, this.Pj);
                return;
            }
        } else {
            this.jve = false;
        }
        start();
        if (this.juG != null && this.jve) {
            this.juO.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyS() {
        return this == TbVideoViewSet.czv().He(this.juZ);
    }

    private boolean cyT() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.dVc = null;
        this.dMg = null;
        this.dVf = null;
        this.efb = null;
        this.eff = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jve = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.juH = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.juG != null) {
            return this.juG.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.juG != null ? this.juG.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.juJ != null) {
            this.juJ.e(j, j2, j3);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.juI = cVar;
    }
}
