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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int jAV;
    private static CallStateReceiver jAW;
    private String ajJ;
    private TbImageView ajz;
    private View bjX;
    private Animation but;
    private TbPageContext<?> dVN;
    private String eKO;
    private com.baidu.tieba.play.m eRv;
    protected TbCyberVideoView fsr;
    protected View gZs;
    private Animation hLZ;
    private CyberPlayerManager.OnPreparedListener jAB;
    private ImageView jAD;
    private TextView jAE;
    private View jAI;
    private View jAJ;
    private TextView jAK;
    private SeekBar jAL;
    private ImageView jAM;
    private ImageView jAN;
    private int jAO;
    private com.baidu.tieba.play.j jAS;
    private int jAU;
    public View jAo;
    private VideoListMediaControllerView jAq;
    private View jAr;
    private FrameLayout jAs;
    protected FrameLayout.LayoutParams jAt;
    private ImageView jAw;
    private View jAx;
    private View jAz;
    private p kFm;
    private i kFy;
    private ProgressBar laV;
    private View laW;
    private SwitchImageView laX;
    private TextView laY;
    private TextView laZ;
    private boolean lbA;
    private boolean lbB;
    private boolean lbC;
    private int lbD;
    private boolean lbE;
    private boolean lbF;
    private TextView lba;
    private int lbb;
    private CyberPlayerManager.OnCompletionListener lbc;
    private CyberPlayerManager.OnErrorListener lbd;
    private View.OnClickListener lbg;
    protected InterfaceC0731c lbh;
    private d lbi;
    private o lbk;
    private h lbl;
    private j lbm;
    private k lbn;
    private m lbo;
    private a lbp;
    private n lbq;
    private l lbr;
    private f lbs;
    private g lbt;
    private TextView lby;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int YN = 100;
    private boolean laU = false;
    protected boolean YX = false;
    private boolean YM = false;
    private boolean lbe = false;
    private boolean lbf = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int jAP = 0;
    private int jAQ = 0;
    private long lbj = 60000;
    private int jAT = 0;
    private boolean jAX = false;
    private boolean lbu = true;
    private boolean lbv = true;
    private boolean lbw = false;
    private boolean lbx = false;
    private String kEY = null;
    private int currentState = -1;
    private boolean lbz = false;
    private boolean lbG = false;
    private boolean lbH = false;
    private CyberPlayerManager.OnPreparedListener dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.jAq != null && c.this.fsr != null && c.this.fsr.getDuration() > 0) {
                c.this.jAq.bq(0, c.this.fsr.getDuration());
            }
            c.this.bRs();
            if (c.this.lbk != null) {
                c.this.lbk.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.qv();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a gWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.bRs();
        }
    };
    private Runnable YS = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.YS);
            if (c.this.ajz.getVisibility() != 8) {
                if (c.this.fsr.getCurrentPosition() > c.this.YN) {
                    c.this.qv();
                } else {
                    com.baidu.adp.lib.f.e.lt().postDelayed(c.this.YS, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.fsr != null) {
                int duration = c.this.fsr.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.YM = false;
                    c.this.lbC = false;
                    c.this.mStartPosition = 0;
                    c.this.cBQ();
                    c.this.jAr.setVisibility(0);
                    c.this.laV.setProgress(c.this.laV.getMax());
                    c.this.YN = 100;
                    if (c.this.lbc != null) {
                        c.this.lbc.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.uk(false);
                        c.this.ul(true);
                    } else {
                        c.this.cYG();
                        c.this.laY.setVisibility(0);
                    }
                    if (!c.this.YX && duration <= 150000) {
                        if (!c.this.lbz) {
                            if (c.this.lbm != null) {
                                c.this.lbm.tr(true);
                            }
                            c.this.B(c.this.mVideoUrl, c.this.ajJ, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.fsr.pause();
                            c.this.fsr.seekTo(0);
                        }
                    }
                    if (c.this.lbk != null) {
                        c.this.lbk.Dk(c.this.laV.getMax());
                        c.this.lbk.AM();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener jAZ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.gZs.setVisibility(0);
            c.this.eRv.cYX();
            c.this.currentState = 4;
            if (c.this.lbd != null) {
                c.this.lbd.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.lbA = true;
            }
            if (c.this.lbk != null) {
                c.this.lbk.cYL();
            }
            c.this.lbC = false;
            return true;
        }
    };
    protected Runnable jBa = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fsr == null || !c.this.fsr.isPlaying()) {
                c.this.gZs.setVisibility(0);
                c.this.eRv.cYX();
                if (c.this.lbk != null) {
                    c.this.lbk.cYL();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener dCC = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.lbw) {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.lbI, 200L);
            }
        }
    };
    private Runnable lbI = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fsr == null || !c.this.lbw) {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.YS, 200L);
                c.this.lbw = false;
            } else if (c.this.mStartPosition != c.this.fsr.getCurrentPosition()) {
                c.this.lbw = false;
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.YS, 20L);
            } else {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.lbI, 200L);
            }
        }
    };
    private TbCyberVideoView.a eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.YM = false;
            if (c.this.lbf) {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.lbJ, 300L);
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.YS);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.jBa);
        }
    };
    private Runnable lbJ = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lbC = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.kFm != null) {
                c.this.kFm.cSM();
            }
            if (view.getId() != c.this.gZs.getId()) {
                if (view.getId() != c.this.laX.getId()) {
                    if (view.getId() == c.this.laZ.getId()) {
                        if (c.this.lbl != null) {
                            c.this.lbl.cSN();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.laY.getId()) {
                        if (c.this.lbm != null) {
                            c.this.lbm.tr(false);
                        }
                        c.this.ff(c.this.mVideoUrl, c.this.ajJ);
                        return;
                    } else if (view.getId() == c.this.jAw.getId()) {
                        int i2 = c.this.lbf ? 1 : 2;
                        if (c.this.YX) {
                            TiebaStatic.log(new ap("c11714"));
                            TiebaStatic.log(new ap("c13262").dn("tid", c.this.ajJ).dn("fid", c.this.eKO).ah("obj_type", i2).ah("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ap("c11710"));
                            TiebaStatic.log(new ap("c13262").dn("tid", c.this.ajJ).dn("fid", c.this.eKO).ah("obj_type", i2).ah("obj_source", 1));
                        }
                        if (c.this.lbr != null) {
                            c.this.lbr.cej();
                        }
                        if (c.this.cYr()) {
                            if (c.this.YX) {
                                c.this.cYu();
                            } else {
                                c.this.cYt();
                            }
                            c.this.uh(c.this.YX);
                            return;
                        }
                        c.this.Io();
                        return;
                    } else if (view.getId() != c.this.jAD.getId()) {
                        if (c.this.lbg != null) {
                            c.this.lbg.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ap("c11713"));
                        if (c.this.lbr != null) {
                            c.this.lbr.cej();
                        }
                        if (c.this.cYr()) {
                            c.this.cYu();
                            c.this.uh(false);
                            return;
                        }
                        c.this.Io();
                        return;
                    }
                }
                TiebaStatic.log(new ap("c13255"));
                c.this.cSF();
                c.this.cYI();
                if (c.this.currentState != 1) {
                    c.this.cYE();
                    c.this.cYF();
                } else {
                    c.this.cCg();
                }
                if (c.this.lbp != null) {
                    c.this.lbp.oH(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.fsr.stopPlayback();
            c.this.YM = false;
            c.this.cYz();
        }
    };
    private Animation.AnimationListener jBc = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener jBd = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable jBe = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cCd();
        }
    };
    private CustomMessageListener jBf = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.azN();
            }
        }
    };
    private VideoControllerView.b jDa = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void pS(int i2) {
            int duration;
            if (c.this.fsr != null && (duration = c.this.fsr.getDuration()) > 0 && c.this.laV != null) {
                c.this.laV.setProgress((int) ((i2 * c.this.jAo.getWidth()) / duration));
                if (c.this.lbk != null) {
                    c.this.lbk.Dk((c.this.fsr.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fdS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new ap("c13256"));
            c.this.cYE();
            c.this.ul(false);
            if (c.this.lbp != null) {
                c.this.lbp.oH(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cBU() != null) {
                c.this.Ad(c.this.cBU().getSeekPosition());
                if (!c.this.cCc()) {
                    c.this.cYz();
                } else {
                    c.this.azO();
                    if (c.this.kFy != null) {
                        c.this.kFy.cel();
                    }
                }
            }
            c.this.ul(true);
            c.this.cYD();
            if (c.this.lbp != null) {
                c.this.lbp.oH(true);
            }
            if (c.this.lbq != null) {
                c.this.lbq.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void oH(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0731c {
        void qe();

        void qf();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cek();

        void oc(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void up(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void ob(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void cSN();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cel();
    }

    /* loaded from: classes.dex */
    public interface j {
        void tr(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cei();

        void cej();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean cSO();

        boolean cSP();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void AM();

        void Dk(int i);

        void cYL();

        void cYM();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cSM();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.lbE = true;
        if (tbPageContext != null) {
            this.dVN = tbPageContext;
            this.mRootView = view;
            this.lbE = z;
            this.jAz = view;
            this.mActivity = this.dVN.getPageActivity();
            init();
        }
    }

    public void init() {
        this.jAo = aq(this.mActivity);
        this.jAo.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.jAo);
        }
        this.fsr = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.jAo).addView(this.fsr.getView(), 0);
        this.fsr.getView().setLayoutParams(layoutParams);
        this.eRv = new com.baidu.tieba.play.m((ViewGroup) this.jAo.findViewById(R.id.auto_video_loading_container));
        this.eRv.setLoadingAnimationListener(this.gWE);
        this.jAq = (VideoListMediaControllerView) this.jAo.findViewById(R.id.media_controller);
        this.jAq.setPlayer(this.fsr);
        this.laV = (ProgressBar) this.jAo.findViewById(R.id.pgrBottomProgress);
        this.laV.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.laV.setProgress(0);
        this.jAq.setOnSeekBarChangeListener(this.fdS);
        this.jAq.setOnProgressUpdatedListener(this.jDa);
        this.jAr = this.jAo.findViewById(R.id.black_mask);
        this.gZs = this.jAo.findViewById(R.id.layout_error);
        this.gZs.setOnClickListener(this.mOnClickListener);
        this.lby = (TextView) this.jAo.findViewById(R.id.auto_video_error_tips);
        this.jAs = (FrameLayout) this.jAo.findViewById(R.id.danmu_container);
        this.jAw = (ImageView) this.jAo.findViewById(R.id.img_full_screen);
        this.jAw.setOnClickListener(this.mOnClickListener);
        this.jAx = this.jAo.findViewById(R.id.layout_media_controller);
        this.laW = this.jAo.findViewById(R.id.time_show_controller);
        this.fsr.setContinuePlayEnable(true);
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnCompletionListener(this.dCz);
        this.fsr.setOnErrorListener(this.jAZ);
        this.fsr.setOnSeekCompleteListener(this.dCC);
        this.fsr.setOnInfoListener(this.dCA);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        this.laX = (SwitchImageView) this.jAo.findViewById(R.id.img_play_controller);
        this.laX.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.laX.setState(0);
        this.laX.setOnClickListener(this.mOnClickListener);
        this.laY = (TextView) this.jAo.findViewById(R.id.txt_replay);
        this.laY.setOnClickListener(this.mOnClickListener);
        this.laZ = (TextView) this.jAo.findViewById(R.id.txt_playnext);
        this.laZ.setOnClickListener(this.mOnClickListener);
        this.lba = (TextView) this.jAo.findViewById(R.id.txt_next_video_title);
        this.ajz = (TbImageView) this.jAo.findViewById(R.id.video_thumbnail);
        this.ajz.setDefaultErrorResource(0);
        this.ajz.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jAD = (ImageView) this.jAo.findViewById(R.id.img_exit);
        this.jAD.setOnClickListener(this.mOnClickListener);
        this.jAE = (TextView) this.jAo.findViewById(R.id.video_title);
        this.bjX = this.jAo.findViewById(R.id.layout_title);
        this.bjX.setVisibility(8);
        this.hLZ = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.but = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jAO = this.mAudioManager.getStreamMaxVolume(3);
        this.jAU = this.mAudioManager.getStreamVolume(3);
        jAV = 100 / this.jAO;
        this.jAo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.lbn != null) {
                    c.this.lbn.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.YM) {
                        if (c.this.mStatus == 1 && c.this.jAQ != 0) {
                            c.this.b(c.this.jAQ == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jAQ = 0;
                            c.this.jAP = 0;
                        }
                        if (!c.this.fsr.isPlaying()) {
                            c.this.laZ.setVisibility(8);
                            c.this.laY.setVisibility(8);
                            c.this.lba.setVisibility(8);
                        }
                    }
                    c.this.cBQ();
                    if (c.this.lbn != null) {
                        c.this.lbn.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jAS = new com.baidu.tieba.play.j(this.mActivity);
        if (this.lbE) {
            this.jAS.start();
        }
        this.jAT = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jAW == null) {
            jAW = new CallStateReceiver();
        }
        jAW.register(this.mActivity);
        cYq();
        MessageManager.getInstance().registerListener(this.jBf);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jBf);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Dg(int i2) {
        if (this.ajz != null) {
            this.ajz.setDefaultBgResource(i2);
        }
    }

    public void cYq() {
        if (this.lbu) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.jAo.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.jAo.setSystemUiVisibility(0);
    }

    public void uf(boolean z) {
        this.lbu = z;
        cYq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBQ() {
        this.mStatus = 0;
        if (this.jAI != null && this.jAI.getParent() != null && (this.jAI.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jAI.getParent()).removeView(this.jAI);
                this.jAI = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jAJ != null && this.jAJ.getParent() != null && (this.jAJ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jAJ.getParent()).removeView(this.jAJ);
                this.jAJ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cBR() {
        if (this.mStatus == 1) {
            if (this.jAI == null && this.jAo != null && (this.jAo instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.jAo, true);
                this.jAI = this.jAo.findViewById(R.id.lay_jindu);
                this.jAK = (TextView) this.jAI.findViewById(R.id.show_time);
                this.jAN = (ImageView) this.jAI.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jAJ == null && this.jAo != null && (this.jAo instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.jAo, true);
            this.jAJ = this.jAo.findViewById(R.id.lay_voice);
            this.jAM = (ImageView) this.jAJ.findViewById(R.id.arrow_voice_icon);
            this.jAL = (SeekBar) this.jAJ.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        this.lbg = onClickListener;
    }

    public void ug(boolean z) {
        this.lbf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.lbn != null) {
                c.this.lbn.onStart();
            }
            if (c.this.YX && c.this.YM) {
                if (c.this.mStatus == 1) {
                    c.this.cYG();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ao(f2);
                    }
                } else {
                    if (c.this.YX) {
                        c.this.cBT();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.jAP = c.this.fsr.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ao(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.lbF) {
                if (c.this.lbo != null && c.this.lbo.cSO()) {
                    return true;
                }
                c.this.cSF();
                c.this.cYI();
                if (c.this.fsr.isPlaying()) {
                    c.this.cYD();
                } else {
                    c.this.cYE();
                }
                if (c.this.lbp != null) {
                    c.this.lbp.oH(c.this.fsr.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.lbF) {
                if (c.this.YM) {
                    if (c.this.lbo != null && c.this.lbo.cSP()) {
                        return true;
                    }
                    c.this.cYC();
                    if (c.this.fsr.isPlaying()) {
                        c.this.cYD();
                    } else {
                        c.this.cYE();
                    }
                    if (c.this.lbp != null) {
                        c.this.lbp.oH(c.this.fsr.isPlaying());
                    }
                } else {
                    c.this.cSF();
                    c.this.cYI();
                    if (c.this.currentState != 1) {
                        c.this.cYE();
                        c.this.cYF();
                    } else {
                        c.this.cCg();
                    }
                    if (c.this.lbp != null) {
                        c.this.lbp.oH(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBT() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jAo.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jAo.setSystemUiVisibility(4);
        } else {
            this.jAo.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(float f2) {
        if (!this.YM) {
            this.mStatus = 0;
            return;
        }
        cBR();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % jAV == 0) {
            if (f2 > 0.0f && this.jAU < this.jAO) {
                this.jAU++;
            }
            if (f2 < 0.0f && this.jAU > 0) {
                this.jAU--;
            }
        }
        if (this.mProgress > 0) {
            this.jAM.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jAM.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jAU, 0);
        this.jAL.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jAP -= 1000;
                this.jAQ = 1;
            } else {
                this.jAP += 1000;
                this.jAQ = 2;
            }
            if (this.jAP < 0) {
                this.jAP = 0;
            } else if (this.jAP > this.fsr.getDuration()) {
                this.jAP = this.fsr.getDuration();
            }
        }
        cBR();
        String Do = this.jAq.Do(this.jAP);
        if (f2 > 0.0f) {
            this.jAN.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jAN.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Do)) {
            this.jAK.setText(new StringBuilder().append(Do).append("/").append(this.jAq.Do(this.fsr.getDuration())));
        }
        this.jAq.setCurrentDuration(this.jAP, z ? false : true);
        cYG();
        cYv();
    }

    protected View aq(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Dh(int i2) {
        this.lbb = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ajJ = str2;
    }

    public void setFid(String str) {
        this.eKO = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRs() {
        int i2 = 100;
        if (this.fsr != null && this.jAq != null) {
            this.jAq.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.cZa().LL(this.mVideoUrl);
            if (this.lbC) {
                this.fsr.setVolume(1.0f, 1.0f);
                this.fsr.start();
                this.lbC = false;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.YS);
                com.baidu.adp.lib.f.e.lt().postDelayed(this.YS, 20L);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBa);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbJ);
                if (this.fsr.cZg()) {
                    this.currentState = 1;
                    cYG();
                }
                this.mStartPosition = com.baidu.tieba.play.n.cZa().LL(this.mVideoUrl);
                this.jAq.setPlayer(this.fsr);
                if (this.mStartPosition != 0) {
                    this.lbw = true;
                }
                if (!this.lbB) {
                    this.jAq.showProgress();
                }
                if (!this.lbf && this.fsr.getDuration() <= 0) {
                    cBU().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.fsr.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.YN = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv() {
        if (this.ajz.getVisibility() != 8 || !this.YM) {
            this.YM = true;
            this.jAr.setVisibility(8);
            this.gZs.setVisibility(8);
            this.eRv.cYW();
            this.ajz.setVisibility(8);
            cYH();
            this.jAq.showProgress();
            this.laV.setVisibility(0);
            if (this.jAB != null) {
                this.jAB.onPrepared();
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

    protected void uh(boolean z) {
        if (hasNavBar(this.mActivity) && (this.laW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.laW.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.laW.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.laW.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.laW.setLayoutParams(layoutParams);
        }
    }

    public void cSF() {
        if (this.fsr.isPlaying()) {
            azN();
            if (this.lbt != null) {
                this.lbt.onPause();
            }
            if (this.lbk != null) {
                this.lbk.onPaused();
            }
        } else if (this.YM) {
            azO();
            if (this.kFy != null) {
                this.kFy.cel();
            }
            if (this.lbk != null) {
                this.lbk.cYM();
            }
        } else {
            cYz();
        }
    }

    public void Io() {
        this.jAX = true;
        if (this.jAS != null) {
            this.jAS.Io();
        }
    }

    public boolean cYr() {
        return this.fsr != null && this.fsr.getView().getHeight() > this.fsr.getView().getWidth();
    }

    public void cYs() {
        uh(false);
        cYu();
    }

    public boolean Di(int i2) {
        switch (i2) {
            case 4:
                if (this.YX) {
                    if (cYr()) {
                        uh(false);
                        cYu();
                    } else {
                        Io();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.jAO <= 0 || this.jAL == null) {
                    return false;
                }
                this.jAU = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jAU * 100.0d) / this.jAO);
                this.jAL.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.fsr;
    }

    public VideoListMediaControllerView cBU() {
        return this.jAq;
    }

    public void show() {
        this.jAo.setVisibility(0);
    }

    public void cBY() {
        if (this.jAz != null) {
            ViewGroup.LayoutParams layoutParams = this.jAz.getLayoutParams();
            this.jAt = (FrameLayout.LayoutParams) this.jAo.getLayoutParams();
            this.jAt.width = layoutParams.width;
            this.jAt.height = layoutParams.height;
            this.jAt.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.jAo.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.jAo.setLayoutParams(this.jAt);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jAX) {
            if (this.YX) {
                TiebaStatic.log(new ap("c11712"));
            } else {
                TiebaStatic.log(new ap("c11711"));
            }
        } else {
            this.jAX = false;
        }
        if (configuration.orientation == 2) {
            cYt();
        } else {
            cYu();
        }
        cYv();
        if (this.mActivity == com.baidu.adp.base.a.jC().currentActivity()) {
            azO();
        }
        cYI();
        cCg();
        if (this.lbp != null) {
            this.lbp.oH(true);
        }
    }

    protected void cYt() {
        this.YX = true;
        if (cYr()) {
            this.jAo.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.jAo.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        i(this.mActivity, true);
        this.bjX.setVisibility(0);
        this.jAD.setVisibility(0);
        this.jAE.setVisibility(0);
        this.jAs.setVisibility(8);
        this.eRv.cYX();
        this.ajz.setVisibility(8);
        this.jAw.setImageResource(R.drawable.icon_video_narrow_white);
        Aa(this.jAT);
        cBT();
        if (this.lbh != null) {
            this.lbh.qe();
        }
    }

    protected void cYu() {
        this.YX = false;
        if (this.jAt != null) {
            this.jAo.setLayoutParams(this.jAt);
        }
        i(this.mActivity, false);
        this.bjX.setVisibility(8);
        this.jAs.setVisibility(0);
        this.eRv.cYX();
        this.ajz.setVisibility(8);
        this.jAw.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.jAq != null && (this.jAq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAq.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.jAq.setLayoutParams(layoutParams);
        }
        this.jAo.setSystemUiVisibility(0);
        cYq();
        if (this.lbh != null) {
            this.lbh.qf();
        }
    }

    public void cYv() {
        if (this.fsr != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.YX) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.laV.setMax(equipmentWidth);
            int duration = this.fsr.getDuration();
            if (duration > 0) {
                if (this.laY.getVisibility() == 0) {
                    this.laV.setProgress(this.laV.getMax());
                } else {
                    this.laV.setProgress((int) ((this.fsr.getCurrentPositionSync() * this.laV.getMax()) / duration));
                }
            }
        }
    }

    private void Aa(int i2) {
        if (this.jAq != null && (this.jAq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAq.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.jAq.setLayoutParams(layoutParams);
        }
    }

    private void i(Activity activity, boolean z) {
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

    public boolean cCa() {
        return !this.YX;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.jAB = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lbc = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lbd = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.lbx) {
            fg(str, str2);
        } else {
            ff(str, str2);
        }
        if (eVar != null) {
            eVar.up(z);
        }
    }

    public void fe(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, String str2, boolean z) {
        cYA();
        this.lbC = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.fsr.setVideoDuration(this.lbb);
        this.fsr.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBa);
        if (this.lbj > 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.jBa, this.lbj);
        }
        if (this.lbk != null) {
            this.lbk.onStarted();
        }
        this.eRv.startLoading();
        ui(z);
    }

    public void ff(String str, String str2) {
        B(str, str2, true);
    }

    public void fg(String str, String str2) {
        cYA();
        this.lbC = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBa);
        if (this.lbj > 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.jBa, this.lbj);
        }
        if (this.lbk != null) {
            this.lbk.onStarted();
        }
        this.eRv.startLoading();
        ui(true);
    }

    public void cYw() {
        azO();
        this.laV.setVisibility(0);
    }

    public void azO() {
        int i2 = 100;
        if (this.fsr != null && this.jAq != null) {
            this.YM = true;
            this.currentState = 1;
            this.fsr.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.cZa().LL(this.mVideoUrl);
            this.lbw = true;
            if (this.mStartPosition > 100 && this.fsr.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.YN = i2;
            this.eRv.cYX();
            ui(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lbA && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ajJ)) {
            this.lbA = false;
            this.lbB = true;
            ff(this.mVideoUrl, this.ajJ);
        }
    }

    private void ui(boolean z) {
        if (z) {
            this.ajz.setVisibility(0);
            cYG();
            this.laV.setProgress(0);
        } else {
            this.ajz.setVisibility(8);
            cYG();
        }
        this.jAq.showProgress();
        this.jAr.setVisibility(8);
        this.laZ.setVisibility(8);
        this.laY.setVisibility(8);
        this.lba.setVisibility(8);
        this.gZs.setVisibility(8);
    }

    private void cYx() {
        this.eRv.cYX();
        this.laZ.setVisibility(8);
        this.laY.setVisibility(8);
        this.lba.setVisibility(8);
        cYI();
    }

    public void azN() {
        this.fsr.pause();
        this.currentState = 2;
        cYx();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.YS);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBa);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbJ);
        this.fsr.stopPlayback();
        this.YM = false;
        this.lbC = false;
        this.mStartPosition = 0;
        coB();
    }

    public void cYy() {
        if (this.fsr.getDuration() >= this.fsr.getCurrentPosition()) {
            com.baidu.tieba.play.n.cZa().bt(this.mVideoUrl, this.fsr.getCurrentPositionSync());
        }
    }

    public void uj(boolean z) {
        this.lbv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(boolean z) {
        if (this.jAx != null) {
            this.jAr.setVisibility(0);
            this.laZ.setVisibility(8);
            this.laY.setVisibility(8);
            this.lba.setVisibility(8);
            this.eRv.cYX();
            cYG();
            this.laV.setVisibility(8);
            this.gZs.setVisibility(8);
            this.jAq.azZ();
            this.ajz.setVisibility(z ? 0 : 8);
        }
    }

    public void coB() {
        uk(true);
    }

    public boolean qg() {
        if (this.fsr == null) {
            return false;
        }
        return this.fsr.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fsr == null) {
            return 0;
        }
        return this.fsr.getCurrentPosition();
    }

    public void a(k kVar) {
        this.lbn = kVar;
    }

    public void a(j jVar) {
        this.lbm = jVar;
    }

    public void a(i iVar) {
        this.kFy = iVar;
    }

    public void a(g gVar) {
        this.lbt = gVar;
    }

    public void a(h hVar) {
        this.lbl = hVar;
    }

    public void Lk(String str) {
        this.kEY = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYz() {
        a(this.mVideoUrl, this.ajJ, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.lbi = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cYA();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dpA().dpB()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.lbx = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.lbs != null) {
                    this.lbs.ob(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.xl(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cYB();
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
                aVar.b(this.dVN).aYL();
                return;
            } else if (this.lbs != null) {
                this.lbs.ob(true);
                return;
            } else {
                if (!this.laU) {
                    this.laU = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.lbr != null) {
            this.lbr.cei();
        }
    }

    private void cYA() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dpA().fv(this.mActivity);
        }
    }

    public void cYB() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.ajz.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBe);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.YS);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBa);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbI);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbJ);
        this.jAS.stop();
        jAW.unregister(this.mActivity);
    }

    public void LK(String str) {
        this.jAE.setText(str);
    }

    public boolean cCc() {
        return this.YM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYC() {
        if (this.jAx != null) {
            if (this.lbe) {
                cYG();
            } else {
                cYF();
            }
        }
    }

    public void cCg() {
        cYF();
        cYD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYD() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBe);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.jBe, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYE() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBe);
    }

    public void cYF() {
        if (this.jAx != null && !this.lbe && !this.lbG) {
            ul(true);
            cCf();
            this.jAx.setVisibility(0);
            this.laW.setVisibility(0);
            this.laV.setVisibility(8);
            this.lbe = true;
            if (this.lbi != null) {
                this.lbi.oc(false);
            }
        }
    }

    public void cCd() {
        if (this.jAx != null && this.lbe) {
            ul(false);
            cCf();
            this.jAx.setVisibility(8);
            this.laW.setVisibility(8);
            this.laV.setVisibility(0);
            this.hLZ.setAnimationListener(this.jBc);
            this.jAx.startAnimation(this.hLZ);
            this.lbe = false;
            if (this.lbi != null) {
                this.lbi.cek();
            }
        }
    }

    public void cYG() {
        if (this.jAx != null && this.lbe) {
            this.but.cancel();
            this.hLZ.cancel();
            ul(false);
            cCf();
            this.jAx.setVisibility(8);
            this.laW.setVisibility(8);
            this.laV.setVisibility(0);
            this.lbe = false;
            if (this.lbi != null) {
                this.lbi.cek();
            }
        }
    }

    private void cCf() {
        if (this.jAx != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBe);
            this.but.setAnimationListener(null);
            this.hLZ.setAnimationListener(null);
            this.jAx.clearAnimation();
        }
    }

    private void cYH() {
        if (this.jAx != null) {
            this.but.setAnimationListener(null);
            this.hLZ.setAnimationListener(null);
            this.jAx.clearAnimation();
        }
    }

    public void ul(boolean z) {
        cYI();
        if (z) {
            this.laX.setVisibility(0);
        } else {
            this.laX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYI() {
        if (this.currentState == 1) {
            this.laX.setState(1);
        } else {
            this.laX.setState(0);
        }
    }

    public void a(InterfaceC0731c interfaceC0731c) {
        this.lbh = interfaceC0731c;
    }

    public void Ad(int i2) {
        this.mStartPosition = i2;
    }

    public void ap(boolean z, boolean z2) {
        if (this.jAS != null) {
            if (this.jAw != null) {
                this.jAw.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.jAq != null && (this.jAq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAq.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.jAq.setLayoutParams(layoutParams);
            }
            this.jAS.cj(z);
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

    public void um(boolean z) {
        this.lbF = z;
    }

    public void a(m mVar) {
        this.lbo = mVar;
    }

    public void a(a aVar) {
        this.lbp = aVar;
    }

    public void a(n nVar) {
        this.lbq = nVar;
    }

    public void a(l lVar) {
        this.lbr = lVar;
    }

    public void a(f fVar) {
        this.lbs = fVar;
    }

    public void un(boolean z) {
        this.lbz = z;
    }

    public void uo(boolean z) {
        this.lbf = z;
    }

    public void Dj(int i2) {
        this.lbD = i2;
    }

    public View cYJ() {
        return this.jAo;
    }

    public void a(p pVar) {
        this.kFm = pVar;
    }

    public void cYK() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dVN.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.dVN.getPageActivity());
    }
}
