package com.baidu.tieba.play;

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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int exr;
    private String aNu;
    private TbPageContext<?> adf;
    private String baI;
    private QuickVideoView bkP;
    private o byI;
    private com.baidu.tieba.play.g cop;
    private w cou;
    private View crj;
    private ImageView crk;
    private View cro;
    private Animation dbf;
    private Animation dbg;
    private VideoListMediaControllerView ewL;
    private View ewM;
    private FrameLayout ewN;
    protected FrameLayout.LayoutParams ewO;
    private ImageView ewQ;
    private ImageView ewR;
    private View ewS;
    private View ewU;
    private TbImageView ewV;
    private g.f ewW;
    private ImageView ewY;
    private TextView ewZ;
    private View exe;
    private View exf;
    private TextView exg;
    private SeekBar exh;
    private ImageView exi;
    private ImageView exj;
    private int exk;
    private int exp;
    private int exq;
    private CallStateReceiver exs;
    private ProgressBar fNL;
    private View fNM;
    private View fNN;
    private TextView fNO;
    private TextView fNP;
    private TextView fNQ;
    private g.a fNR;
    private g.b fNS;
    private View.OnClickListener fNU;
    private b fNV;
    private InterfaceC0201c fNW;
    private g fNX;
    private i fNY;
    private j fNZ;
    private l fOa;
    private k fOb;
    private e fOc;
    private f fOd;
    private TextView fOi;
    private boolean fOk;
    private boolean fOl;
    private boolean fOm;
    private int fOn;
    private boolean fOo;
    private boolean fOp;
    private h fwO;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    public View mMainView;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fNK = false;
    protected boolean dIE = false;
    private boolean exa = false;
    private boolean exc = false;
    private boolean fNT = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int exl = 0;
    private int exm = 0;
    private boolean exu = false;
    private boolean fOe = true;
    private boolean fOf = true;
    private boolean fOg = false;
    private boolean fOh = false;
    private String fws = null;
    private int anu = -1;
    private boolean fOj = false;
    private g.f aZo = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cop = gVar;
            if (c.this.bfT()) {
                c.this.cou.bgV();
                c.this.fOo = true;
                return;
            }
            c.this.afh();
        }
    };
    private VideoLoadingProgressView.a coF = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.afh();
        }
    };
    private Runnable exw = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bkP.getCurrentPosition() > 100) {
                c.this.exa = true;
                c.this.ewM.setVisibility(8);
                c.this.cro.setVisibility(8);
                c.this.cou.bgW();
                c.this.ewV.setVisibility(8);
                c.this.aLH();
                if (c.this.anu == 1 || c.this.anu == 2) {
                    if (c.this.ewS != null) {
                        c.this.ewS.setVisibility(0);
                        c.this.fNN.setVisibility(0);
                        c.this.fNL.setVisibility(8);
                        if (c.this.fNW != null) {
                            c.this.fNW.fG(false);
                        }
                    }
                    c.this.ewL.showProgress();
                    c.this.aLI();
                }
                if (c.this.ewW != null) {
                    c.this.ewW.onPrepared(c.this.bkP.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exw, 20L);
        }
    };
    private g.a aZn = new g.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.exa = false;
            c.this.fOm = false;
            c.this.mStartPosition = 0;
            c.this.aLp();
            c.this.ewM.setVisibility(0);
            c.this.fNL.setVisibility(8);
            c.this.fNL.setProgress(c.this.fNL.getMax());
            if (c.this.fNW != null) {
                c.this.fNW.fG(false);
            }
            if (c.this.dIE) {
                c.this.ewS.setVisibility(0);
                c.this.ewY.setVisibility(0);
                c.this.ewZ.setVisibility(0);
                c.this.fNN.setVisibility(8);
            } else {
                c.this.ewS.setVisibility(8);
                c.this.ewY.setVisibility(8);
                c.this.ewZ.setVisibility(8);
                c.this.fNN.setVisibility(8);
            }
            if (c.this.bkP == null || c.this.bkP.getDuration() > 150000) {
                c.this.lp(false);
            } else {
                c.this.fNO.setVisibility(0);
            }
            x.bhb().remove(c.this.baI);
            if (c.this.fNR != null) {
                c.this.fNR.onCompletion(gVar);
            }
            c.this.anu = 3;
            c.this.bkP.setRecoveryState(3);
            if (!c.this.dIE && c.this.bkP != null && c.this.bkP.getDuration() <= 150000) {
                if (!c.this.fOj) {
                    if (c.this.fNY != null) {
                        c.this.fNY.kM(true);
                    }
                    c.this.bL(c.this.baI, c.this.aNu);
                    return;
                }
                c.this.anu = 5;
                c.this.bkP.setRecoveryState(5);
                c.this.bkP.getPlayer().pause();
                c.this.bkP.getPlayer().seekTo(0);
            }
        }
    };
    private g.b exx = new g.b() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cro.setVisibility(0);
            c.this.cou.bgX();
            c.this.anu = 4;
            c.this.bkP.setRecoveryState(4);
            if (c.this.fNS != null) {
                c.this.fNS.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.gP()) {
                c.this.fOk = true;
            }
            c.this.fOm = false;
            return true;
        }
    };
    private Runnable exy = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            c.this.cro.setVisibility(0);
            c.this.cou.bgX();
        }
    };
    private g.InterfaceC0202g aZs = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.InterfaceC0202g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.fOg) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fOq, 200L);
            }
        }
    };
    private Runnable fOq = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bkP == null || !c.this.fOg) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exw, 200L);
                c.this.fOg = false;
            } else if (c.this.mStartPosition != c.this.bkP.getCurrentPosition()) {
                c.this.fOg = false;
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exw, 20L);
            } else {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fOq, 200L);
            }
        }
    };
    private QuickVideoView.b bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.exa = false;
            if (c.this.fNT) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fOr, 300L);
            } else {
                c.this.fOm = false;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.exw);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.exy);
        }
    };
    private Runnable fOr = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.fOm = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getId() == c.this.cro.getId()) {
                c.this.bgb();
            } else if (view2.getId() != c.this.crk.getId() && view2.getId() != c.this.ewQ.getId()) {
                if (view2.getId() == c.this.fNP.getId()) {
                    if (c.this.fNX != null) {
                        c.this.fNX.bcz();
                    }
                } else if (view2.getId() == c.this.fNO.getId()) {
                    if (c.this.fNY != null) {
                        c.this.fNY.kM(false);
                    }
                    c.this.bL(c.this.baI, c.this.aNu);
                } else if (view2.getId() != c.this.ewR.getId() && view2.getId() != c.this.fNM.getId()) {
                    if (view2.getId() != c.this.ewY.getId()) {
                        if (c.this.fNU != null) {
                            c.this.fNU.onClick(view2);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new al("c11713"));
                    if (c.this.fOb != null) {
                        c.this.fOb.aqY();
                    }
                    if (c.this.bfU()) {
                        c.this.bfW();
                        c.this.lm(false);
                        return;
                    }
                    c.this.aLt();
                } else {
                    if (c.this.dIE) {
                        TiebaStatic.log(new al("c11714"));
                    } else {
                        TiebaStatic.log(new al("c11710"));
                    }
                    if (c.this.fOb != null) {
                        c.this.fOb.aqY();
                    }
                    if (c.this.bfU()) {
                        if (c.this.dIE) {
                            c.this.bfW();
                        } else {
                            c.this.bfV();
                        }
                        c.this.lm(c.this.dIE);
                        return;
                    }
                    c.this.aLt();
                }
            } else {
                c.this.bcq();
            }
        }
    };
    private Animation.AnimationListener exA = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.ewS != null) {
                c.this.ewS.setVisibility(8);
                c.this.fNL.setVisibility(0);
                c.this.exc = false;
                if (c.this.fNW != null) {
                    c.this.fNW.aqZ();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener exB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Runnable exC = new Runnable() { // from class: com.baidu.tieba.play.c.9
        @Override // java.lang.Runnable
        public void run() {
            c.this.aLF();
        }
    };
    private CustomMessageListener exD = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b ezy = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gs(int i2) {
            int duration;
            if (c.this.bkP != null && (duration = c.this.bkP.getDuration()) > 0 && c.this.fNL != null) {
                c.this.fNL.setProgress((int) ((i2 * c.this.mMainView.getWidth()) / duration));
            }
            c.this.oD(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bdD = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.13
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.exc) {
                c.this.aLI();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aLE() && c.this.aLu() != null) {
                c.this.setStartPosition(c.this.aLu().getSeekPosition());
                c.this.bL(c.this.baI, c.this.aNu);
            }
        }
    };
    private QuickVideoView.a fOs = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bgj() {
            if (!c.this.fOj) {
                c.this.cou.startLoading();
                c.this.ewV.setVisibility(0);
                c.this.crk.setVisibility(8);
                c.this.ewQ.setImageResource(d.f.icon_video_suspend_n);
                c.this.fNP.setVisibility(8);
                c.this.fNO.setVisibility(8);
                c.this.fNQ.setVisibility(8);
                c.this.cro.setVisibility(8);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.exy);
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exy, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aqV();

        void aqW();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0201c {
        void aqZ();

        void fG(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void ls(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fF(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface g {
        void bcz();
    }

    /* loaded from: classes.dex */
    public interface h {
        void ara();
    }

    /* loaded from: classes.dex */
    public interface i {
        void kM(boolean z);
    }

    /* loaded from: classes.dex */
    public interface j {
        void onStart();

        void onStop();

        boolean onTouch(View view2, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface k {
        void aqX();

        void aqY();
    }

    /* loaded from: classes.dex */
    public interface l {
        void bcA();
    }

    public c(TbPageContext<?> tbPageContext, View view2, boolean z) {
        this.exp = 0;
        this.fOp = true;
        if (tbPageContext != null) {
            this.adf = tbPageContext;
            this.mMainView = p(tbPageContext);
            this.mRootView = view2;
            this.fOp = z;
            if (view2 instanceof FrameLayout) {
                ((FrameLayout) view2).addView(this.mMainView);
            }
            this.ewU = view2;
            this.mMainView.setOnClickListener(this.mOnClickListener);
            this.bkP = (QuickVideoView) this.mMainView.findViewById(d.g.videoView);
            this.cou = new w((ViewGroup) this.mMainView.findViewById(d.g.auto_video_loading_container));
            this.cou.setLoadingAnimationListener(this.coF);
            this.ewL = (VideoListMediaControllerView) this.mMainView.findViewById(d.g.media_controller);
            this.ewL.setPlayer(this.bkP);
            this.fNL = (ProgressBar) this.mMainView.findViewById(d.g.pgrBottomProgress);
            this.fNL.setMax(com.baidu.adp.lib.util.l.af(this.adf.getPageActivity()));
            this.fNL.setProgress(0);
            this.ewL.setOnSeekBarChangeListener(this.bdD);
            this.ewL.setOnProgressUpdatedListener(this.ezy);
            this.ewM = this.mMainView.findViewById(d.g.black_mask);
            this.cro = this.mMainView.findViewById(d.g.layout_error);
            this.cro.setOnClickListener(this.mOnClickListener);
            this.fOi = (TextView) this.mMainView.findViewById(d.g.auto_video_error_tips);
            this.ewN = (FrameLayout) this.mMainView.findViewById(d.g.danmu_container);
            this.ewQ = (ImageView) this.mMainView.findViewById(d.g.img_play_icon);
            this.ewQ.setOnClickListener(this.mOnClickListener);
            this.ewR = (ImageView) this.mMainView.findViewById(d.g.img_full_screen);
            this.ewR.setOnClickListener(this.mOnClickListener);
            this.fNM = this.mMainView.findViewById(d.g.full_screen_container);
            this.fNM.setOnClickListener(this.mOnClickListener);
            this.ewS = this.mMainView.findViewById(d.g.layout_media_controller);
            this.fNN = this.mMainView.findViewById(d.g.time_show_controller);
            this.bkP.setOnPreparedListener(this.aZo);
            this.bkP.setOnCompletionListener(this.aZn);
            this.bkP.setOnErrorListener(this.exx);
            this.bkP.setOnSeekCompleteListener(this.aZs);
            this.bkP.setOnSurfaceDestroyedListener(this.bkY);
            this.bkP.setOnRecoveryCallback(this.fOs);
            this.crk = (ImageView) this.mMainView.findViewById(d.g.img_play);
            this.crk.setOnClickListener(this.mOnClickListener);
            this.fNO = (TextView) this.mMainView.findViewById(d.g.txt_replay);
            this.fNO.setOnClickListener(this.mOnClickListener);
            this.fNP = (TextView) this.mMainView.findViewById(d.g.txt_playnext);
            this.fNP.setOnClickListener(this.mOnClickListener);
            this.fNQ = (TextView) this.mMainView.findViewById(d.g.txt_next_video_title);
            this.ewV = (TbImageView) this.mMainView.findViewById(d.g.video_thumbnail);
            this.ewV.setDefaultErrorResource(0);
            this.ewV.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity());
            this.mScreenHeight = bB(this.adf.getPageActivity());
            this.ewY = (ImageView) this.mMainView.findViewById(d.g.img_exit);
            this.ewY.setOnClickListener(this.mOnClickListener);
            this.ewZ = (TextView) this.mMainView.findViewById(d.g.video_title);
            this.crj = this.mMainView.findViewById(d.g.layout_title);
            this.crj.setVisibility(8);
            this.dbf = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dbg = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.adf.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.exk = this.mAudioManager.getStreamMaxVolume(3);
            this.exq = this.mAudioManager.getStreamVolume(3);
            exr = 100 / this.exk;
            this.mMainView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    if (c.this.fNZ != null) {
                        c.this.fNZ.onTouch(view3, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.exa) {
                            if (c.this.mStatus == 1 && c.this.exm != 0) {
                                c.this.b(c.this.exm == 1 ? 1000.0f : -1000.0f, false);
                                c.this.exm = 0;
                                c.this.exl = 0;
                            }
                            if (!c.this.bkP.isPlaying() && 8 == c.this.crk.getVisibility()) {
                                c.this.crk.setVisibility(0);
                                c.this.fNP.setVisibility(8);
                                c.this.fNO.setVisibility(8);
                                c.this.fNQ.setVisibility(8);
                            }
                        }
                        c.this.aLp();
                        if (c.this.fNZ != null) {
                            c.this.fNZ.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.byI = new o(this.adf.getPageActivity());
            if (this.fOp) {
                this.byI.start();
            }
            this.exp = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.ds16);
            this.exs = new CallStateReceiver();
            this.exs.register(this.adf.getPageActivity());
            this.adf.registerListener(this.exD);
            bfS();
        }
    }

    public void bfS() {
        if (this.fOe) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.mMainView.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.mMainView.setSystemUiVisibility(0);
    }

    public void ll(boolean z) {
        this.fOe = z;
        bfS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLp() {
        this.mStatus = 0;
        if (this.exe != null && this.exe.getParent() != null && (this.exe.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.exe.getParent()).removeView(this.exe);
                this.exe = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.exf != null && this.exf.getParent() != null && (this.exf.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.exf.getParent()).removeView(this.exf);
                this.exf = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aLq() {
        if (this.mStatus == 1) {
            if (this.exe == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
                LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.float_video_window_jindu, (ViewGroup) this.mMainView, true);
                this.exe = this.mMainView.findViewById(d.g.lay_jindu);
                this.exg = (TextView) this.exe.findViewById(d.g.show_time);
                this.exj = (ImageView) this.exe.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.exf == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
            LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.float_video_window_voice, (ViewGroup) this.mMainView, true);
            this.exf = this.mMainView.findViewById(d.g.lay_voice);
            this.exi = (ImageView) this.exf.findViewById(d.g.arrow_voice_icon);
            this.exh = (SeekBar) this.exf.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        this.fNU = onClickListener;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fNZ != null) {
                c.this.fNZ.onStart();
            }
            if (c.this.dIE && c.this.exa) {
                if (!c.this.bkP.isPlaying() && c.this.crk.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.crk.setVisibility(8);
                    c.this.fNP.setVisibility(8);
                    c.this.fNO.setVisibility(8);
                    c.this.fNQ.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.af(f2);
                    }
                } else {
                    if (c.this.dIE) {
                        c.this.aLs();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.exl = c.this.bkP.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.af(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fOa != null) {
                c.this.fOa.bcA();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.exa) {
                if (c.this.anu != 2) {
                    c.this.bge();
                } else {
                    c.this.bcq();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLs() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mMainView.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mMainView.setSystemUiVisibility(4);
        } else {
            this.mMainView.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(float f2) {
        if (!this.exa) {
            this.mStatus = 0;
            return;
        }
        aLq();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % exr == 0) {
            if (f2 > 0.0f && this.exq < this.exk) {
                this.exq++;
            }
            if (f2 < 0.0f && this.exq > 0) {
                this.exq--;
            }
        }
        if (this.mProgress > 0) {
            this.exi.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.exi.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.exq, 0);
        this.exh.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.exl += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.exm = 1;
            } else {
                this.exl += 1000;
                this.exm = 2;
            }
            if (this.exl < 0) {
                this.exl = 0;
            } else if (this.exl > this.bkP.getDuration()) {
                this.exl = this.bkP.getDuration();
            }
        }
        aLq();
        String rr = this.ewL.rr(this.exl);
        if (f2 > 0.0f) {
            this.exj.setImageResource(d.f.icon_kuaitui);
        } else {
            this.exj.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(rr)) {
            this.exg.setText(new StringBuilder().append(rr).append("/").append(this.ewL.rr(this.bkP.getDuration())));
        }
        this.ewL.setCurrentDuration(this.exl, z ? false : true);
        this.ewS.setVisibility(8);
        this.fNL.setVisibility(0);
        bfX();
    }

    protected View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.float_video_container, (ViewGroup) null);
    }

    public void bK(String str, String str2) {
        this.baI = str;
        this.aNu = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfT() {
        if (this.fNT) {
            return this.fOn == 0 && !this.fOo;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.bkP != null && this.cop != null) {
            if (this.fOm) {
                this.bkP.start();
                this.fOm = false;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exw);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.exw, 20L);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exy);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOr);
            if (this.bkP.bgA()) {
                this.anu = 1;
                this.bkP.setRecoveryState(1);
            }
            if (this.cop != null && this.ewL != null) {
                this.mStartPosition = x.bhb().rr(this.baI);
                this.ewL.Q(this.mStartPosition, this.cop.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bkP != null) {
                        this.bkP.rq(this.mStartPosition);
                    } else {
                        this.cop.seekTo(this.mStartPosition);
                    }
                    if (!this.fOl) {
                        this.ewL.showProgress();
                        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exw);
                    }
                    this.fOg = true;
                }
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", Constants.OS_TYPE_VALUE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(boolean z) {
        if (hasNavBar(this.adf.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fNN.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.adf.getPageActivity());
                this.fNN.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.fNN.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.fNN.setLayoutParams(layoutParams);
        }
    }

    public void bcq() {
        if (!com.baidu.adp.lib.util.j.gP()) {
            com.baidu.adp.lib.util.l.showLongToast(this.adf.getPageActivity(), this.adf.getString(d.k.neterror));
        } else if (this.bkP.isPlaying()) {
            pausePlay();
            if (this.fOd != null) {
                this.fOd.onPause();
            }
        } else if (this.exa) {
            aLD();
            if (this.fwO != null) {
                this.fwO.ara();
            }
        } else {
            bgb();
        }
    }

    public void aLt() {
        this.exu = true;
        if (this.byI != null) {
            this.byI.aLt();
        }
    }

    public boolean bfU() {
        return this.cop != null && this.cop.getVideoHeight() > this.cop.getVideoWidth();
    }

    public boolean rn(int i2) {
        switch (i2) {
            case 4:
                if (this.dIE) {
                    if (bfU()) {
                        lm(false);
                        bfW();
                    } else {
                        aLt();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.exk <= 0 || this.exh == null) {
                    return false;
                }
                this.exq = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.exq * 100.0d) / this.exk);
                this.exh.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bkP;
    }

    public VideoListMediaControllerView aLu() {
        return this.ewL;
    }

    public void show() {
        this.mMainView.setVisibility(0);
    }

    public void aLy() {
        if (this.ewU != null) {
            ViewGroup.LayoutParams layoutParams = this.ewU.getLayoutParams();
            this.ewO = (FrameLayout.LayoutParams) this.mMainView.getLayoutParams();
            this.ewO.width = layoutParams.width;
            this.ewO.height = layoutParams.height;
            this.ewO.topMargin = 0;
            this.mMainView.setLayoutParams(this.ewO);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.exu) {
            if (this.dIE) {
                TiebaStatic.log(new al("c11712"));
            } else {
                TiebaStatic.log(new al("c11711"));
            }
        } else {
            this.exu = false;
        }
        if (configuration.orientation == 2) {
            bfV();
        } else {
            bfW();
        }
        if (this.bkP.isPlaying()) {
            aLI();
        }
        bfX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfV() {
        this.dIE = true;
        if (bfU()) {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.adf, true);
        this.ewS.setVisibility(0);
        this.crj.setVisibility(0);
        this.ewY.setVisibility(0);
        this.ewZ.setVisibility(0);
        this.ewN.setVisibility(8);
        if (this.fNT) {
            this.cou.startLoading();
            this.ewV.setVisibility(0);
        } else {
            this.cou.bgX();
            this.ewV.setVisibility(8);
        }
        if (this.fNV != null) {
            this.fNV.aqV();
        }
        this.ewR.setImageResource(d.f.icon_video_window);
        oB(this.exp);
        aLs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfW() {
        this.dIE = false;
        if (this.ewO != null) {
            this.mMainView.setLayoutParams(this.ewO);
        }
        a((TbPageContext) this.adf, false);
        this.crj.setVisibility(8);
        this.ewN.setVisibility(0);
        if (this.fNT) {
            this.cou.startLoading();
            this.ewV.setVisibility(0);
        } else {
            this.cou.bgX();
            this.ewV.setVisibility(8);
        }
        if (this.fNV != null) {
            this.fNV.aqW();
        }
        if (this.anu == 3 && this.fNW != null) {
            this.fNW.fG(false);
        } else if (!this.exa && this.ewS != null) {
            this.ewS.clearAnimation();
            this.ewS.setVisibility(4);
            this.fNL.setVisibility(0);
            if (this.fNW != null) {
                this.fNW.aqZ();
            }
        }
        aLp();
        this.ewR.setImageResource(d.f.icon_video_fullscreen);
        if (this.ewL != null && (this.ewL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewL.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.ewL.setLayoutParams(layoutParams);
        }
        this.mMainView.setSystemUiVisibility(0);
        bfS();
    }

    public void bfX() {
        if (this.bkP != null) {
            int af = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity());
            if (this.dIE) {
                af = com.baidu.adp.lib.util.l.ah(this.adf.getPageActivity());
            }
            this.fNL.setMax(af);
            int duration = this.bkP.getDuration();
            if (duration > 0) {
                if (this.fNO.getVisibility() == 0) {
                    this.fNL.setProgress(this.fNL.getMax());
                } else {
                    this.fNL.setProgress((int) ((this.bkP.getCurrentPosition() * this.fNL.getMax()) / duration));
                }
            }
        }
    }

    private void oB(int i2) {
        if (this.ewL != null && (this.ewL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewL.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.ewL.setLayoutParams(layoutParams);
        }
    }

    private void a(TbPageContext tbPageContext, boolean z) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = tbPageContext.getPageActivity().getWindow().getAttributes();
                attributes.flags |= 1024;
                tbPageContext.getPageActivity().getWindow().setAttributes(attributes);
                tbPageContext.getPageActivity().getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = tbPageContext.getPageActivity().getWindow().getAttributes();
            attributes2.flags &= -1025;
            tbPageContext.getPageActivity().getWindow().setAttributes(attributes2);
            tbPageContext.getPageActivity().getWindow().clearFlags(512);
        }
    }

    public boolean aLA() {
        return !this.dIE;
    }

    public void a(g.f fVar) {
        this.ewW = fVar;
    }

    public void a(g.a aVar) {
        this.fNR = aVar;
    }

    public void a(g.b bVar) {
        this.fNS = bVar;
    }

    public void aLB() {
        this.ewQ.setImageResource(d.f.icon_video_play);
        this.cou.bgX();
        this.crk.setVisibility(0);
        this.fNP.setVisibility(8);
        this.fNO.setVisibility(8);
        this.fNQ.setVisibility(8);
        this.anu = 2;
        this.bkP.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bkP != null) {
            this.bkP.setPbLoadingTime(currentTimeMillis);
        }
        bL(str, str2);
    }

    public void bL(String str, String str2) {
        bgc();
        this.fOm = true;
        this.anu = 0;
        this.bkP.setRecoveryState(0);
        bK(str, str2);
        this.bkP.setVideoPath(str, str2);
        this.cou.startLoading();
        this.ewV.setVisibility(0);
        this.crk.setVisibility(8);
        this.ewQ.setImageResource(d.f.icon_video_suspend_n);
        this.fNP.setVisibility(8);
        this.fNO.setVisibility(8);
        this.fNQ.setVisibility(8);
        this.cro.setVisibility(8);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exy);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.exy, 60000L);
    }

    public void bM(String str, String str2) {
        bgc();
        this.fOm = true;
        this.anu = 0;
        this.bkP.setRecoveryState(0);
        this.cou.startLoading();
        this.ewV.setVisibility(0);
        this.crk.setVisibility(8);
        this.ewQ.setImageResource(d.f.icon_video_suspend_n);
        this.fNP.setVisibility(8);
        this.fNO.setVisibility(8);
        this.fNQ.setVisibility(8);
        this.cro.setVisibility(8);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exy);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.exy, 60000L);
    }

    public void aLD() {
        this.anu = 1;
        this.bkP.setRecoveryState(1);
        this.bkP.start();
        this.ewQ.setImageResource(d.f.icon_video_suspend_n);
        this.ewV.setVisibility(8);
        this.ewM.setVisibility(8);
        this.cou.bgX();
        this.ewL.showProgress();
        this.crk.setVisibility(8);
        this.fNP.setVisibility(8);
        this.fNO.setVisibility(8);
        this.fNQ.setVisibility(8);
        bgg();
    }

    public void bfY() {
        if (com.baidu.adp.lib.util.j.gP() && this.fOk && !StringUtils.isNull(this.baI) && !StringUtils.isNull(this.aNu)) {
            this.fOk = false;
            this.fOl = true;
            bL(this.baI, this.aNu);
        }
    }

    public void ln(boolean z) {
        if (this.bkP != null) {
            this.bkP.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bkP.isPlaying() && this.fOf) {
            bfZ();
        }
        bgf();
        this.bkP.pause();
        aLB();
    }

    public void stopPlay() {
        if (this.bkP.isPlaying() && this.fOf) {
            bfZ();
        }
        this.anu = 5;
        this.bkP.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exw);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exy);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOr);
        this.bkP.stopPlayback();
        this.exa = false;
        this.fOm = false;
        this.mStartPosition = 0;
        ayA();
    }

    public void bfZ() {
        x.bhb().aD(this.baI, this.bkP.getCurrentPosition());
    }

    public void lo(boolean z) {
        this.fOf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (this.ewS != null) {
            this.ewM.setVisibility(0);
            this.crk.setVisibility(0);
            this.fNP.setVisibility(8);
            this.fNO.setVisibility(8);
            this.fNQ.setVisibility(8);
            this.cou.bgX();
            this.ewQ.setImageResource(d.f.icon_video_play);
            this.ewS.setVisibility(4);
            this.fNL.setVisibility(8);
            this.cro.setVisibility(8);
            this.ewL.Ne();
            this.ewV.setVisibility(z ? 0 : 8);
        }
    }

    public void ayA() {
        lp(true);
    }

    public boolean bga() {
        if (this.bkP == null) {
            return false;
        }
        return this.bkP.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bkP == null) {
            return 0;
        }
        return this.bkP.getCurrentPosition();
    }

    public void a(j jVar) {
        this.fNZ = jVar;
    }

    public void a(i iVar) {
        this.fNY = iVar;
    }

    public void a(h hVar) {
        this.fwO = hVar;
    }

    public void a(f fVar) {
        this.fOd = fVar;
    }

    public void a(g gVar) {
        this.fNX = gVar;
    }

    public void qU(String str) {
        this.fws = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgb() {
        a(this.baI, this.aNu, null, new Object[0]);
    }

    public void b(InterfaceC0201c interfaceC0201c) {
        this.fNW = interfaceC0201c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        bgc();
        if (com.baidu.adp.lib.util.j.gR() && !com.baidu.tieba.video.f.bvW().bvX()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.fOh = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fOc != null) {
                    this.fOc.fF(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
                aVar.dc(TbadkCoreApplication.getInst().getString(d.k.play_video_mobile_tip));
                aVar.a(d.k.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bgd();
                        if (c.this.fOh) {
                            c.this.bM(str, str2);
                        } else {
                            c.this.bL(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.ls(false);
                        }
                    }
                });
                aVar.b(d.k.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.adf).tD();
                return;
            } else if (this.fOc != null) {
                this.fOc.fF(true);
                return;
            } else {
                if (!this.fNK) {
                    this.fNK = true;
                    com.baidu.adp.lib.util.l.showToast(this.adf.getPageActivity(), d.k.play_video_mobile_tip2);
                }
                if (this.fOh) {
                    bM(str, str2);
                } else {
                    bL(str, str2);
                }
                if (dVar != null) {
                    dVar.ls(true);
                    return;
                }
                return;
            }
        }
        if (this.fOh) {
            bM(str, str2);
        } else {
            bL(str, str2);
        }
        if (dVar != null) {
            dVar.ls(true);
        }
        if (this.fOb != null) {
            this.fOb.aqX();
        }
    }

    private void bgc() {
        if (com.baidu.adp.lib.util.j.gR()) {
            com.baidu.tieba.video.f.bvW().cb(this.adf.getPageActivity());
        }
    }

    public void bgd() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void oz(String str) {
        this.ewV.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exC);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exw);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exy);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOq);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOr);
        this.byI.stop();
        this.exs.unregister(this.adf.getPageActivity());
    }

    public void rn(String str) {
        this.ewZ.setText(str);
    }

    public boolean aLE() {
        return this.exa;
    }

    public void aLF() {
        if (this.ewS != null) {
            aLH();
            this.ewS.setVisibility(0);
            this.fNN.setVisibility(0);
            if (this.fNW != null) {
                this.fNW.fG(true);
            }
            this.fNL.setVisibility(8);
            this.dbf.setAnimationListener(this.exA);
            this.ewS.startAnimation(this.dbf);
            this.exc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bge() {
        if (this.ewS != null) {
            if (this.ewS.getVisibility() == 0) {
                aLH();
                this.ewS.setVisibility(8);
                this.fNL.setVisibility(0);
                if (this.fNW != null) {
                    this.fNW.aqZ();
                    return;
                }
                return;
            }
            aLI();
        }
    }

    public void aLG() {
        if (this.ewS != null) {
            aLH();
            this.ewS.setVisibility(0);
            this.fNN.setVisibility(0);
            if (this.fNW != null) {
                this.fNW.fG(false);
            }
            this.fNL.setVisibility(8);
            this.dbg.setAnimationListener(this.exB);
            this.ewS.startAnimation(this.dbg);
        }
    }

    public void bgf() {
        if (this.ewS != null) {
            aLH();
            this.ewS.setVisibility(0);
            this.fNN.setVisibility(0);
            this.fNL.setVisibility(8);
            if (this.fNW != null) {
                this.fNW.fG(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLH() {
        if (this.ewS != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exC);
            this.dbg.setAnimationListener(null);
            this.dbf.setAnimationListener(null);
            this.ewS.clearAnimation();
            this.exc = false;
        }
    }

    public void aLI() {
        aLG();
        bgg();
    }

    private void bgg() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exC);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.exC, 3000L);
    }

    public void a(b bVar) {
        this.fNV = bVar;
    }

    public void oD(int i2) {
        if (this.bkP.getDuration() - i2 <= 3000) {
            aLH();
            if (this.ewS != null) {
                this.ewS.setVisibility(0);
                this.fNN.setVisibility(0);
                this.fNL.setVisibility(8);
                if (this.fNW != null) {
                    this.fNW.fG(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void K(boolean z, boolean z2) {
        int i2 = 8;
        if (this.byI != null) {
            if (this.ewR != null || this.fNM != null) {
                this.ewR.setVisibility((z || !z2) ? 0 : 8);
                View view2 = this.fNM;
                if (z || !z2) {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            }
            if (!z && z2 && this.ewL != null && (this.ewL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewL.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds52);
                this.ewL.setLayoutParams(layoutParams);
            }
            this.byI.lu(z);
        }
    }

    public int bB(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 == 0) {
            return com.baidu.adp.lib.util.l.ah(context);
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

    public int bgh() {
        return this.anu;
    }

    public void a(l lVar) {
        this.fOa = lVar;
    }

    public void a(k kVar) {
        this.fOb = kVar;
    }

    public void a(e eVar) {
        this.fOc = eVar;
    }

    public void lq(boolean z) {
        this.fOj = z;
    }

    public void lr(boolean z) {
        this.fNT = z;
    }

    public void ro(int i2) {
        this.fOn = i2;
    }

    public void bgi() {
        com.baidu.adp.lib.util.l.a(this.adf.getPageActivity(), this.ewQ, 40, 40, 40, 40);
    }
}
