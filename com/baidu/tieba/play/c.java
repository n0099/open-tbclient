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
    private static int jAT;
    private static CallStateReceiver jAU;
    private String ajJ;
    private TbImageView ajz;
    private View bjX;
    private Animation but;
    private TbPageContext<?> dVN;
    private String eKO;
    private com.baidu.tieba.play.m eRv;
    protected TbCyberVideoView fsr;
    protected View gZs;
    private Animation hLX;
    private ImageView jAB;
    private TextView jAC;
    private View jAG;
    private View jAH;
    private TextView jAI;
    private SeekBar jAJ;
    private ImageView jAK;
    private ImageView jAL;
    private int jAM;
    private com.baidu.tieba.play.j jAQ;
    private int jAS;
    public View jAm;
    private VideoListMediaControllerView jAo;
    private View jAp;
    private FrameLayout jAq;
    protected FrameLayout.LayoutParams jAr;
    private ImageView jAu;
    private View jAv;
    private View jAx;
    private CyberPlayerManager.OnPreparedListener jAz;
    private p kFk;
    private i kFw;
    private ProgressBar laT;
    private View laU;
    private SwitchImageView laV;
    private TextView laW;
    private TextView laX;
    private TextView laY;
    private int laZ;
    private boolean lbA;
    private int lbB;
    private boolean lbC;
    private boolean lbD;
    private CyberPlayerManager.OnCompletionListener lba;
    private CyberPlayerManager.OnErrorListener lbb;
    private View.OnClickListener lbe;
    protected InterfaceC0731c lbf;
    private d lbg;
    private o lbi;
    private h lbj;
    private j lbk;
    private k lbl;
    private m lbm;
    private a lbn;
    private n lbo;
    private l lbp;
    private f lbq;
    private g lbr;
    private TextView lbw;
    private boolean lby;
    private boolean lbz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int YN = 100;
    private boolean laS = false;
    protected boolean YX = false;
    private boolean YM = false;
    private boolean lbc = false;
    private boolean lbd = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int jAN = 0;
    private int jAO = 0;
    private long lbh = 60000;
    private int jAR = 0;
    private boolean jAV = false;
    private boolean lbs = true;
    private boolean lbt = true;
    private boolean lbu = false;
    private boolean lbv = false;
    private String kEW = null;
    private int currentState = -1;
    private boolean lbx = false;
    private boolean lbE = false;
    private boolean lbF = false;
    private CyberPlayerManager.OnPreparedListener dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.jAo != null && c.this.fsr != null && c.this.fsr.getDuration() > 0) {
                c.this.jAo.bq(0, c.this.fsr.getDuration());
            }
            c.this.bRs();
            if (c.this.lbi != null) {
                c.this.lbi.onPrepared();
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
                    c.this.lbA = false;
                    c.this.mStartPosition = 0;
                    c.this.cBQ();
                    c.this.jAp.setVisibility(0);
                    c.this.laT.setProgress(c.this.laT.getMax());
                    c.this.YN = 100;
                    if (c.this.lba != null) {
                        c.this.lba.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.uk(false);
                        c.this.ul(true);
                    } else {
                        c.this.cYG();
                        c.this.laW.setVisibility(0);
                    }
                    if (!c.this.YX && duration <= 150000) {
                        if (!c.this.lbx) {
                            if (c.this.lbk != null) {
                                c.this.lbk.tr(true);
                            }
                            c.this.B(c.this.mVideoUrl, c.this.ajJ, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.fsr.pause();
                            c.this.fsr.seekTo(0);
                        }
                    }
                    if (c.this.lbi != null) {
                        c.this.lbi.Dk(c.this.laT.getMax());
                        c.this.lbi.AM();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener jAX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.gZs.setVisibility(0);
            c.this.eRv.cYX();
            c.this.currentState = 4;
            if (c.this.lbb != null) {
                c.this.lbb.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.lby = true;
            }
            if (c.this.lbi != null) {
                c.this.lbi.cYL();
            }
            c.this.lbA = false;
            return true;
        }
    };
    protected Runnable jAY = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fsr == null || !c.this.fsr.isPlaying()) {
                c.this.gZs.setVisibility(0);
                c.this.eRv.cYX();
                if (c.this.lbi != null) {
                    c.this.lbi.cYL();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener dCC = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.lbu) {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.lbG, 200L);
            }
        }
    };
    private Runnable lbG = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fsr == null || !c.this.lbu) {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.YS, 200L);
                c.this.lbu = false;
            } else if (c.this.mStartPosition != c.this.fsr.getCurrentPosition()) {
                c.this.lbu = false;
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.YS, 20L);
            } else {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.lbG, 200L);
            }
        }
    };
    private TbCyberVideoView.a eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.YM = false;
            if (c.this.lbd) {
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.lbH, 300L);
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.YS);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(c.this.jAY);
        }
    };
    private Runnable lbH = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lbA = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.kFk != null) {
                c.this.kFk.cSM();
            }
            if (view.getId() != c.this.gZs.getId()) {
                if (view.getId() != c.this.laV.getId()) {
                    if (view.getId() == c.this.laX.getId()) {
                        if (c.this.lbj != null) {
                            c.this.lbj.cSN();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.laW.getId()) {
                        if (c.this.lbk != null) {
                            c.this.lbk.tr(false);
                        }
                        c.this.ff(c.this.mVideoUrl, c.this.ajJ);
                        return;
                    } else if (view.getId() == c.this.jAu.getId()) {
                        int i2 = c.this.lbd ? 1 : 2;
                        if (c.this.YX) {
                            TiebaStatic.log(new ap("c11714"));
                            TiebaStatic.log(new ap("c13262").dn("tid", c.this.ajJ).dn("fid", c.this.eKO).ah("obj_type", i2).ah("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ap("c11710"));
                            TiebaStatic.log(new ap("c13262").dn("tid", c.this.ajJ).dn("fid", c.this.eKO).ah("obj_type", i2).ah("obj_source", 1));
                        }
                        if (c.this.lbp != null) {
                            c.this.lbp.cej();
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
                    } else if (view.getId() != c.this.jAB.getId()) {
                        if (c.this.lbe != null) {
                            c.this.lbe.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ap("c11713"));
                        if (c.this.lbp != null) {
                            c.this.lbp.cej();
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
                if (c.this.lbn != null) {
                    c.this.lbn.oH(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.fsr.stopPlayback();
            c.this.YM = false;
            c.this.cYz();
        }
    };
    private Animation.AnimationListener jBa = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener jBb = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable jBc = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cCd();
        }
    };
    private CustomMessageListener jBd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.azN();
            }
        }
    };
    private VideoControllerView.b jCY = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void pS(int i2) {
            int duration;
            if (c.this.fsr != null && (duration = c.this.fsr.getDuration()) > 0 && c.this.laT != null) {
                c.this.laT.setProgress((int) ((i2 * c.this.jAm.getWidth()) / duration));
                if (c.this.lbi != null) {
                    c.this.lbi.Dk((c.this.fsr.getCurrentPosition() * 100) / duration);
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
            if (c.this.lbn != null) {
                c.this.lbn.oH(false);
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
                    if (c.this.kFw != null) {
                        c.this.kFw.cel();
                    }
                }
            }
            c.this.ul(true);
            c.this.cYD();
            if (c.this.lbn != null) {
                c.this.lbn.oH(true);
            }
            if (c.this.lbo != null) {
                c.this.lbo.onStopTrackingTouch(seekBar);
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
        this.lbC = true;
        if (tbPageContext != null) {
            this.dVN = tbPageContext;
            this.mRootView = view;
            this.lbC = z;
            this.jAx = view;
            this.mActivity = this.dVN.getPageActivity();
            init();
        }
    }

    public void init() {
        this.jAm = aq(this.mActivity);
        this.jAm.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.jAm);
        }
        this.fsr = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.jAm).addView(this.fsr.getView(), 0);
        this.fsr.getView().setLayoutParams(layoutParams);
        this.eRv = new com.baidu.tieba.play.m((ViewGroup) this.jAm.findViewById(R.id.auto_video_loading_container));
        this.eRv.setLoadingAnimationListener(this.gWE);
        this.jAo = (VideoListMediaControllerView) this.jAm.findViewById(R.id.media_controller);
        this.jAo.setPlayer(this.fsr);
        this.laT = (ProgressBar) this.jAm.findViewById(R.id.pgrBottomProgress);
        this.laT.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.laT.setProgress(0);
        this.jAo.setOnSeekBarChangeListener(this.fdS);
        this.jAo.setOnProgressUpdatedListener(this.jCY);
        this.jAp = this.jAm.findViewById(R.id.black_mask);
        this.gZs = this.jAm.findViewById(R.id.layout_error);
        this.gZs.setOnClickListener(this.mOnClickListener);
        this.lbw = (TextView) this.jAm.findViewById(R.id.auto_video_error_tips);
        this.jAq = (FrameLayout) this.jAm.findViewById(R.id.danmu_container);
        this.jAu = (ImageView) this.jAm.findViewById(R.id.img_full_screen);
        this.jAu.setOnClickListener(this.mOnClickListener);
        this.jAv = this.jAm.findViewById(R.id.layout_media_controller);
        this.laU = this.jAm.findViewById(R.id.time_show_controller);
        this.fsr.setContinuePlayEnable(true);
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnCompletionListener(this.dCz);
        this.fsr.setOnErrorListener(this.jAX);
        this.fsr.setOnSeekCompleteListener(this.dCC);
        this.fsr.setOnInfoListener(this.dCA);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        this.laV = (SwitchImageView) this.jAm.findViewById(R.id.img_play_controller);
        this.laV.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.laV.setState(0);
        this.laV.setOnClickListener(this.mOnClickListener);
        this.laW = (TextView) this.jAm.findViewById(R.id.txt_replay);
        this.laW.setOnClickListener(this.mOnClickListener);
        this.laX = (TextView) this.jAm.findViewById(R.id.txt_playnext);
        this.laX.setOnClickListener(this.mOnClickListener);
        this.laY = (TextView) this.jAm.findViewById(R.id.txt_next_video_title);
        this.ajz = (TbImageView) this.jAm.findViewById(R.id.video_thumbnail);
        this.ajz.setDefaultErrorResource(0);
        this.ajz.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jAB = (ImageView) this.jAm.findViewById(R.id.img_exit);
        this.jAB.setOnClickListener(this.mOnClickListener);
        this.jAC = (TextView) this.jAm.findViewById(R.id.video_title);
        this.bjX = this.jAm.findViewById(R.id.layout_title);
        this.bjX.setVisibility(8);
        this.hLX = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.but = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jAM = this.mAudioManager.getStreamMaxVolume(3);
        this.jAS = this.mAudioManager.getStreamVolume(3);
        jAT = 100 / this.jAM;
        this.jAm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.lbl != null) {
                    c.this.lbl.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.YM) {
                        if (c.this.mStatus == 1 && c.this.jAO != 0) {
                            c.this.b(c.this.jAO == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jAO = 0;
                            c.this.jAN = 0;
                        }
                        if (!c.this.fsr.isPlaying()) {
                            c.this.laX.setVisibility(8);
                            c.this.laW.setVisibility(8);
                            c.this.laY.setVisibility(8);
                        }
                    }
                    c.this.cBQ();
                    if (c.this.lbl != null) {
                        c.this.lbl.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jAQ = new com.baidu.tieba.play.j(this.mActivity);
        if (this.lbC) {
            this.jAQ.start();
        }
        this.jAR = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jAU == null) {
            jAU = new CallStateReceiver();
        }
        jAU.register(this.mActivity);
        cYq();
        MessageManager.getInstance().registerListener(this.jBd);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jBd);
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
        if (this.lbs) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.jAm.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.jAm.setSystemUiVisibility(0);
    }

    public void uf(boolean z) {
        this.lbs = z;
        cYq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBQ() {
        this.mStatus = 0;
        if (this.jAG != null && this.jAG.getParent() != null && (this.jAG.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jAG.getParent()).removeView(this.jAG);
                this.jAG = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jAH != null && this.jAH.getParent() != null && (this.jAH.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jAH.getParent()).removeView(this.jAH);
                this.jAH = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cBR() {
        if (this.mStatus == 1) {
            if (this.jAG == null && this.jAm != null && (this.jAm instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.jAm, true);
                this.jAG = this.jAm.findViewById(R.id.lay_jindu);
                this.jAI = (TextView) this.jAG.findViewById(R.id.show_time);
                this.jAL = (ImageView) this.jAG.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jAH == null && this.jAm != null && (this.jAm instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.jAm, true);
            this.jAH = this.jAm.findViewById(R.id.lay_voice);
            this.jAK = (ImageView) this.jAH.findViewById(R.id.arrow_voice_icon);
            this.jAJ = (SeekBar) this.jAH.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void aa(View.OnClickListener onClickListener) {
        this.lbe = onClickListener;
    }

    public void ug(boolean z) {
        this.lbd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.lbl != null) {
                c.this.lbl.onStart();
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
                        c.this.jAN = c.this.fsr.getCurrentPosition();
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
            if (!c.this.lbD) {
                if (c.this.lbm != null && c.this.lbm.cSO()) {
                    return true;
                }
                c.this.cSF();
                c.this.cYI();
                if (c.this.fsr.isPlaying()) {
                    c.this.cYD();
                } else {
                    c.this.cYE();
                }
                if (c.this.lbn != null) {
                    c.this.lbn.oH(c.this.fsr.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.lbD) {
                if (c.this.YM) {
                    if (c.this.lbm != null && c.this.lbm.cSP()) {
                        return true;
                    }
                    c.this.cYC();
                    if (c.this.fsr.isPlaying()) {
                        c.this.cYD();
                    } else {
                        c.this.cYE();
                    }
                    if (c.this.lbn != null) {
                        c.this.lbn.oH(c.this.fsr.isPlaying());
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
                    if (c.this.lbn != null) {
                        c.this.lbn.oH(c.this.currentState == 1);
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
            this.jAm.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jAm.setSystemUiVisibility(4);
        } else {
            this.jAm.setSystemUiVisibility(5894);
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
        if (this.mProgress % jAT == 0) {
            if (f2 > 0.0f && this.jAS < this.jAM) {
                this.jAS++;
            }
            if (f2 < 0.0f && this.jAS > 0) {
                this.jAS--;
            }
        }
        if (this.mProgress > 0) {
            this.jAK.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jAK.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jAS, 0);
        this.jAJ.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jAN -= 1000;
                this.jAO = 1;
            } else {
                this.jAN += 1000;
                this.jAO = 2;
            }
            if (this.jAN < 0) {
                this.jAN = 0;
            } else if (this.jAN > this.fsr.getDuration()) {
                this.jAN = this.fsr.getDuration();
            }
        }
        cBR();
        String Do = this.jAo.Do(this.jAN);
        if (f2 > 0.0f) {
            this.jAL.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jAL.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Do)) {
            this.jAI.setText(new StringBuilder().append(Do).append("/").append(this.jAo.Do(this.fsr.getDuration())));
        }
        this.jAo.setCurrentDuration(this.jAN, z ? false : true);
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
        this.laZ = i2;
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
        if (this.fsr != null && this.jAo != null) {
            this.jAo.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.cZa().LL(this.mVideoUrl);
            if (this.lbA) {
                this.fsr.setVolume(1.0f, 1.0f);
                this.fsr.start();
                this.lbA = false;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.YS);
                com.baidu.adp.lib.f.e.lt().postDelayed(this.YS, 20L);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jAY);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbH);
                if (this.fsr.cZg()) {
                    this.currentState = 1;
                    cYG();
                }
                this.mStartPosition = com.baidu.tieba.play.n.cZa().LL(this.mVideoUrl);
                this.jAo.setPlayer(this.fsr);
                if (this.mStartPosition != 0) {
                    this.lbu = true;
                }
                if (!this.lbz) {
                    this.jAo.showProgress();
                }
                if (!this.lbd && this.fsr.getDuration() <= 0) {
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
            this.jAp.setVisibility(8);
            this.gZs.setVisibility(8);
            this.eRv.cYW();
            this.ajz.setVisibility(8);
            cYH();
            this.jAo.showProgress();
            this.laT.setVisibility(0);
            if (this.jAz != null) {
                this.jAz.onPrepared();
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
        if (hasNavBar(this.mActivity) && (this.laU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.laU.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.laU.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.laU.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.laU.setLayoutParams(layoutParams);
        }
    }

    public void cSF() {
        if (this.fsr.isPlaying()) {
            azN();
            if (this.lbr != null) {
                this.lbr.onPause();
            }
            if (this.lbi != null) {
                this.lbi.onPaused();
            }
        } else if (this.YM) {
            azO();
            if (this.kFw != null) {
                this.kFw.cel();
            }
            if (this.lbi != null) {
                this.lbi.cYM();
            }
        } else {
            cYz();
        }
    }

    public void Io() {
        this.jAV = true;
        if (this.jAQ != null) {
            this.jAQ.Io();
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
                if (this.mAudioManager == null || this.jAM <= 0 || this.jAJ == null) {
                    return false;
                }
                this.jAS = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jAS * 100.0d) / this.jAM);
                this.jAJ.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.fsr;
    }

    public VideoListMediaControllerView cBU() {
        return this.jAo;
    }

    public void show() {
        this.jAm.setVisibility(0);
    }

    public void cBY() {
        if (this.jAx != null) {
            ViewGroup.LayoutParams layoutParams = this.jAx.getLayoutParams();
            this.jAr = (FrameLayout.LayoutParams) this.jAm.getLayoutParams();
            this.jAr.width = layoutParams.width;
            this.jAr.height = layoutParams.height;
            this.jAr.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.jAm.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.jAm.setLayoutParams(this.jAr);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jAV) {
            if (this.YX) {
                TiebaStatic.log(new ap("c11712"));
            } else {
                TiebaStatic.log(new ap("c11711"));
            }
        } else {
            this.jAV = false;
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
        if (this.lbn != null) {
            this.lbn.oH(true);
        }
    }

    protected void cYt() {
        this.YX = true;
        if (cYr()) {
            this.jAm.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.jAm.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        i(this.mActivity, true);
        this.bjX.setVisibility(0);
        this.jAB.setVisibility(0);
        this.jAC.setVisibility(0);
        this.jAq.setVisibility(8);
        this.eRv.cYX();
        this.ajz.setVisibility(8);
        this.jAu.setImageResource(R.drawable.icon_video_narrow_white);
        Aa(this.jAR);
        cBT();
        if (this.lbf != null) {
            this.lbf.qe();
        }
    }

    protected void cYu() {
        this.YX = false;
        if (this.jAr != null) {
            this.jAm.setLayoutParams(this.jAr);
        }
        i(this.mActivity, false);
        this.bjX.setVisibility(8);
        this.jAq.setVisibility(0);
        this.eRv.cYX();
        this.ajz.setVisibility(8);
        this.jAu.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.jAo != null && (this.jAo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAo.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.jAo.setLayoutParams(layoutParams);
        }
        this.jAm.setSystemUiVisibility(0);
        cYq();
        if (this.lbf != null) {
            this.lbf.qf();
        }
    }

    public void cYv() {
        if (this.fsr != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.YX) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.laT.setMax(equipmentWidth);
            int duration = this.fsr.getDuration();
            if (duration > 0) {
                if (this.laW.getVisibility() == 0) {
                    this.laT.setProgress(this.laT.getMax());
                } else {
                    this.laT.setProgress((int) ((this.fsr.getCurrentPositionSync() * this.laT.getMax()) / duration));
                }
            }
        }
    }

    private void Aa(int i2) {
        if (this.jAo != null && (this.jAo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAo.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.jAo.setLayoutParams(layoutParams);
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
        this.jAz = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lba = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lbb = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.lbv) {
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
        this.lbA = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.fsr.setVideoDuration(this.laZ);
        this.fsr.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jAY);
        if (this.lbh > 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.jAY, this.lbh);
        }
        if (this.lbi != null) {
            this.lbi.onStarted();
        }
        this.eRv.startLoading();
        ui(z);
    }

    public void ff(String str, String str2) {
        B(str, str2, true);
    }

    public void fg(String str, String str2) {
        cYA();
        this.lbA = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jAY);
        if (this.lbh > 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.jAY, this.lbh);
        }
        if (this.lbi != null) {
            this.lbi.onStarted();
        }
        this.eRv.startLoading();
        ui(true);
    }

    public void cYw() {
        azO();
        this.laT.setVisibility(0);
    }

    public void azO() {
        int i2 = 100;
        if (this.fsr != null && this.jAo != null) {
            this.YM = true;
            this.currentState = 1;
            this.fsr.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.cZa().LL(this.mVideoUrl);
            this.lbu = true;
            if (this.mStartPosition > 100 && this.fsr.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.YN = i2;
            this.eRv.cYX();
            ui(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lby && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ajJ)) {
            this.lby = false;
            this.lbz = true;
            ff(this.mVideoUrl, this.ajJ);
        }
    }

    private void ui(boolean z) {
        if (z) {
            this.ajz.setVisibility(0);
            cYG();
            this.laT.setProgress(0);
        } else {
            this.ajz.setVisibility(8);
            cYG();
        }
        this.jAo.showProgress();
        this.jAp.setVisibility(8);
        this.laX.setVisibility(8);
        this.laW.setVisibility(8);
        this.laY.setVisibility(8);
        this.gZs.setVisibility(8);
    }

    private void cYx() {
        this.eRv.cYX();
        this.laX.setVisibility(8);
        this.laW.setVisibility(8);
        this.laY.setVisibility(8);
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jAY);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbH);
        this.fsr.stopPlayback();
        this.YM = false;
        this.lbA = false;
        this.mStartPosition = 0;
        coB();
    }

    public void cYy() {
        if (this.fsr.getDuration() >= this.fsr.getCurrentPosition()) {
            com.baidu.tieba.play.n.cZa().bt(this.mVideoUrl, this.fsr.getCurrentPositionSync());
        }
    }

    public void uj(boolean z) {
        this.lbt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(boolean z) {
        if (this.jAv != null) {
            this.jAp.setVisibility(0);
            this.laX.setVisibility(8);
            this.laW.setVisibility(8);
            this.laY.setVisibility(8);
            this.eRv.cYX();
            cYG();
            this.laT.setVisibility(8);
            this.gZs.setVisibility(8);
            this.jAo.azZ();
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
        this.lbl = kVar;
    }

    public void a(j jVar) {
        this.lbk = jVar;
    }

    public void a(i iVar) {
        this.kFw = iVar;
    }

    public void a(g gVar) {
        this.lbr = gVar;
    }

    public void a(h hVar) {
        this.lbj = hVar;
    }

    public void Lk(String str) {
        this.kEW = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYz() {
        a(this.mVideoUrl, this.ajJ, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.lbg = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cYA();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dpz().dpA()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.lbv = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.lbq != null) {
                    this.lbq.ob(false);
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
            } else if (this.lbq != null) {
                this.lbq.ob(true);
                return;
            } else {
                if (!this.laS) {
                    this.laS = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.lbp != null) {
            this.lbp.cei();
        }
    }

    private void cYA() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dpz().fv(this.mActivity);
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBc);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.YS);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jAY);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbG);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lbH);
        this.jAQ.stop();
        jAU.unregister(this.mActivity);
    }

    public void LK(String str) {
        this.jAC.setText(str);
    }

    public boolean cCc() {
        return this.YM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYC() {
        if (this.jAv != null) {
            if (this.lbc) {
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBc);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.jBc, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYE() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBc);
    }

    public void cYF() {
        if (this.jAv != null && !this.lbc && !this.lbE) {
            ul(true);
            cCf();
            this.jAv.setVisibility(0);
            this.laU.setVisibility(0);
            this.laT.setVisibility(8);
            this.lbc = true;
            if (this.lbg != null) {
                this.lbg.oc(false);
            }
        }
    }

    public void cCd() {
        if (this.jAv != null && this.lbc) {
            ul(false);
            cCf();
            this.jAv.setVisibility(8);
            this.laU.setVisibility(8);
            this.laT.setVisibility(0);
            this.hLX.setAnimationListener(this.jBa);
            this.jAv.startAnimation(this.hLX);
            this.lbc = false;
            if (this.lbg != null) {
                this.lbg.cek();
            }
        }
    }

    public void cYG() {
        if (this.jAv != null && this.lbc) {
            this.but.cancel();
            this.hLX.cancel();
            ul(false);
            cCf();
            this.jAv.setVisibility(8);
            this.laU.setVisibility(8);
            this.laT.setVisibility(0);
            this.lbc = false;
            if (this.lbg != null) {
                this.lbg.cek();
            }
        }
    }

    private void cCf() {
        if (this.jAv != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jBc);
            this.but.setAnimationListener(null);
            this.hLX.setAnimationListener(null);
            this.jAv.clearAnimation();
        }
    }

    private void cYH() {
        if (this.jAv != null) {
            this.but.setAnimationListener(null);
            this.hLX.setAnimationListener(null);
            this.jAv.clearAnimation();
        }
    }

    public void ul(boolean z) {
        cYI();
        if (z) {
            this.laV.setVisibility(0);
        } else {
            this.laV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYI() {
        if (this.currentState == 1) {
            this.laV.setState(1);
        } else {
            this.laV.setState(0);
        }
    }

    public void a(InterfaceC0731c interfaceC0731c) {
        this.lbf = interfaceC0731c;
    }

    public void Ad(int i2) {
        this.mStartPosition = i2;
    }

    public void ap(boolean z, boolean z2) {
        if (this.jAQ != null) {
            if (this.jAu != null) {
                this.jAu.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.jAo != null && (this.jAo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAo.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.jAo.setLayoutParams(layoutParams);
            }
            this.jAQ.cj(z);
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
        this.lbD = z;
    }

    public void a(m mVar) {
        this.lbm = mVar;
    }

    public void a(a aVar) {
        this.lbn = aVar;
    }

    public void a(n nVar) {
        this.lbo = nVar;
    }

    public void a(l lVar) {
        this.lbp = lVar;
    }

    public void a(f fVar) {
        this.lbq = fVar;
    }

    public void un(boolean z) {
        this.lbx = z;
    }

    public void uo(boolean z) {
        this.lbd = z;
    }

    public void Dj(int i2) {
        this.lbB = i2;
    }

    public View cYJ() {
        return this.jAm;
    }

    public void a(p pVar) {
        this.kFk = pVar;
    }

    public void cYK() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dVN.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.dVN.getPageActivity());
    }
}
