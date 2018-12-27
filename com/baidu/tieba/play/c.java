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
    private static int frG;
    private String aEO;
    private o bIZ;
    protected QuickVideoView bOq;
    private String biz;
    private x boU;
    private com.baidu.tieba.play.g cXo;
    private com.baidu.tieba.j.k cXq;
    private Animation dPS;
    private Animation dPT;
    private String daG;
    private View dad;
    protected View dai;
    public View fqY;
    private int frA;
    private int frF;
    private CallStateReceiver frH;
    private VideoListMediaControllerView fra;
    private View frb;
    private FrameLayout frc;
    protected FrameLayout.LayoutParams frd;
    private ImageView frg;
    private View frh;
    private View frj;
    private TbImageView frk;
    private g.f frl;
    private ImageView frn;
    private TextView fro;
    private View fru;
    private View frv;
    private TextView frw;
    private SeekBar frx;
    private ImageView fry;
    private ImageView frz;
    protected InterfaceC0297c gEA;
    private d gEB;
    private n gED;
    private h gEE;
    private j gEF;
    private k gEG;
    private m gEH;
    private a gEI;
    private l gEJ;
    private f gEK;
    private g gEL;
    private TextView gEQ;
    private boolean gES;
    private boolean gET;
    private boolean gEU;
    private int gEV;
    private boolean gEW;
    private boolean gEX;
    private ProgressBar gEp;
    private View gEq;
    private SwitchImageView gEr;
    private TextView gEs;
    private TextView gEt;
    private TextView gEu;
    private g.a gEv;
    private g.b gEw;
    private View.OnClickListener gEz;
    private i gnY;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int cXw = 100;
    private boolean gEo = false;
    protected boolean bJc = false;
    private boolean frp = false;
    private boolean gEx = false;
    private boolean gEy = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int frB = 0;
    private int frC = 0;
    private long gEC = 60000;
    private int frE = 0;
    private boolean frI = false;
    private boolean gEM = true;
    private boolean gEN = true;
    private boolean gEO = false;
    private boolean gEP = false;
    private String gnz = null;
    private int currentState = -1;
    private boolean gER = false;
    private boolean gEY = false;
    private g.f bxM = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cXo = gVar;
            c.this.cXq.bdy();
            c.this.aqa();
        }
    };
    private g.e bxO = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3) {
                c.this.bry();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a cXA = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aqa();
        }
    };
    private Runnable frK = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.frK);
            if (!c.this.frp) {
                if (c.this.bOq.getCurrentPosition() > c.this.cXw) {
                    c.this.bry();
                } else {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.frK, 20L);
                }
            }
        }
    };
    private g.a bxL = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bOq != null) {
                int duration = c.this.bOq.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.frp = false;
                    c.this.gEU = false;
                    c.this.mStartPosition = 0;
                    c.this.aZt();
                    c.this.frb.setVisibility(0);
                    c.this.gEp.setProgress(c.this.gEp.getMax());
                    c.this.cXw = 100;
                    if (c.this.gEv != null) {
                        c.this.gEv.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.bOq.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.mw(false);
                        c.this.mx(true);
                    } else {
                        c.this.brP();
                        c.this.gEs.setVisibility(0);
                    }
                    if (!c.this.bJc && duration <= 150000) {
                        if (!c.this.gER) {
                            if (c.this.gEF != null) {
                                c.this.gEF.lT(true);
                            }
                            c.this.aZ(c.this.aEO, c.this.biz);
                        } else {
                            c.this.currentState = 5;
                            c.this.bOq.setRecoveryState(5);
                            c.this.bOq.getPlayer().pause();
                            c.this.bOq.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.gED != null) {
                        c.this.gED.ie(c.this.gEp.getMax());
                        c.this.gED.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b frL = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.dai.setVisibility(0);
            c.this.boU.bsK();
            c.this.currentState = 4;
            c.this.bOq.setRecoveryState(4);
            if (c.this.gEw != null) {
                c.this.gEw.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kV()) {
                c.this.gES = true;
            }
            if (c.this.gED != null) {
                c.this.gED.YU();
            }
            c.this.gEU = false;
            return true;
        }
    };
    protected Runnable frM = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bOq == null || !c.this.bOq.isPlaying()) {
                c.this.dai.setVisibility(0);
                c.this.boU.bsK();
                if (c.this.gED != null) {
                    c.this.gED.YU();
                }
            }
        }
    };
    private g.InterfaceC0298g bxP = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0298g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gEO) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gEZ, 200L);
            }
        }
    };
    private Runnable gEZ = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bOq == null || !c.this.gEO) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.frK, 200L);
                c.this.gEO = false;
            } else if (c.this.mStartPosition != c.this.bOq.getCurrentPosition()) {
                c.this.gEO = false;
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.frK, 20L);
            } else {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gEZ, 200L);
            }
        }
    };
    private QuickVideoView.b bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.frp = false;
            if (c.this.gEy) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gFa, 300L);
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.frK);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.frM);
        }
    };
    private Runnable gFa = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.gEU = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.dai.getId()) {
                if (view.getId() != c.this.gEr.getId()) {
                    if (view.getId() == c.this.gEt.getId()) {
                        if (c.this.gEE != null) {
                            c.this.gEE.bol();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.gEs.getId()) {
                        if (c.this.gEF != null) {
                            c.this.gEF.lT(false);
                        }
                        c.this.aZ(c.this.aEO, c.this.biz);
                        return;
                    } else if (view.getId() == c.this.frg.getId()) {
                        int i2 = c.this.gEy ? 1 : 2;
                        if (c.this.bJc) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").aA("tid", c.this.biz).aA(ImageViewerConfig.FORUM_ID, c.this.daG).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").aA("tid", c.this.biz).aA(ImageViewerConfig.FORUM_ID, c.this.daG).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.gEJ != null) {
                            c.this.gEJ.aDK();
                        }
                        if (c.this.brA()) {
                            if (c.this.bJc) {
                                c.this.brC();
                            } else {
                                c.this.brB();
                            }
                            c.this.mt(c.this.bJc);
                            return;
                        }
                        c.this.aZx();
                        return;
                    } else if (view.getId() != c.this.frn.getId()) {
                        if (c.this.gEz != null) {
                            c.this.gEz.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.gEJ != null) {
                            c.this.gEJ.aDK();
                        }
                        if (c.this.brA()) {
                            c.this.brC();
                            c.this.mt(false);
                            return;
                        }
                        c.this.aZx();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bnZ();
                c.this.brR();
                if (c.this.currentState != 1) {
                    c.this.brN();
                    c.this.brO();
                } else {
                    c.this.aZL();
                }
                if (c.this.gEI != null) {
                    c.this.gEI.hw(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.bOq.stopPlayback();
            c.this.frp = false;
            c.this.brI();
        }
    };
    private Animation.AnimationListener frO = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener frP = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable frQ = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.aZI();
        }
    };
    private CustomMessageListener frR = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b ftM = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void hJ(int i2) {
            int duration;
            if (c.this.bOq != null && (duration = c.this.bOq.getDuration()) > 0 && c.this.gEp != null) {
                c.this.gEp.setProgress((int) ((i2 * c.this.fqY.getWidth()) / duration));
                if (c.this.gED != null) {
                    c.this.gED.ie((c.this.bOq.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener bCa = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.brN();
            c.this.mx(false);
            if (c.this.gEI != null) {
                c.this.gEI.hw(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.aZy() != null) {
                c.this.setStartPosition(c.this.aZy().getSeekPosition());
                if (!c.this.aZH()) {
                    c.this.brI();
                } else {
                    c.this.aZG();
                    if (c.this.gnY != null) {
                        c.this.gnY.aDM();
                    }
                }
            }
            c.this.mx(true);
            c.this.brM();
            if (c.this.gEI != null) {
                c.this.gEI.hw(true);
            }
        }
    };
    private QuickVideoView.a gFb = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void brU() {
            if (!c.this.gER) {
                c.this.boU.startLoading();
                c.this.frk.setVisibility(0);
                c.this.gEr.setVisibility(8);
                c.this.gEt.setVisibility(8);
                c.this.gEs.setVisibility(8);
                c.this.gEu.setVisibility(8);
                c.this.dai.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.frM);
                if (c.this.gEC > 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.frM, c.this.gEC);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void hw(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0297c {
        void YS();

        void YT();
    }

    /* loaded from: classes.dex */
    public interface d {
        void aDL();

        void gX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void mC(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void gW(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void bol();
    }

    /* loaded from: classes.dex */
    public interface i {
        void aDM();
    }

    /* loaded from: classes.dex */
    public interface j {
        void lT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void aDJ();

        void aDK();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean boj();

        boolean bok();
    }

    /* loaded from: classes.dex */
    public interface n {
        void YU();

        void YV();

        void ie(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    public c(Activity activity, View view, boolean z) {
        this.gEW = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.gEW = z;
            this.frj = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.gEW = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.gEW = z;
            this.frj = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.fqY = Q(this.mActivity);
        this.fqY.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.fqY);
        }
        this.bOq = (QuickVideoView) this.fqY.findViewById(e.g.videoView);
        this.boU = new x((ViewGroup) this.fqY.findViewById(e.g.auto_video_loading_container));
        this.boU.setLoadingAnimationListener(this.cXA);
        this.fra = (VideoListMediaControllerView) this.fqY.findViewById(e.g.media_controller);
        this.fra.setPlayer(this.bOq);
        this.gEp = (ProgressBar) this.fqY.findViewById(e.g.pgrBottomProgress);
        this.gEp.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.gEp.setProgress(0);
        this.fra.setOnSeekBarChangeListener(this.bCa);
        this.fra.setOnProgressUpdatedListener(this.ftM);
        this.frb = this.fqY.findViewById(e.g.black_mask);
        this.dai = this.fqY.findViewById(e.g.layout_error);
        this.dai.setOnClickListener(this.mOnClickListener);
        this.gEQ = (TextView) this.fqY.findViewById(e.g.auto_video_error_tips);
        this.frc = (FrameLayout) this.fqY.findViewById(e.g.danmu_container);
        this.frg = (ImageView) this.fqY.findViewById(e.g.img_full_screen);
        this.frg.setOnClickListener(this.mOnClickListener);
        this.frh = this.fqY.findViewById(e.g.layout_media_controller);
        this.gEq = this.fqY.findViewById(e.g.time_show_controller);
        this.bOq.setPlayerReuseEnable(true);
        this.bOq.setContinuePlayEnable(true);
        this.bOq.setOnPreparedListener(this.bxM);
        this.bOq.setOnCompletionListener(this.bxL);
        this.bOq.setOnErrorListener(this.frL);
        this.bOq.setOnSeekCompleteListener(this.bxP);
        this.bOq.setOnSurfaceDestroyedListener(this.bpd);
        this.bOq.setOnRecoveryCallback(this.gFb);
        this.bOq.setOnOutInfoListener(this.bxO);
        this.gEr = (SwitchImageView) this.fqY.findViewById(e.g.img_play_controller);
        this.gEr.setStateImage(e.f.btn_card_play_video_n, e.f.btn_card_stop_video_n);
        this.gEr.setState(0);
        this.gEr.setOnClickListener(this.mOnClickListener);
        this.gEs = (TextView) this.fqY.findViewById(e.g.txt_replay);
        this.gEs.setOnClickListener(this.mOnClickListener);
        this.gEt = (TextView) this.fqY.findViewById(e.g.txt_playnext);
        this.gEt.setOnClickListener(this.mOnClickListener);
        this.gEu = (TextView) this.fqY.findViewById(e.g.txt_next_video_title);
        this.frk = (TbImageView) this.fqY.findViewById(e.g.video_thumbnail);
        this.frk.setDefaultErrorResource(0);
        this.frk.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.frn = (ImageView) this.fqY.findViewById(e.g.img_exit);
        this.frn.setOnClickListener(this.mOnClickListener);
        this.fro = (TextView) this.fqY.findViewById(e.g.video_title);
        this.dad = this.fqY.findViewById(e.g.layout_title);
        this.dad.setVisibility(8);
        this.dPS = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.dPT = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.frA = this.mAudioManager.getStreamMaxVolume(3);
        this.frF = this.mAudioManager.getStreamVolume(3);
        frG = 100 / this.frA;
        this.fqY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.gEG != null) {
                    c.this.gEG.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.frp) {
                        if (c.this.mStatus == 1 && c.this.frC != 0) {
                            c.this.b(c.this.frC == 1 ? 1000.0f : -1000.0f, false);
                            c.this.frC = 0;
                            c.this.frB = 0;
                        }
                        if (!c.this.bOq.isPlaying()) {
                            c.this.gEt.setVisibility(8);
                            c.this.gEs.setVisibility(8);
                            c.this.gEu.setVisibility(8);
                        }
                    }
                    c.this.aZt();
                    if (c.this.gEG != null) {
                        c.this.gEG.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.bIZ = new o(this.mActivity);
        if (this.gEW) {
            this.bIZ.start();
        }
        this.frE = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.ds16);
        this.frH = new CallStateReceiver();
        this.frH.register(this.mActivity);
        brw();
        this.cXq = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.frR);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.frR);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void brw() {
        if (this.gEM) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fqY.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.fqY.setSystemUiVisibility(0);
    }

    public void ms(boolean z) {
        this.gEM = z;
        brw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZt() {
        this.mStatus = 0;
        if (this.fru != null && this.fru.getParent() != null && (this.fru.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fru.getParent()).removeView(this.fru);
                this.fru = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.frv != null && this.frv.getParent() != null && (this.frv.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.frv.getParent()).removeView(this.frv);
                this.frv = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aZu() {
        if (this.mStatus == 1) {
            if (this.fru == null && this.fqY != null && (this.fqY instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_jindu, (ViewGroup) this.fqY, true);
                this.fru = this.fqY.findViewById(e.g.lay_jindu);
                this.frw = (TextView) this.fru.findViewById(e.g.show_time);
                this.frz = (ImageView) this.fru.findViewById(e.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.frv == null && this.fqY != null && (this.fqY instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_voice, (ViewGroup) this.fqY, true);
            this.frv = this.fqY.findViewById(e.g.lay_voice);
            this.fry = (ImageView) this.frv.findViewById(e.g.arrow_voice_icon);
            this.frx = (SeekBar) this.frv.findViewById(e.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.gEz = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gEG != null) {
                c.this.gEG.onStart();
            }
            if (c.this.bJc && c.this.frp) {
                if (c.this.mStatus == 1) {
                    c.this.brP();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.au(f2);
                    }
                } else {
                    if (c.this.bJc) {
                        c.this.aZw();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.frB = c.this.bOq.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.au(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.gEX) {
                if (c.this.gEH != null && c.this.gEH.boj()) {
                    return true;
                }
                c.this.bnZ();
                c.this.brR();
                if (c.this.bOq.isPlaying()) {
                    c.this.brM();
                } else {
                    c.this.brN();
                }
                if (c.this.gEI != null) {
                    c.this.gEI.hw(c.this.bOq.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.gEX) {
                if (c.this.frp) {
                    if (c.this.gEH != null && c.this.gEH.bok()) {
                        return true;
                    }
                    c.this.brL();
                    if (c.this.bOq.isPlaying()) {
                        c.this.brM();
                    } else {
                        c.this.brN();
                    }
                    if (c.this.gEI != null) {
                        c.this.gEI.hw(c.this.bOq.isPlaying());
                    }
                } else {
                    c.this.bnZ();
                    c.this.brR();
                    if (c.this.currentState != 1) {
                        c.this.brN();
                        c.this.brO();
                    } else {
                        c.this.aZL();
                    }
                    if (c.this.gEI != null) {
                        c.this.gEI.hw(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        if (Build.VERSION.SDK_INT < 16) {
            this.fqY.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.fqY.setSystemUiVisibility(4);
        } else {
            this.fqY.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.frp) {
            this.mStatus = 0;
            return;
        }
        aZu();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % frG == 0) {
            if (f2 > 0.0f && this.frF < this.frA) {
                this.frF++;
            }
            if (f2 < 0.0f && this.frF > 0) {
                this.frF--;
            }
        }
        if (this.mProgress > 0) {
            this.fry.setImageResource(e.f.icon_shengyin_open);
        } else {
            this.fry.setImageResource(e.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.frF, 0);
        this.frx.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.frB += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.frC = 1;
            } else {
                this.frB += 1000;
                this.frC = 2;
            }
            if (this.frB < 0) {
                this.frB = 0;
            } else if (this.frB > this.bOq.getDuration()) {
                this.frB = this.bOq.getDuration();
            }
        }
        aZu();
        String tC = this.fra.tC(this.frB);
        if (f2 > 0.0f) {
            this.frz.setImageResource(e.f.icon_kuaitui);
        } else {
            this.frz.setImageResource(e.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tC)) {
            this.frw.setText(new StringBuilder().append(tC).append("/").append(this.fra.tC(this.bOq.getDuration())));
        }
        this.fra.setCurrentDuration(this.frB, z ? false : true);
        brP();
        brD();
    }

    protected View Q(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(e.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.aEO = str;
        this.biz = str2;
    }

    public void brx() {
        if (this.bOq != null) {
            this.bOq.brx();
        }
    }

    public void setFid(String str) {
        this.daG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqa() {
        int i2 = 100;
        if (this.bOq != null && this.cXo != null && this.fra != null) {
            this.fra.showProgress();
            this.mStartPosition = y.bsO().tZ(this.aEO);
            if (this.gEU) {
                this.cXo.setVolume(1.0f, 1.0f);
                this.bOq.start();
                this.gEU = false;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frK);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.frK, 20L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gFa);
                if (this.bOq.bsk()) {
                    this.currentState = 1;
                    this.bOq.setRecoveryState(1);
                    brP();
                }
                this.mStartPosition = y.bsO().tZ(this.aEO);
                this.fra.setPlayer(this.bOq);
                if (this.mStartPosition != 0 && !this.cXo.isPlayerReuse()) {
                    this.gEO = true;
                }
                if (!this.gET) {
                    this.fra.showProgress();
                }
                if (this.cXo.getDuration() <= 0) {
                    aZy().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.cXo.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.cXw = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bry() {
        if (!this.frp) {
            this.frp = true;
            this.frb.setVisibility(8);
            this.dai.setVisibility(8);
            this.boU.bsJ();
            this.frk.setVisibility(8);
            brQ();
            if (brS()) {
                this.cXq.a(this.biz, -1L, this.bOq.getDuration() / 1000, "middle", this.bOq);
            }
            this.fra.showProgress();
            this.gEp.setVisibility(0);
            if (this.frl != null) {
                this.frl.onPrepared(this.bOq.getPlayer());
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
    public void mt(boolean z) {
        if (hasNavBar(this.mActivity)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEq.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.gEq.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gEq.setBackgroundResource(e.f.bg_video_shadow);
            }
            this.gEq.setLayoutParams(layoutParams);
        }
    }

    public void bnZ() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.S(this.mActivity, this.mActivity.getString(e.j.neterror));
        } else if (this.bOq.isPlaying()) {
            pausePlay();
            if (this.gEL != null) {
                this.gEL.onPause();
            }
            if (this.gED != null) {
                this.gED.onPaused();
            }
        } else if (this.frp) {
            aZG();
            if (this.gnY != null) {
                this.gnY.aDM();
            }
            if (this.gED != null) {
                this.gED.YV();
            }
        } else {
            brI();
        }
    }

    public boolean brz() {
        return this.frI;
    }

    public void aZx() {
        this.frI = true;
        if (this.bIZ != null) {
            this.bIZ.aZx();
        }
    }

    public boolean brA() {
        return this.cXo != null && this.cXo.getVideoHeight() > this.cXo.getVideoWidth();
    }

    public boolean ty(int i2) {
        switch (i2) {
            case 4:
                if (this.bJc) {
                    if (brA()) {
                        mt(false);
                        brC();
                    } else {
                        aZx();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.frA <= 0 || this.frx == null) {
                    return false;
                }
                this.frF = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.frF * 100.0d) / this.frA);
                this.frx.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bOq;
    }

    public VideoListMediaControllerView aZy() {
        return this.fra;
    }

    public void show() {
        this.fqY.setVisibility(0);
    }

    public void aZC() {
        if (this.frj != null) {
            ViewGroup.LayoutParams layoutParams = this.frj.getLayoutParams();
            this.frd = (FrameLayout.LayoutParams) this.fqY.getLayoutParams();
            this.frd.width = layoutParams.width;
            this.frd.height = layoutParams.height;
            this.frd.topMargin = 0;
            this.fqY.setLayoutParams(this.frd);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.frI) {
            if (this.bJc) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.frI = false;
        }
        if (configuration.orientation == 2) {
            brB();
        } else {
            brC();
        }
        brD();
        aZG();
        brR();
        aZL();
        if (this.gEI != null) {
            this.gEI.hw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void brB() {
        this.bJc = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (brA()) {
            this.fqY.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.fqY.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        e(this.mActivity, true);
        this.dad.setVisibility(0);
        this.frn.setVisibility(0);
        this.fro.setVisibility(0);
        this.frc.setVisibility(8);
        this.boU.bsK();
        this.frk.setVisibility(8);
        this.frg.setImageResource(e.f.icon_video_narrow_white);
        rk(this.frE);
        aZw();
        if (this.gEA != null) {
            this.gEA.YS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void brC() {
        this.bJc = false;
        if (this.frd != null) {
            this.fqY.setLayoutParams(this.frd);
        }
        e(this.mActivity, false);
        this.dad.setVisibility(8);
        this.frc.setVisibility(0);
        this.boU.bsK();
        this.frk.setVisibility(8);
        this.frg.setImageResource(e.f.icon_video_enlarge_white);
        if (this.fra != null && (this.fra.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fra.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds24);
            layoutParams.rightMargin = 0;
            this.fra.setLayoutParams(layoutParams);
        }
        this.fqY.setSystemUiVisibility(0);
        brw();
        if (this.gEA != null) {
            this.gEA.YT();
        }
    }

    public void brD() {
        if (this.bOq != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.bJc) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.gEp.setMax(aO);
            int duration = this.bOq.getDuration();
            if (duration > 0) {
                if (this.gEs.getVisibility() == 0) {
                    this.gEp.setProgress(this.gEp.getMax());
                } else {
                    this.gEp.setProgress((int) ((this.bOq.getCurrentPosition() * this.gEp.getMax()) / duration));
                }
            }
        }
    }

    private void rk(int i2) {
        if (this.fra != null && (this.fra.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fra.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.fra.setLayoutParams(layoutParams);
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

    public boolean aZE() {
        return !this.bJc;
    }

    public void a(g.f fVar) {
        this.frl = fVar;
    }

    public void a(g.a aVar) {
        this.gEv = aVar;
    }

    public void a(g.b bVar) {
        this.gEw = bVar;
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bOq != null) {
            this.bOq.setPbLoadingTime(currentTimeMillis);
        }
        aZ(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.gEP) {
            cs(str, str2);
        } else {
            aZ(str, str2);
        }
        if (eVar != null) {
            eVar.mC(z);
        }
    }

    public void cr(String str, String str2) {
    }

    public void aZ(String str, String str2) {
        brJ();
        this.gEU = true;
        this.currentState = 0;
        this.bOq.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bOq.setVideoPath(str, str2);
        this.cXq.bdx();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        if (this.gEC > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.frM, this.gEC);
        }
        if (this.gED != null) {
            this.gED.onStarted();
        }
        this.boU.startLoading();
        mu(true);
    }

    public void cs(String str, String str2) {
        brJ();
        this.gEU = true;
        this.currentState = 0;
        this.bOq.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        if (this.gEC > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.frM, this.gEC);
        }
        if (this.gED != null) {
            this.gED.onStarted();
        }
        this.boU.startLoading();
        mu(true);
    }

    public void brE() {
        aZG();
        this.gEp.setVisibility(0);
    }

    public void aZG() {
        int i2 = 100;
        if (this.bOq != null && this.fra != null) {
            this.frp = true;
            this.currentState = 1;
            this.bOq.setRecoveryState(1);
            this.bOq.start();
            if (this.cXo != null && this.fra != null) {
                this.mStartPosition = y.bsO().tZ(this.aEO);
                if (this.mStartPosition != 0 && !this.cXo.isPlayerReuse()) {
                    this.gEO = true;
                }
                if (this.mStartPosition > 100 && this.cXo.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.cXw = i2;
            } else {
                this.cXw = 100;
            }
            this.boU.bsK();
            mu(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kV() && this.gES && !StringUtils.isNull(this.aEO) && !StringUtils.isNull(this.biz)) {
            this.gES = false;
            this.gET = true;
            aZ(this.aEO, this.biz);
        }
    }

    private void mu(boolean z) {
        if (z) {
            this.frk.setVisibility(0);
            brP();
            this.gEp.setProgress(0);
        } else {
            this.frk.setVisibility(8);
        }
        this.fra.showProgress();
        this.frb.setVisibility(8);
        this.gEt.setVisibility(8);
        this.gEs.setVisibility(8);
        this.gEu.setVisibility(8);
        this.dai.setVisibility(8);
    }

    private void brF() {
        this.boU.bsK();
        this.gEt.setVisibility(8);
        this.gEs.setVisibility(8);
        this.gEu.setVisibility(8);
        brR();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bOq != null) {
            this.bOq.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.bOq.pause();
        this.currentState = 2;
        this.bOq.setRecoveryState(2);
        brF();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.bOq.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frK);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gFa);
        this.bOq.stopPlayback();
        this.frp = false;
        this.gEU = false;
        this.mStartPosition = 0;
        aMK();
    }

    public void brG() {
        if (this.bOq.getDuration() >= this.bOq.getCurrentPosition()) {
            y.bsO().aO(this.aEO, this.bOq.getCurrentPosition());
        }
    }

    public void mv(boolean z) {
        this.gEN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        if (this.frh != null) {
            this.frb.setVisibility(0);
            this.gEt.setVisibility(8);
            this.gEs.setVisibility(8);
            this.gEu.setVisibility(8);
            this.boU.bsK();
            brP();
            this.gEp.setVisibility(8);
            this.dai.setVisibility(8);
            this.fra.Wm();
            this.frk.setVisibility(z ? 0 : 8);
        }
    }

    public void aMK() {
        mw(true);
    }

    public boolean brH() {
        if (this.bOq == null) {
            return false;
        }
        return this.bOq.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bOq == null) {
            return 0;
        }
        return this.bOq.getCurrentPosition();
    }

    public void a(k kVar) {
        this.gEG = kVar;
    }

    public void a(j jVar) {
        this.gEF = jVar;
    }

    public void a(i iVar) {
        this.gnY = iVar;
    }

    public void a(g gVar) {
        this.gEL = gVar;
    }

    public void a(h hVar) {
        this.gEE = hVar;
    }

    public void tw(String str) {
        this.gnz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brI() {
        a(this.aEO, this.biz, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.gEB = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        brJ();
        if (com.baidu.adp.lib.util.j.kX() && !com.baidu.tieba.video.g.bIG().bIH()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gEP = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gEK != null) {
                    this.gEK.gW(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.eB(TbadkCoreApplication.getInst().getString(e.j.play_video_mobile_tip));
                aVar.a(e.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.brK();
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
                aVar.b(this.mContext).BF();
                return;
            } else if (this.gEK != null) {
                this.gEK.gW(true);
                return;
            } else {
                if (!this.gEo) {
                    this.gEo = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, e.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.gEJ != null) {
            this.gEJ.aDJ();
        }
    }

    private void brJ() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bIG().dc(this.mActivity);
        }
    }

    public void brK() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.frk.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frQ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frK);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frM);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gEZ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gFa);
        this.bIZ.stop();
        this.frH.unregister(this.mActivity);
    }

    public void tU(String str) {
        this.fro.setText(str);
    }

    public boolean aZH() {
        return this.frp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brL() {
        if (this.frh != null) {
            if (this.gEx) {
                brP();
            } else {
                brO();
            }
        }
    }

    public void aZL() {
        brO();
        brM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frQ);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.frQ, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brN() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frQ);
    }

    public void brO() {
        if (this.frh != null && !this.gEx && !this.gEY) {
            mx(true);
            aZK();
            this.frh.setVisibility(0);
            this.gEq.setVisibility(0);
            this.gEp.setVisibility(8);
            this.gEx = true;
            if (this.gEB != null) {
                this.gEB.gX(false);
            }
        }
    }

    public void aZI() {
        if (this.frh != null && this.gEx) {
            mx(false);
            aZK();
            this.frh.setVisibility(8);
            this.gEq.setVisibility(8);
            this.gEp.setVisibility(0);
            this.dPS.setAnimationListener(this.frO);
            this.frh.startAnimation(this.dPS);
            this.gEx = false;
            if (this.gEB != null) {
                this.gEB.aDL();
            }
        }
    }

    public void brP() {
        if (this.frh != null && this.gEx) {
            this.dPT.cancel();
            this.dPS.cancel();
            mx(false);
            aZK();
            this.frh.setVisibility(8);
            this.gEq.setVisibility(8);
            this.gEp.setVisibility(0);
            this.gEx = false;
            if (this.gEB != null) {
                this.gEB.aDL();
            }
        }
    }

    private void aZK() {
        if (this.frh != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.frQ);
            this.dPT.setAnimationListener(null);
            this.dPS.setAnimationListener(null);
            this.frh.clearAnimation();
        }
    }

    private void brQ() {
        if (this.frh != null) {
            this.dPT.setAnimationListener(null);
            this.dPS.setAnimationListener(null);
            this.frh.clearAnimation();
        }
    }

    public void mx(boolean z) {
        brR();
        if (z) {
            this.gEr.setVisibility(0);
        } else {
            this.gEr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brR() {
        if (this.currentState == 1) {
            this.gEr.setState(1);
        } else {
            this.gEr.setState(0);
        }
    }

    public void a(InterfaceC0297c interfaceC0297c) {
        this.gEA = interfaceC0297c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void S(boolean z, boolean z2) {
        if (this.bIZ != null) {
            if (this.frg != null) {
                this.frg.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.fra != null && (this.fra.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fra.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds52);
                this.fra.setLayoutParams(layoutParams);
            }
            this.bIZ.mE(z);
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

    public void my(boolean z) {
        this.gEX = z;
    }

    public void a(m mVar) {
        this.gEH = mVar;
    }

    public void a(a aVar) {
        this.gEI = aVar;
    }

    public void a(l lVar) {
        this.gEJ = lVar;
    }

    public void a(f fVar) {
        this.gEK = fVar;
    }

    public void mz(boolean z) {
        this.gER = z;
    }

    public boolean brS() {
        return this.gEy;
    }

    public void mA(boolean z) {
        this.gEy = z;
    }

    public void tz(int i2) {
        this.gEV = i2;
    }

    public View brT() {
        return this.fqY;
    }

    public void a(n nVar) {
        this.gED = nVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.bOq != null) {
            this.bOq.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.frF = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mB(boolean z) {
        this.gEY = z;
        if (z) {
            brP();
        } else {
            aZL();
        }
    }
}
