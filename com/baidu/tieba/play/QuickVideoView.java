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
import com.baidu.adp.lib.network.http.a.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.ag;
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
    private static int kTL = 0;
    private static int kTM = 1;
    private static int kTN = 2;
    private static int kTO = 1;
    private static int kTP = 0;
    private static h kTl;
    private static com.baidu.tieba.k.l kTm;
    private WeakReference<Context> ajK;
    private String ajO;
    private TextureView.SurfaceTextureListener bIZ;
    private boolean dvZ;
    private int dxk;
    private g.b eLe;
    private b eLi;
    private g.a eUI;
    private g.f eUJ;
    private g.c eUK;
    private g.e eUL;
    private g.InterfaceC0721g eUM;
    private g.i eUN;
    private g.d eUO;
    private g.h eUP;
    private final CustomMessageListener eUW;
    private a kSM;
    private q kTA;
    private com.baidu.tieba.play.b.f kTB;
    private String kTC;
    private String kTD;
    private String kTE;
    private long kTF;
    private boolean kTG;
    private boolean kTH;
    private boolean kTI;
    private long kTJ;
    private long kTK;
    private int kTQ;
    private int kTR;
    private int kTS;
    private int kTT;
    private int kTU;
    private int kTV;
    private int kTW;
    private boolean kTX;
    private Runnable kTY;
    private Runnable kTZ;
    private RenderView kTg;
    private String kTh;
    private g kTi;
    private g.e kTj;
    private c kTk;
    private com.baidu.tieba.k.i kTn;
    private com.baidu.tieba.k.e kTo;
    private String kTp;
    private boolean kTq;
    private d kTr;
    private com.baidu.tieba.k.k kTs;
    private boolean kTt;
    private int kTu;
    private int kTv;
    private boolean kTw;
    private SurfaceTexture kTx;
    private boolean kTy;
    private com.baidu.tieba.play.b.a kTz;
    public boolean kUa;
    private g.f kUb;
    private g.a kUc;
    private g.InterfaceC0721g kUd;
    private Runnable kUe;
    private Context mContext;
    private Map<String, String> mHeaders;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cUX();
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
            kTl = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            kTm = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.kTy = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.kTq = false;
        this.kTt = false;
        this.kTu = 0;
        this.dvZ = false;
        this.kTv = -1;
        this.kTw = false;
        this.kTx = null;
        this.kTy = true;
        this.kTI = false;
        this.kTJ = 0L;
        this.kTK = 0L;
        this.kTQ = kTP;
        this.kTR = 0;
        this.kTS = 0;
        this.kTT = -1;
        this.kTU = 0;
        this.kTV = 0;
        this.kTW = 0;
        this.dxk = 0;
        this.kTX = false;
        this.ajK = null;
        this.kTY = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kTi != null && QuickVideoView.this.kTq) {
                    QuickVideoView.this.b(QuickVideoView.this.kTi, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kTZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.qI(false);
                }
            }
        };
        this.kUa = false;
        this.bIZ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kTX) {
                    QuickVideoView.this.kTX = false;
                    if (QuickVideoView.this.kTi != null) {
                        QuickVideoView.this.kTi.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kTt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kTi != null) {
                        if (QuickVideoView.this.cVw()) {
                            QuickVideoView.this.kTi.d(surfaceTexture);
                        } else if (QuickVideoView.this.kTw) {
                            QuickVideoView.this.kTi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kTv);
                            if (QuickVideoView.this.kSM != null) {
                                QuickVideoView.this.kSM.cUX();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kTn.cCy();
                            }
                        }
                    }
                } else if (cVz()) {
                    if (QuickVideoView.this.kTi != null) {
                        QuickVideoView.this.cVn();
                        QuickVideoView.this.kTt = true;
                        QuickVideoView.this.kTi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kTn.cCx();
                    }
                }
                QuickVideoView.this.kTx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kTX) {
                    QuickVideoView.this.cVp();
                    QuickVideoView.this.tK(false);
                    if (QuickVideoView.this.kTi != null) {
                        if (QuickVideoView.this.kTi.isPlaying() && QuickVideoView.this.cVu()) {
                            x.cVW().bv(QuickVideoView.this.kTE, QuickVideoView.this.kTi.getCurrentPosition());
                            if (QuickVideoView.this.kTI) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kTI) {
                            QuickVideoView.this.kTi.release();
                        }
                    }
                    if (QuickVideoView.this.kTt) {
                        if (QuickVideoView.this.kTr != null && !QuickVideoView.this.kTI) {
                            QuickVideoView.this.kTr.KX(QuickVideoView.this.kTD);
                        }
                        if (QuickVideoView.this.eLi != null) {
                            QuickVideoView.this.eLi.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kTx = null;
                    if (QuickVideoView.this.kTn != null && QuickVideoView.this.kTn.Jc(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kTn = null;
                    }
                    if (!QuickVideoView.this.kTI) {
                        QuickVideoView.this.kTt = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cVz() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.w.isEmpty(runningTasks)) {
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
        this.kUb = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Lc;
                QuickVideoView.this.cVp();
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.onPrepared();
                }
                if (QuickVideoView.this.kTn != null && QuickVideoView.this.kTi != null) {
                    QuickVideoView.this.kTn.Am(QuickVideoView.this.kTi.getPlayerType());
                }
                if (QuickVideoView.this.kTI) {
                    TbVideoViewSet.cWb().a(QuickVideoView.this, QuickVideoView.this.kTD);
                }
                if (QuickVideoView.this.eUJ != null) {
                    QuickVideoView.this.kTs.cCO();
                    QuickVideoView.this.eUJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.kTr != null) {
                    long j = 0;
                    if (QuickVideoView.this.kTi != null) {
                        j = QuickVideoView.this.kTi.getDuration();
                    }
                    QuickVideoView.this.kTr.fm(j);
                    QuickVideoView.this.cVo();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kTr.cVh();
                        QuickVideoView.this.cVt();
                    }
                }
                if (QuickVideoView.this.kTH && (Lc = x.cVW().Lc(QuickVideoView.this.kTE)) > 0 && QuickVideoView.this.kTi != null && QuickVideoView.this.kTi.getCurrentPosition() == 0) {
                    QuickVideoView.this.CO(Lc);
                }
                if (QuickVideoView.this.kTq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kTg != null && gVar != null) {
                    QuickVideoView.this.kTg.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kTu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kTh) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kTh);
                }
                if (QuickVideoView.this.kTz != null && QuickVideoView.this.kTz.cWx()) {
                    com.baidu.tieba.play.b.e.CU(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kUc = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tK(true);
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.Jb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kTn = null;
                }
                if (!QuickVideoView.this.dvZ || QuickVideoView.this.kTr == null) {
                    if (QuickVideoView.this.kTr != null) {
                        QuickVideoView.this.kTr.onCompletion();
                    }
                    QuickVideoView.this.kTq = false;
                    x.cVW().remove(QuickVideoView.this.kTE);
                    if (QuickVideoView.this.eUI != null) {
                        QuickVideoView.this.eUI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kTp = null;
                QuickVideoView.this.kTF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kTr.cVa());
                QuickVideoView.this.start();
            }
        };
        this.eUK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cVp();
                if (QuickVideoView.this.kTr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cVu()) {
                    QuickVideoView.this.kTG = true;
                    x.cVW().bv(QuickVideoView.this.kTE, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cWb().Le(QuickVideoView.this.kTD);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kTn != null) {
                        QuickVideoView.this.kTp = QuickVideoView.this.kTn.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kTF, QuickVideoView.this.av(QuickVideoView.this.kTn.cCC(), i3 + "", QuickVideoView.this.kTn.cCD()));
                        QuickVideoView.this.kTn = null;
                    }
                    QuickVideoView.this.kTF = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.CS(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.CT(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eLe == null || QuickVideoView.this.eLe.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.kUd = new g.InterfaceC0721g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(g gVar) {
                if (QuickVideoView.this.kTG) {
                    QuickVideoView.this.kTG = false;
                    return;
                }
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.cVI();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kTr != null && z) {
                    QuickVideoView.this.kTr.onSeekComplete();
                }
                if (QuickVideoView.this.eUM != null) {
                    QuickVideoView.this.eUM.b(gVar);
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kTj != null) {
                    QuickVideoView.this.kTj.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kTu = i2;
                    if (QuickVideoView.this.kTg != null && gVar != null) {
                        QuickVideoView.this.kTg.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kTu);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kTs.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.a(i, i2, QuickVideoView.this.kTn);
                    return true;
                }
                return true;
            }
        };
        this.eUN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.m(i, i2, str);
                }
            }
        };
        this.eUO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.Jd(str);
                }
            }
        };
        this.eUP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kTF = j;
                }
            }
        };
        this.kUe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kTr != null && QuickVideoView.this.kTr.cVd() && QuickVideoView.this.kTr.cVe() && QuickVideoView.this.kTr.cVf() && QuickVideoView.this.kTi != null) {
                    int bnD = QuickVideoView.this.kTi.bnD();
                    int currentPosition = QuickVideoView.this.kTi.getCurrentPosition();
                    int duration = QuickVideoView.this.kTi.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kTJ;
                    boolean z = currentPosition + bnD < duration;
                    if (bnD < QuickVideoView.this.kTr.cVg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kTJ = currentTimeMillis;
                        QuickVideoView.this.kTr.CL(0);
                    }
                    if (QuickVideoView.this.cVs() && currentPosition == QuickVideoView.this.kTK && j > 500) {
                        QuickVideoView.this.kTJ = currentTimeMillis;
                        QuickVideoView.this.kTr.CL(0);
                    }
                    QuickVideoView.this.kTK = currentPosition;
                    if (QuickVideoView.this.kTQ == QuickVideoView.kTO) {
                        QuickVideoView.this.cVt();
                    }
                }
            }
        };
        this.eUW = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kTr != null) {
                        QuickVideoView.this.kTr.zZ(QuickVideoView.this.kTD);
                    }
                    if (QuickVideoView.this.kTn != null) {
                        QuickVideoView.this.kTn.Ja(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kTn = null;
                    }
                    QuickVideoView.this.cVp();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kTq = false;
        this.kTt = false;
        this.kTu = 0;
        this.dvZ = false;
        this.kTv = -1;
        this.kTw = false;
        this.kTx = null;
        this.kTy = true;
        this.kTI = false;
        this.kTJ = 0L;
        this.kTK = 0L;
        this.kTQ = kTP;
        this.kTR = 0;
        this.kTS = 0;
        this.kTT = -1;
        this.kTU = 0;
        this.kTV = 0;
        this.kTW = 0;
        this.dxk = 0;
        this.kTX = false;
        this.ajK = null;
        this.kTY = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kTi != null && QuickVideoView.this.kTq) {
                    QuickVideoView.this.b(QuickVideoView.this.kTi, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kTZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.qI(false);
                }
            }
        };
        this.kUa = false;
        this.bIZ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kTX) {
                    QuickVideoView.this.kTX = false;
                    if (QuickVideoView.this.kTi != null) {
                        QuickVideoView.this.kTi.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kTt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kTi != null) {
                        if (QuickVideoView.this.cVw()) {
                            QuickVideoView.this.kTi.d(surfaceTexture);
                        } else if (QuickVideoView.this.kTw) {
                            QuickVideoView.this.kTi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kTv);
                            if (QuickVideoView.this.kSM != null) {
                                QuickVideoView.this.kSM.cUX();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kTn.cCy();
                            }
                        }
                    }
                } else if (cVz()) {
                    if (QuickVideoView.this.kTi != null) {
                        QuickVideoView.this.cVn();
                        QuickVideoView.this.kTt = true;
                        QuickVideoView.this.kTi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kTn.cCx();
                    }
                }
                QuickVideoView.this.kTx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kTX) {
                    QuickVideoView.this.cVp();
                    QuickVideoView.this.tK(false);
                    if (QuickVideoView.this.kTi != null) {
                        if (QuickVideoView.this.kTi.isPlaying() && QuickVideoView.this.cVu()) {
                            x.cVW().bv(QuickVideoView.this.kTE, QuickVideoView.this.kTi.getCurrentPosition());
                            if (QuickVideoView.this.kTI) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kTI) {
                            QuickVideoView.this.kTi.release();
                        }
                    }
                    if (QuickVideoView.this.kTt) {
                        if (QuickVideoView.this.kTr != null && !QuickVideoView.this.kTI) {
                            QuickVideoView.this.kTr.KX(QuickVideoView.this.kTD);
                        }
                        if (QuickVideoView.this.eLi != null) {
                            QuickVideoView.this.eLi.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kTx = null;
                    if (QuickVideoView.this.kTn != null && QuickVideoView.this.kTn.Jc(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kTn = null;
                    }
                    if (!QuickVideoView.this.kTI) {
                        QuickVideoView.this.kTt = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cVz() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.w.isEmpty(runningTasks)) {
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
        this.kUb = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Lc;
                QuickVideoView.this.cVp();
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.onPrepared();
                }
                if (QuickVideoView.this.kTn != null && QuickVideoView.this.kTi != null) {
                    QuickVideoView.this.kTn.Am(QuickVideoView.this.kTi.getPlayerType());
                }
                if (QuickVideoView.this.kTI) {
                    TbVideoViewSet.cWb().a(QuickVideoView.this, QuickVideoView.this.kTD);
                }
                if (QuickVideoView.this.eUJ != null) {
                    QuickVideoView.this.kTs.cCO();
                    QuickVideoView.this.eUJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.kTr != null) {
                    long j = 0;
                    if (QuickVideoView.this.kTi != null) {
                        j = QuickVideoView.this.kTi.getDuration();
                    }
                    QuickVideoView.this.kTr.fm(j);
                    QuickVideoView.this.cVo();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kTr.cVh();
                        QuickVideoView.this.cVt();
                    }
                }
                if (QuickVideoView.this.kTH && (Lc = x.cVW().Lc(QuickVideoView.this.kTE)) > 0 && QuickVideoView.this.kTi != null && QuickVideoView.this.kTi.getCurrentPosition() == 0) {
                    QuickVideoView.this.CO(Lc);
                }
                if (QuickVideoView.this.kTq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kTg != null && gVar != null) {
                    QuickVideoView.this.kTg.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kTu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kTh) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kTh);
                }
                if (QuickVideoView.this.kTz != null && QuickVideoView.this.kTz.cWx()) {
                    com.baidu.tieba.play.b.e.CU(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kUc = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tK(true);
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.Jb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kTn = null;
                }
                if (!QuickVideoView.this.dvZ || QuickVideoView.this.kTr == null) {
                    if (QuickVideoView.this.kTr != null) {
                        QuickVideoView.this.kTr.onCompletion();
                    }
                    QuickVideoView.this.kTq = false;
                    x.cVW().remove(QuickVideoView.this.kTE);
                    if (QuickVideoView.this.eUI != null) {
                        QuickVideoView.this.eUI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kTp = null;
                QuickVideoView.this.kTF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kTr.cVa());
                QuickVideoView.this.start();
            }
        };
        this.eUK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cVp();
                if (QuickVideoView.this.kTr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cVu()) {
                    QuickVideoView.this.kTG = true;
                    x.cVW().bv(QuickVideoView.this.kTE, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cWb().Le(QuickVideoView.this.kTD);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kTn != null) {
                        QuickVideoView.this.kTp = QuickVideoView.this.kTn.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kTF, QuickVideoView.this.av(QuickVideoView.this.kTn.cCC(), i3 + "", QuickVideoView.this.kTn.cCD()));
                        QuickVideoView.this.kTn = null;
                    }
                    QuickVideoView.this.kTF = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.CS(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.CT(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eLe == null || QuickVideoView.this.eLe.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.kUd = new g.InterfaceC0721g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(g gVar) {
                if (QuickVideoView.this.kTG) {
                    QuickVideoView.this.kTG = false;
                    return;
                }
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.cVI();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kTr != null && z) {
                    QuickVideoView.this.kTr.onSeekComplete();
                }
                if (QuickVideoView.this.eUM != null) {
                    QuickVideoView.this.eUM.b(gVar);
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kTj != null) {
                    QuickVideoView.this.kTj.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kTu = i2;
                    if (QuickVideoView.this.kTg != null && gVar != null) {
                        QuickVideoView.this.kTg.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kTu);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kTs.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.a(i, i2, QuickVideoView.this.kTn);
                    return true;
                }
                return true;
            }
        };
        this.eUN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.m(i, i2, str);
                }
            }
        };
        this.eUO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.Jd(str);
                }
            }
        };
        this.eUP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kTF = j;
                }
            }
        };
        this.kUe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kTr != null && QuickVideoView.this.kTr.cVd() && QuickVideoView.this.kTr.cVe() && QuickVideoView.this.kTr.cVf() && QuickVideoView.this.kTi != null) {
                    int bnD = QuickVideoView.this.kTi.bnD();
                    int currentPosition = QuickVideoView.this.kTi.getCurrentPosition();
                    int duration = QuickVideoView.this.kTi.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kTJ;
                    boolean z = currentPosition + bnD < duration;
                    if (bnD < QuickVideoView.this.kTr.cVg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kTJ = currentTimeMillis;
                        QuickVideoView.this.kTr.CL(0);
                    }
                    if (QuickVideoView.this.cVs() && currentPosition == QuickVideoView.this.kTK && j > 500) {
                        QuickVideoView.this.kTJ = currentTimeMillis;
                        QuickVideoView.this.kTr.CL(0);
                    }
                    QuickVideoView.this.kTK = currentPosition;
                    if (QuickVideoView.this.kTQ == QuickVideoView.kTO) {
                        QuickVideoView.this.cVt();
                    }
                }
            }
        };
        this.eUW = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kTr != null) {
                        QuickVideoView.this.kTr.zZ(QuickVideoView.this.kTD);
                    }
                    if (QuickVideoView.this.kTn != null) {
                        QuickVideoView.this.kTn.Ja(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kTn = null;
                    }
                    QuickVideoView.this.cVp();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kTq = false;
        this.kTt = false;
        this.kTu = 0;
        this.dvZ = false;
        this.kTv = -1;
        this.kTw = false;
        this.kTx = null;
        this.kTy = true;
        this.kTI = false;
        this.kTJ = 0L;
        this.kTK = 0L;
        this.kTQ = kTP;
        this.kTR = 0;
        this.kTS = 0;
        this.kTT = -1;
        this.kTU = 0;
        this.kTV = 0;
        this.kTW = 0;
        this.dxk = 0;
        this.kTX = false;
        this.ajK = null;
        this.kTY = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kTi != null && QuickVideoView.this.kTq) {
                    QuickVideoView.this.b(QuickVideoView.this.kTi, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kTZ = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.qI(false);
                }
            }
        };
        this.kUa = false;
        this.bIZ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.kTX) {
                    QuickVideoView.this.kTX = false;
                    if (QuickVideoView.this.kTi != null) {
                        QuickVideoView.this.kTi.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kTt || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kTi != null) {
                        if (QuickVideoView.this.cVw()) {
                            QuickVideoView.this.kTi.d(surfaceTexture);
                        } else if (QuickVideoView.this.kTw) {
                            QuickVideoView.this.kTi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kTv);
                            if (QuickVideoView.this.kSM != null) {
                                QuickVideoView.this.kSM.cUX();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kTn.cCy();
                            }
                        }
                    }
                } else if (cVz()) {
                    if (QuickVideoView.this.kTi != null) {
                        QuickVideoView.this.cVn();
                        QuickVideoView.this.kTt = true;
                        QuickVideoView.this.kTi.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kTn.cCx();
                    }
                }
                QuickVideoView.this.kTx = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kTX) {
                    QuickVideoView.this.cVp();
                    QuickVideoView.this.tK(false);
                    if (QuickVideoView.this.kTi != null) {
                        if (QuickVideoView.this.kTi.isPlaying() && QuickVideoView.this.cVu()) {
                            x.cVW().bv(QuickVideoView.this.kTE, QuickVideoView.this.kTi.getCurrentPosition());
                            if (QuickVideoView.this.kTI) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kTI) {
                            QuickVideoView.this.kTi.release();
                        }
                    }
                    if (QuickVideoView.this.kTt) {
                        if (QuickVideoView.this.kTr != null && !QuickVideoView.this.kTI) {
                            QuickVideoView.this.kTr.KX(QuickVideoView.this.kTD);
                        }
                        if (QuickVideoView.this.eLi != null) {
                            QuickVideoView.this.eLi.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kTx = null;
                    if (QuickVideoView.this.kTn != null && QuickVideoView.this.kTn.Jc(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kTn = null;
                    }
                    if (!QuickVideoView.this.kTI) {
                        QuickVideoView.this.kTt = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cVz() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.w.isEmpty(runningTasks)) {
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
        this.kUb = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Lc;
                QuickVideoView.this.cVp();
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.onPrepared();
                }
                if (QuickVideoView.this.kTn != null && QuickVideoView.this.kTi != null) {
                    QuickVideoView.this.kTn.Am(QuickVideoView.this.kTi.getPlayerType());
                }
                if (QuickVideoView.this.kTI) {
                    TbVideoViewSet.cWb().a(QuickVideoView.this, QuickVideoView.this.kTD);
                }
                if (QuickVideoView.this.eUJ != null) {
                    QuickVideoView.this.kTs.cCO();
                    QuickVideoView.this.eUJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.kTr != null) {
                    long j = 0;
                    if (QuickVideoView.this.kTi != null) {
                        j = QuickVideoView.this.kTi.getDuration();
                    }
                    QuickVideoView.this.kTr.fm(j);
                    QuickVideoView.this.cVo();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kTr.cVh();
                        QuickVideoView.this.cVt();
                    }
                }
                if (QuickVideoView.this.kTH && (Lc = x.cVW().Lc(QuickVideoView.this.kTE)) > 0 && QuickVideoView.this.kTi != null && QuickVideoView.this.kTi.getCurrentPosition() == 0) {
                    QuickVideoView.this.CO(Lc);
                }
                if (QuickVideoView.this.kTq) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kTg != null && gVar != null) {
                    QuickVideoView.this.kTg.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kTu);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kTh) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kTh);
                }
                if (QuickVideoView.this.kTz != null && QuickVideoView.this.kTz.cWx()) {
                    com.baidu.tieba.play.b.e.CU(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kUc = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tK(true);
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.Jb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kTn = null;
                }
                if (!QuickVideoView.this.dvZ || QuickVideoView.this.kTr == null) {
                    if (QuickVideoView.this.kTr != null) {
                        QuickVideoView.this.kTr.onCompletion();
                    }
                    QuickVideoView.this.kTq = false;
                    x.cVW().remove(QuickVideoView.this.kTE);
                    if (QuickVideoView.this.eUI != null) {
                        QuickVideoView.this.eUI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kTp = null;
                QuickVideoView.this.kTF = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kTr.cVa());
                QuickVideoView.this.start();
            }
        };
        this.eUK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.aa(i2, i22, i3);
                QuickVideoView.this.cVp();
                if (QuickVideoView.this.kTr != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cVu()) {
                    QuickVideoView.this.kTG = true;
                    x.cVW().bv(QuickVideoView.this.kTE, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cWb().Le(QuickVideoView.this.kTD);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kTn != null) {
                        QuickVideoView.this.kTp = QuickVideoView.this.kTn.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kTF, QuickVideoView.this.av(QuickVideoView.this.kTn.cCC(), i3 + "", QuickVideoView.this.kTn.cCD()));
                        QuickVideoView.this.kTn = null;
                    }
                    QuickVideoView.this.kTF = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.CS(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.CT(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eLe == null || QuickVideoView.this.eLe.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.kUd = new g.InterfaceC0721g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(g gVar) {
                if (QuickVideoView.this.kTG) {
                    QuickVideoView.this.kTG = false;
                    return;
                }
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.cVI();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kTr != null && z) {
                    QuickVideoView.this.kTr.onSeekComplete();
                }
                if (QuickVideoView.this.eUM != null) {
                    QuickVideoView.this.eUM.b(gVar);
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.kTj != null) {
                    QuickVideoView.this.kTj.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.kTu = i22;
                    if (QuickVideoView.this.kTg != null && gVar != null) {
                        QuickVideoView.this.kTg.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kTu);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.kTs.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kTA != null) {
                    QuickVideoView.this.kTA.a(i2, i22, QuickVideoView.this.kTn);
                    return true;
                }
                return true;
            }
        };
        this.eUN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.m(i2, i22, str);
                }
            }
        };
        this.eUO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kTn != null) {
                    QuickVideoView.this.kTn.Jd(str);
                }
            }
        };
        this.eUP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kTF = j;
                }
            }
        };
        this.kUe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kTr != null && QuickVideoView.this.kTr.cVd() && QuickVideoView.this.kTr.cVe() && QuickVideoView.this.kTr.cVf() && QuickVideoView.this.kTi != null) {
                    int bnD = QuickVideoView.this.kTi.bnD();
                    int currentPosition = QuickVideoView.this.kTi.getCurrentPosition();
                    int duration = QuickVideoView.this.kTi.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kTJ;
                    boolean z = currentPosition + bnD < duration;
                    if (bnD < QuickVideoView.this.kTr.cVg() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kTJ = currentTimeMillis;
                        QuickVideoView.this.kTr.CL(0);
                    }
                    if (QuickVideoView.this.cVs() && currentPosition == QuickVideoView.this.kTK && j > 500) {
                        QuickVideoView.this.kTJ = currentTimeMillis;
                        QuickVideoView.this.kTr.CL(0);
                    }
                    QuickVideoView.this.kTK = currentPosition;
                    if (QuickVideoView.this.kTQ == QuickVideoView.kTO) {
                        QuickVideoView.this.cVt();
                    }
                }
            }
        };
        this.eUW = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kTr != null) {
                        QuickVideoView.this.kTr.zZ(QuickVideoView.this.kTD);
                    }
                    if (QuickVideoView.this.kTn != null) {
                        QuickVideoView.this.kTn.Ja(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kTn = null;
                    }
                    QuickVideoView.this.cVp();
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
        this.kTg = new RenderView(context);
        this.ajK = new WeakReference<>(TbadkCoreApplication.getInst());
        this.kTg.setSurfaceTextureListener(this.bIZ);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.kTy) {
            addView(this.kTg, layoutParams);
        } else {
            addView(this.kTg, 0, layoutParams);
        }
        if (kTl != null) {
            this.kTi = kTl.bnG();
        }
        if (this.kTi != null) {
            this.kTi.setOnPreparedListener(this.kUb);
            this.kTi.setOnCompletionListener(this.kUc);
            this.kTi.a(this.eUK);
            this.kTi.setOnSeekCompleteListener(this.kUd);
            this.kTi.a(this.eUL);
            this.kTi.a(this.eUN);
            this.kTi.a(this.eUO);
            this.kTi.a(this.eUP);
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
        this.kTz = new com.baidu.tieba.play.b.a(this);
        this.kTA = new q();
        this.kTB = new com.baidu.tieba.play.b.f();
        an.setBackgroundResource(this, R.color.black_alpha100);
        this.kTs = new com.baidu.tieba.k.k();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kTH = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kTD;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.kTs.cCN();
        this.ajO = str2;
        if (this.kTz != null) {
            this.kTz.clear();
            this.kTz.cWx();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Lg(str2);
            if (kTm != null) {
                this.kTn = kTm.au(this.ajO, str, "");
                if (this.kTn != null) {
                    this.kTn.a(-300, -44399, -44399, getLocateSource(), false, this.kTF, "");
                    this.kTn = null;
                }
            }
        }
        if (this.kTo != null) {
            this.kTo.a(null);
            this.kTo.cCq();
            this.kTo = null;
        }
        this.kTp = null;
        this.kTF = 0L;
        setVideoPath(str);
    }

    private String KY(String str) {
        if (!ar.isEmpty(str) && com.baidu.tieba.video.h.dmo().dmp()) {
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
        if (!ar.isEmpty(str)) {
            String KY = KY(str);
            this.kTC = KY;
            if (this.kTr != null) {
                KY = this.kTr.zU(KY);
                if (this.kTr.cVi() != null) {
                    this.kTr.cVi().setPlayer(this);
                }
                if (kTm != null && xP(KY)) {
                    this.kTo = kTm.Jf(KY);
                }
                if (this.kTo != null) {
                    this.kTo.a(new com.baidu.tieba.play.monitor.a(this.ajO, this.kTC, this.kTn));
                    this.kTo.cCp();
                }
                KZ(KY);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !xP(KY)) {
                if (this.eLe != null) {
                    this.eLe.onError(this.kTi, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cWb().Le(this.kTD);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(KY));
            if (this.kTn != null && x(Uri.parse(KY)) != null) {
                this.kTn.cCw();
            }
            this.kTD = str;
            int lastIndexOf = this.kTD.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.kTD.length() > 4) {
                this.kTE = this.kTD.substring(0, lastIndexOf + 4);
            } else {
                this.kTE = this.kTD;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVn() {
        if (com.baidu.tbadk.coreExtra.model.f.bcS()) {
            if (this.kTr != null && (this.kTr.cVc() || this.kTr.cVd())) {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kTY);
                com.baidu.adp.lib.f.e.lt().postDelayed(this.kTY, com.baidu.tbadk.coreExtra.model.f.bcR());
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kTZ);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.kTZ, com.baidu.tbadk.coreExtra.model.f.bcQ());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (x(uri) != null) {
            this.kTn.IZ(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aKF();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.kUa = false;
        if (this.kTx != null) {
            cVn();
            if (this.kTi != null) {
                if (!this.kTt) {
                    this.kTt = true;
                    this.kTi.a(this.mContext, this.mUri, this.mHeaders, this.kTx, this.mUri.getHost());
                } else if (!isPlaying() && this.kUb != null) {
                    this.kUa = true;
                    this.kUb.onPrepared(this.kTi);
                }
            }
        } else if (this.kTg != null && this.kTg.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.kTy) {
                addView(this.kTg, layoutParams);
            } else {
                addView(this.kTg, 0, layoutParams);
            }
        }
        an.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aKF() {
        this.kTt = false;
        this.kTq = false;
        if (this.kTi != null) {
            if (this.kTi.isPlaying() && cVu()) {
                x.cVW().bv(this.kTE, this.kTi.getCurrentPosition());
            }
            this.kTi.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUe);
    }

    private void KZ(String str) {
        this.kTS = 0;
        this.kTT = 0;
        this.kTU = 0;
        this.kTV = 0;
        this.kTW = 0;
        this.dxk = 0;
        if (this.kTr.cVd()) {
            this.kTR = kTM;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.kTT = (int) t.Lb(QuickVideoView.this.kTC);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.kTC != null && this.kTC.equals(str)) {
            this.kTR = kTL;
        } else {
            this.kTR = kTN;
        }
        this.kTQ = kTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVo() {
        this.kTQ = kTO;
        if (this.kTi != null) {
            this.kTS = this.kTi.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK(boolean z) {
        if (this.kTQ == kTO && this.kTi != null) {
            this.kTQ = kTP;
            this.kTV = this.kTi.getDuration();
            if (z) {
                this.kTW = 0;
                this.kTU = this.kTV;
            } else {
                this.kTU = this.kTi.getCurrentPosition();
                this.kTW = this.kTi.getCachedSize();
            }
            if (this.kTU > 0) {
                if (this.kTR == kTL) {
                    this.kTT = (int) t.Lb(this.kTC);
                    if (this.kTS > 0) {
                        long j = (this.kTS * (this.kTU / 1000)) / 8;
                        if (this.kTW < 0) {
                            this.kTW = 0;
                        }
                        long j2 = this.kTW + j;
                        if (this.kTT > 0) {
                            j2 += this.kTT;
                        }
                        setFlowCount(j2, this.kTU, this.kTV, this.dxk);
                    } else if (this.kTS == -1) {
                        this.kTS = 603327;
                        setFlowCount((this.kTS * (this.kTU / 1000)) / 8, this.kTU, this.kTV, this.dxk);
                    }
                } else if (this.kTR == kTM) {
                    if (this.kTS > 0) {
                        long j3 = (this.kTS * (this.kTU / 1000)) / 8;
                        if (this.kTW < 0) {
                            this.kTW = 0;
                        }
                        long j4 = this.kTW + j3;
                        if (this.kTT > 0) {
                            j4 -= this.kTT;
                        }
                        setFlowCount(j4, this.kTU, this.kTV, this.dxk);
                    } else if (this.kTS == -1) {
                        this.kTS = 603327;
                        setFlowCount((this.kTS * (this.kTU / 1000)) / 8, this.kTU, this.kTV, this.dxk);
                    }
                } else {
                    setFlowCount(0L, this.kTU, this.kTV, this.dxk);
                }
            }
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUe);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kTI) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            ag.a(this.ajK, false);
        }
        cVp();
        tK(false);
        if (this.kTz != null) {
            this.kTz.clear();
        }
        this.kTh = null;
        this.kTq = false;
        if (this.kTi != null) {
            if (this.kTi.isPlaying() && cVu()) {
                x.cVW().bv(this.kTE, this.kTi.getCurrentPosition());
            }
            this.kTi.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUe);
        this.dvZ = false;
        if (this.kTr != null) {
            this.kTr.cVb();
        }
        com.baidu.adp.lib.network.http.a.b.ld().a((b.InterfaceC0022b) null);
        if (this.kTn != null && this.kTn.Jc(getLocateSource())) {
            this.kTn = null;
        }
        if (this.kTs != null) {
            this.kTs.cCM();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUe);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ag.a(this.ajK, false);
        }
        cVp();
        tK(false);
        if (this.kTz != null) {
            this.kTz.clear();
        }
        this.kTh = null;
        aKF();
        TbVideoViewSet.cWb().Le(this.kTD);
        this.dvZ = false;
        if (this.kTr != null) {
            this.kTr.KX(this.kTD);
        }
        com.baidu.adp.lib.network.http.a.b.ld().a((b.InterfaceC0022b) null);
        if (this.kTn != null && this.kTn.Jc(getLocateSource())) {
            this.kTn = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUe);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.kTX = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVp() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kTY);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kTZ);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.eUJ = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.eUI = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.eLe = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0721g interfaceC0721g) {
        this.eUM = interfaceC0721g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cVq() {
        cVp();
        if (this.kTA != null) {
            this.kTA.onPrepared();
        }
        if (x(this.mUri) != null && this.kTi != null) {
            this.kTn.IZ(this.mUri.getPath());
            this.kTn.An(this.kTi.getPlayerType());
        }
        this.kTs.cCN();
        this.kTs.cCO();
        if (this.kTr != null) {
            long j = 0;
            if (this.kTi != null) {
                j = this.kTi.getDuration();
            }
            this.kTr.fm(j);
            cVo();
            if (getPlayerType() == -200) {
                this.kTr.cVh();
                cVt();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cVr() {
        if (x(this.mUri) != null && this.kTi != null) {
            this.kTn.IZ(this.mUri.getPath());
            this.kTn.cCw();
            this.kTn.Am(this.kTi.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String av(String str, String str2, String str3) {
        if (this.kTB == null) {
            return "";
        }
        String cWz = this.kTB.cWz();
        this.kTB.aw(str, str2, str3);
        return cWz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.kTr != null && !StringUtils.isNull(this.kTr.cVa())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Lf(uri);
                }
            }
            this.mUri = Uri.parse(this.kTr.cVa());
        }
        boolean z = false;
        if (this.kTz != null) {
            z = this.kTz.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.kTn != null) {
            this.kTp = this.kTn.a(i, i2, i3, getLocateSource(), z, this.kTF, av(this.kTn.cCC(), i3 + "", this.kTn.cCD()));
            this.kTn = null;
        }
        this.kTF = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.kTi != null) {
            try {
                if (this.kTi.isPlaying() && cVu()) {
                    x.cVW().bv(this.kTE, this.kTi.getCurrentPosition());
                }
                this.kTi.release();
                this.kTh = str;
                URI uri = new URI(this.mUri.toString());
                this.kTi.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.kTx, this.mUri.getHost());
                if (x(this.mUri) != null) {
                    this.kTn.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kTi != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.kTi.isPlaying() && cVu()) {
                x.cVW().bv(this.kTE, this.kTi.getCurrentPosition());
            }
            this.kTi.release();
            this.kTi.a(this.mContext, this.mUri, this.mHeaders, this.kTx, this.mUri.getHost());
            if (x(this.mUri) != null) {
                this.kTn.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kTi != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.kTi.forceUseSystemMediaPlayer(true);
            }
            if (this.kTi.isPlaying() && cVu()) {
                x.cVW().bv(this.kTE, this.kTi.getCurrentPosition());
            }
            this.kTi.release();
            this.kTi.a(this.mContext, this.mUri, this.mHeaders, this.kTx, this.mUri.getHost());
            if (x(this.mUri) != null) {
                this.kTn.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.kTq = true;
        if (this.kTi != null) {
            if (this.kTx != null && this.kTw && !this.kTi.isExistInRemote()) {
                this.kTi.a(this.mContext, this.mUri, this.mHeaders, this.kTx, this.kTv);
                if (this.kSM != null) {
                    this.kSM.cUX();
                }
                if (x(this.mUri) != null) {
                    this.kTn.cCy();
                }
                cVn();
                return;
            }
            if (!this.kTi.bnE()) {
                ag.a(this.ajK, true);
                this.kTi.setVolume(1.0f, 1.0f);
            }
            this.kTs.cCP();
            this.kTi.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.kTr != null) {
            this.kTr.onStart();
        }
        if (this.kTk != null) {
            this.kTk.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (x(this.mUri) != null && this.kTi != null) {
            this.kTn.Ao(this.kTi.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kTq) {
            b(aVar);
            return;
        }
        this.kTq = true;
        if (aVar != null) {
            this.kTI = true;
            if (!cVx()) {
                aVar.cWc();
            }
        } else {
            this.kTI = false;
        }
        setVideoPath(this.kTD, this.ajO);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cVp();
        ag.a(this.ajK, false);
        if (this.kTi != null) {
            if (this.kTi.isPlaying() && cVu()) {
                x.cVW().bv(this.kTE, this.kTi.getCurrentPosition());
            }
            this.kTi.pause();
        }
        if (this.kTr != null) {
            this.kTr.onPause();
        }
        this.kTq = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kTn != null) {
            this.kTn.cCB();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.kTi != null) {
            return this.kTi.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.kTi != null) {
            return this.kTi.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.dxk = i;
        CO(i);
    }

    public void CO(int i) {
        if (this.kTA != null) {
            this.kTA.cVH();
        }
        if (this.kTi != null) {
            this.kTi.seekTo(i);
        }
        if (this.kTr != null) {
            this.kTr.CL(0);
            cVt();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.kTi != null) {
            return this.kTi.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.kTi != null) {
            this.kTi.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.kTv = i;
    }

    public int getRecoveryState() {
        return this.kTv;
    }

    public void setNeedRecovery(boolean z) {
        this.kTw = z;
    }

    public void setLooping(boolean z) {
        this.dvZ = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cVs() {
        return this.kTq;
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
        this.eLi = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kTr = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eUW);
    }

    public void setMute(boolean z) {
        if (z) {
            this.kTi.setVolume(0.0f, 0.0f);
            ag.a(this.ajK, false);
            return;
        }
        ag.a(this.ajK, true);
        this.kTi.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dvZ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kTi != null) {
            this.kTi.bnF();
        }
        if (this.kTA != null) {
            this.kTA.Rw();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUe);
        MessageManager.getInstance().unRegisterListener(this.eUW);
        if (this.kTz != null) {
            this.kTz.clear();
        }
        if (this.kTo != null) {
            this.kTo.a(null);
            this.kTo.cCq();
        }
    }

    public g getPlayer() {
        return this.kTi;
    }

    public int getPlayerType() {
        if (this.kTi == null) {
            return -300;
        }
        return this.kTi.getPlayerType();
    }

    public void cVt() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUe);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kUe, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.kSM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.kTr instanceof n) || ((n) this.kTr).cVG() == null) {
            return "";
        }
        return ((n) this.kTr).kUq ? "v_mid_page" : ((n) this.kTr).cVG().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i x(Uri uri) {
        String uri2;
        if (this.kTn != null) {
            return this.kTn;
        }
        if (!StringUtils.isNull(this.kTC)) {
            uri2 = this.kTC;
        } else if (kTm != null && this.kTr != null && !StringUtils.isNull(this.kTr.cVa())) {
            uri2 = this.kTr.cVa();
        } else {
            uri2 = (kTm == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && kTm != null) {
            this.kTn = kTm.au(this.ajO, uri2, this.kTp);
        }
        this.kTp = null;
        this.kTF = 0L;
        return this.kTn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVu() {
        return this.kTi != null && this.kTi.getDuration() >= this.kTi.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.kTn, j, j2, j3, j4);
    }

    public static boolean xP(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cVv() {
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
            this.kTI = true;
            if (!cVx()) {
                aVar.cWc();
            }
            if (!cVw()) {
                aVar.cWd();
                this.kTq = true;
                setVideoPath(this.kTD, this.ajO);
                return;
            }
        } else {
            this.kTI = false;
        }
        start();
        if (this.kTi != null && this.kTI) {
            this.kTs.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVw() {
        return this == TbVideoViewSet.cWb().Ld(this.kTD);
    }

    private boolean cVx() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.eUI = null;
        this.eLe = null;
        this.eUL = null;
        this.kUb = null;
        this.kUd = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kTI = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kTj = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.kTi != null) {
            return this.kTi.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.kTi != null ? this.kTi.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void h(long j, long j2, long j3) {
        if (this.kTn != null) {
            this.kTn.h(j, j2, j3);
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public int getPcdnState() {
        return 0;
    }

    public void setVideoStatusListener(c cVar) {
        this.kTk = cVar;
    }
}
