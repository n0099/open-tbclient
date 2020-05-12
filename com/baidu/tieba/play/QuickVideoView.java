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
    private static h eFx;
    private static com.baidu.tieba.k.l eFy;
    private static int kgQ = 0;
    private static int kgR = 1;
    private static int kgS = 2;
    private static int kgT = 1;
    private static int kgU = 0;
    private WeakReference<Context> ahK;
    private String ahO;
    private TextureView.SurfaceTextureListener bwI;
    private int eAv;
    private g.a eFA;
    private g.InterfaceC0651g eFD;
    private boolean eFp;
    private g.f eFz;
    private g.b emF;
    private b emJ;
    private g.a evJ;
    private g.f evK;
    private g.c evL;
    private g.e evM;
    private g.InterfaceC0651g evN;
    private g.i evO;
    private g.d evP;
    private g.h evQ;
    private final CustomMessageListener evX;
    private a kfT;
    private int kgA;
    private boolean kgB;
    private SurfaceTexture kgC;
    private boolean kgD;
    private com.baidu.tieba.play.b.a kgE;
    private q kgF;
    private com.baidu.tieba.play.b.f kgG;
    private String kgH;
    private String kgI;
    private String kgJ;
    private long kgK;
    private boolean kgL;
    private boolean kgM;
    private boolean kgN;
    private long kgO;
    private long kgP;
    private int kgV;
    private int kgW;
    private int kgX;
    private int kgY;
    private int kgZ;
    private RenderView kgn;
    private String kgo;
    private g kgp;
    private g.e kgq;
    private c kgr;
    private com.baidu.tieba.k.i kgs;
    private com.baidu.tieba.k.e kgt;
    private String kgu;
    private boolean kgv;
    private d kgw;
    private com.baidu.tieba.k.k kgx;
    private boolean kgy;
    private int kgz;
    private int kha;
    private int khb;
    private boolean khc;
    private Runnable khd;
    private Runnable khe;
    public boolean khf;
    private Runnable khg;
    private Context mContext;
    private Map<String, String> mHeaders;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cJq();
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
            eFx = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            eFy = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.kgD = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.kgv = false;
        this.kgy = false;
        this.kgz = 0;
        this.eFp = false;
        this.kgA = -1;
        this.kgB = false;
        this.kgC = null;
        this.kgD = true;
        this.kgN = false;
        this.kgO = 0L;
        this.kgP = 0L;
        this.kgV = kgU;
        this.kgW = 0;
        this.kgX = 0;
        this.kgY = -1;
        this.kgZ = 0;
        this.kha = 0;
        this.khb = 0;
        this.eAv = 0;
        this.khc = false;
        this.ahK = null;
        this.khd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgp != null && QuickVideoView.this.kgv) {
                    QuickVideoView.this.b(QuickVideoView.this.kgp, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.khe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.qb(false);
                }
            }
        };
        this.khf = false;
        this.bwI = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.khc) {
                    QuickVideoView.this.khc = false;
                    if (QuickVideoView.this.kgp != null) {
                        QuickVideoView.this.kgp.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kgy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kgp != null) {
                        if (QuickVideoView.this.cJP()) {
                            QuickVideoView.this.kgp.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.kgB) {
                            QuickVideoView.this.kgp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kgA);
                            if (QuickVideoView.this.kfT != null) {
                                QuickVideoView.this.kfT.cJq();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kgs.crG();
                            }
                        }
                    }
                } else if (cJS()) {
                    if (QuickVideoView.this.kgp != null) {
                        QuickVideoView.this.cJG();
                        QuickVideoView.this.kgy = true;
                        QuickVideoView.this.kgp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kgs.crF();
                    }
                }
                QuickVideoView.this.kgC = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.khc) {
                    QuickVideoView.this.cJI();
                    QuickVideoView.this.sY(false);
                    if (QuickVideoView.this.kgp != null) {
                        if (QuickVideoView.this.kgp.isPlaying() && QuickVideoView.this.cJN()) {
                            x.cKp().bv(QuickVideoView.this.kgJ, QuickVideoView.this.kgp.getCurrentPosition());
                            if (QuickVideoView.this.kgN) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kgN) {
                            QuickVideoView.this.kgp.release();
                        }
                    }
                    if (QuickVideoView.this.kgy) {
                        if (QuickVideoView.this.kgw != null && !QuickVideoView.this.kgN) {
                            QuickVideoView.this.kgw.IJ(QuickVideoView.this.kgI);
                        }
                        if (QuickVideoView.this.emJ != null) {
                            QuickVideoView.this.emJ.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kgC = null;
                    if (QuickVideoView.this.kgs != null && QuickVideoView.this.kgs.GQ(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kgs = null;
                    }
                    if (!QuickVideoView.this.kgN) {
                        QuickVideoView.this.kgy = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cJS() {
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
        this.eFz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int IO;
                QuickVideoView.this.cJI();
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.onPrepared();
                }
                if (QuickVideoView.this.kgs != null && QuickVideoView.this.kgp != null) {
                    QuickVideoView.this.kgs.yQ(QuickVideoView.this.kgp.getPlayerType());
                }
                if (QuickVideoView.this.kgN) {
                    TbVideoViewSet.cKu().a(QuickVideoView.this, QuickVideoView.this.kgI);
                }
                if (QuickVideoView.this.evK != null) {
                    QuickVideoView.this.kgx.crW();
                    QuickVideoView.this.evK.onPrepared(gVar);
                }
                if (QuickVideoView.this.kgw != null) {
                    long j = 0;
                    if (QuickVideoView.this.kgp != null) {
                        j = QuickVideoView.this.kgp.getDuration();
                    }
                    QuickVideoView.this.kgw.fj(j);
                    QuickVideoView.this.cJH();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kgw.cJA();
                        QuickVideoView.this.cJM();
                    }
                }
                if (QuickVideoView.this.kgM && (IO = x.cKp().IO(QuickVideoView.this.kgJ)) > 0 && QuickVideoView.this.kgp != null && QuickVideoView.this.kgp.getCurrentPosition() == 0) {
                    QuickVideoView.this.Ba(IO);
                }
                if (QuickVideoView.this.kgv) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kgn != null && gVar != null) {
                    QuickVideoView.this.kgn.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kgo) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kgo);
                }
                if (QuickVideoView.this.kgE != null && QuickVideoView.this.kgE.cKQ()) {
                    com.baidu.tieba.play.b.e.Bg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eFA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.sY(true);
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.GP(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kgs = null;
                }
                if (!QuickVideoView.this.eFp || QuickVideoView.this.kgw == null) {
                    if (QuickVideoView.this.kgw != null) {
                        QuickVideoView.this.kgw.onCompletion();
                    }
                    QuickVideoView.this.kgv = false;
                    x.cKp().remove(QuickVideoView.this.kgJ);
                    if (QuickVideoView.this.evJ != null) {
                        QuickVideoView.this.evJ.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kgu = null;
                QuickVideoView.this.kgK = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kgw.cJt());
                QuickVideoView.this.start();
            }
        };
        this.evL = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cJI();
                if (QuickVideoView.this.kgw != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cJN()) {
                    QuickVideoView.this.kgL = true;
                    x.cKp().bv(QuickVideoView.this.kgJ, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKu().IQ(QuickVideoView.this.kgI);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgu = QuickVideoView.this.kgs.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kgK, QuickVideoView.this.aq(QuickVideoView.this.kgs.crK(), i3 + "", QuickVideoView.this.kgs.crL()));
                        QuickVideoView.this.kgs = null;
                    }
                    QuickVideoView.this.kgK = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Be(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Bf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.emF == null || QuickVideoView.this.emF.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eFD = new g.InterfaceC0651g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                if (QuickVideoView.this.kgL) {
                    QuickVideoView.this.kgL = false;
                    return;
                }
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.cKb();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kgw != null && z) {
                    QuickVideoView.this.kgw.onSeekComplete();
                }
                if (QuickVideoView.this.evN != null) {
                    QuickVideoView.this.evN.b(gVar);
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kgq != null) {
                    QuickVideoView.this.kgq.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kgz = i2;
                    if (QuickVideoView.this.kgn != null && gVar != null) {
                        QuickVideoView.this.kgn.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgz);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kgx.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.a(i, i2, QuickVideoView.this.kgs);
                    return true;
                }
                return true;
            }
        };
        this.evO = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.m(i, i2, str);
                }
            }
        };
        this.evP = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.GR(str);
                }
            }
        };
        this.evQ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kgK = j;
                }
            }
        };
        this.khg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kgw != null && QuickVideoView.this.kgw.cJw() && QuickVideoView.this.kgw.cJx() && QuickVideoView.this.kgw.cJy() && QuickVideoView.this.kgp != null) {
                    int beP = QuickVideoView.this.kgp.beP();
                    int currentPosition = QuickVideoView.this.kgp.getCurrentPosition();
                    int duration = QuickVideoView.this.kgp.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kgO;
                    boolean z = currentPosition + beP < duration;
                    if (beP < QuickVideoView.this.kgw.cJz() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kgO = currentTimeMillis;
                        QuickVideoView.this.kgw.AX(0);
                    }
                    if (QuickVideoView.this.cJL() && currentPosition == QuickVideoView.this.kgP && j > 500) {
                        QuickVideoView.this.kgO = currentTimeMillis;
                        QuickVideoView.this.kgw.AX(0);
                    }
                    QuickVideoView.this.kgP = currentPosition;
                    if (QuickVideoView.this.kgV == QuickVideoView.kgT) {
                        QuickVideoView.this.cJM();
                    }
                }
            }
        };
        this.evX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kgw != null) {
                        QuickVideoView.this.kgw.ya(QuickVideoView.this.kgI);
                    }
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.GO(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kgs = null;
                    }
                    QuickVideoView.this.cJI();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgv = false;
        this.kgy = false;
        this.kgz = 0;
        this.eFp = false;
        this.kgA = -1;
        this.kgB = false;
        this.kgC = null;
        this.kgD = true;
        this.kgN = false;
        this.kgO = 0L;
        this.kgP = 0L;
        this.kgV = kgU;
        this.kgW = 0;
        this.kgX = 0;
        this.kgY = -1;
        this.kgZ = 0;
        this.kha = 0;
        this.khb = 0;
        this.eAv = 0;
        this.khc = false;
        this.ahK = null;
        this.khd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgp != null && QuickVideoView.this.kgv) {
                    QuickVideoView.this.b(QuickVideoView.this.kgp, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.khe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.qb(false);
                }
            }
        };
        this.khf = false;
        this.bwI = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.khc) {
                    QuickVideoView.this.khc = false;
                    if (QuickVideoView.this.kgp != null) {
                        QuickVideoView.this.kgp.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kgy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kgp != null) {
                        if (QuickVideoView.this.cJP()) {
                            QuickVideoView.this.kgp.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.kgB) {
                            QuickVideoView.this.kgp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kgA);
                            if (QuickVideoView.this.kfT != null) {
                                QuickVideoView.this.kfT.cJq();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kgs.crG();
                            }
                        }
                    }
                } else if (cJS()) {
                    if (QuickVideoView.this.kgp != null) {
                        QuickVideoView.this.cJG();
                        QuickVideoView.this.kgy = true;
                        QuickVideoView.this.kgp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kgs.crF();
                    }
                }
                QuickVideoView.this.kgC = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.khc) {
                    QuickVideoView.this.cJI();
                    QuickVideoView.this.sY(false);
                    if (QuickVideoView.this.kgp != null) {
                        if (QuickVideoView.this.kgp.isPlaying() && QuickVideoView.this.cJN()) {
                            x.cKp().bv(QuickVideoView.this.kgJ, QuickVideoView.this.kgp.getCurrentPosition());
                            if (QuickVideoView.this.kgN) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kgN) {
                            QuickVideoView.this.kgp.release();
                        }
                    }
                    if (QuickVideoView.this.kgy) {
                        if (QuickVideoView.this.kgw != null && !QuickVideoView.this.kgN) {
                            QuickVideoView.this.kgw.IJ(QuickVideoView.this.kgI);
                        }
                        if (QuickVideoView.this.emJ != null) {
                            QuickVideoView.this.emJ.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kgC = null;
                    if (QuickVideoView.this.kgs != null && QuickVideoView.this.kgs.GQ(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kgs = null;
                    }
                    if (!QuickVideoView.this.kgN) {
                        QuickVideoView.this.kgy = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cJS() {
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
        this.eFz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int IO;
                QuickVideoView.this.cJI();
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.onPrepared();
                }
                if (QuickVideoView.this.kgs != null && QuickVideoView.this.kgp != null) {
                    QuickVideoView.this.kgs.yQ(QuickVideoView.this.kgp.getPlayerType());
                }
                if (QuickVideoView.this.kgN) {
                    TbVideoViewSet.cKu().a(QuickVideoView.this, QuickVideoView.this.kgI);
                }
                if (QuickVideoView.this.evK != null) {
                    QuickVideoView.this.kgx.crW();
                    QuickVideoView.this.evK.onPrepared(gVar);
                }
                if (QuickVideoView.this.kgw != null) {
                    long j = 0;
                    if (QuickVideoView.this.kgp != null) {
                        j = QuickVideoView.this.kgp.getDuration();
                    }
                    QuickVideoView.this.kgw.fj(j);
                    QuickVideoView.this.cJH();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kgw.cJA();
                        QuickVideoView.this.cJM();
                    }
                }
                if (QuickVideoView.this.kgM && (IO = x.cKp().IO(QuickVideoView.this.kgJ)) > 0 && QuickVideoView.this.kgp != null && QuickVideoView.this.kgp.getCurrentPosition() == 0) {
                    QuickVideoView.this.Ba(IO);
                }
                if (QuickVideoView.this.kgv) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kgn != null && gVar != null) {
                    QuickVideoView.this.kgn.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kgo) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kgo);
                }
                if (QuickVideoView.this.kgE != null && QuickVideoView.this.kgE.cKQ()) {
                    com.baidu.tieba.play.b.e.Bg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eFA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.sY(true);
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.GP(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kgs = null;
                }
                if (!QuickVideoView.this.eFp || QuickVideoView.this.kgw == null) {
                    if (QuickVideoView.this.kgw != null) {
                        QuickVideoView.this.kgw.onCompletion();
                    }
                    QuickVideoView.this.kgv = false;
                    x.cKp().remove(QuickVideoView.this.kgJ);
                    if (QuickVideoView.this.evJ != null) {
                        QuickVideoView.this.evJ.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kgu = null;
                QuickVideoView.this.kgK = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kgw.cJt());
                QuickVideoView.this.start();
            }
        };
        this.evL = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cJI();
                if (QuickVideoView.this.kgw != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cJN()) {
                    QuickVideoView.this.kgL = true;
                    x.cKp().bv(QuickVideoView.this.kgJ, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKu().IQ(QuickVideoView.this.kgI);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgu = QuickVideoView.this.kgs.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kgK, QuickVideoView.this.aq(QuickVideoView.this.kgs.crK(), i3 + "", QuickVideoView.this.kgs.crL()));
                        QuickVideoView.this.kgs = null;
                    }
                    QuickVideoView.this.kgK = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Be(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Bf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.emF == null || QuickVideoView.this.emF.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eFD = new g.InterfaceC0651g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                if (QuickVideoView.this.kgL) {
                    QuickVideoView.this.kgL = false;
                    return;
                }
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.cKb();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kgw != null && z) {
                    QuickVideoView.this.kgw.onSeekComplete();
                }
                if (QuickVideoView.this.evN != null) {
                    QuickVideoView.this.evN.b(gVar);
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kgq != null) {
                    QuickVideoView.this.kgq.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kgz = i2;
                    if (QuickVideoView.this.kgn != null && gVar != null) {
                        QuickVideoView.this.kgn.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgz);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kgx.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.a(i, i2, QuickVideoView.this.kgs);
                    return true;
                }
                return true;
            }
        };
        this.evO = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.m(i, i2, str);
                }
            }
        };
        this.evP = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.GR(str);
                }
            }
        };
        this.evQ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kgK = j;
                }
            }
        };
        this.khg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kgw != null && QuickVideoView.this.kgw.cJw() && QuickVideoView.this.kgw.cJx() && QuickVideoView.this.kgw.cJy() && QuickVideoView.this.kgp != null) {
                    int beP = QuickVideoView.this.kgp.beP();
                    int currentPosition = QuickVideoView.this.kgp.getCurrentPosition();
                    int duration = QuickVideoView.this.kgp.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kgO;
                    boolean z = currentPosition + beP < duration;
                    if (beP < QuickVideoView.this.kgw.cJz() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kgO = currentTimeMillis;
                        QuickVideoView.this.kgw.AX(0);
                    }
                    if (QuickVideoView.this.cJL() && currentPosition == QuickVideoView.this.kgP && j > 500) {
                        QuickVideoView.this.kgO = currentTimeMillis;
                        QuickVideoView.this.kgw.AX(0);
                    }
                    QuickVideoView.this.kgP = currentPosition;
                    if (QuickVideoView.this.kgV == QuickVideoView.kgT) {
                        QuickVideoView.this.cJM();
                    }
                }
            }
        };
        this.evX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kgw != null) {
                        QuickVideoView.this.kgw.ya(QuickVideoView.this.kgI);
                    }
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.GO(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kgs = null;
                    }
                    QuickVideoView.this.cJI();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgv = false;
        this.kgy = false;
        this.kgz = 0;
        this.eFp = false;
        this.kgA = -1;
        this.kgB = false;
        this.kgC = null;
        this.kgD = true;
        this.kgN = false;
        this.kgO = 0L;
        this.kgP = 0L;
        this.kgV = kgU;
        this.kgW = 0;
        this.kgX = 0;
        this.kgY = -1;
        this.kgZ = 0;
        this.kha = 0;
        this.khb = 0;
        this.eAv = 0;
        this.khc = false;
        this.ahK = null;
        this.khd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgp != null && QuickVideoView.this.kgv) {
                    QuickVideoView.this.b(QuickVideoView.this.kgp, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.khe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.qb(false);
                }
            }
        };
        this.khf = false;
        this.bwI = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.khc) {
                    QuickVideoView.this.khc = false;
                    if (QuickVideoView.this.kgp != null) {
                        QuickVideoView.this.kgp.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kgy || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kgp != null) {
                        if (QuickVideoView.this.cJP()) {
                            QuickVideoView.this.kgp.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.kgB) {
                            QuickVideoView.this.kgp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kgA);
                            if (QuickVideoView.this.kfT != null) {
                                QuickVideoView.this.kfT.cJq();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kgs.crG();
                            }
                        }
                    }
                } else if (cJS()) {
                    if (QuickVideoView.this.kgp != null) {
                        QuickVideoView.this.cJG();
                        QuickVideoView.this.kgy = true;
                        QuickVideoView.this.kgp.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kgs.crF();
                    }
                }
                QuickVideoView.this.kgC = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.khc) {
                    QuickVideoView.this.cJI();
                    QuickVideoView.this.sY(false);
                    if (QuickVideoView.this.kgp != null) {
                        if (QuickVideoView.this.kgp.isPlaying() && QuickVideoView.this.cJN()) {
                            x.cKp().bv(QuickVideoView.this.kgJ, QuickVideoView.this.kgp.getCurrentPosition());
                            if (QuickVideoView.this.kgN) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kgN) {
                            QuickVideoView.this.kgp.release();
                        }
                    }
                    if (QuickVideoView.this.kgy) {
                        if (QuickVideoView.this.kgw != null && !QuickVideoView.this.kgN) {
                            QuickVideoView.this.kgw.IJ(QuickVideoView.this.kgI);
                        }
                        if (QuickVideoView.this.emJ != null) {
                            QuickVideoView.this.emJ.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kgC = null;
                    if (QuickVideoView.this.kgs != null && QuickVideoView.this.kgs.GQ(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kgs = null;
                    }
                    if (!QuickVideoView.this.kgN) {
                        QuickVideoView.this.kgy = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cJS() {
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
        this.eFz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int IO;
                QuickVideoView.this.cJI();
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.onPrepared();
                }
                if (QuickVideoView.this.kgs != null && QuickVideoView.this.kgp != null) {
                    QuickVideoView.this.kgs.yQ(QuickVideoView.this.kgp.getPlayerType());
                }
                if (QuickVideoView.this.kgN) {
                    TbVideoViewSet.cKu().a(QuickVideoView.this, QuickVideoView.this.kgI);
                }
                if (QuickVideoView.this.evK != null) {
                    QuickVideoView.this.kgx.crW();
                    QuickVideoView.this.evK.onPrepared(gVar);
                }
                if (QuickVideoView.this.kgw != null) {
                    long j = 0;
                    if (QuickVideoView.this.kgp != null) {
                        j = QuickVideoView.this.kgp.getDuration();
                    }
                    QuickVideoView.this.kgw.fj(j);
                    QuickVideoView.this.cJH();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kgw.cJA();
                        QuickVideoView.this.cJM();
                    }
                }
                if (QuickVideoView.this.kgM && (IO = x.cKp().IO(QuickVideoView.this.kgJ)) > 0 && QuickVideoView.this.kgp != null && QuickVideoView.this.kgp.getCurrentPosition() == 0) {
                    QuickVideoView.this.Ba(IO);
                }
                if (QuickVideoView.this.kgv) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kgn != null && gVar != null) {
                    QuickVideoView.this.kgn.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kgo) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kgo);
                }
                if (QuickVideoView.this.kgE != null && QuickVideoView.this.kgE.cKQ()) {
                    com.baidu.tieba.play.b.e.Bg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eFA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.sY(true);
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.GP(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kgs = null;
                }
                if (!QuickVideoView.this.eFp || QuickVideoView.this.kgw == null) {
                    if (QuickVideoView.this.kgw != null) {
                        QuickVideoView.this.kgw.onCompletion();
                    }
                    QuickVideoView.this.kgv = false;
                    x.cKp().remove(QuickVideoView.this.kgJ);
                    if (QuickVideoView.this.evJ != null) {
                        QuickVideoView.this.evJ.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kgu = null;
                QuickVideoView.this.kgK = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kgw.cJt());
                QuickVideoView.this.start();
            }
        };
        this.evL = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.aa(i2, i22, i3);
                QuickVideoView.this.cJI();
                if (QuickVideoView.this.kgw != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cJN()) {
                    QuickVideoView.this.kgL = true;
                    x.cKp().bv(QuickVideoView.this.kgJ, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKu().IQ(QuickVideoView.this.kgI);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgu = QuickVideoView.this.kgs.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kgK, QuickVideoView.this.aq(QuickVideoView.this.kgs.crK(), i3 + "", QuickVideoView.this.kgs.crL()));
                        QuickVideoView.this.kgs = null;
                    }
                    QuickVideoView.this.kgK = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.Be(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Bf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.emF == null || QuickVideoView.this.emF.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.eFD = new g.InterfaceC0651g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(g gVar) {
                if (QuickVideoView.this.kgL) {
                    QuickVideoView.this.kgL = false;
                    return;
                }
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.cKb();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kgw != null && z) {
                    QuickVideoView.this.kgw.onSeekComplete();
                }
                if (QuickVideoView.this.evN != null) {
                    QuickVideoView.this.evN.b(gVar);
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.kgq != null) {
                    QuickVideoView.this.kgq.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.kgz = i22;
                    if (QuickVideoView.this.kgn != null && gVar != null) {
                        QuickVideoView.this.kgn.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgz);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.kgx.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kgF != null) {
                    QuickVideoView.this.kgF.a(i2, i22, QuickVideoView.this.kgs);
                    return true;
                }
                return true;
            }
        };
        this.evO = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.m(i2, i22, str);
                }
            }
        };
        this.evP = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kgs != null) {
                    QuickVideoView.this.kgs.GR(str);
                }
            }
        };
        this.evQ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kgK = j;
                }
            }
        };
        this.khg = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kgw != null && QuickVideoView.this.kgw.cJw() && QuickVideoView.this.kgw.cJx() && QuickVideoView.this.kgw.cJy() && QuickVideoView.this.kgp != null) {
                    int beP = QuickVideoView.this.kgp.beP();
                    int currentPosition = QuickVideoView.this.kgp.getCurrentPosition();
                    int duration = QuickVideoView.this.kgp.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kgO;
                    boolean z = currentPosition + beP < duration;
                    if (beP < QuickVideoView.this.kgw.cJz() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kgO = currentTimeMillis;
                        QuickVideoView.this.kgw.AX(0);
                    }
                    if (QuickVideoView.this.cJL() && currentPosition == QuickVideoView.this.kgP && j > 500) {
                        QuickVideoView.this.kgO = currentTimeMillis;
                        QuickVideoView.this.kgw.AX(0);
                    }
                    QuickVideoView.this.kgP = currentPosition;
                    if (QuickVideoView.this.kgV == QuickVideoView.kgT) {
                        QuickVideoView.this.cJM();
                    }
                }
            }
        };
        this.evX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kgw != null) {
                        QuickVideoView.this.kgw.ya(QuickVideoView.this.kgI);
                    }
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.GO(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kgs = null;
                    }
                    QuickVideoView.this.cJI();
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
        this.kgn = new RenderView(context);
        this.ahK = new WeakReference<>(TbadkCoreApplication.getInst());
        this.kgn.setSurfaceTextureListener(this.bwI);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.kgD) {
            addView(this.kgn, layoutParams);
        } else {
            addView(this.kgn, 0, layoutParams);
        }
        if (eFx != null) {
            this.kgp = eFx.beS();
        }
        if (this.kgp != null) {
            this.kgp.setOnPreparedListener(this.eFz);
            this.kgp.setOnCompletionListener(this.eFA);
            this.kgp.a(this.evL);
            this.kgp.setOnSeekCompleteListener(this.eFD);
            this.kgp.a(this.evM);
            this.kgp.a(this.evO);
            this.kgp.a(this.evP);
            this.kgp.a(this.evQ);
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
        this.kgE = new com.baidu.tieba.play.b.a(this);
        this.kgF = new q();
        this.kgG = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.kgx = new com.baidu.tieba.k.k();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kgM = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kgI;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.kgx.crV();
        this.ahO = str2;
        if (this.kgE != null) {
            this.kgE.clear();
            this.kgE.cKQ();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.IS(str2);
            if (eFy != null) {
                this.kgs = eFy.ap(this.ahO, str, "");
                if (this.kgs != null) {
                    this.kgs.a(-300, -44399, -44399, getLocateSource(), false, this.kgK, "");
                    this.kgs = null;
                }
            }
        }
        if (this.kgt != null) {
            this.kgt.a(null);
            this.kgt.cry();
            this.kgt = null;
        }
        this.kgu = null;
        this.kgK = 0L;
        setVideoPath(str);
    }

    private String IK(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.daw().dax()) {
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
            String IK = IK(str);
            this.kgH = IK;
            if (this.kgw != null) {
                IK = this.kgw.xV(IK);
                if (this.kgw.cJB() != null) {
                    this.kgw.cJB().setPlayer(this);
                }
                if (eFy != null && vQ(IK)) {
                    this.kgt = eFy.GT(IK);
                }
                if (this.kgt != null) {
                    this.kgt.a(new com.baidu.tieba.play.monitor.a(this.ahO, this.kgH, this.kgs));
                    this.kgt.crx();
                }
                IL(IK);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !vQ(IK)) {
                if (this.emF != null) {
                    this.emF.onError(this.kgp, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cKu().IQ(this.kgI);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(IK));
            if (this.kgs != null && u(Uri.parse(IK)) != null) {
                this.kgs.crE();
            }
            this.kgI = str;
            int lastIndexOf = this.kgI.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.kgI.length() > 4) {
                this.kgJ = this.kgI.substring(0, lastIndexOf + 4);
            } else {
                this.kgJ = this.kgI;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJG() {
        if (com.baidu.tbadk.coreExtra.model.f.aUF()) {
            if (this.kgw != null && (this.kgw.cJv() || this.kgw.cJw())) {
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khd);
                com.baidu.adp.lib.f.e.lb().postDelayed(this.khd, com.baidu.tbadk.coreExtra.model.f.aUE());
            }
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khe);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.khe, com.baidu.tbadk.coreExtra.model.f.aUD());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.kgs.GN(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            beL();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.khf = false;
        if (this.kgC != null) {
            cJG();
            if (this.kgp != null) {
                if (!this.kgy) {
                    this.kgy = true;
                    this.kgp.a(this.mContext, this.mUri, this.mHeaders, this.kgC, this.mUri.getHost());
                } else if (!isPlaying() && this.eFz != null) {
                    this.khf = true;
                    this.eFz.onPrepared(this.kgp);
                }
            }
        } else if (this.kgn != null && this.kgn.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.kgD) {
                addView(this.kgn, layoutParams);
            } else {
                addView(this.kgn, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void beL() {
        this.kgy = false;
        this.kgv = false;
        if (this.kgp != null) {
            if (this.kgp.isPlaying() && cJN()) {
                x.cKp().bv(this.kgJ, this.kgp.getCurrentPosition());
            }
            this.kgp.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khg);
    }

    private void IL(String str) {
        this.kgX = 0;
        this.kgY = 0;
        this.kgZ = 0;
        this.kha = 0;
        this.khb = 0;
        this.eAv = 0;
        if (this.kgw.cJw()) {
            this.kgW = kgR;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.kgY = (int) t.IN(QuickVideoView.this.kgH);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.kgH != null && this.kgH.equals(str)) {
            this.kgW = kgQ;
        } else {
            this.kgW = kgS;
        }
        this.kgV = kgT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJH() {
        this.kgV = kgT;
        if (this.kgp != null) {
            this.kgX = this.kgp.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sY(boolean z) {
        if (this.kgV == kgT && this.kgp != null) {
            this.kgV = kgU;
            this.kha = this.kgp.getDuration();
            if (z) {
                this.khb = 0;
                this.kgZ = this.kha;
            } else {
                this.kgZ = this.kgp.getCurrentPosition();
                this.khb = this.kgp.getCachedSize();
            }
            if (this.kgZ > 0) {
                if (this.kgW == kgQ) {
                    this.kgY = (int) t.IN(this.kgH);
                    if (this.kgX > 0) {
                        long j = (this.kgX * (this.kgZ / 1000)) / 8;
                        if (this.khb < 0) {
                            this.khb = 0;
                        }
                        long j2 = this.khb + j;
                        if (this.kgY > 0) {
                            j2 += this.kgY;
                        }
                        setFlowCount(j2, this.kgZ, this.kha, this.eAv);
                    } else if (this.kgX == -1) {
                        this.kgX = 603327;
                        setFlowCount((this.kgX * (this.kgZ / 1000)) / 8, this.kgZ, this.kha, this.eAv);
                    }
                } else if (this.kgW == kgR) {
                    if (this.kgX > 0) {
                        long j3 = (this.kgX * (this.kgZ / 1000)) / 8;
                        if (this.khb < 0) {
                            this.khb = 0;
                        }
                        long j4 = this.khb + j3;
                        if (this.kgY > 0) {
                            j4 -= this.kgY;
                        }
                        setFlowCount(j4, this.kgZ, this.kha, this.eAv);
                    } else if (this.kgX == -1) {
                        this.kgX = 603327;
                        setFlowCount((this.kgX * (this.kgZ / 1000)) / 8, this.kgZ, this.kha, this.eAv);
                    }
                } else {
                    setFlowCount(0L, this.kgZ, this.kha, this.eAv);
                }
            }
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khg);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kgN) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.ahK, false);
        }
        cJI();
        sY(false);
        if (this.kgE != null) {
            this.kgE.clear();
        }
        this.kgo = null;
        this.kgv = false;
        if (this.kgp != null) {
            if (this.kgp.isPlaying() && cJN()) {
                x.cKp().bv(this.kgJ, this.kgp.getCurrentPosition());
            }
            this.kgp.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khg);
        this.eFp = false;
        if (this.kgw != null) {
            this.kgw.cJu();
        }
        com.baidu.adp.lib.network.http.a.b.kL().a((b.InterfaceC0020b) null);
        if (this.kgs != null && this.kgs.GQ(getLocateSource())) {
            this.kgs = null;
        }
        if (this.kgx != null) {
            this.kgx.crU();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khg);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.ahK, false);
        }
        cJI();
        sY(false);
        if (this.kgE != null) {
            this.kgE.clear();
        }
        this.kgo = null;
        beL();
        TbVideoViewSet.cKu().IQ(this.kgI);
        this.eFp = false;
        if (this.kgw != null) {
            this.kgw.IJ(this.kgI);
        }
        com.baidu.adp.lib.network.http.a.b.kL().a((b.InterfaceC0020b) null);
        if (this.kgs != null && this.kgs.GQ(getLocateSource())) {
            this.kgs = null;
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khg);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.khc = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJI() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khd);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khe);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.evK = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.evJ = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.emF = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0651g interfaceC0651g) {
        this.evN = interfaceC0651g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJJ() {
        cJI();
        if (this.kgF != null) {
            this.kgF.onPrepared();
        }
        if (u(this.mUri) != null && this.kgp != null) {
            this.kgs.GN(this.mUri.getPath());
            this.kgs.yR(this.kgp.getPlayerType());
        }
        this.kgx.crV();
        this.kgx.crW();
        if (this.kgw != null) {
            long j = 0;
            if (this.kgp != null) {
                j = this.kgp.getDuration();
            }
            this.kgw.fj(j);
            cJH();
            if (getPlayerType() == -200) {
                this.kgw.cJA();
                cJM();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJK() {
        if (u(this.mUri) != null && this.kgp != null) {
            this.kgs.GN(this.mUri.getPath());
            this.kgs.crE();
            this.kgs.yQ(this.kgp.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.kgG == null) {
            return "";
        }
        String cKS = this.kgG.cKS();
        this.kgG.ar(str, str2, str3);
        return cKS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.kgw != null && !StringUtils.isNull(this.kgw.cJt())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.IR(uri);
                }
            }
            this.mUri = Uri.parse(this.kgw.cJt());
        }
        boolean z = false;
        if (this.kgE != null) {
            z = this.kgE.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.kgs != null) {
            this.kgu = this.kgs.a(i, i2, i3, getLocateSource(), z, this.kgK, aq(this.kgs.crK(), i3 + "", this.kgs.crL()));
            this.kgs = null;
        }
        this.kgK = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.kgp != null) {
            try {
                if (this.kgp.isPlaying() && cJN()) {
                    x.cKp().bv(this.kgJ, this.kgp.getCurrentPosition());
                }
                this.kgp.release();
                this.kgo = str;
                URI uri = new URI(this.mUri.toString());
                this.kgp.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.kgC, this.mUri.getHost());
                if (u(this.mUri) != null) {
                    this.kgs.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kgp != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.kgp.isPlaying() && cJN()) {
                x.cKp().bv(this.kgJ, this.kgp.getCurrentPosition());
            }
            this.kgp.release();
            this.kgp.a(this.mContext, this.mUri, this.mHeaders, this.kgC, this.mUri.getHost());
            if (u(this.mUri) != null) {
                this.kgs.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kgp != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.kgp.forceUseSystemMediaPlayer(true);
            }
            if (this.kgp.isPlaying() && cJN()) {
                x.cKp().bv(this.kgJ, this.kgp.getCurrentPosition());
            }
            this.kgp.release();
            this.kgp.a(this.mContext, this.mUri, this.mHeaders, this.kgC, this.mUri.getHost());
            if (u(this.mUri) != null) {
                this.kgs.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.kgv = true;
        if (this.kgp != null) {
            if (this.kgC != null && this.kgB && !this.kgp.isExistInRemote()) {
                this.kgp.a(this.mContext, this.mUri, this.mHeaders, this.kgC, this.kgA);
                if (this.kfT != null) {
                    this.kfT.cJq();
                }
                if (u(this.mUri) != null) {
                    this.kgs.crG();
                }
                cJG();
                return;
            }
            if (!this.kgp.beQ()) {
                af.a(this.ahK, true);
                this.kgp.setVolume(1.0f, 1.0f);
            }
            this.kgx.crX();
            this.kgp.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.kgw != null) {
            this.kgw.onStart();
        }
        if (this.kgr != null) {
            this.kgr.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.kgp != null) {
            this.kgs.yS(this.kgp.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kgv) {
            b(aVar);
            return;
        }
        this.kgv = true;
        if (aVar != null) {
            this.kgN = true;
            if (!cJQ()) {
                aVar.cKv();
            }
        } else {
            this.kgN = false;
        }
        setVideoPath(this.kgI, this.ahO);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cJI();
        af.a(this.ahK, false);
        if (this.kgp != null) {
            if (this.kgp.isPlaying() && cJN()) {
                x.cKp().bv(this.kgJ, this.kgp.getCurrentPosition());
            }
            this.kgp.pause();
        }
        if (this.kgw != null) {
            this.kgw.onPause();
        }
        this.kgv = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kgs != null) {
            this.kgs.crJ();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.kgp != null) {
            return this.kgp.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.kgp != null) {
            return this.kgp.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.eAv = i;
        Ba(i);
    }

    public void Ba(int i) {
        if (this.kgF != null) {
            this.kgF.cKa();
        }
        if (this.kgp != null) {
            this.kgp.seekTo(i);
        }
        if (this.kgw != null) {
            this.kgw.AX(0);
            cJM();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.kgp != null) {
            return this.kgp.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.kgp != null) {
            this.kgp.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.kgA = i;
    }

    public int getRecoveryState() {
        return this.kgA;
    }

    public void setNeedRecovery(boolean z) {
        this.kgB = z;
    }

    public void setLooping(boolean z) {
        this.eFp = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cJL() {
        return this.kgv;
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
        this.emJ = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kgw = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.evX);
    }

    public void setMute(boolean z) {
        if (z) {
            this.kgp.setVolume(0.0f, 0.0f);
            af.a(this.ahK, false);
            return;
        }
        af.a(this.ahK, true);
        this.kgp.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eFp = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kgp != null) {
            this.kgp.beR();
        }
        if (this.kgF != null) {
            this.kgF.Od();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khg);
        MessageManager.getInstance().unRegisterListener(this.evX);
        if (this.kgE != null) {
            this.kgE.clear();
        }
        if (this.kgt != null) {
            this.kgt.a(null);
            this.kgt.cry();
        }
    }

    public g getPlayer() {
        return this.kgp;
    }

    public int getPlayerType() {
        if (this.kgp == null) {
            return -300;
        }
        return this.kgp.getPlayerType();
    }

    public void cJM() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khg);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khg, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.kfT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.kgw instanceof n) || ((n) this.kgw).cJZ() == null) {
            return "";
        }
        return ((n) this.kgw).khs ? "v_mid_page" : ((n) this.kgw).cJZ().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i u(Uri uri) {
        String uri2;
        if (this.kgs != null) {
            return this.kgs;
        }
        if (!StringUtils.isNull(this.kgH)) {
            uri2 = this.kgH;
        } else if (eFy != null && this.kgw != null && !StringUtils.isNull(this.kgw.cJt())) {
            uri2 = this.kgw.cJt();
        } else {
            uri2 = (eFy == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && eFy != null) {
            this.kgs = eFy.ap(this.ahO, uri2, this.kgu);
        }
        this.kgu = null;
        this.kgK = 0L;
        return this.kgs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJN() {
        return this.kgp != null && this.kgp.getDuration() >= this.kgp.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.kgs, j, j2, j3, j4);
    }

    public static boolean vQ(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cJO() {
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
            this.kgN = true;
            if (!cJQ()) {
                aVar.cKv();
            }
            if (!cJP()) {
                aVar.cKw();
                this.kgv = true;
                setVideoPath(this.kgI, this.ahO);
                return;
            }
        } else {
            this.kgN = false;
        }
        start();
        if (this.kgp != null && this.kgN) {
            this.kgx.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJP() {
        return this == TbVideoViewSet.cKu().IP(this.kgI);
    }

    private boolean cJQ() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.evJ = null;
        this.emF = null;
        this.evM = null;
        this.eFz = null;
        this.eFD = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kgN = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kgq = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.kgp != null) {
            return this.kgp.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.kgp != null ? this.kgp.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kgs != null) {
            this.kgs.e(j, j2, j3);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.kgr = cVar;
    }
}
