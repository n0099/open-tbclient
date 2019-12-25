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
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
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
    private static int hUe;
    private static CallStateReceiver hUf;
    private boolean Ej;
    private int Ek;
    private Runnable Ep;
    protected boolean Ev;
    private String OC;
    private TbImageView Os;
    private Animation aGz;
    private View axY;
    private TbPageContext<?> cQU;
    private int currentState;
    private w dHM;
    private QuickVideoView.b dHV;
    private g.a dQN;
    private g.f dQO;
    private g.e dQQ;
    private g.InterfaceC0577g dQR;
    private SeekBar.OnSeekBarChangeListener dVL;
    private com.baidu.tieba.play.o dZX;
    private VideoLoadingProgressView.a fDS;
    private String fGQ;
    protected View fGw;
    private Animation goT;
    private VideoListMediaControllerView hTA;
    private View hTB;
    private FrameLayout hTC;
    protected FrameLayout.LayoutParams hTD;
    private ImageView hTG;
    private View hTH;
    private View hTJ;
    private g.f hTL;
    private ImageView hTN;
    private TextView hTO;
    private View hTS;
    private View hTT;
    private TextView hTU;
    private SeekBar hTV;
    private ImageView hTW;
    private ImageView hTX;
    private int hTY;
    private int hTZ;
    public View hTy;
    private int hUa;
    private int hUc;
    private int hUd;
    private boolean hUg;
    private g.b hUi;
    protected Runnable hUj;
    private Animation.AnimationListener hUl;
    private Animation.AnimationListener hUm;
    private Runnable hUn;
    private CustomMessageListener hUo;
    private VideoControllerView.b hWi;
    private String iSB;
    private p iSP;
    private i iTb;
    private int joY;
    private boolean joZ;
    private boolean jpA;
    private boolean jpB;
    private boolean jpC;
    private TextView jpD;
    private boolean jpE;
    private boolean jpF;
    private boolean jpG;
    private boolean jpH;
    private int jpI;
    private boolean jpJ;
    private boolean jpK;
    private boolean jpL;
    private boolean jpM;
    private Runnable jpN;
    private Runnable jpO;
    private QuickVideoView.a jpP;
    protected com.baidu.tieba.play.a.a jpa;
    private ProgressBar jpb;
    private View jpc;
    private SwitchImageView jpd;
    private TextView jpe;
    private TextView jpf;
    private TextView jpg;
    private g.a jph;
    private g.b jpi;
    private boolean jpj;
    private boolean jpk;
    private View.OnClickListener jpl;
    protected InterfaceC0576c jpm;
    private d jpn;
    private long jpo;
    private o jpp;
    private h jpq;
    private j jpr;
    private k jps;
    private m jpt;
    private a jpu;
    private n jpv;
    private l jpw;
    private f jpx;
    private g jpy;
    private boolean jpz;
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
    private String mVideoUrl;

    /* loaded from: classes.dex */
    public interface a {
        void lY(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0576c {
        void kM();

        void kN();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bDJ();

        void lu(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void rx(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void lt(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void cpT();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bDK();
    }

    /* loaded from: classes.dex */
    public interface j {
        void qB(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bDH();

        void bDI();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cpU();

        boolean cpV();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Aa(int i);

        void cvQ();

        void cvR();

        void onPaused();

        void onPrepared();

        void onStarted();

        void su();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cpS();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.joY = 0;
        this.Ek = 100;
        this.joZ = false;
        this.Ev = false;
        this.Ej = false;
        this.jpj = false;
        this.jpk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hTZ = 0;
        this.hUa = 0;
        this.jpo = 60000L;
        this.hUc = 0;
        this.hUg = false;
        this.jpz = true;
        this.jpA = true;
        this.jpB = false;
        this.jpC = false;
        this.iSB = null;
        this.currentState = -1;
        this.jpE = false;
        this.jpJ = true;
        this.jpL = false;
        this.jpM = false;
        this.dQO = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hTA != null && c.this.jpa != null && c.this.jpa.getDuration() > 0) {
                    c.this.hTA.aV(0, c.this.jpa.getDuration());
                }
                c.this.bsf();
                if (c.this.jpp != null) {
                    c.this.jpp.onPrepared();
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.ld();
                    return false;
                }
                return false;
            }
        };
        this.fDS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bsf();
            }
        };
        this.Ep = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.Ep);
                if (c.this.Os.getVisibility() != 8) {
                    if (c.this.jpa.getCurrentPosition() > c.this.Ek) {
                        c.this.ld();
                    } else {
                        com.baidu.adp.lib.f.e.gy().postDelayed(c.this.Ep, 20L);
                    }
                }
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jpa != null) {
                    int duration = c.this.jpa.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Ej = false;
                        c.this.jpH = false;
                        c.this.mStartPosition = 0;
                        c.this.bZM();
                        c.this.hTB.setVisibility(0);
                        c.this.jpb.setProgress(c.this.jpb.getMax());
                        c.this.Ek = 100;
                        if (c.this.jph != null) {
                            c.this.jph.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cvs()) {
                            ((QuickVideoView) c.this.jpa).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rs(false);
                            c.this.rt(true);
                        } else {
                            c.this.cvK();
                            c.this.jpe.setVisibility(0);
                        }
                        if (!c.this.Ev && duration <= 150000) {
                            if (!c.this.jpE) {
                                if (c.this.jpr != null) {
                                    c.this.jpr.qB(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.OC, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cvs()) {
                                    ((QuickVideoView) c.this.jpa).setRecoveryState(5);
                                }
                                c.this.jpa.pause();
                                c.this.jpa.seekTo(0);
                            }
                        }
                        if (c.this.jpp != null) {
                            c.this.jpp.Aa(c.this.jpb.getMax());
                            c.this.jpp.su();
                        }
                    }
                }
            }
        };
        this.hUi = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.fGw.setVisibility(0);
                c.this.dHM.cwK();
                c.this.currentState = 4;
                if (c.this.cvs()) {
                    ((QuickVideoView) c.this.jpa).setRecoveryState(4);
                }
                if (c.this.jpi != null) {
                    c.this.jpi.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jpF = true;
                }
                if (c.this.jpp != null) {
                    c.this.jpp.cvQ();
                }
                c.this.jpH = false;
                return true;
            }
        };
        this.hUj = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jpa == null || !c.this.jpa.isPlaying()) {
                    c.this.fGw.setVisibility(0);
                    c.this.dHM.cwK();
                    if (c.this.jpp != null) {
                        c.this.jpp.cvQ();
                    }
                }
            }
        };
        this.dQR = new g.InterfaceC0577g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jpB) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.jpN, 200L);
                }
            }
        };
        this.jpN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jpa == null || !c.this.jpB) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.Ep, 200L);
                    c.this.jpB = false;
                } else if (c.this.mStartPosition != c.this.jpa.getCurrentPosition()) {
                    c.this.jpB = false;
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.Ep, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.jpN, 200L);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Ej = false;
                if (c.this.jpk) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.jpO, 300L);
                }
                com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.Ep);
                com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.hUj);
            }
        };
        this.jpO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jpH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iSP != null) {
                    c.this.iSP.cpS();
                }
                if (view2.getId() != c.this.fGw.getId()) {
                    if (view2.getId() != c.this.jpd.getId()) {
                        if (view2.getId() == c.this.jpf.getId()) {
                            if (c.this.jpq != null) {
                                c.this.jpq.cpT();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jpe.getId()) {
                            if (c.this.jpr != null) {
                                c.this.jpr.qB(false);
                            }
                            c.this.dX(c.this.mVideoUrl, c.this.OC);
                            return;
                        } else if (view2.getId() == c.this.hTG.getId()) {
                            int i2 = c.this.jpk ? 1 : 2;
                            if (c.this.Ev) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OC).cp("fid", c.this.fGQ).Z("obj_type", i2).Z("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OC).cp("fid", c.this.fGQ).Z("obj_type", i2).Z("obj_source", 1));
                            }
                            if (c.this.jpw != null) {
                                c.this.jpw.bDI();
                            }
                            if (c.this.cvu()) {
                                if (c.this.Ev) {
                                    c.this.cvy();
                                } else {
                                    c.this.cvx();
                                }
                                c.this.rp(c.this.Ev);
                                return;
                            }
                            c.this.xr();
                            return;
                        } else if (view2.getId() != c.this.hTN.getId()) {
                            if (c.this.jpl != null) {
                                c.this.jpl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jpw != null) {
                                c.this.jpw.bDI();
                            }
                            if (c.this.cvu()) {
                                c.this.cvy();
                                c.this.rp(false);
                                return;
                            }
                            c.this.xr();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cpL();
                    c.this.cvM();
                    if (c.this.currentState != 1) {
                        c.this.cvI();
                        c.this.cvJ();
                    } else {
                        c.this.cac();
                    }
                    if (c.this.jpu != null) {
                        c.this.jpu.lY(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jpa.stopPlayback();
                c.this.Ej = false;
                c.this.cvD();
            }
        };
        this.hUl = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hUm = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hUn = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bZZ();
            }
        };
        this.hUo = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hWi = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i2) {
                int duration;
                if (c.this.jpa != null && (duration = c.this.jpa.getDuration()) > 0 && c.this.jpb != null) {
                    c.this.jpb.setProgress((int) ((i2 * c.this.hTy.getWidth()) / duration));
                    if (c.this.jpp != null) {
                        c.this.jpp.Aa((c.this.jpa.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dVL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cvI();
                c.this.rt(false);
                if (c.this.jpu != null) {
                    c.this.jpu.lY(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bZQ() != null) {
                    c.this.xp(c.this.bZQ().getSeekPosition());
                    if (!c.this.bZY()) {
                        c.this.cvD();
                    } else {
                        c.this.ahr();
                        if (c.this.iTb != null) {
                            c.this.iTb.bDK();
                        }
                    }
                }
                c.this.rt(true);
                c.this.cvH();
                if (c.this.jpu != null) {
                    c.this.jpu.lY(true);
                }
                if (c.this.jpv != null) {
                    c.this.jpv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jpP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cvP() {
                if (!c.this.jpE) {
                    c.this.dHM.startLoading();
                    c.this.Os.setVisibility(0);
                    c.this.jpd.setVisibility(8);
                    c.this.jpf.setVisibility(8);
                    c.this.jpe.setVisibility(8);
                    c.this.jpg.setVisibility(8);
                    c.this.fGw.setVisibility(8);
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.hUj);
                    if (c.this.jpo > 0) {
                        com.baidu.adp.lib.f.e.gy().postDelayed(c.this.hUj, c.this.jpo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cQU = tbPageContext;
            this.mRootView = view;
            this.jpJ = z;
            this.hTJ = view;
            this.mActivity = this.cQU.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.joY = 0;
        this.Ek = 100;
        this.joZ = false;
        this.Ev = false;
        this.Ej = false;
        this.jpj = false;
        this.jpk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.hTZ = 0;
        this.hUa = 0;
        this.jpo = 60000L;
        this.hUc = 0;
        this.hUg = false;
        this.jpz = true;
        this.jpA = true;
        this.jpB = false;
        this.jpC = false;
        this.iSB = null;
        this.currentState = -1;
        this.jpE = false;
        this.jpJ = true;
        this.jpL = false;
        this.jpM = false;
        this.dQO = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.hTA != null && c.this.jpa != null && c.this.jpa.getDuration() > 0) {
                    c.this.hTA.aV(0, c.this.jpa.getDuration());
                }
                c.this.bsf();
                if (c.this.jpp != null) {
                    c.this.jpp.onPrepared();
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.ld();
                    return false;
                }
                return false;
            }
        };
        this.fDS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bsf();
            }
        };
        this.Ep = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.Ep);
                if (c.this.Os.getVisibility() != 8) {
                    if (c.this.jpa.getCurrentPosition() > c.this.Ek) {
                        c.this.ld();
                    } else {
                        com.baidu.adp.lib.f.e.gy().postDelayed(c.this.Ep, 20L);
                    }
                }
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jpa != null) {
                    int duration = c.this.jpa.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Ej = false;
                        c.this.jpH = false;
                        c.this.mStartPosition = 0;
                        c.this.bZM();
                        c.this.hTB.setVisibility(0);
                        c.this.jpb.setProgress(c.this.jpb.getMax());
                        c.this.Ek = 100;
                        if (c.this.jph != null) {
                            c.this.jph.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cvs()) {
                            ((QuickVideoView) c.this.jpa).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rs(false);
                            c.this.rt(true);
                        } else {
                            c.this.cvK();
                            c.this.jpe.setVisibility(0);
                        }
                        if (!c.this.Ev && duration <= 150000) {
                            if (!c.this.jpE) {
                                if (c.this.jpr != null) {
                                    c.this.jpr.qB(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.OC, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cvs()) {
                                    ((QuickVideoView) c.this.jpa).setRecoveryState(5);
                                }
                                c.this.jpa.pause();
                                c.this.jpa.seekTo(0);
                            }
                        }
                        if (c.this.jpp != null) {
                            c.this.jpp.Aa(c.this.jpb.getMax());
                            c.this.jpp.su();
                        }
                    }
                }
            }
        };
        this.hUi = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.fGw.setVisibility(0);
                c.this.dHM.cwK();
                c.this.currentState = 4;
                if (c.this.cvs()) {
                    ((QuickVideoView) c.this.jpa).setRecoveryState(4);
                }
                if (c.this.jpi != null) {
                    c.this.jpi.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jpF = true;
                }
                if (c.this.jpp != null) {
                    c.this.jpp.cvQ();
                }
                c.this.jpH = false;
                return true;
            }
        };
        this.hUj = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jpa == null || !c.this.jpa.isPlaying()) {
                    c.this.fGw.setVisibility(0);
                    c.this.dHM.cwK();
                    if (c.this.jpp != null) {
                        c.this.jpp.cvQ();
                    }
                }
            }
        };
        this.dQR = new g.InterfaceC0577g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0577g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jpB) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.jpN, 200L);
                }
            }
        };
        this.jpN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jpa == null || !c.this.jpB) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.Ep, 200L);
                    c.this.jpB = false;
                } else if (c.this.mStartPosition != c.this.jpa.getCurrentPosition()) {
                    c.this.jpB = false;
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.Ep, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.jpN, 200L);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Ej = false;
                if (c.this.jpk) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(c.this.jpO, 300L);
                }
                com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.Ep);
                com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.hUj);
            }
        };
        this.jpO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jpH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iSP != null) {
                    c.this.iSP.cpS();
                }
                if (view2.getId() != c.this.fGw.getId()) {
                    if (view2.getId() != c.this.jpd.getId()) {
                        if (view2.getId() == c.this.jpf.getId()) {
                            if (c.this.jpq != null) {
                                c.this.jpq.cpT();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jpe.getId()) {
                            if (c.this.jpr != null) {
                                c.this.jpr.qB(false);
                            }
                            c.this.dX(c.this.mVideoUrl, c.this.OC);
                            return;
                        } else if (view2.getId() == c.this.hTG.getId()) {
                            int i22 = c.this.jpk ? 1 : 2;
                            if (c.this.Ev) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OC).cp("fid", c.this.fGQ).Z("obj_type", i22).Z("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cp("tid", c.this.OC).cp("fid", c.this.fGQ).Z("obj_type", i22).Z("obj_source", 1));
                            }
                            if (c.this.jpw != null) {
                                c.this.jpw.bDI();
                            }
                            if (c.this.cvu()) {
                                if (c.this.Ev) {
                                    c.this.cvy();
                                } else {
                                    c.this.cvx();
                                }
                                c.this.rp(c.this.Ev);
                                return;
                            }
                            c.this.xr();
                            return;
                        } else if (view2.getId() != c.this.hTN.getId()) {
                            if (c.this.jpl != null) {
                                c.this.jpl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jpw != null) {
                                c.this.jpw.bDI();
                            }
                            if (c.this.cvu()) {
                                c.this.cvy();
                                c.this.rp(false);
                                return;
                            }
                            c.this.xr();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cpL();
                    c.this.cvM();
                    if (c.this.currentState != 1) {
                        c.this.cvI();
                        c.this.cvJ();
                    } else {
                        c.this.cac();
                    }
                    if (c.this.jpu != null) {
                        c.this.jpu.lY(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jpa.stopPlayback();
                c.this.Ej = false;
                c.this.cvD();
            }
        };
        this.hUl = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.hUm = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.hUn = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.bZZ();
            }
        };
        this.hUo = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.hWi = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void nR(int i22) {
                int duration;
                if (c.this.jpa != null && (duration = c.this.jpa.getDuration()) > 0 && c.this.jpb != null) {
                    c.this.jpb.setProgress((int) ((i22 * c.this.hTy.getWidth()) / duration));
                    if (c.this.jpp != null) {
                        c.this.jpp.Aa((c.this.jpa.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.dVL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cvI();
                c.this.rt(false);
                if (c.this.jpu != null) {
                    c.this.jpu.lY(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.bZQ() != null) {
                    c.this.xp(c.this.bZQ().getSeekPosition());
                    if (!c.this.bZY()) {
                        c.this.cvD();
                    } else {
                        c.this.ahr();
                        if (c.this.iTb != null) {
                            c.this.iTb.bDK();
                        }
                    }
                }
                c.this.rt(true);
                c.this.cvH();
                if (c.this.jpu != null) {
                    c.this.jpu.lY(true);
                }
                if (c.this.jpv != null) {
                    c.this.jpv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jpP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cvP() {
                if (!c.this.jpE) {
                    c.this.dHM.startLoading();
                    c.this.Os.setVisibility(0);
                    c.this.jpd.setVisibility(8);
                    c.this.jpf.setVisibility(8);
                    c.this.jpe.setVisibility(8);
                    c.this.jpg.setVisibility(8);
                    c.this.fGw.setVisibility(8);
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(c.this.hUj);
                    if (c.this.jpo > 0) {
                        com.baidu.adp.lib.f.e.gy().postDelayed(c.this.hUj, c.this.jpo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cQU = tbPageContext;
            this.mRootView = view;
            this.jpJ = z;
            this.hTJ = view;
            this.mActivity = this.cQU.getPageActivity();
            this.joY = i2;
            init();
        }
    }

    public void init() {
        this.hTy = ap(this.mActivity);
        this.hTy.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hTy);
        }
        this.jpa = com.baidu.tieba.play.a.b.E(this.mActivity, this.joY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.hTy).addView(this.jpa.getView(), 0);
        this.jpa.getView().setLayoutParams(layoutParams);
        this.dHM = new w((ViewGroup) this.hTy.findViewById(R.id.auto_video_loading_container));
        this.dHM.setLoadingAnimationListener(this.fDS);
        this.hTA = (VideoListMediaControllerView) this.hTy.findViewById(R.id.media_controller);
        this.hTA.setPlayer(this.jpa);
        this.jpb = (ProgressBar) this.hTy.findViewById(R.id.pgrBottomProgress);
        this.jpb.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.jpb.setProgress(0);
        this.hTA.setOnSeekBarChangeListener(this.dVL);
        this.hTA.setOnProgressUpdatedListener(this.hWi);
        this.hTB = this.hTy.findViewById(R.id.black_mask);
        this.fGw = this.hTy.findViewById(R.id.layout_error);
        this.fGw.setOnClickListener(this.mOnClickListener);
        this.jpD = (TextView) this.hTy.findViewById(R.id.auto_video_error_tips);
        this.hTC = (FrameLayout) this.hTy.findViewById(R.id.danmu_container);
        this.hTG = (ImageView) this.hTy.findViewById(R.id.img_full_screen);
        this.hTG.setOnClickListener(this.mOnClickListener);
        this.hTH = this.hTy.findViewById(R.id.layout_media_controller);
        this.jpc = this.hTy.findViewById(R.id.time_show_controller);
        this.jpa.setContinuePlayEnable(true);
        this.jpa.setOnPreparedListener(this.dQO);
        this.jpa.setOnCompletionListener(this.dQN);
        this.jpa.setOnErrorListener(this.hUi);
        this.jpa.setOnSeekCompleteListener(this.dQR);
        this.jpa.setOnOutInfoListener(this.dQQ);
        this.jpa.setOnSurfaceDestroyedListener(this.dHV);
        if (cvs()) {
            ((QuickVideoView) this.jpa).setOnRecoveryCallback(this.jpP);
        }
        this.jpd = (SwitchImageView) this.hTy.findViewById(R.id.img_play_controller);
        this.jpd.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.jpd.setState(0);
        this.jpd.setOnClickListener(this.mOnClickListener);
        this.jpe = (TextView) this.hTy.findViewById(R.id.txt_replay);
        this.jpe.setOnClickListener(this.mOnClickListener);
        this.jpf = (TextView) this.hTy.findViewById(R.id.txt_playnext);
        this.jpf.setOnClickListener(this.mOnClickListener);
        this.jpg = (TextView) this.hTy.findViewById(R.id.txt_next_video_title);
        this.Os = (TbImageView) this.hTy.findViewById(R.id.video_thumbnail);
        this.Os.setDefaultErrorResource(0);
        this.Os.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hTN = (ImageView) this.hTy.findViewById(R.id.img_exit);
        this.hTN.setOnClickListener(this.mOnClickListener);
        this.hTO = (TextView) this.hTy.findViewById(R.id.video_title);
        this.axY = this.hTy.findViewById(R.id.layout_title);
        this.axY.setVisibility(8);
        this.goT = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aGz = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hTY = this.mAudioManager.getStreamMaxVolume(3);
        this.hUd = this.mAudioManager.getStreamVolume(3);
        hUe = 100 / this.hTY;
        this.hTy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.jps != null) {
                    c.this.jps.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Ej) {
                        if (c.this.mStatus == 1 && c.this.hUa != 0) {
                            c.this.b(c.this.hUa == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hUa = 0;
                            c.this.hTZ = 0;
                        }
                        if (!c.this.jpa.isPlaying()) {
                            c.this.jpf.setVisibility(8);
                            c.this.jpe.setVisibility(8);
                            c.this.jpg.setVisibility(8);
                        }
                    }
                    c.this.bZM();
                    if (c.this.jps != null) {
                        c.this.jps.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.dZX = new com.baidu.tieba.play.o(this.mActivity);
        if (this.jpJ) {
            this.dZX.start();
        }
        this.hUc = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (hUf == null) {
            hUf = new CallStateReceiver();
        }
        hUf.register(this.mActivity);
        cvt();
        MessageManager.getInstance().registerListener(this.hUo);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hUo);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void zX(int i2) {
        if (this.Os != null) {
            this.Os.setDefaultBgResource(i2);
        }
    }

    public boolean cvs() {
        return this.joY == 0 && (this.jpa instanceof QuickVideoView);
    }

    public void cvt() {
        if (this.jpz) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hTy.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hTy.setSystemUiVisibility(0);
    }

    public void rn(boolean z) {
        this.jpz = z;
        cvt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZM() {
        this.mStatus = 0;
        if (this.hTS != null && this.hTS.getParent() != null && (this.hTS.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hTS.getParent()).removeView(this.hTS);
                this.hTS = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hTT != null && this.hTT.getParent() != null && (this.hTT.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hTT.getParent()).removeView(this.hTT);
                this.hTT = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bZN() {
        if (this.mStatus == 1) {
            if (this.hTS == null && this.hTy != null && (this.hTy instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hTy, true);
                this.hTS = this.hTy.findViewById(R.id.lay_jindu);
                this.hTU = (TextView) this.hTS.findViewById(R.id.show_time);
                this.hTX = (ImageView) this.hTS.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hTT == null && this.hTy != null && (this.hTy instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hTy, true);
            this.hTT = this.hTy.findViewById(R.id.lay_voice);
            this.hTW = (ImageView) this.hTT.findViewById(R.id.arrow_voice_icon);
            this.hTV = (SeekBar) this.hTT.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.jpl = onClickListener;
    }

    public void ro(boolean z) {
        this.jpk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.jps != null) {
                c.this.jps.onStart();
            }
            if (c.this.Ev && c.this.Ej) {
                if (c.this.mStatus == 1) {
                    c.this.cvK();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aE(f2);
                    }
                } else {
                    if (c.this.Ev) {
                        c.this.bZP();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hTZ = c.this.jpa.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aE(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.jpK) {
                if (c.this.jpt != null && c.this.jpt.cpU()) {
                    return true;
                }
                c.this.cpL();
                c.this.cvM();
                if (c.this.jpa.isPlaying()) {
                    c.this.cvH();
                } else {
                    c.this.cvI();
                }
                if (c.this.jpu != null) {
                    c.this.jpu.lY(c.this.jpa.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.jpK) {
                if (c.this.Ej) {
                    if (c.this.jpt != null && c.this.jpt.cpV()) {
                        return true;
                    }
                    c.this.cvG();
                    if (c.this.jpa.isPlaying()) {
                        c.this.cvH();
                    } else {
                        c.this.cvI();
                    }
                    if (c.this.jpu != null) {
                        c.this.jpu.lY(c.this.jpa.isPlaying());
                    }
                } else {
                    c.this.cpL();
                    c.this.cvM();
                    if (c.this.currentState != 1) {
                        c.this.cvI();
                        c.this.cvJ();
                    } else {
                        c.this.cac();
                    }
                    if (c.this.jpu != null) {
                        c.this.jpu.lY(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZP() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hTy.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hTy.setSystemUiVisibility(4);
        } else {
            this.hTy.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(float f2) {
        if (!this.Ej) {
            this.mStatus = 0;
            return;
        }
        bZN();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hUe == 0) {
            if (f2 > 0.0f && this.hUd < this.hTY) {
                this.hUd++;
            }
            if (f2 < 0.0f && this.hUd > 0) {
                this.hUd--;
            }
        }
        if (this.mProgress > 0) {
            this.hTW.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hTW.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hUd, 0);
        this.hTV.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hTZ -= 1000;
                this.hUa = 1;
            } else {
                this.hTZ += 1000;
                this.hUa = 2;
            }
            if (this.hTZ < 0) {
                this.hTZ = 0;
            } else if (this.hTZ > this.jpa.getDuration()) {
                this.hTZ = this.jpa.getDuration();
            }
        }
        bZN();
        String Af = this.hTA.Af(this.hTZ);
        if (f2 > 0.0f) {
            this.hTX.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hTX.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Af)) {
            this.hTU.setText(new StringBuilder().append(Af).append("/").append(this.hTA.Af(this.jpa.getDuration())));
        }
        this.hTA.setCurrentDuration(this.hTZ, z ? false : true);
        cvK();
        cvz();
    }

    protected View ap(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.OC = str2;
    }

    public void setFid(String str) {
        this.fGQ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsf() {
        if (this.jpa != null && this.hTA != null) {
            this.hTA.showProgress();
            this.mStartPosition = x.cwN().GF(this.mVideoUrl);
            if (this.jpH) {
                this.jpa.setVolume(1.0f, 1.0f);
                this.jpa.start();
                this.jpH = false;
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.Ep);
                com.baidu.adp.lib.f.e.gy().postDelayed(this.Ep, 20L);
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUj);
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jpO);
                if (this.jpa.cwj()) {
                    this.currentState = 1;
                    if (cvs()) {
                        ((QuickVideoView) this.jpa).setRecoveryState(1);
                    }
                    cvK();
                }
                this.mStartPosition = x.cwN().GF(this.mVideoUrl);
                this.hTA.setPlayer(this.jpa);
                if (this.mStartPosition != 0) {
                    this.jpB = true;
                }
                if (!this.jpG) {
                    this.hTA.showProgress();
                }
                if (!this.jpk && this.jpa.getDuration() <= 0) {
                    bZQ().setVisibility(4);
                }
            }
            this.Ek = (this.mStartPosition <= 100 || this.jpa.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        if (this.Os.getVisibility() != 8 || !this.Ej) {
            this.Ej = true;
            this.hTB.setVisibility(8);
            this.fGw.setVisibility(8);
            this.dHM.cwJ();
            this.Os.setVisibility(8);
            cvL();
            long duration = this.jpa.getDuration() / 1000;
            String str = this.OC;
            this.hTA.showProgress();
            this.jpb.setVisibility(0);
            if (this.hTL != null && cvs()) {
                this.hTL.onPrepared(((QuickVideoView) this.jpa).getPlayer());
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", PraiseDataPassUtil.KEY_FROM_OS);
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

    protected void rp(boolean z) {
        if (hasNavBar(this.mActivity) && (this.jpc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jpc.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.jpc.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.jpc.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.jpc.setLayoutParams(layoutParams);
        }
    }

    public void cpL() {
        if (this.jpa.isPlaying()) {
            pausePlay();
            if (this.jpy != null) {
                this.jpy.onPause();
            }
            if (this.jpp != null) {
                this.jpp.onPaused();
            }
        } else if (this.Ej) {
            ahr();
            if (this.iTb != null) {
                this.iTb.bDK();
            }
            if (this.jpp != null) {
                this.jpp.cvR();
            }
        } else {
            cvD();
        }
    }

    public void xr() {
        this.hUg = true;
        if (this.dZX != null) {
            this.dZX.xr();
        }
    }

    public boolean cvu() {
        return this.jpa != null && this.jpa.getView().getHeight() > this.jpa.getView().getWidth();
    }

    public void cvv() {
        rp(false);
        cvy();
    }

    public boolean zY(int i2) {
        switch (i2) {
            case 4:
                if (this.Ev) {
                    if (cvu()) {
                        rp(false);
                        cvy();
                    } else {
                        xr();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hTY <= 0 || this.hTV == null) {
                    return false;
                }
                this.hUd = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hUd * 100.0d) / this.hTY);
                this.hTV.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cvs()) {
            return (QuickVideoView) this.jpa;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cvw() {
        return this.jpa;
    }

    public VideoListMediaControllerView bZQ() {
        return this.hTA;
    }

    public void show() {
        this.hTy.setVisibility(0);
    }

    public void bZU() {
        if (this.hTJ != null) {
            ViewGroup.LayoutParams layoutParams = this.hTJ.getLayoutParams();
            this.hTD = (FrameLayout.LayoutParams) this.hTy.getLayoutParams();
            this.hTD.width = layoutParams.width;
            this.hTD.height = layoutParams.height;
            this.hTD.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.hTy.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.hTy.setLayoutParams(this.hTD);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hUg) {
            if (this.Ev) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hUg = false;
        }
        if (configuration.orientation == 2) {
            cvx();
        } else {
            cvy();
        }
        cvz();
        ahr();
        cvM();
        cac();
        if (this.jpu != null) {
            this.jpu.lY(true);
        }
    }

    protected void cvx() {
        this.Ev = true;
        if (cvu()) {
            this.hTy.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hTy.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.axY.setVisibility(0);
        this.hTN.setVisibility(0);
        this.hTO.setVisibility(0);
        this.hTC.setVisibility(8);
        this.dHM.cwK();
        this.Os.setVisibility(8);
        this.hTG.setImageResource(R.drawable.icon_video_narrow_white);
        xm(this.hUc);
        bZP();
        if (this.jpm != null) {
            this.jpm.kM();
        }
    }

    protected void cvy() {
        this.Ev = false;
        if (this.hTD != null) {
            this.hTy.setLayoutParams(this.hTD);
        }
        g(this.mActivity, false);
        this.axY.setVisibility(8);
        this.hTC.setVisibility(0);
        this.dHM.cwK();
        this.Os.setVisibility(8);
        this.hTG.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hTA != null && (this.hTA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTA.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hTA.setLayoutParams(layoutParams);
        }
        this.hTy.setSystemUiVisibility(0);
        cvt();
        if (this.jpm != null) {
            this.jpm.kN();
        }
    }

    public void cvz() {
        if (this.jpa != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.Ev) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.jpb.setMax(equipmentWidth);
            int duration = this.jpa.getDuration();
            if (duration > 0) {
                if (this.jpe.getVisibility() == 0) {
                    this.jpb.setProgress(this.jpb.getMax());
                } else {
                    this.jpb.setProgress((int) ((this.jpa.getCurrentPositionSync() * this.jpb.getMax()) / duration));
                }
            }
        }
    }

    private void xm(int i2) {
        if (this.hTA != null && (this.hTA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTA.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hTA.setLayoutParams(layoutParams);
        }
    }

    private void g(Activity activity, boolean z) {
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

    public boolean bZW() {
        return !this.Ev;
    }

    public void a(g.f fVar) {
        this.hTL = fVar;
    }

    public void a(g.a aVar) {
        this.jph = aVar;
    }

    public void a(g.b bVar) {
        this.jpi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.jpC) {
            dY(str, str2);
        } else {
            dX(str, str2);
        }
        if (eVar != null) {
            eVar.rx(z);
        }
    }

    public void dW(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2, boolean z) {
        cvE();
        this.jpH = true;
        this.currentState = 0;
        if (cvs()) {
            ((QuickVideoView) this.jpa).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.jpa.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUj);
        if (this.jpo > 0) {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.hUj, this.jpo);
        }
        if (this.jpp != null) {
            this.jpp.onStarted();
        }
        this.dHM.startLoading();
        rq(z);
    }

    public void dX(String str, String str2) {
        y(str, str2, true);
    }

    public void dY(String str, String str2) {
        cvE();
        this.jpH = true;
        this.currentState = 0;
        if (cvs()) {
            ((QuickVideoView) this.jpa).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUj);
        if (this.jpo > 0) {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.hUj, this.jpo);
        }
        if (this.jpp != null) {
            this.jpp.onStarted();
        }
        this.dHM.startLoading();
        rq(true);
    }

    public void cvA() {
        ahr();
        this.jpb.setVisibility(0);
    }

    public void ahr() {
        if (this.jpa != null && this.hTA != null) {
            this.Ej = true;
            this.currentState = 1;
            if (cvs()) {
                ((QuickVideoView) this.jpa).setRecoveryState(1);
            }
            this.jpa.a(null);
            this.mStartPosition = x.cwN().GF(this.mVideoUrl);
            this.jpB = true;
            this.Ek = (this.mStartPosition <= 100 || this.jpa.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.dHM.cwK();
            rq(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.jpF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.OC)) {
            this.jpF = false;
            this.jpG = true;
            dX(this.mVideoUrl, this.OC);
        }
    }

    private void rq(boolean z) {
        if (z) {
            this.Os.setVisibility(0);
            cvK();
            this.jpb.setProgress(0);
        } else {
            this.Os.setVisibility(8);
            cvK();
        }
        this.hTA.showProgress();
        this.hTB.setVisibility(8);
        this.jpf.setVisibility(8);
        this.jpe.setVisibility(8);
        this.jpg.setVisibility(8);
        this.fGw.setVisibility(8);
    }

    private void cvB() {
        this.dHM.cwK();
        this.jpf.setVisibility(8);
        this.jpe.setVisibility(8);
        this.jpg.setVisibility(8);
        cvM();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.jpa instanceof QuickVideoView) {
            ((QuickVideoView) this.jpa).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.jpa.pause();
        this.currentState = 2;
        if (cvs()) {
            ((QuickVideoView) this.jpa).setRecoveryState(2);
        }
        cvB();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cvs()) {
            ((QuickVideoView) this.jpa).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.Ep);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUj);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jpO);
        this.jpa.stopPlayback();
        this.Ej = false;
        this.jpH = false;
        this.mStartPosition = 0;
        bNb();
    }

    public void cvC() {
        if (this.jpa.getDuration() >= this.jpa.getCurrentPosition()) {
            x.cwN().bm(this.mVideoUrl, this.jpa.getCurrentPosition());
        }
    }

    public void rr(boolean z) {
        this.jpA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(boolean z) {
        if (this.hTH != null) {
            this.hTB.setVisibility(0);
            this.jpf.setVisibility(8);
            this.jpe.setVisibility(8);
            this.jpg.setVisibility(8);
            this.dHM.cwK();
            cvK();
            this.jpb.setVisibility(8);
            this.fGw.setVisibility(8);
            this.hTA.ahA();
            this.Os.setVisibility(z ? 0 : 8);
        }
    }

    public void bNb() {
        rs(true);
    }

    public boolean kO() {
        if (this.jpa == null) {
            return false;
        }
        return this.jpa.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.jpa == null) {
            return 0;
        }
        return this.jpa.getCurrentPosition();
    }

    public void a(k kVar) {
        this.jps = kVar;
    }

    public void a(j jVar) {
        this.jpr = jVar;
    }

    public void a(i iVar) {
        this.iTb = iVar;
    }

    public void a(g gVar) {
        this.jpy = gVar;
    }

    public void a(h hVar) {
        this.jpq = hVar;
    }

    public void FX(String str) {
        this.iSB = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvD() {
        a(this.mVideoUrl, this.OC, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.jpn = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cvE();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cMD().cME()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.jpC = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.jpx != null) {
                    this.jpx.lt(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.sz(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cvF();
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
                aVar.b(this.cQU).aBW();
                return;
            } else if (this.jpx != null) {
                this.jpx.lt(true);
                return;
            } else {
                if (!this.joZ) {
                    this.joZ = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.jpw != null) {
            this.jpw.bDH();
        }
    }

    private void cvE() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cMD().fx(this.mActivity);
        }
    }

    public void cvF() {
        com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.Os.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUn);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.Ep);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUj);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jpN);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jpO);
        this.dZX.stop();
        hUf.unregister(this.mActivity);
    }

    public void Gz(String str) {
        this.hTO.setText(str);
    }

    public boolean bZY() {
        return this.Ej;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvG() {
        if (this.hTH != null) {
            if (this.jpj) {
                cvK();
            } else {
                cvJ();
            }
        }
    }

    public void cac() {
        cvJ();
        cvH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvH() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUn);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.hUn, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvI() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUn);
    }

    public void cvJ() {
        if (this.hTH != null && !this.jpj && !this.jpL) {
            rt(true);
            cab();
            this.hTH.setVisibility(0);
            this.jpc.setVisibility(0);
            this.jpb.setVisibility(8);
            this.jpj = true;
            if (this.jpn != null) {
                this.jpn.lu(false);
            }
        }
    }

    public void bZZ() {
        if (this.hTH != null && this.jpj) {
            rt(false);
            cab();
            this.hTH.setVisibility(8);
            this.jpc.setVisibility(8);
            this.jpb.setVisibility(0);
            this.goT.setAnimationListener(this.hUl);
            this.hTH.startAnimation(this.goT);
            this.jpj = false;
            if (this.jpn != null) {
                this.jpn.bDJ();
            }
        }
    }

    public void cvK() {
        if (this.hTH != null && this.jpj) {
            this.aGz.cancel();
            this.goT.cancel();
            rt(false);
            cab();
            this.hTH.setVisibility(8);
            this.jpc.setVisibility(8);
            this.jpb.setVisibility(0);
            this.jpj = false;
            if (this.jpn != null) {
                this.jpn.bDJ();
            }
        }
    }

    private void cab() {
        if (this.hTH != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hUn);
            this.aGz.setAnimationListener(null);
            this.goT.setAnimationListener(null);
            this.hTH.clearAnimation();
        }
    }

    private void cvL() {
        if (this.hTH != null) {
            this.aGz.setAnimationListener(null);
            this.goT.setAnimationListener(null);
            this.hTH.clearAnimation();
        }
    }

    public void rt(boolean z) {
        cvM();
        if (z) {
            this.jpd.setVisibility(0);
        } else {
            this.jpd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvM() {
        if (this.currentState == 1) {
            this.jpd.setState(1);
        } else {
            this.jpd.setState(0);
        }
    }

    public void a(InterfaceC0576c interfaceC0576c) {
        this.jpm = interfaceC0576c;
    }

    public void xp(int i2) {
        this.mStartPosition = i2;
    }

    public void ah(boolean z, boolean z2) {
        if (this.dZX != null) {
            if (this.hTG != null) {
                this.hTG.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hTA != null && (this.hTA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTA.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.hTA.setLayoutParams(layoutParams);
            }
            this.dZX.bb(z);
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

    public void ru(boolean z) {
        this.jpK = z;
    }

    public void a(m mVar) {
        this.jpt = mVar;
    }

    public void a(a aVar) {
        this.jpu = aVar;
    }

    public void a(n nVar) {
        this.jpv = nVar;
    }

    public void a(l lVar) {
        this.jpw = lVar;
    }

    public void a(f fVar) {
        this.jpx = fVar;
    }

    public void rv(boolean z) {
        this.jpE = z;
    }

    public void rw(boolean z) {
        this.jpk = z;
        if (z) {
            this.jpa.setPageTypeForPerfStat("middle");
        } else {
            this.jpa.setPageTypeForPerfStat("pb");
        }
    }

    public void zZ(int i2) {
        this.jpI = i2;
    }

    public View cvN() {
        return this.hTy;
    }

    public void a(p pVar) {
        this.iSP = pVar;
    }

    public void cvO() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cQU.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.cQU.getPageActivity());
    }
}
