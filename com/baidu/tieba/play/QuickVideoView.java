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
    private static h dqM;
    private static com.baidu.tieba.j.l dqN;
    private static int iwK = 0;
    private static int iwL = 1;
    private static int iwM = 2;
    private static int iwN = 1;
    private static int iwO = 0;
    private WeakReference<Context> bTF;
    private b cTC;
    private g.b cTy;
    private String cma;
    private g.a dcS;
    private g.f dcT;
    private g.c dcU;
    private g.e dcV;
    private g.InterfaceC0498g dcW;
    private g.i dcX;
    private g.d dcY;
    private g.h dcZ;
    private final CustomMessageListener ddg;
    private int dhZ;
    private boolean dqF;
    private g.f dqO;
    private g.a dqP;
    private g.InterfaceC0498g dqS;
    private int ifX;
    private a ivP;
    private r iwA;
    private com.baidu.tieba.play.c.f iwB;
    private String iwC;
    private String iwD;
    private String iwE;
    private long iwF;
    private boolean iwG;
    private boolean iwH;
    private long iwI;
    private long iwJ;
    private int iwP;
    private int iwQ;
    private int iwR;
    private int iwS;
    private int iwT;
    private int iwU;
    private boolean iwV;
    private Runnable iwW;
    private Runnable iwX;
    private TextureView.SurfaceTextureListener iwY;
    private Runnable iwZ;
    private RenderView iwi;
    private String iwj;
    private g iwk;
    private g.e iwl;
    private c iwm;
    private com.baidu.tieba.j.i iwn;
    private com.baidu.tieba.j.e iwo;
    private String iwp;
    private boolean iwq;
    private d iwr;
    private com.baidu.tieba.j.k iws;
    private boolean iwt;
    private int iwu;
    private int iwv;
    private boolean iww;
    private SurfaceTexture iwx;
    private boolean iwy;
    private com.baidu.tieba.play.c.a iwz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;
    private Map<String, String> sG;

    /* loaded from: classes.dex */
    public interface a {
        void cbX();
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
            dqM = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            dqN = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.iwy = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.iwq = false;
        this.iwt = false;
        this.iwu = 0;
        this.dqF = false;
        this.iwv = -1;
        this.iww = false;
        this.iwx = null;
        this.iwy = true;
        this.iwI = 0L;
        this.iwJ = 0L;
        this.ifX = iwO;
        this.iwP = 0;
        this.iwQ = 0;
        this.iwR = -1;
        this.iwS = 0;
        this.iwT = 0;
        this.iwU = 0;
        this.dhZ = 0;
        this.iwV = false;
        this.bTF = null;
        this.iwW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwk != null && QuickVideoView.this.iwq) {
                    QuickVideoView.this.b(QuickVideoView.this.iwk, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.iwX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.nn(false);
                }
            }
        };
        this.iwY = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.iwV) {
                    QuickVideoView.this.iwV = false;
                    if (QuickVideoView.this.iwk != null) {
                        QuickVideoView.this.iwk.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.iwt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iwk != null && QuickVideoView.this.iww) {
                        QuickVideoView.this.iwk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.sG, surfaceTexture, QuickVideoView.this.iwv);
                        if (QuickVideoView.this.ivP != null) {
                            QuickVideoView.this.ivP.cbX();
                        }
                        if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iwn.bMF();
                        }
                    }
                } else if (ccs()) {
                    if (QuickVideoView.this.iwk != null) {
                        QuickVideoView.this.ccl();
                        QuickVideoView.this.iwt = true;
                        QuickVideoView.this.iwk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.sG, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iwn.bME();
                    }
                }
                QuickVideoView.this.iwx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.iwV) {
                    QuickVideoView.this.ccn();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.iwk != null) {
                        if (QuickVideoView.this.iwk.isPlaying() && QuickVideoView.this.ccq()) {
                            y.ccR().bd(QuickVideoView.this.iwE, QuickVideoView.this.iwk.getCurrentPosition());
                        }
                        QuickVideoView.this.iwk.release();
                    }
                    if (QuickVideoView.this.iwt) {
                        if (QuickVideoView.this.iwr != null) {
                            QuickVideoView.this.iwr.onStop();
                        }
                        if (QuickVideoView.this.cTC != null) {
                            QuickVideoView.this.cTC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iwx = null;
                    if (QuickVideoView.this.iwn != null && QuickVideoView.this.iwn.zX(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.iwt = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ccs() {
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
        this.dqO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int BS;
                QuickVideoView.this.ccn();
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.onPrepared();
                }
                if (QuickVideoView.this.iwn != null && QuickVideoView.this.iwk != null) {
                    QuickVideoView.this.iwn.vV(QuickVideoView.this.iwk.getPlayerType());
                }
                if (QuickVideoView.this.dcT != null) {
                    QuickVideoView.this.iws.bMU();
                    QuickVideoView.this.dcT.onPrepared(gVar);
                }
                if (QuickVideoView.this.iwr != null) {
                    long j = 0;
                    if (QuickVideoView.this.iwk != null) {
                        j = QuickVideoView.this.iwk.getDuration();
                    }
                    QuickVideoView.this.iwr.dN(j);
                    QuickVideoView.this.ccm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iwr.cce();
                        QuickVideoView.this.ccp();
                    }
                }
                if (QuickVideoView.this.iwH && (BS = y.ccR().BS(QuickVideoView.this.iwE)) > 0 && QuickVideoView.this.iwk != null) {
                    if (QuickVideoView.this.iwk.isPlayerReuse()) {
                        if (QuickVideoView.this.iwk.getCurrentPosition() == 0) {
                            QuickVideoView.this.xG(BS);
                        }
                    } else {
                        QuickVideoView.this.xG(BS);
                    }
                }
                if (QuickVideoView.this.iwq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iwi != null && gVar != null) {
                    QuickVideoView.this.iwi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iwj) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iwj);
                }
                if (QuickVideoView.this.iwz != null && QuickVideoView.this.iwz.cdm()) {
                    com.baidu.tieba.play.c.e.xN(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dqP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.zW(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iwn = null;
                }
                if (!QuickVideoView.this.dqF || QuickVideoView.this.iwr == null) {
                    if (QuickVideoView.this.iwr != null) {
                        QuickVideoView.this.iwr.onCompletion();
                    }
                    QuickVideoView.this.iwq = false;
                    y.ccR().remove(QuickVideoView.this.iwE);
                    if (QuickVideoView.this.dcS != null) {
                        QuickVideoView.this.dcS.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iwp = null;
                QuickVideoView.this.iwF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iwr.cbY());
                QuickVideoView.this.start();
            }
        };
        this.dcU = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.W(i, i2, i3);
                QuickVideoView.this.ccn();
                if (QuickVideoView.this.iwr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ccq()) {
                    QuickVideoView.this.iwG = true;
                    y.ccR().bd(QuickVideoView.this.iwE, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.iwn != null) {
                        QuickVideoView.this.iwp = QuickVideoView.this.iwn.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iwF, QuickVideoView.this.ac(QuickVideoView.this.iwn.bMJ(), i3 + "", QuickVideoView.this.iwn.bMK()));
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.iwF = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.xL(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.xM(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cTy == null || QuickVideoView.this.cTy.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dqS = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (QuickVideoView.this.iwG) {
                    QuickVideoView.this.iwG = false;
                    return;
                }
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.ccB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iwr != null && z) {
                    QuickVideoView.this.iwr.onSeekComplete();
                }
                if (QuickVideoView.this.dcW != null) {
                    QuickVideoView.this.dcW.b(gVar);
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.iwl != null) {
                    QuickVideoView.this.iwl.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.iwu = i2;
                    if (QuickVideoView.this.iwi != null && gVar != null) {
                        QuickVideoView.this.iwi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwu);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.iws.a(QuickVideoView.this.cma, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.a(i, i2, QuickVideoView.this.iwn);
                    return true;
                }
                return true;
            }
        };
        this.dcX = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.i(i, i2, str);
                }
            }
        };
        this.dcY = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.zY(str);
                }
            }
        };
        this.dcZ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iwF = j;
                }
            }
        };
        this.iwZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iwr != null && QuickVideoView.this.iwr.cca() && QuickVideoView.this.iwr.ccb() && QuickVideoView.this.iwr.ccc() && QuickVideoView.this.iwk != null) {
                    int aCc = QuickVideoView.this.iwk.aCc();
                    int currentPosition = QuickVideoView.this.iwk.getCurrentPosition();
                    int duration = QuickVideoView.this.iwk.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iwI;
                    boolean z = currentPosition + aCc < duration;
                    if (aCc < QuickVideoView.this.iwr.ccd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iwI = currentTimeMillis;
                        QuickVideoView.this.iwr.xE(0);
                    }
                    if (QuickVideoView.this.cco() && currentPosition == QuickVideoView.this.iwJ && j > 500) {
                        QuickVideoView.this.iwI = currentTimeMillis;
                        QuickVideoView.this.iwr.xE(0);
                    }
                    QuickVideoView.this.iwJ = currentPosition;
                    if (QuickVideoView.this.ifX == QuickVideoView.iwN) {
                        QuickVideoView.this.ccp();
                    }
                }
            }
        };
        this.ddg = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iwr != null) {
                        QuickVideoView.this.iwr.ccg();
                    }
                    if (QuickVideoView.this.iwn != null) {
                        QuickVideoView.this.iwn.zV(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.ccn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwq = false;
        this.iwt = false;
        this.iwu = 0;
        this.dqF = false;
        this.iwv = -1;
        this.iww = false;
        this.iwx = null;
        this.iwy = true;
        this.iwI = 0L;
        this.iwJ = 0L;
        this.ifX = iwO;
        this.iwP = 0;
        this.iwQ = 0;
        this.iwR = -1;
        this.iwS = 0;
        this.iwT = 0;
        this.iwU = 0;
        this.dhZ = 0;
        this.iwV = false;
        this.bTF = null;
        this.iwW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwk != null && QuickVideoView.this.iwq) {
                    QuickVideoView.this.b(QuickVideoView.this.iwk, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.iwX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.nn(false);
                }
            }
        };
        this.iwY = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.iwV) {
                    QuickVideoView.this.iwV = false;
                    if (QuickVideoView.this.iwk != null) {
                        QuickVideoView.this.iwk.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.iwt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iwk != null && QuickVideoView.this.iww) {
                        QuickVideoView.this.iwk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.sG, surfaceTexture, QuickVideoView.this.iwv);
                        if (QuickVideoView.this.ivP != null) {
                            QuickVideoView.this.ivP.cbX();
                        }
                        if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iwn.bMF();
                        }
                    }
                } else if (ccs()) {
                    if (QuickVideoView.this.iwk != null) {
                        QuickVideoView.this.ccl();
                        QuickVideoView.this.iwt = true;
                        QuickVideoView.this.iwk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.sG, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iwn.bME();
                    }
                }
                QuickVideoView.this.iwx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.iwV) {
                    QuickVideoView.this.ccn();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.iwk != null) {
                        if (QuickVideoView.this.iwk.isPlaying() && QuickVideoView.this.ccq()) {
                            y.ccR().bd(QuickVideoView.this.iwE, QuickVideoView.this.iwk.getCurrentPosition());
                        }
                        QuickVideoView.this.iwk.release();
                    }
                    if (QuickVideoView.this.iwt) {
                        if (QuickVideoView.this.iwr != null) {
                            QuickVideoView.this.iwr.onStop();
                        }
                        if (QuickVideoView.this.cTC != null) {
                            QuickVideoView.this.cTC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iwx = null;
                    if (QuickVideoView.this.iwn != null && QuickVideoView.this.iwn.zX(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.iwt = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ccs() {
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
        this.dqO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int BS;
                QuickVideoView.this.ccn();
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.onPrepared();
                }
                if (QuickVideoView.this.iwn != null && QuickVideoView.this.iwk != null) {
                    QuickVideoView.this.iwn.vV(QuickVideoView.this.iwk.getPlayerType());
                }
                if (QuickVideoView.this.dcT != null) {
                    QuickVideoView.this.iws.bMU();
                    QuickVideoView.this.dcT.onPrepared(gVar);
                }
                if (QuickVideoView.this.iwr != null) {
                    long j = 0;
                    if (QuickVideoView.this.iwk != null) {
                        j = QuickVideoView.this.iwk.getDuration();
                    }
                    QuickVideoView.this.iwr.dN(j);
                    QuickVideoView.this.ccm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iwr.cce();
                        QuickVideoView.this.ccp();
                    }
                }
                if (QuickVideoView.this.iwH && (BS = y.ccR().BS(QuickVideoView.this.iwE)) > 0 && QuickVideoView.this.iwk != null) {
                    if (QuickVideoView.this.iwk.isPlayerReuse()) {
                        if (QuickVideoView.this.iwk.getCurrentPosition() == 0) {
                            QuickVideoView.this.xG(BS);
                        }
                    } else {
                        QuickVideoView.this.xG(BS);
                    }
                }
                if (QuickVideoView.this.iwq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iwi != null && gVar != null) {
                    QuickVideoView.this.iwi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iwj) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iwj);
                }
                if (QuickVideoView.this.iwz != null && QuickVideoView.this.iwz.cdm()) {
                    com.baidu.tieba.play.c.e.xN(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dqP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.zW(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iwn = null;
                }
                if (!QuickVideoView.this.dqF || QuickVideoView.this.iwr == null) {
                    if (QuickVideoView.this.iwr != null) {
                        QuickVideoView.this.iwr.onCompletion();
                    }
                    QuickVideoView.this.iwq = false;
                    y.ccR().remove(QuickVideoView.this.iwE);
                    if (QuickVideoView.this.dcS != null) {
                        QuickVideoView.this.dcS.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iwp = null;
                QuickVideoView.this.iwF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iwr.cbY());
                QuickVideoView.this.start();
            }
        };
        this.dcU = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.c.e.W(i, i2, i3);
                QuickVideoView.this.ccn();
                if (QuickVideoView.this.iwr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ccq()) {
                    QuickVideoView.this.iwG = true;
                    y.ccR().bd(QuickVideoView.this.iwE, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.iwn != null) {
                        QuickVideoView.this.iwp = QuickVideoView.this.iwn.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iwF, QuickVideoView.this.ac(QuickVideoView.this.iwn.bMJ(), i3 + "", QuickVideoView.this.iwn.bMK()));
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.iwF = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.c.e.xL(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.xM(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cTy == null || QuickVideoView.this.cTy.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.dqS = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (QuickVideoView.this.iwG) {
                    QuickVideoView.this.iwG = false;
                    return;
                }
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.ccB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iwr != null && z) {
                    QuickVideoView.this.iwr.onSeekComplete();
                }
                if (QuickVideoView.this.dcW != null) {
                    QuickVideoView.this.dcW.b(gVar);
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.iwl != null) {
                    QuickVideoView.this.iwl.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.iwu = i2;
                    if (QuickVideoView.this.iwi != null && gVar != null) {
                        QuickVideoView.this.iwi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwu);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.iws.a(QuickVideoView.this.cma, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.a(i, i2, QuickVideoView.this.iwn);
                    return true;
                }
                return true;
            }
        };
        this.dcX = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.i(i, i2, str);
                }
            }
        };
        this.dcY = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.zY(str);
                }
            }
        };
        this.dcZ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iwF = j;
                }
            }
        };
        this.iwZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iwr != null && QuickVideoView.this.iwr.cca() && QuickVideoView.this.iwr.ccb() && QuickVideoView.this.iwr.ccc() && QuickVideoView.this.iwk != null) {
                    int aCc = QuickVideoView.this.iwk.aCc();
                    int currentPosition = QuickVideoView.this.iwk.getCurrentPosition();
                    int duration = QuickVideoView.this.iwk.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iwI;
                    boolean z = currentPosition + aCc < duration;
                    if (aCc < QuickVideoView.this.iwr.ccd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iwI = currentTimeMillis;
                        QuickVideoView.this.iwr.xE(0);
                    }
                    if (QuickVideoView.this.cco() && currentPosition == QuickVideoView.this.iwJ && j > 500) {
                        QuickVideoView.this.iwI = currentTimeMillis;
                        QuickVideoView.this.iwr.xE(0);
                    }
                    QuickVideoView.this.iwJ = currentPosition;
                    if (QuickVideoView.this.ifX == QuickVideoView.iwN) {
                        QuickVideoView.this.ccp();
                    }
                }
            }
        };
        this.ddg = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iwr != null) {
                        QuickVideoView.this.iwr.ccg();
                    }
                    if (QuickVideoView.this.iwn != null) {
                        QuickVideoView.this.iwn.zV(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.ccn();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwq = false;
        this.iwt = false;
        this.iwu = 0;
        this.dqF = false;
        this.iwv = -1;
        this.iww = false;
        this.iwx = null;
        this.iwy = true;
        this.iwI = 0L;
        this.iwJ = 0L;
        this.ifX = iwO;
        this.iwP = 0;
        this.iwQ = 0;
        this.iwR = -1;
        this.iwS = 0;
        this.iwT = 0;
        this.iwU = 0;
        this.dhZ = 0;
        this.iwV = false;
        this.bTF = null;
        this.iwW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwk != null && QuickVideoView.this.iwq) {
                    QuickVideoView.this.b(QuickVideoView.this.iwk, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.iwX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.nn(false);
                }
            }
        };
        this.iwY = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.iwV) {
                    QuickVideoView.this.iwV = false;
                    if (QuickVideoView.this.iwk != null) {
                        QuickVideoView.this.iwk.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.iwt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.iwk != null && QuickVideoView.this.iww) {
                        QuickVideoView.this.iwk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.sG, surfaceTexture, QuickVideoView.this.iwv);
                        if (QuickVideoView.this.ivP != null) {
                            QuickVideoView.this.ivP.cbX();
                        }
                        if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.iwn.bMF();
                        }
                    }
                } else if (ccs()) {
                    if (QuickVideoView.this.iwk != null) {
                        QuickVideoView.this.ccl();
                        QuickVideoView.this.iwt = true;
                        QuickVideoView.this.iwk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.sG, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.r(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.iwn.bME();
                    }
                }
                QuickVideoView.this.iwx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.iwV) {
                    QuickVideoView.this.ccn();
                    QuickVideoView.this.pQ(false);
                    if (QuickVideoView.this.iwk != null) {
                        if (QuickVideoView.this.iwk.isPlaying() && QuickVideoView.this.ccq()) {
                            y.ccR().bd(QuickVideoView.this.iwE, QuickVideoView.this.iwk.getCurrentPosition());
                        }
                        QuickVideoView.this.iwk.release();
                    }
                    if (QuickVideoView.this.iwt) {
                        if (QuickVideoView.this.iwr != null) {
                            QuickVideoView.this.iwr.onStop();
                        }
                        if (QuickVideoView.this.cTC != null) {
                            QuickVideoView.this.cTC.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.iwx = null;
                    if (QuickVideoView.this.iwn != null && QuickVideoView.this.iwn.zX(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.iwt = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean ccs() {
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
        this.dqO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int BS;
                QuickVideoView.this.ccn();
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.onPrepared();
                }
                if (QuickVideoView.this.iwn != null && QuickVideoView.this.iwk != null) {
                    QuickVideoView.this.iwn.vV(QuickVideoView.this.iwk.getPlayerType());
                }
                if (QuickVideoView.this.dcT != null) {
                    QuickVideoView.this.iws.bMU();
                    QuickVideoView.this.dcT.onPrepared(gVar);
                }
                if (QuickVideoView.this.iwr != null) {
                    long j = 0;
                    if (QuickVideoView.this.iwk != null) {
                        j = QuickVideoView.this.iwk.getDuration();
                    }
                    QuickVideoView.this.iwr.dN(j);
                    QuickVideoView.this.ccm();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.iwr.cce();
                        QuickVideoView.this.ccp();
                    }
                }
                if (QuickVideoView.this.iwH && (BS = y.ccR().BS(QuickVideoView.this.iwE)) > 0 && QuickVideoView.this.iwk != null) {
                    if (QuickVideoView.this.iwk.isPlayerReuse()) {
                        if (QuickVideoView.this.iwk.getCurrentPosition() == 0) {
                            QuickVideoView.this.xG(BS);
                        }
                    } else {
                        QuickVideoView.this.xG(BS);
                    }
                }
                if (QuickVideoView.this.iwq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.iwi != null && gVar != null) {
                    QuickVideoView.this.iwi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.iwj) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.c.e.c(QuickVideoView.this.mUri, QuickVideoView.this.iwj);
                }
                if (QuickVideoView.this.iwz != null && QuickVideoView.this.iwz.cdm()) {
                    com.baidu.tieba.play.c.e.xN(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.dqP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.pQ(true);
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.zW(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.iwn = null;
                }
                if (!QuickVideoView.this.dqF || QuickVideoView.this.iwr == null) {
                    if (QuickVideoView.this.iwr != null) {
                        QuickVideoView.this.iwr.onCompletion();
                    }
                    QuickVideoView.this.iwq = false;
                    y.ccR().remove(QuickVideoView.this.iwE);
                    if (QuickVideoView.this.dcS != null) {
                        QuickVideoView.this.dcS.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.iwp = null;
                QuickVideoView.this.iwF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.iwr.cbY());
                QuickVideoView.this.start();
            }
        };
        this.dcU = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.c.e.W(i2, i22, i3);
                QuickVideoView.this.ccn();
                if (QuickVideoView.this.iwr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.ccq()) {
                    QuickVideoView.this.iwG = true;
                    y.ccR().bd(QuickVideoView.this.iwE, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.iwn != null) {
                        QuickVideoView.this.iwp = QuickVideoView.this.iwn.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.iwF, QuickVideoView.this.ac(QuickVideoView.this.iwn.bMJ(), i3 + "", QuickVideoView.this.iwn.bMK()));
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.iwF = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.c.e.xL(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.c.e.xM(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.cTy == null || QuickVideoView.this.cTy.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.dqS = new g.InterfaceC0498g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (QuickVideoView.this.iwG) {
                    QuickVideoView.this.iwG = false;
                    return;
                }
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.ccB();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.iwr != null && z) {
                    QuickVideoView.this.iwr.onSeekComplete();
                }
                if (QuickVideoView.this.dcW != null) {
                    QuickVideoView.this.dcW.b(gVar);
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.iwl != null) {
                    QuickVideoView.this.iwl.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.iwu = i22;
                    if (QuickVideoView.this.iwi != null && gVar != null) {
                        QuickVideoView.this.iwi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.iwu);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.iws.a(QuickVideoView.this.cma, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.iwA != null) {
                    QuickVideoView.this.iwA.a(i2, i22, QuickVideoView.this.iwn);
                    return true;
                }
                return true;
            }
        };
        this.dcX = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.i(i2, i22, str);
                }
            }
        };
        this.dcY = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.iwn != null) {
                    QuickVideoView.this.iwn.zY(str);
                }
            }
        };
        this.dcZ = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.iwF = j;
                }
            }
        };
        this.iwZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.iwr != null && QuickVideoView.this.iwr.cca() && QuickVideoView.this.iwr.ccb() && QuickVideoView.this.iwr.ccc() && QuickVideoView.this.iwk != null) {
                    int aCc = QuickVideoView.this.iwk.aCc();
                    int currentPosition = QuickVideoView.this.iwk.getCurrentPosition();
                    int duration = QuickVideoView.this.iwk.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.iwI;
                    boolean z = currentPosition + aCc < duration;
                    if (aCc < QuickVideoView.this.iwr.ccd() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.iwI = currentTimeMillis;
                        QuickVideoView.this.iwr.xE(0);
                    }
                    if (QuickVideoView.this.cco() && currentPosition == QuickVideoView.this.iwJ && j > 500) {
                        QuickVideoView.this.iwI = currentTimeMillis;
                        QuickVideoView.this.iwr.xE(0);
                    }
                    QuickVideoView.this.iwJ = currentPosition;
                    if (QuickVideoView.this.ifX == QuickVideoView.iwN) {
                        QuickVideoView.this.ccp();
                    }
                }
            }
        };
        this.ddg = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.iwr != null) {
                        QuickVideoView.this.iwr.ccg();
                    }
                    if (QuickVideoView.this.iwn != null) {
                        QuickVideoView.this.iwn.zV(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.iwn = null;
                    }
                    QuickVideoView.this.ccn();
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
        this.iwi = new RenderView(context);
        this.bTF = new WeakReference<>(TbadkCoreApplication.getInst());
        this.iwi.setSurfaceTextureListener(this.iwY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.iwy) {
            addView(this.iwi, layoutParams);
        } else {
            addView(this.iwi, 0, layoutParams);
        }
        if (dqM != null) {
            this.iwk = dqM.aCe();
        }
        if (this.iwk != null) {
            this.iwk.setOnPreparedListener(this.dqO);
            this.iwk.setOnCompletionListener(this.dqP);
            this.iwk.a(this.dcU);
            this.iwk.setOnSeekCompleteListener(this.dqS);
            this.iwk.a(this.dcV);
            this.iwk.a(this.dcX);
            this.iwk.a(this.dcY);
            this.iwk.a(this.dcZ);
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
        this.iwz = new com.baidu.tieba.play.c.a(this);
        this.iwA = new r();
        this.iwB = new com.baidu.tieba.play.c.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.iws = new com.baidu.tieba.j.k();
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
        this.iwH = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.iws.bMT();
        this.cma = str2;
        if (this.iwz != null) {
            this.iwz.clear();
            this.iwz.cdm();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.c.e.BX(str2);
            if (dqN != null) {
                this.iwn = dqN.aa(this.cma, str, "");
                if (this.iwn != null) {
                    this.iwn.a(-300, -44399, -44399, getLocateSource(), false, this.iwF, "");
                    this.iwn = null;
                }
            }
        }
        if (this.iwo != null) {
            this.iwo.a(null);
            this.iwo.bMx();
            this.iwo = null;
        }
        this.iwp = null;
        this.iwF = 0L;
        setVideoPath(str);
    }

    private String BO(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.csB().csC()) {
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
            this.iwC = BO;
            if (this.iwr != null) {
                BO = this.iwr.qX(BO);
                if (this.iwr.ccf() != null) {
                    this.iwr.ccf().setPlayer(this);
                }
                if (dqN != null && oY(BO)) {
                    this.iwo = dqN.Ab(BO);
                }
                if (this.iwo != null) {
                    this.iwo.a(new com.baidu.tieba.play.monitor.a(this.cma, this.iwC, this.iwn));
                    this.iwo.bMw();
                }
                BP(BO);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !oY(BO)) {
                if (this.cTy != null) {
                    this.cTy.onError(this.iwk, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(BO));
            if (this.iwn != null) {
                if (r(Uri.parse(BO)) != null) {
                    this.iwn.bMD();
                }
                this.iwn.La();
                this.iwn = null;
            }
            this.iwD = str;
            int lastIndexOf = this.iwD.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.iwD.length() > 4) {
                this.iwE = this.iwD.substring(0, lastIndexOf + 4);
            } else {
                this.iwE = this.iwD;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccl() {
        if (com.baidu.tbadk.coreExtra.model.f.arQ()) {
            if (this.iwr != null && (this.iwr.cbZ() || this.iwr.cca())) {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwW);
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.iwW, com.baidu.tbadk.coreExtra.model.f.arP());
            }
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwX);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.iwX, com.baidu.tbadk.coreExtra.model.f.arO());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void cbA() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (r(uri) != null) {
            this.iwn.zU(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aBY();
        }
        this.mUri = uri;
        this.sG = map;
        if (this.iwx != null) {
            ccl();
            if (this.iwk != null) {
                if (!this.iwt) {
                    this.iwt = true;
                    this.iwk.a(this.mContext, this.mUri, this.sG, this.iwx, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.dqO.onPrepared(this.iwk);
                }
            }
        } else if (this.iwi != null && this.iwi.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.iwy) {
                addView(this.iwi, layoutParams);
            } else {
                addView(this.iwi, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aBY() {
        this.iwt = false;
        this.iwq = false;
        if (this.iwk != null) {
            if (this.iwk.isPlaying() && ccq()) {
                y.ccR().bd(this.iwE, this.iwk.getCurrentPosition());
            }
            this.iwk.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwZ);
    }

    private void BP(String str) {
        this.iwQ = 0;
        this.iwR = 0;
        this.iwS = 0;
        this.iwT = 0;
        this.iwU = 0;
        this.dhZ = 0;
        if (this.iwr.cca()) {
            this.iwP = iwL;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.iwR = (int) u.BR(QuickVideoView.this.iwC);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.iwC != null && this.iwC.equals(str)) {
            this.iwP = iwK;
        } else {
            this.iwP = iwM;
        }
        this.ifX = iwN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        this.ifX = iwN;
        if (this.iwk != null) {
            this.iwQ = this.iwk.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        if (this.ifX == iwN && this.iwk != null) {
            this.ifX = iwO;
            this.iwT = this.iwk.getDuration();
            if (z) {
                this.iwU = 0;
                this.iwS = this.iwT;
            } else {
                this.iwS = this.iwk.getCurrentPosition();
                this.iwU = this.iwk.getCachedSize();
            }
            if (this.iwS > 0) {
                if (this.iwP == iwK) {
                    this.iwR = (int) u.BR(this.iwC);
                    if (this.iwQ > 0) {
                        long j = (this.iwQ * (this.iwS / 1000)) / 8;
                        if (this.iwU < 0) {
                            this.iwU = 0;
                        }
                        long j2 = this.iwU + j;
                        if (this.iwR > 0) {
                            j2 += this.iwR;
                        }
                        setFlowCount(j2, this.iwS, this.iwT, this.dhZ);
                    } else if (this.iwQ == -1) {
                        this.iwQ = 603327;
                        setFlowCount((this.iwQ * (this.iwS / 1000)) / 8, this.iwS, this.iwT, this.dhZ);
                    }
                } else if (this.iwP == iwL) {
                    if (this.iwQ > 0) {
                        long j3 = (this.iwQ * (this.iwS / 1000)) / 8;
                        if (this.iwU < 0) {
                            this.iwU = 0;
                        }
                        long j4 = this.iwU + j3;
                        if (this.iwR > 0) {
                            j4 -= this.iwR;
                        }
                        setFlowCount(j4, this.iwS, this.iwT, this.dhZ);
                    } else if (this.iwQ == -1) {
                        this.iwQ = 603327;
                        setFlowCount((this.iwQ * (this.iwS / 1000)) / 8, this.iwS, this.iwT, this.dhZ);
                    }
                } else {
                    setFlowCount(0L, this.iwS, this.iwT, this.dhZ);
                }
            }
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwZ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ac.a(this.bTF, false);
        }
        ccn();
        pQ(false);
        if (this.iwz != null) {
            this.iwz.clear();
        }
        this.iwj = null;
        aBY();
        this.dqF = false;
        if (this.iwr != null) {
            this.iwr.onStop();
        }
        com.baidu.tieba.play.b.b.ccU().a((b.InterfaceC0495b) null);
        if (this.iwn != null && this.iwn.zX(getLocateSource())) {
            this.iwn = null;
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwZ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.iwV = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccn() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwW);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwX);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.dcT = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.dcS = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.cTy = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0498g interfaceC0498g) {
        this.dcW = interfaceC0498g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ac(String str, String str2, String str3) {
        if (this.iwB == null) {
            return "";
        }
        String cdo = this.iwB.cdo();
        this.iwB.ad(str, str2, str3);
        return cdo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.iwr != null && !StringUtils.isNull(this.iwr.cbY())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.c.a.BW(uri);
                }
            }
            this.mUri = Uri.parse(this.iwr.cbY());
        }
        boolean z = false;
        if (this.iwz != null) {
            z = this.iwz.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.iwn != null) {
            this.iwp = this.iwn.a(i, i2, i3, getLocateSource(), z, this.iwF, ac(this.iwn.bMJ(), i3 + "", this.iwn.bMK()));
            this.iwn = null;
        }
        this.iwF = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.iwk != null) {
            try {
                if (this.iwk.isPlaying() && ccq()) {
                    y.ccR().bd(this.iwE, this.iwk.getCurrentPosition());
                }
                this.iwk.release();
                this.iwj = str;
                URI uri = new URI(this.mUri.toString());
                this.iwk.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.sG, this.iwx, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (r(this.mUri) != null) {
                    this.iwn.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.iwk != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.iwk.isPlaying() && ccq()) {
                y.ccR().bd(this.iwE, this.iwk.getCurrentPosition());
            }
            this.iwk.release();
            this.iwk.a(this.mContext, this.mUri, this.sG, this.iwx, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (r(this.mUri) != null) {
                this.iwn.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.c.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.iwk != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.iwk.forceUseSystemMediaPlayer(true);
            }
            if (this.iwk.isPlaying() && ccq()) {
                y.ccR().bd(this.iwE, this.iwk.getCurrentPosition());
            }
            this.iwk.release();
            this.iwk.a(this.mContext, this.mUri, this.sG, this.iwx, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (r(this.mUri) != null) {
                this.iwn.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.iwq = true;
        if (this.iwk != null) {
            if (this.iwx != null && this.iww && !this.iwk.isExistInRemote()) {
                this.iwk.a(this.mContext, this.mUri, this.sG, this.iwx, this.iwv);
                if (this.ivP != null) {
                    this.ivP.cbX();
                }
                if (r(this.mUri) != null) {
                    this.iwn.bMF();
                }
                ccl();
                return;
            }
            if (!this.iwk.aCd()) {
                ac.a(this.bTF, true);
                this.iwk.setVolume(1.0f, 1.0f);
            }
            this.iws.bMV();
            this.iwk.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.iwr != null) {
            this.iwr.onStart();
        }
        if (this.iwm != null) {
            this.iwm.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (r(this.mUri) != null && this.iwk != null) {
            this.iwn.vW(this.iwk.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void bIK() {
        start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        ccn();
        ac.a(this.bTF, false);
        if (this.iwk != null) {
            if (this.iwk.isPlaying() && ccq()) {
                y.ccR().bd(this.iwE, this.iwk.getCurrentPosition());
            }
            this.iwk.pause();
        }
        if (this.iwr != null) {
            this.iwr.onPause();
        }
        this.iwq = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iwn != null) {
            this.iwn.bMI();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.iwk != null) {
            return this.iwk.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.iwk != null) {
            return this.iwk.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.dhZ = i;
        xG(i);
    }

    public void xG(int i) {
        if (this.iwA != null) {
            this.iwA.ccA();
        }
        if (this.iwk != null) {
            this.iwk.seekTo(i);
        }
        if (this.iwr != null) {
            this.iwr.xE(0);
            ccp();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.iwk != null) {
            return this.iwk.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.iwk != null) {
            this.iwk.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.iwv = i;
    }

    public int getRecoveryState() {
        return this.iwv;
    }

    public void setNeedRecovery(boolean z) {
        this.iww = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setLooping(boolean z) {
        this.dqF = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cco() {
        return this.iwq;
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
        this.cTC = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.iwr = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddg);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setMute(boolean z) {
        if (z) {
            this.iwk.setVolume(0.0f, 0.0f);
            ac.a(this.bTF, false);
            return;
        }
        ac.a(this.bTF, true);
        this.iwk.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dqF = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.iwk != null) {
            this.iwk.axK();
        }
        if (this.iwA != null) {
            this.iwA.ccC();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwZ);
        MessageManager.getInstance().unRegisterListener(this.ddg);
        if (this.iwz != null) {
            this.iwz.clear();
        }
        if (this.iwo != null) {
            this.iwo.a(null);
            this.iwo.bMx();
        }
    }

    public g getPlayer() {
        return this.iwk;
    }

    public int getPlayerType() {
        if (this.iwk == null) {
            return -300;
        }
        return this.iwk.getPlayerType();
    }

    public void ccp() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwZ);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iwZ, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.ivP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.iwr instanceof n) || ((n) this.iwr).ccz() == null) ? "" : ((n) this.iwr).ccz().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i r(Uri uri) {
        String uri2;
        if (this.iwn != null) {
            return this.iwn;
        }
        if (!StringUtils.isNull(this.iwC)) {
            uri2 = this.iwC;
        } else if (dqN != null && this.iwr != null && !StringUtils.isNull(this.iwr.cbY())) {
            uri2 = this.iwr.cbY();
        } else {
            uri2 = (dqN == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && dqN != null) {
            this.iwn = dqN.aa(this.cma, uri2, this.iwp);
        }
        this.iwp = null;
        this.iwF = 0L;
        return this.iwn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccq() {
        return this.iwk != null && this.iwk.getDuration() >= this.iwk.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.iwn, j, j2, j3, j4);
    }

    public static boolean oY(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.iwl = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.iwk != null) {
            return this.iwk.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.iwk != null ? this.iwk.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void setPageTypeForPerfStat(String str) {
        this.iws.setPageTypeForPerfStat(str);
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.iwn != null) {
            this.iwn.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.iwm = cVar;
    }
}
