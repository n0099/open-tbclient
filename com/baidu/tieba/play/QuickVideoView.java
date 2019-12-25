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
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.network.http.a.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.switchs.VideoPlayerReuseSwitch;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a, com.baidu.tieba.play.b.c {
    private static h eaM;
    private static com.baidu.tieba.j.l eaN;
    private static int jqL = 0;
    private static int jqM = 1;
    private static int jqN = 2;
    private static int jqO = 1;
    private static int jqP = 0;
    private String OC;
    private WeakReference<Context> Oy;
    private TextureView.SurfaceTextureListener aSx;
    private g.b dHR;
    private b dHV;
    private g.a dQN;
    private g.f dQO;
    private g.c dQP;
    private g.e dQQ;
    private g.InterfaceC0577g dQR;
    private g.i dQS;
    private g.d dQT;
    private g.h dQU;
    private final CustomMessageListener dRb;
    private int dVM;
    private boolean eaE;
    private g.f eaO;
    private g.a eaP;
    private g.InterfaceC0577g eaS;
    private int iXZ;
    private a jpP;
    private q jqA;
    private com.baidu.tieba.play.b.f jqB;
    private String jqC;
    private String jqD;
    private String jqE;
    private long jqF;
    private boolean jqG;
    private boolean jqH;
    private boolean jqI;
    private long jqJ;
    private long jqK;
    private int jqQ;
    private int jqR;
    private int jqS;
    private int jqT;
    private int jqU;
    private boolean jqV;
    private Runnable jqW;
    private Runnable jqX;
    public boolean jqY;
    private Runnable jqZ;
    private RenderView jqi;
    private String jqj;
    private g jqk;
    private g.e jql;
    private c jqm;
    private com.baidu.tieba.j.i jqn;
    private com.baidu.tieba.j.e jqo;
    private String jqp;
    private boolean jqq;
    private d jqr;
    private com.baidu.tieba.j.k jqs;
    private boolean jqt;
    private int jqu;
    private int jqv;
    private boolean jqw;
    private SurfaceTexture jqx;
    private boolean jqy;
    private com.baidu.tieba.play.b.a jqz;
    private int mBitRate;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cvP();
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
            eaM = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            eaN = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.jqy = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.jqq = false;
        this.jqt = false;
        this.jqu = 0;
        this.eaE = false;
        this.jqv = -1;
        this.jqw = false;
        this.jqx = null;
        this.jqy = true;
        this.jqI = false;
        this.jqJ = 0L;
        this.jqK = 0L;
        this.iXZ = jqP;
        this.jqQ = 0;
        this.mBitRate = 0;
        this.jqR = -1;
        this.jqS = 0;
        this.jqT = 0;
        this.jqU = 0;
        this.dVM = 0;
        this.jqV = false;
        this.Oy = null;
        this.jqW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jqk != null && QuickVideoView.this.jqq) {
                    QuickVideoView.this.b(QuickVideoView.this.jqk, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jqX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.oC(false);
                }
            }
        };
        this.jqY = false;
        this.aSx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jqV) {
                    QuickVideoView.this.jqV = false;
                    if (QuickVideoView.this.jqk != null) {
                        QuickVideoView.this.jqk.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jqt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jqk != null) {
                        if (QuickVideoView.this.cwn()) {
                            QuickVideoView.this.jqk.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jqw) {
                            QuickVideoView.this.jqk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jqv);
                            if (QuickVideoView.this.jpP != null) {
                                QuickVideoView.this.jpP.cvP();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jqn.cdR();
                            }
                        }
                    }
                } else if (cwq()) {
                    if (QuickVideoView.this.jqk != null) {
                        QuickVideoView.this.cwf();
                        QuickVideoView.this.jqt = true;
                        QuickVideoView.this.jqk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jqn.cdQ();
                    }
                }
                QuickVideoView.this.jqx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jqV) {
                    QuickVideoView.this.cwh();
                    QuickVideoView.this.ry(false);
                    if (QuickVideoView.this.jqk != null) {
                        if (QuickVideoView.this.jqk.isPlaying() && QuickVideoView.this.cwl()) {
                            x.cwN().bm(QuickVideoView.this.jqE, QuickVideoView.this.jqk.getCurrentPosition());
                            if (QuickVideoView.this.jqI) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jqI) {
                            QuickVideoView.this.jqk.release();
                        }
                    }
                    if (QuickVideoView.this.jqt) {
                        if (QuickVideoView.this.jqr != null && !QuickVideoView.this.jqI) {
                            QuickVideoView.this.jqr.GA(QuickVideoView.this.jqD);
                        }
                        if (QuickVideoView.this.dHV != null) {
                            QuickVideoView.this.dHV.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jqx = null;
                    if (QuickVideoView.this.jqn != null && QuickVideoView.this.jqn.EF(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jqn = null;
                    }
                    if (!QuickVideoView.this.jqI) {
                        QuickVideoView.this.jqt = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cwq() {
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
        this.eaO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int GF;
                QuickVideoView.this.cwh();
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.onPrepared();
                }
                if (QuickVideoView.this.jqn != null && QuickVideoView.this.jqk != null) {
                    QuickVideoView.this.jqn.xW(QuickVideoView.this.jqk.getPlayerType());
                }
                if (QuickVideoView.this.jqI) {
                    TbVideoViewSet.cwQ().a(QuickVideoView.this, QuickVideoView.this.jqD);
                }
                if (QuickVideoView.this.dQO != null) {
                    QuickVideoView.this.jqs.ceg();
                    QuickVideoView.this.dQO.onPrepared(gVar);
                }
                if (QuickVideoView.this.jqr != null) {
                    long j = 0;
                    if (QuickVideoView.this.jqk != null) {
                        j = QuickVideoView.this.jqk.getDuration();
                    }
                    QuickVideoView.this.jqr.eu(j);
                    QuickVideoView.this.cwg();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jqr.cvZ();
                        QuickVideoView.this.cwk();
                    }
                }
                if (QuickVideoView.this.jqH && (GF = x.cwN().GF(QuickVideoView.this.jqE)) > 0 && QuickVideoView.this.jqk != null) {
                    if (QuickVideoView.this.jqk.isPlayerReuse()) {
                        if (QuickVideoView.this.jqk.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ad(GF);
                        }
                    } else {
                        QuickVideoView.this.Ad(GF);
                    }
                }
                if (QuickVideoView.this.jqq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jqi != null && gVar != null) {
                    QuickVideoView.this.jqi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jqu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jqj) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jqj);
                }
                if (QuickVideoView.this.jqz != null && QuickVideoView.this.jqz.cxh()) {
                    com.baidu.tieba.play.b.e.Aj(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.ry(true);
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.EE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jqn = null;
                }
                if (!QuickVideoView.this.eaE || QuickVideoView.this.jqr == null) {
                    if (QuickVideoView.this.jqr != null) {
                        QuickVideoView.this.jqr.onCompletion();
                    }
                    QuickVideoView.this.jqq = false;
                    x.cwN().remove(QuickVideoView.this.jqE);
                    if (QuickVideoView.this.dQN != null) {
                        QuickVideoView.this.dQN.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jqp = null;
                QuickVideoView.this.jqF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jqr.cvS());
                QuickVideoView.this.start();
            }
        };
        this.dQP = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.W(i, i2, i3);
                QuickVideoView.this.cwh();
                if (QuickVideoView.this.jqr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cwl()) {
                    QuickVideoView.this.jqG = true;
                    x.cwN().bm(QuickVideoView.this.jqE, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cwQ().GH(QuickVideoView.this.jqD);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jqn != null) {
                        QuickVideoView.this.jqp = QuickVideoView.this.jqn.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jqF, QuickVideoView.this.ap(QuickVideoView.this.jqn.cdV(), i3 + "", QuickVideoView.this.jqn.cdW()));
                        QuickVideoView.this.jqn = null;
                    }
                    QuickVideoView.this.jqF = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Ah(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ai(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dHR == null || QuickVideoView.this.dHR.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eaS = new g.InterfaceC0577g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                if (QuickVideoView.this.jqG) {
                    QuickVideoView.this.jqG = false;
                    return;
                }
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.cwz();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jqr != null && z) {
                    QuickVideoView.this.jqr.onSeekComplete();
                }
                if (QuickVideoView.this.dQR != null) {
                    QuickVideoView.this.dQR.b(gVar);
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jql != null) {
                    QuickVideoView.this.jql.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jqu = i2;
                    if (QuickVideoView.this.jqi != null && gVar != null) {
                        QuickVideoView.this.jqi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jqu);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jqs.a(QuickVideoView.this.OC, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.a(i, i2, QuickVideoView.this.jqn);
                    return true;
                }
                return true;
            }
        };
        this.dQS = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.k(i, i2, str);
                }
            }
        };
        this.dQT = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.EG(str);
                }
            }
        };
        this.dQU = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jqF = j;
                }
            }
        };
        this.jqZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jqr != null && QuickVideoView.this.jqr.cvV() && QuickVideoView.this.jqr.cvW() && QuickVideoView.this.jqr.cvX() && QuickVideoView.this.jqk != null) {
                    int aTU = QuickVideoView.this.jqk.aTU();
                    int currentPosition = QuickVideoView.this.jqk.getCurrentPosition();
                    int duration = QuickVideoView.this.jqk.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jqJ;
                    boolean z = currentPosition + aTU < duration;
                    if (aTU < QuickVideoView.this.jqr.cvY() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jqJ = currentTimeMillis;
                        QuickVideoView.this.jqr.Ab(0);
                    }
                    if (QuickVideoView.this.cwj() && currentPosition == QuickVideoView.this.jqK && j > 500) {
                        QuickVideoView.this.jqJ = currentTimeMillis;
                        QuickVideoView.this.jqr.Ab(0);
                    }
                    QuickVideoView.this.jqK = currentPosition;
                    if (QuickVideoView.this.iXZ == QuickVideoView.jqO) {
                        QuickVideoView.this.cwk();
                    }
                }
            }
        };
        this.dRb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jqr != null) {
                        QuickVideoView.this.jqr.wl(QuickVideoView.this.jqD);
                    }
                    if (QuickVideoView.this.jqn != null) {
                        QuickVideoView.this.jqn.ED(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jqn = null;
                    }
                    QuickVideoView.this.cwh();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jqq = false;
        this.jqt = false;
        this.jqu = 0;
        this.eaE = false;
        this.jqv = -1;
        this.jqw = false;
        this.jqx = null;
        this.jqy = true;
        this.jqI = false;
        this.jqJ = 0L;
        this.jqK = 0L;
        this.iXZ = jqP;
        this.jqQ = 0;
        this.mBitRate = 0;
        this.jqR = -1;
        this.jqS = 0;
        this.jqT = 0;
        this.jqU = 0;
        this.dVM = 0;
        this.jqV = false;
        this.Oy = null;
        this.jqW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jqk != null && QuickVideoView.this.jqq) {
                    QuickVideoView.this.b(QuickVideoView.this.jqk, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jqX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.oC(false);
                }
            }
        };
        this.jqY = false;
        this.aSx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jqV) {
                    QuickVideoView.this.jqV = false;
                    if (QuickVideoView.this.jqk != null) {
                        QuickVideoView.this.jqk.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jqt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jqk != null) {
                        if (QuickVideoView.this.cwn()) {
                            QuickVideoView.this.jqk.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jqw) {
                            QuickVideoView.this.jqk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jqv);
                            if (QuickVideoView.this.jpP != null) {
                                QuickVideoView.this.jpP.cvP();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jqn.cdR();
                            }
                        }
                    }
                } else if (cwq()) {
                    if (QuickVideoView.this.jqk != null) {
                        QuickVideoView.this.cwf();
                        QuickVideoView.this.jqt = true;
                        QuickVideoView.this.jqk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jqn.cdQ();
                    }
                }
                QuickVideoView.this.jqx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jqV) {
                    QuickVideoView.this.cwh();
                    QuickVideoView.this.ry(false);
                    if (QuickVideoView.this.jqk != null) {
                        if (QuickVideoView.this.jqk.isPlaying() && QuickVideoView.this.cwl()) {
                            x.cwN().bm(QuickVideoView.this.jqE, QuickVideoView.this.jqk.getCurrentPosition());
                            if (QuickVideoView.this.jqI) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jqI) {
                            QuickVideoView.this.jqk.release();
                        }
                    }
                    if (QuickVideoView.this.jqt) {
                        if (QuickVideoView.this.jqr != null && !QuickVideoView.this.jqI) {
                            QuickVideoView.this.jqr.GA(QuickVideoView.this.jqD);
                        }
                        if (QuickVideoView.this.dHV != null) {
                            QuickVideoView.this.dHV.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jqx = null;
                    if (QuickVideoView.this.jqn != null && QuickVideoView.this.jqn.EF(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jqn = null;
                    }
                    if (!QuickVideoView.this.jqI) {
                        QuickVideoView.this.jqt = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cwq() {
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
        this.eaO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int GF;
                QuickVideoView.this.cwh();
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.onPrepared();
                }
                if (QuickVideoView.this.jqn != null && QuickVideoView.this.jqk != null) {
                    QuickVideoView.this.jqn.xW(QuickVideoView.this.jqk.getPlayerType());
                }
                if (QuickVideoView.this.jqI) {
                    TbVideoViewSet.cwQ().a(QuickVideoView.this, QuickVideoView.this.jqD);
                }
                if (QuickVideoView.this.dQO != null) {
                    QuickVideoView.this.jqs.ceg();
                    QuickVideoView.this.dQO.onPrepared(gVar);
                }
                if (QuickVideoView.this.jqr != null) {
                    long j = 0;
                    if (QuickVideoView.this.jqk != null) {
                        j = QuickVideoView.this.jqk.getDuration();
                    }
                    QuickVideoView.this.jqr.eu(j);
                    QuickVideoView.this.cwg();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jqr.cvZ();
                        QuickVideoView.this.cwk();
                    }
                }
                if (QuickVideoView.this.jqH && (GF = x.cwN().GF(QuickVideoView.this.jqE)) > 0 && QuickVideoView.this.jqk != null) {
                    if (QuickVideoView.this.jqk.isPlayerReuse()) {
                        if (QuickVideoView.this.jqk.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ad(GF);
                        }
                    } else {
                        QuickVideoView.this.Ad(GF);
                    }
                }
                if (QuickVideoView.this.jqq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jqi != null && gVar != null) {
                    QuickVideoView.this.jqi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jqu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jqj) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jqj);
                }
                if (QuickVideoView.this.jqz != null && QuickVideoView.this.jqz.cxh()) {
                    com.baidu.tieba.play.b.e.Aj(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.ry(true);
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.EE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jqn = null;
                }
                if (!QuickVideoView.this.eaE || QuickVideoView.this.jqr == null) {
                    if (QuickVideoView.this.jqr != null) {
                        QuickVideoView.this.jqr.onCompletion();
                    }
                    QuickVideoView.this.jqq = false;
                    x.cwN().remove(QuickVideoView.this.jqE);
                    if (QuickVideoView.this.dQN != null) {
                        QuickVideoView.this.dQN.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jqp = null;
                QuickVideoView.this.jqF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jqr.cvS());
                QuickVideoView.this.start();
            }
        };
        this.dQP = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.W(i, i2, i3);
                QuickVideoView.this.cwh();
                if (QuickVideoView.this.jqr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cwl()) {
                    QuickVideoView.this.jqG = true;
                    x.cwN().bm(QuickVideoView.this.jqE, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cwQ().GH(QuickVideoView.this.jqD);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jqn != null) {
                        QuickVideoView.this.jqp = QuickVideoView.this.jqn.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jqF, QuickVideoView.this.ap(QuickVideoView.this.jqn.cdV(), i3 + "", QuickVideoView.this.jqn.cdW()));
                        QuickVideoView.this.jqn = null;
                    }
                    QuickVideoView.this.jqF = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Ah(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ai(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dHR == null || QuickVideoView.this.dHR.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.eaS = new g.InterfaceC0577g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                if (QuickVideoView.this.jqG) {
                    QuickVideoView.this.jqG = false;
                    return;
                }
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.cwz();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jqr != null && z) {
                    QuickVideoView.this.jqr.onSeekComplete();
                }
                if (QuickVideoView.this.dQR != null) {
                    QuickVideoView.this.dQR.b(gVar);
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jql != null) {
                    QuickVideoView.this.jql.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jqu = i2;
                    if (QuickVideoView.this.jqi != null && gVar != null) {
                        QuickVideoView.this.jqi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jqu);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jqs.a(QuickVideoView.this.OC, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.a(i, i2, QuickVideoView.this.jqn);
                    return true;
                }
                return true;
            }
        };
        this.dQS = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.k(i, i2, str);
                }
            }
        };
        this.dQT = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.EG(str);
                }
            }
        };
        this.dQU = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jqF = j;
                }
            }
        };
        this.jqZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jqr != null && QuickVideoView.this.jqr.cvV() && QuickVideoView.this.jqr.cvW() && QuickVideoView.this.jqr.cvX() && QuickVideoView.this.jqk != null) {
                    int aTU = QuickVideoView.this.jqk.aTU();
                    int currentPosition = QuickVideoView.this.jqk.getCurrentPosition();
                    int duration = QuickVideoView.this.jqk.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jqJ;
                    boolean z = currentPosition + aTU < duration;
                    if (aTU < QuickVideoView.this.jqr.cvY() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jqJ = currentTimeMillis;
                        QuickVideoView.this.jqr.Ab(0);
                    }
                    if (QuickVideoView.this.cwj() && currentPosition == QuickVideoView.this.jqK && j > 500) {
                        QuickVideoView.this.jqJ = currentTimeMillis;
                        QuickVideoView.this.jqr.Ab(0);
                    }
                    QuickVideoView.this.jqK = currentPosition;
                    if (QuickVideoView.this.iXZ == QuickVideoView.jqO) {
                        QuickVideoView.this.cwk();
                    }
                }
            }
        };
        this.dRb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jqr != null) {
                        QuickVideoView.this.jqr.wl(QuickVideoView.this.jqD);
                    }
                    if (QuickVideoView.this.jqn != null) {
                        QuickVideoView.this.jqn.ED(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jqn = null;
                    }
                    QuickVideoView.this.cwh();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jqq = false;
        this.jqt = false;
        this.jqu = 0;
        this.eaE = false;
        this.jqv = -1;
        this.jqw = false;
        this.jqx = null;
        this.jqy = true;
        this.jqI = false;
        this.jqJ = 0L;
        this.jqK = 0L;
        this.iXZ = jqP;
        this.jqQ = 0;
        this.mBitRate = 0;
        this.jqR = -1;
        this.jqS = 0;
        this.jqT = 0;
        this.jqU = 0;
        this.dVM = 0;
        this.jqV = false;
        this.Oy = null;
        this.jqW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jqk != null && QuickVideoView.this.jqq) {
                    QuickVideoView.this.b(QuickVideoView.this.jqk, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jqX = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.oC(false);
                }
            }
        };
        this.jqY = false;
        this.aSx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.jqV) {
                    QuickVideoView.this.jqV = false;
                    if (QuickVideoView.this.jqk != null) {
                        QuickVideoView.this.jqk.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jqt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jqk != null) {
                        if (QuickVideoView.this.cwn()) {
                            QuickVideoView.this.jqk.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jqw) {
                            QuickVideoView.this.jqk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jqv);
                            if (QuickVideoView.this.jpP != null) {
                                QuickVideoView.this.jpP.cvP();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jqn.cdR();
                            }
                        }
                    }
                } else if (cwq()) {
                    if (QuickVideoView.this.jqk != null) {
                        QuickVideoView.this.cwf();
                        QuickVideoView.this.jqt = true;
                        QuickVideoView.this.jqk.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jqn.cdQ();
                    }
                }
                QuickVideoView.this.jqx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jqV) {
                    QuickVideoView.this.cwh();
                    QuickVideoView.this.ry(false);
                    if (QuickVideoView.this.jqk != null) {
                        if (QuickVideoView.this.jqk.isPlaying() && QuickVideoView.this.cwl()) {
                            x.cwN().bm(QuickVideoView.this.jqE, QuickVideoView.this.jqk.getCurrentPosition());
                            if (QuickVideoView.this.jqI) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jqI) {
                            QuickVideoView.this.jqk.release();
                        }
                    }
                    if (QuickVideoView.this.jqt) {
                        if (QuickVideoView.this.jqr != null && !QuickVideoView.this.jqI) {
                            QuickVideoView.this.jqr.GA(QuickVideoView.this.jqD);
                        }
                        if (QuickVideoView.this.dHV != null) {
                            QuickVideoView.this.dHV.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jqx = null;
                    if (QuickVideoView.this.jqn != null && QuickVideoView.this.jqn.EF(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jqn = null;
                    }
                    if (!QuickVideoView.this.jqI) {
                        QuickVideoView.this.jqt = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cwq() {
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
        this.eaO = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int GF;
                QuickVideoView.this.cwh();
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.onPrepared();
                }
                if (QuickVideoView.this.jqn != null && QuickVideoView.this.jqk != null) {
                    QuickVideoView.this.jqn.xW(QuickVideoView.this.jqk.getPlayerType());
                }
                if (QuickVideoView.this.jqI) {
                    TbVideoViewSet.cwQ().a(QuickVideoView.this, QuickVideoView.this.jqD);
                }
                if (QuickVideoView.this.dQO != null) {
                    QuickVideoView.this.jqs.ceg();
                    QuickVideoView.this.dQO.onPrepared(gVar);
                }
                if (QuickVideoView.this.jqr != null) {
                    long j = 0;
                    if (QuickVideoView.this.jqk != null) {
                        j = QuickVideoView.this.jqk.getDuration();
                    }
                    QuickVideoView.this.jqr.eu(j);
                    QuickVideoView.this.cwg();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jqr.cvZ();
                        QuickVideoView.this.cwk();
                    }
                }
                if (QuickVideoView.this.jqH && (GF = x.cwN().GF(QuickVideoView.this.jqE)) > 0 && QuickVideoView.this.jqk != null) {
                    if (QuickVideoView.this.jqk.isPlayerReuse()) {
                        if (QuickVideoView.this.jqk.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ad(GF);
                        }
                    } else {
                        QuickVideoView.this.Ad(GF);
                    }
                }
                if (QuickVideoView.this.jqq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jqi != null && gVar != null) {
                    QuickVideoView.this.jqi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jqu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jqj) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jqj);
                }
                if (QuickVideoView.this.jqz != null && QuickVideoView.this.jqz.cxh()) {
                    com.baidu.tieba.play.b.e.Aj(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaP = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.ry(true);
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.EE(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jqn = null;
                }
                if (!QuickVideoView.this.eaE || QuickVideoView.this.jqr == null) {
                    if (QuickVideoView.this.jqr != null) {
                        QuickVideoView.this.jqr.onCompletion();
                    }
                    QuickVideoView.this.jqq = false;
                    x.cwN().remove(QuickVideoView.this.jqE);
                    if (QuickVideoView.this.dQN != null) {
                        QuickVideoView.this.dQN.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jqp = null;
                QuickVideoView.this.jqF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jqr.cvS());
                QuickVideoView.this.start();
            }
        };
        this.dQP = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.W(i2, i22, i3);
                QuickVideoView.this.cwh();
                if (QuickVideoView.this.jqr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cwl()) {
                    QuickVideoView.this.jqG = true;
                    x.cwN().bm(QuickVideoView.this.jqE, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cwQ().GH(QuickVideoView.this.jqD);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jqn != null) {
                        QuickVideoView.this.jqp = QuickVideoView.this.jqn.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jqF, QuickVideoView.this.ap(QuickVideoView.this.jqn.cdV(), i3 + "", QuickVideoView.this.jqn.cdW()));
                        QuickVideoView.this.jqn = null;
                    }
                    QuickVideoView.this.jqF = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.Ah(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.Ai(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dHR == null || QuickVideoView.this.dHR.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.eaS = new g.InterfaceC0577g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(g gVar) {
                if (QuickVideoView.this.jqG) {
                    QuickVideoView.this.jqG = false;
                    return;
                }
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.cwz();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jqr != null && z) {
                    QuickVideoView.this.jqr.onSeekComplete();
                }
                if (QuickVideoView.this.dQR != null) {
                    QuickVideoView.this.dQR.b(gVar);
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.jql != null) {
                    QuickVideoView.this.jql.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.jqu = i22;
                    if (QuickVideoView.this.jqi != null && gVar != null) {
                        QuickVideoView.this.jqi.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jqu);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.jqs.a(QuickVideoView.this.OC, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jqA != null) {
                    QuickVideoView.this.jqA.a(i2, i22, QuickVideoView.this.jqn);
                    return true;
                }
                return true;
            }
        };
        this.dQS = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.k(i2, i22, str);
                }
            }
        };
        this.dQT = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jqn != null) {
                    QuickVideoView.this.jqn.EG(str);
                }
            }
        };
        this.dQU = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jqF = j;
                }
            }
        };
        this.jqZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jqr != null && QuickVideoView.this.jqr.cvV() && QuickVideoView.this.jqr.cvW() && QuickVideoView.this.jqr.cvX() && QuickVideoView.this.jqk != null) {
                    int aTU = QuickVideoView.this.jqk.aTU();
                    int currentPosition = QuickVideoView.this.jqk.getCurrentPosition();
                    int duration = QuickVideoView.this.jqk.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jqJ;
                    boolean z = currentPosition + aTU < duration;
                    if (aTU < QuickVideoView.this.jqr.cvY() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jqJ = currentTimeMillis;
                        QuickVideoView.this.jqr.Ab(0);
                    }
                    if (QuickVideoView.this.cwj() && currentPosition == QuickVideoView.this.jqK && j > 500) {
                        QuickVideoView.this.jqJ = currentTimeMillis;
                        QuickVideoView.this.jqr.Ab(0);
                    }
                    QuickVideoView.this.jqK = currentPosition;
                    if (QuickVideoView.this.iXZ == QuickVideoView.jqO) {
                        QuickVideoView.this.cwk();
                    }
                }
            }
        };
        this.dRb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jqr != null) {
                        QuickVideoView.this.jqr.wl(QuickVideoView.this.jqD);
                    }
                    if (QuickVideoView.this.jqn != null) {
                        QuickVideoView.this.jqn.ED(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jqn = null;
                    }
                    QuickVideoView.this.cwh();
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
        this.jqi = new RenderView(context);
        this.Oy = new WeakReference<>(TbadkCoreApplication.getInst());
        this.jqi.setSurfaceTextureListener(this.aSx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.jqy) {
            addView(this.jqi, layoutParams);
        } else {
            addView(this.jqi, 0, layoutParams);
        }
        if (eaM != null) {
            this.jqk = eaM.aTX();
        }
        if (this.jqk != null) {
            this.jqk.setOnPreparedListener(this.eaO);
            this.jqk.setOnCompletionListener(this.eaP);
            this.jqk.a(this.dQP);
            this.jqk.setOnSeekCompleteListener(this.eaS);
            this.jqk.a(this.dQQ);
            this.jqk.a(this.dQS);
            this.jqk.a(this.dQT);
            this.jqk.a(this.dQU);
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
        this.jqz = new com.baidu.tieba.play.b.a(this);
        this.jqA = new q();
        this.jqB = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.jqs = new com.baidu.tieba.j.k();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(SwitchManager.getInstance().findType(VideoPlayerReuseSwitch.VIDEO_PLAY_REUSE_KEY) == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.jqH = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.jqD;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.jqs.cef();
        this.OC = str2;
        if (this.jqz != null) {
            this.jqz.clear();
            this.jqz.cxh();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.GJ(str2);
            if (eaN != null) {
                this.jqn = eaN.ao(this.OC, str, "");
                if (this.jqn != null) {
                    this.jqn.a(-300, -44399, -44399, getLocateSource(), false, this.jqF, "");
                    this.jqn = null;
                }
            }
        }
        if (this.jqo != null) {
            this.jqo.a(null);
            this.jqo.cdJ();
            this.jqo = null;
        }
        this.jqp = null;
        this.jqF = 0L;
        setVideoPath(str);
    }

    private String GB(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cMD().cME()) {
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
            String GB = GB(str);
            this.jqC = GB;
            if (this.jqr != null) {
                GB = this.jqr.wg(GB);
                if (this.jqr.cwa() != null) {
                    this.jqr.cwa().setPlayer(this);
                }
                if (eaN != null && uc(GB)) {
                    this.jqo = eaN.EJ(GB);
                }
                if (this.jqo != null) {
                    this.jqo.a(new com.baidu.tieba.play.monitor.a(this.OC, this.jqC, this.jqn));
                    this.jqo.cdI();
                }
                GC(GB);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !uc(GB)) {
                if (this.dHR != null) {
                    this.dHR.onError(this.jqk, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cwQ().GH(this.jqD);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(GB));
            if (this.jqn != null) {
                if (t(Uri.parse(GB)) != null) {
                    this.jqn.cdP();
                }
                this.jqn.Tz();
                this.jqn = null;
            }
            this.jqD = str;
            int lastIndexOf = this.jqD.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.jqD.length() > 4) {
                this.jqE = this.jqD.substring(0, lastIndexOf + 4);
            } else {
                this.jqE = this.jqD;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwf() {
        if (com.baidu.tbadk.coreExtra.model.f.aJp()) {
            if (this.jqr != null && (this.jqr.cvU() || this.jqr.cvV())) {
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqW);
                com.baidu.adp.lib.f.e.gy().postDelayed(this.jqW, com.baidu.tbadk.coreExtra.model.f.aJo());
            }
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqX);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.jqX, com.baidu.tbadk.coreExtra.model.f.aJn());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (t(uri) != null) {
            this.jqn.EC(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aTQ();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.jqY = false;
        if (this.jqx != null) {
            cwf();
            if (this.jqk != null) {
                if (!this.jqt) {
                    this.jqt = true;
                    this.jqk.a(this.mContext, this.mUri, this.mHeaders, this.jqx, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying() && this.eaO != null) {
                    this.jqY = true;
                    this.eaO.onPrepared(this.jqk);
                }
            }
        } else if (this.jqi != null && this.jqi.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.jqy) {
                addView(this.jqi, layoutParams);
            } else {
                addView(this.jqi, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aTQ() {
        this.jqt = false;
        this.jqq = false;
        if (this.jqk != null) {
            if (this.jqk.isPlaying() && cwl()) {
                x.cwN().bm(this.jqE, this.jqk.getCurrentPosition());
            }
            this.jqk.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqZ);
    }

    private void GC(String str) {
        this.mBitRate = 0;
        this.jqR = 0;
        this.jqS = 0;
        this.jqT = 0;
        this.jqU = 0;
        this.dVM = 0;
        if (this.jqr.cvV()) {
            this.jqQ = jqM;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.jqR = (int) t.GE(QuickVideoView.this.jqC);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.jqC != null && this.jqC.equals(str)) {
            this.jqQ = jqL;
        } else {
            this.jqQ = jqN;
        }
        this.iXZ = jqO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwg() {
        this.iXZ = jqO;
        if (this.jqk != null) {
            this.mBitRate = this.jqk.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry(boolean z) {
        if (this.iXZ == jqO && this.jqk != null) {
            this.iXZ = jqP;
            this.jqT = this.jqk.getDuration();
            if (z) {
                this.jqU = 0;
                this.jqS = this.jqT;
            } else {
                this.jqS = this.jqk.getCurrentPosition();
                this.jqU = this.jqk.getCachedSize();
            }
            if (this.jqS > 0) {
                if (this.jqQ == jqL) {
                    this.jqR = (int) t.GE(this.jqC);
                    if (this.mBitRate > 0) {
                        long j = (this.mBitRate * (this.jqS / 1000)) / 8;
                        if (this.jqU < 0) {
                            this.jqU = 0;
                        }
                        long j2 = this.jqU + j;
                        if (this.jqR > 0) {
                            j2 += this.jqR;
                        }
                        setFlowCount(j2, this.jqS, this.jqT, this.dVM);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jqS / 1000)) / 8, this.jqS, this.jqT, this.dVM);
                    }
                } else if (this.jqQ == jqM) {
                    if (this.mBitRate > 0) {
                        long j3 = (this.mBitRate * (this.jqS / 1000)) / 8;
                        if (this.jqU < 0) {
                            this.jqU = 0;
                        }
                        long j4 = this.jqU + j3;
                        if (this.jqR > 0) {
                            j4 -= this.jqR;
                        }
                        setFlowCount(j4, this.jqS, this.jqT, this.dVM);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jqS / 1000)) / 8, this.jqS, this.jqT, this.dVM);
                    }
                } else {
                    setFlowCount(0L, this.jqS, this.jqT, this.dVM);
                }
            }
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqZ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jqI) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.Oy, false);
        }
        cwh();
        ry(false);
        if (this.jqz != null) {
            this.jqz.clear();
        }
        this.jqj = null;
        this.jqq = false;
        if (this.jqk != null) {
            if (this.jqk.isPlaying() && cwl()) {
                x.cwN().bm(this.jqE, this.jqk.getCurrentPosition());
            }
            this.jqk.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqZ);
        this.eaE = false;
        if (this.jqr != null) {
            this.jqr.cvT();
        }
        com.baidu.adp.lib.network.http.a.b.gj().a((b.InterfaceC0018b) null);
        if (this.jqn != null && this.jqn.EF(getLocateSource())) {
            this.jqn = null;
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqZ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.Oy, false);
        }
        cwh();
        ry(false);
        if (this.jqz != null) {
            this.jqz.clear();
        }
        this.jqj = null;
        aTQ();
        TbVideoViewSet.cwQ().GH(this.jqD);
        this.eaE = false;
        if (this.jqr != null) {
            this.jqr.GA(this.jqD);
        }
        com.baidu.adp.lib.network.http.a.b.gj().a((b.InterfaceC0018b) null);
        if (this.jqn != null && this.jqn.EF(getLocateSource())) {
            this.jqn = null;
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqZ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.jqV = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwh() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqW);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqX);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.dQO = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.dQN = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.dHR = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0577g interfaceC0577g) {
        this.dQR = interfaceC0577g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cwi() {
        cwh();
        if (this.jqA != null) {
            this.jqA.onPrepared();
        }
        if (this.jqn != null && this.jqk != null) {
            this.jqn.xW(this.jqk.getPlayerType());
        }
        this.jqs.ceg();
        if (this.jqr != null) {
            long j = 0;
            if (this.jqk != null) {
                j = this.jqk.getDuration();
            }
            this.jqr.eu(j);
            cwg();
            if (getPlayerType() == -200) {
                this.jqr.cvZ();
                cwk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ap(String str, String str2, String str3) {
        if (this.jqB == null) {
            return "";
        }
        String cxj = this.jqB.cxj();
        this.jqB.aq(str, str2, str3);
        return cxj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.jqr != null && !StringUtils.isNull(this.jqr.cvS())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.GI(uri);
                }
            }
            this.mUri = Uri.parse(this.jqr.cvS());
        }
        boolean z = false;
        if (this.jqz != null) {
            z = this.jqz.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.jqn != null) {
            this.jqp = this.jqn.a(i, i2, i3, getLocateSource(), z, this.jqF, ap(this.jqn.cdV(), i3 + "", this.jqn.cdW()));
            this.jqn = null;
        }
        this.jqF = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.jqk != null) {
            try {
                if (this.jqk.isPlaying() && cwl()) {
                    x.cwN().bm(this.jqE, this.jqk.getCurrentPosition());
                }
                this.jqk.release();
                this.jqj = str;
                URI uri = new URI(this.mUri.toString());
                this.jqk.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.jqx, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (t(this.mUri) != null) {
                    this.jqn.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jqk != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.jqk.isPlaying() && cwl()) {
                x.cwN().bm(this.jqE, this.jqk.getCurrentPosition());
            }
            this.jqk.release();
            this.jqk.a(this.mContext, this.mUri, this.mHeaders, this.jqx, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (t(this.mUri) != null) {
                this.jqn.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jqk != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.jqk.forceUseSystemMediaPlayer(true);
            }
            if (this.jqk.isPlaying() && cwl()) {
                x.cwN().bm(this.jqE, this.jqk.getCurrentPosition());
            }
            this.jqk.release();
            this.jqk.a(this.mContext, this.mUri, this.mHeaders, this.jqx, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (t(this.mUri) != null) {
                this.jqn.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.jqq = true;
        if (this.jqk != null) {
            if (this.jqx != null && this.jqw && !this.jqk.isExistInRemote()) {
                this.jqk.a(this.mContext, this.mUri, this.mHeaders, this.jqx, this.jqv);
                if (this.jpP != null) {
                    this.jpP.cvP();
                }
                if (t(this.mUri) != null) {
                    this.jqn.cdR();
                }
                cwf();
                return;
            }
            if (!this.jqk.aTV()) {
                af.a(this.Oy, true);
                this.jqk.setVolume(1.0f, 1.0f);
            }
            this.jqs.ceh();
            this.jqk.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.jqr != null) {
            this.jqr.onStart();
        }
        if (this.jqm != null) {
            this.jqm.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (t(this.mUri) != null && this.jqk != null) {
            this.jqn.xX(this.jqk.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jqq) {
            b(aVar);
            return;
        }
        this.jqq = true;
        if (aVar != null) {
            this.jqI = true;
            if (!cwo()) {
                aVar.cwR();
            }
        } else {
            this.jqI = false;
        }
        setVideoPath(this.jqD, this.OC);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cwh();
        af.a(this.Oy, false);
        if (this.jqk != null) {
            if (this.jqk.isPlaying() && cwl()) {
                x.cwN().bm(this.jqE, this.jqk.getCurrentPosition());
            }
            this.jqk.pause();
        }
        if (this.jqr != null) {
            this.jqr.onPause();
        }
        this.jqq = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jqn != null) {
            this.jqn.cdU();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.jqk != null) {
            return this.jqk.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.jqk != null) {
            return this.jqk.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.dVM = i;
        Ad(i);
    }

    public void Ad(int i) {
        if (this.jqA != null) {
            this.jqA.cwy();
        }
        if (this.jqk != null) {
            this.jqk.seekTo(i);
        }
        if (this.jqr != null) {
            this.jqr.Ab(0);
            cwk();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.jqk != null) {
            return this.jqk.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.jqk != null) {
            this.jqk.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.jqv = i;
    }

    public int getRecoveryState() {
        return this.jqv;
    }

    public void setNeedRecovery(boolean z) {
        this.jqw = z;
    }

    public void setLooping(boolean z) {
        this.eaE = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cwj() {
        return this.jqq;
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
        this.dHV = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.jqr = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dRb);
    }

    public void setMute(boolean z) {
        if (z) {
            this.jqk.setVolume(0.0f, 0.0f);
            af.a(this.Oy, false);
            return;
        }
        af.a(this.Oy, true);
        this.jqk.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eaE = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jqk != null) {
            this.jqk.aTW();
        }
        if (this.jqA != null) {
            this.jqA.Dz();
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqZ);
        MessageManager.getInstance().unRegisterListener(this.dRb);
        if (this.jqz != null) {
            this.jqz.clear();
        }
        if (this.jqo != null) {
            this.jqo.a(null);
            this.jqo.cdJ();
        }
    }

    public g getPlayer() {
        return this.jqk;
    }

    public int getPlayerType() {
        if (this.jqk == null) {
            return -300;
        }
        return this.jqk.getPlayerType();
    }

    public void cwk() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqZ);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.jqZ, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.jpP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.jqr instanceof n) || ((n) this.jqr).cwx() == null) ? "" : ((n) this.jqr).cwx().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i t(Uri uri) {
        String uri2;
        if (this.jqn != null) {
            return this.jqn;
        }
        if (!StringUtils.isNull(this.jqC)) {
            uri2 = this.jqC;
        } else if (eaN != null && this.jqr != null && !StringUtils.isNull(this.jqr.cvS())) {
            uri2 = this.jqr.cvS();
        } else {
            uri2 = (eaN == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && eaN != null) {
            this.jqn = eaN.ao(this.OC, uri2, this.jqp);
        }
        this.jqp = null;
        this.jqF = 0L;
        return this.jqn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwl() {
        return this.jqk != null && this.jqk.getDuration() >= this.jqk.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.jqn, j, j2, j3, j4);
    }

    public static boolean uc(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cwm() {
        clearCallbacks();
        if (getParent() instanceof ViewGroup) {
            try {
                ((ViewGroup) getParent()).removeView(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void b(TbVideoViewSet.a aVar) {
        if (aVar != null) {
            this.jqI = true;
            if (!cwo()) {
                aVar.cwR();
            }
            if (!cwn()) {
                aVar.cwS();
                this.jqq = true;
                setVideoPath(this.jqD, this.OC);
                return;
            }
        } else {
            this.jqI = false;
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwn() {
        return this == TbVideoViewSet.cwQ().GG(this.jqD);
    }

    private boolean cwo() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.dQN = null;
        this.dHR = null;
        this.dQQ = null;
        this.eaO = null;
        this.eaS = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jqI = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jql = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.jqk != null) {
            return this.jqk.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.jqk != null ? this.jqk.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void setPageTypeForPerfStat(String str) {
        this.jqs.setPageTypeForPerfStat(str);
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.jqn != null) {
            this.jqn.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.jqm = cVar;
    }
}
