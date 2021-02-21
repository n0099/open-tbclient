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
    private static int ldC;
    private static CallStateReceiver ldD;
    private String amC;
    private TbImageView ams;
    private View bMl;
    public View bUP;
    private Animation chW;
    private TbPageContext<?> eUY;
    private String fNd;
    private com.baidu.tieba.play.m fUa;
    protected TbCyberVideoView gAl;
    private ImageView hhN;
    protected View izS;
    private Animation jnM;
    private VideoListMediaControllerView lcZ;
    private com.baidu.tieba.play.j ldA;
    private View lda;
    private FrameLayout ldb;
    protected FrameLayout.LayoutParams ldc;
    private ImageView ldf;
    private View ldg;
    private View ldi;
    private CyberPlayerManager.OnPreparedListener ldk;
    private TextView ldm;
    private View ldq;
    private View ldr;
    private TextView lds;
    private SeekBar ldt;
    private ImageView ldu;
    private ImageView ldv;
    private int ldw;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private ProgressBar mGB;
    private View mGC;
    private SwitchImageView mGD;
    private TextView mGE;
    private TextView mGF;
    private TextView mGG;
    private int mGH;
    private CyberPlayerManager.OnCompletionListener mGI;
    private CyberPlayerManager.OnErrorListener mGJ;
    private View.OnClickListener mGN;
    protected InterfaceC0849c mGO;
    private d mGP;
    private o mGR;
    private h mGS;
    private j mGT;
    private k mGU;
    private m mGV;
    private a mGW;
    private n mGX;
    private l mGY;
    private f mGZ;
    private GestureDetector mGestureDetector;
    private g mHa;
    private TextView mHf;
    private boolean mHh;
    private boolean mHi;
    private boolean mHj;
    private int mHk;
    private boolean mHl;
    private boolean mHm;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int mVolume;
    private p mjK;
    private i mjW;
    private int abJ = 100;
    private boolean mGA = false;
    protected boolean abT = false;
    private boolean abI = false;
    private boolean mGK = false;
    private boolean mGL = false;
    private boolean mGM = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int ldx = 0;
    private int ldy = 0;
    private long mGQ = AppStatusRules.DEFAULT_GRANULARITY;
    private int ldB = 0;
    private boolean ldE = false;
    private boolean mHb = true;
    private boolean mHc = true;
    private boolean mHd = false;
    private boolean mHe = false;
    private String mjx = null;
    private int currentState = -1;
    private boolean mHg = false;
    private boolean mHn = false;
    private boolean mHo = false;
    private CyberPlayerManager.OnPreparedListener eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.lcZ != null && c.this.gAl != null && c.this.gAl.getDuration() > 0) {
                c.this.lcZ.bx(0, c.this.gAl.getDuration());
            }
            c.this.csh();
            if (c.this.mGR != null) {
                c.this.mGR.onPrepared();
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
    private VideoLoadingProgressView.a iwX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.csh();
        }
    };
    private Runnable abO = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            if (c.this.ams.getVisibility() != 8) {
                if (c.this.gAl.getCurrentPosition() > c.this.abJ) {
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
            if (c.this.gAl != null) {
                int duration = c.this.gAl.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.abI = false;
                    c.this.mHj = false;
                    c.this.mStartPosition = 0;
                    c.this.dcn();
                    c.this.lda.setVisibility(0);
                    c.this.mGB.setProgress(c.this.mGB.getMax());
                    c.this.abJ = 100;
                    if (c.this.mGI != null) {
                        c.this.mGI.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.xj(false);
                        c.this.xk(true);
                    } else {
                        c.this.dzT();
                        c.this.mGE.setVisibility(0);
                    }
                    if (!c.this.abT && duration <= 150000) {
                        if (!c.this.mHg) {
                            if (c.this.mGT != null) {
                                c.this.mGT.wk(true);
                            }
                            c.this.E(c.this.mVideoUrl, c.this.amC, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gAl.pause();
                            c.this.gAl.seekTo(0);
                        }
                    }
                    if (c.this.mGR != null) {
                        c.this.mGR.AY(c.this.mGB.getMax());
                        c.this.mGR.GM();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.izS.setVisibility(0);
            c.this.fUa.dAj();
            c.this.currentState = 4;
            if (c.this.mGJ != null) {
                c.this.mGJ.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mHh = true;
            }
            if (c.this.mGR != null) {
                c.this.mGR.cMO();
            }
            c.this.mHj = false;
            return true;
        }
    };
    protected Runnable ldH = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gAl == null || !c.this.gAl.isPlaying()) {
                c.this.izS.setVisibility(0);
                c.this.fUa.dAj();
                if (c.this.mGR != null) {
                    c.this.mGR.cMO();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mHd) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mHp, 200L);
            }
        }
    };
    private Runnable mHp = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gAl == null || !c.this.mHd) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.abO, 200L);
                c.this.mHd = false;
            } else if (c.this.mStartPosition != c.this.gAl.getCurrentPosition()) {
                c.this.mHd = false;
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.abO, 20L);
            } else {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mHp, 200L);
            }
        }
    };
    private TbCyberVideoView.a fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abI = false;
            if (c.this.mGL && !c.this.mGM) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mHq, 300L);
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.ldH);
        }
    };
    private Runnable mHq = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mHj = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.mjK != null) {
                c.this.mjK.cMQ();
            }
            if (view.getId() != c.this.izS.getId()) {
                if (view.getId() != c.this.mGD.getId()) {
                    if (view.getId() == c.this.mGF.getId()) {
                        if (c.this.mGS != null) {
                            c.this.mGS.dtP();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mGE.getId()) {
                        if (c.this.mGT != null) {
                            c.this.mGT.wk(false);
                        }
                        c.this.fX(c.this.mVideoUrl, c.this.amC);
                        return;
                    } else if (view.getId() == c.this.ldf.getId()) {
                        int i2 = c.this.mGL ? 1 : 2;
                        if (c.this.abT) {
                            TiebaStatic.log(new ar("c11714"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.amC).dR("fid", c.this.fNd).ap("obj_type", i2).ap("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ar("c11710"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.amC).dR("fid", c.this.fNd).ap("obj_type", i2).ap("obj_source", 1));
                        }
                        if (c.this.mGY != null) {
                            c.this.mGY.cFw();
                        }
                        if (c.this.dzE()) {
                            if (c.this.abT) {
                                c.this.dzH();
                            } else {
                                c.this.dzG();
                            }
                            c.this.xg(c.this.abT);
                            return;
                        }
                        c.this.TZ();
                        return;
                    } else if (view.getId() != c.this.hhN.getId()) {
                        if (c.this.mGN != null) {
                            c.this.mGN.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ar("c11713"));
                        if (c.this.mGY != null) {
                            c.this.mGY.cFw();
                        }
                        if (c.this.dzE()) {
                            c.this.dzH();
                            c.this.xg(false);
                            return;
                        }
                        c.this.TZ();
                        return;
                    }
                }
                TiebaStatic.log(new ar("c13255"));
                c.this.dtI();
                c.this.dzV();
                if (c.this.currentState != 1) {
                    c.this.dzR();
                    c.this.dzS();
                } else {
                    c.this.dcD();
                }
                if (c.this.mGW != null) {
                    c.this.mGW.rI(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gAl.stopPlayback();
            c.this.abI = false;
            c.this.dzM();
        }
    };
    private Animation.AnimationListener ldJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener ldK = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable ldL = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.dcA();
        }
    };
    private CustomMessageListener ldM = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b lfG = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void tb(int i2) {
            int duration;
            if (c.this.gAl != null && (duration = c.this.gAl.getDuration()) > 0 && c.this.mGB != null) {
                c.this.mGB.setProgress((int) ((i2 * c.this.bUP.getWidth()) / duration));
                if (c.this.mGR != null) {
                    c.this.mGR.AY((c.this.gAl.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener ghW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new ar("c13256"));
            c.this.dzR();
            c.this.xk(false);
            if (c.this.mGW != null) {
                c.this.mGW.rI(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.dcr() != null) {
                c.this.Ec(c.this.dcr().getSeekPosition());
                if (!c.this.dcz()) {
                    c.this.dzM();
                } else {
                    c.this.resumePlay();
                    if (c.this.mjW != null) {
                        c.this.mjW.cFy();
                    }
                }
            }
            c.this.xk(true);
            c.this.dzQ();
            if (c.this.mGW != null) {
                c.this.mGW.rI(true);
            }
            if (c.this.mGX != null) {
                c.this.mGX.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rI(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0849c {
        void rj();

        void rk();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cFx();

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
        void dtP();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cFy();
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
        void cFv();

        void cFw();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dtQ();

        boolean dtR();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void AY(int i);

        void GM();

        void cMO();

        void cMP();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cMQ();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mHl = true;
        if (tbPageContext != null) {
            this.eUY = tbPageContext;
            this.mRootView = view;
            this.mHl = z;
            this.ldi = view;
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
        this.gAl = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.bUP).addView(this.gAl.getView(), 0);
        this.gAl.getView().setLayoutParams(layoutParams);
        this.fUa = new com.baidu.tieba.play.m((ViewGroup) this.bUP.findViewById(R.id.auto_video_loading_container));
        this.fUa.setLoadingAnimationListener(this.iwX);
        this.lcZ = (VideoListMediaControllerView) this.bUP.findViewById(R.id.media_controller);
        this.lcZ.setPlayer(this.gAl);
        this.mGB = (ProgressBar) this.bUP.findViewById(R.id.pgrBottomProgress);
        this.mGB.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mGB.setProgress(0);
        this.lcZ.setOnSeekBarChangeListener(this.ghW);
        this.lcZ.setOnProgressUpdatedListener(this.lfG);
        this.lda = this.bUP.findViewById(R.id.black_mask);
        this.izS = this.bUP.findViewById(R.id.layout_error);
        this.izS.setOnClickListener(this.mOnClickListener);
        this.mHf = (TextView) this.bUP.findViewById(R.id.auto_video_error_tips);
        this.ldb = (FrameLayout) this.bUP.findViewById(R.id.danmu_container);
        this.ldf = (ImageView) this.bUP.findViewById(R.id.img_full_screen);
        this.ldf.setOnClickListener(this.mOnClickListener);
        this.ldg = this.bUP.findViewById(R.id.layout_media_controller);
        this.mGC = this.bUP.findViewById(R.id.time_show_controller);
        this.gAl.setContinuePlayEnable(true);
        this.gAl.setOnPreparedListener(this.eAA);
        this.gAl.setOnCompletionListener(this.eAC);
        this.gAl.setOnErrorListener(this.ldG);
        this.gAl.setOnSeekCompleteListener(this.eAF);
        this.gAl.setOnInfoListener(this.eAD);
        this.gAl.setOnSurfaceDestroyedListener(this.fUi);
        this.mGD = (SwitchImageView) this.bUP.findViewById(R.id.img_play_controller);
        this.mGD.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mGD.setState(0);
        this.mGD.setOnClickListener(this.mOnClickListener);
        this.mGE = (TextView) this.bUP.findViewById(R.id.txt_replay);
        this.mGE.setOnClickListener(this.mOnClickListener);
        this.mGF = (TextView) this.bUP.findViewById(R.id.txt_playnext);
        this.mGF.setOnClickListener(this.mOnClickListener);
        this.mGG = (TextView) this.bUP.findViewById(R.id.txt_next_video_title);
        this.ams = (TbImageView) this.bUP.findViewById(R.id.video_thumbnail);
        this.ams.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hhN = (ImageView) this.bUP.findViewById(R.id.img_exit);
        this.hhN.setOnClickListener(this.mOnClickListener);
        this.ldm = (TextView) this.bUP.findViewById(R.id.video_title);
        this.bMl = this.bUP.findViewById(R.id.layout_title);
        this.bMl.setVisibility(8);
        this.jnM = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.chW = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.ldw = this.mAudioManager.getStreamMaxVolume(3);
        this.mVolume = this.mAudioManager.getStreamVolume(3);
        ldC = 100 / this.ldw;
        this.bUP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mGU != null) {
                    c.this.mGU.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abI) {
                        if (c.this.mStatus == 1 && c.this.ldy != 0) {
                            c.this.c(c.this.ldy == 1 ? 1000.0f : -1000.0f, false);
                            c.this.ldy = 0;
                            c.this.ldx = 0;
                        }
                        if (!c.this.gAl.isPlaying()) {
                            c.this.mGF.setVisibility(8);
                            c.this.mGE.setVisibility(8);
                            c.this.mGG.setVisibility(8);
                        }
                    }
                    c.this.dcn();
                    if (c.this.mGU != null) {
                        c.this.mGU.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.ldA = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mHl) {
            this.ldA.start();
        }
        this.ldB = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (ldD == null) {
            ldD = new CallStateReceiver();
        }
        ldD.register(this.mActivity);
        dzD();
        MessageManager.getInstance().registerListener(this.ldM);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.ldM);
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

    public void dzD() {
        if (this.mHb) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.bUP.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.bUP.setSystemUiVisibility(0);
    }

    public void xd(boolean z) {
        this.mHb = z;
        dzD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcn() {
        this.mStatus = 0;
        if (this.ldq != null && this.ldq.getParent() != null && (this.ldq.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ldq.getParent()).removeView(this.ldq);
                this.ldq = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ldr != null && this.ldr.getParent() != null && (this.ldr.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ldr.getParent()).removeView(this.ldr);
                this.ldr = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void dco() {
        if (this.mStatus == 1) {
            if (this.ldq == null && this.bUP != null && (this.bUP instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.bUP, true);
                this.ldq = this.bUP.findViewById(R.id.lay_jindu);
                this.lds = (TextView) this.ldq.findViewById(R.id.show_time);
                this.ldv = (ImageView) this.ldq.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ldr == null && this.bUP != null && (this.bUP instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.bUP, true);
            this.ldr = this.bUP.findViewById(R.id.lay_voice);
            this.ldu = (ImageView) this.ldr.findViewById(R.id.arrow_voice_icon);
            this.ldt = (SeekBar) this.ldr.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ad(View.OnClickListener onClickListener) {
        this.mGN = onClickListener;
    }

    public void xe(boolean z) {
        this.mGL = z;
    }

    public void xf(boolean z) {
        this.mGM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mGU != null) {
                c.this.mGU.onStart();
            }
            if (c.this.abT && c.this.abI) {
                if (c.this.mStatus == 1) {
                    c.this.dzT();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aR(f2);
                    }
                } else {
                    if (c.this.abT) {
                        c.this.dcq();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ldx = c.this.gAl.getCurrentPosition();
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
            if (!c.this.mHm) {
                if (c.this.mGV != null && c.this.mGV.dtQ()) {
                    return true;
                }
                c.this.dtI();
                c.this.dzV();
                if (c.this.gAl.isPlaying()) {
                    c.this.dzQ();
                } else {
                    c.this.dzR();
                }
                if (c.this.mGW != null) {
                    c.this.mGW.rI(c.this.gAl.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mHm) {
                if (c.this.abI) {
                    if (c.this.mGV != null && c.this.mGV.dtR()) {
                        return true;
                    }
                    c.this.dzP();
                    if (c.this.gAl.isPlaying()) {
                        c.this.dzQ();
                    } else {
                        c.this.dzR();
                    }
                    if (c.this.mGW != null) {
                        c.this.mGW.rI(c.this.gAl.isPlaying());
                    }
                } else {
                    c.this.dtI();
                    c.this.dzV();
                    if (c.this.currentState != 1) {
                        c.this.dzR();
                        c.this.dzS();
                    } else {
                        c.this.dcD();
                    }
                    if (c.this.mGW != null) {
                        c.this.mGW.rI(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcq() {
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
        if (ldC == 0) {
            this.ldw = this.mAudioManager.getStreamMaxVolume(3);
            ldC = 100 / this.ldw;
            if (ldC == 0) {
                ldC = 1;
            }
        }
        dco();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ldC == 0) {
            if (f2 > 0.0f && this.mVolume < this.ldw) {
                this.mVolume++;
            }
            if (f2 < 0.0f && this.mVolume > 0) {
                this.mVolume--;
            }
        }
        if (this.mProgress > 0) {
            this.ldu.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.ldu.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.mVolume, 0);
        this.ldt.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.ldx -= 1000;
                this.ldy = 1;
            } else {
                this.ldx += 1000;
                this.ldy = 2;
            }
            if (this.ldx < 0) {
                this.ldx = 0;
            } else if (this.ldx > this.gAl.getDuration()) {
                this.ldx = this.gAl.getDuration();
            }
        }
        dco();
        String Hq = this.lcZ.Hq(this.ldx);
        if (f2 > 0.0f) {
            this.ldv.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.ldv.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Hq)) {
            this.lds.setText(new StringBuilder().append(Hq).append("/").append(this.lcZ.Hq(this.gAl.getDuration())));
        }
        this.lcZ.setCurrentDuration(this.ldx, z ? false : true);
        dzT();
        dzI();
    }

    protected View as(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Hk(int i2) {
        this.mGH = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amC = str2;
    }

    public void setFid(String str) {
        this.fNd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csh() {
        int i2 = 100;
        if (this.gAl != null && this.lcZ != null) {
            this.lcZ.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dAn().QE(this.mVideoUrl);
            if (this.mHj) {
                this.gAl.setVolume(1.0f, 1.0f);
                this.gAl.start();
                this.mHj = false;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
                com.baidu.adp.lib.f.e.mA().postDelayed(this.abO, 20L);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHq);
                if (this.gAl.dAu()) {
                    this.currentState = 1;
                    dzT();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dAn().QE(this.mVideoUrl);
                this.lcZ.setPlayer(this.gAl);
                if (this.mStartPosition != 0) {
                    this.mHd = true;
                }
                if (!this.mHi) {
                    this.lcZ.showProgress();
                }
                if (!this.mGL && this.gAl.getDuration() <= 0) {
                    dcr().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gAl.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abJ = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        if (this.ams.getVisibility() != 8 || !this.abI) {
            this.abI = true;
            this.lda.setVisibility(8);
            this.izS.setVisibility(8);
            this.fUa.dAi();
            this.ams.setVisibility(8);
            dzU();
            this.lcZ.showProgress();
            this.mGB.setVisibility(0);
            if (this.ldk != null) {
                this.ldk.onPrepared();
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
        if (hasNavBar(this.mActivity) && (this.mGC.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mGC.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mGC.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mGC.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mGC.setLayoutParams(layoutParams);
        }
    }

    public void dtI() {
        if (this.gAl.isPlaying()) {
            pausePlay();
            if (this.mHa != null) {
                this.mHa.onPause();
            }
            if (this.mGR != null) {
                this.mGR.onPaused();
            }
        } else if (this.abI) {
            resumePlay();
            if (this.mjW != null) {
                this.mjW.cFy();
            }
            if (this.mGR != null) {
                this.mGR.cMP();
            }
        } else {
            dzM();
        }
    }

    public void TZ() {
        this.ldE = true;
        if (this.ldA != null) {
            this.ldA.TZ();
        }
    }

    public boolean dzE() {
        return this.gAl != null && this.gAl.getView().getHeight() >= this.gAl.getView().getWidth();
    }

    public void dzF() {
        xg(false);
        dzH();
    }

    public boolean Hl(int i2) {
        switch (i2) {
            case 4:
                if (this.abT) {
                    if (dzE()) {
                        xg(false);
                        dzH();
                    } else {
                        TZ();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.ldw <= 0 || this.ldt == null) {
                    return false;
                }
                this.mVolume = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.mVolume * 100.0d) / this.ldw);
                this.ldt.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gAl;
    }

    public VideoListMediaControllerView dcr() {
        return this.lcZ;
    }

    public void show() {
        this.bUP.setVisibility(0);
    }

    public void dcv() {
        if (this.ldi != null) {
            ViewGroup.LayoutParams layoutParams = this.ldi.getLayoutParams();
            this.ldc = (FrameLayout.LayoutParams) this.bUP.getLayoutParams();
            this.ldc.width = layoutParams.width;
            this.ldc.height = layoutParams.height;
            this.ldc.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.bUP.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.bUP.setLayoutParams(this.ldc);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.ldE) {
            if (this.abT) {
                TiebaStatic.log(new ar("c11712"));
            } else {
                TiebaStatic.log(new ar("c11711"));
            }
        } else {
            this.ldE = false;
        }
        if (configuration.orientation == 2) {
            dzG();
        } else {
            dzH();
        }
        dzI();
        if (this.mActivity == com.baidu.adp.base.b.kB().currentActivity()) {
            resumePlay();
        }
        dzV();
        dcD();
        if (this.mGW != null) {
            this.mGW.rI(true);
        }
    }

    protected void dzG() {
        this.abT = true;
        this.bUP.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bFl().fx(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bFl().fy(this.mActivity))));
        j(this.mActivity, true);
        this.bMl.setVisibility(0);
        this.hhN.setVisibility(0);
        this.ldm.setVisibility(0);
        this.ldb.setVisibility(8);
        this.fUa.dAj();
        this.ams.setVisibility(8);
        this.ldf.setImageResource(R.drawable.icon_video_narrow_white);
        DZ(this.ldB);
        dcq();
        if (this.mGO != null) {
            this.mGO.rj();
        }
    }

    protected void dzH() {
        this.abT = false;
        if (this.ldc != null) {
            this.bUP.setLayoutParams(this.ldc);
        }
        j(this.mActivity, false);
        this.bMl.setVisibility(8);
        this.ldb.setVisibility(0);
        this.fUa.dAj();
        this.ams.setVisibility(8);
        this.ldf.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.lcZ != null && (this.lcZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcZ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.lcZ.setLayoutParams(layoutParams);
        }
        this.bUP.setSystemUiVisibility(0);
        dzD();
        if (this.mGO != null) {
            this.mGO.rk();
        }
    }

    public void dzI() {
        if (this.gAl != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.abT) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mGB.setMax(equipmentWidth);
            int duration = this.gAl.getDuration();
            if (duration > 0) {
                if (this.mGE.getVisibility() == 0) {
                    this.mGB.setProgress(this.mGB.getMax());
                } else {
                    this.mGB.setProgress((int) ((this.gAl.getCurrentPositionSync() * this.mGB.getMax()) / duration));
                }
            }
        }
    }

    private void DZ(int i2) {
        if (this.lcZ != null && (this.lcZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcZ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.lcZ.setLayoutParams(layoutParams);
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

    public boolean dcx() {
        return !this.abT;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.ldk = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mGI = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mGJ = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mHe) {
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
        dzN();
        this.mHj = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gAl.setVideoDuration(this.mGH);
        this.gAl.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
        if (this.mGQ > 0) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.ldH, this.mGQ);
        }
        if (this.mGR != null) {
            this.mGR.onStarted();
        }
        this.fUa.startLoading();
        xh(z);
    }

    public void fX(String str, String str2) {
        E(str, str2, true);
    }

    public void fY(String str, String str2) {
        dzN();
        this.mHj = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
        if (this.mGQ > 0) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.ldH, this.mGQ);
        }
        if (this.mGR != null) {
            this.mGR.onStarted();
        }
        this.fUa.startLoading();
        xh(true);
    }

    public void dzJ() {
        resumePlay();
        this.mGB.setVisibility(0);
    }

    public void resumePlay() {
        int i2 = 100;
        if (this.gAl != null && this.lcZ != null) {
            this.abI = true;
            this.currentState = 1;
            this.gAl.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dAn().QE(this.mVideoUrl);
            this.mHd = true;
            if (this.mStartPosition > 100 && this.gAl.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abJ = i2;
            this.fUa.dAj();
            xh(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mHh && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amC)) {
            this.mHh = false;
            this.mHi = true;
            fX(this.mVideoUrl, this.amC);
        }
    }

    private void xh(boolean z) {
        if (z) {
            this.ams.setVisibility(0);
            dzT();
            this.mGB.setProgress(0);
        } else {
            this.ams.setVisibility(8);
            dzT();
        }
        this.lcZ.showProgress();
        this.lda.setVisibility(8);
        this.mGF.setVisibility(8);
        this.mGE.setVisibility(8);
        this.mGG.setVisibility(8);
        this.izS.setVisibility(8);
    }

    private void dzK() {
        this.fUa.dAj();
        this.mGF.setVisibility(8);
        this.mGE.setVisibility(8);
        this.mGG.setVisibility(8);
        dzV();
    }

    public void pausePlay() {
        this.gAl.pause();
        this.currentState = 2;
        dzK();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHq);
        this.gAl.stopPlayback();
        this.abI = false;
        this.mHj = false;
        this.mStartPosition = 0;
        cSK();
    }

    public void dzL() {
        if (this.gAl.getDuration() >= this.gAl.getCurrentPosition()) {
            com.baidu.tieba.play.n.dAn().bL(this.mVideoUrl, this.gAl.getCurrentPositionSync());
        }
    }

    public void xi(boolean z) {
        this.mHc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        if (this.ldg != null) {
            this.lda.setVisibility(0);
            this.mGF.setVisibility(8);
            this.mGE.setVisibility(8);
            this.mGG.setVisibility(8);
            this.fUa.dAj();
            dzT();
            this.mGB.setVisibility(8);
            this.izS.setVisibility(8);
            this.lcZ.aRo();
            this.ams.setVisibility(z ? 0 : 8);
        }
    }

    public void cSK() {
        xj(true);
    }

    public boolean rl() {
        if (this.gAl == null) {
            return false;
        }
        return this.gAl.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gAl == null) {
            return 0;
        }
        return this.gAl.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mGU = kVar;
    }

    public void a(j jVar) {
        this.mGT = jVar;
    }

    public void a(i iVar) {
        this.mjW = iVar;
    }

    public void a(g gVar) {
        this.mHa = gVar;
    }

    public void a(h hVar) {
        this.mGS = hVar;
    }

    public void Qe(String str) {
        this.mjx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzM() {
        a(this.mVideoUrl, this.amC, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mGP = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dzN();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.f.dSf().dSg() && !TbSingleton.getInstance().hasAgreeToPlay()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mHe = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mGZ != null) {
                    this.mGZ.qX(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Au(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dzO();
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
            } else if (this.mGZ != null) {
                this.mGZ.qX(true);
                return;
            } else {
                if (!this.mGA) {
                    this.mGA = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mGY != null) {
            this.mGY.cFv();
        }
    }

    private void dzN() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dSf().gZ(this.mActivity);
        }
    }

    public void dzO() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.ams.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldL);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHp);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHq);
        this.ldA.stop();
        ldD.unregister(this.mActivity);
    }

    public void QD(String str) {
        this.ldm.setText(str);
    }

    public boolean dcz() {
        return this.abI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzP() {
        if (this.ldg != null) {
            if (this.mGK) {
                dzT();
            } else {
                dzS();
            }
        }
    }

    public void dcD() {
        dzS();
        dzQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzQ() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldL);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.ldL, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzR() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldL);
    }

    public void dzS() {
        if (this.ldg != null && !this.mGK && !this.mHn) {
            xk(true);
            dcC();
            this.ldg.setVisibility(0);
            this.mGC.setVisibility(0);
            this.mGB.setVisibility(8);
            this.mGK = true;
            if (this.mGP != null) {
                this.mGP.qY(false);
            }
        }
    }

    public void dcA() {
        if (this.ldg != null && this.mGK) {
            xk(false);
            dcC();
            this.ldg.setVisibility(8);
            this.mGC.setVisibility(8);
            this.mGB.setVisibility(0);
            this.jnM.setAnimationListener(this.ldJ);
            this.ldg.startAnimation(this.jnM);
            this.mGK = false;
            if (this.mGP != null) {
                this.mGP.cFx();
            }
        }
    }

    public void dzT() {
        if (this.ldg != null && this.mGK) {
            this.chW.cancel();
            this.jnM.cancel();
            xk(false);
            dcC();
            this.ldg.setVisibility(8);
            this.mGC.setVisibility(8);
            this.mGB.setVisibility(0);
            this.mGK = false;
            if (this.mGP != null) {
                this.mGP.cFx();
            }
        }
    }

    private void dcC() {
        if (this.ldg != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldL);
            this.chW.setAnimationListener(null);
            this.jnM.setAnimationListener(null);
            this.ldg.clearAnimation();
        }
    }

    private void dzU() {
        if (this.ldg != null) {
            this.chW.setAnimationListener(null);
            this.jnM.setAnimationListener(null);
            this.ldg.clearAnimation();
        }
    }

    public void xk(boolean z) {
        dzV();
        if (z) {
            this.mGD.setVisibility(0);
        } else {
            this.mGD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzV() {
        if (this.currentState == 1) {
            this.mGD.setState(1);
        } else {
            this.mGD.setState(0);
        }
    }

    public void a(InterfaceC0849c interfaceC0849c) {
        this.mGO = interfaceC0849c;
    }

    public void Ec(int i2) {
        this.mStartPosition = i2;
    }

    public void ax(boolean z, boolean z2) {
        if (this.ldA != null) {
            if (this.ldf != null) {
                this.ldf.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.lcZ != null && (this.lcZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcZ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.lcZ.setLayoutParams(layoutParams);
            }
            this.ldA.dh(z);
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
        this.mHm = z;
    }

    public void a(m mVar) {
        this.mGV = mVar;
    }

    public void a(a aVar) {
        this.mGW = aVar;
    }

    public void a(n nVar) {
        this.mGX = nVar;
    }

    public void a(l lVar) {
        this.mGY = lVar;
    }

    public void a(f fVar) {
        this.mGZ = fVar;
    }

    public void xm(boolean z) {
        this.mHg = z;
    }

    public void xn(boolean z) {
        this.mGL = z;
    }

    public void Hm(int i2) {
        this.mHk = i2;
    }

    public View dzW() {
        return this.bUP;
    }

    public void a(o oVar) {
        this.mGR = oVar;
    }

    public void a(p pVar) {
        this.mjK = pVar;
    }

    public void dzX() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eUY.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gAl != null) {
            this.gAl.setStageType(str);
        }
    }

    public boolean isFullScreen() {
        return this.abT;
    }

    public void dzY() {
        if (this.gAl != null) {
            this.gAl.setVideoPath(this.mVideoUrl, this.amC);
            this.abI = true;
        }
    }
}
