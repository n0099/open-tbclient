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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
    private static int kyI = 0;
    private static int kyJ = 1;
    private static int kyK = 2;
    private static int kyL = 1;
    private static int kyM = 0;
    private static h kyi;
    private static com.baidu.tieba.k.l kyj;
    private WeakReference<Context> aio;
    private String ais;
    private TextureView.SurfaceTextureListener bEl;
    private boolean drn;
    private int dsA;
    private g.b eBk;
    private b eBo;
    private g.a eKl;
    private g.f eKm;
    private g.c eKn;
    private g.e eKo;
    private g.InterfaceC0704g eKp;
    private g.i eKq;
    private g.d eKr;
    private g.h eKs;
    private final CustomMessageListener eKz;
    private a kxJ;
    private String kyA;
    private String kyB;
    private long kyC;
    private boolean kyD;
    private boolean kyE;
    private boolean kyF;
    private long kyG;
    private long kyH;
    private int kyN;
    private int kyO;
    private int kyP;
    private int kyQ;
    private int kyR;
    private int kyS;
    private int kyT;
    private boolean kyU;
    private Runnable kyV;
    private Runnable kyW;
    public boolean kyX;
    private g.f kyY;
    private g.a kyZ;
    private RenderView kyd;
    private String kye;
    private g kyf;
    private g.e kyg;
    private c kyh;
    private com.baidu.tieba.k.i kyk;
    private com.baidu.tieba.k.e kyl;
    private String kym;
    private boolean kyn;
    private d kyo;
    private com.baidu.tieba.k.k kyp;
    private boolean kyq;
    private int kyr;
    private int kys;
    private boolean kyt;
    private SurfaceTexture kyu;
    private boolean kyv;
    private com.baidu.tieba.play.b.a kyw;
    private q kyx;
    private com.baidu.tieba.play.b.f kyy;
    private String kyz;
    private g.InterfaceC0704g kza;
    private Runnable kzb;
    private Context mContext;
    private Map<String, String> mHeaders;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cQp();
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
            kyi = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        if (runTask2 != null) {
            kyj = (com.baidu.tieba.k.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.kyv = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.kyn = false;
        this.kyq = false;
        this.kyr = 0;
        this.drn = false;
        this.kys = -1;
        this.kyt = false;
        this.kyu = null;
        this.kyv = true;
        this.kyF = false;
        this.kyG = 0L;
        this.kyH = 0L;
        this.kyN = kyM;
        this.kyO = 0;
        this.kyP = 0;
        this.kyQ = -1;
        this.kyR = 0;
        this.kyS = 0;
        this.kyT = 0;
        this.dsA = 0;
        this.kyU = false;
        this.aio = null;
        this.kyV = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kyf != null && QuickVideoView.this.kyn) {
                    QuickVideoView.this.b(QuickVideoView.this.kyf, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kyW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.qy(false);
                }
            }
        };
        this.kyX = false;
        this.bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kyU) {
                    QuickVideoView.this.kyU = false;
                    if (QuickVideoView.this.kyf != null) {
                        QuickVideoView.this.kyf.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kyq || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kyf != null) {
                        if (QuickVideoView.this.cQO()) {
                            QuickVideoView.this.kyf.d(surfaceTexture);
                        } else if (QuickVideoView.this.kyt) {
                            QuickVideoView.this.kyf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kys);
                            if (QuickVideoView.this.kxJ != null) {
                                QuickVideoView.this.kxJ.cQp();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kyk.cyj();
                            }
                        }
                    }
                } else if (cQR()) {
                    if (QuickVideoView.this.kyf != null) {
                        QuickVideoView.this.cQF();
                        QuickVideoView.this.kyq = true;
                        QuickVideoView.this.kyf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kyk.cyi();
                    }
                }
                QuickVideoView.this.kyu = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kyU) {
                    QuickVideoView.this.cQH();
                    QuickVideoView.this.tw(false);
                    if (QuickVideoView.this.kyf != null) {
                        if (QuickVideoView.this.kyf.isPlaying() && QuickVideoView.this.cQM()) {
                            x.cRo().bw(QuickVideoView.this.kyB, QuickVideoView.this.kyf.getCurrentPosition());
                            if (QuickVideoView.this.kyF) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kyF) {
                            QuickVideoView.this.kyf.release();
                        }
                    }
                    if (QuickVideoView.this.kyq) {
                        if (QuickVideoView.this.kyo != null && !QuickVideoView.this.kyF) {
                            QuickVideoView.this.kyo.Kv(QuickVideoView.this.kyA);
                        }
                        if (QuickVideoView.this.eBo != null) {
                            QuickVideoView.this.eBo.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kyu = null;
                    if (QuickVideoView.this.kyk != null && QuickVideoView.this.kyk.Iz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kyk = null;
                    }
                    if (!QuickVideoView.this.kyF) {
                        QuickVideoView.this.kyq = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cQR() {
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
        this.kyY = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int KA;
                QuickVideoView.this.cQH();
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.onPrepared();
                }
                if (QuickVideoView.this.kyk != null && QuickVideoView.this.kyf != null) {
                    QuickVideoView.this.kyk.zy(QuickVideoView.this.kyf.getPlayerType());
                }
                if (QuickVideoView.this.kyF) {
                    TbVideoViewSet.cRt().a(QuickVideoView.this, QuickVideoView.this.kyA);
                }
                if (QuickVideoView.this.eKm != null) {
                    QuickVideoView.this.kyp.cyz();
                    QuickVideoView.this.eKm.onPrepared(gVar);
                }
                if (QuickVideoView.this.kyo != null) {
                    long j = 0;
                    if (QuickVideoView.this.kyf != null) {
                        j = QuickVideoView.this.kyf.getDuration();
                    }
                    QuickVideoView.this.kyo.fj(j);
                    QuickVideoView.this.cQG();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kyo.cQz();
                        QuickVideoView.this.cQL();
                    }
                }
                if (QuickVideoView.this.kyE && (KA = x.cRo().KA(QuickVideoView.this.kyB)) > 0 && QuickVideoView.this.kyf != null && QuickVideoView.this.kyf.getCurrentPosition() == 0) {
                    QuickVideoView.this.BK(KA);
                }
                if (QuickVideoView.this.kyn) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kyd != null && gVar != null) {
                    QuickVideoView.this.kyd.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kyr);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kye) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kye);
                }
                if (QuickVideoView.this.kyw != null && QuickVideoView.this.kyw.cRQ()) {
                    com.baidu.tieba.play.b.e.BQ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kyZ = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tw(true);
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.Iy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kyk = null;
                }
                if (!QuickVideoView.this.drn || QuickVideoView.this.kyo == null) {
                    if (QuickVideoView.this.kyo != null) {
                        QuickVideoView.this.kyo.onCompletion();
                    }
                    QuickVideoView.this.kyn = false;
                    x.cRo().remove(QuickVideoView.this.kyB);
                    if (QuickVideoView.this.eKl != null) {
                        QuickVideoView.this.eKl.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kym = null;
                QuickVideoView.this.kyC = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kyo.cQs());
                QuickVideoView.this.start();
            }
        };
        this.eKn = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cQH();
                if (QuickVideoView.this.kyo != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cQM()) {
                    QuickVideoView.this.kyD = true;
                    x.cRo().bw(QuickVideoView.this.kyB, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRt().KC(QuickVideoView.this.kyA);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kyk != null) {
                        QuickVideoView.this.kym = QuickVideoView.this.kyk.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kyC, QuickVideoView.this.au(QuickVideoView.this.kyk.cyn(), i3 + "", QuickVideoView.this.kyk.cyo()));
                        QuickVideoView.this.kyk = null;
                    }
                    QuickVideoView.this.kyC = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.BO(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.BP(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eBk == null || QuickVideoView.this.eBk.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.kza = new g.InterfaceC0704g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(g gVar) {
                if (QuickVideoView.this.kyD) {
                    QuickVideoView.this.kyD = false;
                    return;
                }
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.cRa();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kyo != null && z) {
                    QuickVideoView.this.kyo.onSeekComplete();
                }
                if (QuickVideoView.this.eKp != null) {
                    QuickVideoView.this.eKp.b(gVar);
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kyg != null) {
                    QuickVideoView.this.kyg.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kyr = i2;
                    if (QuickVideoView.this.kyd != null && gVar != null) {
                        QuickVideoView.this.kyd.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kyr);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kyp.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.a(i, i2, QuickVideoView.this.kyk);
                    return true;
                }
                return true;
            }
        };
        this.eKq = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.m(i, i2, str);
                }
            }
        };
        this.eKr = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.IA(str);
                }
            }
        };
        this.eKs = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kyC = j;
                }
            }
        };
        this.kzb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kyo != null && QuickVideoView.this.kyo.cQv() && QuickVideoView.this.kyo.cQw() && QuickVideoView.this.kyo.cQx() && QuickVideoView.this.kyf != null) {
                    int blb = QuickVideoView.this.kyf.blb();
                    int currentPosition = QuickVideoView.this.kyf.getCurrentPosition();
                    int duration = QuickVideoView.this.kyf.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kyG;
                    boolean z = currentPosition + blb < duration;
                    if (blb < QuickVideoView.this.kyo.cQy() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kyG = currentTimeMillis;
                        QuickVideoView.this.kyo.BH(0);
                    }
                    if (QuickVideoView.this.cQK() && currentPosition == QuickVideoView.this.kyH && j > 500) {
                        QuickVideoView.this.kyG = currentTimeMillis;
                        QuickVideoView.this.kyo.BH(0);
                    }
                    QuickVideoView.this.kyH = currentPosition;
                    if (QuickVideoView.this.kyN == QuickVideoView.kyL) {
                        QuickVideoView.this.cQL();
                    }
                }
            }
        };
        this.eKz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kyo != null) {
                        QuickVideoView.this.kyo.zG(QuickVideoView.this.kyA);
                    }
                    if (QuickVideoView.this.kyk != null) {
                        QuickVideoView.this.kyk.Ix(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kyk = null;
                    }
                    QuickVideoView.this.cQH();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kyn = false;
        this.kyq = false;
        this.kyr = 0;
        this.drn = false;
        this.kys = -1;
        this.kyt = false;
        this.kyu = null;
        this.kyv = true;
        this.kyF = false;
        this.kyG = 0L;
        this.kyH = 0L;
        this.kyN = kyM;
        this.kyO = 0;
        this.kyP = 0;
        this.kyQ = -1;
        this.kyR = 0;
        this.kyS = 0;
        this.kyT = 0;
        this.dsA = 0;
        this.kyU = false;
        this.aio = null;
        this.kyV = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kyf != null && QuickVideoView.this.kyn) {
                    QuickVideoView.this.b(QuickVideoView.this.kyf, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kyW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.qy(false);
                }
            }
        };
        this.kyX = false;
        this.bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.kyU) {
                    QuickVideoView.this.kyU = false;
                    if (QuickVideoView.this.kyf != null) {
                        QuickVideoView.this.kyf.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kyq || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kyf != null) {
                        if (QuickVideoView.this.cQO()) {
                            QuickVideoView.this.kyf.d(surfaceTexture);
                        } else if (QuickVideoView.this.kyt) {
                            QuickVideoView.this.kyf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kys);
                            if (QuickVideoView.this.kxJ != null) {
                                QuickVideoView.this.kxJ.cQp();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kyk.cyj();
                            }
                        }
                    }
                } else if (cQR()) {
                    if (QuickVideoView.this.kyf != null) {
                        QuickVideoView.this.cQF();
                        QuickVideoView.this.kyq = true;
                        QuickVideoView.this.kyf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kyk.cyi();
                    }
                }
                QuickVideoView.this.kyu = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kyU) {
                    QuickVideoView.this.cQH();
                    QuickVideoView.this.tw(false);
                    if (QuickVideoView.this.kyf != null) {
                        if (QuickVideoView.this.kyf.isPlaying() && QuickVideoView.this.cQM()) {
                            x.cRo().bw(QuickVideoView.this.kyB, QuickVideoView.this.kyf.getCurrentPosition());
                            if (QuickVideoView.this.kyF) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kyF) {
                            QuickVideoView.this.kyf.release();
                        }
                    }
                    if (QuickVideoView.this.kyq) {
                        if (QuickVideoView.this.kyo != null && !QuickVideoView.this.kyF) {
                            QuickVideoView.this.kyo.Kv(QuickVideoView.this.kyA);
                        }
                        if (QuickVideoView.this.eBo != null) {
                            QuickVideoView.this.eBo.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kyu = null;
                    if (QuickVideoView.this.kyk != null && QuickVideoView.this.kyk.Iz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kyk = null;
                    }
                    if (!QuickVideoView.this.kyF) {
                        QuickVideoView.this.kyq = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cQR() {
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
        this.kyY = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int KA;
                QuickVideoView.this.cQH();
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.onPrepared();
                }
                if (QuickVideoView.this.kyk != null && QuickVideoView.this.kyf != null) {
                    QuickVideoView.this.kyk.zy(QuickVideoView.this.kyf.getPlayerType());
                }
                if (QuickVideoView.this.kyF) {
                    TbVideoViewSet.cRt().a(QuickVideoView.this, QuickVideoView.this.kyA);
                }
                if (QuickVideoView.this.eKm != null) {
                    QuickVideoView.this.kyp.cyz();
                    QuickVideoView.this.eKm.onPrepared(gVar);
                }
                if (QuickVideoView.this.kyo != null) {
                    long j = 0;
                    if (QuickVideoView.this.kyf != null) {
                        j = QuickVideoView.this.kyf.getDuration();
                    }
                    QuickVideoView.this.kyo.fj(j);
                    QuickVideoView.this.cQG();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kyo.cQz();
                        QuickVideoView.this.cQL();
                    }
                }
                if (QuickVideoView.this.kyE && (KA = x.cRo().KA(QuickVideoView.this.kyB)) > 0 && QuickVideoView.this.kyf != null && QuickVideoView.this.kyf.getCurrentPosition() == 0) {
                    QuickVideoView.this.BK(KA);
                }
                if (QuickVideoView.this.kyn) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kyd != null && gVar != null) {
                    QuickVideoView.this.kyd.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kyr);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kye) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kye);
                }
                if (QuickVideoView.this.kyw != null && QuickVideoView.this.kyw.cRQ()) {
                    com.baidu.tieba.play.b.e.BQ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kyZ = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tw(true);
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.Iy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kyk = null;
                }
                if (!QuickVideoView.this.drn || QuickVideoView.this.kyo == null) {
                    if (QuickVideoView.this.kyo != null) {
                        QuickVideoView.this.kyo.onCompletion();
                    }
                    QuickVideoView.this.kyn = false;
                    x.cRo().remove(QuickVideoView.this.kyB);
                    if (QuickVideoView.this.eKl != null) {
                        QuickVideoView.this.eKl.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kym = null;
                QuickVideoView.this.kyC = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kyo.cQs());
                QuickVideoView.this.start();
            }
        };
        this.eKn = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.aa(i, i2, i3);
                QuickVideoView.this.cQH();
                if (QuickVideoView.this.kyo != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cQM()) {
                    QuickVideoView.this.kyD = true;
                    x.cRo().bw(QuickVideoView.this.kyB, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRt().KC(QuickVideoView.this.kyA);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kyk != null) {
                        QuickVideoView.this.kym = QuickVideoView.this.kyk.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kyC, QuickVideoView.this.au(QuickVideoView.this.kyk.cyn(), i3 + "", QuickVideoView.this.kyk.cyo()));
                        QuickVideoView.this.kyk = null;
                    }
                    QuickVideoView.this.kyC = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.BO(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.BP(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eBk == null || QuickVideoView.this.eBk.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.kza = new g.InterfaceC0704g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(g gVar) {
                if (QuickVideoView.this.kyD) {
                    QuickVideoView.this.kyD = false;
                    return;
                }
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.cRa();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kyo != null && z) {
                    QuickVideoView.this.kyo.onSeekComplete();
                }
                if (QuickVideoView.this.eKp != null) {
                    QuickVideoView.this.eKp.b(gVar);
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.kyg != null) {
                    QuickVideoView.this.kyg.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.kyr = i2;
                    if (QuickVideoView.this.kyd != null && gVar != null) {
                        QuickVideoView.this.kyd.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kyr);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.kyp.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.a(i, i2, QuickVideoView.this.kyk);
                    return true;
                }
                return true;
            }
        };
        this.eKq = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.m(i, i2, str);
                }
            }
        };
        this.eKr = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.IA(str);
                }
            }
        };
        this.eKs = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kyC = j;
                }
            }
        };
        this.kzb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kyo != null && QuickVideoView.this.kyo.cQv() && QuickVideoView.this.kyo.cQw() && QuickVideoView.this.kyo.cQx() && QuickVideoView.this.kyf != null) {
                    int blb = QuickVideoView.this.kyf.blb();
                    int currentPosition = QuickVideoView.this.kyf.getCurrentPosition();
                    int duration = QuickVideoView.this.kyf.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kyG;
                    boolean z = currentPosition + blb < duration;
                    if (blb < QuickVideoView.this.kyo.cQy() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kyG = currentTimeMillis;
                        QuickVideoView.this.kyo.BH(0);
                    }
                    if (QuickVideoView.this.cQK() && currentPosition == QuickVideoView.this.kyH && j > 500) {
                        QuickVideoView.this.kyG = currentTimeMillis;
                        QuickVideoView.this.kyo.BH(0);
                    }
                    QuickVideoView.this.kyH = currentPosition;
                    if (QuickVideoView.this.kyN == QuickVideoView.kyL) {
                        QuickVideoView.this.cQL();
                    }
                }
            }
        };
        this.eKz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kyo != null) {
                        QuickVideoView.this.kyo.zG(QuickVideoView.this.kyA);
                    }
                    if (QuickVideoView.this.kyk != null) {
                        QuickVideoView.this.kyk.Ix(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kyk = null;
                    }
                    QuickVideoView.this.cQH();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kyn = false;
        this.kyq = false;
        this.kyr = 0;
        this.drn = false;
        this.kys = -1;
        this.kyt = false;
        this.kyu = null;
        this.kyv = true;
        this.kyF = false;
        this.kyG = 0L;
        this.kyH = 0L;
        this.kyN = kyM;
        this.kyO = 0;
        this.kyP = 0;
        this.kyQ = -1;
        this.kyR = 0;
        this.kyS = 0;
        this.kyT = 0;
        this.dsA = 0;
        this.kyU = false;
        this.aio = null;
        this.kyV = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kyf != null && QuickVideoView.this.kyn) {
                    QuickVideoView.this.b(QuickVideoView.this.kyf, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.kyW = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.qy(false);
                }
            }
        };
        this.kyX = false;
        this.bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.kyU) {
                    QuickVideoView.this.kyU = false;
                    if (QuickVideoView.this.kyf != null) {
                        QuickVideoView.this.kyf.d(surfaceTexture);
                    }
                } else if (QuickVideoView.this.kyq || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.kyf != null) {
                        if (QuickVideoView.this.cQO()) {
                            QuickVideoView.this.kyf.d(surfaceTexture);
                        } else if (QuickVideoView.this.kyt) {
                            QuickVideoView.this.kyf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.kys);
                            if (QuickVideoView.this.kxJ != null) {
                                QuickVideoView.this.kxJ.cQp();
                            }
                            if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.kyk.cyj();
                            }
                        }
                    }
                } else if (cQR()) {
                    if (QuickVideoView.this.kyf != null) {
                        QuickVideoView.this.cQF();
                        QuickVideoView.this.kyq = true;
                        QuickVideoView.this.kyf.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.x(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.kyk.cyi();
                    }
                }
                QuickVideoView.this.kyu = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.kyU) {
                    QuickVideoView.this.cQH();
                    QuickVideoView.this.tw(false);
                    if (QuickVideoView.this.kyf != null) {
                        if (QuickVideoView.this.kyf.isPlaying() && QuickVideoView.this.cQM()) {
                            x.cRo().bw(QuickVideoView.this.kyB, QuickVideoView.this.kyf.getCurrentPosition());
                            if (QuickVideoView.this.kyF) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.kyF) {
                            QuickVideoView.this.kyf.release();
                        }
                    }
                    if (QuickVideoView.this.kyq) {
                        if (QuickVideoView.this.kyo != null && !QuickVideoView.this.kyF) {
                            QuickVideoView.this.kyo.Kv(QuickVideoView.this.kyA);
                        }
                        if (QuickVideoView.this.eBo != null) {
                            QuickVideoView.this.eBo.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.kyu = null;
                    if (QuickVideoView.this.kyk != null && QuickVideoView.this.kyk.Iz(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.kyk = null;
                    }
                    if (!QuickVideoView.this.kyF) {
                        QuickVideoView.this.kyq = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cQR() {
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
        this.kyY = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int KA;
                QuickVideoView.this.cQH();
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.onPrepared();
                }
                if (QuickVideoView.this.kyk != null && QuickVideoView.this.kyf != null) {
                    QuickVideoView.this.kyk.zy(QuickVideoView.this.kyf.getPlayerType());
                }
                if (QuickVideoView.this.kyF) {
                    TbVideoViewSet.cRt().a(QuickVideoView.this, QuickVideoView.this.kyA);
                }
                if (QuickVideoView.this.eKm != null) {
                    QuickVideoView.this.kyp.cyz();
                    QuickVideoView.this.eKm.onPrepared(gVar);
                }
                if (QuickVideoView.this.kyo != null) {
                    long j = 0;
                    if (QuickVideoView.this.kyf != null) {
                        j = QuickVideoView.this.kyf.getDuration();
                    }
                    QuickVideoView.this.kyo.fj(j);
                    QuickVideoView.this.cQG();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.kyo.cQz();
                        QuickVideoView.this.cQL();
                    }
                }
                if (QuickVideoView.this.kyE && (KA = x.cRo().KA(QuickVideoView.this.kyB)) > 0 && QuickVideoView.this.kyf != null && QuickVideoView.this.kyf.getCurrentPosition() == 0) {
                    QuickVideoView.this.BK(KA);
                }
                if (QuickVideoView.this.kyn) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.kyd != null && gVar != null) {
                    QuickVideoView.this.kyd.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kyr);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.kye) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.kye);
                }
                if (QuickVideoView.this.kyw != null && QuickVideoView.this.kyw.cRQ()) {
                    com.baidu.tieba.play.b.e.BQ(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.kyZ = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.tw(true);
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.Iy(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.kyk = null;
                }
                if (!QuickVideoView.this.drn || QuickVideoView.this.kyo == null) {
                    if (QuickVideoView.this.kyo != null) {
                        QuickVideoView.this.kyo.onCompletion();
                    }
                    QuickVideoView.this.kyn = false;
                    x.cRo().remove(QuickVideoView.this.kyB);
                    if (QuickVideoView.this.eKl != null) {
                        QuickVideoView.this.eKl.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.kym = null;
                QuickVideoView.this.kyC = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.kyo.cQs());
                QuickVideoView.this.start();
            }
        };
        this.eKn = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.aa(i2, i22, i3);
                QuickVideoView.this.cQH();
                if (QuickVideoView.this.kyo != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cQM()) {
                    QuickVideoView.this.kyD = true;
                    x.cRo().bw(QuickVideoView.this.kyB, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cRt().KC(QuickVideoView.this.kyA);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.kyk != null) {
                        QuickVideoView.this.kym = QuickVideoView.this.kyk.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.kyC, QuickVideoView.this.au(QuickVideoView.this.kyk.cyn(), i3 + "", QuickVideoView.this.kyk.cyo()));
                        QuickVideoView.this.kyk = null;
                    }
                    QuickVideoView.this.kyC = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.BO(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.BP(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.eBk == null || QuickVideoView.this.eBk.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.kza = new g.InterfaceC0704g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(g gVar) {
                if (QuickVideoView.this.kyD) {
                    QuickVideoView.this.kyD = false;
                    return;
                }
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.cRa();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.kyo != null && z) {
                    QuickVideoView.this.kyo.onSeekComplete();
                }
                if (QuickVideoView.this.eKp != null) {
                    QuickVideoView.this.eKp.b(gVar);
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.kyg != null) {
                    QuickVideoView.this.kyg.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.kyr = i22;
                    if (QuickVideoView.this.kyd != null && gVar != null) {
                        QuickVideoView.this.kyd.Z(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.kyr);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.kyp.a(QuickVideoView.this);
                }
                if (QuickVideoView.this.kyx != null) {
                    QuickVideoView.this.kyx.a(i2, i22, QuickVideoView.this.kyk);
                    return true;
                }
                return true;
            }
        };
        this.eKq = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.m(i2, i22, str);
                }
            }
        };
        this.eKr = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.kyk != null) {
                    QuickVideoView.this.kyk.IA(str);
                }
            }
        };
        this.eKs = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.kyC = j;
                }
            }
        };
        this.kzb = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.kyo != null && QuickVideoView.this.kyo.cQv() && QuickVideoView.this.kyo.cQw() && QuickVideoView.this.kyo.cQx() && QuickVideoView.this.kyf != null) {
                    int blb = QuickVideoView.this.kyf.blb();
                    int currentPosition = QuickVideoView.this.kyf.getCurrentPosition();
                    int duration = QuickVideoView.this.kyf.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.kyG;
                    boolean z = currentPosition + blb < duration;
                    if (blb < QuickVideoView.this.kyo.cQy() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.kyG = currentTimeMillis;
                        QuickVideoView.this.kyo.BH(0);
                    }
                    if (QuickVideoView.this.cQK() && currentPosition == QuickVideoView.this.kyH && j > 500) {
                        QuickVideoView.this.kyG = currentTimeMillis;
                        QuickVideoView.this.kyo.BH(0);
                    }
                    QuickVideoView.this.kyH = currentPosition;
                    if (QuickVideoView.this.kyN == QuickVideoView.kyL) {
                        QuickVideoView.this.cQL();
                    }
                }
            }
        };
        this.eKz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.kyo != null) {
                        QuickVideoView.this.kyo.zG(QuickVideoView.this.kyA);
                    }
                    if (QuickVideoView.this.kyk != null) {
                        QuickVideoView.this.kyk.Ix(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.kyk = null;
                    }
                    QuickVideoView.this.cQH();
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
        this.kyd = new RenderView(context);
        this.aio = new WeakReference<>(TbadkCoreApplication.getInst());
        this.kyd.setSurfaceTextureListener(this.bEl);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.kyv) {
            addView(this.kyd, layoutParams);
        } else {
            addView(this.kyd, 0, layoutParams);
        }
        if (kyi != null) {
            this.kyf = kyi.ble();
        }
        if (this.kyf != null) {
            this.kyf.setOnPreparedListener(this.kyY);
            this.kyf.setOnCompletionListener(this.kyZ);
            this.kyf.a(this.eKn);
            this.kyf.setOnSeekCompleteListener(this.kza);
            this.kyf.a(this.eKo);
            this.kyf.a(this.eKq);
            this.kyf.a(this.eKr);
            this.kyf.a(this.eKs);
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
        this.kyw = new com.baidu.tieba.play.b.a(this);
        this.kyx = new q();
        this.kyy = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.kyp = new com.baidu.tieba.k.k();
    }

    @Override // com.baidu.tieba.play.a.a
    public void setContinuePlayEnable(boolean z) {
        this.kyE = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.kyA;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoDuration(int i) {
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.kyp.cyy();
        this.ais = str2;
        if (this.kyw != null) {
            this.kyw.clear();
            this.kyw.cRQ();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.KE(str2);
            if (kyj != null) {
                this.kyk = kyj.at(this.ais, str, "");
                if (this.kyk != null) {
                    this.kyk.a(-300, -44399, -44399, getLocateSource(), false, this.kyC, "");
                    this.kyk = null;
                }
            }
        }
        if (this.kyl != null) {
            this.kyl.a(null);
            this.kyl.cyb();
            this.kyl = null;
        }
        this.kym = null;
        this.kyC = 0L;
        setVideoPath(str);
    }

    private String Kw(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.dhK().dhL()) {
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
            String Kw = Kw(str);
            this.kyz = Kw;
            if (this.kyo != null) {
                Kw = this.kyo.zB(Kw);
                if (this.kyo.cQA() != null) {
                    this.kyo.cQA().setPlayer(this);
                }
                if (kyj != null && xw(Kw)) {
                    this.kyl = kyj.IC(Kw);
                }
                if (this.kyl != null) {
                    this.kyl.a(new com.baidu.tieba.play.monitor.a(this.ais, this.kyz, this.kyk));
                    this.kyl.cya();
                }
                Kx(Kw);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !xw(Kw)) {
                if (this.eBk != null) {
                    this.eBk.onError(this.kyf, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cRt().KC(this.kyA);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(Kw));
            if (this.kyk != null && x(Uri.parse(Kw)) != null) {
                this.kyk.cyh();
            }
            this.kyA = str;
            int lastIndexOf = this.kyA.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.kyA.length() > 4) {
                this.kyB = this.kyA.substring(0, lastIndexOf + 4);
            } else {
                this.kyB = this.kyA;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQF() {
        if (com.baidu.tbadk.coreExtra.model.f.baP()) {
            if (this.kyo != null && (this.kyo.cQu() || this.kyo.cQv())) {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyV);
                com.baidu.adp.lib.f.e.ld().postDelayed(this.kyV, com.baidu.tbadk.coreExtra.model.f.baO());
            }
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyW);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kyW, com.baidu.tbadk.coreExtra.model.f.baN());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (x(uri) != null) {
            this.kyk.Iw(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aJz();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.kyX = false;
        if (this.kyu != null) {
            cQF();
            if (this.kyf != null) {
                if (!this.kyq) {
                    this.kyq = true;
                    this.kyf.a(this.mContext, this.mUri, this.mHeaders, this.kyu, this.mUri.getHost());
                } else if (!isPlaying() && this.kyY != null) {
                    this.kyX = true;
                    this.kyY.onPrepared(this.kyf);
                }
            }
        } else if (this.kyd != null && this.kyd.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.kyv) {
                addView(this.kyd, layoutParams);
            } else {
                addView(this.kyd, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aJz() {
        this.kyq = false;
        this.kyn = false;
        if (this.kyf != null) {
            if (this.kyf.isPlaying() && cQM()) {
                x.cRo().bw(this.kyB, this.kyf.getCurrentPosition());
            }
            this.kyf.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzb);
    }

    private void Kx(String str) {
        this.kyP = 0;
        this.kyQ = 0;
        this.kyR = 0;
        this.kyS = 0;
        this.kyT = 0;
        this.dsA = 0;
        if (this.kyo.cQv()) {
            this.kyO = kyJ;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.kyQ = (int) t.Kz(QuickVideoView.this.kyz);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.kyz != null && this.kyz.equals(str)) {
            this.kyO = kyI;
        } else {
            this.kyO = kyK;
        }
        this.kyN = kyL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQG() {
        this.kyN = kyL;
        if (this.kyf != null) {
            this.kyP = this.kyf.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(boolean z) {
        if (this.kyN == kyL && this.kyf != null) {
            this.kyN = kyM;
            this.kyS = this.kyf.getDuration();
            if (z) {
                this.kyT = 0;
                this.kyR = this.kyS;
            } else {
                this.kyR = this.kyf.getCurrentPosition();
                this.kyT = this.kyf.getCachedSize();
            }
            if (this.kyR > 0) {
                if (this.kyO == kyI) {
                    this.kyQ = (int) t.Kz(this.kyz);
                    if (this.kyP > 0) {
                        long j = (this.kyP * (this.kyR / 1000)) / 8;
                        if (this.kyT < 0) {
                            this.kyT = 0;
                        }
                        long j2 = this.kyT + j;
                        if (this.kyQ > 0) {
                            j2 += this.kyQ;
                        }
                        setFlowCount(j2, this.kyR, this.kyS, this.dsA);
                    } else if (this.kyP == -1) {
                        this.kyP = 603327;
                        setFlowCount((this.kyP * (this.kyR / 1000)) / 8, this.kyR, this.kyS, this.dsA);
                    }
                } else if (this.kyO == kyJ) {
                    if (this.kyP > 0) {
                        long j3 = (this.kyP * (this.kyR / 1000)) / 8;
                        if (this.kyT < 0) {
                            this.kyT = 0;
                        }
                        long j4 = this.kyT + j3;
                        if (this.kyQ > 0) {
                            j4 -= this.kyQ;
                        }
                        setFlowCount(j4, this.kyR, this.kyS, this.dsA);
                    } else if (this.kyP == -1) {
                        this.kyP = 603327;
                        setFlowCount((this.kyP * (this.kyR / 1000)) / 8, this.kyR, this.kyS, this.dsA);
                    }
                } else {
                    setFlowCount(0L, this.kyR, this.kyS, this.dsA);
                }
            }
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzb);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.kyF) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        cQH();
        tw(false);
        if (this.kyw != null) {
            this.kyw.clear();
        }
        this.kye = null;
        this.kyn = false;
        if (this.kyf != null) {
            if (this.kyf.isPlaying() && cQM()) {
                x.cRo().bw(this.kyB, this.kyf.getCurrentPosition());
            }
            this.kyf.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzb);
        this.drn = false;
        if (this.kyo != null) {
            this.kyo.cQt();
        }
        com.baidu.adp.lib.network.http.a.b.kN().a((b.InterfaceC0022b) null);
        if (this.kyk != null && this.kyk.Iz(getLocateSource())) {
            this.kyk = null;
        }
        if (this.kyp != null) {
            this.kyp.cyx();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzb);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            ag.a(this.aio, false);
        }
        cQH();
        tw(false);
        if (this.kyw != null) {
            this.kyw.clear();
        }
        this.kye = null;
        aJz();
        TbVideoViewSet.cRt().KC(this.kyA);
        this.drn = false;
        if (this.kyo != null) {
            this.kyo.Kv(this.kyA);
        }
        com.baidu.adp.lib.network.http.a.b.kN().a((b.InterfaceC0022b) null);
        if (this.kyk != null && this.kyk.Iz(getLocateSource())) {
            this.kyk = null;
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzb);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.kyU = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQH() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyV);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyW);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.eKm = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.eKl = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.eBk = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0704g interfaceC0704g) {
        this.eKp = interfaceC0704g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQI() {
        cQH();
        if (this.kyx != null) {
            this.kyx.onPrepared();
        }
        if (x(this.mUri) != null && this.kyf != null) {
            this.kyk.Iw(this.mUri.getPath());
            this.kyk.zz(this.kyf.getPlayerType());
        }
        this.kyp.cyy();
        this.kyp.cyz();
        if (this.kyo != null) {
            long j = 0;
            if (this.kyf != null) {
                j = this.kyf.getDuration();
            }
            this.kyo.fj(j);
            cQG();
            if (getPlayerType() == -200) {
                this.kyo.cQz();
                cQL();
            }
        }
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cQJ() {
        if (x(this.mUri) != null && this.kyf != null) {
            this.kyk.Iw(this.mUri.getPath());
            this.kyk.cyh();
            this.kyk.zy(this.kyf.getPlayerType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String au(String str, String str2, String str3) {
        if (this.kyy == null) {
            return "";
        }
        String cRS = this.kyy.cRS();
        this.kyy.av(str, str2, str3);
        return cRS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.kyo != null && !StringUtils.isNull(this.kyo.cQs())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.KD(uri);
                }
            }
            this.mUri = Uri.parse(this.kyo.cQs());
        }
        boolean z = false;
        if (this.kyw != null) {
            z = this.kyw.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.kyk != null) {
            this.kym = this.kyk.a(i, i2, i3, getLocateSource(), z, this.kyC, au(this.kyk.cyn(), i3 + "", this.kyk.cyo()));
            this.kyk = null;
        }
        this.kyC = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.kyf != null) {
            try {
                if (this.kyf.isPlaying() && cQM()) {
                    x.cRo().bw(this.kyB, this.kyf.getCurrentPosition());
                }
                this.kyf.release();
                this.kye = str;
                URI uri = new URI(this.mUri.toString());
                this.kyf.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.kyu, this.mUri.getHost());
                if (x(this.mUri) != null) {
                    this.kyk.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kyf != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.kyf.isPlaying() && cQM()) {
                x.cRo().bw(this.kyB, this.kyf.getCurrentPosition());
            }
            this.kyf.release();
            this.kyf.a(this.mContext, this.mUri, this.mHeaders, this.kyu, this.mUri.getHost());
            if (x(this.mUri) != null) {
                this.kyk.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.kyf != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.kyf.forceUseSystemMediaPlayer(true);
            }
            if (this.kyf.isPlaying() && cQM()) {
                x.cRo().bw(this.kyB, this.kyf.getCurrentPosition());
            }
            this.kyf.release();
            this.kyf.a(this.mContext, this.mUri, this.mHeaders, this.kyu, this.mUri.getHost());
            if (x(this.mUri) != null) {
                this.kyk.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.kyn = true;
        if (this.kyf != null) {
            if (this.kyu != null && this.kyt && !this.kyf.isExistInRemote()) {
                this.kyf.a(this.mContext, this.mUri, this.mHeaders, this.kyu, this.kys);
                if (this.kxJ != null) {
                    this.kxJ.cQp();
                }
                if (x(this.mUri) != null) {
                    this.kyk.cyj();
                }
                cQF();
                return;
            }
            if (!this.kyf.blc()) {
                ag.a(this.aio, true);
                this.kyf.setVolume(1.0f, 1.0f);
            }
            this.kyp.cyA();
            this.kyf.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.kyo != null) {
            this.kyo.onStart();
        }
        if (this.kyh != null) {
            this.kyh.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (x(this.mUri) != null && this.kyf != null) {
            this.kyk.zA(this.kyf.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.kyn) {
            b(aVar);
            return;
        }
        this.kyn = true;
        if (aVar != null) {
            this.kyF = true;
            if (!cQP()) {
                aVar.cRu();
            }
        } else {
            this.kyF = false;
        }
        setVideoPath(this.kyA, this.ais);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cQH();
        ag.a(this.aio, false);
        if (this.kyf != null) {
            if (this.kyf.isPlaying() && cQM()) {
                x.cRo().bw(this.kyB, this.kyf.getCurrentPosition());
            }
            this.kyf.pause();
        }
        if (this.kyo != null) {
            this.kyo.onPause();
        }
        this.kyn = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kyk != null) {
            this.kyk.cym();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.kyf != null) {
            return this.kyf.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.kyf != null) {
            return this.kyf.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.dsA = i;
        BK(i);
    }

    public void BK(int i) {
        if (this.kyx != null) {
            this.kyx.cQZ();
        }
        if (this.kyf != null) {
            this.kyf.seekTo(i);
        }
        if (this.kyo != null) {
            this.kyo.BH(0);
            cQL();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.kyf != null) {
            return this.kyf.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.kyf != null) {
            this.kyf.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.kys = i;
    }

    public int getRecoveryState() {
        return this.kys;
    }

    public void setNeedRecovery(boolean z) {
        this.kyt = z;
    }

    public void setLooping(boolean z) {
        this.drn = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cQK() {
        return this.kyn;
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
        this.eBo = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.kyo = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eKz);
    }

    public void setMute(boolean z) {
        if (z) {
            this.kyf.setVolume(0.0f, 0.0f);
            ag.a(this.aio, false);
            return;
        }
        ag.a(this.aio, true);
        this.kyf.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.drn = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.kyf != null) {
            this.kyf.bld();
        }
        if (this.kyx != null) {
            this.kyx.Qq();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzb);
        MessageManager.getInstance().unRegisterListener(this.eKz);
        if (this.kyw != null) {
            this.kyw.clear();
        }
        if (this.kyl != null) {
            this.kyl.a(null);
            this.kyl.cyb();
        }
    }

    public g getPlayer() {
        return this.kyf;
    }

    public int getPlayerType() {
        if (this.kyf == null) {
            return -300;
        }
        return this.kyf.getPlayerType();
    }

    public void cQL() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzb);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kzb, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.kxJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        if (!(this.kyo instanceof n) || ((n) this.kyo).cQY() == null) {
            return "";
        }
        return ((n) this.kyo).kzn ? "v_mid_page" : ((n) this.kyo).cQY().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.k.i x(Uri uri) {
        String uri2;
        if (this.kyk != null) {
            return this.kyk;
        }
        if (!StringUtils.isNull(this.kyz)) {
            uri2 = this.kyz;
        } else if (kyj != null && this.kyo != null && !StringUtils.isNull(this.kyo.cQs())) {
            uri2 = this.kyo.cQs();
        } else {
            uri2 = (kyj == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && kyj != null) {
            this.kyk = kyj.at(this.ais, uri2, this.kym);
        }
        this.kym = null;
        this.kyC = 0L;
        return this.kyk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQM() {
        return this.kyf != null && this.kyf.getDuration() >= this.kyf.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.kyk, j, j2, j3, j4);
    }

    public static boolean xw(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cQN() {
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
            this.kyF = true;
            if (!cQP()) {
                aVar.cRu();
            }
            if (!cQO()) {
                aVar.cRv();
                this.kyn = true;
                setVideoPath(this.kyA, this.ais);
                return;
            }
        } else {
            this.kyF = false;
        }
        start();
        if (this.kyf != null && this.kyF) {
            this.kyp.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQO() {
        return this == TbVideoViewSet.cRt().KB(this.kyA);
    }

    private boolean cQP() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.eKl = null;
        this.eBk = null;
        this.eKo = null;
        this.kyY = null;
        this.kza = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.kyF = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.kyg = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.kyf != null) {
            return this.kyf.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.kyf != null ? this.kyf.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void e(long j, long j2, long j3) {
        if (this.kyk != null) {
            this.kyk.e(j, j2, j3);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.kyh = cVar;
    }
}
