package com.baidu.tieba.play;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.play.b.b;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a, com.baidu.tieba.play.c.c {
    private static h drD;
    private static com.baidu.tieba.j.l drE;
    private static int ixB = 0;
    private static int ixC = 1;
    private static int ixD = 2;
    private static int ixE = 1;
    private static int ixF = 0;
    private WeakReference<Context> bUw;
    private g.b cUp;
    private b cUt;
    private String cmS;
    private g.a ddK;
    private g.f ddL;
    private g.c ddM;
    private g.e ddN;
    private g.InterfaceC0498g ddO;
    private g.i ddP;
    private g.d ddQ;
    private g.h ddR;
    private final CustomMessageListener ddY;
    private int diR;
    private g.f drF;
    private g.a drG;
    private g.InterfaceC0498g drJ;
    private boolean drw;
    private int igO;
    private a iwG;
    private RenderView iwZ;
    private long ixA;
    private int ixG;
    private int ixH;
    private int ixI;
    private int ixJ;
    private int ixK;
    private int ixL;
    private boolean ixM;
    private Runnable ixN;
    private Runnable ixO;
    private TextureView.SurfaceTextureListener ixP;
    private Runnable ixQ;
    private String ixa;
    private g ixb;
    private g.e ixc;
    private c ixd;
    private com.baidu.tieba.j.i ixe;
    private com.baidu.tieba.j.e ixf;
    private String ixg;
    private boolean ixh;
    private d ixi;
    private com.baidu.tieba.j.k ixj;
    private boolean ixk;
    private int ixl;
    private int ixm;
    private boolean ixn;
    private SurfaceTexture ixo;
    private boolean ixp;
    private com.baidu.tieba.play.c.a ixq;
    private r ixr;
    private com.baidu.tieba.play.c.f ixs;
    private String ixt;
    private String ixu;
    private String ixv;
    private long ixw;
    private boolean ixx;
    private boolean ixy;
    private long ixz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;
    private Map<String, String> tg;

    /* loaded from: classes.dex */
    public interface a {
        void cbZ();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onStart();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            drD = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            drE = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.ixp = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.ixh = false;
        this.ixk = false;
        this.ixl = 0;
        this.drw = false;
        this.ixm = -1;
        this.ixn = false;
        this.ixo = null;
        this.ixp = true;
        this.ixz = 0L;
        this.ixA = 0L;
        this.igO = ixF;
        this.ixG = 0;
        this.ixH = 0;
        this.ixI = -1;
        this.ixJ = 0;
        this.ixK = 0;
        this.ixL = 0;
        this.diR = 0;
        this.ixM = false;
        this.bUw = null;
        this.ixN = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ixb != null && QuickVideoView.this.ixh) {
                    QuickVideoView.this.b(QuickVideoView.this.ixb, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ixO = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.nn(false);
                }
            }
        };
        this.ixP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ixM) {
                    QuickVideoView.this.ixM = false;
                    if (QuickVideoView.this.ixb != null) {
                        QuickVideoView.this.ixb.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.ixk || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ixb != null && QuickVideoView.this.ixn) {
                        QuickVideoView.this.ixb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.tg, surfaceTexture, QuickVideoView.this.ixm);
                        if (QuickVideoView.this.iwG != null) {
                            QuickVideoView.this.iwG.cbZ();
                        }
                        if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ixe.bMH();
                        }
                    }
                } else if (ccu()) {
                    if (QuickVideoView.this.ixb != null) {
                        QuickVideoView.this.ccn();
                        QuickVideoView.this.ixk = true;
                        QuickVideoView.this.ixb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.tg, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ixe.bMG();
                    }
                }
                QuickVideoView.this.ixo = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ixM) {
                    QuickVideoView.this.ccp();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.ixb != null) {
                        if (QuickVideoView.this.ixb.isPlaying() && QuickVideoView.this.ccs()) {
                            y.ccT().bd(QuickVideoView.this.ixv, QuickVideoView.this.ixb.getCurrentPosition());
                        }
                        QuickVideoView.this.ixb.release();
                    }
                    if (QuickVideoView.this.ixk) {
                        if (QuickVideoView.this.ixi != null) {
                            QuickVideoView.this.ixi.onStop();
                        }
                        if (QuickVideoView.this.cUt != null) {
                            QuickVideoView.this.cUt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ixo = null;
                    if (QuickVideoView.this.ixe != null && QuickVideoView.this.ixe.zX(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ixk = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ccu() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                            if (runningTaskInfo.topActivity.getClassName().equals(((Activity) QuickVideoView.this.mContext).getClass().getName())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.drF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int BS;
                QuickVideoView.this.ccp();
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.onPrepared();
                }
                if (QuickVideoView.this.ixe != null && QuickVideoView.this.ixb != null) {
                    QuickVideoView.this.ixe.vW(QuickVideoView.this.ixb.getPlayerType());
                }
                if (QuickVideoView.this.ddL != null) {
                    QuickVideoView.this.ixj.bMW();
                    QuickVideoView.this.ddL.onPrepared(gVar);
                }
                if (QuickVideoView.this.ixi != null) {
                    long j = 0;
                    if (QuickVideoView.this.ixb != null) {
                        j = QuickVideoView.this.ixb.getDuration();
                    }
                    QuickVideoView.this.ixi.dO(j);
                    QuickVideoView.this.cco();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ixi.ccg();
                        QuickVideoView.this.ccr();
                    }
                }
                if (QuickVideoView.this.ixy && (BS = y.ccT().BS(QuickVideoView.this.ixv)) > 0 && QuickVideoView.this.ixb != null) {
                    if (QuickVideoView.this.ixb.isPlayerReuse()) {
                        if (QuickVideoView.this.ixb.getCurrentPosition() == 0) {
                            QuickVideoView.this.xH(BS);
                        }
                    } else {
                        QuickVideoView.this.xH(BS);
                    }
                }
                if (QuickVideoView.this.ixh) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iwZ != null && gVar != null) {
                    QuickVideoView.this.iwZ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ixl);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ixa) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ixa);
                }
                if (QuickVideoView.this.ixq != null && QuickVideoView.this.ixq.cdo()) {
                    com.baidu.tieba.play.c.e.xO(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.drG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.zW(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ixe = null;
                }
                if (!QuickVideoView.this.drw || QuickVideoView.this.ixi == null) {
                    if (QuickVideoView.this.ixi != null) {
                        QuickVideoView.this.ixi.onCompletion();
                    }
                    QuickVideoView.this.ixh = false;
                    y.ccT().remove(QuickVideoView.this.ixv);
                    if (QuickVideoView.this.ddK != null) {
                        QuickVideoView.this.ddK.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ixg = null;
                QuickVideoView.this.ixw = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ixi.cca());
                QuickVideoView.this.start();
            }
        };
        this.ddM = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.W(i, i2, i3);
                QuickVideoView.this.ccp();
                if (QuickVideoView.this.ixi != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ccs()) {
                    QuickVideoView.this.ixx = true;
                    y.ccT().bd(QuickVideoView.this.ixv, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.ixe != null) {
                        QuickVideoView.this.ixg = QuickVideoView.this.ixe.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ixw, QuickVideoView.this.ac(QuickVideoView.this.ixe.bML(), i3 + "", QuickVideoView.this.ixe.bMM()));
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ixw = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.xM(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.xN(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cUp == null || QuickVideoView.this.cUp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.drJ = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (QuickVideoView.this.ixx) {
                    QuickVideoView.this.ixx = false;
                    return;
                }
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.ccD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ixi != null && z) {
                    QuickVideoView.this.ixi.onSeekComplete();
                }
                if (QuickVideoView.this.ddO != null) {
                    QuickVideoView.this.ddO.b(gVar);
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ixc != null) {
                    QuickVideoView.this.ixc.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ixl = i2;
                    if (QuickVideoView.this.iwZ != null && gVar != null) {
                        QuickVideoView.this.iwZ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ixl);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.ixj.a(QuickVideoView.this.cmS, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.a(i, i2, QuickVideoView.this.ixe);
                    return true;
                }
                return true;
            }
        };
        this.ddP = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.i(i, i2, str);
                }
            }
        };
        this.ddQ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.zY(str);
                }
            }
        };
        this.ddR = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ixw = j;
                }
            }
        };
        this.ixQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ixi != null && QuickVideoView.this.ixi.ccc() && QuickVideoView.this.ixi.ccd() && QuickVideoView.this.ixi.cce() && QuickVideoView.this.ixb != null) {
                    int aCe = QuickVideoView.this.ixb.aCe();
                    int currentPosition = QuickVideoView.this.ixb.getCurrentPosition();
                    int duration = QuickVideoView.this.ixb.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ixz;
                    boolean z = currentPosition + aCe < duration;
                    if (aCe < QuickVideoView.this.ixi.ccf() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ixz = currentTimeMillis;
                        QuickVideoView.this.ixi.xF(0);
                    }
                    if (QuickVideoView.this.ccq() && currentPosition == QuickVideoView.this.ixA && j > 500) {
                        QuickVideoView.this.ixz = currentTimeMillis;
                        QuickVideoView.this.ixi.xF(0);
                    }
                    QuickVideoView.this.ixA = currentPosition;
                    if (QuickVideoView.this.igO == QuickVideoView.ixE) {
                        QuickVideoView.this.ccr();
                    }
                }
            }
        };
        this.ddY = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ixi != null) {
                        QuickVideoView.this.ixi.cci();
                    }
                    if (QuickVideoView.this.ixe != null) {
                        QuickVideoView.this.ixe.zV(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ccp();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ixh = false;
        this.ixk = false;
        this.ixl = 0;
        this.drw = false;
        this.ixm = -1;
        this.ixn = false;
        this.ixo = null;
        this.ixp = true;
        this.ixz = 0L;
        this.ixA = 0L;
        this.igO = ixF;
        this.ixG = 0;
        this.ixH = 0;
        this.ixI = -1;
        this.ixJ = 0;
        this.ixK = 0;
        this.ixL = 0;
        this.diR = 0;
        this.ixM = false;
        this.bUw = null;
        this.ixN = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ixb != null && QuickVideoView.this.ixh) {
                    QuickVideoView.this.b(QuickVideoView.this.ixb, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ixO = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.nn(false);
                }
            }
        };
        this.ixP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.ixM) {
                    QuickVideoView.this.ixM = false;
                    if (QuickVideoView.this.ixb != null) {
                        QuickVideoView.this.ixb.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.ixk || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ixb != null && QuickVideoView.this.ixn) {
                        QuickVideoView.this.ixb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.tg, surfaceTexture, QuickVideoView.this.ixm);
                        if (QuickVideoView.this.iwG != null) {
                            QuickVideoView.this.iwG.cbZ();
                        }
                        if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ixe.bMH();
                        }
                    }
                } else if (ccu()) {
                    if (QuickVideoView.this.ixb != null) {
                        QuickVideoView.this.ccn();
                        QuickVideoView.this.ixk = true;
                        QuickVideoView.this.ixb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.tg, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ixe.bMG();
                    }
                }
                QuickVideoView.this.ixo = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ixM) {
                    QuickVideoView.this.ccp();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.ixb != null) {
                        if (QuickVideoView.this.ixb.isPlaying() && QuickVideoView.this.ccs()) {
                            y.ccT().bd(QuickVideoView.this.ixv, QuickVideoView.this.ixb.getCurrentPosition());
                        }
                        QuickVideoView.this.ixb.release();
                    }
                    if (QuickVideoView.this.ixk) {
                        if (QuickVideoView.this.ixi != null) {
                            QuickVideoView.this.ixi.onStop();
                        }
                        if (QuickVideoView.this.cUt != null) {
                            QuickVideoView.this.cUt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ixo = null;
                    if (QuickVideoView.this.ixe != null && QuickVideoView.this.ixe.zX(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ixk = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ccu() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                            if (runningTaskInfo.topActivity.getClassName().equals(((Activity) QuickVideoView.this.mContext).getClass().getName())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.drF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int BS;
                QuickVideoView.this.ccp();
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.onPrepared();
                }
                if (QuickVideoView.this.ixe != null && QuickVideoView.this.ixb != null) {
                    QuickVideoView.this.ixe.vW(QuickVideoView.this.ixb.getPlayerType());
                }
                if (QuickVideoView.this.ddL != null) {
                    QuickVideoView.this.ixj.bMW();
                    QuickVideoView.this.ddL.onPrepared(gVar);
                }
                if (QuickVideoView.this.ixi != null) {
                    long j = 0;
                    if (QuickVideoView.this.ixb != null) {
                        j = QuickVideoView.this.ixb.getDuration();
                    }
                    QuickVideoView.this.ixi.dO(j);
                    QuickVideoView.this.cco();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ixi.ccg();
                        QuickVideoView.this.ccr();
                    }
                }
                if (QuickVideoView.this.ixy && (BS = y.ccT().BS(QuickVideoView.this.ixv)) > 0 && QuickVideoView.this.ixb != null) {
                    if (QuickVideoView.this.ixb.isPlayerReuse()) {
                        if (QuickVideoView.this.ixb.getCurrentPosition() == 0) {
                            QuickVideoView.this.xH(BS);
                        }
                    } else {
                        QuickVideoView.this.xH(BS);
                    }
                }
                if (QuickVideoView.this.ixh) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iwZ != null && gVar != null) {
                    QuickVideoView.this.iwZ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ixl);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ixa) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ixa);
                }
                if (QuickVideoView.this.ixq != null && QuickVideoView.this.ixq.cdo()) {
                    com.baidu.tieba.play.c.e.xO(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.drG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.zW(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ixe = null;
                }
                if (!QuickVideoView.this.drw || QuickVideoView.this.ixi == null) {
                    if (QuickVideoView.this.ixi != null) {
                        QuickVideoView.this.ixi.onCompletion();
                    }
                    QuickVideoView.this.ixh = false;
                    y.ccT().remove(QuickVideoView.this.ixv);
                    if (QuickVideoView.this.ddK != null) {
                        QuickVideoView.this.ddK.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ixg = null;
                QuickVideoView.this.ixw = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ixi.cca());
                QuickVideoView.this.start();
            }
        };
        this.ddM = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.W(i, i2, i3);
                QuickVideoView.this.ccp();
                if (QuickVideoView.this.ixi != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ccs()) {
                    QuickVideoView.this.ixx = true;
                    y.ccT().bd(QuickVideoView.this.ixv, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.ixe != null) {
                        QuickVideoView.this.ixg = QuickVideoView.this.ixe.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ixw, QuickVideoView.this.ac(QuickVideoView.this.ixe.bML(), i3 + "", QuickVideoView.this.ixe.bMM()));
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ixw = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.xM(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.xN(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cUp == null || QuickVideoView.this.cUp.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.drJ = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (QuickVideoView.this.ixx) {
                    QuickVideoView.this.ixx = false;
                    return;
                }
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.ccD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ixi != null && z) {
                    QuickVideoView.this.ixi.onSeekComplete();
                }
                if (QuickVideoView.this.ddO != null) {
                    QuickVideoView.this.ddO.b(gVar);
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.ixc != null) {
                    QuickVideoView.this.ixc.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.ixl = i2;
                    if (QuickVideoView.this.iwZ != null && gVar != null) {
                        QuickVideoView.this.iwZ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ixl);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.ixj.a(QuickVideoView.this.cmS, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.a(i, i2, QuickVideoView.this.ixe);
                    return true;
                }
                return true;
            }
        };
        this.ddP = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.i(i, i2, str);
                }
            }
        };
        this.ddQ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.zY(str);
                }
            }
        };
        this.ddR = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ixw = j;
                }
            }
        };
        this.ixQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ixi != null && QuickVideoView.this.ixi.ccc() && QuickVideoView.this.ixi.ccd() && QuickVideoView.this.ixi.cce() && QuickVideoView.this.ixb != null) {
                    int aCe = QuickVideoView.this.ixb.aCe();
                    int currentPosition = QuickVideoView.this.ixb.getCurrentPosition();
                    int duration = QuickVideoView.this.ixb.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ixz;
                    boolean z = currentPosition + aCe < duration;
                    if (aCe < QuickVideoView.this.ixi.ccf() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ixz = currentTimeMillis;
                        QuickVideoView.this.ixi.xF(0);
                    }
                    if (QuickVideoView.this.ccq() && currentPosition == QuickVideoView.this.ixA && j > 500) {
                        QuickVideoView.this.ixz = currentTimeMillis;
                        QuickVideoView.this.ixi.xF(0);
                    }
                    QuickVideoView.this.ixA = currentPosition;
                    if (QuickVideoView.this.igO == QuickVideoView.ixE) {
                        QuickVideoView.this.ccr();
                    }
                }
            }
        };
        this.ddY = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ixi != null) {
                        QuickVideoView.this.ixi.cci();
                    }
                    if (QuickVideoView.this.ixe != null) {
                        QuickVideoView.this.ixe.zV(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ccp();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ixh = false;
        this.ixk = false;
        this.ixl = 0;
        this.drw = false;
        this.ixm = -1;
        this.ixn = false;
        this.ixo = null;
        this.ixp = true;
        this.ixz = 0L;
        this.ixA = 0L;
        this.igO = ixF;
        this.ixG = 0;
        this.ixH = 0;
        this.ixI = -1;
        this.ixJ = 0;
        this.ixK = 0;
        this.ixL = 0;
        this.diR = 0;
        this.ixM = false;
        this.bUw = null;
        this.ixN = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ixb != null && QuickVideoView.this.ixh) {
                    QuickVideoView.this.b(QuickVideoView.this.ixb, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.ixO = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.nn(false);
                }
            }
        };
        this.ixP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.ixM) {
                    QuickVideoView.this.ixM = false;
                    if (QuickVideoView.this.ixb != null) {
                        QuickVideoView.this.ixb.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.ixk || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.ixb != null && QuickVideoView.this.ixn) {
                        QuickVideoView.this.ixb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.tg, surfaceTexture, QuickVideoView.this.ixm);
                        if (QuickVideoView.this.iwG != null) {
                            QuickVideoView.this.iwG.cbZ();
                        }
                        if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.ixe.bMH();
                        }
                    }
                } else if (ccu()) {
                    if (QuickVideoView.this.ixb != null) {
                        QuickVideoView.this.ccn();
                        QuickVideoView.this.ixk = true;
                        QuickVideoView.this.ixb.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.tg, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.ixe.bMG();
                    }
                }
                QuickVideoView.this.ixo = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.ixM) {
                    QuickVideoView.this.ccp();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.ixb != null) {
                        if (QuickVideoView.this.ixb.isPlaying() && QuickVideoView.this.ccs()) {
                            y.ccT().bd(QuickVideoView.this.ixv, QuickVideoView.this.ixb.getCurrentPosition());
                        }
                        QuickVideoView.this.ixb.release();
                    }
                    if (QuickVideoView.this.ixk) {
                        if (QuickVideoView.this.ixi != null) {
                            QuickVideoView.this.ixi.onStop();
                        }
                        if (QuickVideoView.this.cUt != null) {
                            QuickVideoView.this.cUt.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.ixo = null;
                    if (QuickVideoView.this.ixe != null && QuickVideoView.this.ixe.zX(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ixk = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ccu() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(runningTasks)) {
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                            if (runningTaskInfo.topActivity.getClassName().equals(((Activity) QuickVideoView.this.mContext).getClass().getName())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.drF = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int BS;
                QuickVideoView.this.ccp();
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.onPrepared();
                }
                if (QuickVideoView.this.ixe != null && QuickVideoView.this.ixb != null) {
                    QuickVideoView.this.ixe.vW(QuickVideoView.this.ixb.getPlayerType());
                }
                if (QuickVideoView.this.ddL != null) {
                    QuickVideoView.this.ixj.bMW();
                    QuickVideoView.this.ddL.onPrepared(gVar);
                }
                if (QuickVideoView.this.ixi != null) {
                    long j = 0;
                    if (QuickVideoView.this.ixb != null) {
                        j = QuickVideoView.this.ixb.getDuration();
                    }
                    QuickVideoView.this.ixi.dO(j);
                    QuickVideoView.this.cco();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.ixi.ccg();
                        QuickVideoView.this.ccr();
                    }
                }
                if (QuickVideoView.this.ixy && (BS = y.ccT().BS(QuickVideoView.this.ixv)) > 0 && QuickVideoView.this.ixb != null) {
                    if (QuickVideoView.this.ixb.isPlayerReuse()) {
                        if (QuickVideoView.this.ixb.getCurrentPosition() == 0) {
                            QuickVideoView.this.xH(BS);
                        }
                    } else {
                        QuickVideoView.this.xH(BS);
                    }
                }
                if (QuickVideoView.this.ixh) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iwZ != null && gVar != null) {
                    QuickVideoView.this.iwZ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ixl);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.ixa) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.ixa);
                }
                if (QuickVideoView.this.ixq != null && QuickVideoView.this.ixq.cdo()) {
                    com.baidu.tieba.play.c.e.xO(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.drG = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.zW(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.ixe = null;
                }
                if (!QuickVideoView.this.drw || QuickVideoView.this.ixi == null) {
                    if (QuickVideoView.this.ixi != null) {
                        QuickVideoView.this.ixi.onCompletion();
                    }
                    QuickVideoView.this.ixh = false;
                    y.ccT().remove(QuickVideoView.this.ixv);
                    if (QuickVideoView.this.ddK != null) {
                        QuickVideoView.this.ddK.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.ixg = null;
                QuickVideoView.this.ixw = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.ixi.cca());
                QuickVideoView.this.start();
            }
        };
        this.ddM = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.c.e.W(i2, i22, i3);
                QuickVideoView.this.ccp();
                if (QuickVideoView.this.ixi != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ccs()) {
                    QuickVideoView.this.ixx = true;
                    y.ccT().bd(QuickVideoView.this.ixv, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.ixe != null) {
                        QuickVideoView.this.ixg = QuickVideoView.this.ixe.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.ixw, QuickVideoView.this.ac(QuickVideoView.this.ixe.bML(), i3 + "", QuickVideoView.this.ixe.bMM()));
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ixw = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.c.e.xM(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.xN(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cUp == null || QuickVideoView.this.cUp.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.drJ = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (QuickVideoView.this.ixx) {
                    QuickVideoView.this.ixx = false;
                    return;
                }
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.ccD();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.ixi != null && z) {
                    QuickVideoView.this.ixi.onSeekComplete();
                }
                if (QuickVideoView.this.ddO != null) {
                    QuickVideoView.this.ddO.b(gVar);
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.ixc != null) {
                    QuickVideoView.this.ixc.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.ixl = i22;
                    if (QuickVideoView.this.iwZ != null && gVar != null) {
                        QuickVideoView.this.iwZ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.ixl);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.ixj.a(QuickVideoView.this.cmS, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.ixr != null) {
                    QuickVideoView.this.ixr.a(i2, i22, QuickVideoView.this.ixe);
                    return true;
                }
                return true;
            }
        };
        this.ddP = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.i(i2, i22, str);
                }
            }
        };
        this.ddQ = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.ixe != null) {
                    QuickVideoView.this.ixe.zY(str);
                }
            }
        };
        this.ddR = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.ixw = j;
                }
            }
        };
        this.ixQ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.ixi != null && QuickVideoView.this.ixi.ccc() && QuickVideoView.this.ixi.ccd() && QuickVideoView.this.ixi.cce() && QuickVideoView.this.ixb != null) {
                    int aCe = QuickVideoView.this.ixb.aCe();
                    int currentPosition = QuickVideoView.this.ixb.getCurrentPosition();
                    int duration = QuickVideoView.this.ixb.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.ixz;
                    boolean z = currentPosition + aCe < duration;
                    if (aCe < QuickVideoView.this.ixi.ccf() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.ixz = currentTimeMillis;
                        QuickVideoView.this.ixi.xF(0);
                    }
                    if (QuickVideoView.this.ccq() && currentPosition == QuickVideoView.this.ixA && j > 500) {
                        QuickVideoView.this.ixz = currentTimeMillis;
                        QuickVideoView.this.ixi.xF(0);
                    }
                    QuickVideoView.this.ixA = currentPosition;
                    if (QuickVideoView.this.igO == QuickVideoView.ixE) {
                        QuickVideoView.this.ccr();
                    }
                }
            }
        };
        this.ddY = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.ixi != null) {
                        QuickVideoView.this.ixi.cci();
                    }
                    if (QuickVideoView.this.ixe != null) {
                        QuickVideoView.this.ixe.zV(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.ixe = null;
                    }
                    QuickVideoView.this.ccp();
                }
            }
        };
        init(context);
    }

    @Override // com.baidu.tieba.play.a.a
    public View getView() {
        return this;
    }

    private void init(Context context) {
        this.mContext = context;
        this.iwZ = new RenderView(context);
        this.bUw = new WeakReference<>(TbadkCoreApplication.getInst());
        this.iwZ.setSurfaceTextureListener(this.ixP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.ixp) {
            addView(this.iwZ, layoutParams);
        } else {
            addView(this.iwZ, 0, layoutParams);
        }
        if (drD != null) {
            this.ixb = drD.aCg();
        }
        if (this.ixb != null) {
            this.ixb.setOnPreparedListener(this.drF);
            this.ixb.setOnCompletionListener(this.drG);
            this.ixb.a(this.ddM);
            this.ixb.setOnSeekCompleteListener(this.drJ);
            this.ixb.a(this.ddN);
            this.ixb.a(this.ddP);
            this.ixb.a(this.ddQ);
            this.ixb.a(this.ddR);
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.ixq = new com.baidu.tieba.play.c.a(this);
        this.ixr = new r();
        this.ixs = new com.baidu.tieba.play.c.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.ixj = new com.baidu.tieba.j.k();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.ft().af("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.ixy = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.ixj.bMV();
        this.cmS = str2;
        if (this.ixq != null) {
            this.ixq.clear();
            this.ixq.cdo();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.c.e.BX(str2);
            if (drE != null) {
                this.ixe = drE.aa(this.cmS, str, "");
                if (this.ixe != null) {
                    this.ixe.a(-300, -44399, -44399, getLocateSource(), false, this.ixw, "");
                    this.ixe = null;
                }
            }
        }
        if (this.ixf != null) {
            this.ixf.a(null);
            this.ixf.bMz();
            this.ixf = null;
        }
        this.ixg = null;
        this.ixw = 0L;
        setVideoPath(str);
    }

    private String BO(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.csD().csE()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
                return str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
            }
            return str;
        }
        return str;
    }

    public void setVideoPath(String str) {
        if (!aq.isEmpty(str)) {
            String BO = BO(str);
            this.ixt = BO;
            if (this.ixi != null) {
                BO = this.ixi.qX(BO);
                if (this.ixi.cch() != null) {
                    this.ixi.cch().setPlayer(this);
                }
                if (drE != null && oY(BO)) {
                    this.ixf = drE.Ab(BO);
                }
                if (this.ixf != null) {
                    this.ixf.a(new com.baidu.tieba.play.monitor.a(this.cmS, this.ixt, this.ixe));
                    this.ixf.bMy();
                }
                BP(BO);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !oY(BO)) {
                if (this.cUp != null) {
                    this.cUp.onError(this.ixb, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(BO));
            if (this.ixe != null) {
                if (r(Uri.parse(BO)) != null) {
                    this.ixe.bMF();
                }
                this.ixe.KZ();
                this.ixe = null;
            }
            this.ixu = str;
            int lastIndexOf = this.ixu.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.ixu.length() > 4) {
                this.ixv = this.ixu.substring(0, lastIndexOf + 4);
            } else {
                this.ixv = this.ixu;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccn() {
        if (com.baidu.tbadk.coreExtra.model.f.arS()) {
            if (this.ixi != null && (this.ixi.ccb() || this.ixi.ccc())) {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixN);
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.ixN, com.baidu.tbadk.coreExtra.model.f.arR());
            }
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixO);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.ixO, com.baidu.tbadk.coreExtra.model.f.arQ());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void cbC() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (r(uri) != null) {
            this.ixe.zU(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aCa();
        }
        this.mUri = uri;
        this.tg = map;
        if (this.ixo != null) {
            ccn();
            if (this.ixb != null) {
                if (!this.ixk) {
                    this.ixk = true;
                    this.ixb.a(this.mContext, this.mUri, this.tg, this.ixo, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.drF.onPrepared(this.ixb);
                }
            }
        } else if (this.iwZ != null && this.iwZ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.ixp) {
                addView(this.iwZ, layoutParams);
            } else {
                addView(this.iwZ, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aCa() {
        this.ixk = false;
        this.ixh = false;
        if (this.ixb != null) {
            if (this.ixb.isPlaying() && ccs()) {
                y.ccT().bd(this.ixv, this.ixb.getCurrentPosition());
            }
            this.ixb.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixQ);
    }

    private void BP(String str) {
        this.ixH = 0;
        this.ixI = 0;
        this.ixJ = 0;
        this.ixK = 0;
        this.ixL = 0;
        this.diR = 0;
        if (this.ixi.ccc()) {
            this.ixG = ixC;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.ixI = (int) u.BR(QuickVideoView.this.ixt);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.ixt != null && this.ixt.equals(str)) {
            this.ixG = ixB;
        } else {
            this.ixG = ixD;
        }
        this.igO = ixE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cco() {
        this.igO = ixE;
        if (this.ixb != null) {
            this.ixH = this.ixb.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        if (this.igO == ixE && this.ixb != null) {
            this.igO = ixF;
            this.ixK = this.ixb.getDuration();
            if (z) {
                this.ixL = 0;
                this.ixJ = this.ixK;
            } else {
                this.ixJ = this.ixb.getCurrentPosition();
                this.ixL = this.ixb.getCachedSize();
            }
            if (this.ixJ > 0) {
                if (this.ixG == ixB) {
                    this.ixI = (int) u.BR(this.ixt);
                    if (this.ixH > 0) {
                        long j = (this.ixH * (this.ixJ / 1000)) / 8;
                        if (this.ixL < 0) {
                            this.ixL = 0;
                        }
                        long j2 = this.ixL + j;
                        if (this.ixI > 0) {
                            j2 += this.ixI;
                        }
                        setFlowCount(j2, this.ixJ, this.ixK, this.diR);
                    } else if (this.ixH == -1) {
                        this.ixH = 603327;
                        setFlowCount((this.ixH * (this.ixJ / 1000)) / 8, this.ixJ, this.ixK, this.diR);
                    }
                } else if (this.ixG == ixC) {
                    if (this.ixH > 0) {
                        long j3 = (this.ixH * (this.ixJ / 1000)) / 8;
                        if (this.ixL < 0) {
                            this.ixL = 0;
                        }
                        long j4 = this.ixL + j3;
                        if (this.ixI > 0) {
                            j4 -= this.ixI;
                        }
                        setFlowCount(j4, this.ixJ, this.ixK, this.diR);
                    } else if (this.ixH == -1) {
                        this.ixH = 603327;
                        setFlowCount((this.ixH * (this.ixJ / 1000)) / 8, this.ixJ, this.ixK, this.diR);
                    }
                } else {
                    setFlowCount(0L, this.ixJ, this.ixK, this.diR);
                }
            }
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixQ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ac.a(this.bUw, false);
        }
        ccp();
        pQ(false);
        if (this.ixq != null) {
            this.ixq.clear();
        }
        this.ixa = null;
        aCa();
        this.drw = false;
        if (this.ixi != null) {
            this.ixi.onStop();
        }
        com.baidu.tieba.play.b.b.ccW().a((b.InterfaceC0495b) null);
        if (this.ixe != null && this.ixe.zX(getLocateSource())) {
            this.ixe = null;
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixQ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.ixM = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccp() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixN);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixO);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.ddL = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.ddK = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.cUp = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0498g interfaceC0498g) {
        this.ddO = interfaceC0498g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ac(String str, String str2, String str3) {
        if (this.ixs == null) {
            return "";
        }
        String cdq = this.ixs.cdq();
        this.ixs.ad(str, str2, str3);
        return cdq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.ixi != null && !StringUtils.isNull(this.ixi.cca())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.c.a.BW(uri);
                }
            }
            this.mUri = Uri.parse(this.ixi.cca());
        }
        boolean z = false;
        if (this.ixq != null) {
            z = this.ixq.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.ixe != null) {
            this.ixg = this.ixe.a(i, i2, i3, getLocateSource(), z, this.ixw, ac(this.ixe.bML(), i3 + "", this.ixe.bMM()));
            this.ixe = null;
        }
        this.ixw = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.ixb != null) {
            try {
                if (this.ixb.isPlaying() && ccs()) {
                    y.ccT().bd(this.ixv, this.ixb.getCurrentPosition());
                }
                this.ixb.release();
                this.ixa = str;
                URI uri = new URI(this.mUri.toString());
                this.ixb.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.tg, this.ixo, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (r(this.mUri) != null) {
                    this.ixe.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ixb != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.ixb.isPlaying() && ccs()) {
                y.ccT().bd(this.ixv, this.ixb.getCurrentPosition());
            }
            this.ixb.release();
            this.ixb.a(this.mContext, this.mUri, this.tg, this.ixo, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (r(this.mUri) != null) {
                this.ixe.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.ixb != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.ixb.forceUseSystemMediaPlayer(true);
            }
            if (this.ixb.isPlaying() && ccs()) {
                y.ccT().bd(this.ixv, this.ixb.getCurrentPosition());
            }
            this.ixb.release();
            this.ixb.a(this.mContext, this.mUri, this.tg, this.ixo, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (r(this.mUri) != null) {
                this.ixe.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.ixh = true;
        if (this.ixb != null) {
            if (this.ixo != null && this.ixn && !this.ixb.isExistInRemote()) {
                this.ixb.a(this.mContext, this.mUri, this.tg, this.ixo, this.ixm);
                if (this.iwG != null) {
                    this.iwG.cbZ();
                }
                if (r(this.mUri) != null) {
                    this.ixe.bMH();
                }
                ccn();
                return;
            }
            if (!this.ixb.aCf()) {
                ac.a(this.bUw, true);
                this.ixb.setVolume(1.0f, 1.0f);
            }
            this.ixj.bMX();
            this.ixb.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.ixi != null) {
            this.ixi.onStart();
        }
        if (this.ixd != null) {
            this.ixd.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (r(this.mUri) != null && this.ixb != null) {
            this.ixe.vX(this.ixb.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void bIM() {
        start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        ccp();
        ac.a(this.bUw, false);
        if (this.ixb != null) {
            if (this.ixb.isPlaying() && ccs()) {
                y.ccT().bd(this.ixv, this.ixb.getCurrentPosition());
            }
            this.ixb.pause();
        }
        if (this.ixi != null) {
            this.ixi.onPause();
        }
        this.ixh = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ixe != null) {
            this.ixe.bMK();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.ixb != null) {
            return this.ixb.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.ixb != null) {
            return this.ixb.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.diR = i;
        xH(i);
    }

    public void xH(int i) {
        if (this.ixr != null) {
            this.ixr.ccC();
        }
        if (this.ixb != null) {
            this.ixb.seekTo(i);
        }
        if (this.ixi != null) {
            this.ixi.xF(0);
            ccr();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.ixb != null) {
            return this.ixb.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.ixb != null) {
            this.ixb.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.ixm = i;
    }

    public int getRecoveryState() {
        return this.ixm;
    }

    public void setNeedRecovery(boolean z) {
        this.ixn = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setLooping(boolean z) {
        this.drw = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean ccq() {
        return this.ixh;
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

    @Override // com.baidu.tieba.play.a.a
    public void setOnSurfaceDestroyedListener(b bVar) {
        this.cUt = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.ixi = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddY);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setMute(boolean z) {
        if (z) {
            this.ixb.setVolume(0.0f, 0.0f);
            ac.a(this.bUw, false);
            return;
        }
        ac.a(this.bUw, true);
        this.ixb.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.drw = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.ixb != null) {
            this.ixb.axM();
        }
        if (this.ixr != null) {
            this.ixr.ccE();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixQ);
        MessageManager.getInstance().unRegisterListener(this.ddY);
        if (this.ixq != null) {
            this.ixq.clear();
        }
        if (this.ixf != null) {
            this.ixf.a(null);
            this.ixf.bMz();
        }
    }

    public g getPlayer() {
        return this.ixb;
    }

    public int getPlayerType() {
        if (this.ixb == null) {
            return -300;
        }
        return this.ixb.getPlayerType();
    }

    public void ccr() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixQ);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.ixQ, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.iwG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.ixi instanceof n) || ((n) this.ixi).ccB() == null) ? "" : ((n) this.ixi).ccB().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i r(Uri uri) {
        String uri2;
        if (this.ixe != null) {
            return this.ixe;
        }
        if (!StringUtils.isNull(this.ixt)) {
            uri2 = this.ixt;
        } else if (drE != null && this.ixi != null && !StringUtils.isNull(this.ixi.cca())) {
            uri2 = this.ixi.cca();
        } else {
            uri2 = (drE == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && drE != null) {
            this.ixe = drE.aa(this.cmS, uri2, this.ixg);
        }
        this.ixg = null;
        this.ixw = 0L;
        return this.ixe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccs() {
        return this.ixb != null && this.ixb.getDuration() >= this.ixb.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.ixe, j, j2, j3, j4);
    }

    public static boolean oY(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.ixc = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.ixb != null) {
            return this.ixb.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.ixb != null ? this.ixb.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void setPageTypeForPerfStat(String str) {
        this.ixj.setPageTypeForPerfStat(str);
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.ixe != null) {
            this.ixe.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.ixd = cVar;
    }
}
