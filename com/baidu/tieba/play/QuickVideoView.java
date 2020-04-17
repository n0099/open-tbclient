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
    private static h eFs;
    private static com.baidu.tieba.k.l eFt;
    private static int kgM = 0;
    private static int kgN = 1;
    private static int kgO = 2;
    private static int kgP = 1;
    private static int kgQ = 0;
    private WeakReference<Context> ahH;
    private String ahL;
    private TextureView.SurfaceTextureListener bwD;
    private int eAq;
    private boolean eFk;
    private g.f eFu;
    private g.a eFv;
    private g.InterfaceC0630g eFy;
    private g.b emA;
    private b emE;
    private g.a evE;
    private g.f evF;
    private g.c evG;
    private g.e evH;
    private g.InterfaceC0630g evI;
    private g.i evJ;
    private g.d evK;
    private g.h evL;
    private final CustomMessageListener evS;
    private a kfP;
    private com.baidu.tieba.play.b.a kgA;
    private q kgB;
    private com.baidu.tieba.play.b.f kgC;
    private String kgD;
    private String kgE;
    private String kgF;
    private long kgG;
    private boolean kgH;
    private boolean kgI;
    private boolean kgJ;
    private long kgK;
    private long kgL;
    private int kgR;
    private int kgS;
    private int kgT;
    private int kgU;
    private int kgV;
    private int kgW;
    private int kgX;
    private boolean kgY;
    private Runnable kgZ;
    private RenderView kgj;
    private String kgk;
    private g kgl;
    private g.e kgm;
    private c kgn;
    private com.baidu.tieba.k.i kgo;
    private com.baidu.tieba.k.e kgp;
    private String kgq;
    private boolean kgr;
    private d kgs;
    private com.baidu.tieba.k.k kgt;
    private boolean kgu;
    private int kgv;
    private int kgw;
    private boolean kgx;
    private SurfaceTexture kgy;
    private boolean kgz;
    private Runnable kha;
    public boolean khb;
    private Runnable khc;
    private Context mContext;
    private Map<String, String> mHeaders;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cJs();
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
            eFs = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            eFt = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.kgz = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.kgr = false;
        this.kgu = false;
        this.kgv = 0;
        this.eFk = false;
        this.kgw = -1;
        this.kgx = false;
        this.kgy = null;
        this.kgz = true;
        this.kgJ = false;
        this.kgK = 0L;
        this.kgL = 0L;
        this.kgR = kgQ;
        this.kgS = 0;
        this.kgT = 0;
        this.kgU = -1;
        this.kgV = 0;
        this.kgW = 0;
        this.kgX = 0;
        this.eAq = 0;
        this.kgY = false;
        this.ahH = null;
        this.kgZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgl != null && QuickVideoView.this.kgr) {
                    QuickVideoView.this.b(QuickVideoView.this.kgl, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kha = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.qb(false);
                }
            }
        };
        this.khb = false;
        this.bwD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kgY) {
                    QuickVideoView.this.kgY = false;
                    if (QuickVideoView.this.kgl != null) {
                        QuickVideoView.this.kgl.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kgu || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kgl != null) {
                        if (QuickVideoView.this.cJR()) {
                            QuickVideoView.this.kgl.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.kgx) {
                            QuickVideoView.this.kgl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kgw);
                            if (QuickVideoView.this.kfP != null) {
                                QuickVideoView.this.kfP.cJs();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kgo.crI();
                            }
                        }
                    }
                } else if (cJU()) {
                    if (QuickVideoView.this.kgl != null) {
                        QuickVideoView.this.cJI();
                        QuickVideoView.this.kgu = true;
                        QuickVideoView.this.kgl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kgo.crH();
                    }
                }
                QuickVideoView.this.kgy = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kgY) {
                    QuickVideoView.this.cJK();
                    QuickVideoView.this.sY(false);
                    if (QuickVideoView.this.kgl != null) {
                        if (QuickVideoView.this.kgl.isPlaying() && QuickVideoView.this.cJP()) {
                            x.cKr().bv(QuickVideoView.this.kgF, QuickVideoView.this.kgl.getCurrentPosition());
                            if (QuickVideoView.this.kgJ) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kgJ) {
                            QuickVideoView.this.kgl.release();
                        }
                    }
                    if (QuickVideoView.this.kgu) {
                        if (QuickVideoView.this.kgs != null && !QuickVideoView.this.kgJ) {
                            QuickVideoView.this.kgs.IG(QuickVideoView.this.kgE);
                        }
                        if (QuickVideoView.this.emE != null) {
                            QuickVideoView.this.emE.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kgy = null;
                    if (QuickVideoView.this.kgo != null && QuickVideoView.this.kgo.GN(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kgo = null;
                    }
                    if (!QuickVideoView.this.kgJ) {
                        QuickVideoView.this.kgu = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cJU() {
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
        this.eFu = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int IL;
                QuickVideoView.this.cJK();
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.onPrepared();
                }
                if (QuickVideoView.this.kgo != null && QuickVideoView.this.kgl != null) {
                    QuickVideoView.this.kgo.yQ(QuickVideoView.this.kgl.getPlayerType());
                }
                if (QuickVideoView.this.kgJ) {
                    TbVideoViewSet.cKw().a(QuickVideoView.this, QuickVideoView.this.kgE);
                }
                if (QuickVideoView.this.evF != null) {
                    QuickVideoView.this.kgt.crY();
                    QuickVideoView.this.evF.onPrepared(gVar);
                }
                if (QuickVideoView.this.kgs != null) {
                    long j = 0;
                    if (QuickVideoView.this.kgl != null) {
                        j = QuickVideoView.this.kgl.getDuration();
                    }
                    QuickVideoView.this.kgs.fj(j);
                    QuickVideoView.this.cJJ();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kgs.cJC();
                        QuickVideoView.this.cJO();
                    }
                }
                if (QuickVideoView.this.kgI && (IL = x.cKr().IL(QuickVideoView.this.kgF)) > 0 && QuickVideoView.this.kgl != null && QuickVideoView.this.kgl.getCurrentPosition() == 0) {
                    QuickVideoView.this.Ba(IL);
                }
                if (QuickVideoView.this.kgr) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kgj != null && gVar != null) {
                    QuickVideoView.this.kgj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgv);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kgk) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kgk);
                }
                if (QuickVideoView.this.kgA != null && QuickVideoView.this.kgA.cKS()) {
                    com.baidu.tieba.play.b.e.Bg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eFv = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.sY(true);
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.GM(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kgo = null;
                }
                if (!QuickVideoView.this.eFk || QuickVideoView.this.kgs == null) {
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.onCompletion();
                    }
                    QuickVideoView.this.kgr = false;
                    x.cKr().remove(QuickVideoView.this.kgF);
                    if (QuickVideoView.this.evE != null) {
                        QuickVideoView.this.evE.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kgq = null;
                QuickVideoView.this.kgG = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kgs.cJv());
                QuickVideoView.this.start();
            }
        };
        this.evG = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cJK();
                if (QuickVideoView.this.kgs != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cJP()) {
                    QuickVideoView.this.kgH = true;
                    x.cKr().bv(QuickVideoView.this.kgF, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKw().IN(QuickVideoView.this.kgE);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kgo != null) {
                        QuickVideoView.this.kgq = QuickVideoView.this.kgo.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kgG, QuickVideoView.this.aq(QuickVideoView.this.kgo.crM(), i3 + "", QuickVideoView.this.kgo.crN()));
                        QuickVideoView.this.kgo = null;
                    }
                    QuickVideoView.this.kgG = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Be(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Bf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.emA == null || QuickVideoView.this.emA.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eFy = new g.InterfaceC0630g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                if (QuickVideoView.this.kgH) {
                    QuickVideoView.this.kgH = false;
                    return;
                }
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.cKd();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kgs != null && z) {
                    QuickVideoView.this.kgs.onSeekComplete();
                }
                if (QuickVideoView.this.evI != null) {
                    QuickVideoView.this.evI.b(gVar);
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kgm != null) {
                    QuickVideoView.this.kgm.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kgv = i2;
                    if (QuickVideoView.this.kgj != null && gVar != null) {
                        QuickVideoView.this.kgj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgv);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kgt.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.a(i, i2, QuickVideoView.this.kgo);
                    return true;
                }
                return true;
            }
        };
        this.evJ = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.m(i, i2, str);
                }
            }
        };
        this.evK = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.GO(str);
                }
            }
        };
        this.evL = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kgG = j;
                }
            }
        };
        this.khc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kgs != null && QuickVideoView.this.kgs.cJy() && QuickVideoView.this.kgs.cJz() && QuickVideoView.this.kgs.cJA() && QuickVideoView.this.kgl != null) {
                    int beR = QuickVideoView.this.kgl.beR();
                    int currentPosition = QuickVideoView.this.kgl.getCurrentPosition();
                    int duration = QuickVideoView.this.kgl.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kgK;
                    boolean z = currentPosition + beR < duration;
                    if (beR < QuickVideoView.this.kgs.cJB() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kgK = currentTimeMillis;
                        QuickVideoView.this.kgs.AX(0);
                    }
                    if (QuickVideoView.this.cJN() && currentPosition == QuickVideoView.this.kgL && j > 500) {
                        QuickVideoView.this.kgK = currentTimeMillis;
                        QuickVideoView.this.kgs.AX(0);
                    }
                    QuickVideoView.this.kgL = currentPosition;
                    if (QuickVideoView.this.kgR == QuickVideoView.kgP) {
                        QuickVideoView.this.cJO();
                    }
                }
            }
        };
        this.evS = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.xX(QuickVideoView.this.kgE);
                    }
                    if (QuickVideoView.this.kgo != null) {
                        QuickVideoView.this.kgo.GL(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kgo = null;
                    }
                    QuickVideoView.this.cJK();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgr = false;
        this.kgu = false;
        this.kgv = 0;
        this.eFk = false;
        this.kgw = -1;
        this.kgx = false;
        this.kgy = null;
        this.kgz = true;
        this.kgJ = false;
        this.kgK = 0L;
        this.kgL = 0L;
        this.kgR = kgQ;
        this.kgS = 0;
        this.kgT = 0;
        this.kgU = -1;
        this.kgV = 0;
        this.kgW = 0;
        this.kgX = 0;
        this.eAq = 0;
        this.kgY = false;
        this.ahH = null;
        this.kgZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgl != null && QuickVideoView.this.kgr) {
                    QuickVideoView.this.b(QuickVideoView.this.kgl, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kha = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.qb(false);
                }
            }
        };
        this.khb = false;
        this.bwD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kgY) {
                    QuickVideoView.this.kgY = false;
                    if (QuickVideoView.this.kgl != null) {
                        QuickVideoView.this.kgl.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kgu || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kgl != null) {
                        if (QuickVideoView.this.cJR()) {
                            QuickVideoView.this.kgl.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.kgx) {
                            QuickVideoView.this.kgl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kgw);
                            if (QuickVideoView.this.kfP != null) {
                                QuickVideoView.this.kfP.cJs();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kgo.crI();
                            }
                        }
                    }
                } else if (cJU()) {
                    if (QuickVideoView.this.kgl != null) {
                        QuickVideoView.this.cJI();
                        QuickVideoView.this.kgu = true;
                        QuickVideoView.this.kgl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kgo.crH();
                    }
                }
                QuickVideoView.this.kgy = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kgY) {
                    QuickVideoView.this.cJK();
                    QuickVideoView.this.sY(false);
                    if (QuickVideoView.this.kgl != null) {
                        if (QuickVideoView.this.kgl.isPlaying() && QuickVideoView.this.cJP()) {
                            x.cKr().bv(QuickVideoView.this.kgF, QuickVideoView.this.kgl.getCurrentPosition());
                            if (QuickVideoView.this.kgJ) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kgJ) {
                            QuickVideoView.this.kgl.release();
                        }
                    }
                    if (QuickVideoView.this.kgu) {
                        if (QuickVideoView.this.kgs != null && !QuickVideoView.this.kgJ) {
                            QuickVideoView.this.kgs.IG(QuickVideoView.this.kgE);
                        }
                        if (QuickVideoView.this.emE != null) {
                            QuickVideoView.this.emE.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kgy = null;
                    if (QuickVideoView.this.kgo != null && QuickVideoView.this.kgo.GN(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kgo = null;
                    }
                    if (!QuickVideoView.this.kgJ) {
                        QuickVideoView.this.kgu = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cJU() {
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
        this.eFu = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int IL;
                QuickVideoView.this.cJK();
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.onPrepared();
                }
                if (QuickVideoView.this.kgo != null && QuickVideoView.this.kgl != null) {
                    QuickVideoView.this.kgo.yQ(QuickVideoView.this.kgl.getPlayerType());
                }
                if (QuickVideoView.this.kgJ) {
                    TbVideoViewSet.cKw().a(QuickVideoView.this, QuickVideoView.this.kgE);
                }
                if (QuickVideoView.this.evF != null) {
                    QuickVideoView.this.kgt.crY();
                    QuickVideoView.this.evF.onPrepared(gVar);
                }
                if (QuickVideoView.this.kgs != null) {
                    long j = 0;
                    if (QuickVideoView.this.kgl != null) {
                        j = QuickVideoView.this.kgl.getDuration();
                    }
                    QuickVideoView.this.kgs.fj(j);
                    QuickVideoView.this.cJJ();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kgs.cJC();
                        QuickVideoView.this.cJO();
                    }
                }
                if (QuickVideoView.this.kgI && (IL = x.cKr().IL(QuickVideoView.this.kgF)) > 0 && QuickVideoView.this.kgl != null && QuickVideoView.this.kgl.getCurrentPosition() == 0) {
                    QuickVideoView.this.Ba(IL);
                }
                if (QuickVideoView.this.kgr) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kgj != null && gVar != null) {
                    QuickVideoView.this.kgj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgv);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kgk) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kgk);
                }
                if (QuickVideoView.this.kgA != null && QuickVideoView.this.kgA.cKS()) {
                    com.baidu.tieba.play.b.e.Bg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eFv = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.sY(true);
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.GM(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kgo = null;
                }
                if (!QuickVideoView.this.eFk || QuickVideoView.this.kgs == null) {
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.onCompletion();
                    }
                    QuickVideoView.this.kgr = false;
                    x.cKr().remove(QuickVideoView.this.kgF);
                    if (QuickVideoView.this.evE != null) {
                        QuickVideoView.this.evE.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kgq = null;
                QuickVideoView.this.kgG = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kgs.cJv());
                QuickVideoView.this.start();
            }
        };
        this.evG = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cJK();
                if (QuickVideoView.this.kgs != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cJP()) {
                    QuickVideoView.this.kgH = true;
                    x.cKr().bv(QuickVideoView.this.kgF, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKw().IN(QuickVideoView.this.kgE);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kgo != null) {
                        QuickVideoView.this.kgq = QuickVideoView.this.kgo.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kgG, QuickVideoView.this.aq(QuickVideoView.this.kgo.crM(), i3 + "", QuickVideoView.this.kgo.crN()));
                        QuickVideoView.this.kgo = null;
                    }
                    QuickVideoView.this.kgG = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Be(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Bf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.emA == null || QuickVideoView.this.emA.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eFy = new g.InterfaceC0630g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                if (QuickVideoView.this.kgH) {
                    QuickVideoView.this.kgH = false;
                    return;
                }
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.cKd();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kgs != null && z) {
                    QuickVideoView.this.kgs.onSeekComplete();
                }
                if (QuickVideoView.this.evI != null) {
                    QuickVideoView.this.evI.b(gVar);
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kgm != null) {
                    QuickVideoView.this.kgm.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kgv = i2;
                    if (QuickVideoView.this.kgj != null && gVar != null) {
                        QuickVideoView.this.kgj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgv);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kgt.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.a(i, i2, QuickVideoView.this.kgo);
                    return true;
                }
                return true;
            }
        };
        this.evJ = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.m(i, i2, str);
                }
            }
        };
        this.evK = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.GO(str);
                }
            }
        };
        this.evL = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kgG = j;
                }
            }
        };
        this.khc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kgs != null && QuickVideoView.this.kgs.cJy() && QuickVideoView.this.kgs.cJz() && QuickVideoView.this.kgs.cJA() && QuickVideoView.this.kgl != null) {
                    int beR = QuickVideoView.this.kgl.beR();
                    int currentPosition = QuickVideoView.this.kgl.getCurrentPosition();
                    int duration = QuickVideoView.this.kgl.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kgK;
                    boolean z = currentPosition + beR < duration;
                    if (beR < QuickVideoView.this.kgs.cJB() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kgK = currentTimeMillis;
                        QuickVideoView.this.kgs.AX(0);
                    }
                    if (QuickVideoView.this.cJN() && currentPosition == QuickVideoView.this.kgL && j > 500) {
                        QuickVideoView.this.kgK = currentTimeMillis;
                        QuickVideoView.this.kgs.AX(0);
                    }
                    QuickVideoView.this.kgL = currentPosition;
                    if (QuickVideoView.this.kgR == QuickVideoView.kgP) {
                        QuickVideoView.this.cJO();
                    }
                }
            }
        };
        this.evS = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.xX(QuickVideoView.this.kgE);
                    }
                    if (QuickVideoView.this.kgo != null) {
                        QuickVideoView.this.kgo.GL(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kgo = null;
                    }
                    QuickVideoView.this.cJK();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgr = false;
        this.kgu = false;
        this.kgv = 0;
        this.eFk = false;
        this.kgw = -1;
        this.kgx = false;
        this.kgy = null;
        this.kgz = true;
        this.kgJ = false;
        this.kgK = 0L;
        this.kgL = 0L;
        this.kgR = kgQ;
        this.kgS = 0;
        this.kgT = 0;
        this.kgU = -1;
        this.kgV = 0;
        this.kgW = 0;
        this.kgX = 0;
        this.eAq = 0;
        this.kgY = false;
        this.ahH = null;
        this.kgZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgl != null && QuickVideoView.this.kgr) {
                    QuickVideoView.this.b(QuickVideoView.this.kgl, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kha = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.qb(false);
                }
            }
        };
        this.khb = false;
        this.bwD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.kgY) {
                    QuickVideoView.this.kgY = false;
                    if (QuickVideoView.this.kgl != null) {
                        QuickVideoView.this.kgl.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kgu || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kgl != null) {
                        if (QuickVideoView.this.cJR()) {
                            QuickVideoView.this.kgl.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.kgx) {
                            QuickVideoView.this.kgl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kgw);
                            if (QuickVideoView.this.kfP != null) {
                                QuickVideoView.this.kfP.cJs();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kgo.crI();
                            }
                        }
                    }
                } else if (cJU()) {
                    if (QuickVideoView.this.kgl != null) {
                        QuickVideoView.this.cJI();
                        QuickVideoView.this.kgu = true;
                        QuickVideoView.this.kgl.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kgo.crH();
                    }
                }
                QuickVideoView.this.kgy = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kgY) {
                    QuickVideoView.this.cJK();
                    QuickVideoView.this.sY(false);
                    if (QuickVideoView.this.kgl != null) {
                        if (QuickVideoView.this.kgl.isPlaying() && QuickVideoView.this.cJP()) {
                            x.cKr().bv(QuickVideoView.this.kgF, QuickVideoView.this.kgl.getCurrentPosition());
                            if (QuickVideoView.this.kgJ) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kgJ) {
                            QuickVideoView.this.kgl.release();
                        }
                    }
                    if (QuickVideoView.this.kgu) {
                        if (QuickVideoView.this.kgs != null && !QuickVideoView.this.kgJ) {
                            QuickVideoView.this.kgs.IG(QuickVideoView.this.kgE);
                        }
                        if (QuickVideoView.this.emE != null) {
                            QuickVideoView.this.emE.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kgy = null;
                    if (QuickVideoView.this.kgo != null && QuickVideoView.this.kgo.GN(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kgo = null;
                    }
                    if (!QuickVideoView.this.kgJ) {
                        QuickVideoView.this.kgu = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cJU() {
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
        this.eFu = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int IL;
                QuickVideoView.this.cJK();
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.onPrepared();
                }
                if (QuickVideoView.this.kgo != null && QuickVideoView.this.kgl != null) {
                    QuickVideoView.this.kgo.yQ(QuickVideoView.this.kgl.getPlayerType());
                }
                if (QuickVideoView.this.kgJ) {
                    TbVideoViewSet.cKw().a(QuickVideoView.this, QuickVideoView.this.kgE);
                }
                if (QuickVideoView.this.evF != null) {
                    QuickVideoView.this.kgt.crY();
                    QuickVideoView.this.evF.onPrepared(gVar);
                }
                if (QuickVideoView.this.kgs != null) {
                    long j = 0;
                    if (QuickVideoView.this.kgl != null) {
                        j = QuickVideoView.this.kgl.getDuration();
                    }
                    QuickVideoView.this.kgs.fj(j);
                    QuickVideoView.this.cJJ();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kgs.cJC();
                        QuickVideoView.this.cJO();
                    }
                }
                if (QuickVideoView.this.kgI && (IL = x.cKr().IL(QuickVideoView.this.kgF)) > 0 && QuickVideoView.this.kgl != null && QuickVideoView.this.kgl.getCurrentPosition() == 0) {
                    QuickVideoView.this.Ba(IL);
                }
                if (QuickVideoView.this.kgr) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kgj != null && gVar != null) {
                    QuickVideoView.this.kgj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgv);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kgk) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kgk);
                }
                if (QuickVideoView.this.kgA != null && QuickVideoView.this.kgA.cKS()) {
                    com.baidu.tieba.play.b.e.Bg(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eFv = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.sY(true);
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.GM(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kgo = null;
                }
                if (!QuickVideoView.this.eFk || QuickVideoView.this.kgs == null) {
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.onCompletion();
                    }
                    QuickVideoView.this.kgr = false;
                    x.cKr().remove(QuickVideoView.this.kgF);
                    if (QuickVideoView.this.evE != null) {
                        QuickVideoView.this.evE.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kgq = null;
                QuickVideoView.this.kgG = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kgs.cJv());
                QuickVideoView.this.start();
            }
        };
        this.evG = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.aa(i2, i22, i3);
                QuickVideoView.this.cJK();
                if (QuickVideoView.this.kgs != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cJP()) {
                    QuickVideoView.this.kgH = true;
                    x.cKr().bv(QuickVideoView.this.kgF, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cKw().IN(QuickVideoView.this.kgE);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kgo != null) {
                        QuickVideoView.this.kgq = QuickVideoView.this.kgo.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kgG, QuickVideoView.this.aq(QuickVideoView.this.kgo.crM(), i3 + "", QuickVideoView.this.kgo.crN()));
                        QuickVideoView.this.kgo = null;
                    }
                    QuickVideoView.this.kgG = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.Be(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Bf(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.emA == null || QuickVideoView.this.emA.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.eFy = new g.InterfaceC0630g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(g gVar) {
                if (QuickVideoView.this.kgH) {
                    QuickVideoView.this.kgH = false;
                    return;
                }
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.cKd();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kgs != null && z) {
                    QuickVideoView.this.kgs.onSeekComplete();
                }
                if (QuickVideoView.this.evI != null) {
                    QuickVideoView.this.evI.b(gVar);
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.kgm != null) {
                    QuickVideoView.this.kgm.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.kgv = i22;
                    if (QuickVideoView.this.kgj != null && gVar != null) {
                        QuickVideoView.this.kgj.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kgv);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.kgt.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kgB != null) {
                    QuickVideoView.this.kgB.a(i2, i22, QuickVideoView.this.kgo);
                    return true;
                }
                return true;
            }
        };
        this.evJ = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.m(i2, i22, str);
                }
            }
        };
        this.evK = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kgo != null) {
                    QuickVideoView.this.kgo.GO(str);
                }
            }
        };
        this.evL = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kgG = j;
                }
            }
        };
        this.khc = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kgs != null && QuickVideoView.this.kgs.cJy() && QuickVideoView.this.kgs.cJz() && QuickVideoView.this.kgs.cJA() && QuickVideoView.this.kgl != null) {
                    int beR = QuickVideoView.this.kgl.beR();
                    int currentPosition = QuickVideoView.this.kgl.getCurrentPosition();
                    int duration = QuickVideoView.this.kgl.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kgK;
                    boolean z = currentPosition + beR < duration;
                    if (beR < QuickVideoView.this.kgs.cJB() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kgK = currentTimeMillis;
                        QuickVideoView.this.kgs.AX(0);
                    }
                    if (QuickVideoView.this.cJN() && currentPosition == QuickVideoView.this.kgL && j > 500) {
                        QuickVideoView.this.kgK = currentTimeMillis;
                        QuickVideoView.this.kgs.AX(0);
                    }
                    QuickVideoView.this.kgL = currentPosition;
                    if (QuickVideoView.this.kgR == QuickVideoView.kgP) {
                        QuickVideoView.this.cJO();
                    }
                }
            }
        };
        this.evS = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kgs != null) {
                        QuickVideoView.this.kgs.xX(QuickVideoView.this.kgE);
                    }
                    if (QuickVideoView.this.kgo != null) {
                        QuickVideoView.this.kgo.GL(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kgo = null;
                    }
                    QuickVideoView.this.cJK();
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
        this.kgj = new RenderView(context);
        this.ahH = new WeakReference<>(TbadkCoreApplication.getInst());
        this.kgj.setSurfaceTextureListener(this.bwD);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.kgz) {
            addView(this.kgj, layoutParams);
        } else {
            addView(this.kgj, 0, layoutParams);
        }
        if (eFs != null) {
            this.kgl = eFs.beU();
        }
        if (this.kgl != null) {
            this.kgl.setOnPreparedListener(this.eFu);
            this.kgl.setOnCompletionListener(this.eFv);
            this.kgl.a(this.evG);
            this.kgl.setOnSeekCompleteListener(this.eFy);
            this.kgl.a(this.evH);
            this.kgl.a(this.evJ);
            this.kgl.a(this.evK);
            this.kgl.a(this.evL);
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
        this.kgA = new com.baidu.tieba.play.b.a(this);
        this.kgB = new q();
        this.kgC = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.kgt = new com.baidu.tieba.k.k();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kgI = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kgE;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.kgt.crX();
        this.ahL = str2;
        if (this.kgA != null) {
            this.kgA.clear();
            this.kgA.cKS();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.IP(str2);
            if (eFt != null) {
                this.kgo = eFt.ap(this.ahL, str, "");
                if (this.kgo != null) {
                    this.kgo.a(-300, -44399, -44399, getLocateSource(), false, this.kgG, "");
                    this.kgo = null;
                }
            }
        }
        if (this.kgp != null) {
            this.kgp.a(null);
            this.kgp.crA();
            this.kgp = null;
        }
        this.kgq = null;
        this.kgG = 0L;
        setVideoPath(str);
    }

    private String IH(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.day().daz()) {
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
            String IH = IH(str);
            this.kgD = IH;
            if (this.kgs != null) {
                IH = this.kgs.xS(IH);
                if (this.kgs.cJD() != null) {
                    this.kgs.cJD().setPlayer(this);
                }
                if (eFt != null && vN(IH)) {
                    this.kgp = eFt.GQ(IH);
                }
                if (this.kgp != null) {
                    this.kgp.a(new com.baidu.tieba.play.monitor.a(this.ahL, this.kgD, this.kgo));
                    this.kgp.crz();
                }
                II(IH);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !vN(IH)) {
                if (this.emA != null) {
                    this.emA.onError(this.kgl, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cKw().IN(this.kgE);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(IH));
            if (this.kgo != null && u(Uri.parse(IH)) != null) {
                this.kgo.crG();
            }
            this.kgE = str;
            int lastIndexOf = this.kgE.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.kgE.length() > 4) {
                this.kgF = this.kgE.substring(0, lastIndexOf + 4);
            } else {
                this.kgF = this.kgE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJI() {
        if (com.baidu.tbadk.coreExtra.model.f.aUH()) {
            if (this.kgs != null && (this.kgs.cJx() || this.kgs.cJy())) {
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgZ);
                com.baidu.adp.lib.f.e.lb().postDelayed(this.kgZ, com.baidu.tbadk.coreExtra.model.f.aUG());
            }
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kha);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.kha, com.baidu.tbadk.coreExtra.model.f.aUF());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.kgo.GK(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            beN();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.khb = false;
        if (this.kgy != null) {
            cJI();
            if (this.kgl != null) {
                if (!this.kgu) {
                    this.kgu = true;
                    this.kgl.a(this.mContext, this.mUri, this.mHeaders, this.kgy, this.mUri.getHost());
                } else if (!isPlaying() && this.eFu != null) {
                    this.khb = true;
                    this.eFu.onPrepared(this.kgl);
                }
            }
        } else if (this.kgj != null && this.kgj.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.kgz) {
                addView(this.kgj, layoutParams);
            } else {
                addView(this.kgj, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void beN() {
        this.kgu = false;
        this.kgr = false;
        if (this.kgl != null) {
            if (this.kgl.isPlaying() && cJP()) {
                x.cKr().bv(this.kgF, this.kgl.getCurrentPosition());
            }
            this.kgl.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khc);
    }

    private void II(String str) {
        this.kgT = 0;
        this.kgU = 0;
        this.kgV = 0;
        this.kgW = 0;
        this.kgX = 0;
        this.eAq = 0;
        if (this.kgs.cJy()) {
            this.kgS = kgN;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.kgU = (int) t.IK(QuickVideoView.this.kgD);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.kgD != null && this.kgD.equals(str)) {
            this.kgS = kgM;
        } else {
            this.kgS = kgO;
        }
        this.kgR = kgP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJJ() {
        this.kgR = kgP;
        if (this.kgl != null) {
            this.kgT = this.kgl.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sY(boolean z) {
        if (this.kgR == kgP && this.kgl != null) {
            this.kgR = kgQ;
            this.kgW = this.kgl.getDuration();
            if (z) {
                this.kgX = 0;
                this.kgV = this.kgW;
            } else {
                this.kgV = this.kgl.getCurrentPosition();
                this.kgX = this.kgl.getCachedSize();
            }
            if (this.kgV > 0) {
                if (this.kgS == kgM) {
                    this.kgU = (int) t.IK(this.kgD);
                    if (this.kgT > 0) {
                        long j = (this.kgT * (this.kgV / 1000)) / 8;
                        if (this.kgX < 0) {
                            this.kgX = 0;
                        }
                        long j2 = this.kgX + j;
                        if (this.kgU > 0) {
                            j2 += this.kgU;
                        }
                        setFlowCount(j2, this.kgV, this.kgW, this.eAq);
                    } else if (this.kgT == -1) {
                        this.kgT = 603327;
                        setFlowCount((this.kgT * (this.kgV / 1000)) / 8, this.kgV, this.kgW, this.eAq);
                    }
                } else if (this.kgS == kgN) {
                    if (this.kgT > 0) {
                        long j3 = (this.kgT * (this.kgV / 1000)) / 8;
                        if (this.kgX < 0) {
                            this.kgX = 0;
                        }
                        long j4 = this.kgX + j3;
                        if (this.kgU > 0) {
                            j4 -= this.kgU;
                        }
                        setFlowCount(j4, this.kgV, this.kgW, this.eAq);
                    } else if (this.kgT == -1) {
                        this.kgT = 603327;
                        setFlowCount((this.kgT * (this.kgV / 1000)) / 8, this.kgV, this.kgW, this.eAq);
                    }
                } else {
                    setFlowCount(0L, this.kgV, this.kgW, this.eAq);
                }
            }
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khc);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kgJ) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.ahH, false);
        }
        cJK();
        sY(false);
        if (this.kgA != null) {
            this.kgA.clear();
        }
        this.kgk = null;
        this.kgr = false;
        if (this.kgl != null) {
            if (this.kgl.isPlaying() && cJP()) {
                x.cKr().bv(this.kgF, this.kgl.getCurrentPosition());
            }
            this.kgl.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khc);
        this.eFk = false;
        if (this.kgs != null) {
            this.kgs.cJw();
        }
        com.baidu.adp.lib.network.http.a.b.kL().a((b.InterfaceC0020b) null);
        if (this.kgo != null && this.kgo.GN(getLocateSource())) {
            this.kgo = null;
        }
        if (this.kgt != null) {
            this.kgt.crW();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khc);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.ahH, false);
        }
        cJK();
        sY(false);
        if (this.kgA != null) {
            this.kgA.clear();
        }
        this.kgk = null;
        beN();
        TbVideoViewSet.cKw().IN(this.kgE);
        this.eFk = false;
        if (this.kgs != null) {
            this.kgs.IG(this.kgE);
        }
        com.baidu.adp.lib.network.http.a.b.kL().a((b.InterfaceC0020b) null);
        if (this.kgo != null && this.kgo.GN(getLocateSource())) {
            this.kgo = null;
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khc);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.kgY = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJK() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgZ);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kha);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.evF = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.evE = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.emA = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0630g interfaceC0630g) {
        this.evI = interfaceC0630g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJL() {
        cJK();
        if (this.kgB != null) {
            this.kgB.onPrepared();
        }
        if (u(this.mUri) != null && this.kgl != null) {
            this.kgo.GK(this.mUri.getPath());
            this.kgo.yR(this.kgl.getPlayerType());
        }
        this.kgt.crX();
        this.kgt.crY();
        if (this.kgs != null) {
            long j = 0;
            if (this.kgl != null) {
                j = this.kgl.getDuration();
            }
            this.kgs.fj(j);
            cJJ();
            if (getPlayerType() == -200) {
                this.kgs.cJC();
                cJO();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cJM() {
        if (u(this.mUri) != null && this.kgl != null) {
            this.kgo.GK(this.mUri.getPath());
            this.kgo.crG();
            this.kgo.yQ(this.kgl.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.kgC == null) {
            return "";
        }
        String cKU = this.kgC.cKU();
        this.kgC.ar(str, str2, str3);
        return cKU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.kgs != null && !StringUtils.isNull(this.kgs.cJv())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.IO(uri);
                }
            }
            this.mUri = Uri.parse(this.kgs.cJv());
        }
        boolean z = false;
        if (this.kgA != null) {
            z = this.kgA.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.kgo != null) {
            this.kgq = this.kgo.a(i, i2, i3, getLocateSource(), z, this.kgG, aq(this.kgo.crM(), i3 + "", this.kgo.crN()));
            this.kgo = null;
        }
        this.kgG = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.kgl != null) {
            try {
                if (this.kgl.isPlaying() && cJP()) {
                    x.cKr().bv(this.kgF, this.kgl.getCurrentPosition());
                }
                this.kgl.release();
                this.kgk = str;
                URI uri = new URI(this.mUri.toString());
                this.kgl.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.kgy, this.mUri.getHost());
                if (u(this.mUri) != null) {
                    this.kgo.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kgl != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.kgl.isPlaying() && cJP()) {
                x.cKr().bv(this.kgF, this.kgl.getCurrentPosition());
            }
            this.kgl.release();
            this.kgl.a(this.mContext, this.mUri, this.mHeaders, this.kgy, this.mUri.getHost());
            if (u(this.mUri) != null) {
                this.kgo.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kgl != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.kgl.forceUseSystemMediaPlayer(true);
            }
            if (this.kgl.isPlaying() && cJP()) {
                x.cKr().bv(this.kgF, this.kgl.getCurrentPosition());
            }
            this.kgl.release();
            this.kgl.a(this.mContext, this.mUri, this.mHeaders, this.kgy, this.mUri.getHost());
            if (u(this.mUri) != null) {
                this.kgo.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.kgr = true;
        if (this.kgl != null) {
            if (this.kgy != null && this.kgx && !this.kgl.isExistInRemote()) {
                this.kgl.a(this.mContext, this.mUri, this.mHeaders, this.kgy, this.kgw);
                if (this.kfP != null) {
                    this.kfP.cJs();
                }
                if (u(this.mUri) != null) {
                    this.kgo.crI();
                }
                cJI();
                return;
            }
            if (!this.kgl.beS()) {
                af.a(this.ahH, true);
                this.kgl.setVolume(1.0f, 1.0f);
            }
            this.kgt.crZ();
            this.kgl.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.kgs != null) {
            this.kgs.onStart();
        }
        if (this.kgn != null) {
            this.kgn.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.kgl != null) {
            this.kgo.yS(this.kgl.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kgr) {
            b(aVar);
            return;
        }
        this.kgr = true;
        if (aVar != null) {
            this.kgJ = true;
            if (!cJS()) {
                aVar.cKx();
            }
        } else {
            this.kgJ = false;
        }
        setVideoPath(this.kgE, this.ahL);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cJK();
        af.a(this.ahH, false);
        if (this.kgl != null) {
            if (this.kgl.isPlaying() && cJP()) {
                x.cKr().bv(this.kgF, this.kgl.getCurrentPosition());
            }
            this.kgl.pause();
        }
        if (this.kgs != null) {
            this.kgs.onPause();
        }
        this.kgr = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kgo != null) {
            this.kgo.crL();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.kgl != null) {
            return this.kgl.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.kgl != null) {
            return this.kgl.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.eAq = i;
        Ba(i);
    }

    public void Ba(int i) {
        if (this.kgB != null) {
            this.kgB.cKc();
        }
        if (this.kgl != null) {
            this.kgl.seekTo(i);
        }
        if (this.kgs != null) {
            this.kgs.AX(0);
            cJO();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.kgl != null) {
            return this.kgl.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.kgl != null) {
            this.kgl.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.kgw = i;
    }

    public int getRecoveryState() {
        return this.kgw;
    }

    public void setNeedRecovery(boolean z) {
        this.kgx = z;
    }

    public void setLooping(boolean z) {
        this.eFk = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cJN() {
        return this.kgr;
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
        this.emE = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kgs = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.evS);
    }

    public void setMute(boolean z) {
        if (z) {
            this.kgl.setVolume(0.0f, 0.0f);
            af.a(this.ahH, false);
            return;
        }
        af.a(this.ahH, true);
        this.kgl.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eFk = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kgl != null) {
            this.kgl.beT();
        }
        if (this.kgB != null) {
            this.kgB.Oe();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khc);
        MessageManager.getInstance().unRegisterListener(this.evS);
        if (this.kgA != null) {
            this.kgA.clear();
        }
        if (this.kgp != null) {
            this.kgp.a(null);
            this.kgp.crA();
        }
    }

    public g getPlayer() {
        return this.kgl;
    }

    public int getPlayerType() {
        if (this.kgl == null) {
            return -300;
        }
        return this.kgl.getPlayerType();
    }

    public void cJO() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khc);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khc, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.kfP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.kgs instanceof n) || ((n) this.kgs).cKb() == null) {
            return "";
        }
        return ((n) this.kgs).kho ? "v_mid_page" : ((n) this.kgs).cKb().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i u(Uri uri) {
        String uri2;
        if (this.kgo != null) {
            return this.kgo;
        }
        if (!StringUtils.isNull(this.kgD)) {
            uri2 = this.kgD;
        } else if (eFt != null && this.kgs != null && !StringUtils.isNull(this.kgs.cJv())) {
            uri2 = this.kgs.cJv();
        } else {
            uri2 = (eFt == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && eFt != null) {
            this.kgo = eFt.ap(this.ahL, uri2, this.kgq);
        }
        this.kgq = null;
        this.kgG = 0L;
        return this.kgo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJP() {
        return this.kgl != null && this.kgl.getDuration() >= this.kgl.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.kgo, j, j2, j3, j4);
    }

    public static boolean vN(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cJQ() {
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
            this.kgJ = true;
            if (!cJS()) {
                aVar.cKx();
            }
            if (!cJR()) {
                aVar.cKy();
                this.kgr = true;
                setVideoPath(this.kgE, this.ahL);
                return;
            }
        } else {
            this.kgJ = false;
        }
        start();
        if (this.kgl != null && this.kgJ) {
            this.kgt.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJR() {
        return this == TbVideoViewSet.cKw().IM(this.kgE);
    }

    private boolean cJS() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.evE = null;
        this.emA = null;
        this.evH = null;
        this.eFu = null;
        this.eFy = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kgJ = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kgm = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.kgl != null) {
            return this.kgl.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.kgl != null ? this.kgl.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kgo != null) {
            this.kgo.e(j, j2, j3);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.kgn = cVar;
    }
}
