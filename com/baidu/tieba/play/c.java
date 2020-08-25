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
/* loaded from: classes2.dex */
public class c {
    private static int jQp;
    private static CallStateReceiver jQq;
    private TbImageView akO;
    private String akY;
    private Animation bAe;
    private View bpC;
    private String eVt;
    private TbPageContext<?> efn;
    protected TbCyberVideoView fDL;
    private com.baidu.tieba.play.m fcb;
    protected View hml;
    private Animation iae;
    public View jPI;
    private VideoListMediaControllerView jPK;
    private View jPL;
    private FrameLayout jPM;
    protected FrameLayout.LayoutParams jPN;
    private ImageView jPQ;
    private View jPR;
    private View jPT;
    private CyberPlayerManager.OnPreparedListener jPV;
    private ImageView jPX;
    private TextView jPY;
    private View jQc;
    private View jQd;
    private TextView jQe;
    private SeekBar jQf;
    private ImageView jQg;
    private ImageView jQh;
    private int jQi;
    private com.baidu.tieba.play.j jQm;
    private int jQo;
    private p kUT;
    private i kVf;
    private o lrA;
    private h lrB;
    private j lrC;
    private k lrD;
    private m lrE;
    private a lrF;
    private n lrG;
    private l lrH;
    private f lrI;
    private g lrJ;
    private TextView lrO;
    private boolean lrQ;
    private boolean lrR;
    private boolean lrS;
    private int lrT;
    private boolean lrU;
    private boolean lrV;
    private ProgressBar lrl;
    private View lrm;
    private SwitchImageView lrn;
    private TextView lro;
    private TextView lrp;
    private TextView lrq;
    private int lrr;
    private CyberPlayerManager.OnCompletionListener lrs;
    private CyberPlayerManager.OnErrorListener lrt;
    private View.OnClickListener lrw;
    protected InterfaceC0782c lrx;
    private d lry;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int Zt = 100;
    private boolean lrk = false;
    protected boolean ZD = false;
    private boolean Zs = false;
    private boolean lru = false;
    private boolean lrv = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int jQj = 0;
    private int jQk = 0;
    private long lrz = 60000;
    private int jQn = 0;
    private boolean jQr = false;
    private boolean lrK = true;
    private boolean lrL = true;
    private boolean lrM = false;
    private boolean lrN = false;
    private String kUF = null;
    private int currentState = -1;
    private boolean lrP = false;
    private boolean lrW = false;
    private boolean lrX = false;
    private CyberPlayerManager.OnPreparedListener dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.jPK != null && c.this.fDL != null && c.this.fDL.getDuration() > 0) {
                c.this.jPK.bz(0, c.this.fDL.getDuration());
            }
            c.this.cbE();
            if (c.this.lrA != null) {
                c.this.lrA.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener dLK = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rU();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a hjx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.cbE();
        }
    };
    private Runnable Zy = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(c.this.Zy);
            if (c.this.akO.getVisibility() != 8) {
                if (c.this.fDL.getCurrentPosition() > c.this.Zt) {
                    c.this.rU();
                } else {
                    com.baidu.adp.lib.f.e.mS().postDelayed(c.this.Zy, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.fDL != null) {
                int duration = c.this.fDL.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.Zs = false;
                    c.this.lrS = false;
                    c.this.mStartPosition = 0;
                    c.this.cMI();
                    c.this.jPL.setVisibility(0);
                    c.this.lrl.setProgress(c.this.lrl.getMax());
                    c.this.Zt = 100;
                    if (c.this.lrs != null) {
                        c.this.lrs.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.uW(false);
                        c.this.uX(true);
                    } else {
                        c.this.djJ();
                        c.this.lro.setVisibility(0);
                    }
                    if (!c.this.ZD && duration <= 150000) {
                        if (!c.this.lrP) {
                            if (c.this.lrC != null) {
                                c.this.lrC.ua(true);
                            }
                            c.this.A(c.this.mVideoUrl, c.this.akY, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.fDL.pause();
                            c.this.fDL.seekTo(0);
                        }
                    }
                    if (c.this.lrA != null) {
                        c.this.lrA.FF(c.this.lrl.getMax());
                        c.this.lrA.Gp();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener jQt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.hml.setVisibility(0);
            c.this.fcb.dka();
            c.this.currentState = 4;
            if (c.this.lrt != null) {
                c.this.lrt.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.lrQ = true;
            }
            if (c.this.lrA != null) {
                c.this.lrA.djO();
            }
            c.this.lrS = false;
            return true;
        }
    };
    protected Runnable jQu = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fDL == null || !c.this.fDL.isPlaying()) {
                c.this.hml.setVisibility(0);
                c.this.fcb.dka();
                if (c.this.lrA != null) {
                    c.this.lrA.djO();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener dLM = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.lrM) {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.lrY, 200L);
            }
        }
    };
    private Runnable lrY = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fDL == null || !c.this.lrM) {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.Zy, 200L);
                c.this.lrM = false;
            } else if (c.this.mStartPosition != c.this.fDL.getCurrentPosition()) {
                c.this.lrM = false;
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.Zy, 20L);
            } else {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.lrY, 200L);
            }
        }
    };
    private TbCyberVideoView.a fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.Zs = false;
            if (c.this.lrv) {
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.lrZ, 300L);
            }
            com.baidu.adp.lib.f.e.mS().removeCallbacks(c.this.Zy);
            com.baidu.adp.lib.f.e.mS().removeCallbacks(c.this.jQu);
        }
    };
    private Runnable lrZ = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lrS = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.kUT != null) {
                c.this.kUT.ddE();
            }
            if (view.getId() != c.this.hml.getId()) {
                if (view.getId() != c.this.lrn.getId()) {
                    if (view.getId() == c.this.lrp.getId()) {
                        if (c.this.lrB != null) {
                            c.this.lrB.ddF();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.lro.getId()) {
                        if (c.this.lrC != null) {
                            c.this.lrC.ua(false);
                        }
                        c.this.fw(c.this.mVideoUrl, c.this.akY);
                        return;
                    } else if (view.getId() == c.this.jPQ.getId()) {
                        int i2 = c.this.lrv ? 1 : 2;
                        if (c.this.ZD) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dD("tid", c.this.akY).dD("fid", c.this.eVt).ai("obj_type", i2).ai("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dD("tid", c.this.akY).dD("fid", c.this.eVt).ai("obj_type", i2).ai("obj_source", 1));
                        }
                        if (c.this.lrH != null) {
                            c.this.lrH.coN();
                        }
                        if (c.this.dju()) {
                            if (c.this.ZD) {
                                c.this.djx();
                            } else {
                                c.this.djw();
                            }
                            c.this.uT(c.this.ZD);
                            return;
                        }
                        c.this.Oh();
                        return;
                    } else if (view.getId() != c.this.jPX.getId()) {
                        if (c.this.lrw != null) {
                            c.this.lrw.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.lrH != null) {
                            c.this.lrH.coN();
                        }
                        if (c.this.dju()) {
                            c.this.djx();
                            c.this.uT(false);
                            return;
                        }
                        c.this.Oh();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.ddx();
                c.this.djL();
                if (c.this.currentState != 1) {
                    c.this.djH();
                    c.this.djI();
                } else {
                    c.this.cMY();
                }
                if (c.this.lrF != null) {
                    c.this.lrF.pl(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.fDL.stopPlayback();
            c.this.Zs = false;
            c.this.djC();
        }
    };
    private Animation.AnimationListener jQw = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener jQx = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable jQy = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cMV();
        }
    };
    private CustomMessageListener jQz = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aHX();
            }
        }
    };
    private VideoControllerView.b jSt = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void se(int i2) {
            int duration;
            if (c.this.fDL != null && (duration = c.this.fDL.getDuration()) > 0 && c.this.lrl != null) {
                c.this.lrl.setProgress((int) ((i2 * c.this.jPI.getWidth()) / duration));
                if (c.this.lrA != null) {
                    c.this.lrA.FF((c.this.fDL.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fpk = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.djH();
            c.this.uX(false);
            if (c.this.lrF != null) {
                c.this.lrF.pl(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cMM() != null) {
                c.this.Cw(c.this.cMM().getSeekPosition());
                if (!c.this.cMU()) {
                    c.this.djC();
                } else {
                    c.this.aHY();
                    if (c.this.kVf != null) {
                        c.this.kVf.coP();
                    }
                }
            }
            c.this.uX(true);
            c.this.djG();
            if (c.this.lrF != null) {
                c.this.lrF.pl(true);
            }
            if (c.this.lrG != null) {
                c.this.lrG.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void pl(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0782c {
        void rD();

        void rE();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void coO();

        void oG(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void vb(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void oF(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes2.dex */
    public interface h {
        void ddF();
    }

    /* loaded from: classes2.dex */
    public interface i {
        void coP();
    }

    /* loaded from: classes2.dex */
    public interface j {
        void ua(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface l {
        void coM();

        void coN();
    }

    /* loaded from: classes2.dex */
    public interface m {
        boolean ddG();

        boolean ddH();
    }

    /* loaded from: classes2.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes2.dex */
    public interface o {
        void FF(int i);

        void Gp();

        void djO();

        void djP();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes2.dex */
    public interface p {
        void ddE();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.lrU = true;
        if (tbPageContext != null) {
            this.efn = tbPageContext;
            this.mRootView = view;
            this.lrU = z;
            this.jPT = view;
            this.mActivity = this.efn.getPageActivity();
            init();
        }
    }

    public void init() {
        this.jPI = ar(this.mActivity);
        this.jPI.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.jPI);
        }
        this.fDL = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.jPI).addView(this.fDL.getView(), 0);
        this.fDL.getView().setLayoutParams(layoutParams);
        this.fcb = new com.baidu.tieba.play.m((ViewGroup) this.jPI.findViewById(R.id.auto_video_loading_container));
        this.fcb.setLoadingAnimationListener(this.hjx);
        this.jPK = (VideoListMediaControllerView) this.jPI.findViewById(R.id.media_controller);
        this.jPK.setPlayer(this.fDL);
        this.lrl = (ProgressBar) this.jPI.findViewById(R.id.pgrBottomProgress);
        this.lrl.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.lrl.setProgress(0);
        this.jPK.setOnSeekBarChangeListener(this.fpk);
        this.jPK.setOnProgressUpdatedListener(this.jSt);
        this.jPL = this.jPI.findViewById(R.id.black_mask);
        this.hml = this.jPI.findViewById(R.id.layout_error);
        this.hml.setOnClickListener(this.mOnClickListener);
        this.lrO = (TextView) this.jPI.findViewById(R.id.auto_video_error_tips);
        this.jPM = (FrameLayout) this.jPI.findViewById(R.id.danmu_container);
        this.jPQ = (ImageView) this.jPI.findViewById(R.id.img_full_screen);
        this.jPQ.setOnClickListener(this.mOnClickListener);
        this.jPR = this.jPI.findViewById(R.id.layout_media_controller);
        this.lrm = this.jPI.findViewById(R.id.time_show_controller);
        this.fDL.setContinuePlayEnable(true);
        this.fDL.setOnPreparedListener(this.dLH);
        this.fDL.setOnCompletionListener(this.dLJ);
        this.fDL.setOnErrorListener(this.jQt);
        this.fDL.setOnSeekCompleteListener(this.dLM);
        this.fDL.setOnInfoListener(this.dLK);
        this.fDL.setOnSurfaceDestroyedListener(this.fcj);
        this.lrn = (SwitchImageView) this.jPI.findViewById(R.id.img_play_controller);
        this.lrn.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.lrn.setState(0);
        this.lrn.setOnClickListener(this.mOnClickListener);
        this.lro = (TextView) this.jPI.findViewById(R.id.txt_replay);
        this.lro.setOnClickListener(this.mOnClickListener);
        this.lrp = (TextView) this.jPI.findViewById(R.id.txt_playnext);
        this.lrp.setOnClickListener(this.mOnClickListener);
        this.lrq = (TextView) this.jPI.findViewById(R.id.txt_next_video_title);
        this.akO = (TbImageView) this.jPI.findViewById(R.id.video_thumbnail);
        this.akO.setDefaultErrorResource(0);
        this.akO.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jPX = (ImageView) this.jPI.findViewById(R.id.img_exit);
        this.jPX.setOnClickListener(this.mOnClickListener);
        this.jPY = (TextView) this.jPI.findViewById(R.id.video_title);
        this.bpC = this.jPI.findViewById(R.id.layout_title);
        this.bpC.setVisibility(8);
        this.iae = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bAe = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jQi = this.mAudioManager.getStreamMaxVolume(3);
        this.jQo = this.mAudioManager.getStreamVolume(3);
        jQp = 100 / this.jQi;
        this.jPI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.lrD != null) {
                    c.this.lrD.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Zs) {
                        if (c.this.mStatus == 1 && c.this.jQk != 0) {
                            c.this.b(c.this.jQk == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jQk = 0;
                            c.this.jQj = 0;
                        }
                        if (!c.this.fDL.isPlaying()) {
                            c.this.lrp.setVisibility(8);
                            c.this.lro.setVisibility(8);
                            c.this.lrq.setVisibility(8);
                        }
                    }
                    c.this.cMI();
                    if (c.this.lrD != null) {
                        c.this.lrD.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jQm = new com.baidu.tieba.play.j(this.mActivity);
        if (this.lrU) {
            this.jQm.start();
        }
        this.jQn = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jQq == null) {
            jQq = new CallStateReceiver();
        }
        jQq.register(this.mActivity);
        djt();
        MessageManager.getInstance().registerListener(this.jQz);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jQz);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void FB(int i2) {
        if (this.akO != null) {
            this.akO.setDefaultBgResource(i2);
        }
    }

    public void djt() {
        if (this.lrK) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.jPI.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.jPI.setSystemUiVisibility(0);
    }

    public void uR(boolean z) {
        this.lrK = z;
        djt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMI() {
        this.mStatus = 0;
        if (this.jQc != null && this.jQc.getParent() != null && (this.jQc.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jQc.getParent()).removeView(this.jQc);
                this.jQc = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jQd != null && this.jQd.getParent() != null && (this.jQd.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jQd.getParent()).removeView(this.jQd);
                this.jQd = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cMJ() {
        if (this.mStatus == 1) {
            if (this.jQc == null && this.jPI != null && (this.jPI instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.jPI, true);
                this.jQc = this.jPI.findViewById(R.id.lay_jindu);
                this.jQe = (TextView) this.jQc.findViewById(R.id.show_time);
                this.jQh = (ImageView) this.jQc.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jQd == null && this.jPI != null && (this.jPI instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.jPI, true);
            this.jQd = this.jPI.findViewById(R.id.lay_voice);
            this.jQg = (ImageView) this.jQd.findViewById(R.id.arrow_voice_icon);
            this.jQf = (SeekBar) this.jQd.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.lrw = onClickListener;
    }

    public void uS(boolean z) {
        this.lrv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.lrD != null) {
                c.this.lrD.onStart();
            }
            if (c.this.ZD && c.this.Zs) {
                if (c.this.mStatus == 1) {
                    c.this.djJ();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.au(f2);
                    }
                } else {
                    if (c.this.ZD) {
                        c.this.cML();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.jQj = c.this.fDL.getCurrentPosition();
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
            if (!c.this.lrV) {
                if (c.this.lrE != null && c.this.lrE.ddG()) {
                    return true;
                }
                c.this.ddx();
                c.this.djL();
                if (c.this.fDL.isPlaying()) {
                    c.this.djG();
                } else {
                    c.this.djH();
                }
                if (c.this.lrF != null) {
                    c.this.lrF.pl(c.this.fDL.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.lrV) {
                if (c.this.Zs) {
                    if (c.this.lrE != null && c.this.lrE.ddH()) {
                        return true;
                    }
                    c.this.djF();
                    if (c.this.fDL.isPlaying()) {
                        c.this.djG();
                    } else {
                        c.this.djH();
                    }
                    if (c.this.lrF != null) {
                        c.this.lrF.pl(c.this.fDL.isPlaying());
                    }
                } else {
                    c.this.ddx();
                    c.this.djL();
                    if (c.this.currentState != 1) {
                        c.this.djH();
                        c.this.djI();
                    } else {
                        c.this.cMY();
                    }
                    if (c.this.lrF != null) {
                        c.this.lrF.pl(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cML() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jPI.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jPI.setSystemUiVisibility(4);
        } else {
            this.jPI.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.Zs) {
            this.mStatus = 0;
            return;
        }
        if (jQp == 0) {
            this.jQi = this.mAudioManager.getStreamMaxVolume(3);
            jQp = 100 / this.jQi;
            if (jQp == 0) {
                jQp = 1;
            }
        }
        cMJ();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % jQp == 0) {
            if (f2 > 0.0f && this.jQo < this.jQi) {
                this.jQo++;
            }
            if (f2 < 0.0f && this.jQo > 0) {
                this.jQo--;
            }
        }
        if (this.mProgress > 0) {
            this.jQg.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jQg.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jQo, 0);
        this.jQf.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jQj -= 1000;
                this.jQk = 1;
            } else {
                this.jQj += 1000;
                this.jQk = 2;
            }
            if (this.jQj < 0) {
                this.jQj = 0;
            } else if (this.jQj > this.fDL.getDuration()) {
                this.jQj = this.fDL.getDuration();
            }
        }
        cMJ();
        String FJ = this.jPK.FJ(this.jQj);
        if (f2 > 0.0f) {
            this.jQh.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jQh.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(FJ)) {
            this.jQe.setText(new StringBuilder().append(FJ).append("/").append(this.jPK.FJ(this.fDL.getDuration())));
        }
        this.jPK.setCurrentDuration(this.jQj, z ? false : true);
        djJ();
        djy();
    }

    protected View ar(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void FC(int i2) {
        this.lrr = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.akY = str2;
    }

    public void setFid(String str) {
        this.eVt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        int i2 = 100;
        if (this.fDL != null && this.jPK != null) {
            this.jPK.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dkd().OE(this.mVideoUrl);
            if (this.lrS) {
                this.fDL.setVolume(1.0f, 1.0f);
                this.fDL.start();
                this.lrS = false;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.Zy);
                com.baidu.adp.lib.f.e.mS().postDelayed(this.Zy, 20L);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQu);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lrZ);
                if (this.fDL.dkk()) {
                    this.currentState = 1;
                    djJ();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dkd().OE(this.mVideoUrl);
                this.jPK.setPlayer(this.fDL);
                if (this.mStartPosition != 0) {
                    this.lrM = true;
                }
                if (!this.lrR) {
                    this.jPK.showProgress();
                }
                if (!this.lrv && this.fDL.getDuration() <= 0) {
                    cMM().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.fDL.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.Zt = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU() {
        if (this.akO.getVisibility() != 8 || !this.Zs) {
            this.Zs = true;
            this.jPL.setVisibility(8);
            this.hml.setVisibility(8);
            this.fcb.djZ();
            this.akO.setVisibility(8);
            djK();
            this.jPK.showProgress();
            this.lrl.setVisibility(0);
            if (this.jPV != null) {
                this.jPV.onPrepared();
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

    protected void uT(boolean z) {
        if (hasNavBar(this.mActivity) && (this.lrm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lrm.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.lrm.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.lrm.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.lrm.setLayoutParams(layoutParams);
        }
    }

    public void ddx() {
        if (this.fDL.isPlaying()) {
            aHX();
            if (this.lrJ != null) {
                this.lrJ.onPause();
            }
            if (this.lrA != null) {
                this.lrA.onPaused();
            }
        } else if (this.Zs) {
            aHY();
            if (this.kVf != null) {
                this.kVf.coP();
            }
            if (this.lrA != null) {
                this.lrA.djP();
            }
        } else {
            djC();
        }
    }

    public void Oh() {
        this.jQr = true;
        if (this.jQm != null) {
            this.jQm.Oh();
        }
    }

    public boolean dju() {
        return this.fDL != null && this.fDL.getView().getHeight() > this.fDL.getView().getWidth();
    }

    public void djv() {
        uT(false);
        djx();
    }

    public boolean FD(int i2) {
        switch (i2) {
            case 4:
                if (this.ZD) {
                    if (dju()) {
                        uT(false);
                        djx();
                    } else {
                        Oh();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.jQi <= 0 || this.jQf == null) {
                    return false;
                }
                this.jQo = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jQo * 100.0d) / this.jQi);
                this.jQf.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.fDL;
    }

    public VideoListMediaControllerView cMM() {
        return this.jPK;
    }

    public void show() {
        this.jPI.setVisibility(0);
    }

    public void cMQ() {
        if (this.jPT != null) {
            ViewGroup.LayoutParams layoutParams = this.jPT.getLayoutParams();
            this.jPN = (FrameLayout.LayoutParams) this.jPI.getLayoutParams();
            this.jPN.width = layoutParams.width;
            this.jPN.height = layoutParams.height;
            this.jPN.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.jPI.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.jPI.setLayoutParams(this.jPN);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jQr) {
            if (this.ZD) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.jQr = false;
        }
        if (configuration.orientation == 2) {
            djw();
        } else {
            djx();
        }
        djy();
        if (this.mActivity == com.baidu.adp.base.a.lb().currentActivity()) {
            aHY();
        }
        djL();
        cMY();
        if (this.lrF != null) {
            this.lrF.pl(true);
        }
    }

    protected void djw() {
        this.ZD = true;
        if (dju()) {
            this.jPI.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.jPI.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        j(this.mActivity, true);
        this.bpC.setVisibility(0);
        this.jPX.setVisibility(0);
        this.jPY.setVisibility(0);
        this.jPM.setVisibility(8);
        this.fcb.dka();
        this.akO.setVisibility(8);
        this.jPQ.setImageResource(R.drawable.icon_video_narrow_white);
        Ct(this.jQn);
        cML();
        if (this.lrx != null) {
            this.lrx.rD();
        }
    }

    protected void djx() {
        this.ZD = false;
        if (this.jPN != null) {
            this.jPI.setLayoutParams(this.jPN);
        }
        j(this.mActivity, false);
        this.bpC.setVisibility(8);
        this.jPM.setVisibility(0);
        this.fcb.dka();
        this.akO.setVisibility(8);
        this.jPQ.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.jPK != null && (this.jPK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPK.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.jPK.setLayoutParams(layoutParams);
        }
        this.jPI.setSystemUiVisibility(0);
        djt();
        if (this.lrx != null) {
            this.lrx.rE();
        }
    }

    public void djy() {
        if (this.fDL != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.ZD) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.lrl.setMax(equipmentWidth);
            int duration = this.fDL.getDuration();
            if (duration > 0) {
                if (this.lro.getVisibility() == 0) {
                    this.lrl.setProgress(this.lrl.getMax());
                } else {
                    this.lrl.setProgress((int) ((this.fDL.getCurrentPositionSync() * this.lrl.getMax()) / duration));
                }
            }
        }
    }

    private void Ct(int i2) {
        if (this.jPK != null && (this.jPK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPK.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.jPK.setLayoutParams(layoutParams);
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

    public boolean cMS() {
        return !this.ZD;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.jPV = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lrs = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lrt = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.lrN) {
            fx(str, str2);
        } else {
            fw(str, str2);
        }
        if (eVar != null) {
            eVar.vb(z);
        }
    }

    public void fv(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, boolean z) {
        djD();
        this.lrS = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.fDL.setVideoDuration(this.lrr);
        this.fDL.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQu);
        if (this.lrz > 0) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.jQu, this.lrz);
        }
        if (this.lrA != null) {
            this.lrA.onStarted();
        }
        this.fcb.startLoading();
        uU(z);
    }

    public void fw(String str, String str2) {
        A(str, str2, true);
    }

    public void fx(String str, String str2) {
        djD();
        this.lrS = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQu);
        if (this.lrz > 0) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.jQu, this.lrz);
        }
        if (this.lrA != null) {
            this.lrA.onStarted();
        }
        this.fcb.startLoading();
        uU(true);
    }

    public void djz() {
        aHY();
        this.lrl.setVisibility(0);
    }

    public void aHY() {
        int i2 = 100;
        if (this.fDL != null && this.jPK != null) {
            this.Zs = true;
            this.currentState = 1;
            this.fDL.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dkd().OE(this.mVideoUrl);
            this.lrM = true;
            if (this.mStartPosition > 100 && this.fDL.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.Zt = i2;
            this.fcb.dka();
            uU(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lrQ && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.akY)) {
            this.lrQ = false;
            this.lrR = true;
            fw(this.mVideoUrl, this.akY);
        }
    }

    private void uU(boolean z) {
        if (z) {
            this.akO.setVisibility(0);
            djJ();
            this.lrl.setProgress(0);
        } else {
            this.akO.setVisibility(8);
            djJ();
        }
        this.jPK.showProgress();
        this.jPL.setVisibility(8);
        this.lrp.setVisibility(8);
        this.lro.setVisibility(8);
        this.lrq.setVisibility(8);
        this.hml.setVisibility(8);
    }

    private void djA() {
        this.fcb.dka();
        this.lrp.setVisibility(8);
        this.lro.setVisibility(8);
        this.lrq.setVisibility(8);
        djL();
    }

    public void aHX() {
        this.fDL.pause();
        this.currentState = 2;
        djA();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.Zy);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQu);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lrZ);
        this.fDL.stopPlayback();
        this.Zs = false;
        this.lrS = false;
        this.mStartPosition = 0;
        czu();
    }

    public void djB() {
        if (this.fDL.getDuration() >= this.fDL.getCurrentPosition()) {
            com.baidu.tieba.play.n.dkd().by(this.mVideoUrl, this.fDL.getCurrentPositionSync());
        }
    }

    public void uV(boolean z) {
        this.lrL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW(boolean z) {
        if (this.jPR != null) {
            this.jPL.setVisibility(0);
            this.lrp.setVisibility(8);
            this.lro.setVisibility(8);
            this.lrq.setVisibility(8);
            this.fcb.dka();
            djJ();
            this.lrl.setVisibility(8);
            this.hml.setVisibility(8);
            this.jPK.aIm();
            this.akO.setVisibility(z ? 0 : 8);
        }
    }

    public void czu() {
        uW(true);
    }

    public boolean rF() {
        if (this.fDL == null) {
            return false;
        }
        return this.fDL.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fDL == null) {
            return 0;
        }
        return this.fDL.getCurrentPosition();
    }

    public void a(k kVar) {
        this.lrD = kVar;
    }

    public void a(j jVar) {
        this.lrC = jVar;
    }

    public void a(i iVar) {
        this.kVf = iVar;
    }

    public void a(g gVar) {
        this.lrJ = gVar;
    }

    public void a(h hVar) {
        this.lrB = hVar;
    }

    public void Od(String str) {
        this.kUF = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djC() {
        a(this.mVideoUrl, this.akY, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.lry = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        djD();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dAV().dAW()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.lrN = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.lrI != null) {
                    this.lrI.oF(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.zz(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.djE();
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
                aVar.b(this.efn).bhg();
                return;
            } else if (this.lrI != null) {
                this.lrI.oF(true);
                return;
            } else {
                if (!this.lrk) {
                    this.lrk = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.lrH != null) {
            this.lrH.coM();
        }
    }

    private void djD() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dAV().fI(this.mActivity);
        }
    }

    public void djE() {
        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.akO.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQy);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.Zy);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQu);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lrY);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lrZ);
        this.jQm.stop();
        jQq.unregister(this.mActivity);
    }

    public void OD(String str) {
        this.jPY.setText(str);
    }

    public boolean cMU() {
        return this.Zs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djF() {
        if (this.jPR != null) {
            if (this.lru) {
                djJ();
            } else {
                djI();
            }
        }
    }

    public void cMY() {
        djI();
        djG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djG() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQy);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.jQy, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djH() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQy);
    }

    public void djI() {
        if (this.jPR != null && !this.lru && !this.lrW) {
            uX(true);
            cMX();
            this.jPR.setVisibility(0);
            this.lrm.setVisibility(0);
            this.lrl.setVisibility(8);
            this.lru = true;
            if (this.lry != null) {
                this.lry.oG(false);
            }
        }
    }

    public void cMV() {
        if (this.jPR != null && this.lru) {
            uX(false);
            cMX();
            this.jPR.setVisibility(8);
            this.lrm.setVisibility(8);
            this.lrl.setVisibility(0);
            this.iae.setAnimationListener(this.jQw);
            this.jPR.startAnimation(this.iae);
            this.lru = false;
            if (this.lry != null) {
                this.lry.coO();
            }
        }
    }

    public void djJ() {
        if (this.jPR != null && this.lru) {
            this.bAe.cancel();
            this.iae.cancel();
            uX(false);
            cMX();
            this.jPR.setVisibility(8);
            this.lrm.setVisibility(8);
            this.lrl.setVisibility(0);
            this.lru = false;
            if (this.lry != null) {
                this.lry.coO();
            }
        }
    }

    private void cMX() {
        if (this.jPR != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jQy);
            this.bAe.setAnimationListener(null);
            this.iae.setAnimationListener(null);
            this.jPR.clearAnimation();
        }
    }

    private void djK() {
        if (this.jPR != null) {
            this.bAe.setAnimationListener(null);
            this.iae.setAnimationListener(null);
            this.jPR.clearAnimation();
        }
    }

    public void uX(boolean z) {
        djL();
        if (z) {
            this.lrn.setVisibility(0);
        } else {
            this.lrn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djL() {
        if (this.currentState == 1) {
            this.lrn.setState(1);
        } else {
            this.lrn.setState(0);
        }
    }

    public void a(InterfaceC0782c interfaceC0782c) {
        this.lrx = interfaceC0782c;
    }

    public void Cw(int i2) {
        this.mStartPosition = i2;
    }

    public void au(boolean z, boolean z2) {
        if (this.jQm != null) {
            if (this.jPQ != null) {
                this.jPQ.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.jPK != null && (this.jPK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPK.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.jPK.setLayoutParams(layoutParams);
            }
            this.jQm.cs(z);
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

    public void uY(boolean z) {
        this.lrV = z;
    }

    public void a(m mVar) {
        this.lrE = mVar;
    }

    public void a(a aVar) {
        this.lrF = aVar;
    }

    public void a(n nVar) {
        this.lrG = nVar;
    }

    public void a(l lVar) {
        this.lrH = lVar;
    }

    public void a(f fVar) {
        this.lrI = fVar;
    }

    public void uZ(boolean z) {
        this.lrP = z;
    }

    public void va(boolean z) {
        this.lrv = z;
    }

    public void FE(int i2) {
        this.lrT = i2;
    }

    public View djM() {
        return this.jPI;
    }

    public void a(p pVar) {
        this.kUT = pVar;
    }

    public void djN() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.efn.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.efn.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.fDL != null) {
            this.fDL.setStageType(str);
        }
    }
}
