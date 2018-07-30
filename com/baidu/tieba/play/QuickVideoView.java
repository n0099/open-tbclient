package com.baidu.tieba.play;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static int gfT = 0;
    private static int gfU = 1;
    private static int gfV = 2;
    private static int gfW = 1;
    private static int gfX = 0;
    private static h gfx;
    private static com.baidu.tieba.j.l gfy;
    private Map<String, String> EY;
    private String aWq;
    private g.b bdd;
    private b bdh;
    private g.a bjG;
    private g.f bjH;
    private g.c bjI;
    private g.e bjJ;
    private g.InterfaceC0219g bjK;
    private g.i bjL;
    private g.d bjM;
    private g.h bjN;
    private final CustomMessageListener bjT;
    private int bnU;
    private int fPS;
    private com.baidu.tieba.j.e gfA;
    private String gfB;
    private boolean gfC;
    private d gfD;
    private boolean gfE;
    private int gfF;
    private boolean gfG;
    private int gfH;
    private boolean gfI;
    private SurfaceTexture gfJ;
    private boolean gfK;
    private com.baidu.tieba.play.b.a gfL;
    private q gfM;
    private com.baidu.tieba.play.b.f gfN;
    private String gfO;
    private long gfP;
    private boolean gfQ;
    private long gfR;
    private long gfS;
    private int gfY;
    private int gfZ;
    private a gfa;
    private RenderView gfs;
    private String gft;
    private g gfu;
    private g.e gfv;
    private c gfw;
    private com.baidu.tieba.j.i gfz;
    private int gga;
    private int ggb;
    private int ggc;
    private int ggd;
    private Runnable gge;
    private Runnable ggf;
    private TextureView.SurfaceTextureListener ggg;
    private g.f ggh;
    private g.a ggi;
    private g.InterfaceC0219g ggj;
    private Runnable ggk;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bkd();
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
            gfx = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gfy = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gfK = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gfC = false;
        this.gfE = false;
        this.gfF = 0;
        this.gfG = false;
        this.gfH = -1;
        this.gfI = false;
        this.gfJ = null;
        this.gfK = true;
        this.gfR = 0L;
        this.gfS = 0L;
        this.fPS = gfX;
        this.gfY = 0;
        this.gfZ = 0;
        this.gga = -1;
        this.ggb = 0;
        this.ggc = 0;
        this.ggd = 0;
        this.bnU = 0;
        this.gge = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gfu, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ggf = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.iM(false);
                }
            }
        };
        this.ggg = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gfE) {
                    QuickVideoView.this.gfE = false;
                    if (QuickVideoView.this.gfu != null) {
                        QuickVideoView.this.gfu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfz.aVK();
                    }
                } else if (QuickVideoView.this.gfu != null && QuickVideoView.this.gfI) {
                    QuickVideoView.this.gfu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.gfH);
                    if (QuickVideoView.this.gfa != null) {
                        QuickVideoView.this.gfa.bkd();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfz.aVL();
                    }
                }
                QuickVideoView.this.gfJ = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkt();
                QuickVideoView.this.lv(false);
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.gfu.release();
                }
                if (!QuickVideoView.this.gfE) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.onStop();
                    }
                    if (QuickVideoView.this.bdh != null) {
                        QuickVideoView.this.bdh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfJ = null;
                if (QuickVideoView.this.gfz != null && QuickVideoView.this.gfz.qv(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gfz = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ggh = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkt();
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.onPrepared();
                }
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.pS(QuickVideoView.this.gfu.getPlayerType());
                }
                if (QuickVideoView.this.bjH != null) {
                    QuickVideoView.this.bjH.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfD != null) {
                    long j = 0;
                    if (QuickVideoView.this.gfu != null) {
                        j = QuickVideoView.this.gfu.getDuration();
                    }
                    QuickVideoView.this.gfD.cL(j);
                    QuickVideoView.this.bks();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfD.bkk();
                        QuickVideoView.this.bkv();
                    }
                }
                if (QuickVideoView.this.gfC) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gfs != null && gVar != null) {
                    QuickVideoView.this.gfs.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfF);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gft) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gft);
                }
                if (QuickVideoView.this.gfL != null && QuickVideoView.this.gfL.blc()) {
                    com.baidu.tieba.play.b.e.rL(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.ggi = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lv(true);
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.qu(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gfz = null;
                }
                if (!QuickVideoView.this.gfG || QuickVideoView.this.gfD == null) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.onCompletion();
                    }
                    QuickVideoView.this.gfC = false;
                    if (QuickVideoView.this.bjG != null) {
                        QuickVideoView.this.bjG.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfB = null;
                QuickVideoView.this.gfP = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfD.bke());
                QuickVideoView.this.start();
            }
        };
        this.bjI = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.U(i, i2, i3);
                QuickVideoView.this.bkt();
                if (QuickVideoView.this.gfD != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfQ = true;
                    x.bkW().aD(QuickVideoView.this.gfD.bke(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jE()) {
                    if (QuickVideoView.this.gfz != null) {
                        QuickVideoView.this.gfB = QuickVideoView.this.gfz.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfP, QuickVideoView.this.F(QuickVideoView.this.gfz.aVQ(), i3 + "", QuickVideoView.this.gfz.aVR()));
                        QuickVideoView.this.gfz = null;
                    }
                    QuickVideoView.this.gfP = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rJ(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rK(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bdd == null || QuickVideoView.this.bdd.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.ggj = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.gfQ) {
                    QuickVideoView.this.gfQ = false;
                    return;
                }
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.bkG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfD != null && z) {
                    QuickVideoView.this.gfD.onSeekComplete();
                }
                if (QuickVideoView.this.bjK != null) {
                    QuickVideoView.this.bjK.b(gVar);
                }
            }
        };
        this.bjJ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gfv != null) {
                    QuickVideoView.this.gfv.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gfF = i2;
                    if (QuickVideoView.this.gfs != null && gVar != null) {
                        QuickVideoView.this.gfs.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfF);
                    }
                }
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.a(i, i2, QuickVideoView.this.gfz);
                    return true;
                }
                return true;
            }
        };
        this.bjL = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.f(i, i2, str);
                }
            }
        };
        this.bjM = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.qw(str);
                }
            }
        };
        this.bjN = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfP = j;
                }
            }
        };
        this.ggk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfD != null && QuickVideoView.this.gfD.bkg() && QuickVideoView.this.gfD.bkh() && QuickVideoView.this.gfD.bki() && QuickVideoView.this.gfu != null) {
                    int PI = QuickVideoView.this.gfu.PI();
                    int currentPosition = QuickVideoView.this.gfu.getCurrentPosition();
                    int duration = QuickVideoView.this.gfu.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfR;
                    boolean z = currentPosition + PI < duration;
                    if (PI < QuickVideoView.this.gfD.bkj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfR = currentTimeMillis;
                        QuickVideoView.this.gfD.rG(0);
                    }
                    if (QuickVideoView.this.bku() && currentPosition == QuickVideoView.this.gfS && j > 500) {
                        QuickVideoView.this.gfR = currentTimeMillis;
                        QuickVideoView.this.gfD.rG(0);
                    }
                    QuickVideoView.this.gfS = currentPosition;
                    if (QuickVideoView.this.fPS == QuickVideoView.gfW) {
                        QuickVideoView.this.bkv();
                    }
                }
            }
        };
        this.bjT = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.bkm();
                    }
                    if (QuickVideoView.this.gfz != null) {
                        QuickVideoView.this.gfz.qt(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gfz = null;
                    }
                    QuickVideoView.this.bkt();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfC = false;
        this.gfE = false;
        this.gfF = 0;
        this.gfG = false;
        this.gfH = -1;
        this.gfI = false;
        this.gfJ = null;
        this.gfK = true;
        this.gfR = 0L;
        this.gfS = 0L;
        this.fPS = gfX;
        this.gfY = 0;
        this.gfZ = 0;
        this.gga = -1;
        this.ggb = 0;
        this.ggc = 0;
        this.ggd = 0;
        this.bnU = 0;
        this.gge = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gfu, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ggf = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.iM(false);
                }
            }
        };
        this.ggg = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gfE) {
                    QuickVideoView.this.gfE = false;
                    if (QuickVideoView.this.gfu != null) {
                        QuickVideoView.this.gfu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfz.aVK();
                    }
                } else if (QuickVideoView.this.gfu != null && QuickVideoView.this.gfI) {
                    QuickVideoView.this.gfu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.gfH);
                    if (QuickVideoView.this.gfa != null) {
                        QuickVideoView.this.gfa.bkd();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfz.aVL();
                    }
                }
                QuickVideoView.this.gfJ = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkt();
                QuickVideoView.this.lv(false);
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.gfu.release();
                }
                if (!QuickVideoView.this.gfE) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.onStop();
                    }
                    if (QuickVideoView.this.bdh != null) {
                        QuickVideoView.this.bdh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfJ = null;
                if (QuickVideoView.this.gfz != null && QuickVideoView.this.gfz.qv(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gfz = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ggh = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkt();
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.onPrepared();
                }
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.pS(QuickVideoView.this.gfu.getPlayerType());
                }
                if (QuickVideoView.this.bjH != null) {
                    QuickVideoView.this.bjH.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfD != null) {
                    long j = 0;
                    if (QuickVideoView.this.gfu != null) {
                        j = QuickVideoView.this.gfu.getDuration();
                    }
                    QuickVideoView.this.gfD.cL(j);
                    QuickVideoView.this.bks();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfD.bkk();
                        QuickVideoView.this.bkv();
                    }
                }
                if (QuickVideoView.this.gfC) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gfs != null && gVar != null) {
                    QuickVideoView.this.gfs.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfF);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gft) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gft);
                }
                if (QuickVideoView.this.gfL != null && QuickVideoView.this.gfL.blc()) {
                    com.baidu.tieba.play.b.e.rL(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.ggi = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lv(true);
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.qu(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gfz = null;
                }
                if (!QuickVideoView.this.gfG || QuickVideoView.this.gfD == null) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.onCompletion();
                    }
                    QuickVideoView.this.gfC = false;
                    if (QuickVideoView.this.bjG != null) {
                        QuickVideoView.this.bjG.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfB = null;
                QuickVideoView.this.gfP = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfD.bke());
                QuickVideoView.this.start();
            }
        };
        this.bjI = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.U(i, i2, i3);
                QuickVideoView.this.bkt();
                if (QuickVideoView.this.gfD != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfQ = true;
                    x.bkW().aD(QuickVideoView.this.gfD.bke(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jE()) {
                    if (QuickVideoView.this.gfz != null) {
                        QuickVideoView.this.gfB = QuickVideoView.this.gfz.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfP, QuickVideoView.this.F(QuickVideoView.this.gfz.aVQ(), i3 + "", QuickVideoView.this.gfz.aVR()));
                        QuickVideoView.this.gfz = null;
                    }
                    QuickVideoView.this.gfP = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rJ(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rK(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bdd == null || QuickVideoView.this.bdd.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.ggj = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.gfQ) {
                    QuickVideoView.this.gfQ = false;
                    return;
                }
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.bkG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfD != null && z) {
                    QuickVideoView.this.gfD.onSeekComplete();
                }
                if (QuickVideoView.this.bjK != null) {
                    QuickVideoView.this.bjK.b(gVar);
                }
            }
        };
        this.bjJ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gfv != null) {
                    QuickVideoView.this.gfv.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gfF = i2;
                    if (QuickVideoView.this.gfs != null && gVar != null) {
                        QuickVideoView.this.gfs.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfF);
                    }
                }
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.a(i, i2, QuickVideoView.this.gfz);
                    return true;
                }
                return true;
            }
        };
        this.bjL = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.f(i, i2, str);
                }
            }
        };
        this.bjM = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.qw(str);
                }
            }
        };
        this.bjN = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfP = j;
                }
            }
        };
        this.ggk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfD != null && QuickVideoView.this.gfD.bkg() && QuickVideoView.this.gfD.bkh() && QuickVideoView.this.gfD.bki() && QuickVideoView.this.gfu != null) {
                    int PI = QuickVideoView.this.gfu.PI();
                    int currentPosition = QuickVideoView.this.gfu.getCurrentPosition();
                    int duration = QuickVideoView.this.gfu.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfR;
                    boolean z = currentPosition + PI < duration;
                    if (PI < QuickVideoView.this.gfD.bkj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfR = currentTimeMillis;
                        QuickVideoView.this.gfD.rG(0);
                    }
                    if (QuickVideoView.this.bku() && currentPosition == QuickVideoView.this.gfS && j > 500) {
                        QuickVideoView.this.gfR = currentTimeMillis;
                        QuickVideoView.this.gfD.rG(0);
                    }
                    QuickVideoView.this.gfS = currentPosition;
                    if (QuickVideoView.this.fPS == QuickVideoView.gfW) {
                        QuickVideoView.this.bkv();
                    }
                }
            }
        };
        this.bjT = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.bkm();
                    }
                    if (QuickVideoView.this.gfz != null) {
                        QuickVideoView.this.gfz.qt(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gfz = null;
                    }
                    QuickVideoView.this.bkt();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfC = false;
        this.gfE = false;
        this.gfF = 0;
        this.gfG = false;
        this.gfH = -1;
        this.gfI = false;
        this.gfJ = null;
        this.gfK = true;
        this.gfR = 0L;
        this.gfS = 0L;
        this.fPS = gfX;
        this.gfY = 0;
        this.gfZ = 0;
        this.gga = -1;
        this.ggb = 0;
        this.ggc = 0;
        this.ggd = 0;
        this.bnU = 0;
        this.gge = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gfu, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ggf = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.iM(false);
                }
            }
        };
        this.ggg = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gfE) {
                    QuickVideoView.this.gfE = false;
                    if (QuickVideoView.this.gfu != null) {
                        QuickVideoView.this.gfu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfz.aVK();
                    }
                } else if (QuickVideoView.this.gfu != null && QuickVideoView.this.gfI) {
                    QuickVideoView.this.gfu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.gfH);
                    if (QuickVideoView.this.gfa != null) {
                        QuickVideoView.this.gfa.bkd();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfz.aVL();
                    }
                }
                QuickVideoView.this.gfJ = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkt();
                QuickVideoView.this.lv(false);
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.gfu.release();
                }
                if (!QuickVideoView.this.gfE) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.onStop();
                    }
                    if (QuickVideoView.this.bdh != null) {
                        QuickVideoView.this.bdh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfJ = null;
                if (QuickVideoView.this.gfz != null && QuickVideoView.this.gfz.qv(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gfz = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ggh = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkt();
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.onPrepared();
                }
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.pS(QuickVideoView.this.gfu.getPlayerType());
                }
                if (QuickVideoView.this.bjH != null) {
                    QuickVideoView.this.bjH.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfD != null) {
                    long j = 0;
                    if (QuickVideoView.this.gfu != null) {
                        j = QuickVideoView.this.gfu.getDuration();
                    }
                    QuickVideoView.this.gfD.cL(j);
                    QuickVideoView.this.bks();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfD.bkk();
                        QuickVideoView.this.bkv();
                    }
                }
                if (QuickVideoView.this.gfC) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gfs != null && gVar != null) {
                    QuickVideoView.this.gfs.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfF);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gft) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gft);
                }
                if (QuickVideoView.this.gfL != null && QuickVideoView.this.gfL.blc()) {
                    com.baidu.tieba.play.b.e.rL(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.ggi = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lv(true);
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.qu(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gfz = null;
                }
                if (!QuickVideoView.this.gfG || QuickVideoView.this.gfD == null) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.onCompletion();
                    }
                    QuickVideoView.this.gfC = false;
                    if (QuickVideoView.this.bjG != null) {
                        QuickVideoView.this.bjG.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfB = null;
                QuickVideoView.this.gfP = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfD.bke());
                QuickVideoView.this.start();
            }
        };
        this.bjI = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.U(i2, i22, i3);
                QuickVideoView.this.bkt();
                if (QuickVideoView.this.gfD != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfQ = true;
                    x.bkW().aD(QuickVideoView.this.gfD.bke(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jE()) {
                    if (QuickVideoView.this.gfz != null) {
                        QuickVideoView.this.gfB = QuickVideoView.this.gfz.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfP, QuickVideoView.this.F(QuickVideoView.this.gfz.aVQ(), i3 + "", QuickVideoView.this.gfz.aVR()));
                        QuickVideoView.this.gfz = null;
                    }
                    QuickVideoView.this.gfP = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.rJ(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rK(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bdd == null || QuickVideoView.this.bdd.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.ggj = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.gfQ) {
                    QuickVideoView.this.gfQ = false;
                    return;
                }
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.bkG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfD != null && z) {
                    QuickVideoView.this.gfD.onSeekComplete();
                }
                if (QuickVideoView.this.bjK != null) {
                    QuickVideoView.this.bjK.b(gVar);
                }
            }
        };
        this.bjJ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gfv != null) {
                    QuickVideoView.this.gfv.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gfF = i22;
                    if (QuickVideoView.this.gfs != null && gVar != null) {
                        QuickVideoView.this.gfs.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfF);
                    }
                }
                if (QuickVideoView.this.gfM != null) {
                    QuickVideoView.this.gfM.a(i2, i22, QuickVideoView.this.gfz);
                    return true;
                }
                return true;
            }
        };
        this.bjL = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.f(i2, i22, str);
                }
            }
        };
        this.bjM = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gfz != null) {
                    QuickVideoView.this.gfz.qw(str);
                }
            }
        };
        this.bjN = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfP = j;
                }
            }
        };
        this.ggk = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfD != null && QuickVideoView.this.gfD.bkg() && QuickVideoView.this.gfD.bkh() && QuickVideoView.this.gfD.bki() && QuickVideoView.this.gfu != null) {
                    int PI = QuickVideoView.this.gfu.PI();
                    int currentPosition = QuickVideoView.this.gfu.getCurrentPosition();
                    int duration = QuickVideoView.this.gfu.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfR;
                    boolean z = currentPosition + PI < duration;
                    if (PI < QuickVideoView.this.gfD.bkj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfR = currentTimeMillis;
                        QuickVideoView.this.gfD.rG(0);
                    }
                    if (QuickVideoView.this.bku() && currentPosition == QuickVideoView.this.gfS && j > 500) {
                        QuickVideoView.this.gfR = currentTimeMillis;
                        QuickVideoView.this.gfD.rG(0);
                    }
                    QuickVideoView.this.gfS = currentPosition;
                    if (QuickVideoView.this.fPS == QuickVideoView.gfW) {
                        QuickVideoView.this.bkv();
                    }
                }
            }
        };
        this.bjT = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfD != null) {
                        QuickVideoView.this.gfD.bkm();
                    }
                    if (QuickVideoView.this.gfz != null) {
                        QuickVideoView.this.gfz.qt(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gfz = null;
                    }
                    QuickVideoView.this.bkt();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gfs = new RenderView(context);
        this.gfs.setSurfaceTextureListener(this.ggg);
        if (gfx != null) {
            this.gfu = gfx.PJ();
        }
        if (this.gfu != null) {
            this.gfu.setOnPreparedListener(this.ggh);
            this.gfu.setOnCompletionListener(this.ggi);
            this.gfu.a(this.bjI);
            this.gfu.setOnSeekCompleteListener(this.ggj);
            this.gfu.a(this.bjJ);
            this.gfu.a(this.bjL);
            this.gfu.a(this.bjM);
            this.gfu.a(this.bjN);
        }
        am.j(this, d.C0140d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(ARResourceKey.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gfL = new com.baidu.tieba.play.b.a(this);
        this.gfM = new q();
        this.gfN = new com.baidu.tieba.play.b.f();
    }

    public void setVideoPath(String str, String str2) {
        this.aWq = str2;
        if (this.gfL != null) {
            this.gfL.clear();
            this.gfL.blc();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.sj(str2);
            if (gfy != null) {
                this.gfz = gfy.E(this.aWq, str, "");
                if (this.gfz != null) {
                    this.gfz.a(-300, -44399, -44399, getLocateSource(), false, this.gfP, "");
                    this.gfz = null;
                }
            }
        }
        if (this.gfA != null) {
            this.gfA.a(null);
            this.gfA.aVD();
            this.gfA = null;
        }
        this.gfB = null;
        this.gfP = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (!ap.isEmpty(str)) {
            if (com.baidu.tieba.video.g.bAi().bAj()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    str = str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                } else if (str.contains("http:")) {
                    str = str.replace("http:", "https:");
                }
            }
            this.gfO = str;
            if (this.gfD != null) {
                str = this.gfD.ir(str);
                if (this.gfD.bkl() != null) {
                    this.gfD.bkl().setPlayer(this);
                }
                if (gfy != null && fY(str)) {
                    this.gfA = gfy.qy(str);
                }
                if (this.gfA != null) {
                    this.gfA.a(new com.baidu.tieba.play.monitor.a(this.aWq, this.gfO, this.gfz));
                    this.gfA.aVC();
                }
                sb(str);
            }
            if (!com.baidu.adp.lib.util.j.jE() && !fY(str)) {
                if (this.bdd != null) {
                    this.bdd.onError(this.gfu, -10000, -10000);
                    return;
                }
                return;
            }
            bkq();
            setVideoURI(Uri.parse(str));
            if (f(Uri.parse(str)) != null) {
                this.gfz.aVJ();
            }
            if (this.gfz != null) {
                this.gfz.aVP();
                this.gfz = null;
            }
        }
    }

    private void bkq() {
        if (com.baidu.tbadk.coreExtra.model.f.Fm()) {
            if (this.gfD != null && (this.gfD.bkf() || this.gfD.bkg())) {
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.gge);
                com.baidu.adp.lib.g.e.in().postDelayed(this.gge, com.baidu.tbadk.coreExtra.model.f.Fl());
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggf);
            com.baidu.adp.lib.g.e.in().postDelayed(this.ggf, com.baidu.tbadk.coreExtra.model.f.Fk());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.gfz.qs(uri.toString());
        }
        bkr();
        this.gfE = true;
        this.mUri = uri;
        this.EY = map;
        this.gfF = 0;
        removeView(this.gfs);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gfK) {
            addView(this.gfs, layoutParams);
        } else {
            addView(this.gfs, 0, layoutParams);
        }
        am.j(this, d.C0140d.cp_bg_line_k);
    }

    private void bkr() {
        this.gfE = false;
        this.gfC = false;
        if (this.gfu != null) {
            this.gfu.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggk);
    }

    private void sb(String str) {
        this.gfZ = 0;
        this.gga = 0;
        this.ggb = 0;
        this.ggc = 0;
        this.ggd = 0;
        this.bnU = 0;
        if (this.gfD.bkg()) {
            this.gfY = gfU;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gga = (int) t.sd(QuickVideoView.this.gfO);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gfO != null && this.gfO.equals(str)) {
            this.gfY = gfT;
        } else {
            this.gfY = gfV;
        }
        this.fPS = gfW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bks() {
        this.fPS = gfW;
        if (this.gfu != null) {
            this.gfZ = this.gfu.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(boolean z) {
        if (this.fPS == gfW && this.gfu != null) {
            this.fPS = gfX;
            this.ggc = this.gfu.getDuration();
            if (z) {
                this.ggd = 0;
                this.ggb = this.ggc;
            } else {
                this.ggb = this.gfu.getCurrentPosition();
                this.ggd = this.gfu.getCachedSize();
            }
            if (this.ggb > 0) {
                if (this.gfY == gfT) {
                    this.gga = (int) t.sd(this.gfO);
                    if (this.gfZ > 0) {
                        long j = (this.gfZ * (this.ggb / 1000)) / 8;
                        if (this.ggd < 0) {
                            this.ggd = 0;
                        }
                        long j2 = this.ggd + j;
                        if (this.gga > 0) {
                            j2 += this.gga;
                        }
                        setFlowCount(j2, this.ggb, this.ggc, this.bnU);
                    } else if (this.gfZ == -1) {
                        this.gfZ = 603327;
                        setFlowCount((this.gfZ * (this.ggb / 1000)) / 8, this.ggb, this.ggc, this.bnU);
                    }
                } else if (this.gfY == gfU) {
                    if (this.gfZ > 0) {
                        long j3 = (this.gfZ * (this.ggb / 1000)) / 8;
                        if (this.ggd < 0) {
                            this.ggd = 0;
                        }
                        long j4 = this.ggd + j3;
                        if (this.gga > 0) {
                            j4 -= this.gga;
                        }
                        setFlowCount(j4, this.ggb, this.ggc, this.bnU);
                    } else if (this.gfZ == -1) {
                        this.gfZ = 603327;
                        setFlowCount((this.gfZ * (this.ggb / 1000)) / 8, this.ggb, this.ggc, this.bnU);
                    }
                } else {
                    setFlowCount(0L, this.ggb, this.ggc, this.bnU);
                }
            }
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggk);
    }

    public void stopPlayback() {
        bkt();
        lv(false);
        if (this.gfL != null) {
            this.gfL.clear();
        }
        this.gft = null;
        bkr();
        this.gfG = false;
        if (this.gfD != null) {
            this.gfD.onStop();
        }
        com.baidu.tieba.play.a.b.bkZ().a((b.InterfaceC0216b) null);
        if (this.gfz != null && this.gfz.qv(getLocateSource())) {
            this.gfz = null;
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkt() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gge);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggf);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bjH = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bjG = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bdd = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0219g interfaceC0219g) {
        this.bjK = interfaceC0219g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F(String str, String str2, String str3) {
        if (this.gfN == null) {
            return "";
        }
        String ble = this.gfN.ble();
        this.gfN.G(str, str2, str3);
        return ble;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gfD != null && !StringUtils.isNull(this.gfD.bke())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.si(uri);
            }
            this.mUri = Uri.parse(this.gfD.bke());
        }
        boolean z = false;
        if (this.gfL != null) {
            z = this.gfL.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gfz != null) {
            this.gfB = this.gfz.a(i, i2, i3, getLocateSource(), z, this.gfP, F(this.gfz.aVQ(), i3 + "", this.gfz.aVR()));
            this.gfz = null;
        }
        this.gfP = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gfu != null) {
            try {
                this.gfu.release();
                this.gft = str;
                URI uri = new URI(this.mUri.toString());
                this.gfu.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.EY, this.gfJ, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.gfz.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gfu != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gfu.release();
            this.gfu.a(this.mContext, this.mUri, this.EY, this.gfJ, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.gfz.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gfu != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gfu.forceUseSystemMediaPlayer(true);
            }
            this.gfu.release();
            this.gfu.a(this.mContext, this.mUri, this.EY, this.gfJ, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.gfz.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gfC = true;
        if (this.gfu != null) {
            if (this.gfJ != null && this.gfI && !this.gfu.isExistInRemote()) {
                this.gfu.a(this.mContext, this.mUri, this.EY, this.gfJ, this.gfH);
                if (this.gfa != null) {
                    this.gfa.bkd();
                }
                if (f(this.mUri) != null) {
                    this.gfz.aVL();
                }
                bkq();
                return;
            }
            this.gfu.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gfD != null) {
            this.gfD.onStart();
        }
        if (this.gfw != null) {
            this.gfw.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.gfz.pT(this.gfu.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bkt();
        if (this.gfu != null) {
            this.gfu.pause();
        }
        if (this.gfD != null) {
            this.gfD.onPause();
        }
        this.gfC = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gfz != null) {
            this.gfz.aVO();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gfu != null) {
            return this.gfu.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gfu != null) {
            return this.gfu.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bnU = i;
        rH(i);
    }

    public void rH(int i) {
        if (this.gfM != null) {
            this.gfM.bkF();
        }
        if (this.gfu != null) {
            this.gfu.seekTo(i);
        }
        if (this.gfD != null) {
            this.gfD.rG(0);
            bkv();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gfu != null) {
            return this.gfu.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gfu != null) {
            this.gfu.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gfH = i;
    }

    public int getRecoveryState() {
        return this.gfH;
    }

    public void setNeedRecovery(boolean z) {
        this.gfI = z;
    }

    public void setLooping(boolean z) {
        this.gfG = z;
    }

    public boolean bku() {
        return this.gfC;
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
        this.bdh = bVar;
    }

    public void setBusiness(d dVar) {
        this.gfD = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bjT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gfG = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gfu != null) {
            this.gfu.Lt();
        }
        if (this.gfM != null) {
            this.gfM.bkH();
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggk);
        MessageManager.getInstance().unRegisterListener(this.bjT);
        if (this.gfL != null) {
            this.gfL.clear();
        }
        if (this.gfA != null) {
            this.gfA.a(null);
            this.gfA.aVD();
        }
    }

    public g getPlayer() {
        return this.gfu;
    }

    public int getPlayerType() {
        if (this.gfu == null) {
            return -300;
        }
        return this.gfu.getPlayerType();
    }

    public void bkv() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggk);
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggk, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gfa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gfD instanceof n) || ((n) this.gfD).bkD() == null) ? "" : ((n) this.gfD).bkD().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.gfz != null) {
            return this.gfz;
        }
        if (!StringUtils.isNull(this.gfO)) {
            uri2 = this.gfO;
        } else if (gfy != null && this.gfD != null && !StringUtils.isNull(this.gfD.bke())) {
            uri2 = this.gfD.bke();
        } else {
            uri2 = (gfy == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gfy != null) {
            this.gfz = gfy.E(this.aWq, uri2, this.gfB);
        }
        this.gfB = null;
        this.gfP = 0L;
        return this.gfz;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gfz, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gfz, j);
    }

    public static boolean fY(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gfv = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gfu != null) {
            return this.gfu.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gfu != null ? this.gfu.getId() : "";
    }

    public void setVideoStatusListener(c cVar) {
        this.gfw = cVar;
    }
}
