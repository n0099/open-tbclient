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
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.ng.ai.apps.trace.ReportLevel;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static h gCH;
    private static com.baidu.tieba.j.l gCI;
    private static int gDg = 0;
    private static int gDh = 1;
    private static int gDi = 2;
    private static int gDj = 1;
    private static int gDk = 0;
    private int bBY;
    private String biw;
    private g.b boW;
    private b bpa;
    private g.a bxI;
    private g.f bxJ;
    private g.c bxK;
    private g.e bxL;
    private g.InterfaceC0298g bxM;
    private g.i bxN;
    private g.d bxO;
    private g.h bxP;
    private final CustomMessageListener bxV;
    private RenderView gCC;
    private String gCD;
    private g gCE;
    private g.e gCF;
    private c gCG;
    private com.baidu.tieba.j.i gCJ;
    private com.baidu.tieba.j.e gCK;
    private String gCL;
    private boolean gCM;
    private d gCN;
    private boolean gCO;
    private int gCP;
    private boolean gCQ;
    private int gCR;
    private boolean gCS;
    private SurfaceTexture gCT;
    private boolean gCU;
    private com.baidu.tieba.play.b.a gCV;
    private r gCW;
    private com.baidu.tieba.play.b.f gCX;
    private String gCY;
    private String gCZ;
    private a gCk;
    private String gDa;
    private long gDb;
    private boolean gDc;
    private boolean gDd;
    private long gDe;
    private long gDf;
    private int gDl;
    private int gDm;
    private int gDn;
    private int gDo;
    private int gDp;
    private int gDq;
    private boolean gDr;
    private Runnable gDs;
    private Runnable gDt;
    private TextureView.SurfaceTextureListener gDu;
    private g.f gDv;
    private g.a gDw;
    private g.InterfaceC0298g gDx;
    private Runnable gDy;
    private int gmP;
    private Context mContext;
    private Map<String, String> mHeaders;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bri();
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016490, h.class);
        if (runTask != null) {
            gCH = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gCI = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gCU = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gCM = false;
        this.gCO = false;
        this.gCP = 0;
        this.gCQ = false;
        this.gCR = -1;
        this.gCS = false;
        this.gCT = null;
        this.gCU = true;
        this.gDe = 0L;
        this.gDf = 0L;
        this.gmP = gDk;
        this.gDl = 0;
        this.gDm = 0;
        this.gDn = -1;
        this.gDo = 0;
        this.gDp = 0;
        this.gDq = 0;
        this.bBY = 0;
        this.gDr = false;
        this.gDs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCE != null && QuickVideoView.this.gCM) {
                    QuickVideoView.this.b(QuickVideoView.this.gCE, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gDt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.jP(false);
                }
            }
        };
        this.gDu = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gDr) {
                    QuickVideoView.this.gDr = false;
                    QuickVideoView.this.gCE.c(surfaceTexture);
                } else if (QuickVideoView.this.gCO || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gCE != null && QuickVideoView.this.gCS) {
                        QuickVideoView.this.gCE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gCR);
                        if (QuickVideoView.this.gCk != null) {
                            QuickVideoView.this.gCk.bri();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gCJ.bcv();
                        }
                    }
                } else if (brC()) {
                    if (QuickVideoView.this.gCE != null) {
                        QuickVideoView.this.brv();
                        QuickVideoView.this.gCO = true;
                        QuickVideoView.this.gCE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCJ.bcu();
                    }
                }
                QuickVideoView.this.gCT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gDr) {
                    QuickVideoView.this.brx();
                    QuickVideoView.this.mA(false);
                    if (QuickVideoView.this.gCE != null) {
                        if (QuickVideoView.this.gCE.isPlaying() && QuickVideoView.this.brA()) {
                            y.bsc().aN(QuickVideoView.this.gDa, QuickVideoView.this.gCE.getCurrentPosition());
                        }
                        QuickVideoView.this.gCE.release();
                    }
                    if (QuickVideoView.this.gCO) {
                        if (QuickVideoView.this.gCN != null) {
                            QuickVideoView.this.gCN.onStop();
                        }
                        if (QuickVideoView.this.bpa != null) {
                            QuickVideoView.this.bpa.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gCT = null;
                    if (QuickVideoView.this.gCJ != null && QuickVideoView.this.gCJ.sf(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.gCO = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean brC() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gDv = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tW;
                QuickVideoView.this.brx();
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.onPrepared();
                }
                if (QuickVideoView.this.gCJ != null && QuickVideoView.this.gCE != null) {
                    QuickVideoView.this.gCJ.rH(QuickVideoView.this.gCE.getPlayerType());
                }
                if (QuickVideoView.this.bxJ != null) {
                    QuickVideoView.this.bxJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.gCN != null) {
                    long j = 0;
                    if (QuickVideoView.this.gCE != null) {
                        j = QuickVideoView.this.gCE.getDuration();
                    }
                    QuickVideoView.this.gCN.cY(j);
                    QuickVideoView.this.brw();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gCN.brp();
                        QuickVideoView.this.brz();
                    }
                }
                if (QuickVideoView.this.gDd && (tW = y.bsc().tW(QuickVideoView.this.gDa)) > 0) {
                    if (QuickVideoView.this.gCE.isPlayerReuse()) {
                        if (QuickVideoView.this.gCE.getCurrentPosition() == 0) {
                            QuickVideoView.this.to(tW);
                        }
                    } else {
                        QuickVideoView.this.to(tW);
                    }
                }
                if (QuickVideoView.this.gCM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gCC != null && gVar != null) {
                    QuickVideoView.this.gCC.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gCD) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gCD);
                }
                if (QuickVideoView.this.gCV != null && QuickVideoView.this.gCV.bsi()) {
                    com.baidu.tieba.play.b.e.ts(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gDw = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mA(true);
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.se(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gCJ = null;
                }
                if (!QuickVideoView.this.gCQ || QuickVideoView.this.gCN == null) {
                    if (QuickVideoView.this.gCN != null) {
                        QuickVideoView.this.gCN.onCompletion();
                    }
                    QuickVideoView.this.gCM = false;
                    y.bsc().remove(QuickVideoView.this.gDa);
                    if (QuickVideoView.this.bxI != null) {
                        QuickVideoView.this.bxI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gCL = null;
                QuickVideoView.this.gDb = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gCN.brj());
                QuickVideoView.this.start();
            }
        };
        this.bxK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.brx();
                if (QuickVideoView.this.gCN != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.brA()) {
                    QuickVideoView.this.gDc = true;
                    y.bsc().aN(QuickVideoView.this.gDa, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gCJ != null) {
                        QuickVideoView.this.gCL = QuickVideoView.this.gCJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gDb, QuickVideoView.this.N(QuickVideoView.this.gCJ.bcz(), i3 + "", QuickVideoView.this.gCJ.bcA()));
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.gDb = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.boW == null || QuickVideoView.this.boW.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gDx = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gDc) {
                    QuickVideoView.this.gDc = false;
                    return;
                }
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.brM();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gCN != null && z) {
                    QuickVideoView.this.gCN.onSeekComplete();
                }
                if (QuickVideoView.this.bxM != null) {
                    QuickVideoView.this.bxM.b(gVar);
                }
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gCF != null) {
                    QuickVideoView.this.gCF.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gCP = i2;
                    if (QuickVideoView.this.gCC != null && gVar != null) {
                        QuickVideoView.this.gCC.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCP);
                    }
                }
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.a(i, i2, QuickVideoView.this.gCJ);
                    return true;
                }
                return true;
            }
        };
        this.bxN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.f(i, i2, str);
                }
            }
        };
        this.bxO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.sg(str);
                }
            }
        };
        this.bxP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gDb = j;
                }
            }
        };
        this.gDy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gCN != null && QuickVideoView.this.gCN.brl() && QuickVideoView.this.gCN.brm() && QuickVideoView.this.gCN.brn() && QuickVideoView.this.gCE != null) {
                    int UN = QuickVideoView.this.gCE.UN();
                    int currentPosition = QuickVideoView.this.gCE.getCurrentPosition();
                    int duration = QuickVideoView.this.gCE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gDe;
                    boolean z = currentPosition + UN < duration;
                    if (UN < QuickVideoView.this.gCN.bro() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gDe = currentTimeMillis;
                        QuickVideoView.this.gCN.tn(0);
                    }
                    if (QuickVideoView.this.bry() && currentPosition == QuickVideoView.this.gDf && j > 500) {
                        QuickVideoView.this.gDe = currentTimeMillis;
                        QuickVideoView.this.gCN.tn(0);
                    }
                    QuickVideoView.this.gDf = currentPosition;
                    if (QuickVideoView.this.gmP == QuickVideoView.gDj) {
                        QuickVideoView.this.brz();
                    }
                }
            }
        };
        this.bxV = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gCN != null) {
                        QuickVideoView.this.gCN.brr();
                    }
                    if (QuickVideoView.this.gCJ != null) {
                        QuickVideoView.this.gCJ.sd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.brx();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gCM = false;
        this.gCO = false;
        this.gCP = 0;
        this.gCQ = false;
        this.gCR = -1;
        this.gCS = false;
        this.gCT = null;
        this.gCU = true;
        this.gDe = 0L;
        this.gDf = 0L;
        this.gmP = gDk;
        this.gDl = 0;
        this.gDm = 0;
        this.gDn = -1;
        this.gDo = 0;
        this.gDp = 0;
        this.gDq = 0;
        this.bBY = 0;
        this.gDr = false;
        this.gDs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCE != null && QuickVideoView.this.gCM) {
                    QuickVideoView.this.b(QuickVideoView.this.gCE, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gDt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.jP(false);
                }
            }
        };
        this.gDu = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gDr) {
                    QuickVideoView.this.gDr = false;
                    QuickVideoView.this.gCE.c(surfaceTexture);
                } else if (QuickVideoView.this.gCO || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gCE != null && QuickVideoView.this.gCS) {
                        QuickVideoView.this.gCE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gCR);
                        if (QuickVideoView.this.gCk != null) {
                            QuickVideoView.this.gCk.bri();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gCJ.bcv();
                        }
                    }
                } else if (brC()) {
                    if (QuickVideoView.this.gCE != null) {
                        QuickVideoView.this.brv();
                        QuickVideoView.this.gCO = true;
                        QuickVideoView.this.gCE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCJ.bcu();
                    }
                }
                QuickVideoView.this.gCT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gDr) {
                    QuickVideoView.this.brx();
                    QuickVideoView.this.mA(false);
                    if (QuickVideoView.this.gCE != null) {
                        if (QuickVideoView.this.gCE.isPlaying() && QuickVideoView.this.brA()) {
                            y.bsc().aN(QuickVideoView.this.gDa, QuickVideoView.this.gCE.getCurrentPosition());
                        }
                        QuickVideoView.this.gCE.release();
                    }
                    if (QuickVideoView.this.gCO) {
                        if (QuickVideoView.this.gCN != null) {
                            QuickVideoView.this.gCN.onStop();
                        }
                        if (QuickVideoView.this.bpa != null) {
                            QuickVideoView.this.bpa.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gCT = null;
                    if (QuickVideoView.this.gCJ != null && QuickVideoView.this.gCJ.sf(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.gCO = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean brC() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gDv = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tW;
                QuickVideoView.this.brx();
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.onPrepared();
                }
                if (QuickVideoView.this.gCJ != null && QuickVideoView.this.gCE != null) {
                    QuickVideoView.this.gCJ.rH(QuickVideoView.this.gCE.getPlayerType());
                }
                if (QuickVideoView.this.bxJ != null) {
                    QuickVideoView.this.bxJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.gCN != null) {
                    long j = 0;
                    if (QuickVideoView.this.gCE != null) {
                        j = QuickVideoView.this.gCE.getDuration();
                    }
                    QuickVideoView.this.gCN.cY(j);
                    QuickVideoView.this.brw();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gCN.brp();
                        QuickVideoView.this.brz();
                    }
                }
                if (QuickVideoView.this.gDd && (tW = y.bsc().tW(QuickVideoView.this.gDa)) > 0) {
                    if (QuickVideoView.this.gCE.isPlayerReuse()) {
                        if (QuickVideoView.this.gCE.getCurrentPosition() == 0) {
                            QuickVideoView.this.to(tW);
                        }
                    } else {
                        QuickVideoView.this.to(tW);
                    }
                }
                if (QuickVideoView.this.gCM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gCC != null && gVar != null) {
                    QuickVideoView.this.gCC.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gCD) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gCD);
                }
                if (QuickVideoView.this.gCV != null && QuickVideoView.this.gCV.bsi()) {
                    com.baidu.tieba.play.b.e.ts(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gDw = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mA(true);
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.se(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gCJ = null;
                }
                if (!QuickVideoView.this.gCQ || QuickVideoView.this.gCN == null) {
                    if (QuickVideoView.this.gCN != null) {
                        QuickVideoView.this.gCN.onCompletion();
                    }
                    QuickVideoView.this.gCM = false;
                    y.bsc().remove(QuickVideoView.this.gDa);
                    if (QuickVideoView.this.bxI != null) {
                        QuickVideoView.this.bxI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gCL = null;
                QuickVideoView.this.gDb = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gCN.brj());
                QuickVideoView.this.start();
            }
        };
        this.bxK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.brx();
                if (QuickVideoView.this.gCN != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.brA()) {
                    QuickVideoView.this.gDc = true;
                    y.bsc().aN(QuickVideoView.this.gDa, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gCJ != null) {
                        QuickVideoView.this.gCL = QuickVideoView.this.gCJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gDb, QuickVideoView.this.N(QuickVideoView.this.gCJ.bcz(), i3 + "", QuickVideoView.this.gCJ.bcA()));
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.gDb = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.tq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.boW == null || QuickVideoView.this.boW.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gDx = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gDc) {
                    QuickVideoView.this.gDc = false;
                    return;
                }
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.brM();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gCN != null && z) {
                    QuickVideoView.this.gCN.onSeekComplete();
                }
                if (QuickVideoView.this.bxM != null) {
                    QuickVideoView.this.bxM.b(gVar);
                }
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gCF != null) {
                    QuickVideoView.this.gCF.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gCP = i2;
                    if (QuickVideoView.this.gCC != null && gVar != null) {
                        QuickVideoView.this.gCC.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCP);
                    }
                }
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.a(i, i2, QuickVideoView.this.gCJ);
                    return true;
                }
                return true;
            }
        };
        this.bxN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.f(i, i2, str);
                }
            }
        };
        this.bxO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.sg(str);
                }
            }
        };
        this.bxP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gDb = j;
                }
            }
        };
        this.gDy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gCN != null && QuickVideoView.this.gCN.brl() && QuickVideoView.this.gCN.brm() && QuickVideoView.this.gCN.brn() && QuickVideoView.this.gCE != null) {
                    int UN = QuickVideoView.this.gCE.UN();
                    int currentPosition = QuickVideoView.this.gCE.getCurrentPosition();
                    int duration = QuickVideoView.this.gCE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gDe;
                    boolean z = currentPosition + UN < duration;
                    if (UN < QuickVideoView.this.gCN.bro() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gDe = currentTimeMillis;
                        QuickVideoView.this.gCN.tn(0);
                    }
                    if (QuickVideoView.this.bry() && currentPosition == QuickVideoView.this.gDf && j > 500) {
                        QuickVideoView.this.gDe = currentTimeMillis;
                        QuickVideoView.this.gCN.tn(0);
                    }
                    QuickVideoView.this.gDf = currentPosition;
                    if (QuickVideoView.this.gmP == QuickVideoView.gDj) {
                        QuickVideoView.this.brz();
                    }
                }
            }
        };
        this.bxV = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gCN != null) {
                        QuickVideoView.this.gCN.brr();
                    }
                    if (QuickVideoView.this.gCJ != null) {
                        QuickVideoView.this.gCJ.sd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.brx();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gCM = false;
        this.gCO = false;
        this.gCP = 0;
        this.gCQ = false;
        this.gCR = -1;
        this.gCS = false;
        this.gCT = null;
        this.gCU = true;
        this.gDe = 0L;
        this.gDf = 0L;
        this.gmP = gDk;
        this.gDl = 0;
        this.gDm = 0;
        this.gDn = -1;
        this.gDo = 0;
        this.gDp = 0;
        this.gDq = 0;
        this.bBY = 0;
        this.gDr = false;
        this.gDs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCE != null && QuickVideoView.this.gCM) {
                    QuickVideoView.this.b(QuickVideoView.this.gCE, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gDt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.jP(false);
                }
            }
        };
        this.gDu = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gDr) {
                    QuickVideoView.this.gDr = false;
                    QuickVideoView.this.gCE.c(surfaceTexture);
                } else if (QuickVideoView.this.gCO || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gCE != null && QuickVideoView.this.gCS) {
                        QuickVideoView.this.gCE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.gCR);
                        if (QuickVideoView.this.gCk != null) {
                            QuickVideoView.this.gCk.bri();
                        }
                        if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gCJ.bcv();
                        }
                    }
                } else if (brC()) {
                    if (QuickVideoView.this.gCE != null) {
                        QuickVideoView.this.brv();
                        QuickVideoView.this.gCO = true;
                        QuickVideoView.this.gCE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.mHeaders, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.g(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gCJ.bcu();
                    }
                }
                QuickVideoView.this.gCT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!QuickVideoView.this.gDr) {
                    QuickVideoView.this.brx();
                    QuickVideoView.this.mA(false);
                    if (QuickVideoView.this.gCE != null) {
                        if (QuickVideoView.this.gCE.isPlaying() && QuickVideoView.this.brA()) {
                            y.bsc().aN(QuickVideoView.this.gDa, QuickVideoView.this.gCE.getCurrentPosition());
                        }
                        QuickVideoView.this.gCE.release();
                    }
                    if (QuickVideoView.this.gCO) {
                        if (QuickVideoView.this.gCN != null) {
                            QuickVideoView.this.gCN.onStop();
                        }
                        if (QuickVideoView.this.bpa != null) {
                            QuickVideoView.this.bpa.onSurfaceDestroyed();
                        }
                    }
                    QuickVideoView.this.gCT = null;
                    if (QuickVideoView.this.gCJ != null && QuickVideoView.this.gCJ.sf(QuickVideoView.this.getLocateSource())) {
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.gCO = false;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean brC() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.I(runningTasks)) {
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
        this.gDv = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int tW;
                QuickVideoView.this.brx();
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.onPrepared();
                }
                if (QuickVideoView.this.gCJ != null && QuickVideoView.this.gCE != null) {
                    QuickVideoView.this.gCJ.rH(QuickVideoView.this.gCE.getPlayerType());
                }
                if (QuickVideoView.this.bxJ != null) {
                    QuickVideoView.this.bxJ.onPrepared(gVar);
                }
                if (QuickVideoView.this.gCN != null) {
                    long j = 0;
                    if (QuickVideoView.this.gCE != null) {
                        j = QuickVideoView.this.gCE.getDuration();
                    }
                    QuickVideoView.this.gCN.cY(j);
                    QuickVideoView.this.brw();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gCN.brp();
                        QuickVideoView.this.brz();
                    }
                }
                if (QuickVideoView.this.gDd && (tW = y.bsc().tW(QuickVideoView.this.gDa)) > 0) {
                    if (QuickVideoView.this.gCE.isPlayerReuse()) {
                        if (QuickVideoView.this.gCE.getCurrentPosition() == 0) {
                            QuickVideoView.this.to(tW);
                        }
                    } else {
                        QuickVideoView.this.to(tW);
                    }
                }
                if (QuickVideoView.this.gCM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gCC != null && gVar != null) {
                    QuickVideoView.this.gCC.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gCD) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gCD);
                }
                if (QuickVideoView.this.gCV != null && QuickVideoView.this.gCV.bsi()) {
                    com.baidu.tieba.play.b.e.ts(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gDw = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.mA(true);
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.se(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gCJ = null;
                }
                if (!QuickVideoView.this.gCQ || QuickVideoView.this.gCN == null) {
                    if (QuickVideoView.this.gCN != null) {
                        QuickVideoView.this.gCN.onCompletion();
                    }
                    QuickVideoView.this.gCM = false;
                    y.bsc().remove(QuickVideoView.this.gDa);
                    if (QuickVideoView.this.bxI != null) {
                        QuickVideoView.this.bxI.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gCL = null;
                QuickVideoView.this.gDb = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gCN.brj());
                QuickVideoView.this.start();
            }
        };
        this.bxK = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.brx();
                if (QuickVideoView.this.gCN != null && QuickVideoView.this.getCurrentPosition() > 0 && QuickVideoView.this.brA()) {
                    QuickVideoView.this.gDc = true;
                    y.bsc().aN(QuickVideoView.this.gDa, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kV()) {
                    if (QuickVideoView.this.gCJ != null) {
                        QuickVideoView.this.gCL = QuickVideoView.this.gCJ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gDb, QuickVideoView.this.N(QuickVideoView.this.gCJ.bcz(), i3 + "", QuickVideoView.this.gCJ.bcA()));
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.gDb = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.tq(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.tr(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.boW == null || QuickVideoView.this.boW.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gDx = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0298g
            public void b(g gVar) {
                if (QuickVideoView.this.gDc) {
                    QuickVideoView.this.gDc = false;
                    return;
                }
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.brM();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gCN != null && z) {
                    QuickVideoView.this.gCN.onSeekComplete();
                }
                if (QuickVideoView.this.bxM != null) {
                    QuickVideoView.this.bxM.b(gVar);
                }
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gCF != null) {
                    QuickVideoView.this.gCF.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gCP = i22;
                    if (QuickVideoView.this.gCC != null && gVar != null) {
                        QuickVideoView.this.gCC.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gCP);
                    }
                }
                if (QuickVideoView.this.gCW != null) {
                    QuickVideoView.this.gCW.a(i2, i22, QuickVideoView.this.gCJ);
                    return true;
                }
                return true;
            }
        };
        this.bxN = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.f(i2, i22, str);
                }
            }
        };
        this.bxO = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gCJ != null) {
                    QuickVideoView.this.gCJ.sg(str);
                }
            }
        };
        this.bxP = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gDb = j;
                }
            }
        };
        this.gDy = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gCN != null && QuickVideoView.this.gCN.brl() && QuickVideoView.this.gCN.brm() && QuickVideoView.this.gCN.brn() && QuickVideoView.this.gCE != null) {
                    int UN = QuickVideoView.this.gCE.UN();
                    int currentPosition = QuickVideoView.this.gCE.getCurrentPosition();
                    int duration = QuickVideoView.this.gCE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gDe;
                    boolean z = currentPosition + UN < duration;
                    if (UN < QuickVideoView.this.gCN.bro() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gDe = currentTimeMillis;
                        QuickVideoView.this.gCN.tn(0);
                    }
                    if (QuickVideoView.this.bry() && currentPosition == QuickVideoView.this.gDf && j > 500) {
                        QuickVideoView.this.gDe = currentTimeMillis;
                        QuickVideoView.this.gCN.tn(0);
                    }
                    QuickVideoView.this.gDf = currentPosition;
                    if (QuickVideoView.this.gmP == QuickVideoView.gDj) {
                        QuickVideoView.this.brz();
                    }
                }
            }
        };
        this.bxV = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gCN != null) {
                        QuickVideoView.this.gCN.brr();
                    }
                    if (QuickVideoView.this.gCJ != null) {
                        QuickVideoView.this.gCJ.sd(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gCJ = null;
                    }
                    QuickVideoView.this.brx();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gCC = new RenderView(context);
        this.gCC.setSurfaceTextureListener(this.gDu);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gCU) {
            addView(this.gCC, layoutParams);
        } else {
            addView(this.gCC, 0, layoutParams);
        }
        if (gCH != null) {
            this.gCE = gCH.UO();
        }
        if (this.gCE != null) {
            this.gCE.setOnPreparedListener(this.gDv);
            this.gCE.setOnCompletionListener(this.gDw);
            this.gCE.a(this.bxK);
            this.gCE.setOnSeekCompleteListener(this.gDx);
            this.gCE.a(this.bxL);
            this.gCE.a(this.bxN);
            this.gCE.a(this.bxO);
            this.gCE.a(this.bxP);
        }
        al.j(this, e.d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(ARResourceKey.HTTP_POWER);
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.gCV = new com.baidu.tieba.play.b.a(this);
        this.gCW = new r();
        this.gCX = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iQ().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.gDd = z;
    }

    public void setVideoPath(String str, String str2) {
        this.biw = str2;
        if (this.gCV != null) {
            this.gCV.clear();
            this.gCV.bsi();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.ub(str2);
            if (gCI != null) {
                this.gCJ = gCI.M(this.biw, str, "");
                if (this.gCJ != null) {
                    this.gCJ.a(ReportLevel.USER, -44399, -44399, getLocateSource(), false, this.gDb, "");
                    this.gCJ = null;
                }
            }
        }
        if (this.gCK != null) {
            this.gCK.a(null);
            this.gCK.bcn();
            this.gCK = null;
        }
        this.gCL = null;
        this.gDb = 0L;
        setVideoPath(str);
    }

    public void ct(String str, String str2) {
    }

    private String tS(String str) {
        if (!ao.isEmpty(str) && com.baidu.tieba.video.g.bHQ().bHR()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            if (str.contains("http:")) {
                return str.replace("http:", "https:");
            }
            return str;
        }
        return str;
    }

    public void setVideoPath(String str) {
        if (!ao.isEmpty(str)) {
            String tS = tS(str);
            this.gCY = tS;
            if (this.gCN != null) {
                tS = this.gCN.jA(tS);
                if (this.gCN.brq() != null) {
                    this.gCN.brq().setPlayer(this);
                }
                if (gCI != null && hc(tS)) {
                    this.gCK = gCI.sj(tS);
                }
                if (this.gCK != null) {
                    this.gCK.a(new com.baidu.tieba.play.monitor.a(this.biw, this.gCY, this.gCJ));
                    this.gCK.bcm();
                }
                tT(tS);
            }
            if (!com.baidu.adp.lib.util.j.kV() && !hc(tS)) {
                if (this.boW != null) {
                    this.boW.onError(this.gCE, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(tS));
            if (this.gCJ != null) {
                if (g(Uri.parse(tS)) != null) {
                    this.gCJ.bct();
                }
                this.gCJ.report();
                this.gCJ = null;
            }
            this.gCZ = str;
            int lastIndexOf = this.gCZ.lastIndexOf(".mp4");
            if (lastIndexOf != -1 && this.gCZ.length() > 4) {
                this.gDa = this.gCZ.substring(0, lastIndexOf + 4);
            } else {
                this.gDa = this.gCZ;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brv() {
        if (com.baidu.tbadk.coreExtra.model.f.JT()) {
            if (this.gCN != null && (this.gCN.brk() || this.gCN.brl())) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDs);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.gDs, com.baidu.tbadk.coreExtra.model.f.JS());
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDt);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gDt, com.baidu.tbadk.coreExtra.model.f.JR());
        }
    }

    public void bqL() {
        this.mUri = null;
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (g(uri) != null) {
            this.gCJ.sc(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            UJ();
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.gCP = 0;
        if (this.gCT != null) {
            brv();
            if (this.gCE != null) {
                if (!this.gCO) {
                    this.gCO = true;
                    this.gCE.a(this.mContext, this.mUri, this.mHeaders, this.gCT, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gDv.onPrepared(this.gCE);
                }
            }
        } else if (this.gCC != null && this.gCC.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.gCU) {
                addView(this.gCC, layoutParams);
            } else {
                addView(this.gCC, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void UJ() {
        this.gCO = false;
        this.gCM = false;
        if (this.gCE != null) {
            if (this.gCE.isPlaying() && brA()) {
                y.bsc().aN(this.gDa, this.gCE.getCurrentPosition());
            }
            this.gCE.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDy);
    }

    private void tT(String str) {
        this.gDm = 0;
        this.gDn = 0;
        this.gDo = 0;
        this.gDp = 0;
        this.gDq = 0;
        this.bBY = 0;
        if (this.gCN.brl()) {
            this.gDl = gDh;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gDn = (int) u.tV(QuickVideoView.this.gCY);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gCY != null && this.gCY.equals(str)) {
            this.gDl = gDg;
        } else {
            this.gDl = gDi;
        }
        this.gmP = gDj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brw() {
        this.gmP = gDj;
        if (this.gCE != null) {
            this.gDm = this.gCE.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(boolean z) {
        if (this.gmP == gDj && this.gCE != null) {
            this.gmP = gDk;
            this.gDp = this.gCE.getDuration();
            if (z) {
                this.gDq = 0;
                this.gDo = this.gDp;
            } else {
                this.gDo = this.gCE.getCurrentPosition();
                this.gDq = this.gCE.getCachedSize();
            }
            if (this.gDo > 0) {
                if (this.gDl == gDg) {
                    this.gDn = (int) u.tV(this.gCY);
                    if (this.gDm > 0) {
                        long j = (this.gDm * (this.gDo / 1000)) / 8;
                        if (this.gDq < 0) {
                            this.gDq = 0;
                        }
                        long j2 = this.gDq + j;
                        if (this.gDn > 0) {
                            j2 += this.gDn;
                        }
                        setFlowCount(j2, this.gDo, this.gDp, this.bBY);
                    } else if (this.gDm == -1) {
                        this.gDm = 603327;
                        setFlowCount((this.gDm * (this.gDo / 1000)) / 8, this.gDo, this.gDp, this.bBY);
                    }
                } else if (this.gDl == gDh) {
                    if (this.gDm > 0) {
                        long j3 = (this.gDm * (this.gDo / 1000)) / 8;
                        if (this.gDq < 0) {
                            this.gDq = 0;
                        }
                        long j4 = this.gDq + j3;
                        if (this.gDn > 0) {
                            j4 -= this.gDn;
                        }
                        setFlowCount(j4, this.gDo, this.gDp, this.bBY);
                    } else if (this.gDm == -1) {
                        this.gDm = 603327;
                        setFlowCount((this.gDm * (this.gDo / 1000)) / 8, this.gDo, this.gDp, this.bBY);
                    }
                } else {
                    setFlowCount(0L, this.gDo, this.gDp, this.bBY);
                }
            }
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDy);
    }

    public void stopPlayback() {
        brx();
        mA(false);
        if (this.gCV != null) {
            this.gCV.clear();
        }
        this.gCD = null;
        UJ();
        this.gCQ = false;
        if (this.gCN != null) {
            this.gCN.onStop();
        }
        com.baidu.tieba.play.a.b.bsf().a((b.InterfaceC0295b) null);
        if (this.gCJ != null && this.gCJ.sf(getLocateSource())) {
            this.gCJ = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDy);
    }

    public void setFullScreenToDestroySurface() {
        this.gDr = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brx() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDs);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDt);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bxJ = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bxI = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.boW = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0298g interfaceC0298g) {
        this.bxM = interfaceC0298g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(String str, String str2, String str3) {
        if (this.gCX == null) {
            return "";
        }
        String bsk = this.gCX.bsk();
        this.gCX.O(str, str2, str3);
        return bsk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gCN != null && !StringUtils.isNull(this.gCN.brj())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.ua(uri);
                }
            }
            this.mUri = Uri.parse(this.gCN.brj());
        }
        boolean z = false;
        if (this.gCV != null) {
            z = this.gCV.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gCJ != null) {
            this.gCL = this.gCJ.a(i, i2, i3, getLocateSource(), z, this.gDb, N(this.gCJ.bcz(), i3 + "", this.gCJ.bcA()));
            this.gCJ = null;
        }
        this.gDb = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gCE != null) {
            try {
                if (this.gCE.isPlaying() && brA()) {
                    y.bsc().aN(this.gDa, this.gCE.getCurrentPosition());
                }
                this.gCE.release();
                this.gCD = str;
                URI uri = new URI(this.mUri.toString());
                this.gCE.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.mHeaders, this.gCT, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (g(this.mUri) != null) {
                    this.gCJ.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gCE != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.gCE.isPlaying() && brA()) {
                y.bsc().aN(this.gDa, this.gCE.getCurrentPosition());
            }
            this.gCE.release();
            this.gCE.a(this.mContext, this.mUri, this.mHeaders, this.gCT, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gCJ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gCE != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.gCE.forceUseSystemMediaPlayer(true);
            }
            if (this.gCE.isPlaying() && brA()) {
                y.bsc().aN(this.gDa, this.gCE.getCurrentPosition());
            }
            this.gCE.release();
            this.gCE.a(this.mContext, this.mUri, this.mHeaders, this.gCT, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (g(this.mUri) != null) {
                this.gCJ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gCM = true;
        if (this.gCE != null) {
            if (this.gCT != null && this.gCS && !this.gCE.isExistInRemote()) {
                this.gCE.a(this.mContext, this.mUri, this.mHeaders, this.gCT, this.gCR);
                if (this.gCk != null) {
                    this.gCk.bri();
                }
                if (g(this.mUri) != null) {
                    this.gCJ.bcv();
                }
                brv();
                return;
            }
            this.gCE.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gCN != null) {
            this.gCN.onStart();
        }
        if (this.gCG != null) {
            this.gCG.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (g(this.mUri) != null && this.gCE != null) {
            this.gCJ.rI(this.gCE.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        brx();
        if (this.gCE != null) {
            if (this.gCE.isPlaying() && brA()) {
                y.bsc().aN(this.gDa, this.gCE.getCurrentPosition());
            }
            this.gCE.pause();
        }
        if (this.gCN != null) {
            this.gCN.onPause();
        }
        this.gCM = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gCJ != null) {
            this.gCJ.bcy();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gCE != null) {
            return this.gCE.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gCE != null) {
            return this.gCE.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bBY = i;
        to(i);
    }

    public void to(int i) {
        if (this.gCW != null) {
            this.gCW.brL();
        }
        if (this.gCE != null) {
            this.gCE.seekTo(i);
        }
        if (this.gCN != null) {
            this.gCN.tn(0);
            brz();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gCE != null) {
            return this.gCE.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gCE != null) {
            this.gCE.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gCR = i;
    }

    public int getRecoveryState() {
        return this.gCR;
    }

    public void setNeedRecovery(boolean z) {
        this.gCS = z;
    }

    public void setLooping(boolean z) {
        this.gCQ = z;
    }

    public boolean bry() {
        return this.gCM;
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
        this.bpa = bVar;
    }

    public void setBusiness(d dVar) {
        this.gCN = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bxV);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gCQ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gCE != null) {
            this.gCE.Qc();
        }
        if (this.gCW != null) {
            this.gCW.brN();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDy);
        MessageManager.getInstance().unRegisterListener(this.bxV);
        if (this.gCV != null) {
            this.gCV.clear();
        }
        if (this.gCK != null) {
            this.gCK.a(null);
            this.gCK.bcn();
        }
    }

    public g getPlayer() {
        return this.gCE;
    }

    public int getPlayerType() {
        return this.gCE == null ? ReportLevel.USER : this.gCE.getPlayerType();
    }

    public void brz() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDy);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gDy, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gCk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gCN instanceof n) || ((n) this.gCN).brJ() == null) ? "" : ((n) this.gCN).brJ().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i g(Uri uri) {
        String uri2;
        if (this.gCJ != null) {
            return this.gCJ;
        }
        if (!StringUtils.isNull(this.gCY)) {
            uri2 = this.gCY;
        } else if (gCI != null && this.gCN != null && !StringUtils.isNull(this.gCN.brj())) {
            uri2 = this.gCN.brj();
        } else {
            uri2 = (gCI == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gCI != null) {
            this.gCJ = gCI.M(this.biw, uri2, this.gCL);
        }
        this.gCL = null;
        this.gDb = 0L;
        return this.gCJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brA() {
        return this.gCE != null && this.gCE.getDuration() >= this.gCE.getCurrentPosition();
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gCJ, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gCJ, j);
    }

    public static boolean hc(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gCF = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gCE != null) {
            return this.gCE.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gCE != null ? this.gCE.getId() : "";
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (this.gCJ != null) {
            this.gCJ.a(str, j, j2, j3, j4, j5, str2, i);
        }
    }

    public void setVideoStatusListener(c cVar) {
        this.gCG = cVar;
    }
}
