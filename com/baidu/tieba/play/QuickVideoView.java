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
    private static h eaV;
    private static com.baidu.tieba.j.l eaW;
    private static int jur = 0;
    private static int jus = 1;
    private static int jut = 2;
    private static int juu = 1;
    private static int juv = 0;
    private WeakReference<Context> OC;
    private String OG;
    private TextureView.SurfaceTextureListener aTp;
    private g.b dIa;
    private b dIe;
    private g.a dQW;
    private g.f dQX;
    private g.c dQY;
    private g.e dQZ;
    private g.InterfaceC0582g dRa;
    private g.i dRb;
    private g.d dRc;
    private g.h dRd;
    private final CustomMessageListener dRk;
    private int dVV;
    private boolean eaN;
    private g.f eaX;
    private g.a eaY;
    private g.InterfaceC0582g ebb;
    private int jbH;
    private RenderView jtO;
    private String jtP;
    private g jtQ;
    private g.e jtR;
    private c jtS;
    private com.baidu.tieba.j.i jtT;
    private com.baidu.tieba.j.e jtU;
    private String jtV;
    private boolean jtW;
    private d jtX;
    private com.baidu.tieba.j.k jtY;
    private boolean jtZ;
    private a jtv;
    private int juA;
    private boolean juB;
    private Runnable juC;
    private Runnable juD;
    public boolean juE;
    private Runnable juF;
    private int jua;
    private int jub;
    private boolean juc;
    private SurfaceTexture jud;
    private boolean jue;
    private com.baidu.tieba.play.b.a juf;
    private q jug;
    private com.baidu.tieba.play.b.f juh;
    private String jui;
    private String juj;
    private String juk;
    private long jul;
    private boolean jum;
    private boolean jun;
    private boolean juo;
    private long jup;
    private long juq;
    private int juw;
    private int jux;
    private int juy;
    private int juz;
    private int mBitRate;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cwY();
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
            eaV = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            eaW = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.jue = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.jtW = false;
        this.jtZ = false;
        this.jua = 0;
        this.eaN = false;
        this.jub = -1;
        this.juc = false;
        this.jud = null;
        this.jue = true;
        this.juo = false;
        this.jup = 0L;
        this.juq = 0L;
        this.jbH = juv;
        this.juw = 0;
        this.mBitRate = 0;
        this.jux = -1;
        this.juy = 0;
        this.juz = 0;
        this.juA = 0;
        this.dVV = 0;
        this.juB = false;
        this.OC = null;
        this.juC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtQ != null && QuickVideoView.this.jtW) {
                    QuickVideoView.this.b(QuickVideoView.this.jtQ, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.juD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.oO(false);
                }
            }
        };
        this.juE = false;
        this.aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.juB) {
                    QuickVideoView.this.juB = false;
                    if (QuickVideoView.this.jtQ != null) {
                        QuickVideoView.this.jtQ.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jtZ || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jtQ != null) {
                        if (QuickVideoView.this.cxw()) {
                            QuickVideoView.this.jtQ.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juc) {
                            QuickVideoView.this.jtQ.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jub);
                            if (QuickVideoView.this.jtv != null) {
                                QuickVideoView.this.jtv.cwY();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jtT.cfa();
                            }
                        }
                    }
                } else if (cxz()) {
                    if (QuickVideoView.this.jtQ != null) {
                        QuickVideoView.this.cxo();
                        QuickVideoView.this.jtZ = true;
                        QuickVideoView.this.jtQ.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jtT.ceZ();
                    }
                }
                QuickVideoView.this.jud = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.juB) {
                    QuickVideoView.this.cxq();
                    QuickVideoView.this.rL(false);
                    if (QuickVideoView.this.jtQ != null) {
                        if (QuickVideoView.this.jtQ.isPlaying() && QuickVideoView.this.cxu()) {
                            x.cxW().bn(QuickVideoView.this.juk, QuickVideoView.this.jtQ.getCurrentPosition());
                            if (QuickVideoView.this.juo) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.juo) {
                            QuickVideoView.this.jtQ.release();
                        }
                    }
                    if (QuickVideoView.this.jtZ) {
                        if (QuickVideoView.this.jtX != null && !QuickVideoView.this.juo) {
                            QuickVideoView.this.jtX.GK(QuickVideoView.this.juj);
                        }
                        if (QuickVideoView.this.dIe != null) {
                            QuickVideoView.this.dIe.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jud = null;
                    if (QuickVideoView.this.jtT != null && QuickVideoView.this.jtT.EP(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jtT = null;
                    }
                    if (!QuickVideoView.this.juo) {
                        QuickVideoView.this.jtZ = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cxz() {
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
        this.eaX = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int GP;
                QuickVideoView.this.cxq();
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.onPrepared();
                }
                if (QuickVideoView.this.jtT != null && QuickVideoView.this.jtQ != null) {
                    QuickVideoView.this.jtT.yb(QuickVideoView.this.jtQ.getPlayerType());
                }
                if (QuickVideoView.this.juo) {
                    TbVideoViewSet.cxZ().a(QuickVideoView.this, QuickVideoView.this.juj);
                }
                if (QuickVideoView.this.dQX != null) {
                    QuickVideoView.this.jtY.cfp();
                    QuickVideoView.this.dQX.onPrepared(gVar);
                }
                if (QuickVideoView.this.jtX != null) {
                    long j = 0;
                    if (QuickVideoView.this.jtQ != null) {
                        j = QuickVideoView.this.jtQ.getDuration();
                    }
                    QuickVideoView.this.jtX.ez(j);
                    QuickVideoView.this.cxp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jtX.cxi();
                        QuickVideoView.this.cxt();
                    }
                }
                if (QuickVideoView.this.jun && (GP = x.cxW().GP(QuickVideoView.this.juk)) > 0 && QuickVideoView.this.jtQ != null) {
                    if (QuickVideoView.this.jtQ.isPlayerReuse()) {
                        if (QuickVideoView.this.jtQ.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ai(GP);
                        }
                    } else {
                        QuickVideoView.this.Ai(GP);
                    }
                }
                if (QuickVideoView.this.jtW) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jtO != null && gVar != null) {
                    QuickVideoView.this.jtO.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jua);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jtP) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jtP);
                }
                if (QuickVideoView.this.juf != null && QuickVideoView.this.juf.cyq()) {
                    com.baidu.tieba.play.b.e.Ao(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rL(true);
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.EO(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jtT = null;
                }
                if (!QuickVideoView.this.eaN || QuickVideoView.this.jtX == null) {
                    if (QuickVideoView.this.jtX != null) {
                        QuickVideoView.this.jtX.onCompletion();
                    }
                    QuickVideoView.this.jtW = false;
                    x.cxW().remove(QuickVideoView.this.juk);
                    if (QuickVideoView.this.dQW != null) {
                        QuickVideoView.this.dQW.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jtV = null;
                QuickVideoView.this.jul = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jtX.cxb());
                QuickVideoView.this.start();
            }
        };
        this.dQY = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.W(i, i2, i3);
                QuickVideoView.this.cxq();
                if (QuickVideoView.this.jtX != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cxu()) {
                    QuickVideoView.this.jum = true;
                    x.cxW().bn(QuickVideoView.this.juk, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxZ().GR(QuickVideoView.this.juj);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jtT != null) {
                        QuickVideoView.this.jtV = QuickVideoView.this.jtT.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jul, QuickVideoView.this.aq(QuickVideoView.this.jtT.cfe(), i3 + "", QuickVideoView.this.jtT.cff()));
                        QuickVideoView.this.jtT = null;
                    }
                    QuickVideoView.this.jul = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Am(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.An(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dIa == null || QuickVideoView.this.dIa.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.ebb = new g.InterfaceC0582g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                if (QuickVideoView.this.jum) {
                    QuickVideoView.this.jum = false;
                    return;
                }
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.cxI();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jtX != null && z) {
                    QuickVideoView.this.jtX.onSeekComplete();
                }
                if (QuickVideoView.this.dRa != null) {
                    QuickVideoView.this.dRa.b(gVar);
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jtR != null) {
                    QuickVideoView.this.jtR.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jua = i2;
                    if (QuickVideoView.this.jtO != null && gVar != null) {
                        QuickVideoView.this.jtO.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jua);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jtY.a(QuickVideoView.this.OG, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.a(i, i2, QuickVideoView.this.jtT);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.m(i, i2, str);
                }
            }
        };
        this.dRc = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.EQ(str);
                }
            }
        };
        this.dRd = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jul = j;
                }
            }
        };
        this.juF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jtX != null && QuickVideoView.this.jtX.cxe() && QuickVideoView.this.jtX.cxf() && QuickVideoView.this.jtX.cxg() && QuickVideoView.this.jtQ != null) {
                    int aUo = QuickVideoView.this.jtQ.aUo();
                    int currentPosition = QuickVideoView.this.jtQ.getCurrentPosition();
                    int duration = QuickVideoView.this.jtQ.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jup;
                    boolean z = currentPosition + aUo < duration;
                    if (aUo < QuickVideoView.this.jtX.cxh() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jup = currentTimeMillis;
                        QuickVideoView.this.jtX.Ag(0);
                    }
                    if (QuickVideoView.this.cxs() && currentPosition == QuickVideoView.this.juq && j > 500) {
                        QuickVideoView.this.jup = currentTimeMillis;
                        QuickVideoView.this.jtX.Ag(0);
                    }
                    QuickVideoView.this.juq = currentPosition;
                    if (QuickVideoView.this.jbH == QuickVideoView.juu) {
                        QuickVideoView.this.cxt();
                    }
                }
            }
        };
        this.dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jtX != null) {
                        QuickVideoView.this.jtX.wp(QuickVideoView.this.juj);
                    }
                    if (QuickVideoView.this.jtT != null) {
                        QuickVideoView.this.jtT.EN(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jtT = null;
                    }
                    QuickVideoView.this.cxq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtW = false;
        this.jtZ = false;
        this.jua = 0;
        this.eaN = false;
        this.jub = -1;
        this.juc = false;
        this.jud = null;
        this.jue = true;
        this.juo = false;
        this.jup = 0L;
        this.juq = 0L;
        this.jbH = juv;
        this.juw = 0;
        this.mBitRate = 0;
        this.jux = -1;
        this.juy = 0;
        this.juz = 0;
        this.juA = 0;
        this.dVV = 0;
        this.juB = false;
        this.OC = null;
        this.juC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtQ != null && QuickVideoView.this.jtW) {
                    QuickVideoView.this.b(QuickVideoView.this.jtQ, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.juD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.oO(false);
                }
            }
        };
        this.juE = false;
        this.aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.juB) {
                    QuickVideoView.this.juB = false;
                    if (QuickVideoView.this.jtQ != null) {
                        QuickVideoView.this.jtQ.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jtZ || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jtQ != null) {
                        if (QuickVideoView.this.cxw()) {
                            QuickVideoView.this.jtQ.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juc) {
                            QuickVideoView.this.jtQ.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jub);
                            if (QuickVideoView.this.jtv != null) {
                                QuickVideoView.this.jtv.cwY();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jtT.cfa();
                            }
                        }
                    }
                } else if (cxz()) {
                    if (QuickVideoView.this.jtQ != null) {
                        QuickVideoView.this.cxo();
                        QuickVideoView.this.jtZ = true;
                        QuickVideoView.this.jtQ.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jtT.ceZ();
                    }
                }
                QuickVideoView.this.jud = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.juB) {
                    QuickVideoView.this.cxq();
                    QuickVideoView.this.rL(false);
                    if (QuickVideoView.this.jtQ != null) {
                        if (QuickVideoView.this.jtQ.isPlaying() && QuickVideoView.this.cxu()) {
                            x.cxW().bn(QuickVideoView.this.juk, QuickVideoView.this.jtQ.getCurrentPosition());
                            if (QuickVideoView.this.juo) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.juo) {
                            QuickVideoView.this.jtQ.release();
                        }
                    }
                    if (QuickVideoView.this.jtZ) {
                        if (QuickVideoView.this.jtX != null && !QuickVideoView.this.juo) {
                            QuickVideoView.this.jtX.GK(QuickVideoView.this.juj);
                        }
                        if (QuickVideoView.this.dIe != null) {
                            QuickVideoView.this.dIe.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jud = null;
                    if (QuickVideoView.this.jtT != null && QuickVideoView.this.jtT.EP(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jtT = null;
                    }
                    if (!QuickVideoView.this.juo) {
                        QuickVideoView.this.jtZ = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cxz() {
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
        this.eaX = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int GP;
                QuickVideoView.this.cxq();
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.onPrepared();
                }
                if (QuickVideoView.this.jtT != null && QuickVideoView.this.jtQ != null) {
                    QuickVideoView.this.jtT.yb(QuickVideoView.this.jtQ.getPlayerType());
                }
                if (QuickVideoView.this.juo) {
                    TbVideoViewSet.cxZ().a(QuickVideoView.this, QuickVideoView.this.juj);
                }
                if (QuickVideoView.this.dQX != null) {
                    QuickVideoView.this.jtY.cfp();
                    QuickVideoView.this.dQX.onPrepared(gVar);
                }
                if (QuickVideoView.this.jtX != null) {
                    long j = 0;
                    if (QuickVideoView.this.jtQ != null) {
                        j = QuickVideoView.this.jtQ.getDuration();
                    }
                    QuickVideoView.this.jtX.ez(j);
                    QuickVideoView.this.cxp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jtX.cxi();
                        QuickVideoView.this.cxt();
                    }
                }
                if (QuickVideoView.this.jun && (GP = x.cxW().GP(QuickVideoView.this.juk)) > 0 && QuickVideoView.this.jtQ != null) {
                    if (QuickVideoView.this.jtQ.isPlayerReuse()) {
                        if (QuickVideoView.this.jtQ.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ai(GP);
                        }
                    } else {
                        QuickVideoView.this.Ai(GP);
                    }
                }
                if (QuickVideoView.this.jtW) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jtO != null && gVar != null) {
                    QuickVideoView.this.jtO.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jua);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jtP) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jtP);
                }
                if (QuickVideoView.this.juf != null && QuickVideoView.this.juf.cyq()) {
                    com.baidu.tieba.play.b.e.Ao(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rL(true);
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.EO(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jtT = null;
                }
                if (!QuickVideoView.this.eaN || QuickVideoView.this.jtX == null) {
                    if (QuickVideoView.this.jtX != null) {
                        QuickVideoView.this.jtX.onCompletion();
                    }
                    QuickVideoView.this.jtW = false;
                    x.cxW().remove(QuickVideoView.this.juk);
                    if (QuickVideoView.this.dQW != null) {
                        QuickVideoView.this.dQW.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jtV = null;
                QuickVideoView.this.jul = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jtX.cxb());
                QuickVideoView.this.start();
            }
        };
        this.dQY = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.W(i, i2, i3);
                QuickVideoView.this.cxq();
                if (QuickVideoView.this.jtX != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cxu()) {
                    QuickVideoView.this.jum = true;
                    x.cxW().bn(QuickVideoView.this.juk, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxZ().GR(QuickVideoView.this.juj);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jtT != null) {
                        QuickVideoView.this.jtV = QuickVideoView.this.jtT.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jul, QuickVideoView.this.aq(QuickVideoView.this.jtT.cfe(), i3 + "", QuickVideoView.this.jtT.cff()));
                        QuickVideoView.this.jtT = null;
                    }
                    QuickVideoView.this.jul = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.Am(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.An(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dIa == null || QuickVideoView.this.dIa.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.ebb = new g.InterfaceC0582g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                if (QuickVideoView.this.jum) {
                    QuickVideoView.this.jum = false;
                    return;
                }
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.cxI();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jtX != null && z) {
                    QuickVideoView.this.jtX.onSeekComplete();
                }
                if (QuickVideoView.this.dRa != null) {
                    QuickVideoView.this.dRa.b(gVar);
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jtR != null) {
                    QuickVideoView.this.jtR.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jua = i2;
                    if (QuickVideoView.this.jtO != null && gVar != null) {
                        QuickVideoView.this.jtO.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jua);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jtY.a(QuickVideoView.this.OG, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.a(i, i2, QuickVideoView.this.jtT);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.m(i, i2, str);
                }
            }
        };
        this.dRc = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.EQ(str);
                }
            }
        };
        this.dRd = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jul = j;
                }
            }
        };
        this.juF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jtX != null && QuickVideoView.this.jtX.cxe() && QuickVideoView.this.jtX.cxf() && QuickVideoView.this.jtX.cxg() && QuickVideoView.this.jtQ != null) {
                    int aUo = QuickVideoView.this.jtQ.aUo();
                    int currentPosition = QuickVideoView.this.jtQ.getCurrentPosition();
                    int duration = QuickVideoView.this.jtQ.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jup;
                    boolean z = currentPosition + aUo < duration;
                    if (aUo < QuickVideoView.this.jtX.cxh() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jup = currentTimeMillis;
                        QuickVideoView.this.jtX.Ag(0);
                    }
                    if (QuickVideoView.this.cxs() && currentPosition == QuickVideoView.this.juq && j > 500) {
                        QuickVideoView.this.jup = currentTimeMillis;
                        QuickVideoView.this.jtX.Ag(0);
                    }
                    QuickVideoView.this.juq = currentPosition;
                    if (QuickVideoView.this.jbH == QuickVideoView.juu) {
                        QuickVideoView.this.cxt();
                    }
                }
            }
        };
        this.dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jtX != null) {
                        QuickVideoView.this.jtX.wp(QuickVideoView.this.juj);
                    }
                    if (QuickVideoView.this.jtT != null) {
                        QuickVideoView.this.jtT.EN(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jtT = null;
                    }
                    QuickVideoView.this.cxq();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtW = false;
        this.jtZ = false;
        this.jua = 0;
        this.eaN = false;
        this.jub = -1;
        this.juc = false;
        this.jud = null;
        this.jue = true;
        this.juo = false;
        this.jup = 0L;
        this.juq = 0L;
        this.jbH = juv;
        this.juw = 0;
        this.mBitRate = 0;
        this.jux = -1;
        this.juy = 0;
        this.juz = 0;
        this.juA = 0;
        this.dVV = 0;
        this.juB = false;
        this.OC = null;
        this.juC = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtQ != null && QuickVideoView.this.jtW) {
                    QuickVideoView.this.b(QuickVideoView.this.jtQ, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.juD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.oO(false);
                }
            }
        };
        this.juE = false;
        this.aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.juB) {
                    QuickVideoView.this.juB = false;
                    if (QuickVideoView.this.jtQ != null) {
                        QuickVideoView.this.jtQ.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jtZ || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jtQ != null) {
                        if (QuickVideoView.this.cxw()) {
                            QuickVideoView.this.jtQ.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.juc) {
                            QuickVideoView.this.jtQ.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jub);
                            if (QuickVideoView.this.jtv != null) {
                                QuickVideoView.this.jtv.cwY();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jtT.cfa();
                            }
                        }
                    }
                } else if (cxz()) {
                    if (QuickVideoView.this.jtQ != null) {
                        QuickVideoView.this.cxo();
                        QuickVideoView.this.jtZ = true;
                        QuickVideoView.this.jtQ.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jtT.ceZ();
                    }
                }
                QuickVideoView.this.jud = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.juB) {
                    QuickVideoView.this.cxq();
                    QuickVideoView.this.rL(false);
                    if (QuickVideoView.this.jtQ != null) {
                        if (QuickVideoView.this.jtQ.isPlaying() && QuickVideoView.this.cxu()) {
                            x.cxW().bn(QuickVideoView.this.juk, QuickVideoView.this.jtQ.getCurrentPosition());
                            if (QuickVideoView.this.juo) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.juo) {
                            QuickVideoView.this.jtQ.release();
                        }
                    }
                    if (QuickVideoView.this.jtZ) {
                        if (QuickVideoView.this.jtX != null && !QuickVideoView.this.juo) {
                            QuickVideoView.this.jtX.GK(QuickVideoView.this.juj);
                        }
                        if (QuickVideoView.this.dIe != null) {
                            QuickVideoView.this.dIe.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jud = null;
                    if (QuickVideoView.this.jtT != null && QuickVideoView.this.jtT.EP(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jtT = null;
                    }
                    if (!QuickVideoView.this.juo) {
                        QuickVideoView.this.jtZ = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cxz() {
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
        this.eaX = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int GP;
                QuickVideoView.this.cxq();
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.onPrepared();
                }
                if (QuickVideoView.this.jtT != null && QuickVideoView.this.jtQ != null) {
                    QuickVideoView.this.jtT.yb(QuickVideoView.this.jtQ.getPlayerType());
                }
                if (QuickVideoView.this.juo) {
                    TbVideoViewSet.cxZ().a(QuickVideoView.this, QuickVideoView.this.juj);
                }
                if (QuickVideoView.this.dQX != null) {
                    QuickVideoView.this.jtY.cfp();
                    QuickVideoView.this.dQX.onPrepared(gVar);
                }
                if (QuickVideoView.this.jtX != null) {
                    long j = 0;
                    if (QuickVideoView.this.jtQ != null) {
                        j = QuickVideoView.this.jtQ.getDuration();
                    }
                    QuickVideoView.this.jtX.ez(j);
                    QuickVideoView.this.cxp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jtX.cxi();
                        QuickVideoView.this.cxt();
                    }
                }
                if (QuickVideoView.this.jun && (GP = x.cxW().GP(QuickVideoView.this.juk)) > 0 && QuickVideoView.this.jtQ != null) {
                    if (QuickVideoView.this.jtQ.isPlayerReuse()) {
                        if (QuickVideoView.this.jtQ.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ai(GP);
                        }
                    } else {
                        QuickVideoView.this.Ai(GP);
                    }
                }
                if (QuickVideoView.this.jtW) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jtO != null && gVar != null) {
                    QuickVideoView.this.jtO.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jua);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jtP) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jtP);
                }
                if (QuickVideoView.this.juf != null && QuickVideoView.this.juf.cyq()) {
                    com.baidu.tieba.play.b.e.Ao(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rL(true);
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.EO(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jtT = null;
                }
                if (!QuickVideoView.this.eaN || QuickVideoView.this.jtX == null) {
                    if (QuickVideoView.this.jtX != null) {
                        QuickVideoView.this.jtX.onCompletion();
                    }
                    QuickVideoView.this.jtW = false;
                    x.cxW().remove(QuickVideoView.this.juk);
                    if (QuickVideoView.this.dQW != null) {
                        QuickVideoView.this.dQW.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jtV = null;
                QuickVideoView.this.jul = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jtX.cxb());
                QuickVideoView.this.start();
            }
        };
        this.dQY = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.W(i2, i22, i3);
                QuickVideoView.this.cxq();
                if (QuickVideoView.this.jtX != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cxu()) {
                    QuickVideoView.this.jum = true;
                    x.cxW().bn(QuickVideoView.this.juk, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxZ().GR(QuickVideoView.this.juj);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jtT != null) {
                        QuickVideoView.this.jtV = QuickVideoView.this.jtT.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jul, QuickVideoView.this.aq(QuickVideoView.this.jtT.cfe(), i3 + "", QuickVideoView.this.jtT.cff()));
                        QuickVideoView.this.jtT = null;
                    }
                    QuickVideoView.this.jul = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.Am(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.An(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.dIa == null || QuickVideoView.this.dIa.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.ebb = new g.InterfaceC0582g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0582g
            public void b(g gVar) {
                if (QuickVideoView.this.jum) {
                    QuickVideoView.this.jum = false;
                    return;
                }
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.cxI();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jtX != null && z) {
                    QuickVideoView.this.jtX.onSeekComplete();
                }
                if (QuickVideoView.this.dRa != null) {
                    QuickVideoView.this.dRa.b(gVar);
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.jtR != null) {
                    QuickVideoView.this.jtR.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.jua = i22;
                    if (QuickVideoView.this.jtO != null && gVar != null) {
                        QuickVideoView.this.jtO.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jua);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.jtY.a(QuickVideoView.this.OG, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jug != null) {
                    QuickVideoView.this.jug.a(i2, i22, QuickVideoView.this.jtT);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.m(i2, i22, str);
                }
            }
        };
        this.dRc = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jtT != null) {
                    QuickVideoView.this.jtT.EQ(str);
                }
            }
        };
        this.dRd = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jul = j;
                }
            }
        };
        this.juF = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jtX != null && QuickVideoView.this.jtX.cxe() && QuickVideoView.this.jtX.cxf() && QuickVideoView.this.jtX.cxg() && QuickVideoView.this.jtQ != null) {
                    int aUo = QuickVideoView.this.jtQ.aUo();
                    int currentPosition = QuickVideoView.this.jtQ.getCurrentPosition();
                    int duration = QuickVideoView.this.jtQ.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.jup;
                    boolean z = currentPosition + aUo < duration;
                    if (aUo < QuickVideoView.this.jtX.cxh() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.jup = currentTimeMillis;
                        QuickVideoView.this.jtX.Ag(0);
                    }
                    if (QuickVideoView.this.cxs() && currentPosition == QuickVideoView.this.juq && j > 500) {
                        QuickVideoView.this.jup = currentTimeMillis;
                        QuickVideoView.this.jtX.Ag(0);
                    }
                    QuickVideoView.this.juq = currentPosition;
                    if (QuickVideoView.this.jbH == QuickVideoView.juu) {
                        QuickVideoView.this.cxt();
                    }
                }
            }
        };
        this.dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    QuickVideoView.this.stopPlayback();
                    if (QuickVideoView.this.jtX != null) {
                        QuickVideoView.this.jtX.wp(QuickVideoView.this.juj);
                    }
                    if (QuickVideoView.this.jtT != null) {
                        QuickVideoView.this.jtT.EN(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jtT = null;
                    }
                    QuickVideoView.this.cxq();
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
        this.jtO = new RenderView(context);
        this.OC = new WeakReference<>(TbadkCoreApplication.getInst());
        this.jtO.setSurfaceTextureListener(this.aTp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.jue) {
            addView(this.jtO, layoutParams);
        } else {
            addView(this.jtO, 0, layoutParams);
        }
        if (eaV != null) {
            this.jtQ = eaV.aUr();
        }
        if (this.jtQ != null) {
            this.jtQ.setOnPreparedListener(this.eaX);
            this.jtQ.setOnCompletionListener(this.eaY);
            this.jtQ.a(this.dQY);
            this.jtQ.setOnSeekCompleteListener(this.ebb);
            this.jtQ.a(this.dQZ);
            this.jtQ.a(this.dRb);
            this.jtQ.a(this.dRc);
            this.jtQ.a(this.dRd);
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
        this.juf = new com.baidu.tieba.play.b.a(this);
        this.jug = new q();
        this.juh = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.jtY = new com.baidu.tieba.j.k();
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
        this.jun = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.juj;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.jtY.cfo();
        this.OG = str2;
        if (this.juf != null) {
            this.juf.clear();
            this.juf.cyq();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.GT(str2);
            if (eaW != null) {
                this.jtT = eaW.ap(this.OG, str, "");
                if (this.jtT != null) {
                    this.jtT.a(-300, -44399, -44399, getLocateSource(), false, this.jul, "");
                    this.jtT = null;
                }
            }
        }
        if (this.jtU != null) {
            this.jtU.a(null);
            this.jtU.ceS();
            this.jtU = null;
        }
        this.jtV = null;
        this.jul = 0L;
        setVideoPath(str);
    }

    private String GL(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cNK().cNL()) {
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
            String GL = GL(str);
            this.jui = GL;
            if (this.jtX != null) {
                GL = this.jtX.wk(GL);
                if (this.jtX.cxj() != null) {
                    this.jtX.cxj().setPlayer(this);
                }
                if (eaW != null && uh(GL)) {
                    this.jtU = eaW.ET(GL);
                }
                if (this.jtU != null) {
                    this.jtU.a(new com.baidu.tieba.play.monitor.a(this.OG, this.jui, this.jtT));
                    this.jtU.ceR();
                }
                GM(GL);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !uh(GL)) {
                if (this.dIa != null) {
                    this.dIa.onError(this.jtQ, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cxZ().GR(this.juj);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(GL));
            if (this.jtT != null) {
                if (t(Uri.parse(GL)) != null) {
                    this.jtT.ceY();
                }
                this.jtT.TW();
                this.jtT = null;
            }
            this.juj = str;
            int lastIndexOf = this.juj.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.juj.length() > 4) {
                this.juk = this.juj.substring(0, lastIndexOf + 4);
            } else {
                this.juk = this.juj;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxo() {
        if (com.baidu.tbadk.coreExtra.model.f.aJJ()) {
            if (this.jtX != null && (this.jtX.cxd() || this.jtX.cxe())) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juC);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.juC, com.baidu.tbadk.coreExtra.model.f.aJI());
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juD);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.juD, com.baidu.tbadk.coreExtra.model.f.aJH());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (t(uri) != null) {
            this.jtT.EM(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aUk();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.juE = false;
        if (this.jud != null) {
            cxo();
            if (this.jtQ != null) {
                if (!this.jtZ) {
                    this.jtZ = true;
                    this.jtQ.a(this.mContext, this.mUri, this.mHeaders, this.jud, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying() && this.eaX != null) {
                    this.juE = true;
                    this.eaX.onPrepared(this.jtQ);
                }
            }
        } else if (this.jtO != null && this.jtO.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.jue) {
                addView(this.jtO, layoutParams);
            } else {
                addView(this.jtO, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aUk() {
        this.jtZ = false;
        this.jtW = false;
        if (this.jtQ != null) {
            if (this.jtQ.isPlaying() && cxu()) {
                x.cxW().bn(this.juk, this.jtQ.getCurrentPosition());
            }
            this.jtQ.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juF);
    }

    private void GM(String str) {
        this.mBitRate = 0;
        this.jux = 0;
        this.juy = 0;
        this.juz = 0;
        this.juA = 0;
        this.dVV = 0;
        if (this.jtX.cxe()) {
            this.juw = jus;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.jux = (int) t.GO(QuickVideoView.this.jui);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.jui != null && this.jui.equals(str)) {
            this.juw = jur;
        } else {
            this.juw = jut;
        }
        this.jbH = juu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxp() {
        this.jbH = juu;
        if (this.jtQ != null) {
            this.mBitRate = this.jtQ.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL(boolean z) {
        if (this.jbH == juu && this.jtQ != null) {
            this.jbH = juv;
            this.juz = this.jtQ.getDuration();
            if (z) {
                this.juA = 0;
                this.juy = this.juz;
            } else {
                this.juy = this.jtQ.getCurrentPosition();
                this.juA = this.jtQ.getCachedSize();
            }
            if (this.juy > 0) {
                if (this.juw == jur) {
                    this.jux = (int) t.GO(this.jui);
                    if (this.mBitRate > 0) {
                        long j = (this.mBitRate * (this.juy / 1000)) / 8;
                        if (this.juA < 0) {
                            this.juA = 0;
                        }
                        long j2 = this.juA + j;
                        if (this.jux > 0) {
                            j2 += this.jux;
                        }
                        setFlowCount(j2, this.juy, this.juz, this.dVV);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.juy / 1000)) / 8, this.juy, this.juz, this.dVV);
                    }
                } else if (this.juw == jus) {
                    if (this.mBitRate > 0) {
                        long j3 = (this.mBitRate * (this.juy / 1000)) / 8;
                        if (this.juA < 0) {
                            this.juA = 0;
                        }
                        long j4 = this.juA + j3;
                        if (this.jux > 0) {
                            j4 -= this.jux;
                        }
                        setFlowCount(j4, this.juy, this.juz, this.dVV);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.juy / 1000)) / 8, this.juy, this.juz, this.dVV);
                    }
                } else {
                    setFlowCount(0L, this.juy, this.juz, this.dVV);
                }
            }
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juF);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.juo) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.OC, false);
        }
        cxq();
        rL(false);
        if (this.juf != null) {
            this.juf.clear();
        }
        this.jtP = null;
        this.jtW = false;
        if (this.jtQ != null) {
            if (this.jtQ.isPlaying() && cxu()) {
                x.cxW().bn(this.juk, this.jtQ.getCurrentPosition());
            }
            this.jtQ.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juF);
        this.eaN = false;
        if (this.jtX != null) {
            this.jtX.cxc();
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.jtT != null && this.jtT.EP(getLocateSource())) {
            this.jtT = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juF);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.OC, false);
        }
        cxq();
        rL(false);
        if (this.juf != null) {
            this.juf.clear();
        }
        this.jtP = null;
        aUk();
        TbVideoViewSet.cxZ().GR(this.juj);
        this.eaN = false;
        if (this.jtX != null) {
            this.jtX.GK(this.juj);
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.jtT != null && this.jtT.EP(getLocateSource())) {
            this.jtT = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juF);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.juB = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxq() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juC);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juD);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnPreparedListener(g.f fVar) {
        this.dQX = fVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnCompletionListener(g.a aVar) {
        this.dQW = aVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnErrorListener(g.b bVar) {
        this.dIa = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnSeekCompleteListener(g.InterfaceC0582g interfaceC0582g) {
        this.dRa = interfaceC0582g;
    }

    @Override // com.baidu.tieba.play.a.a
    @Deprecated
    public void cxr() {
        cxq();
        if (this.jug != null) {
            this.jug.onPrepared();
        }
        if (this.jtT != null && this.jtQ != null) {
            this.jtT.yb(this.jtQ.getPlayerType());
        }
        this.jtY.cfp();
        if (this.jtX != null) {
            long j = 0;
            if (this.jtQ != null) {
                j = this.jtQ.getDuration();
            }
            this.jtX.ez(j);
            cxp();
            if (getPlayerType() == -200) {
                this.jtX.cxi();
                cxt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.juh == null) {
            return "";
        }
        String cys = this.juh.cys();
        this.juh.ar(str, str2, str3);
        return cys;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.jtX != null && !StringUtils.isNull(this.jtX.cxb())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.GS(uri);
                }
            }
            this.mUri = Uri.parse(this.jtX.cxb());
        }
        boolean z = false;
        if (this.juf != null) {
            z = this.juf.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.jtT != null) {
            this.jtV = this.jtT.a(i, i2, i3, getLocateSource(), z, this.jul, aq(this.jtT.cfe(), i3 + "", this.jtT.cff()));
            this.jtT = null;
        }
        this.jul = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.jtQ != null) {
            try {
                if (this.jtQ.isPlaying() && cxu()) {
                    x.cxW().bn(this.juk, this.jtQ.getCurrentPosition());
                }
                this.jtQ.release();
                this.jtP = str;
                URI uri = new URI(this.mUri.toString());
                this.jtQ.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.jud, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (t(this.mUri) != null) {
                    this.jtT.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jtQ != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.jtQ.isPlaying() && cxu()) {
                x.cxW().bn(this.juk, this.jtQ.getCurrentPosition());
            }
            this.jtQ.release();
            this.jtQ.a(this.mContext, this.mUri, this.mHeaders, this.jud, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (t(this.mUri) != null) {
                this.jtT.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jtQ != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.jtQ.forceUseSystemMediaPlayer(true);
            }
            if (this.jtQ.isPlaying() && cxu()) {
                x.cxW().bn(this.juk, this.jtQ.getCurrentPosition());
            }
            this.jtQ.release();
            this.jtQ.a(this.mContext, this.mUri, this.mHeaders, this.jud, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (t(this.mUri) != null) {
                this.jtT.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.jtW = true;
        if (this.jtQ != null) {
            if (this.jud != null && this.juc && !this.jtQ.isExistInRemote()) {
                this.jtQ.a(this.mContext, this.mUri, this.mHeaders, this.jud, this.jub);
                if (this.jtv != null) {
                    this.jtv.cwY();
                }
                if (t(this.mUri) != null) {
                    this.jtT.cfa();
                }
                cxo();
                return;
            }
            if (!this.jtQ.aUp()) {
                af.a(this.OC, true);
                this.jtQ.setVolume(1.0f, 1.0f);
            }
            this.jtY.cfq();
            this.jtQ.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.jtX != null) {
            this.jtX.onStart();
        }
        if (this.jtS != null) {
            this.jtS.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (t(this.mUri) != null && this.jtQ != null) {
            this.jtT.yc(this.jtQ.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jtW) {
            b(aVar);
            return;
        }
        this.jtW = true;
        if (aVar != null) {
            this.juo = true;
            if (!cxx()) {
                aVar.cya();
            }
        } else {
            this.juo = false;
        }
        setVideoPath(this.juj, this.OG);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cxq();
        af.a(this.OC, false);
        if (this.jtQ != null) {
            if (this.jtQ.isPlaying() && cxu()) {
                x.cxW().bn(this.juk, this.jtQ.getCurrentPosition());
            }
            this.jtQ.pause();
        }
        if (this.jtX != null) {
            this.jtX.onPause();
        }
        this.jtW = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jtT != null) {
            this.jtT.cfd();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.jtQ != null) {
            return this.jtQ.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.jtQ != null) {
            return this.jtQ.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.tieba.play.a.a
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.dVV = i;
        Ai(i);
    }

    public void Ai(int i) {
        if (this.jug != null) {
            this.jug.cxH();
        }
        if (this.jtQ != null) {
            this.jtQ.seekTo(i);
        }
        if (this.jtX != null) {
            this.jtX.Ag(0);
            cxt();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.jtQ != null) {
            return this.jtQ.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.jtQ != null) {
            this.jtQ.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.jub = i;
    }

    public int getRecoveryState() {
        return this.jub;
    }

    public void setNeedRecovery(boolean z) {
        this.juc = z;
    }

    public void setLooping(boolean z) {
        this.eaN = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cxs() {
        return this.jtW;
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
        this.dIe = bVar;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setBusiness(d dVar) {
        this.jtX = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dRk);
    }

    public void setMute(boolean z) {
        if (z) {
            this.jtQ.setVolume(0.0f, 0.0f);
            af.a(this.OC, false);
            return;
        }
        af.a(this.OC, true);
        this.jtQ.setVolume(1.0f, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eaN = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jtQ != null) {
            this.jtQ.aUq();
        }
        if (this.jug != null) {
            this.jug.DV();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juF);
        MessageManager.getInstance().unRegisterListener(this.dRk);
        if (this.juf != null) {
            this.juf.clear();
        }
        if (this.jtU != null) {
            this.jtU.a(null);
            this.jtU.ceS();
        }
    }

    public g getPlayer() {
        return this.jtQ;
    }

    public int getPlayerType() {
        if (this.jtQ == null) {
            return -300;
        }
        return this.jtQ.getPlayerType();
    }

    public void cxt() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juF);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.juF, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.jtv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.jtX instanceof n) || ((n) this.jtX).cxG() == null) ? "" : ((n) this.jtX).cxG().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i t(Uri uri) {
        String uri2;
        if (this.jtT != null) {
            return this.jtT;
        }
        if (!StringUtils.isNull(this.jui)) {
            uri2 = this.jui;
        } else if (eaW != null && this.jtX != null && !StringUtils.isNull(this.jtX.cxb())) {
            uri2 = this.jtX.cxb();
        } else {
            uri2 = (eaW == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && eaW != null) {
            this.jtT = eaW.ap(this.OG, uri2, this.jtV);
        }
        this.jtV = null;
        this.jul = 0L;
        return this.jtT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxu() {
        return this.jtQ != null && this.jtQ.getDuration() >= this.jtQ.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.jtT, j, j2, j3, j4);
    }

    public static boolean uh(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cxv() {
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
            this.juo = true;
            if (!cxx()) {
                aVar.cya();
            }
            if (!cxw()) {
                aVar.cyb();
                this.jtW = true;
                setVideoPath(this.juj, this.OG);
                return;
            }
        } else {
            this.juo = false;
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxw() {
        return this == TbVideoViewSet.cxZ().GQ(this.juj);
    }

    private boolean cxx() {
        return getParent() != null;
    }

    private void clearCallbacks() {
        this.dQW = null;
        this.dIa = null;
        this.dQZ = null;
        this.eaX = null;
        this.ebb = null;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setTryUseViewInSet(boolean z) {
        this.juo = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jtR = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.jtQ != null) {
            return this.jtQ.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.jtQ != null ? this.jtQ.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void setPageTypeForPerfStat(String str) {
        this.jtY.setPageTypeForPerfStat(str);
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.jtT != null) {
            this.jtT.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.jtS = cVar;
    }
}
