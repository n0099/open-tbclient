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
    private static int jbg;
    private static CallStateReceiver jbh;
    protected boolean YC;
    private boolean Yr;
    private int Ys;
    private Runnable Yx;
    private TbImageView aii;
    private String ais;
    private View ber;
    private Animation boW;
    private int currentState;
    private TbPageContext<?> dIF;
    private w eBq;
    private QuickVideoView.b eBz;
    private g.InterfaceC0705g eKA;
    private g.a eKw;
    private g.f eKx;
    private g.e eKz;
    private SeekBar.OnSeekBarChangeListener ePf;
    private String evm;
    private VideoLoadingProgressView.a gEj;
    protected View gGN;
    private Animation htl;
    private VideoListMediaControllerView jaB;
    private View jaC;
    private FrameLayout jaD;
    protected FrameLayout.LayoutParams jaE;
    private ImageView jaH;
    private View jaI;
    private View jaK;
    private g.f jaM;
    private ImageView jaO;
    private TextView jaP;
    private View jaT;
    private View jaU;
    private TextView jaV;
    private SeekBar jaW;
    private ImageView jaX;
    private ImageView jaY;
    private int jaZ;
    public View jaz;
    private int jba;
    private int jbb;
    private com.baidu.tieba.play.o jbd;
    private int jbe;
    private int jbf;
    private boolean jbi;
    private g.b jbk;
    protected Runnable jbl;
    private Animation.AnimationListener jbn;
    private Animation.AnimationListener jbo;
    private Runnable jbp;
    private CustomMessageListener jbq;
    private VideoControllerView.b jdl;
    private p kcE;
    private i kcQ;
    private String kcq;
    private boolean kxY;
    protected com.baidu.tieba.play.a.a kxZ;
    private boolean kyA;
    private boolean kyB;
    private boolean kyC;
    private TextView kyD;
    private boolean kyE;
    private boolean kyF;
    private boolean kyG;
    private boolean kyH;
    private int kyI;
    private boolean kyJ;
    private boolean kyK;
    private boolean kyL;
    private boolean kyM;
    private Runnable kyN;
    private Runnable kyO;
    private QuickVideoView.a kyP;
    private ProgressBar kya;
    private View kyb;
    private SwitchImageView kyc;
    private TextView kyd;
    private TextView kye;
    private TextView kyf;
    private int kyg;
    private g.a kyh;
    private g.b kyi;
    private boolean kyj;
    private boolean kyk;
    private View.OnClickListener kyl;
    protected InterfaceC0704c kym;
    private d kyn;
    private long kyo;
    private o kyp;
    private h kyq;
    private j kyr;
    private k kys;
    private m kyt;
    private a kyu;
    private n kyv;
    private l kyw;
    private f kyx;
    private g kyy;
    private boolean kyz;
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
        void nQ(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0704c {
        void pM();

        void pN();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bXA();

        void nm(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void tv(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void nl(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void cKI();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bXB();
    }

    /* loaded from: classes.dex */
    public interface j {
        void sx(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bXy();

        void bXz();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cKJ();

        boolean cKK();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void BI(int i);

        void cQG();

        void cQH();

        void onPaused();

        void onPrepared();

        void onStarted();

        void zK();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cKH();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.Ys = 100;
        this.kxY = false;
        this.YC = false;
        this.Yr = false;
        this.kyj = false;
        this.kyk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.jba = 0;
        this.jbb = 0;
        this.kyo = 60000L;
        this.jbe = 0;
        this.jbi = false;
        this.kyz = true;
        this.kyA = true;
        this.kyB = false;
        this.kyC = false;
        this.kcq = null;
        this.currentState = -1;
        this.kyE = false;
        this.kyJ = true;
        this.kyL = false;
        this.kyM = false;
        this.eKx = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.jaB != null && c.this.kxZ != null && c.this.kxZ.getDuration() > 0) {
                    c.this.jaB.bj(0, c.this.kxZ.getDuration());
                }
                c.this.bKZ();
                if (c.this.kyp != null) {
                    c.this.kyp.onPrepared();
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.qd();
                    return false;
                }
                return false;
            }
        };
        this.gEj = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bKZ();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                if (c.this.aii.getVisibility() != 8) {
                    if (c.this.kxZ.getCurrentPosition() > c.this.Ys) {
                        c.this.qd();
                    } else {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                    }
                }
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kxZ != null) {
                    int duration = c.this.kxZ.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Yr = false;
                        c.this.kyH = false;
                        c.this.mStartPosition = 0;
                        c.this.cuc();
                        c.this.jaC.setVisibility(0);
                        c.this.kya.setProgress(c.this.kya.getMax());
                        c.this.Ys = 100;
                        if (c.this.kyh != null) {
                            c.this.kyh.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cQi()) {
                            ((QuickVideoView) c.this.kxZ).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.tq(false);
                            c.this.tr(true);
                        } else {
                            c.this.cQA();
                            c.this.kyd.setVisibility(0);
                        }
                        if (!c.this.YC && duration <= 150000) {
                            if (!c.this.kyE) {
                                if (c.this.kyr != null) {
                                    c.this.kyr.sx(true);
                                }
                                c.this.A(c.this.mVideoUrl, c.this.ais, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cQi()) {
                                    ((QuickVideoView) c.this.kxZ).setRecoveryState(5);
                                }
                                c.this.kxZ.pause();
                                c.this.kxZ.seekTo(0);
                            }
                        }
                        if (c.this.kyp != null) {
                            c.this.kyp.BI(c.this.kya.getMax());
                            c.this.kyp.zK();
                        }
                    }
                }
            }
        };
        this.jbk = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.gGN.setVisibility(0);
                c.this.eBq.cRB();
                c.this.currentState = 4;
                if (c.this.cQi()) {
                    ((QuickVideoView) c.this.kxZ).setRecoveryState(4);
                }
                if (c.this.kyi != null) {
                    c.this.kyi.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kyF = true;
                }
                if (c.this.kyp != null) {
                    c.this.kyp.cQG();
                }
                c.this.kyH = false;
                return true;
            }
        };
        this.jbl = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kxZ == null || !c.this.kxZ.isPlaying()) {
                    c.this.gGN.setVisibility(0);
                    c.this.eBq.cRB();
                    if (c.this.kyp != null) {
                        c.this.kyp.cQG();
                    }
                }
            }
        };
        this.eKA = new g.InterfaceC0705g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kyB) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kyN, 200L);
                }
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kxZ == null || !c.this.kyB) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 200L);
                    c.this.kyB = false;
                } else if (c.this.mStartPosition != c.this.kxZ.getCurrentPosition()) {
                    c.this.kyB = false;
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                } else {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kyN, 200L);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Yr = false;
                if (c.this.kyk) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kyO, 300L);
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jbl);
            }
        };
        this.kyO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kyH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.kcE != null) {
                    c.this.kcE.cKH();
                }
                if (view2.getId() != c.this.gGN.getId()) {
                    if (view2.getId() != c.this.kyc.getId()) {
                        if (view2.getId() == c.this.kye.getId()) {
                            if (c.this.kyq != null) {
                                c.this.kyq.cKI();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kyd.getId()) {
                            if (c.this.kyr != null) {
                                c.this.kyr.sx(false);
                            }
                            c.this.eW(c.this.mVideoUrl, c.this.ais);
                            return;
                        } else if (view2.getId() == c.this.jaH.getId()) {
                            int i2 = c.this.kyk ? 1 : 2;
                            if (c.this.YC) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i2).ag("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i2).ag("obj_source", 1));
                            }
                            if (c.this.kyw != null) {
                                c.this.kyw.bXz();
                            }
                            if (c.this.cQk()) {
                                if (c.this.YC) {
                                    c.this.cQo();
                                } else {
                                    c.this.cQn();
                                }
                                c.this.tn(c.this.YC);
                                return;
                            }
                            c.this.GV();
                            return;
                        } else if (view2.getId() != c.this.jaO.getId()) {
                            if (c.this.kyl != null) {
                                c.this.kyl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kyw != null) {
                                c.this.kyw.bXz();
                            }
                            if (c.this.cQk()) {
                                c.this.cQo();
                                c.this.tn(false);
                                return;
                            }
                            c.this.GV();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cKA();
                    c.this.cQC();
                    if (c.this.currentState != 1) {
                        c.this.cQy();
                        c.this.cQz();
                    } else {
                        c.this.cus();
                    }
                    if (c.this.kyu != null) {
                        c.this.kyu.nQ(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kxZ.stopPlayback();
                c.this.Yr = false;
                c.this.cQt();
            }
        };
        this.jbn = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.jbo = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.jbp = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cup();
            }
        };
        this.jbq = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.avT();
                }
            }
        };
        this.jdl = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pg(int i2) {
                int duration;
                if (c.this.kxZ != null && (duration = c.this.kxZ.getDuration()) > 0 && c.this.kya != null) {
                    c.this.kya.setProgress((int) ((i2 * c.this.jaz.getWidth()) / duration));
                    if (c.this.kyp != null) {
                        c.this.kyp.BI((c.this.kxZ.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.ePf = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cQy();
                c.this.tr(false);
                if (c.this.kyu != null) {
                    c.this.kyu.nQ(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cug() != null) {
                    c.this.yS(c.this.cug().getSeekPosition());
                    if (!c.this.cuo()) {
                        c.this.cQt();
                    } else {
                        c.this.avU();
                        if (c.this.kcQ != null) {
                            c.this.kcQ.bXB();
                        }
                    }
                }
                c.this.tr(true);
                c.this.cQx();
                if (c.this.kyu != null) {
                    c.this.kyu.nQ(true);
                }
                if (c.this.kyv != null) {
                    c.this.kyv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kyP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQF() {
                if (!c.this.kyE) {
                    c.this.eBq.startLoading();
                    c.this.aii.setVisibility(0);
                    c.this.kyc.setVisibility(8);
                    c.this.kye.setVisibility(8);
                    c.this.kyd.setVisibility(8);
                    c.this.kyf.setVisibility(8);
                    c.this.gGN.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jbl);
                    if (c.this.kyo > 0) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.jbl, c.this.kyo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.dIF = tbPageContext;
            this.mRootView = view;
            this.kyJ = z;
            this.jaK = view;
            this.mActivity = this.dIF.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.Ys = 100;
        this.kxY = false;
        this.YC = false;
        this.Yr = false;
        this.kyj = false;
        this.kyk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.jba = 0;
        this.jbb = 0;
        this.kyo = 60000L;
        this.jbe = 0;
        this.jbi = false;
        this.kyz = true;
        this.kyA = true;
        this.kyB = false;
        this.kyC = false;
        this.kcq = null;
        this.currentState = -1;
        this.kyE = false;
        this.kyJ = true;
        this.kyL = false;
        this.kyM = false;
        this.eKx = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.jaB != null && c.this.kxZ != null && c.this.kxZ.getDuration() > 0) {
                    c.this.jaB.bj(0, c.this.kxZ.getDuration());
                }
                c.this.bKZ();
                if (c.this.kyp != null) {
                    c.this.kyp.onPrepared();
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.qd();
                    return false;
                }
                return false;
            }
        };
        this.gEj = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bKZ();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                if (c.this.aii.getVisibility() != 8) {
                    if (c.this.kxZ.getCurrentPosition() > c.this.Ys) {
                        c.this.qd();
                    } else {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                    }
                }
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kxZ != null) {
                    int duration = c.this.kxZ.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Yr = false;
                        c.this.kyH = false;
                        c.this.mStartPosition = 0;
                        c.this.cuc();
                        c.this.jaC.setVisibility(0);
                        c.this.kya.setProgress(c.this.kya.getMax());
                        c.this.Ys = 100;
                        if (c.this.kyh != null) {
                            c.this.kyh.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cQi()) {
                            ((QuickVideoView) c.this.kxZ).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.tq(false);
                            c.this.tr(true);
                        } else {
                            c.this.cQA();
                            c.this.kyd.setVisibility(0);
                        }
                        if (!c.this.YC && duration <= 150000) {
                            if (!c.this.kyE) {
                                if (c.this.kyr != null) {
                                    c.this.kyr.sx(true);
                                }
                                c.this.A(c.this.mVideoUrl, c.this.ais, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cQi()) {
                                    ((QuickVideoView) c.this.kxZ).setRecoveryState(5);
                                }
                                c.this.kxZ.pause();
                                c.this.kxZ.seekTo(0);
                            }
                        }
                        if (c.this.kyp != null) {
                            c.this.kyp.BI(c.this.kya.getMax());
                            c.this.kyp.zK();
                        }
                    }
                }
            }
        };
        this.jbk = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.gGN.setVisibility(0);
                c.this.eBq.cRB();
                c.this.currentState = 4;
                if (c.this.cQi()) {
                    ((QuickVideoView) c.this.kxZ).setRecoveryState(4);
                }
                if (c.this.kyi != null) {
                    c.this.kyi.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kyF = true;
                }
                if (c.this.kyp != null) {
                    c.this.kyp.cQG();
                }
                c.this.kyH = false;
                return true;
            }
        };
        this.jbl = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kxZ == null || !c.this.kxZ.isPlaying()) {
                    c.this.gGN.setVisibility(0);
                    c.this.eBq.cRB();
                    if (c.this.kyp != null) {
                        c.this.kyp.cQG();
                    }
                }
            }
        };
        this.eKA = new g.InterfaceC0705g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0705g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kyB) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kyN, 200L);
                }
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kxZ == null || !c.this.kyB) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 200L);
                    c.this.kyB = false;
                } else if (c.this.mStartPosition != c.this.kxZ.getCurrentPosition()) {
                    c.this.kyB = false;
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                } else {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kyN, 200L);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Yr = false;
                if (c.this.kyk) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kyO, 300L);
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jbl);
            }
        };
        this.kyO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kyH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.kcE != null) {
                    c.this.kcE.cKH();
                }
                if (view2.getId() != c.this.gGN.getId()) {
                    if (view2.getId() != c.this.kyc.getId()) {
                        if (view2.getId() == c.this.kye.getId()) {
                            if (c.this.kyq != null) {
                                c.this.kyq.cKI();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kyd.getId()) {
                            if (c.this.kyr != null) {
                                c.this.kyr.sx(false);
                            }
                            c.this.eW(c.this.mVideoUrl, c.this.ais);
                            return;
                        } else if (view2.getId() == c.this.jaH.getId()) {
                            int i22 = c.this.kyk ? 1 : 2;
                            if (c.this.YC) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i22).ag("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i22).ag("obj_source", 1));
                            }
                            if (c.this.kyw != null) {
                                c.this.kyw.bXz();
                            }
                            if (c.this.cQk()) {
                                if (c.this.YC) {
                                    c.this.cQo();
                                } else {
                                    c.this.cQn();
                                }
                                c.this.tn(c.this.YC);
                                return;
                            }
                            c.this.GV();
                            return;
                        } else if (view2.getId() != c.this.jaO.getId()) {
                            if (c.this.kyl != null) {
                                c.this.kyl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kyw != null) {
                                c.this.kyw.bXz();
                            }
                            if (c.this.cQk()) {
                                c.this.cQo();
                                c.this.tn(false);
                                return;
                            }
                            c.this.GV();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cKA();
                    c.this.cQC();
                    if (c.this.currentState != 1) {
                        c.this.cQy();
                        c.this.cQz();
                    } else {
                        c.this.cus();
                    }
                    if (c.this.kyu != null) {
                        c.this.kyu.nQ(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kxZ.stopPlayback();
                c.this.Yr = false;
                c.this.cQt();
            }
        };
        this.jbn = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.jbo = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.jbp = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cup();
            }
        };
        this.jbq = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.avT();
                }
            }
        };
        this.jdl = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pg(int i22) {
                int duration;
                if (c.this.kxZ != null && (duration = c.this.kxZ.getDuration()) > 0 && c.this.kya != null) {
                    c.this.kya.setProgress((int) ((i22 * c.this.jaz.getWidth()) / duration));
                    if (c.this.kyp != null) {
                        c.this.kyp.BI((c.this.kxZ.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.ePf = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cQy();
                c.this.tr(false);
                if (c.this.kyu != null) {
                    c.this.kyu.nQ(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cug() != null) {
                    c.this.yS(c.this.cug().getSeekPosition());
                    if (!c.this.cuo()) {
                        c.this.cQt();
                    } else {
                        c.this.avU();
                        if (c.this.kcQ != null) {
                            c.this.kcQ.bXB();
                        }
                    }
                }
                c.this.tr(true);
                c.this.cQx();
                if (c.this.kyu != null) {
                    c.this.kyu.nQ(true);
                }
                if (c.this.kyv != null) {
                    c.this.kyv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kyP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQF() {
                if (!c.this.kyE) {
                    c.this.eBq.startLoading();
                    c.this.aii.setVisibility(0);
                    c.this.kyc.setVisibility(8);
                    c.this.kye.setVisibility(8);
                    c.this.kyd.setVisibility(8);
                    c.this.kyf.setVisibility(8);
                    c.this.gGN.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jbl);
                    if (c.this.kyo > 0) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.jbl, c.this.kyo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.dIF = tbPageContext;
            this.mRootView = view;
            this.kyJ = z;
            this.jaK = view;
            this.mActivity = this.dIF.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.jaz = ao(this.mActivity);
        this.jaz.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.jaz);
        }
        this.kxZ = com.baidu.tieba.play.a.b.A(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.jaz).addView(this.kxZ.getView(), 0);
        this.kxZ.getView().setLayoutParams(layoutParams);
        this.eBq = new w((ViewGroup) this.jaz.findViewById(R.id.auto_video_loading_container));
        this.eBq.setLoadingAnimationListener(this.gEj);
        this.jaB = (VideoListMediaControllerView) this.jaz.findViewById(R.id.media_controller);
        this.jaB.setPlayer(this.kxZ);
        this.kya = (ProgressBar) this.jaz.findViewById(R.id.pgrBottomProgress);
        this.kya.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.kya.setProgress(0);
        this.jaB.setOnSeekBarChangeListener(this.ePf);
        this.jaB.setOnProgressUpdatedListener(this.jdl);
        this.jaC = this.jaz.findViewById(R.id.black_mask);
        this.gGN = this.jaz.findViewById(R.id.layout_error);
        this.gGN.setOnClickListener(this.mOnClickListener);
        this.kyD = (TextView) this.jaz.findViewById(R.id.auto_video_error_tips);
        this.jaD = (FrameLayout) this.jaz.findViewById(R.id.danmu_container);
        this.jaH = (ImageView) this.jaz.findViewById(R.id.img_full_screen);
        this.jaH.setOnClickListener(this.mOnClickListener);
        this.jaI = this.jaz.findViewById(R.id.layout_media_controller);
        this.kyb = this.jaz.findViewById(R.id.time_show_controller);
        this.kxZ.setContinuePlayEnable(true);
        this.kxZ.setOnPreparedListener(this.eKx);
        this.kxZ.setOnCompletionListener(this.eKw);
        this.kxZ.setOnErrorListener(this.jbk);
        this.kxZ.setOnSeekCompleteListener(this.eKA);
        this.kxZ.setOnOutInfoListener(this.eKz);
        this.kxZ.setOnSurfaceDestroyedListener(this.eBz);
        if (cQi()) {
            ((QuickVideoView) this.kxZ).setOnRecoveryCallback(this.kyP);
        }
        this.kyc = (SwitchImageView) this.jaz.findViewById(R.id.img_play_controller);
        this.kyc.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.kyc.setState(0);
        this.kyc.setOnClickListener(this.mOnClickListener);
        this.kyd = (TextView) this.jaz.findViewById(R.id.txt_replay);
        this.kyd.setOnClickListener(this.mOnClickListener);
        this.kye = (TextView) this.jaz.findViewById(R.id.txt_playnext);
        this.kye.setOnClickListener(this.mOnClickListener);
        this.kyf = (TextView) this.jaz.findViewById(R.id.txt_next_video_title);
        this.aii = (TbImageView) this.jaz.findViewById(R.id.video_thumbnail);
        this.aii.setDefaultErrorResource(0);
        this.aii.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jaO = (ImageView) this.jaz.findViewById(R.id.img_exit);
        this.jaO.setOnClickListener(this.mOnClickListener);
        this.jaP = (TextView) this.jaz.findViewById(R.id.video_title);
        this.ber = this.jaz.findViewById(R.id.layout_title);
        this.ber.setVisibility(8);
        this.htl = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.boW = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jaZ = this.mAudioManager.getStreamMaxVolume(3);
        this.jbf = this.mAudioManager.getStreamVolume(3);
        jbg = 100 / this.jaZ;
        this.jaz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.kys != null) {
                    c.this.kys.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Yr) {
                        if (c.this.mStatus == 1 && c.this.jbb != 0) {
                            c.this.b(c.this.jbb == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jbb = 0;
                            c.this.jba = 0;
                        }
                        if (!c.this.kxZ.isPlaying()) {
                            c.this.kye.setVisibility(8);
                            c.this.kyd.setVisibility(8);
                            c.this.kyf.setVisibility(8);
                        }
                    }
                    c.this.cuc();
                    if (c.this.kys != null) {
                        c.this.kys.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jbd = new com.baidu.tieba.play.o(this.mActivity);
        if (this.kyJ) {
            this.jbd.start();
        }
        this.jbe = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jbh == null) {
            jbh = new CallStateReceiver();
        }
        jbh.register(this.mActivity);
        cQj();
        MessageManager.getInstance().registerListener(this.jbq);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jbq);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void BE(int i2) {
        if (this.aii != null) {
            this.aii.setDefaultBgResource(i2);
        }
    }

    public boolean cQi() {
        return this.mVideoType == 0 && (this.kxZ instanceof QuickVideoView);
    }

    public void cQj() {
        if (this.kyz) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.jaz.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.jaz.setSystemUiVisibility(0);
    }

    public void tl(boolean z) {
        this.kyz = z;
        cQj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuc() {
        this.mStatus = 0;
        if (this.jaT != null && this.jaT.getParent() != null && (this.jaT.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jaT.getParent()).removeView(this.jaT);
                this.jaT = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jaU != null && this.jaU.getParent() != null && (this.jaU.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jaU.getParent()).removeView(this.jaU);
                this.jaU = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cud() {
        if (this.mStatus == 1) {
            if (this.jaT == null && this.jaz != null && (this.jaz instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.jaz, true);
                this.jaT = this.jaz.findViewById(R.id.lay_jindu);
                this.jaV = (TextView) this.jaT.findViewById(R.id.show_time);
                this.jaY = (ImageView) this.jaT.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jaU == null && this.jaz != null && (this.jaz instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.jaz, true);
            this.jaU = this.jaz.findViewById(R.id.lay_voice);
            this.jaX = (ImageView) this.jaU.findViewById(R.id.arrow_voice_icon);
            this.jaW = (SeekBar) this.jaU.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.kyl = onClickListener;
    }

    public void tm(boolean z) {
        this.kyk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.kys != null) {
                c.this.kys.onStart();
            }
            if (c.this.YC && c.this.Yr) {
                if (c.this.mStatus == 1) {
                    c.this.cQA();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ak(f2);
                    }
                } else {
                    if (c.this.YC) {
                        c.this.cuf();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.jba = c.this.kxZ.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ak(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.kyK) {
                if (c.this.kyt != null && c.this.kyt.cKJ()) {
                    return true;
                }
                c.this.cKA();
                c.this.cQC();
                if (c.this.kxZ.isPlaying()) {
                    c.this.cQx();
                } else {
                    c.this.cQy();
                }
                if (c.this.kyu != null) {
                    c.this.kyu.nQ(c.this.kxZ.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.kyK) {
                if (c.this.Yr) {
                    if (c.this.kyt != null && c.this.kyt.cKK()) {
                        return true;
                    }
                    c.this.cQw();
                    if (c.this.kxZ.isPlaying()) {
                        c.this.cQx();
                    } else {
                        c.this.cQy();
                    }
                    if (c.this.kyu != null) {
                        c.this.kyu.nQ(c.this.kxZ.isPlaying());
                    }
                } else {
                    c.this.cKA();
                    c.this.cQC();
                    if (c.this.currentState != 1) {
                        c.this.cQy();
                        c.this.cQz();
                    } else {
                        c.this.cus();
                    }
                    if (c.this.kyu != null) {
                        c.this.kyu.nQ(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuf() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jaz.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jaz.setSystemUiVisibility(4);
        } else {
            this.jaz.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(float f2) {
        if (!this.Yr) {
            this.mStatus = 0;
            return;
        }
        cud();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % jbg == 0) {
            if (f2 > 0.0f && this.jbf < this.jaZ) {
                this.jbf++;
            }
            if (f2 < 0.0f && this.jbf > 0) {
                this.jbf--;
            }
        }
        if (this.mProgress > 0) {
            this.jaX.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jaX.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jbf, 0);
        this.jaW.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jba -= 1000;
                this.jbb = 1;
            } else {
                this.jba += 1000;
                this.jbb = 2;
            }
            if (this.jba < 0) {
                this.jba = 0;
            } else if (this.jba > this.kxZ.getDuration()) {
                this.jba = this.kxZ.getDuration();
            }
        }
        cud();
        String BO = this.jaB.BO(this.jba);
        if (f2 > 0.0f) {
            this.jaY.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jaY.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(BO)) {
            this.jaV.setText(new StringBuilder().append(BO).append("/").append(this.jaB.BO(this.kxZ.getDuration())));
        }
        this.jaB.setCurrentDuration(this.jba, z ? false : true);
        cQA();
        cQp();
    }

    protected View ao(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void BF(int i2) {
        this.kyg = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ais = str2;
    }

    public void setFid(String str) {
        this.evm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKZ() {
        if (this.kxZ != null && this.jaB != null) {
            this.jaB.showProgress();
            this.mStartPosition = x.cRE().KB(this.mVideoUrl);
            if (this.kyH) {
                this.kxZ.setVolume(1.0f, 1.0f);
                this.kxZ.start();
                this.kyH = false;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.Yx);
                com.baidu.adp.lib.f.e.ld().postDelayed(this.Yx, 20L);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbl);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyO);
                if (this.kxZ.cRa()) {
                    this.currentState = 1;
                    if (cQi()) {
                        ((QuickVideoView) this.kxZ).setRecoveryState(1);
                    }
                    cQA();
                }
                this.mStartPosition = x.cRE().KB(this.mVideoUrl);
                this.jaB.setPlayer(this.kxZ);
                if (this.mStartPosition != 0) {
                    this.kyB = true;
                }
                if (!this.kyG) {
                    this.jaB.showProgress();
                }
                if (!this.kyk && this.kxZ.getDuration() <= 0) {
                    cug().setVisibility(4);
                }
            }
            this.Ys = (this.mStartPosition <= 100 || this.kxZ.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        if (this.aii.getVisibility() != 8 || !this.Yr) {
            this.Yr = true;
            this.jaC.setVisibility(8);
            this.gGN.setVisibility(8);
            this.eBq.cRA();
            this.aii.setVisibility(8);
            cQB();
            long duration = this.kxZ.getDuration() / 1000;
            String str = this.ais;
            this.jaB.showProgress();
            this.kya.setVisibility(0);
            if (this.jaM != null && cQi()) {
                this.jaM.onPrepared(((QuickVideoView) this.kxZ).getPlayer());
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

    protected void tn(boolean z) {
        if (hasNavBar(this.mActivity) && (this.kyb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kyb.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.kyb.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.kyb.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.kyb.setLayoutParams(layoutParams);
        }
    }

    public void cKA() {
        if (this.kxZ.isPlaying()) {
            avT();
            if (this.kyy != null) {
                this.kyy.onPause();
            }
            if (this.kyp != null) {
                this.kyp.onPaused();
            }
        } else if (this.Yr) {
            avU();
            if (this.kcQ != null) {
                this.kcQ.bXB();
            }
            if (this.kyp != null) {
                this.kyp.cQH();
            }
        } else {
            cQt();
        }
    }

    public void GV() {
        this.jbi = true;
        if (this.jbd != null) {
            this.jbd.GV();
        }
    }

    public boolean cQk() {
        return this.kxZ != null && this.kxZ.getView().getHeight() > this.kxZ.getView().getWidth();
    }

    public void cQl() {
        tn(false);
        cQo();
    }

    public boolean BG(int i2) {
        switch (i2) {
            case 4:
                if (this.YC) {
                    if (cQk()) {
                        tn(false);
                        cQo();
                    } else {
                        GV();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.jaZ <= 0 || this.jaW == null) {
                    return false;
                }
                this.jbf = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jbf * 100.0d) / this.jaZ);
                this.jaW.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cQi()) {
            return (QuickVideoView) this.kxZ;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cQm() {
        return this.kxZ;
    }

    public VideoListMediaControllerView cug() {
        return this.jaB;
    }

    public void show() {
        this.jaz.setVisibility(0);
    }

    public void cuk() {
        if (this.jaK != null) {
            ViewGroup.LayoutParams layoutParams = this.jaK.getLayoutParams();
            this.jaE = (FrameLayout.LayoutParams) this.jaz.getLayoutParams();
            this.jaE.width = layoutParams.width;
            this.jaE.height = layoutParams.height;
            this.jaE.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.jaz.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.jaz.setLayoutParams(this.jaE);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jbi) {
            if (this.YC) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.jbi = false;
        }
        if (configuration.orientation == 2) {
            cQn();
        } else {
            cQo();
        }
        cQp();
        if (this.mActivity == com.baidu.adp.base.a.jm().currentActivity()) {
            avU();
        }
        cQC();
        cus();
        if (this.kyu != null) {
            this.kyu.nQ(true);
        }
    }

    protected void cQn() {
        this.YC = true;
        if (cQk()) {
            this.jaz.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.jaz.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        h(this.mActivity, true);
        this.ber.setVisibility(0);
        this.jaO.setVisibility(0);
        this.jaP.setVisibility(0);
        this.jaD.setVisibility(8);
        this.eBq.cRB();
        this.aii.setVisibility(8);
        this.jaH.setImageResource(R.drawable.icon_video_narrow_white);
        yP(this.jbe);
        cuf();
        if (this.kym != null) {
            this.kym.pM();
        }
    }

    protected void cQo() {
        this.YC = false;
        if (this.jaE != null) {
            this.jaz.setLayoutParams(this.jaE);
        }
        h(this.mActivity, false);
        this.ber.setVisibility(8);
        this.jaD.setVisibility(0);
        this.eBq.cRB();
        this.aii.setVisibility(8);
        this.jaH.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.jaB != null && (this.jaB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jaB.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.jaB.setLayoutParams(layoutParams);
        }
        this.jaz.setSystemUiVisibility(0);
        cQj();
        if (this.kym != null) {
            this.kym.pN();
        }
    }

    public void cQp() {
        if (this.kxZ != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.YC) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.kya.setMax(equipmentWidth);
            int duration = this.kxZ.getDuration();
            if (duration > 0) {
                if (this.kyd.getVisibility() == 0) {
                    this.kya.setProgress(this.kya.getMax());
                } else {
                    this.kya.setProgress((int) ((this.kxZ.getCurrentPositionSync() * this.kya.getMax()) / duration));
                }
            }
        }
    }

    private void yP(int i2) {
        if (this.jaB != null && (this.jaB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jaB.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.jaB.setLayoutParams(layoutParams);
        }
    }

    private void h(Activity activity, boolean z) {
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

    public boolean cum() {
        return !this.YC;
    }

    public void a(g.f fVar) {
        this.jaM = fVar;
    }

    public void a(g.a aVar) {
        this.kyh = aVar;
    }

    public void a(g.b bVar) {
        this.kyi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.kyC) {
            eX(str, str2);
        } else {
            eW(str, str2);
        }
        if (eVar != null) {
            eVar.tv(z);
        }
    }

    public void eV(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, boolean z) {
        cQu();
        this.kyH = true;
        this.currentState = 0;
        if (cQi()) {
            ((QuickVideoView) this.kxZ).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.kxZ.setVideoDuration(this.kyg);
        this.kxZ.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbl);
        if (this.kyo > 0) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.jbl, this.kyo);
        }
        if (this.kyp != null) {
            this.kyp.onStarted();
        }
        this.eBq.startLoading();
        to(z);
    }

    public void eW(String str, String str2) {
        A(str, str2, true);
    }

    public void eX(String str, String str2) {
        cQu();
        this.kyH = true;
        this.currentState = 0;
        if (cQi()) {
            ((QuickVideoView) this.kxZ).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbl);
        if (this.kyo > 0) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.jbl, this.kyo);
        }
        if (this.kyp != null) {
            this.kyp.onStarted();
        }
        this.eBq.startLoading();
        to(true);
    }

    public void cQq() {
        avU();
        this.kya.setVisibility(0);
    }

    public void avU() {
        if (this.kxZ != null && this.jaB != null) {
            this.Yr = true;
            this.currentState = 1;
            if (cQi()) {
                ((QuickVideoView) this.kxZ).setRecoveryState(1);
            }
            this.kxZ.a(null);
            this.mStartPosition = x.cRE().KB(this.mVideoUrl);
            this.kyB = true;
            this.Ys = (this.mStartPosition <= 100 || this.kxZ.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.eBq.cRB();
            to(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.kyF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ais)) {
            this.kyF = false;
            this.kyG = true;
            eW(this.mVideoUrl, this.ais);
        }
    }

    private void to(boolean z) {
        if (z) {
            this.aii.setVisibility(0);
            cQA();
            this.kya.setProgress(0);
        } else {
            this.aii.setVisibility(8);
            cQA();
        }
        this.jaB.showProgress();
        this.jaC.setVisibility(8);
        this.kye.setVisibility(8);
        this.kyd.setVisibility(8);
        this.kyf.setVisibility(8);
        this.gGN.setVisibility(8);
    }

    private void cQr() {
        this.eBq.cRB();
        this.kye.setVisibility(8);
        this.kyd.setVisibility(8);
        this.kyf.setVisibility(8);
        cQC();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.kxZ instanceof QuickVideoView) {
            ((QuickVideoView) this.kxZ).setNeedRecovery(z);
        }
    }

    public void avT() {
        this.kxZ.pause();
        this.currentState = 2;
        if (cQi()) {
            ((QuickVideoView) this.kxZ).setRecoveryState(2);
        }
        cQr();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cQi()) {
            ((QuickVideoView) this.kxZ).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.Yx);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbl);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyO);
        this.kxZ.stopPlayback();
        this.Yr = false;
        this.kyH = false;
        this.mStartPosition = 0;
        cho();
    }

    public void cQs() {
        if (this.kxZ.getDuration() >= this.kxZ.getCurrentPosition()) {
            x.cRE().bw(this.mVideoUrl, this.kxZ.getCurrentPosition());
        }
    }

    public void tp(boolean z) {
        this.kyA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(boolean z) {
        if (this.jaI != null) {
            this.jaC.setVisibility(0);
            this.kye.setVisibility(8);
            this.kyd.setVisibility(8);
            this.kyf.setVisibility(8);
            this.eBq.cRB();
            cQA();
            this.kya.setVisibility(8);
            this.gGN.setVisibility(8);
            this.jaB.awd();
            this.aii.setVisibility(z ? 0 : 8);
        }
    }

    public void cho() {
        tq(true);
    }

    public boolean pO() {
        if (this.kxZ == null) {
            return false;
        }
        return this.kxZ.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.kxZ == null) {
            return 0;
        }
        return this.kxZ.getCurrentPosition();
    }

    public void a(k kVar) {
        this.kys = kVar;
    }

    public void a(j jVar) {
        this.kyr = jVar;
    }

    public void a(i iVar) {
        this.kcQ = iVar;
    }

    public void a(g gVar) {
        this.kyy = gVar;
    }

    public void a(h hVar) {
        this.kyq = hVar;
    }

    public void JU(String str) {
        this.kcq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQt() {
        a(this.mVideoUrl, this.ais, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.kyn = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cQu();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dhZ().dia()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.kyC = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.kyx != null) {
                    this.kyx.nl(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.vO(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cQv();
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
                aVar.b(this.dIF).aST();
                return;
            } else if (this.kyx != null) {
                this.kyx.nl(true);
                return;
            } else {
                if (!this.kxY) {
                    this.kxY = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.kyw != null) {
            this.kyw.bXy();
        }
    }

    private void cQu() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dhZ().fs(this.mActivity);
        }
    }

    public void cQv() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.aii.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbp);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.Yx);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbl);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyN);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyO);
        this.jbd.stop();
        jbh.unregister(this.mActivity);
    }

    public void Kv(String str) {
        this.jaP.setText(str);
    }

    public boolean cuo() {
        return this.Yr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQw() {
        if (this.jaI != null) {
            if (this.kyj) {
                cQA();
            } else {
                cQz();
            }
        }
    }

    public void cus() {
        cQz();
        cQx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQx() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbp);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.jbp, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbp);
    }

    public void cQz() {
        if (this.jaI != null && !this.kyj && !this.kyL) {
            tr(true);
            cur();
            this.jaI.setVisibility(0);
            this.kyb.setVisibility(0);
            this.kya.setVisibility(8);
            this.kyj = true;
            if (this.kyn != null) {
                this.kyn.nm(false);
            }
        }
    }

    public void cup() {
        if (this.jaI != null && this.kyj) {
            tr(false);
            cur();
            this.jaI.setVisibility(8);
            this.kyb.setVisibility(8);
            this.kya.setVisibility(0);
            this.htl.setAnimationListener(this.jbn);
            this.jaI.startAnimation(this.htl);
            this.kyj = false;
            if (this.kyn != null) {
                this.kyn.bXA();
            }
        }
    }

    public void cQA() {
        if (this.jaI != null && this.kyj) {
            this.boW.cancel();
            this.htl.cancel();
            tr(false);
            cur();
            this.jaI.setVisibility(8);
            this.kyb.setVisibility(8);
            this.kya.setVisibility(0);
            this.kyj = false;
            if (this.kyn != null) {
                this.kyn.bXA();
            }
        }
    }

    private void cur() {
        if (this.jaI != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbp);
            this.boW.setAnimationListener(null);
            this.htl.setAnimationListener(null);
            this.jaI.clearAnimation();
        }
    }

    private void cQB() {
        if (this.jaI != null) {
            this.boW.setAnimationListener(null);
            this.htl.setAnimationListener(null);
            this.jaI.clearAnimation();
        }
    }

    public void tr(boolean z) {
        cQC();
        if (z) {
            this.kyc.setVisibility(0);
        } else {
            this.kyc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQC() {
        if (this.currentState == 1) {
            this.kyc.setState(1);
        } else {
            this.kyc.setState(0);
        }
    }

    public void a(InterfaceC0704c interfaceC0704c) {
        this.kym = interfaceC0704c;
    }

    public void yS(int i2) {
        this.mStartPosition = i2;
    }

    public void an(boolean z, boolean z2) {
        if (this.jbd != null) {
            if (this.jaH != null) {
                this.jaH.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.jaB != null && (this.jaB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jaB.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.jaB.setLayoutParams(layoutParams);
            }
            this.jbd.cc(z);
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

    public void ts(boolean z) {
        this.kyK = z;
    }

    public void a(m mVar) {
        this.kyt = mVar;
    }

    public void a(a aVar) {
        this.kyu = aVar;
    }

    public void a(n nVar) {
        this.kyv = nVar;
    }

    public void a(l lVar) {
        this.kyw = lVar;
    }

    public void a(f fVar) {
        this.kyx = fVar;
    }

    public void tt(boolean z) {
        this.kyE = z;
    }

    public void tu(boolean z) {
        this.kyk = z;
    }

    public void BH(int i2) {
        this.kyI = i2;
    }

    public View cQD() {
        return this.jaz;
    }

    public void a(p pVar) {
        this.kcE = pVar;
    }

    public void cQE() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dIF.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.dIF.getPageActivity());
    }
}
