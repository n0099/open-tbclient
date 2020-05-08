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
    private static int iLs;
    private static CallStateReceiver iLt;
    private boolean Yb;
    private int Yc;
    private Runnable Yh;
    protected boolean Yn;
    private View aWZ;
    private TbImageView ahE;
    private String ahO;
    private Animation bhy;
    private int currentState;
    private TbPageContext<?> duK;
    private SeekBar.OnSeekBarChangeListener eAu;
    private com.baidu.tieba.play.o eEJ;
    private String eQk;
    private w emA;
    private QuickVideoView.b emJ;
    private g.a evJ;
    private g.f evK;
    private g.e evM;
    private g.InterfaceC0651g evN;
    private VideoLoadingProgressView.a gpi;
    protected View grN;
    private Animation hem;
    public View iKM;
    private VideoListMediaControllerView iKO;
    private View iKP;
    private FrameLayout iKQ;
    protected FrameLayout.LayoutParams iKR;
    private ImageView iKU;
    private View iKV;
    private View iKX;
    private g.f iKZ;
    private Animation.AnimationListener iLA;
    private Runnable iLB;
    private CustomMessageListener iLC;
    private ImageView iLb;
    private TextView iLc;
    private View iLg;
    private View iLh;
    private TextView iLi;
    private SeekBar iLj;
    private ImageView iLk;
    private ImageView iLl;
    private int iLm;
    private int iLn;
    private int iLo;
    private int iLq;
    private int iLr;
    private boolean iLu;
    private g.b iLw;
    protected Runnable iLx;
    private Animation.AnimationListener iLz;
    private VideoControllerView.b iNx;
    private p jJN;
    private i jJZ;
    private String jJz;
    private l kfA;
    private f kfB;
    private g kfC;
    private boolean kfD;
    private boolean kfE;
    private boolean kfF;
    private boolean kfG;
    private TextView kfH;
    private boolean kfI;
    private boolean kfJ;
    private boolean kfK;
    private boolean kfL;
    private int kfM;
    private boolean kfN;
    private boolean kfO;
    private boolean kfP;
    private boolean kfQ;
    private Runnable kfR;
    private Runnable kfS;
    private QuickVideoView.a kfT;
    private boolean kfc;
    protected com.baidu.tieba.play.a.a kfd;
    private ProgressBar kfe;
    private View kff;
    private SwitchImageView kfg;
    private TextView kfh;
    private TextView kfi;
    private TextView kfj;
    private int kfk;
    private g.a kfl;
    private g.b kfm;
    private boolean kfn;
    private boolean kfo;
    private View.OnClickListener kfp;
    protected InterfaceC0650c kfq;
    private d kfr;
    private long kfs;
    private o kft;
    private h kfu;
    private j kfv;
    private k kfw;
    private m kfx;
    private a kfy;
    private n kfz;
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
        void nv(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0650c {
        void pG();

        void pH();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bRb();

        void mR(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void sX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void mQ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void cDt();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bRc();
    }

    /* loaded from: classes.dex */
    public interface j {
        void rZ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bQZ();

        void bRa();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cDu();

        boolean cDv();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void AW(int i);

        void cJq();

        void cJr();

        void onPaused();

        void onPrepared();

        void onStarted();

        void yu();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cDs();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.Yc = 100;
        this.kfc = false;
        this.Yn = false;
        this.Yb = false;
        this.kfn = false;
        this.kfo = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.iLn = 0;
        this.iLo = 0;
        this.kfs = 60000L;
        this.iLq = 0;
        this.iLu = false;
        this.kfD = true;
        this.kfE = true;
        this.kfF = false;
        this.kfG = false;
        this.jJz = null;
        this.currentState = -1;
        this.kfI = false;
        this.kfN = true;
        this.kfP = false;
        this.kfQ = false;
        this.evK = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iKO != null && c.this.kfd != null && c.this.kfd.getDuration() > 0) {
                    c.this.iKO.be(0, c.this.kfd.getDuration());
                }
                c.this.bED();
                if (c.this.kft != null) {
                    c.this.kft.onPrepared();
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.pX();
                    return false;
                }
                return false;
            }
        };
        this.gpi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bED();
            }
        };
        this.Yh = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Yh);
                if (c.this.ahE.getVisibility() != 8) {
                    if (c.this.kfd.getCurrentPosition() > c.this.Yc) {
                        c.this.pX();
                    } else {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Yh, 20L);
                    }
                }
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kfd != null) {
                    int duration = c.this.kfd.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Yb = false;
                        c.this.kfL = false;
                        c.this.mStartPosition = 0;
                        c.this.cnq();
                        c.this.iKP.setVisibility(0);
                        c.this.kfe.setProgress(c.this.kfe.getMax());
                        c.this.Yc = 100;
                        if (c.this.kfl != null) {
                            c.this.kfl.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cIS()) {
                            ((QuickVideoView) c.this.kfd).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.sS(false);
                            c.this.sT(true);
                        } else {
                            c.this.cJk();
                            c.this.kfh.setVisibility(0);
                        }
                        if (!c.this.Yn && duration <= 150000) {
                            if (!c.this.kfI) {
                                if (c.this.kfv != null) {
                                    c.this.kfv.rZ(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.ahO, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cIS()) {
                                    ((QuickVideoView) c.this.kfd).setRecoveryState(5);
                                }
                                c.this.kfd.pause();
                                c.this.kfd.seekTo(0);
                            }
                        }
                        if (c.this.kft != null) {
                            c.this.kft.AW(c.this.kfe.getMax());
                            c.this.kft.yu();
                        }
                    }
                }
            }
        };
        this.iLw = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.grN.setVisibility(0);
                c.this.emA.cKl();
                c.this.currentState = 4;
                if (c.this.cIS()) {
                    ((QuickVideoView) c.this.kfd).setRecoveryState(4);
                }
                if (c.this.kfm != null) {
                    c.this.kfm.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kfJ = true;
                }
                if (c.this.kft != null) {
                    c.this.kft.cJq();
                }
                c.this.kfL = false;
                return true;
            }
        };
        this.iLx = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kfd == null || !c.this.kfd.isPlaying()) {
                    c.this.grN.setVisibility(0);
                    c.this.emA.cKl();
                    if (c.this.kft != null) {
                        c.this.kft.cJq();
                    }
                }
            }
        };
        this.evN = new g.InterfaceC0651g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kfF) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfR, 200L);
                }
            }
        };
        this.kfR = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kfd == null || !c.this.kfF) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Yh, 200L);
                    c.this.kfF = false;
                } else if (c.this.mStartPosition != c.this.kfd.getCurrentPosition()) {
                    c.this.kfF = false;
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Yh, 20L);
                } else {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfR, 200L);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Yb = false;
                if (c.this.kfo) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfS, 300L);
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Yh);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLx);
            }
        };
        this.kfS = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kfL = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.jJN != null) {
                    c.this.jJN.cDs();
                }
                if (view2.getId() != c.this.grN.getId()) {
                    if (view2.getId() != c.this.kfg.getId()) {
                        if (view2.getId() == c.this.kfi.getId()) {
                            if (c.this.kfu != null) {
                                c.this.kfu.cDt();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kfh.getId()) {
                            if (c.this.kfv != null) {
                                c.this.kfv.rZ(false);
                            }
                            c.this.ev(c.this.mVideoUrl, c.this.ahO);
                            return;
                        } else if (view2.getId() == c.this.iKU.getId()) {
                            int i2 = c.this.kfo ? 1 : 2;
                            if (c.this.Yn) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahO).cI("fid", c.this.eQk).af("obj_type", i2).af("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahO).cI("fid", c.this.eQk).af("obj_type", i2).af("obj_source", 1));
                            }
                            if (c.this.kfA != null) {
                                c.this.kfA.bRa();
                            }
                            if (c.this.cIU()) {
                                if (c.this.Yn) {
                                    c.this.cIY();
                                } else {
                                    c.this.cIX();
                                }
                                c.this.sP(c.this.Yn);
                                return;
                            }
                            c.this.Fe();
                            return;
                        } else if (view2.getId() != c.this.iLb.getId()) {
                            if (c.this.kfp != null) {
                                c.this.kfp.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kfA != null) {
                                c.this.kfA.bRa();
                            }
                            if (c.this.cIU()) {
                                c.this.cIY();
                                c.this.sP(false);
                                return;
                            }
                            c.this.Fe();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cDl();
                    c.this.cJm();
                    if (c.this.currentState != 1) {
                        c.this.cJi();
                        c.this.cJj();
                    } else {
                        c.this.cnG();
                    }
                    if (c.this.kfy != null) {
                        c.this.kfy.nv(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kfd.stopPlayback();
                c.this.Yb = false;
                c.this.cJd();
            }
        };
        this.iLz = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.iLA = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.iLB = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cnD();
            }
        };
        this.iLC = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.asl();
                }
            }
        };
        this.iNx = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i2) {
                int duration;
                if (c.this.kfd != null && (duration = c.this.kfd.getDuration()) > 0 && c.this.kfe != null) {
                    c.this.kfe.setProgress((int) ((i2 * c.this.iKM.getWidth()) / duration));
                    if (c.this.kft != null) {
                        c.this.kft.AW((c.this.kfd.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eAu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cJi();
                c.this.sT(false);
                if (c.this.kfy != null) {
                    c.this.kfy.nv(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cnu() != null) {
                    c.this.yi(c.this.cnu().getSeekPosition());
                    if (!c.this.cnC()) {
                        c.this.cJd();
                    } else {
                        c.this.asn();
                        if (c.this.jJZ != null) {
                            c.this.jJZ.bRc();
                        }
                    }
                }
                c.this.sT(true);
                c.this.cJh();
                if (c.this.kfy != null) {
                    c.this.kfy.nv(true);
                }
                if (c.this.kfz != null) {
                    c.this.kfz.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kfT = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJp() {
                if (!c.this.kfI) {
                    c.this.emA.startLoading();
                    c.this.ahE.setVisibility(0);
                    c.this.kfg.setVisibility(8);
                    c.this.kfi.setVisibility(8);
                    c.this.kfh.setVisibility(8);
                    c.this.kfj.setVisibility(8);
                    c.this.grN.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLx);
                    if (c.this.kfs > 0) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.iLx, c.this.kfs);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.duK = tbPageContext;
            this.mRootView = view;
            this.kfN = z;
            this.iKX = view;
            this.mActivity = this.duK.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.Yc = 100;
        this.kfc = false;
        this.Yn = false;
        this.Yb = false;
        this.kfn = false;
        this.kfo = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.iLn = 0;
        this.iLo = 0;
        this.kfs = 60000L;
        this.iLq = 0;
        this.iLu = false;
        this.kfD = true;
        this.kfE = true;
        this.kfF = false;
        this.kfG = false;
        this.jJz = null;
        this.currentState = -1;
        this.kfI = false;
        this.kfN = true;
        this.kfP = false;
        this.kfQ = false;
        this.evK = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iKO != null && c.this.kfd != null && c.this.kfd.getDuration() > 0) {
                    c.this.iKO.be(0, c.this.kfd.getDuration());
                }
                c.this.bED();
                if (c.this.kft != null) {
                    c.this.kft.onPrepared();
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.pX();
                    return false;
                }
                return false;
            }
        };
        this.gpi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bED();
            }
        };
        this.Yh = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Yh);
                if (c.this.ahE.getVisibility() != 8) {
                    if (c.this.kfd.getCurrentPosition() > c.this.Yc) {
                        c.this.pX();
                    } else {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Yh, 20L);
                    }
                }
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kfd != null) {
                    int duration = c.this.kfd.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Yb = false;
                        c.this.kfL = false;
                        c.this.mStartPosition = 0;
                        c.this.cnq();
                        c.this.iKP.setVisibility(0);
                        c.this.kfe.setProgress(c.this.kfe.getMax());
                        c.this.Yc = 100;
                        if (c.this.kfl != null) {
                            c.this.kfl.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cIS()) {
                            ((QuickVideoView) c.this.kfd).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.sS(false);
                            c.this.sT(true);
                        } else {
                            c.this.cJk();
                            c.this.kfh.setVisibility(0);
                        }
                        if (!c.this.Yn && duration <= 150000) {
                            if (!c.this.kfI) {
                                if (c.this.kfv != null) {
                                    c.this.kfv.rZ(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.ahO, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cIS()) {
                                    ((QuickVideoView) c.this.kfd).setRecoveryState(5);
                                }
                                c.this.kfd.pause();
                                c.this.kfd.seekTo(0);
                            }
                        }
                        if (c.this.kft != null) {
                            c.this.kft.AW(c.this.kfe.getMax());
                            c.this.kft.yu();
                        }
                    }
                }
            }
        };
        this.iLw = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.grN.setVisibility(0);
                c.this.emA.cKl();
                c.this.currentState = 4;
                if (c.this.cIS()) {
                    ((QuickVideoView) c.this.kfd).setRecoveryState(4);
                }
                if (c.this.kfm != null) {
                    c.this.kfm.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kfJ = true;
                }
                if (c.this.kft != null) {
                    c.this.kft.cJq();
                }
                c.this.kfL = false;
                return true;
            }
        };
        this.iLx = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kfd == null || !c.this.kfd.isPlaying()) {
                    c.this.grN.setVisibility(0);
                    c.this.emA.cKl();
                    if (c.this.kft != null) {
                        c.this.kft.cJq();
                    }
                }
            }
        };
        this.evN = new g.InterfaceC0651g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0651g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kfF) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfR, 200L);
                }
            }
        };
        this.kfR = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kfd == null || !c.this.kfF) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Yh, 200L);
                    c.this.kfF = false;
                } else if (c.this.mStartPosition != c.this.kfd.getCurrentPosition()) {
                    c.this.kfF = false;
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Yh, 20L);
                } else {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfR, 200L);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Yb = false;
                if (c.this.kfo) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfS, 300L);
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Yh);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLx);
            }
        };
        this.kfS = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kfL = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.jJN != null) {
                    c.this.jJN.cDs();
                }
                if (view2.getId() != c.this.grN.getId()) {
                    if (view2.getId() != c.this.kfg.getId()) {
                        if (view2.getId() == c.this.kfi.getId()) {
                            if (c.this.kfu != null) {
                                c.this.kfu.cDt();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kfh.getId()) {
                            if (c.this.kfv != null) {
                                c.this.kfv.rZ(false);
                            }
                            c.this.ev(c.this.mVideoUrl, c.this.ahO);
                            return;
                        } else if (view2.getId() == c.this.iKU.getId()) {
                            int i22 = c.this.kfo ? 1 : 2;
                            if (c.this.Yn) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahO).cI("fid", c.this.eQk).af("obj_type", i22).af("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahO).cI("fid", c.this.eQk).af("obj_type", i22).af("obj_source", 1));
                            }
                            if (c.this.kfA != null) {
                                c.this.kfA.bRa();
                            }
                            if (c.this.cIU()) {
                                if (c.this.Yn) {
                                    c.this.cIY();
                                } else {
                                    c.this.cIX();
                                }
                                c.this.sP(c.this.Yn);
                                return;
                            }
                            c.this.Fe();
                            return;
                        } else if (view2.getId() != c.this.iLb.getId()) {
                            if (c.this.kfp != null) {
                                c.this.kfp.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kfA != null) {
                                c.this.kfA.bRa();
                            }
                            if (c.this.cIU()) {
                                c.this.cIY();
                                c.this.sP(false);
                                return;
                            }
                            c.this.Fe();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cDl();
                    c.this.cJm();
                    if (c.this.currentState != 1) {
                        c.this.cJi();
                        c.this.cJj();
                    } else {
                        c.this.cnG();
                    }
                    if (c.this.kfy != null) {
                        c.this.kfy.nv(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kfd.stopPlayback();
                c.this.Yb = false;
                c.this.cJd();
            }
        };
        this.iLz = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.iLA = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.iLB = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cnD();
            }
        };
        this.iLC = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.asl();
                }
            }
        };
        this.iNx = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i22) {
                int duration;
                if (c.this.kfd != null && (duration = c.this.kfd.getDuration()) > 0 && c.this.kfe != null) {
                    c.this.kfe.setProgress((int) ((i22 * c.this.iKM.getWidth()) / duration));
                    if (c.this.kft != null) {
                        c.this.kft.AW((c.this.kfd.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eAu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cJi();
                c.this.sT(false);
                if (c.this.kfy != null) {
                    c.this.kfy.nv(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cnu() != null) {
                    c.this.yi(c.this.cnu().getSeekPosition());
                    if (!c.this.cnC()) {
                        c.this.cJd();
                    } else {
                        c.this.asn();
                        if (c.this.jJZ != null) {
                            c.this.jJZ.bRc();
                        }
                    }
                }
                c.this.sT(true);
                c.this.cJh();
                if (c.this.kfy != null) {
                    c.this.kfy.nv(true);
                }
                if (c.this.kfz != null) {
                    c.this.kfz.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kfT = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJp() {
                if (!c.this.kfI) {
                    c.this.emA.startLoading();
                    c.this.ahE.setVisibility(0);
                    c.this.kfg.setVisibility(8);
                    c.this.kfi.setVisibility(8);
                    c.this.kfh.setVisibility(8);
                    c.this.kfj.setVisibility(8);
                    c.this.grN.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLx);
                    if (c.this.kfs > 0) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.iLx, c.this.kfs);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.duK = tbPageContext;
            this.mRootView = view;
            this.kfN = z;
            this.iKX = view;
            this.mActivity = this.duK.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.iKM = ap(this.mActivity);
        this.iKM.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.iKM);
        }
        this.kfd = com.baidu.tieba.play.a.b.A(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.iKM).addView(this.kfd.getView(), 0);
        this.kfd.getView().setLayoutParams(layoutParams);
        this.emA = new w((ViewGroup) this.iKM.findViewById(R.id.auto_video_loading_container));
        this.emA.setLoadingAnimationListener(this.gpi);
        this.iKO = (VideoListMediaControllerView) this.iKM.findViewById(R.id.media_controller);
        this.iKO.setPlayer(this.kfd);
        this.kfe = (ProgressBar) this.iKM.findViewById(R.id.pgrBottomProgress);
        this.kfe.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.kfe.setProgress(0);
        this.iKO.setOnSeekBarChangeListener(this.eAu);
        this.iKO.setOnProgressUpdatedListener(this.iNx);
        this.iKP = this.iKM.findViewById(R.id.black_mask);
        this.grN = this.iKM.findViewById(R.id.layout_error);
        this.grN.setOnClickListener(this.mOnClickListener);
        this.kfH = (TextView) this.iKM.findViewById(R.id.auto_video_error_tips);
        this.iKQ = (FrameLayout) this.iKM.findViewById(R.id.danmu_container);
        this.iKU = (ImageView) this.iKM.findViewById(R.id.img_full_screen);
        this.iKU.setOnClickListener(this.mOnClickListener);
        this.iKV = this.iKM.findViewById(R.id.layout_media_controller);
        this.kff = this.iKM.findViewById(R.id.time_show_controller);
        this.kfd.setContinuePlayEnable(true);
        this.kfd.setOnPreparedListener(this.evK);
        this.kfd.setOnCompletionListener(this.evJ);
        this.kfd.setOnErrorListener(this.iLw);
        this.kfd.setOnSeekCompleteListener(this.evN);
        this.kfd.setOnOutInfoListener(this.evM);
        this.kfd.setOnSurfaceDestroyedListener(this.emJ);
        if (cIS()) {
            ((QuickVideoView) this.kfd).setOnRecoveryCallback(this.kfT);
        }
        this.kfg = (SwitchImageView) this.iKM.findViewById(R.id.img_play_controller);
        this.kfg.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.kfg.setState(0);
        this.kfg.setOnClickListener(this.mOnClickListener);
        this.kfh = (TextView) this.iKM.findViewById(R.id.txt_replay);
        this.kfh.setOnClickListener(this.mOnClickListener);
        this.kfi = (TextView) this.iKM.findViewById(R.id.txt_playnext);
        this.kfi.setOnClickListener(this.mOnClickListener);
        this.kfj = (TextView) this.iKM.findViewById(R.id.txt_next_video_title);
        this.ahE = (TbImageView) this.iKM.findViewById(R.id.video_thumbnail);
        this.ahE.setDefaultErrorResource(0);
        this.ahE.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.iLb = (ImageView) this.iKM.findViewById(R.id.img_exit);
        this.iLb.setOnClickListener(this.mOnClickListener);
        this.iLc = (TextView) this.iKM.findViewById(R.id.video_title);
        this.aWZ = this.iKM.findViewById(R.id.layout_title);
        this.aWZ.setVisibility(8);
        this.hem = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bhy = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.iLm = this.mAudioManager.getStreamMaxVolume(3);
        this.iLr = this.mAudioManager.getStreamVolume(3);
        iLs = 100 / this.iLm;
        this.iKM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.kfw != null) {
                    c.this.kfw.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Yb) {
                        if (c.this.mStatus == 1 && c.this.iLo != 0) {
                            c.this.b(c.this.iLo == 1 ? 1000.0f : -1000.0f, false);
                            c.this.iLo = 0;
                            c.this.iLn = 0;
                        }
                        if (!c.this.kfd.isPlaying()) {
                            c.this.kfi.setVisibility(8);
                            c.this.kfh.setVisibility(8);
                            c.this.kfj.setVisibility(8);
                        }
                    }
                    c.this.cnq();
                    if (c.this.kfw != null) {
                        c.this.kfw.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.eEJ = new com.baidu.tieba.play.o(this.mActivity);
        if (this.kfN) {
            this.eEJ.start();
        }
        this.iLq = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (iLt == null) {
            iLt = new CallStateReceiver();
        }
        iLt.register(this.mActivity);
        cIT();
        MessageManager.getInstance().registerListener(this.iLC);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.iLC);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void AS(int i2) {
        if (this.ahE != null) {
            this.ahE.setDefaultBgResource(i2);
        }
    }

    public boolean cIS() {
        return this.mVideoType == 0 && (this.kfd instanceof QuickVideoView);
    }

    public void cIT() {
        if (this.kfD) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.iKM.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.iKM.setSystemUiVisibility(0);
    }

    public void sN(boolean z) {
        this.kfD = z;
        cIT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnq() {
        this.mStatus = 0;
        if (this.iLg != null && this.iLg.getParent() != null && (this.iLg.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.iLg.getParent()).removeView(this.iLg);
                this.iLg = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.iLh != null && this.iLh.getParent() != null && (this.iLh.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.iLh.getParent()).removeView(this.iLh);
                this.iLh = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cnr() {
        if (this.mStatus == 1) {
            if (this.iLg == null && this.iKM != null && (this.iKM instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.iKM, true);
                this.iLg = this.iKM.findViewById(R.id.lay_jindu);
                this.iLi = (TextView) this.iLg.findViewById(R.id.show_time);
                this.iLl = (ImageView) this.iLg.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.iLh == null && this.iKM != null && (this.iKM instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.iKM, true);
            this.iLh = this.iKM.findViewById(R.id.lay_voice);
            this.iLk = (ImageView) this.iLh.findViewById(R.id.arrow_voice_icon);
            this.iLj = (SeekBar) this.iLh.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.kfp = onClickListener;
    }

    public void sO(boolean z) {
        this.kfo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.kfw != null) {
                c.this.kfw.onStart();
            }
            if (c.this.Yn && c.this.Yb) {
                if (c.this.mStatus == 1) {
                    c.this.cJk();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.am(f2);
                    }
                } else {
                    if (c.this.Yn) {
                        c.this.cnt();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.iLn = c.this.kfd.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.am(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.kfO) {
                if (c.this.kfx != null && c.this.kfx.cDu()) {
                    return true;
                }
                c.this.cDl();
                c.this.cJm();
                if (c.this.kfd.isPlaying()) {
                    c.this.cJh();
                } else {
                    c.this.cJi();
                }
                if (c.this.kfy != null) {
                    c.this.kfy.nv(c.this.kfd.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.kfO) {
                if (c.this.Yb) {
                    if (c.this.kfx != null && c.this.kfx.cDv()) {
                        return true;
                    }
                    c.this.cJg();
                    if (c.this.kfd.isPlaying()) {
                        c.this.cJh();
                    } else {
                        c.this.cJi();
                    }
                    if (c.this.kfy != null) {
                        c.this.kfy.nv(c.this.kfd.isPlaying());
                    }
                } else {
                    c.this.cDl();
                    c.this.cJm();
                    if (c.this.currentState != 1) {
                        c.this.cJi();
                        c.this.cJj();
                    } else {
                        c.this.cnG();
                    }
                    if (c.this.kfy != null) {
                        c.this.kfy.nv(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnt() {
        if (Build.VERSION.SDK_INT < 16) {
            this.iKM.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.iKM.setSystemUiVisibility(4);
        } else {
            this.iKM.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(float f2) {
        if (!this.Yb) {
            this.mStatus = 0;
            return;
        }
        cnr();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % iLs == 0) {
            if (f2 > 0.0f && this.iLr < this.iLm) {
                this.iLr++;
            }
            if (f2 < 0.0f && this.iLr > 0) {
                this.iLr--;
            }
        }
        if (this.mProgress > 0) {
            this.iLk.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.iLk.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.iLr, 0);
        this.iLj.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.iLn -= 1000;
                this.iLo = 1;
            } else {
                this.iLn += 1000;
                this.iLo = 2;
            }
            if (this.iLn < 0) {
                this.iLn = 0;
            } else if (this.iLn > this.kfd.getDuration()) {
                this.iLn = this.kfd.getDuration();
            }
        }
        cnr();
        String Bc = this.iKO.Bc(this.iLn);
        if (f2 > 0.0f) {
            this.iLl.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.iLl.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Bc)) {
            this.iLi.setText(new StringBuilder().append(Bc).append("/").append(this.iKO.Bc(this.kfd.getDuration())));
        }
        this.iKO.setCurrentDuration(this.iLn, z ? false : true);
        cJk();
        cIZ();
    }

    protected View ap(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void AT(int i2) {
        this.kfk = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ahO = str2;
    }

    public void setFid(String str) {
        this.eQk = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bED() {
        if (this.kfd != null && this.iKO != null) {
            this.iKO.showProgress();
            this.mStartPosition = x.cKo().IO(this.mVideoUrl);
            if (this.kfL) {
                this.kfd.setVolume(1.0f, 1.0f);
                this.kfd.start();
                this.kfL = false;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Yh);
                com.baidu.adp.lib.f.e.lb().postDelayed(this.Yh, 20L);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfS);
                if (this.kfd.cJK()) {
                    this.currentState = 1;
                    if (cIS()) {
                        ((QuickVideoView) this.kfd).setRecoveryState(1);
                    }
                    cJk();
                }
                this.mStartPosition = x.cKo().IO(this.mVideoUrl);
                this.iKO.setPlayer(this.kfd);
                if (this.mStartPosition != 0) {
                    this.kfF = true;
                }
                if (!this.kfK) {
                    this.iKO.showProgress();
                }
                if (!this.kfo && this.kfd.getDuration() <= 0) {
                    cnu().setVisibility(4);
                }
            }
            this.Yc = (this.mStartPosition <= 100 || this.kfd.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX() {
        if (this.ahE.getVisibility() != 8 || !this.Yb) {
            this.Yb = true;
            this.iKP.setVisibility(8);
            this.grN.setVisibility(8);
            this.emA.cKk();
            this.ahE.setVisibility(8);
            cJl();
            long duration = this.kfd.getDuration() / 1000;
            String str = this.ahO;
            this.iKO.showProgress();
            this.kfe.setVisibility(0);
            if (this.iKZ != null && cIS()) {
                this.iKZ.onPrepared(((QuickVideoView) this.kfd).getPlayer());
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

    protected void sP(boolean z) {
        if (hasNavBar(this.mActivity) && (this.kff.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kff.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.kff.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.kff.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.kff.setLayoutParams(layoutParams);
        }
    }

    public void cDl() {
        if (this.kfd.isPlaying()) {
            asl();
            if (this.kfC != null) {
                this.kfC.onPause();
            }
            if (this.kft != null) {
                this.kft.onPaused();
            }
        } else if (this.Yb) {
            asn();
            if (this.jJZ != null) {
                this.jJZ.bRc();
            }
            if (this.kft != null) {
                this.kft.cJr();
            }
        } else {
            cJd();
        }
    }

    public void Fe() {
        this.iLu = true;
        if (this.eEJ != null) {
            this.eEJ.Fe();
        }
    }

    public boolean cIU() {
        return this.kfd != null && this.kfd.getView().getHeight() > this.kfd.getView().getWidth();
    }

    public void cIV() {
        sP(false);
        cIY();
    }

    public boolean AU(int i2) {
        switch (i2) {
            case 4:
                if (this.Yn) {
                    if (cIU()) {
                        sP(false);
                        cIY();
                    } else {
                        Fe();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.iLm <= 0 || this.iLj == null) {
                    return false;
                }
                this.iLr = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.iLr * 100.0d) / this.iLm);
                this.iLj.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cIS()) {
            return (QuickVideoView) this.kfd;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cIW() {
        return this.kfd;
    }

    public VideoListMediaControllerView cnu() {
        return this.iKO;
    }

    public void show() {
        this.iKM.setVisibility(0);
    }

    public void cny() {
        if (this.iKX != null) {
            ViewGroup.LayoutParams layoutParams = this.iKX.getLayoutParams();
            this.iKR = (FrameLayout.LayoutParams) this.iKM.getLayoutParams();
            this.iKR.width = layoutParams.width;
            this.iKR.height = layoutParams.height;
            this.iKR.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.iKM.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.iKM.setLayoutParams(this.iKR);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.iLu) {
            if (this.Yn) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.iLu = false;
        }
        if (configuration.orientation == 2) {
            cIX();
        } else {
            cIY();
        }
        cIZ();
        if (this.mActivity == com.baidu.adp.base.a.jm().currentActivity()) {
            asn();
        }
        cJm();
        cnG();
        if (this.kfy != null) {
            this.kfy.nv(true);
        }
    }

    protected void cIX() {
        this.Yn = true;
        if (cIU()) {
            this.iKM.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.iKM.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.aWZ.setVisibility(0);
        this.iLb.setVisibility(0);
        this.iLc.setVisibility(0);
        this.iKQ.setVisibility(8);
        this.emA.cKl();
        this.ahE.setVisibility(8);
        this.iKU.setImageResource(R.drawable.icon_video_narrow_white);
        yf(this.iLq);
        cnt();
        if (this.kfq != null) {
            this.kfq.pG();
        }
    }

    protected void cIY() {
        this.Yn = false;
        if (this.iKR != null) {
            this.iKM.setLayoutParams(this.iKR);
        }
        g(this.mActivity, false);
        this.aWZ.setVisibility(8);
        this.iKQ.setVisibility(0);
        this.emA.cKl();
        this.ahE.setVisibility(8);
        this.iKU.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.iKO != null && (this.iKO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKO.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.iKO.setLayoutParams(layoutParams);
        }
        this.iKM.setSystemUiVisibility(0);
        cIT();
        if (this.kfq != null) {
            this.kfq.pH();
        }
    }

    public void cIZ() {
        if (this.kfd != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.Yn) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.kfe.setMax(equipmentWidth);
            int duration = this.kfd.getDuration();
            if (duration > 0) {
                if (this.kfh.getVisibility() == 0) {
                    this.kfe.setProgress(this.kfe.getMax());
                } else {
                    this.kfe.setProgress((int) ((this.kfd.getCurrentPositionSync() * this.kfe.getMax()) / duration));
                }
            }
        }
    }

    private void yf(int i2) {
        if (this.iKO != null && (this.iKO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKO.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.iKO.setLayoutParams(layoutParams);
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

    public boolean cnA() {
        return !this.Yn;
    }

    public void a(g.f fVar) {
        this.iKZ = fVar;
    }

    public void a(g.a aVar) {
        this.kfl = aVar;
    }

    public void a(g.b bVar) {
        this.kfm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.kfG) {
            ew(str, str2);
        } else {
            ev(str, str2);
        }
        if (eVar != null) {
            eVar.sX(z);
        }
    }

    public void eu(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2, boolean z) {
        cJe();
        this.kfL = true;
        this.currentState = 0;
        if (cIS()) {
            ((QuickVideoView) this.kfd).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.kfd.setVideoDuration(this.kfk);
        this.kfd.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
        if (this.kfs > 0) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.iLx, this.kfs);
        }
        if (this.kft != null) {
            this.kft.onStarted();
        }
        this.emA.startLoading();
        sQ(z);
    }

    public void ev(String str, String str2) {
        y(str, str2, true);
    }

    public void ew(String str, String str2) {
        cJe();
        this.kfL = true;
        this.currentState = 0;
        if (cIS()) {
            ((QuickVideoView) this.kfd).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
        if (this.kfs > 0) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.iLx, this.kfs);
        }
        if (this.kft != null) {
            this.kft.onStarted();
        }
        this.emA.startLoading();
        sQ(true);
    }

    public void cJa() {
        asn();
        this.kfe.setVisibility(0);
    }

    public void asn() {
        if (this.kfd != null && this.iKO != null) {
            this.Yb = true;
            this.currentState = 1;
            if (cIS()) {
                ((QuickVideoView) this.kfd).setRecoveryState(1);
            }
            this.kfd.a(null);
            this.mStartPosition = x.cKo().IO(this.mVideoUrl);
            this.kfF = true;
            this.Yc = (this.mStartPosition <= 100 || this.kfd.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.emA.cKl();
            sQ(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.kfJ && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ahO)) {
            this.kfJ = false;
            this.kfK = true;
            ev(this.mVideoUrl, this.ahO);
        }
    }

    private void sQ(boolean z) {
        if (z) {
            this.ahE.setVisibility(0);
            cJk();
            this.kfe.setProgress(0);
        } else {
            this.ahE.setVisibility(8);
            cJk();
        }
        this.iKO.showProgress();
        this.iKP.setVisibility(8);
        this.kfi.setVisibility(8);
        this.kfh.setVisibility(8);
        this.kfj.setVisibility(8);
        this.grN.setVisibility(8);
    }

    private void cJb() {
        this.emA.cKl();
        this.kfi.setVisibility(8);
        this.kfh.setVisibility(8);
        this.kfj.setVisibility(8);
        cJm();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.kfd instanceof QuickVideoView) {
            ((QuickVideoView) this.kfd).setNeedRecovery(z);
        }
    }

    public void asl() {
        this.kfd.pause();
        this.currentState = 2;
        if (cIS()) {
            ((QuickVideoView) this.kfd).setRecoveryState(2);
        }
        cJb();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cIS()) {
            ((QuickVideoView) this.kfd).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Yh);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfS);
        this.kfd.stopPlayback();
        this.Yb = false;
        this.kfL = false;
        this.mStartPosition = 0;
        caF();
    }

    public void cJc() {
        if (this.kfd.getDuration() >= this.kfd.getCurrentPosition()) {
            x.cKo().bv(this.mVideoUrl, this.kfd.getCurrentPosition());
        }
    }

    public void sR(boolean z) {
        this.kfE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        if (this.iKV != null) {
            this.iKP.setVisibility(0);
            this.kfi.setVisibility(8);
            this.kfh.setVisibility(8);
            this.kfj.setVisibility(8);
            this.emA.cKl();
            cJk();
            this.kfe.setVisibility(8);
            this.grN.setVisibility(8);
            this.iKO.asw();
            this.ahE.setVisibility(z ? 0 : 8);
        }
    }

    public void caF() {
        sS(true);
    }

    public boolean pI() {
        if (this.kfd == null) {
            return false;
        }
        return this.kfd.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.kfd == null) {
            return 0;
        }
        return this.kfd.getCurrentPosition();
    }

    public void a(k kVar) {
        this.kfw = kVar;
    }

    public void a(j jVar) {
        this.kfv = jVar;
    }

    public void a(i iVar) {
        this.jJZ = iVar;
    }

    public void a(g gVar) {
        this.kfC = gVar;
    }

    public void a(h hVar) {
        this.kfu = hVar;
    }

    public void Ih(String str) {
        this.jJz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJd() {
        a(this.mVideoUrl, this.ahO, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.kfr = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cJe();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dav().daw()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.kfG = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.kfB != null) {
                    this.kfB.mQ(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.ui(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cJf();
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
                aVar.b(this.duK).aMS();
                return;
            } else if (this.kfB != null) {
                this.kfB.mQ(true);
                return;
            } else {
                if (!this.kfc) {
                    this.kfc = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.kfA != null) {
            this.kfA.bQZ();
        }
    }

    private void cJe() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dav().fd(this.mActivity);
        }
    }

    public void cJf() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.ahE.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLB);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Yh);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfR);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfS);
        this.eEJ.stop();
        iLt.unregister(this.mActivity);
    }

    public void II(String str) {
        this.iLc.setText(str);
    }

    public boolean cnC() {
        return this.Yb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJg() {
        if (this.iKV != null) {
            if (this.kfn) {
                cJk();
            } else {
                cJj();
            }
        }
    }

    public void cnG() {
        cJj();
        cJh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJh() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLB);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.iLB, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJi() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLB);
    }

    public void cJj() {
        if (this.iKV != null && !this.kfn && !this.kfP) {
            sT(true);
            cnF();
            this.iKV.setVisibility(0);
            this.kff.setVisibility(0);
            this.kfe.setVisibility(8);
            this.kfn = true;
            if (this.kfr != null) {
                this.kfr.mR(false);
            }
        }
    }

    public void cnD() {
        if (this.iKV != null && this.kfn) {
            sT(false);
            cnF();
            this.iKV.setVisibility(8);
            this.kff.setVisibility(8);
            this.kfe.setVisibility(0);
            this.hem.setAnimationListener(this.iLz);
            this.iKV.startAnimation(this.hem);
            this.kfn = false;
            if (this.kfr != null) {
                this.kfr.bRb();
            }
        }
    }

    public void cJk() {
        if (this.iKV != null && this.kfn) {
            this.bhy.cancel();
            this.hem.cancel();
            sT(false);
            cnF();
            this.iKV.setVisibility(8);
            this.kff.setVisibility(8);
            this.kfe.setVisibility(0);
            this.kfn = false;
            if (this.kfr != null) {
                this.kfr.bRb();
            }
        }
    }

    private void cnF() {
        if (this.iKV != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLB);
            this.bhy.setAnimationListener(null);
            this.hem.setAnimationListener(null);
            this.iKV.clearAnimation();
        }
    }

    private void cJl() {
        if (this.iKV != null) {
            this.bhy.setAnimationListener(null);
            this.hem.setAnimationListener(null);
            this.iKV.clearAnimation();
        }
    }

    public void sT(boolean z) {
        cJm();
        if (z) {
            this.kfg.setVisibility(0);
        } else {
            this.kfg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJm() {
        if (this.currentState == 1) {
            this.kfg.setState(1);
        } else {
            this.kfg.setState(0);
        }
    }

    public void a(InterfaceC0650c interfaceC0650c) {
        this.kfq = interfaceC0650c;
    }

    public void yi(int i2) {
        this.mStartPosition = i2;
    }

    public void ak(boolean z, boolean z2) {
        if (this.eEJ != null) {
            if (this.iKU != null) {
                this.iKU.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.iKO != null && (this.iKO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKO.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.iKO.setLayoutParams(layoutParams);
            }
            this.eEJ.bS(z);
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

    public void sU(boolean z) {
        this.kfO = z;
    }

    public void a(m mVar) {
        this.kfx = mVar;
    }

    public void a(a aVar) {
        this.kfy = aVar;
    }

    public void a(n nVar) {
        this.kfz = nVar;
    }

    public void a(l lVar) {
        this.kfA = lVar;
    }

    public void a(f fVar) {
        this.kfB = fVar;
    }

    public void sV(boolean z) {
        this.kfI = z;
    }

    public void sW(boolean z) {
        this.kfo = z;
    }

    public void AV(int i2) {
        this.kfM = i2;
    }

    public View cJn() {
        return this.iKM;
    }

    public void a(p pVar) {
        this.jJN = pVar;
    }

    public void cJo() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duK.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.duK.getPageActivity());
    }
}
