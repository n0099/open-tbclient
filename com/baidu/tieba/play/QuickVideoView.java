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
    private static h grP;
    private static com.baidu.tieba.i.k grQ;
    private static int gsl = 0;
    private static int gsm = 1;
    private static int gsn = 2;
    private static int gso = 1;
    private static int gsp = 0;
    private Map<String, String> aot;
    private String bAT;
    private final CustomMessageListener bNA;
    private g.a bNm;
    private g.f bNn;
    private g.b bNo;
    private g.c bNp;
    private g.e bNq;
    private g.InterfaceC0149g bNr;
    private g.i bNs;
    private g.d bNt;
    private g.h bNu;
    private int bRx;
    private b bYO;
    private int gcl;
    private a grA;
    private o grL;
    private String grM;
    private g grN;
    private g.e grO;
    private com.baidu.tieba.i.i grR;
    private com.baidu.tieba.i.e grS;
    private String grT;
    private boolean grU;
    private d grV;
    private boolean grW;
    private int grX;
    private boolean grY;
    private int grZ;
    private g.a gsA;
    private g.InterfaceC0149g gsB;
    private Runnable gsC;
    private boolean gsa;
    private SurfaceTexture gsb;
    private boolean gsc;
    private com.baidu.tieba.play.c.a gsd;
    private r gse;
    private com.baidu.tieba.play.c.f gsf;
    private String gsg;
    private long gsh;
    private boolean gsi;
    private long gsj;
    private long gsk;
    private int gsq;
    private int gsr;
    private int gss;
    private int gst;
    private int gsu;
    private int gsv;
    private Runnable gsw;
    private Runnable gsx;
    private TextureView.SurfaceTextureListener gsy;
    private g.f gsz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bjP();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            grP = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            grQ = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gsc = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.grU = false;
        this.grW = false;
        this.grX = 0;
        this.grY = false;
        this.grZ = -1;
        this.gsa = false;
        this.gsb = null;
        this.gsc = true;
        this.gsj = 0L;
        this.gsk = 0L;
        this.gcl = gsp;
        this.gsq = 0;
        this.gsr = 0;
        this.gss = -1;
        this.gst = 0;
        this.gsu = 0;
        this.gsv = 0;
        this.bRx = 0;
        this.gsw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.grN != null) {
                    QuickVideoView.this.b(QuickVideoView.this.grN, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gsx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.iW(false);
                }
            }
        };
        this.gsy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.grW) {
                    QuickVideoView.this.grW = false;
                    if (QuickVideoView.this.grN != null) {
                        QuickVideoView.this.grN.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aot, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.grR.aVe();
                    }
                } else if (QuickVideoView.this.grN != null && QuickVideoView.this.gsa) {
                    QuickVideoView.this.grN.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aot, surfaceTexture, QuickVideoView.this.grZ);
                    if (QuickVideoView.this.grA != null) {
                        QuickVideoView.this.grA.bjP();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.grR.aVf();
                    }
                }
                QuickVideoView.this.gsb = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkf();
                QuickVideoView.this.lE(false);
                if (QuickVideoView.this.grN != null) {
                    QuickVideoView.this.grN.release();
                }
                if (!QuickVideoView.this.grW) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.onStop();
                    }
                    if (QuickVideoView.this.bYO != null) {
                        QuickVideoView.this.bYO.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gsb = null;
                if (QuickVideoView.this.grR != null && QuickVideoView.this.grR.pp(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.grR = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gsz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkf();
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.onPrepared();
                }
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.se(QuickVideoView.this.grN.getPlayerType());
                }
                if (QuickVideoView.this.bNn != null) {
                    QuickVideoView.this.bNn.onPrepared(gVar);
                }
                if (QuickVideoView.this.grV != null) {
                    long j = 0;
                    if (QuickVideoView.this.grN != null) {
                        j = QuickVideoView.this.grN.getDuration();
                    }
                    QuickVideoView.this.grV.cJ(j);
                    QuickVideoView.this.bke();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.grV.bjW();
                        QuickVideoView.this.bkh();
                    }
                }
                if (QuickVideoView.this.grU) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.grL != null && gVar != null) {
                    QuickVideoView.this.grL.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.grX);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.grM) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.grM);
                }
                if (QuickVideoView.this.gsd != null && QuickVideoView.this.gsd.bkN()) {
                    com.baidu.tieba.play.c.e.tY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gsA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lE(true);
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.po(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.grR = null;
                }
                if (!QuickVideoView.this.grY || QuickVideoView.this.grV == null) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.onCompletion();
                    }
                    QuickVideoView.this.grU = false;
                    if (QuickVideoView.this.bNm != null) {
                        QuickVideoView.this.bNm.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.grT = null;
                QuickVideoView.this.gsh = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.grV.bjQ());
                QuickVideoView.this.start();
            }
        };
        this.bNp = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.ag(i, i2, i3);
                QuickVideoView.this.bkf();
                if (QuickVideoView.this.grV != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gsi = true;
                    z.bkH().aA(QuickVideoView.this.grV.bjQ(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oI()) {
                    if (QuickVideoView.this.grR != null) {
                        QuickVideoView.this.grT = QuickVideoView.this.grR.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gsh, QuickVideoView.this.H(QuickVideoView.this.grR.aVk(), i3 + "", QuickVideoView.this.grR.aVl()));
                        QuickVideoView.this.grR = null;
                    }
                    QuickVideoView.this.gsh = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.tW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.tX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNo == null || QuickVideoView.this.bNo.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gsB = new g.InterfaceC0149g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0149g
            public void a(g gVar) {
                if (QuickVideoView.this.gsi) {
                    QuickVideoView.this.gsi = false;
                    return;
                }
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.bkr();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.grV != null && z) {
                    QuickVideoView.this.grV.onSeekComplete();
                }
                if (QuickVideoView.this.bNr != null) {
                    QuickVideoView.this.bNr.a(gVar);
                }
            }
        };
        this.bNq = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.grO != null) {
                    QuickVideoView.this.grO.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.grX = i2;
                    if (QuickVideoView.this.grL != null && gVar != null) {
                        QuickVideoView.this.grL.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.grX);
                    }
                }
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.a(i, i2, QuickVideoView.this.grR);
                    return true;
                }
                return true;
            }
        };
        this.bNs = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.i(i, i2, str);
                }
            }
        };
        this.bNt = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.pq(str);
                }
            }
        };
        this.bNu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gsh = j;
                }
            }
        };
        this.gsC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.grV != null && QuickVideoView.this.grV.bjS() && QuickVideoView.this.grV.bjT() && QuickVideoView.this.grV.bjU() && QuickVideoView.this.grN != null) {
                    int SA = QuickVideoView.this.grN.SA();
                    int currentPosition = QuickVideoView.this.grN.getCurrentPosition();
                    int duration = QuickVideoView.this.grN.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gsj;
                    boolean z = currentPosition + SA < duration;
                    if (SA < QuickVideoView.this.grV.bjV() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gsj = currentTimeMillis;
                        QuickVideoView.this.grV.tT(0);
                    }
                    if (QuickVideoView.this.bkg() && currentPosition == QuickVideoView.this.gsk && j > 500) {
                        QuickVideoView.this.gsj = currentTimeMillis;
                        QuickVideoView.this.grV.tT(0);
                    }
                    QuickVideoView.this.gsk = currentPosition;
                    if (QuickVideoView.this.gcl == QuickVideoView.gso) {
                        QuickVideoView.this.bkh();
                    }
                }
            }
        };
        this.bNA = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.bjY();
                    }
                    if (QuickVideoView.this.grR != null) {
                        QuickVideoView.this.grR.pn(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.grR = null;
                    }
                    QuickVideoView.this.bkf();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.grU = false;
        this.grW = false;
        this.grX = 0;
        this.grY = false;
        this.grZ = -1;
        this.gsa = false;
        this.gsb = null;
        this.gsc = true;
        this.gsj = 0L;
        this.gsk = 0L;
        this.gcl = gsp;
        this.gsq = 0;
        this.gsr = 0;
        this.gss = -1;
        this.gst = 0;
        this.gsu = 0;
        this.gsv = 0;
        this.bRx = 0;
        this.gsw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.grN != null) {
                    QuickVideoView.this.b(QuickVideoView.this.grN, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gsx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.iW(false);
                }
            }
        };
        this.gsy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.grW) {
                    QuickVideoView.this.grW = false;
                    if (QuickVideoView.this.grN != null) {
                        QuickVideoView.this.grN.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aot, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.grR.aVe();
                    }
                } else if (QuickVideoView.this.grN != null && QuickVideoView.this.gsa) {
                    QuickVideoView.this.grN.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aot, surfaceTexture, QuickVideoView.this.grZ);
                    if (QuickVideoView.this.grA != null) {
                        QuickVideoView.this.grA.bjP();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.grR.aVf();
                    }
                }
                QuickVideoView.this.gsb = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkf();
                QuickVideoView.this.lE(false);
                if (QuickVideoView.this.grN != null) {
                    QuickVideoView.this.grN.release();
                }
                if (!QuickVideoView.this.grW) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.onStop();
                    }
                    if (QuickVideoView.this.bYO != null) {
                        QuickVideoView.this.bYO.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gsb = null;
                if (QuickVideoView.this.grR != null && QuickVideoView.this.grR.pp(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.grR = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gsz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkf();
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.onPrepared();
                }
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.se(QuickVideoView.this.grN.getPlayerType());
                }
                if (QuickVideoView.this.bNn != null) {
                    QuickVideoView.this.bNn.onPrepared(gVar);
                }
                if (QuickVideoView.this.grV != null) {
                    long j = 0;
                    if (QuickVideoView.this.grN != null) {
                        j = QuickVideoView.this.grN.getDuration();
                    }
                    QuickVideoView.this.grV.cJ(j);
                    QuickVideoView.this.bke();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.grV.bjW();
                        QuickVideoView.this.bkh();
                    }
                }
                if (QuickVideoView.this.grU) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.grL != null && gVar != null) {
                    QuickVideoView.this.grL.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.grX);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.grM) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.grM);
                }
                if (QuickVideoView.this.gsd != null && QuickVideoView.this.gsd.bkN()) {
                    com.baidu.tieba.play.c.e.tY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gsA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lE(true);
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.po(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.grR = null;
                }
                if (!QuickVideoView.this.grY || QuickVideoView.this.grV == null) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.onCompletion();
                    }
                    QuickVideoView.this.grU = false;
                    if (QuickVideoView.this.bNm != null) {
                        QuickVideoView.this.bNm.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.grT = null;
                QuickVideoView.this.gsh = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.grV.bjQ());
                QuickVideoView.this.start();
            }
        };
        this.bNp = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.ag(i, i2, i3);
                QuickVideoView.this.bkf();
                if (QuickVideoView.this.grV != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gsi = true;
                    z.bkH().aA(QuickVideoView.this.grV.bjQ(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oI()) {
                    if (QuickVideoView.this.grR != null) {
                        QuickVideoView.this.grT = QuickVideoView.this.grR.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gsh, QuickVideoView.this.H(QuickVideoView.this.grR.aVk(), i3 + "", QuickVideoView.this.grR.aVl()));
                        QuickVideoView.this.grR = null;
                    }
                    QuickVideoView.this.gsh = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.tW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.tX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNo == null || QuickVideoView.this.bNo.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gsB = new g.InterfaceC0149g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0149g
            public void a(g gVar) {
                if (QuickVideoView.this.gsi) {
                    QuickVideoView.this.gsi = false;
                    return;
                }
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.bkr();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.grV != null && z) {
                    QuickVideoView.this.grV.onSeekComplete();
                }
                if (QuickVideoView.this.bNr != null) {
                    QuickVideoView.this.bNr.a(gVar);
                }
            }
        };
        this.bNq = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.grO != null) {
                    QuickVideoView.this.grO.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.grX = i2;
                    if (QuickVideoView.this.grL != null && gVar != null) {
                        QuickVideoView.this.grL.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.grX);
                    }
                }
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.a(i, i2, QuickVideoView.this.grR);
                    return true;
                }
                return true;
            }
        };
        this.bNs = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.i(i, i2, str);
                }
            }
        };
        this.bNt = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.pq(str);
                }
            }
        };
        this.bNu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gsh = j;
                }
            }
        };
        this.gsC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.grV != null && QuickVideoView.this.grV.bjS() && QuickVideoView.this.grV.bjT() && QuickVideoView.this.grV.bjU() && QuickVideoView.this.grN != null) {
                    int SA = QuickVideoView.this.grN.SA();
                    int currentPosition = QuickVideoView.this.grN.getCurrentPosition();
                    int duration = QuickVideoView.this.grN.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gsj;
                    boolean z = currentPosition + SA < duration;
                    if (SA < QuickVideoView.this.grV.bjV() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gsj = currentTimeMillis;
                        QuickVideoView.this.grV.tT(0);
                    }
                    if (QuickVideoView.this.bkg() && currentPosition == QuickVideoView.this.gsk && j > 500) {
                        QuickVideoView.this.gsj = currentTimeMillis;
                        QuickVideoView.this.grV.tT(0);
                    }
                    QuickVideoView.this.gsk = currentPosition;
                    if (QuickVideoView.this.gcl == QuickVideoView.gso) {
                        QuickVideoView.this.bkh();
                    }
                }
            }
        };
        this.bNA = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.bjY();
                    }
                    if (QuickVideoView.this.grR != null) {
                        QuickVideoView.this.grR.pn(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.grR = null;
                    }
                    QuickVideoView.this.bkf();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.grU = false;
        this.grW = false;
        this.grX = 0;
        this.grY = false;
        this.grZ = -1;
        this.gsa = false;
        this.gsb = null;
        this.gsc = true;
        this.gsj = 0L;
        this.gsk = 0L;
        this.gcl = gsp;
        this.gsq = 0;
        this.gsr = 0;
        this.gss = -1;
        this.gst = 0;
        this.gsu = 0;
        this.gsv = 0;
        this.bRx = 0;
        this.gsw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.grN != null) {
                    QuickVideoView.this.b(QuickVideoView.this.grN, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gsx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.iW(false);
                }
            }
        };
        this.gsy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.grW) {
                    QuickVideoView.this.grW = false;
                    if (QuickVideoView.this.grN != null) {
                        QuickVideoView.this.grN.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aot, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.grR.aVe();
                    }
                } else if (QuickVideoView.this.grN != null && QuickVideoView.this.gsa) {
                    QuickVideoView.this.grN.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aot, surfaceTexture, QuickVideoView.this.grZ);
                    if (QuickVideoView.this.grA != null) {
                        QuickVideoView.this.grA.bjP();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.grR.aVf();
                    }
                }
                QuickVideoView.this.gsb = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkf();
                QuickVideoView.this.lE(false);
                if (QuickVideoView.this.grN != null) {
                    QuickVideoView.this.grN.release();
                }
                if (!QuickVideoView.this.grW) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.onStop();
                    }
                    if (QuickVideoView.this.bYO != null) {
                        QuickVideoView.this.bYO.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gsb = null;
                if (QuickVideoView.this.grR != null && QuickVideoView.this.grR.pp(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.grR = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gsz = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkf();
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.onPrepared();
                }
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.se(QuickVideoView.this.grN.getPlayerType());
                }
                if (QuickVideoView.this.bNn != null) {
                    QuickVideoView.this.bNn.onPrepared(gVar);
                }
                if (QuickVideoView.this.grV != null) {
                    long j = 0;
                    if (QuickVideoView.this.grN != null) {
                        j = QuickVideoView.this.grN.getDuration();
                    }
                    QuickVideoView.this.grV.cJ(j);
                    QuickVideoView.this.bke();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.grV.bjW();
                        QuickVideoView.this.bkh();
                    }
                }
                if (QuickVideoView.this.grU) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.grL != null && gVar != null) {
                    QuickVideoView.this.grL.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.grX);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.grM) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.grM);
                }
                if (QuickVideoView.this.gsd != null && QuickVideoView.this.gsd.bkN()) {
                    com.baidu.tieba.play.c.e.tY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gsA = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lE(true);
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.po(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.grR = null;
                }
                if (!QuickVideoView.this.grY || QuickVideoView.this.grV == null) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.onCompletion();
                    }
                    QuickVideoView.this.grU = false;
                    if (QuickVideoView.this.bNm != null) {
                        QuickVideoView.this.bNm.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.grT = null;
                QuickVideoView.this.gsh = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.grV.bjQ());
                QuickVideoView.this.start();
            }
        };
        this.bNp = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.c.e.ag(i2, i22, i3);
                QuickVideoView.this.bkf();
                if (QuickVideoView.this.grV != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gsi = true;
                    z.bkH().aA(QuickVideoView.this.grV.bjQ(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oI()) {
                    if (QuickVideoView.this.grR != null) {
                        QuickVideoView.this.grT = QuickVideoView.this.grR.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gsh, QuickVideoView.this.H(QuickVideoView.this.grR.aVk(), i3 + "", QuickVideoView.this.grR.aVl()));
                        QuickVideoView.this.grR = null;
                    }
                    QuickVideoView.this.gsh = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.c.e.tW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.tX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNo == null || QuickVideoView.this.bNo.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gsB = new g.InterfaceC0149g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0149g
            public void a(g gVar) {
                if (QuickVideoView.this.gsi) {
                    QuickVideoView.this.gsi = false;
                    return;
                }
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.bkr();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.grV != null && z) {
                    QuickVideoView.this.grV.onSeekComplete();
                }
                if (QuickVideoView.this.bNr != null) {
                    QuickVideoView.this.bNr.a(gVar);
                }
            }
        };
        this.bNq = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.grO != null) {
                    QuickVideoView.this.grO.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.grX = i22;
                    if (QuickVideoView.this.grL != null && gVar != null) {
                        QuickVideoView.this.grL.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.grX);
                    }
                }
                if (QuickVideoView.this.gse != null) {
                    QuickVideoView.this.gse.a(i2, i22, QuickVideoView.this.grR);
                    return true;
                }
                return true;
            }
        };
        this.bNs = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.i(i2, i22, str);
                }
            }
        };
        this.bNt = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.grR != null) {
                    QuickVideoView.this.grR.pq(str);
                }
            }
        };
        this.bNu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gsh = j;
                }
            }
        };
        this.gsC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.grV != null && QuickVideoView.this.grV.bjS() && QuickVideoView.this.grV.bjT() && QuickVideoView.this.grV.bjU() && QuickVideoView.this.grN != null) {
                    int SA = QuickVideoView.this.grN.SA();
                    int currentPosition = QuickVideoView.this.grN.getCurrentPosition();
                    int duration = QuickVideoView.this.grN.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gsj;
                    boolean z = currentPosition + SA < duration;
                    if (SA < QuickVideoView.this.grV.bjV() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gsj = currentTimeMillis;
                        QuickVideoView.this.grV.tT(0);
                    }
                    if (QuickVideoView.this.bkg() && currentPosition == QuickVideoView.this.gsk && j > 500) {
                        QuickVideoView.this.gsj = currentTimeMillis;
                        QuickVideoView.this.grV.tT(0);
                    }
                    QuickVideoView.this.gsk = currentPosition;
                    if (QuickVideoView.this.gcl == QuickVideoView.gso) {
                        QuickVideoView.this.bkh();
                    }
                }
            }
        };
        this.bNA = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.bjY();
                    }
                    if (QuickVideoView.this.grR != null) {
                        QuickVideoView.this.grR.pn(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.grR = null;
                    }
                    QuickVideoView.this.bkf();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.grL = new o(context);
        this.grL.setSurfaceTextureListener(this.gsy);
        if (grP != null) {
            this.grN = grP.SB();
        }
        if (this.grN != null) {
            this.grN.setOnPreparedListener(this.gsz);
            this.grN.setOnCompletionListener(this.gsA);
            this.grN.a(this.bNp);
            this.grN.setOnSeekCompleteListener(this.gsB);
            this.grN.a(this.bNq);
            this.grN.a(this.bNs);
            this.grN.a(this.bNt);
            this.grN.a(this.bNu);
        }
        aj.t(this, d.C0107d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gsd = new com.baidu.tieba.play.c.a(this);
        this.gse = new r();
        this.gsf = new com.baidu.tieba.play.c.f();
    }

    public void bO(String str, String str2) {
        this.bAT = str2;
        if (this.gsd != null) {
            this.gsd.clear();
            this.gsd.bkN();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.c.e.rc(str2);
            if (grQ != null) {
                this.grR = grQ.G(this.bAT, str, "");
                if (this.grR != null) {
                    this.grR.a(-300, -44399, -44399, getLocateSource(), false, this.gsh, "");
                    this.grR = null;
                }
            }
        }
        if (this.grS != null) {
            this.grS.a(null);
            this.grS.aUX();
            this.grS = null;
        }
        this.grT = null;
        this.gsh = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.grR != null) {
            this.grR.aVj();
            this.grR = null;
        }
        if (!am.isEmpty(str)) {
            this.gsg = str;
            if (i(Uri.parse(str)) != null) {
                this.grR.aVd();
            }
            if (this.grV != null) {
                str = this.grV.hF(str);
                if (this.grV.bjX() != null) {
                    this.grV.bjX().setPlayer(this);
                }
                if (grQ != null && qU(str)) {
                    this.grS = grQ.ps(str);
                }
                if (this.grS != null) {
                    this.grS.a(new com.baidu.tieba.play.b.a(this.bAT, this.gsg, this.grR));
                    this.grS.aUW();
                }
                qT(str);
            }
            if (!com.baidu.adp.lib.util.j.oI() && !qU(str)) {
                if (this.bNo != null) {
                    this.bNo.onError(this.grN, -10000, -10000);
                    return;
                }
                return;
            }
            bkc();
            setVideoURI(Uri.parse(str));
        }
    }

    private void bkc() {
        if (com.baidu.tbadk.coreExtra.model.f.Id()) {
            if (this.grV != null && (this.grV.bjR() || this.grV.bjS())) {
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsw);
                com.baidu.adp.lib.g.e.nr().postDelayed(this.gsw, com.baidu.tbadk.coreExtra.model.f.Ic());
            }
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsx);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.gsx, com.baidu.tbadk.coreExtra.model.f.Ib());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (i(uri) != null) {
            this.grR.pm(uri.toString());
        }
        bkd();
        this.grW = true;
        this.mUri = uri;
        this.aot = map;
        this.grX = 0;
        removeView(this.grL);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gsc) {
            addView(this.grL, layoutParams);
        } else {
            addView(this.grL, 0, layoutParams);
        }
        aj.t(this, d.C0107d.cp_bg_line_k);
    }

    private void bkd() {
        this.grW = false;
        this.grU = false;
        if (this.grN != null) {
            this.grN.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsC);
    }

    private void qT(String str) {
        this.gsr = 0;
        this.gss = 0;
        this.gst = 0;
        this.gsu = 0;
        this.gsv = 0;
        this.bRx = 0;
        if (this.grV.bjS()) {
            this.gsq = gsm;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gss = (int) u.qW(QuickVideoView.this.gsg);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gsg != null && this.gsg.equals(str)) {
            this.gsq = gsl;
        } else {
            this.gsq = gsn;
        }
        this.gcl = gso;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bke() {
        this.gcl = gso;
        if (this.grN != null) {
            this.gsr = this.grN.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(boolean z) {
        if (this.gcl == gso && this.grN != null) {
            this.gcl = gsp;
            this.gsu = this.grN.getDuration();
            if (z) {
                this.gsv = 0;
                this.gst = this.gsu;
            } else {
                this.gst = this.grN.getCurrentPosition();
                this.gsv = this.grN.getCachedSize();
            }
            if (this.gst > 0) {
                if (this.gsq == gsl) {
                    this.gss = (int) u.qW(this.gsg);
                    if (this.gsr > 0) {
                        long j = (this.gsr * (this.gst / 1000)) / 8;
                        if (this.gsv < 0) {
                            this.gsv = 0;
                        }
                        long j2 = this.gsv + j;
                        if (this.gss > 0) {
                            j2 += this.gss;
                        }
                        a(j2, this.gst, this.gsu, this.bRx);
                    } else if (this.gsr == -1) {
                        this.gsr = 603327;
                        a((this.gsr * (this.gst / 1000)) / 8, this.gst, this.gsu, this.bRx);
                    }
                } else if (this.gsq == gsm) {
                    if (this.gsr > 0) {
                        long j3 = (this.gsr * (this.gst / 1000)) / 8;
                        if (this.gsv < 0) {
                            this.gsv = 0;
                        }
                        long j4 = this.gsv + j3;
                        if (this.gss > 0) {
                            j4 -= this.gss;
                        }
                        a(j4, this.gst, this.gsu, this.bRx);
                    } else if (this.gsr == -1) {
                        this.gsr = 603327;
                        a((this.gsr * (this.gst / 1000)) / 8, this.gst, this.gsu, this.bRx);
                    }
                } else {
                    a(0L, this.gst, this.gsu, this.bRx);
                }
            }
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsC);
    }

    public void stopPlayback() {
        bkf();
        lE(false);
        if (this.gsd != null) {
            this.gsd.clear();
        }
        this.grM = null;
        bkd();
        this.grY = false;
        if (this.grV != null) {
            this.grV.onStop();
        }
        com.baidu.tieba.play.a.b.bkK().a((b.InterfaceC0146b) null);
        if (this.grR != null && this.grR.pp(getLocateSource())) {
            this.grR = null;
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkf() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsw);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsx);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bNn = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bNm = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bNo = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0149g interfaceC0149g) {
        this.bNr = interfaceC0149g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H(String str, String str2, String str3) {
        if (this.gsf == null) {
            return "";
        }
        String bkP = this.gsf.bkP();
        this.gsf.I(str, str2, str3);
        return bkP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.grV != null && !StringUtils.isNull(this.grV.bjQ())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.c.a.rb(uri);
            }
            this.mUri = Uri.parse(this.grV.bjQ());
        }
        boolean z = false;
        if (this.gsd != null) {
            z = this.gsd.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.grR != null) {
            this.grT = this.grR.a(i, i2, i3, getLocateSource(), z, this.gsh, H(this.grR.aVk(), i3 + "", this.grR.aVl()));
            this.grR = null;
        }
        this.gsh = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.grN != null) {
            try {
                this.grN.release();
                this.grM = str;
                URI uri = new URI(this.mUri.toString());
                this.grN.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.aot, this.gsb, this.mUri.getHost());
                if (i(this.mUri) != null) {
                    this.grR.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.grN != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.grN.release();
            this.grN.a(this.mContext, this.mUri, this.aot, this.gsb, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.grR.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.grN != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.grN.forceUseSystemMediaPlayer(true);
            }
            this.grN.release();
            this.grN.a(this.mContext, this.mUri, this.aot, this.gsb, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.grR.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.grU = true;
        if (this.grN != null) {
            if (this.gsb != null && this.gsa && !this.grN.isExistInRemote()) {
                this.grN.a(this.mContext, this.mUri, this.aot, this.gsb, this.grZ);
                if (this.grA != null) {
                    this.grA.bjP();
                }
                if (i(this.mUri) != null) {
                    this.grR.aVf();
                }
                bkc();
                return;
            }
            this.grN.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.grV != null) {
            this.grV.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (i(this.mUri) != null) {
            this.grR.sf(this.grN.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bkf();
        if (this.grN != null) {
            this.grN.pause();
        }
        if (this.grV != null) {
            this.grV.onPause();
        }
        this.grU = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.grR != null) {
            this.grR.aVi();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.grN != null) {
            return this.grN.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.grN != null) {
            return this.grN.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bRx = i;
        tU(i);
    }

    public void tU(int i) {
        if (this.gse != null) {
            this.gse.bkq();
        }
        if (this.grN != null) {
            this.grN.seekTo(i);
        }
        if (this.grV != null) {
            this.grV.tT(0);
            bkh();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.grN != null) {
            return this.grN.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.grN != null) {
            this.grN.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.grZ = i;
    }

    public int getRecoveryState() {
        return this.grZ;
    }

    public void setNeedRecovery(boolean z) {
        this.gsa = z;
    }

    public void setLooping(boolean z) {
        this.grY = z;
    }

    public boolean bkg() {
        return this.grU;
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
        this.bYO = bVar;
    }

    public void setBusiness(d dVar) {
        this.grV = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bNA);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.grY = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.grN != null) {
            this.grN.OD();
        }
        if (this.gse != null) {
            this.gse.bks();
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsC);
        MessageManager.getInstance().unRegisterListener(this.bNA);
        if (this.gsd != null) {
            this.gsd.clear();
        }
        if (this.grS != null) {
            this.grS.a(null);
            this.grS.aUX();
        }
    }

    public g getPlayer() {
        return this.grN;
    }

    public int getPlayerType() {
        if (this.grN == null) {
            return -300;
        }
        return this.grN.getPlayerType();
    }

    public void bkh() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsC);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gsC, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.grA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.grV instanceof n) || ((n) this.grV).bko() == null) ? "" : ((n) this.grV).bko().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i i(Uri uri) {
        String uri2;
        if (this.grR != null) {
            return this.grR;
        }
        if (!StringUtils.isNull(this.gsg)) {
            uri2 = this.gsg;
        } else if (grQ != null && this.grV != null && !StringUtils.isNull(this.grV.bjQ())) {
            uri2 = this.grV.bjQ();
        } else {
            uri2 = (grQ == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && grQ != null) {
            this.grR = grQ.G(this.bAT, uri2, this.grT);
        }
        this.grT = null;
        this.gsh = 0L;
        return this.grR;
    }

    public void a(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.b.b.a(this.grR, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.b.b.a(this.grR, j);
    }

    public static boolean qU(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.grO = eVar;
    }
}
