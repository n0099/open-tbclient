package com.baidu.tieba.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.view.SwitchImageView;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int fgC;
    private String aAy;
    private o bEH;
    protected QuickVideoView bJN;
    private String beh;
    private x bkI;
    private com.baidu.tieba.play.g cML;
    private com.baidu.tieba.j.k cMN;
    private View cPA;
    protected View cPF;
    private String cQb;
    private Animation dFq;
    private Animation dFr;
    public View ffV;
    private VideoListMediaControllerView ffX;
    private View ffY;
    private FrameLayout ffZ;
    private int fgB;
    private CallStateReceiver fgD;
    protected FrameLayout.LayoutParams fga;
    private ImageView fgd;
    private View fge;
    private View fgg;
    private TbImageView fgh;
    private g.f fgi;
    private ImageView fgk;
    private TextView fgl;
    private View fgq;
    private View fgr;
    private TextView fgs;
    private SeekBar fgt;
    private ImageView fgu;
    private ImageView fgv;
    private int fgw;
    private i gcT;
    private m gtA;
    private a gtB;
    private l gtC;
    private f gtD;
    private g gtE;
    private TextView gtJ;
    private boolean gtL;
    private boolean gtM;
    private boolean gtN;
    private int gtO;
    private boolean gtP;
    private boolean gtQ;
    private ProgressBar gti;
    private View gtj;
    private SwitchImageView gtk;
    private TextView gtl;
    private TextView gtm;
    private TextView gtn;
    private g.a gto;
    private g.b gtp;
    private View.OnClickListener gts;
    protected InterfaceC0258c gtt;
    private d gtu;
    private n gtw;
    private h gtx;
    private j gty;
    private k gtz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int cMT = 100;
    private boolean gth = false;
    protected boolean bEK = false;
    private boolean fgm = false;
    private boolean gtq = false;
    private boolean gtr = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int fgx = 0;
    private int fgy = 0;
    private long gtv = 60000;
    private int fgA = 0;
    private boolean fgE = false;
    private boolean gtF = true;
    private boolean gtG = true;
    private boolean gtH = false;
    private boolean gtI = false;
    private String gct = null;
    private int currentState = -1;
    private boolean gtK = false;
    private boolean gtR = false;
    private g.f btz = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cML = gVar;
            c.this.cMN.bbv();
            c.this.anX();
        }
    };
    private g.e btB = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3) {
                c.this.bpz();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a cMX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.anX();
        }
    };
    private Runnable fgG = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(c.this.fgG);
            if (!c.this.fgm) {
                if (c.this.bJN.getCurrentPosition() > c.this.cMT) {
                    c.this.bpz();
                } else {
                    com.baidu.adp.lib.g.e.jI().postDelayed(c.this.fgG, 20L);
                }
            }
        }
    };
    private g.a bty = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bJN != null) {
                int duration = c.this.bJN.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.fgm = false;
                    c.this.gtN = false;
                    c.this.mStartPosition = 0;
                    c.this.aXr();
                    c.this.ffY.setVisibility(0);
                    c.this.gti.setProgress(c.this.gti.getMax());
                    y.bqO().remove(c.this.aAy);
                    c.this.cMT = 100;
                    if (c.this.gto != null) {
                        c.this.gto.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.bJN.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.mf(false);
                        c.this.mg(true);
                    } else {
                        c.this.bpP();
                        c.this.gtl.setVisibility(0);
                    }
                    if (!c.this.bEK && duration <= 150000) {
                        if (!c.this.gtK) {
                            if (c.this.gty != null) {
                                c.this.gty.lC(true);
                            }
                            c.this.aW(c.this.aAy, c.this.beh);
                        } else {
                            c.this.currentState = 5;
                            c.this.bJN.setRecoveryState(5);
                            c.this.bJN.getPlayer().pause();
                            c.this.bJN.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.gtw != null) {
                        c.this.gtw.hC(c.this.gti.getMax());
                        c.this.gtw.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b fgH = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cPF.setVisibility(0);
            c.this.bkI.bqK();
            c.this.currentState = 4;
            c.this.bJN.setRecoveryState(4);
            if (c.this.gtp != null) {
                c.this.gtp.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kX()) {
                c.this.gtL = true;
            }
            if (c.this.gtw != null) {
                c.this.gtw.XF();
            }
            c.this.gtN = false;
            return true;
        }
    };
    protected Runnable fgI = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bJN == null || !c.this.bJN.isPlaying()) {
                c.this.cPF.setVisibility(0);
                c.this.bkI.bqK();
                if (c.this.gtw != null) {
                    c.this.gtw.XF();
                }
            }
        }
    };
    private g.InterfaceC0259g btC = new g.InterfaceC0259g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0259g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gtH) {
                com.baidu.adp.lib.g.e.jI().postDelayed(c.this.gtS, 200L);
            }
        }
    };
    private Runnable gtS = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bJN == null || !c.this.gtH) {
                com.baidu.adp.lib.g.e.jI().postDelayed(c.this.fgG, 200L);
                c.this.gtH = false;
            } else if (c.this.mStartPosition != c.this.bJN.getCurrentPosition()) {
                c.this.gtH = false;
                com.baidu.adp.lib.g.e.jI().postDelayed(c.this.fgG, 20L);
            } else {
                com.baidu.adp.lib.g.e.jI().postDelayed(c.this.gtS, 200L);
            }
        }
    };
    private QuickVideoView.b bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fgm = false;
            if (c.this.gtr) {
                com.baidu.adp.lib.g.e.jI().postDelayed(c.this.gtT, 300L);
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(c.this.fgG);
            com.baidu.adp.lib.g.e.jI().removeCallbacks(c.this.fgI);
        }
    };
    private Runnable gtT = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.gtN = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.cPF.getId()) {
                if (view.getId() != c.this.gtk.getId()) {
                    if (view.getId() == c.this.gtm.getId()) {
                        if (c.this.gtx != null) {
                            c.this.gtx.bml();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.gtl.getId()) {
                        if (c.this.gty != null) {
                            c.this.gty.lC(false);
                        }
                        c.this.aW(c.this.aAy, c.this.beh);
                        return;
                    } else if (view.getId() == c.this.fgd.getId()) {
                        int i2 = c.this.gtr ? 1 : 2;
                        if (c.this.bEK) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").ax("tid", c.this.beh).ax(ImageViewerConfig.FORUM_ID, c.this.cQb).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").ax("tid", c.this.beh).ax(ImageViewerConfig.FORUM_ID, c.this.cQb).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.gtC != null) {
                            c.this.gtC.aBO();
                        }
                        if (c.this.bpB()) {
                            if (c.this.bEK) {
                                c.this.bpD();
                            } else {
                                c.this.bpC();
                            }
                            c.this.mc(c.this.bEK);
                            return;
                        }
                        c.this.aXv();
                        return;
                    } else if (view.getId() != c.this.fgk.getId()) {
                        if (c.this.gts != null) {
                            c.this.gts.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.gtC != null) {
                            c.this.gtC.aBO();
                        }
                        if (c.this.bpB()) {
                            c.this.bpD();
                            c.this.mc(false);
                            return;
                        }
                        c.this.aXv();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.blZ();
                c.this.bpR();
                if (c.this.currentState != 1) {
                    c.this.bpN();
                    c.this.bpO();
                } else {
                    c.this.aXJ();
                }
                if (c.this.gtB != null) {
                    c.this.gtB.hh(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.bJN.stopPlayback();
            c.this.fgm = false;
            c.this.bpI();
        }
    };
    private Animation.AnimationListener fgK = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener fgL = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable fgM = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXG();
        }
    };
    private CustomMessageListener fgN = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b fiJ = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void hh(int i2) {
            int duration;
            if (c.this.bJN != null && (duration = c.this.bJN.getDuration()) > 0 && c.this.gti != null) {
                c.this.gti.setProgress((int) ((i2 * c.this.ffV.getWidth()) / duration));
                if (c.this.gtw != null) {
                    c.this.gtw.hC((c.this.bJN.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener bxP = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bpN();
            c.this.mg(false);
            if (c.this.gtB != null) {
                c.this.gtB.hh(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.aXw() != null) {
                c.this.setStartPosition(c.this.aXw().getSeekPosition());
                if (!c.this.aXF()) {
                    c.this.bpI();
                } else {
                    c.this.aXE();
                    if (c.this.gcT != null) {
                        c.this.gcT.aBQ();
                    }
                }
            }
            c.this.mg(true);
            c.this.bpM();
            if (c.this.gtB != null) {
                c.this.gtB.hh(true);
            }
        }
    };
    private QuickVideoView.a gtU = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bpU() {
            if (!c.this.gtK) {
                c.this.bkI.startLoading();
                c.this.fgh.setVisibility(0);
                c.this.gtk.setVisibility(8);
                c.this.gtm.setVisibility(8);
                c.this.gtl.setVisibility(8);
                c.this.gtn.setVisibility(8);
                c.this.cPF.setVisibility(8);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(c.this.fgI);
                if (c.this.gtv > 0) {
                    com.baidu.adp.lib.g.e.jI().postDelayed(c.this.fgI, c.this.gtv);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void hh(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0258c {
        void XD();

        void XE();
    }

    /* loaded from: classes.dex */
    public interface d {
        void aBP();

        void gJ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void ml(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void gI(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void bml();
    }

    /* loaded from: classes.dex */
    public interface i {
        void aBQ();
    }

    /* loaded from: classes.dex */
    public interface j {
        void lC(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void aBN();

        void aBO();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bmj();

        boolean bmk();
    }

    /* loaded from: classes.dex */
    public interface n {
        void XF();

        void XG();

        void hC(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    public c(Activity activity, View view, boolean z) {
        this.gtP = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.gtP = z;
            this.fgg = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.gtP = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.gtP = z;
            this.fgg = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.ffV = K(this.mActivity);
        this.ffV.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.ffV);
        }
        this.bJN = (QuickVideoView) this.ffV.findViewById(e.g.videoView);
        this.bkI = new x((ViewGroup) this.ffV.findViewById(e.g.auto_video_loading_container));
        this.bkI.setLoadingAnimationListener(this.cMX);
        this.ffX = (VideoListMediaControllerView) this.ffV.findViewById(e.g.media_controller);
        this.ffX.setPlayer(this.bJN);
        this.gti = (ProgressBar) this.ffV.findViewById(e.g.pgrBottomProgress);
        this.gti.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.gti.setProgress(0);
        this.ffX.setOnSeekBarChangeListener(this.bxP);
        this.ffX.setOnProgressUpdatedListener(this.fiJ);
        this.ffY = this.ffV.findViewById(e.g.black_mask);
        this.cPF = this.ffV.findViewById(e.g.layout_error);
        this.cPF.setOnClickListener(this.mOnClickListener);
        this.gtJ = (TextView) this.ffV.findViewById(e.g.auto_video_error_tips);
        this.ffZ = (FrameLayout) this.ffV.findViewById(e.g.danmu_container);
        this.fgd = (ImageView) this.ffV.findViewById(e.g.img_full_screen);
        this.fgd.setOnClickListener(this.mOnClickListener);
        this.fge = this.ffV.findViewById(e.g.layout_media_controller);
        this.gtj = this.ffV.findViewById(e.g.time_show_controller);
        this.bJN.setPlayerReuseEnable(true);
        this.bJN.setContinuePlayEnable(true);
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnCompletionListener(this.bty);
        this.bJN.setOnErrorListener(this.fgH);
        this.bJN.setOnSeekCompleteListener(this.btC);
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        this.bJN.setOnRecoveryCallback(this.gtU);
        this.bJN.setOnOutInfoListener(this.btB);
        this.gtk = (SwitchImageView) this.ffV.findViewById(e.g.img_play_controller);
        this.gtk.setStateImage(e.f.btn_card_play_video_n, e.f.btn_card_stop_video_n);
        this.gtk.setState(0);
        this.gtk.setOnClickListener(this.mOnClickListener);
        this.gtl = (TextView) this.ffV.findViewById(e.g.txt_replay);
        this.gtl.setOnClickListener(this.mOnClickListener);
        this.gtm = (TextView) this.ffV.findViewById(e.g.txt_playnext);
        this.gtm.setOnClickListener(this.mOnClickListener);
        this.gtn = (TextView) this.ffV.findViewById(e.g.txt_next_video_title);
        this.fgh = (TbImageView) this.ffV.findViewById(e.g.video_thumbnail);
        this.fgh.setDefaultErrorResource(0);
        this.fgh.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.fgk = (ImageView) this.ffV.findViewById(e.g.img_exit);
        this.fgk.setOnClickListener(this.mOnClickListener);
        this.fgl = (TextView) this.ffV.findViewById(e.g.video_title);
        this.cPA = this.ffV.findViewById(e.g.layout_title);
        this.cPA.setVisibility(8);
        this.dFq = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.dFr = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.fgw = this.mAudioManager.getStreamMaxVolume(3);
        this.fgB = this.mAudioManager.getStreamVolume(3);
        fgC = 100 / this.fgw;
        this.ffV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.gtz != null) {
                    c.this.gtz.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.fgm) {
                        if (c.this.mStatus == 1 && c.this.fgy != 0) {
                            c.this.b(c.this.fgy == 1 ? 1000.0f : -1000.0f, false);
                            c.this.fgy = 0;
                            c.this.fgx = 0;
                        }
                        if (!c.this.bJN.isPlaying()) {
                            c.this.gtm.setVisibility(8);
                            c.this.gtl.setVisibility(8);
                            c.this.gtn.setVisibility(8);
                        }
                    }
                    c.this.aXr();
                    if (c.this.gtz != null) {
                        c.this.gtz.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.bEH = new o(this.mActivity);
        if (this.gtP) {
            this.bEH.start();
        }
        this.fgA = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0175e.ds16);
        this.fgD = new CallStateReceiver();
        this.fgD.register(this.mActivity);
        bpx();
        this.cMN = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.fgN);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.fgN);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bpx() {
        if (this.gtF) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ffV.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.ffV.setSystemUiVisibility(0);
    }

    public void mb(boolean z) {
        this.gtF = z;
        bpx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXr() {
        this.mStatus = 0;
        if (this.fgq != null && this.fgq.getParent() != null && (this.fgq.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fgq.getParent()).removeView(this.fgq);
                this.fgq = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.fgr != null && this.fgr.getParent() != null && (this.fgr.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fgr.getParent()).removeView(this.fgr);
                this.fgr = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aXs() {
        if (this.mStatus == 1) {
            if (this.fgq == null && this.ffV != null && (this.ffV instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_jindu, (ViewGroup) this.ffV, true);
                this.fgq = this.ffV.findViewById(e.g.lay_jindu);
                this.fgs = (TextView) this.fgq.findViewById(e.g.show_time);
                this.fgv = (ImageView) this.fgq.findViewById(e.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.fgr == null && this.ffV != null && (this.ffV instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_voice, (ViewGroup) this.ffV, true);
            this.fgr = this.ffV.findViewById(e.g.lay_voice);
            this.fgu = (ImageView) this.fgr.findViewById(e.g.arrow_voice_icon);
            this.fgt = (SeekBar) this.fgr.findViewById(e.g.show_voice_seekbar);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.gts = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gtz != null) {
                c.this.gtz.onStart();
            }
            if (c.this.bEK && c.this.fgm) {
                if (c.this.mStatus == 1) {
                    c.this.bpP();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.as(f2);
                    }
                } else {
                    if (c.this.bEK) {
                        c.this.aXu();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.fgx = c.this.bJN.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.as(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.gtQ) {
                if (c.this.gtA != null && c.this.gtA.bmj()) {
                    return true;
                }
                c.this.blZ();
                c.this.bpR();
                if (c.this.bJN.isPlaying()) {
                    c.this.bpM();
                } else {
                    c.this.bpN();
                }
                if (c.this.gtB != null) {
                    c.this.gtB.hh(c.this.bJN.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.gtQ) {
                if (c.this.fgm) {
                    if (c.this.gtA == null || !c.this.gtA.bmk()) {
                        c.this.bpL();
                        if (c.this.bJN.isPlaying()) {
                            c.this.bpM();
                        } else {
                            c.this.bpN();
                        }
                        if (c.this.gtB != null) {
                            c.this.gtB.hh(c.this.bJN.isPlaying());
                        }
                    } else {
                        return true;
                    }
                } else {
                    c.this.aW(c.this.aAy, c.this.beh);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXu() {
        if (Build.VERSION.SDK_INT < 16) {
            this.ffV.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.ffV.setSystemUiVisibility(4);
        } else {
            this.ffV.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(float f2) {
        if (!this.fgm) {
            this.mStatus = 0;
            return;
        }
        aXs();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % fgC == 0) {
            if (f2 > 0.0f && this.fgB < this.fgw) {
                this.fgB++;
            }
            if (f2 < 0.0f && this.fgB > 0) {
                this.fgB--;
            }
        }
        if (this.mProgress > 0) {
            this.fgu.setImageResource(e.f.icon_shengyin_open);
        } else {
            this.fgu.setImageResource(e.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.fgB, 0);
        this.fgt.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.fgx += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.fgy = 1;
            } else {
                this.fgx += 1000;
                this.fgy = 2;
            }
            if (this.fgx < 0) {
                this.fgx = 0;
            } else if (this.fgx > this.bJN.getDuration()) {
                this.fgx = this.bJN.getDuration();
            }
        }
        aXs();
        String sC = this.ffX.sC(this.fgx);
        if (f2 > 0.0f) {
            this.fgv.setImageResource(e.f.icon_kuaitui);
        } else {
            this.fgv.setImageResource(e.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(sC)) {
            this.fgs.setText(new StringBuilder().append(sC).append("/").append(this.ffX.sC(this.bJN.getDuration())));
        }
        this.ffX.setCurrentDuration(this.fgx, z ? false : true);
        bpP();
        bpE();
    }

    protected View K(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(e.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.aAy = str;
        this.beh = str2;
    }

    public void bpy() {
        if (this.bJN != null) {
            this.bJN.bpy();
        }
    }

    public void setFid(String str) {
        this.cQb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anX() {
        int i2 = 100;
        if (this.bJN != null && this.cML != null) {
            this.ffX.showProgress();
            this.mStartPosition = y.bqO().tp(this.aAy);
            if (this.gtN) {
                this.cML.setVolume(1.0f, 1.0f);
                this.bJN.start();
                this.gtN = false;
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgG);
                com.baidu.adp.lib.g.e.jI().postDelayed(this.fgG, 20L);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgI);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gtT);
                if (this.bJN.bqk()) {
                    this.currentState = 1;
                    this.bJN.setRecoveryState(1);
                    bpP();
                }
                if (this.cML != null && this.ffX != null) {
                    this.mStartPosition = y.bqO().tp(this.aAy);
                    this.ffX.setPlayer(this.bJN);
                    if (this.mStartPosition != 0 && !this.cML.isPlayerReuse()) {
                        this.gtH = true;
                    }
                    if (!this.gtM) {
                        this.ffX.showProgress();
                    }
                }
                if (this.cML != null && this.cML.getDuration() <= 0) {
                    aXw().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.cML.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.cMT = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpz() {
        if (!this.fgm) {
            this.fgm = true;
            this.ffY.setVisibility(8);
            this.cPF.setVisibility(8);
            this.bkI.bqJ();
            this.fgh.setVisibility(8);
            bpQ();
            if (bpS()) {
                this.cMN.a(this.beh, -1L, this.bJN.getDuration() / 1000, "middle");
            }
            this.ffX.showProgress();
            this.gti.setVisibility(0);
            if (this.fgi != null) {
                this.fgi.onPrepared(this.bJN.getPlayer());
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE);
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
            Method declaredMethod = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mc(boolean z) {
        if (hasNavBar(this.mActivity)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtj.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.gtj.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gtj.setBackgroundResource(e.f.bg_video_shadow);
            }
            this.gtj.setLayoutParams(layoutParams);
        }
    }

    public void blZ() {
        if (!com.baidu.adp.lib.util.j.kX()) {
            com.baidu.adp.lib.util.l.S(this.mActivity, this.mActivity.getString(e.j.neterror));
        } else if (this.bJN.isPlaying()) {
            pausePlay();
            if (this.gtE != null) {
                this.gtE.onPause();
            }
            if (this.gtw != null) {
                this.gtw.onPaused();
            }
        } else if (this.fgm) {
            aXE();
            if (this.gcT != null) {
                this.gcT.aBQ();
            }
            if (this.gtw != null) {
                this.gtw.XG();
            }
        } else {
            bpI();
        }
    }

    public boolean bpA() {
        return this.fgE;
    }

    public void aXv() {
        this.fgE = true;
        if (this.bEH != null) {
            this.bEH.aXv();
        }
    }

    public boolean bpB() {
        return this.cML != null && this.cML.getVideoHeight() > this.cML.getVideoWidth();
    }

    public boolean sy(int i2) {
        switch (i2) {
            case 4:
                if (this.bEK) {
                    if (bpB()) {
                        mc(false);
                        bpD();
                    } else {
                        aXv();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.fgw <= 0 || this.fgt == null) {
                    return false;
                }
                this.fgB = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.fgB * 100.0d) / this.fgw);
                this.fgt.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bJN;
    }

    public VideoListMediaControllerView aXw() {
        return this.ffX;
    }

    public void show() {
        this.ffV.setVisibility(0);
    }

    public void aXA() {
        if (this.fgg != null) {
            ViewGroup.LayoutParams layoutParams = this.fgg.getLayoutParams();
            this.fga = (FrameLayout.LayoutParams) this.ffV.getLayoutParams();
            this.fga.width = layoutParams.width;
            this.fga.height = layoutParams.height;
            this.fga.topMargin = 0;
            this.ffV.setLayoutParams(this.fga);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.fgE) {
            if (this.bEK) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.fgE = false;
        }
        if (configuration.orientation == 2) {
            bpC();
        } else {
            bpD();
        }
        bpE();
        aXE();
        bpR();
        aXJ();
        if (this.gtB != null) {
            this.gtB.hh(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpC() {
        this.bEK = true;
        if (bpB()) {
            this.ffV.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.ffV.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        e(this.mActivity, true);
        this.cPA.setVisibility(0);
        this.fgk.setVisibility(0);
        this.fgl.setVisibility(0);
        this.ffZ.setVisibility(8);
        this.bkI.bqK();
        this.fgh.setVisibility(8);
        this.fgd.setImageResource(e.f.icon_video_narrow_white);
        qk(this.fgA);
        aXu();
        if (this.gtt != null) {
            this.gtt.XD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpD() {
        this.bEK = false;
        if (this.fga != null) {
            this.ffV.setLayoutParams(this.fga);
        }
        e(this.mActivity, false);
        this.cPA.setVisibility(8);
        this.ffZ.setVisibility(0);
        this.bkI.bqK();
        this.fgh.setVisibility(8);
        this.fgd.setImageResource(e.f.icon_video_enlarge_white);
        if (this.ffX != null && (this.ffX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffX.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0175e.tbds24);
            layoutParams.rightMargin = 0;
            this.ffX.setLayoutParams(layoutParams);
        }
        this.ffV.setSystemUiVisibility(0);
        bpx();
        if (this.gtt != null) {
            this.gtt.XE();
        }
    }

    public void bpE() {
        if (this.bJN != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.bEK) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.gti.setMax(aO);
            int duration = this.bJN.getDuration();
            if (duration > 0) {
                if (this.gtl.getVisibility() == 0) {
                    this.gti.setProgress(this.gti.getMax());
                } else {
                    this.gti.setProgress((int) ((this.bJN.getCurrentPosition() * this.gti.getMax()) / duration));
                }
            }
        }
    }

    private void qk(int i2) {
        if (this.ffX != null && (this.ffX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffX.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.ffX.setLayoutParams(layoutParams);
        }
    }

    private void e(Activity activity, boolean z) {
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

    public boolean aXC() {
        return !this.bEK;
    }

    public void a(g.f fVar) {
        this.fgi = fVar;
    }

    public void a(g.a aVar) {
        this.gto = aVar;
    }

    public void a(g.b bVar) {
        this.gtp = bVar;
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bJN != null) {
            this.bJN.setPbLoadingTime(currentTimeMillis);
        }
        aW(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.gtI) {
            cn(str, str2);
        } else {
            aW(str, str2);
        }
        if (eVar != null) {
            eVar.ml(z);
        }
    }

    public void cm(String str, String str2) {
    }

    public void aW(String str, String str2) {
        bpJ();
        this.gtN = true;
        this.currentState = 0;
        this.bJN.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bJN.setVideoPath(str, str2);
        this.cMN.bbu();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgI);
        if (this.gtv > 0) {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.fgI, this.gtv);
        }
        if (this.gtw != null) {
            this.gtw.onStarted();
        }
        this.bkI.startLoading();
        md(true);
    }

    public void cn(String str, String str2) {
        bpJ();
        this.gtN = true;
        this.currentState = 0;
        this.bJN.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgI);
        if (this.gtv > 0) {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.fgI, this.gtv);
        }
        if (this.gtw != null) {
            this.gtw.onStarted();
        }
        this.bkI.startLoading();
        md(true);
    }

    public void aXE() {
        int i2 = 100;
        if (this.bJN != null && this.ffX != null) {
            this.fgm = true;
            this.currentState = 1;
            this.bJN.setRecoveryState(1);
            this.bJN.start();
            if (this.cML != null && this.ffX != null) {
                this.mStartPosition = y.bqO().tp(this.aAy);
                if (this.mStartPosition != 0 && !this.cML.isPlayerReuse()) {
                    this.gtH = true;
                }
                if (this.mStartPosition > 100 && this.cML.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.cMT = i2;
            } else {
                this.cMT = 100;
            }
            this.bkI.bqK();
            md(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kX() && this.gtL && !StringUtils.isNull(this.aAy) && !StringUtils.isNull(this.beh)) {
            this.gtL = false;
            this.gtM = true;
            aW(this.aAy, this.beh);
        }
    }

    private void md(boolean z) {
        if (z) {
            this.fgh.setVisibility(0);
            bpP();
            this.gti.setProgress(0);
        } else {
            this.fgh.setVisibility(8);
        }
        this.ffX.showProgress();
        this.ffY.setVisibility(8);
        this.gtm.setVisibility(8);
        this.gtl.setVisibility(8);
        this.gtn.setVisibility(8);
        this.cPF.setVisibility(8);
    }

    private void bpF() {
        this.bkI.bqK();
        this.gtm.setVisibility(8);
        this.gtl.setVisibility(8);
        this.gtn.setVisibility(8);
        bpR();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bJN != null) {
            this.bJN.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.bJN.pause();
        this.currentState = 2;
        this.bJN.setRecoveryState(2);
        bpF();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.bJN.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgG);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgI);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gtT);
        this.bJN.stopPlayback();
        this.fgm = false;
        this.gtN = false;
        this.mStartPosition = 0;
        aKH();
    }

    public void bpG() {
        if (this.bJN.getDuration() >= this.bJN.getCurrentPosition()) {
            y.bqO().aM(this.aAy, this.bJN.getCurrentPosition());
        }
    }

    public void me(boolean z) {
        this.gtG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(boolean z) {
        if (this.fge != null) {
            this.ffY.setVisibility(0);
            this.gtm.setVisibility(8);
            this.gtl.setVisibility(8);
            this.gtn.setVisibility(8);
            this.bkI.bqK();
            bpP();
            this.gti.setVisibility(8);
            this.cPF.setVisibility(8);
            this.ffX.UV();
            this.fgh.setVisibility(z ? 0 : 8);
        }
    }

    public void aKH() {
        mf(true);
    }

    public boolean bpH() {
        if (this.bJN == null) {
            return false;
        }
        return this.bJN.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bJN == null) {
            return 0;
        }
        return this.bJN.getCurrentPosition();
    }

    public void a(k kVar) {
        this.gtz = kVar;
    }

    public void a(j jVar) {
        this.gty = jVar;
    }

    public void a(i iVar) {
        this.gcT = iVar;
    }

    public void a(g gVar) {
        this.gtE = gVar;
    }

    public void a(h hVar) {
        this.gtx = hVar;
    }

    public void sQ(String str) {
        this.gct = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpI() {
        a(this.aAy, this.beh, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.gtu = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bpJ();
        if (com.baidu.adp.lib.util.j.kZ() && !com.baidu.tieba.video.g.bGn().bGo()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gtI = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gtD != null) {
                    this.gtD.gI(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.ej(TbadkCoreApplication.getInst().getString(e.j.play_video_mobile_tip));
                aVar.a(e.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bpK();
                        aVar2.dismiss();
                        c.this.a(eVar, false, str, str2);
                    }
                });
                aVar.b(e.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).Au();
                return;
            } else if (this.gtD != null) {
                this.gtD.gI(true);
                return;
            } else {
                if (!this.gth) {
                    this.gth = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, e.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.gtC != null) {
            this.gtC.aBN();
        }
    }

    private void bpJ() {
        if (com.baidu.adp.lib.util.j.kZ()) {
            com.baidu.tieba.video.g.bGn().dd(this.mActivity);
        }
    }

    public void bpK() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.fgh.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgM);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgG);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgI);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gtS);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gtT);
        this.bEH.stop();
        this.fgD.unregister(this.mActivity);
    }

    public void tk(String str) {
        this.fgl.setText(str);
    }

    public boolean aXF() {
        return this.fgm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpL() {
        if (this.fge != null) {
            if (this.gtq) {
                bpP();
            } else {
                bpO();
            }
        }
    }

    public void aXJ() {
        bpO();
        bpM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpM() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgM);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.fgM, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpN() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgM);
    }

    public void bpO() {
        if (this.fge != null && !this.gtq && !this.gtR) {
            mg(true);
            aXI();
            this.fge.setVisibility(0);
            this.gtj.setVisibility(0);
            this.gti.setVisibility(8);
            this.gtq = true;
            if (this.gtu != null) {
                this.gtu.gJ(false);
            }
        }
    }

    public void aXG() {
        if (this.fge != null && this.gtq) {
            mg(false);
            aXI();
            this.fge.setVisibility(8);
            this.gtj.setVisibility(8);
            this.gti.setVisibility(0);
            this.dFq.setAnimationListener(this.fgK);
            this.fge.startAnimation(this.dFq);
            this.gtq = false;
            if (this.gtu != null) {
                this.gtu.aBP();
            }
        }
    }

    public void bpP() {
        if (this.fge != null && this.gtq) {
            this.dFr.cancel();
            this.dFq.cancel();
            mg(false);
            aXI();
            this.fge.setVisibility(8);
            this.gtj.setVisibility(8);
            this.gti.setVisibility(0);
            this.gtq = false;
            if (this.gtu != null) {
                this.gtu.aBP();
            }
        }
    }

    private void aXI() {
        if (this.fge != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fgM);
            this.dFr.setAnimationListener(null);
            this.dFq.setAnimationListener(null);
            this.fge.clearAnimation();
        }
    }

    private void bpQ() {
        if (this.fge != null) {
            this.dFr.setAnimationListener(null);
            this.dFq.setAnimationListener(null);
            this.fge.clearAnimation();
        }
    }

    public void mg(boolean z) {
        bpR();
        if (z) {
            this.gtk.setVisibility(0);
        } else {
            this.gtk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpR() {
        if (this.currentState == 1) {
            this.gtk.setState(1);
        } else {
            this.gtk.setState(0);
        }
    }

    public void a(InterfaceC0258c interfaceC0258c) {
        this.gtt = interfaceC0258c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void Q(boolean z, boolean z2) {
        if (this.bEH != null) {
            if (this.fgd != null) {
                this.fgd.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.ffX != null && (this.ffX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffX.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0175e.tbds52);
                this.ffX.setLayoutParams(layoutParams);
            }
            this.bEH.mn(z);
        }
    }

    public int getScreenHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 == 0) {
            return com.baidu.adp.lib.util.l.aQ(context);
        }
        return i2;
    }

    public static int getVirtualBarHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
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

    public void mh(boolean z) {
        this.gtQ = z;
    }

    public void a(m mVar) {
        this.gtA = mVar;
    }

    public void a(a aVar) {
        this.gtB = aVar;
    }

    public void a(l lVar) {
        this.gtC = lVar;
    }

    public void a(f fVar) {
        this.gtD = fVar;
    }

    public void mi(boolean z) {
        this.gtK = z;
    }

    public boolean bpS() {
        return this.gtr;
    }

    public void mj(boolean z) {
        this.gtr = z;
    }

    public void sz(int i2) {
        this.gtO = i2;
    }

    public View bpT() {
        return this.ffV;
    }

    public void a(n nVar) {
        this.gtw = nVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.bJN != null) {
            this.bJN.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.fgB = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mk(boolean z) {
        this.gtR = z;
        if (z) {
            bpP();
        } else {
            aXJ();
        }
    }
}
