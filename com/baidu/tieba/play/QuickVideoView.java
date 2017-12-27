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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.c.c {
    private static h gCI;
    private static com.baidu.tieba.i.k gCJ;
    private static int gDe = 0;
    private static int gDf = 1;
    private static int gDg = 2;
    private static int gDh = 1;
    private static int gDi = 0;
    private Map<String, String> aou;
    private String bAK;
    private g.a bNe;
    private g.f bNf;
    private g.b bNg;
    private g.c bNh;
    private g.e bNi;
    private g.InterfaceC0150g bNj;
    private g.i bNk;
    private g.d bNl;
    private g.h bNm;
    private final CustomMessageListener bNs;
    private int bRq;
    private b bYH;
    private o gCE;
    private String gCF;
    private g gCG;
    private g.e gCH;
    private com.baidu.tieba.i.i gCK;
    private com.baidu.tieba.i.e gCL;
    private String gCM;
    private boolean gCN;
    private d gCO;
    private boolean gCP;
    private int gCQ;
    private boolean gCR;
    private int gCS;
    private boolean gCT;
    private SurfaceTexture gCU;
    private boolean gCV;
    private com.baidu.tieba.play.c.a gCW;
    private r gCX;
    private com.baidu.tieba.play.c.f gCY;
    private String gCZ;
    private a gCt;
    private long gDa;
    private boolean gDb;
    private long gDc;
    private long gDd;
    private int gDj;
    private int gDk;
    private int gDl;
    private int gDm;
    private int gDn;
    private int gDo;
    private Runnable gDp;
    private Runnable gDq;
    private TextureView.SurfaceTextureListener gDr;
    private g.f gDs;
    private g.a gDt;
    private g.InterfaceC0150g gDu;
    private Runnable gDv;
    private int gaK;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bqw();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            gCI = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            gCJ = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gCV = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gCN = false;
        this.gCP = false;
        this.gCQ = 0;
        this.gCR = false;
        this.gCS = -1;
        this.gCT = false;
        this.gCU = null;
        this.gCV = true;
        this.gDc = 0L;
        this.gDd = 0L;
        this.gaK = gDi;
        this.gDj = 0;
        this.gDk = 0;
        this.gDl = -1;
        this.gDm = 0;
        this.gDn = 0;
        this.gDo = 0;
        this.bRq = 0;
        this.gDp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCG != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gCG, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gDq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.iT(false);
                }
            }
        };
        this.gDr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gCP) {
                    QuickVideoView.this.gCP = false;
                    if (QuickVideoView.this.gCG != null) {
                        QuickVideoView.this.gCG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aou, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCK.aUZ();
                    }
                } else if (QuickVideoView.this.gCG != null && QuickVideoView.this.gCT) {
                    QuickVideoView.this.gCG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aou, surfaceTexture, QuickVideoView.this.gCS);
                    if (QuickVideoView.this.gCt != null) {
                        QuickVideoView.this.gCt.bqw();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCK.aVa();
                    }
                }
                QuickVideoView.this.gCU = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bqM();
                QuickVideoView.this.mC(false);
                if (QuickVideoView.this.gCG != null) {
                    QuickVideoView.this.gCG.release();
                }
                if (!QuickVideoView.this.gCP) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.onStop();
                    }
                    if (QuickVideoView.this.bYH != null) {
                        QuickVideoView.this.bYH.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gCU = null;
                if (QuickVideoView.this.gCK != null && QuickVideoView.this.gCK.pm(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gCK = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gDs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bqM();
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.onPrepared();
                }
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.sl(QuickVideoView.this.gCG.getPlayerType());
                }
                if (QuickVideoView.this.bNf != null) {
                    QuickVideoView.this.bNf.onPrepared(gVar);
                }
                if (QuickVideoView.this.gCO != null) {
                    long j = 0;
                    if (QuickVideoView.this.gCG != null) {
                        j = QuickVideoView.this.gCG.getDuration();
                    }
                    QuickVideoView.this.gCO.cR(j);
                    QuickVideoView.this.bqL();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gCO.bqD();
                        QuickVideoView.this.bqO();
                    }
                }
                if (QuickVideoView.this.gCN) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gCE != null && gVar != null) {
                    QuickVideoView.this.gCE.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCQ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gCF) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gCF);
                }
                if (QuickVideoView.this.gCW != null && QuickVideoView.this.gCW.bru()) {
                    com.baidu.tieba.play.c.e.vx(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gDt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mC(true);
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.pl(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gCK = null;
                }
                if (!QuickVideoView.this.gCR || QuickVideoView.this.gCO == null) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.onCompletion();
                    }
                    QuickVideoView.this.gCN = false;
                    if (QuickVideoView.this.bNe != null) {
                        QuickVideoView.this.bNe.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gCM = null;
                QuickVideoView.this.gDa = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gCO.bqx());
                QuickVideoView.this.start();
            }
        };
        this.bNh = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.ah(i, i2, i3);
                QuickVideoView.this.bqM();
                if (QuickVideoView.this.gCO != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gDb = true;
                    z.bro().ay(QuickVideoView.this.gCO.bqx(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oI()) {
                    if (QuickVideoView.this.gCK != null) {
                        QuickVideoView.this.gCM = QuickVideoView.this.gCK.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gDa, QuickVideoView.this.H(QuickVideoView.this.gCK.aVf(), i3 + "", QuickVideoView.this.gCK.aVg()));
                        QuickVideoView.this.gCK = null;
                    }
                    QuickVideoView.this.gDa = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.vv(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.vw(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNg == null || QuickVideoView.this.bNg.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gDu = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0150g
            public void a(g gVar) {
                if (QuickVideoView.this.gDb) {
                    QuickVideoView.this.gDb = false;
                    return;
                }
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.bqY();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gCO != null && z) {
                    QuickVideoView.this.gCO.onSeekComplete();
                }
                if (QuickVideoView.this.bNj != null) {
                    QuickVideoView.this.bNj.a(gVar);
                }
            }
        };
        this.bNi = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gCH != null) {
                    QuickVideoView.this.gCH.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gCQ = i2;
                    if (QuickVideoView.this.gCE != null && gVar != null) {
                        QuickVideoView.this.gCE.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCQ);
                    }
                }
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.a(i, i2, QuickVideoView.this.gCK);
                    return true;
                }
                return true;
            }
        };
        this.bNk = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.i(i, i2, str);
                }
            }
        };
        this.bNl = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.pn(str);
                }
            }
        };
        this.bNm = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gDa = j;
                }
            }
        };
        this.gDv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gCO != null && QuickVideoView.this.gCO.bqz() && QuickVideoView.this.gCO.bqA() && QuickVideoView.this.gCO.bqB() && QuickVideoView.this.gCG != null) {
                    int SM = QuickVideoView.this.gCG.SM();
                    int currentPosition = QuickVideoView.this.gCG.getCurrentPosition();
                    int duration = QuickVideoView.this.gCG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gDc;
                    boolean z = currentPosition + SM < duration;
                    if (SM < QuickVideoView.this.gCO.bqC() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gDc = currentTimeMillis;
                        QuickVideoView.this.gCO.vs(0);
                    }
                    if (QuickVideoView.this.bqN() && currentPosition == QuickVideoView.this.gDd && j > 500) {
                        QuickVideoView.this.gDc = currentTimeMillis;
                        QuickVideoView.this.gCO.vs(0);
                    }
                    QuickVideoView.this.gDd = currentPosition;
                    if (QuickVideoView.this.gaK == QuickVideoView.gDh) {
                        QuickVideoView.this.bqO();
                    }
                }
            }
        };
        this.bNs = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.bqF();
                    }
                    if (QuickVideoView.this.gCK != null) {
                        QuickVideoView.this.gCK.pk(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gCK = null;
                    }
                    QuickVideoView.this.bqM();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gCN = false;
        this.gCP = false;
        this.gCQ = 0;
        this.gCR = false;
        this.gCS = -1;
        this.gCT = false;
        this.gCU = null;
        this.gCV = true;
        this.gDc = 0L;
        this.gDd = 0L;
        this.gaK = gDi;
        this.gDj = 0;
        this.gDk = 0;
        this.gDl = -1;
        this.gDm = 0;
        this.gDn = 0;
        this.gDo = 0;
        this.bRq = 0;
        this.gDp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCG != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gCG, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gDq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.iT(false);
                }
            }
        };
        this.gDr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gCP) {
                    QuickVideoView.this.gCP = false;
                    if (QuickVideoView.this.gCG != null) {
                        QuickVideoView.this.gCG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aou, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCK.aUZ();
                    }
                } else if (QuickVideoView.this.gCG != null && QuickVideoView.this.gCT) {
                    QuickVideoView.this.gCG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aou, surfaceTexture, QuickVideoView.this.gCS);
                    if (QuickVideoView.this.gCt != null) {
                        QuickVideoView.this.gCt.bqw();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCK.aVa();
                    }
                }
                QuickVideoView.this.gCU = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bqM();
                QuickVideoView.this.mC(false);
                if (QuickVideoView.this.gCG != null) {
                    QuickVideoView.this.gCG.release();
                }
                if (!QuickVideoView.this.gCP) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.onStop();
                    }
                    if (QuickVideoView.this.bYH != null) {
                        QuickVideoView.this.bYH.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gCU = null;
                if (QuickVideoView.this.gCK != null && QuickVideoView.this.gCK.pm(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gCK = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gDs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bqM();
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.onPrepared();
                }
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.sl(QuickVideoView.this.gCG.getPlayerType());
                }
                if (QuickVideoView.this.bNf != null) {
                    QuickVideoView.this.bNf.onPrepared(gVar);
                }
                if (QuickVideoView.this.gCO != null) {
                    long j = 0;
                    if (QuickVideoView.this.gCG != null) {
                        j = QuickVideoView.this.gCG.getDuration();
                    }
                    QuickVideoView.this.gCO.cR(j);
                    QuickVideoView.this.bqL();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gCO.bqD();
                        QuickVideoView.this.bqO();
                    }
                }
                if (QuickVideoView.this.gCN) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gCE != null && gVar != null) {
                    QuickVideoView.this.gCE.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCQ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gCF) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gCF);
                }
                if (QuickVideoView.this.gCW != null && QuickVideoView.this.gCW.bru()) {
                    com.baidu.tieba.play.c.e.vx(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gDt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mC(true);
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.pl(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gCK = null;
                }
                if (!QuickVideoView.this.gCR || QuickVideoView.this.gCO == null) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.onCompletion();
                    }
                    QuickVideoView.this.gCN = false;
                    if (QuickVideoView.this.bNe != null) {
                        QuickVideoView.this.bNe.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gCM = null;
                QuickVideoView.this.gDa = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gCO.bqx());
                QuickVideoView.this.start();
            }
        };
        this.bNh = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.ah(i, i2, i3);
                QuickVideoView.this.bqM();
                if (QuickVideoView.this.gCO != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gDb = true;
                    z.bro().ay(QuickVideoView.this.gCO.bqx(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oI()) {
                    if (QuickVideoView.this.gCK != null) {
                        QuickVideoView.this.gCM = QuickVideoView.this.gCK.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gDa, QuickVideoView.this.H(QuickVideoView.this.gCK.aVf(), i3 + "", QuickVideoView.this.gCK.aVg()));
                        QuickVideoView.this.gCK = null;
                    }
                    QuickVideoView.this.gDa = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.vv(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.vw(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNg == null || QuickVideoView.this.bNg.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gDu = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0150g
            public void a(g gVar) {
                if (QuickVideoView.this.gDb) {
                    QuickVideoView.this.gDb = false;
                    return;
                }
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.bqY();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gCO != null && z) {
                    QuickVideoView.this.gCO.onSeekComplete();
                }
                if (QuickVideoView.this.bNj != null) {
                    QuickVideoView.this.bNj.a(gVar);
                }
            }
        };
        this.bNi = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gCH != null) {
                    QuickVideoView.this.gCH.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gCQ = i2;
                    if (QuickVideoView.this.gCE != null && gVar != null) {
                        QuickVideoView.this.gCE.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCQ);
                    }
                }
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.a(i, i2, QuickVideoView.this.gCK);
                    return true;
                }
                return true;
            }
        };
        this.bNk = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.i(i, i2, str);
                }
            }
        };
        this.bNl = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.pn(str);
                }
            }
        };
        this.bNm = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gDa = j;
                }
            }
        };
        this.gDv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gCO != null && QuickVideoView.this.gCO.bqz() && QuickVideoView.this.gCO.bqA() && QuickVideoView.this.gCO.bqB() && QuickVideoView.this.gCG != null) {
                    int SM = QuickVideoView.this.gCG.SM();
                    int currentPosition = QuickVideoView.this.gCG.getCurrentPosition();
                    int duration = QuickVideoView.this.gCG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gDc;
                    boolean z = currentPosition + SM < duration;
                    if (SM < QuickVideoView.this.gCO.bqC() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gDc = currentTimeMillis;
                        QuickVideoView.this.gCO.vs(0);
                    }
                    if (QuickVideoView.this.bqN() && currentPosition == QuickVideoView.this.gDd && j > 500) {
                        QuickVideoView.this.gDc = currentTimeMillis;
                        QuickVideoView.this.gCO.vs(0);
                    }
                    QuickVideoView.this.gDd = currentPosition;
                    if (QuickVideoView.this.gaK == QuickVideoView.gDh) {
                        QuickVideoView.this.bqO();
                    }
                }
            }
        };
        this.bNs = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.bqF();
                    }
                    if (QuickVideoView.this.gCK != null) {
                        QuickVideoView.this.gCK.pk(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gCK = null;
                    }
                    QuickVideoView.this.bqM();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gCN = false;
        this.gCP = false;
        this.gCQ = 0;
        this.gCR = false;
        this.gCS = -1;
        this.gCT = false;
        this.gCU = null;
        this.gCV = true;
        this.gDc = 0L;
        this.gDd = 0L;
        this.gaK = gDi;
        this.gDj = 0;
        this.gDk = 0;
        this.gDl = -1;
        this.gDm = 0;
        this.gDn = 0;
        this.gDo = 0;
        this.bRq = 0;
        this.gDp = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCG != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gCG, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gDq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.iT(false);
                }
            }
        };
        this.gDr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gCP) {
                    QuickVideoView.this.gCP = false;
                    if (QuickVideoView.this.gCG != null) {
                        QuickVideoView.this.gCG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aou, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCK.aUZ();
                    }
                } else if (QuickVideoView.this.gCG != null && QuickVideoView.this.gCT) {
                    QuickVideoView.this.gCG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aou, surfaceTexture, QuickVideoView.this.gCS);
                    if (QuickVideoView.this.gCt != null) {
                        QuickVideoView.this.gCt.bqw();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCK.aVa();
                    }
                }
                QuickVideoView.this.gCU = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bqM();
                QuickVideoView.this.mC(false);
                if (QuickVideoView.this.gCG != null) {
                    QuickVideoView.this.gCG.release();
                }
                if (!QuickVideoView.this.gCP) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.onStop();
                    }
                    if (QuickVideoView.this.bYH != null) {
                        QuickVideoView.this.bYH.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gCU = null;
                if (QuickVideoView.this.gCK != null && QuickVideoView.this.gCK.pm(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gCK = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gDs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bqM();
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.onPrepared();
                }
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.sl(QuickVideoView.this.gCG.getPlayerType());
                }
                if (QuickVideoView.this.bNf != null) {
                    QuickVideoView.this.bNf.onPrepared(gVar);
                }
                if (QuickVideoView.this.gCO != null) {
                    long j = 0;
                    if (QuickVideoView.this.gCG != null) {
                        j = QuickVideoView.this.gCG.getDuration();
                    }
                    QuickVideoView.this.gCO.cR(j);
                    QuickVideoView.this.bqL();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gCO.bqD();
                        QuickVideoView.this.bqO();
                    }
                }
                if (QuickVideoView.this.gCN) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gCE != null && gVar != null) {
                    QuickVideoView.this.gCE.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCQ);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gCF) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gCF);
                }
                if (QuickVideoView.this.gCW != null && QuickVideoView.this.gCW.bru()) {
                    com.baidu.tieba.play.c.e.vx(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gDt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mC(true);
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.pl(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gCK = null;
                }
                if (!QuickVideoView.this.gCR || QuickVideoView.this.gCO == null) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.onCompletion();
                    }
                    QuickVideoView.this.gCN = false;
                    if (QuickVideoView.this.bNe != null) {
                        QuickVideoView.this.bNe.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gCM = null;
                QuickVideoView.this.gDa = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gCO.bqx());
                QuickVideoView.this.start();
            }
        };
        this.bNh = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.c.e.ah(i2, i22, i3);
                QuickVideoView.this.bqM();
                if (QuickVideoView.this.gCO != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gDb = true;
                    z.bro().ay(QuickVideoView.this.gCO.bqx(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oI()) {
                    if (QuickVideoView.this.gCK != null) {
                        QuickVideoView.this.gCM = QuickVideoView.this.gCK.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gDa, QuickVideoView.this.H(QuickVideoView.this.gCK.aVf(), i3 + "", QuickVideoView.this.gCK.aVg()));
                        QuickVideoView.this.gCK = null;
                    }
                    QuickVideoView.this.gDa = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.c.e.vv(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.vw(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNg == null || QuickVideoView.this.bNg.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gDu = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0150g
            public void a(g gVar) {
                if (QuickVideoView.this.gDb) {
                    QuickVideoView.this.gDb = false;
                    return;
                }
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.bqY();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gCO != null && z) {
                    QuickVideoView.this.gCO.onSeekComplete();
                }
                if (QuickVideoView.this.bNj != null) {
                    QuickVideoView.this.bNj.a(gVar);
                }
            }
        };
        this.bNi = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gCH != null) {
                    QuickVideoView.this.gCH.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gCQ = i22;
                    if (QuickVideoView.this.gCE != null && gVar != null) {
                        QuickVideoView.this.gCE.ag(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCQ);
                    }
                }
                if (QuickVideoView.this.gCX != null) {
                    QuickVideoView.this.gCX.a(i2, i22, QuickVideoView.this.gCK);
                    return true;
                }
                return true;
            }
        };
        this.bNk = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.i(i2, i22, str);
                }
            }
        };
        this.bNl = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gCK != null) {
                    QuickVideoView.this.gCK.pn(str);
                }
            }
        };
        this.bNm = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gDa = j;
                }
            }
        };
        this.gDv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gCO != null && QuickVideoView.this.gCO.bqz() && QuickVideoView.this.gCO.bqA() && QuickVideoView.this.gCO.bqB() && QuickVideoView.this.gCG != null) {
                    int SM = QuickVideoView.this.gCG.SM();
                    int currentPosition = QuickVideoView.this.gCG.getCurrentPosition();
                    int duration = QuickVideoView.this.gCG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gDc;
                    boolean z = currentPosition + SM < duration;
                    if (SM < QuickVideoView.this.gCO.bqC() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gDc = currentTimeMillis;
                        QuickVideoView.this.gCO.vs(0);
                    }
                    if (QuickVideoView.this.bqN() && currentPosition == QuickVideoView.this.gDd && j > 500) {
                        QuickVideoView.this.gDc = currentTimeMillis;
                        QuickVideoView.this.gCO.vs(0);
                    }
                    QuickVideoView.this.gDd = currentPosition;
                    if (QuickVideoView.this.gaK == QuickVideoView.gDh) {
                        QuickVideoView.this.bqO();
                    }
                }
            }
        };
        this.bNs = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gCO != null) {
                        QuickVideoView.this.gCO.bqF();
                    }
                    if (QuickVideoView.this.gCK != null) {
                        QuickVideoView.this.gCK.pk(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gCK = null;
                    }
                    QuickVideoView.this.bqM();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gCE = new o(context);
        this.gCE.setSurfaceTextureListener(this.gDr);
        if (gCI != null) {
            this.gCG = gCI.SN();
        }
        if (this.gCG != null) {
            this.gCG.setOnPreparedListener(this.gDs);
            this.gCG.setOnCompletionListener(this.gDt);
            this.gCG.a(this.bNh);
            this.gCG.setOnSeekCompleteListener(this.gDu);
            this.gCG.a(this.bNi);
            this.gCG.a(this.bNk);
            this.gCG.a(this.bNl);
            this.gCG.a(this.bNm);
        }
        aj.t(this, d.C0108d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gCW = new com.baidu.tieba.play.c.a(this);
        this.gCX = new r();
        this.gCY = new com.baidu.tieba.play.c.f();
    }

    public void bS(String str, String str2) {
        this.bAK = str2;
        if (this.gCW != null) {
            this.gCW.clear();
            this.gCW.bru();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.c.e.rI(str2);
            if (gCJ != null) {
                this.gCK = gCJ.G(this.bAK, str, "");
                if (this.gCK != null) {
                    this.gCK.a(-300, -44399, -44399, getLocateSource(), false, this.gDa, "");
                    this.gCK = null;
                }
            }
        }
        if (this.gCL != null) {
            this.gCL.a(null);
            this.gCL.aUS();
            this.gCL = null;
        }
        this.gCM = null;
        this.gDa = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.gCK != null) {
            this.gCK.aVe();
            this.gCK = null;
        }
        if (!am.isEmpty(str)) {
            this.gCZ = str;
            if (i(Uri.parse(str)) != null) {
                this.gCK.aUY();
            }
            if (this.gCO != null) {
                str = this.gCO.hE(str);
                if (this.gCO.bqE() != null) {
                    this.gCO.bqE().setPlayer(this);
                }
                if (gCJ != null && rA(str)) {
                    this.gCL = gCJ.pp(str);
                }
                if (this.gCL != null) {
                    this.gCL.a(new com.baidu.tieba.play.b.a(this.bAK, this.gCZ, this.gCK));
                    this.gCL.aUR();
                }
                rz(str);
            }
            if (!com.baidu.adp.lib.util.j.oI() && !rA(str)) {
                if (this.bNg != null) {
                    this.bNg.onError(this.gCG, -10000, -10000);
                    return;
                }
                return;
            }
            bqJ();
            setVideoURI(Uri.parse(str));
        }
    }

    private void bqJ() {
        if (com.baidu.tbadk.coreExtra.model.f.Ik()) {
            if (this.gCO != null && (this.gCO.bqy() || this.gCO.bqz())) {
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDp);
                com.baidu.adp.lib.g.e.nr().postDelayed(this.gDp, com.baidu.tbadk.coreExtra.model.f.Ij());
            }
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDq);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.gDq, com.baidu.tbadk.coreExtra.model.f.Ii());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (i(uri) != null) {
            this.gCK.pj(uri.toString());
        }
        bqK();
        this.gCP = true;
        this.mUri = uri;
        this.aou = map;
        this.gCQ = 0;
        removeView(this.gCE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gCV) {
            addView(this.gCE, layoutParams);
        } else {
            addView(this.gCE, 0, layoutParams);
        }
        aj.t(this, d.C0108d.cp_bg_line_k);
    }

    private void bqK() {
        this.gCP = false;
        this.gCN = false;
        if (this.gCG != null) {
            this.gCG.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDv);
    }

    private void rz(String str) {
        this.gDk = 0;
        this.gDl = 0;
        this.gDm = 0;
        this.gDn = 0;
        this.gDo = 0;
        this.bRq = 0;
        if (this.gCO.bqz()) {
            this.gDj = gDf;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gDl = (int) u.rC(QuickVideoView.this.gCZ);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gCZ != null && this.gCZ.equals(str)) {
            this.gDj = gDe;
        } else {
            this.gDj = gDg;
        }
        this.gaK = gDh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqL() {
        this.gaK = gDh;
        if (this.gCG != null) {
            this.gDk = this.gCG.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(boolean z) {
        if (this.gaK == gDh && this.gCG != null) {
            this.gaK = gDi;
            this.gDn = this.gCG.getDuration();
            if (z) {
                this.gDo = 0;
                this.gDm = this.gDn;
            } else {
                this.gDm = this.gCG.getCurrentPosition();
                this.gDo = this.gCG.getCachedSize();
            }
            if (this.gDm > 0) {
                if (this.gDj == gDe) {
                    this.gDl = (int) u.rC(this.gCZ);
                    if (this.gDk > 0) {
                        long j = (this.gDk * (this.gDm / 1000)) / 8;
                        if (this.gDo < 0) {
                            this.gDo = 0;
                        }
                        long j2 = this.gDo + j;
                        if (this.gDl > 0) {
                            j2 += this.gDl;
                        }
                        a(j2, this.gDm, this.gDn, this.bRq);
                    } else if (this.gDk == -1) {
                        this.gDk = 603327;
                        a((this.gDk * (this.gDm / 1000)) / 8, this.gDm, this.gDn, this.bRq);
                    }
                } else if (this.gDj == gDf) {
                    if (this.gDk > 0) {
                        long j3 = (this.gDk * (this.gDm / 1000)) / 8;
                        if (this.gDo < 0) {
                            this.gDo = 0;
                        }
                        long j4 = this.gDo + j3;
                        if (this.gDl > 0) {
                            j4 -= this.gDl;
                        }
                        a(j4, this.gDm, this.gDn, this.bRq);
                    } else if (this.gDk == -1) {
                        this.gDk = 603327;
                        a((this.gDk * (this.gDm / 1000)) / 8, this.gDm, this.gDn, this.bRq);
                    }
                } else {
                    a(0L, this.gDm, this.gDn, this.bRq);
                }
            }
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDv);
    }

    public void stopPlayback() {
        bqM();
        mC(false);
        if (this.gCW != null) {
            this.gCW.clear();
        }
        this.gCF = null;
        bqK();
        this.gCR = false;
        if (this.gCO != null) {
            this.gCO.onStop();
        }
        com.baidu.tieba.play.a.b.brr().a((b.InterfaceC0147b) null);
        if (this.gCK != null && this.gCK.pm(getLocateSource())) {
            this.gCK = null;
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqM() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDp);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDq);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bNf = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bNe = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bNg = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0150g interfaceC0150g) {
        this.bNj = interfaceC0150g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H(String str, String str2, String str3) {
        if (this.gCY == null) {
            return "";
        }
        String brw = this.gCY.brw();
        this.gCY.I(str, str2, str3);
        return brw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gCO != null && !StringUtils.isNull(this.gCO.bqx())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.c.a.rH(uri);
            }
            this.mUri = Uri.parse(this.gCO.bqx());
        }
        boolean z = false;
        if (this.gCW != null) {
            z = this.gCW.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gCK != null) {
            this.gCM = this.gCK.a(i, i2, i3, getLocateSource(), z, this.gDa, H(this.gCK.aVf(), i3 + "", this.gCK.aVg()));
            this.gCK = null;
        }
        this.gDa = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gCG != null) {
            try {
                this.gCG.release();
                this.gCF = str;
                URI uri = new URI(this.mUri.toString());
                this.gCG.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.aou, this.gCU, this.mUri.getHost());
                if (i(this.mUri) != null) {
                    this.gCK.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gCG != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gCG.release();
            this.gCG.a(this.mContext, this.mUri, this.aou, this.gCU, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gCK.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gCG != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gCG.forceUseSystemMediaPlayer(true);
            }
            this.gCG.release();
            this.gCG.a(this.mContext, this.mUri, this.aou, this.gCU, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gCK.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gCN = true;
        if (this.gCG != null) {
            if (this.gCU != null && this.gCT && !this.gCG.isExistInRemote()) {
                this.gCG.a(this.mContext, this.mUri, this.aou, this.gCU, this.gCS);
                if (this.gCt != null) {
                    this.gCt.bqw();
                }
                if (i(this.mUri) != null) {
                    this.gCK.aVa();
                }
                bqJ();
                return;
            }
            this.gCG.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.gCO != null) {
            this.gCO.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (i(this.mUri) != null) {
            this.gCK.sm(this.gCG.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bqM();
        if (this.gCG != null) {
            this.gCG.pause();
        }
        if (this.gCO != null) {
            this.gCO.onPause();
        }
        this.gCN = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gCK != null) {
            this.gCK.aVd();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gCG != null) {
            return this.gCG.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gCG != null) {
            return this.gCG.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bRq = i;
        vt(i);
    }

    public void vt(int i) {
        if (this.gCX != null) {
            this.gCX.bqX();
        }
        if (this.gCG != null) {
            this.gCG.seekTo(i);
        }
        if (this.gCO != null) {
            this.gCO.vs(0);
            bqO();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gCG != null) {
            return this.gCG.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gCG != null) {
            this.gCG.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gCS = i;
    }

    public int getRecoveryState() {
        return this.gCS;
    }

    public void setNeedRecovery(boolean z) {
        this.gCT = z;
    }

    public void setLooping(boolean z) {
        this.gCR = z;
    }

    public boolean bqN() {
        return this.gCN;
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
        this.bYH = bVar;
    }

    public void setBusiness(d dVar) {
        this.gCO = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bNs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gCR = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gCG != null) {
            this.gCG.OP();
        }
        if (this.gCX != null) {
            this.gCX.bqZ();
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDv);
        MessageManager.getInstance().unRegisterListener(this.bNs);
        if (this.gCW != null) {
            this.gCW.clear();
        }
        if (this.gCL != null) {
            this.gCL.a(null);
            this.gCL.aUS();
        }
    }

    public g getPlayer() {
        return this.gCG;
    }

    public int getPlayerType() {
        if (this.gCG == null) {
            return -300;
        }
        return this.gCG.getPlayerType();
    }

    public void bqO() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDv);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gDv, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gCt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gCO instanceof n) || ((n) this.gCO).bqV() == null) ? "" : ((n) this.gCO).bqV().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i i(Uri uri) {
        String uri2;
        if (this.gCK != null) {
            return this.gCK;
        }
        if (!StringUtils.isNull(this.gCZ)) {
            uri2 = this.gCZ;
        } else if (gCJ != null && this.gCO != null && !StringUtils.isNull(this.gCO.bqx())) {
            uri2 = this.gCO.bqx();
        } else {
            uri2 = (gCJ == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gCJ != null) {
            this.gCK = gCJ.G(this.bAK, uri2, this.gCM);
        }
        this.gCM = null;
        this.gDa = 0L;
        return this.gCK;
    }

    public void a(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.b.b.a(this.gCK, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.b.b.a(this.gCK, j);
    }

    public static boolean rA(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gCH = eVar;
    }
}
