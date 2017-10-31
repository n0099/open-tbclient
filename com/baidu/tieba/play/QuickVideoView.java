package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.c.b {
    private static com.baidu.tieba.play.b.b fFA;
    private static h fFz;
    private Map<String, String> Am;
    private String aMi;
    private g.a aWa;
    private g.InterfaceC0121g aWb;
    private g.b aWc;
    private g.c aWd;
    private g.e aWe;
    private g.h aWf;
    private g.f aWg;
    private g.i aWh;
    private g.d aWi;
    private final CustomMessageListener aWq;
    private b bSr;
    private com.baidu.tieba.play.b.a fFB;
    private String fFC;
    private boolean fFD;
    private d fFE;
    private boolean fFF;
    private int fFG;
    private boolean fFH;
    private int fFI;
    private boolean fFJ;
    private SurfaceTexture fFK;
    private boolean fFL;
    private boolean fFM;
    private com.baidu.tieba.play.c.a fFN;
    private boolean fFO;
    private boolean fFP;
    private TextureView.SurfaceTextureListener fFQ;
    private g.InterfaceC0121g fFR;
    private g.a fFS;
    private g.h fFT;
    private Runnable fFU;
    private Runnable fFV;
    private a fFm;
    private o fFw;
    private String fFx;
    private g fFy;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bhj();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fFM = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            fFz = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_MONITOR_FACTORY, com.baidu.tieba.play.b.b.class);
        if (runTask2 != null) {
            fFA = (com.baidu.tieba.play.b.b) runTask2.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fFD = false;
        this.fFF = false;
        this.fFG = 0;
        this.fFH = false;
        this.fFI = -1;
        this.fFJ = false;
        this.fFK = null;
        this.fFM = true;
        this.fFQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fFK != null && QuickVideoView.this.fFK != surfaceTexture) {
                    QuickVideoView.this.fFK.release();
                    QuickVideoView.this.fFK = null;
                }
                if (QuickVideoView.this.fFF) {
                    QuickVideoView.this.fFF = false;
                    if (QuickVideoView.this.fFy != null) {
                        QuickVideoView.this.fFy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFB.aMU();
                    }
                } else if (QuickVideoView.this.fFy != null && QuickVideoView.this.fFJ) {
                    QuickVideoView.this.fFy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fFI);
                    if (QuickVideoView.this.fFm != null) {
                        QuickVideoView.this.fFm.bhj();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFB.aMV();
                    }
                }
                QuickVideoView.this.fFK = surfaceTexture;
                QuickVideoView.this.fFL = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fFy != null) {
                    QuickVideoView.this.fFy.release();
                }
                if (!QuickVideoView.this.fFF) {
                    if (QuickVideoView.this.fFE != null) {
                        QuickVideoView.this.fFE.onStop();
                    }
                    if (QuickVideoView.this.bSr != null) {
                        QuickVideoView.this.bSr.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fFL) {
                    QuickVideoView.this.fFK = null;
                }
                if (QuickVideoView.this.fFB != null && QuickVideoView.this.fFB.oH(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fFB = null;
                }
                return QuickVideoView.this.fFL;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fFR = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.aMX();
                }
                if (QuickVideoView.this.aWb != null) {
                    QuickVideoView.this.aWb.onPrepared(gVar);
                }
                if (QuickVideoView.this.fFE != null) {
                    QuickVideoView.this.fFE.onPrepared();
                }
                if (QuickVideoView.this.fFD) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFw != null && gVar != null) {
                    QuickVideoView.this.fFw.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fFG);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fFx)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fFx).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fFx;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fFN != null && QuickVideoView.this.fFN.bhP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fFS = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oG(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFB = null;
                }
                if (!QuickVideoView.this.fFH || QuickVideoView.this.fFE == null) {
                    if (QuickVideoView.this.fFE != null) {
                        QuickVideoView.this.fFE.onCompletion();
                    }
                    QuickVideoView.this.fFD = false;
                    if (QuickVideoView.this.aWa != null) {
                        QuickVideoView.this.aWa.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fFC = null;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                QuickVideoView.this.start();
            }
        };
        this.aWd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4 = 0;
                com.baidu.tieba.play.c.a.Z(i, i2, i3);
                QuickVideoView.this.bht();
                boolean a2 = QuickVideoView.this.fFN != null ? QuickVideoView.this.fFN.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false;
                if (QuickVideoView.this.fFB != null && a2) {
                    QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), a2);
                    QuickVideoView.this.fFB = null;
                }
                if (QuickVideoView.this.fFE != null && !QuickVideoView.this.fFP && !a2 && QuickVideoView.qR(QuickVideoView.this.fFE.hA(QuickVideoView.this.fFE.bhk()))) {
                    QuickVideoView.this.fFy.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fFN.bhP();
                    QuickVideoView.this.fFP = true;
                    if (QuickVideoView.this.fFB != null) {
                        QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true);
                        QuickVideoView.this.fFB = null;
                    }
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                    QuickVideoView.this.start();
                    a2 = true;
                }
                if (QuickVideoView.this.fFB != null && !a2) {
                    QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), a2);
                    QuickVideoView.this.fFB = null;
                }
                if (!a2) {
                    QuickVideoView.this.bhv();
                    if (QuickVideoView.this.aWc == null || QuickVideoView.this.aWc.onError(gVar, i2, i3)) {
                    }
                } else {
                    if (QuickVideoView.this.getPlayerType() != -100) {
                        i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                }
                return true;
            }
        };
        this.fFT = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.play.g.h
            public void a(g gVar) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fFU);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fFU, 500L);
                if (QuickVideoView.this.aWf != null) {
                    QuickVideoView.this.aWf.a(gVar);
                }
            }
        };
        this.aWe = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fFG = i2;
                    if (QuickVideoView.this.fFw != null && gVar != null) {
                        QuickVideoView.this.fFw.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fFG);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fFB != null && !QuickVideoView.this.fFO) {
                    QuickVideoView.this.fFB.aMY();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fFB != null && !QuickVideoView.this.fFO) {
                    QuickVideoView.this.fFB.aMZ();
                    QuickVideoView.this.fFO = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fFU);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fFU = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fFO = false;
            }
        };
        this.aWg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.f
            public void onReleaseFinished() {
                QuickVideoView.this.fFL = true;
            }
        };
        this.aWh = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.bt(i, i2);
                }
            }
        };
        this.aWi = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oI(str);
                }
            }
        };
        this.fFV = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fFE != null && QuickVideoView.qR(QuickVideoView.this.fFE.hA(QuickVideoView.this.fFE.bhk()))) {
                    QuickVideoView.this.fFy.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fFN.bhP();
                    QuickVideoView.this.fFP = true;
                    if (QuickVideoView.this.fFB != null) {
                        QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true);
                        QuickVideoView.this.fFB = null;
                    }
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                    QuickVideoView.this.start();
                }
            }
        };
        this.aWq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oF(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFB = null;
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFD = false;
        this.fFF = false;
        this.fFG = 0;
        this.fFH = false;
        this.fFI = -1;
        this.fFJ = false;
        this.fFK = null;
        this.fFM = true;
        this.fFQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fFK != null && QuickVideoView.this.fFK != surfaceTexture) {
                    QuickVideoView.this.fFK.release();
                    QuickVideoView.this.fFK = null;
                }
                if (QuickVideoView.this.fFF) {
                    QuickVideoView.this.fFF = false;
                    if (QuickVideoView.this.fFy != null) {
                        QuickVideoView.this.fFy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFB.aMU();
                    }
                } else if (QuickVideoView.this.fFy != null && QuickVideoView.this.fFJ) {
                    QuickVideoView.this.fFy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fFI);
                    if (QuickVideoView.this.fFm != null) {
                        QuickVideoView.this.fFm.bhj();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFB.aMV();
                    }
                }
                QuickVideoView.this.fFK = surfaceTexture;
                QuickVideoView.this.fFL = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fFy != null) {
                    QuickVideoView.this.fFy.release();
                }
                if (!QuickVideoView.this.fFF) {
                    if (QuickVideoView.this.fFE != null) {
                        QuickVideoView.this.fFE.onStop();
                    }
                    if (QuickVideoView.this.bSr != null) {
                        QuickVideoView.this.bSr.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fFL) {
                    QuickVideoView.this.fFK = null;
                }
                if (QuickVideoView.this.fFB != null && QuickVideoView.this.fFB.oH(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fFB = null;
                }
                return QuickVideoView.this.fFL;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fFR = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.aMX();
                }
                if (QuickVideoView.this.aWb != null) {
                    QuickVideoView.this.aWb.onPrepared(gVar);
                }
                if (QuickVideoView.this.fFE != null) {
                    QuickVideoView.this.fFE.onPrepared();
                }
                if (QuickVideoView.this.fFD) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFw != null && gVar != null) {
                    QuickVideoView.this.fFw.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fFG);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fFx)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fFx).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fFx;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fFN != null && QuickVideoView.this.fFN.bhP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fFS = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oG(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFB = null;
                }
                if (!QuickVideoView.this.fFH || QuickVideoView.this.fFE == null) {
                    if (QuickVideoView.this.fFE != null) {
                        QuickVideoView.this.fFE.onCompletion();
                    }
                    QuickVideoView.this.fFD = false;
                    if (QuickVideoView.this.aWa != null) {
                        QuickVideoView.this.aWa.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fFC = null;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                QuickVideoView.this.start();
            }
        };
        this.aWd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4 = 0;
                com.baidu.tieba.play.c.a.Z(i, i2, i3);
                QuickVideoView.this.bht();
                boolean a2 = QuickVideoView.this.fFN != null ? QuickVideoView.this.fFN.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false;
                if (QuickVideoView.this.fFB != null && a2) {
                    QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), a2);
                    QuickVideoView.this.fFB = null;
                }
                if (QuickVideoView.this.fFE != null && !QuickVideoView.this.fFP && !a2 && QuickVideoView.qR(QuickVideoView.this.fFE.hA(QuickVideoView.this.fFE.bhk()))) {
                    QuickVideoView.this.fFy.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fFN.bhP();
                    QuickVideoView.this.fFP = true;
                    if (QuickVideoView.this.fFB != null) {
                        QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true);
                        QuickVideoView.this.fFB = null;
                    }
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                    QuickVideoView.this.start();
                    a2 = true;
                }
                if (QuickVideoView.this.fFB != null && !a2) {
                    QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i, i2, i3, QuickVideoView.this.getLocateSource(), a2);
                    QuickVideoView.this.fFB = null;
                }
                if (!a2) {
                    QuickVideoView.this.bhv();
                    if (QuickVideoView.this.aWc == null || QuickVideoView.this.aWc.onError(gVar, i2, i3)) {
                    }
                } else {
                    if (QuickVideoView.this.getPlayerType() != -100) {
                        i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                }
                return true;
            }
        };
        this.fFT = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.play.g.h
            public void a(g gVar) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fFU);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fFU, 500L);
                if (QuickVideoView.this.aWf != null) {
                    QuickVideoView.this.aWf.a(gVar);
                }
            }
        };
        this.aWe = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fFG = i2;
                    if (QuickVideoView.this.fFw != null && gVar != null) {
                        QuickVideoView.this.fFw.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fFG);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fFB != null && !QuickVideoView.this.fFO) {
                    QuickVideoView.this.fFB.aMY();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fFB != null && !QuickVideoView.this.fFO) {
                    QuickVideoView.this.fFB.aMZ();
                    QuickVideoView.this.fFO = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fFU);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fFU = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fFO = false;
            }
        };
        this.aWg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.f
            public void onReleaseFinished() {
                QuickVideoView.this.fFL = true;
            }
        };
        this.aWh = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.bt(i, i2);
                }
            }
        };
        this.aWi = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oI(str);
                }
            }
        };
        this.fFV = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fFE != null && QuickVideoView.qR(QuickVideoView.this.fFE.hA(QuickVideoView.this.fFE.bhk()))) {
                    QuickVideoView.this.fFy.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fFN.bhP();
                    QuickVideoView.this.fFP = true;
                    if (QuickVideoView.this.fFB != null) {
                        QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true);
                        QuickVideoView.this.fFB = null;
                    }
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                    QuickVideoView.this.start();
                }
            }
        };
        this.aWq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oF(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFB = null;
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFD = false;
        this.fFF = false;
        this.fFG = 0;
        this.fFH = false;
        this.fFI = -1;
        this.fFJ = false;
        this.fFK = null;
        this.fFM = true;
        this.fFQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fFK != null && QuickVideoView.this.fFK != surfaceTexture) {
                    QuickVideoView.this.fFK.release();
                    QuickVideoView.this.fFK = null;
                }
                if (QuickVideoView.this.fFF) {
                    QuickVideoView.this.fFF = false;
                    if (QuickVideoView.this.fFy != null) {
                        QuickVideoView.this.fFy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFB.aMU();
                    }
                } else if (QuickVideoView.this.fFy != null && QuickVideoView.this.fFJ) {
                    QuickVideoView.this.fFy.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fFI);
                    if (QuickVideoView.this.fFm != null) {
                        QuickVideoView.this.fFm.bhj();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFB.aMV();
                    }
                }
                QuickVideoView.this.fFK = surfaceTexture;
                QuickVideoView.this.fFL = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fFy != null) {
                    QuickVideoView.this.fFy.release();
                }
                if (!QuickVideoView.this.fFF) {
                    if (QuickVideoView.this.fFE != null) {
                        QuickVideoView.this.fFE.onStop();
                    }
                    if (QuickVideoView.this.bSr != null) {
                        QuickVideoView.this.bSr.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fFL) {
                    QuickVideoView.this.fFK = null;
                }
                if (QuickVideoView.this.fFB != null && QuickVideoView.this.fFB.oH(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fFB = null;
                }
                return QuickVideoView.this.fFL;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fFR = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.aMX();
                }
                if (QuickVideoView.this.aWb != null) {
                    QuickVideoView.this.aWb.onPrepared(gVar);
                }
                if (QuickVideoView.this.fFE != null) {
                    QuickVideoView.this.fFE.onPrepared();
                }
                if (QuickVideoView.this.fFD) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFw != null && gVar != null) {
                    QuickVideoView.this.fFw.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fFG);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fFx)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fFx).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fFx;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fFN != null && QuickVideoView.this.fFN.bhP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fFS = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oG(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFB = null;
                }
                if (!QuickVideoView.this.fFH || QuickVideoView.this.fFE == null) {
                    if (QuickVideoView.this.fFE != null) {
                        QuickVideoView.this.fFE.onCompletion();
                    }
                    QuickVideoView.this.fFD = false;
                    if (QuickVideoView.this.aWa != null) {
                        QuickVideoView.this.aWa.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fFC = null;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                QuickVideoView.this.start();
            }
        };
        this.aWd = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4 = 0;
                com.baidu.tieba.play.c.a.Z(i2, i22, i3);
                QuickVideoView.this.bht();
                boolean a2 = QuickVideoView.this.fFN != null ? QuickVideoView.this.fFN.a(gVar, i2, i22, i3, QuickVideoView.this.mUri) : false;
                if (QuickVideoView.this.fFB != null && a2) {
                    QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), a2);
                    QuickVideoView.this.fFB = null;
                }
                if (QuickVideoView.this.fFE != null && !QuickVideoView.this.fFP && !a2 && QuickVideoView.qR(QuickVideoView.this.fFE.hA(QuickVideoView.this.fFE.bhk()))) {
                    QuickVideoView.this.fFy.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fFN.bhP();
                    QuickVideoView.this.fFP = true;
                    if (QuickVideoView.this.fFB != null) {
                        QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), true);
                        QuickVideoView.this.fFB = null;
                    }
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                    QuickVideoView.this.start();
                    a2 = true;
                }
                if (QuickVideoView.this.fFB != null && !a2) {
                    QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), a2);
                    QuickVideoView.this.fFB = null;
                }
                if (!a2) {
                    QuickVideoView.this.bhv();
                    if (QuickVideoView.this.aWc == null || QuickVideoView.this.aWc.onError(gVar, i22, i3)) {
                    }
                } else {
                    if (QuickVideoView.this.getPlayerType() != -100) {
                        i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                }
                return true;
            }
        };
        this.fFT = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.play.g.h
            public void a(g gVar) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fFU);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fFU, 500L);
                if (QuickVideoView.this.aWf != null) {
                    QuickVideoView.this.aWf.a(gVar);
                }
            }
        };
        this.aWe = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fFG = i22;
                    if (QuickVideoView.this.fFw != null && gVar != null) {
                        QuickVideoView.this.fFw.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fFG);
                        return true;
                    }
                    return true;
                } else if ((i2 == 701 || i22 == 701) && QuickVideoView.this.fFB != null && !QuickVideoView.this.fFO) {
                    QuickVideoView.this.fFB.aMY();
                    return true;
                } else if ((i2 == 702 || i22 == 702) && QuickVideoView.this.fFB != null && !QuickVideoView.this.fFO) {
                    QuickVideoView.this.fFB.aMZ();
                    QuickVideoView.this.fFO = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fFU);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fFU = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fFO = false;
            }
        };
        this.aWg = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.f
            public void onReleaseFinished() {
                QuickVideoView.this.fFL = true;
            }
        };
        this.aWh = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.bt(i2, i22);
                }
            }
        };
        this.aWi = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oI(str);
                }
            }
        };
        this.fFV = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fFE != null && QuickVideoView.qR(QuickVideoView.this.fFE.hA(QuickVideoView.this.fFE.bhk()))) {
                    QuickVideoView.this.fFy.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fFN.bhP();
                    QuickVideoView.this.fFP = true;
                    if (QuickVideoView.this.fFB != null) {
                        QuickVideoView.this.fFC = QuickVideoView.this.fFB.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true);
                        QuickVideoView.this.fFB = null;
                    }
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fFE.bhk());
                    QuickVideoView.this.start();
                }
            }
        };
        this.aWq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fFB != null) {
                    QuickVideoView.this.fFB.oF(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFB = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fFw = new o(context);
        this.fFw.setSurfaceTextureListener(this.fFQ);
        if (fFz != null) {
            this.fFy = fFz.KF();
        }
        if (this.fFy != null) {
            this.fFy.setOnPreparedListener(this.fFR);
            this.fFy.setOnCompletionListener(this.fFS);
            this.fFy.a(this.aWd);
            this.fFy.setOnSeekCompleteListener(this.fFT);
            this.fFy.a(this.aWe);
            this.fFy.a(this.aWg);
            this.fFy.a(this.aWh);
            this.fFy.a(this.aWi);
        }
        aj.k(this, d.C0080d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.fFN = new com.baidu.tieba.play.c.a(this);
        MessageManager.getInstance().registerListener(this.aWq);
    }

    public void setVideoPath(String str) {
        if (this.fFB != null) {
            this.fFB.aNd();
            this.fFB = null;
        }
        if (!am.isEmpty(str)) {
            if (e(Uri.parse(str)) != null) {
                this.fFB.aMT();
            }
            if (this.fFE != null) {
                str = this.fFE.hA(str);
                if (this.fFE.getMediaProgressObserver() != null) {
                    this.fFE.getMediaProgressObserver().setPlayer(this);
                }
            }
            setVideoURI(Uri.parse(str));
        }
    }

    public void bL(String str, String str2) {
        this.aMi = str2;
        if (TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ak("c12026").ac("tid", str2));
            if (fFA != null) {
                this.fFB = fFA.F(this.aMi, str, "");
                if (this.fFB != null) {
                    this.fFB.a(-300, -44399, -44399, "unknown", false);
                    this.fFB = null;
                }
            }
        }
        this.fFC = null;
        setVideoPath(str);
    }

    private void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    private void a(Uri uri, Map<String, String> map) {
        if (e(uri) != null) {
            this.fFB.oE(uri.toString());
        }
        bhq();
        this.fFF = true;
        this.mUri = uri;
        this.Am = map;
        this.fFG = 0;
        removeView(this.fFw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fFM) {
            addView(this.fFw, layoutParams);
        } else {
            addView(this.fFw, 0, layoutParams);
        }
        aj.k(this, d.C0080d.cp_bg_line_k);
    }

    private void bhq() {
        this.fFF = false;
        this.fFD = false;
        if (this.fFy != null) {
            this.fFy.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void stopPlayback() {
        this.fFx = null;
        bhq();
        this.fFH = false;
        if (this.fFE != null) {
            this.fFE.onStop();
        }
        com.baidu.tieba.play.a.b.bhN().a((b.InterfaceC0118b) null);
        if (this.fFB != null && this.fFB.oH(getLocateSource())) {
            this.fFB = null;
        }
    }

    public void setOnPreparedListener(g.InterfaceC0121g interfaceC0121g) {
        this.aWb = interfaceC0121g;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aWa = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aWc = bVar;
    }

    public void setOnSeekCompleteListener(g.h hVar) {
        this.aWf = hVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void a(g gVar, int i, int i2, int i3, String str) {
        if (getCurrentPosition() <= 0 || this.fFy == null || !this.fFy.isPlaying() || this.fFK == null) {
            try {
                this.fFx = str;
                URI uri = new URI(this.mUri.toString());
                this.fFy.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Am, this.fFK, this.mUri.getHost());
                if (e(this.mUri) != null) {
                    this.fFB.aMW();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.b
    public void b(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fFy.a(this.mContext, this.mUri, this.Am, this.fFK, this.mUri.getHost());
            if (e(this.mUri) != null) {
                this.fFB.aMW();
            }
        }
    }

    @Override // com.baidu.tieba.play.c.b
    public void c(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fFy.forceUseSystemMediaPlayer(true);
            }
            this.fFy.a(this.mContext, this.mUri, this.Am, this.fFK, this.mUri.getHost());
            if (e(this.mUri) != null) {
                this.fFB.aMW();
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fFD = true;
        if (this.fFy != null) {
            if (this.fFK != null && this.fFJ && !this.fFy.isExistInRemote()) {
                this.fFy.a(this.mContext, this.mUri, this.Am, this.fFK, this.fFI);
                if (this.fFm != null) {
                    this.fFm.bhj();
                }
                if (e(this.mUri) != null) {
                    this.fFB.aMV();
                    return;
                }
                return;
            }
            this.fFy.start();
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fFE != null) {
            this.fFE.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (e(this.mUri) != null) {
            this.fFB.pa(this.fFy.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.fFy != null) {
            this.fFy.pause();
        }
        if (this.fFE != null) {
            this.fFE.onPause();
        }
        this.fFD = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fFB != null) {
            this.fFB.aNa();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fFy != null) {
            return this.fFy.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fFy != null) {
            return this.fFy.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.fFO = true;
        if (this.fFy != null) {
            this.fFy.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fFy != null) {
            return this.fFy.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fFy != null) {
            this.fFy.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fFI = i;
    }

    public int getRecoveryState() {
        return this.fFI;
    }

    public void setNeedRecovery(boolean z) {
        this.fFJ = z;
    }

    public void setLooping(boolean z) {
        this.fFH = z;
    }

    public boolean bhr() {
        return this.fFD;
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

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.bSr = bVar;
    }

    public void setBusiness(d dVar) {
        this.fFE = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fFH = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fFy != null) {
            this.fFy.GX();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFV);
        MessageManager.getInstance().unRegisterListener(this.aWq);
        if (this.fFN != null) {
            this.fFN.clear();
        }
    }

    public g getPlayer() {
        return this.fFy;
    }

    public int getPlayerType() {
        if (this.fFy == null) {
            return -300;
        }
        return this.fFy.getPlayerType();
    }

    public boolean bhs() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.fFP) {
            if (this.fFB != null) {
                this.fFC = this.fFB.a(getPlayerType(), -4399, -4399, getLocateSource(), false);
                this.fFB = null;
            }
            if (getPlayerType() == -100) {
                i = 0;
            } else {
                i = getPlayerType() == -200 ? 1 : 2;
            }
            TiebaStatic.log(new ak("c12194").r("obj_type", i));
            bhv();
            return false;
        } else if (this.fFN != null) {
            boolean a2 = this.fFN.a(this.fFy, getPlayerType(), 0, -4399, this.mUri);
            if (a2) {
                if (getPlayerType() != -100) {
                    i3 = getPlayerType() == -200 ? 1 : 2;
                }
                TiebaStatic.log(new ak("c12493").r("obj_type", i3));
            }
            if (this.fFB != null) {
                this.fFC = this.fFB.a(getPlayerType(), -4399, -4399, getLocateSource(), a2);
                this.fFB = null;
            }
            return a2;
        } else {
            if (getPlayerType() == -100) {
                i2 = 0;
            } else if (getPlayerType() != -200) {
                i2 = 2;
            }
            TiebaStatic.log(new ak("c12194").r("obj_type", i2));
            bhv();
            return false;
        }
    }

    public void bht() {
        if (this.fFE != null) {
            this.fFE.bhl();
        }
    }

    public void bhu() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFV);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fFV, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhv() {
        int i;
        int i2 = 2;
        if (getPlayerType() == -100) {
            i = 0;
        } else {
            i = getPlayerType() == -200 ? 1 : 2;
        }
        if (Build.CPU_ABI.toLowerCase().contains("v7")) {
            i2 = 0;
        } else if (Build.CPU_ABI.toLowerCase().contains("arm")) {
            i2 = 1;
        } else if (!Build.CPU_ABI.toLowerCase().contains("86")) {
            if (Build.CPU_ABI.toLowerCase().contains("mips")) {
                i2 = 3;
            } else {
                i2 = 4;
            }
        }
        TiebaStatic.log(new ak("c12029").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1).r("obj_param2", i2));
    }

    public void setOnRecoveryCallback(a aVar) {
        this.fFm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fFE instanceof n) || ((n) this.fFE).bhA() == null) ? "" : ((n) this.fFE).bhA().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.play.b.a e(Uri uri) {
        if (this.fFB != null) {
            return this.fFB;
        }
        if (fFA != null && this.fFE != null) {
            this.fFB = fFA.F(this.aMi, this.fFE.bhk(), this.fFC);
        } else if (fFA != null && uri != null) {
            this.fFB = fFA.F(this.aMi, uri.toString(), this.fFC);
        }
        this.fFC = null;
        return this.fFB;
    }

    public static boolean qR(String str) {
        return str.contains("127.0.0.1") || !str.contains("http");
    }
}
