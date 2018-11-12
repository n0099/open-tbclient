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
    private static int fhV;
    private String aBn;
    private o bFt;
    protected QuickVideoView bKy;
    private String beV;
    private x blt;
    private com.baidu.tieba.play.g cNR;
    private com.baidu.tieba.j.k cNT;
    private View cQG;
    protected View cQL;
    private String cRh;
    private Animation dGF;
    private Animation dGG;
    private TbImageView fhA;
    private g.f fhB;
    private ImageView fhD;
    private TextView fhE;
    private View fhJ;
    private View fhK;
    private TextView fhL;
    private SeekBar fhM;
    private ImageView fhN;
    private ImageView fhO;
    private int fhP;
    private int fhU;
    private CallStateReceiver fhW;
    public View fho;
    private VideoListMediaControllerView fhq;
    private View fhr;
    private FrameLayout fhs;
    protected FrameLayout.LayoutParams fht;
    private ImageView fhw;
    private View fhx;
    private View fhz;
    private i geq;
    private ProgressBar guI;
    private View guJ;
    private SwitchImageView guK;
    private TextView guL;
    private TextView guM;
    private TextView guN;
    private g.a guO;
    private g.b guP;
    private View.OnClickListener guS;
    protected InterfaceC0286c guT;
    private d guU;
    private n guW;
    private h guX;
    private j guY;
    private k guZ;
    private m gva;
    private a gvb;
    private l gvc;
    private f gvd;
    private g gve;
    private TextView gvj;
    private boolean gvl;
    private boolean gvm;
    private boolean gvn;
    private int gvo;
    private boolean gvp;
    private boolean gvq;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int cNZ = 100;
    private boolean guH = false;
    protected boolean bFw = false;
    private boolean fhF = false;
    private boolean guQ = false;
    private boolean guR = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int fhQ = 0;
    private int fhR = 0;
    private long guV = 60000;
    private int fhT = 0;
    private boolean fhX = false;
    private boolean gvf = true;
    private boolean gvg = true;
    private boolean gvh = false;
    private boolean gvi = false;
    private String gdQ = null;
    private int currentState = -1;
    private boolean gvk = false;
    private boolean gvr = false;
    private g.f bum = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cNR = gVar;
            c.this.cNT.baU();
            c.this.any();
        }
    };
    private g.e buo = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3) {
                c.this.boU();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a cOd = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.any();
        }
    };
    private Runnable fhZ = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fhZ);
            if (!c.this.fhF) {
                if (c.this.bKy.getCurrentPosition() > c.this.cNZ) {
                    c.this.boU();
                } else {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fhZ, 20L);
                }
            }
        }
    };
    private g.a bul = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bKy != null) {
                int duration = c.this.bKy.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.fhF = false;
                    c.this.gvn = false;
                    c.this.mStartPosition = 0;
                    c.this.aWO();
                    c.this.fhr.setVisibility(0);
                    c.this.guI.setProgress(c.this.guI.getMax());
                    y.bqk().remove(c.this.aBn);
                    c.this.cNZ = 100;
                    if (c.this.guO != null) {
                        c.this.guO.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.bKy.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.mq(false);
                        c.this.mr(true);
                    } else {
                        c.this.bpl();
                        c.this.guL.setVisibility(0);
                    }
                    if (!c.this.bFw && duration <= 150000) {
                        if (!c.this.gvk) {
                            if (c.this.guY != null) {
                                c.this.guY.lN(true);
                            }
                            c.this.aW(c.this.aBn, c.this.beV);
                        } else {
                            c.this.currentState = 5;
                            c.this.bKy.setRecoveryState(5);
                            c.this.bKy.getPlayer().pause();
                            c.this.bKy.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.guW != null) {
                        c.this.guW.hP(c.this.guI.getMax());
                        c.this.guW.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b fia = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cQL.setVisibility(0);
            c.this.blt.bqg();
            c.this.currentState = 4;
            c.this.bKy.setRecoveryState(4);
            if (c.this.guP != null) {
                c.this.guP.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kV()) {
                c.this.gvl = true;
            }
            if (c.this.guW != null) {
                c.this.guW.XP();
            }
            c.this.gvn = false;
            return true;
        }
    };
    protected Runnable fib = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bKy == null || !c.this.bKy.isPlaying()) {
                c.this.cQL.setVisibility(0);
                c.this.blt.bqg();
                if (c.this.guW != null) {
                    c.this.guW.XP();
                }
            }
        }
    };
    private g.InterfaceC0287g bup = new g.InterfaceC0287g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0287g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gvh) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gvs, 200L);
            }
        }
    };
    private Runnable gvs = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bKy == null || !c.this.gvh) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fhZ, 200L);
                c.this.gvh = false;
            } else if (c.this.mStartPosition != c.this.bKy.getCurrentPosition()) {
                c.this.gvh = false;
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fhZ, 20L);
            } else {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gvs, 200L);
            }
        }
    };
    private QuickVideoView.b blC = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fhF = false;
            if (c.this.guR) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gvt, 300L);
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fhZ);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fib);
        }
    };
    private Runnable gvt = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.gvn = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.cQL.getId()) {
                if (view.getId() != c.this.guK.getId()) {
                    if (view.getId() == c.this.guM.getId()) {
                        if (c.this.guX != null) {
                            c.this.guX.blH();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.guL.getId()) {
                        if (c.this.guY != null) {
                            c.this.guY.lN(false);
                        }
                        c.this.aW(c.this.aBn, c.this.beV);
                        return;
                    } else if (view.getId() == c.this.fhw.getId()) {
                        int i2 = c.this.guR ? 1 : 2;
                        if (c.this.bFw) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").ax("tid", c.this.beV).ax(ImageViewerConfig.FORUM_ID, c.this.cRh).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").ax("tid", c.this.beV).ax(ImageViewerConfig.FORUM_ID, c.this.cRh).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.gvc != null) {
                            c.this.gvc.aBl();
                        }
                        if (c.this.boW()) {
                            if (c.this.bFw) {
                                c.this.boY();
                            } else {
                                c.this.boX();
                            }
                            c.this.mn(c.this.bFw);
                            return;
                        }
                        c.this.aWS();
                        return;
                    } else if (view.getId() != c.this.fhD.getId()) {
                        if (c.this.guS != null) {
                            c.this.guS.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.gvc != null) {
                            c.this.gvc.aBl();
                        }
                        if (c.this.boW()) {
                            c.this.boY();
                            c.this.mn(false);
                            return;
                        }
                        c.this.aWS();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.blv();
                c.this.bpn();
                if (c.this.currentState != 1) {
                    c.this.bpj();
                    c.this.bpk();
                } else {
                    c.this.aXg();
                }
                if (c.this.gvb != null) {
                    c.this.gvb.hr(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.bKy.stopPlayback();
            c.this.fhF = false;
            c.this.bpe();
        }
    };
    private Animation.AnimationListener fie = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener fif = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable fig = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXd();
        }
    };
    private CustomMessageListener fih = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b fkc = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void hu(int i2) {
            int duration;
            if (c.this.bKy != null && (duration = c.this.bKy.getDuration()) > 0 && c.this.guI != null) {
                c.this.guI.setProgress((int) ((i2 * c.this.fho.getWidth()) / duration));
                if (c.this.guW != null) {
                    c.this.guW.hP((c.this.bKy.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener byA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bpj();
            c.this.mr(false);
            if (c.this.gvb != null) {
                c.this.gvb.hr(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.aWT() != null) {
                c.this.setStartPosition(c.this.aWT().getSeekPosition());
                if (!c.this.aXc()) {
                    c.this.bpe();
                } else {
                    c.this.aXb();
                    if (c.this.geq != null) {
                        c.this.geq.aBn();
                    }
                }
            }
            c.this.mr(true);
            c.this.bpi();
            if (c.this.gvb != null) {
                c.this.gvb.hr(true);
            }
        }
    };
    private QuickVideoView.a gvu = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bpq() {
            if (!c.this.gvk) {
                c.this.blt.startLoading();
                c.this.fhA.setVisibility(0);
                c.this.guK.setVisibility(8);
                c.this.guM.setVisibility(8);
                c.this.guL.setVisibility(8);
                c.this.guN.setVisibility(8);
                c.this.cQL.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fib);
                if (c.this.guV > 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fib, c.this.guV);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void hr(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0286c {
        void XN();

        void XO();
    }

    /* loaded from: classes.dex */
    public interface d {
        void aBm();

        void gT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void mw(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void gS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void blH();
    }

    /* loaded from: classes.dex */
    public interface i {
        void aBn();
    }

    /* loaded from: classes.dex */
    public interface j {
        void lN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void aBk();

        void aBl();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean blF();

        boolean blG();
    }

    /* loaded from: classes.dex */
    public interface n {
        void XP();

        void XQ();

        void hP(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    public c(Activity activity, View view, boolean z) {
        this.gvp = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.gvp = z;
            this.fhz = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.gvp = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.gvp = z;
            this.fhz = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.fho = N(this.mActivity);
        this.fho.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.fho);
        }
        this.bKy = (QuickVideoView) this.fho.findViewById(e.g.videoView);
        this.blt = new x((ViewGroup) this.fho.findViewById(e.g.auto_video_loading_container));
        this.blt.setLoadingAnimationListener(this.cOd);
        this.fhq = (VideoListMediaControllerView) this.fho.findViewById(e.g.media_controller);
        this.fhq.setPlayer(this.bKy);
        this.guI = (ProgressBar) this.fho.findViewById(e.g.pgrBottomProgress);
        this.guI.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.guI.setProgress(0);
        this.fhq.setOnSeekBarChangeListener(this.byA);
        this.fhq.setOnProgressUpdatedListener(this.fkc);
        this.fhr = this.fho.findViewById(e.g.black_mask);
        this.cQL = this.fho.findViewById(e.g.layout_error);
        this.cQL.setOnClickListener(this.mOnClickListener);
        this.gvj = (TextView) this.fho.findViewById(e.g.auto_video_error_tips);
        this.fhs = (FrameLayout) this.fho.findViewById(e.g.danmu_container);
        this.fhw = (ImageView) this.fho.findViewById(e.g.img_full_screen);
        this.fhw.setOnClickListener(this.mOnClickListener);
        this.fhx = this.fho.findViewById(e.g.layout_media_controller);
        this.guJ = this.fho.findViewById(e.g.time_show_controller);
        this.bKy.setPlayerReuseEnable(true);
        this.bKy.setContinuePlayEnable(true);
        this.bKy.setOnPreparedListener(this.bum);
        this.bKy.setOnCompletionListener(this.bul);
        this.bKy.setOnErrorListener(this.fia);
        this.bKy.setOnSeekCompleteListener(this.bup);
        this.bKy.setOnSurfaceDestroyedListener(this.blC);
        this.bKy.setOnRecoveryCallback(this.gvu);
        this.bKy.setOnOutInfoListener(this.buo);
        this.guK = (SwitchImageView) this.fho.findViewById(e.g.img_play_controller);
        this.guK.setStateImage(e.f.btn_card_play_video_n, e.f.btn_card_stop_video_n);
        this.guK.setState(0);
        this.guK.setOnClickListener(this.mOnClickListener);
        this.guL = (TextView) this.fho.findViewById(e.g.txt_replay);
        this.guL.setOnClickListener(this.mOnClickListener);
        this.guM = (TextView) this.fho.findViewById(e.g.txt_playnext);
        this.guM.setOnClickListener(this.mOnClickListener);
        this.guN = (TextView) this.fho.findViewById(e.g.txt_next_video_title);
        this.fhA = (TbImageView) this.fho.findViewById(e.g.video_thumbnail);
        this.fhA.setDefaultErrorResource(0);
        this.fhA.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.fhD = (ImageView) this.fho.findViewById(e.g.img_exit);
        this.fhD.setOnClickListener(this.mOnClickListener);
        this.fhE = (TextView) this.fho.findViewById(e.g.video_title);
        this.cQG = this.fho.findViewById(e.g.layout_title);
        this.cQG.setVisibility(8);
        this.dGF = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.dGG = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.fhP = this.mAudioManager.getStreamMaxVolume(3);
        this.fhU = this.mAudioManager.getStreamVolume(3);
        fhV = 100 / this.fhP;
        this.fho.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.guZ != null) {
                    c.this.guZ.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.fhF) {
                        if (c.this.mStatus == 1 && c.this.fhR != 0) {
                            c.this.b(c.this.fhR == 1 ? 1000.0f : -1000.0f, false);
                            c.this.fhR = 0;
                            c.this.fhQ = 0;
                        }
                        if (!c.this.bKy.isPlaying()) {
                            c.this.guM.setVisibility(8);
                            c.this.guL.setVisibility(8);
                            c.this.guN.setVisibility(8);
                        }
                    }
                    c.this.aWO();
                    if (c.this.guZ != null) {
                        c.this.guZ.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.bFt = new o(this.mActivity);
        if (this.gvp) {
            this.bFt.start();
        }
        this.fhT = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0200e.ds16);
        this.fhW = new CallStateReceiver();
        this.fhW.register(this.mActivity);
        boS();
        this.cNT = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.fih);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.fih);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void boS() {
        if (this.gvf) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fho.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.fho.setSystemUiVisibility(0);
    }

    public void mm(boolean z) {
        this.gvf = z;
        boS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWO() {
        this.mStatus = 0;
        if (this.fhJ != null && this.fhJ.getParent() != null && (this.fhJ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fhJ.getParent()).removeView(this.fhJ);
                this.fhJ = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.fhK != null && this.fhK.getParent() != null && (this.fhK.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fhK.getParent()).removeView(this.fhK);
                this.fhK = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aWP() {
        if (this.mStatus == 1) {
            if (this.fhJ == null && this.fho != null && (this.fho instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_jindu, (ViewGroup) this.fho, true);
                this.fhJ = this.fho.findViewById(e.g.lay_jindu);
                this.fhL = (TextView) this.fhJ.findViewById(e.g.show_time);
                this.fhO = (ImageView) this.fhJ.findViewById(e.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.fhK == null && this.fho != null && (this.fho instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_voice, (ViewGroup) this.fho, true);
            this.fhK = this.fho.findViewById(e.g.lay_voice);
            this.fhN = (ImageView) this.fhK.findViewById(e.g.arrow_voice_icon);
            this.fhM = (SeekBar) this.fhK.findViewById(e.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.guS = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.guZ != null) {
                c.this.guZ.onStart();
            }
            if (c.this.bFw && c.this.fhF) {
                if (c.this.mStatus == 1) {
                    c.this.bpl();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.au(f2);
                    }
                } else {
                    if (c.this.bFw) {
                        c.this.aWR();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.fhQ = c.this.bKy.getCurrentPosition();
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
            if (!c.this.gvq) {
                if (c.this.gva != null && c.this.gva.blF()) {
                    return true;
                }
                c.this.blv();
                c.this.bpn();
                if (c.this.bKy.isPlaying()) {
                    c.this.bpi();
                } else {
                    c.this.bpj();
                }
                if (c.this.gvb != null) {
                    c.this.gvb.hr(c.this.bKy.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.gvq) {
                if (c.this.fhF) {
                    if (c.this.gva == null || !c.this.gva.blG()) {
                        c.this.bph();
                        if (c.this.bKy.isPlaying()) {
                            c.this.bpi();
                        } else {
                            c.this.bpj();
                        }
                        if (c.this.gvb != null) {
                            c.this.gvb.hr(c.this.bKy.isPlaying());
                        }
                    } else {
                        return true;
                    }
                } else {
                    c.this.aW(c.this.aBn, c.this.beV);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWR() {
        if (Build.VERSION.SDK_INT < 16) {
            this.fho.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.fho.setSystemUiVisibility(4);
        } else {
            this.fho.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.fhF) {
            this.mStatus = 0;
            return;
        }
        aWP();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % fhV == 0) {
            if (f2 > 0.0f && this.fhU < this.fhP) {
                this.fhU++;
            }
            if (f2 < 0.0f && this.fhU > 0) {
                this.fhU--;
            }
        }
        if (this.mProgress > 0) {
            this.fhN.setImageResource(e.f.icon_shengyin_open);
        } else {
            this.fhN.setImageResource(e.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.fhU, 0);
        this.fhM.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.fhQ += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.fhR = 1;
            } else {
                this.fhQ += 1000;
                this.fhR = 2;
            }
            if (this.fhQ < 0) {
                this.fhQ = 0;
            } else if (this.fhQ > this.bKy.getDuration()) {
                this.fhQ = this.bKy.getDuration();
            }
        }
        aWP();
        String sV = this.fhq.sV(this.fhQ);
        if (f2 > 0.0f) {
            this.fhO.setImageResource(e.f.icon_kuaitui);
        } else {
            this.fhO.setImageResource(e.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(sV)) {
            this.fhL.setText(new StringBuilder().append(sV).append("/").append(this.fhq.sV(this.bKy.getDuration())));
        }
        this.fhq.setCurrentDuration(this.fhQ, z ? false : true);
        bpl();
        boZ();
    }

    protected View N(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(e.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.aBn = str;
        this.beV = str2;
    }

    public void boT() {
        if (this.bKy != null) {
            this.bKy.boT();
        }
    }

    public void setFid(String str) {
        this.cRh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void any() {
        int i2 = 100;
        if (this.bKy != null && this.cNR != null && this.fhq != null) {
            this.fhq.showProgress();
            this.mStartPosition = y.bqk().tu(this.aBn);
            if (this.gvn) {
                this.cNR.setVolume(1.0f, 1.0f);
                this.bKy.start();
                this.gvn = false;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhZ);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fhZ, 20L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvt);
                if (this.bKy.bpG()) {
                    this.currentState = 1;
                    this.bKy.setRecoveryState(1);
                    bpl();
                }
                this.mStartPosition = y.bqk().tu(this.aBn);
                this.fhq.setPlayer(this.bKy);
                if (this.mStartPosition != 0 && !this.cNR.isPlayerReuse()) {
                    this.gvh = true;
                }
                if (!this.gvm) {
                    this.fhq.showProgress();
                }
                if (this.cNR.getDuration() <= 0) {
                    aWT().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.cNR.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.cNZ = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boU() {
        if (!this.fhF) {
            this.fhF = true;
            this.fhr.setVisibility(8);
            this.cQL.setVisibility(8);
            this.blt.bqf();
            this.fhA.setVisibility(8);
            bpm();
            if (bpo()) {
                this.cNT.a(this.beV, -1L, this.bKy.getDuration() / 1000, "middle", this.bKy);
            }
            this.fhq.showProgress();
            this.guI.setVisibility(0);
            if (this.fhB != null) {
                this.fhB.onPrepared(this.bKy.getPlayer());
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
    public void mn(boolean z) {
        if (hasNavBar(this.mActivity)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guJ.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.guJ.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.guJ.setBackgroundResource(e.f.bg_video_shadow);
            }
            this.guJ.setLayoutParams(layoutParams);
        }
    }

    public void blv() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.S(this.mActivity, this.mActivity.getString(e.j.neterror));
        } else if (this.bKy.isPlaying()) {
            pausePlay();
            if (this.gve != null) {
                this.gve.onPause();
            }
            if (this.guW != null) {
                this.guW.onPaused();
            }
        } else if (this.fhF) {
            aXb();
            if (this.geq != null) {
                this.geq.aBn();
            }
            if (this.guW != null) {
                this.guW.XQ();
            }
        } else {
            bpe();
        }
    }

    public boolean boV() {
        return this.fhX;
    }

    public void aWS() {
        this.fhX = true;
        if (this.bFt != null) {
            this.bFt.aWS();
        }
    }

    public boolean boW() {
        return this.cNR != null && this.cNR.getVideoHeight() > this.cNR.getVideoWidth();
    }

    public boolean sR(int i2) {
        switch (i2) {
            case 4:
                if (this.bFw) {
                    if (boW()) {
                        mn(false);
                        boY();
                    } else {
                        aWS();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.fhP <= 0 || this.fhM == null) {
                    return false;
                }
                this.fhU = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.fhU * 100.0d) / this.fhP);
                this.fhM.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bKy;
    }

    public VideoListMediaControllerView aWT() {
        return this.fhq;
    }

    public void show() {
        this.fho.setVisibility(0);
    }

    public void aWX() {
        if (this.fhz != null) {
            ViewGroup.LayoutParams layoutParams = this.fhz.getLayoutParams();
            this.fht = (FrameLayout.LayoutParams) this.fho.getLayoutParams();
            this.fht.width = layoutParams.width;
            this.fht.height = layoutParams.height;
            this.fht.topMargin = 0;
            this.fho.setLayoutParams(this.fht);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.fhX) {
            if (this.bFw) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.fhX = false;
        }
        if (configuration.orientation == 2) {
            boX();
        } else {
            boY();
        }
        boZ();
        aXb();
        bpn();
        aXg();
        if (this.gvb != null) {
            this.gvb.hr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boX() {
        this.bFw = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (boW()) {
            this.fho.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.fho.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        e(this.mActivity, true);
        this.cQG.setVisibility(0);
        this.fhD.setVisibility(0);
        this.fhE.setVisibility(0);
        this.fhs.setVisibility(8);
        this.blt.bqg();
        this.fhA.setVisibility(8);
        this.fhw.setImageResource(e.f.icon_video_narrow_white);
        qD(this.fhT);
        aWR();
        if (this.guT != null) {
            this.guT.XN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boY() {
        this.bFw = false;
        if (this.fht != null) {
            this.fho.setLayoutParams(this.fht);
        }
        e(this.mActivity, false);
        this.cQG.setVisibility(8);
        this.fhs.setVisibility(0);
        this.blt.bqg();
        this.fhA.setVisibility(8);
        this.fhw.setImageResource(e.f.icon_video_enlarge_white);
        if (this.fhq != null && (this.fhq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhq.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0200e.tbds24);
            layoutParams.rightMargin = 0;
            this.fhq.setLayoutParams(layoutParams);
        }
        this.fho.setSystemUiVisibility(0);
        boS();
        if (this.guT != null) {
            this.guT.XO();
        }
    }

    public void boZ() {
        if (this.bKy != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.bFw) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.guI.setMax(aO);
            int duration = this.bKy.getDuration();
            if (duration > 0) {
                if (this.guL.getVisibility() == 0) {
                    this.guI.setProgress(this.guI.getMax());
                } else {
                    this.guI.setProgress((int) ((this.bKy.getCurrentPosition() * this.guI.getMax()) / duration));
                }
            }
        }
    }

    private void qD(int i2) {
        if (this.fhq != null && (this.fhq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhq.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.fhq.setLayoutParams(layoutParams);
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

    public boolean aWZ() {
        return !this.bFw;
    }

    public void a(g.f fVar) {
        this.fhB = fVar;
    }

    public void a(g.a aVar) {
        this.guO = aVar;
    }

    public void a(g.b bVar) {
        this.guP = bVar;
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bKy != null) {
            this.bKy.setPbLoadingTime(currentTimeMillis);
        }
        aW(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.gvi) {
            cn(str, str2);
        } else {
            aW(str, str2);
        }
        if (eVar != null) {
            eVar.mw(z);
        }
    }

    public void cm(String str, String str2) {
    }

    public void aW(String str, String str2) {
        bpf();
        this.gvn = true;
        this.currentState = 0;
        this.bKy.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bKy.setVideoPath(str, str2);
        this.cNT.baT();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        if (this.guV > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fib, this.guV);
        }
        if (this.guW != null) {
            this.guW.onStarted();
        }
        this.blt.startLoading();
        mo(true);
    }

    public void cn(String str, String str2) {
        bpf();
        this.gvn = true;
        this.currentState = 0;
        this.bKy.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        if (this.guV > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fib, this.guV);
        }
        if (this.guW != null) {
            this.guW.onStarted();
        }
        this.blt.startLoading();
        mo(true);
    }

    public void bpa() {
        aXb();
        this.guI.setVisibility(0);
    }

    public void aXb() {
        int i2 = 100;
        if (this.bKy != null && this.fhq != null) {
            this.fhF = true;
            this.currentState = 1;
            this.bKy.setRecoveryState(1);
            this.bKy.start();
            if (this.cNR != null && this.fhq != null) {
                this.mStartPosition = y.bqk().tu(this.aBn);
                if (this.mStartPosition != 0 && !this.cNR.isPlayerReuse()) {
                    this.gvh = true;
                }
                if (this.mStartPosition > 100 && this.cNR.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.cNZ = i2;
            } else {
                this.cNZ = 100;
            }
            this.blt.bqg();
            mo(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kV() && this.gvl && !StringUtils.isNull(this.aBn) && !StringUtils.isNull(this.beV)) {
            this.gvl = false;
            this.gvm = true;
            aW(this.aBn, this.beV);
        }
    }

    private void mo(boolean z) {
        if (z) {
            this.fhA.setVisibility(0);
            bpl();
            this.guI.setProgress(0);
        } else {
            this.fhA.setVisibility(8);
        }
        this.fhq.showProgress();
        this.fhr.setVisibility(8);
        this.guM.setVisibility(8);
        this.guL.setVisibility(8);
        this.guN.setVisibility(8);
        this.cQL.setVisibility(8);
    }

    private void bpb() {
        this.blt.bqg();
        this.guM.setVisibility(8);
        this.guL.setVisibility(8);
        this.guN.setVisibility(8);
        bpn();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bKy != null) {
            this.bKy.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.bKy.pause();
        this.currentState = 2;
        this.bKy.setRecoveryState(2);
        bpb();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.bKy.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhZ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvt);
        this.bKy.stopPlayback();
        this.fhF = false;
        this.gvn = false;
        this.mStartPosition = 0;
        aKf();
    }

    public void bpc() {
        if (this.bKy.getDuration() >= this.bKy.getCurrentPosition()) {
            y.bqk().aM(this.aBn, this.bKy.getCurrentPosition());
        }
    }

    public void mp(boolean z) {
        this.gvg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        if (this.fhx != null) {
            this.fhr.setVisibility(0);
            this.guM.setVisibility(8);
            this.guL.setVisibility(8);
            this.guN.setVisibility(8);
            this.blt.bqg();
            bpl();
            this.guI.setVisibility(8);
            this.cQL.setVisibility(8);
            this.fhq.Ve();
            this.fhA.setVisibility(z ? 0 : 8);
        }
    }

    public void aKf() {
        mq(true);
    }

    public boolean bpd() {
        if (this.bKy == null) {
            return false;
        }
        return this.bKy.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bKy == null) {
            return 0;
        }
        return this.bKy.getCurrentPosition();
    }

    public void a(k kVar) {
        this.guZ = kVar;
    }

    public void a(j jVar) {
        this.guY = jVar;
    }

    public void a(i iVar) {
        this.geq = iVar;
    }

    public void a(g gVar) {
        this.gve = gVar;
    }

    public void a(h hVar) {
        this.guX = hVar;
    }

    public void sR(String str) {
        this.gdQ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpe() {
        a(this.aBn, this.beV, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.guU = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bpf();
        if (com.baidu.adp.lib.util.j.kX() && !com.baidu.tieba.video.g.bFM().bFN()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gvi = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gvd != null) {
                    this.gvd.gS(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.ej(TbadkCoreApplication.getInst().getString(e.j.play_video_mobile_tip));
                aVar.a(e.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bpg();
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
                aVar.b(this.mContext).AB();
                return;
            } else if (this.gvd != null) {
                this.gvd.gS(true);
                return;
            } else {
                if (!this.guH) {
                    this.guH = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, e.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.gvc != null) {
            this.gvc.aBk();
        }
    }

    private void bpf() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bFM().cY(this.mActivity);
        }
    }

    public void bpg() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.fhA.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fig);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhZ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fib);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvs);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvt);
        this.bFt.stop();
        this.fhW.unregister(this.mActivity);
    }

    public void tp(String str) {
        this.fhE.setText(str);
    }

    public boolean aXc() {
        return this.fhF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bph() {
        if (this.fhx != null) {
            if (this.guQ) {
                bpl();
            } else {
                bpk();
            }
        }
    }

    public void aXg() {
        bpk();
        bpi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpi() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fig);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fig, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fig);
    }

    public void bpk() {
        if (this.fhx != null && !this.guQ && !this.gvr) {
            mr(true);
            aXf();
            this.fhx.setVisibility(0);
            this.guJ.setVisibility(0);
            this.guI.setVisibility(8);
            this.guQ = true;
            if (this.guU != null) {
                this.guU.gT(false);
            }
        }
    }

    public void aXd() {
        if (this.fhx != null && this.guQ) {
            mr(false);
            aXf();
            this.fhx.setVisibility(8);
            this.guJ.setVisibility(8);
            this.guI.setVisibility(0);
            this.dGF.setAnimationListener(this.fie);
            this.fhx.startAnimation(this.dGF);
            this.guQ = false;
            if (this.guU != null) {
                this.guU.aBm();
            }
        }
    }

    public void bpl() {
        if (this.fhx != null && this.guQ) {
            this.dGG.cancel();
            this.dGF.cancel();
            mr(false);
            aXf();
            this.fhx.setVisibility(8);
            this.guJ.setVisibility(8);
            this.guI.setVisibility(0);
            this.guQ = false;
            if (this.guU != null) {
                this.guU.aBm();
            }
        }
    }

    private void aXf() {
        if (this.fhx != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fig);
            this.dGG.setAnimationListener(null);
            this.dGF.setAnimationListener(null);
            this.fhx.clearAnimation();
        }
    }

    private void bpm() {
        if (this.fhx != null) {
            this.dGG.setAnimationListener(null);
            this.dGF.setAnimationListener(null);
            this.fhx.clearAnimation();
        }
    }

    public void mr(boolean z) {
        bpn();
        if (z) {
            this.guK.setVisibility(0);
        } else {
            this.guK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpn() {
        if (this.currentState == 1) {
            this.guK.setState(1);
        } else {
            this.guK.setState(0);
        }
    }

    public void a(InterfaceC0286c interfaceC0286c) {
        this.guT = interfaceC0286c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void S(boolean z, boolean z2) {
        if (this.bFt != null) {
            if (this.fhw != null) {
                this.fhw.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.fhq != null && (this.fhq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhq.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0200e.tbds52);
                this.fhq.setLayoutParams(layoutParams);
            }
            this.bFt.my(z);
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

    public void ms(boolean z) {
        this.gvq = z;
    }

    public void a(m mVar) {
        this.gva = mVar;
    }

    public void a(a aVar) {
        this.gvb = aVar;
    }

    public void a(l lVar) {
        this.gvc = lVar;
    }

    public void a(f fVar) {
        this.gvd = fVar;
    }

    public void mt(boolean z) {
        this.gvk = z;
    }

    public boolean bpo() {
        return this.guR;
    }

    public void mu(boolean z) {
        this.guR = z;
    }

    public void sS(int i2) {
        this.gvo = i2;
    }

    public View bpp() {
        return this.fho;
    }

    public void a(n nVar) {
        this.guW = nVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.bKy != null) {
            this.bKy.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.fhU = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mv(boolean z) {
        this.gvr = z;
        if (z) {
            bpl();
        } else {
            aXg();
        }
    }
}
