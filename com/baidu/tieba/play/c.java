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
    private static int exo;
    private String aNu;
    private TbPageContext<?> adf;
    private String baI;
    private QuickVideoView bkP;
    private o byI;

    /* renamed from: com  reason: collision with root package name */
    private com.baidu.tieba.play.g f18com;
    private w cor;
    private View crg;
    private ImageView crh;
    private View crl;
    private Animation dbc;
    private Animation dbd;
    private VideoListMediaControllerView ewI;
    private View ewJ;
    private FrameLayout ewK;
    protected FrameLayout.LayoutParams ewL;
    private ImageView ewN;
    private ImageView ewO;
    private View ewP;
    private View ewR;
    private TbImageView ewS;
    private g.f ewT;
    private ImageView ewV;
    private TextView ewW;
    private View exb;
    private View exc;
    private TextView exd;
    private SeekBar exe;
    private ImageView exf;
    private ImageView exg;
    private int exh;
    private int exm;
    private int exn;
    private CallStateReceiver exp;
    private ProgressBar fNI;
    private View fNJ;
    private View fNK;
    private TextView fNL;
    private TextView fNM;
    private TextView fNN;
    private g.a fNO;
    private g.b fNP;
    private View.OnClickListener fNR;
    private b fNS;
    private InterfaceC0201c fNT;
    private g fNU;
    private i fNV;
    private j fNW;
    private l fNX;
    private k fNY;
    private e fNZ;
    private f fOa;
    private TextView fOf;
    private boolean fOh;
    private boolean fOi;
    private boolean fOj;
    private int fOk;
    private boolean fOl;
    private boolean fOm;
    private h fwL;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    public View mMainView;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fNH = false;
    protected boolean dIB = false;
    private boolean ewX = false;
    private boolean ewZ = false;
    private boolean fNQ = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int exi = 0;
    private int exj = 0;
    private boolean exq = false;
    private boolean fOb = true;
    private boolean fOc = true;
    private boolean fOd = false;
    private boolean fOe = false;
    private String fwp = null;
    private int anu = -1;
    private boolean fOg = false;
    private g.f aZo = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.f18com = gVar;
            if (c.this.bfT()) {
                c.this.cor.bgV();
                c.this.fOl = true;
                return;
            }
            c.this.afh();
        }
    };
    private VideoLoadingProgressView.a coC = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.afh();
        }
    };
    private Runnable exs = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bkP.getCurrentPosition() > 100) {
                c.this.ewX = true;
                c.this.ewJ.setVisibility(8);
                c.this.crl.setVisibility(8);
                c.this.cor.bgW();
                c.this.ewS.setVisibility(8);
                c.this.aLH();
                if (c.this.anu == 1 || c.this.anu == 2) {
                    if (c.this.ewP != null) {
                        c.this.ewP.setVisibility(0);
                        c.this.fNK.setVisibility(0);
                        c.this.fNI.setVisibility(8);
                        if (c.this.fNT != null) {
                            c.this.fNT.fG(false);
                        }
                    }
                    c.this.ewI.showProgress();
                    c.this.aLI();
                }
                if (c.this.ewT != null) {
                    c.this.ewT.onPrepared(c.this.bkP.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exs, 20L);
        }
    };
    private g.a aZn = new g.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.ewX = false;
            c.this.fOj = false;
            c.this.mStartPosition = 0;
            c.this.aLp();
            c.this.ewJ.setVisibility(0);
            c.this.fNI.setVisibility(8);
            c.this.fNI.setProgress(c.this.fNI.getMax());
            if (c.this.fNT != null) {
                c.this.fNT.fG(false);
            }
            if (c.this.dIB) {
                c.this.ewP.setVisibility(0);
                c.this.ewV.setVisibility(0);
                c.this.ewW.setVisibility(0);
                c.this.fNK.setVisibility(8);
            } else {
                c.this.ewP.setVisibility(8);
                c.this.ewV.setVisibility(8);
                c.this.ewW.setVisibility(8);
                c.this.fNK.setVisibility(8);
            }
            if (c.this.bkP == null || c.this.bkP.getDuration() > 150000) {
                c.this.lp(false);
            } else {
                c.this.fNL.setVisibility(0);
            }
            x.bhb().remove(c.this.baI);
            if (c.this.fNO != null) {
                c.this.fNO.onCompletion(gVar);
            }
            c.this.anu = 3;
            c.this.bkP.setRecoveryState(3);
            if (!c.this.dIB && c.this.bkP != null && c.this.bkP.getDuration() <= 150000) {
                if (!c.this.fOg) {
                    if (c.this.fNV != null) {
                        c.this.fNV.kM(true);
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
    private g.b exu = new g.b() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.crl.setVisibility(0);
            c.this.cor.bgX();
            c.this.anu = 4;
            c.this.bkP.setRecoveryState(4);
            if (c.this.fNP != null) {
                c.this.fNP.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.gP()) {
                c.this.fOh = true;
            }
            c.this.fOj = false;
            return true;
        }
    };
    private Runnable exv = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            c.this.crl.setVisibility(0);
            c.this.cor.bgX();
        }
    };
    private g.InterfaceC0202g aZs = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.InterfaceC0202g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.fOd) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fOn, 200L);
            }
        }
    };
    private Runnable fOn = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bkP == null || !c.this.fOd) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exs, 200L);
                c.this.fOd = false;
            } else if (c.this.mStartPosition != c.this.bkP.getCurrentPosition()) {
                c.this.fOd = false;
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exs, 20L);
            } else {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fOn, 200L);
            }
        }
    };
    private QuickVideoView.b bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.ewX = false;
            if (c.this.fNQ) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fOo, 300L);
            } else {
                c.this.fOj = false;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.exs);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.exv);
        }
    };
    private Runnable fOo = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.fOj = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getId() == c.this.crl.getId()) {
                c.this.bgb();
            } else if (view2.getId() != c.this.crh.getId() && view2.getId() != c.this.ewN.getId()) {
                if (view2.getId() == c.this.fNM.getId()) {
                    if (c.this.fNU != null) {
                        c.this.fNU.bcz();
                    }
                } else if (view2.getId() == c.this.fNL.getId()) {
                    if (c.this.fNV != null) {
                        c.this.fNV.kM(false);
                    }
                    c.this.bL(c.this.baI, c.this.aNu);
                } else if (view2.getId() != c.this.ewO.getId() && view2.getId() != c.this.fNJ.getId()) {
                    if (view2.getId() != c.this.ewV.getId()) {
                        if (c.this.fNR != null) {
                            c.this.fNR.onClick(view2);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new al("c11713"));
                    if (c.this.fNY != null) {
                        c.this.fNY.aqY();
                    }
                    if (c.this.bfU()) {
                        c.this.bfW();
                        c.this.lm(false);
                        return;
                    }
                    c.this.aLt();
                } else {
                    if (c.this.dIB) {
                        TiebaStatic.log(new al("c11714"));
                    } else {
                        TiebaStatic.log(new al("c11710"));
                    }
                    if (c.this.fNY != null) {
                        c.this.fNY.aqY();
                    }
                    if (c.this.bfU()) {
                        if (c.this.dIB) {
                            c.this.bfW();
                        } else {
                            c.this.bfV();
                        }
                        c.this.lm(c.this.dIB);
                        return;
                    }
                    c.this.aLt();
                }
            } else {
                c.this.bcq();
            }
        }
    };
    private Animation.AnimationListener exx = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.ewP != null) {
                c.this.ewP.setVisibility(8);
                c.this.fNI.setVisibility(0);
                c.this.ewZ = false;
                if (c.this.fNT != null) {
                    c.this.fNT.aqZ();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener exy = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Runnable exz = new Runnable() { // from class: com.baidu.tieba.play.c.9
        @Override // java.lang.Runnable
        public void run() {
            c.this.aLF();
        }
    };
    private CustomMessageListener exA = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b ezv = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gs(int i2) {
            int duration;
            if (c.this.bkP != null && (duration = c.this.bkP.getDuration()) > 0 && c.this.fNI != null) {
                c.this.fNI.setProgress((int) ((i2 * c.this.mMainView.getWidth()) / duration));
            }
            c.this.oD(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bdD = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.13
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.ewZ) {
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
    private QuickVideoView.a fOp = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bgj() {
            if (!c.this.fOg) {
                c.this.cor.startLoading();
                c.this.ewS.setVisibility(0);
                c.this.crh.setVisibility(8);
                c.this.ewN.setImageResource(d.f.icon_video_suspend_n);
                c.this.fNM.setVisibility(8);
                c.this.fNL.setVisibility(8);
                c.this.fNN.setVisibility(8);
                c.this.crl.setVisibility(8);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.exv);
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.exv, 60000L);
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
        this.exm = 0;
        this.fOm = true;
        if (tbPageContext != null) {
            this.adf = tbPageContext;
            this.mMainView = p(tbPageContext);
            this.mRootView = view2;
            this.fOm = z;
            if (view2 instanceof FrameLayout) {
                ((FrameLayout) view2).addView(this.mMainView);
            }
            this.ewR = view2;
            this.mMainView.setOnClickListener(this.mOnClickListener);
            this.bkP = (QuickVideoView) this.mMainView.findViewById(d.g.videoView);
            this.cor = new w((ViewGroup) this.mMainView.findViewById(d.g.auto_video_loading_container));
            this.cor.setLoadingAnimationListener(this.coC);
            this.ewI = (VideoListMediaControllerView) this.mMainView.findViewById(d.g.media_controller);
            this.ewI.setPlayer(this.bkP);
            this.fNI = (ProgressBar) this.mMainView.findViewById(d.g.pgrBottomProgress);
            this.fNI.setMax(com.baidu.adp.lib.util.l.af(this.adf.getPageActivity()));
            this.fNI.setProgress(0);
            this.ewI.setOnSeekBarChangeListener(this.bdD);
            this.ewI.setOnProgressUpdatedListener(this.ezv);
            this.ewJ = this.mMainView.findViewById(d.g.black_mask);
            this.crl = this.mMainView.findViewById(d.g.layout_error);
            this.crl.setOnClickListener(this.mOnClickListener);
            this.fOf = (TextView) this.mMainView.findViewById(d.g.auto_video_error_tips);
            this.ewK = (FrameLayout) this.mMainView.findViewById(d.g.danmu_container);
            this.ewN = (ImageView) this.mMainView.findViewById(d.g.img_play_icon);
            this.ewN.setOnClickListener(this.mOnClickListener);
            this.ewO = (ImageView) this.mMainView.findViewById(d.g.img_full_screen);
            this.ewO.setOnClickListener(this.mOnClickListener);
            this.fNJ = this.mMainView.findViewById(d.g.full_screen_container);
            this.fNJ.setOnClickListener(this.mOnClickListener);
            this.ewP = this.mMainView.findViewById(d.g.layout_media_controller);
            this.fNK = this.mMainView.findViewById(d.g.time_show_controller);
            this.bkP.setOnPreparedListener(this.aZo);
            this.bkP.setOnCompletionListener(this.aZn);
            this.bkP.setOnErrorListener(this.exu);
            this.bkP.setOnSeekCompleteListener(this.aZs);
            this.bkP.setOnSurfaceDestroyedListener(this.bkY);
            this.bkP.setOnRecoveryCallback(this.fOp);
            this.crh = (ImageView) this.mMainView.findViewById(d.g.img_play);
            this.crh.setOnClickListener(this.mOnClickListener);
            this.fNL = (TextView) this.mMainView.findViewById(d.g.txt_replay);
            this.fNL.setOnClickListener(this.mOnClickListener);
            this.fNM = (TextView) this.mMainView.findViewById(d.g.txt_playnext);
            this.fNM.setOnClickListener(this.mOnClickListener);
            this.fNN = (TextView) this.mMainView.findViewById(d.g.txt_next_video_title);
            this.ewS = (TbImageView) this.mMainView.findViewById(d.g.video_thumbnail);
            this.ewS.setDefaultErrorResource(0);
            this.ewS.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity());
            this.mScreenHeight = bB(this.adf.getPageActivity());
            this.ewV = (ImageView) this.mMainView.findViewById(d.g.img_exit);
            this.ewV.setOnClickListener(this.mOnClickListener);
            this.ewW = (TextView) this.mMainView.findViewById(d.g.video_title);
            this.crg = this.mMainView.findViewById(d.g.layout_title);
            this.crg.setVisibility(8);
            this.dbc = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dbd = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.adf.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.exh = this.mAudioManager.getStreamMaxVolume(3);
            this.exn = this.mAudioManager.getStreamVolume(3);
            exo = 100 / this.exh;
            this.mMainView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    if (c.this.fNW != null) {
                        c.this.fNW.onTouch(view3, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.ewX) {
                            if (c.this.mStatus == 1 && c.this.exj != 0) {
                                c.this.b(c.this.exj == 1 ? 1000.0f : -1000.0f, false);
                                c.this.exj = 0;
                                c.this.exi = 0;
                            }
                            if (!c.this.bkP.isPlaying() && 8 == c.this.crh.getVisibility()) {
                                c.this.crh.setVisibility(0);
                                c.this.fNM.setVisibility(8);
                                c.this.fNL.setVisibility(8);
                                c.this.fNN.setVisibility(8);
                            }
                        }
                        c.this.aLp();
                        if (c.this.fNW != null) {
                            c.this.fNW.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.byI = new o(this.adf.getPageActivity());
            if (this.fOm) {
                this.byI.start();
            }
            this.exm = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.ds16);
            this.exp = new CallStateReceiver();
            this.exp.register(this.adf.getPageActivity());
            this.adf.registerListener(this.exA);
            bfS();
        }
    }

    public void bfS() {
        if (this.fOb) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.mMainView.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.mMainView.setSystemUiVisibility(0);
    }

    public void ll(boolean z) {
        this.fOb = z;
        bfS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLp() {
        this.mStatus = 0;
        if (this.exb != null && this.exb.getParent() != null && (this.exb.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.exb.getParent()).removeView(this.exb);
                this.exb = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.exc != null && this.exc.getParent() != null && (this.exc.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.exc.getParent()).removeView(this.exc);
                this.exc = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aLq() {
        if (this.mStatus == 1) {
            if (this.exb == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
                LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.float_video_window_jindu, (ViewGroup) this.mMainView, true);
                this.exb = this.mMainView.findViewById(d.g.lay_jindu);
                this.exd = (TextView) this.exb.findViewById(d.g.show_time);
                this.exg = (ImageView) this.exb.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.exc == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
            LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.float_video_window_voice, (ViewGroup) this.mMainView, true);
            this.exc = this.mMainView.findViewById(d.g.lay_voice);
            this.exf = (ImageView) this.exc.findViewById(d.g.arrow_voice_icon);
            this.exe = (SeekBar) this.exc.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        this.fNR = onClickListener;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fNW != null) {
                c.this.fNW.onStart();
            }
            if (c.this.dIB && c.this.ewX) {
                if (!c.this.bkP.isPlaying() && c.this.crh.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.crh.setVisibility(8);
                    c.this.fNM.setVisibility(8);
                    c.this.fNL.setVisibility(8);
                    c.this.fNN.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.af(f2);
                    }
                } else {
                    if (c.this.dIB) {
                        c.this.aLs();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.exi = c.this.bkP.getCurrentPosition();
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
            if (c.this.fNX != null) {
                c.this.fNX.bcA();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.ewX) {
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
        if (!this.ewX) {
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
        if (this.mProgress % exo == 0) {
            if (f2 > 0.0f && this.exn < this.exh) {
                this.exn++;
            }
            if (f2 < 0.0f && this.exn > 0) {
                this.exn--;
            }
        }
        if (this.mProgress > 0) {
            this.exf.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.exf.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.exn, 0);
        this.exe.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.exi += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.exj = 1;
            } else {
                this.exi += 1000;
                this.exj = 2;
            }
            if (this.exi < 0) {
                this.exi = 0;
            } else if (this.exi > this.bkP.getDuration()) {
                this.exi = this.bkP.getDuration();
            }
        }
        aLq();
        String rr = this.ewI.rr(this.exi);
        if (f2 > 0.0f) {
            this.exg.setImageResource(d.f.icon_kuaitui);
        } else {
            this.exg.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(rr)) {
            this.exd.setText(new StringBuilder().append(rr).append("/").append(this.ewI.rr(this.bkP.getDuration())));
        }
        this.ewI.setCurrentDuration(this.exi, z ? false : true);
        this.ewP.setVisibility(8);
        this.fNI.setVisibility(0);
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
        if (this.fNQ) {
            return this.fOk == 0 && !this.fOl;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.bkP != null && this.f18com != null) {
            if (this.fOj) {
                this.bkP.start();
                this.fOj = false;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exs);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.exs, 20L);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exv);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOo);
            if (this.bkP.bgA()) {
                this.anu = 1;
                this.bkP.setRecoveryState(1);
            }
            if (this.f18com != null && this.ewI != null) {
                this.mStartPosition = x.bhb().rr(this.baI);
                this.ewI.Q(this.mStartPosition, this.f18com.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bkP != null) {
                        this.bkP.rq(this.mStartPosition);
                    } else {
                        this.f18com.seekTo(this.mStartPosition);
                    }
                    if (!this.fOi) {
                        this.ewI.showProgress();
                        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exs);
                    }
                    this.fOd = true;
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fNK.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.adf.getPageActivity());
                this.fNK.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.fNK.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.fNK.setLayoutParams(layoutParams);
        }
    }

    public void bcq() {
        if (!com.baidu.adp.lib.util.j.gP()) {
            com.baidu.adp.lib.util.l.showLongToast(this.adf.getPageActivity(), this.adf.getString(d.k.neterror));
        } else if (this.bkP.isPlaying()) {
            pausePlay();
            if (this.fOa != null) {
                this.fOa.onPause();
            }
        } else if (this.ewX) {
            aLD();
            if (this.fwL != null) {
                this.fwL.ara();
            }
        } else {
            bgb();
        }
    }

    public void aLt() {
        this.exq = true;
        if (this.byI != null) {
            this.byI.aLt();
        }
    }

    public boolean bfU() {
        return this.f18com != null && this.f18com.getVideoHeight() > this.f18com.getVideoWidth();
    }

    public boolean rn(int i2) {
        switch (i2) {
            case 4:
                if (this.dIB) {
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
                if (this.mAudioManager == null || this.exh <= 0 || this.exe == null) {
                    return false;
                }
                this.exn = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.exn * 100.0d) / this.exh);
                this.exe.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bkP;
    }

    public VideoListMediaControllerView aLu() {
        return this.ewI;
    }

    public void show() {
        this.mMainView.setVisibility(0);
    }

    public void aLy() {
        if (this.ewR != null) {
            ViewGroup.LayoutParams layoutParams = this.ewR.getLayoutParams();
            this.ewL = (FrameLayout.LayoutParams) this.mMainView.getLayoutParams();
            this.ewL.width = layoutParams.width;
            this.ewL.height = layoutParams.height;
            this.ewL.topMargin = 0;
            this.mMainView.setLayoutParams(this.ewL);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.exq) {
            if (this.dIB) {
                TiebaStatic.log(new al("c11712"));
            } else {
                TiebaStatic.log(new al("c11711"));
            }
        } else {
            this.exq = false;
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
        this.dIB = true;
        if (bfU()) {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.adf, true);
        this.ewP.setVisibility(0);
        this.crg.setVisibility(0);
        this.ewV.setVisibility(0);
        this.ewW.setVisibility(0);
        this.ewK.setVisibility(8);
        if (this.fNQ) {
            this.cor.startLoading();
            this.ewS.setVisibility(0);
        } else {
            this.cor.bgX();
            this.ewS.setVisibility(8);
        }
        if (this.fNS != null) {
            this.fNS.aqV();
        }
        this.ewO.setImageResource(d.f.icon_video_window);
        oB(this.exm);
        aLs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfW() {
        this.dIB = false;
        if (this.ewL != null) {
            this.mMainView.setLayoutParams(this.ewL);
        }
        a((TbPageContext) this.adf, false);
        this.crg.setVisibility(8);
        this.ewK.setVisibility(0);
        if (this.fNQ) {
            this.cor.startLoading();
            this.ewS.setVisibility(0);
        } else {
            this.cor.bgX();
            this.ewS.setVisibility(8);
        }
        if (this.fNS != null) {
            this.fNS.aqW();
        }
        if (this.anu == 3 && this.fNT != null) {
            this.fNT.fG(false);
        } else if (!this.ewX && this.ewP != null) {
            this.ewP.clearAnimation();
            this.ewP.setVisibility(4);
            this.fNI.setVisibility(0);
            if (this.fNT != null) {
                this.fNT.aqZ();
            }
        }
        aLp();
        this.ewO.setImageResource(d.f.icon_video_fullscreen);
        if (this.ewI != null && (this.ewI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewI.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.ewI.setLayoutParams(layoutParams);
        }
        this.mMainView.setSystemUiVisibility(0);
        bfS();
    }

    public void bfX() {
        if (this.bkP != null) {
            int af = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity());
            if (this.dIB) {
                af = com.baidu.adp.lib.util.l.ah(this.adf.getPageActivity());
            }
            this.fNI.setMax(af);
            int duration = this.bkP.getDuration();
            if (duration > 0) {
                if (this.fNL.getVisibility() == 0) {
                    this.fNI.setProgress(this.fNI.getMax());
                } else {
                    this.fNI.setProgress((int) ((this.bkP.getCurrentPosition() * this.fNI.getMax()) / duration));
                }
            }
        }
    }

    private void oB(int i2) {
        if (this.ewI != null && (this.ewI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewI.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.ewI.setLayoutParams(layoutParams);
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
        return !this.dIB;
    }

    public void a(g.f fVar) {
        this.ewT = fVar;
    }

    public void a(g.a aVar) {
        this.fNO = aVar;
    }

    public void a(g.b bVar) {
        this.fNP = bVar;
    }

    public void aLB() {
        this.ewN.setImageResource(d.f.icon_video_play);
        this.cor.bgX();
        this.crh.setVisibility(0);
        this.fNM.setVisibility(8);
        this.fNL.setVisibility(8);
        this.fNN.setVisibility(8);
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
        this.fOj = true;
        this.anu = 0;
        this.bkP.setRecoveryState(0);
        bK(str, str2);
        this.bkP.setVideoPath(str, str2);
        this.cor.startLoading();
        this.ewS.setVisibility(0);
        this.crh.setVisibility(8);
        this.ewN.setImageResource(d.f.icon_video_suspend_n);
        this.fNM.setVisibility(8);
        this.fNL.setVisibility(8);
        this.fNN.setVisibility(8);
        this.crl.setVisibility(8);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exv);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.exv, 60000L);
    }

    public void bM(String str, String str2) {
        bgc();
        this.fOj = true;
        this.anu = 0;
        this.bkP.setRecoveryState(0);
        this.cor.startLoading();
        this.ewS.setVisibility(0);
        this.crh.setVisibility(8);
        this.ewN.setImageResource(d.f.icon_video_suspend_n);
        this.fNM.setVisibility(8);
        this.fNL.setVisibility(8);
        this.fNN.setVisibility(8);
        this.crl.setVisibility(8);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exv);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.exv, 60000L);
    }

    public void aLD() {
        this.anu = 1;
        this.bkP.setRecoveryState(1);
        this.bkP.start();
        this.ewN.setImageResource(d.f.icon_video_suspend_n);
        this.ewS.setVisibility(8);
        this.ewJ.setVisibility(8);
        this.cor.bgX();
        this.ewI.showProgress();
        this.crh.setVisibility(8);
        this.fNM.setVisibility(8);
        this.fNL.setVisibility(8);
        this.fNN.setVisibility(8);
        bgg();
    }

    public void bfY() {
        if (com.baidu.adp.lib.util.j.gP() && this.fOh && !StringUtils.isNull(this.baI) && !StringUtils.isNull(this.aNu)) {
            this.fOh = false;
            this.fOi = true;
            bL(this.baI, this.aNu);
        }
    }

    public void ln(boolean z) {
        if (this.bkP != null) {
            this.bkP.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bkP.isPlaying() && this.fOc) {
            bfZ();
        }
        bgf();
        this.bkP.pause();
        aLB();
    }

    public void stopPlay() {
        if (this.bkP.isPlaying() && this.fOc) {
            bfZ();
        }
        this.anu = 5;
        this.bkP.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exs);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exv);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOo);
        this.bkP.stopPlayback();
        this.ewX = false;
        this.fOj = false;
        this.mStartPosition = 0;
        ayA();
    }

    public void bfZ() {
        x.bhb().aD(this.baI, this.bkP.getCurrentPosition());
    }

    public void lo(boolean z) {
        this.fOc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (this.ewP != null) {
            this.ewJ.setVisibility(0);
            this.crh.setVisibility(0);
            this.fNM.setVisibility(8);
            this.fNL.setVisibility(8);
            this.fNN.setVisibility(8);
            this.cor.bgX();
            this.ewN.setImageResource(d.f.icon_video_play);
            this.ewP.setVisibility(4);
            this.fNI.setVisibility(8);
            this.crl.setVisibility(8);
            this.ewI.Ne();
            this.ewS.setVisibility(z ? 0 : 8);
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
        this.fNW = jVar;
    }

    public void a(i iVar) {
        this.fNV = iVar;
    }

    public void a(h hVar) {
        this.fwL = hVar;
    }

    public void a(f fVar) {
        this.fOa = fVar;
    }

    public void a(g gVar) {
        this.fNU = gVar;
    }

    public void qU(String str) {
        this.fwp = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgb() {
        a(this.baI, this.aNu, null, new Object[0]);
    }

    public void b(InterfaceC0201c interfaceC0201c) {
        this.fNT = interfaceC0201c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        bgc();
        if (com.baidu.adp.lib.util.j.gR() && !com.baidu.tieba.video.f.bvW().bvX()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.fOe = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fNZ != null) {
                    this.fNZ.fF(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
                aVar.dc(TbadkCoreApplication.getInst().getString(d.k.play_video_mobile_tip));
                aVar.a(d.k.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bgd();
                        if (c.this.fOe) {
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
            } else if (this.fNZ != null) {
                this.fNZ.fF(true);
                return;
            } else {
                if (!this.fNH) {
                    this.fNH = true;
                    com.baidu.adp.lib.util.l.showToast(this.adf.getPageActivity(), d.k.play_video_mobile_tip2);
                }
                if (this.fOe) {
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
        if (this.fOe) {
            bM(str, str2);
        } else {
            bL(str, str2);
        }
        if (dVar != null) {
            dVar.ls(true);
        }
        if (this.fNY != null) {
            this.fNY.aqX();
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
        this.ewS.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exz);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exs);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exv);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOn);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOo);
        this.byI.stop();
        this.exp.unregister(this.adf.getPageActivity());
    }

    public void rn(String str) {
        this.ewW.setText(str);
    }

    public boolean aLE() {
        return this.ewX;
    }

    public void aLF() {
        if (this.ewP != null) {
            aLH();
            this.ewP.setVisibility(0);
            this.fNK.setVisibility(0);
            if (this.fNT != null) {
                this.fNT.fG(true);
            }
            this.fNI.setVisibility(8);
            this.dbc.setAnimationListener(this.exx);
            this.ewP.startAnimation(this.dbc);
            this.ewZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bge() {
        if (this.ewP != null) {
            if (this.ewP.getVisibility() == 0) {
                aLH();
                this.ewP.setVisibility(8);
                this.fNI.setVisibility(0);
                if (this.fNT != null) {
                    this.fNT.aqZ();
                    return;
                }
                return;
            }
            aLI();
        }
    }

    public void aLG() {
        if (this.ewP != null) {
            aLH();
            this.ewP.setVisibility(0);
            this.fNK.setVisibility(0);
            if (this.fNT != null) {
                this.fNT.fG(false);
            }
            this.fNI.setVisibility(8);
            this.dbd.setAnimationListener(this.exy);
            this.ewP.startAnimation(this.dbd);
        }
    }

    public void bgf() {
        if (this.ewP != null) {
            aLH();
            this.ewP.setVisibility(0);
            this.fNK.setVisibility(0);
            this.fNI.setVisibility(8);
            if (this.fNT != null) {
                this.fNT.fG(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLH() {
        if (this.ewP != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exz);
            this.dbd.setAnimationListener(null);
            this.dbc.setAnimationListener(null);
            this.ewP.clearAnimation();
            this.ewZ = false;
        }
    }

    public void aLI() {
        aLG();
        bgg();
    }

    private void bgg() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.exz);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.exz, 3000L);
    }

    public void a(b bVar) {
        this.fNS = bVar;
    }

    public void oD(int i2) {
        if (this.bkP.getDuration() - i2 <= 3000) {
            aLH();
            if (this.ewP != null) {
                this.ewP.setVisibility(0);
                this.fNK.setVisibility(0);
                this.fNI.setVisibility(8);
                if (this.fNT != null) {
                    this.fNT.fG(false);
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
            if (this.ewO != null || this.fNJ != null) {
                this.ewO.setVisibility((z || !z2) ? 0 : 8);
                View view2 = this.fNJ;
                if (z || !z2) {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            }
            if (!z && z2 && this.ewI != null && (this.ewI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewI.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds52);
                this.ewI.setLayoutParams(layoutParams);
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
        this.fNX = lVar;
    }

    public void a(k kVar) {
        this.fNY = kVar;
    }

    public void a(e eVar) {
        this.fNZ = eVar;
    }

    public void lq(boolean z) {
        this.fOg = z;
    }

    public void lr(boolean z) {
        this.fNQ = z;
    }

    public void ro(int i2) {
        this.fOk = i2;
    }

    public void bgi() {
        com.baidu.adp.lib.util.l.a(this.adf.getPageActivity(), this.ewN, 40, 40, 40, 40);
    }
}
