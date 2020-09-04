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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
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
    private static int jQv;
    private static CallStateReceiver jQw;
    private TbImageView akQ;
    private String ala;
    private Animation bAh;
    private View bpF;
    private String eVx;
    private TbPageContext<?> efr;
    protected TbCyberVideoView fDP;
    private com.baidu.tieba.play.m fcf;
    protected View hmp;
    private Animation iak;
    public View jPO;
    private VideoListMediaControllerView jPQ;
    private View jPR;
    private FrameLayout jPS;
    protected FrameLayout.LayoutParams jPT;
    private ImageView jPW;
    private View jPX;
    private View jPZ;
    private CyberPlayerManager.OnPreparedListener jQb;
    private ImageView jQd;
    private TextView jQe;
    private View jQi;
    private View jQj;
    private TextView jQk;
    private SeekBar jQl;
    private ImageView jQm;
    private ImageView jQn;
    private int jQo;
    private com.baidu.tieba.play.j jQs;
    private int jQu;
    private p kVa;
    private i kVm;
    private TextView lrA;
    private TextView lrB;
    private int lrC;
    private CyberPlayerManager.OnCompletionListener lrD;
    private CyberPlayerManager.OnErrorListener lrE;
    private View.OnClickListener lrH;
    protected InterfaceC0782c lrI;
    private d lrJ;
    private o lrL;
    private h lrM;
    private j lrN;
    private k lrO;
    private m lrP;
    private a lrQ;
    private n lrR;
    private l lrS;
    private f lrT;
    private g lrU;
    private TextView lrZ;
    private ProgressBar lrw;
    private View lrx;
    private SwitchImageView lry;
    private TextView lrz;
    private boolean lsb;
    private boolean lsc;
    private boolean lsd;
    private int lse;
    private boolean lsf;
    private boolean lsg;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int Zv = 100;
    private boolean lrv = false;
    protected boolean ZF = false;
    private boolean Zu = false;
    private boolean lrF = false;
    private boolean lrG = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int jQp = 0;
    private int jQq = 0;
    private long lrK = 60000;
    private int jQt = 0;
    private boolean jQx = false;
    private boolean lrV = true;
    private boolean lrW = true;
    private boolean lrX = false;
    private boolean lrY = false;
    private String kUM = null;
    private int currentState = -1;
    private boolean lsa = false;
    private boolean lsh = false;
    private boolean lsi = false;
    private CyberPlayerManager.OnPreparedListener dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.jPQ != null && c.this.fDP != null && c.this.fDP.getDuration() > 0) {
                c.this.jPQ.bz(0, c.this.fDP.getDuration());
            }
            c.this.cbF();
            if (c.this.lrL != null) {
                c.this.lrL.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener dLO = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rU();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a hjB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.cbF();
        }
    };
    private Runnable ZA = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(c.this.ZA);
            if (c.this.akQ.getVisibility() != 8) {
                if (c.this.fDP.getCurrentPosition() > c.this.Zv) {
                    c.this.rU();
                } else {
                    com.baidu.adp.lib.f.e.mS().postDelayed(c.this.ZA, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.fDP != null) {
                int duration = c.this.fDP.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.Zu = false;
                    c.this.lsd = false;
                    c.this.mStartPosition = 0;
                    c.this.cMJ();
                    c.this.jPR.setVisibility(0);
                    c.this.lrw.setProgress(c.this.lrw.getMax());
                    c.this.Zv = 100;
                    if (c.this.lrD != null) {
                        c.this.lrD.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.uY(false);
                        c.this.uZ(true);
                    } else {
                        c.this.djM();
                        c.this.lrz.setVisibility(0);
                    }
                    if (!c.this.ZF && duration <= 150000) {
                        if (!c.this.lsa) {
                            if (c.this.lrN != null) {
                                c.this.lrN.uc(true);
                            }
                            c.this.A(c.this.mVideoUrl, c.this.ala, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.fDP.pause();
                            c.this.fDP.seekTo(0);
                        }
                    }
                    if (c.this.lrL != null) {
                        c.this.lrL.FF(c.this.lrw.getMax());
                        c.this.lrL.Gp();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener jQz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.hmp.setVisibility(0);
            c.this.fcf.dkd();
            c.this.currentState = 4;
            if (c.this.lrE != null) {
                c.this.lrE.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.lsb = true;
            }
            if (c.this.lrL != null) {
                c.this.lrL.djR();
            }
            c.this.lsd = false;
            return true;
        }
    };
    protected Runnable jQA = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fDP == null || !c.this.fDP.isPlaying()) {
                c.this.hmp.setVisibility(0);
                c.this.fcf.dkd();
                if (c.this.lrL != null) {
                    c.this.lrL.djR();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener dLQ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.lrX) {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.lsj, 200L);
            }
        }
    };
    private Runnable lsj = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fDP == null || !c.this.lrX) {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.ZA, 200L);
                c.this.lrX = false;
            } else if (c.this.mStartPosition != c.this.fDP.getCurrentPosition()) {
                c.this.lrX = false;
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.ZA, 20L);
            } else {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.lsj, 200L);
            }
        }
    };
    private TbCyberVideoView.a fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.Zu = false;
            if (c.this.lrG) {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.lsk, 300L);
            }
            com.baidu.adp.lib.f.e.mS().removeCallbacks(c.this.ZA);
            com.baidu.adp.lib.f.e.mS().removeCallbacks(c.this.jQA);
        }
    };
    private Runnable lsk = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lsd = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.kVa != null) {
                c.this.kVa.ddF();
            }
            if (view.getId() != c.this.hmp.getId()) {
                if (view.getId() != c.this.lry.getId()) {
                    if (view.getId() == c.this.lrA.getId()) {
                        if (c.this.lrM != null) {
                            c.this.lrM.ddG();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.lrz.getId()) {
                        if (c.this.lrN != null) {
                            c.this.lrN.uc(false);
                        }
                        c.this.fx(c.this.mVideoUrl, c.this.ala);
                        return;
                    } else if (view.getId() == c.this.jPW.getId()) {
                        int i2 = c.this.lrG ? 1 : 2;
                        if (c.this.ZF) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dD("tid", c.this.ala).dD("fid", c.this.eVx).ai("obj_type", i2).ai("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dD("tid", c.this.ala).dD("fid", c.this.eVx).ai("obj_type", i2).ai("obj_source", 1));
                        }
                        if (c.this.lrS != null) {
                            c.this.lrS.coO();
                        }
                        if (c.this.djx()) {
                            if (c.this.ZF) {
                                c.this.djA();
                            } else {
                                c.this.djz();
                            }
                            c.this.uV(c.this.ZF);
                            return;
                        }
                        c.this.Oh();
                        return;
                    } else if (view.getId() != c.this.jQd.getId()) {
                        if (c.this.lrH != null) {
                            c.this.lrH.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.lrS != null) {
                            c.this.lrS.coO();
                        }
                        if (c.this.djx()) {
                            c.this.djA();
                            c.this.uV(false);
                            return;
                        }
                        c.this.Oh();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.ddy();
                c.this.djO();
                if (c.this.currentState != 1) {
                    c.this.djK();
                    c.this.djL();
                } else {
                    c.this.cMZ();
                }
                if (c.this.lrQ != null) {
                    c.this.lrQ.pn(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.fDP.stopPlayback();
            c.this.Zu = false;
            c.this.djF();
        }
    };
    private Animation.AnimationListener jQC = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener jQD = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable jQE = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cMW();
        }
    };
    private CustomMessageListener jQF = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aHX();
            }
        }
    };
    private VideoControllerView.b jSz = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void se(int i2) {
            int duration;
            if (c.this.fDP != null && (duration = c.this.fDP.getDuration()) > 0 && c.this.lrw != null) {
                c.this.lrw.setProgress((int) ((i2 * c.this.jPO.getWidth()) / duration));
                if (c.this.lrL != null) {
                    c.this.lrL.FF((c.this.fDP.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fpo = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.djK();
            c.this.uZ(false);
            if (c.this.lrQ != null) {
                c.this.lrQ.pn(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cMN() != null) {
                c.this.Cw(c.this.cMN().getSeekPosition());
                if (!c.this.cMV()) {
                    c.this.djF();
                } else {
                    c.this.aHY();
                    if (c.this.kVm != null) {
                        c.this.kVm.coQ();
                    }
                }
            }
            c.this.uZ(true);
            c.this.djJ();
            if (c.this.lrQ != null) {
                c.this.lrQ.pn(true);
            }
            if (c.this.lrR != null) {
                c.this.lrR.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void pn(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0782c {
        void rD();

        void rE();
    }

    /* loaded from: classes.dex */
    public interface d {
        void coP();

        void oI(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void vd(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void oH(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void ddG();
    }

    /* loaded from: classes.dex */
    public interface i {
        void coQ();
    }

    /* loaded from: classes.dex */
    public interface j {
        void uc(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void coN();

        void coO();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean ddH();

        boolean ddI();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void FF(int i);

        void Gp();

        void djR();

        void djS();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void ddF();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.lsf = true;
        if (tbPageContext != null) {
            this.efr = tbPageContext;
            this.mRootView = view;
            this.lsf = z;
            this.jPZ = view;
            this.mActivity = this.efr.getPageActivity();
            init();
        }
    }

    public void init() {
        this.jPO = ar(this.mActivity);
        this.jPO.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.jPO);
        }
        this.fDP = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.jPO).addView(this.fDP.getView(), 0);
        this.fDP.getView().setLayoutParams(layoutParams);
        this.fcf = new com.baidu.tieba.play.m((ViewGroup) this.jPO.findViewById(R.id.auto_video_loading_container));
        this.fcf.setLoadingAnimationListener(this.hjB);
        this.jPQ = (VideoListMediaControllerView) this.jPO.findViewById(R.id.media_controller);
        this.jPQ.setPlayer(this.fDP);
        this.lrw = (ProgressBar) this.jPO.findViewById(R.id.pgrBottomProgress);
        this.lrw.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.lrw.setProgress(0);
        this.jPQ.setOnSeekBarChangeListener(this.fpo);
        this.jPQ.setOnProgressUpdatedListener(this.jSz);
        this.jPR = this.jPO.findViewById(R.id.black_mask);
        this.hmp = this.jPO.findViewById(R.id.layout_error);
        this.hmp.setOnClickListener(this.mOnClickListener);
        this.lrZ = (TextView) this.jPO.findViewById(R.id.auto_video_error_tips);
        this.jPS = (FrameLayout) this.jPO.findViewById(R.id.danmu_container);
        this.jPW = (ImageView) this.jPO.findViewById(R.id.img_full_screen);
        this.jPW.setOnClickListener(this.mOnClickListener);
        this.jPX = this.jPO.findViewById(R.id.layout_media_controller);
        this.lrx = this.jPO.findViewById(R.id.time_show_controller);
        this.fDP.setContinuePlayEnable(true);
        this.fDP.setOnPreparedListener(this.dLL);
        this.fDP.setOnCompletionListener(this.dLN);
        this.fDP.setOnErrorListener(this.jQz);
        this.fDP.setOnSeekCompleteListener(this.dLQ);
        this.fDP.setOnInfoListener(this.dLO);
        this.fDP.setOnSurfaceDestroyedListener(this.fcn);
        this.lry = (SwitchImageView) this.jPO.findViewById(R.id.img_play_controller);
        this.lry.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.lry.setState(0);
        this.lry.setOnClickListener(this.mOnClickListener);
        this.lrz = (TextView) this.jPO.findViewById(R.id.txt_replay);
        this.lrz.setOnClickListener(this.mOnClickListener);
        this.lrA = (TextView) this.jPO.findViewById(R.id.txt_playnext);
        this.lrA.setOnClickListener(this.mOnClickListener);
        this.lrB = (TextView) this.jPO.findViewById(R.id.txt_next_video_title);
        this.akQ = (TbImageView) this.jPO.findViewById(R.id.video_thumbnail);
        this.akQ.setDefaultErrorResource(0);
        this.akQ.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jQd = (ImageView) this.jPO.findViewById(R.id.img_exit);
        this.jQd.setOnClickListener(this.mOnClickListener);
        this.jQe = (TextView) this.jPO.findViewById(R.id.video_title);
        this.bpF = this.jPO.findViewById(R.id.layout_title);
        this.bpF.setVisibility(8);
        this.iak = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bAh = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jQo = this.mAudioManager.getStreamMaxVolume(3);
        this.jQu = this.mAudioManager.getStreamVolume(3);
        jQv = 100 / this.jQo;
        this.jPO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.lrO != null) {
                    c.this.lrO.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Zu) {
                        if (c.this.mStatus == 1 && c.this.jQq != 0) {
                            c.this.b(c.this.jQq == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jQq = 0;
                            c.this.jQp = 0;
                        }
                        if (!c.this.fDP.isPlaying()) {
                            c.this.lrA.setVisibility(8);
                            c.this.lrz.setVisibility(8);
                            c.this.lrB.setVisibility(8);
                        }
                    }
                    c.this.cMJ();
                    if (c.this.lrO != null) {
                        c.this.lrO.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jQs = new com.baidu.tieba.play.j(this.mActivity);
        if (this.lsf) {
            this.jQs.start();
        }
        this.jQt = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jQw == null) {
            jQw = new CallStateReceiver();
        }
        jQw.register(this.mActivity);
        djw();
        MessageManager.getInstance().registerListener(this.jQF);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jQF);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void FB(int i2) {
        if (this.akQ != null) {
            this.akQ.setDefaultBgResource(i2);
        }
    }

    public void djw() {
        if (this.lrV) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.jPO.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.jPO.setSystemUiVisibility(0);
    }

    public void uT(boolean z) {
        this.lrV = z;
        djw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMJ() {
        this.mStatus = 0;
        if (this.jQi != null && this.jQi.getParent() != null && (this.jQi.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jQi.getParent()).removeView(this.jQi);
                this.jQi = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jQj != null && this.jQj.getParent() != null && (this.jQj.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jQj.getParent()).removeView(this.jQj);
                this.jQj = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cMK() {
        if (this.mStatus == 1) {
            if (this.jQi == null && this.jPO != null && (this.jPO instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.jPO, true);
                this.jQi = this.jPO.findViewById(R.id.lay_jindu);
                this.jQk = (TextView) this.jQi.findViewById(R.id.show_time);
                this.jQn = (ImageView) this.jQi.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jQj == null && this.jPO != null && (this.jPO instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.jPO, true);
            this.jQj = this.jPO.findViewById(R.id.lay_voice);
            this.jQm = (ImageView) this.jQj.findViewById(R.id.arrow_voice_icon);
            this.jQl = (SeekBar) this.jQj.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.lrH = onClickListener;
    }

    public void uU(boolean z) {
        this.lrG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.lrO != null) {
                c.this.lrO.onStart();
            }
            if (c.this.ZF && c.this.Zu) {
                if (c.this.mStatus == 1) {
                    c.this.djM();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.au(f2);
                    }
                } else {
                    if (c.this.ZF) {
                        c.this.cMM();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.jQp = c.this.fDP.getCurrentPosition();
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
            if (!c.this.lsg) {
                if (c.this.lrP != null && c.this.lrP.ddH()) {
                    return true;
                }
                c.this.ddy();
                c.this.djO();
                if (c.this.fDP.isPlaying()) {
                    c.this.djJ();
                } else {
                    c.this.djK();
                }
                if (c.this.lrQ != null) {
                    c.this.lrQ.pn(c.this.fDP.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.lsg) {
                if (c.this.Zu) {
                    if (c.this.lrP != null && c.this.lrP.ddI()) {
                        return true;
                    }
                    c.this.djI();
                    if (c.this.fDP.isPlaying()) {
                        c.this.djJ();
                    } else {
                        c.this.djK();
                    }
                    if (c.this.lrQ != null) {
                        c.this.lrQ.pn(c.this.fDP.isPlaying());
                    }
                } else {
                    c.this.ddy();
                    c.this.djO();
                    if (c.this.currentState != 1) {
                        c.this.djK();
                        c.this.djL();
                    } else {
                        c.this.cMZ();
                    }
                    if (c.this.lrQ != null) {
                        c.this.lrQ.pn(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMM() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jPO.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jPO.setSystemUiVisibility(4);
        } else {
            this.jPO.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.Zu) {
            this.mStatus = 0;
            return;
        }
        if (jQv == 0) {
            this.jQo = this.mAudioManager.getStreamMaxVolume(3);
            jQv = 100 / this.jQo;
            if (jQv == 0) {
                jQv = 1;
            }
        }
        cMK();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % jQv == 0) {
            if (f2 > 0.0f && this.jQu < this.jQo) {
                this.jQu++;
            }
            if (f2 < 0.0f && this.jQu > 0) {
                this.jQu--;
            }
        }
        if (this.mProgress > 0) {
            this.jQm.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jQm.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jQu, 0);
        this.jQl.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jQp -= 1000;
                this.jQq = 1;
            } else {
                this.jQp += 1000;
                this.jQq = 2;
            }
            if (this.jQp < 0) {
                this.jQp = 0;
            } else if (this.jQp > this.fDP.getDuration()) {
                this.jQp = this.fDP.getDuration();
            }
        }
        cMK();
        String FJ = this.jPQ.FJ(this.jQp);
        if (f2 > 0.0f) {
            this.jQn.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jQn.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(FJ)) {
            this.jQk.setText(new StringBuilder().append(FJ).append("/").append(this.jPQ.FJ(this.fDP.getDuration())));
        }
        this.jPQ.setCurrentDuration(this.jQp, z ? false : true);
        djM();
        djB();
    }

    protected View ar(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void FC(int i2) {
        this.lrC = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.ala = str2;
    }

    public void setFid(String str) {
        this.eVx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        int i2 = 100;
        if (this.fDP != null && this.jPQ != null) {
            this.jPQ.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dkg().OF(this.mVideoUrl);
            if (this.lsd) {
                this.fDP.setVolume(1.0f, 1.0f);
                this.fDP.start();
                this.lsd = false;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ZA);
                com.baidu.adp.lib.f.e.mS().postDelayed(this.ZA, 20L);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQA);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsk);
                if (this.fDP.dkn()) {
                    this.currentState = 1;
                    djM();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dkg().OF(this.mVideoUrl);
                this.jPQ.setPlayer(this.fDP);
                if (this.mStartPosition != 0) {
                    this.lrX = true;
                }
                if (!this.lsc) {
                    this.jPQ.showProgress();
                }
                if (!this.lrG && this.fDP.getDuration() <= 0) {
                    cMN().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.fDP.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.Zv = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU() {
        if (this.akQ.getVisibility() != 8 || !this.Zu) {
            this.Zu = true;
            this.jPR.setVisibility(8);
            this.hmp.setVisibility(8);
            this.fcf.dkc();
            this.akQ.setVisibility(8);
            djN();
            this.jPQ.showProgress();
            this.lrw.setVisibility(0);
            if (this.jQb != null) {
                this.jQb.onPrepared();
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

    protected void uV(boolean z) {
        if (hasNavBar(this.mActivity) && (this.lrx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lrx.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.lrx.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.lrx.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.lrx.setLayoutParams(layoutParams);
        }
    }

    public void ddy() {
        if (this.fDP.isPlaying()) {
            aHX();
            if (this.lrU != null) {
                this.lrU.onPause();
            }
            if (this.lrL != null) {
                this.lrL.onPaused();
            }
        } else if (this.Zu) {
            aHY();
            if (this.kVm != null) {
                this.kVm.coQ();
            }
            if (this.lrL != null) {
                this.lrL.djS();
            }
        } else {
            djF();
        }
    }

    public void Oh() {
        this.jQx = true;
        if (this.jQs != null) {
            this.jQs.Oh();
        }
    }

    public boolean djx() {
        return this.fDP != null && this.fDP.getView().getHeight() > this.fDP.getView().getWidth();
    }

    public void djy() {
        uV(false);
        djA();
    }

    public boolean FD(int i2) {
        switch (i2) {
            case 4:
                if (this.ZF) {
                    if (djx()) {
                        uV(false);
                        djA();
                    } else {
                        Oh();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.jQo <= 0 || this.jQl == null) {
                    return false;
                }
                this.jQu = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jQu * 100.0d) / this.jQo);
                this.jQl.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.fDP;
    }

    public VideoListMediaControllerView cMN() {
        return this.jPQ;
    }

    public void show() {
        this.jPO.setVisibility(0);
    }

    public void cMR() {
        if (this.jPZ != null) {
            ViewGroup.LayoutParams layoutParams = this.jPZ.getLayoutParams();
            this.jPT = (FrameLayout.LayoutParams) this.jPO.getLayoutParams();
            this.jPT.width = layoutParams.width;
            this.jPT.height = layoutParams.height;
            this.jPT.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.jPO.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.jPO.setLayoutParams(this.jPT);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jQx) {
            if (this.ZF) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.jQx = false;
        }
        if (configuration.orientation == 2) {
            djz();
        } else {
            djA();
        }
        djB();
        if (this.mActivity == com.baidu.adp.base.a.lb().currentActivity()) {
            aHY();
        }
        djO();
        cMZ();
        if (this.lrQ != null) {
            this.lrQ.pn(true);
        }
    }

    protected void djz() {
        this.ZF = true;
        if (djx()) {
            this.jPO.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.jPO.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        j(this.mActivity, true);
        this.bpF.setVisibility(0);
        this.jQd.setVisibility(0);
        this.jQe.setVisibility(0);
        this.jPS.setVisibility(8);
        this.fcf.dkd();
        this.akQ.setVisibility(8);
        this.jPW.setImageResource(R.drawable.icon_video_narrow_white);
        Ct(this.jQt);
        cMM();
        if (this.lrI != null) {
            this.lrI.rD();
        }
    }

    protected void djA() {
        this.ZF = false;
        if (this.jPT != null) {
            this.jPO.setLayoutParams(this.jPT);
        }
        j(this.mActivity, false);
        this.bpF.setVisibility(8);
        this.jPS.setVisibility(0);
        this.fcf.dkd();
        this.akQ.setVisibility(8);
        this.jPW.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.jPQ != null && (this.jPQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPQ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.jPQ.setLayoutParams(layoutParams);
        }
        this.jPO.setSystemUiVisibility(0);
        djw();
        if (this.lrI != null) {
            this.lrI.rE();
        }
    }

    public void djB() {
        if (this.fDP != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.ZF) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.lrw.setMax(equipmentWidth);
            int duration = this.fDP.getDuration();
            if (duration > 0) {
                if (this.lrz.getVisibility() == 0) {
                    this.lrw.setProgress(this.lrw.getMax());
                } else {
                    this.lrw.setProgress((int) ((this.fDP.getCurrentPositionSync() * this.lrw.getMax()) / duration));
                }
            }
        }
    }

    private void Ct(int i2) {
        if (this.jPQ != null && (this.jPQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPQ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.jPQ.setLayoutParams(layoutParams);
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

    public boolean cMT() {
        return !this.ZF;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.jQb = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lrD = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lrE = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.lrY) {
            fy(str, str2);
        } else {
            fx(str, str2);
        }
        if (eVar != null) {
            eVar.vd(z);
        }
    }

    public void fw(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, boolean z) {
        djG();
        this.lsd = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.fDP.setVideoDuration(this.lrC);
        this.fDP.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQA);
        if (this.lrK > 0) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.jQA, this.lrK);
        }
        if (this.lrL != null) {
            this.lrL.onStarted();
        }
        this.fcf.startLoading();
        uW(z);
    }

    public void fx(String str, String str2) {
        A(str, str2, true);
    }

    public void fy(String str, String str2) {
        djG();
        this.lsd = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQA);
        if (this.lrK > 0) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.jQA, this.lrK);
        }
        if (this.lrL != null) {
            this.lrL.onStarted();
        }
        this.fcf.startLoading();
        uW(true);
    }

    public void djC() {
        aHY();
        this.lrw.setVisibility(0);
    }

    public void aHY() {
        int i2 = 100;
        if (this.fDP != null && this.jPQ != null) {
            this.Zu = true;
            this.currentState = 1;
            this.fDP.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dkg().OF(this.mVideoUrl);
            this.lrX = true;
            if (this.mStartPosition > 100 && this.fDP.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.Zv = i2;
            this.fcf.dkd();
            uW(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lsb && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.ala)) {
            this.lsb = false;
            this.lsc = true;
            fx(this.mVideoUrl, this.ala);
        }
    }

    private void uW(boolean z) {
        if (z) {
            this.akQ.setVisibility(0);
            djM();
            this.lrw.setProgress(0);
        } else {
            this.akQ.setVisibility(8);
            djM();
        }
        this.jPQ.showProgress();
        this.jPR.setVisibility(8);
        this.lrA.setVisibility(8);
        this.lrz.setVisibility(8);
        this.lrB.setVisibility(8);
        this.hmp.setVisibility(8);
    }

    private void djD() {
        this.fcf.dkd();
        this.lrA.setVisibility(8);
        this.lrz.setVisibility(8);
        this.lrB.setVisibility(8);
        djO();
    }

    public void aHX() {
        this.fDP.pause();
        this.currentState = 2;
        djD();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ZA);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQA);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsk);
        this.fDP.stopPlayback();
        this.Zu = false;
        this.lsd = false;
        this.mStartPosition = 0;
        czv();
    }

    public void djE() {
        if (this.fDP.getDuration() >= this.fDP.getCurrentPosition()) {
            com.baidu.tieba.play.n.dkg().by(this.mVideoUrl, this.fDP.getCurrentPositionSync());
        }
    }

    public void uX(boolean z) {
        this.lrW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(boolean z) {
        if (this.jPX != null) {
            this.jPR.setVisibility(0);
            this.lrA.setVisibility(8);
            this.lrz.setVisibility(8);
            this.lrB.setVisibility(8);
            this.fcf.dkd();
            djM();
            this.lrw.setVisibility(8);
            this.hmp.setVisibility(8);
            this.jPQ.aIm();
            this.akQ.setVisibility(z ? 0 : 8);
        }
    }

    public void czv() {
        uY(true);
    }

    public boolean rF() {
        if (this.fDP == null) {
            return false;
        }
        return this.fDP.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fDP == null) {
            return 0;
        }
        return this.fDP.getCurrentPosition();
    }

    public void a(k kVar) {
        this.lrO = kVar;
    }

    public void a(j jVar) {
        this.lrN = jVar;
    }

    public void a(i iVar) {
        this.kVm = iVar;
    }

    public void a(g gVar) {
        this.lrU = gVar;
    }

    public void a(h hVar) {
        this.lrM = hVar;
    }

    public void Oe(String str) {
        this.kUM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djF() {
        a(this.mVideoUrl, this.ala, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.lrJ = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        djG();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dBe().dBf()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.lrY = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.lrT != null) {
                    this.lrT.oH(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.zA(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.djH();
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
                aVar.b(this.efr).bhg();
                return;
            } else if (this.lrT != null) {
                this.lrT.oH(true);
                return;
            } else {
                if (!this.lrv) {
                    this.lrv = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.lrS != null) {
            this.lrS.coN();
        }
    }

    private void djG() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dBe().fI(this.mActivity);
        }
    }

    public void djH() {
        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.akQ.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQE);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ZA);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQA);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsj);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsk);
        this.jQs.stop();
        jQw.unregister(this.mActivity);
    }

    public void OE(String str) {
        this.jQe.setText(str);
    }

    public boolean cMV() {
        return this.Zu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djI() {
        if (this.jPX != null) {
            if (this.lrF) {
                djM();
            } else {
                djL();
            }
        }
    }

    public void cMZ() {
        djL();
        djJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djJ() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQE);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.jQE, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djK() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQE);
    }

    public void djL() {
        if (this.jPX != null && !this.lrF && !this.lsh) {
            uZ(true);
            cMY();
            this.jPX.setVisibility(0);
            this.lrx.setVisibility(0);
            this.lrw.setVisibility(8);
            this.lrF = true;
            if (this.lrJ != null) {
                this.lrJ.oI(false);
            }
        }
    }

    public void cMW() {
        if (this.jPX != null && this.lrF) {
            uZ(false);
            cMY();
            this.jPX.setVisibility(8);
            this.lrx.setVisibility(8);
            this.lrw.setVisibility(0);
            this.iak.setAnimationListener(this.jQC);
            this.jPX.startAnimation(this.iak);
            this.lrF = false;
            if (this.lrJ != null) {
                this.lrJ.coP();
            }
        }
    }

    public void djM() {
        if (this.jPX != null && this.lrF) {
            this.bAh.cancel();
            this.iak.cancel();
            uZ(false);
            cMY();
            this.jPX.setVisibility(8);
            this.lrx.setVisibility(8);
            this.lrw.setVisibility(0);
            this.lrF = false;
            if (this.lrJ != null) {
                this.lrJ.coP();
            }
        }
    }

    private void cMY() {
        if (this.jPX != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQE);
            this.bAh.setAnimationListener(null);
            this.iak.setAnimationListener(null);
            this.jPX.clearAnimation();
        }
    }

    private void djN() {
        if (this.jPX != null) {
            this.bAh.setAnimationListener(null);
            this.iak.setAnimationListener(null);
            this.jPX.clearAnimation();
        }
    }

    public void uZ(boolean z) {
        djO();
        if (z) {
            this.lry.setVisibility(0);
        } else {
            this.lry.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djO() {
        if (this.currentState == 1) {
            this.lry.setState(1);
        } else {
            this.lry.setState(0);
        }
    }

    public void a(InterfaceC0782c interfaceC0782c) {
        this.lrI = interfaceC0782c;
    }

    public void Cw(int i2) {
        this.mStartPosition = i2;
    }

    public void au(boolean z, boolean z2) {
        if (this.jQs != null) {
            if (this.jPW != null) {
                this.jPW.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.jPQ != null && (this.jPQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPQ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.jPQ.setLayoutParams(layoutParams);
            }
            this.jQs.ct(z);
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

    public void va(boolean z) {
        this.lsg = z;
    }

    public void a(m mVar) {
        this.lrP = mVar;
    }

    public void a(a aVar) {
        this.lrQ = aVar;
    }

    public void a(n nVar) {
        this.lrR = nVar;
    }

    public void a(l lVar) {
        this.lrS = lVar;
    }

    public void a(f fVar) {
        this.lrT = fVar;
    }

    public void vb(boolean z) {
        this.lsa = z;
    }

    public void vc(boolean z) {
        this.lrG = z;
    }

    public void FE(int i2) {
        this.lse = i2;
    }

    public View djP() {
        return this.jPO;
    }

    public void a(p pVar) {
        this.kVa = pVar;
    }

    public void djQ() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.efr.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.efr.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.fDP != null) {
            this.fDP.setStageType(str);
        }
    }
}
