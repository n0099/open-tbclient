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
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static h gmO;
    private static com.baidu.tieba.j.l gmP;
    private static int gnm = 0;
    private static int gnn = 1;
    private static int gno = 2;
    private static int gnp = 1;
    private static int gnq = 0;
    private Map<String, String> Ht;
    private String aZG;
    private b bgC;
    private g.b bgy;
    private g.e bpA;
    private g.InterfaceC0225g bpB;
    private g.i bpC;
    private g.d bpD;
    private g.h bpE;
    private final CustomMessageListener bpK;
    private g.a bpx;
    private g.f bpy;
    private g.c bpz;
    private int btL;
    private int fXa;
    private RenderView gmJ;
    private String gmK;
    private g gmL;
    private g.e gmM;
    private c gmN;
    private com.baidu.tieba.j.i gmQ;
    private com.baidu.tieba.j.e gmR;
    private String gmS;
    private boolean gmT;
    private d gmU;
    private boolean gmV;
    private int gmW;
    private boolean gmX;
    private int gmY;
    private boolean gmZ;
    private a gmr;
    private g.f gnA;
    private g.a gnB;
    private g.InterfaceC0225g gnC;
    private Runnable gnD;
    private SurfaceTexture gna;
    private boolean gnb;
    private com.baidu.tieba.play.b.a gnc;
    private q gnd;
    private com.baidu.tieba.play.b.f gne;
    private String gnf;
    private String gng;
    private long gnh;
    private boolean gni;
    private boolean gnj;
    private long gnk;
    private long gnl;
    private int gnr;
    private int gns;
    private int gnt;
    private int gnu;
    private int gnv;
    private int gnw;
    private Runnable gnx;
    private Runnable gny;
    private TextureView.SurfaceTextureListener gnz;
    private Context mContext;
    private boolean mPlayerReuseEnable;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bmG();
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
            gmO = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        if (runTask2 != null) {
            gmP = (com.baidu.tieba.j.l) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.gnb = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.gmT = false;
        this.gmV = false;
        this.gmW = 0;
        this.gmX = false;
        this.gmY = -1;
        this.gmZ = false;
        this.gna = null;
        this.gnb = true;
        this.gnk = 0L;
        this.gnl = 0L;
        this.fXa = gnq;
        this.gnr = 0;
        this.gns = 0;
        this.gnt = -1;
        this.gnu = 0;
        this.gnv = 0;
        this.gnw = 0;
        this.btL = 0;
        this.gnx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gmL != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gmL, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gny = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.jk(false);
                }
            }
        };
        this.gnz = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gmV || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gmL != null && QuickVideoView.this.gmZ) {
                        QuickVideoView.this.gmL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ht, surfaceTexture, QuickVideoView.this.gmY);
                        if (QuickVideoView.this.gmr != null) {
                            QuickVideoView.this.gmr.bmG();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gmQ.aXV();
                        }
                    }
                } else if (bmZ()) {
                    if (QuickVideoView.this.gmL != null) {
                        QuickVideoView.this.bmT();
                        QuickVideoView.this.gmV = true;
                        QuickVideoView.this.gmL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ht, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gmQ.aXU();
                    }
                }
                QuickVideoView.this.gna = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bmV();
                QuickVideoView.this.lU(false);
                if (QuickVideoView.this.gmL != null) {
                    if (QuickVideoView.this.gmL.isPlaying()) {
                        x.bnz().aI(QuickVideoView.this.gng, QuickVideoView.this.gmL.getCurrentPosition());
                    }
                    QuickVideoView.this.gmL.release();
                }
                if (QuickVideoView.this.gmV) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.onStop();
                    }
                    if (QuickVideoView.this.bgC != null) {
                        QuickVideoView.this.bgC.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gna = null;
                if (QuickVideoView.this.gmQ != null && QuickVideoView.this.gmQ.rc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gmQ = null;
                }
                QuickVideoView.this.gmV = false;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bmZ() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.z(runningTasks)) {
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
        this.gnA = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int sP;
                QuickVideoView.this.bmV();
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.onPrepared();
                }
                if (QuickVideoView.this.gmQ != null && QuickVideoView.this.gmL != null) {
                    QuickVideoView.this.gmQ.qw(QuickVideoView.this.gmL.getPlayerType());
                }
                if (QuickVideoView.this.bpy != null) {
                    QuickVideoView.this.bpy.onPrepared(gVar);
                }
                if (QuickVideoView.this.gmU != null) {
                    long j = 0;
                    if (QuickVideoView.this.gmL != null) {
                        j = QuickVideoView.this.gmL.getDuration();
                    }
                    QuickVideoView.this.gmU.cP(j);
                    QuickVideoView.this.bmU();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gmU.bmN();
                        QuickVideoView.this.bmX();
                    }
                }
                if (QuickVideoView.this.gnj && (sP = x.bnz().sP(QuickVideoView.this.gng)) > 0) {
                    if (QuickVideoView.this.gmL.isPlayerReuse()) {
                        if (QuickVideoView.this.gmL.getCurrentPosition() == 0) {
                            QuickVideoView.this.se(sP);
                        }
                    } else {
                        QuickVideoView.this.se(sP);
                    }
                }
                if (QuickVideoView.this.gmT) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gmJ != null && gVar != null) {
                    QuickVideoView.this.gmJ.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gmW);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gmK) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gmK);
                }
                if (QuickVideoView.this.gnc != null && QuickVideoView.this.gnc.bnF()) {
                    com.baidu.tieba.play.b.e.si(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gnB = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lU(true);
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.rb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gmQ = null;
                }
                if (!QuickVideoView.this.gmX || QuickVideoView.this.gmU == null) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.onCompletion();
                    }
                    QuickVideoView.this.gmT = false;
                    if (QuickVideoView.this.bpx != null) {
                        QuickVideoView.this.bpx.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gmS = null;
                QuickVideoView.this.gnh = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gmU.bmH());
                QuickVideoView.this.start();
            }
        };
        this.bpz = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bmV();
                if (QuickVideoView.this.gmU != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gni = true;
                    x.bnz().aI(QuickVideoView.this.gng, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kK()) {
                    if (QuickVideoView.this.gmQ != null) {
                        QuickVideoView.this.gmS = QuickVideoView.this.gmQ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gnh, QuickVideoView.this.F(QuickVideoView.this.gmQ.aYa(), i3 + "", QuickVideoView.this.gmQ.aYb()));
                        QuickVideoView.this.gmQ = null;
                    }
                    QuickVideoView.this.gnh = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.sg(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sh(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bgy == null || QuickVideoView.this.bgy.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gnC = new g.InterfaceC0225g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0225g
            public void b(g gVar) {
                if (QuickVideoView.this.gni) {
                    QuickVideoView.this.gni = false;
                    return;
                }
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.bnj();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gmU != null && z) {
                    QuickVideoView.this.gmU.onSeekComplete();
                }
                if (QuickVideoView.this.bpB != null) {
                    QuickVideoView.this.bpB.b(gVar);
                }
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gmM != null) {
                    QuickVideoView.this.gmM.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gmW = i2;
                    if (QuickVideoView.this.gmJ != null && gVar != null) {
                        QuickVideoView.this.gmJ.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gmW);
                    }
                }
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.a(i, i2, QuickVideoView.this.gmQ);
                    return true;
                }
                return true;
            }
        };
        this.bpC = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.f(i, i2, str);
                }
            }
        };
        this.bpD = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.rd(str);
                }
            }
        };
        this.bpE = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gnh = j;
                }
            }
        };
        this.gnD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gmU != null && QuickVideoView.this.gmU.bmJ() && QuickVideoView.this.gmU.bmK() && QuickVideoView.this.gmU.bmL() && QuickVideoView.this.gmL != null) {
                    int RC = QuickVideoView.this.gmL.RC();
                    int currentPosition = QuickVideoView.this.gmL.getCurrentPosition();
                    int duration = QuickVideoView.this.gmL.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gnk;
                    boolean z = currentPosition + RC < duration;
                    if (RC < QuickVideoView.this.gmU.bmM() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gnk = currentTimeMillis;
                        QuickVideoView.this.gmU.sd(0);
                    }
                    if (QuickVideoView.this.bmW() && currentPosition == QuickVideoView.this.gnl && j > 500) {
                        QuickVideoView.this.gnk = currentTimeMillis;
                        QuickVideoView.this.gmU.sd(0);
                    }
                    QuickVideoView.this.gnl = currentPosition;
                    if (QuickVideoView.this.fXa == QuickVideoView.gnp) {
                        QuickVideoView.this.bmX();
                    }
                }
            }
        };
        this.bpK = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.bmP();
                    }
                    if (QuickVideoView.this.gmQ != null) {
                        QuickVideoView.this.gmQ.ra(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gmQ = null;
                    }
                    QuickVideoView.this.bmV();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmT = false;
        this.gmV = false;
        this.gmW = 0;
        this.gmX = false;
        this.gmY = -1;
        this.gmZ = false;
        this.gna = null;
        this.gnb = true;
        this.gnk = 0L;
        this.gnl = 0L;
        this.fXa = gnq;
        this.gnr = 0;
        this.gns = 0;
        this.gnt = -1;
        this.gnu = 0;
        this.gnv = 0;
        this.gnw = 0;
        this.btL = 0;
        this.gnx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gmL != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gmL, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gny = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.jk(false);
                }
            }
        };
        this.gnz = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.gmV || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gmL != null && QuickVideoView.this.gmZ) {
                        QuickVideoView.this.gmL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ht, surfaceTexture, QuickVideoView.this.gmY);
                        if (QuickVideoView.this.gmr != null) {
                            QuickVideoView.this.gmr.bmG();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gmQ.aXV();
                        }
                    }
                } else if (bmZ()) {
                    if (QuickVideoView.this.gmL != null) {
                        QuickVideoView.this.bmT();
                        QuickVideoView.this.gmV = true;
                        QuickVideoView.this.gmL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ht, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gmQ.aXU();
                    }
                }
                QuickVideoView.this.gna = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bmV();
                QuickVideoView.this.lU(false);
                if (QuickVideoView.this.gmL != null) {
                    if (QuickVideoView.this.gmL.isPlaying()) {
                        x.bnz().aI(QuickVideoView.this.gng, QuickVideoView.this.gmL.getCurrentPosition());
                    }
                    QuickVideoView.this.gmL.release();
                }
                if (QuickVideoView.this.gmV) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.onStop();
                    }
                    if (QuickVideoView.this.bgC != null) {
                        QuickVideoView.this.bgC.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gna = null;
                if (QuickVideoView.this.gmQ != null && QuickVideoView.this.gmQ.rc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gmQ = null;
                }
                QuickVideoView.this.gmV = false;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bmZ() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.z(runningTasks)) {
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
        this.gnA = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int sP;
                QuickVideoView.this.bmV();
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.onPrepared();
                }
                if (QuickVideoView.this.gmQ != null && QuickVideoView.this.gmL != null) {
                    QuickVideoView.this.gmQ.qw(QuickVideoView.this.gmL.getPlayerType());
                }
                if (QuickVideoView.this.bpy != null) {
                    QuickVideoView.this.bpy.onPrepared(gVar);
                }
                if (QuickVideoView.this.gmU != null) {
                    long j = 0;
                    if (QuickVideoView.this.gmL != null) {
                        j = QuickVideoView.this.gmL.getDuration();
                    }
                    QuickVideoView.this.gmU.cP(j);
                    QuickVideoView.this.bmU();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gmU.bmN();
                        QuickVideoView.this.bmX();
                    }
                }
                if (QuickVideoView.this.gnj && (sP = x.bnz().sP(QuickVideoView.this.gng)) > 0) {
                    if (QuickVideoView.this.gmL.isPlayerReuse()) {
                        if (QuickVideoView.this.gmL.getCurrentPosition() == 0) {
                            QuickVideoView.this.se(sP);
                        }
                    } else {
                        QuickVideoView.this.se(sP);
                    }
                }
                if (QuickVideoView.this.gmT) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gmJ != null && gVar != null) {
                    QuickVideoView.this.gmJ.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gmW);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gmK) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gmK);
                }
                if (QuickVideoView.this.gnc != null && QuickVideoView.this.gnc.bnF()) {
                    com.baidu.tieba.play.b.e.si(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gnB = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lU(true);
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.rb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gmQ = null;
                }
                if (!QuickVideoView.this.gmX || QuickVideoView.this.gmU == null) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.onCompletion();
                    }
                    QuickVideoView.this.gmT = false;
                    if (QuickVideoView.this.bpx != null) {
                        QuickVideoView.this.bpx.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gmS = null;
                QuickVideoView.this.gnh = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gmU.bmH());
                QuickVideoView.this.start();
            }
        };
        this.bpz = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                com.baidu.tieba.play.b.e.Z(i, i2, i3);
                QuickVideoView.this.bmV();
                if (QuickVideoView.this.gmU != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gni = true;
                    x.bnz().aI(QuickVideoView.this.gng, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kK()) {
                    if (QuickVideoView.this.gmQ != null) {
                        QuickVideoView.this.gmS = QuickVideoView.this.gmQ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gnh, QuickVideoView.this.F(QuickVideoView.this.gmQ.aYa(), i3 + "", QuickVideoView.this.gmQ.aYb()));
                        QuickVideoView.this.gmQ = null;
                    }
                    QuickVideoView.this.gnh = 0L;
                } else if (QuickVideoView.this.b(gVar, i, i2, i3)) {
                    com.baidu.tieba.play.b.e.sg(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sh(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bgy == null || QuickVideoView.this.bgy.onError(gVar, i2, i3)) {
                }
                return true;
            }
        };
        this.gnC = new g.InterfaceC0225g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0225g
            public void b(g gVar) {
                if (QuickVideoView.this.gni) {
                    QuickVideoView.this.gni = false;
                    return;
                }
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.bnj();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gmU != null && z) {
                    QuickVideoView.this.gmU.onSeekComplete();
                }
                if (QuickVideoView.this.bpB != null) {
                    QuickVideoView.this.bpB.b(gVar);
                }
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (QuickVideoView.this.gmM != null) {
                    QuickVideoView.this.gmM.onInfo(gVar, i, i2);
                }
                if (i == 10001) {
                    QuickVideoView.this.gmW = i2;
                    if (QuickVideoView.this.gmJ != null && gVar != null) {
                        QuickVideoView.this.gmJ.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gmW);
                    }
                }
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.a(i, i2, QuickVideoView.this.gmQ);
                    return true;
                }
                return true;
            }
        };
        this.bpC = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.f(i, i2, str);
                }
            }
        };
        this.bpD = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.rd(str);
                }
            }
        };
        this.bpE = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gnh = j;
                }
            }
        };
        this.gnD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gmU != null && QuickVideoView.this.gmU.bmJ() && QuickVideoView.this.gmU.bmK() && QuickVideoView.this.gmU.bmL() && QuickVideoView.this.gmL != null) {
                    int RC = QuickVideoView.this.gmL.RC();
                    int currentPosition = QuickVideoView.this.gmL.getCurrentPosition();
                    int duration = QuickVideoView.this.gmL.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gnk;
                    boolean z = currentPosition + RC < duration;
                    if (RC < QuickVideoView.this.gmU.bmM() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gnk = currentTimeMillis;
                        QuickVideoView.this.gmU.sd(0);
                    }
                    if (QuickVideoView.this.bmW() && currentPosition == QuickVideoView.this.gnl && j > 500) {
                        QuickVideoView.this.gnk = currentTimeMillis;
                        QuickVideoView.this.gmU.sd(0);
                    }
                    QuickVideoView.this.gnl = currentPosition;
                    if (QuickVideoView.this.fXa == QuickVideoView.gnp) {
                        QuickVideoView.this.bmX();
                    }
                }
            }
        };
        this.bpK = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.bmP();
                    }
                    if (QuickVideoView.this.gmQ != null) {
                        QuickVideoView.this.gmQ.ra(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gmQ = null;
                    }
                    QuickVideoView.this.bmV();
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmT = false;
        this.gmV = false;
        this.gmW = 0;
        this.gmX = false;
        this.gmY = -1;
        this.gmZ = false;
        this.gna = null;
        this.gnb = true;
        this.gnk = 0L;
        this.gnl = 0L;
        this.fXa = gnq;
        this.gnr = 0;
        this.gns = 0;
        this.gnt = -1;
        this.gnu = 0;
        this.gnv = 0;
        this.gnw = 0;
        this.btL = 0;
        this.gnx = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gmL != null) {
                    QuickVideoView.this.b(QuickVideoView.this.gmL, QuickVideoView.this.getPlayerType(), -90000, -90000);
                }
            }
        };
        this.gny = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.jk(false);
                }
            }
        };
        this.gnz = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.gmV || QuickVideoView.this.mUri == null) {
                    if (QuickVideoView.this.mUri != null && QuickVideoView.this.gmL != null && QuickVideoView.this.gmZ) {
                        QuickVideoView.this.gmL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ht, surfaceTexture, QuickVideoView.this.gmY);
                        if (QuickVideoView.this.gmr != null) {
                            QuickVideoView.this.gmr.bmG();
                        }
                        if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                            QuickVideoView.this.gmQ.aXV();
                        }
                    }
                } else if (bmZ()) {
                    if (QuickVideoView.this.gmL != null) {
                        QuickVideoView.this.bmT();
                        QuickVideoView.this.gmV = true;
                        QuickVideoView.this.gmL.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ht, surfaceTexture, QuickVideoView.this.mUri.getHost(), QuickVideoView.this.mPlayerReuseEnable);
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.gmQ.aXU();
                    }
                }
                QuickVideoView.this.gna = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.bmV();
                QuickVideoView.this.lU(false);
                if (QuickVideoView.this.gmL != null) {
                    if (QuickVideoView.this.gmL.isPlaying()) {
                        x.bnz().aI(QuickVideoView.this.gng, QuickVideoView.this.gmL.getCurrentPosition());
                    }
                    QuickVideoView.this.gmL.release();
                }
                if (QuickVideoView.this.gmV) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.onStop();
                    }
                    if (QuickVideoView.this.bgC != null) {
                        QuickVideoView.this.bgC.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.gna = null;
                if (QuickVideoView.this.gmQ != null && QuickVideoView.this.gmQ.rc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.gmQ = null;
                }
                QuickVideoView.this.gmV = false;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public boolean bmZ() {
                if (QuickVideoView.this.mContext instanceof Activity) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QuickVideoView.this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
                    if (!com.baidu.tbadk.core.util.v.z(runningTasks)) {
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
        this.gnA = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int sP;
                QuickVideoView.this.bmV();
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.onPrepared();
                }
                if (QuickVideoView.this.gmQ != null && QuickVideoView.this.gmL != null) {
                    QuickVideoView.this.gmQ.qw(QuickVideoView.this.gmL.getPlayerType());
                }
                if (QuickVideoView.this.bpy != null) {
                    QuickVideoView.this.bpy.onPrepared(gVar);
                }
                if (QuickVideoView.this.gmU != null) {
                    long j = 0;
                    if (QuickVideoView.this.gmL != null) {
                        j = QuickVideoView.this.gmL.getDuration();
                    }
                    QuickVideoView.this.gmU.cP(j);
                    QuickVideoView.this.bmU();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.gmU.bmN();
                        QuickVideoView.this.bmX();
                    }
                }
                if (QuickVideoView.this.gnj && (sP = x.bnz().sP(QuickVideoView.this.gng)) > 0) {
                    if (QuickVideoView.this.gmL.isPlayerReuse()) {
                        if (QuickVideoView.this.gmL.getCurrentPosition() == 0) {
                            QuickVideoView.this.se(sP);
                        }
                    } else {
                        QuickVideoView.this.se(sP);
                    }
                }
                if (QuickVideoView.this.gmT) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.gmJ != null && gVar != null) {
                    QuickVideoView.this.gmJ.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gmW);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.gmK) && QuickVideoView.this.mUri != null) {
                    com.baidu.tieba.play.b.e.a(QuickVideoView.this.mUri, QuickVideoView.this.gmK);
                }
                if (QuickVideoView.this.gnc != null && QuickVideoView.this.gnc.bnF()) {
                    com.baidu.tieba.play.b.e.si(QuickVideoView.this.getPlayerType());
                }
            }
        };
        this.gnB = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lU(true);
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.rb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.gmQ = null;
                }
                if (!QuickVideoView.this.gmX || QuickVideoView.this.gmU == null) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.onCompletion();
                    }
                    QuickVideoView.this.gmT = false;
                    if (QuickVideoView.this.bpx != null) {
                        QuickVideoView.this.bpx.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.gmS = null;
                QuickVideoView.this.gnh = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.gmU.bmH());
                QuickVideoView.this.start();
            }
        };
        this.bpz = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                com.baidu.tieba.play.b.e.Z(i2, i22, i3);
                QuickVideoView.this.bmV();
                if (QuickVideoView.this.gmU != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.gni = true;
                    x.bnz().aI(QuickVideoView.this.gng, QuickVideoView.this.getCurrentPosition());
                }
                if (!com.baidu.adp.lib.util.j.kK()) {
                    if (QuickVideoView.this.gmQ != null) {
                        QuickVideoView.this.gmS = QuickVideoView.this.gmQ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.gnh, QuickVideoView.this.F(QuickVideoView.this.gmQ.aYa(), i3 + "", QuickVideoView.this.gmQ.aYb()));
                        QuickVideoView.this.gmQ = null;
                    }
                    QuickVideoView.this.gnh = 0L;
                } else if (QuickVideoView.this.b(gVar, i2, i22, i3)) {
                    com.baidu.tieba.play.b.e.sg(QuickVideoView.this.getPlayerType());
                    return true;
                } else {
                    com.baidu.tieba.play.b.e.sh(QuickVideoView.this.getPlayerType());
                }
                if (QuickVideoView.this.bgy == null || QuickVideoView.this.bgy.onError(gVar, i22, i3)) {
                }
                return true;
            }
        };
        this.gnC = new g.InterfaceC0225g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0225g
            public void b(g gVar) {
                if (QuickVideoView.this.gni) {
                    QuickVideoView.this.gni = false;
                    return;
                }
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.bnj();
                }
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.gmU != null && z) {
                    QuickVideoView.this.gmU.onSeekComplete();
                }
                if (QuickVideoView.this.bpB != null) {
                    QuickVideoView.this.bpB.b(gVar);
                }
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                if (QuickVideoView.this.gmM != null) {
                    QuickVideoView.this.gmM.onInfo(gVar, i2, i22);
                }
                if (i2 == 10001) {
                    QuickVideoView.this.gmW = i22;
                    if (QuickVideoView.this.gmJ != null && gVar != null) {
                        QuickVideoView.this.gmJ.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.gmW);
                    }
                }
                if (QuickVideoView.this.gnd != null) {
                    QuickVideoView.this.gnd.a(i2, i22, QuickVideoView.this.gmQ);
                    return true;
                }
                return true;
            }
        };
        this.bpC = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.f(i2, i22, str);
                }
            }
        };
        this.bpD = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.gmQ != null) {
                    QuickVideoView.this.gmQ.rd(str);
                }
            }
        };
        this.bpE = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.gnh = j;
                }
            }
        };
        this.gnD = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.gmU != null && QuickVideoView.this.gmU.bmJ() && QuickVideoView.this.gmU.bmK() && QuickVideoView.this.gmU.bmL() && QuickVideoView.this.gmL != null) {
                    int RC = QuickVideoView.this.gmL.RC();
                    int currentPosition = QuickVideoView.this.gmL.getCurrentPosition();
                    int duration = QuickVideoView.this.gmL.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.gnk;
                    boolean z = currentPosition + RC < duration;
                    if (RC < QuickVideoView.this.gmU.bmM() * 1000 && j > 5000 && z) {
                        QuickVideoView.this.gnk = currentTimeMillis;
                        QuickVideoView.this.gmU.sd(0);
                    }
                    if (QuickVideoView.this.bmW() && currentPosition == QuickVideoView.this.gnl && j > 500) {
                        QuickVideoView.this.gnk = currentTimeMillis;
                        QuickVideoView.this.gmU.sd(0);
                    }
                    QuickVideoView.this.gnl = currentPosition;
                    if (QuickVideoView.this.fXa == QuickVideoView.gnp) {
                        QuickVideoView.this.bmX();
                    }
                }
            }
        };
        this.bpK = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.gmU != null) {
                        QuickVideoView.this.gmU.bmP();
                    }
                    if (QuickVideoView.this.gmQ != null) {
                        QuickVideoView.this.gmQ.ra(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.gmQ = null;
                    }
                    QuickVideoView.this.bmV();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.gmJ = new RenderView(context);
        this.gmJ.setSurfaceTextureListener(this.gnz);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.gnb) {
            addView(this.gmJ, layoutParams);
        } else {
            addView(this.gmJ, 0, layoutParams);
        }
        if (gmO != null) {
            this.gmL = gmO.RD();
        }
        if (this.gmL != null) {
            this.gmL.setOnPreparedListener(this.gnA);
            this.gmL.setOnCompletionListener(this.gnB);
            this.gmL.a(this.bpz);
            this.gmL.setOnSeekCompleteListener(this.gnC);
            this.gmL.a(this.bpA);
            this.gmL.a(this.bpC);
            this.gmL.a(this.bpD);
            this.gmL.a(this.bpE);
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
        this.gnc = new com.baidu.tieba.play.b.a(this);
        this.gnd = new q();
        this.gne = new com.baidu.tieba.play.b.f();
    }

    public void setPlayerReuseEnable(boolean z) {
        boolean z2 = true;
        if (!(com.baidu.adp.lib.b.d.iB().aO("android_video_player_reuseable") == 1) || !z) {
            z2 = false;
        }
        this.mPlayerReuseEnable = z2;
    }

    public void setContinuePlayEnable(boolean z) {
        this.gnj = z;
    }

    public void setVideoPath(String str, String str2) {
        this.aZG = str2;
        if (this.gnc != null) {
            this.gnc.clear();
            this.gnc.bnF();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.tieba.play.b.e.sU(str2);
            if (gmP != null) {
                this.gmQ = gmP.E(this.aZG, str, "");
                if (this.gmQ != null) {
                    this.gmQ.a(-300, -44399, -44399, getLocateSource(), false, this.gnh, "");
                    this.gmQ = null;
                }
            }
        }
        if (this.gmR != null) {
            this.gmR.a(null);
            this.gmR.aXN();
            this.gmR = null;
        }
        this.gmS = null;
        this.gnh = 0L;
        setVideoPath(str);
    }

    public void cd(String str, String str2) {
        if (!ao.isEmpty(str) && this.gmU != null) {
            String sL = sL(str);
            if (!ao.F(sL, this.gmU.iT(sL))) {
                setVideoPath(str, str2);
            }
        }
    }

    private String sL(String str) {
        if (!ao.isEmpty(str) && com.baidu.tieba.video.g.bCZ().bDa()) {
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
            this.gng = str;
            String sL = sL(str);
            this.gnf = sL;
            if (this.gmU != null) {
                sL = this.gmU.iT(sL);
                if (this.gmU.bmO() != null) {
                    this.gmU.bmO().setPlayer(this);
                }
                if (gmP != null && gv(sL)) {
                    this.gmR = gmP.rg(sL);
                }
                if (this.gmR != null) {
                    this.gmR.a(new com.baidu.tieba.play.monitor.a(this.aZG, this.gnf, this.gmQ));
                    this.gmR.aXM();
                }
                sM(sL);
            }
            if (!com.baidu.adp.lib.util.j.kK() && !gv(sL)) {
                if (this.bgy != null) {
                    this.bgy.onError(this.gmL, -10000, -10000);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(sL));
            if (this.gmQ != null) {
                if (f(Uri.parse(sL)) != null) {
                    this.gmQ.aXT();
                }
                this.gmQ.aXZ();
                this.gmQ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmT() {
        if (com.baidu.tbadk.coreExtra.model.f.GC()) {
            if (this.gmU != null && (this.gmU.bmI() || this.gmU.bmJ())) {
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnx);
                com.baidu.adp.lib.g.e.jt().postDelayed(this.gnx, com.baidu.tbadk.coreExtra.model.f.GB());
            }
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gny);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.gny, com.baidu.tbadk.coreExtra.model.f.GA());
        }
    }

    private void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        if (f(uri) != null) {
            this.gmQ.qZ(uri.toString());
        }
        if (this.mUri == null || !this.mUri.equals(uri)) {
            Ry();
        }
        this.mUri = uri;
        this.Ht = map;
        this.gmW = 0;
        if (this.gna != null) {
            bmT();
            if (this.gmL != null) {
                if (!this.gmV) {
                    this.gmV = true;
                    this.gmL.a(this.mContext, this.mUri, this.Ht, this.gna, this.mUri.getHost(), this.mPlayerReuseEnable);
                } else if (!isPlaying()) {
                    this.gnA.onPrepared(this.gmL);
                }
            }
        } else if (this.gmJ != null && this.gmJ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            if (this.gnb) {
                addView(this.gmJ, layoutParams);
            } else {
                addView(this.gmJ, 0, layoutParams);
            }
        }
        al.j(this, e.d.cp_bg_line_k);
    }

    private void Ry() {
        this.gmV = false;
        this.gmT = false;
        if (this.gmL != null) {
            if (this.gmL.isPlaying()) {
                x.bnz().aI(this.gng, this.gmL.getCurrentPosition());
            }
            this.gmL.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnD);
    }

    private void sM(String str) {
        this.gns = 0;
        this.gnt = 0;
        this.gnu = 0;
        this.gnv = 0;
        this.gnw = 0;
        this.btL = 0;
        if (this.gmU.bmJ()) {
            this.gnr = gnn;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.gnt = (int) t.sO(QuickVideoView.this.gnf);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.gnf != null && this.gnf.equals(str)) {
            this.gnr = gnm;
        } else {
            this.gnr = gno;
        }
        this.fXa = gnp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmU() {
        this.fXa = gnp;
        if (this.gmL != null) {
            this.gns = this.gmL.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(boolean z) {
        if (this.fXa == gnp && this.gmL != null) {
            this.fXa = gnq;
            this.gnv = this.gmL.getDuration();
            if (z) {
                this.gnw = 0;
                this.gnu = this.gnv;
            } else {
                this.gnu = this.gmL.getCurrentPosition();
                this.gnw = this.gmL.getCachedSize();
            }
            if (this.gnu > 0) {
                if (this.gnr == gnm) {
                    this.gnt = (int) t.sO(this.gnf);
                    if (this.gns > 0) {
                        long j = (this.gns * (this.gnu / 1000)) / 8;
                        if (this.gnw < 0) {
                            this.gnw = 0;
                        }
                        long j2 = this.gnw + j;
                        if (this.gnt > 0) {
                            j2 += this.gnt;
                        }
                        setFlowCount(j2, this.gnu, this.gnv, this.btL);
                    } else if (this.gns == -1) {
                        this.gns = 603327;
                        setFlowCount((this.gns * (this.gnu / 1000)) / 8, this.gnu, this.gnv, this.btL);
                    }
                } else if (this.gnr == gnn) {
                    if (this.gns > 0) {
                        long j3 = (this.gns * (this.gnu / 1000)) / 8;
                        if (this.gnw < 0) {
                            this.gnw = 0;
                        }
                        long j4 = this.gnw + j3;
                        if (this.gnt > 0) {
                            j4 -= this.gnt;
                        }
                        setFlowCount(j4, this.gnu, this.gnv, this.btL);
                    } else if (this.gns == -1) {
                        this.gns = 603327;
                        setFlowCount((this.gns * (this.gnu / 1000)) / 8, this.gnu, this.gnv, this.btL);
                    }
                } else {
                    setFlowCount(0L, this.gnu, this.gnv, this.btL);
                }
            }
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnD);
    }

    public void stopPlayback() {
        bmV();
        lU(false);
        if (this.gnc != null) {
            this.gnc.clear();
        }
        this.gmK = null;
        Ry();
        this.gmX = false;
        if (this.gmU != null) {
            this.gmU.onStop();
        }
        com.baidu.tieba.play.a.b.bnC().a((b.InterfaceC0222b) null);
        if (this.gmQ != null && this.gmQ.rc(getLocateSource())) {
            this.gmQ = null;
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmV() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnx);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gny);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.bpy = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.bpx = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.bgy = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0225g interfaceC0225g) {
        this.bpB = interfaceC0225g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F(String str, String str2, String str3) {
        if (this.gne == null) {
            return "";
        }
        String bnH = this.gne.bnH();
        this.gne.G(str, str2, str3);
        return bnH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar, int i, int i2, int i3) {
        if (this.gmU != null && !StringUtils.isNull(this.gmU.bmH())) {
            if (this.mUri != null) {
                String uri = this.mUri.toString();
                if (!uri.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    com.baidu.tieba.play.b.a.sT(uri);
                }
            }
            this.mUri = Uri.parse(this.gmU.bmH());
        }
        boolean z = false;
        if (this.gnc != null) {
            z = this.gnc.a(gVar, i, i2, i3, this.mUri);
        }
        if (this.gmQ != null) {
            this.gmS = this.gmQ.a(i, i2, i3, getLocateSource(), z, this.gnh, F(this.gmQ.aYa(), i3 + "", this.gmQ.aYb()));
            this.gmQ = null;
        }
        this.gnh = 0L;
        return z;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4, int i5) {
        if (this.gmL != null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gmL.getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
                if (this.gmL.isPlaying()) {
                    x.bnz().aI(this.gng, this.gmL.getCurrentPosition());
                }
                this.gmL.release();
                this.gmK = str;
                URI uri = new URI(this.mUri.toString());
                this.gmL.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Ht, this.gna, this.mUri.getHost(), this.mPlayerReuseEnable);
                if (f(this.mUri) != null) {
                    this.gmQ.a(i5, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gmL != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (this.gmL.isPlaying()) {
                x.bnz().aI(this.gng, this.gmL.getCurrentPosition());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gmL.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
            this.gmL.release();
            this.gmL.a(this.mContext, this.mUri, this.Ht, this.gna, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gmQ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4, int i5) {
        if (this.gmL != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gmL.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
            if (i == -200 || i == -300) {
                this.gmL.forceUseSystemMediaPlayer(true);
            }
            if (this.gmL.isPlaying()) {
                x.bnz().aI(this.gng, this.gmL.getCurrentPosition());
            }
            this.gmL.release();
            this.gmL.a(this.mContext, this.mUri, this.Ht, this.gna, this.mUri.getHost(), this.mPlayerReuseEnable);
            if (f(this.mUri) != null) {
                this.gmQ.a(i5, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.gmT = true;
        if (this.gmL != null) {
            if (this.gna != null && this.gmZ && !this.gmL.isExistInRemote()) {
                this.gmL.a(this.mContext, this.mUri, this.Ht, this.gna, this.gmY);
                if (this.gmr != null) {
                    this.gmr.bmG();
                }
                if (f(this.mUri) != null) {
                    this.gmQ.aXV();
                }
                bmT();
                return;
            }
            this.gmL.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
        if (this.gmU != null) {
            this.gmU.onStart();
        }
        if (this.gmN != null) {
            this.gmN.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null && this.gmL != null) {
            this.gmQ.qx(this.gmL.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bmV();
        if (this.gmL != null) {
            if (this.gmL.isPlaying()) {
                x.bnz().aI(this.gng, this.gmL.getCurrentPosition());
            }
            this.gmL.pause();
        }
        if (this.gmU != null) {
            this.gmU.onPause();
        }
        this.gmT = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gmQ != null) {
            this.gmQ.aXY();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.gmL != null) {
            return this.gmL.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.gmL != null) {
            return this.gmL.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.btL = i;
        se(i);
    }

    public void se(int i) {
        if (this.gnd != null) {
            this.gnd.bni();
        }
        if (this.gmL != null) {
            this.gmL.seekTo(i);
        }
        if (this.gmU != null) {
            this.gmU.sd(0);
            bmX();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.gmL != null) {
            return this.gmL.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.gmL != null) {
            this.gmL.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.gmY = i;
    }

    public int getRecoveryState() {
        return this.gmY;
    }

    public void setNeedRecovery(boolean z) {
        this.gmZ = z;
    }

    public void setLooping(boolean z) {
        this.gmX = z;
    }

    public boolean bmW() {
        return this.gmT;
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
        this.bgC = bVar;
    }

    public void setBusiness(d dVar) {
        this.gmU = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bpK);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gmX = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.gmL != null) {
            this.gmL.MP();
        }
        if (this.gnd != null) {
            this.gnd.bnk();
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnD);
        MessageManager.getInstance().unRegisterListener(this.bpK);
        if (this.gnc != null) {
            this.gnc.clear();
        }
        if (this.gmR != null) {
            this.gmR.a(null);
            this.gmR.aXN();
        }
    }

    public g getPlayer() {
        return this.gmL;
    }

    public int getPlayerType() {
        if (this.gmL == null) {
            return -300;
        }
        return this.gmL.getPlayerType();
    }

    public void bmX() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnD);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.gnD, 200L);
    }

    public void setOnRecoveryCallback(a aVar) {
        this.gmr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.gmU instanceof n) || ((n) this.gmU).bng() == null) ? "" : ((n) this.gmU).bng().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.j.i f(Uri uri) {
        String uri2;
        if (this.gmQ != null) {
            return this.gmQ;
        }
        if (!StringUtils.isNull(this.gnf)) {
            uri2 = this.gnf;
        } else if (gmP != null && this.gmU != null && !StringUtils.isNull(this.gmU.bmH())) {
            uri2 = this.gmU.bmH();
        } else {
            uri2 = (gmP == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && gmP != null) {
            this.gmQ = gmP.E(this.aZG, uri2, this.gmS);
        }
        this.gmS = null;
        this.gnh = 0L;
        return this.gmQ;
    }

    public void setFlowCount(long j, long j2, long j3, long j4) {
        com.baidu.tieba.play.monitor.b.a(this.gmQ, j, j2, j3, j4);
    }

    public void setPbLoadingTime(long j) {
        com.baidu.tieba.play.monitor.b.a(this.gmQ, j);
    }

    public static boolean gv(String str) {
        return (StringUtils.isNull(str) || str.contains(HttpHost.DEFAULT_SCHEME_NAME)) ? false : true;
    }

    public void setOnOutInfoListener(g.e eVar) {
        this.gmM = eVar;
    }

    public List<String> getMediaIDs() {
        if (this.gmL != null) {
            return this.gmL.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.gmL != null ? this.gmL.getId() : "";
    }

    public void setVideoStatusListener(c cVar) {
        this.gmN = cVar;
    }
}
