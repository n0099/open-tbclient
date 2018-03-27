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
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static h gtV;
    private static com.baidu.tieba.i.k gtW;
    private static int gur = 0;
    private static int gus = 1;
    private static int gut = 2;
    private static int guu = 1;
    private static int guv = 0;
    private Map<String, String> aop;
    private String bCV;
    private g.h bPA;
    private final CustomMessageListener bPG;
    private g.a bPs;
    private g.f bPt;
    private g.b bPu;
    private g.c bPv;
    private g.e bPw;
    private g.InterfaceC0220g bPx;
    private g.i bPy;
    private g.d bPz;
    private int bTB;
    private b caY;
    private int geN;
    private a gtG;
    private o gtR;
    private String gtS;
    private g gtT;
    private g.e gtU;
    private com.baidu.tieba.i.i gtX;
    private com.baidu.tieba.i.e gtY;
    private String gtZ;
    private int guA;
    private int guB;
    private Runnable guC;
    private Runnable guD;
    private TextureView.SurfaceTextureListener guE;
    private g.f guF;
    private g.a guG;
    private g.InterfaceC0220g guH;
    private Runnable guI;
    private boolean gua;
    private d gub;
    private boolean guc;
    private int gud;
    private boolean gue;
    private int guf;
    private boolean gug;
    private SurfaceTexture guh;
    private boolean gui;
    private com.baidu.tieba.play.b.a guj;
    private r guk;
    private com.baidu.tieba.play.b.f gul;
    private String gum;
    private long gun;
    private boolean guo;
    private long gup;
    private long guq;
    private int guw;
    private int gux;
    private int guy;
    private int guz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bld();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            gtV = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            gtW = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gui = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gua = false;
        this.guc = false;
        this.gud = 0;
        this.gue = false;
        this.guf = -1;
        this.gug = false;
        this.guh = null;
        this.gui = true;
        this.gup = 0L;
        this.guq = 0L;
        this.geN = guv;
        this.guw = 0;
        this.gux = 0;
        this.guy = -1;
        this.guz = 0;
        this.guA = 0;
        this.guB = 0;
        this.bTB = 0;
        this.guC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtT != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtT, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.guD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.jn(false);
                }
            }
        };
        this.guE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.guc) {
                    QuickVideoView.this.guc = false;
                    if (QuickVideoView.this.gtT != null) {
                        QuickVideoView.this.gtT.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtX.aWS();
                    }
                } else if (QuickVideoView.this.gtT != null && QuickVideoView.this.gug) {
                    QuickVideoView.this.gtT.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.guf);
                    if (QuickVideoView.this.gtG != null) {
                        QuickVideoView.this.gtG.bld();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtX.aWT();
                    }
                }
                QuickVideoView.this.guh = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blt();
                QuickVideoView.this.lT(false);
                if (QuickVideoView.this.gtT != null) {
                    QuickVideoView.this.gtT.release();
                }
                if (!QuickVideoView.this.guc) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.onStop();
                    }
                    if (QuickVideoView.this.caY != null) {
                        QuickVideoView.this.caY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.guh = null;
                if (QuickVideoView.this.gtX != null && QuickVideoView.this.gtX.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtX = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.guF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blt();
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.onPrepared();
                }
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.si(QuickVideoView.this.gtT.getPlayerType());
                }
                if (QuickVideoView.this.bPt != null) {
                    QuickVideoView.this.bPt.onPrepared(gVar);
                }
                if (QuickVideoView.this.gub != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtT != null) {
                        j = QuickVideoView.this.gtT.getDuration();
                    }
                    QuickVideoView.this.gub.cK(j);
                    QuickVideoView.this.bls();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gub.blk();
                        QuickVideoView.this.blv();
                    }
                }
                if (QuickVideoView.this.gua) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtR != null && gVar != null) {
                    QuickVideoView.this.gtR.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gud);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtS) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtS);
                }
                if (QuickVideoView.this.guj != null && QuickVideoView.this.guj.bmb()) {
                    com.baidu.tieba.play.b.e.tX(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lT(true);
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtX = null;
                }
                if (!QuickVideoView.this.gue || QuickVideoView.this.gub == null) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.onCompletion();
                    }
                    QuickVideoView.this.gua = false;
                    if (QuickVideoView.this.bPs != null) {
                        QuickVideoView.this.bPs.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtZ = null;
                QuickVideoView.this.gun = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gub.ble());
                QuickVideoView.this.start();
            }
        };
        this.bPv = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ah(i, i2, i3);
                QuickVideoView.this.blt();
                if (QuickVideoView.this.gub != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.guo = true;
                    z.blV().aB(QuickVideoView.this.gub.ble(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtX != null) {
                        QuickVideoView.this.gtZ = QuickVideoView.this.gtX.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gun, QuickVideoView.this.I(QuickVideoView.this.gtX.aWY(), i3 + "", QuickVideoView.this.gtX.aWZ()));
                        QuickVideoView.this.gtX = null;
                    }
                    QuickVideoView.this.gun = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPu == null || QuickVideoView.this.bPu.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.guH = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.guo) {
                    QuickVideoView.this.guo = false;
                    return;
                }
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.blF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gub != null && z) {
                    QuickVideoView.this.gub.onSeekComplete();
                }
                if (QuickVideoView.this.bPx != null) {
                    QuickVideoView.this.bPx.b(gVar);
                }
            }
        };
        this.bPw = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gud = i2;
                    if (QuickVideoView.this.gtR != null && gVar != null) {
                        QuickVideoView.this.gtR.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gud);
                    }
                }
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.a(i, i2, QuickVideoView.this.gtX);
                    return true;
                }
                return true;
            }
        };
        this.bPy = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.i(i, i2, str);
                }
            }
        };
        this.bPz = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.pG(str);
                }
            }
        };
        this.bPA = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gun = j;
                }
            }
        };
        this.guI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gub != null && QuickVideoView.this.gub.blg() && QuickVideoView.this.gub.blh() && QuickVideoView.this.gub.bli() && QuickVideoView.this.gtT != null) {
                    int Tl = QuickVideoView.this.gtT.Tl();
                    int currentPosition = QuickVideoView.this.gtT.getCurrentPosition();
                    int duration = QuickVideoView.this.gtT.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gup;
                    boolean z = currentPosition + Tl < duration;
                    if (Tl < QuickVideoView.this.gub.blj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gup = currentTimeMillis;
                        QuickVideoView.this.gub.tS(0);
                    }
                    if (QuickVideoView.this.blu() && currentPosition == QuickVideoView.this.guq && j > 500) {
                        QuickVideoView.this.gup = currentTimeMillis;
                        QuickVideoView.this.gub.tS(0);
                    }
                    QuickVideoView.this.guq = currentPosition;
                    if (QuickVideoView.this.geN == QuickVideoView.guu) {
                        QuickVideoView.this.blv();
                    }
                }
            }
        };
        this.bPG = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.blm();
                    }
                    if (QuickVideoView.this.gtX != null) {
                        QuickVideoView.this.gtX.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtX = null;
                    }
                    QuickVideoView.this.blt();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gua = false;
        this.guc = false;
        this.gud = 0;
        this.gue = false;
        this.guf = -1;
        this.gug = false;
        this.guh = null;
        this.gui = true;
        this.gup = 0L;
        this.guq = 0L;
        this.geN = guv;
        this.guw = 0;
        this.gux = 0;
        this.guy = -1;
        this.guz = 0;
        this.guA = 0;
        this.guB = 0;
        this.bTB = 0;
        this.guC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtT != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtT, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.guD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.jn(false);
                }
            }
        };
        this.guE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.guc) {
                    QuickVideoView.this.guc = false;
                    if (QuickVideoView.this.gtT != null) {
                        QuickVideoView.this.gtT.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtX.aWS();
                    }
                } else if (QuickVideoView.this.gtT != null && QuickVideoView.this.gug) {
                    QuickVideoView.this.gtT.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.guf);
                    if (QuickVideoView.this.gtG != null) {
                        QuickVideoView.this.gtG.bld();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtX.aWT();
                    }
                }
                QuickVideoView.this.guh = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blt();
                QuickVideoView.this.lT(false);
                if (QuickVideoView.this.gtT != null) {
                    QuickVideoView.this.gtT.release();
                }
                if (!QuickVideoView.this.guc) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.onStop();
                    }
                    if (QuickVideoView.this.caY != null) {
                        QuickVideoView.this.caY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.guh = null;
                if (QuickVideoView.this.gtX != null && QuickVideoView.this.gtX.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtX = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.guF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blt();
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.onPrepared();
                }
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.si(QuickVideoView.this.gtT.getPlayerType());
                }
                if (QuickVideoView.this.bPt != null) {
                    QuickVideoView.this.bPt.onPrepared(gVar);
                }
                if (QuickVideoView.this.gub != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtT != null) {
                        j = QuickVideoView.this.gtT.getDuration();
                    }
                    QuickVideoView.this.gub.cK(j);
                    QuickVideoView.this.bls();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gub.blk();
                        QuickVideoView.this.blv();
                    }
                }
                if (QuickVideoView.this.gua) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtR != null && gVar != null) {
                    QuickVideoView.this.gtR.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gud);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtS) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtS);
                }
                if (QuickVideoView.this.guj != null && QuickVideoView.this.guj.bmb()) {
                    com.baidu.tieba.play.b.e.tX(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lT(true);
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtX = null;
                }
                if (!QuickVideoView.this.gue || QuickVideoView.this.gub == null) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.onCompletion();
                    }
                    QuickVideoView.this.gua = false;
                    if (QuickVideoView.this.bPs != null) {
                        QuickVideoView.this.bPs.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtZ = null;
                QuickVideoView.this.gun = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gub.ble());
                QuickVideoView.this.start();
            }
        };
        this.bPv = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ah(i, i2, i3);
                QuickVideoView.this.blt();
                if (QuickVideoView.this.gub != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.guo = true;
                    z.blV().aB(QuickVideoView.this.gub.ble(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtX != null) {
                        QuickVideoView.this.gtZ = QuickVideoView.this.gtX.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gun, QuickVideoView.this.I(QuickVideoView.this.gtX.aWY(), i3 + "", QuickVideoView.this.gtX.aWZ()));
                        QuickVideoView.this.gtX = null;
                    }
                    QuickVideoView.this.gun = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPu == null || QuickVideoView.this.bPu.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.guH = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.guo) {
                    QuickVideoView.this.guo = false;
                    return;
                }
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.blF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gub != null && z) {
                    QuickVideoView.this.gub.onSeekComplete();
                }
                if (QuickVideoView.this.bPx != null) {
                    QuickVideoView.this.bPx.b(gVar);
                }
            }
        };
        this.bPw = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gud = i2;
                    if (QuickVideoView.this.gtR != null && gVar != null) {
                        QuickVideoView.this.gtR.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gud);
                    }
                }
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.a(i, i2, QuickVideoView.this.gtX);
                    return true;
                }
                return true;
            }
        };
        this.bPy = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.i(i, i2, str);
                }
            }
        };
        this.bPz = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.pG(str);
                }
            }
        };
        this.bPA = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gun = j;
                }
            }
        };
        this.guI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gub != null && QuickVideoView.this.gub.blg() && QuickVideoView.this.gub.blh() && QuickVideoView.this.gub.bli() && QuickVideoView.this.gtT != null) {
                    int Tl = QuickVideoView.this.gtT.Tl();
                    int currentPosition = QuickVideoView.this.gtT.getCurrentPosition();
                    int duration = QuickVideoView.this.gtT.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gup;
                    boolean z = currentPosition + Tl < duration;
                    if (Tl < QuickVideoView.this.gub.blj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gup = currentTimeMillis;
                        QuickVideoView.this.gub.tS(0);
                    }
                    if (QuickVideoView.this.blu() && currentPosition == QuickVideoView.this.guq && j > 500) {
                        QuickVideoView.this.gup = currentTimeMillis;
                        QuickVideoView.this.gub.tS(0);
                    }
                    QuickVideoView.this.guq = currentPosition;
                    if (QuickVideoView.this.geN == QuickVideoView.guu) {
                        QuickVideoView.this.blv();
                    }
                }
            }
        };
        this.bPG = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.blm();
                    }
                    if (QuickVideoView.this.gtX != null) {
                        QuickVideoView.this.gtX.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtX = null;
                    }
                    QuickVideoView.this.blt();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gua = false;
        this.guc = false;
        this.gud = 0;
        this.gue = false;
        this.guf = -1;
        this.gug = false;
        this.guh = null;
        this.gui = true;
        this.gup = 0L;
        this.guq = 0L;
        this.geN = guv;
        this.guw = 0;
        this.gux = 0;
        this.guy = -1;
        this.guz = 0;
        this.guA = 0;
        this.guB = 0;
        this.bTB = 0;
        this.guC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtT != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtT, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.guD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.jn(false);
                }
            }
        };
        this.guE = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.guc) {
                    QuickVideoView.this.guc = false;
                    if (QuickVideoView.this.gtT != null) {
                        QuickVideoView.this.gtT.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtX.aWS();
                    }
                } else if (QuickVideoView.this.gtT != null && QuickVideoView.this.gug) {
                    QuickVideoView.this.gtT.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.guf);
                    if (QuickVideoView.this.gtG != null) {
                        QuickVideoView.this.gtG.bld();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtX.aWT();
                    }
                }
                QuickVideoView.this.guh = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blt();
                QuickVideoView.this.lT(false);
                if (QuickVideoView.this.gtT != null) {
                    QuickVideoView.this.gtT.release();
                }
                if (!QuickVideoView.this.guc) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.onStop();
                    }
                    if (QuickVideoView.this.caY != null) {
                        QuickVideoView.this.caY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.guh = null;
                if (QuickVideoView.this.gtX != null && QuickVideoView.this.gtX.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtX = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.guF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blt();
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.onPrepared();
                }
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.si(QuickVideoView.this.gtT.getPlayerType());
                }
                if (QuickVideoView.this.bPt != null) {
                    QuickVideoView.this.bPt.onPrepared(gVar);
                }
                if (QuickVideoView.this.gub != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtT != null) {
                        j = QuickVideoView.this.gtT.getDuration();
                    }
                    QuickVideoView.this.gub.cK(j);
                    QuickVideoView.this.bls();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gub.blk();
                        QuickVideoView.this.blv();
                    }
                }
                if (QuickVideoView.this.gua) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtR != null && gVar != null) {
                    QuickVideoView.this.gtR.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gud);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtS) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtS);
                }
                if (QuickVideoView.this.guj != null && QuickVideoView.this.guj.bmb()) {
                    com.baidu.tieba.play.b.e.tX(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lT(true);
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtX = null;
                }
                if (!QuickVideoView.this.gue || QuickVideoView.this.gub == null) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.onCompletion();
                    }
                    QuickVideoView.this.gua = false;
                    if (QuickVideoView.this.bPs != null) {
                        QuickVideoView.this.bPs.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtZ = null;
                QuickVideoView.this.gun = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gub.ble());
                QuickVideoView.this.start();
            }
        };
        this.bPv = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ah(i2, i22, i3);
                QuickVideoView.this.blt();
                if (QuickVideoView.this.gub != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.guo = true;
                    z.blV().aB(QuickVideoView.this.gub.ble(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtX != null) {
                        QuickVideoView.this.gtZ = QuickVideoView.this.gtX.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gun, QuickVideoView.this.I(QuickVideoView.this.gtX.aWY(), i3 + "", QuickVideoView.this.gtX.aWZ()));
                        QuickVideoView.this.gtX = null;
                    }
                    QuickVideoView.this.gun = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPu == null || QuickVideoView.this.bPu.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.guH = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.guo) {
                    QuickVideoView.this.guo = false;
                    return;
                }
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.blF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gub != null && z) {
                    QuickVideoView.this.gub.onSeekComplete();
                }
                if (QuickVideoView.this.bPx != null) {
                    QuickVideoView.this.bPx.b(gVar);
                }
            }
        };
        this.bPw = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gud = i22;
                    if (QuickVideoView.this.gtR != null && gVar != null) {
                        QuickVideoView.this.gtR.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gud);
                    }
                }
                if (QuickVideoView.this.guk != null) {
                    QuickVideoView.this.guk.a(i2, i22, QuickVideoView.this.gtX);
                    return true;
                }
                return true;
            }
        };
        this.bPy = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.i(i2, i22, str);
                }
            }
        };
        this.bPz = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtX != null) {
                    QuickVideoView.this.gtX.pG(str);
                }
            }
        };
        this.bPA = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gun = j;
                }
            }
        };
        this.guI = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gub != null && QuickVideoView.this.gub.blg() && QuickVideoView.this.gub.blh() && QuickVideoView.this.gub.bli() && QuickVideoView.this.gtT != null) {
                    int Tl = QuickVideoView.this.gtT.Tl();
                    int currentPosition = QuickVideoView.this.gtT.getCurrentPosition();
                    int duration = QuickVideoView.this.gtT.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gup;
                    boolean z = currentPosition + Tl < duration;
                    if (Tl < QuickVideoView.this.gub.blj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gup = currentTimeMillis;
                        QuickVideoView.this.gub.tS(0);
                    }
                    if (QuickVideoView.this.blu() && currentPosition == QuickVideoView.this.guq && j > 500) {
                        QuickVideoView.this.gup = currentTimeMillis;
                        QuickVideoView.this.gub.tS(0);
                    }
                    QuickVideoView.this.guq = currentPosition;
                    if (QuickVideoView.this.geN == QuickVideoView.guu) {
                        QuickVideoView.this.blv();
                    }
                }
            }
        };
        this.bPG = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gub != null) {
                        QuickVideoView.this.gub.blm();
                    }
                    if (QuickVideoView.this.gtX != null) {
                        QuickVideoView.this.gtX.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtX = null;
                    }
                    QuickVideoView.this.blt();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gtR = new o(context);
        this.gtR.setSurfaceTextureListener(this.guE);
        if (gtV != null) {
            this.gtT = gtV.Tm();
        }
        if (this.gtT != null) {
            this.gtT.setOnPreparedListener(this.guF);
            this.gtT.setOnCompletionListener(this.guG);
            this.gtT.a(this.bPv);
            this.gtT.setOnSeekCompleteListener(this.guH);
            this.gtT.a(this.bPw);
            this.gtT.a(this.bPy);
            this.gtT.a(this.bPz);
            this.gtT.a(this.bPA);
        }
        aj.t(this, d.C0141d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(Constants.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.guj = new com.baidu.tieba.play.b.a(this);
        this.guk = new r();
        this.gul = new com.baidu.tieba.play.b.f();
    }

    public void bN(String str, String str2) {
        this.bCV = str2;
        if (this.guj != null) {
            this.guj.clear();
            this.guj.bmb();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.rq(str2);
            if (gtW != null) {
                this.gtX = gtW.H(this.bCV, str, "");
                if (this.gtX != null) {
                    this.gtX.a(-300, -44399, -44399, getLocateSource(), false, this.gun, "");
                    this.gtX = null;
                }
            }
        }
        if (this.gtY != null) {
            this.gtY.a(null);
            this.gtY.aWL();
            this.gtY = null;
        }
        this.gtZ = null;
        this.gun = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.gtX != null) {
            this.gtX.aWX();
            this.gtX = null;
        }
        if (!am.isEmpty(str)) {
            this.gum = str;
            if (i(Uri.parse(str)) != null) {
                this.gtX.aWR();
            }
            if (this.gub != null) {
                str = this.gub.hW(str);
                if (this.gub.bll() != null) {
                    this.gub.bll().setPlayer(this);
                }
                if (gtW != null && ri(str)) {
                    this.gtY = gtW.pI(str);
                }
                if (this.gtY != null) {
                    this.gtY.a(new com.baidu.tieba.play.monitor.a(this.bCV, this.gum, this.gtX));
                    this.gtY.aWK();
                }
                rh(str);
            }
            if (!com.baidu.adp.lib.util.j.oJ() && !ri(str)) {
                if (this.bPu != null) {
                    this.bPu.onError(this.gtT, Constants.BDUSS_EXCEPRION, Constants.BDUSS_EXCEPRION);
                    return;
                }
                return;
            }
            blq();
            setVideoURI(Uri.parse(str));
        }
    }

    private void blq() {
        if (com.baidu.tbadk.coreExtra.model.f.IL()) {
            if (this.gub != null && (this.gub.blf() || this.gub.blg())) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guC);
                com.baidu.adp.lib.g.e.ns().postDelayed(this.guC, com.baidu.tbadk.coreExtra.model.f.IK());
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guD);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.guD, com.baidu.tbadk.coreExtra.model.f.IJ());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (i(uri) != null) {
            this.gtX.pC(uri.toString());
        }
        blr();
        this.guc = true;
        this.mUri = uri;
        this.aop = map;
        this.gud = 0;
        removeView(this.gtR);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gui) {
            addView(this.gtR, layoutParams);
        } else {
            addView(this.gtR, 0, layoutParams);
        }
        aj.t(this, d.C0141d.cp_bg_line_k);
    }

    private void blr() {
        this.guc = false;
        this.gua = false;
        if (this.gtT != null) {
            this.gtT.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guI);
    }

    private void rh(String str) {
        this.gux = 0;
        this.guy = 0;
        this.guz = 0;
        this.guA = 0;
        this.guB = 0;
        this.bTB = 0;
        if (this.gub.blg()) {
            this.guw = gus;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.guy = (int) u.rk(QuickVideoView.this.gum);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gum != null && this.gum.equals(str)) {
            this.guw = gur;
        } else {
            this.guw = gut;
        }
        this.geN = guu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bls() {
        this.geN = guu;
        if (this.gtT != null) {
            this.gux = this.gtT.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(boolean z) {
        if (this.geN == guu && this.gtT != null) {
            this.geN = guv;
            this.guA = this.gtT.getDuration();
            if (z) {
                this.guB = 0;
                this.guz = this.guA;
            } else {
                this.guz = this.gtT.getCurrentPosition();
                this.guB = this.gtT.getCachedSize();
            }
            if (this.guz > 0) {
                if (this.guw == gur) {
                    this.guy = (int) u.rk(this.gum);
                    if (this.gux > 0) {
                        long j = (this.gux * (this.guz / 1000)) / 8;
                        if (this.guB < 0) {
                            this.guB = 0;
                        }
                        long j2 = this.guB + j;
                        if (this.guy > 0) {
                            j2 += this.guy;
                        }
                        a(j2, this.guz, this.guA, this.bTB);
                    } else if (this.gux == -1) {
                        this.gux = 603327;
                        a((this.gux * (this.guz / 1000)) / 8, this.guz, this.guA, this.bTB);
                    }
                } else if (this.guw == gus) {
                    if (this.gux > 0) {
                        long j3 = (this.gux * (this.guz / 1000)) / 8;
                        if (this.guB < 0) {
                            this.guB = 0;
                        }
                        long j4 = this.guB + j3;
                        if (this.guy > 0) {
                            j4 -= this.guy;
                        }
                        a(j4, this.guz, this.guA, this.bTB);
                    } else if (this.gux == -1) {
                        this.gux = 603327;
                        a((this.gux * (this.guz / 1000)) / 8, this.guz, this.guA, this.bTB);
                    }
                } else {
                    a(0L, this.guz, this.guA, this.bTB);
                }
            }
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guI);
    }

    public void stopPlayback() {
        blt();
        lT(false);
        if (this.guj != null) {
            this.guj.clear();
        }
        this.gtS = null;
        blr();
        this.gue = false;
        if (this.gub != null) {
            this.gub.onStop();
        }
        com.baidu.tieba.play.a.b.blY().a((b.InterfaceC0217b) null);
        if (this.gtX != null && this.gtX.pF(getLocateSource())) {
            this.gtX = null;
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guC);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guD);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bPt = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bPs = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bPu = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0220g interfaceC0220g) {
        this.bPx = interfaceC0220g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I(String str, String str2, String str3) {
        if (this.gul == null) {
            return "";
        }
        String bmd = this.gul.bmd();
        this.gul.J(str, str2, str3);
        return bmd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gub != null && !StringUtils.isNull(this.gub.ble())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.rp(uri);
            }
            this.mUri = Uri.parse(this.gub.ble());
        }
        boolean z = false;
        if (this.guj != null) {
            z = this.guj.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gtX != null) {
            this.gtZ = this.gtX.a(i, i2, i3, getLocateSource(), z, this.gun, I(this.gtX.aWY(), i3 + "", this.gtX.aWZ()));
            this.gtX = null;
        }
        this.gun = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gtT != null) {
            try {
                this.gtT.release();
                this.gtS = str;
                URI uri = new URI(this.mUri.toString());
                this.gtT.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.aop, this.guh, this.mUri.getHost());
                if (i(this.mUri) != null) {
                    this.gtX.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gtT != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gtT.release();
            this.gtT.a(this.mContext, this.mUri, this.aop, this.guh, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gtX.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gtT != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gtT.forceUseSystemMediaPlayer(true);
            }
            this.gtT.release();
            this.gtT.a(this.mContext, this.mUri, this.aop, this.guh, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gtX.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gua = true;
        if (this.gtT != null) {
            if (this.guh != null && this.gug && !this.gtT.isExistInRemote()) {
                this.gtT.a(this.mContext, this.mUri, this.aop, this.guh, this.guf);
                if (this.gtG != null) {
                    this.gtG.bld();
                }
                if (i(this.mUri) != null) {
                    this.gtX.aWT();
                }
                blq();
                return;
            }
            this.gtT.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gub != null) {
            this.gub.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (i(this.mUri) != null) {
            this.gtX.sj(this.gtT.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        blt();
        if (this.gtT != null) {
            this.gtT.pause();
        }
        if (this.gub != null) {
            this.gub.onPause();
        }
        this.gua = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gtX != null) {
            this.gtX.aWW();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gtT != null) {
            return this.gtT.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gtT != null) {
            return this.gtT.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bTB = i;
        tT(i);
    }

    public void tT(int i) {
        if (this.guk != null) {
            this.guk.blE();
        }
        if (this.gtT != null) {
            this.gtT.seekTo(i);
        }
        if (this.gub != null) {
            this.gub.tS(0);
            blv();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gtT != null) {
            return this.gtT.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gtT != null) {
            this.gtT.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.guf = i;
    }

    public int getRecoveryState() {
        return this.guf;
    }

    public void setNeedRecovery(boolean z) {
        this.gug = z;
    }

    public void setLooping(boolean z) {
        this.gue = z;
    }

    public boolean blu() {
        return this.gua;
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
        this.caY = bVar;
    }

    public void setBusiness(d dVar) {
        this.gub = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bPG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gue = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gtT != null) {
            this.gtT.Pk();
        }
        if (this.guk != null) {
            this.guk.blG();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guI);
        MessageManager.getInstance().unRegisterListener(this.bPG);
        if (this.guj != null) {
            this.guj.clear();
        }
        if (this.gtY != null) {
            this.gtY.a(null);
            this.gtY.aWL();
        }
    }

    public g getPlayer() {
        return this.gtT;
    }

    public int getPlayerType() {
        if (this.gtT == null) {
            return -300;
        }
        return this.gtT.getPlayerType();
    }

    public void blv() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guI);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.guI, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gtG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gub instanceof n) || ((n) this.gub).blC() == null) ? "" : ((n) this.gub).blC().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i i(Uri uri) {
        String uri2;
        if (this.gtX != null) {
            return this.gtX;
        }
        if (!StringUtils.isNull(this.gum)) {
            uri2 = this.gum;
        } else if (gtW != null && this.gub != null && !StringUtils.isNull(this.gub.ble())) {
            uri2 = this.gub.ble();
        } else {
            uri2 = (gtW == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gtW != null) {
            this.gtX = gtW.H(this.bCV, uri2, this.gtZ);
        }
        this.gtZ = null;
        this.gun = 0L;
        return this.gtX;
    }

    public void a(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gtX, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gtX, j);
    }

    public static boolean ri(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gtU = eVar;
    }
}
