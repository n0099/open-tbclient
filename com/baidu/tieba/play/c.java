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
    private static int ibu;
    private static CallStateReceiver ibv;
    private boolean EI;
    private int EJ;
    private Runnable EO;
    protected boolean EV;
    private TbImageView OZ;
    private String Pk;
    private View aDn;
    private Animation aLM;
    private TbPageContext<?> cVv;
    private int currentState;
    private w dME;
    private QuickVideoView.b dMN;
    private g.a dVF;
    private g.f dVG;
    private g.e dVI;
    private g.InterfaceC0591g dVJ;
    private SeekBar.OnSeekBarChangeListener eaC;
    private com.baidu.tieba.play.o eeN;
    private String emF;
    private VideoLoadingProgressView.a fKw;
    protected View fNa;
    private Animation guV;
    private p iZB;
    private i iZN;
    private String iZn;
    public View iaO;
    private VideoListMediaControllerView iaQ;
    private View iaR;
    private FrameLayout iaS;
    protected FrameLayout.LayoutParams iaT;
    private ImageView iaW;
    private View iaX;
    private View iaZ;
    private Animation.AnimationListener ibB;
    private Animation.AnimationListener ibC;
    private Runnable ibD;
    private CustomMessageListener ibE;
    private g.f ibb;
    private ImageView ibd;
    private TextView ibe;
    private View ibi;
    private View ibj;
    private TextView ibk;
    private SeekBar ibl;
    private ImageView ibm;
    private ImageView ibn;
    private int ibo;
    private int ibp;
    private int ibq;
    private int ibs;
    private int ibt;
    private boolean ibw;
    private g.b iby;
    protected Runnable ibz;
    private VideoControllerView.b idC;
    private a jvA;
    private n jvB;
    private l jvC;
    private f jvD;
    private g jvE;
    private boolean jvF;
    private boolean jvG;
    private boolean jvH;
    private boolean jvI;
    private TextView jvJ;
    private boolean jvK;
    private boolean jvL;
    private boolean jvM;
    private boolean jvN;
    private int jvO;
    private boolean jvP;
    private boolean jvQ;
    private boolean jvR;
    private boolean jvS;
    private Runnable jvT;
    private Runnable jvU;
    private QuickVideoView.a jvV;
    private boolean jve;
    protected com.baidu.tieba.play.a.a jvf;
    private ProgressBar jvg;
    private View jvh;
    private SwitchImageView jvi;
    private TextView jvj;
    private TextView jvk;
    private TextView jvl;
    private int jvm;
    private g.a jvn;
    private g.b jvo;
    private boolean jvp;
    private boolean jvq;
    private View.OnClickListener jvr;
    protected InterfaceC0590c jvs;
    private d jvt;
    private long jvu;
    private o jvv;
    private h jvw;
    private j jvx;
    private k jvy;
    private m jvz;
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
        void mr(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0590c {
        void lc();

        void ld();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bGC();

        void lN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void rT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void lM(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void csQ();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bGD();
    }

    /* loaded from: classes.dex */
    public interface j {
        void qV(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bGA();

        void bGB();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean csR();

        boolean csS();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Aw(int i);

        void cyO();

        void cyP();

        void onPaused();

        void onPrepared();

        void onStarted();

        void ub();
    }

    /* loaded from: classes.dex */
    public interface p {
        void csP();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jve = false;
        this.EV = false;
        this.EI = false;
        this.jvp = false;
        this.jvq = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.ibp = 0;
        this.ibq = 0;
        this.jvu = 60000L;
        this.ibs = 0;
        this.ibw = false;
        this.jvF = true;
        this.jvG = true;
        this.jvH = false;
        this.jvI = false;
        this.iZn = null;
        this.currentState = -1;
        this.jvK = false;
        this.jvP = true;
        this.jvR = false;
        this.jvS = false;
        this.dVG = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iaQ != null && c.this.jvf != null && c.this.jvf.getDuration() > 0) {
                    c.this.iaQ.ba(0, c.this.jvf.getDuration());
                }
                c.this.buT();
                if (c.this.jvv != null) {
                    c.this.jvv.onPrepared();
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fKw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buT();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OZ.getVisibility() != 8) {
                    if (c.this.jvf.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jvf != null) {
                    int duration = c.this.jvf.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.jvN = false;
                        c.this.mStartPosition = 0;
                        c.this.ccS();
                        c.this.iaR.setVisibility(0);
                        c.this.jvg.setProgress(c.this.jvg.getMax());
                        c.this.EJ = 100;
                        if (c.this.jvn != null) {
                            c.this.jvn.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cyq()) {
                            ((QuickVideoView) c.this.jvf).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rO(false);
                            c.this.rP(true);
                        } else {
                            c.this.cyI();
                            c.this.jvj.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jvK) {
                                if (c.this.jvx != null) {
                                    c.this.jvx.qV(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pk, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cyq()) {
                                    ((QuickVideoView) c.this.jvf).setRecoveryState(5);
                                }
                                c.this.jvf.pause();
                                c.this.jvf.seekTo(0);
                            }
                        }
                        if (c.this.jvv != null) {
                            c.this.jvv.Aw(c.this.jvg.getMax());
                            c.this.jvv.ub();
                        }
                    }
                }
            }
        };
        this.iby = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
                c.this.fNa.setVisibility(0);
                c.this.dME.czJ();
                c.this.currentState = 4;
                if (c.this.cyq()) {
                    ((QuickVideoView) c.this.jvf).setRecoveryState(4);
                }
                if (c.this.jvo != null) {
                    c.this.jvo.onError(gVar, i2, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jvL = true;
                }
                if (c.this.jvv != null) {
                    c.this.jvv.cyO();
                }
                c.this.jvN = false;
                return true;
            }
        };
        this.ibz = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jvf == null || !c.this.jvf.isPlaying()) {
                    c.this.fNa.setVisibility(0);
                    c.this.dME.czJ();
                    if (c.this.jvv != null) {
                        c.this.jvv.cyO();
                    }
                }
            }
        };
        this.dVJ = new g.InterfaceC0591g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jvH) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jvT, 200L);
                }
            }
        };
        this.jvT = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jvf == null || !c.this.jvH) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jvH = false;
                } else if (c.this.mStartPosition != c.this.jvf.getCurrentPosition()) {
                    c.this.jvH = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jvT, 200L);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jvq) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jvU, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.ibz);
            }
        };
        this.jvU = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jvN = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iZB != null) {
                    c.this.iZB.csP();
                }
                if (view2.getId() != c.this.fNa.getId()) {
                    if (view2.getId() != c.this.jvi.getId()) {
                        if (view2.getId() == c.this.jvk.getId()) {
                            if (c.this.jvw != null) {
                                c.this.jvw.csQ();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jvj.getId()) {
                            if (c.this.jvx != null) {
                                c.this.jvx.qV(false);
                            }
                            c.this.eg(c.this.mVideoUrl, c.this.Pk);
                            return;
                        } else if (view2.getId() == c.this.iaW.getId()) {
                            int i2 = c.this.jvq ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cx("tid", c.this.Pk).cx("fid", c.this.emF).X("obj_type", i2).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cx("tid", c.this.Pk).cx("fid", c.this.emF).X("obj_type", i2).X("obj_source", 1));
                            }
                            if (c.this.jvC != null) {
                                c.this.jvC.bGB();
                            }
                            if (c.this.cys()) {
                                if (c.this.EV) {
                                    c.this.cyw();
                                } else {
                                    c.this.cyv();
                                }
                                c.this.rL(c.this.EV);
                                return;
                            }
                            c.this.Ah();
                            return;
                        } else if (view2.getId() != c.this.ibd.getId()) {
                            if (c.this.jvr != null) {
                                c.this.jvr.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jvC != null) {
                                c.this.jvC.bGB();
                            }
                            if (c.this.cys()) {
                                c.this.cyw();
                                c.this.rL(false);
                                return;
                            }
                            c.this.Ah();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csI();
                    c.this.cyK();
                    if (c.this.currentState != 1) {
                        c.this.cyG();
                        c.this.cyH();
                    } else {
                        c.this.cdi();
                    }
                    if (c.this.jvA != null) {
                        c.this.jvA.mr(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jvf.stopPlayback();
                c.this.EI = false;
                c.this.cyB();
            }
        };
        this.ibB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.ibC = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.ibD = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cdf();
            }
        };
        this.ibE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.idC = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ok(int i2) {
                int duration;
                if (c.this.jvf != null && (duration = c.this.jvf.getDuration()) > 0 && c.this.jvg != null) {
                    c.this.jvg.setProgress((int) ((i2 * c.this.iaO.getWidth()) / duration));
                    if (c.this.jvv != null) {
                        c.this.jvv.Aw((c.this.jvf.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eaC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cyG();
                c.this.rP(false);
                if (c.this.jvA != null) {
                    c.this.jvA.mr(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccW() != null) {
                    c.this.xI(c.this.ccW().getSeekPosition());
                    if (!c.this.cde()) {
                        c.this.cyB();
                    } else {
                        c.this.akd();
                        if (c.this.iZN != null) {
                            c.this.iZN.bGD();
                        }
                    }
                }
                c.this.rP(true);
                c.this.cyF();
                if (c.this.jvA != null) {
                    c.this.jvA.mr(true);
                }
                if (c.this.jvB != null) {
                    c.this.jvB.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jvV = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyN() {
                if (!c.this.jvK) {
                    c.this.dME.startLoading();
                    c.this.OZ.setVisibility(0);
                    c.this.jvi.setVisibility(8);
                    c.this.jvk.setVisibility(8);
                    c.this.jvj.setVisibility(8);
                    c.this.jvl.setVisibility(8);
                    c.this.fNa.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.ibz);
                    if (c.this.jvu > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.ibz, c.this.jvu);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVv = tbPageContext;
            this.mRootView = view;
            this.jvP = z;
            this.iaZ = view;
            this.mActivity = this.cVv.getPageActivity();
            init();
        }
    }

    public c(TbPageContext tbPageContext, View view, boolean z, int i2) {
        this.mVideoType = 0;
        this.EJ = 100;
        this.jve = false;
        this.EV = false;
        this.EI = false;
        this.jvp = false;
        this.jvq = false;
        this.mStartPosition = 0;
        this.mStatus = 0;
        this.ibp = 0;
        this.ibq = 0;
        this.jvu = 60000L;
        this.ibs = 0;
        this.ibw = false;
        this.jvF = true;
        this.jvG = true;
        this.jvH = false;
        this.jvI = false;
        this.iZn = null;
        this.currentState = -1;
        this.jvK = false;
        this.jvP = true;
        this.jvR = false;
        this.jvS = false;
        this.dVG = new g.f() { // from class: com.baidu.tieba.play.c.17
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (c.this.iaQ != null && c.this.jvf != null && c.this.jvf.getDuration() > 0) {
                    c.this.iaQ.ba(0, c.this.jvf.getDuration());
                }
                c.this.buT();
                if (c.this.jvv != null) {
                    c.this.jvv.onPrepared();
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.play.c.18
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i22, int i3) {
                if (i22 == 3 || i22 == 702 || i22 == 904) {
                    c.this.lt();
                    return false;
                }
                return false;
            }
        };
        this.fKw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                c.this.buT();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.play.c.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                if (c.this.OZ.getVisibility() != 8) {
                    if (c.this.jvf.getCurrentPosition() > c.this.EJ) {
                        c.this.lt();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                    }
                }
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.play.c.21
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (c.this.jvf != null) {
                    int duration = c.this.jvf.getDuration();
                    if (duration - c.this.getCurrentPosition() <= 5000) {
                        c.this.EI = false;
                        c.this.jvN = false;
                        c.this.mStartPosition = 0;
                        c.this.ccS();
                        c.this.iaR.setVisibility(0);
                        c.this.jvg.setProgress(c.this.jvg.getMax());
                        c.this.EJ = 100;
                        if (c.this.jvn != null) {
                            c.this.jvn.onCompletion(gVar);
                        }
                        c.this.currentState = 3;
                        if (c.this.cyq()) {
                            ((QuickVideoView) c.this.jvf).setRecoveryState(3);
                        }
                        if (duration > 150000) {
                            c.this.rO(false);
                            c.this.rP(true);
                        } else {
                            c.this.cyI();
                            c.this.jvj.setVisibility(0);
                        }
                        if (!c.this.EV && duration <= 150000) {
                            if (!c.this.jvK) {
                                if (c.this.jvx != null) {
                                    c.this.jvx.qV(true);
                                }
                                c.this.z(c.this.mVideoUrl, c.this.Pk, false);
                            } else {
                                c.this.currentState = 5;
                                if (c.this.cyq()) {
                                    ((QuickVideoView) c.this.jvf).setRecoveryState(5);
                                }
                                c.this.jvf.pause();
                                c.this.jvf.seekTo(0);
                            }
                        }
                        if (c.this.jvv != null) {
                            c.this.jvv.Aw(c.this.jvg.getMax());
                            c.this.jvv.ub();
                        }
                    }
                }
            }
        };
        this.iby = new g.b() { // from class: com.baidu.tieba.play.c.22
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i22, int i3) {
                c.this.fNa.setVisibility(0);
                c.this.dME.czJ();
                c.this.currentState = 4;
                if (c.this.cyq()) {
                    ((QuickVideoView) c.this.jvf).setRecoveryState(4);
                }
                if (c.this.jvo != null) {
                    c.this.jvo.onError(gVar, i22, i3);
                }
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    c.this.jvL = true;
                }
                if (c.this.jvv != null) {
                    c.this.jvv.cyO();
                }
                c.this.jvN = false;
                return true;
            }
        };
        this.ibz = new Runnable() { // from class: com.baidu.tieba.play.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jvf == null || !c.this.jvf.isPlaying()) {
                    c.this.fNa.setVisibility(0);
                    c.this.dME.czJ();
                    if (c.this.jvv != null) {
                        c.this.jvv.cyO();
                    }
                }
            }
        };
        this.dVJ = new g.InterfaceC0591g() { // from class: com.baidu.tieba.play.c.2
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(com.baidu.tieba.play.g gVar) {
                if (c.this.jvH) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jvT, 200L);
                }
            }
        };
        this.jvT = new Runnable() { // from class: com.baidu.tieba.play.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jvf == null || !c.this.jvH) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 200L);
                    c.this.jvH = false;
                } else if (c.this.mStartPosition != c.this.jvf.getCurrentPosition()) {
                    c.this.jvH = false;
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.EO, 20L);
                } else {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jvT, 200L);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                c.this.EI = false;
                if (c.this.jvq) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(c.this.jvU, 300L);
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.EO);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.ibz);
            }
        };
        this.jvU = new Runnable() { // from class: com.baidu.tieba.play.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.jvN = false;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.iZB != null) {
                    c.this.iZB.csP();
                }
                if (view2.getId() != c.this.fNa.getId()) {
                    if (view2.getId() != c.this.jvi.getId()) {
                        if (view2.getId() == c.this.jvk.getId()) {
                            if (c.this.jvw != null) {
                                c.this.jvw.csQ();
                                return;
                            }
                            return;
                        } else if (view2.getId() == c.this.jvj.getId()) {
                            if (c.this.jvx != null) {
                                c.this.jvx.qV(false);
                            }
                            c.this.eg(c.this.mVideoUrl, c.this.Pk);
                            return;
                        } else if (view2.getId() == c.this.iaW.getId()) {
                            int i22 = c.this.jvq ? 1 : 2;
                            if (c.this.EV) {
                                TiebaStatic.log(new an("c11714"));
                                TiebaStatic.log(new an("c13262").cx("tid", c.this.Pk).cx("fid", c.this.emF).X("obj_type", i22).X("obj_source", 2));
                            } else {
                                TiebaStatic.log(new an("c11710"));
                                TiebaStatic.log(new an("c13262").cx("tid", c.this.Pk).cx("fid", c.this.emF).X("obj_type", i22).X("obj_source", 1));
                            }
                            if (c.this.jvC != null) {
                                c.this.jvC.bGB();
                            }
                            if (c.this.cys()) {
                                if (c.this.EV) {
                                    c.this.cyw();
                                } else {
                                    c.this.cyv();
                                }
                                c.this.rL(c.this.EV);
                                return;
                            }
                            c.this.Ah();
                            return;
                        } else if (view2.getId() != c.this.ibd.getId()) {
                            if (c.this.jvr != null) {
                                c.this.jvr.onClick(view2);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new an("c11713"));
                            if (c.this.jvC != null) {
                                c.this.jvC.bGB();
                            }
                            if (c.this.cys()) {
                                c.this.cyw();
                                c.this.rL(false);
                                return;
                            }
                            c.this.Ah();
                            return;
                        }
                    }
                    TiebaStatic.log(new an("c13255"));
                    c.this.csI();
                    c.this.cyK();
                    if (c.this.currentState != 1) {
                        c.this.cyG();
                        c.this.cyH();
                    } else {
                        c.this.cdi();
                    }
                    if (c.this.jvA != null) {
                        c.this.jvA.mr(c.this.currentState == 1);
                        return;
                    }
                    return;
                }
                c.this.jvf.stopPlayback();
                c.this.EI = false;
                c.this.cyB();
            }
        };
        this.ibB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
        this.ibC = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
        this.ibD = new Runnable() { // from class: com.baidu.tieba.play.c.11
            @Override // java.lang.Runnable
            public void run() {
                c.this.cdf();
            }
        };
        this.ibE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    c.this.pausePlay();
                }
            }
        };
        this.idC = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ok(int i22) {
                int duration;
                if (c.this.jvf != null && (duration = c.this.jvf.getDuration()) > 0 && c.this.jvg != null) {
                    c.this.jvg.setProgress((int) ((i22 * c.this.iaO.getWidth()) / duration));
                    if (c.this.jvv != null) {
                        c.this.jvv.Aw((c.this.jvf.getCurrentPosition() * 100) / duration);
                    }
                }
            }
        };
        this.eaC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                TiebaStatic.log(new an("c13256"));
                c.this.cyG();
                c.this.rP(false);
                if (c.this.jvA != null) {
                    c.this.jvA.mr(false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (c.this.ccW() != null) {
                    c.this.xI(c.this.ccW().getSeekPosition());
                    if (!c.this.cde()) {
                        c.this.cyB();
                    } else {
                        c.this.akd();
                        if (c.this.iZN != null) {
                            c.this.iZN.bGD();
                        }
                    }
                }
                c.this.rP(true);
                c.this.cyF();
                if (c.this.jvA != null) {
                    c.this.jvA.mr(true);
                }
                if (c.this.jvB != null) {
                    c.this.jvB.onStopTrackingTouch(seekBar);
                }
            }
        };
        this.jvV = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyN() {
                if (!c.this.jvK) {
                    c.this.dME.startLoading();
                    c.this.OZ.setVisibility(0);
                    c.this.jvi.setVisibility(8);
                    c.this.jvk.setVisibility(8);
                    c.this.jvj.setVisibility(8);
                    c.this.jvl.setVisibility(8);
                    c.this.fNa.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(c.this.ibz);
                    if (c.this.jvu > 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(c.this.ibz, c.this.jvu);
                    }
                }
            }
        };
        if (tbPageContext != null) {
            this.cVv = tbPageContext;
            this.mRootView = view;
            this.jvP = z;
            this.iaZ = view;
            this.mActivity = this.cVv.getPageActivity();
            this.mVideoType = i2;
            init();
        }
    }

    public void init() {
        this.iaO = at(this.mActivity);
        this.iaO.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.iaO);
        }
        this.jvf = com.baidu.tieba.play.a.b.F(this.mActivity, this.mVideoType);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.iaO).addView(this.jvf.getView(), 0);
        this.jvf.getView().setLayoutParams(layoutParams);
        this.dME = new w((ViewGroup) this.iaO.findViewById(R.id.auto_video_loading_container));
        this.dME.setLoadingAnimationListener(this.fKw);
        this.iaQ = (VideoListMediaControllerView) this.iaO.findViewById(R.id.media_controller);
        this.iaQ.setPlayer(this.jvf);
        this.jvg = (ProgressBar) this.iaO.findViewById(R.id.pgrBottomProgress);
        this.jvg.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.jvg.setProgress(0);
        this.iaQ.setOnSeekBarChangeListener(this.eaC);
        this.iaQ.setOnProgressUpdatedListener(this.idC);
        this.iaR = this.iaO.findViewById(R.id.black_mask);
        this.fNa = this.iaO.findViewById(R.id.layout_error);
        this.fNa.setOnClickListener(this.mOnClickListener);
        this.jvJ = (TextView) this.iaO.findViewById(R.id.auto_video_error_tips);
        this.iaS = (FrameLayout) this.iaO.findViewById(R.id.danmu_container);
        this.iaW = (ImageView) this.iaO.findViewById(R.id.img_full_screen);
        this.iaW.setOnClickListener(this.mOnClickListener);
        this.iaX = this.iaO.findViewById(R.id.layout_media_controller);
        this.jvh = this.iaO.findViewById(R.id.time_show_controller);
        this.jvf.setContinuePlayEnable(true);
        this.jvf.setOnPreparedListener(this.dVG);
        this.jvf.setOnCompletionListener(this.dVF);
        this.jvf.setOnErrorListener(this.iby);
        this.jvf.setOnSeekCompleteListener(this.dVJ);
        this.jvf.setOnOutInfoListener(this.dVI);
        this.jvf.setOnSurfaceDestroyedListener(this.dMN);
        if (cyq()) {
            ((QuickVideoView) this.jvf).setOnRecoveryCallback(this.jvV);
        }
        this.jvi = (SwitchImageView) this.iaO.findViewById(R.id.img_play_controller);
        this.jvi.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.jvi.setState(0);
        this.jvi.setOnClickListener(this.mOnClickListener);
        this.jvj = (TextView) this.iaO.findViewById(R.id.txt_replay);
        this.jvj.setOnClickListener(this.mOnClickListener);
        this.jvk = (TextView) this.iaO.findViewById(R.id.txt_playnext);
        this.jvk.setOnClickListener(this.mOnClickListener);
        this.jvl = (TextView) this.iaO.findViewById(R.id.txt_next_video_title);
        this.OZ = (TbImageView) this.iaO.findViewById(R.id.video_thumbnail);
        this.OZ.setDefaultErrorResource(0);
        this.OZ.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.ibd = (ImageView) this.iaO.findViewById(R.id.img_exit);
        this.ibd.setOnClickListener(this.mOnClickListener);
        this.ibe = (TextView) this.iaO.findViewById(R.id.video_title);
        this.aDn = this.iaO.findViewById(R.id.layout_title);
        this.aDn.setVisibility(8);
        this.guV = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aLM = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.ibo = this.mAudioManager.getStreamMaxVolume(3);
        this.ibt = this.mAudioManager.getStreamVolume(3);
        ibu = 100 / this.ibo;
        this.iaO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.jvy != null) {
                    c.this.jvy.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.EI) {
                        if (c.this.mStatus == 1 && c.this.ibq != 0) {
                            c.this.b(c.this.ibq == 1 ? 1000.0f : -1000.0f, false);
                            c.this.ibq = 0;
                            c.this.ibp = 0;
                        }
                        if (!c.this.jvf.isPlaying()) {
                            c.this.jvk.setVisibility(8);
                            c.this.jvj.setVisibility(8);
                            c.this.jvl.setVisibility(8);
                        }
                    }
                    c.this.ccS();
                    if (c.this.jvy != null) {
                        c.this.jvy.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.eeN = new com.baidu.tieba.play.o(this.mActivity);
        if (this.jvP) {
            this.eeN.start();
        }
        this.ibs = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (ibv == null) {
            ibv = new CallStateReceiver();
        }
        ibv.register(this.mActivity);
        cyr();
        MessageManager.getInstance().registerListener(this.ibE);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.ibE);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void As(int i2) {
        if (this.OZ != null) {
            this.OZ.setDefaultBgResource(i2);
        }
    }

    public boolean cyq() {
        return this.mVideoType == 0 && (this.jvf instanceof QuickVideoView);
    }

    public void cyr() {
        if (this.jvF) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.iaO.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.iaO.setSystemUiVisibility(0);
    }

    public void rJ(boolean z) {
        this.jvF = z;
        cyr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccS() {
        this.mStatus = 0;
        if (this.ibi != null && this.ibi.getParent() != null && (this.ibi.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ibi.getParent()).removeView(this.ibi);
                this.ibi = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ibj != null && this.ibj.getParent() != null && (this.ibj.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ibj.getParent()).removeView(this.ibj);
                this.ibj = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void ccT() {
        if (this.mStatus == 1) {
            if (this.ibi == null && this.iaO != null && (this.iaO instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.iaO, true);
                this.ibi = this.iaO.findViewById(R.id.lay_jindu);
                this.ibk = (TextView) this.ibi.findViewById(R.id.show_time);
                this.ibn = (ImageView) this.ibi.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ibj == null && this.iaO != null && (this.iaO instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.iaO, true);
            this.ibj = this.iaO.findViewById(R.id.lay_voice);
            this.ibm = (ImageView) this.ibj.findViewById(R.id.arrow_voice_icon);
            this.ibl = (SeekBar) this.ibj.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jvr = onClickListener;
    }

    public void rK(boolean z) {
        this.jvq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.jvy != null) {
                c.this.jvy.onStart();
            }
            if (c.this.EV && c.this.EI) {
                if (c.this.mStatus == 1) {
                    c.this.cyI();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aC(f2);
                    }
                } else {
                    if (c.this.EV) {
                        c.this.ccV();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ibp = c.this.jvf.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aC(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.jvQ) {
                if (c.this.jvz != null && c.this.jvz.csR()) {
                    return true;
                }
                c.this.csI();
                c.this.cyK();
                if (c.this.jvf.isPlaying()) {
                    c.this.cyF();
                } else {
                    c.this.cyG();
                }
                if (c.this.jvA != null) {
                    c.this.jvA.mr(c.this.jvf.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.jvQ) {
                if (c.this.EI) {
                    if (c.this.jvz != null && c.this.jvz.csS()) {
                        return true;
                    }
                    c.this.cyE();
                    if (c.this.jvf.isPlaying()) {
                        c.this.cyF();
                    } else {
                        c.this.cyG();
                    }
                    if (c.this.jvA != null) {
                        c.this.jvA.mr(c.this.jvf.isPlaying());
                    }
                } else {
                    c.this.csI();
                    c.this.cyK();
                    if (c.this.currentState != 1) {
                        c.this.cyG();
                        c.this.cyH();
                    } else {
                        c.this.cdi();
                    }
                    if (c.this.jvA != null) {
                        c.this.jvA.mr(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccV() {
        if (Build.VERSION.SDK_INT < 16) {
            this.iaO.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.iaO.setSystemUiVisibility(4);
        } else {
            this.iaO.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(float f2) {
        if (!this.EI) {
            this.mStatus = 0;
            return;
        }
        ccT();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ibu == 0) {
            if (f2 > 0.0f && this.ibt < this.ibo) {
                this.ibt++;
            }
            if (f2 < 0.0f && this.ibt > 0) {
                this.ibt--;
            }
        }
        if (this.mProgress > 0) {
            this.ibm.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.ibm.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.ibt, 0);
        this.ibl.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.ibp -= 1000;
                this.ibq = 1;
            } else {
                this.ibp += 1000;
                this.ibq = 2;
            }
            if (this.ibp < 0) {
                this.ibp = 0;
            } else if (this.ibp > this.jvf.getDuration()) {
                this.ibp = this.jvf.getDuration();
            }
        }
        ccT();
        String AC = this.iaQ.AC(this.ibp);
        if (f2 > 0.0f) {
            this.ibn.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.ibn.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(AC)) {
            this.ibk.setText(new StringBuilder().append(AC).append("/").append(this.iaQ.AC(this.jvf.getDuration())));
        }
        this.iaQ.setCurrentDuration(this.ibp, z ? false : true);
        cyI();
        cyx();
    }

    protected View at(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void At(int i2) {
        this.jvm = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pk = str2;
    }

    public void setFid(String str) {
        this.emF = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        if (this.jvf != null && this.iaQ != null) {
            this.iaQ.showProgress();
            this.mStartPosition = x.czM().Hd(this.mVideoUrl);
            if (this.jvN) {
                this.jvf.setVolume(1.0f, 1.0f);
                this.jvf.start();
                this.jvN = false;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.EO, 20L);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibz);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvU);
                if (this.jvf.czi()) {
                    this.currentState = 1;
                    if (cyq()) {
                        ((QuickVideoView) this.jvf).setRecoveryState(1);
                    }
                    cyI();
                }
                this.mStartPosition = x.czM().Hd(this.mVideoUrl);
                this.iaQ.setPlayer(this.jvf);
                if (this.mStartPosition != 0) {
                    this.jvH = true;
                }
                if (!this.jvM) {
                    this.iaQ.showProgress();
                }
                if (!this.jvq && this.jvf.getDuration() <= 0) {
                    ccW().setVisibility(4);
                }
            }
            this.EJ = (this.mStartPosition <= 100 || this.jvf.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt() {
        if (this.OZ.getVisibility() != 8 || !this.EI) {
            this.EI = true;
            this.iaR.setVisibility(8);
            this.fNa.setVisibility(8);
            this.dME.czI();
            this.OZ.setVisibility(8);
            cyJ();
            long duration = this.jvf.getDuration() / 1000;
            String str = this.Pk;
            this.iaQ.showProgress();
            this.jvg.setVisibility(0);
            if (this.ibb != null && cyq()) {
                this.ibb.onPrepared(((QuickVideoView) this.jvf).getPlayer());
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

    protected void rL(boolean z) {
        if (hasNavBar(this.mActivity) && (this.jvh.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jvh.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.jvh.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.jvh.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.jvh.setLayoutParams(layoutParams);
        }
    }

    public void csI() {
        if (this.jvf.isPlaying()) {
            pausePlay();
            if (this.jvE != null) {
                this.jvE.onPause();
            }
            if (this.jvv != null) {
                this.jvv.onPaused();
            }
        } else if (this.EI) {
            akd();
            if (this.iZN != null) {
                this.iZN.bGD();
            }
            if (this.jvv != null) {
                this.jvv.cyP();
            }
        } else {
            cyB();
        }
    }

    public void Ah() {
        this.ibw = true;
        if (this.eeN != null) {
            this.eeN.Ah();
        }
    }

    public boolean cys() {
        return this.jvf != null && this.jvf.getView().getHeight() > this.jvf.getView().getWidth();
    }

    public void cyt() {
        rL(false);
        cyw();
    }

    public boolean Au(int i2) {
        switch (i2) {
            case 4:
                if (this.EV) {
                    if (cys()) {
                        rL(false);
                        cyw();
                    } else {
                        Ah();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.ibo <= 0 || this.ibl == null) {
                    return false;
                }
                this.ibt = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.ibt * 100.0d) / this.ibo);
                this.ibl.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    @Deprecated
    public QuickVideoView getVideoView() {
        if (cyq()) {
            return (QuickVideoView) this.jvf;
        }
        return null;
    }

    public com.baidu.tieba.play.a.a cyu() {
        return this.jvf;
    }

    public VideoListMediaControllerView ccW() {
        return this.iaQ;
    }

    public void show() {
        this.iaO.setVisibility(0);
    }

    public void cda() {
        if (this.iaZ != null) {
            ViewGroup.LayoutParams layoutParams = this.iaZ.getLayoutParams();
            this.iaT = (FrameLayout.LayoutParams) this.iaO.getLayoutParams();
            this.iaT.width = layoutParams.width;
            this.iaT.height = layoutParams.height;
            this.iaT.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.iaO.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.iaO.setLayoutParams(this.iaT);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.ibw) {
            if (this.EV) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.ibw = false;
        }
        if (configuration.orientation == 2) {
            cyv();
        } else {
            cyw();
        }
        cyx();
        if (this.mActivity == com.baidu.adp.base.a.eH().currentActivity()) {
            akd();
        }
        cyK();
        cdi();
        if (this.jvA != null) {
            this.jvA.mr(true);
        }
    }

    protected void cyv() {
        this.EV = true;
        if (cys()) {
            this.iaO.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.iaO.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.aDn.setVisibility(0);
        this.ibd.setVisibility(0);
        this.ibe.setVisibility(0);
        this.iaS.setVisibility(8);
        this.dME.czJ();
        this.OZ.setVisibility(8);
        this.iaW.setImageResource(R.drawable.icon_video_narrow_white);
        xF(this.ibs);
        ccV();
        if (this.jvs != null) {
            this.jvs.lc();
        }
    }

    protected void cyw() {
        this.EV = false;
        if (this.iaT != null) {
            this.iaO.setLayoutParams(this.iaT);
        }
        g(this.mActivity, false);
        this.aDn.setVisibility(8);
        this.iaS.setVisibility(0);
        this.dME.czJ();
        this.OZ.setVisibility(8);
        this.iaW.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.iaQ != null && (this.iaQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iaQ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.iaQ.setLayoutParams(layoutParams);
        }
        this.iaO.setSystemUiVisibility(0);
        cyr();
        if (this.jvs != null) {
            this.jvs.ld();
        }
    }

    public void cyx() {
        if (this.jvf != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.EV) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.jvg.setMax(equipmentWidth);
            int duration = this.jvf.getDuration();
            if (duration > 0) {
                if (this.jvj.getVisibility() == 0) {
                    this.jvg.setProgress(this.jvg.getMax());
                } else {
                    this.jvg.setProgress((int) ((this.jvf.getCurrentPositionSync() * this.jvg.getMax()) / duration));
                }
            }
        }
    }

    private void xF(int i2) {
        if (this.iaQ != null && (this.iaQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iaQ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.iaQ.setLayoutParams(layoutParams);
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

    public boolean cdc() {
        return !this.EV;
    }

    public void a(g.f fVar) {
        this.ibb = fVar;
    }

    public void a(g.a aVar) {
        this.jvn = aVar;
    }

    public void a(g.b bVar) {
        this.jvo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.jvI) {
            eh(str, str2);
        } else {
            eg(str, str2);
        }
        if (eVar != null) {
            eVar.rT(z);
        }
    }

    public void ef(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, boolean z) {
        cyC();
        this.jvN = true;
        this.currentState = 0;
        if (cyq()) {
            ((QuickVideoView) this.jvf).setRecoveryState(0);
        }
        setVideoUrl(str, str2);
        this.jvf.setVideoDuration(this.jvm);
        this.jvf.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibz);
        if (this.jvu > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.ibz, this.jvu);
        }
        if (this.jvv != null) {
            this.jvv.onStarted();
        }
        this.dME.startLoading();
        rM(z);
    }

    public void eg(String str, String str2) {
        z(str, str2, true);
    }

    public void eh(String str, String str2) {
        cyC();
        this.jvN = true;
        this.currentState = 0;
        if (cyq()) {
            ((QuickVideoView) this.jvf).setRecoveryState(0);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibz);
        if (this.jvu > 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.ibz, this.jvu);
        }
        if (this.jvv != null) {
            this.jvv.onStarted();
        }
        this.dME.startLoading();
        rM(true);
    }

    public void cyy() {
        akd();
        this.jvg.setVisibility(0);
    }

    public void akd() {
        if (this.jvf != null && this.iaQ != null) {
            this.EI = true;
            this.currentState = 1;
            if (cyq()) {
                ((QuickVideoView) this.jvf).setRecoveryState(1);
            }
            this.jvf.a(null);
            this.mStartPosition = x.czM().Hd(this.mVideoUrl);
            this.jvH = true;
            this.EJ = (this.mStartPosition <= 100 || this.jvf.getDuration() <= this.mStartPosition) ? 100 : this.mStartPosition;
            this.dME.czJ();
            rM(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.jvL && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pk)) {
            this.jvL = false;
            this.jvM = true;
            eg(this.mVideoUrl, this.Pk);
        }
    }

    private void rM(boolean z) {
        if (z) {
            this.OZ.setVisibility(0);
            cyI();
            this.jvg.setProgress(0);
        } else {
            this.OZ.setVisibility(8);
            cyI();
        }
        this.iaQ.showProgress();
        this.iaR.setVisibility(8);
        this.jvk.setVisibility(8);
        this.jvj.setVisibility(8);
        this.jvl.setVisibility(8);
        this.fNa.setVisibility(8);
    }

    private void cyz() {
        this.dME.czJ();
        this.jvk.setVisibility(8);
        this.jvj.setVisibility(8);
        this.jvl.setVisibility(8);
        cyK();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.jvf instanceof QuickVideoView) {
            ((QuickVideoView) this.jvf).setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.jvf.pause();
        this.currentState = 2;
        if (cyq()) {
            ((QuickVideoView) this.jvf).setRecoveryState(2);
        }
        cyz();
    }

    public void stopPlay() {
        this.currentState = 5;
        if (cyq()) {
            ((QuickVideoView) this.jvf).setRecoveryState(5);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibz);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvU);
        this.jvf.stopPlayback();
        this.EI = false;
        this.jvN = false;
        this.mStartPosition = 0;
        bQh();
    }

    public void cyA() {
        if (this.jvf.getDuration() >= this.jvf.getCurrentPosition()) {
            x.czM().bl(this.mVideoUrl, this.jvf.getCurrentPosition());
        }
    }

    public void rN(boolean z) {
        this.jvG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(boolean z) {
        if (this.iaX != null) {
            this.iaR.setVisibility(0);
            this.jvk.setVisibility(8);
            this.jvj.setVisibility(8);
            this.jvl.setVisibility(8);
            this.dME.czJ();
            cyI();
            this.jvg.setVisibility(8);
            this.fNa.setVisibility(8);
            this.iaQ.akm();
            this.OZ.setVisibility(z ? 0 : 8);
        }
    }

    public void bQh() {
        rO(true);
    }

    public boolean le() {
        if (this.jvf == null) {
            return false;
        }
        return this.jvf.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.jvf == null) {
            return 0;
        }
        return this.jvf.getCurrentPosition();
    }

    public void a(k kVar) {
        this.jvy = kVar;
    }

    public void a(j jVar) {
        this.jvx = jVar;
    }

    public void a(i iVar) {
        this.iZN = iVar;
    }

    public void a(g gVar) {
        this.jvE = gVar;
    }

    public void a(h hVar) {
        this.jvw = hVar;
    }

    public void Gw(String str) {
        this.iZn = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyB() {
        a(this.mVideoUrl, this.Pk, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.jvt = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cyC();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cPC().cPD()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.jvI = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.jvD != null) {
                    this.jvD.lM(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.sR(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cyD();
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
                aVar.b(this.cVv).aEG();
                return;
            } else if (this.jvD != null) {
                this.jvD.lM(true);
                return;
            } else {
                if (!this.jve) {
                    this.jve = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.jvC != null) {
            this.jvC.bGA();
        }
    }

    private void cyC() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cPC().fx(this.mActivity);
        }
    }

    public void cyD() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.OZ.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibD);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.EO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibz);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvT);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvU);
        this.eeN.stop();
        ibv.unregister(this.mActivity);
    }

    public void GX(String str) {
        this.ibe.setText(str);
    }

    public boolean cde() {
        return this.EI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyE() {
        if (this.iaX != null) {
            if (this.jvp) {
                cyI();
            } else {
                cyH();
            }
        }
    }

    public void cdi() {
        cyH();
        cyF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibD);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.ibD, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibD);
    }

    public void cyH() {
        if (this.iaX != null && !this.jvp && !this.jvR) {
            rP(true);
            cdh();
            this.iaX.setVisibility(0);
            this.jvh.setVisibility(0);
            this.jvg.setVisibility(8);
            this.jvp = true;
            if (this.jvt != null) {
                this.jvt.lN(false);
            }
        }
    }

    public void cdf() {
        if (this.iaX != null && this.jvp) {
            rP(false);
            cdh();
            this.iaX.setVisibility(8);
            this.jvh.setVisibility(8);
            this.jvg.setVisibility(0);
            this.guV.setAnimationListener(this.ibB);
            this.iaX.startAnimation(this.guV);
            this.jvp = false;
            if (this.jvt != null) {
                this.jvt.bGC();
            }
        }
    }

    public void cyI() {
        if (this.iaX != null && this.jvp) {
            this.aLM.cancel();
            this.guV.cancel();
            rP(false);
            cdh();
            this.iaX.setVisibility(8);
            this.jvh.setVisibility(8);
            this.jvg.setVisibility(0);
            this.jvp = false;
            if (this.jvt != null) {
                this.jvt.bGC();
            }
        }
    }

    private void cdh() {
        if (this.iaX != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibD);
            this.aLM.setAnimationListener(null);
            this.guV.setAnimationListener(null);
            this.iaX.clearAnimation();
        }
    }

    private void cyJ() {
        if (this.iaX != null) {
            this.aLM.setAnimationListener(null);
            this.guV.setAnimationListener(null);
            this.iaX.clearAnimation();
        }
    }

    public void rP(boolean z) {
        cyK();
        if (z) {
            this.jvi.setVisibility(0);
        } else {
            this.jvi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        if (this.currentState == 1) {
            this.jvi.setState(1);
        } else {
            this.jvi.setState(0);
        }
    }

    public void a(InterfaceC0590c interfaceC0590c) {
        this.jvs = interfaceC0590c;
    }

    public void xI(int i2) {
        this.mStartPosition = i2;
    }

    public void aj(boolean z, boolean z2) {
        if (this.eeN != null) {
            if (this.iaW != null) {
                this.iaW.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.iaQ != null && (this.iaQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iaQ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.iaQ.setLayoutParams(layoutParams);
            }
            this.eeN.bo(z);
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

    public void rQ(boolean z) {
        this.jvQ = z;
    }

    public void a(m mVar) {
        this.jvz = mVar;
    }

    public void a(a aVar) {
        this.jvA = aVar;
    }

    public void a(n nVar) {
        this.jvB = nVar;
    }

    public void a(l lVar) {
        this.jvC = lVar;
    }

    public void a(f fVar) {
        this.jvD = fVar;
    }

    public void rR(boolean z) {
        this.jvK = z;
    }

    public void rS(boolean z) {
        this.jvq = z;
    }

    public void Av(int i2) {
        this.jvO = i2;
    }

    public View cyL() {
        return this.iaO;
    }

    public void a(p pVar) {
        this.iZB = pVar;
    }

    public void cyM() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVv.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.cVv.getPageActivity());
    }
}
