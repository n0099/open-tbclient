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
    private static int jat;
    private static CallStateReceiver jau;
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
    private w eBf;
    private QuickVideoView.b eBo;
    private g.a eKl;
    private g.f eKm;
    private g.e eKo;
    private g.InterfaceC0704g eKp;
    private SeekBar.OnSeekBarChangeListener eOU;
    private String evm;
    private VideoLoadingProgressView.a gDY;
    protected View gGC;
    private Animation hta;
    public View iZM;
    private VideoListMediaControllerView iZO;
    private View iZP;
    private FrameLayout iZQ;
    protected FrameLayout.LayoutParams iZR;
    private ImageView iZU;
    private View iZV;
    private View iZX;
    private g.f iZZ;
    private Animation.AnimationListener jaA;
    private Animation.AnimationListener jaB;
    private Runnable jaC;
    private CustomMessageListener jaD;
    private ImageView jab;
    private TextView jac;
    private View jag;
    private View jah;
    private TextView jai;
    private SeekBar jaj;
    private ImageView jak;
    private ImageView jal;
    private int jam;
    private int jan;
    private int jao;
    private com.baidu.tieba.play.o jaq;
    private int jar;
    private int jas;
    private boolean jav;
    private g.b jax;
    protected Runnable jay;
    private VideoControllerView.b jcy;
    private i kbK;
    private String kbk;
    private p kby;
    private boolean kwS;
    protected com.baidu.tieba.play.a.a kwT;
    private ProgressBar kwU;
    private View kwV;
    private SwitchImageView kwW;
    private TextView kwX;
    private TextView kwY;
    private TextView kwZ;
    private boolean kxA;
    private boolean kxB;
    private int kxC;
    private boolean kxD;
    private boolean kxE;
    private boolean kxF;
    private boolean kxG;
    private Runnable kxH;
    private Runnable kxI;
    private QuickVideoView.a kxJ;
    private int kxa;
    private g.a kxb;
    private g.b kxc;
    private boolean kxd;
    private boolean kxe;
    private View.OnClickListener kxf;
    protected InterfaceC0703c kxg;
    private d kxh;
    private long kxi;
    private o kxj;
    private h kxk;
    private j kxl;
    private k kxm;
    private m kxn;
    private a kxo;
    private n kxp;
    private l kxq;
    private f kxr;
    private g kxs;
    private boolean kxt;
    private boolean kxu;
    private boolean kxv;
    private boolean kxw;
    private TextView kxx;
    private boolean kxy;
    private boolean kxz;
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
    public interface InterfaceC0703c {
        void pM();

        void pN();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bXy();

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
        void cKs();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bXz();
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
        void bXw();

        void bXx();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cKt();

        boolean cKu();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void BG(int i);

        void cQq();

        void cQr();

        void onPaused();

        void onPrepared();

        void onStarted();

        void zK();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cKr();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.Ys = 100;
        this.kwS = false;
        this.YC = false;
        this.Yr = false;
        this.kxd = false;
        this.kxe = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.jan = 0;
        this.jao = 0;
        this.kxi = 60000L;
        this.jar = 0;
        this.jav = false;
        this.kxt = true;
        this.kxu = true;
        this.kxv = false;
        this.kxw = false;
        this.kbk = null;
        this.currentState = -1;
        this.kxy = false;
        this.kxD = true;
        this.kxF = false;
        this.kxG = false;
        this.eKm = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iZO != null && c.this.kwT != null && c.this.kwT.getDuration() > 0) {
                    c.this.iZO.bj(0, c.this.kwT.getDuration());
                }
                c.this.bKX();
                if (c.this.kxj != null) {
                    c.this.kxj.onPrepared();
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.qd();
                    return false;
                }
                return false;
            }
        };
        this.gDY = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bKX();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                if (c.this.aii.getVisibility() != 8) {
                    if (c.this.kwT.getCurrentPosition() > c.this.Ys) {
                        c.this.qd();
                    } else {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                    }
                }
            }
        };
        this.eKl = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kwT != null) {
                    int duration = c.this.kwT.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Yr = false;
                        c.this.kxB = false;
                        c.this.mStartPosition = 0;
                        c.this.ctT();
                        c.this.iZP.setVisibility(0);
                        c.this.kwU.setProgress(c.this.kwU.getMax());
                        c.this.Ys = 100;
                        if (c.this.kxb != null) {
                            c.this.kxb.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cPS()) {
                            ((QuickVideoView) c.this.kwT).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.tq(false);
                            c.this.tr(true);
                        } else {
                            c.this.cQk();
                            c.this.kwX.setVisibility(0);
                        }
                        if (!c.this.YC && duration <= 150000) {
                            if (!c.this.kxy) {
                                if (c.this.kxl != null) {
                                    c.this.kxl.sx(true);
                                }
                                c.this.A(c.this.mVideoUrl, c.this.ais, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cPS()) {
                                    ((QuickVideoView) c.this.kwT).setRecoveryState(5);
                                }
                                c.this.kwT.pause();
                                c.this.kwT.seekTo(0);
                            }
                        }
                        if (c.this.kxj != null) {
                            c.this.kxj.BG(c.this.kwU.getMax());
                            c.this.kxj.zK();
                        }
                    }
                }
            }
        };
        this.jax = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.gGC.setVisibility(0);
                c.this.eBf.cRl();
                c.this.currentState = 4;
                if (c.this.cPS()) {
                    ((QuickVideoView) c.this.kwT).setRecoveryState(4);
                }
                if (c.this.kxc != null) {
                    c.this.kxc.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kxz = true;
                }
                if (c.this.kxj != null) {
                    c.this.kxj.cQq();
                }
                c.this.kxB = false;
                return true;
            }
        };
        this.jay = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kwT == null || !c.this.kwT.isPlaying()) {
                    c.this.gGC.setVisibility(0);
                    c.this.eBf.cRl();
                    if (c.this.kxj != null) {
                        c.this.kxj.cQq();
                    }
                }
            }
        };
        this.eKp = new g.InterfaceC0704g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kxv) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kxH, 200L);
                }
            }
        };
        this.kxH = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kwT == null || !c.this.kxv) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 200L);
                    c.this.kxv = false;
                } else if (c.this.mStartPosition != c.this.kwT.getCurrentPosition()) {
                    c.this.kxv = false;
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                } else {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kxH, 200L);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Yr = false;
                if (c.this.kxe) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kxI, 300L);
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jay);
            }
        };
        this.kxI = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kxB = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.kby != null) {
                    c.this.kby.cKr();
                }
                if (view2.getId() != c.this.gGC.getId()) {
                    if (view2.getId() != c.this.kwW.getId()) {
                        if (view2.getId() == c.this.kwY.getId()) {
                            if (c.this.kxk != null) {
                                c.this.kxk.cKs();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kwX.getId()) {
                            if (c.this.kxl != null) {
                                c.this.kxl.sx(false);
                            }
                            c.this.eW(c.this.mVideoUrl, c.this.ais);
                            return;
                        } else if (view2.getId() == c.this.iZU.getId()) {
                            int i2 = c.this.kxe ? 1 : 2;
                            if (c.this.YC) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i2).ag("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i2).ag("obj_source", 1));
                            }
                            if (c.this.kxq != null) {
                                c.this.kxq.bXx();
                            }
                            if (c.this.cPU()) {
                                if (c.this.YC) {
                                    c.this.cPY();
                                } else {
                                    c.this.cPX();
                                }
                                c.this.tn(c.this.YC);
                                return;
                            }
                            c.this.GV();
                            return;
                        } else if (view2.getId() != c.this.jab.getId()) {
                            if (c.this.kxf != null) {
                                c.this.kxf.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kxq != null) {
                                c.this.kxq.bXx();
                            }
                            if (c.this.cPU()) {
                                c.this.cPY();
                                c.this.tn(false);
                                return;
                            }
                            c.this.GV();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cKk();
                    c.this.cQm();
                    if (c.this.currentState != 1) {
                        c.this.cQi();
                        c.this.cQj();
                    } else {
                        c.this.cuj();
                    }
                    if (c.this.kxo != null) {
                        c.this.kxo.nQ(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kwT.stopPlayback();
                c.this.Yr = false;
                c.this.cQd();
            }
        };
        this.jaA = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.jaB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.jaC = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cug();
            }
        };
        this.jaD = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.avT();
                }
            }
        };
        this.jcy = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pe(int i2) {
                int duration;
                if (c.this.kwT != null && (duration = c.this.kwT.getDuration()) > 0 && c.this.kwU != null) {
                    c.this.kwU.setProgress((int) ((i2 * c.this.iZM.getWidth()) / duration));
                    if (c.this.kxj != null) {
                        c.this.kxj.BG((c.this.kwT.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eOU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cQi();
                c.this.tr(false);
                if (c.this.kxo != null) {
                    c.this.kxo.nQ(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ctX() != null) {
                    c.this.yQ(c.this.ctX().getSeekPosition());
                    if (!c.this.cuf()) {
                        c.this.cQd();
                    } else {
                        c.this.avU();
                        if (c.this.kbK != null) {
                            c.this.kbK.bXz();
                        }
                    }
                }
                c.this.tr(true);
                c.this.cQh();
                if (c.this.kxo != null) {
                    c.this.kxo.nQ(true);
                }
                if (c.this.kxp != null) {
                    c.this.kxp.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kxJ = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQp() {
                if (!c.this.kxy) {
                    c.this.eBf.startLoading();
                    c.this.aii.setVisibility(0);
                    c.this.kwW.setVisibility(8);
                    c.this.kwY.setVisibility(8);
                    c.this.kwX.setVisibility(8);
                    c.this.kwZ.setVisibility(8);
                    c.this.gGC.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jay);
                    if (c.this.kxi > 0) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.jay, c.this.kxi);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.dIF = tbPageContext;
            this.mRootView = view;
            this.kxD = z;
            this.iZX = view;
            this.mActivity = this.dIF.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.Ys = 100;
        this.kwS = false;
        this.YC = false;
        this.Yr = false;
        this.kxd = false;
        this.kxe = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.jan = 0;
        this.jao = 0;
        this.kxi = 60000L;
        this.jar = 0;
        this.jav = false;
        this.kxt = true;
        this.kxu = true;
        this.kxv = false;
        this.kxw = false;
        this.kbk = null;
        this.currentState = -1;
        this.kxy = false;
        this.kxD = true;
        this.kxF = false;
        this.kxG = false;
        this.eKm = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iZO != null && c.this.kwT != null && c.this.kwT.getDuration() > 0) {
                    c.this.iZO.bj(0, c.this.kwT.getDuration());
                }
                c.this.bKX();
                if (c.this.kxj != null) {
                    c.this.kxj.onPrepared();
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.qd();
                    return false;
                }
                return false;
            }
        };
        this.gDY = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bKX();
            }
        };
        this.Yx = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                if (c.this.aii.getVisibility() != 8) {
                    if (c.this.kwT.getCurrentPosition() > c.this.Ys) {
                        c.this.qd();
                    } else {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                    }
                }
            }
        };
        this.eKl = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.kwT != null) {
                    int duration = c.this.kwT.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.Yr = false;
                        c.this.kxB = false;
                        c.this.mStartPosition = 0;
                        c.this.ctT();
                        c.this.iZP.setVisibility(0);
                        c.this.kwU.setProgress(c.this.kwU.getMax());
                        c.this.Ys = 100;
                        if (c.this.kxb != null) {
                            c.this.kxb.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cPS()) {
                            ((QuickVideoView) c.this.kwT).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.tq(false);
                            c.this.tr(true);
                        } else {
                            c.this.cQk();
                            c.this.kwX.setVisibility(0);
                        }
                        if (!c.this.YC && duration <= 150000) {
                            if (!c.this.kxy) {
                                if (c.this.kxl != null) {
                                    c.this.kxl.sx(true);
                                }
                                c.this.A(c.this.mVideoUrl, c.this.ais, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cPS()) {
                                    ((QuickVideoView) c.this.kwT).setRecoveryState(5);
                                }
                                c.this.kwT.pause();
                                c.this.kwT.seekTo(0);
                            }
                        }
                        if (c.this.kxj != null) {
                            c.this.kxj.BG(c.this.kwU.getMax());
                            c.this.kxj.zK();
                        }
                    }
                }
            }
        };
        this.jax = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.gGC.setVisibility(0);
                c.this.eBf.cRl();
                c.this.currentState = 4;
                if (c.this.cPS()) {
                    ((QuickVideoView) c.this.kwT).setRecoveryState(4);
                }
                if (c.this.kxc != null) {
                    c.this.kxc.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kxz = true;
                }
                if (c.this.kxj != null) {
                    c.this.kxj.cQq();
                }
                c.this.kxB = false;
                return true;
            }
        };
        this.jay = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kwT == null || !c.this.kwT.isPlaying()) {
                    c.this.gGC.setVisibility(0);
                    c.this.eBf.cRl();
                    if (c.this.kxj != null) {
                        c.this.kxj.cQq();
                    }
                }
            }
        };
        this.eKp = new g.InterfaceC0704g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0704g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kxv) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kxH, 200L);
                }
            }
        };
        this.kxH = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.kwT == null || !c.this.kxv) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 200L);
                    c.this.kxv = false;
                } else if (c.this.mStartPosition != c.this.kwT.getCurrentPosition()) {
                    c.this.kxv = false;
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.Yx, 20L);
                } else {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kxH, 200L);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.Yr = false;
                if (c.this.kxe) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(c.this.kxI, 300L);
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.Yx);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jay);
            }
        };
        this.kxI = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kxB = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.kby != null) {
                    c.this.kby.cKr();
                }
                if (view2.getId() != c.this.gGC.getId()) {
                    if (view2.getId() != c.this.kwW.getId()) {
                        if (view2.getId() == c.this.kwY.getId()) {
                            if (c.this.kxk != null) {
                                c.this.kxk.cKs();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kwX.getId()) {
                            if (c.this.kxl != null) {
                                c.this.kxl.sx(false);
                            }
                            c.this.eW(c.this.mVideoUrl, c.this.ais);
                            return;
                        } else if (view2.getId() == c.this.iZU.getId()) {
                            int i22 = c.this.kxe ? 1 : 2;
                            if (c.this.YC) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i22).ag("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").dh("tid", c.this.ais).dh("fid", c.this.evm).ag("obj_type", i22).ag("obj_source", 1));
                            }
                            if (c.this.kxq != null) {
                                c.this.kxq.bXx();
                            }
                            if (c.this.cPU()) {
                                if (c.this.YC) {
                                    c.this.cPY();
                                } else {
                                    c.this.cPX();
                                }
                                c.this.tn(c.this.YC);
                                return;
                            }
                            c.this.GV();
                            return;
                        } else if (view2.getId() != c.this.jab.getId()) {
                            if (c.this.kxf != null) {
                                c.this.kxf.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kxq != null) {
                                c.this.kxq.bXx();
                            }
                            if (c.this.cPU()) {
                                c.this.cPY();
                                c.this.tn(false);
                                return;
                            }
                            c.this.GV();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cKk();
                    c.this.cQm();
                    if (c.this.currentState != 1) {
                        c.this.cQi();
                        c.this.cQj();
                    } else {
                        c.this.cuj();
                    }
                    if (c.this.kxo != null) {
                        c.this.kxo.nQ(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.kwT.stopPlayback();
                c.this.Yr = false;
                c.this.cQd();
            }
        };
        this.jaA = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.jaB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.jaC = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cug();
            }
        };
        this.jaD = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.avT();
                }
            }
        };
        this.jcy = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void pe(int i22) {
                int duration;
                if (c.this.kwT != null && (duration = c.this.kwT.getDuration()) > 0 && c.this.kwU != null) {
                    c.this.kwU.setProgress((int) ((i22 * c.this.iZM.getWidth()) / duration));
                    if (c.this.kxj != null) {
                        c.this.kxj.BG((c.this.kwT.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eOU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cQi();
                c.this.tr(false);
                if (c.this.kxo != null) {
                    c.this.kxo.nQ(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ctX() != null) {
                    c.this.yQ(c.this.ctX().getSeekPosition());
                    if (!c.this.cuf()) {
                        c.this.cQd();
                    } else {
                        c.this.avU();
                        if (c.this.kbK != null) {
                            c.this.kbK.bXz();
                        }
                    }
                }
                c.this.tr(true);
                c.this.cQh();
                if (c.this.kxo != null) {
                    c.this.kxo.nQ(true);
                }
                if (c.this.kxp != null) {
                    c.this.kxp.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kxJ = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cQp() {
                if (!c.this.kxy) {
                    c.this.eBf.startLoading();
                    c.this.aii.setVisibility(0);
                    c.this.kwW.setVisibility(8);
                    c.this.kwY.setVisibility(8);
                    c.this.kwX.setVisibility(8);
                    c.this.kwZ.setVisibility(8);
                    c.this.gGC.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(c.this.jay);
                    if (c.this.kxi > 0) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(c.this.jay, c.this.kxi);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.dIF = tbPageContext;
            this.mRootView = view;
            this.kxD = z;
            this.iZX = view;
            this.mActivity = this.dIF.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.iZM = ao(this.mActivity);
        this.iZM.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.iZM);
        }
        this.kwT = com.baidu.tieba.play.a.b.A(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.iZM).addView(this.kwT.getView(), 0);
        this.kwT.getView().setLayoutParams(layoutParams);
        this.eBf = new w((ViewGroup) this.iZM.findViewById(R.id.auto_video_loading_container));
        this.eBf.setLoadingAnimationListener(this.gDY);
        this.iZO = (VideoListMediaControllerView) this.iZM.findViewById(R.id.media_controller);
        this.iZO.setPlayer(this.kwT);
        this.kwU = (ProgressBar) this.iZM.findViewById(R.id.pgrBottomProgress);
        this.kwU.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.kwU.setProgress(0);
        this.iZO.setOnSeekBarChangeListener(this.eOU);
        this.iZO.setOnProgressUpdatedListener(this.jcy);
        this.iZP = this.iZM.findViewById(R.id.black_mask);
        this.gGC = this.iZM.findViewById(R.id.layout_error);
        this.gGC.setOnClickListener(this.mOnClickListener);
        this.kxx = (TextView) this.iZM.findViewById(R.id.auto_video_error_tips);
        this.iZQ = (FrameLayout) this.iZM.findViewById(R.id.danmu_container);
        this.iZU = (ImageView) this.iZM.findViewById(R.id.img_full_screen);
        this.iZU.setOnClickListener(this.mOnClickListener);
        this.iZV = this.iZM.findViewById(R.id.layout_media_controller);
        this.kwV = this.iZM.findViewById(R.id.time_show_controller);
        this.kwT.setContinuePlayEnable(true);
        this.kwT.setOnPreparedListener(this.eKm);
        this.kwT.setOnCompletionListener(this.eKl);
        this.kwT.setOnErrorListener(this.jax);
        this.kwT.setOnSeekCompleteListener(this.eKp);
        this.kwT.setOnOutInfoListener(this.eKo);
        this.kwT.setOnSurfaceDestroyedListener(this.eBo);
        if (cPS()) {
            ((QuickVideoView) this.kwT).setOnRecoveryCallback(this.kxJ);
        }
        this.kwW = (SwitchImageView) this.iZM.findViewById(R.id.img_play_controller);
        this.kwW.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.kwW.setState(0);
        this.kwW.setOnClickListener(this.mOnClickListener);
        this.kwX = (TextView) this.iZM.findViewById(R.id.txt_replay);
        this.kwX.setOnClickListener(this.mOnClickListener);
        this.kwY = (TextView) this.iZM.findViewById(R.id.txt_playnext);
        this.kwY.setOnClickListener(this.mOnClickListener);
        this.kwZ = (TextView) this.iZM.findViewById(R.id.txt_next_video_title);
        this.aii = (TbImageView) this.iZM.findViewById(R.id.video_thumbnail);
        this.aii.setDefaultErrorResource(0);
        this.aii.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jab = (ImageView) this.iZM.findViewById(R.id.img_exit);
        this.jab.setOnClickListener(this.mOnClickListener);
        this.jac = (TextView) this.iZM.findViewById(R.id.video_title);
        this.ber = this.iZM.findViewById(R.id.layout_title);
        this.ber.setVisibility(8);
        this.hta = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.boW = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jam = this.mAudioManager.getStreamMaxVolume(3);
        this.jas = this.mAudioManager.getStreamVolume(3);
        jat = 100 / this.jam;
        this.iZM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.kxm != null) {
                    c.this.kxm.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Yr) {
                        if (c.this.mStatus == 1 && c.this.jao != 0) {
                            c.this.b(c.this.jao == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jao = 0;
                            c.this.jan = 0;
                        }
                        if (!c.this.kwT.isPlaying()) {
                            c.this.kwY.setVisibility(8);
                            c.this.kwX.setVisibility(8);
                            c.this.kwZ.setVisibility(8);
                        }
                    }
                    c.this.ctT();
                    if (c.this.kxm != null) {
                        c.this.kxm.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jaq = new com.baidu.tieba.play.o(this.mActivity);
        if (this.kxD) {
            this.jaq.start();
        }
        this.jar = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jau == null) {
            jau = new CallStateReceiver();
        }
        jau.register(this.mActivity);
        cPT();
        MessageManager.getInstance().registerListener(this.jaD);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jaD);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void BC(int i2) {
        if (this.aii != null) {
            this.aii.setDefaultBgResource(i2);
        }
    }

    public boolean cPS() {
        return this.mVideoType == 0 && (this.kwT instanceof QuickVideoView);
    }

    public void cPT() {
        if (this.kxt) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.iZM.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.iZM.setSystemUiVisibility(0);
    }

    public void tl(boolean z) {
        this.kxt = z;
        cPT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctT() {
        this.mStatus = 0;
        if (this.jag != null && this.jag.getParent() != null && (this.jag.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jag.getParent()).removeView(this.jag);
                this.jag = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jah != null && this.jah.getParent() != null && (this.jah.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jah.getParent()).removeView(this.jah);
                this.jah = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void ctU() {
        if (this.mStatus == 1) {
            if (this.jag == null && this.iZM != null && (this.iZM instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.iZM, true);
                this.jag = this.iZM.findViewById(R.id.lay_jindu);
                this.jai = (TextView) this.jag.findViewById(R.id.show_time);
                this.jal = (ImageView) this.jag.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jah == null && this.iZM != null && (this.iZM instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.iZM, true);
            this.jah = this.iZM.findViewById(R.id.lay_voice);
            this.jak = (ImageView) this.jah.findViewById(R.id.arrow_voice_icon);
            this.jaj = (SeekBar) this.jah.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.kxf = onClickListener;
    }

    public void tm(boolean z) {
        this.kxe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.kxm != null) {
                c.this.kxm.onStart();
            }
            if (c.this.YC && c.this.Yr) {
                if (c.this.mStatus == 1) {
                    c.this.cQk();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ak(f2);
                    }
                } else {
                    if (c.this.YC) {
                        c.this.ctW();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.jan = c.this.kwT.getCurrentPosition();
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
            if (!c.this.kxE) {
                if (c.this.kxn != null && c.this.kxn.cKt()) {
                    return true;
                }
                c.this.cKk();
                c.this.cQm();
                if (c.this.kwT.isPlaying()) {
                    c.this.cQh();
                } else {
                    c.this.cQi();
                }
                if (c.this.kxo != null) {
                    c.this.kxo.nQ(c.this.kwT.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.kxE) {
                if (c.this.Yr) {
                    if (c.this.kxn != null && c.this.kxn.cKu()) {
                        return true;
                    }
                    c.this.cQg();
                    if (c.this.kwT.isPlaying()) {
                        c.this.cQh();
                    } else {
                        c.this.cQi();
                    }
                    if (c.this.kxo != null) {
                        c.this.kxo.nQ(c.this.kwT.isPlaying());
                    }
                } else {
                    c.this.cKk();
                    c.this.cQm();
                    if (c.this.currentState != 1) {
                        c.this.cQi();
                        c.this.cQj();
                    } else {
                        c.this.cuj();
                    }
                    if (c.this.kxo != null) {
                        c.this.kxo.nQ(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctW() {
        if (Build.VERSION.SDK_INT < 16) {
            this.iZM.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.iZM.setSystemUiVisibility(4);
        } else {
            this.iZM.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(float f2) {
        if (!this.Yr) {
            this.mStatus = 0;
            return;
        }
        ctU();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % jat == 0) {
            if (f2 > 0.0f && this.jas < this.jam) {
                this.jas++;
            }
            if (f2 < 0.0f && this.jas > 0) {
                this.jas--;
            }
        }
        if (this.mProgress > 0) {
            this.jak.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jak.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jas, 0);
        this.jaj.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jan -= 1000;
                this.jao = 1;
            } else {
                this.jan += 1000;
                this.jao = 2;
            }
            if (this.jan < 0) {
                this.jan = 0;
            } else if (this.jan > this.kwT.getDuration()) {
                this.jan = this.kwT.getDuration();
            }
        }
        ctU();
        String BM = this.iZO.BM(this.jan);
        if (f2 > 0.0f) {
            this.jal.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jal.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(BM)) {
            this.jai.setText(new StringBuilder().append(BM).append("/").append(this.iZO.BM(this.kwT.getDuration())));
        }
        this.iZO.setCurrentDuration(this.jan, z ? false : true);
        cQk();
        cPZ();
    }

    protected View ao(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void BD(int i2) {
        this.kxa = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ais = str2;
    }

    public void setFid(String str) {
        this.evm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKX() {
        if (this.kwT != null && this.iZO != null) {
            this.iZO.showProgress();
            this.mStartPosition = x.cRo().KA(this.mVideoUrl);
            if (this.kxB) {
                this.kwT.setVolume(1.0f, 1.0f);
                this.kwT.start();
                this.kxB = false;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.Yx);
                com.baidu.adp.lib.f.e.ld().postDelayed(this.Yx, 20L);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jay);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kxI);
                if (this.kwT.cQK()) {
                    this.currentState = 1;
                    if (cPS()) {
                        ((QuickVideoView) this.kwT).setRecoveryState(1);
                    }
                    cQk();
                }
                this.mStartPosition = x.cRo().KA(this.mVideoUrl);
                this.iZO.setPlayer(this.kwT);
                if (this.mStartPosition != 0) {
                    this.kxv = true;
                }
                if (!this.kxA) {
                    this.iZO.showProgress();
                }
                if (!this.kxe && this.kwT.getDuration() <= 0) {
                    ctX().setVisibility(4);
                }
            }
            this.Ys = (this.mStartPosition <= 100 || this.kwT.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        if (this.aii.getVisibility() != 8 || !this.Yr) {
            this.Yr = true;
            this.iZP.setVisibility(8);
            this.gGC.setVisibility(8);
            this.eBf.cRk();
            this.aii.setVisibility(8);
            cQl();
            long duration = this.kwT.getDuration() / 1000;
            String str = this.ais;
            this.iZO.showProgress();
            this.kwU.setVisibility(0);
            if (this.iZZ != null && cPS()) {
                this.iZZ.onPrepared(((QuickVideoView) this.kwT).getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.kwV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kwV.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.kwV.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.kwV.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.kwV.setLayoutParams(layoutParams);
        }
    }

    public void cKk() {
        if (this.kwT.isPlaying()) {
            avT();
            if (this.kxs != null) {
                this.kxs.onPause();
            }
            if (this.kxj != null) {
                this.kxj.onPaused();
            }
        } else if (this.Yr) {
            avU();
            if (this.kbK != null) {
                this.kbK.bXz();
            }
            if (this.kxj != null) {
                this.kxj.cQr();
            }
        } else {
            cQd();
        }
    }

    public void GV() {
        this.jav = true;
        if (this.jaq != null) {
            this.jaq.GV();
        }
    }

    public boolean cPU() {
        return this.kwT != null && this.kwT.getView().getHeight() > this.kwT.getView().getWidth();
    }

    public void cPV() {
        tn(false);
        cPY();
    }

    public boolean BE(int i2) {
        switch (i2) {
            case 4:
                if (this.YC) {
                    if (cPU()) {
                        tn(false);
                        cPY();
                    } else {
                        GV();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.jam <= 0 || this.jaj == null) {
                    return false;
                }
                this.jas = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jas * 100.0d) / this.jam);
                this.jaj.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cPS()) {
            return (QuickVideoView) this.kwT;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cPW() {
        return this.kwT;
    }

    public VideoListMediaControllerView ctX() {
        return this.iZO;
    }

    public void show() {
        this.iZM.setVisibility(0);
    }

    public void cub() {
        if (this.iZX != null) {
            ViewGroup.LayoutParams layoutParams = this.iZX.getLayoutParams();
            this.iZR = (FrameLayout.LayoutParams) this.iZM.getLayoutParams();
            this.iZR.width = layoutParams.width;
            this.iZR.height = layoutParams.height;
            this.iZR.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.iZM.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.iZM.setLayoutParams(this.iZR);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jav) {
            if (this.YC) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.jav = false;
        }
        if (configuration.orientation == 2) {
            cPX();
        } else {
            cPY();
        }
        cPZ();
        if (this.mActivity == com.baidu.adp.base.a.jm().currentActivity()) {
            avU();
        }
        cQm();
        cuj();
        if (this.kxo != null) {
            this.kxo.nQ(true);
        }
    }

    protected void cPX() {
        this.YC = true;
        if (cPU()) {
            this.iZM.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.iZM.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        h(this.mActivity, true);
        this.ber.setVisibility(0);
        this.jab.setVisibility(0);
        this.jac.setVisibility(0);
        this.iZQ.setVisibility(8);
        this.eBf.cRl();
        this.aii.setVisibility(8);
        this.iZU.setImageResource(R.drawable.icon_video_narrow_white);
        yN(this.jar);
        ctW();
        if (this.kxg != null) {
            this.kxg.pM();
        }
    }

    protected void cPY() {
        this.YC = false;
        if (this.iZR != null) {
            this.iZM.setLayoutParams(this.iZR);
        }
        h(this.mActivity, false);
        this.ber.setVisibility(8);
        this.iZQ.setVisibility(0);
        this.eBf.cRl();
        this.aii.setVisibility(8);
        this.iZU.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.iZO != null && (this.iZO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZO.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.iZO.setLayoutParams(layoutParams);
        }
        this.iZM.setSystemUiVisibility(0);
        cPT();
        if (this.kxg != null) {
            this.kxg.pN();
        }
    }

    public void cPZ() {
        if (this.kwT != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.YC) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.kwU.setMax(equipmentWidth);
            int duration = this.kwT.getDuration();
            if (duration > 0) {
                if (this.kwX.getVisibility() == 0) {
                    this.kwU.setProgress(this.kwU.getMax());
                } else {
                    this.kwU.setProgress((int) ((this.kwT.getCurrentPositionSync() * this.kwU.getMax()) / duration));
                }
            }
        }
    }

    private void yN(int i2) {
        if (this.iZO != null && (this.iZO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZO.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.iZO.setLayoutParams(layoutParams);
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

    public boolean cud() {
        return !this.YC;
    }

    public void a(g.f fVar) {
        this.iZZ = fVar;
    }

    public void a(g.a aVar) {
        this.kxb = aVar;
    }

    public void a(g.b bVar) {
        this.kxc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.kxw) {
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
        cQe();
        this.kxB = true;
        this.currentState = 0;
        if (cPS()) {
            ((QuickVideoView) this.kwT).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.kwT.setVideoDuration(this.kxa);
        this.kwT.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jay);
        if (this.kxi > 0) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.jay, this.kxi);
        }
        if (this.kxj != null) {
            this.kxj.onStarted();
        }
        this.eBf.startLoading();
        to(z);
    }

    public void eW(String str, String str2) {
        A(str, str2, true);
    }

    public void eX(String str, String str2) {
        cQe();
        this.kxB = true;
        this.currentState = 0;
        if (cPS()) {
            ((QuickVideoView) this.kwT).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jay);
        if (this.kxi > 0) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.jay, this.kxi);
        }
        if (this.kxj != null) {
            this.kxj.onStarted();
        }
        this.eBf.startLoading();
        to(true);
    }

    public void cQa() {
        avU();
        this.kwU.setVisibility(0);
    }

    public void avU() {
        if (this.kwT != null && this.iZO != null) {
            this.Yr = true;
            this.currentState = 1;
            if (cPS()) {
                ((QuickVideoView) this.kwT).setRecoveryState(1);
            }
            this.kwT.a(null);
            this.mStartPosition = x.cRo().KA(this.mVideoUrl);
            this.kxv = true;
            this.Ys = (this.mStartPosition <= 100 || this.kwT.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.eBf.cRl();
            to(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.kxz && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ais)) {
            this.kxz = false;
            this.kxA = true;
            eW(this.mVideoUrl, this.ais);
        }
    }

    private void to(boolean z) {
        if (z) {
            this.aii.setVisibility(0);
            cQk();
            this.kwU.setProgress(0);
        } else {
            this.aii.setVisibility(8);
            cQk();
        }
        this.iZO.showProgress();
        this.iZP.setVisibility(8);
        this.kwY.setVisibility(8);
        this.kwX.setVisibility(8);
        this.kwZ.setVisibility(8);
        this.gGC.setVisibility(8);
    }

    private void cQb() {
        this.eBf.cRl();
        this.kwY.setVisibility(8);
        this.kwX.setVisibility(8);
        this.kwZ.setVisibility(8);
        cQm();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.kwT instanceof QuickVideoView) {
            ((QuickVideoView) this.kwT).setNeedRecovery(z);
        }
    }

    public void avT() {
        this.kwT.pause();
        this.currentState = 2;
        if (cPS()) {
            ((QuickVideoView) this.kwT).setRecoveryState(2);
        }
        cQb();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cPS()) {
            ((QuickVideoView) this.kwT).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.Yx);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jay);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kxI);
        this.kwT.stopPlayback();
        this.Yr = false;
        this.kxB = false;
        this.mStartPosition = 0;
        chf();
    }

    public void cQc() {
        if (this.kwT.getDuration() >= this.kwT.getCurrentPosition()) {
            x.cRo().bw(this.mVideoUrl, this.kwT.getCurrentPosition());
        }
    }

    public void tp(boolean z) {
        this.kxu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(boolean z) {
        if (this.iZV != null) {
            this.iZP.setVisibility(0);
            this.kwY.setVisibility(8);
            this.kwX.setVisibility(8);
            this.kwZ.setVisibility(8);
            this.eBf.cRl();
            cQk();
            this.kwU.setVisibility(8);
            this.gGC.setVisibility(8);
            this.iZO.awd();
            this.aii.setVisibility(z ? 0 : 8);
        }
    }

    public void chf() {
        tq(true);
    }

    public boolean pO() {
        if (this.kwT == null) {
            return false;
        }
        return this.kwT.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.kwT == null) {
            return 0;
        }
        return this.kwT.getCurrentPosition();
    }

    public void a(k kVar) {
        this.kxm = kVar;
    }

    public void a(j jVar) {
        this.kxl = jVar;
    }

    public void a(i iVar) {
        this.kbK = iVar;
    }

    public void a(g gVar) {
        this.kxs = gVar;
    }

    public void a(h hVar) {
        this.kxk = hVar;
    }

    public void JT(String str) {
        this.kbk = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQd() {
        a(this.mVideoUrl, this.ais, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.kxh = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cQe();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dhK().dhL()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.kxw = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.kxr != null) {
                    this.kxr.nl(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.vO(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cQf();
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
            } else if (this.kxr != null) {
                this.kxr.nl(true);
                return;
            } else {
                if (!this.kwS) {
                    this.kwS = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.kxq != null) {
            this.kxq.bXw();
        }
    }

    private void cQe() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dhK().fs(this.mActivity);
        }
    }

    public void cQf() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.aii.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jaC);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.Yx);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jay);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kxH);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kxI);
        this.jaq.stop();
        jau.unregister(this.mActivity);
    }

    public void Ku(String str) {
        this.jac.setText(str);
    }

    public boolean cuf() {
        return this.Yr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQg() {
        if (this.iZV != null) {
            if (this.kxd) {
                cQk();
            } else {
                cQj();
            }
        }
    }

    public void cuj() {
        cQj();
        cQh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQh() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jaC);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.jaC, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQi() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jaC);
    }

    public void cQj() {
        if (this.iZV != null && !this.kxd && !this.kxF) {
            tr(true);
            cui();
            this.iZV.setVisibility(0);
            this.kwV.setVisibility(0);
            this.kwU.setVisibility(8);
            this.kxd = true;
            if (this.kxh != null) {
                this.kxh.nm(false);
            }
        }
    }

    public void cug() {
        if (this.iZV != null && this.kxd) {
            tr(false);
            cui();
            this.iZV.setVisibility(8);
            this.kwV.setVisibility(8);
            this.kwU.setVisibility(0);
            this.hta.setAnimationListener(this.jaA);
            this.iZV.startAnimation(this.hta);
            this.kxd = false;
            if (this.kxh != null) {
                this.kxh.bXy();
            }
        }
    }

    public void cQk() {
        if (this.iZV != null && this.kxd) {
            this.boW.cancel();
            this.hta.cancel();
            tr(false);
            cui();
            this.iZV.setVisibility(8);
            this.kwV.setVisibility(8);
            this.kwU.setVisibility(0);
            this.kxd = false;
            if (this.kxh != null) {
                this.kxh.bXy();
            }
        }
    }

    private void cui() {
        if (this.iZV != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jaC);
            this.boW.setAnimationListener(null);
            this.hta.setAnimationListener(null);
            this.iZV.clearAnimation();
        }
    }

    private void cQl() {
        if (this.iZV != null) {
            this.boW.setAnimationListener(null);
            this.hta.setAnimationListener(null);
            this.iZV.clearAnimation();
        }
    }

    public void tr(boolean z) {
        cQm();
        if (z) {
            this.kwW.setVisibility(0);
        } else {
            this.kwW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQm() {
        if (this.currentState == 1) {
            this.kwW.setState(1);
        } else {
            this.kwW.setState(0);
        }
    }

    public void a(InterfaceC0703c interfaceC0703c) {
        this.kxg = interfaceC0703c;
    }

    public void yQ(int i2) {
        this.mStartPosition = i2;
    }

    public void an(boolean z, boolean z2) {
        if (this.jaq != null) {
            if (this.iZU != null) {
                this.iZU.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.iZO != null && (this.iZO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZO.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.iZO.setLayoutParams(layoutParams);
            }
            this.jaq.cc(z);
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
        this.kxE = z;
    }

    public void a(m mVar) {
        this.kxn = mVar;
    }

    public void a(a aVar) {
        this.kxo = aVar;
    }

    public void a(n nVar) {
        this.kxp = nVar;
    }

    public void a(l lVar) {
        this.kxq = lVar;
    }

    public void a(f fVar) {
        this.kxr = fVar;
    }

    public void tt(boolean z) {
        this.kxy = z;
    }

    public void tu(boolean z) {
        this.kxe = z;
    }

    public void BF(int i2) {
        this.kxC = i2;
    }

    public View cQn() {
        return this.iZM;
    }

    public void a(p pVar) {
        this.kby = pVar;
    }

    public void cQo() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dIF.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.dIF.getPageActivity());
    }
}
