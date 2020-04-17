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
    private static int iLo;
    private static CallStateReceiver iLp;
    private boolean XY;
    private int XZ;
    private Runnable Ye;
    protected boolean Yk;
    private View aWU;
    private TbImageView ahB;
    private String ahL;
    private Animation bht;
    private int currentState;
    private TbPageContext<?> duG;
    private SeekBar.OnSeekBarChangeListener eAp;
    private com.baidu.tieba.play.o eEE;
    private String eQf;
    private QuickVideoView.b emE;
    private w emv;
    private g.a evE;
    private g.f evF;
    private g.e evH;
    private g.InterfaceC0630g evI;
    private VideoLoadingProgressView.a gpc;
    protected View grH;
    private Animation heg;
    public View iKI;
    private VideoListMediaControllerView iKK;
    private View iKL;
    private FrameLayout iKM;
    protected FrameLayout.LayoutParams iKN;
    private ImageView iKQ;
    private View iKR;
    private View iKT;
    private g.f iKV;
    private ImageView iKX;
    private TextView iKY;
    private View iLc;
    private View iLd;
    private TextView iLe;
    private SeekBar iLf;
    private ImageView iLg;
    private ImageView iLh;
    private int iLi;
    private int iLj;
    private int iLk;
    private int iLm;
    private int iLn;
    private boolean iLq;
    private g.b iLs;
    protected Runnable iLt;
    private Animation.AnimationListener iLv;
    private Animation.AnimationListener iLw;
    private Runnable iLx;
    private CustomMessageListener iLy;
    private VideoControllerView.b iNt;
    private p jJJ;
    private i jJV;
    private String jJv;
    private boolean keY;
    protected com.baidu.tieba.play.a.a keZ;
    private boolean kfA;
    private boolean kfB;
    private boolean kfC;
    private TextView kfD;
    private boolean kfE;
    private boolean kfF;
    private boolean kfG;
    private boolean kfH;
    private int kfI;
    private boolean kfJ;
    private boolean kfK;
    private boolean kfL;
    private boolean kfM;
    private Runnable kfN;
    private Runnable kfO;
    private QuickVideoView.a kfP;
    private ProgressBar kfa;
    private View kfb;
    private SwitchImageView kfc;
    private TextView kfd;
    private TextView kfe;
    private TextView kff;
    private int kfg;
    private g.a kfh;
    private g.b kfi;
    private boolean kfj;
    private boolean kfk;
    private View.OnClickListener kfl;
    protected InterfaceC0629c kfm;
    private d kfn;
    private long kfo;
    private o kfp;
    private h kfq;
    private j kfr;
    private k kfs;
    private m kft;
    private a kfu;
    private n kfv;
    private l kfw;
    private f kfx;
    private g kfy;
    private boolean kfz;
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
    public interface InterfaceC0629c {
        void pG();

        void pH();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bRd();

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
        void cDw();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bRe();
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
        void bRb();

        void bRc();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cDx();

        boolean cDy();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void AW(int i);

        void cJt();

        void cJu();

        void onPaused();

        void onPrepared();

        void onStarted();

        void yv();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cDv();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.XZ = 100;
        this.keY = false;
        this.Yk = false;
        this.XY = false;
        this.kfj = false;
        this.kfk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.iLj = 0;
        this.iLk = 0;
        this.kfo = 60000L;
        this.iLm = 0;
        this.iLq = false;
        this.kfz = true;
        this.kfA = true;
        this.kfB = false;
        this.kfC = false;
        this.jJv = null;
        this.currentState = -1;
        this.kfE = false;
        this.kfJ = true;
        this.kfL = false;
        this.kfM = false;
        this.evF = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iKK != null && c.this.keZ != null && c.this.keZ.getDuration() > 0) {
                    c.this.iKK.be(0, c.this.keZ.getDuration());
                }
                c.this.bEF();
                if (c.this.kfp != null) {
                    c.this.kfp.onPrepared();
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.pX();
                    return false;
                }
                return false;
            }
        };
        this.gpc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bEF();
            }
        };
        this.Ye = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Ye);
                if (c.this.ahB.getVisibility() != 8) {
                    if (c.this.keZ.getCurrentPosition() > c.this.XZ) {
                        c.this.pX();
                    } else {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Ye, 20L);
                    }
                }
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.keZ != null) {
                    int duration = c.this.keZ.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.XY = false;
                        c.this.kfH = false;
                        c.this.mStartPosition = 0;
                        c.this.cnt();
                        c.this.iKL.setVisibility(0);
                        c.this.kfa.setProgress(c.this.kfa.getMax());
                        c.this.XZ = 100;
                        if (c.this.kfh != null) {
                            c.this.kfh.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cIV()) {
                            ((QuickVideoView) c.this.keZ).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.sS(false);
                            c.this.sT(true);
                        } else {
                            c.this.cJn();
                            c.this.kfd.setVisibility(0);
                        }
                        if (!c.this.Yk && duration <= 150000) {
                            if (!c.this.kfE) {
                                if (c.this.kfr != null) {
                                    c.this.kfr.rZ(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.ahL, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cIV()) {
                                    ((QuickVideoView) c.this.keZ).setRecoveryState(5);
                                }
                                c.this.keZ.pause();
                                c.this.keZ.seekTo(0);
                            }
                        }
                        if (c.this.kfp != null) {
                            c.this.kfp.AW(c.this.kfa.getMax());
                            c.this.kfp.yv();
                        }
                    }
                }
            }
        };
        this.iLs = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.grH.setVisibility(0);
                c.this.emv.cKo();
                c.this.currentState = 4;
                if (c.this.cIV()) {
                    ((QuickVideoView) c.this.keZ).setRecoveryState(4);
                }
                if (c.this.kfi != null) {
                    c.this.kfi.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kfF = true;
                }
                if (c.this.kfp != null) {
                    c.this.kfp.cJt();
                }
                c.this.kfH = false;
                return true;
            }
        };
        this.iLt = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.keZ == null || !c.this.keZ.isPlaying()) {
                    c.this.grH.setVisibility(0);
                    c.this.emv.cKo();
                    if (c.this.kfp != null) {
                        c.this.kfp.cJt();
                    }
                }
            }
        };
        this.evI = new g.InterfaceC0630g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kfB) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfN, 200L);
                }
            }
        };
        this.kfN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.keZ == null || !c.this.kfB) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Ye, 200L);
                    c.this.kfB = false;
                } else if (c.this.mStartPosition != c.this.keZ.getCurrentPosition()) {
                    c.this.kfB = false;
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Ye, 20L);
                } else {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfN, 200L);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.XY = false;
                if (c.this.kfk) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfO, 300L);
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Ye);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLt);
            }
        };
        this.kfO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kfH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.jJJ != null) {
                    c.this.jJJ.cDv();
                }
                if (view2.getId() != c.this.grH.getId()) {
                    if (view2.getId() != c.this.kfc.getId()) {
                        if (view2.getId() == c.this.kfe.getId()) {
                            if (c.this.kfq != null) {
                                c.this.kfq.cDw();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kfd.getId()) {
                            if (c.this.kfr != null) {
                                c.this.kfr.rZ(false);
                            }
                            c.this.ev(c.this.mVideoUrl, c.this.ahL);
                            return;
                        } else if (view2.getId() == c.this.iKQ.getId()) {
                            int i2 = c.this.kfk ? 1 : 2;
                            if (c.this.Yk) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahL).cI("fid", c.this.eQf).af("obj_type", i2).af("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahL).cI("fid", c.this.eQf).af("obj_type", i2).af("obj_source", 1));
                            }
                            if (c.this.kfw != null) {
                                c.this.kfw.bRc();
                            }
                            if (c.this.cIX()) {
                                if (c.this.Yk) {
                                    c.this.cJb();
                                } else {
                                    c.this.cJa();
                                }
                                c.this.sP(c.this.Yk);
                                return;
                            }
                            c.this.Ff();
                            return;
                        } else if (view2.getId() != c.this.iKX.getId()) {
                            if (c.this.kfl != null) {
                                c.this.kfl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kfw != null) {
                                c.this.kfw.bRc();
                            }
                            if (c.this.cIX()) {
                                c.this.cJb();
                                c.this.sP(false);
                                return;
                            }
                            c.this.Ff();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cDo();
                    c.this.cJp();
                    if (c.this.currentState != 1) {
                        c.this.cJl();
                        c.this.cJm();
                    } else {
                        c.this.cnJ();
                    }
                    if (c.this.kfu != null) {
                        c.this.kfu.nv(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.keZ.stopPlayback();
                c.this.XY = false;
                c.this.cJg();
            }
        };
        this.iLv = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.iLw = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.iLx = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cnG();
            }
        };
        this.iLy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.asn();
                }
            }
        };
        this.iNt = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i2) {
                int duration;
                if (c.this.keZ != null && (duration = c.this.keZ.getDuration()) > 0 && c.this.kfa != null) {
                    c.this.kfa.setProgress((int) ((i2 * c.this.iKI.getWidth()) / duration));
                    if (c.this.kfp != null) {
                        c.this.kfp.AW((c.this.keZ.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eAp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cJl();
                c.this.sT(false);
                if (c.this.kfu != null) {
                    c.this.kfu.nv(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cnx() != null) {
                    c.this.yi(c.this.cnx().getSeekPosition());
                    if (!c.this.cnF()) {
                        c.this.cJg();
                    } else {
                        c.this.aso();
                        if (c.this.jJV != null) {
                            c.this.jJV.bRe();
                        }
                    }
                }
                c.this.sT(true);
                c.this.cJk();
                if (c.this.kfu != null) {
                    c.this.kfu.nv(true);
                }
                if (c.this.kfv != null) {
                    c.this.kfv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kfP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJs() {
                if (!c.this.kfE) {
                    c.this.emv.startLoading();
                    c.this.ahB.setVisibility(0);
                    c.this.kfc.setVisibility(8);
                    c.this.kfe.setVisibility(8);
                    c.this.kfd.setVisibility(8);
                    c.this.kff.setVisibility(8);
                    c.this.grH.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLt);
                    if (c.this.kfo > 0) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.iLt, c.this.kfo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.duG = tbPageContext;
            this.mRootView = view;
            this.kfJ = z;
            this.iKT = view;
            this.mActivity = this.duG.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.XZ = 100;
        this.keY = false;
        this.Yk = false;
        this.XY = false;
        this.kfj = false;
        this.kfk = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.iLj = 0;
        this.iLk = 0;
        this.kfo = 60000L;
        this.iLm = 0;
        this.iLq = false;
        this.kfz = true;
        this.kfA = true;
        this.kfB = false;
        this.kfC = false;
        this.jJv = null;
        this.currentState = -1;
        this.kfE = false;
        this.kfJ = true;
        this.kfL = false;
        this.kfM = false;
        this.evF = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iKK != null && c.this.keZ != null && c.this.keZ.getDuration() > 0) {
                    c.this.iKK.be(0, c.this.keZ.getDuration());
                }
                c.this.bEF();
                if (c.this.kfp != null) {
                    c.this.kfp.onPrepared();
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.pX();
                    return false;
                }
                return false;
            }
        };
        this.gpc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.bEF();
            }
        };
        this.Ye = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Ye);
                if (c.this.ahB.getVisibility() != 8) {
                    if (c.this.keZ.getCurrentPosition() > c.this.XZ) {
                        c.this.pX();
                    } else {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Ye, 20L);
                    }
                }
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.keZ != null) {
                    int duration = c.this.keZ.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.XY = false;
                        c.this.kfH = false;
                        c.this.mStartPosition = 0;
                        c.this.cnt();
                        c.this.iKL.setVisibility(0);
                        c.this.kfa.setProgress(c.this.kfa.getMax());
                        c.this.XZ = 100;
                        if (c.this.kfh != null) {
                            c.this.kfh.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cIV()) {
                            ((QuickVideoView) c.this.keZ).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.sS(false);
                            c.this.sT(true);
                        } else {
                            c.this.cJn();
                            c.this.kfd.setVisibility(0);
                        }
                        if (!c.this.Yk && duration <= 150000) {
                            if (!c.this.kfE) {
                                if (c.this.kfr != null) {
                                    c.this.kfr.rZ(true);
                                }
                                c.this.y(c.this.mVideoUrl, c.this.ahL, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cIV()) {
                                    ((QuickVideoView) c.this.keZ).setRecoveryState(5);
                                }
                                c.this.keZ.pause();
                                c.this.keZ.seekTo(0);
                            }
                        }
                        if (c.this.kfp != null) {
                            c.this.kfp.AW(c.this.kfa.getMax());
                            c.this.kfp.yv();
                        }
                    }
                }
            }
        };
        this.iLs = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.grH.setVisibility(0);
                c.this.emv.cKo();
                c.this.currentState = 4;
                if (c.this.cIV()) {
                    ((QuickVideoView) c.this.keZ).setRecoveryState(4);
                }
                if (c.this.kfi != null) {
                    c.this.kfi.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.kfF = true;
                }
                if (c.this.kfp != null) {
                    c.this.kfp.cJt();
                }
                c.this.kfH = false;
                return true;
            }
        };
        this.iLt = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.keZ == null || !c.this.keZ.isPlaying()) {
                    c.this.grH.setVisibility(0);
                    c.this.emv.cKo();
                    if (c.this.kfp != null) {
                        c.this.kfp.cJt();
                    }
                }
            }
        };
        this.evI = new g.InterfaceC0630g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0630g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.kfB) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfN, 200L);
                }
            }
        };
        this.kfN = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.keZ == null || !c.this.kfB) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Ye, 200L);
                    c.this.kfB = false;
                } else if (c.this.mStartPosition != c.this.keZ.getCurrentPosition()) {
                    c.this.kfB = false;
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.Ye, 20L);
                } else {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfN, 200L);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.XY = false;
                if (c.this.kfk) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(c.this.kfO, 300L);
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.Ye);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLt);
            }
        };
        this.kfO = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.kfH = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.jJJ != null) {
                    c.this.jJJ.cDv();
                }
                if (view2.getId() != c.this.grH.getId()) {
                    if (view2.getId() != c.this.kfc.getId()) {
                        if (view2.getId() == c.this.kfe.getId()) {
                            if (c.this.kfq != null) {
                                c.this.kfq.cDw();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.kfd.getId()) {
                            if (c.this.kfr != null) {
                                c.this.kfr.rZ(false);
                            }
                            c.this.ev(c.this.mVideoUrl, c.this.ahL);
                            return;
                        } else if (view2.getId() == c.this.iKQ.getId()) {
                            int i22 = c.this.kfk ? 1 : 2;
                            if (c.this.Yk) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahL).cI("fid", c.this.eQf).af("obj_type", i22).af("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cI("tid", c.this.ahL).cI("fid", c.this.eQf).af("obj_type", i22).af("obj_source", 1));
                            }
                            if (c.this.kfw != null) {
                                c.this.kfw.bRc();
                            }
                            if (c.this.cIX()) {
                                if (c.this.Yk) {
                                    c.this.cJb();
                                } else {
                                    c.this.cJa();
                                }
                                c.this.sP(c.this.Yk);
                                return;
                            }
                            c.this.Ff();
                            return;
                        } else if (view2.getId() != c.this.iKX.getId()) {
                            if (c.this.kfl != null) {
                                c.this.kfl.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.kfw != null) {
                                c.this.kfw.bRc();
                            }
                            if (c.this.cIX()) {
                                c.this.cJb();
                                c.this.sP(false);
                                return;
                            }
                            c.this.Ff();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.cDo();
                    c.this.cJp();
                    if (c.this.currentState != 1) {
                        c.this.cJl();
                        c.this.cJm();
                    } else {
                        c.this.cnJ();
                    }
                    if (c.this.kfu != null) {
                        c.this.kfu.nv(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.keZ.stopPlayback();
                c.this.XY = false;
                c.this.cJg();
            }
        };
        this.iLv = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.iLw = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.iLx = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cnG();
            }
        };
        this.iLy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.asn();
                }
            }
        };
        this.iNt = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ox(int i22) {
                int duration;
                if (c.this.keZ != null && (duration = c.this.keZ.getDuration()) > 0 && c.this.kfa != null) {
                    c.this.kfa.setProgress((int) ((i22 * c.this.iKI.getWidth()) / duration));
                    if (c.this.kfp != null) {
                        c.this.kfp.AW((c.this.keZ.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eAp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cJl();
                c.this.sT(false);
                if (c.this.kfu != null) {
                    c.this.kfu.nv(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.cnx() != null) {
                    c.this.yi(c.this.cnx().getSeekPosition());
                    if (!c.this.cnF()) {
                        c.this.cJg();
                    } else {
                        c.this.aso();
                        if (c.this.jJV != null) {
                            c.this.jJV.bRe();
                        }
                    }
                }
                c.this.sT(true);
                c.this.cJk();
                if (c.this.kfu != null) {
                    c.this.kfu.nv(true);
                }
                if (c.this.kfv != null) {
                    c.this.kfv.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.kfP = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cJs() {
                if (!c.this.kfE) {
                    c.this.emv.startLoading();
                    c.this.ahB.setVisibility(0);
                    c.this.kfc.setVisibility(8);
                    c.this.kfe.setVisibility(8);
                    c.this.kfd.setVisibility(8);
                    c.this.kff.setVisibility(8);
                    c.this.grH.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(c.this.iLt);
                    if (c.this.kfo > 0) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(c.this.iLt, c.this.kfo);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.duG = tbPageContext;
            this.mRootView = view;
            this.kfJ = z;
            this.iKT = view;
            this.mActivity = this.duG.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.iKI = ap(this.mActivity);
        this.iKI.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.iKI);
        }
        this.keZ = com.baidu.tieba.play.a.b.A(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.iKI).addView(this.keZ.getView(), 0);
        this.keZ.getView().setLayoutParams(layoutParams);
        this.emv = new w((ViewGroup) this.iKI.findViewById(R.id.auto_video_loading_container));
        this.emv.setLoadingAnimationListener(this.gpc);
        this.iKK = (VideoListMediaControllerView) this.iKI.findViewById(R.id.media_controller);
        this.iKK.setPlayer(this.keZ);
        this.kfa = (ProgressBar) this.iKI.findViewById(R.id.pgrBottomProgress);
        this.kfa.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.kfa.setProgress(0);
        this.iKK.setOnSeekBarChangeListener(this.eAp);
        this.iKK.setOnProgressUpdatedListener(this.iNt);
        this.iKL = this.iKI.findViewById(R.id.black_mask);
        this.grH = this.iKI.findViewById(R.id.layout_error);
        this.grH.setOnClickListener(this.mOnClickListener);
        this.kfD = (TextView) this.iKI.findViewById(R.id.auto_video_error_tips);
        this.iKM = (FrameLayout) this.iKI.findViewById(R.id.danmu_container);
        this.iKQ = (ImageView) this.iKI.findViewById(R.id.img_full_screen);
        this.iKQ.setOnClickListener(this.mOnClickListener);
        this.iKR = this.iKI.findViewById(R.id.layout_media_controller);
        this.kfb = this.iKI.findViewById(R.id.time_show_controller);
        this.keZ.setContinuePlayEnable(true);
        this.keZ.setOnPreparedListener(this.evF);
        this.keZ.setOnCompletionListener(this.evE);
        this.keZ.setOnErrorListener(this.iLs);
        this.keZ.setOnSeekCompleteListener(this.evI);
        this.keZ.setOnOutInfoListener(this.evH);
        this.keZ.setOnSurfaceDestroyedListener(this.emE);
        if (cIV()) {
            ((QuickVideoView) this.keZ).setOnRecoveryCallback(this.kfP);
        }
        this.kfc = (SwitchImageView) this.iKI.findViewById(R.id.img_play_controller);
        this.kfc.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.kfc.setState(0);
        this.kfc.setOnClickListener(this.mOnClickListener);
        this.kfd = (TextView) this.iKI.findViewById(R.id.txt_replay);
        this.kfd.setOnClickListener(this.mOnClickListener);
        this.kfe = (TextView) this.iKI.findViewById(R.id.txt_playnext);
        this.kfe.setOnClickListener(this.mOnClickListener);
        this.kff = (TextView) this.iKI.findViewById(R.id.txt_next_video_title);
        this.ahB = (TbImageView) this.iKI.findViewById(R.id.video_thumbnail);
        this.ahB.setDefaultErrorResource(0);
        this.ahB.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.iKX = (ImageView) this.iKI.findViewById(R.id.img_exit);
        this.iKX.setOnClickListener(this.mOnClickListener);
        this.iKY = (TextView) this.iKI.findViewById(R.id.video_title);
        this.aWU = this.iKI.findViewById(R.id.layout_title);
        this.aWU.setVisibility(8);
        this.heg = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bht = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.iLi = this.mAudioManager.getStreamMaxVolume(3);
        this.iLn = this.mAudioManager.getStreamVolume(3);
        iLo = 100 / this.iLi;
        this.iKI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.kfs != null) {
                    c.this.kfs.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.XY) {
                        if (c.this.mStatus == 1 && c.this.iLk != 0) {
                            c.this.b(c.this.iLk == 1 ? 1000.0f : -1000.0f, false);
                            c.this.iLk = 0;
                            c.this.iLj = 0;
                        }
                        if (!c.this.keZ.isPlaying()) {
                            c.this.kfe.setVisibility(8);
                            c.this.kfd.setVisibility(8);
                            c.this.kff.setVisibility(8);
                        }
                    }
                    c.this.cnt();
                    if (c.this.kfs != null) {
                        c.this.kfs.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.eEE = new com.baidu.tieba.play.o(this.mActivity);
        if (this.kfJ) {
            this.eEE.start();
        }
        this.iLm = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (iLp == null) {
            iLp = new CallStateReceiver();
        }
        iLp.register(this.mActivity);
        cIW();
        MessageManager.getInstance().registerListener(this.iLy);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.iLy);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void AS(int i2) {
        if (this.ahB != null) {
            this.ahB.setDefaultBgResource(i2);
        }
    }

    public boolean cIV() {
        return this.mVideoType == 0 && (this.keZ instanceof QuickVideoView);
    }

    public void cIW() {
        if (this.kfz) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.iKI.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.iKI.setSystemUiVisibility(0);
    }

    public void sN(boolean z) {
        this.kfz = z;
        cIW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnt() {
        this.mStatus = 0;
        if (this.iLc != null && this.iLc.getParent() != null && (this.iLc.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.iLc.getParent()).removeView(this.iLc);
                this.iLc = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.iLd != null && this.iLd.getParent() != null && (this.iLd.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.iLd.getParent()).removeView(this.iLd);
                this.iLd = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cnu() {
        if (this.mStatus == 1) {
            if (this.iLc == null && this.iKI != null && (this.iKI instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.iKI, true);
                this.iLc = this.iKI.findViewById(R.id.lay_jindu);
                this.iLe = (TextView) this.iLc.findViewById(R.id.show_time);
                this.iLh = (ImageView) this.iLc.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.iLd == null && this.iKI != null && (this.iKI instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.iKI, true);
            this.iLd = this.iKI.findViewById(R.id.lay_voice);
            this.iLg = (ImageView) this.iLd.findViewById(R.id.arrow_voice_icon);
            this.iLf = (SeekBar) this.iLd.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Z(View.OnClickListener onClickListener) {
        this.kfl = onClickListener;
    }

    public void sO(boolean z) {
        this.kfk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.kfs != null) {
                c.this.kfs.onStart();
            }
            if (c.this.Yk && c.this.XY) {
                if (c.this.mStatus == 1) {
                    c.this.cJn();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.am(f2);
                    }
                } else {
                    if (c.this.Yk) {
                        c.this.cnw();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.iLj = c.this.keZ.getCurrentPosition();
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
            if (!c.this.kfK) {
                if (c.this.kft != null && c.this.kft.cDx()) {
                    return true;
                }
                c.this.cDo();
                c.this.cJp();
                if (c.this.keZ.isPlaying()) {
                    c.this.cJk();
                } else {
                    c.this.cJl();
                }
                if (c.this.kfu != null) {
                    c.this.kfu.nv(c.this.keZ.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.kfK) {
                if (c.this.XY) {
                    if (c.this.kft != null && c.this.kft.cDy()) {
                        return true;
                    }
                    c.this.cJj();
                    if (c.this.keZ.isPlaying()) {
                        c.this.cJk();
                    } else {
                        c.this.cJl();
                    }
                    if (c.this.kfu != null) {
                        c.this.kfu.nv(c.this.keZ.isPlaying());
                    }
                } else {
                    c.this.cDo();
                    c.this.cJp();
                    if (c.this.currentState != 1) {
                        c.this.cJl();
                        c.this.cJm();
                    } else {
                        c.this.cnJ();
                    }
                    if (c.this.kfu != null) {
                        c.this.kfu.nv(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnw() {
        if (Build.VERSION.SDK_INT < 16) {
            this.iKI.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.iKI.setSystemUiVisibility(4);
        } else {
            this.iKI.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(float f2) {
        if (!this.XY) {
            this.mStatus = 0;
            return;
        }
        cnu();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % iLo == 0) {
            if (f2 > 0.0f && this.iLn < this.iLi) {
                this.iLn++;
            }
            if (f2 < 0.0f && this.iLn > 0) {
                this.iLn--;
            }
        }
        if (this.mProgress > 0) {
            this.iLg.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.iLg.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.iLn, 0);
        this.iLf.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.iLj -= 1000;
                this.iLk = 1;
            } else {
                this.iLj += 1000;
                this.iLk = 2;
            }
            if (this.iLj < 0) {
                this.iLj = 0;
            } else if (this.iLj > this.keZ.getDuration()) {
                this.iLj = this.keZ.getDuration();
            }
        }
        cnu();
        String Bc = this.iKK.Bc(this.iLj);
        if (f2 > 0.0f) {
            this.iLh.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.iLh.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Bc)) {
            this.iLe.setText(new StringBuilder().append(Bc).append("/").append(this.iKK.Bc(this.keZ.getDuration())));
        }
        this.iKK.setCurrentDuration(this.iLj, z ? false : true);
        cJn();
        cJc();
    }

    protected View ap(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void AT(int i2) {
        this.kfg = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ahL = str2;
    }

    public void setFid(String str) {
        this.eQf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.keZ != null && this.iKK != null) {
            this.iKK.showProgress();
            this.mStartPosition = x.cKr().IL(this.mVideoUrl);
            if (this.kfH) {
                this.keZ.setVolume(1.0f, 1.0f);
                this.keZ.start();
                this.kfH = false;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Ye);
                com.baidu.adp.lib.f.e.lb().postDelayed(this.Ye, 20L);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLt);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfO);
                if (this.keZ.cJN()) {
                    this.currentState = 1;
                    if (cIV()) {
                        ((QuickVideoView) this.keZ).setRecoveryState(1);
                    }
                    cJn();
                }
                this.mStartPosition = x.cKr().IL(this.mVideoUrl);
                this.iKK.setPlayer(this.keZ);
                if (this.mStartPosition != 0) {
                    this.kfB = true;
                }
                if (!this.kfG) {
                    this.iKK.showProgress();
                }
                if (!this.kfk && this.keZ.getDuration() <= 0) {
                    cnx().setVisibility(4);
                }
            }
            this.XZ = (this.mStartPosition <= 100 || this.keZ.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX() {
        if (this.ahB.getVisibility() != 8 || !this.XY) {
            this.XY = true;
            this.iKL.setVisibility(8);
            this.grH.setVisibility(8);
            this.emv.cKn();
            this.ahB.setVisibility(8);
            cJo();
            long duration = this.keZ.getDuration() / 1000;
            String str = this.ahL;
            this.iKK.showProgress();
            this.kfa.setVisibility(0);
            if (this.iKV != null && cIV()) {
                this.iKV.onPrepared(((QuickVideoView) this.keZ).getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.kfb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kfb.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.kfb.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.kfb.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.kfb.setLayoutParams(layoutParams);
        }
    }

    public void cDo() {
        if (this.keZ.isPlaying()) {
            asn();
            if (this.kfy != null) {
                this.kfy.onPause();
            }
            if (this.kfp != null) {
                this.kfp.onPaused();
            }
        } else if (this.XY) {
            aso();
            if (this.jJV != null) {
                this.jJV.bRe();
            }
            if (this.kfp != null) {
                this.kfp.cJu();
            }
        } else {
            cJg();
        }
    }

    public void Ff() {
        this.iLq = true;
        if (this.eEE != null) {
            this.eEE.Ff();
        }
    }

    public boolean cIX() {
        return this.keZ != null && this.keZ.getView().getHeight() > this.keZ.getView().getWidth();
    }

    public void cIY() {
        sP(false);
        cJb();
    }

    public boolean AU(int i2) {
        switch (i2) {
            case 4:
                if (this.Yk) {
                    if (cIX()) {
                        sP(false);
                        cJb();
                    } else {
                        Ff();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.iLi <= 0 || this.iLf == null) {
                    return false;
                }
                this.iLn = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.iLn * 100.0d) / this.iLi);
                this.iLf.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cIV()) {
            return (QuickVideoView) this.keZ;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cIZ() {
        return this.keZ;
    }

    public VideoListMediaControllerView cnx() {
        return this.iKK;
    }

    public void show() {
        this.iKI.setVisibility(0);
    }

    public void cnB() {
        if (this.iKT != null) {
            ViewGroup.LayoutParams layoutParams = this.iKT.getLayoutParams();
            this.iKN = (FrameLayout.LayoutParams) this.iKI.getLayoutParams();
            this.iKN.width = layoutParams.width;
            this.iKN.height = layoutParams.height;
            this.iKN.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.iKI.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.iKI.setLayoutParams(this.iKN);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.iLq) {
            if (this.Yk) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.iLq = false;
        }
        if (configuration.orientation == 2) {
            cJa();
        } else {
            cJb();
        }
        cJc();
        if (this.mActivity == com.baidu.adp.base.a.jm().currentActivity()) {
            aso();
        }
        cJp();
        cnJ();
        if (this.kfu != null) {
            this.kfu.nv(true);
        }
    }

    protected void cJa() {
        this.Yk = true;
        if (cIX()) {
            this.iKI.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.iKI.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.aWU.setVisibility(0);
        this.iKX.setVisibility(0);
        this.iKY.setVisibility(0);
        this.iKM.setVisibility(8);
        this.emv.cKo();
        this.ahB.setVisibility(8);
        this.iKQ.setImageResource(R.drawable.icon_video_narrow_white);
        yf(this.iLm);
        cnw();
        if (this.kfm != null) {
            this.kfm.pG();
        }
    }

    protected void cJb() {
        this.Yk = false;
        if (this.iKN != null) {
            this.iKI.setLayoutParams(this.iKN);
        }
        g(this.mActivity, false);
        this.aWU.setVisibility(8);
        this.iKM.setVisibility(0);
        this.emv.cKo();
        this.ahB.setVisibility(8);
        this.iKQ.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.iKK != null && (this.iKK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKK.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.iKK.setLayoutParams(layoutParams);
        }
        this.iKI.setSystemUiVisibility(0);
        cIW();
        if (this.kfm != null) {
            this.kfm.pH();
        }
    }

    public void cJc() {
        if (this.keZ != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.Yk) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.kfa.setMax(equipmentWidth);
            int duration = this.keZ.getDuration();
            if (duration > 0) {
                if (this.kfd.getVisibility() == 0) {
                    this.kfa.setProgress(this.kfa.getMax());
                } else {
                    this.kfa.setProgress((int) ((this.keZ.getCurrentPositionSync() * this.kfa.getMax()) / duration));
                }
            }
        }
    }

    private void yf(int i2) {
        if (this.iKK != null && (this.iKK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKK.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.iKK.setLayoutParams(layoutParams);
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

    public boolean cnD() {
        return !this.Yk;
    }

    public void a(g.f fVar) {
        this.iKV = fVar;
    }

    public void a(g.a aVar) {
        this.kfh = aVar;
    }

    public void a(g.b bVar) {
        this.kfi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.kfC) {
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
        cJh();
        this.kfH = true;
        this.currentState = 0;
        if (cIV()) {
            ((QuickVideoView) this.keZ).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.keZ.setVideoDuration(this.kfg);
        this.keZ.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLt);
        if (this.kfo > 0) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.iLt, this.kfo);
        }
        if (this.kfp != null) {
            this.kfp.onStarted();
        }
        this.emv.startLoading();
        sQ(z);
    }

    public void ev(String str, String str2) {
        y(str, str2, true);
    }

    public void ew(String str, String str2) {
        cJh();
        this.kfH = true;
        this.currentState = 0;
        if (cIV()) {
            ((QuickVideoView) this.keZ).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLt);
        if (this.kfo > 0) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.iLt, this.kfo);
        }
        if (this.kfp != null) {
            this.kfp.onStarted();
        }
        this.emv.startLoading();
        sQ(true);
    }

    public void cJd() {
        aso();
        this.kfa.setVisibility(0);
    }

    public void aso() {
        if (this.keZ != null && this.iKK != null) {
            this.XY = true;
            this.currentState = 1;
            if (cIV()) {
                ((QuickVideoView) this.keZ).setRecoveryState(1);
            }
            this.keZ.a(null);
            this.mStartPosition = x.cKr().IL(this.mVideoUrl);
            this.kfB = true;
            this.XZ = (this.mStartPosition <= 100 || this.keZ.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.emv.cKo();
            sQ(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.kfF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ahL)) {
            this.kfF = false;
            this.kfG = true;
            ev(this.mVideoUrl, this.ahL);
        }
    }

    private void sQ(boolean z) {
        if (z) {
            this.ahB.setVisibility(0);
            cJn();
            this.kfa.setProgress(0);
        } else {
            this.ahB.setVisibility(8);
            cJn();
        }
        this.iKK.showProgress();
        this.iKL.setVisibility(8);
        this.kfe.setVisibility(8);
        this.kfd.setVisibility(8);
        this.kff.setVisibility(8);
        this.grH.setVisibility(8);
    }

    private void cJe() {
        this.emv.cKo();
        this.kfe.setVisibility(8);
        this.kfd.setVisibility(8);
        this.kff.setVisibility(8);
        cJp();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.keZ instanceof QuickVideoView) {
            ((QuickVideoView) this.keZ).setNeedRecovery(z);
        }
    }

    public void asn() {
        this.keZ.pause();
        this.currentState = 2;
        if (cIV()) {
            ((QuickVideoView) this.keZ).setRecoveryState(2);
        }
        cJe();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cIV()) {
            ((QuickVideoView) this.keZ).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Ye);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLt);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfO);
        this.keZ.stopPlayback();
        this.XY = false;
        this.kfH = false;
        this.mStartPosition = 0;
        caH();
    }

    public void cJf() {
        if (this.keZ.getDuration() >= this.keZ.getCurrentPosition()) {
            x.cKr().bv(this.mVideoUrl, this.keZ.getCurrentPosition());
        }
    }

    public void sR(boolean z) {
        this.kfA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        if (this.iKR != null) {
            this.iKL.setVisibility(0);
            this.kfe.setVisibility(8);
            this.kfd.setVisibility(8);
            this.kff.setVisibility(8);
            this.emv.cKo();
            cJn();
            this.kfa.setVisibility(8);
            this.grH.setVisibility(8);
            this.iKK.asx();
            this.ahB.setVisibility(z ? 0 : 8);
        }
    }

    public void caH() {
        sS(true);
    }

    public boolean pI() {
        if (this.keZ == null) {
            return false;
        }
        return this.keZ.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.keZ == null) {
            return 0;
        }
        return this.keZ.getCurrentPosition();
    }

    public void a(k kVar) {
        this.kfs = kVar;
    }

    public void a(j jVar) {
        this.kfr = jVar;
    }

    public void a(i iVar) {
        this.jJV = iVar;
    }

    public void a(g gVar) {
        this.kfy = gVar;
    }

    public void a(h hVar) {
        this.kfq = hVar;
    }

    public void Ie(String str) {
        this.jJv = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJg() {
        a(this.mVideoUrl, this.ahL, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.kfn = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cJh();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.day().daz()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.kfC = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.kfx != null) {
                    this.kfx.mQ(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.uf(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cJi();
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
                aVar.b(this.duG).aMU();
                return;
            } else if (this.kfx != null) {
                this.kfx.mQ(true);
                return;
            } else {
                if (!this.keY) {
                    this.keY = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.kfw != null) {
            this.kfw.bRb();
        }
    }

    private void cJh() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.day().fp(this.mActivity);
        }
    }

    public void cJi() {
        com.baidu.tbadk.core.sharedPref.b.aNV().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.ahB.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Ye);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLt);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfN);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kfO);
        this.eEE.stop();
        iLp.unregister(this.mActivity);
    }

    public void IF(String str) {
        this.iKY.setText(str);
    }

    public boolean cnF() {
        return this.XY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJj() {
        if (this.iKR != null) {
            if (this.kfj) {
                cJn();
            } else {
                cJm();
            }
        }
    }

    public void cnJ() {
        cJm();
        cJk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJk() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.iLx, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJl() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
    }

    public void cJm() {
        if (this.iKR != null && !this.kfj && !this.kfL) {
            sT(true);
            cnI();
            this.iKR.setVisibility(0);
            this.kfb.setVisibility(0);
            this.kfa.setVisibility(8);
            this.kfj = true;
            if (this.kfn != null) {
                this.kfn.mR(false);
            }
        }
    }

    public void cnG() {
        if (this.iKR != null && this.kfj) {
            sT(false);
            cnI();
            this.iKR.setVisibility(8);
            this.kfb.setVisibility(8);
            this.kfa.setVisibility(0);
            this.heg.setAnimationListener(this.iLv);
            this.iKR.startAnimation(this.heg);
            this.kfj = false;
            if (this.kfn != null) {
                this.kfn.bRd();
            }
        }
    }

    public void cJn() {
        if (this.iKR != null && this.kfj) {
            this.bht.cancel();
            this.heg.cancel();
            sT(false);
            cnI();
            this.iKR.setVisibility(8);
            this.kfb.setVisibility(8);
            this.kfa.setVisibility(0);
            this.kfj = false;
            if (this.kfn != null) {
                this.kfn.bRd();
            }
        }
    }

    private void cnI() {
        if (this.iKR != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iLx);
            this.bht.setAnimationListener(null);
            this.heg.setAnimationListener(null);
            this.iKR.clearAnimation();
        }
    }

    private void cJo() {
        if (this.iKR != null) {
            this.bht.setAnimationListener(null);
            this.heg.setAnimationListener(null);
            this.iKR.clearAnimation();
        }
    }

    public void sT(boolean z) {
        cJp();
        if (z) {
            this.kfc.setVisibility(0);
        } else {
            this.kfc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJp() {
        if (this.currentState == 1) {
            this.kfc.setState(1);
        } else {
            this.kfc.setState(0);
        }
    }

    public void a(InterfaceC0629c interfaceC0629c) {
        this.kfm = interfaceC0629c;
    }

    public void yi(int i2) {
        this.mStartPosition = i2;
    }

    public void ak(boolean z, boolean z2) {
        if (this.eEE != null) {
            if (this.iKQ != null) {
                this.iKQ.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.iKK != null && (this.iKK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKK.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.iKK.setLayoutParams(layoutParams);
            }
            this.eEE.bS(z);
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
        this.kfK = z;
    }

    public void a(m mVar) {
        this.kft = mVar;
    }

    public void a(a aVar) {
        this.kfu = aVar;
    }

    public void a(n nVar) {
        this.kfv = nVar;
    }

    public void a(l lVar) {
        this.kfw = lVar;
    }

    public void a(f fVar) {
        this.kfx = fVar;
    }

    public void sV(boolean z) {
        this.kfE = z;
    }

    public void sW(boolean z) {
        this.kfk = z;
    }

    public void AV(int i2) {
        this.kfI = i2;
    }

    public View cJq() {
        return this.iKI;
    }

    public void a(p pVar) {
        this.jJJ = pVar;
    }

    public void cJr() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duG.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.duG.getPageActivity());
    }
}
