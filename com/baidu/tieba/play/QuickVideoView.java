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
    private static h fPK;
    private static com.baidu.tieba.j.k fPL;
    private static int fQg = 0;
    private static int fQh = 1;
    private static int fQi = 2;
    private static int fQj = 1;
    private static int fQk = 0;
    private String aNv;
    private final CustomMessageListener aZC;
    private g.a aZo;
    private g.f aZp;
    private g.b aZq;
    private g.c aZr;
    private g.e aZs;
    private g.InterfaceC0202g aZt;
    private g.i aZu;
    private g.d aZv;
    private g.h aZw;
    private int bdF;
    private b bln;
    private int fAk;
    private RenderView fPG;
    private String fPH;
    private g fPI;
    private g.e fPJ;
    private com.baidu.tieba.j.i fPM;
    private com.baidu.tieba.j.e fPN;
    private String fPO;
    private boolean fPP;
    private d fPQ;
    private boolean fPR;
    private int fPS;
    private boolean fPT;
    private int fPU;
    private boolean fPV;
    private SurfaceTexture fPW;
    private boolean fPX;
    private com.baidu.tieba.play.b.a fPY;
    private q fPZ;
    private a fPv;
    private com.baidu.tieba.play.b.f fQa;
    private String fQb;
    private long fQc;
    private boolean fQd;
    private long fQe;
    private long fQf;
    private int fQl;
    private int fQm;
    private int fQn;
    private int fQo;
    private int fQp;
    private int fQq;
    private Runnable fQr;
    private Runnable fQs;
    private TextureView.SurfaceTextureListener fQt;
    private g.f fQu;
    private g.a fQv;
    private g.InterfaceC0202g fQw;
    private Runnable fQx;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;
    private Map<String, String> yR;

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
            fPK = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        if (runTask2 != null) {
            fPL = (com.baidu.tieba.j.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fPX = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fPP = false;
        this.fPR = false;
        this.fPS = 0;
        this.fPT = false;
        this.fPU = -1;
        this.fPV = false;
        this.fPW = null;
        this.fPX = true;
        this.fQe = 0L;
        this.fQf = 0L;
        this.fAk = fQk;
        this.fQl = 0;
        this.fQm = 0;
        this.fQn = -1;
        this.fQo = 0;
        this.fQp = 0;
        this.fQq = 0;
        this.bdF = 0;
        this.fQr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fPI != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fPI, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fQs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.iK(false);
                }
            }
        };
        this.fQt = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fPR) {
                    QuickVideoView.this.fPR = false;
                    if (QuickVideoView.this.fPI != null) {
                        QuickVideoView.this.fPI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yR, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPM.aRN();
                    }
                } else if (QuickVideoView.this.fPI != null && QuickVideoView.this.fPV) {
                    QuickVideoView.this.fPI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yR, surfaceTexture, QuickVideoView.this.fPU);
                    if (QuickVideoView.this.fPv != null) {
                        QuickVideoView.this.fPv.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPM.aRO();
                    }
                }
                QuickVideoView.this.fPW = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lu(false);
                if (QuickVideoView.this.fPI != null) {
                    QuickVideoView.this.fPI.release();
                }
                if (!QuickVideoView.this.fPR) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.onStop();
                    }
                    if (QuickVideoView.this.bln != null) {
                        QuickVideoView.this.bln.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPW = null;
                if (QuickVideoView.this.fPM != null && QuickVideoView.this.fPM.pO(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPM = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQu = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.onPrepared();
                }
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pC(QuickVideoView.this.fPI.getPlayerType());
                }
                if (QuickVideoView.this.aZp != null) {
                    QuickVideoView.this.aZp.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPQ != null) {
                    long j = 0;
                    if (QuickVideoView.this.fPI != null) {
                        j = QuickVideoView.this.fPI.getDuration();
                    }
                    QuickVideoView.this.fPQ.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPQ.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fPP) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPG != null && gVar != null) {
                    QuickVideoView.this.fPG.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPS);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPH) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fPH);
                }
                if (QuickVideoView.this.fPY != null && QuickVideoView.this.fPY.bhh()) {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fQv = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lu(true);
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pN(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPM = null;
                }
                if (!QuickVideoView.this.fPT || QuickVideoView.this.fPQ == null) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.onCompletion();
                    }
                    QuickVideoView.this.fPP = false;
                    if (QuickVideoView.this.aZo != null) {
                        QuickVideoView.this.aZo.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPO = null;
                QuickVideoView.this.fQc = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPQ.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fPQ != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fQd = true;
                    x.bhb().aD(QuickVideoView.this.fPQ.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fPM != null) {
                        QuickVideoView.this.fPO = QuickVideoView.this.fPM.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fQc, QuickVideoView.this.F(QuickVideoView.this.fPM.aRT(), i3 + "", QuickVideoView.this.fPM.aRU()));
                        QuickVideoView.this.fPM = null;
                    }
                    QuickVideoView.this.fQc = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rr(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rs(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZq == null || QuickVideoView.this.aZq.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.fQw = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fQd) {
                    QuickVideoView.this.fQd = false;
                    return;
                }
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPQ != null && z) {
                    QuickVideoView.this.fPQ.onSeekComplete();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.b(gVar);
                }
            }
        };
        this.aZs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.fPJ != null) {
                    QuickVideoView.this.fPJ.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.fPS = i2;
                    if (QuickVideoView.this.fPG != null && gVar != null) {
                        QuickVideoView.this.fPG.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPS);
                    }
                }
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.a(i, i2, QuickVideoView.this.fPM);
                    return true;
                }
                return true;
            }
        };
        this.aZu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.f(i, i2, str);
                }
            }
        };
        this.aZv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pP(str);
                }
            }
        };
        this.aZw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fQc = j;
                }
            }
        };
        this.fQx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPQ != null && QuickVideoView.this.fPQ.bgm() && QuickVideoView.this.fPQ.bgn() && QuickVideoView.this.fPQ.bgo() && QuickVideoView.this.fPI != null) {
                    int LG = QuickVideoView.this.fPI.LG();
                    int currentPosition = QuickVideoView.this.fPI.getCurrentPosition();
                    int duration = QuickVideoView.this.fPI.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fQe;
                    boolean z = currentPosition + LG < duration;
                    if (LG < QuickVideoView.this.fPQ.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fQe = currentTimeMillis;
                        QuickVideoView.this.fPQ.ro(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fQf && j > 500) {
                        QuickVideoView.this.fQe = currentTimeMillis;
                        QuickVideoView.this.fPQ.ro(0);
                    }
                    QuickVideoView.this.fQf = currentPosition;
                    if (QuickVideoView.this.fAk == QuickVideoView.fQj) {
                        QuickVideoView.this.bgB();
                    }
                }
            }
        };
        this.aZC = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.bgs();
                    }
                    if (QuickVideoView.this.fPM != null) {
                        QuickVideoView.this.fPM.pM(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPM = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPP = false;
        this.fPR = false;
        this.fPS = 0;
        this.fPT = false;
        this.fPU = -1;
        this.fPV = false;
        this.fPW = null;
        this.fPX = true;
        this.fQe = 0L;
        this.fQf = 0L;
        this.fAk = fQk;
        this.fQl = 0;
        this.fQm = 0;
        this.fQn = -1;
        this.fQo = 0;
        this.fQp = 0;
        this.fQq = 0;
        this.bdF = 0;
        this.fQr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fPI != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fPI, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fQs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.iK(false);
                }
            }
        };
        this.fQt = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fPR) {
                    QuickVideoView.this.fPR = false;
                    if (QuickVideoView.this.fPI != null) {
                        QuickVideoView.this.fPI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yR, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPM.aRN();
                    }
                } else if (QuickVideoView.this.fPI != null && QuickVideoView.this.fPV) {
                    QuickVideoView.this.fPI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yR, surfaceTexture, QuickVideoView.this.fPU);
                    if (QuickVideoView.this.fPv != null) {
                        QuickVideoView.this.fPv.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPM.aRO();
                    }
                }
                QuickVideoView.this.fPW = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lu(false);
                if (QuickVideoView.this.fPI != null) {
                    QuickVideoView.this.fPI.release();
                }
                if (!QuickVideoView.this.fPR) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.onStop();
                    }
                    if (QuickVideoView.this.bln != null) {
                        QuickVideoView.this.bln.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPW = null;
                if (QuickVideoView.this.fPM != null && QuickVideoView.this.fPM.pO(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPM = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQu = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.onPrepared();
                }
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pC(QuickVideoView.this.fPI.getPlayerType());
                }
                if (QuickVideoView.this.aZp != null) {
                    QuickVideoView.this.aZp.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPQ != null) {
                    long j = 0;
                    if (QuickVideoView.this.fPI != null) {
                        j = QuickVideoView.this.fPI.getDuration();
                    }
                    QuickVideoView.this.fPQ.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPQ.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fPP) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPG != null && gVar != null) {
                    QuickVideoView.this.fPG.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPS);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPH) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fPH);
                }
                if (QuickVideoView.this.fPY != null && QuickVideoView.this.fPY.bhh()) {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fQv = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lu(true);
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pN(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPM = null;
                }
                if (!QuickVideoView.this.fPT || QuickVideoView.this.fPQ == null) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.onCompletion();
                    }
                    QuickVideoView.this.fPP = false;
                    if (QuickVideoView.this.aZo != null) {
                        QuickVideoView.this.aZo.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPO = null;
                QuickVideoView.this.fQc = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPQ.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fPQ != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fQd = true;
                    x.bhb().aD(QuickVideoView.this.fPQ.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fPM != null) {
                        QuickVideoView.this.fPO = QuickVideoView.this.fPM.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fQc, QuickVideoView.this.F(QuickVideoView.this.fPM.aRT(), i3 + "", QuickVideoView.this.fPM.aRU()));
                        QuickVideoView.this.fPM = null;
                    }
                    QuickVideoView.this.fQc = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rr(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rs(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZq == null || QuickVideoView.this.aZq.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.fQw = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fQd) {
                    QuickVideoView.this.fQd = false;
                    return;
                }
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPQ != null && z) {
                    QuickVideoView.this.fPQ.onSeekComplete();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.b(gVar);
                }
            }
        };
        this.aZs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.fPJ != null) {
                    QuickVideoView.this.fPJ.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.fPS = i2;
                    if (QuickVideoView.this.fPG != null && gVar != null) {
                        QuickVideoView.this.fPG.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPS);
                    }
                }
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.a(i, i2, QuickVideoView.this.fPM);
                    return true;
                }
                return true;
            }
        };
        this.aZu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.f(i, i2, str);
                }
            }
        };
        this.aZv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pP(str);
                }
            }
        };
        this.aZw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fQc = j;
                }
            }
        };
        this.fQx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPQ != null && QuickVideoView.this.fPQ.bgm() && QuickVideoView.this.fPQ.bgn() && QuickVideoView.this.fPQ.bgo() && QuickVideoView.this.fPI != null) {
                    int LG = QuickVideoView.this.fPI.LG();
                    int currentPosition = QuickVideoView.this.fPI.getCurrentPosition();
                    int duration = QuickVideoView.this.fPI.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fQe;
                    boolean z = currentPosition + LG < duration;
                    if (LG < QuickVideoView.this.fPQ.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fQe = currentTimeMillis;
                        QuickVideoView.this.fPQ.ro(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fQf && j > 500) {
                        QuickVideoView.this.fQe = currentTimeMillis;
                        QuickVideoView.this.fPQ.ro(0);
                    }
                    QuickVideoView.this.fQf = currentPosition;
                    if (QuickVideoView.this.fAk == QuickVideoView.fQj) {
                        QuickVideoView.this.bgB();
                    }
                }
            }
        };
        this.aZC = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.bgs();
                    }
                    if (QuickVideoView.this.fPM != null) {
                        QuickVideoView.this.fPM.pM(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPM = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPP = false;
        this.fPR = false;
        this.fPS = 0;
        this.fPT = false;
        this.fPU = -1;
        this.fPV = false;
        this.fPW = null;
        this.fPX = true;
        this.fQe = 0L;
        this.fQf = 0L;
        this.fAk = fQk;
        this.fQl = 0;
        this.fQm = 0;
        this.fQn = -1;
        this.fQo = 0;
        this.fQp = 0;
        this.fQq = 0;
        this.bdF = 0;
        this.fQr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fPI != null) {
                    QuickVideoView.this.b(QuickVideoView.this.fPI, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.fQs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.iK(false);
                }
            }
        };
        this.fQt = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fPR) {
                    QuickVideoView.this.fPR = false;
                    if (QuickVideoView.this.fPI != null) {
                        QuickVideoView.this.fPI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yR, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPM.aRN();
                    }
                } else if (QuickVideoView.this.fPI != null && QuickVideoView.this.fPV) {
                    QuickVideoView.this.fPI.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.yR, surfaceTexture, QuickVideoView.this.fPU);
                    if (QuickVideoView.this.fPv != null) {
                        QuickVideoView.this.fPv.bgj();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPM.aRO();
                    }
                }
                QuickVideoView.this.fPW = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bgz();
                QuickVideoView.this.lu(false);
                if (QuickVideoView.this.fPI != null) {
                    QuickVideoView.this.fPI.release();
                }
                if (!QuickVideoView.this.fPR) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.onStop();
                    }
                    if (QuickVideoView.this.bln != null) {
                        QuickVideoView.this.bln.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPW = null;
                if (QuickVideoView.this.fPM != null && QuickVideoView.this.fPM.pO(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPM = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQu = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.onPrepared();
                }
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pC(QuickVideoView.this.fPI.getPlayerType());
                }
                if (QuickVideoView.this.aZp != null) {
                    QuickVideoView.this.aZp.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPQ != null) {
                    long j = 0;
                    if (QuickVideoView.this.fPI != null) {
                        j = QuickVideoView.this.fPI.getDuration();
                    }
                    QuickVideoView.this.fPQ.cO(j);
                    QuickVideoView.this.bgy();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPQ.bgq();
                        QuickVideoView.this.bgB();
                    }
                }
                if (QuickVideoView.this.fPP) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPG != null && gVar != null) {
                    QuickVideoView.this.fPG.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPS);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPH) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.fPH);
                }
                if (QuickVideoView.this.fPY != null && QuickVideoView.this.fPY.bhh()) {
                    com.baidu.tieba.play.b.e.rt(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.fQv = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lu(true);
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pN(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPM = null;
                }
                if (!QuickVideoView.this.fPT || QuickVideoView.this.fPQ == null) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.onCompletion();
                    }
                    QuickVideoView.this.fPP = false;
                    if (QuickVideoView.this.aZo != null) {
                        QuickVideoView.this.aZo.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPO = null;
                QuickVideoView.this.fQc = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPQ.bgk());
                QuickVideoView.this.start();
            }
        };
        this.aZr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.V(i2, i22, i3);
                QuickVideoView.this.bgz();
                if (QuickVideoView.this.fPQ != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fQd = true;
                    x.bhb().aD(QuickVideoView.this.fPQ.bgk(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.gP()) {
                    if (QuickVideoView.this.fPM != null) {
                        QuickVideoView.this.fPO = QuickVideoView.this.fPM.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fQc, QuickVideoView.this.F(QuickVideoView.this.fPM.aRT(), i3 + "", QuickVideoView.this.fPM.aRU()));
                        QuickVideoView.this.fPM = null;
                    }
                    QuickVideoView.this.fQc = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.rr(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rs(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.aZq == null || QuickVideoView.this.aZq.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.fQw = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0202g
            public void b(g gVar) {
                if (QuickVideoView.this.fQd) {
                    QuickVideoView.this.fQd = false;
                    return;
                }
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.bgL();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPQ != null && z) {
                    QuickVideoView.this.fPQ.onSeekComplete();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.b(gVar);
                }
            }
        };
        this.aZs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.fPJ != null) {
                    QuickVideoView.this.fPJ.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.fPS = i22;
                    if (QuickVideoView.this.fPG != null && gVar != null) {
                        QuickVideoView.this.fPG.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPS);
                    }
                }
                if (QuickVideoView.this.fPZ != null) {
                    QuickVideoView.this.fPZ.a(i2, i22, QuickVideoView.this.fPM);
                    return true;
                }
                return true;
            }
        };
        this.aZu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.f(i2, i22, str);
                }
            }
        };
        this.aZv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPM != null) {
                    QuickVideoView.this.fPM.pP(str);
                }
            }
        };
        this.aZw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fQc = j;
                }
            }
        };
        this.fQx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPQ != null && QuickVideoView.this.fPQ.bgm() && QuickVideoView.this.fPQ.bgn() && QuickVideoView.this.fPQ.bgo() && QuickVideoView.this.fPI != null) {
                    int LG = QuickVideoView.this.fPI.LG();
                    int currentPosition = QuickVideoView.this.fPI.getCurrentPosition();
                    int duration = QuickVideoView.this.fPI.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fQe;
                    boolean z = currentPosition + LG < duration;
                    if (LG < QuickVideoView.this.fPQ.bgp() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fQe = currentTimeMillis;
                        QuickVideoView.this.fPQ.ro(0);
                    }
                    if (QuickVideoView.this.bgA() && currentPosition == QuickVideoView.this.fQf && j > 500) {
                        QuickVideoView.this.fQe = currentTimeMillis;
                        QuickVideoView.this.fPQ.ro(0);
                    }
                    QuickVideoView.this.fQf = currentPosition;
                    if (QuickVideoView.this.fAk == QuickVideoView.fQj) {
                        QuickVideoView.this.bgB();
                    }
                }
            }
        };
        this.aZC = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPQ != null) {
                        QuickVideoView.this.fPQ.bgs();
                    }
                    if (QuickVideoView.this.fPM != null) {
                        QuickVideoView.this.fPM.pM(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPM = null;
                    }
                    QuickVideoView.this.bgz();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fPG = new RenderView(context);
        this.fPG.setSurfaceTextureListener(this.fQt);
        if (fPK != null) {
            this.fPI = fPK.LH();
        }
        if (this.fPI != null) {
            this.fPI.setOnPreparedListener(this.fQu);
            this.fPI.setOnCompletionListener(this.fQv);
            this.fPI.a(this.aZr);
            this.fPI.setOnSeekCompleteListener(this.fQw);
            this.fPI.a(this.aZs);
            this.fPI.a(this.aZu);
            this.fPI.a(this.aZv);
            this.fPI.a(this.aZw);
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
        this.fPY = new com.baidu.tieba.play.b.a(this);
        this.fPZ = new q();
        this.fQa = new com.baidu.tieba.play.b.f();
    }

    public void setVideoPath(String str, String str2) {
        this.aNv = str2;
        if (this.fPY != null) {
            this.fPY.clear();
            this.fPY.bhh();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.rz(str2);
            if (fPL != null) {
                this.fPM = fPL.E(this.aNv, str, "");
                if (this.fPM != null) {
                    this.fPM.a(-300, -44399, -44399, getLocateSource(), false, this.fQc, "");
                    this.fPM = null;
                }
            }
        }
        if (this.fPN != null) {
            this.fPN.a(null);
            this.fPN.aRG();
            this.fPN = null;
        }
        this.fPO = null;
        this.fQc = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.fPM != null) {
            this.fPM.aRS();
            this.fPM = null;
        }
        if (!an.isEmpty(str)) {
            if (com.baidu.tieba.video.f.bvU().bvV()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    str = str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                } else if (str.contains("http:")) {
                    str = str.replace("http:", "https:");
                }
            }
            this.fQb = str;
            if (f(Uri.parse(str)) != null) {
                this.fPM.aRM();
            }
            if (this.fPQ != null) {
                str = this.fPQ.hQ(str);
                if (this.fPQ.bgr() != null) {
                    this.fPQ.bgr().setPlayer(this);
                }
                if (fPL != null && fy(str)) {
                    this.fPN = fPL.pR(str);
                }
                if (this.fPN != null) {
                    this.fPN.a(new com.baidu.tieba.play.monitor.a(this.aNv, this.fQb, this.fPM));
                    this.fPN.aRF();
                }
                rr(str);
            }
            if (!com.baidu.adp.lib.util.j.gP() && !fy(str)) {
                if (this.aZq != null) {
                    this.aZq.onError(this.fPI, Constants.BDUSS_EXCEPRION, Constants.BDUSS_EXCEPRION);
                    return;
                }
                return;
            }
            bgw();
            setVideoURI(Uri.parse(str));
        }
    }

    private void bgw() {
        if (com.baidu.tbadk.coreExtra.model.f.Bx()) {
            if (this.fPQ != null && (this.fPQ.bgl() || this.fPQ.bgm())) {
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQr);
                com.baidu.adp.lib.g.e.fw().postDelayed(this.fQr, com.baidu.tbadk.coreExtra.model.f.Bw());
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQs);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fQs, com.baidu.tbadk.coreExtra.model.f.Bv());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.fPM.pL(uri.toString());
        }
        bgx();
        this.fPR = true;
        this.mUri = uri;
        this.yR = map;
        this.fPS = 0;
        removeView(this.fPG);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fPX) {
            addView(this.fPG, layoutParams);
        } else {
            addView(this.fPG, 0, layoutParams);
        }
        ak.j(this, d.C0126d.cp_bg_line_k);
    }

    private void bgx() {
        this.fPR = false;
        this.fPP = false;
        if (this.fPI != null) {
            this.fPI.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQx);
    }

    private void rr(String str) {
        this.fQm = 0;
        this.fQn = 0;
        this.fQo = 0;
        this.fQp = 0;
        this.fQq = 0;
        this.bdF = 0;
        if (this.fPQ.bgm()) {
            this.fQl = fQh;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.fQn = (int) t.rt(QuickVideoView.this.fQb);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.fQb != null && this.fQb.equals(str)) {
            this.fQl = fQg;
        } else {
            this.fQl = fQi;
        }
        this.fAk = fQj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgy() {
        this.fAk = fQj;
        if (this.fPI != null) {
            this.fQm = this.fPI.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu(boolean z) {
        if (this.fAk == fQj && this.fPI != null) {
            this.fAk = fQk;
            this.fQp = this.fPI.getDuration();
            if (z) {
                this.fQq = 0;
                this.fQo = this.fQp;
            } else {
                this.fQo = this.fPI.getCurrentPosition();
                this.fQq = this.fPI.getCachedSize();
            }
            if (this.fQo > 0) {
                if (this.fQl == fQg) {
                    this.fQn = (int) t.rt(this.fQb);
                    if (this.fQm > 0) {
                        long j = (this.fQm * (this.fQo / 1000)) / 8;
                        if (this.fQq < 0) {
                            this.fQq = 0;
                        }
                        long j2 = this.fQq + j;
                        if (this.fQn > 0) {
                            j2 += this.fQn;
                        }
                        setFlowCount(j2, this.fQo, this.fQp, this.bdF);
                    } else if (this.fQm == -1) {
                        this.fQm = 603327;
                        setFlowCount((this.fQm * (this.fQo / 1000)) / 8, this.fQo, this.fQp, this.bdF);
                    }
                } else if (this.fQl == fQh) {
                    if (this.fQm > 0) {
                        long j3 = (this.fQm * (this.fQo / 1000)) / 8;
                        if (this.fQq < 0) {
                            this.fQq = 0;
                        }
                        long j4 = this.fQq + j3;
                        if (this.fQn > 0) {
                            j4 -= this.fQn;
                        }
                        setFlowCount(j4, this.fQo, this.fQp, this.bdF);
                    } else if (this.fQm == -1) {
                        this.fQm = 603327;
                        setFlowCount((this.fQm * (this.fQo / 1000)) / 8, this.fQo, this.fQp, this.bdF);
                    }
                } else {
                    setFlowCount(0L, this.fQo, this.fQp, this.bdF);
                }
            }
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQx);
    }

    public void stopPlayback() {
        bgz();
        lu(false);
        if (this.fPY != null) {
            this.fPY.clear();
        }
        this.fPH = null;
        bgx();
        this.fPT = false;
        if (this.fPQ != null) {
            this.fPQ.onStop();
        }
        com.baidu.tieba.play.a.b.bhe().a((b.InterfaceC0199b) null);
        if (this.fPM != null && this.fPM.pO(getLocateSource())) {
            this.fPM = null;
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgz() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQr);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQs);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.aZp = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aZo = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aZq = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0202g interfaceC0202g) {
        this.aZt = interfaceC0202g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F(String str, String str2, String str3) {
        if (this.fQa == null) {
            return "";
        }
        String bhj = this.fQa.bhj();
        this.fQa.G(str, str2, str3);
        return bhj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.fPQ != null && !StringUtils.isNull(this.fPQ.bgk())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.ry(uri);
            }
            this.mUri = Uri.parse(this.fPQ.bgk());
        }
        boolean z = false;
        if (this.fPY != null) {
            z = this.fPY.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.fPM != null) {
            this.fPO = this.fPM.a(i, i2, i3, getLocateSource(), z, this.fQc, F(this.fPM.aRT(), i3 + "", this.fPM.aRU()));
            this.fPM = null;
        }
        this.fQc = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.fPI != null) {
            try {
                this.fPI.release();
                this.fPH = str;
                URI uri = new URI(this.mUri.toString());
                this.fPI.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.yR, this.fPW, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.fPM.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.fPI != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fPI.release();
            this.fPI.a(this.mContext, this.mUri, this.yR, this.fPW, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fPM.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.fPI != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fPI.forceUseSystemMediaPlayer(true);
            }
            this.fPI.release();
            this.fPI.a(this.mContext, this.mUri, this.yR, this.fPW, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fPM.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fPP = true;
        if (this.fPI != null) {
            if (this.fPW != null && this.fPV && !this.fPI.isExistInRemote()) {
                this.fPI.a(this.mContext, this.mUri, this.yR, this.fPW, this.fPU);
                if (this.fPv != null) {
                    this.fPv.bgj();
                }
                if (f(this.mUri) != null) {
                    this.fPM.aRO();
                }
                bgw();
                return;
            }
            this.fPI.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.fPQ != null) {
            this.fPQ.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.fPM.pD(this.fPI.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bgz();
        if (this.fPI != null) {
            this.fPI.pause();
        }
        if (this.fPQ != null) {
            this.fPQ.onPause();
        }
        this.fPP = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fPM != null) {
            this.fPM.aRR();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fPI != null) {
            return this.fPI.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fPI != null) {
            return this.fPI.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bdF = i;
        rp(i);
    }

    public void rp(int i) {
        if (this.fPZ != null) {
            this.fPZ.bgK();
        }
        if (this.fPI != null) {
            this.fPI.seekTo(i);
        }
        if (this.fPQ != null) {
            this.fPQ.ro(0);
            bgB();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fPI != null) {
            return this.fPI.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fPI != null) {
            this.fPI.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fPU = i;
    }

    public int getRecoveryState() {
        return this.fPU;
    }

    public void setNeedRecovery(boolean z) {
        this.fPV = z;
    }

    public void setLooping(boolean z) {
        this.fPT = z;
    }

    public boolean bgA() {
        return this.fPP;
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
        this.bln = bVar;
    }

    public void setBusiness(d dVar) {
        this.fPQ = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aZC);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fPT = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fPI != null) {
            this.fPI.HK();
        }
        if (this.fPZ != null) {
            this.fPZ.bgM();
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQx);
        MessageManager.getInstance().unRegisterListener(this.aZC);
        if (this.fPY != null) {
            this.fPY.clear();
        }
        if (this.fPN != null) {
            this.fPN.a(null);
            this.fPN.aRG();
        }
    }

    public g getPlayer() {
        return this.fPI;
    }

    public int getPlayerType() {
        if (this.fPI == null) {
            return -300;
        }
        return this.fPI.getPlayerType();
    }

    public void bgB() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQx);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fQx, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.fPv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fPQ instanceof n) || ((n) this.fPQ).bgI() == null) ? "" : ((n) this.fPQ).bgI().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.fPM != null) {
            return this.fPM;
        }
        if (!StringUtils.isNull(this.fQb)) {
            uri2 = this.fQb;
        } else if (fPL != null && this.fPQ != null && !StringUtils.isNull(this.fPQ.bgk())) {
            uri2 = this.fPQ.bgk();
        } else {
            uri2 = (fPL == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && fPL != null) {
            this.fPM = fPL.E(this.aNv, uri2, this.fPO);
        }
        this.fPO = null;
        this.fQc = 0L;
        return this.fPM;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.fPM, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.fPM, j);
    }

    public static boolean fy(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.fPJ = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.fPI != null) {
            return this.fPI.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.fPI != null ? this.fPI.getId() : "";
    }
}
