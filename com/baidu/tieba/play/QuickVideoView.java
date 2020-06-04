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
import com.baidu.tbadk.util.ag;
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
    private static int kzO = 0;
    private static int kzP = 1;
    private static int kzQ = 2;
    private static int kzR = 1;
    private static int kzS = 0;
    private static h kzo;
    private static com.baidu.tieba.k.l kzp;
    private WeakReference<Context> aio;
    private String ais;
    private TextureView.SurfaceTextureListener bEl;
    private boolean drn;
    private int dsA;
    private g.b eBv;
    private b eBz;
    private g.InterfaceC0705g eKA;
    private g.i eKB;
    private g.d eKC;
    private g.h eKD;
    private final CustomMessageListener eKK;
    private g.a eKw;
    private g.f eKx;
    private g.c eKy;
    private g.e eKz;
    private boolean kAa;
    private Runnable kAb;
    private Runnable kAc;
    public boolean kAd;
    private g.f kAe;
    private g.a kAf;
    private g.InterfaceC0705g kAg;
    private Runnable kAh;
    private a kyP;
    private SurfaceTexture kzA;
    private boolean kzB;
    private com.baidu.tieba.play.b.a kzC;
    private q kzD;
    private com.baidu.tieba.play.b.f kzE;
    private String kzF;
    private String kzG;
    private String kzH;
    private long kzI;
    private boolean kzJ;
    private boolean kzK;
    private boolean kzL;
    private long kzM;
    private long kzN;
    private int kzT;
    private int kzU;
    private int kzV;
    private int kzW;
    private int kzX;
    private int kzY;
    private int kzZ;
    private RenderView kzj;
    private String kzk;
    private g kzl;
    private g.e kzm;
    private c kzn;
    private com.baidu.tieba.k.i kzq;
    private com.baidu.tieba.k.e kzr;
    private String kzs;
    private boolean kzt;
    private d kzu;
    private com.baidu.tieba.k.k kzv;
    private boolean kzw;
    private int kzx;
    private int kzy;
    private boolean kzz;
    private Context mContext;
    private Map<String, String> mHeaders;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cQF();
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
            kzo = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            kzp = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.kzB = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.kzt = false;
        this.kzw = false;
        this.kzx = 0;
        this.drn = false;
        this.kzy = -1;
        this.kzz = false;
        this.kzA = null;
        this.kzB = true;
        this.kzL = false;
        this.kzM = 0L;
        this.kzN = 0L;
        this.kzT = kzS;
        this.kzU = 0;
        this.kzV = 0;
        this.kzW = -1;
        this.kzX = 0;
        this.kzY = 0;
        this.kzZ = 0;
        this.dsA = 0;
        this.kAa = false;
        this.aio = null;
        this.kAb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kzl != null && QuickVideoView.this.kzt) {
                    QuickVideoView.this.b(QuickVideoView.this.kzl, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kAc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.qy(false);
                }
            }
        };
        this.kAd = false;
        this.bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kAa) {
                    QuickVideoView.this.kAa = false;
                    if (QuickVideoView.this.kzl != null) {
                        QuickVideoView.this.kzl.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kzw || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kzl != null) {
                        if (QuickVideoView.this.cRe()) {
                            QuickVideoView.this.kzl.d(surfaceTexture);
                        } else if (QuickVideoView.this.kzz) {
                            QuickVideoView.this.kzl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kzy);
                            if (QuickVideoView.this.kyP != null) {
                                QuickVideoView.this.kyP.cQF();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kzq.cyA();
                            }
                        }
                    }
                } else if (cRh()) {
                    if (QuickVideoView.this.kzl != null) {
                        QuickVideoView.this.cQV();
                        QuickVideoView.this.kzw = true;
                        QuickVideoView.this.kzl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kzq.cyz();
                    }
                }
                QuickVideoView.this.kzA = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kAa) {
                    QuickVideoView.this.cQX();
                    QuickVideoView.this.tw(false);
                    if (QuickVideoView.this.kzl != null) {
                        if (QuickVideoView.this.kzl.isPlaying() && QuickVideoView.this.cRc()) {
                            x.cRE().bw(QuickVideoView.this.kzH, QuickVideoView.this.kzl.getCurrentPosition());
                            if (QuickVideoView.this.kzL) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kzL) {
                            QuickVideoView.this.kzl.release();
                        }
                    }
                    if (QuickVideoView.this.kzw) {
                        if (QuickVideoView.this.kzu != null && !QuickVideoView.this.kzL) {
                            QuickVideoView.this.kzu.Kw(QuickVideoView.this.kzG);
                        }
                        if (QuickVideoView.this.eBz != null) {
                            QuickVideoView.this.eBz.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kzA = null;
                    if (QuickVideoView.this.kzq != null && QuickVideoView.this.kzq.IA(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kzq = null;
                    }
                    if (!QuickVideoView.this.kzL) {
                        QuickVideoView.this.kzw = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cRh() {
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
        this.kAe = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int KB;
                QuickVideoView.this.cQX();
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.onPrepared();
                }
                if (QuickVideoView.this.kzq != null && QuickVideoView.this.kzl != null) {
                    QuickVideoView.this.kzq.zA(QuickVideoView.this.kzl.getPlayerType());
                }
                if (QuickVideoView.this.kzL) {
                    TbVideoViewSet.cRJ().a(QuickVideoView.this, QuickVideoView.this.kzG);
                }
                if (QuickVideoView.this.eKx != null) {
                    QuickVideoView.this.kzv.cyQ();
                    QuickVideoView.this.eKx.onPrepared(gVar);
                }
                if (QuickVideoView.this.kzu != null) {
                    long j = 0;
                    if (QuickVideoView.this.kzl != null) {
                        j = QuickVideoView.this.kzl.getDuration();
                    }
                    QuickVideoView.this.kzu.fj(j);
                    QuickVideoView.this.cQW();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kzu.cQP();
                        QuickVideoView.this.cRb();
                    }
                }
                if (QuickVideoView.this.kzK && (KB = x.cRE().KB(QuickVideoView.this.kzH)) > 0 && QuickVideoView.this.kzl != null && QuickVideoView.this.kzl.getCurrentPosition() == 0) {
                    QuickVideoView.this.BM(KB);
                }
                if (QuickVideoView.this.kzt) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kzj != null && gVar != null) {
                    QuickVideoView.this.kzj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kzx);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kzk) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kzk);
                }
                if (QuickVideoView.this.kzC != null && QuickVideoView.this.kzC.cSg()) {
                    com.baidu.tieba.play.b.e.BS(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kAf = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tw(true);
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.Iz(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kzq = null;
                }
                if (!QuickVideoView.this.drn || QuickVideoView.this.kzu == null) {
                    if (QuickVideoView.this.kzu != null) {
                        QuickVideoView.this.kzu.onCompletion();
                    }
                    QuickVideoView.this.kzt = false;
                    x.cRE().remove(QuickVideoView.this.kzH);
                    if (QuickVideoView.this.eKw != null) {
                        QuickVideoView.this.eKw.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kzs = null;
                QuickVideoView.this.kzI = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kzu.cQI());
                QuickVideoView.this.start();
            }
        };
        this.eKy = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cQX();
                if (QuickVideoView.this.kzu != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cRc()) {
                    QuickVideoView.this.kzJ = true;
                    x.cRE().bw(QuickVideoView.this.kzH, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRJ().KD(QuickVideoView.this.kzG);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kzq != null) {
                        QuickVideoView.this.kzs = QuickVideoView.this.kzq.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kzI, QuickVideoView.this.au(QuickVideoView.this.kzq.cyE(), i3 + "", QuickVideoView.this.kzq.cyF()));
                        QuickVideoView.this.kzq = null;
                    }
                    QuickVideoView.this.kzI = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.BQ(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.BR(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eBv == null || QuickVideoView.this.eBv.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.kAg = new g.InterfaceC0705g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(g gVar) {
                if (QuickVideoView.this.kzJ) {
                    QuickVideoView.this.kzJ = false;
                    return;
                }
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.cRq();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kzu != null && z) {
                    QuickVideoView.this.kzu.onSeekComplete();
                }
                if (QuickVideoView.this.eKA != null) {
                    QuickVideoView.this.eKA.b(gVar);
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kzm != null) {
                    QuickVideoView.this.kzm.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kzx = i2;
                    if (QuickVideoView.this.kzj != null && gVar != null) {
                        QuickVideoView.this.kzj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kzx);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kzv.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.a(i, i2, QuickVideoView.this.kzq);
                    return true;
                }
                return true;
            }
        };
        this.eKB = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.m(i, i2, str);
                }
            }
        };
        this.eKC = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.IB(str);
                }
            }
        };
        this.eKD = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kzI = j;
                }
            }
        };
        this.kAh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kzu != null && QuickVideoView.this.kzu.cQL() && QuickVideoView.this.kzu.cQM() && QuickVideoView.this.kzu.cQN() && QuickVideoView.this.kzl != null) {
                    int bld = QuickVideoView.this.kzl.bld();
                    int currentPosition = QuickVideoView.this.kzl.getCurrentPosition();
                    int duration = QuickVideoView.this.kzl.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kzM;
                    boolean z = currentPosition + bld < duration;
                    if (bld < QuickVideoView.this.kzu.cQO() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kzM = currentTimeMillis;
                        QuickVideoView.this.kzu.BJ(0);
                    }
                    if (QuickVideoView.this.cRa() && currentPosition == QuickVideoView.this.kzN && j > 500) {
                        QuickVideoView.this.kzM = currentTimeMillis;
                        QuickVideoView.this.kzu.BJ(0);
                    }
                    QuickVideoView.this.kzN = currentPosition;
                    if (QuickVideoView.this.kzT == QuickVideoView.kzR) {
                        QuickVideoView.this.cRb();
                    }
                }
            }
        };
        this.eKK = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kzu != null) {
                        QuickVideoView.this.kzu.zG(QuickVideoView.this.kzG);
                    }
                    if (QuickVideoView.this.kzq != null) {
                        QuickVideoView.this.kzq.Iy(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kzq = null;
                    }
                    QuickVideoView.this.cQX();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kzt = false;
        this.kzw = false;
        this.kzx = 0;
        this.drn = false;
        this.kzy = -1;
        this.kzz = false;
        this.kzA = null;
        this.kzB = true;
        this.kzL = false;
        this.kzM = 0L;
        this.kzN = 0L;
        this.kzT = kzS;
        this.kzU = 0;
        this.kzV = 0;
        this.kzW = -1;
        this.kzX = 0;
        this.kzY = 0;
        this.kzZ = 0;
        this.dsA = 0;
        this.kAa = false;
        this.aio = null;
        this.kAb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kzl != null && QuickVideoView.this.kzt) {
                    QuickVideoView.this.b(QuickVideoView.this.kzl, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kAc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.qy(false);
                }
            }
        };
        this.kAd = false;
        this.bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kAa) {
                    QuickVideoView.this.kAa = false;
                    if (QuickVideoView.this.kzl != null) {
                        QuickVideoView.this.kzl.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kzw || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kzl != null) {
                        if (QuickVideoView.this.cRe()) {
                            QuickVideoView.this.kzl.d(surfaceTexture);
                        } else if (QuickVideoView.this.kzz) {
                            QuickVideoView.this.kzl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kzy);
                            if (QuickVideoView.this.kyP != null) {
                                QuickVideoView.this.kyP.cQF();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kzq.cyA();
                            }
                        }
                    }
                } else if (cRh()) {
                    if (QuickVideoView.this.kzl != null) {
                        QuickVideoView.this.cQV();
                        QuickVideoView.this.kzw = true;
                        QuickVideoView.this.kzl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kzq.cyz();
                    }
                }
                QuickVideoView.this.kzA = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kAa) {
                    QuickVideoView.this.cQX();
                    QuickVideoView.this.tw(false);
                    if (QuickVideoView.this.kzl != null) {
                        if (QuickVideoView.this.kzl.isPlaying() && QuickVideoView.this.cRc()) {
                            x.cRE().bw(QuickVideoView.this.kzH, QuickVideoView.this.kzl.getCurrentPosition());
                            if (QuickVideoView.this.kzL) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kzL) {
                            QuickVideoView.this.kzl.release();
                        }
                    }
                    if (QuickVideoView.this.kzw) {
                        if (QuickVideoView.this.kzu != null && !QuickVideoView.this.kzL) {
                            QuickVideoView.this.kzu.Kw(QuickVideoView.this.kzG);
                        }
                        if (QuickVideoView.this.eBz != null) {
                            QuickVideoView.this.eBz.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kzA = null;
                    if (QuickVideoView.this.kzq != null && QuickVideoView.this.kzq.IA(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kzq = null;
                    }
                    if (!QuickVideoView.this.kzL) {
                        QuickVideoView.this.kzw = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cRh() {
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
        this.kAe = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int KB;
                QuickVideoView.this.cQX();
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.onPrepared();
                }
                if (QuickVideoView.this.kzq != null && QuickVideoView.this.kzl != null) {
                    QuickVideoView.this.kzq.zA(QuickVideoView.this.kzl.getPlayerType());
                }
                if (QuickVideoView.this.kzL) {
                    TbVideoViewSet.cRJ().a(QuickVideoView.this, QuickVideoView.this.kzG);
                }
                if (QuickVideoView.this.eKx != null) {
                    QuickVideoView.this.kzv.cyQ();
                    QuickVideoView.this.eKx.onPrepared(gVar);
                }
                if (QuickVideoView.this.kzu != null) {
                    long j = 0;
                    if (QuickVideoView.this.kzl != null) {
                        j = QuickVideoView.this.kzl.getDuration();
                    }
                    QuickVideoView.this.kzu.fj(j);
                    QuickVideoView.this.cQW();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kzu.cQP();
                        QuickVideoView.this.cRb();
                    }
                }
                if (QuickVideoView.this.kzK && (KB = x.cRE().KB(QuickVideoView.this.kzH)) > 0 && QuickVideoView.this.kzl != null && QuickVideoView.this.kzl.getCurrentPosition() == 0) {
                    QuickVideoView.this.BM(KB);
                }
                if (QuickVideoView.this.kzt) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kzj != null && gVar != null) {
                    QuickVideoView.this.kzj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kzx);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kzk) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kzk);
                }
                if (QuickVideoView.this.kzC != null && QuickVideoView.this.kzC.cSg()) {
                    com.baidu.tieba.play.b.e.BS(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kAf = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tw(true);
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.Iz(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kzq = null;
                }
                if (!QuickVideoView.this.drn || QuickVideoView.this.kzu == null) {
                    if (QuickVideoView.this.kzu != null) {
                        QuickVideoView.this.kzu.onCompletion();
                    }
                    QuickVideoView.this.kzt = false;
                    x.cRE().remove(QuickVideoView.this.kzH);
                    if (QuickVideoView.this.eKw != null) {
                        QuickVideoView.this.eKw.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kzs = null;
                QuickVideoView.this.kzI = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kzu.cQI());
                QuickVideoView.this.start();
            }
        };
        this.eKy = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cQX();
                if (QuickVideoView.this.kzu != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cRc()) {
                    QuickVideoView.this.kzJ = true;
                    x.cRE().bw(QuickVideoView.this.kzH, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRJ().KD(QuickVideoView.this.kzG);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kzq != null) {
                        QuickVideoView.this.kzs = QuickVideoView.this.kzq.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kzI, QuickVideoView.this.au(QuickVideoView.this.kzq.cyE(), i3 + "", QuickVideoView.this.kzq.cyF()));
                        QuickVideoView.this.kzq = null;
                    }
                    QuickVideoView.this.kzI = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.BQ(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.BR(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eBv == null || QuickVideoView.this.eBv.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.kAg = new g.InterfaceC0705g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(g gVar) {
                if (QuickVideoView.this.kzJ) {
                    QuickVideoView.this.kzJ = false;
                    return;
                }
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.cRq();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kzu != null && z) {
                    QuickVideoView.this.kzu.onSeekComplete();
                }
                if (QuickVideoView.this.eKA != null) {
                    QuickVideoView.this.eKA.b(gVar);
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kzm != null) {
                    QuickVideoView.this.kzm.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kzx = i2;
                    if (QuickVideoView.this.kzj != null && gVar != null) {
                        QuickVideoView.this.kzj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kzx);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kzv.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.a(i, i2, QuickVideoView.this.kzq);
                    return true;
                }
                return true;
            }
        };
        this.eKB = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.m(i, i2, str);
                }
            }
        };
        this.eKC = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.IB(str);
                }
            }
        };
        this.eKD = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kzI = j;
                }
            }
        };
        this.kAh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kzu != null && QuickVideoView.this.kzu.cQL() && QuickVideoView.this.kzu.cQM() && QuickVideoView.this.kzu.cQN() && QuickVideoView.this.kzl != null) {
                    int bld = QuickVideoView.this.kzl.bld();
                    int currentPosition = QuickVideoView.this.kzl.getCurrentPosition();
                    int duration = QuickVideoView.this.kzl.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kzM;
                    boolean z = currentPosition + bld < duration;
                    if (bld < QuickVideoView.this.kzu.cQO() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kzM = currentTimeMillis;
                        QuickVideoView.this.kzu.BJ(0);
                    }
                    if (QuickVideoView.this.cRa() && currentPosition == QuickVideoView.this.kzN && j > 500) {
                        QuickVideoView.this.kzM = currentTimeMillis;
                        QuickVideoView.this.kzu.BJ(0);
                    }
                    QuickVideoView.this.kzN = currentPosition;
                    if (QuickVideoView.this.kzT == QuickVideoView.kzR) {
                        QuickVideoView.this.cRb();
                    }
                }
            }
        };
        this.eKK = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kzu != null) {
                        QuickVideoView.this.kzu.zG(QuickVideoView.this.kzG);
                    }
                    if (QuickVideoView.this.kzq != null) {
                        QuickVideoView.this.kzq.Iy(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kzq = null;
                    }
                    QuickVideoView.this.cQX();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzt = false;
        this.kzw = false;
        this.kzx = 0;
        this.drn = false;
        this.kzy = -1;
        this.kzz = false;
        this.kzA = null;
        this.kzB = true;
        this.kzL = false;
        this.kzM = 0L;
        this.kzN = 0L;
        this.kzT = kzS;
        this.kzU = 0;
        this.kzV = 0;
        this.kzW = -1;
        this.kzX = 0;
        this.kzY = 0;
        this.kzZ = 0;
        this.dsA = 0;
        this.kAa = false;
        this.aio = null;
        this.kAb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kzl != null && QuickVideoView.this.kzt) {
                    QuickVideoView.this.b(QuickVideoView.this.kzl, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kAc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.qy(false);
                }
            }
        };
        this.kAd = false;
        this.bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.kAa) {
                    QuickVideoView.this.kAa = false;
                    if (QuickVideoView.this.kzl != null) {
                        QuickVideoView.this.kzl.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kzw || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kzl != null) {
                        if (QuickVideoView.this.cRe()) {
                            QuickVideoView.this.kzl.d(surfaceTexture);
                        } else if (QuickVideoView.this.kzz) {
                            QuickVideoView.this.kzl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kzy);
                            if (QuickVideoView.this.kyP != null) {
                                QuickVideoView.this.kyP.cQF();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kzq.cyA();
                            }
                        }
                    }
                } else if (cRh()) {
                    if (QuickVideoView.this.kzl != null) {
                        QuickVideoView.this.cQV();
                        QuickVideoView.this.kzw = true;
                        QuickVideoView.this.kzl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kzq.cyz();
                    }
                }
                QuickVideoView.this.kzA = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kAa) {
                    QuickVideoView.this.cQX();
                    QuickVideoView.this.tw(false);
                    if (QuickVideoView.this.kzl != null) {
                        if (QuickVideoView.this.kzl.isPlaying() && QuickVideoView.this.cRc()) {
                            x.cRE().bw(QuickVideoView.this.kzH, QuickVideoView.this.kzl.getCurrentPosition());
                            if (QuickVideoView.this.kzL) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kzL) {
                            QuickVideoView.this.kzl.release();
                        }
                    }
                    if (QuickVideoView.this.kzw) {
                        if (QuickVideoView.this.kzu != null && !QuickVideoView.this.kzL) {
                            QuickVideoView.this.kzu.Kw(QuickVideoView.this.kzG);
                        }
                        if (QuickVideoView.this.eBz != null) {
                            QuickVideoView.this.eBz.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kzA = null;
                    if (QuickVideoView.this.kzq != null && QuickVideoView.this.kzq.IA(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kzq = null;
                    }
                    if (!QuickVideoView.this.kzL) {
                        QuickVideoView.this.kzw = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cRh() {
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
        this.kAe = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int KB;
                QuickVideoView.this.cQX();
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.onPrepared();
                }
                if (QuickVideoView.this.kzq != null && QuickVideoView.this.kzl != null) {
                    QuickVideoView.this.kzq.zA(QuickVideoView.this.kzl.getPlayerType());
                }
                if (QuickVideoView.this.kzL) {
                    TbVideoViewSet.cRJ().a(QuickVideoView.this, QuickVideoView.this.kzG);
                }
                if (QuickVideoView.this.eKx != null) {
                    QuickVideoView.this.kzv.cyQ();
                    QuickVideoView.this.eKx.onPrepared(gVar);
                }
                if (QuickVideoView.this.kzu != null) {
                    long j = 0;
                    if (QuickVideoView.this.kzl != null) {
                        j = QuickVideoView.this.kzl.getDuration();
                    }
                    QuickVideoView.this.kzu.fj(j);
                    QuickVideoView.this.cQW();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kzu.cQP();
                        QuickVideoView.this.cRb();
                    }
                }
                if (QuickVideoView.this.kzK && (KB = x.cRE().KB(QuickVideoView.this.kzH)) > 0 && QuickVideoView.this.kzl != null && QuickVideoView.this.kzl.getCurrentPosition() == 0) {
                    QuickVideoView.this.BM(KB);
                }
                if (QuickVideoView.this.kzt) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kzj != null && gVar != null) {
                    QuickVideoView.this.kzj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kzx);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kzk) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kzk);
                }
                if (QuickVideoView.this.kzC != null && QuickVideoView.this.kzC.cSg()) {
                    com.baidu.tieba.play.b.e.BS(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kAf = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tw(true);
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.Iz(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kzq = null;
                }
                if (!QuickVideoView.this.drn || QuickVideoView.this.kzu == null) {
                    if (QuickVideoView.this.kzu != null) {
                        QuickVideoView.this.kzu.onCompletion();
                    }
                    QuickVideoView.this.kzt = false;
                    x.cRE().remove(QuickVideoView.this.kzH);
                    if (QuickVideoView.this.eKw != null) {
                        QuickVideoView.this.eKw.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kzs = null;
                QuickVideoView.this.kzI = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kzu.cQI());
                QuickVideoView.this.start();
            }
        };
        this.eKy = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.aa(i2, i22, i3);
                QuickVideoView.this.cQX();
                if (QuickVideoView.this.kzu != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cRc()) {
                    QuickVideoView.this.kzJ = true;
                    x.cRE().bw(QuickVideoView.this.kzH, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRJ().KD(QuickVideoView.this.kzG);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kzq != null) {
                        QuickVideoView.this.kzs = QuickVideoView.this.kzq.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kzI, QuickVideoView.this.au(QuickVideoView.this.kzq.cyE(), i3 + "", QuickVideoView.this.kzq.cyF()));
                        QuickVideoView.this.kzq = null;
                    }
                    QuickVideoView.this.kzI = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.BQ(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.BR(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eBv == null || QuickVideoView.this.eBv.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.kAg = new g.InterfaceC0705g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(g gVar) {
                if (QuickVideoView.this.kzJ) {
                    QuickVideoView.this.kzJ = false;
                    return;
                }
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.cRq();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kzu != null && z) {
                    QuickVideoView.this.kzu.onSeekComplete();
                }
                if (QuickVideoView.this.eKA != null) {
                    QuickVideoView.this.eKA.b(gVar);
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.kzm != null) {
                    QuickVideoView.this.kzm.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.kzx = i22;
                    if (QuickVideoView.this.kzj != null && gVar != null) {
                        QuickVideoView.this.kzj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kzx);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.kzv.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kzD != null) {
                    QuickVideoView.this.kzD.a(i2, i22, QuickVideoView.this.kzq);
                    return true;
                }
                return true;
            }
        };
        this.eKB = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.m(i2, i22, str);
                }
            }
        };
        this.eKC = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kzq != null) {
                    QuickVideoView.this.kzq.IB(str);
                }
            }
        };
        this.eKD = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kzI = j;
                }
            }
        };
        this.kAh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kzu != null && QuickVideoView.this.kzu.cQL() && QuickVideoView.this.kzu.cQM() && QuickVideoView.this.kzu.cQN() && QuickVideoView.this.kzl != null) {
                    int bld = QuickVideoView.this.kzl.bld();
                    int currentPosition = QuickVideoView.this.kzl.getCurrentPosition();
                    int duration = QuickVideoView.this.kzl.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kzM;
                    boolean z = currentPosition + bld < duration;
                    if (bld < QuickVideoView.this.kzu.cQO() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kzM = currentTimeMillis;
                        QuickVideoView.this.kzu.BJ(0);
                    }
                    if (QuickVideoView.this.cRa() && currentPosition == QuickVideoView.this.kzN && j > 500) {
                        QuickVideoView.this.kzM = currentTimeMillis;
                        QuickVideoView.this.kzu.BJ(0);
                    }
                    QuickVideoView.this.kzN = currentPosition;
                    if (QuickVideoView.this.kzT == QuickVideoView.kzR) {
                        QuickVideoView.this.cRb();
                    }
                }
            }
        };
        this.eKK = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kzu != null) {
                        QuickVideoView.this.kzu.zG(QuickVideoView.this.kzG);
                    }
                    if (QuickVideoView.this.kzq != null) {
                        QuickVideoView.this.kzq.Iy(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kzq = null;
                    }
                    QuickVideoView.this.cQX();
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
        this.kzj = new RenderView(context);
        this.aio = new WeakReference<>(TbadkCoreApplication.getInst());
        this.kzj.setSurfaceTextureListener(this.bEl);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.kzB) {
            addView(this.kzj, layoutParams);
        } else {
            addView(this.kzj, 0, layoutParams);
        }
        if (kzo != null) {
            this.kzl = kzo.blg();
        }
        if (this.kzl != null) {
            this.kzl.setOnPreparedListener(this.kAe);
            this.kzl.setOnCompletionListener(this.kAf);
            this.kzl.a(this.eKy);
            this.kzl.setOnSeekCompleteListener(this.kAg);
            this.kzl.a(this.eKz);
            this.kzl.a(this.eKB);
            this.kzl.a(this.eKC);
            this.kzl.a(this.eKD);
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
        this.kzC = new com.baidu.tieba.play.b.a(this);
        this.kzD = new q();
        this.kzE = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.kzv = new com.baidu.tieba.k.k();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kzK = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kzG;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.kzv.cyP();
        this.ais = str2;
        if (this.kzC != null) {
            this.kzC.clear();
            this.kzC.cSg();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.KF(str2);
            if (kzp != null) {
                this.kzq = kzp.at(this.ais, str, "");
                if (this.kzq != null) {
                    this.kzq.a(-300, -44399, -44399, getLocateSource(), false, this.kzI, "");
                    this.kzq = null;
                }
            }
        }
        if (this.kzr != null) {
            this.kzr.a(null);
            this.kzr.cys();
            this.kzr = null;
        }
        this.kzs = null;
        this.kzI = 0L;
        setVideoPath(str);
    }

    private String Kx(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.dhZ().dia()) {
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
            String Kx = Kx(str);
            this.kzF = Kx;
            if (this.kzu != null) {
                Kx = this.kzu.zB(Kx);
                if (this.kzu.cQQ() != null) {
                    this.kzu.cQQ().setPlayer(this);
                }
                if (kzp != null && xw(Kx)) {
                    this.kzr = kzp.ID(Kx);
                }
                if (this.kzr != null) {
                    this.kzr.a(new com.baidu.tieba.play.monitor.a(this.ais, this.kzF, this.kzq));
                    this.kzr.cyr();
                }
                Ky(Kx);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !xw(Kx)) {
                if (this.eBv != null) {
                    this.eBv.onError(this.kzl, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cRJ().KD(this.kzG);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(Kx));
            if (this.kzq != null && x(Uri.parse(Kx)) != null) {
                this.kzq.cyy();
            }
            this.kzG = str;
            int lastIndexOf = this.kzG.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.kzG.length() > 4) {
                this.kzH = this.kzG.substring(0, lastIndexOf + 4);
            } else {
                this.kzH = this.kzG;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQV() {
        if (com.baidu.tbadk.coreExtra.model.f.baQ()) {
            if (this.kzu != null && (this.kzu.cQK() || this.kzu.cQL())) {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAb);
                com.baidu.adp.lib.f.e.ld().postDelayed(this.kAb, com.baidu.tbadk.coreExtra.model.f.baP());
            }
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAc);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kAc, com.baidu.tbadk.coreExtra.model.f.baO());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (x(uri) != null) {
            this.kzq.Ix(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aJz();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.kAd = false;
        if (this.kzA != null) {
            cQV();
            if (this.kzl != null) {
                if (!this.kzw) {
                    this.kzw = true;
                    this.kzl.a(this.mContext, this.mUri, this.mHeaders, this.kzA, this.mUri.getHost());
                } else if (!isPlaying() && this.kAe != null) {
                    this.kAd = true;
                    this.kAe.onPrepared(this.kzl);
                }
            }
        } else if (this.kzj != null && this.kzj.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.kzB) {
                addView(this.kzj, layoutParams);
            } else {
                addView(this.kzj, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aJz() {
        this.kzw = false;
        this.kzt = false;
        if (this.kzl != null) {
            if (this.kzl.isPlaying() && cRc()) {
                x.cRE().bw(this.kzH, this.kzl.getCurrentPosition());
            }
            this.kzl.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAh);
    }

    private void Ky(String str) {
        this.kzV = 0;
        this.kzW = 0;
        this.kzX = 0;
        this.kzY = 0;
        this.kzZ = 0;
        this.dsA = 0;
        if (this.kzu.cQL()) {
            this.kzU = kzP;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.kzW = (int) t.KA(QuickVideoView.this.kzF);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.kzF != null && this.kzF.equals(str)) {
            this.kzU = kzO;
        } else {
            this.kzU = kzQ;
        }
        this.kzT = kzR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQW() {
        this.kzT = kzR;
        if (this.kzl != null) {
            this.kzV = this.kzl.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(boolean z) {
        if (this.kzT == kzR && this.kzl != null) {
            this.kzT = kzS;
            this.kzY = this.kzl.getDuration();
            if (z) {
                this.kzZ = 0;
                this.kzX = this.kzY;
            } else {
                this.kzX = this.kzl.getCurrentPosition();
                this.kzZ = this.kzl.getCachedSize();
            }
            if (this.kzX > 0) {
                if (this.kzU == kzO) {
                    this.kzW = (int) t.KA(this.kzF);
                    if (this.kzV > 0) {
                        long j = (this.kzV * (this.kzX / 1000)) / 8;
                        if (this.kzZ < 0) {
                            this.kzZ = 0;
                        }
                        long j2 = this.kzZ + j;
                        if (this.kzW > 0) {
                            j2 += this.kzW;
                        }
                        setFlowCount(j2, this.kzX, this.kzY, this.dsA);
                    } else if (this.kzV == -1) {
                        this.kzV = 603327;
                        setFlowCount((this.kzV * (this.kzX / 1000)) / 8, this.kzX, this.kzY, this.dsA);
                    }
                } else if (this.kzU == kzP) {
                    if (this.kzV > 0) {
                        long j3 = (this.kzV * (this.kzX / 1000)) / 8;
                        if (this.kzZ < 0) {
                            this.kzZ = 0;
                        }
                        long j4 = this.kzZ + j3;
                        if (this.kzW > 0) {
                            j4 -= this.kzW;
                        }
                        setFlowCount(j4, this.kzX, this.kzY, this.dsA);
                    } else if (this.kzV == -1) {
                        this.kzV = 603327;
                        setFlowCount((this.kzV * (this.kzX / 1000)) / 8, this.kzX, this.kzY, this.dsA);
                    }
                } else {
                    setFlowCount(0L, this.kzX, this.kzY, this.dsA);
                }
            }
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAh);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kzL) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        cQX();
        tw(false);
        if (this.kzC != null) {
            this.kzC.clear();
        }
        this.kzk = null;
        this.kzt = false;
        if (this.kzl != null) {
            if (this.kzl.isPlaying() && cRc()) {
                x.cRE().bw(this.kzH, this.kzl.getCurrentPosition());
            }
            this.kzl.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAh);
        this.drn = false;
        if (this.kzu != null) {
            this.kzu.cQJ();
        }
        com.baidu.adp.lib.network.http.a.b.kN().a((b.InterfaceC0022b) null);
        if (this.kzq != null && this.kzq.IA(getLocateSource())) {
            this.kzq = null;
        }
        if (this.kzv != null) {
            this.kzv.cyO();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAh);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        cQX();
        tw(false);
        if (this.kzC != null) {
            this.kzC.clear();
        }
        this.kzk = null;
        aJz();
        TbVideoViewSet.cRJ().KD(this.kzG);
        this.drn = false;
        if (this.kzu != null) {
            this.kzu.Kw(this.kzG);
        }
        com.baidu.adp.lib.network.http.a.b.kN().a((b.InterfaceC0022b) null);
        if (this.kzq != null && this.kzq.IA(getLocateSource())) {
            this.kzq = null;
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAh);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.kAa = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQX() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAb);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAc);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.eKx = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.eKw = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.eBv = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0705g interfaceC0705g) {
        this.eKA = interfaceC0705g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQY() {
        cQX();
        if (this.kzD != null) {
            this.kzD.onPrepared();
        }
        if (x(this.mUri) != null && this.kzl != null) {
            this.kzq.Ix(this.mUri.getPath());
            this.kzq.zB(this.kzl.getPlayerType());
        }
        this.kzv.cyP();
        this.kzv.cyQ();
        if (this.kzu != null) {
            long j = 0;
            if (this.kzl != null) {
                j = this.kzl.getDuration();
            }
            this.kzu.fj(j);
            cQW();
            if (getPlayerType() == -200) {
                this.kzu.cQP();
                cRb();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQZ() {
        if (x(this.mUri) != null && this.kzl != null) {
            this.kzq.Ix(this.mUri.getPath());
            this.kzq.cyy();
            this.kzq.zA(this.kzl.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String au(String str, String str2, String str3) {
        if (this.kzE == null) {
            return "";
        }
        String cSi = this.kzE.cSi();
        this.kzE.av(str, str2, str3);
        return cSi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.kzu != null && !StringUtils.isNull(this.kzu.cQI())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.KE(uri);
                }
            }
            this.mUri = Uri.parse(this.kzu.cQI());
        }
        boolean z = false;
        if (this.kzC != null) {
            z = this.kzC.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.kzq != null) {
            this.kzs = this.kzq.a(i, i2, i3, getLocateSource(), z, this.kzI, au(this.kzq.cyE(), i3 + "", this.kzq.cyF()));
            this.kzq = null;
        }
        this.kzI = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.kzl != null) {
            try {
                if (this.kzl.isPlaying() && cRc()) {
                    x.cRE().bw(this.kzH, this.kzl.getCurrentPosition());
                }
                this.kzl.release();
                this.kzk = str;
                URI uri = new URI(this.mUri.toString());
                this.kzl.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.kzA, this.mUri.getHost());
                if (x(this.mUri) != null) {
                    this.kzq.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kzl != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.kzl.isPlaying() && cRc()) {
                x.cRE().bw(this.kzH, this.kzl.getCurrentPosition());
            }
            this.kzl.release();
            this.kzl.a(this.mContext, this.mUri, this.mHeaders, this.kzA, this.mUri.getHost());
            if (x(this.mUri) != null) {
                this.kzq.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kzl != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.kzl.forceUseSystemMediaPlayer(true);
            }
            if (this.kzl.isPlaying() && cRc()) {
                x.cRE().bw(this.kzH, this.kzl.getCurrentPosition());
            }
            this.kzl.release();
            this.kzl.a(this.mContext, this.mUri, this.mHeaders, this.kzA, this.mUri.getHost());
            if (x(this.mUri) != null) {
                this.kzq.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.kzt = true;
        if (this.kzl != null) {
            if (this.kzA != null && this.kzz && !this.kzl.isExistInRemote()) {
                this.kzl.a(this.mContext, this.mUri, this.mHeaders, this.kzA, this.kzy);
                if (this.kyP != null) {
                    this.kyP.cQF();
                }
                if (x(this.mUri) != null) {
                    this.kzq.cyA();
                }
                cQV();
                return;
            }
            if (!this.kzl.ble()) {
                ag.a(this.aio, true);
                this.kzl.setVolume(1.0f, 1.0f);
            }
            this.kzv.cyR();
            this.kzl.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.kzu != null) {
            this.kzu.onStart();
        }
        if (this.kzn != null) {
            this.kzn.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (x(this.mUri) != null && this.kzl != null) {
            this.kzq.zC(this.kzl.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kzt) {
            b(aVar);
            return;
        }
        this.kzt = true;
        if (aVar != null) {
            this.kzL = true;
            if (!cRf()) {
                aVar.cRK();
            }
        } else {
            this.kzL = false;
        }
        setVideoPath(this.kzG, this.ais);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cQX();
        ag.a(this.aio, false);
        if (this.kzl != null) {
            if (this.kzl.isPlaying() && cRc()) {
                x.cRE().bw(this.kzH, this.kzl.getCurrentPosition());
            }
            this.kzl.pause();
        }
        if (this.kzu != null) {
            this.kzu.onPause();
        }
        this.kzt = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kzq != null) {
            this.kzq.cyD();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.kzl != null) {
            return this.kzl.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.kzl != null) {
            return this.kzl.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.dsA = i;
        BM(i);
    }

    public void BM(int i) {
        if (this.kzD != null) {
            this.kzD.cRp();
        }
        if (this.kzl != null) {
            this.kzl.seekTo(i);
        }
        if (this.kzu != null) {
            this.kzu.BJ(0);
            cRb();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.kzl != null) {
            return this.kzl.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.kzl != null) {
            this.kzl.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.kzy = i;
    }

    public int getRecoveryState() {
        return this.kzy;
    }

    public void setNeedRecovery(boolean z) {
        this.kzz = z;
    }

    public void setLooping(boolean z) {
        this.drn = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cRa() {
        return this.kzt;
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
        this.eBz = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kzu = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eKK);
    }

    public void setMute(boolean z) {
        if (z) {
            this.kzl.setVolume(0.0f, 0.0f);
            ag.a(this.aio, false);
            return;
        }
        ag.a(this.aio, true);
        this.kzl.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.drn = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kzl != null) {
            this.kzl.blf();
        }
        if (this.kzD != null) {
            this.kzD.Qq();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAh);
        MessageManager.getInstance().unRegisterListener(this.eKK);
        if (this.kzC != null) {
            this.kzC.clear();
        }
        if (this.kzr != null) {
            this.kzr.a(null);
            this.kzr.cys();
        }
    }

    public g getPlayer() {
        return this.kzl;
    }

    public int getPlayerType() {
        if (this.kzl == null) {
            return -300;
        }
        return this.kzl.getPlayerType();
    }

    public void cRb() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAh);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kAh, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.kyP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.kzu instanceof n) || ((n) this.kzu).cRo() == null) {
            return "";
        }
        return ((n) this.kzu).kAt ? "v_mid_page" : ((n) this.kzu).cRo().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i x(Uri uri) {
        String uri2;
        if (this.kzq != null) {
            return this.kzq;
        }
        if (!StringUtils.isNull(this.kzF)) {
            uri2 = this.kzF;
        } else if (kzp != null && this.kzu != null && !StringUtils.isNull(this.kzu.cQI())) {
            uri2 = this.kzu.cQI();
        } else {
            uri2 = (kzp == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && kzp != null) {
            this.kzq = kzp.at(this.ais, uri2, this.kzs);
        }
        this.kzs = null;
        this.kzI = 0L;
        return this.kzq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRc() {
        return this.kzl != null && this.kzl.getDuration() >= this.kzl.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.kzq, j, j2, j3, j4);
    }

    public static boolean xw(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cRd() {
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
            this.kzL = true;
            if (!cRf()) {
                aVar.cRK();
            }
            if (!cRe()) {
                aVar.cRL();
                this.kzt = true;
                setVideoPath(this.kzG, this.ais);
                return;
            }
        } else {
            this.kzL = false;
        }
        start();
        if (this.kzl != null && this.kzL) {
            this.kzv.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRe() {
        return this == TbVideoViewSet.cRJ().KC(this.kzG);
    }

    private boolean cRf() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.eKw = null;
        this.eBv = null;
        this.eKz = null;
        this.kAe = null;
        this.kAg = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kzL = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kzm = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.kzl != null) {
            return this.kzl.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.kzl != null ? this.kzl.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kzq != null) {
            this.kzq.e(j, j2, j3);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public int getPcdnState() {
        return 0;
    }

    public void setVideoStatusListener(c cVar) {
        this.kzn = cVar;
    }
}
