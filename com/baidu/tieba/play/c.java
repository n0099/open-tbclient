package com.baidu.tieba.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int jsq;
    private static CallStateReceiver jsr;
    private boolean YV;
    private int YW;
    private Runnable Zb;
    protected boolean Zh;
    private TbImageView ajE;
    private String ajO;
    private View bjD;
    private Animation btW;
    private int currentState;
    private TbPageContext<?> dPv;
    private String eEs;
    private w eKZ;
    private QuickVideoView.b eLi;
    private g.a eUI;
    private g.f eUJ;
    private g.e eUL;
    private g.InterfaceC0721g eUM;
    private SeekBar.OnSeekBarChangeListener eZq;
    private VideoLoadingProgressView.a gQZ;
    protected View gTN;
    private Animation hGb;
    public View jrJ;
    private VideoListMediaControllerView jrL;
    private View jrM;
    private FrameLayout jrN;
    protected FrameLayout.LayoutParams jrO;
    private ImageView jrR;
    private View jrS;
    private View jrU;
    private g.f jrW;
    private ImageView jrY;
    private TextView jrZ;
    private CustomMessageListener jsA;
    private View jsd;
    private View jse;
    private TextView jsf;
    private SeekBar jsg;
    private ImageView jsh;
    private ImageView jsi;
    private int jsj;
    private int jsk;
    private int jsl;
    private com.baidu.tieba.play.o jsn;
    private int jso;
    private int jsp;
    private boolean jss;
    private g.b jsu;
    protected Runnable jsv;
    private Animation.AnimationListener jsx;
    private Animation.AnimationListener jsy;
    private Runnable jsz;
    private VideoControllerView.b juu;
    private boolean kRV;
    protected com.baidu.tieba.play.a.a kRW;
    private ProgressBar kRX;
    private View kRY;
    private SwitchImageView kRZ;
    private TextView kSA;
    private boolean kSB;
    private boolean kSC;
    private boolean kSD;
    private boolean kSE;
    private int kSF;
    private boolean kSG;
    private boolean kSH;
    private boolean kSI;
    private boolean kSJ;
    private Runnable kSK;
    private Runnable kSL;
    private QuickVideoView.a kSM;
    private TextView kSa;
    private TextView kSb;
    private TextView kSc;
    private int kSd;
    private g.a kSe;
    private g.b kSf;
    private boolean kSg;
    private boolean kSh;
    private View.OnClickListener kSi;
    protected InterfaceC0720c kSj;
    private d kSk;
    private long kSl;
    private o kSm;
    private h kSn;
    private j kSo;
    private k kSp;
    private m kSq;
    private a kSr;
    private n kSs;
    private l kSt;
    private f kSu;
    private g kSv;
    private boolean kSw;
    private boolean kSx;
    private boolean kSy;
    private boolean kSz;
    private i kwD;
    private String kwd;
    private p kwr;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    protected View.OnClickListener mOnClickListener;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mStartPosition;
    private int mStatus;
    private int mVideoType;
    private String mVideoUrl;

    /* loaded from: classes.dex */
    public interface a {
        void oc(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0720c {
        void qd();

        void qe();
    }

    /* loaded from: classes.dex */
    public interface d {
        void caM();

        void nx(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void tJ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void nw(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void cPa();
    }

    /* loaded from: classes.dex */
    public interface i {
        void caN();
    }

    /* loaded from: classes.dex */
    public interface j {
        void sL(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void caK();

        void caL();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cPb();

        boolean cPc();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Ak();

        void CK(int i);

        void cUY();

        void cUZ();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cOZ();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.YW = 100;
        this.kRV = false;
        this.Zh = false;
        this.YV = false;
        this.kSg = false;
        this.kSh = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.jsk = 0;
        this.jsl = 0;
        this.kSl = 60000L;
        this.jso = 0;
        this.jss = false;
        this.kSw = true;
        this.kSx = true;
        this.kSy = false;
        this.kSz = false;
        this.kwd = null;
        this.currentState = -1;
        this.kSB = false;
        this.kSG = true;
        this.kSI = false;
        this.kSJ = false;
        this.eUJ = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.jrL != null && c.this.kRW != null && c.this.kRW.getDuration() > 0) {
                    c.this.jrL.bn(0, c.this.kRW.getDuration());
                }
                c.this.bOi();
                if (c.this.kSm != null) {
                    c.this.kSm.onPrepared();
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.qu();
                    return false;
                }
                return false;
            }
        };
        this.gQZ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bOi();
            }
        };
        this.Zb = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.Zb);
                if (c.this.ajE.getVisibility() != 8) {
                    if (c.this.kRW.getCurrentPosition() > c.this.YW) {
                        c.this.qu();
                    } else {
                        com.baidu.adp.lib.f.e.lt().postDelayed(c.this.Zb, 20L);
                    }
                }
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kRW != null) {
                    int duration = c.this.kRW.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.YV = false;
                        c.this.kSE = false;
                        c.this.mStartPosition = 0;
                        c.this.cxS();
                        c.this.jrM.setVisibility(0);
                        c.this.kRX.setProgress(c.this.kRX.getMax());
                        c.this.YW = 100;
                        if (c.this.kSe != null) {
                            c.this.kSe.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cUA()) {
                            ((QuickVideoView) c.this.kRW).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.tE(false);
                            c.this.tF(true);
                        } else {
                            c.this.cUS();
                            c.this.kSa.setVisibility(0);
                        }
                        if (!c.this.Zh && duration <= 150000) {
                            if (!c.this.kSB) {
                                if (c.this.kSo != null) {
                                    c.this.kSo.sL(true);
                                }
                                c.this.B(c.this.mVideoUrl, c.this.ajO, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cUA()) {
                                    ((QuickVideoView) c.this.kRW).setRecoveryState(5);
                                }
                                c.this.kRW.pause();
                                c.this.kRW.seekTo(0);
                            }
                        }
                        if (c.this.kSm != null) {
                            c.this.kSm.CK(c.this.kRX.getMax());
                            c.this.kSm.Ak();
                        }
                    }
                }
            }
        };
        this.jsu = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.gTN.setVisibility(0);
                c.this.eKZ.cVT();
                c.this.currentState = 4;
                if (c.this.cUA()) {
                    ((QuickVideoView) c.this.kRW).setRecoveryState(4);
                }
                if (c.this.kSf != null) {
                    c.this.kSf.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kSC = true;
                }
                if (c.this.kSm != null) {
                    c.this.kSm.cUY();
                }
                c.this.kSE = false;
                return true;
            }
        };
        this.jsv = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kRW == null || !c.this.kRW.isPlaying()) {
                    c.this.gTN.setVisibility(0);
                    c.this.eKZ.cVT();
                    if (c.this.kSm != null) {
                        c.this.kSm.cUY();
                    }
                }
            }
        };
        this.eUM = new g.InterfaceC0721g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kSy) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.kSK, 200L);
                }
            }
        };
        this.kSK = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kRW == null || !c.this.kSy) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.Zb, 200L);
                    c.this.kSy = false;
                } else if (c.this.mStartPosition != c.this.kRW.getCurrentPosition()) {
                    c.this.kSy = false;
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.Zb, 20L);
                } else {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.kSK, 200L);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.YV = false;
                if (c.this.kSh) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.kSL, 300L);
                }
                com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.Zb);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.jsv);
            }
        };
        this.kSL = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kSE = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.kwr != null) {
                    c.this.kwr.cOZ();
                }
                if (view2.getId() != c.this.gTN.getId()) {
                    if (view2.getId() != c.this.kRZ.getId()) {
                        if (view2.getId() == c.this.kSb.getId()) {
                            if (c.this.kSn != null) {
                                c.this.kSn.cPa();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kSa.getId()) {
                            if (c.this.kSo != null) {
                                c.this.kSo.sL(false);
                            }
                            c.this.fd(c.this.mVideoUrl, c.this.ajO);
                            return;
                        } else if (view2.getId() == c.this.jrR.getId()) {
                            int i2 = c.this.kSh ? 1 : 2;
                            if (c.this.Zh) {
                                TiebaStatic.log(new ao("c11714"));
                                TiebaStatic.log(new ao("c13262").dk("tid", c.this.ajO).dk("fid", c.this.eEs).ag("obj_type", i2).ag("obj_source", 2));
                            } else {
                                TiebaStatic.log(new ao("c11710"));
                                TiebaStatic.log(new ao("c13262").dk("tid", c.this.ajO).dk("fid", c.this.eEs).ag("obj_type", i2).ag("obj_source", 1));
                            }
                            if (c.this.kSt != null) {
                                c.this.kSt.caL();
                            }
                            if (c.this.cUC()) {
                                if (c.this.Zh) {
                                    c.this.cUG();
                                } else {
                                    c.this.cUF();
                                }
                                c.this.tB(c.this.Zh);
                                return;
                            }
                            c.this.Ii();
                            return;
                        } else if (view2.getId() != c.this.jrY.getId()) {
                            if (c.this.kSi != null) {
                                c.this.kSi.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new ao("c11713"));
                            if (c.this.kSt != null) {
                                c.this.kSt.caL();
                            }
                            if (c.this.cUC()) {
                                c.this.cUG();
                                c.this.tB(false);
                                return;
                            }
                            c.this.Ii();
                            return;
                        }
                    }
                    TiebaStatic.log(new ao("c13255"));
                    c.this.cOS();
                    c.this.cUU();
                    if (c.this.currentState != 1) {
                        c.this.cUQ();
                        c.this.cUR();
                    } else {
                        c.this.cyi();
                    }
                    if (c.this.kSr != null) {
                        c.this.kSr.oc(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kRW.stopPlayback();
                c.this.YV = false;
                c.this.cUL();
            }
        };
        this.jsx = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jsy = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jsz = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cyf();
            }
        };
        this.jsA = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.awZ();
                }
            }
        };
        this.juu = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pF(int i2) {
                int duration;
                if (c.this.kRW != null && (duration = c.this.kRW.getDuration()) > 0 && c.this.kRX != null) {
                    c.this.kRX.setProgress((int) ((i2 * c.this.jrJ.getWidth()) / duration));
                    if (c.this.kSm != null) {
                        c.this.kSm.CK((c.this.kRW.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eZq = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new ao("c13256"));
                c.this.cUQ();
                c.this.tF(false);
                if (c.this.kSr != null) {
                    c.this.kSr.oc(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cxW() != null) {
                    c.this.zE(c.this.cxW().getSeekPosition());
                    if (!c.this.cye()) {
                        c.this.cUL();
                    } else {
                        c.this.axa();
                        if (c.this.kwD != null) {
                            c.this.kwD.caN();
                        }
                    }
                }
                c.this.tF(true);
                c.this.cUP();
                if (c.this.kSr != null) {
                    c.this.kSr.oc(true);
                }
                if (c.this.kSs != null) {
                    c.this.kSs.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kSM = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cUX() {
                if (!c.this.kSB) {
                    c.this.eKZ.startLoading();
                    c.this.ajE.setVisibility(0);
                    c.this.kRZ.setVisibility(8);
                    c.this.kSb.setVisibility(8);
                    c.this.kSa.setVisibility(8);
                    c.this.kSc.setVisibility(8);
                    c.this.gTN.setVisibility(8);
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.jsv);
                    if (c.this.kSl > 0) {
                        com.baidu.adp.lib.f.e.lt().postDelayed(c.this.jsv, c.this.kSl);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.dPv = tbPageContext;
            this.mRootView = view;
            this.kSG = z;
            this.jrU = view;
            this.mActivity = this.dPv.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.YW = 100;
        this.kRV = false;
        this.Zh = false;
        this.YV = false;
        this.kSg = false;
        this.kSh = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.jsk = 0;
        this.jsl = 0;
        this.kSl = 60000L;
        this.jso = 0;
        this.jss = false;
        this.kSw = true;
        this.kSx = true;
        this.kSy = false;
        this.kSz = false;
        this.kwd = null;
        this.currentState = -1;
        this.kSB = false;
        this.kSG = true;
        this.kSI = false;
        this.kSJ = false;
        this.eUJ = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.jrL != null && c.this.kRW != null && c.this.kRW.getDuration() > 0) {
                    c.this.jrL.bn(0, c.this.kRW.getDuration());
                }
                c.this.bOi();
                if (c.this.kSm != null) {
                    c.this.kSm.onPrepared();
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.qu();
                    return false;
                }
                return false;
            }
        };
        this.gQZ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bOi();
            }
        };
        this.Zb = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.Zb);
                if (c.this.ajE.getVisibility() != 8) {
                    if (c.this.kRW.getCurrentPosition() > c.this.YW) {
                        c.this.qu();
                    } else {
                        com.baidu.adp.lib.f.e.lt().postDelayed(c.this.Zb, 20L);
                    }
                }
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kRW != null) {
                    int duration = c.this.kRW.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.YV = false;
                        c.this.kSE = false;
                        c.this.mStartPosition = 0;
                        c.this.cxS();
                        c.this.jrM.setVisibility(0);
                        c.this.kRX.setProgress(c.this.kRX.getMax());
                        c.this.YW = 100;
                        if (c.this.kSe != null) {
                            c.this.kSe.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cUA()) {
                            ((QuickVideoView) c.this.kRW).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.tE(false);
                            c.this.tF(true);
                        } else {
                            c.this.cUS();
                            c.this.kSa.setVisibility(0);
                        }
                        if (!c.this.Zh && duration <= 150000) {
                            if (!c.this.kSB) {
                                if (c.this.kSo != null) {
                                    c.this.kSo.sL(true);
                                }
                                c.this.B(c.this.mVideoUrl, c.this.ajO, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cUA()) {
                                    ((QuickVideoView) c.this.kRW).setRecoveryState(5);
                                }
                                c.this.kRW.pause();
                                c.this.kRW.seekTo(0);
                            }
                        }
                        if (c.this.kSm != null) {
                            c.this.kSm.CK(c.this.kRX.getMax());
                            c.this.kSm.Ak();
                        }
                    }
                }
            }
        };
        this.jsu = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.gTN.setVisibility(0);
                c.this.eKZ.cVT();
                c.this.currentState = 4;
                if (c.this.cUA()) {
                    ((QuickVideoView) c.this.kRW).setRecoveryState(4);
                }
                if (c.this.kSf != null) {
                    c.this.kSf.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kSC = true;
                }
                if (c.this.kSm != null) {
                    c.this.kSm.cUY();
                }
                c.this.kSE = false;
                return true;
            }
        };
        this.jsv = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kRW == null || !c.this.kRW.isPlaying()) {
                    c.this.gTN.setVisibility(0);
                    c.this.eKZ.cVT();
                    if (c.this.kSm != null) {
                        c.this.kSm.cUY();
                    }
                }
            }
        };
        this.eUM = new g.InterfaceC0721g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0721g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kSy) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.kSK, 200L);
                }
            }
        };
        this.kSK = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kRW == null || !c.this.kSy) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.Zb, 200L);
                    c.this.kSy = false;
                } else if (c.this.mStartPosition != c.this.kRW.getCurrentPosition()) {
                    c.this.kSy = false;
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.Zb, 20L);
                } else {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.kSK, 200L);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.YV = false;
                if (c.this.kSh) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.kSL, 300L);
                }
                com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.Zb);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.jsv);
            }
        };
        this.kSL = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kSE = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.kwr != null) {
                    c.this.kwr.cOZ();
                }
                if (view2.getId() != c.this.gTN.getId()) {
                    if (view2.getId() != c.this.kRZ.getId()) {
                        if (view2.getId() == c.this.kSb.getId()) {
                            if (c.this.kSn != null) {
                                c.this.kSn.cPa();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kSa.getId()) {
                            if (c.this.kSo != null) {
                                c.this.kSo.sL(false);
                            }
                            c.this.fd(c.this.mVideoUrl, c.this.ajO);
                            return;
                        } else if (view2.getId() == c.this.jrR.getId()) {
                            int i22 = c.this.kSh ? 1 : 2;
                            if (c.this.Zh) {
                                TiebaStatic.log(new ao("c11714"));
                                TiebaStatic.log(new ao("c13262").dk("tid", c.this.ajO).dk("fid", c.this.eEs).ag("obj_type", i22).ag("obj_source", 2));
                            } else {
                                TiebaStatic.log(new ao("c11710"));
                                TiebaStatic.log(new ao("c13262").dk("tid", c.this.ajO).dk("fid", c.this.eEs).ag("obj_type", i22).ag("obj_source", 1));
                            }
                            if (c.this.kSt != null) {
                                c.this.kSt.caL();
                            }
                            if (c.this.cUC()) {
                                if (c.this.Zh) {
                                    c.this.cUG();
                                } else {
                                    c.this.cUF();
                                }
                                c.this.tB(c.this.Zh);
                                return;
                            }
                            c.this.Ii();
                            return;
                        } else if (view2.getId() != c.this.jrY.getId()) {
                            if (c.this.kSi != null) {
                                c.this.kSi.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new ao("c11713"));
                            if (c.this.kSt != null) {
                                c.this.kSt.caL();
                            }
                            if (c.this.cUC()) {
                                c.this.cUG();
                                c.this.tB(false);
                                return;
                            }
                            c.this.Ii();
                            return;
                        }
                    }
                    TiebaStatic.log(new ao("c13255"));
                    c.this.cOS();
                    c.this.cUU();
                    if (c.this.currentState != 1) {
                        c.this.cUQ();
                        c.this.cUR();
                    } else {
                        c.this.cyi();
                    }
                    if (c.this.kSr != null) {
                        c.this.kSr.oc(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kRW.stopPlayback();
                c.this.YV = false;
                c.this.cUL();
            }
        };
        this.jsx = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jsy = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jsz = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cyf();
            }
        };
        this.jsA = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.awZ();
                }
            }
        };
        this.juu = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pF(int i22) {
                int duration;
                if (c.this.kRW != null && (duration = c.this.kRW.getDuration()) > 0 && c.this.kRX != null) {
                    c.this.kRX.setProgress((int) ((i22 * c.this.jrJ.getWidth()) / duration));
                    if (c.this.kSm != null) {
                        c.this.kSm.CK((c.this.kRW.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eZq = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new ao("c13256"));
                c.this.cUQ();
                c.this.tF(false);
                if (c.this.kSr != null) {
                    c.this.kSr.oc(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cxW() != null) {
                    c.this.zE(c.this.cxW().getSeekPosition());
                    if (!c.this.cye()) {
                        c.this.cUL();
                    } else {
                        c.this.axa();
                        if (c.this.kwD != null) {
                            c.this.kwD.caN();
                        }
                    }
                }
                c.this.tF(true);
                c.this.cUP();
                if (c.this.kSr != null) {
                    c.this.kSr.oc(true);
                }
                if (c.this.kSs != null) {
                    c.this.kSs.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kSM = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cUX() {
                if (!c.this.kSB) {
                    c.this.eKZ.startLoading();
                    c.this.ajE.setVisibility(0);
                    c.this.kRZ.setVisibility(8);
                    c.this.kSb.setVisibility(8);
                    c.this.kSa.setVisibility(8);
                    c.this.kSc.setVisibility(8);
                    c.this.gTN.setVisibility(8);
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.jsv);
                    if (c.this.kSl > 0) {
                        com.baidu.adp.lib.f.e.lt().postDelayed(c.this.jsv, c.this.kSl);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.dPv = tbPageContext;
            this.mRootView = view;
            this.kSG = z;
            this.jrU = view;
            this.mActivity = this.dPv.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.jrJ = ap(this.mActivity);
        this.jrJ.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.jrJ);
        }
        this.kRW = com.baidu.tieba.play.a.b.A(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.jrJ).addView(this.kRW.getView(), 0);
        this.kRW.getView().setLayoutParams(layoutParams);
        this.eKZ = new w((ViewGroup) this.jrJ.findViewById(R.id.auto_video_loading_container));
        this.eKZ.setLoadingAnimationListener(this.gQZ);
        this.jrL = (VideoListMediaControllerView) this.jrJ.findViewById(R.id.media_controller);
        this.jrL.setPlayer(this.kRW);
        this.kRX = (ProgressBar) this.jrJ.findViewById(R.id.pgrBottomProgress);
        this.kRX.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.kRX.setProgress(0);
        this.jrL.setOnSeekBarChangeListener(this.eZq);
        this.jrL.setOnProgressUpdatedListener(this.juu);
        this.jrM = this.jrJ.findViewById(R.id.black_mask);
        this.gTN = this.jrJ.findViewById(R.id.layout_error);
        this.gTN.setOnClickListener(this.mOnClickListener);
        this.kSA = (TextView) this.jrJ.findViewById(R.id.auto_video_error_tips);
        this.jrN = (FrameLayout) this.jrJ.findViewById(R.id.danmu_container);
        this.jrR = (ImageView) this.jrJ.findViewById(R.id.img_full_screen);
        this.jrR.setOnClickListener(this.mOnClickListener);
        this.jrS = this.jrJ.findViewById(R.id.layout_media_controller);
        this.kRY = this.jrJ.findViewById(R.id.time_show_controller);
        this.kRW.setContinuePlayEnable(true);
        this.kRW.setOnPreparedListener(this.eUJ);
        this.kRW.setOnCompletionListener(this.eUI);
        this.kRW.setOnErrorListener(this.jsu);
        this.kRW.setOnSeekCompleteListener(this.eUM);
        this.kRW.setOnOutInfoListener(this.eUL);
        this.kRW.setOnSurfaceDestroyedListener(this.eLi);
        if (cUA()) {
            ((QuickVideoView) this.kRW).setOnRecoveryCallback(this.kSM);
        }
        this.kRZ = (SwitchImageView) this.jrJ.findViewById(R.id.img_play_controller);
        this.kRZ.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.kRZ.setState(0);
        this.kRZ.setOnClickListener(this.mOnClickListener);
        this.kSa = (TextView) this.jrJ.findViewById(R.id.txt_replay);
        this.kSa.setOnClickListener(this.mOnClickListener);
        this.kSb = (TextView) this.jrJ.findViewById(R.id.txt_playnext);
        this.kSb.setOnClickListener(this.mOnClickListener);
        this.kSc = (TextView) this.jrJ.findViewById(R.id.txt_next_video_title);
        this.ajE = (TbImageView) this.jrJ.findViewById(R.id.video_thumbnail);
        this.ajE.setDefaultErrorResource(0);
        this.ajE.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jrY = (ImageView) this.jrJ.findViewById(R.id.img_exit);
        this.jrY.setOnClickListener(this.mOnClickListener);
        this.jrZ = (TextView) this.jrJ.findViewById(R.id.video_title);
        this.bjD = this.jrJ.findViewById(R.id.layout_title);
        this.bjD.setVisibility(8);
        this.hGb = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.btW = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jsj = this.mAudioManager.getStreamMaxVolume(3);
        this.jsp = this.mAudioManager.getStreamVolume(3);
        jsq = 100 / this.jsj;
        this.jrJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.kSp != null) {
                    c.this.kSp.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.YV) {
                        if (c.this.mStatus == 1 && c.this.jsl != 0) {
                            c.this.b(c.this.jsl == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jsl = 0;
                            c.this.jsk = 0;
                        }
                        if (!c.this.kRW.isPlaying()) {
                            c.this.kSb.setVisibility(8);
                            c.this.kSa.setVisibility(8);
                            c.this.kSc.setVisibility(8);
                        }
                    }
                    c.this.cxS();
                    if (c.this.kSp != null) {
                        c.this.kSp.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jsn = new com.baidu.tieba.play.o(this.mActivity);
        if (this.kSG) {
            this.jsn.start();
        }
        this.jso = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jsr == null) {
            jsr = new CallStateReceiver();
        }
        jsr.register(this.mActivity);
        cUB();
        MessageManager.getInstance().registerListener(this.jsA);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jsA);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void CG(int i2) {
        if (this.ajE != null) {
            this.ajE.setDefaultBgResource(i2);
        }
    }

    public boolean cUA() {
        return this.mVideoType == 0 && (this.kRW instanceof QuickVideoView);
    }

    public void cUB() {
        if (this.kSw) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.jrJ.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.jrJ.setSystemUiVisibility(0);
    }

    public void tz(boolean z) {
        this.kSw = z;
        cUB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxS() {
        this.mStatus = 0;
        if (this.jsd != null && this.jsd.getParent() != null && (this.jsd.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jsd.getParent()).removeView(this.jsd);
                this.jsd = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jse != null && this.jse.getParent() != null && (this.jse.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jse.getParent()).removeView(this.jse);
                this.jse = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cxT() {
        if (this.mStatus == 1) {
            if (this.jsd == null && this.jrJ != null && (this.jrJ instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.jrJ, true);
                this.jsd = this.jrJ.findViewById(R.id.lay_jindu);
                this.jsf = (TextView) this.jsd.findViewById(R.id.show_time);
                this.jsi = (ImageView) this.jsd.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jse == null && this.jrJ != null && (this.jrJ instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.jrJ, true);
            this.jse = this.jrJ.findViewById(R.id.lay_voice);
            this.jsh = (ImageView) this.jse.findViewById(R.id.arrow_voice_icon);
            this.jsg = (SeekBar) this.jse.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.kSi = onClickListener;
    }

    public void tA(boolean z) {
        this.kSh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.kSp != null) {
                c.this.kSp.onStart();
            }
            if (c.this.Zh && c.this.YV) {
                if (c.this.mStatus == 1) {
                    c.this.cUS();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ao(f2);
                    }
                } else {
                    if (c.this.Zh) {
                        c.this.cxV();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.jsk = c.this.kRW.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ao(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.kSH) {
                if (c.this.kSq != null && c.this.kSq.cPb()) {
                    return true;
                }
                c.this.cOS();
                c.this.cUU();
                if (c.this.kRW.isPlaying()) {
                    c.this.cUP();
                } else {
                    c.this.cUQ();
                }
                if (c.this.kSr != null) {
                    c.this.kSr.oc(c.this.kRW.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.kSH) {
                if (c.this.YV) {
                    if (c.this.kSq != null && c.this.kSq.cPc()) {
                        return true;
                    }
                    c.this.cUO();
                    if (c.this.kRW.isPlaying()) {
                        c.this.cUP();
                    } else {
                        c.this.cUQ();
                    }
                    if (c.this.kSr != null) {
                        c.this.kSr.oc(c.this.kRW.isPlaying());
                    }
                } else {
                    c.this.cOS();
                    c.this.cUU();
                    if (c.this.currentState != 1) {
                        c.this.cUQ();
                        c.this.cUR();
                    } else {
                        c.this.cyi();
                    }
                    if (c.this.kSr != null) {
                        c.this.kSr.oc(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxV() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jrJ.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jrJ.setSystemUiVisibility(4);
        } else {
            this.jrJ.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(float f2) {
        if (!this.YV) {
            this.mStatus = 0;
            return;
        }
        cxT();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % jsq == 0) {
            if (f2 > 0.0f && this.jsp < this.jsj) {
                this.jsp++;
            }
            if (f2 < 0.0f && this.jsp > 0) {
                this.jsp--;
            }
        }
        if (this.mProgress > 0) {
            this.jsh.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jsh.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jsp, 0);
        this.jsg.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jsk -= 1000;
                this.jsl = 1;
            } else {
                this.jsk += 1000;
                this.jsl = 2;
            }
            if (this.jsk < 0) {
                this.jsk = 0;
            } else if (this.jsk > this.kRW.getDuration()) {
                this.jsk = this.kRW.getDuration();
            }
        }
        cxT();
        String CQ = this.jrL.CQ(this.jsk);
        if (f2 > 0.0f) {
            this.jsi.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jsi.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(CQ)) {
            this.jsf.setText(new StringBuilder().append(CQ).append("/").append(this.jrL.CQ(this.kRW.getDuration())));
        }
        this.jrL.setCurrentDuration(this.jsk, z ? false : true);
        cUS();
        cUH();
    }

    protected View ap(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void CH(int i2) {
        this.kSd = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ajO = str2;
    }

    public void setFid(String str) {
        this.eEs = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOi() {
        if (this.kRW != null && this.jrL != null) {
            this.jrL.showProgress();
            this.mStartPosition = x.cVW().Lc(this.mVideoUrl);
            if (this.kSE) {
                this.kRW.setVolume(1.0f, 1.0f);
                this.kRW.start();
                this.kSE = false;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.Zb);
                com.baidu.adp.lib.f.e.lt().postDelayed(this.Zb, 20L);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsv);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kSL);
                if (this.kRW.cVs()) {
                    this.currentState = 1;
                    if (cUA()) {
                        ((QuickVideoView) this.kRW).setRecoveryState(1);
                    }
                    cUS();
                }
                this.mStartPosition = x.cVW().Lc(this.mVideoUrl);
                this.jrL.setPlayer(this.kRW);
                if (this.mStartPosition != 0) {
                    this.kSy = true;
                }
                if (!this.kSD) {
                    this.jrL.showProgress();
                }
                if (!this.kSh && this.kRW.getDuration() <= 0) {
                    cxW().setVisibility(4);
                }
            }
            this.YW = (this.mStartPosition <= 100 || this.kRW.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu() {
        if (this.ajE.getVisibility() != 8 || !this.YV) {
            this.YV = true;
            this.jrM.setVisibility(8);
            this.gTN.setVisibility(8);
            this.eKZ.cVS();
            this.ajE.setVisibility(8);
            cUT();
            long duration = this.kRW.getDuration() / 1000;
            String str = this.ajO;
            this.jrL.showProgress();
            this.kRX.setVisibility(0);
            if (this.jrW != null && cUA()) {
                this.jrW.onPrepared(((QuickVideoView) this.kRW).getPlayer());
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
    }

    private static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    protected void tB(boolean z) {
        if (hasNavBar(this.mActivity) && (this.kRY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kRY.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.kRY.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.kRY.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.kRY.setLayoutParams(layoutParams);
        }
    }

    public void cOS() {
        if (this.kRW.isPlaying()) {
            awZ();
            if (this.kSv != null) {
                this.kSv.onPause();
            }
            if (this.kSm != null) {
                this.kSm.onPaused();
            }
        } else if (this.YV) {
            axa();
            if (this.kwD != null) {
                this.kwD.caN();
            }
            if (this.kSm != null) {
                this.kSm.cUZ();
            }
        } else {
            cUL();
        }
    }

    public void Ii() {
        this.jss = true;
        if (this.jsn != null) {
            this.jsn.Ii();
        }
    }

    public boolean cUC() {
        return this.kRW != null && this.kRW.getView().getHeight() > this.kRW.getView().getWidth();
    }

    public void cUD() {
        tB(false);
        cUG();
    }

    public boolean CI(int i2) {
        switch (i2) {
            case 4:
                if (this.Zh) {
                    if (cUC()) {
                        tB(false);
                        cUG();
                    } else {
                        Ii();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.jsj <= 0 || this.jsg == null) {
                    return false;
                }
                this.jsp = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jsp * 100.0d) / this.jsj);
                this.jsg.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cUA()) {
            return (QuickVideoView) this.kRW;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cUE() {
        return this.kRW;
    }

    public VideoListMediaControllerView cxW() {
        return this.jrL;
    }

    public void show() {
        this.jrJ.setVisibility(0);
    }

    public void cya() {
        if (this.jrU != null) {
            ViewGroup.LayoutParams layoutParams = this.jrU.getLayoutParams();
            this.jrO = (FrameLayout.LayoutParams) this.jrJ.getLayoutParams();
            this.jrO.width = layoutParams.width;
            this.jrO.height = layoutParams.height;
            this.jrO.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.jrJ.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.jrJ.setLayoutParams(this.jrO);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jss) {
            if (this.Zh) {
                TiebaStatic.log(new ao("c11712"));
            } else {
                TiebaStatic.log(new ao("c11711"));
            }
        } else {
            this.jss = false;
        }
        if (configuration.orientation == 2) {
            cUF();
        } else {
            cUG();
        }
        cUH();
        if (this.mActivity == com.baidu.adp.base.a.jC().currentActivity()) {
            axa();
        }
        cUU();
        cyi();
        if (this.kSr != null) {
            this.kSr.oc(true);
        }
    }

    protected void cUF() {
        this.Zh = true;
        if (cUC()) {
            this.jrJ.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.jrJ.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        i(this.mActivity, true);
        this.bjD.setVisibility(0);
        this.jrY.setVisibility(0);
        this.jrZ.setVisibility(0);
        this.jrN.setVisibility(8);
        this.eKZ.cVT();
        this.ajE.setVisibility(8);
        this.jrR.setImageResource(R.drawable.icon_video_narrow_white);
        zB(this.jso);
        cxV();
        if (this.kSj != null) {
            this.kSj.qd();
        }
    }

    protected void cUG() {
        this.Zh = false;
        if (this.jrO != null) {
            this.jrJ.setLayoutParams(this.jrO);
        }
        i(this.mActivity, false);
        this.bjD.setVisibility(8);
        this.jrN.setVisibility(0);
        this.eKZ.cVT();
        this.ajE.setVisibility(8);
        this.jrR.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.jrL != null && (this.jrL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jrL.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.jrL.setLayoutParams(layoutParams);
        }
        this.jrJ.setSystemUiVisibility(0);
        cUB();
        if (this.kSj != null) {
            this.kSj.qe();
        }
    }

    public void cUH() {
        if (this.kRW != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.Zh) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.kRX.setMax(equipmentWidth);
            int duration = this.kRW.getDuration();
            if (duration > 0) {
                if (this.kSa.getVisibility() == 0) {
                    this.kRX.setProgress(this.kRX.getMax());
                } else {
                    this.kRX.setProgress((int) ((this.kRW.getCurrentPositionSync() * this.kRX.getMax()) / duration));
                }
            }
        }
    }

    private void zB(int i2) {
        if (this.jrL != null && (this.jrL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jrL.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.jrL.setLayoutParams(layoutParams);
        }
    }

    private void i(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                activity.getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            activity.getWindow().clearFlags(512);
        }
    }

    public boolean cyc() {
        return !this.Zh;
    }

    public void a(g.f fVar) {
        this.jrW = fVar;
    }

    public void a(g.a aVar) {
        this.kSe = aVar;
    }

    public void a(g.b bVar) {
        this.kSf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.kSz) {
            fe(str, str2);
        } else {
            fd(str, str2);
        }
        if (eVar != null) {
            eVar.tJ(z);
        }
    }

    public void fc(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, String str2, boolean z) {
        cUM();
        this.kSE = true;
        this.currentState = 0;
        if (cUA()) {
            ((QuickVideoView) this.kRW).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.kRW.setVideoDuration(this.kSd);
        this.kRW.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsv);
        if (this.kSl > 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.jsv, this.kSl);
        }
        if (this.kSm != null) {
            this.kSm.onStarted();
        }
        this.eKZ.startLoading();
        tC(z);
    }

    public void fd(String str, String str2) {
        B(str, str2, true);
    }

    public void fe(String str, String str2) {
        cUM();
        this.kSE = true;
        this.currentState = 0;
        if (cUA()) {
            ((QuickVideoView) this.kRW).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsv);
        if (this.kSl > 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.jsv, this.kSl);
        }
        if (this.kSm != null) {
            this.kSm.onStarted();
        }
        this.eKZ.startLoading();
        tC(true);
    }

    public void cUI() {
        axa();
        this.kRX.setVisibility(0);
    }

    public void axa() {
        if (this.kRW != null && this.jrL != null) {
            this.YV = true;
            this.currentState = 1;
            if (cUA()) {
                ((QuickVideoView) this.kRW).setRecoveryState(1);
            }
            this.kRW.a(null);
            this.mStartPosition = x.cVW().Lc(this.mVideoUrl);
            this.kSy = true;
            this.YW = (this.mStartPosition <= 100 || this.kRW.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.eKZ.cVT();
            tC(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.kSC && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ajO)) {
            this.kSC = false;
            this.kSD = true;
            fd(this.mVideoUrl, this.ajO);
        }
    }

    private void tC(boolean z) {
        if (z) {
            this.ajE.setVisibility(0);
            cUS();
            this.kRX.setProgress(0);
        } else {
            this.ajE.setVisibility(8);
            cUS();
        }
        this.jrL.showProgress();
        this.jrM.setVisibility(8);
        this.kSb.setVisibility(8);
        this.kSa.setVisibility(8);
        this.kSc.setVisibility(8);
        this.gTN.setVisibility(8);
    }

    private void cUJ() {
        this.eKZ.cVT();
        this.kSb.setVisibility(8);
        this.kSa.setVisibility(8);
        this.kSc.setVisibility(8);
        cUU();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.kRW instanceof QuickVideoView) {
            ((QuickVideoView) this.kRW).setNeedRecovery(z);
        }
    }

    public void awZ() {
        this.kRW.pause();
        this.currentState = 2;
        if (cUA()) {
            ((QuickVideoView) this.kRW).setRecoveryState(2);
        }
        cUJ();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cUA()) {
            ((QuickVideoView) this.kRW).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.Zb);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsv);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kSL);
        this.kRW.stopPlayback();
        this.YV = false;
        this.kSE = false;
        this.mStartPosition = 0;
        clb();
    }

    public void cUK() {
        if (this.kRW.getDuration() >= this.kRW.getCurrentPosition()) {
            x.cVW().bv(this.mVideoUrl, this.kRW.getCurrentPosition());
        }
    }

    public void tD(boolean z) {
        this.kSx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE(boolean z) {
        if (this.jrS != null) {
            this.jrM.setVisibility(0);
            this.kSb.setVisibility(8);
            this.kSa.setVisibility(8);
            this.kSc.setVisibility(8);
            this.eKZ.cVT();
            cUS();
            this.kRX.setVisibility(8);
            this.gTN.setVisibility(8);
            this.jrL.axj();
            this.ajE.setVisibility(z ? 0 : 8);
        }
    }

    public void clb() {
        tE(true);
    }

    public boolean qf() {
        if (this.kRW == null) {
            return false;
        }
        return this.kRW.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.kRW == null) {
            return 0;
        }
        return this.kRW.getCurrentPosition();
    }

    public void a(k kVar) {
        this.kSp = kVar;
    }

    public void a(j jVar) {
        this.kSo = jVar;
    }

    public void a(i iVar) {
        this.kwD = iVar;
    }

    public void a(g gVar) {
        this.kSv = gVar;
    }

    public void a(h hVar) {
        this.kSn = hVar;
    }

    public void Kw(String str) {
        this.kwd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUL() {
        a(this.mVideoUrl, this.ajO, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.kSk = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cUM();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.h.dmo().dmp()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.kSz = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.kSu != null) {
                    this.kSu.nw(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.we(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cUN();
                        aVar2.dismiss();
                        c.this.a(eVar, false, str, str2);
                    }
                });
                aVar.b(R.string.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.dPv).aUN();
                return;
            } else if (this.kSu != null) {
                this.kSu.nw(true);
                return;
            } else {
                if (!this.kRV) {
                    this.kRV = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.kSt != null) {
            this.kSt.caK();
        }
    }

    private void cUM() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.h.dmo().fs(this.mActivity);
        }
    }

    public void cUN() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.ajE.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsz);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.Zb);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsv);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kSK);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kSL);
        this.jsn.stop();
        jsr.unregister(this.mActivity);
    }

    public void KW(String str) {
        this.jrZ.setText(str);
    }

    public boolean cye() {
        return this.YV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUO() {
        if (this.jrS != null) {
            if (this.kSg) {
                cUS();
            } else {
                cUR();
            }
        }
    }

    public void cyi() {
        cUR();
        cUP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUP() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsz);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.jsz, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUQ() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsz);
    }

    public void cUR() {
        if (this.jrS != null && !this.kSg && !this.kSI) {
            tF(true);
            cyh();
            this.jrS.setVisibility(0);
            this.kRY.setVisibility(0);
            this.kRX.setVisibility(8);
            this.kSg = true;
            if (this.kSk != null) {
                this.kSk.nx(false);
            }
        }
    }

    public void cyf() {
        if (this.jrS != null && this.kSg) {
            tF(false);
            cyh();
            this.jrS.setVisibility(8);
            this.kRY.setVisibility(8);
            this.kRX.setVisibility(0);
            this.hGb.setAnimationListener(this.jsx);
            this.jrS.startAnimation(this.hGb);
            this.kSg = false;
            if (this.kSk != null) {
                this.kSk.caM();
            }
        }
    }

    public void cUS() {
        if (this.jrS != null && this.kSg) {
            this.btW.cancel();
            this.hGb.cancel();
            tF(false);
            cyh();
            this.jrS.setVisibility(8);
            this.kRY.setVisibility(8);
            this.kRX.setVisibility(0);
            this.kSg = false;
            if (this.kSk != null) {
                this.kSk.caM();
            }
        }
    }

    private void cyh() {
        if (this.jrS != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jsz);
            this.btW.setAnimationListener(null);
            this.hGb.setAnimationListener(null);
            this.jrS.clearAnimation();
        }
    }

    private void cUT() {
        if (this.jrS != null) {
            this.btW.setAnimationListener(null);
            this.hGb.setAnimationListener(null);
            this.jrS.clearAnimation();
        }
    }

    public void tF(boolean z) {
        cUU();
        if (z) {
            this.kRZ.setVisibility(0);
        } else {
            this.kRZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUU() {
        if (this.currentState == 1) {
            this.kRZ.setState(1);
        } else {
            this.kRZ.setState(0);
        }
    }

    public void a(InterfaceC0720c interfaceC0720c) {
        this.kSj = interfaceC0720c;
    }

    public void zE(int i2) {
        this.mStartPosition = i2;
    }

    public void ao(boolean z, boolean z2) {
        if (this.jsn != null) {
            if (this.jrR != null) {
                this.jrR.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.jrL != null && (this.jrL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jrL.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.jrL.setLayoutParams(layoutParams);
            }
            this.jsn.ch(z);
        }
    }

    public int getScreenHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            if (context.getResources() != null && context.getResources().getConfiguration() != null && context.getResources().getConfiguration().orientation == 2) {
                i2 = displayMetrics.widthPixels;
            } else {
                i2 = displayMetrics.heightPixels;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 == 0) {
            return com.baidu.adp.lib.util.l.getEquipmentHeight(context);
        }
        return i2;
    }

    public static int getVirtualBarHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        return i2;
    }

    public int getCurrentState() {
        return this.currentState;
    }

    public void tG(boolean z) {
        this.kSH = z;
    }

    public void a(m mVar) {
        this.kSq = mVar;
    }

    public void a(a aVar) {
        this.kSr = aVar;
    }

    public void a(n nVar) {
        this.kSs = nVar;
    }

    public void a(l lVar) {
        this.kSt = lVar;
    }

    public void a(f fVar) {
        this.kSu = fVar;
    }

    public void tH(boolean z) {
        this.kSB = z;
    }

    public void tI(boolean z) {
        this.kSh = z;
    }

    public void CJ(int i2) {
        this.kSF = i2;
    }

    public View cUV() {
        return this.jrJ;
    }

    public void a(p pVar) {
        this.kwr = pVar;
    }

    public void cUW() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dPv.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.dPv.getPageActivity());
    }
}
