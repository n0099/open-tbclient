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
    private static h efC;
    private static com.baidu.tieba.k.l efD;
    private static int jwS = 0;
    private static int jwT = 1;
    private static int jwU = 2;
    private static int jwV = 1;
    private static int jwW = 0;
    private WeakReference<Context> Pg;
    private String Pk;
    private TextureView.SurfaceTextureListener aYd;
    private g.b dMJ;
    private b dMN;
    private g.a dVF;
    private g.f dVG;
    private g.c dVH;
    private g.e dVI;
    private g.InterfaceC0591g dVJ;
    private g.i dVK;
    private g.d dVL;
    private g.h dVM;
    private final CustomMessageListener dVT;
    private int eaD;
    private g.f efE;
    private g.a efF;
    private g.InterfaceC0591g efI;
    private boolean efu;
    private a jvV;
    private boolean jwA;
    private int jwB;
    private int jwC;
    private boolean jwD;
    private SurfaceTexture jwE;
    private boolean jwF;
    private com.baidu.tieba.play.b.a jwG;
    private q jwH;
    private com.baidu.tieba.play.b.f jwI;
    private String jwJ;
    private String jwK;
    private String jwL;
    private long jwM;
    private boolean jwN;
    private boolean jwO;
    private boolean jwP;
    private long jwQ;
    private long jwR;
    private int jwX;
    private int jwY;
    private int jwZ;
    private RenderView jwp;
    private String jwq;
    private g jwr;
    private g.e jws;
    private c jwt;
    private com.baidu.tieba.k.i jwu;
    private com.baidu.tieba.k.e jwv;
    private String jww;
    private boolean jwx;
    private d jwy;
    private com.baidu.tieba.k.k jwz;
    private int jxa;
    private int jxb;
    private int jxc;
    private boolean jxd;
    private Runnable jxe;
    private Runnable jxf;
    public boolean jxg;
    private Runnable jxh;
    private int mBitRate;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cyN();
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
            efC = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            efD = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.jwF = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.jwx = false;
        this.jwA = false;
        this.jwB = 0;
        this.efu = false;
        this.jwC = -1;
        this.jwD = false;
        this.jwE = null;
        this.jwF = true;
        this.jwP = false;
        this.jwQ = 0L;
        this.jwR = 0L;
        this.jwX = jwW;
        this.jwY = 0;
        this.mBitRate = 0;
        this.jwZ = -1;
        this.jxa = 0;
        this.jxb = 0;
        this.jxc = 0;
        this.eaD = 0;
        this.jxd = false;
        this.Pg = null;
        this.jxe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jwr != null && QuickVideoView.this.jwx) {
                    QuickVideoView.this.b(QuickVideoView.this.jwr, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jxf = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.oX(false);
                }
            }
        };
        this.jxg = false;
        this.aYd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jxd) {
                    QuickVideoView.this.jxd = false;
                    if (QuickVideoView.this.jwr != null) {
                        QuickVideoView.this.jwr.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jwA || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jwr != null) {
                        if (QuickVideoView.this.czm()) {
                            QuickVideoView.this.jwr.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jwD) {
                            QuickVideoView.this.jwr.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jwC);
                            if (QuickVideoView.this.jvV != null) {
                                QuickVideoView.this.jvV.cyN();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jwu.chb();
                            }
                        }
                    }
                } else if (czp()) {
                    if (QuickVideoView.this.jwr != null) {
                        QuickVideoView.this.czd();
                        QuickVideoView.this.jwA = true;
                        QuickVideoView.this.jwr.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jwu.cha();
                    }
                }
                QuickVideoView.this.jwE = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jxd) {
                    QuickVideoView.this.czf();
                    QuickVideoView.this.rU(false);
                    if (QuickVideoView.this.jwr != null) {
                        if (QuickVideoView.this.jwr.isPlaying() && QuickVideoView.this.czk()) {
                            x.czM().bl(QuickVideoView.this.jwL, QuickVideoView.this.jwr.getCurrentPosition());
                            if (QuickVideoView.this.jwP) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jwP) {
                            QuickVideoView.this.jwr.release();
                        }
                    }
                    if (QuickVideoView.this.jwA) {
                        if (QuickVideoView.this.jwy != null && !QuickVideoView.this.jwP) {
                            QuickVideoView.this.jwy.GY(QuickVideoView.this.jwK);
                        }
                        if (QuickVideoView.this.dMN != null) {
                            QuickVideoView.this.dMN.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jwE = null;
                    if (QuickVideoView.this.jwu != null && QuickVideoView.this.jwu.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jwu = null;
                    }
                    if (!QuickVideoView.this.jwP) {
                        QuickVideoView.this.jwA = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean czp() {
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
        this.efE = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.czf();
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.onPrepared();
                }
                if (QuickVideoView.this.jwu != null && QuickVideoView.this.jwr != null) {
                    QuickVideoView.this.jwu.yp(QuickVideoView.this.jwr.getPlayerType());
                }
                if (QuickVideoView.this.jwP) {
                    TbVideoViewSet.czP().a(QuickVideoView.this, QuickVideoView.this.jwK);
                }
                if (QuickVideoView.this.dVG != null) {
                    QuickVideoView.this.jwz.chr();
                    QuickVideoView.this.dVG.onPrepared(gVar);
                }
                if (QuickVideoView.this.jwy != null) {
                    long j = 0;
                    if (QuickVideoView.this.jwr != null) {
                        j = QuickVideoView.this.jwr.getDuration();
                    }
                    QuickVideoView.this.jwy.ex(j);
                    QuickVideoView.this.cze();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jwy.cyX();
                        QuickVideoView.this.czj();
                    }
                }
                if (QuickVideoView.this.jwO && (Hd = x.czM().Hd(QuickVideoView.this.jwL)) > 0 && QuickVideoView.this.jwr != null) {
                    if (QuickVideoView.this.jwr.isPlayerReuse()) {
                        if (QuickVideoView.this.jwr.getCurrentPosition() == 0) {
                            QuickVideoView.this.AA(Hd);
                        }
                    } else {
                        QuickVideoView.this.AA(Hd);
                    }
                }
                if (QuickVideoView.this.jwx) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jwp != null && gVar != null) {
                    QuickVideoView.this.jwp.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jwB);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jwq) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jwq);
                }
                if (QuickVideoView.this.jwG != null && QuickVideoView.this.jwG.cAi()) {
                    com.baidu.tieba.play.b.e.AG(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efF = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rU(true);
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jwu = null;
                }
                if (!QuickVideoView.this.efu || QuickVideoView.this.jwy == null) {
                    if (QuickVideoView.this.jwy != null) {
                        QuickVideoView.this.jwy.onCompletion();
                    }
                    QuickVideoView.this.jwx = false;
                    x.czM().remove(QuickVideoView.this.jwL);
                    if (QuickVideoView.this.dVF != null) {
                        QuickVideoView.this.dVF.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jww = null;
                QuickVideoView.this.jwM = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jwy.cyQ());
                QuickVideoView.this.start();
            }
        };
        this.dVH = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.czf();
                if (QuickVideoView.this.jwy != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.czk()) {
                    QuickVideoView.this.jwN = true;
                    x.czM().bl(QuickVideoView.this.jwL, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czP().Hf(QuickVideoView.this.jwK);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jwu != null) {
                        QuickVideoView.this.jww = QuickVideoView.this.jwu.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jwM, QuickVideoView.this.aq(QuickVideoView.this.jwu.chf(), i3 + "", QuickVideoView.this.jwu.chg()));
                        QuickVideoView.this.jwu = null;
                    }
                    QuickVideoView.this.jwM = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.AE(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.AF(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMJ == null || QuickVideoView.this.dMJ.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.efI = new g.InterfaceC0591g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                if (QuickVideoView.this.jwN) {
                    QuickVideoView.this.jwN = false;
                    return;
                }
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.czy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jwy != null && z) {
                    QuickVideoView.this.jwy.onSeekComplete();
                }
                if (QuickVideoView.this.dVJ != null) {
                    QuickVideoView.this.dVJ.b(gVar);
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jws != null) {
                    QuickVideoView.this.jws.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jwB = i2;
                    if (QuickVideoView.this.jwp != null && gVar != null) {
                        QuickVideoView.this.jwp.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jwB);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jwz.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.a(i, i2, QuickVideoView.this.jwu);
                    return true;
                }
                return true;
            }
        };
        this.dVK = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.m(i, i2, str);
                }
            }
        };
        this.dVL = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.Fg(str);
                }
            }
        };
        this.dVM = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jwM = j;
                }
            }
        };
        this.jxh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jwy != null && QuickVideoView.this.jwy.cyT() && QuickVideoView.this.jwy.cyU() && QuickVideoView.this.jwy.cyV() && QuickVideoView.this.jwr != null) {
                    int aWL = QuickVideoView.this.jwr.aWL();
                    int currentPosition = QuickVideoView.this.jwr.getCurrentPosition();
                    int duration = QuickVideoView.this.jwr.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jwQ;
                    boolean z = currentPosition + aWL < duration;
                    if (aWL < QuickVideoView.this.jwy.cyW() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jwQ = currentTimeMillis;
                        QuickVideoView.this.jwy.Ax(0);
                    }
                    if (QuickVideoView.this.czi() && currentPosition == QuickVideoView.this.jwR && j > 500) {
                        QuickVideoView.this.jwQ = currentTimeMillis;
                        QuickVideoView.this.jwy.Ax(0);
                    }
                    QuickVideoView.this.jwR = currentPosition;
                    if (QuickVideoView.this.jwX == QuickVideoView.jwV) {
                        QuickVideoView.this.czj();
                    }
                }
            }
        };
        this.dVT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jwy != null) {
                        QuickVideoView.this.jwy.wK(QuickVideoView.this.jwK);
                    }
                    if (QuickVideoView.this.jwu != null) {
                        QuickVideoView.this.jwu.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jwu = null;
                    }
                    QuickVideoView.this.czf();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwx = false;
        this.jwA = false;
        this.jwB = 0;
        this.efu = false;
        this.jwC = -1;
        this.jwD = false;
        this.jwE = null;
        this.jwF = true;
        this.jwP = false;
        this.jwQ = 0L;
        this.jwR = 0L;
        this.jwX = jwW;
        this.jwY = 0;
        this.mBitRate = 0;
        this.jwZ = -1;
        this.jxa = 0;
        this.jxb = 0;
        this.jxc = 0;
        this.eaD = 0;
        this.jxd = false;
        this.Pg = null;
        this.jxe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jwr != null && QuickVideoView.this.jwx) {
                    QuickVideoView.this.b(QuickVideoView.this.jwr, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jxf = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.oX(false);
                }
            }
        };
        this.jxg = false;
        this.aYd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.jxd) {
                    QuickVideoView.this.jxd = false;
                    if (QuickVideoView.this.jwr != null) {
                        QuickVideoView.this.jwr.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jwA || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jwr != null) {
                        if (QuickVideoView.this.czm()) {
                            QuickVideoView.this.jwr.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jwD) {
                            QuickVideoView.this.jwr.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jwC);
                            if (QuickVideoView.this.jvV != null) {
                                QuickVideoView.this.jvV.cyN();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jwu.chb();
                            }
                        }
                    }
                } else if (czp()) {
                    if (QuickVideoView.this.jwr != null) {
                        QuickVideoView.this.czd();
                        QuickVideoView.this.jwA = true;
                        QuickVideoView.this.jwr.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jwu.cha();
                    }
                }
                QuickVideoView.this.jwE = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jxd) {
                    QuickVideoView.this.czf();
                    QuickVideoView.this.rU(false);
                    if (QuickVideoView.this.jwr != null) {
                        if (QuickVideoView.this.jwr.isPlaying() && QuickVideoView.this.czk()) {
                            x.czM().bl(QuickVideoView.this.jwL, QuickVideoView.this.jwr.getCurrentPosition());
                            if (QuickVideoView.this.jwP) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jwP) {
                            QuickVideoView.this.jwr.release();
                        }
                    }
                    if (QuickVideoView.this.jwA) {
                        if (QuickVideoView.this.jwy != null && !QuickVideoView.this.jwP) {
                            QuickVideoView.this.jwy.GY(QuickVideoView.this.jwK);
                        }
                        if (QuickVideoView.this.dMN != null) {
                            QuickVideoView.this.dMN.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jwE = null;
                    if (QuickVideoView.this.jwu != null && QuickVideoView.this.jwu.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jwu = null;
                    }
                    if (!QuickVideoView.this.jwP) {
                        QuickVideoView.this.jwA = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean czp() {
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
        this.efE = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.czf();
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.onPrepared();
                }
                if (QuickVideoView.this.jwu != null && QuickVideoView.this.jwr != null) {
                    QuickVideoView.this.jwu.yp(QuickVideoView.this.jwr.getPlayerType());
                }
                if (QuickVideoView.this.jwP) {
                    TbVideoViewSet.czP().a(QuickVideoView.this, QuickVideoView.this.jwK);
                }
                if (QuickVideoView.this.dVG != null) {
                    QuickVideoView.this.jwz.chr();
                    QuickVideoView.this.dVG.onPrepared(gVar);
                }
                if (QuickVideoView.this.jwy != null) {
                    long j = 0;
                    if (QuickVideoView.this.jwr != null) {
                        j = QuickVideoView.this.jwr.getDuration();
                    }
                    QuickVideoView.this.jwy.ex(j);
                    QuickVideoView.this.cze();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jwy.cyX();
                        QuickVideoView.this.czj();
                    }
                }
                if (QuickVideoView.this.jwO && (Hd = x.czM().Hd(QuickVideoView.this.jwL)) > 0 && QuickVideoView.this.jwr != null) {
                    if (QuickVideoView.this.jwr.isPlayerReuse()) {
                        if (QuickVideoView.this.jwr.getCurrentPosition() == 0) {
                            QuickVideoView.this.AA(Hd);
                        }
                    } else {
                        QuickVideoView.this.AA(Hd);
                    }
                }
                if (QuickVideoView.this.jwx) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jwp != null && gVar != null) {
                    QuickVideoView.this.jwp.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jwB);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jwq) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jwq);
                }
                if (QuickVideoView.this.jwG != null && QuickVideoView.this.jwG.cAi()) {
                    com.baidu.tieba.play.b.e.AG(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efF = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rU(true);
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jwu = null;
                }
                if (!QuickVideoView.this.efu || QuickVideoView.this.jwy == null) {
                    if (QuickVideoView.this.jwy != null) {
                        QuickVideoView.this.jwy.onCompletion();
                    }
                    QuickVideoView.this.jwx = false;
                    x.czM().remove(QuickVideoView.this.jwL);
                    if (QuickVideoView.this.dVF != null) {
                        QuickVideoView.this.dVF.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jww = null;
                QuickVideoView.this.jwM = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jwy.cyQ());
                QuickVideoView.this.start();
            }
        };
        this.dVH = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.X(i, i2, i3);
                QuickVideoView.this.czf();
                if (QuickVideoView.this.jwy != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.czk()) {
                    QuickVideoView.this.jwN = true;
                    x.czM().bl(QuickVideoView.this.jwL, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czP().Hf(QuickVideoView.this.jwK);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jwu != null) {
                        QuickVideoView.this.jww = QuickVideoView.this.jwu.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jwM, QuickVideoView.this.aq(QuickVideoView.this.jwu.chf(), i3 + "", QuickVideoView.this.jwu.chg()));
                        QuickVideoView.this.jwu = null;
                    }
                    QuickVideoView.this.jwM = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.AE(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.AF(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMJ == null || QuickVideoView.this.dMJ.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.efI = new g.InterfaceC0591g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                if (QuickVideoView.this.jwN) {
                    QuickVideoView.this.jwN = false;
                    return;
                }
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.czy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jwy != null && z) {
                    QuickVideoView.this.jwy.onSeekComplete();
                }
                if (QuickVideoView.this.dVJ != null) {
                    QuickVideoView.this.dVJ.b(gVar);
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jws != null) {
                    QuickVideoView.this.jws.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jwB = i2;
                    if (QuickVideoView.this.jwp != null && gVar != null) {
                        QuickVideoView.this.jwp.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jwB);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jwz.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.a(i, i2, QuickVideoView.this.jwu);
                    return true;
                }
                return true;
            }
        };
        this.dVK = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.m(i, i2, str);
                }
            }
        };
        this.dVL = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.Fg(str);
                }
            }
        };
        this.dVM = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jwM = j;
                }
            }
        };
        this.jxh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jwy != null && QuickVideoView.this.jwy.cyT() && QuickVideoView.this.jwy.cyU() && QuickVideoView.this.jwy.cyV() && QuickVideoView.this.jwr != null) {
                    int aWL = QuickVideoView.this.jwr.aWL();
                    int currentPosition = QuickVideoView.this.jwr.getCurrentPosition();
                    int duration = QuickVideoView.this.jwr.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jwQ;
                    boolean z = currentPosition + aWL < duration;
                    if (aWL < QuickVideoView.this.jwy.cyW() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jwQ = currentTimeMillis;
                        QuickVideoView.this.jwy.Ax(0);
                    }
                    if (QuickVideoView.this.czi() && currentPosition == QuickVideoView.this.jwR && j > 500) {
                        QuickVideoView.this.jwQ = currentTimeMillis;
                        QuickVideoView.this.jwy.Ax(0);
                    }
                    QuickVideoView.this.jwR = currentPosition;
                    if (QuickVideoView.this.jwX == QuickVideoView.jwV) {
                        QuickVideoView.this.czj();
                    }
                }
            }
        };
        this.dVT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jwy != null) {
                        QuickVideoView.this.jwy.wK(QuickVideoView.this.jwK);
                    }
                    if (QuickVideoView.this.jwu != null) {
                        QuickVideoView.this.jwu.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jwu = null;
                    }
                    QuickVideoView.this.czf();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwx = false;
        this.jwA = false;
        this.jwB = 0;
        this.efu = false;
        this.jwC = -1;
        this.jwD = false;
        this.jwE = null;
        this.jwF = true;
        this.jwP = false;
        this.jwQ = 0L;
        this.jwR = 0L;
        this.jwX = jwW;
        this.jwY = 0;
        this.mBitRate = 0;
        this.jwZ = -1;
        this.jxa = 0;
        this.jxb = 0;
        this.jxc = 0;
        this.eaD = 0;
        this.jxd = false;
        this.Pg = null;
        this.jxe = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jwr != null && QuickVideoView.this.jwx) {
                    QuickVideoView.this.b(QuickVideoView.this.jwr, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.jxf = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.oX(false);
                }
            }
        };
        this.jxg = false;
        this.aYd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.jxd) {
                    QuickVideoView.this.jxd = false;
                    if (QuickVideoView.this.jwr != null) {
                        QuickVideoView.this.jwr.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jwA || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jwr != null) {
                        if (QuickVideoView.this.czm()) {
                            QuickVideoView.this.jwr.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jwD) {
                            QuickVideoView.this.jwr.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jwC);
                            if (QuickVideoView.this.jvV != null) {
                                QuickVideoView.this.jvV.cyN();
                            }
                            if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jwu.chb();
                            }
                        }
                    }
                } else if (czp()) {
                    if (QuickVideoView.this.jwr != null) {
                        QuickVideoView.this.czd();
                        QuickVideoView.this.jwA = true;
                        QuickVideoView.this.jwr.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.u(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jwu.cha();
                    }
                }
                QuickVideoView.this.jwE = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.jxd) {
                    QuickVideoView.this.czf();
                    QuickVideoView.this.rU(false);
                    if (QuickVideoView.this.jwr != null) {
                        if (QuickVideoView.this.jwr.isPlaying() && QuickVideoView.this.czk()) {
                            x.czM().bl(QuickVideoView.this.jwL, QuickVideoView.this.jwr.getCurrentPosition());
                            if (QuickVideoView.this.jwP) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.jwP) {
                            QuickVideoView.this.jwr.release();
                        }
                    }
                    if (QuickVideoView.this.jwA) {
                        if (QuickVideoView.this.jwy != null && !QuickVideoView.this.jwP) {
                            QuickVideoView.this.jwy.GY(QuickVideoView.this.jwK);
                        }
                        if (QuickVideoView.this.dMN != null) {
                            QuickVideoView.this.dMN.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jwE = null;
                    if (QuickVideoView.this.jwu != null && QuickVideoView.this.jwu.Ff(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jwu = null;
                    }
                    if (!QuickVideoView.this.jwP) {
                        QuickVideoView.this.jwA = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean czp() {
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
        this.efE = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int Hd;
                QuickVideoView.this.czf();
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.onPrepared();
                }
                if (QuickVideoView.this.jwu != null && QuickVideoView.this.jwr != null) {
                    QuickVideoView.this.jwu.yp(QuickVideoView.this.jwr.getPlayerType());
                }
                if (QuickVideoView.this.jwP) {
                    TbVideoViewSet.czP().a(QuickVideoView.this, QuickVideoView.this.jwK);
                }
                if (QuickVideoView.this.dVG != null) {
                    QuickVideoView.this.jwz.chr();
                    QuickVideoView.this.dVG.onPrepared(gVar);
                }
                if (QuickVideoView.this.jwy != null) {
                    long j = 0;
                    if (QuickVideoView.this.jwr != null) {
                        j = QuickVideoView.this.jwr.getDuration();
                    }
                    QuickVideoView.this.jwy.ex(j);
                    QuickVideoView.this.cze();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jwy.cyX();
                        QuickVideoView.this.czj();
                    }
                }
                if (QuickVideoView.this.jwO && (Hd = x.czM().Hd(QuickVideoView.this.jwL)) > 0 && QuickVideoView.this.jwr != null) {
                    if (QuickVideoView.this.jwr.isPlayerReuse()) {
                        if (QuickVideoView.this.jwr.getCurrentPosition() == 0) {
                            QuickVideoView.this.AA(Hd);
                        }
                    } else {
                        QuickVideoView.this.AA(Hd);
                    }
                }
                if (QuickVideoView.this.jwx) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jwp != null && gVar != null) {
                    QuickVideoView.this.jwp.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jwB);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jwq) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jwq);
                }
                if (QuickVideoView.this.jwG != null && QuickVideoView.this.jwG.cAi()) {
                    com.baidu.tieba.play.b.e.AG(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.efF = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rU(true);
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.Fe(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jwu = null;
                }
                if (!QuickVideoView.this.efu || QuickVideoView.this.jwy == null) {
                    if (QuickVideoView.this.jwy != null) {
                        QuickVideoView.this.jwy.onCompletion();
                    }
                    QuickVideoView.this.jwx = false;
                    x.czM().remove(QuickVideoView.this.jwL);
                    if (QuickVideoView.this.dVF != null) {
                        QuickVideoView.this.dVF.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jww = null;
                QuickVideoView.this.jwM = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jwy.cyQ());
                QuickVideoView.this.start();
            }
        };
        this.dVH = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.X(i2, i22, i3);
                QuickVideoView.this.czf();
                if (QuickVideoView.this.jwy != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.czk()) {
                    QuickVideoView.this.jwN = true;
                    x.czM().bl(QuickVideoView.this.jwL, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.czP().Hf(QuickVideoView.this.jwK);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jwu != null) {
                        QuickVideoView.this.jww = QuickVideoView.this.jwu.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jwM, QuickVideoView.this.aq(QuickVideoView.this.jwu.chf(), i3 + "", QuickVideoView.this.jwu.chg()));
                        QuickVideoView.this.jwu = null;
                    }
                    QuickVideoView.this.jwM = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.AE(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.AF(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dMJ == null || QuickVideoView.this.dMJ.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.efI = new g.InterfaceC0591g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                if (QuickVideoView.this.jwN) {
                    QuickVideoView.this.jwN = false;
                    return;
                }
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.czy();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jwy != null && z) {
                    QuickVideoView.this.jwy.onSeekComplete();
                }
                if (QuickVideoView.this.dVJ != null) {
                    QuickVideoView.this.dVJ.b(gVar);
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.jws != null) {
                    QuickVideoView.this.jws.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.jwB = i22;
                    if (QuickVideoView.this.jwp != null && gVar != null) {
                        QuickVideoView.this.jwp.W(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jwB);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.jwz.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.jwH != null) {
                    QuickVideoView.this.jwH.a(i2, i22, QuickVideoView.this.jwu);
                    return true;
                }
                return true;
            }
        };
        this.dVK = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.m(i2, i22, str);
                }
            }
        };
        this.dVL = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jwu != null) {
                    QuickVideoView.this.jwu.Fg(str);
                }
            }
        };
        this.dVM = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jwM = j;
                }
            }
        };
        this.jxh = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jwy != null && QuickVideoView.this.jwy.cyT() && QuickVideoView.this.jwy.cyU() && QuickVideoView.this.jwy.cyV() && QuickVideoView.this.jwr != null) {
                    int aWL = QuickVideoView.this.jwr.aWL();
                    int currentPosition = QuickVideoView.this.jwr.getCurrentPosition();
                    int duration = QuickVideoView.this.jwr.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jwQ;
                    boolean z = currentPosition + aWL < duration;
                    if (aWL < QuickVideoView.this.jwy.cyW() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jwQ = currentTimeMillis;
                        QuickVideoView.this.jwy.Ax(0);
                    }
                    if (QuickVideoView.this.czi() && currentPosition == QuickVideoView.this.jwR && j > 500) {
                        QuickVideoView.this.jwQ = currentTimeMillis;
                        QuickVideoView.this.jwy.Ax(0);
                    }
                    QuickVideoView.this.jwR = currentPosition;
                    if (QuickVideoView.this.jwX == QuickVideoView.jwV) {
                        QuickVideoView.this.czj();
                    }
                }
            }
        };
        this.dVT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jwy != null) {
                        QuickVideoView.this.jwy.wK(QuickVideoView.this.jwK);
                    }
                    if (QuickVideoView.this.jwu != null) {
                        QuickVideoView.this.jwu.Fd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jwu = null;
                    }
                    QuickVideoView.this.czf();
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
        this.jwp = new RenderView(context);
        this.Pg = new WeakReference<>(TbadkCoreApplication.getInst());
        this.jwp.setSurfaceTextureListener(this.aYd);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.jwF) {
            addView(this.jwp, layoutParams);
        } else {
            addView(this.jwp, 0, layoutParams);
        }
        if (efC != null) {
            this.jwr = efC.aWO();
        }
        if (this.jwr != null) {
            this.jwr.setOnPreparedListener(this.efE);
            this.jwr.setOnCompletionListener(this.efF);
            this.jwr.a(this.dVH);
            this.jwr.setOnSeekCompleteListener(this.efI);
            this.jwr.a(this.dVI);
            this.jwr.a(this.dVK);
            this.jwr.a(this.dVL);
            this.jwr.a(this.dVM);
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
        this.jwG = new com.baidu.tieba.play.b.a(this);
        this.jwH = new q();
        this.jwI = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.jwz = new com.baidu.tieba.k.k();
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
        this.jwO = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.jwK;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.jwz.chq();
        this.Pk = str2;
        if (this.jwG != null) {
            this.jwG.clear();
            this.jwG.cAi();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.Hh(str2);
            if (efD != null) {
                this.jwu = efD.ap(this.Pk, str, "");
                if (this.jwu != null) {
                    this.jwu.a(-300, -44399, -44399, getLocateSource(), false, this.jwM, "");
                    this.jwu = null;
                }
            }
        }
        if (this.jwv != null) {
            this.jwv.a(null);
            this.jwv.cgT();
            this.jwv = null;
        }
        this.jww = null;
        this.jwM = 0L;
        setVideoPath(str);
    }

    private String GZ(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cPC().cPD()) {
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
            String GZ = GZ(str);
            this.jwJ = GZ;
            if (this.jwy != null) {
                GZ = this.jwy.wF(GZ);
                if (this.jwy.cyY() != null) {
                    this.jwy.cyY().setPlayer(this);
                }
                if (efD != null && uy(GZ)) {
                    this.jwv = efD.Fi(GZ);
                }
                if (this.jwv != null) {
                    this.jwv.a(new com.baidu.tieba.play.monitor.a(this.Pk, this.jwJ, this.jwu));
                    this.jwv.cgS();
                }
                Ha(GZ);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !uy(GZ)) {
                if (this.dMJ != null) {
                    this.dMJ.onError(this.jwr, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.czP().Hf(this.jwK);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(GZ));
            if (this.jwu != null && u(Uri.parse(GZ)) != null) {
                this.jwu.cgZ();
            }
            this.jwK = str;
            int lastIndexOf = this.jwK.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.jwK.length() > 4) {
                this.jwL = this.jwK.substring(0, lastIndexOf + 4);
            } else {
                this.jwL = this.jwK;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czd() {
        if (com.baidu.tbadk.coreExtra.model.f.aMk()) {
            if (this.jwy != null && (this.jwy.cyS() || this.jwy.cyT())) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxe);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.jxe, com.baidu.tbadk.coreExtra.model.f.aMj());
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxf);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jxf, com.baidu.tbadk.coreExtra.model.f.aMi());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (u(uri) != null) {
            this.jwu.Fc(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aWH();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.jxg = false;
        if (this.jwE != null) {
            czd();
            if (this.jwr != null) {
                if (!this.jwA) {
                    this.jwA = true;
                    this.jwr.a(this.mContext, this.mUri, this.mHeaders, this.jwE, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying() && this.efE != null) {
                    this.jxg = true;
                    this.efE.onPrepared(this.jwr);
                }
            }
        } else if (this.jwp != null && this.jwp.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.jwF) {
                addView(this.jwp, layoutParams);
            } else {
                addView(this.jwp, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aWH() {
        this.jwA = false;
        this.jwx = false;
        if (this.jwr != null) {
            if (this.jwr.isPlaying() && czk()) {
                x.czM().bl(this.jwL, this.jwr.getCurrentPosition());
            }
            this.jwr.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxh);
    }

    private void Ha(String str) {
        this.mBitRate = 0;
        this.jwZ = 0;
        this.jxa = 0;
        this.jxb = 0;
        this.jxc = 0;
        this.eaD = 0;
        if (this.jwy.cyT()) {
            this.jwY = jwT;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.jwZ = (int) t.Hc(QuickVideoView.this.jwJ);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.jwJ != null && this.jwJ.equals(str)) {
            this.jwY = jwS;
        } else {
            this.jwY = jwU;
        }
        this.jwX = jwV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cze() {
        this.jwX = jwV;
        if (this.jwr != null) {
            this.mBitRate = this.jwr.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU(boolean z) {
        if (this.jwX == jwV && this.jwr != null) {
            this.jwX = jwW;
            this.jxb = this.jwr.getDuration();
            if (z) {
                this.jxc = 0;
                this.jxa = this.jxb;
            } else {
                this.jxa = this.jwr.getCurrentPosition();
                this.jxc = this.jwr.getCachedSize();
            }
            if (this.jxa > 0) {
                if (this.jwY == jwS) {
                    this.jwZ = (int) t.Hc(this.jwJ);
                    if (this.mBitRate > 0) {
                        long j = (this.mBitRate * (this.jxa / 1000)) / 8;
                        if (this.jxc < 0) {
                            this.jxc = 0;
                        }
                        long j2 = this.jxc + j;
                        if (this.jwZ > 0) {
                            j2 += this.jwZ;
                        }
                        setFlowCount(j2, this.jxa, this.jxb, this.eaD);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jxa / 1000)) / 8, this.jxa, this.jxb, this.eaD);
                    }
                } else if (this.jwY == jwT) {
                    if (this.mBitRate > 0) {
                        long j3 = (this.mBitRate * (this.jxa / 1000)) / 8;
                        if (this.jxc < 0) {
                            this.jxc = 0;
                        }
                        long j4 = this.jxc + j3;
                        if (this.jwZ > 0) {
                            j4 -= this.jwZ;
                        }
                        setFlowCount(j4, this.jxa, this.jxb, this.eaD);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jxa / 1000)) / 8, this.jxa, this.jxb, this.eaD);
                    }
                } else {
                    setFlowCount(0L, this.jxa, this.jxb, this.eaD);
                }
            }
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxh);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.jwP) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pg, false);
        }
        czf();
        rU(false);
        if (this.jwG != null) {
            this.jwG.clear();
        }
        this.jwq = null;
        this.jwx = false;
        if (this.jwr != null) {
            if (this.jwr.isPlaying() && czk()) {
                x.czM().bl(this.jwL, this.jwr.getCurrentPosition());
            }
            this.jwr.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxh);
        this.efu = false;
        if (this.jwy != null) {
            this.jwy.cyR();
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.jwu != null && this.jwu.Ff(getLocateSource())) {
            this.jwu = null;
        }
        if (this.jwz != null) {
            this.jwz.chp();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxh);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.Pg, false);
        }
        czf();
        rU(false);
        if (this.jwG != null) {
            this.jwG.clear();
        }
        this.jwq = null;
        aWH();
        TbVideoViewSet.czP().Hf(this.jwK);
        this.efu = false;
        if (this.jwy != null) {
            this.jwy.GY(this.jwK);
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.jwu != null && this.jwu.Ff(getLocateSource())) {
            this.jwu = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxh);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.jxd = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czf() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxe);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxf);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.dVG = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.dVF = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.dMJ = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0591g interfaceC0591g) {
        this.dVJ = interfaceC0591g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void czg() {
        czf();
        if (this.jwH != null) {
            this.jwH.onPrepared();
        }
        if (u(this.mUri) != null && this.jwr != null) {
            this.jwu.Fc(this.mUri.getPath());
            this.jwu.yq(this.jwr.getPlayerType());
        }
        this.jwz.chq();
        this.jwz.chr();
        if (this.jwy != null) {
            long j = 0;
            if (this.jwr != null) {
                j = this.jwr.getDuration();
            }
            this.jwy.ex(j);
            cze();
            if (getPlayerType() == -200) {
                this.jwy.cyX();
                czj();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void czh() {
        if (u(this.mUri) != null && this.jwr != null) {
            this.jwu.Fc(this.mUri.getPath());
            this.jwu.cgZ();
            this.jwu.yp(this.jwr.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.jwI == null) {
            return "";
        }
        String cAk = this.jwI.cAk();
        this.jwI.ar(str, str2, str3);
        return cAk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.jwy != null && !StringUtils.isNull(this.jwy.cyQ())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.Hg(uri);
                }
            }
            this.mUri = Uri.parse(this.jwy.cyQ());
        }
        boolean z = false;
        if (this.jwG != null) {
            z = this.jwG.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.jwu != null) {
            this.jww = this.jwu.a(i, i2, i3, getLocateSource(), z, this.jwM, aq(this.jwu.chf(), i3 + "", this.jwu.chg()));
            this.jwu = null;
        }
        this.jwM = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.jwr != null) {
            try {
                if (this.jwr.isPlaying() && czk()) {
                    x.czM().bl(this.jwL, this.jwr.getCurrentPosition());
                }
                this.jwr.release();
                this.jwq = str;
                URI uri = new URI(this.mUri.toString());
                this.jwr.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.jwE, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (u(this.mUri) != null) {
                    this.jwu.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jwr != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.jwr.isPlaying() && czk()) {
                x.czM().bl(this.jwL, this.jwr.getCurrentPosition());
            }
            this.jwr.release();
            this.jwr.a(this.mContext, this.mUri, this.mHeaders, this.jwE, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.jwu.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jwr != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.jwr.forceUseSystemMediaPlayer(true);
            }
            if (this.jwr.isPlaying() && czk()) {
                x.czM().bl(this.jwL, this.jwr.getCurrentPosition());
            }
            this.jwr.release();
            this.jwr.a(this.mContext, this.mUri, this.mHeaders, this.jwE, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (u(this.mUri) != null) {
                this.jwu.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.jwx = true;
        if (this.jwr != null) {
            if (this.jwE != null && this.jwD && !this.jwr.isExistInRemote()) {
                this.jwr.a(this.mContext, this.mUri, this.mHeaders, this.jwE, this.jwC);
                if (this.jvV != null) {
                    this.jvV.cyN();
                }
                if (u(this.mUri) != null) {
                    this.jwu.chb();
                }
                czd();
                return;
            }
            if (!this.jwr.aWM()) {
                af.a(this.Pg, true);
                this.jwr.setVolume(1.0f, 1.0f);
            }
            this.jwz.chs();
            this.jwr.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.jwy != null) {
            this.jwy.onStart();
        }
        if (this.jwt != null) {
            this.jwt.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (u(this.mUri) != null && this.jwr != null) {
            this.jwu.yr(this.jwr.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jwx) {
            b(aVar);
            return;
        }
        this.jwx = true;
        if (aVar != null) {
            this.jwP = true;
            if (!czn()) {
                aVar.czQ();
            }
        } else {
            this.jwP = false;
        }
        setVideoPath(this.jwK, this.Pk);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        czf();
        af.a(this.Pg, false);
        if (this.jwr != null) {
            if (this.jwr.isPlaying() && czk()) {
                x.czM().bl(this.jwL, this.jwr.getCurrentPosition());
            }
            this.jwr.pause();
        }
        if (this.jwy != null) {
            this.jwy.onPause();
        }
        this.jwx = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jwu != null) {
            this.jwu.che();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.jwr != null) {
            return this.jwr.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.jwr != null) {
            return this.jwr.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.eaD = i;
        AA(i);
    }

    public void AA(int i) {
        if (this.jwH != null) {
            this.jwH.czx();
        }
        if (this.jwr != null) {
            this.jwr.seekTo(i);
        }
        if (this.jwy != null) {
            this.jwy.Ax(0);
            czj();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.jwr != null) {
            return this.jwr.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.jwr != null) {
            this.jwr.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.jwC = i;
    }

    public int getRecoveryState() {
        return this.jwC;
    }

    public void setNeedRecovery(boolean z) {
        this.jwD = z;
    }

    public void setLooping(boolean z) {
        this.efu = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean czi() {
        return this.jwx;
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
        this.dMN = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.jwy = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVT);
    }

    public void setMute(boolean z) {
        if (z) {
            this.jwr.setVolume(0.0f, 0.0f);
            af.a(this.Pg, false);
            return;
        }
        af.a(this.Pg, true);
        this.jwr.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.efu = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jwr != null) {
            this.jwr.aWN();
        }
        if (this.jwH != null) {
            this.jwH.Gr();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxh);
        MessageManager.getInstance().unRegisterListener(this.dVT);
        if (this.jwG != null) {
            this.jwG.clear();
        }
        if (this.jwv != null) {
            this.jwv.a(null);
            this.jwv.cgT();
        }
    }

    public g getPlayer() {
        return this.jwr;
    }

    public int getPlayerType() {
        if (this.jwr == null) {
            return -300;
        }
        return this.jwr.getPlayerType();
    }

    public void czj() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxh);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jxh, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.jvV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.jwy instanceof n) || ((n) this.jwy).czw() == null) {
            return "";
        }
        return ((n) this.jwy).jxt ? "v_mid_page" : ((n) this.jwy).czw().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i u(Uri uri) {
        String uri2;
        if (this.jwu != null) {
            return this.jwu;
        }
        if (!StringUtils.isNull(this.jwJ)) {
            uri2 = this.jwJ;
        } else if (efD != null && this.jwy != null && !StringUtils.isNull(this.jwy.cyQ())) {
            uri2 = this.jwy.cyQ();
        } else {
            uri2 = (efD == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && efD != null) {
            this.jwu = efD.ap(this.Pk, uri2, this.jww);
        }
        this.jww = null;
        this.jwM = 0L;
        return this.jwu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czk() {
        return this.jwr != null && this.jwr.getDuration() >= this.jwr.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.jwu, j, j2, j3, j4);
    }

    public static boolean uy(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void czl() {
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
            this.jwP = true;
            if (!czn()) {
                aVar.czQ();
            }
            if (!czm()) {
                aVar.czR();
                this.jwx = true;
                setVideoPath(this.jwK, this.Pk);
                return;
            }
        } else {
            this.jwP = false;
        }
        start();
        if (this.jwr != null && this.jwP) {
            this.jwz.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czm() {
        return this == TbVideoViewSet.czP().He(this.jwK);
    }

    private boolean czn() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.dVF = null;
        this.dMJ = null;
        this.dVI = null;
        this.efE = null;
        this.efI = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.jwP = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jws = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.jwr != null) {
            return this.jwr.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.jwr != null ? this.jwr.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.jwu != null) {
            this.jwu.e(j, j2, j3);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.jwt = cVar;
    }
}
