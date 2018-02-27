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
    private static h gtF;
    private static com.baidu.tieba.i.k gtG;
    private static int gub = 0;
    private static int guc = 1;
    private static int gud = 2;
    private static int gue = 1;
    private static int guf = 0;
    private Map<String, String> aop;
    private String bCS;
    private final CustomMessageListener bPD;
    private g.a bPp;
    private g.f bPq;
    private g.b bPr;
    private g.c bPs;
    private g.e bPt;
    private g.InterfaceC0220g bPu;
    private g.i bPv;
    private g.d bPw;
    private g.h bPx;
    private int bTy;
    private b caV;
    private int gex;
    private o gtB;
    private String gtC;
    private g gtD;
    private g.e gtE;
    private com.baidu.tieba.i.i gtH;
    private com.baidu.tieba.i.e gtI;
    private String gtJ;
    private boolean gtK;
    private d gtL;
    private boolean gtM;
    private int gtN;
    private boolean gtO;
    private int gtP;
    private boolean gtQ;
    private SurfaceTexture gtR;
    private boolean gtS;
    private com.baidu.tieba.play.b.a gtT;
    private r gtU;
    private com.baidu.tieba.play.b.f gtV;
    private String gtW;
    private long gtX;
    private boolean gtY;
    private long gtZ;
    private a gtq;
    private long gua;
    private int gug;
    private int guh;
    private int gui;
    private int guj;
    private int guk;
    private int gul;
    private Runnable gum;
    private Runnable gun;
    private TextureView.SurfaceTextureListener guo;
    private g.f gup;
    private g.a guq;
    private g.InterfaceC0220g gur;
    private Runnable gus;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void blc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            gtF = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            gtG = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gtS = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gtK = false;
        this.gtM = false;
        this.gtN = 0;
        this.gtO = false;
        this.gtP = -1;
        this.gtQ = false;
        this.gtR = null;
        this.gtS = true;
        this.gtZ = 0L;
        this.gua = 0L;
        this.gex = guf;
        this.gug = 0;
        this.guh = 0;
        this.gui = -1;
        this.guj = 0;
        this.guk = 0;
        this.gul = 0;
        this.bTy = 0;
        this.gum = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtD != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtD, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gun = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.ji(false);
                }
            }
        };
        this.guo = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gtM) {
                    QuickVideoView.this.gtM = false;
                    if (QuickVideoView.this.gtD != null) {
                        QuickVideoView.this.gtD.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtH.aWR();
                    }
                } else if (QuickVideoView.this.gtD != null && QuickVideoView.this.gtQ) {
                    QuickVideoView.this.gtD.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.gtP);
                    if (QuickVideoView.this.gtq != null) {
                        QuickVideoView.this.gtq.blc();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtH.aWS();
                    }
                }
                QuickVideoView.this.gtR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bls();
                QuickVideoView.this.lO(false);
                if (QuickVideoView.this.gtD != null) {
                    QuickVideoView.this.gtD.release();
                }
                if (!QuickVideoView.this.gtM) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.onStop();
                    }
                    if (QuickVideoView.this.caV != null) {
                        QuickVideoView.this.caV.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gtR = null;
                if (QuickVideoView.this.gtH != null && QuickVideoView.this.gtH.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtH = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gup = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bls();
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.onPrepared();
                }
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.si(QuickVideoView.this.gtD.getPlayerType());
                }
                if (QuickVideoView.this.bPq != null) {
                    QuickVideoView.this.bPq.onPrepared(gVar);
                }
                if (QuickVideoView.this.gtL != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtD != null) {
                        j = QuickVideoView.this.gtD.getDuration();
                    }
                    QuickVideoView.this.gtL.cK(j);
                    QuickVideoView.this.blr();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gtL.blj();
                        QuickVideoView.this.blu();
                    }
                }
                if (QuickVideoView.this.gtK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtB != null && gVar != null) {
                    QuickVideoView.this.gtB.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtC) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtC);
                }
                if (QuickVideoView.this.gtT != null && QuickVideoView.this.gtT.bma()) {
                    com.baidu.tieba.play.b.e.tX(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guq = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lO(true);
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtH = null;
                }
                if (!QuickVideoView.this.gtO || QuickVideoView.this.gtL == null) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.onCompletion();
                    }
                    QuickVideoView.this.gtK = false;
                    if (QuickVideoView.this.bPp != null) {
                        QuickVideoView.this.bPp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtJ = null;
                QuickVideoView.this.gtX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gtL.bld());
                QuickVideoView.this.start();
            }
        };
        this.bPs = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ah(i, i2, i3);
                QuickVideoView.this.bls();
                if (QuickVideoView.this.gtL != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gtY = true;
                    z.blU().aB(QuickVideoView.this.gtL.bld(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtH != null) {
                        QuickVideoView.this.gtJ = QuickVideoView.this.gtH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gtX, QuickVideoView.this.I(QuickVideoView.this.gtH.aWX(), i3 + "", QuickVideoView.this.gtH.aWY()));
                        QuickVideoView.this.gtH = null;
                    }
                    QuickVideoView.this.gtX = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPr == null || QuickVideoView.this.bPr.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gur = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.gtY) {
                    QuickVideoView.this.gtY = false;
                    return;
                }
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.blE();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gtL != null && z) {
                    QuickVideoView.this.gtL.onSeekComplete();
                }
                if (QuickVideoView.this.bPu != null) {
                    QuickVideoView.this.bPu.b(gVar);
                }
            }
        };
        this.bPt = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gtE != null) {
                    QuickVideoView.this.gtE.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gtN = i2;
                    if (QuickVideoView.this.gtB != null && gVar != null) {
                        QuickVideoView.this.gtB.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtN);
                    }
                }
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.a(i, i2, QuickVideoView.this.gtH);
                    return true;
                }
                return true;
            }
        };
        this.bPv = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.i(i, i2, str);
                }
            }
        };
        this.bPw = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.pG(str);
                }
            }
        };
        this.bPx = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gtX = j;
                }
            }
        };
        this.gus = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gtL != null && QuickVideoView.this.gtL.blf() && QuickVideoView.this.gtL.blg() && QuickVideoView.this.gtL.blh() && QuickVideoView.this.gtD != null) {
                    int Tk = QuickVideoView.this.gtD.Tk();
                    int currentPosition = QuickVideoView.this.gtD.getCurrentPosition();
                    int duration = QuickVideoView.this.gtD.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gtZ;
                    boolean z = currentPosition + Tk < duration;
                    if (Tk < QuickVideoView.this.gtL.bli() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gtZ = currentTimeMillis;
                        QuickVideoView.this.gtL.tS(0);
                    }
                    if (QuickVideoView.this.blt() && currentPosition == QuickVideoView.this.gua && j > 500) {
                        QuickVideoView.this.gtZ = currentTimeMillis;
                        QuickVideoView.this.gtL.tS(0);
                    }
                    QuickVideoView.this.gua = currentPosition;
                    if (QuickVideoView.this.gex == QuickVideoView.gue) {
                        QuickVideoView.this.blu();
                    }
                }
            }
        };
        this.bPD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.bll();
                    }
                    if (QuickVideoView.this.gtH != null) {
                        QuickVideoView.this.gtH.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtH = null;
                    }
                    QuickVideoView.this.bls();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtK = false;
        this.gtM = false;
        this.gtN = 0;
        this.gtO = false;
        this.gtP = -1;
        this.gtQ = false;
        this.gtR = null;
        this.gtS = true;
        this.gtZ = 0L;
        this.gua = 0L;
        this.gex = guf;
        this.gug = 0;
        this.guh = 0;
        this.gui = -1;
        this.guj = 0;
        this.guk = 0;
        this.gul = 0;
        this.bTy = 0;
        this.gum = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtD != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtD, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gun = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.ji(false);
                }
            }
        };
        this.guo = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gtM) {
                    QuickVideoView.this.gtM = false;
                    if (QuickVideoView.this.gtD != null) {
                        QuickVideoView.this.gtD.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtH.aWR();
                    }
                } else if (QuickVideoView.this.gtD != null && QuickVideoView.this.gtQ) {
                    QuickVideoView.this.gtD.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.gtP);
                    if (QuickVideoView.this.gtq != null) {
                        QuickVideoView.this.gtq.blc();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtH.aWS();
                    }
                }
                QuickVideoView.this.gtR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bls();
                QuickVideoView.this.lO(false);
                if (QuickVideoView.this.gtD != null) {
                    QuickVideoView.this.gtD.release();
                }
                if (!QuickVideoView.this.gtM) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.onStop();
                    }
                    if (QuickVideoView.this.caV != null) {
                        QuickVideoView.this.caV.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gtR = null;
                if (QuickVideoView.this.gtH != null && QuickVideoView.this.gtH.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtH = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gup = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bls();
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.onPrepared();
                }
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.si(QuickVideoView.this.gtD.getPlayerType());
                }
                if (QuickVideoView.this.bPq != null) {
                    QuickVideoView.this.bPq.onPrepared(gVar);
                }
                if (QuickVideoView.this.gtL != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtD != null) {
                        j = QuickVideoView.this.gtD.getDuration();
                    }
                    QuickVideoView.this.gtL.cK(j);
                    QuickVideoView.this.blr();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gtL.blj();
                        QuickVideoView.this.blu();
                    }
                }
                if (QuickVideoView.this.gtK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtB != null && gVar != null) {
                    QuickVideoView.this.gtB.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtC) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtC);
                }
                if (QuickVideoView.this.gtT != null && QuickVideoView.this.gtT.bma()) {
                    com.baidu.tieba.play.b.e.tX(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guq = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lO(true);
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtH = null;
                }
                if (!QuickVideoView.this.gtO || QuickVideoView.this.gtL == null) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.onCompletion();
                    }
                    QuickVideoView.this.gtK = false;
                    if (QuickVideoView.this.bPp != null) {
                        QuickVideoView.this.bPp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtJ = null;
                QuickVideoView.this.gtX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gtL.bld());
                QuickVideoView.this.start();
            }
        };
        this.bPs = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.ah(i, i2, i3);
                QuickVideoView.this.bls();
                if (QuickVideoView.this.gtL != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gtY = true;
                    z.blU().aB(QuickVideoView.this.gtL.bld(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtH != null) {
                        QuickVideoView.this.gtJ = QuickVideoView.this.gtH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gtX, QuickVideoView.this.I(QuickVideoView.this.gtH.aWX(), i3 + "", QuickVideoView.this.gtH.aWY()));
                        QuickVideoView.this.gtH = null;
                    }
                    QuickVideoView.this.gtX = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPr == null || QuickVideoView.this.bPr.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gur = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.gtY) {
                    QuickVideoView.this.gtY = false;
                    return;
                }
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.blE();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gtL != null && z) {
                    QuickVideoView.this.gtL.onSeekComplete();
                }
                if (QuickVideoView.this.bPu != null) {
                    QuickVideoView.this.bPu.b(gVar);
                }
            }
        };
        this.bPt = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gtE != null) {
                    QuickVideoView.this.gtE.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gtN = i2;
                    if (QuickVideoView.this.gtB != null && gVar != null) {
                        QuickVideoView.this.gtB.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtN);
                    }
                }
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.a(i, i2, QuickVideoView.this.gtH);
                    return true;
                }
                return true;
            }
        };
        this.bPv = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.i(i, i2, str);
                }
            }
        };
        this.bPw = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.pG(str);
                }
            }
        };
        this.bPx = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gtX = j;
                }
            }
        };
        this.gus = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gtL != null && QuickVideoView.this.gtL.blf() && QuickVideoView.this.gtL.blg() && QuickVideoView.this.gtL.blh() && QuickVideoView.this.gtD != null) {
                    int Tk = QuickVideoView.this.gtD.Tk();
                    int currentPosition = QuickVideoView.this.gtD.getCurrentPosition();
                    int duration = QuickVideoView.this.gtD.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gtZ;
                    boolean z = currentPosition + Tk < duration;
                    if (Tk < QuickVideoView.this.gtL.bli() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gtZ = currentTimeMillis;
                        QuickVideoView.this.gtL.tS(0);
                    }
                    if (QuickVideoView.this.blt() && currentPosition == QuickVideoView.this.gua && j > 500) {
                        QuickVideoView.this.gtZ = currentTimeMillis;
                        QuickVideoView.this.gtL.tS(0);
                    }
                    QuickVideoView.this.gua = currentPosition;
                    if (QuickVideoView.this.gex == QuickVideoView.gue) {
                        QuickVideoView.this.blu();
                    }
                }
            }
        };
        this.bPD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.bll();
                    }
                    if (QuickVideoView.this.gtH != null) {
                        QuickVideoView.this.gtH.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtH = null;
                    }
                    QuickVideoView.this.bls();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtK = false;
        this.gtM = false;
        this.gtN = 0;
        this.gtO = false;
        this.gtP = -1;
        this.gtQ = false;
        this.gtR = null;
        this.gtS = true;
        this.gtZ = 0L;
        this.gua = 0L;
        this.gex = guf;
        this.gug = 0;
        this.guh = 0;
        this.gui = -1;
        this.guj = 0;
        this.guk = 0;
        this.gul = 0;
        this.bTy = 0;
        this.gum = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtD != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gtD, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gun = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.ji(false);
                }
            }
        };
        this.guo = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gtM) {
                    QuickVideoView.this.gtM = false;
                    if (QuickVideoView.this.gtD != null) {
                        QuickVideoView.this.gtD.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtH.aWR();
                    }
                } else if (QuickVideoView.this.gtD != null && QuickVideoView.this.gtQ) {
                    QuickVideoView.this.gtD.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aop, surfaceTexture, QuickVideoView.this.gtP);
                    if (QuickVideoView.this.gtq != null) {
                        QuickVideoView.this.gtq.blc();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gtH.aWS();
                    }
                }
                QuickVideoView.this.gtR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bls();
                QuickVideoView.this.lO(false);
                if (QuickVideoView.this.gtD != null) {
                    QuickVideoView.this.gtD.release();
                }
                if (!QuickVideoView.this.gtM) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.onStop();
                    }
                    if (QuickVideoView.this.caV != null) {
                        QuickVideoView.this.caV.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gtR = null;
                if (QuickVideoView.this.gtH != null && QuickVideoView.this.gtH.pF(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gtH = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gup = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bls();
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.onPrepared();
                }
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.si(QuickVideoView.this.gtD.getPlayerType());
                }
                if (QuickVideoView.this.bPq != null) {
                    QuickVideoView.this.bPq.onPrepared(gVar);
                }
                if (QuickVideoView.this.gtL != null) {
                    long j = 0;
                    if (QuickVideoView.this.gtD != null) {
                        j = QuickVideoView.this.gtD.getDuration();
                    }
                    QuickVideoView.this.gtL.cK(j);
                    QuickVideoView.this.blr();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gtL.blj();
                        QuickVideoView.this.blu();
                    }
                }
                if (QuickVideoView.this.gtK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gtB != null && gVar != null) {
                    QuickVideoView.this.gtB.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gtC) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gtC);
                }
                if (QuickVideoView.this.gtT != null && QuickVideoView.this.gtT.bma()) {
                    com.baidu.tieba.play.b.e.tX(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.guq = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lO(true);
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.pE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gtH = null;
                }
                if (!QuickVideoView.this.gtO || QuickVideoView.this.gtL == null) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.onCompletion();
                    }
                    QuickVideoView.this.gtK = false;
                    if (QuickVideoView.this.bPp != null) {
                        QuickVideoView.this.bPp.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gtJ = null;
                QuickVideoView.this.gtX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gtL.bld());
                QuickVideoView.this.start();
            }
        };
        this.bPs = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.ah(i2, i22, i3);
                QuickVideoView.this.bls();
                if (QuickVideoView.this.gtL != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gtY = true;
                    z.blU().aB(QuickVideoView.this.gtL.bld(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gtH != null) {
                        QuickVideoView.this.gtJ = QuickVideoView.this.gtH.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gtX, QuickVideoView.this.I(QuickVideoView.this.gtH.aWX(), i3 + "", QuickVideoView.this.gtH.aWY()));
                        QuickVideoView.this.gtH = null;
                    }
                    QuickVideoView.this.gtX = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.tV(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tW(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bPr == null || QuickVideoView.this.bPr.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gur = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0220g
            public void b(g gVar) {
                if (QuickVideoView.this.gtY) {
                    QuickVideoView.this.gtY = false;
                    return;
                }
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.blE();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gtL != null && z) {
                    QuickVideoView.this.gtL.onSeekComplete();
                }
                if (QuickVideoView.this.bPu != null) {
                    QuickVideoView.this.bPu.b(gVar);
                }
            }
        };
        this.bPt = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gtE != null) {
                    QuickVideoView.this.gtE.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gtN = i22;
                    if (QuickVideoView.this.gtB != null && gVar != null) {
                        QuickVideoView.this.gtB.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gtN);
                    }
                }
                if (QuickVideoView.this.gtU != null) {
                    QuickVideoView.this.gtU.a(i2, i22, QuickVideoView.this.gtH);
                    return true;
                }
                return true;
            }
        };
        this.bPv = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.i(i2, i22, str);
                }
            }
        };
        this.bPw = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gtH != null) {
                    QuickVideoView.this.gtH.pG(str);
                }
            }
        };
        this.bPx = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gtX = j;
                }
            }
        };
        this.gus = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gtL != null && QuickVideoView.this.gtL.blf() && QuickVideoView.this.gtL.blg() && QuickVideoView.this.gtL.blh() && QuickVideoView.this.gtD != null) {
                    int Tk = QuickVideoView.this.gtD.Tk();
                    int currentPosition = QuickVideoView.this.gtD.getCurrentPosition();
                    int duration = QuickVideoView.this.gtD.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gtZ;
                    boolean z = currentPosition + Tk < duration;
                    if (Tk < QuickVideoView.this.gtL.bli() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gtZ = currentTimeMillis;
                        QuickVideoView.this.gtL.tS(0);
                    }
                    if (QuickVideoView.this.blt() && currentPosition == QuickVideoView.this.gua && j > 500) {
                        QuickVideoView.this.gtZ = currentTimeMillis;
                        QuickVideoView.this.gtL.tS(0);
                    }
                    QuickVideoView.this.gua = currentPosition;
                    if (QuickVideoView.this.gex == QuickVideoView.gue) {
                        QuickVideoView.this.blu();
                    }
                }
            }
        };
        this.bPD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gtL != null) {
                        QuickVideoView.this.gtL.bll();
                    }
                    if (QuickVideoView.this.gtH != null) {
                        QuickVideoView.this.gtH.pD(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gtH = null;
                    }
                    QuickVideoView.this.bls();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gtB = new o(context);
        this.gtB.setSurfaceTextureListener(this.guo);
        if (gtF != null) {
            this.gtD = gtF.Tl();
        }
        if (this.gtD != null) {
            this.gtD.setOnPreparedListener(this.gup);
            this.gtD.setOnCompletionListener(this.guq);
            this.gtD.a(this.bPs);
            this.gtD.setOnSeekCompleteListener(this.gur);
            this.gtD.a(this.bPt);
            this.gtD.a(this.bPv);
            this.gtD.a(this.bPw);
            this.gtD.a(this.bPx);
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
        this.gtT = new com.baidu.tieba.play.b.a(this);
        this.gtU = new r();
        this.gtV = new com.baidu.tieba.play.b.f();
    }

    public void bN(String str, String str2) {
        this.bCS = str2;
        if (this.gtT != null) {
            this.gtT.clear();
            this.gtT.bma();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.rq(str2);
            if (gtG != null) {
                this.gtH = gtG.H(this.bCS, str, "");
                if (this.gtH != null) {
                    this.gtH.a(-300, -44399, -44399, getLocateSource(), false, this.gtX, "");
                    this.gtH = null;
                }
            }
        }
        if (this.gtI != null) {
            this.gtI.a(null);
            this.gtI.aWK();
            this.gtI = null;
        }
        this.gtJ = null;
        this.gtX = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.gtH != null) {
            this.gtH.aWW();
            this.gtH = null;
        }
        if (!am.isEmpty(str)) {
            this.gtW = str;
            if (i(Uri.parse(str)) != null) {
                this.gtH.aWQ();
            }
            if (this.gtL != null) {
                str = this.gtL.hW(str);
                if (this.gtL.blk() != null) {
                    this.gtL.blk().setPlayer(this);
                }
                if (gtG != null && ri(str)) {
                    this.gtI = gtG.pI(str);
                }
                if (this.gtI != null) {
                    this.gtI.a(new com.baidu.tieba.play.monitor.a(this.bCS, this.gtW, this.gtH));
                    this.gtI.aWJ();
                }
                rh(str);
            }
            if (!com.baidu.adp.lib.util.j.oJ() && !ri(str)) {
                if (this.bPr != null) {
                    this.bPr.onError(this.gtD, Constants.BDUSS_EXCEPRION, Constants.BDUSS_EXCEPRION);
                    return;
                }
                return;
            }
            blp();
            setVideoURI(Uri.parse(str));
        }
    }

    private void blp() {
        if (com.baidu.tbadk.coreExtra.model.f.IK()) {
            if (this.gtL != null && (this.gtL.ble() || this.gtL.blf())) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gum);
                com.baidu.adp.lib.g.e.ns().postDelayed(this.gum, com.baidu.tbadk.coreExtra.model.f.IJ());
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gun);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.gun, com.baidu.tbadk.coreExtra.model.f.II());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (i(uri) != null) {
            this.gtH.pC(uri.toString());
        }
        blq();
        this.gtM = true;
        this.mUri = uri;
        this.aop = map;
        this.gtN = 0;
        removeView(this.gtB);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gtS) {
            addView(this.gtB, layoutParams);
        } else {
            addView(this.gtB, 0, layoutParams);
        }
        aj.t(this, d.C0141d.cp_bg_line_k);
    }

    private void blq() {
        this.gtM = false;
        this.gtK = false;
        if (this.gtD != null) {
            this.gtD.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gus);
    }

    private void rh(String str) {
        this.guh = 0;
        this.gui = 0;
        this.guj = 0;
        this.guk = 0;
        this.gul = 0;
        this.bTy = 0;
        if (this.gtL.blf()) {
            this.gug = guc;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gui = (int) u.rk(QuickVideoView.this.gtW);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gtW != null && this.gtW.equals(str)) {
            this.gug = gub;
        } else {
            this.gug = gud;
        }
        this.gex = gue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        this.gex = gue;
        if (this.gtD != null) {
            this.guh = this.gtD.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (this.gex == gue && this.gtD != null) {
            this.gex = guf;
            this.guk = this.gtD.getDuration();
            if (z) {
                this.gul = 0;
                this.guj = this.guk;
            } else {
                this.guj = this.gtD.getCurrentPosition();
                this.gul = this.gtD.getCachedSize();
            }
            if (this.guj > 0) {
                if (this.gug == gub) {
                    this.gui = (int) u.rk(this.gtW);
                    if (this.guh > 0) {
                        long j = (this.guh * (this.guj / 1000)) / 8;
                        if (this.gul < 0) {
                            this.gul = 0;
                        }
                        long j2 = this.gul + j;
                        if (this.gui > 0) {
                            j2 += this.gui;
                        }
                        a(j2, this.guj, this.guk, this.bTy);
                    } else if (this.guh == -1) {
                        this.guh = 603327;
                        a((this.guh * (this.guj / 1000)) / 8, this.guj, this.guk, this.bTy);
                    }
                } else if (this.gug == guc) {
                    if (this.guh > 0) {
                        long j3 = (this.guh * (this.guj / 1000)) / 8;
                        if (this.gul < 0) {
                            this.gul = 0;
                        }
                        long j4 = this.gul + j3;
                        if (this.gui > 0) {
                            j4 -= this.gui;
                        }
                        a(j4, this.guj, this.guk, this.bTy);
                    } else if (this.guh == -1) {
                        this.guh = 603327;
                        a((this.guh * (this.guj / 1000)) / 8, this.guj, this.guk, this.bTy);
                    }
                } else {
                    a(0L, this.guj, this.guk, this.bTy);
                }
            }
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gus);
    }

    public void stopPlayback() {
        bls();
        lO(false);
        if (this.gtT != null) {
            this.gtT.clear();
        }
        this.gtC = null;
        blq();
        this.gtO = false;
        if (this.gtL != null) {
            this.gtL.onStop();
        }
        com.baidu.tieba.play.a.b.blX().a((b.InterfaceC0217b) null);
        if (this.gtH != null && this.gtH.pF(getLocateSource())) {
            this.gtH = null;
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bls() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gum);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gun);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bPq = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bPp = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bPr = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0220g interfaceC0220g) {
        this.bPu = interfaceC0220g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I(String str, String str2, String str3) {
        if (this.gtV == null) {
            return "";
        }
        String bmc = this.gtV.bmc();
        this.gtV.J(str, str2, str3);
        return bmc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gtL != null && !StringUtils.isNull(this.gtL.bld())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.rp(uri);
            }
            this.mUri = Uri.parse(this.gtL.bld());
        }
        boolean z = false;
        if (this.gtT != null) {
            z = this.gtT.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gtH != null) {
            this.gtJ = this.gtH.a(i, i2, i3, getLocateSource(), z, this.gtX, I(this.gtH.aWX(), i3 + "", this.gtH.aWY()));
            this.gtH = null;
        }
        this.gtX = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gtD != null) {
            try {
                this.gtD.release();
                this.gtC = str;
                URI uri = new URI(this.mUri.toString());
                this.gtD.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.aop, this.gtR, this.mUri.getHost());
                if (i(this.mUri) != null) {
                    this.gtH.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gtD != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gtD.release();
            this.gtD.a(this.mContext, this.mUri, this.aop, this.gtR, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gtH.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gtD != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gtD.forceUseSystemMediaPlayer(true);
            }
            this.gtD.release();
            this.gtD.a(this.mContext, this.mUri, this.aop, this.gtR, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gtH.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gtK = true;
        if (this.gtD != null) {
            if (this.gtR != null && this.gtQ && !this.gtD.isExistInRemote()) {
                this.gtD.a(this.mContext, this.mUri, this.aop, this.gtR, this.gtP);
                if (this.gtq != null) {
                    this.gtq.blc();
                }
                if (i(this.mUri) != null) {
                    this.gtH.aWS();
                }
                blp();
                return;
            }
            this.gtD.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gtL != null) {
            this.gtL.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (i(this.mUri) != null) {
            this.gtH.sj(this.gtD.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bls();
        if (this.gtD != null) {
            this.gtD.pause();
        }
        if (this.gtL != null) {
            this.gtL.onPause();
        }
        this.gtK = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gtH != null) {
            this.gtH.aWV();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gtD != null) {
            return this.gtD.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gtD != null) {
            return this.gtD.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bTy = i;
        tT(i);
    }

    public void tT(int i) {
        if (this.gtU != null) {
            this.gtU.blD();
        }
        if (this.gtD != null) {
            this.gtD.seekTo(i);
        }
        if (this.gtL != null) {
            this.gtL.tS(0);
            blu();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gtD != null) {
            return this.gtD.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gtD != null) {
            this.gtD.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gtP = i;
    }

    public int getRecoveryState() {
        return this.gtP;
    }

    public void setNeedRecovery(boolean z) {
        this.gtQ = z;
    }

    public void setLooping(boolean z) {
        this.gtO = z;
    }

    public boolean blt() {
        return this.gtK;
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
        this.caV = bVar;
    }

    public void setBusiness(d dVar) {
        this.gtL = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bPD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gtO = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gtD != null) {
            this.gtD.Pj();
        }
        if (this.gtU != null) {
            this.gtU.blF();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gus);
        MessageManager.getInstance().unRegisterListener(this.bPD);
        if (this.gtT != null) {
            this.gtT.clear();
        }
        if (this.gtI != null) {
            this.gtI.a(null);
            this.gtI.aWK();
        }
    }

    public g getPlayer() {
        return this.gtD;
    }

    public int getPlayerType() {
        if (this.gtD == null) {
            return -300;
        }
        return this.gtD.getPlayerType();
    }

    public void blu() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gus);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gus, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gtq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gtL instanceof n) || ((n) this.gtL).blB() == null) ? "" : ((n) this.gtL).blB().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i i(Uri uri) {
        String uri2;
        if (this.gtH != null) {
            return this.gtH;
        }
        if (!StringUtils.isNull(this.gtW)) {
            uri2 = this.gtW;
        } else if (gtG != null && this.gtL != null && !StringUtils.isNull(this.gtL.bld())) {
            uri2 = this.gtL.bld();
        } else {
            uri2 = (gtG == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gtG != null) {
            this.gtH = gtG.H(this.bCS, uri2, this.gtJ);
        }
        this.gtJ = null;
        this.gtX = 0L;
        return this.gtH;
    }

    public void a(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gtH, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gtH, j);
    }

    public static boolean ri(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gtE = eVar;
    }
}
