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
    private static int jum = 0;
    private static int jun = 1;
    private static int juo = 2;
    private static int jup = 1;
    private static int juq = 0;
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
    private int jbC;
    private RenderView jtJ;
    private String jtK;
    private g jtL;
    private g.e jtM;
    private c jtN;
    private com.baidu.tieba.j.i jtO;
    private com.baidu.tieba.j.e jtP;
    private String jtQ;
    private boolean jtR;
    private d jtS;
    private com.baidu.tieba.j.k jtT;
    private boolean jtU;
    private int jtV;
    private int jtW;
    private boolean jtX;
    private SurfaceTexture jtY;
    private boolean jtZ;
    private a jtq;
    private Runnable juA;
    private com.baidu.tieba.play.b.a jua;
    private q jub;
    private com.baidu.tieba.play.b.f juc;
    private String jud;
    private String jue;
    private String juf;
    private long jug;
    private boolean juh;
    private boolean jui;
    private boolean juj;
    private long juk;
    private long jul;
    private int jur;
    private int jus;
    private int jut;
    private int juu;
    private int juv;
    private boolean juw;
    private Runnable jux;
    private Runnable juy;
    public boolean juz;
    private int mBitRate;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void cwW();
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
        this.jtZ = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.jtR = false;
        this.jtU = false;
        this.jtV = 0;
        this.eaN = false;
        this.jtW = -1;
        this.jtX = false;
        this.jtY = null;
        this.jtZ = true;
        this.juj = false;
        this.juk = 0L;
        this.jul = 0L;
        this.jbC = juq;
        this.jur = 0;
        this.mBitRate = 0;
        this.jus = -1;
        this.jut = 0;
        this.juu = 0;
        this.juv = 0;
        this.dVV = 0;
        this.juw = false;
        this.OC = null;
        this.jux = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtL != null && QuickVideoView.this.jtR) {
                    QuickVideoView.this.b(QuickVideoView.this.jtL, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.juy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.oO(false);
                }
            }
        };
        this.juz = false;
        this.aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.juw) {
                    QuickVideoView.this.juw = false;
                    if (QuickVideoView.this.jtL != null) {
                        QuickVideoView.this.jtL.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jtU || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jtL != null) {
                        if (QuickVideoView.this.cxu()) {
                            QuickVideoView.this.jtL.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jtX) {
                            QuickVideoView.this.jtL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jtW);
                            if (QuickVideoView.this.jtq != null) {
                                QuickVideoView.this.jtq.cwW();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jtO.cfa();
                            }
                        }
                    }
                } else if (cxx()) {
                    if (QuickVideoView.this.jtL != null) {
                        QuickVideoView.this.cxm();
                        QuickVideoView.this.jtU = true;
                        QuickVideoView.this.jtL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jtO.ceZ();
                    }
                }
                QuickVideoView.this.jtY = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.juw) {
                    QuickVideoView.this.cxo();
                    QuickVideoView.this.rL(false);
                    if (QuickVideoView.this.jtL != null) {
                        if (QuickVideoView.this.jtL.isPlaying() && QuickVideoView.this.cxs()) {
                            x.cxU().bn(QuickVideoView.this.juf, QuickVideoView.this.jtL.getCurrentPosition());
                            if (QuickVideoView.this.juj) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.juj) {
                            QuickVideoView.this.jtL.release();
                        }
                    }
                    if (QuickVideoView.this.jtU) {
                        if (QuickVideoView.this.jtS != null && !QuickVideoView.this.juj) {
                            QuickVideoView.this.jtS.GK(QuickVideoView.this.jue);
                        }
                        if (QuickVideoView.this.dIe != null) {
                            QuickVideoView.this.dIe.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jtY = null;
                    if (QuickVideoView.this.jtO != null && QuickVideoView.this.jtO.EP(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jtO = null;
                    }
                    if (!QuickVideoView.this.juj) {
                        QuickVideoView.this.jtU = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cxx() {
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
                QuickVideoView.this.cxo();
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.onPrepared();
                }
                if (QuickVideoView.this.jtO != null && QuickVideoView.this.jtL != null) {
                    QuickVideoView.this.jtO.yb(QuickVideoView.this.jtL.getPlayerType());
                }
                if (QuickVideoView.this.juj) {
                    TbVideoViewSet.cxX().a(QuickVideoView.this, QuickVideoView.this.jue);
                }
                if (QuickVideoView.this.dQX != null) {
                    QuickVideoView.this.jtT.cfp();
                    QuickVideoView.this.dQX.onPrepared(gVar);
                }
                if (QuickVideoView.this.jtS != null) {
                    long j = 0;
                    if (QuickVideoView.this.jtL != null) {
                        j = QuickVideoView.this.jtL.getDuration();
                    }
                    QuickVideoView.this.jtS.ez(j);
                    QuickVideoView.this.cxn();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jtS.cxg();
                        QuickVideoView.this.cxr();
                    }
                }
                if (QuickVideoView.this.jui && (GP = x.cxU().GP(QuickVideoView.this.juf)) > 0 && QuickVideoView.this.jtL != null) {
                    if (QuickVideoView.this.jtL.isPlayerReuse()) {
                        if (QuickVideoView.this.jtL.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ai(GP);
                        }
                    } else {
                        QuickVideoView.this.Ai(GP);
                    }
                }
                if (QuickVideoView.this.jtR) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jtJ != null && gVar != null) {
                    QuickVideoView.this.jtJ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jtV);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jtK) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jtK);
                }
                if (QuickVideoView.this.jua != null && QuickVideoView.this.jua.cyo()) {
                    com.baidu.tieba.play.b.e.Ao(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rL(true);
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.EO(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jtO = null;
                }
                if (!QuickVideoView.this.eaN || QuickVideoView.this.jtS == null) {
                    if (QuickVideoView.this.jtS != null) {
                        QuickVideoView.this.jtS.onCompletion();
                    }
                    QuickVideoView.this.jtR = false;
                    x.cxU().remove(QuickVideoView.this.juf);
                    if (QuickVideoView.this.dQW != null) {
                        QuickVideoView.this.dQW.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jtQ = null;
                QuickVideoView.this.jug = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jtS.cwZ());
                QuickVideoView.this.start();
            }
        };
        this.dQY = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.W(i, i2, i3);
                QuickVideoView.this.cxo();
                if (QuickVideoView.this.jtS != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cxs()) {
                    QuickVideoView.this.juh = true;
                    x.cxU().bn(QuickVideoView.this.juf, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxX().GR(QuickVideoView.this.jue);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jtO != null) {
                        QuickVideoView.this.jtQ = QuickVideoView.this.jtO.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jug, QuickVideoView.this.aq(QuickVideoView.this.jtO.cfe(), i3 + "", QuickVideoView.this.jtO.cff()));
                        QuickVideoView.this.jtO = null;
                    }
                    QuickVideoView.this.jug = 0L;
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
                if (QuickVideoView.this.juh) {
                    QuickVideoView.this.juh = false;
                    return;
                }
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.cxG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jtS != null && z) {
                    QuickVideoView.this.jtS.onSeekComplete();
                }
                if (QuickVideoView.this.dRa != null) {
                    QuickVideoView.this.dRa.b(gVar);
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jtM != null) {
                    QuickVideoView.this.jtM.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jtV = i2;
                    if (QuickVideoView.this.jtJ != null && gVar != null) {
                        QuickVideoView.this.jtJ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jtV);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jtT.a(QuickVideoView.this.OG, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.a(i, i2, QuickVideoView.this.jtO);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.m(i, i2, str);
                }
            }
        };
        this.dRc = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.EQ(str);
                }
            }
        };
        this.dRd = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jug = j;
                }
            }
        };
        this.juA = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jtS != null && QuickVideoView.this.jtS.cxc() && QuickVideoView.this.jtS.cxd() && QuickVideoView.this.jtS.cxe() && QuickVideoView.this.jtL != null) {
                    int aUo = QuickVideoView.this.jtL.aUo();
                    int currentPosition = QuickVideoView.this.jtL.getCurrentPosition();
                    int duration = QuickVideoView.this.jtL.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.juk;
                    boolean z = currentPosition + aUo < duration;
                    if (aUo < QuickVideoView.this.jtS.cxf() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.juk = currentTimeMillis;
                        QuickVideoView.this.jtS.Ag(0);
                    }
                    if (QuickVideoView.this.cxq() && currentPosition == QuickVideoView.this.jul && j > 500) {
                        QuickVideoView.this.juk = currentTimeMillis;
                        QuickVideoView.this.jtS.Ag(0);
                    }
                    QuickVideoView.this.jul = currentPosition;
                    if (QuickVideoView.this.jbC == QuickVideoView.jup) {
                        QuickVideoView.this.cxr();
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
                    if (QuickVideoView.this.jtS != null) {
                        QuickVideoView.this.jtS.wp(QuickVideoView.this.jue);
                    }
                    if (QuickVideoView.this.jtO != null) {
                        QuickVideoView.this.jtO.EN(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jtO = null;
                    }
                    QuickVideoView.this.cxo();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtR = false;
        this.jtU = false;
        this.jtV = 0;
        this.eaN = false;
        this.jtW = -1;
        this.jtX = false;
        this.jtY = null;
        this.jtZ = true;
        this.juj = false;
        this.juk = 0L;
        this.jul = 0L;
        this.jbC = juq;
        this.jur = 0;
        this.mBitRate = 0;
        this.jus = -1;
        this.jut = 0;
        this.juu = 0;
        this.juv = 0;
        this.dVV = 0;
        this.juw = false;
        this.OC = null;
        this.jux = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtL != null && QuickVideoView.this.jtR) {
                    QuickVideoView.this.b(QuickVideoView.this.jtL, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.juy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.oO(false);
                }
            }
        };
        this.juz = false;
        this.aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.juw) {
                    QuickVideoView.this.juw = false;
                    if (QuickVideoView.this.jtL != null) {
                        QuickVideoView.this.jtL.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jtU || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jtL != null) {
                        if (QuickVideoView.this.cxu()) {
                            QuickVideoView.this.jtL.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jtX) {
                            QuickVideoView.this.jtL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jtW);
                            if (QuickVideoView.this.jtq != null) {
                                QuickVideoView.this.jtq.cwW();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jtO.cfa();
                            }
                        }
                    }
                } else if (cxx()) {
                    if (QuickVideoView.this.jtL != null) {
                        QuickVideoView.this.cxm();
                        QuickVideoView.this.jtU = true;
                        QuickVideoView.this.jtL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jtO.ceZ();
                    }
                }
                QuickVideoView.this.jtY = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.juw) {
                    QuickVideoView.this.cxo();
                    QuickVideoView.this.rL(false);
                    if (QuickVideoView.this.jtL != null) {
                        if (QuickVideoView.this.jtL.isPlaying() && QuickVideoView.this.cxs()) {
                            x.cxU().bn(QuickVideoView.this.juf, QuickVideoView.this.jtL.getCurrentPosition());
                            if (QuickVideoView.this.juj) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.juj) {
                            QuickVideoView.this.jtL.release();
                        }
                    }
                    if (QuickVideoView.this.jtU) {
                        if (QuickVideoView.this.jtS != null && !QuickVideoView.this.juj) {
                            QuickVideoView.this.jtS.GK(QuickVideoView.this.jue);
                        }
                        if (QuickVideoView.this.dIe != null) {
                            QuickVideoView.this.dIe.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jtY = null;
                    if (QuickVideoView.this.jtO != null && QuickVideoView.this.jtO.EP(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jtO = null;
                    }
                    if (!QuickVideoView.this.juj) {
                        QuickVideoView.this.jtU = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cxx() {
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
                QuickVideoView.this.cxo();
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.onPrepared();
                }
                if (QuickVideoView.this.jtO != null && QuickVideoView.this.jtL != null) {
                    QuickVideoView.this.jtO.yb(QuickVideoView.this.jtL.getPlayerType());
                }
                if (QuickVideoView.this.juj) {
                    TbVideoViewSet.cxX().a(QuickVideoView.this, QuickVideoView.this.jue);
                }
                if (QuickVideoView.this.dQX != null) {
                    QuickVideoView.this.jtT.cfp();
                    QuickVideoView.this.dQX.onPrepared(gVar);
                }
                if (QuickVideoView.this.jtS != null) {
                    long j = 0;
                    if (QuickVideoView.this.jtL != null) {
                        j = QuickVideoView.this.jtL.getDuration();
                    }
                    QuickVideoView.this.jtS.ez(j);
                    QuickVideoView.this.cxn();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jtS.cxg();
                        QuickVideoView.this.cxr();
                    }
                }
                if (QuickVideoView.this.jui && (GP = x.cxU().GP(QuickVideoView.this.juf)) > 0 && QuickVideoView.this.jtL != null) {
                    if (QuickVideoView.this.jtL.isPlayerReuse()) {
                        if (QuickVideoView.this.jtL.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ai(GP);
                        }
                    } else {
                        QuickVideoView.this.Ai(GP);
                    }
                }
                if (QuickVideoView.this.jtR) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jtJ != null && gVar != null) {
                    QuickVideoView.this.jtJ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jtV);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jtK) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jtK);
                }
                if (QuickVideoView.this.jua != null && QuickVideoView.this.jua.cyo()) {
                    com.baidu.tieba.play.b.e.Ao(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rL(true);
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.EO(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jtO = null;
                }
                if (!QuickVideoView.this.eaN || QuickVideoView.this.jtS == null) {
                    if (QuickVideoView.this.jtS != null) {
                        QuickVideoView.this.jtS.onCompletion();
                    }
                    QuickVideoView.this.jtR = false;
                    x.cxU().remove(QuickVideoView.this.juf);
                    if (QuickVideoView.this.dQW != null) {
                        QuickVideoView.this.dQW.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jtQ = null;
                QuickVideoView.this.jug = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jtS.cwZ());
                QuickVideoView.this.start();
            }
        };
        this.dQY = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.W(i, i2, i3);
                QuickVideoView.this.cxo();
                if (QuickVideoView.this.jtS != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cxs()) {
                    QuickVideoView.this.juh = true;
                    x.cxU().bn(QuickVideoView.this.juf, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxX().GR(QuickVideoView.this.jue);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jtO != null) {
                        QuickVideoView.this.jtQ = QuickVideoView.this.jtO.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jug, QuickVideoView.this.aq(QuickVideoView.this.jtO.cfe(), i3 + "", QuickVideoView.this.jtO.cff()));
                        QuickVideoView.this.jtO = null;
                    }
                    QuickVideoView.this.jug = 0L;
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
                if (QuickVideoView.this.juh) {
                    QuickVideoView.this.juh = false;
                    return;
                }
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.cxG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jtS != null && z) {
                    QuickVideoView.this.jtS.onSeekComplete();
                }
                if (QuickVideoView.this.dRa != null) {
                    QuickVideoView.this.dRa.b(gVar);
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.jtM != null) {
                    QuickVideoView.this.jtM.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.jtV = i2;
                    if (QuickVideoView.this.jtJ != null && gVar != null) {
                        QuickVideoView.this.jtJ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jtV);
                    }
                } else if (i == 3) {
                    QuickVideoView.this.jtT.a(QuickVideoView.this.OG, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.a(i, i2, QuickVideoView.this.jtO);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.m(i, i2, str);
                }
            }
        };
        this.dRc = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.EQ(str);
                }
            }
        };
        this.dRd = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jug = j;
                }
            }
        };
        this.juA = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jtS != null && QuickVideoView.this.jtS.cxc() && QuickVideoView.this.jtS.cxd() && QuickVideoView.this.jtS.cxe() && QuickVideoView.this.jtL != null) {
                    int aUo = QuickVideoView.this.jtL.aUo();
                    int currentPosition = QuickVideoView.this.jtL.getCurrentPosition();
                    int duration = QuickVideoView.this.jtL.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.juk;
                    boolean z = currentPosition + aUo < duration;
                    if (aUo < QuickVideoView.this.jtS.cxf() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.juk = currentTimeMillis;
                        QuickVideoView.this.jtS.Ag(0);
                    }
                    if (QuickVideoView.this.cxq() && currentPosition == QuickVideoView.this.jul && j > 500) {
                        QuickVideoView.this.juk = currentTimeMillis;
                        QuickVideoView.this.jtS.Ag(0);
                    }
                    QuickVideoView.this.jul = currentPosition;
                    if (QuickVideoView.this.jbC == QuickVideoView.jup) {
                        QuickVideoView.this.cxr();
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
                    if (QuickVideoView.this.jtS != null) {
                        QuickVideoView.this.jtS.wp(QuickVideoView.this.jue);
                    }
                    if (QuickVideoView.this.jtO != null) {
                        QuickVideoView.this.jtO.EN(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jtO = null;
                    }
                    QuickVideoView.this.cxo();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtR = false;
        this.jtU = false;
        this.jtV = 0;
        this.eaN = false;
        this.jtW = -1;
        this.jtX = false;
        this.jtY = null;
        this.jtZ = true;
        this.juj = false;
        this.juk = 0L;
        this.jul = 0L;
        this.jbC = juq;
        this.jur = 0;
        this.mBitRate = 0;
        this.jus = -1;
        this.jut = 0;
        this.juu = 0;
        this.juv = 0;
        this.dVV = 0;
        this.juw = false;
        this.OC = null;
        this.jux = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtL != null && QuickVideoView.this.jtR) {
                    QuickVideoView.this.b(QuickVideoView.this.jtL, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.juy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.oO(false);
                }
            }
        };
        this.juz = false;
        this.aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.juw) {
                    QuickVideoView.this.juw = false;
                    if (QuickVideoView.this.jtL != null) {
                        QuickVideoView.this.jtL.setSurface(surfaceTexture);
                    }
                } else if (QuickVideoView.this.jtU || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.jtL != null) {
                        if (QuickVideoView.this.cxu()) {
                            QuickVideoView.this.jtL.setSurface(surfaceTexture);
                        } else if (QuickVideoView.this.jtX) {
                            QuickVideoView.this.jtL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.jtW);
                            if (QuickVideoView.this.jtq != null) {
                                QuickVideoView.this.jtq.cwW();
                            }
                            if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                                QuickVideoView.this.jtO.cfa();
                            }
                        }
                    }
                } else if (cxx()) {
                    if (QuickVideoView.this.jtL != null) {
                        QuickVideoView.this.cxm();
                        QuickVideoView.this.jtU = true;
                        QuickVideoView.this.jtL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.t(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.jtO.ceZ();
                    }
                }
                QuickVideoView.this.jtY = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.juw) {
                    QuickVideoView.this.cxo();
                    QuickVideoView.this.rL(false);
                    if (QuickVideoView.this.jtL != null) {
                        if (QuickVideoView.this.jtL.isPlaying() && QuickVideoView.this.cxs()) {
                            x.cxU().bn(QuickVideoView.this.juf, QuickVideoView.this.jtL.getCurrentPosition());
                            if (QuickVideoView.this.juj) {
                                QuickVideoView.this.pause();
                            }
                        }
                        if (!QuickVideoView.this.juj) {
                            QuickVideoView.this.jtL.release();
                        }
                    }
                    if (QuickVideoView.this.jtU) {
                        if (QuickVideoView.this.jtS != null && !QuickVideoView.this.juj) {
                            QuickVideoView.this.jtS.GK(QuickVideoView.this.jue);
                        }
                        if (QuickVideoView.this.dIe != null) {
                            QuickVideoView.this.dIe.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.jtY = null;
                    if (QuickVideoView.this.jtO != null && QuickVideoView.this.jtO.EP(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.jtO = null;
                    }
                    if (!QuickVideoView.this.juj) {
                        QuickVideoView.this.jtU = false;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean cxx() {
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
                QuickVideoView.this.cxo();
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.onPrepared();
                }
                if (QuickVideoView.this.jtO != null && QuickVideoView.this.jtL != null) {
                    QuickVideoView.this.jtO.yb(QuickVideoView.this.jtL.getPlayerType());
                }
                if (QuickVideoView.this.juj) {
                    TbVideoViewSet.cxX().a(QuickVideoView.this, QuickVideoView.this.jue);
                }
                if (QuickVideoView.this.dQX != null) {
                    QuickVideoView.this.jtT.cfp();
                    QuickVideoView.this.dQX.onPrepared(gVar);
                }
                if (QuickVideoView.this.jtS != null) {
                    long j = 0;
                    if (QuickVideoView.this.jtL != null) {
                        j = QuickVideoView.this.jtL.getDuration();
                    }
                    QuickVideoView.this.jtS.ez(j);
                    QuickVideoView.this.cxn();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.jtS.cxg();
                        QuickVideoView.this.cxr();
                    }
                }
                if (QuickVideoView.this.jui && (GP = x.cxU().GP(QuickVideoView.this.juf)) > 0 && QuickVideoView.this.jtL != null) {
                    if (QuickVideoView.this.jtL.isPlayerReuse()) {
                        if (QuickVideoView.this.jtL.getCurrentPosition() == 0) {
                            QuickVideoView.this.Ai(GP);
                        }
                    } else {
                        QuickVideoView.this.Ai(GP);
                    }
                }
                if (QuickVideoView.this.jtR) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.jtJ != null && gVar != null) {
                    QuickVideoView.this.jtJ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jtV);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.jtK) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.d(QuickVideoView.this.mUri, QuickVideoView.this.jtK);
                }
                if (QuickVideoView.this.jua != null && QuickVideoView.this.jua.cyo()) {
                    com.baidu.tieba.play.b.e.Ao(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.eaY = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.rL(true);
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.EO(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.jtO = null;
                }
                if (!QuickVideoView.this.eaN || QuickVideoView.this.jtS == null) {
                    if (QuickVideoView.this.jtS != null) {
                        QuickVideoView.this.jtS.onCompletion();
                    }
                    QuickVideoView.this.jtR = false;
                    x.cxU().remove(QuickVideoView.this.juf);
                    if (QuickVideoView.this.dQW != null) {
                        QuickVideoView.this.dQW.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.jtQ = null;
                QuickVideoView.this.jug = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.jtS.cwZ());
                QuickVideoView.this.start();
            }
        };
        this.dQY = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.W(i2, i22, i3);
                QuickVideoView.this.cxo();
                if (QuickVideoView.this.jtS != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.cxs()) {
                    QuickVideoView.this.juh = true;
                    x.cxU().bn(QuickVideoView.this.juf, QuickVideoView.this.getCurrentPosition());
                }
                TbVideoViewSet.cxX().GR(QuickVideoView.this.jue);
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (QuickVideoView.this.jtO != null) {
                        QuickVideoView.this.jtQ = QuickVideoView.this.jtO.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.jug, QuickVideoView.this.aq(QuickVideoView.this.jtO.cfe(), i3 + "", QuickVideoView.this.jtO.cff()));
                        QuickVideoView.this.jtO = null;
                    }
                    QuickVideoView.this.jug = 0L;
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
                if (QuickVideoView.this.juh) {
                    QuickVideoView.this.juh = false;
                    return;
                }
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.cxG();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.jtS != null && z) {
                    QuickVideoView.this.jtS.onSeekComplete();
                }
                if (QuickVideoView.this.dRa != null) {
                    QuickVideoView.this.dRa.b(gVar);
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.jtM != null) {
                    QuickVideoView.this.jtM.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.jtV = i22;
                    if (QuickVideoView.this.jtJ != null && gVar != null) {
                        QuickVideoView.this.jtJ.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.jtV);
                    }
                } else if (i2 == 3) {
                    QuickVideoView.this.jtT.a(QuickVideoView.this.OG, -1L, QuickVideoView.this.getDuration(), QuickVideoView.this);
                }
                if (QuickVideoView.this.jub != null) {
                    QuickVideoView.this.jub.a(i2, i22, QuickVideoView.this.jtO);
                    return true;
                }
                return true;
            }
        };
        this.dRb = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.m(i2, i22, str);
                }
            }
        };
        this.dRc = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.jtO != null) {
                    QuickVideoView.this.jtO.EQ(str);
                }
            }
        };
        this.dRd = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.jug = j;
                }
            }
        };
        this.juA = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.jtS != null && QuickVideoView.this.jtS.cxc() && QuickVideoView.this.jtS.cxd() && QuickVideoView.this.jtS.cxe() && QuickVideoView.this.jtL != null) {
                    int aUo = QuickVideoView.this.jtL.aUo();
                    int currentPosition = QuickVideoView.this.jtL.getCurrentPosition();
                    int duration = QuickVideoView.this.jtL.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.juk;
                    boolean z = currentPosition + aUo < duration;
                    if (aUo < QuickVideoView.this.jtS.cxf() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.juk = currentTimeMillis;
                        QuickVideoView.this.jtS.Ag(0);
                    }
                    if (QuickVideoView.this.cxq() && currentPosition == QuickVideoView.this.jul && j > 500) {
                        QuickVideoView.this.juk = currentTimeMillis;
                        QuickVideoView.this.jtS.Ag(0);
                    }
                    QuickVideoView.this.jul = currentPosition;
                    if (QuickVideoView.this.jbC == QuickVideoView.jup) {
                        QuickVideoView.this.cxr();
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
                    if (QuickVideoView.this.jtS != null) {
                        QuickVideoView.this.jtS.wp(QuickVideoView.this.jue);
                    }
                    if (QuickVideoView.this.jtO != null) {
                        QuickVideoView.this.jtO.EN(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.jtO = null;
                    }
                    QuickVideoView.this.cxo();
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
        this.jtJ = new RenderView(context);
        this.OC = new WeakReference<>(TbadkCoreApplication.getInst());
        this.jtJ.setSurfaceTextureListener(this.aTp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.jtZ) {
            addView(this.jtJ, layoutParams);
        } else {
            addView(this.jtJ, 0, layoutParams);
        }
        if (eaV != null) {
            this.jtL = eaV.aUr();
        }
        if (this.jtL != null) {
            this.jtL.setOnPreparedListener(this.eaX);
            this.jtL.setOnCompletionListener(this.eaY);
            this.jtL.a(this.dQY);
            this.jtL.setOnSeekCompleteListener(this.ebb);
            this.jtL.a(this.dQZ);
            this.jtL.a(this.dRb);
            this.jtL.a(this.dRc);
            this.jtL.a(this.dRd);
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
        this.jua = new com.baidu.tieba.play.b.a(this);
        this.jub = new q();
        this.juc = new com.baidu.tieba.play.b.f();
        am.setBackgroundResource(this, R.color.black_alpha100);
        this.jtT = new com.baidu.tieba.j.k();
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
        this.jui = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public String getOriginUrl() {
        return this.jue;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVideoPath(String str, String str2) {
        this.jtT.cfo();
        this.OG = str2;
        if (this.jua != null) {
            this.jua.clear();
            this.jua.cyo();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.GT(str2);
            if (eaW != null) {
                this.jtO = eaW.ap(this.OG, str, "");
                if (this.jtO != null) {
                    this.jtO.a(-300, -44399, -44399, getLocateSource(), false, this.jug, "");
                    this.jtO = null;
                }
            }
        }
        if (this.jtP != null) {
            this.jtP.a(null);
            this.jtP.ceS();
            this.jtP = null;
        }
        this.jtQ = null;
        this.jug = 0L;
        setVideoPath(str);
    }

    private String GL(String str) {
        if (!aq.isEmpty(str) && com.baidu.tieba.video.g.cNI().cNJ()) {
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
            this.jud = GL;
            if (this.jtS != null) {
                GL = this.jtS.wk(GL);
                if (this.jtS.cxh() != null) {
                    this.jtS.cxh().setPlayer(this);
                }
                if (eaW != null && uh(GL)) {
                    this.jtP = eaW.ET(GL);
                }
                if (this.jtP != null) {
                    this.jtP.a(new com.baidu.tieba.play.monitor.a(this.OG, this.jud, this.jtO));
                    this.jtP.ceR();
                }
                GM(GL);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && !uh(GL)) {
                if (this.dIa != null) {
                    this.dIa.onError(this.jtL, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER, DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
                    TbVideoViewSet.cxX().GR(this.jue);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(GL));
            if (this.jtO != null) {
                if (t(Uri.parse(GL)) != null) {
                    this.jtO.ceY();
                }
                this.jtO.TW();
                this.jtO = null;
            }
            this.jue = str;
            int lastIndexOf = this.jue.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.jue.length() > 4) {
                this.juf = this.jue.substring(0, lastIndexOf + 4);
            } else {
                this.juf = this.jue;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxm() {
        if (com.baidu.tbadk.coreExtra.model.f.aJJ()) {
            if (this.jtS != null && (this.jtS.cxb() || this.jtS.cxc())) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jux);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.jux, com.baidu.tbadk.coreExtra.model.f.aJI());
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juy);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.juy, com.baidu.tbadk.coreExtra.model.f.aJH());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (t(uri) != null) {
            this.jtO.EM(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            aUk();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.juz = false;
        if (this.jtY != null) {
            cxm();
            if (this.jtL != null) {
                if (!this.jtU) {
                    this.jtU = true;
                    this.jtL.a(this.mContext, this.mUri, this.mHeaders, this.jtY, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying() && this.eaX != null) {
                    this.juz = true;
                    this.eaX.onPrepared(this.jtL);
                }
            }
        } else if (this.jtJ != null && this.jtJ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.jtZ) {
                addView(this.jtJ, layoutParams);
            } else {
                addView(this.jtJ, 0, layoutParams);
            }
        }
        am.setBackgroundResource(this, R.color.black_alpha100);
    }

    private void aUk() {
        this.jtU = false;
        this.jtR = false;
        if (this.jtL != null) {
            if (this.jtL.isPlaying() && cxs()) {
                x.cxU().bn(this.juf, this.jtL.getCurrentPosition());
            }
            this.jtL.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
    }

    private void GM(String str) {
        this.mBitRate = 0;
        this.jus = 0;
        this.jut = 0;
        this.juu = 0;
        this.juv = 0;
        this.dVV = 0;
        if (this.jtS.cxc()) {
            this.jur = jun;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.jus = (int) t.GO(QuickVideoView.this.jud);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.jud != null && this.jud.equals(str)) {
            this.jur = jum;
        } else {
            this.jur = juo;
        }
        this.jbC = jup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxn() {
        this.jbC = jup;
        if (this.jtL != null) {
            this.mBitRate = this.jtL.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL(boolean z) {
        if (this.jbC == jup && this.jtL != null) {
            this.jbC = juq;
            this.juu = this.jtL.getDuration();
            if (z) {
                this.juv = 0;
                this.jut = this.juu;
            } else {
                this.jut = this.jtL.getCurrentPosition();
                this.juv = this.jtL.getCachedSize();
            }
            if (this.jut > 0) {
                if (this.jur == jum) {
                    this.jus = (int) t.GO(this.jud);
                    if (this.mBitRate > 0) {
                        long j = (this.mBitRate * (this.jut / 1000)) / 8;
                        if (this.juv < 0) {
                            this.juv = 0;
                        }
                        long j2 = this.juv + j;
                        if (this.jus > 0) {
                            j2 += this.jus;
                        }
                        setFlowCount(j2, this.jut, this.juu, this.dVV);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jut / 1000)) / 8, this.jut, this.juu, this.dVV);
                    }
                } else if (this.jur == jun) {
                    if (this.mBitRate > 0) {
                        long j3 = (this.mBitRate * (this.jut / 1000)) / 8;
                        if (this.juv < 0) {
                            this.juv = 0;
                        }
                        long j4 = this.juv + j3;
                        if (this.jus > 0) {
                            j4 -= this.jus;
                        }
                        setFlowCount(j4, this.jut, this.juu, this.dVV);
                    } else if (this.mBitRate == -1) {
                        this.mBitRate = 603327;
                        setFlowCount((this.mBitRate * (this.jut / 1000)) / 8, this.jut, this.juu, this.dVV);
                    }
                } else {
                    setFlowCount(0L, this.jut, this.juu, this.dVV);
                }
            }
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stop() {
        if (!this.juj) {
            stopPlayback();
            return;
        }
        if (this.mUri != null && isPlaying()) {
            af.a(this.OC, false);
        }
        cxo();
        rL(false);
        if (this.jua != null) {
            this.jua.clear();
        }
        this.jtK = null;
        this.jtR = false;
        if (this.jtL != null) {
            if (this.jtL.isPlaying() && cxs()) {
                x.cxU().bn(this.juf, this.jtL.getCurrentPosition());
            }
            this.jtL.pause();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
        this.eaN = false;
        if (this.jtS != null) {
            this.jtS.cxa();
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.jtO != null && this.jtO.EP(getLocateSource())) {
            this.jtO = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
    }

    @Override // com.baidu.tieba.play.a.a
    public void stopPlayback() {
        if (this.mUri != null && isPlaying()) {
            af.a(this.OC, false);
        }
        cxo();
        rL(false);
        if (this.jua != null) {
            this.jua.clear();
        }
        this.jtK = null;
        aUk();
        TbVideoViewSet.cxX().GR(this.jue);
        this.eaN = false;
        if (this.jtS != null) {
            this.jtS.GK(this.jue);
        }
        com.baidu.adp.lib.network.http.a.b.gi().a((b.InterfaceC0018b) null);
        if (this.jtO != null && this.jtO.EP(getLocateSource())) {
            this.jtO = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
    }

    @Override // com.baidu.tieba.play.a.a
    public void setFullScreenToDestroySurface() {
        this.juw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxo() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jux);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juy);
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
    public void cxp() {
        cxo();
        if (this.jub != null) {
            this.jub.onPrepared();
        }
        if (this.jtO != null && this.jtL != null) {
            this.jtO.yb(this.jtL.getPlayerType());
        }
        this.jtT.cfp();
        if (this.jtS != null) {
            long j = 0;
            if (this.jtL != null) {
                j = this.jtL.getDuration();
            }
            this.jtS.ez(j);
            cxn();
            if (getPlayerType() == -200) {
                this.jtS.cxg();
                cxr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str, String str2, String str3) {
        if (this.juc == null) {
            return "";
        }
        String cyq = this.juc.cyq();
        this.juc.ar(str, str2, str3);
        return cyq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.jtS != null && !StringUtils.isNull(this.jtS.cwZ())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.GS(uri);
                }
            }
            this.mUri = Uri.parse(this.jtS.cwZ());
        }
        boolean z = false;
        if (this.jua != null) {
            z = this.jua.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.jtO != null) {
            this.jtQ = this.jtO.a(i, i2, i3, getLocateSource(), z, this.jug, aq(this.jtO.cfe(), i3 + "", this.jtO.cff()));
            this.jtO = null;
        }
        this.jug = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.jtL != null) {
            try {
                if (this.jtL.isPlaying() && cxs()) {
                    x.cxU().bn(this.juf, this.jtL.getCurrentPosition());
                }
                this.jtL.release();
                this.jtK = str;
                URI uri = new URI(this.mUri.toString());
                this.jtL.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.jtY, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (t(this.mUri) != null) {
                    this.jtO.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jtL != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.jtL.isPlaying() && cxs()) {
                x.cxU().bn(this.juf, this.jtL.getCurrentPosition());
            }
            this.jtL.release();
            this.jtL.a(this.mContext, this.mUri, this.mHeaders, this.jtY, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (t(this.mUri) != null) {
                this.jtO.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.jtL != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.jtL.forceUseSystemMediaPlayer(true);
            }
            if (this.jtL.isPlaying() && cxs()) {
                x.cxU().bn(this.juf, this.jtL.getCurrentPosition());
            }
            this.jtL.release();
            this.jtL.a(this.mContext, this.mUri, this.mHeaders, this.jtY, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (t(this.mUri) != null) {
                this.jtO.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.mUri != null) {
        }
        this.jtR = true;
        if (this.jtL != null) {
            if (this.jtY != null && this.jtX && !this.jtL.isExistInRemote()) {
                this.jtL.a(this.mContext, this.mUri, this.mHeaders, this.jtY, this.jtW);
                if (this.jtq != null) {
                    this.jtq.cwW();
                }
                if (t(this.mUri) != null) {
                    this.jtO.cfa();
                }
                cxm();
                return;
            }
            if (!this.jtL.aUp()) {
                af.a(this.OC, true);
                this.jtL.setVolume(1.0f, 1.0f);
            }
            this.jtT.cfq();
            this.jtL.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.jtS != null) {
            this.jtS.onStart();
        }
        if (this.jtN != null) {
            this.jtN.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (t(this.mUri) != null && this.jtL != null) {
            this.jtO.yc(this.jtL.getPlayerType());
        }
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(TbVideoViewSet.a aVar) {
        if (isPlaying() || this.jtR) {
            b(aVar);
            return;
        }
        this.jtR = true;
        if (aVar != null) {
            this.juj = true;
            if (!cxv()) {
                aVar.cxY();
            }
        } else {
            this.juj = false;
        }
        setVideoPath(this.jue, this.OG);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        cxo();
        af.a(this.OC, false);
        if (this.jtL != null) {
            if (this.jtL.isPlaying() && cxs()) {
                x.cxU().bn(this.juf, this.jtL.getCurrentPosition());
            }
            this.jtL.pause();
        }
        if (this.jtS != null) {
            this.jtS.onPause();
        }
        this.jtR = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.jtO != null) {
            this.jtO.cfd();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.jtL != null) {
            return this.jtL.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.jtL != null) {
            return this.jtL.getCurrentPosition();
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
        if (this.jub != null) {
            this.jub.cxF();
        }
        if (this.jtL != null) {
            this.jtL.seekTo(i);
        }
        if (this.jtS != null) {
            this.jtS.Ag(0);
            cxr();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.baidu.tieba.play.a.a
    public boolean isPlaying() {
        if (this.jtL != null) {
            return this.jtL.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setVolume(float f, float f2) {
        if (this.jtL != null) {
            this.jtL.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.jtW = i;
    }

    public int getRecoveryState() {
        return this.jtW;
    }

    public void setNeedRecovery(boolean z) {
        this.jtX = z;
    }

    public void setLooping(boolean z) {
        this.eaN = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public boolean cxq() {
        return this.jtR;
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
        this.jtS = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dRk);
    }

    public void setMute(boolean z) {
        if (z) {
            this.jtL.setVolume(0.0f, 0.0f);
            af.a(this.OC, false);
            return;
        }
        af.a(this.OC, true);
        this.jtL.setVolume(1.0f, 1.0f);
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
        if (this.jtL != null) {
            this.jtL.aUq();
        }
        if (this.jub != null) {
            this.jub.DV();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
        MessageManager.getInstance().unRegisterListener(this.dRk);
        if (this.jua != null) {
            this.jua.clear();
        }
        if (this.jtP != null) {
            this.jtP.a(null);
            this.jtP.ceS();
        }
    }

    public g getPlayer() {
        return this.jtL;
    }

    public int getPlayerType() {
        if (this.jtL == null) {
            return -300;
        }
        return this.jtL.getPlayerType();
    }

    public void cxr() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.juA, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.jtq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.jtS instanceof n) || ((n) this.jtS).cxE() == null) ? "" : ((n) this.jtS).cxE().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i t(Uri uri) {
        String uri2;
        if (this.jtO != null) {
            return this.jtO;
        }
        if (!StringUtils.isNull(this.jud)) {
            uri2 = this.jud;
        } else if (eaW != null && this.jtS != null && !StringUtils.isNull(this.jtS.cwZ())) {
            uri2 = this.jtS.cwZ();
        } else {
            uri2 = (eaW == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && eaW != null) {
            this.jtO = eaW.ap(this.OG, uri2, this.jtQ);
        }
        this.jtQ = null;
        this.jug = 0L;
        return this.jtO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxs() {
        return this.jtL != null && this.jtL.getDuration() >= this.jtL.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.jtO, j, j2, j3, j4);
    }

    public static boolean uh(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    @Override // com.baidu.tieba.play.a.a
    public void cxt() {
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
            this.juj = true;
            if (!cxv()) {
                aVar.cxY();
            }
            if (!cxu()) {
                aVar.cxZ();
                this.jtR = true;
                setVideoPath(this.jue, this.OG);
                return;
            }
        } else {
            this.juj = false;
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxu() {
        return this == TbVideoViewSet.cxX().GQ(this.jue);
    }

    private boolean cxv() {
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
        this.juj = z;
    }

    @Override // com.baidu.tieba.play.a.a
    public void setOnOutInfoListener(g.e eVar) {
        this.jtM = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.jtL != null) {
            return this.jtL.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.jtL != null ? this.jtL.getId() : "";
    }

    @Override // com.baidu.tieba.play.a.a
    public void setPageTypeForPerfStat(String str) {
        this.jtT.setPageTypeForPerfStat(str);
    }

    @Override // com.baidu.tieba.play.a.a
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.jtO != null) {
            this.jtO.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.jtN = cVar;
    }
}
