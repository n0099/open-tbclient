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
    private static int gsG = 0;
    private static int gsH = 1;
    private static int gsI = 2;
    private static int gsJ = 1;
    private static int gsK = 0;
    private static h gsk;
    private static com.baidu.tieba.i.k gsl;
    private Map<String, String> aow;
    private String bBb;
    private g.i bNA;
    private g.d bNB;
    private g.h bNC;
    private final CustomMessageListener bNI;
    private g.a bNu;
    private g.f bNv;
    private g.b bNw;
    private g.c bNx;
    private g.e bNy;
    private g.InterfaceC0150g bNz;
    private int bRF;
    private b bYW;
    private int gcG;
    private a grV;
    private com.baidu.tieba.play.c.f gsA;
    private String gsB;
    private long gsC;
    private boolean gsD;
    private long gsE;
    private long gsF;
    private int gsL;
    private int gsM;
    private int gsN;
    private int gsO;
    private int gsP;
    private int gsQ;
    private Runnable gsR;
    private Runnable gsS;
    private TextureView.SurfaceTextureListener gsT;
    private g.f gsU;
    private g.a gsV;
    private g.InterfaceC0150g gsW;
    private Runnable gsX;
    private o gsg;
    private String gsh;
    private g gsi;
    private g.e gsj;
    private com.baidu.tieba.i.i gsm;
    private com.baidu.tieba.i.e gsn;
    private String gso;
    private boolean gsp;
    private d gsq;
    private boolean gsr;
    private int gss;
    private boolean gst;
    private int gsu;
    private boolean gsv;
    private SurfaceTexture gsw;
    private boolean gsx;
    private com.baidu.tieba.play.c.a gsy;
    private r gsz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bjQ();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            gsk = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            gsl = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gsx = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gsp = false;
        this.gsr = false;
        this.gss = 0;
        this.gst = false;
        this.gsu = -1;
        this.gsv = false;
        this.gsw = null;
        this.gsx = true;
        this.gsE = 0L;
        this.gsF = 0L;
        this.gcG = gsK;
        this.gsL = 0;
        this.gsM = 0;
        this.gsN = -1;
        this.gsO = 0;
        this.gsP = 0;
        this.gsQ = 0;
        this.bRF = 0;
        this.gsR = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gsi != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gsi, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gsS = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.iY(false);
                }
            }
        };
        this.gsT = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gsr) {
                    QuickVideoView.this.gsr = false;
                    if (QuickVideoView.this.gsi != null) {
                        QuickVideoView.this.gsi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aow, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gsm.aVj();
                    }
                } else if (QuickVideoView.this.gsi != null && QuickVideoView.this.gsv) {
                    QuickVideoView.this.gsi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aow, surfaceTexture, QuickVideoView.this.gsu);
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.bjQ();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gsm.aVk();
                    }
                }
                QuickVideoView.this.gsw = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkg();
                QuickVideoView.this.lG(false);
                if (QuickVideoView.this.gsi != null) {
                    QuickVideoView.this.gsi.release();
                }
                if (!QuickVideoView.this.gsr) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.onStop();
                    }
                    if (QuickVideoView.this.bYW != null) {
                        QuickVideoView.this.bYW.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gsw = null;
                if (QuickVideoView.this.gsm != null && QuickVideoView.this.gsm.pw(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gsm = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gsU = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkg();
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.onPrepared();
                }
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.se(QuickVideoView.this.gsi.getPlayerType());
                }
                if (QuickVideoView.this.bNv != null) {
                    QuickVideoView.this.bNv.onPrepared(gVar);
                }
                if (QuickVideoView.this.gsq != null) {
                    long j = 0;
                    if (QuickVideoView.this.gsi != null) {
                        j = QuickVideoView.this.gsi.getDuration();
                    }
                    QuickVideoView.this.gsq.cL(j);
                    QuickVideoView.this.bkf();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gsq.bjX();
                        QuickVideoView.this.bki();
                    }
                }
                if (QuickVideoView.this.gsp) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gsg != null && gVar != null) {
                    QuickVideoView.this.gsg.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gss);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gsh) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gsh);
                }
                if (QuickVideoView.this.gsy != null && QuickVideoView.this.gsy.bkO()) {
                    com.baidu.tieba.play.c.e.tY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gsV = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lG(true);
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.pv(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gsm = null;
                }
                if (!QuickVideoView.this.gst || QuickVideoView.this.gsq == null) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.onCompletion();
                    }
                    QuickVideoView.this.gsp = false;
                    if (QuickVideoView.this.bNu != null) {
                        QuickVideoView.this.bNu.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gso = null;
                QuickVideoView.this.gsC = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gsq.bjR());
                QuickVideoView.this.start();
            }
        };
        this.bNx = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.ag(i, i2, i3);
                QuickVideoView.this.bkg();
                if (QuickVideoView.this.gsq != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gsD = true;
                    z.bkI().aA(QuickVideoView.this.gsq.bjR(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gsm != null) {
                        QuickVideoView.this.gso = QuickVideoView.this.gsm.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gsC, QuickVideoView.this.J(QuickVideoView.this.gsm.aVp(), i3 + "", QuickVideoView.this.gsm.aVq()));
                        QuickVideoView.this.gsm = null;
                    }
                    QuickVideoView.this.gsC = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.tW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.tX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNw == null || QuickVideoView.this.bNw.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gsW = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0150g
            public void a(g gVar) {
                if (QuickVideoView.this.gsD) {
                    QuickVideoView.this.gsD = false;
                    return;
                }
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.bks();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gsq != null && z) {
                    QuickVideoView.this.gsq.onSeekComplete();
                }
                if (QuickVideoView.this.bNz != null) {
                    QuickVideoView.this.bNz.a(gVar);
                }
            }
        };
        this.bNy = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gsj != null) {
                    QuickVideoView.this.gsj.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gss = i2;
                    if (QuickVideoView.this.gsg != null && gVar != null) {
                        QuickVideoView.this.gsg.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gss);
                    }
                }
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.a(i, i2, QuickVideoView.this.gsm);
                    return true;
                }
                return true;
            }
        };
        this.bNA = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.i(i, i2, str);
                }
            }
        };
        this.bNB = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.px(str);
                }
            }
        };
        this.bNC = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gsC = j;
                }
            }
        };
        this.gsX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gsq != null && QuickVideoView.this.gsq.bjT() && QuickVideoView.this.gsq.bjU() && QuickVideoView.this.gsq.bjV() && QuickVideoView.this.gsi != null) {
                    int SC = QuickVideoView.this.gsi.SC();
                    int currentPosition = QuickVideoView.this.gsi.getCurrentPosition();
                    int duration = QuickVideoView.this.gsi.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gsE;
                    boolean z = currentPosition + SC < duration;
                    if (SC < QuickVideoView.this.gsq.bjW() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gsE = currentTimeMillis;
                        QuickVideoView.this.gsq.tT(0);
                    }
                    if (QuickVideoView.this.bkh() && currentPosition == QuickVideoView.this.gsF && j > 500) {
                        QuickVideoView.this.gsE = currentTimeMillis;
                        QuickVideoView.this.gsq.tT(0);
                    }
                    QuickVideoView.this.gsF = currentPosition;
                    if (QuickVideoView.this.gcG == QuickVideoView.gsJ) {
                        QuickVideoView.this.bki();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.bjZ();
                    }
                    if (QuickVideoView.this.gsm != null) {
                        QuickVideoView.this.gsm.pu(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gsm = null;
                    }
                    QuickVideoView.this.bkg();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsp = false;
        this.gsr = false;
        this.gss = 0;
        this.gst = false;
        this.gsu = -1;
        this.gsv = false;
        this.gsw = null;
        this.gsx = true;
        this.gsE = 0L;
        this.gsF = 0L;
        this.gcG = gsK;
        this.gsL = 0;
        this.gsM = 0;
        this.gsN = -1;
        this.gsO = 0;
        this.gsP = 0;
        this.gsQ = 0;
        this.bRF = 0;
        this.gsR = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gsi != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gsi, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gsS = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.iY(false);
                }
            }
        };
        this.gsT = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gsr) {
                    QuickVideoView.this.gsr = false;
                    if (QuickVideoView.this.gsi != null) {
                        QuickVideoView.this.gsi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aow, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gsm.aVj();
                    }
                } else if (QuickVideoView.this.gsi != null && QuickVideoView.this.gsv) {
                    QuickVideoView.this.gsi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aow, surfaceTexture, QuickVideoView.this.gsu);
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.bjQ();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gsm.aVk();
                    }
                }
                QuickVideoView.this.gsw = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkg();
                QuickVideoView.this.lG(false);
                if (QuickVideoView.this.gsi != null) {
                    QuickVideoView.this.gsi.release();
                }
                if (!QuickVideoView.this.gsr) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.onStop();
                    }
                    if (QuickVideoView.this.bYW != null) {
                        QuickVideoView.this.bYW.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gsw = null;
                if (QuickVideoView.this.gsm != null && QuickVideoView.this.gsm.pw(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gsm = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gsU = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkg();
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.onPrepared();
                }
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.se(QuickVideoView.this.gsi.getPlayerType());
                }
                if (QuickVideoView.this.bNv != null) {
                    QuickVideoView.this.bNv.onPrepared(gVar);
                }
                if (QuickVideoView.this.gsq != null) {
                    long j = 0;
                    if (QuickVideoView.this.gsi != null) {
                        j = QuickVideoView.this.gsi.getDuration();
                    }
                    QuickVideoView.this.gsq.cL(j);
                    QuickVideoView.this.bkf();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gsq.bjX();
                        QuickVideoView.this.bki();
                    }
                }
                if (QuickVideoView.this.gsp) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gsg != null && gVar != null) {
                    QuickVideoView.this.gsg.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gss);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gsh) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gsh);
                }
                if (QuickVideoView.this.gsy != null && QuickVideoView.this.gsy.bkO()) {
                    com.baidu.tieba.play.c.e.tY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gsV = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lG(true);
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.pv(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gsm = null;
                }
                if (!QuickVideoView.this.gst || QuickVideoView.this.gsq == null) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.onCompletion();
                    }
                    QuickVideoView.this.gsp = false;
                    if (QuickVideoView.this.bNu != null) {
                        QuickVideoView.this.bNu.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gso = null;
                QuickVideoView.this.gsC = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gsq.bjR());
                QuickVideoView.this.start();
            }
        };
        this.bNx = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.ag(i, i2, i3);
                QuickVideoView.this.bkg();
                if (QuickVideoView.this.gsq != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gsD = true;
                    z.bkI().aA(QuickVideoView.this.gsq.bjR(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gsm != null) {
                        QuickVideoView.this.gso = QuickVideoView.this.gsm.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gsC, QuickVideoView.this.J(QuickVideoView.this.gsm.aVp(), i3 + "", QuickVideoView.this.gsm.aVq()));
                        QuickVideoView.this.gsm = null;
                    }
                    QuickVideoView.this.gsC = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.tW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.tX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNw == null || QuickVideoView.this.bNw.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gsW = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0150g
            public void a(g gVar) {
                if (QuickVideoView.this.gsD) {
                    QuickVideoView.this.gsD = false;
                    return;
                }
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.bks();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gsq != null && z) {
                    QuickVideoView.this.gsq.onSeekComplete();
                }
                if (QuickVideoView.this.bNz != null) {
                    QuickVideoView.this.bNz.a(gVar);
                }
            }
        };
        this.bNy = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (QuickVideoView.this.gsj != null) {
                    QuickVideoView.this.gsj.a(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gss = i2;
                    if (QuickVideoView.this.gsg != null && gVar != null) {
                        QuickVideoView.this.gsg.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gss);
                    }
                }
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.a(i, i2, QuickVideoView.this.gsm);
                    return true;
                }
                return true;
            }
        };
        this.bNA = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.i(i, i2, str);
                }
            }
        };
        this.bNB = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.px(str);
                }
            }
        };
        this.bNC = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gsC = j;
                }
            }
        };
        this.gsX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gsq != null && QuickVideoView.this.gsq.bjT() && QuickVideoView.this.gsq.bjU() && QuickVideoView.this.gsq.bjV() && QuickVideoView.this.gsi != null) {
                    int SC = QuickVideoView.this.gsi.SC();
                    int currentPosition = QuickVideoView.this.gsi.getCurrentPosition();
                    int duration = QuickVideoView.this.gsi.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gsE;
                    boolean z = currentPosition + SC < duration;
                    if (SC < QuickVideoView.this.gsq.bjW() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gsE = currentTimeMillis;
                        QuickVideoView.this.gsq.tT(0);
                    }
                    if (QuickVideoView.this.bkh() && currentPosition == QuickVideoView.this.gsF && j > 500) {
                        QuickVideoView.this.gsE = currentTimeMillis;
                        QuickVideoView.this.gsq.tT(0);
                    }
                    QuickVideoView.this.gsF = currentPosition;
                    if (QuickVideoView.this.gcG == QuickVideoView.gsJ) {
                        QuickVideoView.this.bki();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.bjZ();
                    }
                    if (QuickVideoView.this.gsm != null) {
                        QuickVideoView.this.gsm.pu(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gsm = null;
                    }
                    QuickVideoView.this.bkg();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsp = false;
        this.gsr = false;
        this.gss = 0;
        this.gst = false;
        this.gsu = -1;
        this.gsv = false;
        this.gsw = null;
        this.gsx = true;
        this.gsE = 0L;
        this.gsF = 0L;
        this.gcG = gsK;
        this.gsL = 0;
        this.gsM = 0;
        this.gsN = -1;
        this.gsO = 0;
        this.gsP = 0;
        this.gsQ = 0;
        this.bRF = 0;
        this.gsR = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gsi != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gsi, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gsS = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.iY(false);
                }
            }
        };
        this.gsT = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gsr) {
                    QuickVideoView.this.gsr = false;
                    if (QuickVideoView.this.gsi != null) {
                        QuickVideoView.this.gsi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aow, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gsm.aVj();
                    }
                } else if (QuickVideoView.this.gsi != null && QuickVideoView.this.gsv) {
                    QuickVideoView.this.gsi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.aow, surfaceTexture, QuickVideoView.this.gsu);
                    if (QuickVideoView.this.grV != null) {
                        QuickVideoView.this.grV.bjQ();
                    }
                    if (QuickVideoView.this.i(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gsm.aVk();
                    }
                }
                QuickVideoView.this.gsw = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bkg();
                QuickVideoView.this.lG(false);
                if (QuickVideoView.this.gsi != null) {
                    QuickVideoView.this.gsi.release();
                }
                if (!QuickVideoView.this.gsr) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.onStop();
                    }
                    if (QuickVideoView.this.bYW != null) {
                        QuickVideoView.this.bYW.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gsw = null;
                if (QuickVideoView.this.gsm != null && QuickVideoView.this.gsm.pw(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gsm = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.gsU = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                QuickVideoView.this.bkg();
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.onPrepared();
                }
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.se(QuickVideoView.this.gsi.getPlayerType());
                }
                if (QuickVideoView.this.bNv != null) {
                    QuickVideoView.this.bNv.onPrepared(gVar);
                }
                if (QuickVideoView.this.gsq != null) {
                    long j = 0;
                    if (QuickVideoView.this.gsi != null) {
                        j = QuickVideoView.this.gsi.getDuration();
                    }
                    QuickVideoView.this.gsq.cL(j);
                    QuickVideoView.this.bkf();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gsq.bjX();
                        QuickVideoView.this.bki();
                    }
                }
                if (QuickVideoView.this.gsp) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gsg != null && gVar != null) {
                    QuickVideoView.this.gsg.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gss);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gsh) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gsh);
                }
                if (QuickVideoView.this.gsy != null && QuickVideoView.this.gsy.bkO()) {
                    com.baidu.tieba.play.c.e.tY(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gsV = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lG(true);
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.pv(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gsm = null;
                }
                if (!QuickVideoView.this.gst || QuickVideoView.this.gsq == null) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.onCompletion();
                    }
                    QuickVideoView.this.gsp = false;
                    if (QuickVideoView.this.bNu != null) {
                        QuickVideoView.this.bNu.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gso = null;
                QuickVideoView.this.gsC = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gsq.bjR());
                QuickVideoView.this.start();
            }
        };
        this.bNx = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.c.e.ag(i2, i22, i3);
                QuickVideoView.this.bkg();
                if (QuickVideoView.this.gsq != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gsD = true;
                    z.bkI().aA(QuickVideoView.this.gsq.bjR(), QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    if (QuickVideoView.this.gsm != null) {
                        QuickVideoView.this.gso = QuickVideoView.this.gsm.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gsC, QuickVideoView.this.J(QuickVideoView.this.gsm.aVp(), i3 + "", QuickVideoView.this.gsm.aVq()));
                        QuickVideoView.this.gsm = null;
                    }
                    QuickVideoView.this.gsC = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.c.e.tW(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.tX(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bNw == null || QuickVideoView.this.bNw.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gsW = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0150g
            public void a(g gVar) {
                if (QuickVideoView.this.gsD) {
                    QuickVideoView.this.gsD = false;
                    return;
                }
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.bks();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gsq != null && z) {
                    QuickVideoView.this.gsq.onSeekComplete();
                }
                if (QuickVideoView.this.bNz != null) {
                    QuickVideoView.this.bNz.a(gVar);
                }
            }
        };
        this.bNy = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gsj != null) {
                    QuickVideoView.this.gsj.a(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gss = i22;
                    if (QuickVideoView.this.gsg != null && gVar != null) {
                        QuickVideoView.this.gsg.af(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gss);
                    }
                }
                if (QuickVideoView.this.gsz != null) {
                    QuickVideoView.this.gsz.a(i2, i22, QuickVideoView.this.gsm);
                    return true;
                }
                return true;
            }
        };
        this.bNA = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.i(i2, i22, str);
                }
            }
        };
        this.bNB = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gsm != null) {
                    QuickVideoView.this.gsm.px(str);
                }
            }
        };
        this.bNC = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gsC = j;
                }
            }
        };
        this.gsX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gsq != null && QuickVideoView.this.gsq.bjT() && QuickVideoView.this.gsq.bjU() && QuickVideoView.this.gsq.bjV() && QuickVideoView.this.gsi != null) {
                    int SC = QuickVideoView.this.gsi.SC();
                    int currentPosition = QuickVideoView.this.gsi.getCurrentPosition();
                    int duration = QuickVideoView.this.gsi.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gsE;
                    boolean z = currentPosition + SC < duration;
                    if (SC < QuickVideoView.this.gsq.bjW() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.gsE = currentTimeMillis;
                        QuickVideoView.this.gsq.tT(0);
                    }
                    if (QuickVideoView.this.bkh() && currentPosition == QuickVideoView.this.gsF && j > 500) {
                        QuickVideoView.this.gsE = currentTimeMillis;
                        QuickVideoView.this.gsq.tT(0);
                    }
                    QuickVideoView.this.gsF = currentPosition;
                    if (QuickVideoView.this.gcG == QuickVideoView.gsJ) {
                        QuickVideoView.this.bki();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gsq != null) {
                        QuickVideoView.this.gsq.bjZ();
                    }
                    if (QuickVideoView.this.gsm != null) {
                        QuickVideoView.this.gsm.pu(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gsm = null;
                    }
                    QuickVideoView.this.bkg();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gsg = new o(context);
        this.gsg.setSurfaceTextureListener(this.gsT);
        if (gsk != null) {
            this.gsi = gsk.SD();
        }
        if (this.gsi != null) {
            this.gsi.setOnPreparedListener(this.gsU);
            this.gsi.setOnCompletionListener(this.gsV);
            this.gsi.a(this.bNx);
            this.gsi.setOnSeekCompleteListener(this.gsW);
            this.gsi.a(this.bNy);
            this.gsi.a(this.bNA);
            this.gsi.a(this.bNB);
            this.gsi.a(this.bNC);
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
        this.gsy = new com.baidu.tieba.play.c.a(this);
        this.gsz = new r();
        this.gsA = new com.baidu.tieba.play.c.f();
    }

    public void bN(String str, String str2) {
        this.bBb = str2;
        if (this.gsy != null) {
            this.gsy.clear();
            this.gsy.bkO();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.c.e.rj(str2);
            if (gsl != null) {
                this.gsm = gsl.I(this.bBb, str, "");
                if (this.gsm != null) {
                    this.gsm.a(-300, -44399, -44399, getLocateSource(), false, this.gsC, "");
                    this.gsm = null;
                }
            }
        }
        if (this.gsn != null) {
            this.gsn.a(null);
            this.gsn.aVc();
            this.gsn = null;
        }
        this.gso = null;
        this.gsC = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.gsm != null) {
            this.gsm.aVo();
            this.gsm = null;
        }
        if (!am.isEmpty(str)) {
            this.gsB = str;
            if (i(Uri.parse(str)) != null) {
                this.gsm.aVi();
            }
            if (this.gsq != null) {
                str = this.gsq.hM(str);
                if (this.gsq.bjY() != null) {
                    this.gsq.bjY().setPlayer(this);
                }
                if (gsl != null && rb(str)) {
                    this.gsn = gsl.pz(str);
                }
                if (this.gsn != null) {
                    this.gsn.a(new com.baidu.tieba.play.b.a(this.bBb, this.gsB, this.gsm));
                    this.gsn.aVb();
                }
                ra(str);
            }
            if (!com.baidu.adp.lib.util.j.oJ() && !rb(str)) {
                if (this.bNw != null) {
                    this.bNw.onError(this.gsi, -10000, -10000);
                    return;
                }
                return;
            }
            bkd();
            setVideoURI(Uri.parse(str));
        }
    }

    private void bkd() {
        if (com.baidu.tbadk.coreExtra.model.f.If()) {
            if (this.gsq != null && (this.gsq.bjS() || this.gsq.bjT())) {
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsR);
                com.baidu.adp.lib.g.e.ns().postDelayed(this.gsR, com.baidu.tbadk.coreExtra.model.f.Ie());
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsS);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.gsS, com.baidu.tbadk.coreExtra.model.f.Id());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (i(uri) != null) {
            this.gsm.pt(uri.toString());
        }
        bke();
        this.gsr = true;
        this.mUri = uri;
        this.aow = map;
        this.gss = 0;
        removeView(this.gsg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gsx) {
            addView(this.gsg, layoutParams);
        } else {
            addView(this.gsg, 0, layoutParams);
        }
        aj.t(this, d.C0108d.cp_bg_line_k);
    }

    private void bke() {
        this.gsr = false;
        this.gsp = false;
        if (this.gsi != null) {
            this.gsi.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsX);
    }

    private void ra(String str) {
        this.gsM = 0;
        this.gsN = 0;
        this.gsO = 0;
        this.gsP = 0;
        this.gsQ = 0;
        this.bRF = 0;
        if (this.gsq.bjT()) {
            this.gsL = gsH;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gsN = (int) u.rd(QuickVideoView.this.gsB);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gsB != null && this.gsB.equals(str)) {
            this.gsL = gsG;
        } else {
            this.gsL = gsI;
        }
        this.gcG = gsJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkf() {
        this.gcG = gsJ;
        if (this.gsi != null) {
            this.gsM = this.gsi.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        if (this.gcG == gsJ && this.gsi != null) {
            this.gcG = gsK;
            this.gsP = this.gsi.getDuration();
            if (z) {
                this.gsQ = 0;
                this.gsO = this.gsP;
            } else {
                this.gsO = this.gsi.getCurrentPosition();
                this.gsQ = this.gsi.getCachedSize();
            }
            if (this.gsO > 0) {
                if (this.gsL == gsG) {
                    this.gsN = (int) u.rd(this.gsB);
                    if (this.gsM > 0) {
                        long j = (this.gsM * (this.gsO / 1000)) / 8;
                        if (this.gsQ < 0) {
                            this.gsQ = 0;
                        }
                        long j2 = this.gsQ + j;
                        if (this.gsN > 0) {
                            j2 += this.gsN;
                        }
                        a(j2, this.gsO, this.gsP, this.bRF);
                    } else if (this.gsM == -1) {
                        this.gsM = 603327;
                        a((this.gsM * (this.gsO / 1000)) / 8, this.gsO, this.gsP, this.bRF);
                    }
                } else if (this.gsL == gsH) {
                    if (this.gsM > 0) {
                        long j3 = (this.gsM * (this.gsO / 1000)) / 8;
                        if (this.gsQ < 0) {
                            this.gsQ = 0;
                        }
                        long j4 = this.gsQ + j3;
                        if (this.gsN > 0) {
                            j4 -= this.gsN;
                        }
                        a(j4, this.gsO, this.gsP, this.bRF);
                    } else if (this.gsM == -1) {
                        this.gsM = 603327;
                        a((this.gsM * (this.gsO / 1000)) / 8, this.gsO, this.gsP, this.bRF);
                    }
                } else {
                    a(0L, this.gsO, this.gsP, this.bRF);
                }
            }
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsX);
    }

    public void stopPlayback() {
        bkg();
        lG(false);
        if (this.gsy != null) {
            this.gsy.clear();
        }
        this.gsh = null;
        bke();
        this.gst = false;
        if (this.gsq != null) {
            this.gsq.onStop();
        }
        com.baidu.tieba.play.a.b.bkL().a((b.InterfaceC0147b) null);
        if (this.gsm != null && this.gsm.pw(getLocateSource())) {
            this.gsm = null;
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkg() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsR);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsS);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bNv = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bNu = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bNw = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0150g interfaceC0150g) {
        this.bNz = interfaceC0150g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String J(String str, String str2, String str3) {
        if (this.gsA == null) {
            return "";
        }
        String bkQ = this.gsA.bkQ();
        this.gsA.K(str, str2, str3);
        return bkQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gsq != null && !StringUtils.isNull(this.gsq.bjR())) {
            String uri = this.mUri.toString();
            if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                com.baidu.tieba.play.c.a.ri(uri);
            }
            this.mUri = Uri.parse(this.gsq.bjR());
        }
        boolean z = false;
        if (this.gsy != null) {
            z = this.gsy.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gsm != null) {
            this.gso = this.gsm.a(i, i2, i3, getLocateSource(), z, this.gsC, J(this.gsm.aVp(), i3 + "", this.gsm.aVq()));
            this.gsm = null;
        }
        this.gsC = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gsi != null) {
            try {
                this.gsi.release();
                this.gsh = str;
                URI uri = new URI(this.mUri.toString());
                this.gsi.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.aow, this.gsw, this.mUri.getHost());
                if (i(this.mUri) != null) {
                    this.gsm.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gsi != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.gsi.release();
            this.gsi.a(this.mContext, this.mUri, this.aow, this.gsw, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gsm.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gsi != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gsi.forceUseSystemMediaPlayer(true);
            }
            this.gsi.release();
            this.gsi.a(this.mContext, this.mUri, this.aow, this.gsw, this.mUri.getHost());
            if (i(this.mUri) != null) {
                this.gsm.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gsp = true;
        if (this.gsi != null) {
            if (this.gsw != null && this.gsv && !this.gsi.isExistInRemote()) {
                this.gsi.a(this.mContext, this.mUri, this.aow, this.gsw, this.gsu);
                if (this.grV != null) {
                    this.grV.bjQ();
                }
                if (i(this.mUri) != null) {
                    this.gsm.aVk();
                }
                bkd();
                return;
            }
            this.gsi.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.gsq != null) {
            this.gsq.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (i(this.mUri) != null) {
            this.gsm.sf(this.gsi.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bkg();
        if (this.gsi != null) {
            this.gsi.pause();
        }
        if (this.gsq != null) {
            this.gsq.onPause();
        }
        this.gsp = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gsm != null) {
            this.gsm.aVn();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gsi != null) {
            return this.gsi.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gsi != null) {
            return this.gsi.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bRF = i;
        tU(i);
    }

    public void tU(int i) {
        if (this.gsz != null) {
            this.gsz.bkr();
        }
        if (this.gsi != null) {
            this.gsi.seekTo(i);
        }
        if (this.gsq != null) {
            this.gsq.tT(0);
            bki();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gsi != null) {
            return this.gsi.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gsi != null) {
            this.gsi.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gsu = i;
    }

    public int getRecoveryState() {
        return this.gsu;
    }

    public void setNeedRecovery(boolean z) {
        this.gsv = z;
    }

    public void setLooping(boolean z) {
        this.gst = z;
    }

    public boolean bkh() {
        return this.gsp;
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
        this.bYW = bVar;
    }

    public void setBusiness(d dVar) {
        this.gsq = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bNI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gst = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gsi != null) {
            this.gsi.OF();
        }
        if (this.gsz != null) {
            this.gsz.bkt();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsX);
        MessageManager.getInstance().unRegisterListener(this.bNI);
        if (this.gsy != null) {
            this.gsy.clear();
        }
        if (this.gsn != null) {
            this.gsn.a(null);
            this.gsn.aVc();
        }
    }

    public g getPlayer() {
        return this.gsi;
    }

    public int getPlayerType() {
        if (this.gsi == null) {
            return -300;
        }
        return this.gsi.getPlayerType();
    }

    public void bki() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gsX);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gsX, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.grV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gsq instanceof n) || ((n) this.gsq).bkp() == null) ? "" : ((n) this.gsq).bkp().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i i(Uri uri) {
        String uri2;
        if (this.gsm != null) {
            return this.gsm;
        }
        if (!StringUtils.isNull(this.gsB)) {
            uri2 = this.gsB;
        } else if (gsl != null && this.gsq != null && !StringUtils.isNull(this.gsq.bjR())) {
            uri2 = this.gsq.bjR();
        } else {
            uri2 = (gsl == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gsl != null) {
            this.gsm = gsl.I(this.bBb, uri2, this.gso);
        }
        this.gso = null;
        this.gsC = 0L;
        return this.gsm;
    }

    public void a(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.b.b.a(this.gsm, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.b.b.a(this.gsm, j);
    }

    public static boolean rb(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gsj = eVar;
    }
}
