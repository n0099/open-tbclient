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
    private static h geX;
    private static com.baidu.tieba.j.k geY;
    private static int gft = 0;
    private static int gfu = 1;
    private static int gfv = 2;
    private static int gfw = 1;
    private static int gfx = 0;
    private Map<String, String> Fb;
    private String aWo;
    private g.b bcU;
    private b bcY;
    private g.a bjb;
    private g.f bjc;
    private g.c bjd;
    private g.e bje;
    private g.InterfaceC0220g bjf;
    private g.i bjg;
    private g.d bjh;
    private g.h bji;
    private final CustomMessageListener bjo;
    private int bno;
    private int fPI;
    private a geI;
    private RenderView geT;
    private String geU;
    private g geV;
    private g.e geW;
    private com.baidu.tieba.j.i geZ;
    private int gfA;
    private int gfB;
    private int gfC;
    private int gfD;
    private Runnable gfE;
    private Runnable gfF;
    private TextureView.SurfaceTextureListener gfG;
    private g.f gfH;
    private g.a gfI;
    private g.InterfaceC0220g gfJ;
    private Runnable gfK;
    private com.baidu.tieba.j.e gfa;
    private String gfb;
    private boolean gfc;
    private d gfd;
    private boolean gfe;
    private int gff;
    private boolean gfg;
    private int gfh;
    private boolean gfi;
    private SurfaceTexture gfj;
    private boolean gfk;
    private com.baidu.tieba.play.b.a gfl;
    private q gfm;
    private com.baidu.tieba.play.b.f gfn;
    private String gfo;
    private long gfp;
    private boolean gfq;
    private long gfr;
    private long gfs;
    private int gfy;
    private int gfz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void blL();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            geX = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        if (runTask2 != null) {
            geY = (com.baidu.tieba.j.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gfk = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gfc = false;
        this.gfe = false;
        this.gff = 0;
        this.gfg = false;
        this.gfh = -1;
        this.gfi = false;
        this.gfj = null;
        this.gfk = true;
        this.gfr = 0L;
        this.gfs = 0L;
        this.fPI = gfx;
        this.gfy = 0;
        this.gfz = 0;
        this.gfA = -1;
        this.gfB = 0;
        this.gfC = 0;
        this.gfD = 0;
        this.bno = 0;
        this.gfE = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.geV != null) {
                    QuickVideoView.this.b(QuickVideoView.this.geV, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gfF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.ja(false);
                }
            }
        };
        this.gfG = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gfe) {
                    QuickVideoView.this.gfe = false;
                    if (QuickVideoView.this.geV != null) {
                        QuickVideoView.this.geV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Fb, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.geZ.aXr();
                    }
                } else if (QuickVideoView.this.geV != null && QuickVideoView.this.gfi) {
                    QuickVideoView.this.geV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Fb, surfaceTexture, QuickVideoView.this.gfh);
                    if (QuickVideoView.this.geI != null) {
                        QuickVideoView.this.geI.blL();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.geZ.aXs();
                    }
                }
                QuickVideoView.this.gfj = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bmb();
                QuickVideoView.this.lK(false);
                if (QuickVideoView.this.geV != null) {
                    QuickVideoView.this.geV.release();
                }
                if (!QuickVideoView.this.gfe) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.onStop();
                    }
                    if (QuickVideoView.this.bcY != null) {
                        QuickVideoView.this.bcY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfj = null;
                if (QuickVideoView.this.geZ != null && QuickVideoView.this.geZ.qC(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.geZ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gfH = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bmb();
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.onPrepared();
                }
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.pV(QuickVideoView.this.geV.getPlayerType());
                }
                if (QuickVideoView.this.bjc != null) {
                    QuickVideoView.this.bjc.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfd != null) {
                    long j = 0;
                    if (QuickVideoView.this.geV != null) {
                        j = QuickVideoView.this.geV.getDuration();
                    }
                    QuickVideoView.this.gfd.cP(j);
                    QuickVideoView.this.bma();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfd.blS();
                        QuickVideoView.this.bmd();
                    }
                }
                if (QuickVideoView.this.gfc) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.geT != null && gVar != null) {
                    QuickVideoView.this.geT.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gff);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.geU) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.geU);
                }
                if (QuickVideoView.this.gfl != null && QuickVideoView.this.gfl.bmJ()) {
                    com.baidu.tieba.play.b.e.rO(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gfI = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lK(true);
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.qB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.geZ = null;
                }
                if (!QuickVideoView.this.gfg || QuickVideoView.this.gfd == null) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.onCompletion();
                    }
                    QuickVideoView.this.gfc = false;
                    if (QuickVideoView.this.bjb != null) {
                        QuickVideoView.this.bjb.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfb = null;
                QuickVideoView.this.gfp = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfd.blM());
                QuickVideoView.this.start();
            }
        };
        this.bjd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bmb();
                if (QuickVideoView.this.gfd != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfq = true;
                    x.bmD().aH(QuickVideoView.this.gfd.blM(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jD()) {
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.gfb = QuickVideoView.this.geZ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfp, QuickVideoView.this.E(QuickVideoView.this.geZ.aXx(), i3 + "", QuickVideoView.this.geZ.aXy()));
                        QuickVideoView.this.geZ = null;
                    }
                    QuickVideoView.this.gfp = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rM(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rN(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bcU == null || QuickVideoView.this.bcU.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gfJ = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.gfq) {
                    QuickVideoView.this.gfq = false;
                    return;
                }
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.bmn();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfd != null && z) {
                    QuickVideoView.this.gfd.onSeekComplete();
                }
                if (QuickVideoView.this.bjf != null) {
                    QuickVideoView.this.bjf.b(gVar);
                }
            }
        };
        this.bje = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.geW != null) {
                    QuickVideoView.this.geW.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gff = i2;
                    if (QuickVideoView.this.geT != null && gVar != null) {
                        QuickVideoView.this.geT.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gff);
                    }
                }
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.a(i, i2, QuickVideoView.this.geZ);
                    return true;
                }
                return true;
            }
        };
        this.bjg = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.f(i, i2, str);
                }
            }
        };
        this.bjh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.qD(str);
                }
            }
        };
        this.bji = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfp = j;
                }
            }
        };
        this.gfK = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfd != null && QuickVideoView.this.gfd.blO() && QuickVideoView.this.gfd.blP() && QuickVideoView.this.gfd.blQ() && QuickVideoView.this.geV != null) {
                    int PC = QuickVideoView.this.geV.PC();
                    int currentPosition = QuickVideoView.this.geV.getCurrentPosition();
                    int duration = QuickVideoView.this.geV.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfr;
                    boolean z = currentPosition + PC < duration;
                    if (PC < QuickVideoView.this.gfd.blR() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfr = currentTimeMillis;
                        QuickVideoView.this.gfd.rJ(0);
                    }
                    if (QuickVideoView.this.bmc() && currentPosition == QuickVideoView.this.gfs && j > 500) {
                        QuickVideoView.this.gfr = currentTimeMillis;
                        QuickVideoView.this.gfd.rJ(0);
                    }
                    QuickVideoView.this.gfs = currentPosition;
                    if (QuickVideoView.this.fPI == QuickVideoView.gfw) {
                        QuickVideoView.this.bmd();
                    }
                }
            }
        };
        this.bjo = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.blU();
                    }
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.geZ.qA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.geZ = null;
                    }
                    QuickVideoView.this.bmb();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfc = false;
        this.gfe = false;
        this.gff = 0;
        this.gfg = false;
        this.gfh = -1;
        this.gfi = false;
        this.gfj = null;
        this.gfk = true;
        this.gfr = 0L;
        this.gfs = 0L;
        this.fPI = gfx;
        this.gfy = 0;
        this.gfz = 0;
        this.gfA = -1;
        this.gfB = 0;
        this.gfC = 0;
        this.gfD = 0;
        this.bno = 0;
        this.gfE = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.geV != null) {
                    QuickVideoView.this.b(QuickVideoView.this.geV, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gfF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.ja(false);
                }
            }
        };
        this.gfG = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gfe) {
                    QuickVideoView.this.gfe = false;
                    if (QuickVideoView.this.geV != null) {
                        QuickVideoView.this.geV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Fb, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.geZ.aXr();
                    }
                } else if (QuickVideoView.this.geV != null && QuickVideoView.this.gfi) {
                    QuickVideoView.this.geV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Fb, surfaceTexture, QuickVideoView.this.gfh);
                    if (QuickVideoView.this.geI != null) {
                        QuickVideoView.this.geI.blL();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.geZ.aXs();
                    }
                }
                QuickVideoView.this.gfj = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bmb();
                QuickVideoView.this.lK(false);
                if (QuickVideoView.this.geV != null) {
                    QuickVideoView.this.geV.release();
                }
                if (!QuickVideoView.this.gfe) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.onStop();
                    }
                    if (QuickVideoView.this.bcY != null) {
                        QuickVideoView.this.bcY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfj = null;
                if (QuickVideoView.this.geZ != null && QuickVideoView.this.geZ.qC(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.geZ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gfH = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bmb();
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.onPrepared();
                }
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.pV(QuickVideoView.this.geV.getPlayerType());
                }
                if (QuickVideoView.this.bjc != null) {
                    QuickVideoView.this.bjc.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfd != null) {
                    long j = 0;
                    if (QuickVideoView.this.geV != null) {
                        j = QuickVideoView.this.geV.getDuration();
                    }
                    QuickVideoView.this.gfd.cP(j);
                    QuickVideoView.this.bma();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfd.blS();
                        QuickVideoView.this.bmd();
                    }
                }
                if (QuickVideoView.this.gfc) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.geT != null && gVar != null) {
                    QuickVideoView.this.geT.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gff);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.geU) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.geU);
                }
                if (QuickVideoView.this.gfl != null && QuickVideoView.this.gfl.bmJ()) {
                    com.baidu.tieba.play.b.e.rO(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gfI = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lK(true);
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.qB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.geZ = null;
                }
                if (!QuickVideoView.this.gfg || QuickVideoView.this.gfd == null) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.onCompletion();
                    }
                    QuickVideoView.this.gfc = false;
                    if (QuickVideoView.this.bjb != null) {
                        QuickVideoView.this.bjb.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfb = null;
                QuickVideoView.this.gfp = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfd.blM());
                QuickVideoView.this.start();
            }
        };
        this.bjd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bmb();
                if (QuickVideoView.this.gfd != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfq = true;
                    x.bmD().aH(QuickVideoView.this.gfd.blM(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jD()) {
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.gfb = QuickVideoView.this.geZ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfp, QuickVideoView.this.E(QuickVideoView.this.geZ.aXx(), i3 + "", QuickVideoView.this.geZ.aXy()));
                        QuickVideoView.this.geZ = null;
                    }
                    QuickVideoView.this.gfp = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rM(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rN(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bcU == null || QuickVideoView.this.bcU.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gfJ = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.gfq) {
                    QuickVideoView.this.gfq = false;
                    return;
                }
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.bmn();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfd != null && z) {
                    QuickVideoView.this.gfd.onSeekComplete();
                }
                if (QuickVideoView.this.bjf != null) {
                    QuickVideoView.this.bjf.b(gVar);
                }
            }
        };
        this.bje = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.geW != null) {
                    QuickVideoView.this.geW.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gff = i2;
                    if (QuickVideoView.this.geT != null && gVar != null) {
                        QuickVideoView.this.geT.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gff);
                    }
                }
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.a(i, i2, QuickVideoView.this.geZ);
                    return true;
                }
                return true;
            }
        };
        this.bjg = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.f(i, i2, str);
                }
            }
        };
        this.bjh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.qD(str);
                }
            }
        };
        this.bji = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfp = j;
                }
            }
        };
        this.gfK = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfd != null && QuickVideoView.this.gfd.blO() && QuickVideoView.this.gfd.blP() && QuickVideoView.this.gfd.blQ() && QuickVideoView.this.geV != null) {
                    int PC = QuickVideoView.this.geV.PC();
                    int currentPosition = QuickVideoView.this.geV.getCurrentPosition();
                    int duration = QuickVideoView.this.geV.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfr;
                    boolean z = currentPosition + PC < duration;
                    if (PC < QuickVideoView.this.gfd.blR() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfr = currentTimeMillis;
                        QuickVideoView.this.gfd.rJ(0);
                    }
                    if (QuickVideoView.this.bmc() && currentPosition == QuickVideoView.this.gfs && j > 500) {
                        QuickVideoView.this.gfr = currentTimeMillis;
                        QuickVideoView.this.gfd.rJ(0);
                    }
                    QuickVideoView.this.gfs = currentPosition;
                    if (QuickVideoView.this.fPI == QuickVideoView.gfw) {
                        QuickVideoView.this.bmd();
                    }
                }
            }
        };
        this.bjo = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.blU();
                    }
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.geZ.qA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.geZ = null;
                    }
                    QuickVideoView.this.bmb();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfc = false;
        this.gfe = false;
        this.gff = 0;
        this.gfg = false;
        this.gfh = -1;
        this.gfi = false;
        this.gfj = null;
        this.gfk = true;
        this.gfr = 0L;
        this.gfs = 0L;
        this.fPI = gfx;
        this.gfy = 0;
        this.gfz = 0;
        this.gfA = -1;
        this.gfB = 0;
        this.gfC = 0;
        this.gfD = 0;
        this.bno = 0;
        this.gfE = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.geV != null) {
                    QuickVideoView.this.b(QuickVideoView.this.geV, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gfF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.ja(false);
                }
            }
        };
        this.gfG = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gfe) {
                    QuickVideoView.this.gfe = false;
                    if (QuickVideoView.this.geV != null) {
                        QuickVideoView.this.geV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Fb, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.geZ.aXr();
                    }
                } else if (QuickVideoView.this.geV != null && QuickVideoView.this.gfi) {
                    QuickVideoView.this.geV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Fb, surfaceTexture, QuickVideoView.this.gfh);
                    if (QuickVideoView.this.geI != null) {
                        QuickVideoView.this.geI.blL();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.geZ.aXs();
                    }
                }
                QuickVideoView.this.gfj = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bmb();
                QuickVideoView.this.lK(false);
                if (QuickVideoView.this.geV != null) {
                    QuickVideoView.this.geV.release();
                }
                if (!QuickVideoView.this.gfe) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.onStop();
                    }
                    if (QuickVideoView.this.bcY != null) {
                        QuickVideoView.this.bcY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gfj = null;
                if (QuickVideoView.this.geZ != null && QuickVideoView.this.geZ.qC(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.geZ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gfH = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bmb();
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.onPrepared();
                }
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.pV(QuickVideoView.this.geV.getPlayerType());
                }
                if (QuickVideoView.this.bjc != null) {
                    QuickVideoView.this.bjc.onPrepared(gVar);
                }
                if (QuickVideoView.this.gfd != null) {
                    long j = 0;
                    if (QuickVideoView.this.geV != null) {
                        j = QuickVideoView.this.geV.getDuration();
                    }
                    QuickVideoView.this.gfd.cP(j);
                    QuickVideoView.this.bma();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gfd.blS();
                        QuickVideoView.this.bmd();
                    }
                }
                if (QuickVideoView.this.gfc) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.geT != null && gVar != null) {
                    QuickVideoView.this.geT.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gff);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.geU) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.geU);
                }
                if (QuickVideoView.this.gfl != null && QuickVideoView.this.gfl.bmJ()) {
                    com.baidu.tieba.play.b.e.rO(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gfI = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lK(true);
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.qB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.geZ = null;
                }
                if (!QuickVideoView.this.gfg || QuickVideoView.this.gfd == null) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.onCompletion();
                    }
                    QuickVideoView.this.gfc = false;
                    if (QuickVideoView.this.bjb != null) {
                        QuickVideoView.this.bjb.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gfb = null;
                QuickVideoView.this.gfp = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gfd.blM());
                QuickVideoView.this.start();
            }
        };
        this.bjd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.V(i2, i22, i3);
                QuickVideoView.this.bmb();
                if (QuickVideoView.this.gfd != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gfq = true;
                    x.bmD().aH(QuickVideoView.this.gfd.blM(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jD()) {
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.gfb = QuickVideoView.this.geZ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gfp, QuickVideoView.this.E(QuickVideoView.this.geZ.aXx(), i3 + "", QuickVideoView.this.geZ.aXy()));
                        QuickVideoView.this.geZ = null;
                    }
                    QuickVideoView.this.gfp = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.rM(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rN(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bcU == null || QuickVideoView.this.bcU.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gfJ = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.gfq) {
                    QuickVideoView.this.gfq = false;
                    return;
                }
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.bmn();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gfd != null && z) {
                    QuickVideoView.this.gfd.onSeekComplete();
                }
                if (QuickVideoView.this.bjf != null) {
                    QuickVideoView.this.bjf.b(gVar);
                }
            }
        };
        this.bje = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.geW != null) {
                    QuickVideoView.this.geW.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gff = i22;
                    if (QuickVideoView.this.geT != null && gVar != null) {
                        QuickVideoView.this.geT.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gff);
                    }
                }
                if (QuickVideoView.this.gfm != null) {
                    QuickVideoView.this.gfm.a(i2, i22, QuickVideoView.this.geZ);
                    return true;
                }
                return true;
            }
        };
        this.bjg = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.f(i2, i22, str);
                }
            }
        };
        this.bjh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.geZ != null) {
                    QuickVideoView.this.geZ.qD(str);
                }
            }
        };
        this.bji = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gfp = j;
                }
            }
        };
        this.gfK = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gfd != null && QuickVideoView.this.gfd.blO() && QuickVideoView.this.gfd.blP() && QuickVideoView.this.gfd.blQ() && QuickVideoView.this.geV != null) {
                    int PC = QuickVideoView.this.geV.PC();
                    int currentPosition = QuickVideoView.this.geV.getCurrentPosition();
                    int duration = QuickVideoView.this.geV.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gfr;
                    boolean z = currentPosition + PC < duration;
                    if (PC < QuickVideoView.this.gfd.blR() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gfr = currentTimeMillis;
                        QuickVideoView.this.gfd.rJ(0);
                    }
                    if (QuickVideoView.this.bmc() && currentPosition == QuickVideoView.this.gfs && j > 500) {
                        QuickVideoView.this.gfr = currentTimeMillis;
                        QuickVideoView.this.gfd.rJ(0);
                    }
                    QuickVideoView.this.gfs = currentPosition;
                    if (QuickVideoView.this.fPI == QuickVideoView.gfw) {
                        QuickVideoView.this.bmd();
                    }
                }
            }
        };
        this.bjo = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gfd != null) {
                        QuickVideoView.this.gfd.blU();
                    }
                    if (QuickVideoView.this.geZ != null) {
                        QuickVideoView.this.geZ.qA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.geZ = null;
                    }
                    QuickVideoView.this.bmb();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.geT = new RenderView(context);
        this.geT.setSurfaceTextureListener(this.gfG);
        if (geX != null) {
            this.geV = geX.PD();
        }
        if (this.geV != null) {
            this.geV.setOnPreparedListener(this.gfH);
            this.geV.setOnCompletionListener(this.gfI);
            this.geV.a(this.bjd);
            this.geV.setOnSeekCompleteListener(this.gfJ);
            this.geV.a(this.bje);
            this.geV.a(this.bjg);
            this.geV.a(this.bjh);
            this.geV.a(this.bji);
        }
        am.j(this, d.C0142d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(ARResourceKey.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gfl = new com.baidu.tieba.play.b.a(this);
        this.gfm = new q();
        this.gfn = new com.baidu.tieba.play.b.f();
    }

    public void setVideoPath(String str, String str2) {
        this.aWo = str2;
        if (this.gfl != null) {
            this.gfl.clear();
            this.gfl.bmJ();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.sp(str2);
            if (geY != null) {
                this.geZ = geY.D(this.aWo, str, "");
                if (this.geZ != null) {
                    this.geZ.a(-300, -44399, -44399, getLocateSource(), false, this.gfp, "");
                    this.geZ = null;
                }
            }
        }
        if (this.gfa != null) {
            this.gfa.a(null);
            this.gfa.aXk();
            this.gfa = null;
        }
        this.gfb = null;
        this.gfp = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.geZ != null) {
            this.geZ.aXw();
            this.geZ = null;
        }
        if (!ap.isEmpty(str)) {
            if (com.baidu.tieba.video.f.bBB().bBC()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    str = str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                } else if (str.contains("http:")) {
                    str = str.replace("http:", "https:");
                }
            }
            this.gfo = str;
            if (f(Uri.parse(str)) != null) {
                this.geZ.aXq();
            }
            if (this.gfd != null) {
                str = this.gfd.iu(str);
                if (this.gfd.blT() != null) {
                    this.gfd.blT().setPlayer(this);
                }
                if (geY != null && ga(str)) {
                    this.gfa = geY.qF(str);
                }
                if (this.gfa != null) {
                    this.gfa.a(new com.baidu.tieba.play.monitor.a(this.aWo, this.gfo, this.geZ));
                    this.gfa.aXj();
                }
                sh(str);
            }
            if (!com.baidu.adp.lib.util.j.jD() && !ga(str)) {
                if (this.bcU != null) {
                    this.bcU.onError(this.geV, -10000, -10000);
                    return;
                }
                return;
            }
            blY();
            setVideoURI(Uri.parse(str));
        }
    }

    private void blY() {
        if (com.baidu.tbadk.coreExtra.model.f.Fq()) {
            if (this.gfd != null && (this.gfd.blN() || this.gfd.blO())) {
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfE);
                com.baidu.adp.lib.g.e.im().postDelayed(this.gfE, com.baidu.tbadk.coreExtra.model.f.Fp());
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfF);
            com.baidu.adp.lib.g.e.im().postDelayed(this.gfF, com.baidu.tbadk.coreExtra.model.f.Fo());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.geZ.qz(uri.toString());
        }
        blZ();
        this.gfe = true;
        this.mUri = uri;
        this.Fb = map;
        this.gff = 0;
        removeView(this.geT);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gfk) {
            addView(this.geT, layoutParams);
        } else {
            addView(this.geT, 0, layoutParams);
        }
        am.j(this, d.C0142d.cp_bg_line_k);
    }

    private void blZ() {
        this.gfe = false;
        this.gfc = false;
        if (this.geV != null) {
            this.geV.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfK);
    }

    private void sh(String str) {
        this.gfz = 0;
        this.gfA = 0;
        this.gfB = 0;
        this.gfC = 0;
        this.gfD = 0;
        this.bno = 0;
        if (this.gfd.blO()) {
            this.gfy = gfu;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gfA = (int) t.sj(QuickVideoView.this.gfo);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gfo != null && this.gfo.equals(str)) {
            this.gfy = gft;
        } else {
            this.gfy = gfv;
        }
        this.fPI = gfw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bma() {
        this.fPI = gfw;
        if (this.geV != null) {
            this.gfz = this.geV.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(boolean z) {
        if (this.fPI == gfw && this.geV != null) {
            this.fPI = gfx;
            this.gfC = this.geV.getDuration();
            if (z) {
                this.gfD = 0;
                this.gfB = this.gfC;
            } else {
                this.gfB = this.geV.getCurrentPosition();
                this.gfD = this.geV.getCachedSize();
            }
            if (this.gfB > 0) {
                if (this.gfy == gft) {
                    this.gfA = (int) t.sj(this.gfo);
                    if (this.gfz > 0) {
                        long j = (this.gfz * (this.gfB / 1000)) / 8;
                        if (this.gfD < 0) {
                            this.gfD = 0;
                        }
                        long j2 = this.gfD + j;
                        if (this.gfA > 0) {
                            j2 += this.gfA;
                        }
                        setFlowCount(j2, this.gfB, this.gfC, this.bno);
                    } else if (this.gfz == -1) {
                        this.gfz = 603327;
                        setFlowCount((this.gfz * (this.gfB / 1000)) / 8, this.gfB, this.gfC, this.bno);
                    }
                } else if (this.gfy == gfu) {
                    if (this.gfz > 0) {
                        long j3 = (this.gfz * (this.gfB / 1000)) / 8;
                        if (this.gfD < 0) {
                            this.gfD = 0;
                        }
                        long j4 = this.gfD + j3;
                        if (this.gfA > 0) {
                            j4 -= this.gfA;
                        }
                        setFlowCount(j4, this.gfB, this.gfC, this.bno);
                    } else if (this.gfz == -1) {
                        this.gfz = 603327;
                        setFlowCount((this.gfz * (this.gfB / 1000)) / 8, this.gfB, this.gfC, this.bno);
                    }
                } else {
                    setFlowCount(0L, this.gfB, this.gfC, this.bno);
                }
            }
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfK);
    }

    public void stopPlayback() {
        bmb();
        lK(false);
        if (this.gfl != null) {
            this.gfl.clear();
        }
        this.geU = null;
        blZ();
        this.gfg = false;
        if (this.gfd != null) {
            this.gfd.onStop();
        }
        com.baidu.tieba.play.a.b.bmG().a((b.InterfaceC0217b) null);
        if (this.geZ != null && this.geZ.qC(getLocateSource())) {
            this.geZ = null;
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmb() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfE);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfF);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bjc = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bjb = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bcU = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0220g interfaceC0220g) {
        this.bjf = interfaceC0220g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String E(String str, String str2, String str3) {
        if (this.gfn == null) {
            return "";
        }
        String bmL = this.gfn.bmL();
        this.gfn.F(str, str2, str3);
        return bmL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gfd != null && !StringUtils.isNull(this.gfd.blM())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.so(uri);
            }
            this.mUri = Uri.parse(this.gfd.blM());
        }
        boolean z = false;
        if (this.gfl != null) {
            z = this.gfl.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.geZ != null) {
            this.gfb = this.geZ.a(i, i2, i3, getLocateSource(), z, this.gfp, E(this.geZ.aXx(), i3 + "", this.geZ.aXy()));
            this.geZ = null;
        }
        this.gfp = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.geV != null) {
            try {
                this.geV.release();
                this.geU = str;
                URI uri = new URI(this.mUri.toString());
                this.geV.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Fb, this.gfj, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.geZ.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.geV != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.geV.release();
            this.geV.a(this.mContext, this.mUri, this.Fb, this.gfj, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.geZ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.geV != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.geV.forceUseSystemMediaPlayer(true);
            }
            this.geV.release();
            this.geV.a(this.mContext, this.mUri, this.Fb, this.gfj, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.geZ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gfc = true;
        if (this.geV != null) {
            if (this.gfj != null && this.gfi && !this.geV.isExistInRemote()) {
                this.geV.a(this.mContext, this.mUri, this.Fb, this.gfj, this.gfh);
                if (this.geI != null) {
                    this.geI.blL();
                }
                if (f(this.mUri) != null) {
                    this.geZ.aXs();
                }
                blY();
                return;
            }
            this.geV.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gfd != null) {
            this.gfd.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.geZ.pW(this.geV.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bmb();
        if (this.geV != null) {
            this.geV.pause();
        }
        if (this.gfd != null) {
            this.gfd.onPause();
        }
        this.gfc = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.geZ != null) {
            this.geZ.aXv();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.geV != null) {
            return this.geV.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.geV != null) {
            return this.geV.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bno = i;
        rK(i);
    }

    public void rK(int i) {
        if (this.gfm != null) {
            this.gfm.bmm();
        }
        if (this.geV != null) {
            this.geV.seekTo(i);
        }
        if (this.gfd != null) {
            this.gfd.rJ(0);
            bmd();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.geV != null) {
            return this.geV.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.geV != null) {
            this.geV.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gfh = i;
    }

    public int getRecoveryState() {
        return this.gfh;
    }

    public void setNeedRecovery(boolean z) {
        this.gfi = z;
    }

    public void setLooping(boolean z) {
        this.gfg = z;
    }

    public boolean bmc() {
        return this.gfc;
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
        this.bcY = bVar;
    }

    public void setBusiness(d dVar) {
        this.gfd = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bjo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gfg = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.geV != null) {
            this.geV.Ly();
        }
        if (this.gfm != null) {
            this.gfm.bmo();
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfK);
        MessageManager.getInstance().unRegisterListener(this.bjo);
        if (this.gfl != null) {
            this.gfl.clear();
        }
        if (this.gfa != null) {
            this.gfa.a(null);
            this.gfa.aXk();
        }
    }

    public g getPlayer() {
        return this.geV;
    }

    public int getPlayerType() {
        if (this.geV == null) {
            return -300;
        }
        return this.geV.getPlayerType();
    }

    public void bmd() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gfK);
        com.baidu.adp.lib.g.e.im().postDelayed(this.gfK, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.geI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gfd instanceof n) || ((n) this.gfd).bmk() == null) ? "" : ((n) this.gfd).bmk().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.geZ != null) {
            return this.geZ;
        }
        if (!StringUtils.isNull(this.gfo)) {
            uri2 = this.gfo;
        } else if (geY != null && this.gfd != null && !StringUtils.isNull(this.gfd.blM())) {
            uri2 = this.gfd.blM();
        } else {
            uri2 = (geY == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && geY != null) {
            this.geZ = geY.D(this.aWo, uri2, this.gfb);
        }
        this.gfb = null;
        this.gfp = 0L;
        return this.geZ;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.geZ, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.geZ, j);
    }

    public static boolean ga(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.geW = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.geV != null) {
            return this.geV.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.geV != null ? this.geV.getId() : "";
    }
}
