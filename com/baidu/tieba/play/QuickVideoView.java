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
    private static h gtQ;
    private static com.baidu.tieba.i.k gtR;
    private static int gum = 0;
    private static int gun = 1;
    private static int guo = 2;
    private static int gup = 1;
    private static int guq = 0;
    private Map<String, String> aov;
    private String bDf;
    private g.a bPC;
    private g.f bPD;
    private g.b bPE;
    private g.c bPF;
    private g.e bPG;
    private g.InterfaceC0219g bPH;
    private g.i bPI;
    private g.d bPJ;
    private g.h bPK;
    private final CustomMessageListener bPQ;
    private int bTK;
    private b cbh;
    private int geI;
    private a gtB;
    private o gtM;
    private String gtN;
    private g gtO;
    private g.e gtP;
    private com.baidu.tieba.i.i gtS;
    private com.baidu.tieba.i.e gtT;
    private String gtU;
    private boolean gtV;
    private d gtW;
    private boolean gtX;
    private int gtY;
    private boolean gtZ;
    private g.f guA;
    private g.a guB;
    private g.InterfaceC0219g guC;
    private Runnable guD;
    private int gua;
    private boolean gub;
    private SurfaceTexture guc;
    private boolean gud;
    private com.baidu.tieba.play.b.a gue;
    private r guf;
    private com.baidu.tieba.play.b.f gug;
    private String guh;
    private long gui;
    private boolean guj;
    private long guk;
    private long gul;
    private int gur;
    private int gus;
    private int gut;
    private int guu;
    private int guv;
    private int guw;
    private Runnable gux;
    private Runnable guy;
    private TextureView.SurfaceTextureListener guz;
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
            gtQ = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            gtR = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gud = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gtV = false;
        this.gtX = false;
        this.gtY = 0;
        this.gtZ = false;
        this.gua = -1;
        this.gub = false;
        this.guc = null;
        this.gud = true;
        this.guk = 0L;
        this.gul = 0L;
        this.geI = guq;
        this.gur = 0;
        this.gus = 0;
        this.gut = -1;
        this.guu = 0;
        this.guv = 0;
        this.guw = 0;
        this.bTK = 0;
        this.gux = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtO != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtO, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.guy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.ji(false);
                }
            }
        };
        this.guz = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gtX) {
                    QuickVideoView.this.gtX = false;
                    if (QuickVideoView.this.gtO != null) {
                        QuickVideoView.this.gtO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aov, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtS.aWS();
                    }
                } else if (QuickVideoView.this.gtO != null && QuickVideoView.this.gub) {
                    QuickVideoView.this.gtO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aov, surfaceTexture, QuickVideoView.this.gua);
                    if (QuickVideoView.this.gtB != null) {
                        QuickVideoView.this.gtB.bld();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtS.aWT();
                    }
                }
                QuickVideoView.this.guc = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blt();
                QuickVideoView.this.lO(false);
                if (QuickVideoView.this.gtO != null) {
                    QuickVideoView.this.gtO.release();
                }
                if (!QuickVideoView.this.gtX) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.onStop();
                    }
                    if (QuickVideoView.this.cbh != null) {
                        QuickVideoView.this.cbh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.guc = null;
                if (QuickVideoView.this.gtS != null && QuickVideoView.this.gtS.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtS = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.guA = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blt();
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.onPrepared();
                }
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.sh(QuickVideoView.this.gtO.getPlayerType());
                }
                if (QuickVideoView.this.bPD != null) {
                    QuickVideoView.this.bPD.onPrepared(gVar);
                }
                if (QuickVideoView.this.gtW != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtO != null) {
                        j = QuickVideoView.this.gtO.getDuration();
                    }
                    QuickVideoView.this.gtW.cK(j);
                    QuickVideoView.this.bls();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gtW.blk();
                        QuickVideoView.this.blv();
                    }
                }
                if (QuickVideoView.this.gtV) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtM != null && gVar != null) {
                    QuickVideoView.this.gtM.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtY);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtN) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtN);
                }
                if (QuickVideoView.this.gue != null && QuickVideoView.this.gue.bmb()) {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guB = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lO(true);
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtS = null;
                }
                if (!QuickVideoView.this.gtZ || QuickVideoView.this.gtW == null) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.onCompletion();
                    }
                    QuickVideoView.this.gtV = false;
                    if (QuickVideoView.this.bPC != null) {
                        QuickVideoView.this.bPC.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtU = null;
                QuickVideoView.this.gui = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gtW.ble());
                QuickVideoView.this.start();
            }
        };
        this.bPF = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ah(i, i2, i3);
                QuickVideoView.this.blt();
                if (QuickVideoView.this.gtW != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.guj = true;
                    z.blV().aB(QuickVideoView.this.gtW.ble(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtS != null) {
                        QuickVideoView.this.gtU = QuickVideoView.this.gtS.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gui, QuickVideoView.this.I(QuickVideoView.this.gtS.aWY(), i3 + "", QuickVideoView.this.gtS.aWZ()));
                        QuickVideoView.this.gtS = null;
                    }
                    QuickVideoView.this.gui = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tU(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPE == null || QuickVideoView.this.bPE.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.guC = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.guj) {
                    QuickVideoView.this.guj = false;
                    return;
                }
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.blF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gtW != null && z) {
                    QuickVideoView.this.gtW.onSeekComplete();
                }
                if (QuickVideoView.this.bPH != null) {
                    QuickVideoView.this.bPH.b(gVar);
                }
            }
        };
        this.bPG = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gtP != null) {
                    QuickVideoView.this.gtP.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gtY = i2;
                    if (QuickVideoView.this.gtM != null && gVar != null) {
                        QuickVideoView.this.gtM.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtY);
                    }
                }
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.a(i, i2, QuickVideoView.this.gtS);
                    return true;
                }
                return true;
            }
        };
        this.bPI = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.i(i, i2, str);
                }
            }
        };
        this.bPJ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.pG(str);
                }
            }
        };
        this.bPK = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gui = j;
                }
            }
        };
        this.guD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gtW != null && QuickVideoView.this.gtW.blg() && QuickVideoView.this.gtW.blh() && QuickVideoView.this.gtW.bli() && QuickVideoView.this.gtO != null) {
                    int Tl = QuickVideoView.this.gtO.Tl();
                    int currentPosition = QuickVideoView.this.gtO.getCurrentPosition();
                    int duration = QuickVideoView.this.gtO.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guk;
                    boolean z = currentPosition + Tl < duration;
                    if (Tl < QuickVideoView.this.gtW.blj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.guk = currentTimeMillis;
                        QuickVideoView.this.gtW.tR(0);
                    }
                    if (QuickVideoView.this.blu() && currentPosition == QuickVideoView.this.gul && j > 500) {
                        QuickVideoView.this.guk = currentTimeMillis;
                        QuickVideoView.this.gtW.tR(0);
                    }
                    QuickVideoView.this.gul = currentPosition;
                    if (QuickVideoView.this.geI == QuickVideoView.gup) {
                        QuickVideoView.this.blv();
                    }
                }
            }
        };
        this.bPQ = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.blm();
                    }
                    if (QuickVideoView.this.gtS != null) {
                        QuickVideoView.this.gtS.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtS = null;
                    }
                    QuickVideoView.this.blt();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtV = false;
        this.gtX = false;
        this.gtY = 0;
        this.gtZ = false;
        this.gua = -1;
        this.gub = false;
        this.guc = null;
        this.gud = true;
        this.guk = 0L;
        this.gul = 0L;
        this.geI = guq;
        this.gur = 0;
        this.gus = 0;
        this.gut = -1;
        this.guu = 0;
        this.guv = 0;
        this.guw = 0;
        this.bTK = 0;
        this.gux = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtO != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtO, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.guy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.ji(false);
                }
            }
        };
        this.guz = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gtX) {
                    QuickVideoView.this.gtX = false;
                    if (QuickVideoView.this.gtO != null) {
                        QuickVideoView.this.gtO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aov, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtS.aWS();
                    }
                } else if (QuickVideoView.this.gtO != null && QuickVideoView.this.gub) {
                    QuickVideoView.this.gtO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aov, surfaceTexture, QuickVideoView.this.gua);
                    if (QuickVideoView.this.gtB != null) {
                        QuickVideoView.this.gtB.bld();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtS.aWT();
                    }
                }
                QuickVideoView.this.guc = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blt();
                QuickVideoView.this.lO(false);
                if (QuickVideoView.this.gtO != null) {
                    QuickVideoView.this.gtO.release();
                }
                if (!QuickVideoView.this.gtX) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.onStop();
                    }
                    if (QuickVideoView.this.cbh != null) {
                        QuickVideoView.this.cbh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.guc = null;
                if (QuickVideoView.this.gtS != null && QuickVideoView.this.gtS.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtS = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.guA = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blt();
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.onPrepared();
                }
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.sh(QuickVideoView.this.gtO.getPlayerType());
                }
                if (QuickVideoView.this.bPD != null) {
                    QuickVideoView.this.bPD.onPrepared(gVar);
                }
                if (QuickVideoView.this.gtW != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtO != null) {
                        j = QuickVideoView.this.gtO.getDuration();
                    }
                    QuickVideoView.this.gtW.cK(j);
                    QuickVideoView.this.bls();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gtW.blk();
                        QuickVideoView.this.blv();
                    }
                }
                if (QuickVideoView.this.gtV) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtM != null && gVar != null) {
                    QuickVideoView.this.gtM.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtY);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtN) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtN);
                }
                if (QuickVideoView.this.gue != null && QuickVideoView.this.gue.bmb()) {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guB = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lO(true);
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtS = null;
                }
                if (!QuickVideoView.this.gtZ || QuickVideoView.this.gtW == null) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.onCompletion();
                    }
                    QuickVideoView.this.gtV = false;
                    if (QuickVideoView.this.bPC != null) {
                        QuickVideoView.this.bPC.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtU = null;
                QuickVideoView.this.gui = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gtW.ble());
                QuickVideoView.this.start();
            }
        };
        this.bPF = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ah(i, i2, i3);
                QuickVideoView.this.blt();
                if (QuickVideoView.this.gtW != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.guj = true;
                    z.blV().aB(QuickVideoView.this.gtW.ble(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtS != null) {
                        QuickVideoView.this.gtU = QuickVideoView.this.gtS.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gui, QuickVideoView.this.I(QuickVideoView.this.gtS.aWY(), i3 + "", QuickVideoView.this.gtS.aWZ()));
                        QuickVideoView.this.gtS = null;
                    }
                    QuickVideoView.this.gui = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tU(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPE == null || QuickVideoView.this.bPE.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.guC = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.guj) {
                    QuickVideoView.this.guj = false;
                    return;
                }
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.blF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gtW != null && z) {
                    QuickVideoView.this.gtW.onSeekComplete();
                }
                if (QuickVideoView.this.bPH != null) {
                    QuickVideoView.this.bPH.b(gVar);
                }
            }
        };
        this.bPG = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gtP != null) {
                    QuickVideoView.this.gtP.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gtY = i2;
                    if (QuickVideoView.this.gtM != null && gVar != null) {
                        QuickVideoView.this.gtM.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtY);
                    }
                }
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.a(i, i2, QuickVideoView.this.gtS);
                    return true;
                }
                return true;
            }
        };
        this.bPI = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.i(i, i2, str);
                }
            }
        };
        this.bPJ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.pG(str);
                }
            }
        };
        this.bPK = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gui = j;
                }
            }
        };
        this.guD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gtW != null && QuickVideoView.this.gtW.blg() && QuickVideoView.this.gtW.blh() && QuickVideoView.this.gtW.bli() && QuickVideoView.this.gtO != null) {
                    int Tl = QuickVideoView.this.gtO.Tl();
                    int currentPosition = QuickVideoView.this.gtO.getCurrentPosition();
                    int duration = QuickVideoView.this.gtO.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guk;
                    boolean z = currentPosition + Tl < duration;
                    if (Tl < QuickVideoView.this.gtW.blj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.guk = currentTimeMillis;
                        QuickVideoView.this.gtW.tR(0);
                    }
                    if (QuickVideoView.this.blu() && currentPosition == QuickVideoView.this.gul && j > 500) {
                        QuickVideoView.this.guk = currentTimeMillis;
                        QuickVideoView.this.gtW.tR(0);
                    }
                    QuickVideoView.this.gul = currentPosition;
                    if (QuickVideoView.this.geI == QuickVideoView.gup) {
                        QuickVideoView.this.blv();
                    }
                }
            }
        };
        this.bPQ = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.blm();
                    }
                    if (QuickVideoView.this.gtS != null) {
                        QuickVideoView.this.gtS.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtS = null;
                    }
                    QuickVideoView.this.blt();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtV = false;
        this.gtX = false;
        this.gtY = 0;
        this.gtZ = false;
        this.gua = -1;
        this.gub = false;
        this.guc = null;
        this.gud = true;
        this.guk = 0L;
        this.gul = 0L;
        this.geI = guq;
        this.gur = 0;
        this.gus = 0;
        this.gut = -1;
        this.guu = 0;
        this.guv = 0;
        this.guw = 0;
        this.bTK = 0;
        this.gux = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtO != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtO, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.guy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.ji(false);
                }
            }
        };
        this.guz = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gtX) {
                    QuickVideoView.this.gtX = false;
                    if (QuickVideoView.this.gtO != null) {
                        QuickVideoView.this.gtO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aov, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtS.aWS();
                    }
                } else if (QuickVideoView.this.gtO != null && QuickVideoView.this.gub) {
                    QuickVideoView.this.gtO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aov, surfaceTexture, QuickVideoView.this.gua);
                    if (QuickVideoView.this.gtB != null) {
                        QuickVideoView.this.gtB.bld();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtS.aWT();
                    }
                }
                QuickVideoView.this.guc = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blt();
                QuickVideoView.this.lO(false);
                if (QuickVideoView.this.gtO != null) {
                    QuickVideoView.this.gtO.release();
                }
                if (!QuickVideoView.this.gtX) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.onStop();
                    }
                    if (QuickVideoView.this.cbh != null) {
                        QuickVideoView.this.cbh.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.guc = null;
                if (QuickVideoView.this.gtS != null && QuickVideoView.this.gtS.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtS = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.guA = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blt();
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.onPrepared();
                }
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.sh(QuickVideoView.this.gtO.getPlayerType());
                }
                if (QuickVideoView.this.bPD != null) {
                    QuickVideoView.this.bPD.onPrepared(gVar);
                }
                if (QuickVideoView.this.gtW != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtO != null) {
                        j = QuickVideoView.this.gtO.getDuration();
                    }
                    QuickVideoView.this.gtW.cK(j);
                    QuickVideoView.this.bls();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gtW.blk();
                        QuickVideoView.this.blv();
                    }
                }
                if (QuickVideoView.this.gtV) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtM != null && gVar != null) {
                    QuickVideoView.this.gtM.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtY);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtN) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtN);
                }
                if (QuickVideoView.this.gue != null && QuickVideoView.this.gue.bmb()) {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guB = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lO(true);
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtS = null;
                }
                if (!QuickVideoView.this.gtZ || QuickVideoView.this.gtW == null) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.onCompletion();
                    }
                    QuickVideoView.this.gtV = false;
                    if (QuickVideoView.this.bPC != null) {
                        QuickVideoView.this.bPC.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtU = null;
                QuickVideoView.this.gui = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gtW.ble());
                QuickVideoView.this.start();
            }
        };
        this.bPF = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ah(i2, i22, i3);
                QuickVideoView.this.blt();
                if (QuickVideoView.this.gtW != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.guj = true;
                    z.blV().aB(QuickVideoView.this.gtW.ble(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtS != null) {
                        QuickVideoView.this.gtU = QuickVideoView.this.gtS.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gui, QuickVideoView.this.I(QuickVideoView.this.gtS.aWY(), i3 + "", QuickVideoView.this.gtS.aWZ()));
                        QuickVideoView.this.gtS = null;
                    }
                    QuickVideoView.this.gui = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.tU(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPE == null || QuickVideoView.this.bPE.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.guC = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (QuickVideoView.this.guj) {
                    QuickVideoView.this.guj = false;
                    return;
                }
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.blF();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gtW != null && z) {
                    QuickVideoView.this.gtW.onSeekComplete();
                }
                if (QuickVideoView.this.bPH != null) {
                    QuickVideoView.this.bPH.b(gVar);
                }
            }
        };
        this.bPG = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gtP != null) {
                    QuickVideoView.this.gtP.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gtY = i22;
                    if (QuickVideoView.this.gtM != null && gVar != null) {
                        QuickVideoView.this.gtM.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtY);
                    }
                }
                if (QuickVideoView.this.guf != null) {
                    QuickVideoView.this.guf.a(i2, i22, QuickVideoView.this.gtS);
                    return true;
                }
                return true;
            }
        };
        this.bPI = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.i(i2, i22, str);
                }
            }
        };
        this.bPJ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtS != null) {
                    QuickVideoView.this.gtS.pG(str);
                }
            }
        };
        this.bPK = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gui = j;
                }
            }
        };
        this.guD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gtW != null && QuickVideoView.this.gtW.blg() && QuickVideoView.this.gtW.blh() && QuickVideoView.this.gtW.bli() && QuickVideoView.this.gtO != null) {
                    int Tl = QuickVideoView.this.gtO.Tl();
                    int currentPosition = QuickVideoView.this.gtO.getCurrentPosition();
                    int duration = QuickVideoView.this.gtO.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.guk;
                    boolean z = currentPosition + Tl < duration;
                    if (Tl < QuickVideoView.this.gtW.blj() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.guk = currentTimeMillis;
                        QuickVideoView.this.gtW.tR(0);
                    }
                    if (QuickVideoView.this.blu() && currentPosition == QuickVideoView.this.gul && j > 500) {
                        QuickVideoView.this.guk = currentTimeMillis;
                        QuickVideoView.this.gtW.tR(0);
                    }
                    QuickVideoView.this.gul = currentPosition;
                    if (QuickVideoView.this.geI == QuickVideoView.gup) {
                        QuickVideoView.this.blv();
                    }
                }
            }
        };
        this.bPQ = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gtW != null) {
                        QuickVideoView.this.gtW.blm();
                    }
                    if (QuickVideoView.this.gtS != null) {
                        QuickVideoView.this.gtS.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtS = null;
                    }
                    QuickVideoView.this.blt();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gtM = new o(context);
        this.gtM.setSurfaceTextureListener(this.guz);
        if (gtQ != null) {
            this.gtO = gtQ.Tm();
        }
        if (this.gtO != null) {
            this.gtO.setOnPreparedListener(this.guA);
            this.gtO.setOnCompletionListener(this.guB);
            this.gtO.a(this.bPF);
            this.gtO.setOnSeekCompleteListener(this.guC);
            this.gtO.a(this.bPG);
            this.gtO.a(this.bPI);
            this.gtO.a(this.bPJ);
            this.gtO.a(this.bPK);
        }
        aj.t(this, d.C0140d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(Constants.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gue = new com.baidu.tieba.play.b.a(this);
        this.guf = new r();
        this.gug = new com.baidu.tieba.play.b.f();
    }

    public void bN(String str, String str2) {
        this.bDf = str2;
        if (this.gue != null) {
            this.gue.clear();
            this.gue.bmb();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.rq(str2);
            if (gtR != null) {
                this.gtS = gtR.H(this.bDf, str, "");
                if (this.gtS != null) {
                    this.gtS.a(-300, -44399, -44399, getLocateSource(), false, this.gui, "");
                    this.gtS = null;
                }
            }
        }
        if (this.gtT != null) {
            this.gtT.a(null);
            this.gtT.aWL();
            this.gtT = null;
        }
        this.gtU = null;
        this.gui = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.gtS != null) {
            this.gtS.aWX();
            this.gtS = null;
        }
        if (!am.isEmpty(str)) {
            this.guh = str;
            if (i(Uri.parse(str)) != null) {
                this.gtS.aWR();
            }
            if (this.gtW != null) {
                str = this.gtW.hW(str);
                if (this.gtW.bll() != null) {
                    this.gtW.bll().setPlayer(this);
                }
                if (gtR != null && ri(str)) {
                    this.gtT = gtR.pI(str);
                }
                if (this.gtT != null) {
                    this.gtT.a(new com.baidu.tieba.play.monitor.a(this.bDf, this.guh, this.gtS));
                    this.gtT.aWK();
                }
                rh(str);
            }
            if (!com.baidu.adp.lib.util.j.oJ() && !ri(str)) {
                if (this.bPE != null) {
                    this.bPE.onError(this.gtO, Constants.BDUSS_EXCEPRION, Constants.BDUSS_EXCEPRION);
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
            if (this.gtW != null && (this.gtW.blf() || this.gtW.blg())) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gux);
                com.baidu.adp.lib.g.e.ns().postDelayed(this.gux, com.baidu.tbadk.coreExtra.model.f.IK());
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guy);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.guy, com.baidu.tbadk.coreExtra.model.f.IJ());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (i(uri) != null) {
            this.gtS.pC(uri.toString());
        }
        blr();
        this.gtX = true;
        this.mUri = uri;
        this.aov = map;
        this.gtY = 0;
        removeView(this.gtM);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gud) {
            addView(this.gtM, layoutParams);
        } else {
            addView(this.gtM, 0, layoutParams);
        }
        aj.t(this, d.C0140d.cp_bg_line_k);
    }

    private void blr() {
        this.gtX = false;
        this.gtV = false;
        if (this.gtO != null) {
            this.gtO.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guD);
    }

    private void rh(String str) {
        this.gus = 0;
        this.gut = 0;
        this.guu = 0;
        this.guv = 0;
        this.guw = 0;
        this.bTK = 0;
        if (this.gtW.blg()) {
            this.gur = gun;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gut = (int) u.rk(QuickVideoView.this.guh);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.guh != null && this.guh.equals(str)) {
            this.gur = gum;
        } else {
            this.gur = guo;
        }
        this.geI = gup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bls() {
        this.geI = gup;
        if (this.gtO != null) {
            this.gus = this.gtO.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (this.geI == gup && this.gtO != null) {
            this.geI = guq;
            this.guv = this.gtO.getDuration();
            if (z) {
                this.guw = 0;
                this.guu = this.guv;
            } else {
                this.guu = this.gtO.getCurrentPosition();
                this.guw = this.gtO.getCachedSize();
            }
            if (this.guu > 0) {
                if (this.gur == gum) {
                    this.gut = (int) u.rk(this.guh);
                    if (this.gus > 0) {
                        long j = (this.gus * (this.guu / 1000)) / 8;
                        if (this.guw < 0) {
                            this.guw = 0;
                        }
                        long j2 = this.guw + j;
                        if (this.gut > 0) {
                            j2 += this.gut;
                        }
                        a(j2, this.guu, this.guv, this.bTK);
                    } else if (this.gus == -1) {
                        this.gus = 603327;
                        a((this.gus * (this.guu / 1000)) / 8, this.guu, this.guv, this.bTK);
                    }
                } else if (this.gur == gun) {
                    if (this.gus > 0) {
                        long j3 = (this.gus * (this.guu / 1000)) / 8;
                        if (this.guw < 0) {
                            this.guw = 0;
                        }
                        long j4 = this.guw + j3;
                        if (this.gut > 0) {
                            j4 -= this.gut;
                        }
                        a(j4, this.guu, this.guv, this.bTK);
                    } else if (this.gus == -1) {
                        this.gus = 603327;
                        a((this.gus * (this.guu / 1000)) / 8, this.guu, this.guv, this.bTK);
                    }
                } else {
                    a(0L, this.guu, this.guv, this.bTK);
                }
            }
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guD);
    }

    public void stopPlayback() {
        blt();
        lO(false);
        if (this.gue != null) {
            this.gue.clear();
        }
        this.gtN = null;
        blr();
        this.gtZ = false;
        if (this.gtW != null) {
            this.gtW.onStop();
        }
        com.baidu.tieba.play.a.b.blY().a((b.InterfaceC0216b) null);
        if (this.gtS != null && this.gtS.pF(getLocateSource())) {
            this.gtS = null;
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gux);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guy);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bPD = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bPC = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bPE = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0219g interfaceC0219g) {
        this.bPH = interfaceC0219g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I(String str, String str2, String str3) {
        if (this.gug == null) {
            return "";
        }
        String bmd = this.gug.bmd();
        this.gug.J(str, str2, str3);
        return bmd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gtW != null && !StringUtils.isNull(this.gtW.ble())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.rp(uri);
            }
            this.mUri = Uri.parse(this.gtW.ble());
        }
        boolean z = false;
        if (this.gue != null) {
            z = this.gue.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gtS != null) {
            this.gtU = this.gtS.a(i, i2, i3, getLocateSource(), z, this.gui, I(this.gtS.aWY(), i3 + "", this.gtS.aWZ()));
            this.gtS = null;
        }
        this.gui = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gtO != null) {
            try {
                this.gtO.release();
                this.gtN = str;
                URI uri = new URI(this.mUri.toString());
                this.gtO.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.aov, this.guc, this.mUri.getHost());
                if (i(this.mUri) != null) {
                    this.gtS.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gtO != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gtO.release();
            this.gtO.a(this.mContext, this.mUri, this.aov, this.guc, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gtS.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gtO != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gtO.forceUseSystemMediaPlayer(true);
            }
            this.gtO.release();
            this.gtO.a(this.mContext, this.mUri, this.aov, this.guc, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gtS.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gtV = true;
        if (this.gtO != null) {
            if (this.guc != null && this.gub && !this.gtO.isExistInRemote()) {
                this.gtO.a(this.mContext, this.mUri, this.aov, this.guc, this.gua);
                if (this.gtB != null) {
                    this.gtB.bld();
                }
                if (i(this.mUri) != null) {
                    this.gtS.aWT();
                }
                blq();
                return;
            }
            this.gtO.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gtW != null) {
            this.gtW.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (i(this.mUri) != null) {
            this.gtS.si(this.gtO.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        blt();
        if (this.gtO != null) {
            this.gtO.pause();
        }
        if (this.gtW != null) {
            this.gtW.onPause();
        }
        this.gtV = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gtS != null) {
            this.gtS.aWW();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gtO != null) {
            return this.gtO.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gtO != null) {
            return this.gtO.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bTK = i;
        tS(i);
    }

    public void tS(int i) {
        if (this.guf != null) {
            this.guf.blE();
        }
        if (this.gtO != null) {
            this.gtO.seekTo(i);
        }
        if (this.gtW != null) {
            this.gtW.tR(0);
            blv();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gtO != null) {
            return this.gtO.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gtO != null) {
            this.gtO.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gua = i;
    }

    public int getRecoveryState() {
        return this.gua;
    }

    public void setNeedRecovery(boolean z) {
        this.gub = z;
    }

    public void setLooping(boolean z) {
        this.gtZ = z;
    }

    public boolean blu() {
        return this.gtV;
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
        this.cbh = bVar;
    }

    public void setBusiness(d dVar) {
        this.gtW = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bPQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gtZ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gtO != null) {
            this.gtO.Pk();
        }
        if (this.guf != null) {
            this.guf.blG();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guD);
        MessageManager.getInstance().unRegisterListener(this.bPQ);
        if (this.gue != null) {
            this.gue.clear();
        }
        if (this.gtT != null) {
            this.gtT.a(null);
            this.gtT.aWL();
        }
    }

    public g getPlayer() {
        return this.gtO;
    }

    public int getPlayerType() {
        if (this.gtO == null) {
            return -300;
        }
        return this.gtO.getPlayerType();
    }

    public void blv() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guD);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.guD, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gtB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gtW instanceof n) || ((n) this.gtW).blC() == null) ? "" : ((n) this.gtW).blC().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i i(Uri uri) {
        String uri2;
        if (this.gtS != null) {
            return this.gtS;
        }
        if (!StringUtils.isNull(this.guh)) {
            uri2 = this.guh;
        } else if (gtR != null && this.gtW != null && !StringUtils.isNull(this.gtW.ble())) {
            uri2 = this.gtW.ble();
        } else {
            uri2 = (gtR == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gtR != null) {
            this.gtS = gtR.H(this.bDf, uri2, this.gtU);
        }
        this.gtU = null;
        this.gui = 0L;
        return this.gtS;
    }

    public void a(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gtS, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gtS, j);
    }

    public static boolean ri(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gtP = eVar;
    }
}
