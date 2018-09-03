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
import com.baidu.tieba.f;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static int gfS = 0;
    private static int gfT = 1;
    private static int gfU = 2;
    private static int gfV = 1;
    private static int gfW = 0;
    private static h gfw;
    private static com.baidu.tieba.j.l gfx;
    private Map<String, String> EY;
    private String aWq;
    private g.b bdd;
    private b bdh;
    private g.a bjM;
    private g.f bjN;
    private g.c bjO;
    private g.e bjP;
    private g.InterfaceC0219g bjQ;
    private g.i bjR;
    private g.d bjS;
    private g.h bjT;
    private final CustomMessageListener bjZ;
    private int bnW;
    private int fPK;
    private a geZ;
    private String gfA;
    private boolean gfB;
    private d gfC;
    private boolean gfD;
    private int gfE;
    private boolean gfF;
    private int gfG;
    private boolean gfH;
    private SurfaceTexture gfI;
    private boolean gfJ;
    private com.baidu.tieba.play.b.a gfK;
    private q gfL;
    private com.baidu.tieba.play.b.f gfM;
    private String gfN;
    private long gfO;
    private boolean gfP;
    private long gfQ;
    private long gfR;
    private int gfX;
    private int gfY;
    private int gfZ;
    private RenderView gfr;
    private String gfs;
    private g gft;
    private g.e gfu;
    private c gfv;
    private com.baidu.tieba.j.i gfy;
    private com.baidu.tieba.j.e gfz;
    private int gga;
    private int ggb;
    private int ggc;
    private Runnable ggd;
    private Runnable gge;
    private TextureView.SurfaceTextureListener ggf;
    private g.f ggg;
    private g.a ggh;
    private g.InterfaceC0219g ggi;
    private Runnable ggj;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bka();
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
            gfw = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gfx = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gfJ = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gfB = false;
        this.gfD = false;
        this.gfE = 0;
        this.gfF = false;
        this.gfG = -1;
        this.gfH = false;
        this.gfI = null;
        this.gfJ = true;
        this.gfQ = 0L;
        this.gfR = 0L;
        this.fPK = gfW;
        this.gfX = 0;
        this.gfY = 0;
        this.gfZ = -1;
        this.gga = 0;
        this.ggb = 0;
        this.ggc = 0;
        this.bnW = 0;
        this.ggd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gft != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gft, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gge = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.iM(false);
                }
            }
        };
        this.ggf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gfD) {
                    QuickVideoView.this.gfD = false;
                    if (QuickVideoView.this.gft != null) {
                        QuickVideoView.this.gft.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfy.aVG();
                    }
                } else if (QuickVideoView.this.gft != null && QuickVideoView.this.gfH) {
                    QuickVideoView.this.gft.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.gfG);
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.geZ.bka();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfy.aVH();
                    }
                }
                QuickVideoView.this.gfI = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkq();
                QuickVideoView.this.lv(false);
                if (QuickVideoView.this.gft != null) {
                    QuickVideoView.this.gft.release();
                }
                if (!QuickVideoView.this.gfD) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.onStop();
                    }
                    if (QuickVideoView.this.bdh != null) {
                        QuickVideoView.this.bdh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfI = null;
                if (QuickVideoView.this.gfy != null && QuickVideoView.this.gfy.qx(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gfy = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ggg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkq();
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.onPrepared();
                }
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.pS(QuickVideoView.this.gft.getPlayerType());
                }
                if (QuickVideoView.this.bjN != null) {
                    QuickVideoView.this.bjN.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfC != null) {
                    long j = 0;
                    if (QuickVideoView.this.gft != null) {
                        j = QuickVideoView.this.gft.getDuration();
                    }
                    QuickVideoView.this.gfC.cL(j);
                    QuickVideoView.this.bkp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfC.bkh();
                        QuickVideoView.this.bks();
                    }
                }
                if (QuickVideoView.this.gfB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gfr != null && gVar != null) {
                    QuickVideoView.this.gfr.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gfs) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gfs);
                }
                if (QuickVideoView.this.gfK != null && QuickVideoView.this.gfK.bkZ()) {
                    com.baidu.tieba.play.b.e.rL(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.ggh = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lv(true);
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.qw(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gfy = null;
                }
                if (!QuickVideoView.this.gfF || QuickVideoView.this.gfC == null) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.onCompletion();
                    }
                    QuickVideoView.this.gfB = false;
                    if (QuickVideoView.this.bjM != null) {
                        QuickVideoView.this.bjM.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfA = null;
                QuickVideoView.this.gfO = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfC.bkb());
                QuickVideoView.this.start();
            }
        };
        this.bjO = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.U(i, i2, i3);
                QuickVideoView.this.bkq();
                if (QuickVideoView.this.gfC != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfP = true;
                    x.bkT().aD(QuickVideoView.this.gfC.bkb(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jE()) {
                    if (QuickVideoView.this.gfy != null) {
                        QuickVideoView.this.gfA = QuickVideoView.this.gfy.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfO, QuickVideoView.this.F(QuickVideoView.this.gfy.aVM(), i3 + "", QuickVideoView.this.gfy.aVN()));
                        QuickVideoView.this.gfy = null;
                    }
                    QuickVideoView.this.gfO = 0L;
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
        this.ggi = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.gfP) {
                    QuickVideoView.this.gfP = false;
                    return;
                }
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.bkD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfC != null && z) {
                    QuickVideoView.this.gfC.onSeekComplete();
                }
                if (QuickVideoView.this.bjQ != null) {
                    QuickVideoView.this.bjQ.b(gVar);
                }
            }
        };
        this.bjP = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.gfu.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gfE = i2;
                    if (QuickVideoView.this.gfr != null && gVar != null) {
                        QuickVideoView.this.gfr.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfE);
                    }
                }
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.a(i, i2, QuickVideoView.this.gfy);
                    return true;
                }
                return true;
            }
        };
        this.bjR = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.f(i, i2, str);
                }
            }
        };
        this.bjS = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.qy(str);
                }
            }
        };
        this.bjT = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfO = j;
                }
            }
        };
        this.ggj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfC != null && QuickVideoView.this.gfC.bkd() && QuickVideoView.this.gfC.bke() && QuickVideoView.this.gfC.bkf() && QuickVideoView.this.gft != null) {
                    int PO = QuickVideoView.this.gft.PO();
                    int currentPosition = QuickVideoView.this.gft.getCurrentPosition();
                    int duration = QuickVideoView.this.gft.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfQ;
                    boolean z = currentPosition + PO < duration;
                    if (PO < QuickVideoView.this.gfC.bkg() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfQ = currentTimeMillis;
                        QuickVideoView.this.gfC.rG(0);
                    }
                    if (QuickVideoView.this.bkr() && currentPosition == QuickVideoView.this.gfR && j > 500) {
                        QuickVideoView.this.gfQ = currentTimeMillis;
                        QuickVideoView.this.gfC.rG(0);
                    }
                    QuickVideoView.this.gfR = currentPosition;
                    if (QuickVideoView.this.fPK == QuickVideoView.gfV) {
                        QuickVideoView.this.bks();
                    }
                }
            }
        };
        this.bjZ = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.bkj();
                    }
                    if (QuickVideoView.this.gfy != null) {
                        QuickVideoView.this.gfy.qv(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gfy = null;
                    }
                    QuickVideoView.this.bkq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfB = false;
        this.gfD = false;
        this.gfE = 0;
        this.gfF = false;
        this.gfG = -1;
        this.gfH = false;
        this.gfI = null;
        this.gfJ = true;
        this.gfQ = 0L;
        this.gfR = 0L;
        this.fPK = gfW;
        this.gfX = 0;
        this.gfY = 0;
        this.gfZ = -1;
        this.gga = 0;
        this.ggb = 0;
        this.ggc = 0;
        this.bnW = 0;
        this.ggd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gft != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gft, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gge = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.iM(false);
                }
            }
        };
        this.ggf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gfD) {
                    QuickVideoView.this.gfD = false;
                    if (QuickVideoView.this.gft != null) {
                        QuickVideoView.this.gft.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfy.aVG();
                    }
                } else if (QuickVideoView.this.gft != null && QuickVideoView.this.gfH) {
                    QuickVideoView.this.gft.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.gfG);
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.geZ.bka();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfy.aVH();
                    }
                }
                QuickVideoView.this.gfI = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkq();
                QuickVideoView.this.lv(false);
                if (QuickVideoView.this.gft != null) {
                    QuickVideoView.this.gft.release();
                }
                if (!QuickVideoView.this.gfD) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.onStop();
                    }
                    if (QuickVideoView.this.bdh != null) {
                        QuickVideoView.this.bdh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfI = null;
                if (QuickVideoView.this.gfy != null && QuickVideoView.this.gfy.qx(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gfy = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ggg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkq();
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.onPrepared();
                }
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.pS(QuickVideoView.this.gft.getPlayerType());
                }
                if (QuickVideoView.this.bjN != null) {
                    QuickVideoView.this.bjN.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfC != null) {
                    long j = 0;
                    if (QuickVideoView.this.gft != null) {
                        j = QuickVideoView.this.gft.getDuration();
                    }
                    QuickVideoView.this.gfC.cL(j);
                    QuickVideoView.this.bkp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfC.bkh();
                        QuickVideoView.this.bks();
                    }
                }
                if (QuickVideoView.this.gfB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gfr != null && gVar != null) {
                    QuickVideoView.this.gfr.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gfs) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gfs);
                }
                if (QuickVideoView.this.gfK != null && QuickVideoView.this.gfK.bkZ()) {
                    com.baidu.tieba.play.b.e.rL(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.ggh = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lv(true);
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.qw(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gfy = null;
                }
                if (!QuickVideoView.this.gfF || QuickVideoView.this.gfC == null) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.onCompletion();
                    }
                    QuickVideoView.this.gfB = false;
                    if (QuickVideoView.this.bjM != null) {
                        QuickVideoView.this.bjM.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfA = null;
                QuickVideoView.this.gfO = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfC.bkb());
                QuickVideoView.this.start();
            }
        };
        this.bjO = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.U(i, i2, i3);
                QuickVideoView.this.bkq();
                if (QuickVideoView.this.gfC != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfP = true;
                    x.bkT().aD(QuickVideoView.this.gfC.bkb(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jE()) {
                    if (QuickVideoView.this.gfy != null) {
                        QuickVideoView.this.gfA = QuickVideoView.this.gfy.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfO, QuickVideoView.this.F(QuickVideoView.this.gfy.aVM(), i3 + "", QuickVideoView.this.gfy.aVN()));
                        QuickVideoView.this.gfy = null;
                    }
                    QuickVideoView.this.gfO = 0L;
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
        this.ggi = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.gfP) {
                    QuickVideoView.this.gfP = false;
                    return;
                }
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.bkD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfC != null && z) {
                    QuickVideoView.this.gfC.onSeekComplete();
                }
                if (QuickVideoView.this.bjQ != null) {
                    QuickVideoView.this.bjQ.b(gVar);
                }
            }
        };
        this.bjP = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.gfu.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gfE = i2;
                    if (QuickVideoView.this.gfr != null && gVar != null) {
                        QuickVideoView.this.gfr.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfE);
                    }
                }
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.a(i, i2, QuickVideoView.this.gfy);
                    return true;
                }
                return true;
            }
        };
        this.bjR = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.f(i, i2, str);
                }
            }
        };
        this.bjS = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.qy(str);
                }
            }
        };
        this.bjT = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfO = j;
                }
            }
        };
        this.ggj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfC != null && QuickVideoView.this.gfC.bkd() && QuickVideoView.this.gfC.bke() && QuickVideoView.this.gfC.bkf() && QuickVideoView.this.gft != null) {
                    int PO = QuickVideoView.this.gft.PO();
                    int currentPosition = QuickVideoView.this.gft.getCurrentPosition();
                    int duration = QuickVideoView.this.gft.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfQ;
                    boolean z = currentPosition + PO < duration;
                    if (PO < QuickVideoView.this.gfC.bkg() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfQ = currentTimeMillis;
                        QuickVideoView.this.gfC.rG(0);
                    }
                    if (QuickVideoView.this.bkr() && currentPosition == QuickVideoView.this.gfR && j > 500) {
                        QuickVideoView.this.gfQ = currentTimeMillis;
                        QuickVideoView.this.gfC.rG(0);
                    }
                    QuickVideoView.this.gfR = currentPosition;
                    if (QuickVideoView.this.fPK == QuickVideoView.gfV) {
                        QuickVideoView.this.bks();
                    }
                }
            }
        };
        this.bjZ = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.bkj();
                    }
                    if (QuickVideoView.this.gfy != null) {
                        QuickVideoView.this.gfy.qv(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gfy = null;
                    }
                    QuickVideoView.this.bkq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfB = false;
        this.gfD = false;
        this.gfE = 0;
        this.gfF = false;
        this.gfG = -1;
        this.gfH = false;
        this.gfI = null;
        this.gfJ = true;
        this.gfQ = 0L;
        this.gfR = 0L;
        this.fPK = gfW;
        this.gfX = 0;
        this.gfY = 0;
        this.gfZ = -1;
        this.gga = 0;
        this.ggb = 0;
        this.ggc = 0;
        this.bnW = 0;
        this.ggd = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gft != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gft, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gge = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.iM(false);
                }
            }
        };
        this.ggf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gfD) {
                    QuickVideoView.this.gfD = false;
                    if (QuickVideoView.this.gft != null) {
                        QuickVideoView.this.gft.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfy.aVG();
                    }
                } else if (QuickVideoView.this.gft != null && QuickVideoView.this.gfH) {
                    QuickVideoView.this.gft.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EY, surfaceTexture, QuickVideoView.this.gfG);
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.geZ.bka();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gfy.aVH();
                    }
                }
                QuickVideoView.this.gfI = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkq();
                QuickVideoView.this.lv(false);
                if (QuickVideoView.this.gft != null) {
                    QuickVideoView.this.gft.release();
                }
                if (!QuickVideoView.this.gfD) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.onStop();
                    }
                    if (QuickVideoView.this.bdh != null) {
                        QuickVideoView.this.bdh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfI = null;
                if (QuickVideoView.this.gfy != null && QuickVideoView.this.gfy.qx(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gfy = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.ggg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkq();
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.onPrepared();
                }
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.pS(QuickVideoView.this.gft.getPlayerType());
                }
                if (QuickVideoView.this.bjN != null) {
                    QuickVideoView.this.bjN.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfC != null) {
                    long j = 0;
                    if (QuickVideoView.this.gft != null) {
                        j = QuickVideoView.this.gft.getDuration();
                    }
                    QuickVideoView.this.gfC.cL(j);
                    QuickVideoView.this.bkp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfC.bkh();
                        QuickVideoView.this.bks();
                    }
                }
                if (QuickVideoView.this.gfB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gfr != null && gVar != null) {
                    QuickVideoView.this.gfr.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gfs) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gfs);
                }
                if (QuickVideoView.this.gfK != null && QuickVideoView.this.gfK.bkZ()) {
                    com.baidu.tieba.play.b.e.rL(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.ggh = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lv(true);
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.qw(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gfy = null;
                }
                if (!QuickVideoView.this.gfF || QuickVideoView.this.gfC == null) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.onCompletion();
                    }
                    QuickVideoView.this.gfB = false;
                    if (QuickVideoView.this.bjM != null) {
                        QuickVideoView.this.bjM.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfA = null;
                QuickVideoView.this.gfO = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfC.bkb());
                QuickVideoView.this.start();
            }
        };
        this.bjO = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.U(i2, i22, i3);
                QuickVideoView.this.bkq();
                if (QuickVideoView.this.gfC != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfP = true;
                    x.bkT().aD(QuickVideoView.this.gfC.bkb(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jE()) {
                    if (QuickVideoView.this.gfy != null) {
                        QuickVideoView.this.gfA = QuickVideoView.this.gfy.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfO, QuickVideoView.this.F(QuickVideoView.this.gfy.aVM(), i3 + "", QuickVideoView.this.gfy.aVN()));
                        QuickVideoView.this.gfy = null;
                    }
                    QuickVideoView.this.gfO = 0L;
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
        this.ggi = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.gfP) {
                    QuickVideoView.this.gfP = false;
                    return;
                }
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.bkD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfC != null && z) {
                    QuickVideoView.this.gfC.onSeekComplete();
                }
                if (QuickVideoView.this.bjQ != null) {
                    QuickVideoView.this.bjQ.b(gVar);
                }
            }
        };
        this.bjP = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gfu != null) {
                    QuickVideoView.this.gfu.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gfE = i22;
                    if (QuickVideoView.this.gfr != null && gVar != null) {
                        QuickVideoView.this.gfr.T(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gfE);
                    }
                }
                if (QuickVideoView.this.gfL != null) {
                    QuickVideoView.this.gfL.a(i2, i22, QuickVideoView.this.gfy);
                    return true;
                }
                return true;
            }
        };
        this.bjR = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.f(i2, i22, str);
                }
            }
        };
        this.bjS = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gfy != null) {
                    QuickVideoView.this.gfy.qy(str);
                }
            }
        };
        this.bjT = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfO = j;
                }
            }
        };
        this.ggj = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfC != null && QuickVideoView.this.gfC.bkd() && QuickVideoView.this.gfC.bke() && QuickVideoView.this.gfC.bkf() && QuickVideoView.this.gft != null) {
                    int PO = QuickVideoView.this.gft.PO();
                    int currentPosition = QuickVideoView.this.gft.getCurrentPosition();
                    int duration = QuickVideoView.this.gft.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfQ;
                    boolean z = currentPosition + PO < duration;
                    if (PO < QuickVideoView.this.gfC.bkg() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfQ = currentTimeMillis;
                        QuickVideoView.this.gfC.rG(0);
                    }
                    if (QuickVideoView.this.bkr() && currentPosition == QuickVideoView.this.gfR && j > 500) {
                        QuickVideoView.this.gfQ = currentTimeMillis;
                        QuickVideoView.this.gfC.rG(0);
                    }
                    QuickVideoView.this.gfR = currentPosition;
                    if (QuickVideoView.this.fPK == QuickVideoView.gfV) {
                        QuickVideoView.this.bks();
                    }
                }
            }
        };
        this.bjZ = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfC != null) {
                        QuickVideoView.this.gfC.bkj();
                    }
                    if (QuickVideoView.this.gfy != null) {
                        QuickVideoView.this.gfy.qv(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gfy = null;
                    }
                    QuickVideoView.this.bkq();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gfr = new RenderView(context);
        this.gfr.setSurfaceTextureListener(this.ggf);
        if (gfw != null) {
            this.gft = gfw.PP();
        }
        if (this.gft != null) {
            this.gft.setOnPreparedListener(this.ggg);
            this.gft.setOnCompletionListener(this.ggh);
            this.gft.a(this.bjO);
            this.gft.setOnSeekCompleteListener(this.ggi);
            this.gft.a(this.bjP);
            this.gft.a(this.bjR);
            this.gft.a(this.bjS);
            this.gft.a(this.bjT);
        }
        am.j(this, f.d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(ARResourceKey.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gfK = new com.baidu.tieba.play.b.a(this);
        this.gfL = new q();
        this.gfM = new com.baidu.tieba.play.b.f();
    }

    public void setVideoPath(String str, String str2) {
        this.aWq = str2;
        if (this.gfK != null) {
            this.gfK.clear();
            this.gfK.bkZ();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.sm(str2);
            if (gfx != null) {
                this.gfy = gfx.E(this.aWq, str, "");
                if (this.gfy != null) {
                    this.gfy.a(-300, -44399, -44399, getLocateSource(), false, this.gfO, "");
                    this.gfy = null;
                }
            }
        }
        if (this.gfz != null) {
            this.gfz.a(null);
            this.gfz.aVz();
            this.gfz = null;
        }
        this.gfA = null;
        this.gfO = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (!ap.isEmpty(str)) {
            if (com.baidu.tieba.video.g.bAk().bAl()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    str = str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                } else if (str.contains("http:")) {
                    str = str.replace("http:", "https:");
                }
            }
            this.gfN = str;
            if (this.gfC != null) {
                str = this.gfC.is(str);
                if (this.gfC.bki() != null) {
                    this.gfC.bki().setPlayer(this);
                }
                if (gfx != null && fY(str)) {
                    this.gfz = gfx.qB(str);
                }
                if (this.gfz != null) {
                    this.gfz.a(new com.baidu.tieba.play.monitor.a(this.aWq, this.gfN, this.gfy));
                    this.gfz.aVy();
                }
                se(str);
            }
            if (!com.baidu.adp.lib.util.j.jE() && !fY(str)) {
                if (this.bdd != null) {
                    this.bdd.onError(this.gft, -10000, -10000);
                    return;
                }
                return;
            }
            bkn();
            setVideoURI(Uri.parse(str));
            if (f(Uri.parse(str)) != null) {
                this.gfy.aVF();
            }
            if (this.gfy != null) {
                this.gfy.aVL();
                this.gfy = null;
            }
        }
    }

    private void bkn() {
        if (com.baidu.tbadk.coreExtra.model.f.Fm()) {
            if (this.gfC != null && (this.gfC.bkc() || this.gfC.bkd())) {
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggd);
                com.baidu.adp.lib.g.e.in().postDelayed(this.ggd, com.baidu.tbadk.coreExtra.model.f.Fl());
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.gge);
            com.baidu.adp.lib.g.e.in().postDelayed(this.gge, com.baidu.tbadk.coreExtra.model.f.Fk());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.gfy.qu(uri.toString());
        }
        bko();
        this.gfD = true;
        this.mUri = uri;
        this.EY = map;
        this.gfE = 0;
        removeView(this.gfr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gfJ) {
            addView(this.gfr, layoutParams);
        } else {
            addView(this.gfr, 0, layoutParams);
        }
        am.j(this, f.d.cp_bg_line_k);
    }

    private void bko() {
        this.gfD = false;
        this.gfB = false;
        if (this.gft != null) {
            this.gft.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggj);
    }

    private void se(String str) {
        this.gfY = 0;
        this.gfZ = 0;
        this.gga = 0;
        this.ggb = 0;
        this.ggc = 0;
        this.bnW = 0;
        if (this.gfC.bkd()) {
            this.gfX = gfT;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gfZ = (int) t.sg(QuickVideoView.this.gfN);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gfN != null && this.gfN.equals(str)) {
            this.gfX = gfS;
        } else {
            this.gfX = gfU;
        }
        this.fPK = gfV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        this.fPK = gfV;
        if (this.gft != null) {
            this.gfY = this.gft.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(boolean z) {
        if (this.fPK == gfV && this.gft != null) {
            this.fPK = gfW;
            this.ggb = this.gft.getDuration();
            if (z) {
                this.ggc = 0;
                this.gga = this.ggb;
            } else {
                this.gga = this.gft.getCurrentPosition();
                this.ggc = this.gft.getCachedSize();
            }
            if (this.gga > 0) {
                if (this.gfX == gfS) {
                    this.gfZ = (int) t.sg(this.gfN);
                    if (this.gfY > 0) {
                        long j = (this.gfY * (this.gga / 1000)) / 8;
                        if (this.ggc < 0) {
                            this.ggc = 0;
                        }
                        long j2 = this.ggc + j;
                        if (this.gfZ > 0) {
                            j2 += this.gfZ;
                        }
                        setFlowCount(j2, this.gga, this.ggb, this.bnW);
                    } else if (this.gfY == -1) {
                        this.gfY = 603327;
                        setFlowCount((this.gfY * (this.gga / 1000)) / 8, this.gga, this.ggb, this.bnW);
                    }
                } else if (this.gfX == gfT) {
                    if (this.gfY > 0) {
                        long j3 = (this.gfY * (this.gga / 1000)) / 8;
                        if (this.ggc < 0) {
                            this.ggc = 0;
                        }
                        long j4 = this.ggc + j3;
                        if (this.gfZ > 0) {
                            j4 -= this.gfZ;
                        }
                        setFlowCount(j4, this.gga, this.ggb, this.bnW);
                    } else if (this.gfY == -1) {
                        this.gfY = 603327;
                        setFlowCount((this.gfY * (this.gga / 1000)) / 8, this.gga, this.ggb, this.bnW);
                    }
                } else {
                    setFlowCount(0L, this.gga, this.ggb, this.bnW);
                }
            }
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggj);
    }

    public void stopPlayback() {
        bkq();
        lv(false);
        if (this.gfK != null) {
            this.gfK.clear();
        }
        this.gfs = null;
        bko();
        this.gfF = false;
        if (this.gfC != null) {
            this.gfC.onStop();
        }
        com.baidu.tieba.play.a.b.bkW().a((b.InterfaceC0216b) null);
        if (this.gfy != null && this.gfy.qx(getLocateSource())) {
            this.gfy = null;
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkq() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggd);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gge);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bjN = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bjM = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bdd = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0219g interfaceC0219g) {
        this.bjQ = interfaceC0219g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F(String str, String str2, String str3) {
        if (this.gfM == null) {
            return "";
        }
        String blb = this.gfM.blb();
        this.gfM.G(str, str2, str3);
        return blb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gfC != null && !StringUtils.isNull(this.gfC.bkb())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.sl(uri);
            }
            this.mUri = Uri.parse(this.gfC.bkb());
        }
        boolean z = false;
        if (this.gfK != null) {
            z = this.gfK.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gfy != null) {
            this.gfA = this.gfy.a(i, i2, i3, getLocateSource(), z, this.gfO, F(this.gfy.aVM(), i3 + "", this.gfy.aVN()));
            this.gfy = null;
        }
        this.gfO = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gft != null) {
            try {
                this.gft.release();
                this.gfs = str;
                URI uri = new URI(this.mUri.toString());
                this.gft.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.EY, this.gfI, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.gfy.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gft != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gft.release();
            this.gft.a(this.mContext, this.mUri, this.EY, this.gfI, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.gfy.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gft != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gft.forceUseSystemMediaPlayer(true);
            }
            this.gft.release();
            this.gft.a(this.mContext, this.mUri, this.EY, this.gfI, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.gfy.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gfB = true;
        if (this.gft != null) {
            if (this.gfI != null && this.gfH && !this.gft.isExistInRemote()) {
                this.gft.a(this.mContext, this.mUri, this.EY, this.gfI, this.gfG);
                if (this.geZ != null) {
                    this.geZ.bka();
                }
                if (f(this.mUri) != null) {
                    this.gfy.aVH();
                }
                bkn();
                return;
            }
            this.gft.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gfC != null) {
            this.gfC.onStart();
        }
        if (this.gfv != null) {
            this.gfv.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.gfy.pT(this.gft.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bkq();
        if (this.gft != null) {
            this.gft.pause();
        }
        if (this.gfC != null) {
            this.gfC.onPause();
        }
        this.gfB = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gfy != null) {
            this.gfy.aVK();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gft != null) {
            return this.gft.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gft != null) {
            return this.gft.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bnW = i;
        rH(i);
    }

    public void rH(int i) {
        if (this.gfL != null) {
            this.gfL.bkC();
        }
        if (this.gft != null) {
            this.gft.seekTo(i);
        }
        if (this.gfC != null) {
            this.gfC.rG(0);
            bks();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gft != null) {
            return this.gft.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gft != null) {
            this.gft.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gfG = i;
    }

    public int getRecoveryState() {
        return this.gfG;
    }

    public void setNeedRecovery(boolean z) {
        this.gfH = z;
    }

    public void setLooping(boolean z) {
        this.gfF = z;
    }

    public boolean bkr() {
        return this.gfB;
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
        this.gfC = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bjZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gfF = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gft != null) {
            this.gft.Lx();
        }
        if (this.gfL != null) {
            this.gfL.bkE();
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggj);
        MessageManager.getInstance().unRegisterListener(this.bjZ);
        if (this.gfK != null) {
            this.gfK.clear();
        }
        if (this.gfz != null) {
            this.gfz.a(null);
            this.gfz.aVz();
        }
    }

    public g getPlayer() {
        return this.gft;
    }

    public int getPlayerType() {
        if (this.gft == null) {
            return -300;
        }
        return this.gft.getPlayerType();
    }

    public void bks() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggj);
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggj, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.geZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gfC instanceof n) || ((n) this.gfC).bkA() == null) ? "" : ((n) this.gfC).bkA().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.gfy != null) {
            return this.gfy;
        }
        if (!StringUtils.isNull(this.gfN)) {
            uri2 = this.gfN;
        } else if (gfx != null && this.gfC != null && !StringUtils.isNull(this.gfC.bkb())) {
            uri2 = this.gfC.bkb();
        } else {
            uri2 = (gfx == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gfx != null) {
            this.gfy = gfx.E(this.aWq, uri2, this.gfA);
        }
        this.gfA = null;
        this.gfO = 0L;
        return this.gfy;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gfy, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gfy, j);
    }

    public static boolean fY(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gfu = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gft != null) {
            return this.gft.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gft != null ? this.gft.getId() : "";
    }

    public void setVideoStatusListener(c cVar) {
        this.gfv = cVar;
    }
}
