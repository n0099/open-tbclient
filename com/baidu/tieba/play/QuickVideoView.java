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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
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
    private static h gaW;
    private static com.baidu.tieba.j.k gaX;
    private static int gbs = 0;
    private static int gbt = 1;
    private static int gbu = 2;
    private static int gbv = 1;
    private static int gbw = 0;
    private Map<String, String> EZ;
    private String aVt;
    private g.b bhA;
    private g.c bhB;
    private g.e bhC;
    private g.InterfaceC0218g bhD;
    private g.i bhE;
    private g.d bhF;
    private g.h bhG;
    private final CustomMessageListener bhM;
    private g.a bhy;
    private g.f bhz;
    private int blP;
    private b bts;
    private int fLF;
    private a gaH;
    private RenderView gaS;
    private String gaT;
    private g gaU;
    private g.e gaV;
    private com.baidu.tieba.j.i gaY;
    private com.baidu.tieba.j.e gaZ;
    private int gbA;
    private int gbB;
    private int gbC;
    private Runnable gbD;
    private Runnable gbE;
    private TextureView.SurfaceTextureListener gbF;
    private g.f gbG;
    private g.a gbH;
    private g.InterfaceC0218g gbI;
    private Runnable gbJ;
    private String gba;
    private boolean gbb;
    private d gbc;
    private boolean gbd;
    private int gbe;
    private boolean gbf;
    private int gbg;
    private boolean gbh;
    private SurfaceTexture gbi;
    private boolean gbj;
    private com.baidu.tieba.play.b.a gbk;
    private q gbl;
    private com.baidu.tieba.play.b.f gbm;
    private String gbn;
    private long gbo;
    private boolean gbp;
    private long gbq;
    private long gbr;
    private int gbx;
    private int gby;
    private int gbz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void blh();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            gaW = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        if (runTask2 != null) {
            gaX = (com.baidu.tieba.j.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gbj = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gbb = false;
        this.gbd = false;
        this.gbe = 0;
        this.gbf = false;
        this.gbg = -1;
        this.gbh = false;
        this.gbi = null;
        this.gbj = true;
        this.gbq = 0L;
        this.gbr = 0L;
        this.fLF = gbw;
        this.gbx = 0;
        this.gby = 0;
        this.gbz = -1;
        this.gbA = 0;
        this.gbB = 0;
        this.gbC = 0;
        this.blP = 0;
        this.gbD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gaU != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gaU, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gbE = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.iQ(false);
                }
            }
        };
        this.gbF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gbd) {
                    QuickVideoView.this.gbd = false;
                    if (QuickVideoView.this.gaU != null) {
                        QuickVideoView.this.gaU.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EZ, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gaY.aWK();
                    }
                } else if (QuickVideoView.this.gaU != null && QuickVideoView.this.gbh) {
                    QuickVideoView.this.gaU.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EZ, surfaceTexture, QuickVideoView.this.gbg);
                    if (QuickVideoView.this.gaH != null) {
                        QuickVideoView.this.gaH.blh();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gaY.aWL();
                    }
                }
                QuickVideoView.this.gbi = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blx();
                QuickVideoView.this.lA(false);
                if (QuickVideoView.this.gaU != null) {
                    QuickVideoView.this.gaU.release();
                }
                if (!QuickVideoView.this.gbd) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.onStop();
                    }
                    if (QuickVideoView.this.bts != null) {
                        QuickVideoView.this.bts.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gbi = null;
                if (QuickVideoView.this.gaY != null && QuickVideoView.this.gaY.qC(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gaY = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gbG = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blx();
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.onPrepared();
                }
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.pO(QuickVideoView.this.gaU.getPlayerType());
                }
                if (QuickVideoView.this.bhz != null) {
                    QuickVideoView.this.bhz.onPrepared(gVar);
                }
                if (QuickVideoView.this.gbc != null) {
                    long j = 0;
                    if (QuickVideoView.this.gaU != null) {
                        j = QuickVideoView.this.gaU.getDuration();
                    }
                    QuickVideoView.this.gbc.cU(j);
                    QuickVideoView.this.blw();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gbc.blo();
                        QuickVideoView.this.blz();
                    }
                }
                if (QuickVideoView.this.gbb) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gaS != null && gVar != null) {
                    QuickVideoView.this.gaS.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gbe);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gaT) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gaT);
                }
                if (QuickVideoView.this.gbk != null && QuickVideoView.this.gbk.bmf()) {
                    com.baidu.tieba.play.b.e.rF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gbH = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lA(true);
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.qB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gaY = null;
                }
                if (!QuickVideoView.this.gbf || QuickVideoView.this.gbc == null) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.onCompletion();
                    }
                    QuickVideoView.this.gbb = false;
                    if (QuickVideoView.this.bhy != null) {
                        QuickVideoView.this.bhy.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gba = null;
                QuickVideoView.this.gbo = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gbc.bli());
                QuickVideoView.this.start();
            }
        };
        this.bhB = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.blx();
                if (QuickVideoView.this.gbc != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gbp = true;
                    x.blZ().aG(QuickVideoView.this.gbc.bli(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jD()) {
                    if (QuickVideoView.this.gaY != null) {
                        QuickVideoView.this.gba = QuickVideoView.this.gaY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gbo, QuickVideoView.this.G(QuickVideoView.this.gaY.aWQ(), i3 + "", QuickVideoView.this.gaY.aWR()));
                        QuickVideoView.this.gaY = null;
                    }
                    QuickVideoView.this.gbo = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bhA == null || QuickVideoView.this.bhA.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gbI = new g.InterfaceC0218g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0218g
            public void b(g gVar) {
                if (QuickVideoView.this.gbp) {
                    QuickVideoView.this.gbp = false;
                    return;
                }
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.blJ();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gbc != null && z) {
                    QuickVideoView.this.gbc.onSeekComplete();
                }
                if (QuickVideoView.this.bhD != null) {
                    QuickVideoView.this.bhD.b(gVar);
                }
            }
        };
        this.bhC = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gaV != null) {
                    QuickVideoView.this.gaV.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gbe = i2;
                    if (QuickVideoView.this.gaS != null && gVar != null) {
                        QuickVideoView.this.gaS.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gbe);
                    }
                }
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.a(i, i2, QuickVideoView.this.gaY);
                    return true;
                }
                return true;
            }
        };
        this.bhE = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.f(i, i2, str);
                }
            }
        };
        this.bhF = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.qD(str);
                }
            }
        };
        this.bhG = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gbo = j;
                }
            }
        };
        this.gbJ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gbc != null && QuickVideoView.this.gbc.blk() && QuickVideoView.this.gbc.bll() && QuickVideoView.this.gbc.blm() && QuickVideoView.this.gaU != null) {
                    int Pf = QuickVideoView.this.gaU.Pf();
                    int currentPosition = QuickVideoView.this.gaU.getCurrentPosition();
                    int duration = QuickVideoView.this.gaU.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gbq;
                    boolean z = currentPosition + Pf < duration;
                    if (Pf < QuickVideoView.this.gbc.bln() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gbq = currentTimeMillis;
                        QuickVideoView.this.gbc.rA(0);
                    }
                    if (QuickVideoView.this.bly() && currentPosition == QuickVideoView.this.gbr && j > 500) {
                        QuickVideoView.this.gbq = currentTimeMillis;
                        QuickVideoView.this.gbc.rA(0);
                    }
                    QuickVideoView.this.gbr = currentPosition;
                    if (QuickVideoView.this.fLF == QuickVideoView.gbv) {
                        QuickVideoView.this.blz();
                    }
                }
            }
        };
        this.bhM = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.blq();
                    }
                    if (QuickVideoView.this.gaY != null) {
                        QuickVideoView.this.gaY.qA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gaY = null;
                    }
                    QuickVideoView.this.blx();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbb = false;
        this.gbd = false;
        this.gbe = 0;
        this.gbf = false;
        this.gbg = -1;
        this.gbh = false;
        this.gbi = null;
        this.gbj = true;
        this.gbq = 0L;
        this.gbr = 0L;
        this.fLF = gbw;
        this.gbx = 0;
        this.gby = 0;
        this.gbz = -1;
        this.gbA = 0;
        this.gbB = 0;
        this.gbC = 0;
        this.blP = 0;
        this.gbD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gaU != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gaU, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gbE = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.iQ(false);
                }
            }
        };
        this.gbF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gbd) {
                    QuickVideoView.this.gbd = false;
                    if (QuickVideoView.this.gaU != null) {
                        QuickVideoView.this.gaU.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EZ, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gaY.aWK();
                    }
                } else if (QuickVideoView.this.gaU != null && QuickVideoView.this.gbh) {
                    QuickVideoView.this.gaU.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EZ, surfaceTexture, QuickVideoView.this.gbg);
                    if (QuickVideoView.this.gaH != null) {
                        QuickVideoView.this.gaH.blh();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gaY.aWL();
                    }
                }
                QuickVideoView.this.gbi = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blx();
                QuickVideoView.this.lA(false);
                if (QuickVideoView.this.gaU != null) {
                    QuickVideoView.this.gaU.release();
                }
                if (!QuickVideoView.this.gbd) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.onStop();
                    }
                    if (QuickVideoView.this.bts != null) {
                        QuickVideoView.this.bts.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gbi = null;
                if (QuickVideoView.this.gaY != null && QuickVideoView.this.gaY.qC(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gaY = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gbG = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blx();
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.onPrepared();
                }
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.pO(QuickVideoView.this.gaU.getPlayerType());
                }
                if (QuickVideoView.this.bhz != null) {
                    QuickVideoView.this.bhz.onPrepared(gVar);
                }
                if (QuickVideoView.this.gbc != null) {
                    long j = 0;
                    if (QuickVideoView.this.gaU != null) {
                        j = QuickVideoView.this.gaU.getDuration();
                    }
                    QuickVideoView.this.gbc.cU(j);
                    QuickVideoView.this.blw();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gbc.blo();
                        QuickVideoView.this.blz();
                    }
                }
                if (QuickVideoView.this.gbb) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gaS != null && gVar != null) {
                    QuickVideoView.this.gaS.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gbe);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gaT) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gaT);
                }
                if (QuickVideoView.this.gbk != null && QuickVideoView.this.gbk.bmf()) {
                    com.baidu.tieba.play.b.e.rF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gbH = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lA(true);
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.qB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gaY = null;
                }
                if (!QuickVideoView.this.gbf || QuickVideoView.this.gbc == null) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.onCompletion();
                    }
                    QuickVideoView.this.gbb = false;
                    if (QuickVideoView.this.bhy != null) {
                        QuickVideoView.this.bhy.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gba = null;
                QuickVideoView.this.gbo = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gbc.bli());
                QuickVideoView.this.start();
            }
        };
        this.bhB = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.V(i, i2, i3);
                QuickVideoView.this.blx();
                if (QuickVideoView.this.gbc != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gbp = true;
                    x.blZ().aG(QuickVideoView.this.gbc.bli(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jD()) {
                    if (QuickVideoView.this.gaY != null) {
                        QuickVideoView.this.gba = QuickVideoView.this.gaY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gbo, QuickVideoView.this.G(QuickVideoView.this.gaY.aWQ(), i3 + "", QuickVideoView.this.gaY.aWR()));
                        QuickVideoView.this.gaY = null;
                    }
                    QuickVideoView.this.gbo = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.rD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bhA == null || QuickVideoView.this.bhA.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gbI = new g.InterfaceC0218g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0218g
            public void b(g gVar) {
                if (QuickVideoView.this.gbp) {
                    QuickVideoView.this.gbp = false;
                    return;
                }
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.blJ();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gbc != null && z) {
                    QuickVideoView.this.gbc.onSeekComplete();
                }
                if (QuickVideoView.this.bhD != null) {
                    QuickVideoView.this.bhD.b(gVar);
                }
            }
        };
        this.bhC = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gaV != null) {
                    QuickVideoView.this.gaV.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gbe = i2;
                    if (QuickVideoView.this.gaS != null && gVar != null) {
                        QuickVideoView.this.gaS.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gbe);
                    }
                }
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.a(i, i2, QuickVideoView.this.gaY);
                    return true;
                }
                return true;
            }
        };
        this.bhE = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.f(i, i2, str);
                }
            }
        };
        this.bhF = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.qD(str);
                }
            }
        };
        this.bhG = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gbo = j;
                }
            }
        };
        this.gbJ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gbc != null && QuickVideoView.this.gbc.blk() && QuickVideoView.this.gbc.bll() && QuickVideoView.this.gbc.blm() && QuickVideoView.this.gaU != null) {
                    int Pf = QuickVideoView.this.gaU.Pf();
                    int currentPosition = QuickVideoView.this.gaU.getCurrentPosition();
                    int duration = QuickVideoView.this.gaU.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gbq;
                    boolean z = currentPosition + Pf < duration;
                    if (Pf < QuickVideoView.this.gbc.bln() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gbq = currentTimeMillis;
                        QuickVideoView.this.gbc.rA(0);
                    }
                    if (QuickVideoView.this.bly() && currentPosition == QuickVideoView.this.gbr && j > 500) {
                        QuickVideoView.this.gbq = currentTimeMillis;
                        QuickVideoView.this.gbc.rA(0);
                    }
                    QuickVideoView.this.gbr = currentPosition;
                    if (QuickVideoView.this.fLF == QuickVideoView.gbv) {
                        QuickVideoView.this.blz();
                    }
                }
            }
        };
        this.bhM = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.blq();
                    }
                    if (QuickVideoView.this.gaY != null) {
                        QuickVideoView.this.gaY.qA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gaY = null;
                    }
                    QuickVideoView.this.blx();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbb = false;
        this.gbd = false;
        this.gbe = 0;
        this.gbf = false;
        this.gbg = -1;
        this.gbh = false;
        this.gbi = null;
        this.gbj = true;
        this.gbq = 0L;
        this.gbr = 0L;
        this.fLF = gbw;
        this.gbx = 0;
        this.gby = 0;
        this.gbz = -1;
        this.gbA = 0;
        this.gbB = 0;
        this.gbC = 0;
        this.blP = 0;
        this.gbD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gaU != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gaU, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gbE = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.iQ(false);
                }
            }
        };
        this.gbF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gbd) {
                    QuickVideoView.this.gbd = false;
                    if (QuickVideoView.this.gaU != null) {
                        QuickVideoView.this.gaU.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EZ, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gaY.aWK();
                    }
                } else if (QuickVideoView.this.gaU != null && QuickVideoView.this.gbh) {
                    QuickVideoView.this.gaU.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.EZ, surfaceTexture, QuickVideoView.this.gbg);
                    if (QuickVideoView.this.gaH != null) {
                        QuickVideoView.this.gaH.blh();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gaY.aWL();
                    }
                }
                QuickVideoView.this.gbi = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.blx();
                QuickVideoView.this.lA(false);
                if (QuickVideoView.this.gaU != null) {
                    QuickVideoView.this.gaU.release();
                }
                if (!QuickVideoView.this.gbd) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.onStop();
                    }
                    if (QuickVideoView.this.bts != null) {
                        QuickVideoView.this.bts.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gbi = null;
                if (QuickVideoView.this.gaY != null && QuickVideoView.this.gaY.qC(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gaY = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gbG = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.blx();
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.onPrepared();
                }
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.pO(QuickVideoView.this.gaU.getPlayerType());
                }
                if (QuickVideoView.this.bhz != null) {
                    QuickVideoView.this.bhz.onPrepared(gVar);
                }
                if (QuickVideoView.this.gbc != null) {
                    long j = 0;
                    if (QuickVideoView.this.gaU != null) {
                        j = QuickVideoView.this.gaU.getDuration();
                    }
                    QuickVideoView.this.gbc.cU(j);
                    QuickVideoView.this.blw();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gbc.blo();
                        QuickVideoView.this.blz();
                    }
                }
                if (QuickVideoView.this.gbb) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gaS != null && gVar != null) {
                    QuickVideoView.this.gaS.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gbe);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gaT) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.b(QuickVideoView.this.mUri, QuickVideoView.this.gaT);
                }
                if (QuickVideoView.this.gbk != null && QuickVideoView.this.gbk.bmf()) {
                    com.baidu.tieba.play.b.e.rF(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gbH = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lA(true);
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.qB(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gaY = null;
                }
                if (!QuickVideoView.this.gbf || QuickVideoView.this.gbc == null) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.onCompletion();
                    }
                    QuickVideoView.this.gbb = false;
                    if (QuickVideoView.this.bhy != null) {
                        QuickVideoView.this.bhy.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gba = null;
                QuickVideoView.this.gbo = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gbc.bli());
                QuickVideoView.this.start();
            }
        };
        this.bhB = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.V(i2, i22, i3);
                QuickVideoView.this.blx();
                if (QuickVideoView.this.gbc != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gbp = true;
                    x.blZ().aG(QuickVideoView.this.gbc.bli(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.jD()) {
                    if (QuickVideoView.this.gaY != null) {
                        QuickVideoView.this.gba = QuickVideoView.this.gaY.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gbo, QuickVideoView.this.G(QuickVideoView.this.gaY.aWQ(), i3 + "", QuickVideoView.this.gaY.aWR()));
                        QuickVideoView.this.gaY = null;
                    }
                    QuickVideoView.this.gbo = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.rD(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.rE(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bhA == null || QuickVideoView.this.bhA.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gbI = new g.InterfaceC0218g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0218g
            public void b(g gVar) {
                if (QuickVideoView.this.gbp) {
                    QuickVideoView.this.gbp = false;
                    return;
                }
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.blJ();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gbc != null && z) {
                    QuickVideoView.this.gbc.onSeekComplete();
                }
                if (QuickVideoView.this.bhD != null) {
                    QuickVideoView.this.bhD.b(gVar);
                }
            }
        };
        this.bhC = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gaV != null) {
                    QuickVideoView.this.gaV.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gbe = i22;
                    if (QuickVideoView.this.gaS != null && gVar != null) {
                        QuickVideoView.this.gaS.U(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gbe);
                    }
                }
                if (QuickVideoView.this.gbl != null) {
                    QuickVideoView.this.gbl.a(i2, i22, QuickVideoView.this.gaY);
                    return true;
                }
                return true;
            }
        };
        this.bhE = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.f(i2, i22, str);
                }
            }
        };
        this.bhF = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gaY != null) {
                    QuickVideoView.this.gaY.qD(str);
                }
            }
        };
        this.bhG = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gbo = j;
                }
            }
        };
        this.gbJ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gbc != null && QuickVideoView.this.gbc.blk() && QuickVideoView.this.gbc.bll() && QuickVideoView.this.gbc.blm() && QuickVideoView.this.gaU != null) {
                    int Pf = QuickVideoView.this.gaU.Pf();
                    int currentPosition = QuickVideoView.this.gaU.getCurrentPosition();
                    int duration = QuickVideoView.this.gaU.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gbq;
                    boolean z = currentPosition + Pf < duration;
                    if (Pf < QuickVideoView.this.gbc.bln() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gbq = currentTimeMillis;
                        QuickVideoView.this.gbc.rA(0);
                    }
                    if (QuickVideoView.this.bly() && currentPosition == QuickVideoView.this.gbr && j > 500) {
                        QuickVideoView.this.gbq = currentTimeMillis;
                        QuickVideoView.this.gbc.rA(0);
                    }
                    QuickVideoView.this.gbr = currentPosition;
                    if (QuickVideoView.this.fLF == QuickVideoView.gbv) {
                        QuickVideoView.this.blz();
                    }
                }
            }
        };
        this.bhM = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gbc != null) {
                        QuickVideoView.this.gbc.blq();
                    }
                    if (QuickVideoView.this.gaY != null) {
                        QuickVideoView.this.gaY.qA(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gaY = null;
                    }
                    QuickVideoView.this.blx();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gaS = new RenderView(context);
        this.gaS.setSurfaceTextureListener(this.gbF);
        if (gaW != null) {
            this.gaU = gaW.Pg();
        }
        if (this.gaU != null) {
            this.gaU.setOnPreparedListener(this.gbG);
            this.gaU.setOnCompletionListener(this.gbH);
            this.gaU.a(this.bhB);
            this.gaU.setOnSeekCompleteListener(this.gbI);
            this.gaU.a(this.bhC);
            this.gaU.a(this.bhE);
            this.gaU.a(this.bhF);
            this.gaU.a(this.bhG);
        }
        al.j(this, d.C0141d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(ARResourceKey.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gbk = new com.baidu.tieba.play.b.a(this);
        this.gbl = new q();
        this.gbm = new com.baidu.tieba.play.b.f();
    }

    public void setVideoPath(String str, String str2) {
        this.aVt = str2;
        if (this.gbk != null) {
            this.gbk.clear();
            this.gbk.bmf();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.sq(str2);
            if (gaX != null) {
                this.gaY = gaX.F(this.aVt, str, "");
                if (this.gaY != null) {
                    this.gaY.a(-300, -44399, -44399, getLocateSource(), false, this.gbo, "");
                    this.gaY = null;
                }
            }
        }
        if (this.gaZ != null) {
            this.gaZ.a(null);
            this.gaZ.aWD();
            this.gaZ = null;
        }
        this.gba = null;
        this.gbo = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.gaY != null) {
            this.gaY.aWP();
            this.gaY = null;
        }
        if (!ao.isEmpty(str)) {
            if (com.baidu.tieba.video.f.bBb().bBc()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    str = str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                } else if (str.contains("http:")) {
                    str = str.replace("http:", "https:");
                }
            }
            this.gbn = str;
            if (f(Uri.parse(str)) != null) {
                this.gaY.aWJ();
            }
            if (this.gbc != null) {
                str = this.gbc.ip(str);
                if (this.gbc.blp() != null) {
                    this.gbc.blp().setPlayer(this);
                }
                if (gaX != null && fW(str)) {
                    this.gaZ = gaX.qF(str);
                }
                if (this.gaZ != null) {
                    this.gaZ.a(new com.baidu.tieba.play.monitor.a(this.aVt, this.gbn, this.gaY));
                    this.gaZ.aWC();
                }
                si(str);
            }
            if (!com.baidu.adp.lib.util.j.jD() && !fW(str)) {
                if (this.bhA != null) {
                    this.bhA.onError(this.gaU, -10000, -10000);
                    return;
                }
                return;
            }
            blu();
            setVideoURI(Uri.parse(str));
        }
    }

    private void blu() {
        if (com.baidu.tbadk.coreExtra.model.f.EY()) {
            if (this.gbc != null && (this.gbc.blj() || this.gbc.blk())) {
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbD);
                com.baidu.adp.lib.g.e.im().postDelayed(this.gbD, com.baidu.tbadk.coreExtra.model.f.EX());
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbE);
            com.baidu.adp.lib.g.e.im().postDelayed(this.gbE, com.baidu.tbadk.coreExtra.model.f.EW());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.gaY.qz(uri.toString());
        }
        blv();
        this.gbd = true;
        this.mUri = uri;
        this.EZ = map;
        this.gbe = 0;
        removeView(this.gaS);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gbj) {
            addView(this.gaS, layoutParams);
        } else {
            addView(this.gaS, 0, layoutParams);
        }
        al.j(this, d.C0141d.cp_bg_line_k);
    }

    private void blv() {
        this.gbd = false;
        this.gbb = false;
        if (this.gaU != null) {
            this.gaU.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbJ);
    }

    private void si(String str) {
        this.gby = 0;
        this.gbz = 0;
        this.gbA = 0;
        this.gbB = 0;
        this.gbC = 0;
        this.blP = 0;
        if (this.gbc.blk()) {
            this.gbx = gbt;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gbz = (int) t.sk(QuickVideoView.this.gbn);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gbn != null && this.gbn.equals(str)) {
            this.gbx = gbs;
        } else {
            this.gbx = gbu;
        }
        this.fLF = gbv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blw() {
        this.fLF = gbv;
        if (this.gaU != null) {
            this.gby = this.gaU.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA(boolean z) {
        if (this.fLF == gbv && this.gaU != null) {
            this.fLF = gbw;
            this.gbB = this.gaU.getDuration();
            if (z) {
                this.gbC = 0;
                this.gbA = this.gbB;
            } else {
                this.gbA = this.gaU.getCurrentPosition();
                this.gbC = this.gaU.getCachedSize();
            }
            if (this.gbA > 0) {
                if (this.gbx == gbs) {
                    this.gbz = (int) t.sk(this.gbn);
                    if (this.gby > 0) {
                        long j = (this.gby * (this.gbA / 1000)) / 8;
                        if (this.gbC < 0) {
                            this.gbC = 0;
                        }
                        long j2 = this.gbC + j;
                        if (this.gbz > 0) {
                            j2 += this.gbz;
                        }
                        setFlowCount(j2, this.gbA, this.gbB, this.blP);
                    } else if (this.gby == -1) {
                        this.gby = 603327;
                        setFlowCount((this.gby * (this.gbA / 1000)) / 8, this.gbA, this.gbB, this.blP);
                    }
                } else if (this.gbx == gbt) {
                    if (this.gby > 0) {
                        long j3 = (this.gby * (this.gbA / 1000)) / 8;
                        if (this.gbC < 0) {
                            this.gbC = 0;
                        }
                        long j4 = this.gbC + j3;
                        if (this.gbz > 0) {
                            j4 -= this.gbz;
                        }
                        setFlowCount(j4, this.gbA, this.gbB, this.blP);
                    } else if (this.gby == -1) {
                        this.gby = 603327;
                        setFlowCount((this.gby * (this.gbA / 1000)) / 8, this.gbA, this.gbB, this.blP);
                    }
                } else {
                    setFlowCount(0L, this.gbA, this.gbB, this.blP);
                }
            }
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbJ);
    }

    public void stopPlayback() {
        blx();
        lA(false);
        if (this.gbk != null) {
            this.gbk.clear();
        }
        this.gaT = null;
        blv();
        this.gbf = false;
        if (this.gbc != null) {
            this.gbc.onStop();
        }
        com.baidu.tieba.play.a.b.bmc().a((b.InterfaceC0215b) null);
        if (this.gaY != null && this.gaY.qC(getLocateSource())) {
            this.gaY = null;
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbD);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbE);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bhz = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bhy = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bhA = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0218g interfaceC0218g) {
        this.bhD = interfaceC0218g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String G(String str, String str2, String str3) {
        if (this.gbm == null) {
            return "";
        }
        String bmh = this.gbm.bmh();
        this.gbm.H(str, str2, str3);
        return bmh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gbc != null && !StringUtils.isNull(this.gbc.bli())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.b.a.sp(uri);
            }
            this.mUri = Uri.parse(this.gbc.bli());
        }
        boolean z = false;
        if (this.gbk != null) {
            z = this.gbk.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gaY != null) {
            this.gba = this.gaY.a(i, i2, i3, getLocateSource(), z, this.gbo, G(this.gaY.aWQ(), i3 + "", this.gaY.aWR()));
            this.gaY = null;
        }
        this.gbo = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gaU != null) {
            try {
                this.gaU.release();
                this.gaT = str;
                URI uri = new URI(this.mUri.toString());
                this.gaU.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.EZ, this.gbi, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.gaY.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gaU != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gaU.release();
            this.gaU.a(this.mContext, this.mUri, this.EZ, this.gbi, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.gaY.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gaU != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gaU.forceUseSystemMediaPlayer(true);
            }
            this.gaU.release();
            this.gaU.a(this.mContext, this.mUri, this.EZ, this.gbi, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.gaY.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gbb = true;
        if (this.gaU != null) {
            if (this.gbi != null && this.gbh && !this.gaU.isExistInRemote()) {
                this.gaU.a(this.mContext, this.mUri, this.EZ, this.gbi, this.gbg);
                if (this.gaH != null) {
                    this.gaH.blh();
                }
                if (f(this.mUri) != null) {
                    this.gaY.aWL();
                }
                blu();
                return;
            }
            this.gaU.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gbc != null) {
            this.gbc.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.gaY.pP(this.gaU.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        blx();
        if (this.gaU != null) {
            this.gaU.pause();
        }
        if (this.gbc != null) {
            this.gbc.onPause();
        }
        this.gbb = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gaY != null) {
            this.gaY.aWO();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gaU != null) {
            return this.gaU.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gaU != null) {
            return this.gaU.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.blP = i;
        rB(i);
    }

    public void rB(int i) {
        if (this.gbl != null) {
            this.gbl.blI();
        }
        if (this.gaU != null) {
            this.gaU.seekTo(i);
        }
        if (this.gbc != null) {
            this.gbc.rA(0);
            blz();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gaU != null) {
            return this.gaU.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gaU != null) {
            this.gaU.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gbg = i;
    }

    public int getRecoveryState() {
        return this.gbg;
    }

    public void setNeedRecovery(boolean z) {
        this.gbh = z;
    }

    public void setLooping(boolean z) {
        this.gbf = z;
    }

    public boolean bly() {
        return this.gbb;
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
        this.bts = bVar;
    }

    public void setBusiness(d dVar) {
        this.gbc = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bhM);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gbf = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gaU != null) {
            this.gaU.Lg();
        }
        if (this.gbl != null) {
            this.gbl.blK();
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbJ);
        MessageManager.getInstance().unRegisterListener(this.bhM);
        if (this.gbk != null) {
            this.gbk.clear();
        }
        if (this.gaZ != null) {
            this.gaZ.a(null);
            this.gaZ.aWD();
        }
    }

    public g getPlayer() {
        return this.gaU;
    }

    public int getPlayerType() {
        if (this.gaU == null) {
            return -300;
        }
        return this.gaU.getPlayerType();
    }

    public void blz() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gbJ);
        com.baidu.adp.lib.g.e.im().postDelayed(this.gbJ, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gaH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gbc instanceof n) || ((n) this.gbc).blG() == null) ? "" : ((n) this.gbc).blG().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.gaY != null) {
            return this.gaY;
        }
        if (!StringUtils.isNull(this.gbn)) {
            uri2 = this.gbn;
        } else if (gaX != null && this.gbc != null && !StringUtils.isNull(this.gbc.bli())) {
            uri2 = this.gbc.bli();
        } else {
            uri2 = (gaX == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gaX != null) {
            this.gaY = gaX.F(this.aVt, uri2, this.gba);
        }
        this.gba = null;
        this.gbo = 0L;
        return this.gaY;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gaY, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gaY, j);
    }

    public static boolean fW(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gaV = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gaU != null) {
            return this.gaU.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gaU != null ? this.gaU.getId() : "";
    }
}
