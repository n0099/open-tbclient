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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.view.SwitchImageView;
import com.kwad.sdk.collector.AppStatusRules;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int ldo;
    private static CallStateReceiver ldp;
    private String amC;
    private TbImageView ams;
    private View bMl;
    public View bUP;
    private Animation chW;
    private TbPageContext<?> eUY;
    private String fNd;
    private com.baidu.tieba.play.m fUa;
    protected TbCyberVideoView gzX;
    private ImageView hhz;
    protected View izE;
    private Animation jny;
    private VideoListMediaControllerView lcL;
    private View lcM;
    private FrameLayout lcN;
    protected FrameLayout.LayoutParams lcO;
    private ImageView lcR;
    private View lcS;
    private View lcU;
    private CyberPlayerManager.OnPreparedListener lcW;
    private TextView lcY;
    private View ldc;
    private View ldd;
    private TextView lde;
    private SeekBar ldf;
    private ImageView ldg;
    private ImageView ldh;
    private int ldi;
    private com.baidu.tieba.play.j ldm;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private d mGA;
    private o mGC;
    private h mGD;
    private j mGE;
    private k mGF;
    private m mGG;
    private a mGH;
    private n mGI;
    private l mGJ;
    private f mGK;
    private g mGL;
    private TextView mGQ;
    private boolean mGS;
    private boolean mGT;
    private boolean mGU;
    private int mGV;
    private boolean mGW;
    private boolean mGX;
    private GestureDetector mGestureDetector;
    private ProgressBar mGm;
    private View mGn;
    private SwitchImageView mGo;
    private TextView mGp;
    private TextView mGq;
    private TextView mGr;
    private int mGs;
    private CyberPlayerManager.OnCompletionListener mGt;
    private CyberPlayerManager.OnErrorListener mGu;
    private View.OnClickListener mGy;
    protected InterfaceC0848c mGz;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int mVolume;
    private i mjH;
    private p mjv;
    private int abJ = 100;
    private boolean mGk = false;
    protected boolean abT = false;
    private boolean abI = false;
    private boolean mGv = false;
    private boolean mGw = false;
    private boolean mGx = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int ldj = 0;
    private int ldk = 0;
    private long mGB = AppStatusRules.DEFAULT_GRANULARITY;
    private int ldn = 0;
    private boolean ldq = false;
    private boolean mGM = true;
    private boolean mGN = true;
    private boolean mGO = false;
    private boolean mGP = false;
    private String mji = null;
    private int currentState = -1;
    private boolean mGR = false;
    private boolean mGY = false;
    private boolean mGZ = false;
    private CyberPlayerManager.OnPreparedListener eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.lcL != null && c.this.gzX != null && c.this.gzX.getDuration() > 0) {
                c.this.lcL.bw(0, c.this.gzX.getDuration());
            }
            c.this.csa();
            if (c.this.mGC != null) {
                c.this.mGC.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rA();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a iwJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.csa();
        }
    };
    private Runnable abO = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            if (c.this.ams.getVisibility() != 8) {
                if (c.this.gzX.getCurrentPosition() > c.this.abJ) {
                    c.this.rA();
                } else {
                    com.baidu.adp.lib.f.e.mA().postDelayed(c.this.abO, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.gzX != null) {
                int duration = c.this.gzX.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.abI = false;
                    c.this.mGU = false;
                    c.this.mStartPosition = 0;
                    c.this.dcg();
                    c.this.lcM.setVisibility(0);
                    c.this.mGm.setProgress(c.this.mGm.getMax());
                    c.this.abJ = 100;
                    if (c.this.mGt != null) {
                        c.this.mGt.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.xj(false);
                        c.this.xk(true);
                    } else {
                        c.this.dzM();
                        c.this.mGp.setVisibility(0);
                    }
                    if (!c.this.abT && duration <= 150000) {
                        if (!c.this.mGR) {
                            if (c.this.mGE != null) {
                                c.this.mGE.wk(true);
                            }
                            c.this.E(c.this.mVideoUrl, c.this.amC, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gzX.pause();
                            c.this.gzX.seekTo(0);
                        }
                    }
                    if (c.this.mGC != null) {
                        c.this.mGC.AY(c.this.mGm.getMax());
                        c.this.mGC.GM();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.izE.setVisibility(0);
            c.this.fUa.dAc();
            c.this.currentState = 4;
            if (c.this.mGu != null) {
                c.this.mGu.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mGS = true;
            }
            if (c.this.mGC != null) {
                c.this.mGC.cMH();
            }
            c.this.mGU = false;
            return true;
        }
    };
    protected Runnable ldt = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gzX == null || !c.this.gzX.isPlaying()) {
                c.this.izE.setVisibility(0);
                c.this.fUa.dAc();
                if (c.this.mGC != null) {
                    c.this.mGC.cMH();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mGO) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mHa, 200L);
            }
        }
    };
    private Runnable mHa = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gzX == null || !c.this.mGO) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.abO, 200L);
                c.this.mGO = false;
            } else if (c.this.mStartPosition != c.this.gzX.getCurrentPosition()) {
                c.this.mGO = false;
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.abO, 20L);
            } else {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mHa, 200L);
            }
        }
    };
    private TbCyberVideoView.a fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abI = false;
            if (c.this.mGw && !c.this.mGx) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mHb, 300L);
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.ldt);
        }
    };
    private Runnable mHb = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mGU = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.mjv != null) {
                c.this.mjv.cMJ();
            }
            if (view.getId() != c.this.izE.getId()) {
                if (view.getId() != c.this.mGo.getId()) {
                    if (view.getId() == c.this.mGq.getId()) {
                        if (c.this.mGD != null) {
                            c.this.mGD.dtI();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mGp.getId()) {
                        if (c.this.mGE != null) {
                            c.this.mGE.wk(false);
                        }
                        c.this.fX(c.this.mVideoUrl, c.this.amC);
                        return;
                    } else if (view.getId() == c.this.lcR.getId()) {
                        int i2 = c.this.mGw ? 1 : 2;
                        if (c.this.abT) {
                            TiebaStatic.log(new ar("c11714"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.amC).dR("fid", c.this.fNd).ap("obj_type", i2).ap("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ar("c11710"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.amC).dR("fid", c.this.fNd).ap("obj_type", i2).ap("obj_source", 1));
                        }
                        if (c.this.mGJ != null) {
                            c.this.mGJ.cFp();
                        }
                        if (c.this.dzx()) {
                            if (c.this.abT) {
                                c.this.dzA();
                            } else {
                                c.this.dzz();
                            }
                            c.this.xg(c.this.abT);
                            return;
                        }
                        c.this.TZ();
                        return;
                    } else if (view.getId() != c.this.hhz.getId()) {
                        if (c.this.mGy != null) {
                            c.this.mGy.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ar("c11713"));
                        if (c.this.mGJ != null) {
                            c.this.mGJ.cFp();
                        }
                        if (c.this.dzx()) {
                            c.this.dzA();
                            c.this.xg(false);
                            return;
                        }
                        c.this.TZ();
                        return;
                    }
                }
                TiebaStatic.log(new ar("c13255"));
                c.this.dtB();
                c.this.dzO();
                if (c.this.currentState != 1) {
                    c.this.dzK();
                    c.this.dzL();
                } else {
                    c.this.dcw();
                }
                if (c.this.mGH != null) {
                    c.this.mGH.rI(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gzX.stopPlayback();
            c.this.abI = false;
            c.this.dzF();
        }
    };
    private Animation.AnimationListener ldv = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener ldw = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable ldx = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.dct();
        }
    };
    private CustomMessageListener ldy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b lfs = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void tb(int i2) {
            int duration;
            if (c.this.gzX != null && (duration = c.this.gzX.getDuration()) > 0 && c.this.mGm != null) {
                c.this.mGm.setProgress((int) ((i2 * c.this.bUP.getWidth()) / duration));
                if (c.this.mGC != null) {
                    c.this.mGC.AY((c.this.gzX.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener ghI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new ar("c13256"));
            c.this.dzK();
            c.this.xk(false);
            if (c.this.mGH != null) {
                c.this.mGH.rI(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.dck() != null) {
                c.this.Ec(c.this.dck().getSeekPosition());
                if (!c.this.dcs()) {
                    c.this.dzF();
                } else {
                    c.this.resumePlay();
                    if (c.this.mjH != null) {
                        c.this.mjH.cFr();
                    }
                }
            }
            c.this.xk(true);
            c.this.dzJ();
            if (c.this.mGH != null) {
                c.this.mGH.rI(true);
            }
            if (c.this.mGI != null) {
                c.this.mGI.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rI(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0848c {
        void rj();

        void rk();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cFq();

        void qY(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void xo(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void qX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dtI();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cFr();
    }

    /* loaded from: classes.dex */
    public interface j {
        void wk(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cFo();

        void cFp();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dtJ();

        boolean dtK();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void AY(int i);

        void GM();

        void cMH();

        void cMI();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cMJ();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mGW = true;
        if (tbPageContext != null) {
            this.eUY = tbPageContext;
            this.mRootView = view;
            this.mGW = z;
            this.lcU = view;
            this.mActivity = this.eUY.getPageActivity();
            init();
        }
    }

    public void init() {
        this.bUP = as(this.mActivity);
        this.bUP.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.bUP);
        }
        this.gzX = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.bUP).addView(this.gzX.getView(), 0);
        this.gzX.getView().setLayoutParams(layoutParams);
        this.fUa = new com.baidu.tieba.play.m((ViewGroup) this.bUP.findViewById(R.id.auto_video_loading_container));
        this.fUa.setLoadingAnimationListener(this.iwJ);
        this.lcL = (VideoListMediaControllerView) this.bUP.findViewById(R.id.media_controller);
        this.lcL.setPlayer(this.gzX);
        this.mGm = (ProgressBar) this.bUP.findViewById(R.id.pgrBottomProgress);
        this.mGm.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mGm.setProgress(0);
        this.lcL.setOnSeekBarChangeListener(this.ghI);
        this.lcL.setOnProgressUpdatedListener(this.lfs);
        this.lcM = this.bUP.findViewById(R.id.black_mask);
        this.izE = this.bUP.findViewById(R.id.layout_error);
        this.izE.setOnClickListener(this.mOnClickListener);
        this.mGQ = (TextView) this.bUP.findViewById(R.id.auto_video_error_tips);
        this.lcN = (FrameLayout) this.bUP.findViewById(R.id.danmu_container);
        this.lcR = (ImageView) this.bUP.findViewById(R.id.img_full_screen);
        this.lcR.setOnClickListener(this.mOnClickListener);
        this.lcS = this.bUP.findViewById(R.id.layout_media_controller);
        this.mGn = this.bUP.findViewById(R.id.time_show_controller);
        this.gzX.setContinuePlayEnable(true);
        this.gzX.setOnPreparedListener(this.eAA);
        this.gzX.setOnCompletionListener(this.eAC);
        this.gzX.setOnErrorListener(this.lds);
        this.gzX.setOnSeekCompleteListener(this.eAF);
        this.gzX.setOnInfoListener(this.eAD);
        this.gzX.setOnSurfaceDestroyedListener(this.fUi);
        this.mGo = (SwitchImageView) this.bUP.findViewById(R.id.img_play_controller);
        this.mGo.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mGo.setState(0);
        this.mGo.setOnClickListener(this.mOnClickListener);
        this.mGp = (TextView) this.bUP.findViewById(R.id.txt_replay);
        this.mGp.setOnClickListener(this.mOnClickListener);
        this.mGq = (TextView) this.bUP.findViewById(R.id.txt_playnext);
        this.mGq.setOnClickListener(this.mOnClickListener);
        this.mGr = (TextView) this.bUP.findViewById(R.id.txt_next_video_title);
        this.ams = (TbImageView) this.bUP.findViewById(R.id.video_thumbnail);
        this.ams.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hhz = (ImageView) this.bUP.findViewById(R.id.img_exit);
        this.hhz.setOnClickListener(this.mOnClickListener);
        this.lcY = (TextView) this.bUP.findViewById(R.id.video_title);
        this.bMl = this.bUP.findViewById(R.id.layout_title);
        this.bMl.setVisibility(8);
        this.jny = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.chW = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.ldi = this.mAudioManager.getStreamMaxVolume(3);
        this.mVolume = this.mAudioManager.getStreamVolume(3);
        ldo = 100 / this.ldi;
        this.bUP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mGF != null) {
                    c.this.mGF.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abI) {
                        if (c.this.mStatus == 1 && c.this.ldk != 0) {
                            c.this.c(c.this.ldk == 1 ? 1000.0f : -1000.0f, false);
                            c.this.ldk = 0;
                            c.this.ldj = 0;
                        }
                        if (!c.this.gzX.isPlaying()) {
                            c.this.mGq.setVisibility(8);
                            c.this.mGp.setVisibility(8);
                            c.this.mGr.setVisibility(8);
                        }
                    }
                    c.this.dcg();
                    if (c.this.mGF != null) {
                        c.this.mGF.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.ldm = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mGW) {
            this.ldm.start();
        }
        this.ldn = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (ldp == null) {
            ldp = new CallStateReceiver();
        }
        ldp.register(this.mActivity);
        dzw();
        MessageManager.getInstance().registerListener(this.ldy);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.ldy);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Hi(int i2) {
        if (this.ams != null) {
            this.ams.setDefaultBgResource(i2);
        }
    }

    public void Hj(int i2) {
        if (this.ams != null) {
            this.ams.setPlaceHolder(i2);
        }
    }

    public void dzw() {
        if (this.mGM) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.bUP.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.bUP.setSystemUiVisibility(0);
    }

    public void xd(boolean z) {
        this.mGM = z;
        dzw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcg() {
        this.mStatus = 0;
        if (this.ldc != null && this.ldc.getParent() != null && (this.ldc.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ldc.getParent()).removeView(this.ldc);
                this.ldc = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ldd != null && this.ldd.getParent() != null && (this.ldd.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ldd.getParent()).removeView(this.ldd);
                this.ldd = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void dch() {
        if (this.mStatus == 1) {
            if (this.ldc == null && this.bUP != null && (this.bUP instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.bUP, true);
                this.ldc = this.bUP.findViewById(R.id.lay_jindu);
                this.lde = (TextView) this.ldc.findViewById(R.id.show_time);
                this.ldh = (ImageView) this.ldc.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ldd == null && this.bUP != null && (this.bUP instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.bUP, true);
            this.ldd = this.bUP.findViewById(R.id.lay_voice);
            this.ldg = (ImageView) this.ldd.findViewById(R.id.arrow_voice_icon);
            this.ldf = (SeekBar) this.ldd.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ad(View.OnClickListener onClickListener) {
        this.mGy = onClickListener;
    }

    public void xe(boolean z) {
        this.mGw = z;
    }

    public void xf(boolean z) {
        this.mGx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mGF != null) {
                c.this.mGF.onStart();
            }
            if (c.this.abT && c.this.abI) {
                if (c.this.mStatus == 1) {
                    c.this.dzM();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aR(f2);
                    }
                } else {
                    if (c.this.abT) {
                        c.this.dcj();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ldj = c.this.gzX.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aR(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.mGX) {
                if (c.this.mGG != null && c.this.mGG.dtJ()) {
                    return true;
                }
                c.this.dtB();
                c.this.dzO();
                if (c.this.gzX.isPlaying()) {
                    c.this.dzJ();
                } else {
                    c.this.dzK();
                }
                if (c.this.mGH != null) {
                    c.this.mGH.rI(c.this.gzX.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mGX) {
                if (c.this.abI) {
                    if (c.this.mGG != null && c.this.mGG.dtK()) {
                        return true;
                    }
                    c.this.dzI();
                    if (c.this.gzX.isPlaying()) {
                        c.this.dzJ();
                    } else {
                        c.this.dzK();
                    }
                    if (c.this.mGH != null) {
                        c.this.mGH.rI(c.this.gzX.isPlaying());
                    }
                } else {
                    c.this.dtB();
                    c.this.dzO();
                    if (c.this.currentState != 1) {
                        c.this.dzK();
                        c.this.dzL();
                    } else {
                        c.this.dcw();
                    }
                    if (c.this.mGH != null) {
                        c.this.mGH.rI(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcj() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bUP.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bUP.setSystemUiVisibility(4);
        } else {
            this.bUP.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(float f2) {
        if (!this.abI) {
            this.mStatus = 0;
            return;
        }
        if (ldo == 0) {
            this.ldi = this.mAudioManager.getStreamMaxVolume(3);
            ldo = 100 / this.ldi;
            if (ldo == 0) {
                ldo = 1;
            }
        }
        dch();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ldo == 0) {
            if (f2 > 0.0f && this.mVolume < this.ldi) {
                this.mVolume++;
            }
            if (f2 < 0.0f && this.mVolume > 0) {
                this.mVolume--;
            }
        }
        if (this.mProgress > 0) {
            this.ldg.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.ldg.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.mVolume, 0);
        this.ldf.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.ldj -= 1000;
                this.ldk = 1;
            } else {
                this.ldj += 1000;
                this.ldk = 2;
            }
            if (this.ldj < 0) {
                this.ldj = 0;
            } else if (this.ldj > this.gzX.getDuration()) {
                this.ldj = this.gzX.getDuration();
            }
        }
        dch();
        String Hq = this.lcL.Hq(this.ldj);
        if (f2 > 0.0f) {
            this.ldh.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.ldh.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Hq)) {
            this.lde.setText(new StringBuilder().append(Hq).append("/").append(this.lcL.Hq(this.gzX.getDuration())));
        }
        this.lcL.setCurrentDuration(this.ldj, z ? false : true);
        dzM();
        dzB();
    }

    protected View as(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Hk(int i2) {
        this.mGs = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amC = str2;
    }

    public void setFid(String str) {
        this.fNd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csa() {
        int i2 = 100;
        if (this.gzX != null && this.lcL != null) {
            this.lcL.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dAg().QD(this.mVideoUrl);
            if (this.mGU) {
                this.gzX.setVolume(1.0f, 1.0f);
                this.gzX.start();
                this.mGU = false;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
                com.baidu.adp.lib.f.e.mA().postDelayed(this.abO, 20L);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHb);
                if (this.gzX.dAn()) {
                    this.currentState = 1;
                    dzM();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dAg().QD(this.mVideoUrl);
                this.lcL.setPlayer(this.gzX);
                if (this.mStartPosition != 0) {
                    this.mGO = true;
                }
                if (!this.mGT) {
                    this.lcL.showProgress();
                }
                if (!this.mGw && this.gzX.getDuration() <= 0) {
                    dck().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gzX.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abJ = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        if (this.ams.getVisibility() != 8 || !this.abI) {
            this.abI = true;
            this.lcM.setVisibility(8);
            this.izE.setVisibility(8);
            this.fUa.dAb();
            this.ams.setVisibility(8);
            dzN();
            this.lcL.showProgress();
            this.mGm.setVisibility(0);
            if (this.lcW != null) {
                this.lcW.onPrepared();
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
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    protected void xg(boolean z) {
        if (hasNavBar(this.mActivity) && (this.mGn.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mGn.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mGn.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mGn.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mGn.setLayoutParams(layoutParams);
        }
    }

    public void dtB() {
        if (this.gzX.isPlaying()) {
            pausePlay();
            if (this.mGL != null) {
                this.mGL.onPause();
            }
            if (this.mGC != null) {
                this.mGC.onPaused();
            }
        } else if (this.abI) {
            resumePlay();
            if (this.mjH != null) {
                this.mjH.cFr();
            }
            if (this.mGC != null) {
                this.mGC.cMI();
            }
        } else {
            dzF();
        }
    }

    public void TZ() {
        this.ldq = true;
        if (this.ldm != null) {
            this.ldm.TZ();
        }
    }

    public boolean dzx() {
        return this.gzX != null && this.gzX.getView().getHeight() >= this.gzX.getView().getWidth();
    }

    public void dzy() {
        xg(false);
        dzA();
    }

    public boolean Hl(int i2) {
        switch (i2) {
            case 4:
                if (this.abT) {
                    if (dzx()) {
                        xg(false);
                        dzA();
                    } else {
                        TZ();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.ldi <= 0 || this.ldf == null) {
                    return false;
                }
                this.mVolume = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.mVolume * 100.0d) / this.ldi);
                this.ldf.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gzX;
    }

    public VideoListMediaControllerView dck() {
        return this.lcL;
    }

    public void show() {
        this.bUP.setVisibility(0);
    }

    public void dco() {
        if (this.lcU != null) {
            ViewGroup.LayoutParams layoutParams = this.lcU.getLayoutParams();
            this.lcO = (FrameLayout.LayoutParams) this.bUP.getLayoutParams();
            this.lcO.width = layoutParams.width;
            this.lcO.height = layoutParams.height;
            this.lcO.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.bUP.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.bUP.setLayoutParams(this.lcO);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.ldq) {
            if (this.abT) {
                TiebaStatic.log(new ar("c11712"));
            } else {
                TiebaStatic.log(new ar("c11711"));
            }
        } else {
            this.ldq = false;
        }
        if (configuration.orientation == 2) {
            dzz();
        } else {
            dzA();
        }
        dzB();
        if (this.mActivity == com.baidu.adp.base.b.kB().currentActivity()) {
            resumePlay();
        }
        dzO();
        dcw();
        if (this.mGH != null) {
            this.mGH.rI(true);
        }
    }

    protected void dzz() {
        this.abT = true;
        this.bUP.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bFl().fx(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bFl().fy(this.mActivity))));
        j(this.mActivity, true);
        this.bMl.setVisibility(0);
        this.hhz.setVisibility(0);
        this.lcY.setVisibility(0);
        this.lcN.setVisibility(8);
        this.fUa.dAc();
        this.ams.setVisibility(8);
        this.lcR.setImageResource(R.drawable.icon_video_narrow_white);
        DZ(this.ldn);
        dcj();
        if (this.mGz != null) {
            this.mGz.rj();
        }
    }

    protected void dzA() {
        this.abT = false;
        if (this.lcO != null) {
            this.bUP.setLayoutParams(this.lcO);
        }
        j(this.mActivity, false);
        this.bMl.setVisibility(8);
        this.lcN.setVisibility(0);
        this.fUa.dAc();
        this.ams.setVisibility(8);
        this.lcR.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.lcL != null && (this.lcL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcL.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.lcL.setLayoutParams(layoutParams);
        }
        this.bUP.setSystemUiVisibility(0);
        dzw();
        if (this.mGz != null) {
            this.mGz.rk();
        }
    }

    public void dzB() {
        if (this.gzX != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.abT) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mGm.setMax(equipmentWidth);
            int duration = this.gzX.getDuration();
            if (duration > 0) {
                if (this.mGp.getVisibility() == 0) {
                    this.mGm.setProgress(this.mGm.getMax());
                } else {
                    this.mGm.setProgress((int) ((this.gzX.getCurrentPositionSync() * this.mGm.getMax()) / duration));
                }
            }
        }
    }

    private void DZ(int i2) {
        if (this.lcL != null && (this.lcL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcL.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.lcL.setLayoutParams(layoutParams);
        }
    }

    private void j(Activity activity, boolean z) {
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

    public boolean dcq() {
        return !this.abT;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.lcW = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mGt = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mGu = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mGP) {
            fY(str, str2);
        } else {
            fX(str, str2);
        }
        if (eVar != null) {
            eVar.xo(z);
        }
    }

    public void fW(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2, boolean z) {
        dzG();
        this.mGU = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gzX.setVideoDuration(this.mGs);
        this.gzX.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
        if (this.mGB > 0) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.ldt, this.mGB);
        }
        if (this.mGC != null) {
            this.mGC.onStarted();
        }
        this.fUa.startLoading();
        xh(z);
    }

    public void fX(String str, String str2) {
        E(str, str2, true);
    }

    public void fY(String str, String str2) {
        dzG();
        this.mGU = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
        if (this.mGB > 0) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.ldt, this.mGB);
        }
        if (this.mGC != null) {
            this.mGC.onStarted();
        }
        this.fUa.startLoading();
        xh(true);
    }

    public void dzC() {
        resumePlay();
        this.mGm.setVisibility(0);
    }

    public void resumePlay() {
        int i2 = 100;
        if (this.gzX != null && this.lcL != null) {
            this.abI = true;
            this.currentState = 1;
            this.gzX.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dAg().QD(this.mVideoUrl);
            this.mGO = true;
            if (this.mStartPosition > 100 && this.gzX.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abJ = i2;
            this.fUa.dAc();
            xh(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mGS && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amC)) {
            this.mGS = false;
            this.mGT = true;
            fX(this.mVideoUrl, this.amC);
        }
    }

    private void xh(boolean z) {
        if (z) {
            this.ams.setVisibility(0);
            dzM();
            this.mGm.setProgress(0);
        } else {
            this.ams.setVisibility(8);
            dzM();
        }
        this.lcL.showProgress();
        this.lcM.setVisibility(8);
        this.mGq.setVisibility(8);
        this.mGp.setVisibility(8);
        this.mGr.setVisibility(8);
        this.izE.setVisibility(8);
    }

    private void dzD() {
        this.fUa.dAc();
        this.mGq.setVisibility(8);
        this.mGp.setVisibility(8);
        this.mGr.setVisibility(8);
        dzO();
    }

    public void pausePlay() {
        this.gzX.pause();
        this.currentState = 2;
        dzD();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHb);
        this.gzX.stopPlayback();
        this.abI = false;
        this.mGU = false;
        this.mStartPosition = 0;
        cSD();
    }

    public void dzE() {
        if (this.gzX.getDuration() >= this.gzX.getCurrentPosition()) {
            com.baidu.tieba.play.n.dAg().bL(this.mVideoUrl, this.gzX.getCurrentPositionSync());
        }
    }

    public void xi(boolean z) {
        this.mGN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        if (this.lcS != null) {
            this.lcM.setVisibility(0);
            this.mGq.setVisibility(8);
            this.mGp.setVisibility(8);
            this.mGr.setVisibility(8);
            this.fUa.dAc();
            dzM();
            this.mGm.setVisibility(8);
            this.izE.setVisibility(8);
            this.lcL.aRo();
            this.ams.setVisibility(z ? 0 : 8);
        }
    }

    public void cSD() {
        xj(true);
    }

    public boolean rl() {
        if (this.gzX == null) {
            return false;
        }
        return this.gzX.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gzX == null) {
            return 0;
        }
        return this.gzX.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mGF = kVar;
    }

    public void a(j jVar) {
        this.mGE = jVar;
    }

    public void a(i iVar) {
        this.mjH = iVar;
    }

    public void a(g gVar) {
        this.mGL = gVar;
    }

    public void a(h hVar) {
        this.mGD = hVar;
    }

    public void Qd(String str) {
        this.mji = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzF() {
        a(this.mVideoUrl, this.amC, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mGA = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dzG();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.f.dRX().dRY() && !TbSingleton.getInstance().hasAgreeToPlay()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mGP = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mGK != null) {
                    this.mGK.qX(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Au(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dzH();
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
                aVar.b(this.eUY).bqx();
                return;
            } else if (this.mGK != null) {
                this.mGK.qX(true);
                return;
            } else {
                if (!this.mGk) {
                    this.mGk = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mGJ != null) {
            this.mGJ.cFo();
        }
    }

    private void dzG() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dRX().gZ(this.mActivity);
        }
    }

    public void dzH() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.ams.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldx);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHa);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHb);
        this.ldm.stop();
        ldp.unregister(this.mActivity);
    }

    public void QC(String str) {
        this.lcY.setText(str);
    }

    public boolean dcs() {
        return this.abI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzI() {
        if (this.lcS != null) {
            if (this.mGv) {
                dzM();
            } else {
                dzL();
            }
        }
    }

    public void dcw() {
        dzL();
        dzJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzJ() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldx);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.ldx, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzK() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldx);
    }

    public void dzL() {
        if (this.lcS != null && !this.mGv && !this.mGY) {
            xk(true);
            dcv();
            this.lcS.setVisibility(0);
            this.mGn.setVisibility(0);
            this.mGm.setVisibility(8);
            this.mGv = true;
            if (this.mGA != null) {
                this.mGA.qY(false);
            }
        }
    }

    public void dct() {
        if (this.lcS != null && this.mGv) {
            xk(false);
            dcv();
            this.lcS.setVisibility(8);
            this.mGn.setVisibility(8);
            this.mGm.setVisibility(0);
            this.jny.setAnimationListener(this.ldv);
            this.lcS.startAnimation(this.jny);
            this.mGv = false;
            if (this.mGA != null) {
                this.mGA.cFq();
            }
        }
    }

    public void dzM() {
        if (this.lcS != null && this.mGv) {
            this.chW.cancel();
            this.jny.cancel();
            xk(false);
            dcv();
            this.lcS.setVisibility(8);
            this.mGn.setVisibility(8);
            this.mGm.setVisibility(0);
            this.mGv = false;
            if (this.mGA != null) {
                this.mGA.cFq();
            }
        }
    }

    private void dcv() {
        if (this.lcS != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldx);
            this.chW.setAnimationListener(null);
            this.jny.setAnimationListener(null);
            this.lcS.clearAnimation();
        }
    }

    private void dzN() {
        if (this.lcS != null) {
            this.chW.setAnimationListener(null);
            this.jny.setAnimationListener(null);
            this.lcS.clearAnimation();
        }
    }

    public void xk(boolean z) {
        dzO();
        if (z) {
            this.mGo.setVisibility(0);
        } else {
            this.mGo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzO() {
        if (this.currentState == 1) {
            this.mGo.setState(1);
        } else {
            this.mGo.setState(0);
        }
    }

    public void a(InterfaceC0848c interfaceC0848c) {
        this.mGz = interfaceC0848c;
    }

    public void Ec(int i2) {
        this.mStartPosition = i2;
    }

    public void ax(boolean z, boolean z2) {
        if (this.ldm != null) {
            if (this.lcR != null) {
                this.lcR.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.lcL != null && (this.lcL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcL.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.lcL.setLayoutParams(layoutParams);
            }
            this.ldm.dh(z);
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

    public void xl(boolean z) {
        this.mGX = z;
    }

    public void a(m mVar) {
        this.mGG = mVar;
    }

    public void a(a aVar) {
        this.mGH = aVar;
    }

    public void a(n nVar) {
        this.mGI = nVar;
    }

    public void a(l lVar) {
        this.mGJ = lVar;
    }

    public void a(f fVar) {
        this.mGK = fVar;
    }

    public void xm(boolean z) {
        this.mGR = z;
    }

    public void xn(boolean z) {
        this.mGw = z;
    }

    public void Hm(int i2) {
        this.mGV = i2;
    }

    public View dzP() {
        return this.bUP;
    }

    public void a(o oVar) {
        this.mGC = oVar;
    }

    public void a(p pVar) {
        this.mjv = pVar;
    }

    public void dzQ() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eUY.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gzX != null) {
            this.gzX.setStageType(str);
        }
    }

    public boolean isFullScreen() {
        return this.abT;
    }

    public void dzR() {
        if (this.gzX != null) {
            this.gzX.setVideoPath(this.mVideoUrl, this.amC);
            this.abI = true;
        }
    }
}
