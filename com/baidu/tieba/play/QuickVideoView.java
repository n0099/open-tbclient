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
    private static h fOH;
    private static com.baidu.tieba.j.k fOI;
    private static int fPd = 0;
    private static int fPe = 1;
    private static int fPf = 2;
    private static int fPg = 1;
    private static int fPh = 0;
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
    private RenderView fOD;
    private String fOE;
    private g fOF;
    private g.e fOG;
    private com.baidu.tieba.j.i fOJ;
    private com.baidu.tieba.j.e fOK;
    private String fOL;
    private boolean fOM;
    private d fON;
    private boolean fOO;
    private int fOP;
    private boolean fOQ;
    private int fOR;
    private boolean fOS;
    private SurfaceTexture fOT;
    private boolean fOU;
    private com.baidu.tieba.play.b.a fOV;
    private q fOW;
    private com.baidu.tieba.play.b.f fOX;
    private String fOY;
    private long fOZ;
    private a fOs;
    private boolean fPa;
    private long fPb;
    private long fPc;
    private int fPi;
    private int fPj;
    private int fPk;
    private int fPl;
    private int fPm;
    private int fPn;
    private Runnable fPo;
    private Runnable fPp;
    private TextureView.SurfaceTextureListener fPq;
    private g.f fPr;
    private g.a fPs;
    private g.InterfaceC0202g fPt;
    private Runnable fPu;
    private int fzh;
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
            fOH = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        if (runTask2 != null) {
            fOI = (com.baidu.tieba.j.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fOU = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fOM = false;
        this.fOO = false;
        this.fOP = 0;
        this.fOQ = false;
        this.fOR = -1;
        this.fOS = false;
        this.fOT = null;
        this.fOU = true;
        this.fPb = 0L;
        this.fPc = 0L;
        this.fzh = fPh;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = -1;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdE = 0;
        this.fPo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOF != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fOF, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fPp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.iJ(false);
                }
            }
        };
        this.fPq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fOO) {
                    QuickVideoView.this.fOO = false;
                    if (QuickVideoView.this.fOF != null) {
                        QuickVideoView.this.fOF.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aRN();
                    }
                } else if (QuickVideoView.this.fOF != null && QuickVideoView.this.fOS) {
                    QuickVideoView.this.fOF.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.fOR);
                    if (QuickVideoView.this.fOs != null) {
                        QuickVideoView.this.fOs.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aRO();
                    }
                }
                QuickVideoView.this.fOT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lt(false);
                if (QuickVideoView.this.fOF != null) {
                    QuickVideoView.this.fOF.release();
                }
                if (!QuickVideoView.this.fOO) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onStop();
                    }
                    if (QuickVideoView.this.bkY != null) {
                        QuickVideoView.this.bkY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOT = null;
                if (QuickVideoView.this.fOJ != null && QuickVideoView.this.fOJ.pL(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOJ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.onPrepared();
                }
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pE(QuickVideoView.this.fOF.getPlayerType());
                }
                if (QuickVideoView.this.aZo != null) {
                    QuickVideoView.this.aZo.onPrepared(gVar);
                }
                if (QuickVideoView.this.fON != null) {
                    long j = 0;
                    if (QuickVideoView.this.fOF != null) {
                        j = QuickVideoView.this.fOF.getDuration();
                    }
                    QuickVideoView.this.fON.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fON.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fOM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOD != null && gVar != null) {
                    QuickVideoView.this.fOD.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOE) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fOE);
                }
                if (QuickVideoView.this.fOV != null && QuickVideoView.this.fOV.bhh()) {
                    com.baidu.tieba.play.b.e.rv(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fPs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lt(true);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
                if (!QuickVideoView.this.fOQ || QuickVideoView.this.fON == null) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onCompletion();
                    }
                    QuickVideoView.this.fOM = false;
                    if (QuickVideoView.this.aZn != null) {
                        QuickVideoView.this.aZn.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOL = null;
                QuickVideoView.this.fOZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZq = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fON != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPa = true;
                    x.bhb().aD(QuickVideoView.this.fON.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOZ, QuickVideoView.this.F(QuickVideoView.this.fOJ.aRT(), i3 + "", QuickVideoView.this.fOJ.aRU()));
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.ru(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZp == null || QuickVideoView.this.aZp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.fPt = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fPa) {
                    QuickVideoView.this.fPa = false;
                    return;
                }
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fON != null && z) {
                    QuickVideoView.this.fON.onSeekComplete();
                }
                if (QuickVideoView.this.aZs != null) {
                    QuickVideoView.this.aZs.b(gVar);
                }
            }
        };
        this.aZr = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.fOP = i2;
                    if (QuickVideoView.this.fOD != null && gVar != null) {
                        QuickVideoView.this.fOD.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                    }
                }
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.a(i, i2, QuickVideoView.this.fOJ);
                    return true;
                }
                return true;
            }
        };
        this.aZt = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.f(i, i2, str);
                }
            }
        };
        this.aZu = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pM(str);
                }
            }
        };
        this.aZv = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOZ = j;
                }
            }
        };
        this.fPu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fON != null && QuickVideoView.this.fON.bgm() && QuickVideoView.this.fON.bgn() && QuickVideoView.this.fON.bgo() && QuickVideoView.this.fOF != null) {
                    int LI = QuickVideoView.this.fOF.LI();
                    int currentPosition = QuickVideoView.this.fOF.getCurrentPosition();
                    int duration = QuickVideoView.this.fOF.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPb;
                    boolean z = currentPosition + LI < duration;
                    if (LI < QuickVideoView.this.fON.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.rq(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fPc && j > 500) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.rq(0);
                    }
                    QuickVideoView.this.fPc = currentPosition;
                    if (QuickVideoView.this.fzh == QuickVideoView.fPg) {
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
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.bgs();
                    }
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOJ.pJ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOM = false;
        this.fOO = false;
        this.fOP = 0;
        this.fOQ = false;
        this.fOR = -1;
        this.fOS = false;
        this.fOT = null;
        this.fOU = true;
        this.fPb = 0L;
        this.fPc = 0L;
        this.fzh = fPh;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = -1;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdE = 0;
        this.fPo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOF != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fOF, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fPp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.iJ(false);
                }
            }
        };
        this.fPq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fOO) {
                    QuickVideoView.this.fOO = false;
                    if (QuickVideoView.this.fOF != null) {
                        QuickVideoView.this.fOF.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aRN();
                    }
                } else if (QuickVideoView.this.fOF != null && QuickVideoView.this.fOS) {
                    QuickVideoView.this.fOF.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.fOR);
                    if (QuickVideoView.this.fOs != null) {
                        QuickVideoView.this.fOs.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aRO();
                    }
                }
                QuickVideoView.this.fOT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lt(false);
                if (QuickVideoView.this.fOF != null) {
                    QuickVideoView.this.fOF.release();
                }
                if (!QuickVideoView.this.fOO) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onStop();
                    }
                    if (QuickVideoView.this.bkY != null) {
                        QuickVideoView.this.bkY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOT = null;
                if (QuickVideoView.this.fOJ != null && QuickVideoView.this.fOJ.pL(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOJ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.onPrepared();
                }
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pE(QuickVideoView.this.fOF.getPlayerType());
                }
                if (QuickVideoView.this.aZo != null) {
                    QuickVideoView.this.aZo.onPrepared(gVar);
                }
                if (QuickVideoView.this.fON != null) {
                    long j = 0;
                    if (QuickVideoView.this.fOF != null) {
                        j = QuickVideoView.this.fOF.getDuration();
                    }
                    QuickVideoView.this.fON.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fON.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fOM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOD != null && gVar != null) {
                    QuickVideoView.this.fOD.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOE) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fOE);
                }
                if (QuickVideoView.this.fOV != null && QuickVideoView.this.fOV.bhh()) {
                    com.baidu.tieba.play.b.e.rv(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fPs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lt(true);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
                if (!QuickVideoView.this.fOQ || QuickVideoView.this.fON == null) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onCompletion();
                    }
                    QuickVideoView.this.fOM = false;
                    if (QuickVideoView.this.aZn != null) {
                        QuickVideoView.this.aZn.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOL = null;
                QuickVideoView.this.fOZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZq = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fON != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPa = true;
                    x.bhb().aD(QuickVideoView.this.fON.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOZ, QuickVideoView.this.F(QuickVideoView.this.fOJ.aRT(), i3 + "", QuickVideoView.this.fOJ.aRU()));
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.ru(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZp == null || QuickVideoView.this.aZp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.fPt = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fPa) {
                    QuickVideoView.this.fPa = false;
                    return;
                }
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fON != null && z) {
                    QuickVideoView.this.fON.onSeekComplete();
                }
                if (QuickVideoView.this.aZs != null) {
                    QuickVideoView.this.aZs.b(gVar);
                }
            }
        };
        this.aZr = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.fOP = i2;
                    if (QuickVideoView.this.fOD != null && gVar != null) {
                        QuickVideoView.this.fOD.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                    }
                }
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.a(i, i2, QuickVideoView.this.fOJ);
                    return true;
                }
                return true;
            }
        };
        this.aZt = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.f(i, i2, str);
                }
            }
        };
        this.aZu = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pM(str);
                }
            }
        };
        this.aZv = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOZ = j;
                }
            }
        };
        this.fPu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fON != null && QuickVideoView.this.fON.bgm() && QuickVideoView.this.fON.bgn() && QuickVideoView.this.fON.bgo() && QuickVideoView.this.fOF != null) {
                    int LI = QuickVideoView.this.fOF.LI();
                    int currentPosition = QuickVideoView.this.fOF.getCurrentPosition();
                    int duration = QuickVideoView.this.fOF.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPb;
                    boolean z = currentPosition + LI < duration;
                    if (LI < QuickVideoView.this.fON.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.rq(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fPc && j > 500) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.rq(0);
                    }
                    QuickVideoView.this.fPc = currentPosition;
                    if (QuickVideoView.this.fzh == QuickVideoView.fPg) {
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
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.bgs();
                    }
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOJ.pJ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fOM = false;
        this.fOO = false;
        this.fOP = 0;
        this.fOQ = false;
        this.fOR = -1;
        this.fOS = false;
        this.fOT = null;
        this.fOU = true;
        this.fPb = 0L;
        this.fPc = 0L;
        this.fzh = fPh;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = -1;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdE = 0;
        this.fPo = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOF != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fOF, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fPp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.iJ(false);
                }
            }
        };
        this.fPq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fOO) {
                    QuickVideoView.this.fOO = false;
                    if (QuickVideoView.this.fOF != null) {
                        QuickVideoView.this.fOF.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aRN();
                    }
                } else if (QuickVideoView.this.fOF != null && QuickVideoView.this.fOS) {
                    QuickVideoView.this.fOF.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yS, surfaceTexture, QuickVideoView.this.fOR);
                    if (QuickVideoView.this.fOs != null) {
                        QuickVideoView.this.fOs.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aRO();
                    }
                }
                QuickVideoView.this.fOT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lt(false);
                if (QuickVideoView.this.fOF != null) {
                    QuickVideoView.this.fOF.release();
                }
                if (!QuickVideoView.this.fOO) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onStop();
                    }
                    if (QuickVideoView.this.bkY != null) {
                        QuickVideoView.this.bkY.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOT = null;
                if (QuickVideoView.this.fOJ != null && QuickVideoView.this.fOJ.pL(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOJ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.onPrepared();
                }
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pE(QuickVideoView.this.fOF.getPlayerType());
                }
                if (QuickVideoView.this.aZo != null) {
                    QuickVideoView.this.aZo.onPrepared(gVar);
                }
                if (QuickVideoView.this.fON != null) {
                    long j = 0;
                    if (QuickVideoView.this.fOF != null) {
                        j = QuickVideoView.this.fOF.getDuration();
                    }
                    QuickVideoView.this.fON.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fON.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fOM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOD != null && gVar != null) {
                    QuickVideoView.this.fOD.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOE) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fOE);
                }
                if (QuickVideoView.this.fOV != null && QuickVideoView.this.fOV.bhh()) {
                    com.baidu.tieba.play.b.e.rv(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fPs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lt(true);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
                if (!QuickVideoView.this.fOQ || QuickVideoView.this.fON == null) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onCompletion();
                    }
                    QuickVideoView.this.fOM = false;
                    if (QuickVideoView.this.aZn != null) {
                        QuickVideoView.this.aZn.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOL = null;
                QuickVideoView.this.fOZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZq = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.V(i2, i22, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fON != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPa = true;
                    x.bhb().aD(QuickVideoView.this.fON.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOZ, QuickVideoView.this.F(QuickVideoView.this.fOJ.aRT(), i3 + "", QuickVideoView.this.fOJ.aRU()));
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.ru(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZp == null || QuickVideoView.this.aZp.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.fPt = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fPa) {
                    QuickVideoView.this.fPa = false;
                    return;
                }
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fON != null && z) {
                    QuickVideoView.this.fON.onSeekComplete();
                }
                if (QuickVideoView.this.aZs != null) {
                    QuickVideoView.this.aZs.b(gVar);
                }
            }
        };
        this.aZr = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.fOP = i22;
                    if (QuickVideoView.this.fOD != null && gVar != null) {
                        QuickVideoView.this.fOD.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                    }
                }
                if (QuickVideoView.this.fOW != null) {
                    QuickVideoView.this.fOW.a(i2, i22, QuickVideoView.this.fOJ);
                    return true;
                }
                return true;
            }
        };
        this.aZt = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.f(i2, i22, str);
                }
            }
        };
        this.aZu = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pM(str);
                }
            }
        };
        this.aZv = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOZ = j;
                }
            }
        };
        this.fPu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fON != null && QuickVideoView.this.fON.bgm() && QuickVideoView.this.fON.bgn() && QuickVideoView.this.fON.bgo() && QuickVideoView.this.fOF != null) {
                    int LI = QuickVideoView.this.fOF.LI();
                    int currentPosition = QuickVideoView.this.fOF.getCurrentPosition();
                    int duration = QuickVideoView.this.fOF.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPb;
                    boolean z = currentPosition + LI < duration;
                    if (LI < QuickVideoView.this.fON.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.rq(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fPc && j > 500) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.rq(0);
                    }
                    QuickVideoView.this.fPc = currentPosition;
                    if (QuickVideoView.this.fzh == QuickVideoView.fPg) {
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
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.bgs();
                    }
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOJ.pJ(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fOD = new RenderView(context);
        this.fOD.setSurfaceTextureListener(this.fPq);
        if (fOH != null) {
            this.fOF = fOH.LJ();
        }
        if (this.fOF != null) {
            this.fOF.setOnPreparedListener(this.fPr);
            this.fOF.setOnCompletionListener(this.fPs);
            this.fOF.a(this.aZq);
            this.fOF.setOnSeekCompleteListener(this.fPt);
            this.fOF.a(this.aZr);
            this.fOF.a(this.aZt);
            this.fOF.a(this.aZu);
            this.fOF.a(this.aZv);
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
        this.fOV = new com.baidu.tieba.play.b.a(this);
        this.fOW = new q();
        this.fOX = new com.baidu.tieba.play.b.f();
    }

    public void setVideoPath(String str, String str2) {
        this.aNu = str2;
        if (this.fOV != null) {
            this.fOV.clear();
            this.fOV.bhh();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.rw(str2);
            if (fOI != null) {
                this.fOJ = fOI.E(this.aNu, str, "");
                if (this.fOJ != null) {
                    this.fOJ.a(-300, -44399, -44399, getLocateSource(), false, this.fOZ, "");
                    this.fOJ = null;
                }
            }
        }
        if (this.fOK != null) {
            this.fOK.a(null);
            this.fOK.aRG();
            this.fOK = null;
        }
        this.fOL = null;
        this.fOZ = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.fOJ != null) {
            this.fOJ.aRS();
            this.fOJ = null;
        }
        if (!an.isEmpty(str)) {
            if (com.baidu.tieba.video.f.bvW().bvX()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    str = str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                } else if (str.contains("http:")) {
                    str = str.replace("http:", "https:");
                }
            }
            this.fOY = str;
            if (f(Uri.parse(str)) != null) {
                this.fOJ.aRM();
            }
            if (this.fON != null) {
                str = this.fON.hP(str);
                if (this.fON.bgr() != null) {
                    this.fON.bgr().setPlayer(this);
                }
                if (fOI != null && fy(str)) {
                    this.fOK = fOI.pO(str);
                }
                if (this.fOK != null) {
                    this.fOK.a(new com.baidu.tieba.play.monitor.a(this.aNu, this.fOY, this.fOJ));
                    this.fOK.aRF();
                }
                ro(str);
            }
            if (!com.baidu.adp.lib.util.j.gP() && !fy(str)) {
                if (this.aZp != null) {
                    this.aZp.onError(this.fOF, Constants.BDUSS_EXCEPRION, Constants.BDUSS_EXCEPRION);
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
            if (this.fON != null && (this.fON.bgl() || this.fON.bgm())) {
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPo);
                com.baidu.adp.lib.g.e.fw().postDelayed(this.fPo, com.baidu.tbadk.coreExtra.model.f.By());
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPp);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fPp, com.baidu.tbadk.coreExtra.model.f.Bx());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.fOJ.pI(uri.toString());
        }
        bgx();
        this.fOO = true;
        this.mUri = uri;
        this.yS = map;
        this.fOP = 0;
        removeView(this.fOD);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fOU) {
            addView(this.fOD, layoutParams);
        } else {
            addView(this.fOD, 0, layoutParams);
        }
        ak.j(this, d.C0126d.cp_bg_line_k);
    }

    private void bgx() {
        this.fOO = false;
        this.fOM = false;
        if (this.fOF != null) {
            this.fOF.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
    }

    private void ro(String str) {
        this.fPj = 0;
        this.fPk = 0;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdE = 0;
        if (this.fON.bgm()) {
            this.fPi = fPe;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.fPk = (int) t.rq(QuickVideoView.this.fOY);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.fOY != null && this.fOY.equals(str)) {
            this.fPi = fPd;
        } else {
            this.fPi = fPf;
        }
        this.fzh = fPg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgy() {
        this.fzh = fPg;
        if (this.fOF != null) {
            this.fPj = this.fOF.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        if (this.fzh == fPg && this.fOF != null) {
            this.fzh = fPh;
            this.fPm = this.fOF.getDuration();
            if (z) {
                this.fPn = 0;
                this.fPl = this.fPm;
            } else {
                this.fPl = this.fOF.getCurrentPosition();
                this.fPn = this.fOF.getCachedSize();
            }
            if (this.fPl > 0) {
                if (this.fPi == fPd) {
                    this.fPk = (int) t.rq(this.fOY);
                    if (this.fPj > 0) {
                        long j = (this.fPj * (this.fPl / 1000)) / 8;
                        if (this.fPn < 0) {
                            this.fPn = 0;
                        }
                        long j2 = this.fPn + j;
                        if (this.fPk > 0) {
                            j2 += this.fPk;
                        }
                        setFlowCount(j2, this.fPl, this.fPm, this.bdE);
                    } else if (this.fPj == -1) {
                        this.fPj = 603327;
                        setFlowCount((this.fPj * (this.fPl / 1000)) / 8, this.fPl, this.fPm, this.bdE);
                    }
                } else if (this.fPi == fPe) {
                    if (this.fPj > 0) {
                        long j3 = (this.fPj * (this.fPl / 1000)) / 8;
                        if (this.fPn < 0) {
                            this.fPn = 0;
                        }
                        long j4 = this.fPn + j3;
                        if (this.fPk > 0) {
                            j4 -= this.fPk;
                        }
                        setFlowCount(j4, this.fPl, this.fPm, this.bdE);
                    } else if (this.fPj == -1) {
                        this.fPj = 603327;
                        setFlowCount((this.fPj * (this.fPl / 1000)) / 8, this.fPl, this.fPm, this.bdE);
                    }
                } else {
                    setFlowCount(0L, this.fPl, this.fPm, this.bdE);
                }
            }
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
    }

    public void stopPlayback() {
        bgz();
        lt(false);
        if (this.fOV != null) {
            this.fOV.clear();
        }
        this.fOE = null;
        bgx();
        this.fOQ = false;
        if (this.fON != null) {
            this.fON.onStop();
        }
        com.baidu.tieba.play.a.b.bhe().a((b.InterfaceC0199b) null);
        if (this.fOJ != null && this.fOJ.pL(getLocateSource())) {
            this.fOJ = null;
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgz() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPo);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPp);
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
        if (this.fOX == null) {
            return "";
        }
        String bhj = this.fOX.bhj();
        this.fOX.G(str, str2, str3);
        return bhj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.fON != null && !StringUtils.isNull(this.fON.bgk())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.rv(uri);
            }
            this.mUri = Uri.parse(this.fON.bgk());
        }
        boolean z = false;
        if (this.fOV != null) {
            z = this.fOV.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.fOJ != null) {
            this.fOL = this.fOJ.a(i, i2, i3, getLocateSource(), z, this.fOZ, F(this.fOJ.aRT(), i3 + "", this.fOJ.aRU()));
            this.fOJ = null;
        }
        this.fOZ = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.fOF != null) {
            try {
                this.fOF.release();
                this.fOE = str;
                URI uri = new URI(this.mUri.toString());
                this.fOF.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.yS, this.fOT, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.fOJ.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.fOF != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fOF.release();
            this.fOF.a(this.mContext, this.mUri, this.yS, this.fOT, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fOJ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.fOF != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fOF.forceUseSystemMediaPlayer(true);
            }
            this.fOF.release();
            this.fOF.a(this.mContext, this.mUri, this.yS, this.fOT, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fOJ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fOM = true;
        if (this.fOF != null) {
            if (this.fOT != null && this.fOS && !this.fOF.isExistInRemote()) {
                this.fOF.a(this.mContext, this.mUri, this.yS, this.fOT, this.fOR);
                if (this.fOs != null) {
                    this.fOs.bgj();
                }
                if (f(this.mUri) != null) {
                    this.fOJ.aRO();
                }
                bgw();
                return;
            }
            this.fOF.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.fON != null) {
            this.fON.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.fOJ.pF(this.fOF.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bgz();
        if (this.fOF != null) {
            this.fOF.pause();
        }
        if (this.fON != null) {
            this.fON.onPause();
        }
        this.fOM = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fOJ != null) {
            this.fOJ.aRR();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fOF != null) {
            return this.fOF.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fOF != null) {
            return this.fOF.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bdE = i;
        rr(i);
    }

    public void rr(int i) {
        if (this.fOW != null) {
            this.fOW.bgK();
        }
        if (this.fOF != null) {
            this.fOF.seekTo(i);
        }
        if (this.fON != null) {
            this.fON.rq(0);
            bgB();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fOF != null) {
            return this.fOF.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fOF != null) {
            this.fOF.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fOR = i;
    }

    public int getRecoveryState() {
        return this.fOR;
    }

    public void setNeedRecovery(boolean z) {
        this.fOS = z;
    }

    public void setLooping(boolean z) {
        this.fOQ = z;
    }

    public boolean bgA() {
        return this.fOM;
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
        this.fON = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aZB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fOQ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fOF != null) {
            this.fOF.HM();
        }
        if (this.fOW != null) {
            this.fOW.bgM();
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
        MessageManager.getInstance().unRegisterListener(this.aZB);
        if (this.fOV != null) {
            this.fOV.clear();
        }
        if (this.fOK != null) {
            this.fOK.a(null);
            this.fOK.aRG();
        }
    }

    public g getPlayer() {
        return this.fOF;
    }

    public int getPlayerType() {
        if (this.fOF == null) {
            return -300;
        }
        return this.fOF.getPlayerType();
    }

    public void bgB() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fPu, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.fOs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fON instanceof n) || ((n) this.fON).bgI() == null) ? "" : ((n) this.fON).bgI().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.fOJ != null) {
            return this.fOJ;
        }
        if (!StringUtils.isNull(this.fOY)) {
            uri2 = this.fOY;
        } else if (fOI != null && this.fON != null && !StringUtils.isNull(this.fON.bgk())) {
            uri2 = this.fON.bgk();
        } else {
            uri2 = (fOI == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && fOI != null) {
            this.fOJ = fOI.E(this.aNu, uri2, this.fOL);
        }
        this.fOL = null;
        this.fOZ = 0L;
        return this.fOJ;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.fOJ, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.fOJ, j);
    }

    public static boolean fy(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.fOG = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.fOF != null) {
            return this.fOF.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.fOF != null ? this.fOF.getId() : "";
    }
}
