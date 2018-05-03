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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
    private static h fOE;
    private static com.baidu.tieba.j.k fOF;
    private static int fPa = 0;
    private static int fPb = 1;
    private static int fPc = 2;
    private static int fPd = 1;
    private static int fPe = 0;
    private String aNu;
    private final CustomMessageListener aZB;
    private g.a aZn;
    private g.f aZo;
    private g.b aZp;
    private g.c aZq;
    private g.e aZr;
    private g.InterfaceC0202g aZs;
    private g.i aZt;
    private g.d aZu;
    private g.h aZv;
    private int bdE;
    private b bkY;
    private RenderView fOA;
    private String fOB;
    private g fOC;
    private g.e fOD;
    private com.baidu.tieba.j.i fOG;
    private com.baidu.tieba.j.e fOH;
    private String fOI;
    private boolean fOJ;
    private d fOK;
    private boolean fOL;
    private int fOM;
    private boolean fON;
    private int fOO;
    private boolean fOP;
    private SurfaceTexture fOQ;
    private boolean fOR;
    private com.baidu.tieba.play.b.a fOS;
    private q fOT;
    private com.baidu.tieba.play.b.f fOU;
    private String fOV;
    private long fOW;
    private boolean fOX;
    private long fOY;
    private long fOZ;
    private a fOp;
    private int fPf;
    private int fPg;
    private int fPh;
    private int fPi;
    private int fPj;
    private int fPk;
    private Runnable fPl;
    private Runnable fPm;
    private TextureView.SurfaceTextureListener fPn;
    private g.f fPo;
    private g.a fPp;
    private g.InterfaceC0202g fPq;
    private Runnable fPr;
    private int fze;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;
    private Map<String, String> yS;

    /* loaded from: classes.dex */
    public interface a {
        void bgj();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            fOE = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        if (runTask2 != null) {
            fOF = (com.baidu.tieba.j.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fOR = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fOJ = false;
        this.fOL = false;
        this.fOM = 0;
        this.fON = false;
        this.fOO = -1;
        this.fOP = false;
        this.fOQ = null;
        this.fOR = true;
        this.fOY = 0L;
        this.fOZ = 0L;
        this.fze = fPe;
        this.fPf = 0;
        this.fPg = 0;
        this.fPh = -1;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = 0;
        this.bdE = 0;
        this.fPl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOC != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fOC, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fPm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.iJ(false);
                }
            }
        };
        this.fPn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fOL) {
                    QuickVideoView.this.fOL = false;
                    if (QuickVideoView.this.fOC != null) {
                        QuickVideoView.this.fOC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOG.aRN();
                    }
                } else if (QuickVideoView.this.fOC != null && QuickVideoView.this.fOP) {
                    QuickVideoView.this.fOC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.fOO);
                    if (QuickVideoView.this.fOp != null) {
                        QuickVideoView.this.fOp.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOG.aRO();
                    }
                }
                QuickVideoView.this.fOQ = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lt(false);
                if (QuickVideoView.this.fOC != null) {
                    QuickVideoView.this.fOC.release();
                }
                if (!QuickVideoView.this.fOL) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.onStop();
                    }
                    if (QuickVideoView.this.bkY != null) {
                        QuickVideoView.this.bkY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOQ = null;
                if (QuickVideoView.this.fOG != null && QuickVideoView.this.fOG.pL(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOG = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.onPrepared();
                }
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pD(QuickVideoView.this.fOC.getPlayerType());
                }
                if (QuickVideoView.this.aZo != null) {
                    QuickVideoView.this.aZo.onPrepared(gVar);
                }
                if (QuickVideoView.this.fOK != null) {
                    long j = 0;
                    if (QuickVideoView.this.fOC != null) {
                        j = QuickVideoView.this.fOC.getDuration();
                    }
                    QuickVideoView.this.fOK.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fOK.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fOJ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOA != null && gVar != null) {
                    QuickVideoView.this.fOA.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOM);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOB) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fOB);
                }
                if (QuickVideoView.this.fOS != null && QuickVideoView.this.fOS.bhh()) {
                    com.baidu.tieba.play.b.e.ru(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fPp = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lt(true);
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOG = null;
                }
                if (!QuickVideoView.this.fON || QuickVideoView.this.fOK == null) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.onCompletion();
                    }
                    QuickVideoView.this.fOJ = false;
                    if (QuickVideoView.this.aZn != null) {
                        QuickVideoView.this.aZn.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOI = null;
                QuickVideoView.this.fOW = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fOK.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZq = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOK != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fOX = true;
                    x.bhb().aD(QuickVideoView.this.fOK.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOI = QuickVideoView.this.fOG.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOW, QuickVideoView.this.F(QuickVideoView.this.fOG.aRT(), i3 + "", QuickVideoView.this.fOG.aRU()));
                        QuickVideoView.this.fOG = null;
                    }
                    QuickVideoView.this.fOW = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rs(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZp == null || QuickVideoView.this.aZp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.fPq = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fOX) {
                    QuickVideoView.this.fOX = false;
                    return;
                }
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fOK != null && z) {
                    QuickVideoView.this.fOK.onSeekComplete();
                }
                if (QuickVideoView.this.aZs != null) {
                    QuickVideoView.this.aZs.b(gVar);
                }
            }
        };
        this.aZr = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.fOD != null) {
                    QuickVideoView.this.fOD.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.fOM = i2;
                    if (QuickVideoView.this.fOA != null && gVar != null) {
                        QuickVideoView.this.fOA.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOM);
                    }
                }
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.a(i, i2, QuickVideoView.this.fOG);
                    return true;
                }
                return true;
            }
        };
        this.aZt = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.f(i, i2, str);
                }
            }
        };
        this.aZu = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pM(str);
                }
            }
        };
        this.aZv = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOW = j;
                }
            }
        };
        this.fPr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fOK != null && QuickVideoView.this.fOK.bgm() && QuickVideoView.this.fOK.bgn() && QuickVideoView.this.fOK.bgo() && QuickVideoView.this.fOC != null) {
                    int LI = QuickVideoView.this.fOC.LI();
                    int currentPosition = QuickVideoView.this.fOC.getCurrentPosition();
                    int duration = QuickVideoView.this.fOC.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fOY;
                    boolean z = currentPosition + LI < duration;
                    if (LI < QuickVideoView.this.fOK.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fOY = currentTimeMillis;
                        QuickVideoView.this.fOK.rp(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fOZ && j > 500) {
                        QuickVideoView.this.fOY = currentTimeMillis;
                        QuickVideoView.this.fOK.rp(0);
                    }
                    QuickVideoView.this.fOZ = currentPosition;
                    if (QuickVideoView.this.fze == QuickVideoView.fPd) {
                        QuickVideoView.this.bgB();
                    }
                }
            }
        };
        this.aZB = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.bgs();
                    }
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOG.pJ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fOG = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOJ = false;
        this.fOL = false;
        this.fOM = 0;
        this.fON = false;
        this.fOO = -1;
        this.fOP = false;
        this.fOQ = null;
        this.fOR = true;
        this.fOY = 0L;
        this.fOZ = 0L;
        this.fze = fPe;
        this.fPf = 0;
        this.fPg = 0;
        this.fPh = -1;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = 0;
        this.bdE = 0;
        this.fPl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOC != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fOC, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fPm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.iJ(false);
                }
            }
        };
        this.fPn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fOL) {
                    QuickVideoView.this.fOL = false;
                    if (QuickVideoView.this.fOC != null) {
                        QuickVideoView.this.fOC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOG.aRN();
                    }
                } else if (QuickVideoView.this.fOC != null && QuickVideoView.this.fOP) {
                    QuickVideoView.this.fOC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.fOO);
                    if (QuickVideoView.this.fOp != null) {
                        QuickVideoView.this.fOp.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOG.aRO();
                    }
                }
                QuickVideoView.this.fOQ = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lt(false);
                if (QuickVideoView.this.fOC != null) {
                    QuickVideoView.this.fOC.release();
                }
                if (!QuickVideoView.this.fOL) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.onStop();
                    }
                    if (QuickVideoView.this.bkY != null) {
                        QuickVideoView.this.bkY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOQ = null;
                if (QuickVideoView.this.fOG != null && QuickVideoView.this.fOG.pL(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOG = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.onPrepared();
                }
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pD(QuickVideoView.this.fOC.getPlayerType());
                }
                if (QuickVideoView.this.aZo != null) {
                    QuickVideoView.this.aZo.onPrepared(gVar);
                }
                if (QuickVideoView.this.fOK != null) {
                    long j = 0;
                    if (QuickVideoView.this.fOC != null) {
                        j = QuickVideoView.this.fOC.getDuration();
                    }
                    QuickVideoView.this.fOK.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fOK.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fOJ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOA != null && gVar != null) {
                    QuickVideoView.this.fOA.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOM);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOB) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fOB);
                }
                if (QuickVideoView.this.fOS != null && QuickVideoView.this.fOS.bhh()) {
                    com.baidu.tieba.play.b.e.ru(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fPp = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lt(true);
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOG = null;
                }
                if (!QuickVideoView.this.fON || QuickVideoView.this.fOK == null) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.onCompletion();
                    }
                    QuickVideoView.this.fOJ = false;
                    if (QuickVideoView.this.aZn != null) {
                        QuickVideoView.this.aZn.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOI = null;
                QuickVideoView.this.fOW = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fOK.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZq = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOK != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fOX = true;
                    x.bhb().aD(QuickVideoView.this.fOK.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOI = QuickVideoView.this.fOG.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOW, QuickVideoView.this.F(QuickVideoView.this.fOG.aRT(), i3 + "", QuickVideoView.this.fOG.aRU()));
                        QuickVideoView.this.fOG = null;
                    }
                    QuickVideoView.this.fOW = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rs(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZp == null || QuickVideoView.this.aZp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.fPq = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fOX) {
                    QuickVideoView.this.fOX = false;
                    return;
                }
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fOK != null && z) {
                    QuickVideoView.this.fOK.onSeekComplete();
                }
                if (QuickVideoView.this.aZs != null) {
                    QuickVideoView.this.aZs.b(gVar);
                }
            }
        };
        this.aZr = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.fOD != null) {
                    QuickVideoView.this.fOD.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.fOM = i2;
                    if (QuickVideoView.this.fOA != null && gVar != null) {
                        QuickVideoView.this.fOA.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOM);
                    }
                }
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.a(i, i2, QuickVideoView.this.fOG);
                    return true;
                }
                return true;
            }
        };
        this.aZt = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.f(i, i2, str);
                }
            }
        };
        this.aZu = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pM(str);
                }
            }
        };
        this.aZv = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOW = j;
                }
            }
        };
        this.fPr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fOK != null && QuickVideoView.this.fOK.bgm() && QuickVideoView.this.fOK.bgn() && QuickVideoView.this.fOK.bgo() && QuickVideoView.this.fOC != null) {
                    int LI = QuickVideoView.this.fOC.LI();
                    int currentPosition = QuickVideoView.this.fOC.getCurrentPosition();
                    int duration = QuickVideoView.this.fOC.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fOY;
                    boolean z = currentPosition + LI < duration;
                    if (LI < QuickVideoView.this.fOK.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fOY = currentTimeMillis;
                        QuickVideoView.this.fOK.rp(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fOZ && j > 500) {
                        QuickVideoView.this.fOY = currentTimeMillis;
                        QuickVideoView.this.fOK.rp(0);
                    }
                    QuickVideoView.this.fOZ = currentPosition;
                    if (QuickVideoView.this.fze == QuickVideoView.fPd) {
                        QuickVideoView.this.bgB();
                    }
                }
            }
        };
        this.aZB = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.bgs();
                    }
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOG.pJ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fOG = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fOJ = false;
        this.fOL = false;
        this.fOM = 0;
        this.fON = false;
        this.fOO = -1;
        this.fOP = false;
        this.fOQ = null;
        this.fOR = true;
        this.fOY = 0L;
        this.fOZ = 0L;
        this.fze = fPe;
        this.fPf = 0;
        this.fPg = 0;
        this.fPh = -1;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = 0;
        this.bdE = 0;
        this.fPl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOC != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fOC, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fPm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.iJ(false);
                }
            }
        };
        this.fPn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fOL) {
                    QuickVideoView.this.fOL = false;
                    if (QuickVideoView.this.fOC != null) {
                        QuickVideoView.this.fOC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOG.aRN();
                    }
                } else if (QuickVideoView.this.fOC != null && QuickVideoView.this.fOP) {
                    QuickVideoView.this.fOC.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.fOO);
                    if (QuickVideoView.this.fOp != null) {
                        QuickVideoView.this.fOp.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOG.aRO();
                    }
                }
                QuickVideoView.this.fOQ = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lt(false);
                if (QuickVideoView.this.fOC != null) {
                    QuickVideoView.this.fOC.release();
                }
                if (!QuickVideoView.this.fOL) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.onStop();
                    }
                    if (QuickVideoView.this.bkY != null) {
                        QuickVideoView.this.bkY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOQ = null;
                if (QuickVideoView.this.fOG != null && QuickVideoView.this.fOG.pL(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOG = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.onPrepared();
                }
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pD(QuickVideoView.this.fOC.getPlayerType());
                }
                if (QuickVideoView.this.aZo != null) {
                    QuickVideoView.this.aZo.onPrepared(gVar);
                }
                if (QuickVideoView.this.fOK != null) {
                    long j = 0;
                    if (QuickVideoView.this.fOC != null) {
                        j = QuickVideoView.this.fOC.getDuration();
                    }
                    QuickVideoView.this.fOK.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fOK.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fOJ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOA != null && gVar != null) {
                    QuickVideoView.this.fOA.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOM);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOB) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fOB);
                }
                if (QuickVideoView.this.fOS != null && QuickVideoView.this.fOS.bhh()) {
                    com.baidu.tieba.play.b.e.ru(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fPp = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lt(true);
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOG = null;
                }
                if (!QuickVideoView.this.fON || QuickVideoView.this.fOK == null) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.onCompletion();
                    }
                    QuickVideoView.this.fOJ = false;
                    if (QuickVideoView.this.aZn != null) {
                        QuickVideoView.this.aZn.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOI = null;
                QuickVideoView.this.fOW = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fOK.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZq = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.V(i2, i22, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOK != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fOX = true;
                    x.bhb().aD(QuickVideoView.this.fOK.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOI = QuickVideoView.this.fOG.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOW, QuickVideoView.this.F(QuickVideoView.this.fOG.aRT(), i3 + "", QuickVideoView.this.fOG.aRU()));
                        QuickVideoView.this.fOG = null;
                    }
                    QuickVideoView.this.fOW = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.rs(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZp == null || QuickVideoView.this.aZp.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.fPq = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fOX) {
                    QuickVideoView.this.fOX = false;
                    return;
                }
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fOK != null && z) {
                    QuickVideoView.this.fOK.onSeekComplete();
                }
                if (QuickVideoView.this.aZs != null) {
                    QuickVideoView.this.aZs.b(gVar);
                }
            }
        };
        this.aZr = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.fOD != null) {
                    QuickVideoView.this.fOD.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.fOM = i22;
                    if (QuickVideoView.this.fOA != null && gVar != null) {
                        QuickVideoView.this.fOA.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOM);
                    }
                }
                if (QuickVideoView.this.fOT != null) {
                    QuickVideoView.this.fOT.a(i2, i22, QuickVideoView.this.fOG);
                    return true;
                }
                return true;
            }
        };
        this.aZt = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.f(i2, i22, str);
                }
            }
        };
        this.aZu = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.pM(str);
                }
            }
        };
        this.aZv = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOW = j;
                }
            }
        };
        this.fPr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fOK != null && QuickVideoView.this.fOK.bgm() && QuickVideoView.this.fOK.bgn() && QuickVideoView.this.fOK.bgo() && QuickVideoView.this.fOC != null) {
                    int LI = QuickVideoView.this.fOC.LI();
                    int currentPosition = QuickVideoView.this.fOC.getCurrentPosition();
                    int duration = QuickVideoView.this.fOC.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fOY;
                    boolean z = currentPosition + LI < duration;
                    if (LI < QuickVideoView.this.fOK.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fOY = currentTimeMillis;
                        QuickVideoView.this.fOK.rp(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fOZ && j > 500) {
                        QuickVideoView.this.fOY = currentTimeMillis;
                        QuickVideoView.this.fOK.rp(0);
                    }
                    QuickVideoView.this.fOZ = currentPosition;
                    if (QuickVideoView.this.fze == QuickVideoView.fPd) {
                        QuickVideoView.this.bgB();
                    }
                }
            }
        };
        this.aZB = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fOK != null) {
                        QuickVideoView.this.fOK.bgs();
                    }
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOG.pJ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fOG = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fOA = new RenderView(context);
        this.fOA.setSurfaceTextureListener(this.fPn);
        if (fOE != null) {
            this.fOC = fOE.LJ();
        }
        if (this.fOC != null) {
            this.fOC.setOnPreparedListener(this.fPo);
            this.fOC.setOnCompletionListener(this.fPp);
            this.fOC.a(this.aZq);
            this.fOC.setOnSeekCompleteListener(this.fPq);
            this.fOC.a(this.aZr);
            this.fOC.a(this.aZt);
            this.fOC.a(this.aZu);
            this.fOC.a(this.aZv);
        }
        ak.j(this, d.C0126d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(Constants.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.fOS = new com.baidu.tieba.play.b.a(this);
        this.fOT = new q();
        this.fOU = new com.baidu.tieba.play.b.f();
    }

    public void setVideoPath(String str, String str2) {
        this.aNu = str2;
        if (this.fOS != null) {
            this.fOS.clear();
            this.fOS.bhh();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.rw(str2);
            if (fOF != null) {
                this.fOG = fOF.E(this.aNu, str, "");
                if (this.fOG != null) {
                    this.fOG.a(-300, -44399, -44399, getLocateSource(), false, this.fOW, "");
                    this.fOG = null;
                }
            }
        }
        if (this.fOH != null) {
            this.fOH.a(null);
            this.fOH.aRG();
            this.fOH = null;
        }
        this.fOI = null;
        this.fOW = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.fOG != null) {
            this.fOG.aRS();
            this.fOG = null;
        }
        if (!an.isEmpty(str)) {
            if (com.baidu.tieba.video.f.bvW().bvX()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    str = str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                } else if (str.contains("http:")) {
                    str = str.replace("http:", "https:");
                }
            }
            this.fOV = str;
            if (f(Uri.parse(str)) != null) {
                this.fOG.aRM();
            }
            if (this.fOK != null) {
                str = this.fOK.hP(str);
                if (this.fOK.bgr() != null) {
                    this.fOK.bgr().setPlayer(this);
                }
                if (fOF != null && fy(str)) {
                    this.fOH = fOF.pO(str);
                }
                if (this.fOH != null) {
                    this.fOH.a(new com.baidu.tieba.play.monitor.a(this.aNu, this.fOV, this.fOG));
                    this.fOH.aRF();
                }
                ro(str);
            }
            if (!com.baidu.adp.lib.util.j.gP() && !fy(str)) {
                if (this.aZp != null) {
                    this.aZp.onError(this.fOC, Constants.BDUSS_EXCEPRION, Constants.BDUSS_EXCEPRION);
                    return;
                }
                return;
            }
            bgw();
            setVideoURI(Uri.parse(str));
        }
    }

    private void bgw() {
        if (com.baidu.tbadk.coreExtra.model.f.Bz()) {
            if (this.fOK != null && (this.fOK.bgl() || this.fOK.bgm())) {
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPl);
                com.baidu.adp.lib.g.e.fw().postDelayed(this.fPl, com.baidu.tbadk.coreExtra.model.f.By());
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPm);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fPm, com.baidu.tbadk.coreExtra.model.f.Bx());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.fOG.pI(uri.toString());
        }
        bgx();
        this.fOL = true;
        this.mUri = uri;
        this.yS = map;
        this.fOM = 0;
        removeView(this.fOA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fOR) {
            addView(this.fOA, layoutParams);
        } else {
            addView(this.fOA, 0, layoutParams);
        }
        ak.j(this, d.C0126d.cp_bg_line_k);
    }

    private void bgx() {
        this.fOL = false;
        this.fOJ = false;
        if (this.fOC != null) {
            this.fOC.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPr);
    }

    private void ro(String str) {
        this.fPg = 0;
        this.fPh = 0;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = 0;
        this.bdE = 0;
        if (this.fOK.bgm()) {
            this.fPf = fPb;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.fPh = (int) t.rq(QuickVideoView.this.fOV);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.fOV != null && this.fOV.equals(str)) {
            this.fPf = fPa;
        } else {
            this.fPf = fPc;
        }
        this.fze = fPd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgy() {
        this.fze = fPd;
        if (this.fOC != null) {
            this.fPg = this.fOC.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        if (this.fze == fPd && this.fOC != null) {
            this.fze = fPe;
            this.fPj = this.fOC.getDuration();
            if (z) {
                this.fPk = 0;
                this.fPi = this.fPj;
            } else {
                this.fPi = this.fOC.getCurrentPosition();
                this.fPk = this.fOC.getCachedSize();
            }
            if (this.fPi > 0) {
                if (this.fPf == fPa) {
                    this.fPh = (int) t.rq(this.fOV);
                    if (this.fPg > 0) {
                        long j = (this.fPg * (this.fPi / 1000)) / 8;
                        if (this.fPk < 0) {
                            this.fPk = 0;
                        }
                        long j2 = this.fPk + j;
                        if (this.fPh > 0) {
                            j2 += this.fPh;
                        }
                        setFlowCount(j2, this.fPi, this.fPj, this.bdE);
                    } else if (this.fPg == -1) {
                        this.fPg = 603327;
                        setFlowCount((this.fPg * (this.fPi / 1000)) / 8, this.fPi, this.fPj, this.bdE);
                    }
                } else if (this.fPf == fPb) {
                    if (this.fPg > 0) {
                        long j3 = (this.fPg * (this.fPi / 1000)) / 8;
                        if (this.fPk < 0) {
                            this.fPk = 0;
                        }
                        long j4 = this.fPk + j3;
                        if (this.fPh > 0) {
                            j4 -= this.fPh;
                        }
                        setFlowCount(j4, this.fPi, this.fPj, this.bdE);
                    } else if (this.fPg == -1) {
                        this.fPg = 603327;
                        setFlowCount((this.fPg * (this.fPi / 1000)) / 8, this.fPi, this.fPj, this.bdE);
                    }
                } else {
                    setFlowCount(0L, this.fPi, this.fPj, this.bdE);
                }
            }
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPr);
    }

    public void stopPlayback() {
        bgz();
        lt(false);
        if (this.fOS != null) {
            this.fOS.clear();
        }
        this.fOB = null;
        bgx();
        this.fON = false;
        if (this.fOK != null) {
            this.fOK.onStop();
        }
        com.baidu.tieba.play.a.b.bhe().a((b.InterfaceC0199b) null);
        if (this.fOG != null && this.fOG.pL(getLocateSource())) {
            this.fOG = null;
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgz() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPl);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPm);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.aZo = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aZn = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aZp = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0202g interfaceC0202g) {
        this.aZs = interfaceC0202g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F(String str, String str2, String str3) {
        if (this.fOU == null) {
            return "";
        }
        String bhj = this.fOU.bhj();
        this.fOU.G(str, str2, str3);
        return bhj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.fOK != null && !StringUtils.isNull(this.fOK.bgk())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.rv(uri);
            }
            this.mUri = Uri.parse(this.fOK.bgk());
        }
        boolean z = false;
        if (this.fOS != null) {
            z = this.fOS.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.fOG != null) {
            this.fOI = this.fOG.a(i, i2, i3, getLocateSource(), z, this.fOW, F(this.fOG.aRT(), i3 + "", this.fOG.aRU()));
            this.fOG = null;
        }
        this.fOW = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.fOC != null) {
            try {
                this.fOC.release();
                this.fOB = str;
                URI uri = new URI(this.mUri.toString());
                this.fOC.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.yS, this.fOQ, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.fOG.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.fOC != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fOC.release();
            this.fOC.a(this.mContext, this.mUri, this.yS, this.fOQ, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fOG.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.fOC != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fOC.forceUseSystemMediaPlayer(true);
            }
            this.fOC.release();
            this.fOC.a(this.mContext, this.mUri, this.yS, this.fOQ, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fOG.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fOJ = true;
        if (this.fOC != null) {
            if (this.fOQ != null && this.fOP && !this.fOC.isExistInRemote()) {
                this.fOC.a(this.mContext, this.mUri, this.yS, this.fOQ, this.fOO);
                if (this.fOp != null) {
                    this.fOp.bgj();
                }
                if (f(this.mUri) != null) {
                    this.fOG.aRO();
                }
                bgw();
                return;
            }
            this.fOC.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.fOK != null) {
            this.fOK.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.fOG.pE(this.fOC.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bgz();
        if (this.fOC != null) {
            this.fOC.pause();
        }
        if (this.fOK != null) {
            this.fOK.onPause();
        }
        this.fOJ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fOG != null) {
            this.fOG.aRR();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fOC != null) {
            return this.fOC.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fOC != null) {
            return this.fOC.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bdE = i;
        rq(i);
    }

    public void rq(int i) {
        if (this.fOT != null) {
            this.fOT.bgK();
        }
        if (this.fOC != null) {
            this.fOC.seekTo(i);
        }
        if (this.fOK != null) {
            this.fOK.rp(0);
            bgB();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fOC != null) {
            return this.fOC.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fOC != null) {
            this.fOC.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fOO = i;
    }

    public int getRecoveryState() {
        return this.fOO;
    }

    public void setNeedRecovery(boolean z) {
        this.fOP = z;
    }

    public void setLooping(boolean z) {
        this.fON = z;
    }

    public boolean bgA() {
        return this.fOJ;
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
        this.bkY = bVar;
    }

    public void setBusiness(d dVar) {
        this.fOK = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aZB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fON = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fOC != null) {
            this.fOC.HM();
        }
        if (this.fOT != null) {
            this.fOT.bgM();
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPr);
        MessageManager.getInstance().unRegisterListener(this.aZB);
        if (this.fOS != null) {
            this.fOS.clear();
        }
        if (this.fOH != null) {
            this.fOH.a(null);
            this.fOH.aRG();
        }
    }

    public g getPlayer() {
        return this.fOC;
    }

    public int getPlayerType() {
        if (this.fOC == null) {
            return -300;
        }
        return this.fOC.getPlayerType();
    }

    public void bgB() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPr);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fPr, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.fOp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fOK instanceof n) || ((n) this.fOK).bgI() == null) ? "" : ((n) this.fOK).bgI().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.fOG != null) {
            return this.fOG;
        }
        if (!StringUtils.isNull(this.fOV)) {
            uri2 = this.fOV;
        } else if (fOF != null && this.fOK != null && !StringUtils.isNull(this.fOK.bgk())) {
            uri2 = this.fOK.bgk();
        } else {
            uri2 = (fOF == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && fOF != null) {
            this.fOG = fOF.E(this.aNu, uri2, this.fOI);
        }
        this.fOI = null;
        this.fOW = 0L;
        return this.fOG;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.fOG, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.fOG, j);
    }

    public static boolean fy(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.fOD = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.fOC != null) {
            return this.fOC.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.fOC != null ? this.fOC.getId() : "";
    }
}
